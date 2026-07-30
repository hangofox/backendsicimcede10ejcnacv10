//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.UsuarioService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.UsuarioDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Usuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RecuperacionContrasenaAccesoUsuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UsuarioRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.RecuperacionContrasenaAccesoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired//INYECTAMOS EL DAO.
    private UsuarioDAO usuarioDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UsuarioRepository usuarioRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private RecuperacionContrasenaAccesoUsuarioRepository recuperacionContrasenaAccesoUsuarioRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idUsuario, String keyword) {
        return usuarioRepository.findTotalRegistros(idUsuario, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<UsuarioDTO> listarUsuarios(Long idUsuario, String keyword, String orderBy, String orderMode) {
        List<Usuario> usuarios = usuarioRepository.findAllUsuarios(idUsuario, keyword, orderBy, orderMode);
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        
        for (Usuario usuario : usuarios){
            usuarioDTOS.add(usuarioDAO.usuarioDTO(usuario));
        }
        
        return usuarioDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<UsuarioDTO> listarUsuariosPag(Pageable pageable, Long idUsuario, String keyword, String orderBy, String orderMode) {
        Slice<Usuario> usuarios = usuarioRepository.findAllUsuariosPag(pageable, idUsuario, keyword, orderBy, orderMode);
        return usuarios.map(usuario -> usuarioDAO.usuarioDTO(usuario));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Long maxIdUsuario = null;
        Usuario usuarioNickname = usuarioRepository.findByNicknameUsuario(usuarioDTO.getNicknameUsuario());
        Usuario usuarioNumeroDocumentoIdentificacion = usuarioRepository.findByNumeroDocumentoIdentificacionUsuario(usuarioDTO.getNumeroDocumentoIdentificacionUsuario());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNicknameEncontrado=0, banderaNumeroDocumentoIdentificacionRegistroEncontrado=0;
        
        if (!(usuarioNickname==null)) {//SI ENCONTRO EL NICKNAME DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NICKNAME DE REGISTRO REPETIDO CON EL MISMO NICKNAME PROPORCIONADO.
           banderaNicknameEncontrado=1;
        }
        if (!(usuarioNumeroDocumentoIdentificacion==null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           banderaNumeroDocumentoIdentificacionRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNicknameEncontrado==1) {//SI ENCONTRO EL NICKNAME DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NICKNAMEO DE REGISTRO REPETIDO CON EL NICKNAME PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NICKNAME_YA_EXISTE, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        if ((banderaNicknameEncontrado==0)&&(banderaNumeroDocumentoIdentificacionRegistroEncontrado==0)) {//SI NO ENCONTRO EL NICKNAME DEL REGISTRO Y EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NICKNAME Y NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADOS.
           maxIdUsuario = usuarioRepository.findMaxIdUsuario();
           if (maxIdUsuario==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdUsuario=Long.valueOf(0);
           }
           usuarioDTO.setIdUsuario(maxIdUsuario+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           usuarioRepository.save(usuarioDAO.usuario(usuarioDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUsuarioporId(Long idUsuario) {
        Optional<Usuario> usuarioId = usuarioRepository.findByIdUsuario(Long.valueOf(idUsuario));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (usuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setUsuarioDTO(usuarioDAO.usuarioDTO(usuarioId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (usuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUsuarioporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionUsuario) {
        Optional<Usuario> usuarioNumeroDocumentoIdentificacion = Optional.ofNullable(usuarioRepository.findByNumeroDocumentoIdentificacionUsuario(numeroDocumentoIdentificacionUsuario));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
        
        if (usuarioNumeroDocumentoIdentificacion.isPresent()==true) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO.setUsuarioDTO(usuarioDAO.usuarioDTO(usuarioNumeroDocumentoIdentificacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (usuarioNumeroDocumentoIdentificacion.isPresent()==false) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO PARA RECUPERACIÓN DE CONTRASEÑA POR NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUsuarioRecuperacionContrasenaAccesoporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionUsuario) {
        Optional<Usuario> usuarioNumeroDocumentoIdentificacion = Optional.ofNullable(usuarioRepository.findByNumeroDocumentoIdentificacionUsuario(numeroDocumentoIdentificacionUsuario));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
        
        if (usuarioNumeroDocumentoIdentificacion.isPresent()==true) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           //OCULTAMOS LOS DATOS SENSIBLES DEL USUARIO ANTES DE ENVIARSE:
           usuarioNumeroDocumentoIdentificacion.get().setNicknameUsuario(null);
           usuarioNumeroDocumentoIdentificacion.get().setPasswordUsuario(null);
           usuarioNumeroDocumentoIdentificacion.get().setLugarExpedicionDocumentoIdentificacionUsuario("*****");
           usuarioNumeroDocumentoIdentificacion.get().setNombreArchivoFotoExtensionoFormatoUsuario(null);
           usuarioNumeroDocumentoIdentificacion.get().setFechaHMSNacimientoUsuario(null);
           usuarioNumeroDocumentoIdentificacion.get().setSexoUsuario("*****");
           usuarioNumeroDocumentoIdentificacion.get().setDireccionUsuario("*****");
           usuarioNumeroDocumentoIdentificacion.get().setTelefonoUsuario(null);
           usuarioNumeroDocumentoIdentificacion.get().setPaisOrigenUsuario("*****");
           usuarioNumeroDocumentoIdentificacion.get().setDepartamentooEstadoOrigenUsuario("*****");
           usuarioNumeroDocumentoIdentificacion.get().setCiudadOrigenUsuario("*****");
           usuarioNumeroDocumentoIdentificacion.get().setFechaHMSIngresoUsuario(null);
           usuarioNumeroDocumentoIdentificacion.get().setEstadoUsuario("*****");
           usuarioNumeroDocumentoIdentificacion.get().setTipoDocumentoIdentificacion(null);
           usuarioNumeroDocumentoIdentificacion.get().setTipoUsuario(null);
           respuestaDTO.setUsuarioDTO(usuarioDAO.usuarioDTO(usuarioNumeroDocumentoIdentificacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (usuarioNumeroDocumentoIdentificacion.isPresent()==false) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NICKNAME Y PASSWORD:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUsuarioporNicknameYPassword(String nicknameUsuario, String passwordUsuario) {
        Optional<Usuario> usuarioNickname = Optional.ofNullable(usuarioRepository.findByNicknameUsuario(nicknameUsuario));
        Optional<Usuario> usuarioNicknameAndPassword = Optional.ofNullable(usuarioRepository.findByNicknameUsuarioAndPasswordUsuario(nicknameUsuario, passwordUsuario));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NICKNAME_Y_PASSWORD_NO_ENCONTRADO, false);
        
        if (usuarioNickname.isPresent()==true) {//SI ENCONTRO EL NICKNAME DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS VALIDA EL PASSWORD PROPORCIONADO.
           if (usuarioNicknameAndPassword.isPresent()==true) {//SI ENCONTRO EL NICKNAME Y PASSWORD DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NICKNAME Y PASSWORD PROPORCIONADOS.
              if ( (usuarioNicknameAndPassword.get().getEstadoUsuario().equals("ACTIVO")==true) ) {//SI EL ESTADO DEL REGISTRO ES ESTADO ACTIVO MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NICKNAME Y PASSWORD PROPORCIONADOS.
                 respuestaDTO.setUsuarioDTO(usuarioDAO.usuarioDTO(usuarioNicknameAndPassword.get()));
                 respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
                 respuestaDTO.setBanderaexito(true);
              }
              if ( (usuarioNicknameAndPassword.get().getEstadoUsuario().equals("INACTIVO")==true) ) {//SI EL ESTADO DEL REGISTRO ES ESTADO INACTIVO REALIZADA MUESTRA EL REGISTRO EN NULO CON UN MENSAJE DE REGISTRO EN ESTADO INACTIVO CON EL NICKNAME Y PASSWORD PROPORCIONADOS
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_USUARIO_ESTADO_INACTIVO, false);
                 respuestaDTO.setUsuarioDTO(null);
              }
           }
           if (usuarioNicknameAndPassword.isPresent()==false) {//SI NO ENCONTRO EL NICKNAME Y PASSWORD DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO EN NULO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NICKNAME Y PASSWORD PROPORCIONADOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PASSWORD_NO_ENCONTRADO, false);
              respuestaDTO.setUsuarioDTO(null);
           }
        }
        if (usuarioNickname.isPresent()==false) {//SI NO ENCONTRO EL NICKNAME DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NICKNAME PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NICKNAME_NO_ENCONTRADO, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioId = usuarioRepository.findByIdUsuario(usuarioDTO.getIdUsuario());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (usuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO CON EL ID PROPORCIONADO.
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaNicknameEncontrado=0, banderaNumeroDocumentoIdentificacionRegistroEncontrado=0;
           
           if ( (usuarioDTO.getNicknameUsuario().equals(usuarioId.get().getNicknameUsuario())==true)&&(usuarioDTO.getNumeroDocumentoIdentificacionUsuario().equals(usuarioId.get().getNumeroDocumentoIdentificacionUsuario())==true) ) {//SI EL NICKNAME Y NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS SON IGUALES AL NICKNAME Y NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              Usuario usuario = usuarioDAO.usuario(usuarioDTO);
              usuarioRepository.save(usuario);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           
           if ( (usuarioDTO.getNicknameUsuario().equals(usuarioId.get().getNicknameUsuario())==false) ) {//SI EL NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS SON DIFERENTES AL NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS EXISTEN EN OTROS REGISTROS.
              Usuario usuarioNickname = usuarioRepository.findByNicknameUsuario(usuarioDTO.getNicknameUsuario());
              
              if (!(usuarioNickname==null)) {//SI ENCONTRO EL NICKNAME DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NICKNAME DE REGISTRO REPETIDO CON EL MISMO NICKNAME PROPORCIONADO.
                 banderaNicknameEncontrado=1;
              }
              
              if ((banderaNicknameEncontrado==1)) {//SI ENCONTRO EL NICKNAME DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NICKNAMEO DE REGISTRO REPETIDO CON EL NICKNAME PROPORCIONADO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NICKNAME_YA_EXISTE, false);
                 respuestaDTO.setUsuarioDTO(null);
              }
           }
           if ( (usuarioDTO.getNumeroDocumentoIdentificacionUsuario().equals(usuarioId.get().getNumeroDocumentoIdentificacionUsuario())==false) ) {//SI EL NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS SON DIFERENTES AL NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS EXISTEN EN OTROS REGISTROS.
              Usuario usuarioNumeroDocumentoIdentificacion = usuarioRepository.findByNumeroDocumentoIdentificacionUsuario(usuarioDTO.getNumeroDocumentoIdentificacionUsuario());
              
              if ((!(usuarioNumeroDocumentoIdentificacion==null))) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
                 banderaNumeroDocumentoIdentificacionRegistroEncontrado=1;
              }
              
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
                 respuestaDTO.setUsuarioDTO(null);
              }
           }
           if ( (usuarioDTO.getNicknameUsuario().equals(usuarioId.get().getNicknameUsuario())==false)||(usuarioDTO.getNumeroDocumentoIdentificacionUsuario().equals(usuarioId.get().getNumeroDocumentoIdentificacionUsuario())==false) ) {//SI EL NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS SON DIFERENTES AL NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE Y SUPERA LAS 2 VALIDACIONES (NICKNAME O NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS) SE ACTUALIZA EL REGISTRO CON EL NICKNAME Y NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADOS.
              if ((banderaNicknameEncontrado==0)&&(banderaNumeroDocumentoIdentificacionRegistroEncontrado==0)) {//SI LA BUSQUEDA OBTIENE QUE EL NICKNAME DIGITADO Y EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO SON NULOS EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 Usuario usuario = usuarioDAO.usuario(usuarioDTO);
                 usuarioRepository.save(usuario);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (usuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //RECUPERACIÓN DE CONTRASEÑA DE ACCESO DE USUARIO:
    @Override//SOBREESCRIBIMOS EL METODO DE RECUPERACIÓN DE CONTRASEÑA DE ACCESO DE USUARIO.
    public RespuestaDTO recuperacionContrasenaAccesoUsuario(String codigoActivacionContrasenaAccesoUsuario, Long idUsuario, String passwordUsuario) {
        Optional<RecuperacionContrasenaAccesoUsuario> recuperacionContrasenaAccesoUsuarioCodigoActivacion = Optional.ofNullable(recuperacionContrasenaAccesoUsuarioRepository.findByCodigoActivacionContrasenaAccesoUsuario(String.valueOf(codigoActivacionContrasenaAccesoUsuario)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_CONTRASENA_ACCESO_USUARIO_NO_RECUPERADA, false);
        
        if (recuperacionContrasenaAccesoUsuarioCodigoActivacion.isPresent()==true) {//SI ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA FECHA, HORA, MINUTO Y SEGUNDO DE EXPIRACIÓN Y EL ESTADO DE USO DEL CÓDIGO DE ACTIVACIÓN CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
           
           //OBTENCIÓN AUTOMÁTICA DE LA FECHA Y HORA (AÑO, MES Y DÍA, HORA, MINUTO Y SEGUNDO) DEL SERVIDOR ACTUAL:
           Date fechaHMSExpCodActivContrasenaAccesoUsuarioServidor = new Date();
           
           //OBTENCIÓN AUTOMÁTICA DE LA FECHA Y HORA (AÑO, MES Y DÍA, HORA, MINUTO Y SEGUNDO) ALMACENADA DE LA TABLA DE RECUPERACIONES DE CONTRASEÑAS DE ACCESOS DE LOS USUARIOS:
           Date fechaHMSExpCodActivContrasenaAccesoUsuarioAlmacenada = recuperacionContrasenaAccesoUsuarioCodigoActivacion.get().getFechaHMSExpCodActivContrasenaAccesoUsuario();
           
           //VERIFICAMOS SI EL CÓDIGO DE ACTIVACIÓN DE LA CONTRASEÑA DE ACCESO DEL USUARIO CUMPLE CON LOS REQUISITOS DE: QUE LA FECHA, HORA, MINUTO Y SEGUNDO ACTUAL DEL SERVIDOR SEAN INFERIOR A LA FECHA, HORA, MINUTO Y SEGUNDO ALMACENADA EN LA TABLA DE LA BASE DE DATOS Y EL ESTADO DE USO DEL CÓDIGO DE ACTIVACIÓN ESTE EN PENDIENTE DE USO.
           if ( (fechaHMSExpCodActivContrasenaAccesoUsuarioServidor.after(fechaHMSExpCodActivContrasenaAccesoUsuarioAlmacenada)==false)&&(recuperacionContrasenaAccesoUsuarioCodigoActivacion.get().getEstadoUsoCodigoActivacionContrasenaAccesoUsuario().equals("PENDIENTE DE USO")==true) ) {//EN CASO DE QUE LA FECHA, HORA, MINUTO Y SEGUNDO ACTUAL DEL SERVIDOR YA SEA SUPERIOR A LA FECHA, HORA, MINUTO Y SEGUNDO ALMACENADA EN LA TABLA DE LA BASE DE DATOS O EL ESTADO DE USO DEL CÓDIGO DE ACTIVACIÓN ESTE EN EXPIRADO.
              usuarioRepository.updatePasswordUsuario(idUsuario, passwordUsuario);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_CONTRASENA_ACCESO_USUARIO_RECUPERADA_EXITO, true);
           }
           
           //VERIFICAMOS SI EL CÓDIGO DE ACTIVACIÓN DE LA CONTRASEÑA DE ACCESO DEL USUARIO YA ESTA EXPIRADO:
           if ( (fechaHMSExpCodActivContrasenaAccesoUsuarioServidor.after(fechaHMSExpCodActivContrasenaAccesoUsuarioAlmacenada)==true)&&(recuperacionContrasenaAccesoUsuarioCodigoActivacion.get().getEstadoUsoCodigoActivacionContrasenaAccesoUsuario().equals("EXPIRADO")==true) ) {//EN CASO DE QUE LA FECHA, HORA, MINUTO Y SEGUNDO ACTUAL DEL SERVIDOR YA SEA SUPERIOR A LA FECHA, HORA, MINUTO Y SEGUNDO ALMACENADA EN LA TABLA DE LA BASE DE DATOS O EL ESTADO DE USO DEL CÓDIGO DE ACTIVACIÓN ESTE EN EXPIRADO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_ACTIVACION_EXPIRO, false);
              respuestaDTO.setUsuarioDTO(null);
           }
           
           //VERIFICAMOS SI EL CÓDIGO DE ACTIVACIÓN DE LA CONTRASEÑA DE ACCESO DEL USUARIO YA FUE USADO:
           if ( (recuperacionContrasenaAccesoUsuarioCodigoActivacion.get().getEstadoUsoCodigoActivacionContrasenaAccesoUsuario().equals("USADO")==true) ) {//EN CASO DE QUE LA FECHA ACTUAL DEL SERVIDOR YA SEA SUPERIOR A LA FECHA ALMACENADA EN LA TABLA DE LA BASE DE DATOS O EL ESTADO DE USO DEL CÓDIGO DE ACTIVACIÓN ESTE EN EXPIRADO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_ACTIVACION_USADO, false);
              respuestaDTO.setUsuarioDTO(null);
           }
        }
        if (recuperacionContrasenaAccesoUsuarioCodigoActivacion.isPresent()==false) {//SI NO ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE CONTRASEÑA DE ACCESO DE USUARIO NO RECUPERADA EXITOSAMENTE CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_CONTRASENA_ACCESO_USUARIO_NO_RECUPERADA, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarUsuario(Long idUsuario) {
        Optional<Usuario> usuarioId = usuarioRepository.findById(idUsuario);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (usuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setUsuarioDTO(usuarioDAO.usuarioDTO(usuarioId.get()));
           usuarioRepository.delete(usuarioId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (usuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
}
