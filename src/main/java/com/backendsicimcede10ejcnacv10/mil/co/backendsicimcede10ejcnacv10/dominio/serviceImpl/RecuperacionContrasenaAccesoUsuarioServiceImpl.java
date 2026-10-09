//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RecuperacionContrasenaAccesoUsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EnvioCodigoActivacionRecuperacionContrasenaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EmailDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.EmailService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ParametrosSistema;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Usuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ParametrosSistemaRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UsuarioRepository;
import java.security.SecureRandom;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.RecuperacionContrasenaAccesoUsuarioService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.RecuperacionContrasenaAccesoUsuarioDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RecuperacionContrasenaAccesoUsuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.RecuperacionContrasenaAccesoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;
//import java.text.SimpleDateFormat;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class RecuperacionContrasenaAccesoUsuarioServiceImpl implements RecuperacionContrasenaAccesoUsuarioService {
    
    @Autowired//INYECTAMOS EL DAO.
    private RecuperacionContrasenaAccesoUsuarioDAO recuperacionContrasenaAccesoUsuarioDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private RecuperacionContrasenaAccesoUsuarioRepository recuperacionContrasenaAccesoUsuarioRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO DE USUARIOS (PARA VALIDAR QUE TENGA EL CORREO ELEGIDO ANTES DE GENERAR EL CÓDIGO).
    private UsuarioRepository usuarioRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO DE PARÁMETROS DEL SISTEMA (TIEMPO DE VALIDEZ DEL CÓDIGO).
    private ParametrosSistemaRepository parametrosSistemaRepository;
    
    @Autowired//INYECTAMOS EL SERVICIO DE ENVÍO DE CORREOS ELECTRÓNICOS.
    private EmailService emailService;
    
    //MEDIOS DE ENVÍO (MISMOS VALORES QUE ESPERA EmailDTO, COMO EN EL BACKEND SIGEPS):
    private static final String MEDIO_ENVIO_INSTITUCIONAL = "INSTITUCIONAL";
    private static final String MEDIO_ENVIO_PERSONAL = "PERSONAL";
    //ÚNICO REGISTRO DE PARÁMETROS DEL SISTEMA (EL MISMO QUE USA EmailServiceImpl):
    private static final Long ID_PARAMETROS_SISTEMA = 1L;
    private static final SecureRandom GENERADOR_ALEATORIO_SEGURO = new SecureRandom();
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuarios() {
        List<RecuperacionContrasenaAccesoUsuario> recuperacionesContrasenasAccesosUsuarios = recuperacionContrasenaAccesoUsuarioRepository.findAll();
        List<RecuperacionContrasenaAccesoUsuarioDTO> recuperacionContrasenaAccesoUsuarioDTOS = new ArrayList<>();
        
        for (RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario : recuperacionesContrasenasAccesosUsuarios){
            recuperacionContrasenaAccesoUsuarioDTOS.add(recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuario));
        }
        
        return recuperacionContrasenaAccesoUsuarioDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosOrdenadasporId(String orderBy, String orderMode) {
        List<RecuperacionContrasenaAccesoUsuario> recuperacionesContrasenasAccesosUsuarios = recuperacionContrasenaAccesoUsuarioRepository.findAllRecuperacionesContrasenasAccesosUsuariosOrderedById(orderBy, orderMode);
        List<RecuperacionContrasenaAccesoUsuarioDTO> recuperacionContrasenaAccesoUsuarioDTOS = new ArrayList<>();
        
        for (RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario : recuperacionesContrasenasAccesosUsuarios){
            recuperacionContrasenaAccesoUsuarioDTOS.add(recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuario));
        }
        
        return recuperacionContrasenaAccesoUsuarioDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosOrdenadasporIdPag(Pageable pageable, String orderBy, String orderMode) {
        Slice<RecuperacionContrasenaAccesoUsuario> recuperacionesContrasenasAccesosUsuarios = recuperacionContrasenaAccesoUsuarioRepository.findAllRecuperacionesContrasenasAccesosUsuariosOrderedByIdPag(pageable, orderBy, orderMode);
        return recuperacionesContrasenasAccesosUsuarios.map(recuperacionContrasenaAccesoUsuario -> recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuario));
    }
    
    //LISTAR REGISTROS FILTRADOS POR ID DE USUARIO Y ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosporIdUsuarioyOrdenadasporId(Long idUsuario, String orderBy, String orderMode) {
        List<RecuperacionContrasenaAccesoUsuario> recuperacionesContrasenasAccesosUsuarios = recuperacionContrasenaAccesoUsuarioRepository.searchRecuperacionesContrasenasAccesosUsuariosByIdUsuarioOrderedById(idUsuario, orderBy, orderMode);
        List<RecuperacionContrasenaAccesoUsuarioDTO> recuperacionContrasenaAccesoUsuarioDTOS = new ArrayList<>();
        
        for (RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario : recuperacionesContrasenasAccesosUsuarios){
            recuperacionContrasenaAccesoUsuarioDTOS.add(recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuario));
        }
        
        return recuperacionContrasenaAccesoUsuarioDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS FILTRADOS POR ID DE USUARIO Y ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosporIdUsuarioyOrdenadasporIdPag(Pageable pageable, Long idUsuario, String orderBy, String orderMode) {
        Slice<RecuperacionContrasenaAccesoUsuario> recuperacionesContrasenasAccesosUsuarios = recuperacionContrasenaAccesoUsuarioRepository.searchRecuperacionesContrasenasAccesosUsuariosByIdUsuarioOrderedByIdPag(pageable, idUsuario, orderBy, orderMode);
        return recuperacionesContrasenasAccesosUsuarios.map(recuperacionContrasenaAccesoUsuario -> recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuario));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearRecuperacionContrasenaAccesoUsuario(RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO) {
        Long maxIdRecuperacionContrasenaAccesoUsuario=null;
        RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuarioCodigoActivacion = recuperacionContrasenaAccesoUsuarioRepository.findByCodigoActivacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO.getCodigoActivacionContrasenaAccesoUsuario().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaCodigoActivacionRegistroEncontrado=0;
        
        if (!(recuperacionContrasenaAccesoUsuarioCodigoActivacion==null)) {//SI ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE ACTIVACIÓN DE REGISTRO REPETIDO CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
           banderaCodigoActivacionRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaCodigoActivacionRegistroEncontrado==1) {//SI ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE ACTIVACIÓN DE REGISTRO REPETIDO CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_ACTIVACION_YA_EXISTE, false);
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
        }
        if ((banderaCodigoActivacionRegistroEncontrado==0) ) {//SI NO ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
           maxIdRecuperacionContrasenaAccesoUsuario = recuperacionContrasenaAccesoUsuarioRepository.findMaxIdRecuperacionContrasenaAccesoUsuario();
           if (maxIdRecuperacionContrasenaAccesoUsuario==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdRecuperacionContrasenaAccesoUsuario=Long.valueOf(0);
           }
           recuperacionContrasenaAccesoUsuarioDTO.setIdRecuperacionContrasenaAccesoUsuario(maxIdRecuperacionContrasenaAccesoUsuario+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           recuperacionContrasenaAccesoUsuarioRepository.save(recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarRecuperacionContrasenaAccesoUsuarioporId(Long idRecuperacionContrasenaAccesoUsuario) {
        Optional<RecuperacionContrasenaAccesoUsuario> recuperacionContrasenaAccesoUsuarioId = recuperacionContrasenaAccesoUsuarioRepository.findByIdRecuperacionContrasenaAccesoUsuario(Long.valueOf(idRecuperacionContrasenaAccesoUsuario));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (recuperacionContrasenaAccesoUsuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuarioId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (recuperacionContrasenaAccesoUsuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CÓDIGO DE ACTIVACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarRecuperacionContrasenaAccesoUsuarioporCodigoActivacion(String codigoActivacionContrasenaAccesoUsuario) {
        Optional<RecuperacionContrasenaAccesoUsuario> recuperacionContrasenaAccesoUsuarioCodigoActivacion = Optional.ofNullable(recuperacionContrasenaAccesoUsuarioRepository.findByCodigoActivacionContrasenaAccesoUsuario(String.valueOf(codigoActivacionContrasenaAccesoUsuario)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (recuperacionContrasenaAccesoUsuarioCodigoActivacion.isPresent()==true) {//SI ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuarioCodigoActivacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (recuperacionContrasenaAccesoUsuarioCodigoActivacion.isPresent()==false) {//SI NO ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarRecuperacionContrasenaAccesoUsuario(RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO) {
        Optional<RecuperacionContrasenaAccesoUsuario> recuperacionContrasenaAccesoUsuarioId = recuperacionContrasenaAccesoUsuarioRepository.findByIdRecuperacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO.getIdRecuperacionContrasenaAccesoUsuario());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (recuperacionContrasenaAccesoUsuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (recuperacionContrasenaAccesoUsuarioDTO.getCodigoActivacionContrasenaAccesoUsuario().equals(recuperacionContrasenaAccesoUsuarioId.get().getCodigoActivacionContrasenaAccesoUsuario())==true) ) {//SI EL CÓDIGO DE ACTIVACIÓN DIGITADO ES IGUAL AL CÓDIGO DE ACTIVACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario = recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO);
              recuperacionContrasenaAccesoUsuarioRepository.save(recuperacionContrasenaAccesoUsuario);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (recuperacionContrasenaAccesoUsuarioDTO.getCodigoActivacionContrasenaAccesoUsuario().equals(recuperacionContrasenaAccesoUsuarioId.get().getCodigoActivacionContrasenaAccesoUsuario())==false) {//SI EL CÓDIGO DE ACTIVACIÓN DIGITADO ES DIFERENTE AL CÓDIGO DE ACTIVACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE CÓDIGO DE ACTIVACIÓN DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuarioCodigoActivacion = recuperacionContrasenaAccesoUsuarioRepository.findByCodigoActivacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO.getCodigoActivacionContrasenaAccesoUsuario().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaCodigoActivacionRegistroEncontrado=0;
              
              if (!(recuperacionContrasenaAccesoUsuarioCodigoActivacion==null)) {//SI ENCONTRO EL CÓDIGO DE ACTIVACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE ACTIVACIÓN DE REGISTRO REPETIDO CON EL CÓDIGO DE ACTIVACIÓN PROPORCIONADO.
                 banderaCodigoActivacionRegistroEncontrado=1;
              }
              
              if (banderaCodigoActivacionRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO DE ACTIVACIÓN DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CÓDIGO DE ACTIVACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE CÓDIGO DE ACTIVACIÓN DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_ACTIVACION_YA_EXISTE, false);
                 respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
              }
              if (banderaCodigoActivacionRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO DE ACTIVACIÓN DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario = recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO);
                 recuperacionContrasenaAccesoUsuarioRepository.save(recuperacionContrasenaAccesoUsuario);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (recuperacionContrasenaAccesoUsuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarRecuperacionContrasenaAccesoUsuario(Long idRecuperacionContrasenaAccesoUsuario) {
        Optional<RecuperacionContrasenaAccesoUsuario> recuperacionContrasenaAccesoUsuarioId  = recuperacionContrasenaAccesoUsuarioRepository.findById(idRecuperacionContrasenaAccesoUsuario);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (recuperacionContrasenaAccesoUsuarioId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuarioDAO.recuperacionContrasenaAccesoUsuarioDTO(recuperacionContrasenaAccesoUsuarioId.get()));
           recuperacionContrasenaAccesoUsuarioRepository.delete(recuperacionContrasenaAccesoUsuarioId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (recuperacionContrasenaAccesoUsuarioId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ACTUALIZAR ESTADOS DE USOS DE CÓDIGOS DE ACTIVACIONES DE CONTRASEÑAS DE ACCESOS DE USUARIOS:
    @Override//SOBREESCRIBIMOS EL METODO DE PREDETERMINAR REGISTRO.
    public RespuestaDTO actualizarEstadosUsosCodigosActivacionesContrasenasAccesosUsuarios(Date fechaHMSExpCodActivContrasenaAccesoUsuario) {
        List<RecuperacionContrasenaAccesoUsuario> recuperacionesContrasenasAccesosUsuarios = recuperacionContrasenaAccesoUsuarioRepository.findAllRecuperacionesContrasenasAccesosUsuariosOrderedById("idRecuperacionContrasenaAccesoUsuario", "ASC");
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_ACTUALIZADOS, false);
        
        if ( (recuperacionesContrasenasAccesosUsuarios==null)||(recuperacionesContrasenasAccesosUsuarios.isEmpty()==false) ) {//EN CASO DE QUE LA LISTA CONTENGA DATOS.
           //RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO = new RecuperacionContrasenaAccesoUsuarioDTO();
           recuperacionContrasenaAccesoUsuarioRepository.updateEstadoUsoCodActivContrasenaAccesoUsuarioRecuperacionesContrasenasAccesosUsuarios(fechaHMSExpCodActivContrasenaAccesoUsuario);
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_ACTUALIZADOS_EXITO, true);
        }
        if ( (recuperacionesContrasenasAccesosUsuarios==null)||(recuperacionesContrasenasAccesosUsuarios.isEmpty()==true) ) {//EN CASO DE QUE LA LISTA ESTE VACIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_ACTUALIZADOS, false);
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //VACIAR REGISTROS POR ID DE USUARIO:
    @Override//SOBREESCRIBIMOS EL METODO DE VACIAR REGISTROS.
    public RespuestaDTO vaciarRecuperacionesContrasenasAccesosUsuariosporIdUsuario(Long idUsuario) {
        List<RecuperacionContrasenaAccesoUsuario> recuperacionesContrasenasAccesosUsuarios = recuperacionContrasenaAccesoUsuarioRepository.searchRecuperacionesContrasenasAccesosUsuariosByIdUsuarioOrderedById(idUsuario, "idRecuperacionContrasenaAccesoUsuario", "ASC");
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_VACIADOS, false);
        
        if ( (recuperacionesContrasenasAccesosUsuarios==null)||(recuperacionesContrasenasAccesosUsuarios.isEmpty()==false) ) {//EN CASO DE QUE LA LISTA CONTENGA DATOS.
           recuperacionContrasenaAccesoUsuarioRepository.deleteRecuperacionesContrasenasAccesosUsuariosByIdUsuario(idUsuario);
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_VACIADOS_EXITO, true);
        }
        if ( (recuperacionesContrasenasAccesosUsuarios==null)||(recuperacionesContrasenasAccesosUsuarios.isEmpty()==true) ) {//EN CASO DE QUE LA LISTA ESTE VACIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_VACIADOS, false);
           respuestaDTO.setRecuperacionContrasenaAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ENVIAR CÓDIGO DE ACTIVACIÓN DE RECUPERACIÓN DE CONTRASEÑA DE ACCESO POR CORREO ELECTRÓNICO:
    //AQUÍ SOLO SE GENERA EL CÓDIGO Y SE GUARDA LA RECUPERACIÓN CON SU FECHA DE EXPIRACIÓN. EL CORREO LO ARMA Y ENVÍA
    //EmailServiceImpl CON EL PATRÓN DEL BACKEND SIGEPS: RECIBE SOLO EL ID DEL USUARIO Y EL MEDIO DE ENVÍO, TOMA EL
    //CÓDIGO RECIÉN GUARDADO (EL MÁS RECIENTE DEL USUARIO), EL NÚMERO DE DOCUMENTO, LA PLANTILLA Y EL SMTP DE LA BASE
    //DE DATOS Y REEMPLAZA LOS MARCADORES *[NUMDOCIDSICIM]* Y *[CODACTIVAUSICIM]*.
    //EL CÓDIGO NUNCA SE GENERA NI SE DEVUELVE EN EL NAVEGADOR.
    @Override//SOBREESCRIBIMOS EL METODO DE ENVIAR CÓDIGO DE ACTIVACIÓN.
    public RespuestaDTO enviarCodigoActivacionRecuperacionContrasenaAccesoUsuario(EnvioCodigoActivacionRecuperacionContrasenaDTO envioCodigoActivacionRecuperacionContrasenaDTO) {
        try {
            if ( (envioCodigoActivacionRecuperacionContrasenaDTO==null)||(envioCodigoActivacionRecuperacionContrasenaDTO.getIdUsuario()==null) ) {
               return new RespuestaDTO(MensajesConstantes.MSG_USUARIO_RECUPERACION_NO_ENCONTRADO, false);
            }
            
            //USUARIO QUE SOLICITA LA RECUPERACIÓN:
            Optional<Usuario> usuarioEncontrado = usuarioRepository.findByIdUsuario(envioCodigoActivacionRecuperacionContrasenaDTO.getIdUsuario());
            if (!usuarioEncontrado.isPresent()) {
               return new RespuestaDTO(MensajesConstantes.MSG_USUARIO_RECUPERACION_NO_ENCONTRADO, false);
            }
            Usuario usuario = usuarioEncontrado.get();
            
            //MEDIO DE ENVÍO: "INSTITUCIONAL" O "PERSONAL" (VALORES QUE ESPERA EmailDTO, COMO EN SIGEPS):
            String medioEnvio = (envioCodigoActivacionRecuperacionContrasenaDTO.getMedioEnvio()==null) ? "" : envioCodigoActivacionRecuperacionContrasenaDTO.getMedioEnvio().trim().toUpperCase();
            String correoElectronicoDestinatario;
            if (MEDIO_ENVIO_INSTITUCIONAL.equals(medioEnvio)) {
               correoElectronicoDestinatario = usuario.getCorreoElectronicoInstitucionalUsuario();
            } else if (MEDIO_ENVIO_PERSONAL.equals(medioEnvio)) {
               correoElectronicoDestinatario = usuario.getCorreoElectronicoPersonalUsuario();
            } else {
               return new RespuestaDTO(MensajesConstantes.MSG_MEDIO_ENVIO_NO_VALIDO, false);
            }
            //SE VALIDA ANTES DE GENERAR EL CÓDIGO PARA NO DEJAR UNA RECUPERACIÓN QUE NO SE PUEDA ENVIAR:
            if ( (correoElectronicoDestinatario==null)||(correoElectronicoDestinatario.trim().isEmpty()) ) {
               return new RespuestaDTO(MensajesConstantes.MSG_CORREO_ELECTRONICO_DESTINATARIO_NO_REGISTRADO, false);
            }
            
            //TIEMPO DE VALIDEZ DEL CÓDIGO (MISMO REGISTRO DE PARÁMETROS QUE USA EmailServiceImpl):
            Optional<ParametrosSistema> parametrosSistemaOpt = parametrosSistemaRepository.findByIdParametrosSistema(ID_PARAMETROS_SISTEMA);
            if (!parametrosSistemaOpt.isPresent()) {
               return new RespuestaDTO(MensajesConstantes.MSG_PARAMETROS_SISTEMA_NO_ENCONTRADOS, false);
            }
            Long tiempoMinutosValidezParametro = parametrosSistemaOpt.get().getTiempoMinutosValidezCodigoActivacionContrasena();
            long tiempoMinutosValidez = (tiempoMinutosValidezParametro==null) ? 0L : tiempoMinutosValidezParametro;
            Date fechaHMSExpiracion = new Date(System.currentTimeMillis() + (tiempoMinutosValidez * 60L * 1000L));
            
            //SE BORRAN LAS RECUPERACIONES ANTERIORES DEL USUARIO PARA QUE SOLO QUEDE VIGENTE EL ÚLTIMO CÓDIGO:
            vaciarRecuperacionesContrasenasAccesosUsuariosporIdUsuario(usuario.getIdUsuario());
            
            //SE GENERA EL CÓDIGO DE 6 DÍGITOS Y SE GUARDA LA RECUPERACIÓN (SE REINTENTA SI EL CÓDIGO YA EXISTIERA):
            boolean recuperacionGuardada = false;
            for (int intento = 0; (intento < 5)&&(!recuperacionGuardada); intento++) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setIdUsuario(usuario.getIdUsuario());
                RecuperacionContrasenaAccesoUsuarioDTO recuperacionDTO = new RecuperacionContrasenaAccesoUsuarioDTO();
                recuperacionDTO.setUsuarioDTO(usuarioDTO);
                recuperacionDTO.setCodigoActivacionContrasenaAccesoUsuario(generarCodigoActivacion());
                recuperacionDTO.setFechaHMSExpCodActivContrasenaAccesoUsuario(fechaHMSExpiracion);
                recuperacionDTO.setEstadoUsoCodigoActivacionContrasenaAccesoUsuario("PENDIENTE DE USO");
                recuperacionGuardada = crearRecuperacionContrasenaAccesoUsuario(recuperacionDTO).isBanderaexito();
            }
            if (!recuperacionGuardada) {
               return new RespuestaDTO(MensajesConstantes.MSG_CODIGO_ACTIVACION_NO_ENVIADO, false);
            }
            
            //EL CORREO SE DELEGA A EmailServiceImpl SOLO CON EL ID DEL USUARIO Y EL MEDIO DE ENVÍO:
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setIdUsuario(usuario.getIdUsuario());
            emailDTO.setMedioEnvio(medioEnvio);
            RespuestaDTO respuestaEnvio = emailService.enviarCorreoElectronico(emailDTO);
            if (!respuestaEnvio.isBanderaexito()) {
               //SI EL CORREO NO SALIÓ, EL CÓDIGO NO SIRVE: SE BORRA PARA QUE NO QUEDE UNA RECUPERACIÓN HUÉRFANA.
               vaciarRecuperacionesContrasenasAccesosUsuariosporIdUsuario(usuario.getIdUsuario());
               return new RespuestaDTO(MensajesConstantes.MSG_CODIGO_ACTIVACION_NO_ENVIADO, false);
            }
            return new RespuestaDTO(MensajesConstantes.MSG_CODIGO_ACTIVACION_ENVIADO_EXITO, true);
        } catch (Exception e) {
            return new RespuestaDTO(MensajesConstantes.MSG_CODIGO_ACTIVACION_NO_ENVIADO, false);
        }
    }
    
    //CÓDIGO DE ACTIVACIÓN DE 6 DÍGITOS NUMÉRICOS (MISMO FORMATO DE LOS PROYECTOS DE REFERENCIA), CON GENERADOR SEGURO:
    private String generarCodigoActivacion() {
        StringBuilder codigo = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            codigo.append(GENERADOR_ALEATORIO_SEGURO.nextInt(10));
        }
        return codigo.toString();
    }
}
