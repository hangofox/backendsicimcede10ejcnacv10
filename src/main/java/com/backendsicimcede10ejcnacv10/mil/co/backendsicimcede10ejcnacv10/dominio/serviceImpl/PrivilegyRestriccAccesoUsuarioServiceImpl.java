//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PrivilegyRestriccAccesoUsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.PrivilegyRestriccAccesoUsuarioService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.PrivilegyRestriccAccesoUsuarioDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PrivilegyRestriccAccesoUsuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.PrivilegyRestriccAccesoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class PrivilegyRestriccAccesoUsuarioServiceImpl implements PrivilegyRestriccAccesoUsuarioService {
    
    @Autowired//INYECTAMOS EL DAO.
    private PrivilegyRestriccAccesoUsuarioDAO privilegyRestriccAccesoUsuarioDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private PrivilegyRestriccAccesoUsuarioRepository privilegyRestriccAccesoUsuarioRepository;
    
    //CONTROLADORES DE CRUDS (CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO).
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idPrivilegioyRestriccionAccesoUsuario, String keyword, Long idFuncionalidad, String nombreFuncionalidad, Long idRol, String nombreRol, String siglaoAcronimoUnidadMilitar, Long idUsuario) {
        return privilegyRestriccAccesoUsuarioRepository.findTotalRegistros(idPrivilegioyRestriccionAccesoUsuario, keyword, idFuncionalidad, nombreFuncionalidad, idRol, nombreRol, siglaoAcronimoUnidadMilitar, idUsuario);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<PrivilegyRestriccAccesoUsuarioDTO> listarPrivilegyRestriccAccesosUsuarios(Long idPrivilegioyRestriccionAccesoUsuario, String keyword, Long idFuncionalidad, String nombreFuncionalidad, Long idRol, String nombreRol, String siglaoAcronimoUnidadMilitar, Long idUsuario, String orderBy, String orderMode) {
        List<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesosUsuarios = privilegyRestriccAccesoUsuarioRepository.findAllPrivilegyRestriccAccesosUsuarios(idPrivilegioyRestriccionAccesoUsuario, keyword, idFuncionalidad, nombreFuncionalidad, idRol, nombreRol, siglaoAcronimoUnidadMilitar, idUsuario, orderBy, orderMode);
        List<PrivilegyRestriccAccesoUsuarioDTO> privilegyRestriccAccesoUsuarioDTOS = new ArrayList<>();
        for (PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuario : privilegyRestriccAccesosUsuarios) {
            privilegyRestriccAccesoUsuarioDTOS.add(privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuario));
        }
        
        return privilegyRestriccAccesoUsuarioDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<PrivilegyRestriccAccesoUsuarioDTO> listarPrivilegyRestriccAccesosUsuariosPag(Pageable pageable, Long idPrivilegioyRestriccionAccesoUsuario, String keyword, Long idFuncionalidad, String nombreFuncionalidad, Long idRol, String nombreRol, String siglaoAcronimoUnidadMilitar, Long idUsuario, String orderBy, String orderMode) {
        Slice<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesosUsuarios = privilegyRestriccAccesoUsuarioRepository.findAllPrivilegyRestriccAccesosUsuariosPag(pageable, idPrivilegioyRestriccionAccesoUsuario, keyword, idFuncionalidad, nombreFuncionalidad, idRol, nombreRol, siglaoAcronimoUnidadMilitar, idUsuario, orderBy, orderMode);
        return privilegyRestriccAccesosUsuarios.map(privilegyRestriccAccesoUsuario -> privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuario));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearPrivilegyRestriccAccesoUsuario(PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO) {
        Long maxIdPrivilegioyRestriccionAccesoUsuario=null;
        PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol = privilegyRestriccAccesoUsuarioRepository.findBySAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol(privilegyRestriccAccesoUsuarioDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar(), privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario(), privilegyRestriccAccesoUsuarioDTO.getFuncionalidadDTO().getNombreFuncionalidad(), privilegyRestriccAccesoUsuarioDTO.getRolDTO().getNombreRol());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaPrivilegyRestriccRegistroEncontrado=0;
        
        if (!(privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol==null)) {//SI ENCONTRO LA SIGLA O ACRÓNIMO, ID Y NOMBRES DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE PRIVILEGIO Y RESTRICCIÓN DE REGISTRO REPETIDO CON LA SIGLA O ACRÓNIMO, ID Y NOMBRES PROPORCIONADOS.
           banderaPrivilegyRestriccRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaPrivilegyRestriccRegistroEncontrado==1) {//SI ENCONTRO LA SIGLA O ACRÓNIMO, ID Y NOMBRES DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE PRIVILEGIO Y RESTRICCIÓN DE REGISTRO REPETIDO CON LA SIGLA O ACRÓNIMO, ID Y NOMBRES PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PRIVILEGIO_Y_RESTRICCION_YA_EXISTEN, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        if ((banderaPrivilegyRestriccRegistroEncontrado==0) ) {//SI ENCONTRO LA SIGLA O ACRÓNIMO, ID Y NOMBRES DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE PRIVILEGIO Y RESTRICCIÓN DE REGISTRO REPETIDO CON LA SIGLA O ACRÓNIMO, ID Y NOMBRES PROPORCIONADOS.
           maxIdPrivilegioyRestriccionAccesoUsuario = privilegyRestriccAccesoUsuarioRepository.findMaxIdPrivilegioyRestriccionAccesoUsuario();
           if (maxIdPrivilegioyRestriccionAccesoUsuario==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdPrivilegioyRestriccionAccesoUsuario=Long.valueOf(0);
           }
           privilegyRestriccAccesoUsuarioDTO.setIdPrivilegioyRestriccionAccesoUsuario(maxIdPrivilegioyRestriccionAccesoUsuario+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL PRIVILEGIO Y RESTRICCIÓN COMBINANDO LA CADENA "PRIVYREST" CON LA ID DE LA LLAVE PRIMARIA, LA CADENA "_", ID DEL USUARIO Y LA FECHA Y HORA (AÑO, MES Y DÍA) ACTUAL DEL SERVIDOR EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSPrivilegioyRestriccionAccesoUsuarioinIntermedios = objetoFechaHMS.format(privilegyRestriccAccesoUsuarioDTO.getFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario());
           privilegyRestriccAccesoUsuarioDTO.setNumeroRegistroPrivilegioyRestriccionAccesoUsuario("PRIVYREST" + (maxIdPrivilegioyRestriccionAccesoUsuario+1) + "_" + privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario() + fechaHMSPrivilegioyRestriccionAccesoUsuarioinIntermedios);
           
           privilegyRestriccAccesoUsuarioRepository.save(privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuario(privilegyRestriccAccesoUsuarioDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //CREAR REGISTROS MÚLTIPLES:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTROS MÚLTIPLES.
    public RespuestaDTO crearPrivilegyRestriccAccesosUsuarios(List<PrivilegyRestriccAccesoUsuarioDTO> privilegyRestriccAccesoUsuarioDTOS) {
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_CREADOS, false);
        
        if ((!(privilegyRestriccAccesoUsuarioDTOS==null))&&(!(privilegyRestriccAccesoUsuarioDTOS.isEmpty()==true))) {//SI ENCONTRO LOS OBJETOS DE LOS REGISTROS EN LA TABLA DE LA BASE DE DATOS MUESTRA LOS REGISTROS CON UN MENSAJE DE REGISTROS CREADOS EXITOSAMENTE.
           //DECLARACION DE LAS VARIABLES:
           Long maxIdPrivilegioyRestriccionAccesoUsuario = Long.valueOf(0);
           for (PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO : privilegyRestriccAccesoUsuarioDTOS) {
               maxIdPrivilegioyRestriccionAccesoUsuario = privilegyRestriccAccesoUsuarioRepository.findMaxIdPrivilegioyRestriccionAccesoUsuario();
               if (maxIdPrivilegioyRestriccionAccesoUsuario == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
                  maxIdPrivilegioyRestriccionAccesoUsuario = Long.valueOf(0);
               }
               privilegyRestriccAccesoUsuarioDTO.setIdPrivilegioyRestriccionAccesoUsuario(maxIdPrivilegioyRestriccionAccesoUsuario+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
               
               //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL PRIVILEGIO Y RESTRICCIÓN COMBINANDO LA CADENA "PRIVYREST" CON LA ID DE LA LLAVE PRIMARIA, LA CADENA "_", ID DEL USUARIO Y LA FECHA Y HORA (AÑO, MES Y DÍA) ACTUAL DEL SERVIDOR EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
               SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
               String fechaHMSPrivilegioyRestriccionAccesoUsuarioinIntermedios = objetoFechaHMS.format(privilegyRestriccAccesoUsuarioDTO.getFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario());
               privilegyRestriccAccesoUsuarioDTO.setNumeroRegistroPrivilegioyRestriccionAccesoUsuario("PRIVYREST" + (maxIdPrivilegioyRestriccionAccesoUsuario+1) + "_" + privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario() + fechaHMSPrivilegioyRestriccionAccesoUsuarioinIntermedios);
               
               privilegyRestriccAccesoUsuarioRepository.save(privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuario(privilegyRestriccAccesoUsuarioDTO));
           }
           
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_CREADOS_EXITO, true);
        }
        if ((privilegyRestriccAccesoUsuarioDTOS==null)||(privilegyRestriccAccesoUsuarioDTOS.isEmpty()==true)) {//SI NO ENCONTRO LOS OBJETOS DE LOS REGISTROS EN LA TABLA DE LA BASE DE DATOS MUESTRA LOS REGISTROS CON UN MENSAJE DE REGISTROS NO CREADOS EXITOSAMENTE.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_CREADOS, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarPrivilegyRestriccAccesoUsuarioporId(Long idPrivilegioyRestriccionAccesoUsuario) {
        Optional<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesoUsuarioId = privilegyRestriccAccesoUsuarioRepository.findByIdPrivilegioyRestriccionAccesoUsuario(Long.valueOf(idPrivilegioyRestriccionAccesoUsuario));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (privilegyRestriccAccesoUsuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (privilegyRestriccAccesoUsuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR LA SIGLA O ACRÓNIMO DE UNIDAD MILITAR, ID DE USUARIO, ID DE FUNCIONALIDAD E ID DE ROL:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarPrivilegyRestriccAccesoUsuarioporSAUnidadMilitareIdUsuarioeIdFuncionalidadeIdRol(String siglaoAcronimoUnidadMilitar, Long idUsuario, Long idFuncionalidad, Long idRol) {
        Optional<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesoUsuarioSAUnidadMilitaAndIdUsuarioAndIdFuncionalidadAndIdRol = Optional.ofNullable(privilegyRestriccAccesoUsuarioRepository.findBySAUnidadMilitarAndIdUsuarioAndIdFuncionalidadAndIdRol(siglaoAcronimoUnidadMilitar, idUsuario, idFuncionalidad, idRol));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PRIVILEGIO_Y_RESTRICCION_NO_ENCONTRADOS, false);
        
        if (privilegyRestriccAccesoUsuarioSAUnidadMilitaAndIdUsuarioAndIdFuncionalidadAndIdRol.isPresent()==true) {//SI ENCONTRO EL PRIVILEGIO Y RESTRICCIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON LA SIGLA O ACRÓNIMO, ID E IDS PROPORCIONADOS.
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioSAUnidadMilitaAndIdUsuarioAndIdFuncionalidadAndIdRol.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (privilegyRestriccAccesoUsuarioSAUnidadMilitaAndIdUsuarioAndIdFuncionalidadAndIdRol.isPresent()==false) {//SI NO ENCONTRO EL PRIVILEGIO Y RESTRICCIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON LA SIGLA O ACRÓNIMO, ID E IDS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PRIVILEGIO_Y_RESTRICCION_NO_ENCONTRADOS, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR LA SIGLA O ACRÓNIMO DE UNIDAD MILITAR, ID DE USUARIO, NOMBRE DE FUNCIONALIDAD Y NOMBRE DE ROL:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarPrivilegyRestriccAccesoUsuarioporSAUnidadMilitareIdUsuarioyNombreFuncionalidadyNombreRol(String siglaoAcronimoUnidadMilitar, Long idUsuario, String nombreFuncionalidad, String nombreRol) {
        Optional<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol = Optional.ofNullable(privilegyRestriccAccesoUsuarioRepository.findBySAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol(siglaoAcronimoUnidadMilitar, idUsuario, nombreFuncionalidad, nombreRol));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PRIVILEGIO_Y_RESTRICCION_NO_ENCONTRADOS, false);
        
        if (privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol.isPresent()==true) {//SI ENCONTRO EL PRIVILEGIO Y RESTRICCIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON LA SIGLA O ACRÓNIMO, ID Y NOMBRES PROPORCIONADOS.
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol.isPresent()==false) {//SI NO ENCONTRO EL PRIVILEGIO Y RESTRICCIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON LA SIGLA O ACRÓNIMO, ID Y NOMBRES PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PRIVILEGIO_Y_RESTRICCION_NO_ENCONTRADOS, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarPrivilegyRestriccAccesoUsuario(PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO) {
        Optional<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesoUsuarioId = privilegyRestriccAccesoUsuarioRepository.findByIdPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuarioDTO.getIdPrivilegioyRestriccionAccesoUsuario());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (privilegyRestriccAccesoUsuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA SIGLA O ACRÓNIMO, ID E IDS DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (privilegyRestriccAccesoUsuarioDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar().equals(privilegyRestriccAccesoUsuarioId.get().getUnidadMilitar().getSiglaoAcronimoUnidadMilitar())==true)&&(privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario().equals(privilegyRestriccAccesoUsuarioId.get().getUsuario().getIdUsuario())==true)&&(privilegyRestriccAccesoUsuarioDTO.getFuncionalidadDTO().getNombreFuncionalidad().equals(privilegyRestriccAccesoUsuarioId.get().getFuncionalidad().getNombreFuncionalidad())==true)&&(privilegyRestriccAccesoUsuarioDTO.getRolDTO().getNombreRol().equals(privilegyRestriccAccesoUsuarioId.get().getRol().getNombreRol())==true) ) {//SI LA SIGLA O ACRÓNIMO, ID Y NOMBRES DIGITADOS ES IGUAL A LA SIGLA O ACRÓNIMO, ID Y NOMBRES ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuario = privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuario(privilegyRestriccAccesoUsuarioDTO);
              privilegyRestriccAccesoUsuarioRepository.save(privilegyRestriccAccesoUsuario);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
            if ( (privilegyRestriccAccesoUsuarioDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar().equals(privilegyRestriccAccesoUsuarioId.get().getUnidadMilitar().getSiglaoAcronimoUnidadMilitar())==false)||(privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario().equals(privilegyRestriccAccesoUsuarioId.get().getUsuario().getIdUsuario())==false)||(privilegyRestriccAccesoUsuarioDTO.getFuncionalidadDTO().getNombreFuncionalidad().equals(privilegyRestriccAccesoUsuarioId.get().getFuncionalidad().getNombreFuncionalidad())==false)||(privilegyRestriccAccesoUsuarioDTO.getRolDTO().getNombreRol().equals(privilegyRestriccAccesoUsuarioId.get().getRol().getNombreRol())==false) ) {//SI LA SIGLA O ACRÓNIMO, ID Y NOMBRES DIGITADOS ES DIFERENTE A LA SIGLA O ACRÓNIMO, ID Y NOMBRES ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTA SIGLA O ACRÓNIMO, ID Y NOMBRES DIGITADOS EXISTEN EN OTROS REGISTROS.
              //consulte por sigla o acrónimo, id y nombres e imprima si existen y si no existen
              PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol = privilegyRestriccAccesoUsuarioRepository.findBySAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol(privilegyRestriccAccesoUsuarioDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar(), privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario(), privilegyRestriccAccesoUsuarioDTO.getFuncionalidadDTO().getNombreFuncionalidad(), privilegyRestriccAccesoUsuarioDTO.getRolDTO().getNombreRol());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaSAUnidadMilitarIdUsuarioNombreFuncionalidadNombreRolRegistroEncontrado=0;
              
              if (!(privilegyRestriccAccesoUsuarioSAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol==null)) {//SI ENCONTRO LA SIGLA O ACRÓNIMO, ID Y NOMBRES DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE LA SIGLA O ACRÓNIMO, ID Y NOMBRES DE REGISTRO REPETIDO CON LA SIGLA O ACRÓNIMO, ID Y NOMBRES PROPORCIONADO.
                 banderaSAUnidadMilitarIdUsuarioNombreFuncionalidadNombreRolRegistroEncontrado=1;
              }
              
              if (banderaSAUnidadMilitarIdUsuarioNombreFuncionalidadNombreRolRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE LA SIGLA O ACRÓNIMO, ID Y NOMBRES DIGITADOS Y BUSCADOS SON DIFERENTES DE NULO SIGNIFICA QUE ENCONTRO LA MISMA SIGLA O ACRÓNIMO, ID Y NOMBRES ALMACENADOS EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL Y MUESTRA UN MENSAJE DE SIGLA O ACRÓNIMO, ID Y NOMBRES DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PRIVILEGIO_Y_RESTRICCION_YA_EXISTEN, false);
                 respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
              }
              if (banderaSAUnidadMilitarIdUsuarioNombreFuncionalidadNombreRolRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE LA SIGLA O ACRÓNIMO, ID Y NOMBRES DIGITADOS Y BUSCADOS SON NULOS EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuario = privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuario(privilegyRestriccAccesoUsuarioDTO);
                 privilegyRestriccAccesoUsuarioRepository.save(privilegyRestriccAccesoUsuario);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (privilegyRestriccAccesoUsuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarPrivilegyRestriccAccesoUsuario(Long idPrivilegioyRestriccionAccesoUsuario) {
        Optional<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesoUsuarioId = privilegyRestriccAccesoUsuarioRepository.findById(idPrivilegioyRestriccionAccesoUsuario);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (privilegyRestriccAccesoUsuarioId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioDAO.privilegyRestriccAccesoUsuarioDTO(privilegyRestriccAccesoUsuarioId.get()));
           privilegyRestriccAccesoUsuarioRepository.delete(privilegyRestriccAccesoUsuarioId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (privilegyRestriccAccesoUsuarioId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //VACIAR REGISTROS A NIVEL GENERAL POR ID DE USUARIO:
    @Override//SOBREESCRIBIMOS EL METODO DE VACIAR REGISTROS.
    public RespuestaDTO vaciarPrivilegyRestriccAccesosUsuariosNivelGeneralporIdUsuario(Long idUsuario) {
        List<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesosUsuarios = privilegyRestriccAccesoUsuarioRepository.findAllPrivilegyRestriccAccesosUsuarios(null, null, null, null, null, null, null, idUsuario, null, null);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_VACIADOS, false);
        
        if ( (privilegyRestriccAccesosUsuarios==null)||(privilegyRestriccAccesosUsuarios.isEmpty()==false) ) {//EN CASO DE QUE LA LISTA CONTENGA DATOS.
           privilegyRestriccAccesoUsuarioRepository.deletePrivilegyRestriccAccesosUsuariosNivelGeneralByIdUsuario(idUsuario);
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_VACIADOS_EXITO, true);
        }
        if ( (privilegyRestriccAccesosUsuarios==null)||(privilegyRestriccAccesosUsuarios.isEmpty()==true) ) {//EN CASO DE QUE LA LISTA ESTE VACIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_VACIADOS, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //VACIAR REGISTROS EN UNIDAD MILITAR POR ID DE USUARIO Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE VACIAR REGISTROS.
    public RespuestaDTO vaciarPrivilegyRestriccAccesosUsuariosUnidadMilitarporIdUsuarioySAUnidadMilitar(Long idUsuario, String siglaoAcronimoUnidadMilitar) {
        List<PrivilegyRestriccAccesoUsuario> privilegyRestriccAccesosUsuarios = privilegyRestriccAccesoUsuarioRepository.findAllPrivilegyRestriccAccesosUsuarios(null, null, null, null, null, null, siglaoAcronimoUnidadMilitar, idUsuario, null, null);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_VACIADOS, false);
        
        if ( (privilegyRestriccAccesosUsuarios==null)||(privilegyRestriccAccesosUsuarios.isEmpty()==false) ) {//EN CASO DE QUE LA LISTA CONTENGA DATOS.
           privilegyRestriccAccesoUsuarioRepository.deletePrivilegyRestriccAccesosUsuariosUnidadMilitarByIdUsuarioAndSAUnidadMilitar(idUsuario, siglaoAcronimoUnidadMilitar);
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_VACIADOS_EXITO, true);
        }
        if ( (privilegyRestriccAccesosUsuarios==null)||(privilegyRestriccAccesosUsuarios.isEmpty()==true) ) {//EN CASO DE QUE LA LISTA ESTE VACIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTROS_NO_VACIADOS, false);
           respuestaDTO.setPrivilegyRestriccAccesoUsuarioDTO(null);
        }
        
        return respuestaDTO;
    }
}
