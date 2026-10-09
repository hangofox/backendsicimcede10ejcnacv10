//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EmailDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.EmailService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ParametrosSistema;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RecuperacionContrasenaAccesoUsuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Usuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ParametrosSistemaRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.RecuperacionContrasenaAccesoUsuarioRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UsuarioRepository;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Mismo patrón del backend SIGEPS: el cliente solo envía el id del usuario y el medio de envío;
* el destinatario, el número de documento, el código de activación, la plantilla y el SMTP se
* resuelven aquí, en la base de datos.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class EmailServiceImpl implements EmailService {
    
    //ENVIAR CORREO ELECTRÓNICO:
    
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);//DECLARACIÓN DE VARIABLES DE LOG.
    
    //ÚNICO REGISTRO DE PARÁMETROS DEL SISTEMA (SMTP, PLANTILLAS, ETC.):
    private static final Long ID_PARAMETROS_SISTEMA = 1L;
    
    //MARCADORES DE LA PLANTILLA DE CORREO ALMACENADA EN parametrosSistema.cuerpoMensajeHtmlRecuperacionContrasena:
    private static final String MARCADOR_NUMERO_DOCUMENTO = "*[NUMDOCIDSICIM]*";
    private static final String MARCADOR_CODIGO_ACTIVACION = "*[CODACTIVAUSICIM]*";
    
    @Autowired//INYECTAMOS EL REPOSITORIO PARA CONSULTAR LA CONFIGURACIÓN SMTP Y LA PLANTILLA INTERNAMENTE (NUNCA DESDE EL CLIENTE).
    private ParametrosSistemaRepository parametrosSistemaRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO DE USUARIOS (PARA RESOLVER EL CORREO DE DESTINO Y EL NÚMERO DE DOCUMENTO INTERNAMENTE, NUNCA DESDE EL CLIENTE).
    private UsuarioRepository usuarioRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO DE RECUPERACIONES (PARA RESOLVER EL CÓDIGO DE ACTIVACIÓN VIGENTE INTERNAMENTE, NUNCA DESDE EL CLIENTE).
    private RecuperacionContrasenaAccesoUsuarioRepository recuperacionContrasenaAccesoUsuarioRepository;
    
    @Override//SOBREESCRIBIMOS EL METODO DE ENVIAR CORREO ELECTRÓNICO.
    public RespuestaDTO enviarCorreoElectronico(EmailDTO emailDTO) {
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_CORREO_ELECTRONICO_NO_ENVIADO, false);
        
        if ( (emailDTO==null)||(emailDTO.getIdUsuario()==null) ) {
           return new RespuestaDTO(MensajesConstantes.MSG_USUARIO_RECUPERACION_NO_ENCONTRADO, false);
        }
        
        //SE RESUELVE EL USUARIO Y SU CORREO DE DESTINO (INSTITUCIONAL O PERSONAL) DESDE SU PROPIO REGISTRO, NUNCA
        //DESDE UNA DIRECCIÓN QUE ENVÍE EL CLIENTE:
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdUsuario(emailDTO.getIdUsuario());
        if (!usuarioOpt.isPresent()) {
           return new RespuestaDTO(MensajesConstantes.MSG_USUARIO_RECUPERACION_NO_ENCONTRADO, false);
        }
        Usuario usuario = usuarioOpt.get();
        String correoElectronicoDestinatario = "INSTITUCIONAL".equalsIgnoreCase(emailDTO.getMedioEnvio())
            ? usuario.getCorreoElectronicoInstitucionalUsuario()
            : usuario.getCorreoElectronicoPersonalUsuario();
        if ( (correoElectronicoDestinatario==null)||(correoElectronicoDestinatario.trim().isEmpty()) ) {
           return new RespuestaDTO(MensajesConstantes.MSG_CORREO_ELECTRONICO_DESTINATARIO_NO_REGISTRADO, false);
        }
        
        //SE BUSCA EL CÓDIGO DE ACTIVACIÓN VIGENTE DE ESTE USUARIO (EL MÁS RECIENTE, YA GUARDADO PREVIAMENTE POR
        //crearRecuperacionContrasenaAccesoUsuario):
        List<RecuperacionContrasenaAccesoUsuario> recuperaciones = recuperacionContrasenaAccesoUsuarioRepository.searchRecuperacionesContrasenasAccesosUsuariosByIdUsuarioOrderedById(emailDTO.getIdUsuario(), "idRecuperacionContrasenaAccesoUsuario", "ASC");
        if ( (recuperaciones==null)||(recuperaciones.isEmpty()) ) {
           return new RespuestaDTO(MensajesConstantes.MSG_CODIGO_ACTIVACION_NO_ENVIADO, false);
        }
        String codigoActivacionContrasenaAccesoUsuario = recuperaciones.get(recuperaciones.size() - 1).getCodigoActivacionContrasenaAccesoUsuario();
        
        //SE CONSULTA LA CONFIGURACIÓN SMTP Y LA PLANTILLA DEL CORREO DIRECTAMENTE EN LA BASE DE DATOS (NUNCA SE
        //RECIBEN DESDE EL FRONTEND, PARA QUE LA CONTRASEÑA Y DEMÁS DATOS DEL REMITENTE NUNCA VIAJEN POR EL NAVEGADOR):
        Optional<ParametrosSistema> parametrosSistemaOpt = parametrosSistemaRepository.findByIdParametrosSistema(ID_PARAMETROS_SISTEMA);
        if (!parametrosSistemaOpt.isPresent()) {
           return new RespuestaDTO(MensajesConstantes.MSG_PARAMETROS_SISTEMA_NO_ENCONTRADOS, false);
        }
        ParametrosSistema parametrosSistema = parametrosSistemaOpt.get();
        //EN SICIM LOS PARÁMETROS GUARDAN "1" (ACTIVO) O "0" (INACTIVO); Boolean.parseBoolean("1") DARÍA FALSO:
        boolean authEnable = esVerdadero(parametrosSistema.getAuthEnable());
        boolean startTTLSEnable = esVerdadero(parametrosSistema.getStartTTLSEnable());
        int smtpPort = (parametrosSistema.getSmtpPort()==null) ? 0 : parametrosSistema.getSmtpPort().intValue();
        
        //SE ARMA EL ASUNTO Y EL CUERPO HTML DEL CORREO REEMPLAZANDO LOS MARCADORES DE LA PLANTILLA CON EL NÚMERO
        //DE DOCUMENTO Y EL CÓDIGO DE ACTIVACIÓN RESUELTOS INTERNAMENTE (NUNCA VIENEN DEL CLIENTE).
        //String.replace REEMPLAZA TODAS LAS APARICIONES DE CADA MARCADOR:
        String plantilla = (parametrosSistema.getCuerpoMensajeHtmlRecuperacionContrasena()==null) ? "" : parametrosSistema.getCuerpoMensajeHtmlRecuperacionContrasena();
        String numeroDocumento = (usuario.getNumeroDocumentoIdentificacionUsuario()==null) ? "" : usuario.getNumeroDocumentoIdentificacionUsuario();
        String asuntoDestinatario = parametrosSistema.getAsuntoDestinatarioRecuperacionContrasena();
        String cuerpoMensajeHtml = plantilla
            .replace(MARCADOR_NUMERO_DOCUMENTO, numeroDocumento)
            .replace(MARCADOR_CODIGO_ACTIVACION, codigoActivacionContrasenaAccesoUsuario);
        
        try {
            //CONFIGURACIÓN DEL SERVIDOR SMTP:
            Properties props = new Properties();
            props.put("mail.smtp.auth", authEnable);//PERMITE SI O NO ACTIVAR EN VERDADERO O FALSO (TRUE OR FALSE) LA AUTENTICACIÓN SMTP CON USUARIO Y PASSWORD.
            props.put("mail.smtp.starttls.enable", startTTLSEnable);//PERMITE SI O NO ACTIVAR EN VERDADERO O FALSO (TRUE OR FALSE) EL CIFRADO DE LA CONEXIÓN.
            props.put("mail.smtp.host", parametrosSistema.getSmtpHost());//ESPECÍFICA LA DIRECCIÓN DEL SERVIDOR SMTP AL QUE SE CONECTARÁ PARA ENVIAR LOS CORREOS ELECTRÓNICOS.
            props.put("mail.smtp.ssl.trust", parametrosSistema.getSmtpHost());//ESPECÍFICA QUE SERVIDORES SE CONSIDERAN CONFIABLES PARA CONEXIONES SSL (DIRECCIÓN DEL SERVIDOR SMTP).
            props.put("mail.smtp.port", String.valueOf(smtpPort));//ESPECÍFICA EL PUERTO DEL SERVIDOR SMTP AL QUE SE CONECTARÁ PARA ENVIAR LOS CORREOS ELECTRÓNICOS.
            props.put("mail.smtp.ssl.protocols", parametrosSistema.getSmtpProtocols());//ESPECÍFICA LOS PROTOCOLOS SSL/TLS CON SU VERSIÓN QUE SE DEBEN DE USAR PARA ENVIAR LOS CORREOS ELECTRÓNICOS.
            
            //SI SE USA SSL (PUERTO 465):
            if (smtpPort==465) {
               props.put("mail.smtp.socketFactory.port", String.valueOf(smtpPort));
               props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
               props.put("mail.smtp.ssl.enable", "true");
            }
            
            //AUTENTICACIÓN DEL REMITENTE:
            Session session = null;
            if (authEnable==true) {
               final String usuarioRemitente = parametrosSistema.getUsuarioRemitente();
               final String passwordRemitente = parametrosSistema.getPasswordRemitente();
               session = Session.getInstance(props, new Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(usuarioRemitente, passwordRemitente);
                   }
               });
            }
            if (authEnable==false) {
               session = Session.getInstance(props);
            }
            
            //COMPOSICIÓN DEL MENSAJE:
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(parametrosSistema.getCorreoElectronicoRemitente()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoElectronicoDestinatario.trim()));
            message.setSubject(asuntoDestinatario);
            message.setContent(cuerpoMensajeHtml, "text/html; charset=UTF-8");
            
            //ENVIO DEL MENSAJE:
            Transport.send(message);
            
            respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_CORREO_ELECTRONICO_ENVIADO_EXITO, true);
        } catch (Exception e) {
            //CAPTURA EL STACKTRACE COMO TEXTO:
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String stackTrace = sw.toString();
            //e.printStackTrace();//MUESTRA STACKTRACE EN CONSOLA.
            logger.error("Error al enviar correo electrónico", e);//MUESTRA TRAZA COMPLETA.
            respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_ERROR_ENVIO_CORREO_ELECTRONICO + " " + stackTrace, false);
        }
        
        return respuestaDTO;
    }
    
    //LOS PARÁMETROS DEL SISTEMA GUARDAN authEnable Y startTTLSEnable COMO TEXTO ("1"/"0" EN SICIM):
    private boolean esVerdadero(String valor) {
        if (valor==null) {
           return false;
        }
        String v = valor.trim();
        return v.equals("1") || v.equalsIgnoreCase("true") || v.equalsIgnoreCase("SI") || v.equalsIgnoreCase("SÍ") || v.equalsIgnoreCase("ACTIVO");
    }
}
