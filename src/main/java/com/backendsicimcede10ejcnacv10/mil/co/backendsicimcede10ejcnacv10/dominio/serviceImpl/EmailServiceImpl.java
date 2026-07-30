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
import org.springframework.stereotype.Service;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EmailDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.EmailService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class EmailServiceImpl implements EmailService {
    
    //ENVIAR CORREO ELECTRÓNICO:
    
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);//DECLARACIÓN DE VARIABLES DE LOG.
    
    @Override//SOBREESCRIBIMOS EL METODO DE ENVIAR CORREO ELECTRÓNICO.
    public RespuestaDTO enviarCorreoElectronico(EmailDTO emailDTO) {
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_CORREO_ELECTRONICO_NO_ENVIADO, false);
        
        try {
            /*//LOG DE PARÁMETROS ANTES DE ENVIAR EL CORREO ELECTRÓNICO.
            logger.info("=== INICIO ENVÍO DE CORREO ===");
            logger.info("SMTP HOST: {}", emailDTO.getSmtpHost());
            logger.info("SMTP PORT: {}", emailDTO.getSmtpPort());
            logger.info("TLS ENABLED: {}", emailDTO.isStartTTLSEnable());
            logger.info("AUTH ENABLED: {}", emailDTO.isAuthEnable());
            logger.info("USUARIO REMITENTE: {}", emailDTO.getUsuarioRemitente());
            logger.info("CORREO DESTINATARIO: {}", emailDTO.getCorreoElectronicoDestinatario());*/
            
            //CONFIGURACIÓN DEL SERVIDOR SMTP:
            Properties props = new Properties();
            props.put("mail.smtp.auth", emailDTO.isAuthEnable());//PERMITE SI O NO ACTIVAR EN VERDADERO O FALSO (TRUE OR FALSE) LA AUTENTICACIÓN SMTP CON USUARIO Y PASSWORD.
            props.put("mail.smtp.starttls.enable", emailDTO.isStartTTLSEnable());//PERMITE SI O NO ACTIVAR EN VERDADERO O FALSO (TRUE OR FALSE) EL CIFRADO DE LA CONEXIÓN.
            props.put("mail.smtp.host", emailDTO.getSmtpHost());//ESPECÍFICA LA DIRECCIÓN DEL SERVIDOR SMTP AL QUE SE CONECTARÁ PARA ENVIAR LOS CORREOS ELECTRÓNICOS.
            props.put("mail.smtp.ssl.trust", emailDTO.getSmtpHost());//ESPECÍFICA QUE SERVIDORES SE CONSIDERAN CONFIABLES PARA CONEXIONES SSL (DIRECCIÓN DEL SERVIDOR SMTP).
            props.put("mail.smtp.port", String.valueOf(emailDTO.getSmtpPort()));//ESPECÍFICA EL PUERTO DEL SERVIDOR SMTP AL QUE SE CONECTARÁ PARA ENVIAR LOS CORREOS ELECTRÓNICOS.
            props.put("mail.smtp.ssl.protocols", emailDTO.getSmtpProtocols());//ESPECÍFICA LOS PROTOCOLOS SSL/TLS CON SU VERSIÓN QUE SE DEBEN DE USAR PARA ENVIAR LOS CORREOS ELECTRÓNICOS.
            
            //SI SE USA SSL (PUERTO 465):
            if (emailDTO.getSmtpPort()==465) {
               props.put("mail.smtp.socketFactory.port", String.valueOf(emailDTO.getSmtpPort()));
               props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
               props.put("mail.smtp.ssl.enable", "true");
            }
            
            //AUTENTICACIÓN DEL REMITENTE:
            Session session = null;
            if (emailDTO.isAuthEnable()==true) {
               session = Session.getInstance(props, new Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(emailDTO.getUsuarioRemitente(), emailDTO.getPasswordRemitente());
                   }
               });
            }
            if (emailDTO.isAuthEnable()==false) {
               session = Session.getInstance(props);
            }
            
            //COMPOSICIÓN DEL MENSAJE:
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailDTO.getCorreoElectronicoRemitente()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDTO.getCorreoElectronicoDestinatario()));
            message.setSubject(emailDTO.getAsuntoDestinatario());
            message.setContent(emailDTO.getCuerpoMensajeHtml(), "text/html; charset=UTF-8");
            
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
}
