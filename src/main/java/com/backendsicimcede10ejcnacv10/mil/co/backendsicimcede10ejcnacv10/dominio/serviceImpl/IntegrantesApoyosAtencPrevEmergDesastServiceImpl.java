//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesApoyosAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.IntegrantesApoyosAtencPrevEmergDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.IntegrantesApoyosAtencPrevEmergDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesApoyosAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.IntegrantesApoyosAtencPrevEmergDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class IntegrantesApoyosAtencPrevEmergDesastServiceImpl implements IntegrantesApoyosAtencPrevEmergDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private IntegrantesApoyosAtencPrevEmergDesastDAO integrantesApoyosAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private IntegrantesApoyosAtencPrevEmergDesastRepository integrantesApoyosAtencPrevEmergDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idIntegrantesApoyosAtencPrevEmergDesast, Long idApoyoAtencPrevEmergDesast, String gradoJefeGestionRiesgoUnidadMilitar, String nombresJefeGestionRiesgoUnidadMilitar, String primerApellidoJefeGestionRiesgoUnidadMilitar, String segundoApellidoJefeGestionRiesgoUnidadMilitar, String cargoJefeGestionRiesgoUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword) {
        return integrantesApoyosAtencPrevEmergDesastRepository.findTotalRegistros(idIntegrantesApoyosAtencPrevEmergDesast, idApoyoAtencPrevEmergDesast, gradoJefeGestionRiesgoUnidadMilitar, nombresJefeGestionRiesgoUnidadMilitar, primerApellidoJefeGestionRiesgoUnidadMilitar, segundoApellidoJefeGestionRiesgoUnidadMilitar, cargoJefeGestionRiesgoUnidadMilitar, gradoJefeOperacionesUnidadMilitar, nombresJefeOperacionesUnidadMilitar, primerApellidoJefeOperacionesUnidadMilitar, segundoApellidoJefeOperacionesUnidadMilitar, cargoJefeOperacionesUnidadMilitar, gradoCteUnidadMilitar, nombresCteUnidadMilitar, primerApellidoCteUnidadMilitar, segundoApellidoCteUnidadMilitar, cargoCteUnidadMilitar, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<IntegrantesApoyosAtencPrevEmergDesastDTO> listarIntegrantesApoyosAtencPrevEmergDesast(Long idIntegrantesApoyosAtencPrevEmergDesast, Long idApoyoAtencPrevEmergDesast, String gradoJefeGestionRiesgoUnidadMilitar, String nombresJefeGestionRiesgoUnidadMilitar, String primerApellidoJefeGestionRiesgoUnidadMilitar, String segundoApellidoJefeGestionRiesgoUnidadMilitar, String cargoJefeGestionRiesgoUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword, String orderBy, String orderMode) {
        List<IntegrantesApoyosAtencPrevEmergDesast> integrantesApoyosAtencPrevEmergDesast = integrantesApoyosAtencPrevEmergDesastRepository.findAllIntegrantesApoyosAtencPrevEmergDesast(idIntegrantesApoyosAtencPrevEmergDesast, idApoyoAtencPrevEmergDesast, gradoJefeGestionRiesgoUnidadMilitar, nombresJefeGestionRiesgoUnidadMilitar, primerApellidoJefeGestionRiesgoUnidadMilitar, segundoApellidoJefeGestionRiesgoUnidadMilitar, cargoJefeGestionRiesgoUnidadMilitar, gradoJefeOperacionesUnidadMilitar, nombresJefeOperacionesUnidadMilitar, primerApellidoJefeOperacionesUnidadMilitar, segundoApellidoJefeOperacionesUnidadMilitar, cargoJefeOperacionesUnidadMilitar, gradoCteUnidadMilitar, nombresCteUnidadMilitar, primerApellidoCteUnidadMilitar, segundoApellidoCteUnidadMilitar, cargoCteUnidadMilitar, keyword, orderBy, orderMode);
        List<IntegrantesApoyosAtencPrevEmergDesastDTO> integrantesApoyosAtencPrevEmergDesastDTOS = new ArrayList<>();
        for (IntegrantesApoyosAtencPrevEmergDesast integrantesApoyosAtencPrevEmergDesastItem : integrantesApoyosAtencPrevEmergDesast) {
            integrantesApoyosAtencPrevEmergDesastDTOS.add(integrantesApoyosAtencPrevEmergDesastDAO.integrantesApoyosAtencPrevEmergDesastDTO(integrantesApoyosAtencPrevEmergDesastItem));
        }
        
        return integrantesApoyosAtencPrevEmergDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<IntegrantesApoyosAtencPrevEmergDesastDTO> listarIntegrantesApoyosAtencPrevEmergDesastPag(Pageable pageable, Long idIntegrantesApoyosAtencPrevEmergDesast, Long idApoyoAtencPrevEmergDesast, String gradoJefeGestionRiesgoUnidadMilitar, String nombresJefeGestionRiesgoUnidadMilitar, String primerApellidoJefeGestionRiesgoUnidadMilitar, String segundoApellidoJefeGestionRiesgoUnidadMilitar, String cargoJefeGestionRiesgoUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword, String orderBy, String orderMode) {
        Slice<IntegrantesApoyosAtencPrevEmergDesast> integrantesApoyosAtencPrevEmergDesast = integrantesApoyosAtencPrevEmergDesastRepository.findAllIntegrantesApoyosAtencPrevEmergDesastPag(pageable, idIntegrantesApoyosAtencPrevEmergDesast, idApoyoAtencPrevEmergDesast, gradoJefeGestionRiesgoUnidadMilitar, nombresJefeGestionRiesgoUnidadMilitar, primerApellidoJefeGestionRiesgoUnidadMilitar, segundoApellidoJefeGestionRiesgoUnidadMilitar, cargoJefeGestionRiesgoUnidadMilitar, gradoJefeOperacionesUnidadMilitar, nombresJefeOperacionesUnidadMilitar, primerApellidoJefeOperacionesUnidadMilitar, segundoApellidoJefeOperacionesUnidadMilitar, cargoJefeOperacionesUnidadMilitar, gradoCteUnidadMilitar, nombresCteUnidadMilitar, primerApellidoCteUnidadMilitar, segundoApellidoCteUnidadMilitar, cargoCteUnidadMilitar, keyword, orderBy, orderMode);
        return integrantesApoyosAtencPrevEmergDesast.map(integrantesApoyosAtencPrevEmergDesastItem -> integrantesApoyosAtencPrevEmergDesastDAO.integrantesApoyosAtencPrevEmergDesastDTO(integrantesApoyosAtencPrevEmergDesastItem));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearIntegrantesApoyosAtencPrevEmergDesast(IntegrantesApoyosAtencPrevEmergDesastDTO integrantesApoyosAtencPrevEmergDesastDTO) {
        Long maxIdIntegrantesApoyosAtencPrevEmergDesast = null;
        IntegrantesApoyosAtencPrevEmergDesast integrantesExistentesEnApoyoAtencPrevEmergDesast = integrantesApoyosAtencPrevEmergDesastRepository.findByApoyoAtencPrevEmergDesastId(integrantesApoyosAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(integrantesExistentesEnApoyoAtencPrevEmergDesast == null)) {//SI YA EXISTE UN REGISTRO DE INTEGRANTES PARA EL MISMO APOYO ATENC PREV EMERG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE INTEGRANTES PARA EL MISMO APOYO ATENC PREV EMERG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_INTEGRANTES_YA_EXISTE_EN_APOYO_ATENC_PREV_EMERG_DESAST, false);
           respuestaDTO.setIntegrantesApoyosAtencPrevEmergDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE INTEGRANTES PARA EL MISMO APOYO ATENC PREV EMERG DESAST SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdIntegrantesApoyosAtencPrevEmergDesast = integrantesApoyosAtencPrevEmergDesastRepository.findMaxIdIntegrantesApoyosAtencPrevEmergDesast();
           if (maxIdIntegrantesApoyosAtencPrevEmergDesast == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdIntegrantesApoyosAtencPrevEmergDesast = Long.valueOf(0);
           }
           integrantesApoyosAtencPrevEmergDesastDTO.setIdIntegrantesApoyosAtencPrevEmergDesast(maxIdIntegrantesApoyosAtencPrevEmergDesast + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           integrantesApoyosAtencPrevEmergDesastRepository.save(integrantesApoyosAtencPrevEmergDesastDAO.integrantesApoyosAtencPrevEmergDesast(integrantesApoyosAtencPrevEmergDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarIntegrantesApoyosAtencPrevEmergDesastporId(Long idIntegrantesApoyosAtencPrevEmergDesast) {
        Optional<IntegrantesApoyosAtencPrevEmergDesast> integrantesApoyosAtencPrevEmergDesastId = integrantesApoyosAtencPrevEmergDesastRepository.findByIdIntegrantesApoyosAtencPrevEmergDesast(Long.valueOf(idIntegrantesApoyosAtencPrevEmergDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (integrantesApoyosAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setIntegrantesApoyosAtencPrevEmergDesastDTO(integrantesApoyosAtencPrevEmergDesastDAO.integrantesApoyosAtencPrevEmergDesastDTO(integrantesApoyosAtencPrevEmergDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (integrantesApoyosAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setIntegrantesApoyosAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarIntegrantesApoyosAtencPrevEmergDesast(IntegrantesApoyosAtencPrevEmergDesastDTO integrantesApoyosAtencPrevEmergDesastDTO) {
        Optional<IntegrantesApoyosAtencPrevEmergDesast> integrantesApoyosAtencPrevEmergDesastId = integrantesApoyosAtencPrevEmergDesastRepository.findByIdIntegrantesApoyosAtencPrevEmergDesast(integrantesApoyosAtencPrevEmergDesastDTO.getIdIntegrantesApoyosAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (integrantesApoyosAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           integrantesApoyosAtencPrevEmergDesastRepository.save(integrantesApoyosAtencPrevEmergDesastDAO.integrantesApoyosAtencPrevEmergDesast(integrantesApoyosAtencPrevEmergDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (integrantesApoyosAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setIntegrantesApoyosAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarIntegrantesApoyosAtencPrevEmergDesast(Long idIntegrantesApoyosAtencPrevEmergDesast) {
        Optional<IntegrantesApoyosAtencPrevEmergDesast> integrantesApoyosAtencPrevEmergDesastId = integrantesApoyosAtencPrevEmergDesastRepository.findById(idIntegrantesApoyosAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (integrantesApoyosAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setIntegrantesApoyosAtencPrevEmergDesastDTO(integrantesApoyosAtencPrevEmergDesastDAO.integrantesApoyosAtencPrevEmergDesastDTO(integrantesApoyosAtencPrevEmergDesastId.get()));
           integrantesApoyosAtencPrevEmergDesastRepository.delete(integrantesApoyosAtencPrevEmergDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (integrantesApoyosAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setIntegrantesApoyosAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
