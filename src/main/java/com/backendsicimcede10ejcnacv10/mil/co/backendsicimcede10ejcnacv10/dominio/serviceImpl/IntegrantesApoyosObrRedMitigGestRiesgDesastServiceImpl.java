//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesApoyosObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.IntegrantesApoyosObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.IntegrantesApoyosObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesApoyosObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.IntegrantesApoyosObrRedMitigGestRiesgDesastRepository;
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
public class IntegrantesApoyosObrRedMitigGestRiesgDesastServiceImpl implements IntegrantesApoyosObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private IntegrantesApoyosObrRedMitigGestRiesgDesastDAO integrantesApoyosObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private IntegrantesApoyosObrRedMitigGestRiesgDesastRepository integrantesApoyosObrRedMitigGestRiesgDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String gradoJefeSeccionTecnicaUnidadMilitar, String nombresJefeSeccionTecnicaUnidadMilitar, String primerApellidoJefeSeccionTecnicaUnidadMilitar, String segundoApellidoJefeSeccionTecnicaUnidadMilitar, String cargoJefeSeccionTecnicaUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword) {
        return integrantesApoyosObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idIntegrantesApoyosObrRedMitigGestRiesgDesast, idApoyoObrRedMitigGestRiesgDesast, gradoJefeSeccionTecnicaUnidadMilitar, nombresJefeSeccionTecnicaUnidadMilitar, primerApellidoJefeSeccionTecnicaUnidadMilitar, segundoApellidoJefeSeccionTecnicaUnidadMilitar, cargoJefeSeccionTecnicaUnidadMilitar, gradoJefeOperacionesUnidadMilitar, nombresJefeOperacionesUnidadMilitar, primerApellidoJefeOperacionesUnidadMilitar, segundoApellidoJefeOperacionesUnidadMilitar, cargoJefeOperacionesUnidadMilitar, gradoCteUnidadMilitar, nombresCteUnidadMilitar, primerApellidoCteUnidadMilitar, segundoApellidoCteUnidadMilitar, cargoCteUnidadMilitar, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<IntegrantesApoyosObrRedMitigGestRiesgDesastDTO> listarIntegrantesApoyosObrRedMitigGestRiesgDesast(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String gradoJefeSeccionTecnicaUnidadMilitar, String nombresJefeSeccionTecnicaUnidadMilitar, String primerApellidoJefeSeccionTecnicaUnidadMilitar, String segundoApellidoJefeSeccionTecnicaUnidadMilitar, String cargoJefeSeccionTecnicaUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword, String orderBy, String orderMode) {
        List<IntegrantesApoyosObrRedMitigGestRiesgDesast> integrantesApoyosObrRedMitigGestRiesgDesast = integrantesApoyosObrRedMitigGestRiesgDesastRepository.findAllIntegrantesApoyosObrRedMitigGestRiesgDesast(idIntegrantesApoyosObrRedMitigGestRiesgDesast, idApoyoObrRedMitigGestRiesgDesast, gradoJefeSeccionTecnicaUnidadMilitar, nombresJefeSeccionTecnicaUnidadMilitar, primerApellidoJefeSeccionTecnicaUnidadMilitar, segundoApellidoJefeSeccionTecnicaUnidadMilitar, cargoJefeSeccionTecnicaUnidadMilitar, gradoJefeOperacionesUnidadMilitar, nombresJefeOperacionesUnidadMilitar, primerApellidoJefeOperacionesUnidadMilitar, segundoApellidoJefeOperacionesUnidadMilitar, cargoJefeOperacionesUnidadMilitar, gradoCteUnidadMilitar, nombresCteUnidadMilitar, primerApellidoCteUnidadMilitar, segundoApellidoCteUnidadMilitar, cargoCteUnidadMilitar, keyword, orderBy, orderMode);
        List<IntegrantesApoyosObrRedMitigGestRiesgDesastDTO> integrantesApoyosObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        for (IntegrantesApoyosObrRedMitigGestRiesgDesast integrantesApoyosObrRedMitigGestRiesgDesastItem : integrantesApoyosObrRedMitigGestRiesgDesast) {
            integrantesApoyosObrRedMitigGestRiesgDesastDTOS.add(integrantesApoyosObrRedMitigGestRiesgDesastDAO.integrantesApoyosObrRedMitigGestRiesgDesastDTO(integrantesApoyosObrRedMitigGestRiesgDesastItem));
        }
        
        return integrantesApoyosObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<IntegrantesApoyosObrRedMitigGestRiesgDesastDTO> listarIntegrantesApoyosObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idIntegrantesApoyosObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String gradoJefeSeccionTecnicaUnidadMilitar, String nombresJefeSeccionTecnicaUnidadMilitar, String primerApellidoJefeSeccionTecnicaUnidadMilitar, String segundoApellidoJefeSeccionTecnicaUnidadMilitar, String cargoJefeSeccionTecnicaUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword, String orderBy, String orderMode) {
        Slice<IntegrantesApoyosObrRedMitigGestRiesgDesast> integrantesApoyosObrRedMitigGestRiesgDesast = integrantesApoyosObrRedMitigGestRiesgDesastRepository.findAllIntegrantesApoyosObrRedMitigGestRiesgDesastPag(pageable, idIntegrantesApoyosObrRedMitigGestRiesgDesast, idApoyoObrRedMitigGestRiesgDesast, gradoJefeSeccionTecnicaUnidadMilitar, nombresJefeSeccionTecnicaUnidadMilitar, primerApellidoJefeSeccionTecnicaUnidadMilitar, segundoApellidoJefeSeccionTecnicaUnidadMilitar, cargoJefeSeccionTecnicaUnidadMilitar, gradoJefeOperacionesUnidadMilitar, nombresJefeOperacionesUnidadMilitar, primerApellidoJefeOperacionesUnidadMilitar, segundoApellidoJefeOperacionesUnidadMilitar, cargoJefeOperacionesUnidadMilitar, gradoCteUnidadMilitar, nombresCteUnidadMilitar, primerApellidoCteUnidadMilitar, segundoApellidoCteUnidadMilitar, cargoCteUnidadMilitar, keyword, orderBy, orderMode);
        return integrantesApoyosObrRedMitigGestRiesgDesast.map(integrantesApoyosObrRedMitigGestRiesgDesastItem -> integrantesApoyosObrRedMitigGestRiesgDesastDAO.integrantesApoyosObrRedMitigGestRiesgDesastDTO(integrantesApoyosObrRedMitigGestRiesgDesastItem));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearIntegrantesApoyosObrRedMitigGestRiesgDesast(IntegrantesApoyosObrRedMitigGestRiesgDesastDTO integrantesApoyosObrRedMitigGestRiesgDesastDTO) {
        Long maxIdIntegrantesApoyosObrRedMitigGestRiesgDesast = null;
        IntegrantesApoyosObrRedMitigGestRiesgDesast integrantesExistentesEnApoyoObrRedMitigGestRiesgDesast = integrantesApoyosObrRedMitigGestRiesgDesastRepository.findByApoyoObrRedMitigGestRiesgDesastId(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(integrantesExistentesEnApoyoObrRedMitigGestRiesgDesast == null)) {//SI YA EXISTE UN REGISTRO DE INTEGRANTES PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE INTEGRANTES PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_INTEGRANTES_YA_EXISTE_EN_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST, false);
           respuestaDTO.setIntegrantesApoyosObrRedMitigGestRiesgDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE INTEGRANTES PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdIntegrantesApoyosObrRedMitigGestRiesgDesast = integrantesApoyosObrRedMitigGestRiesgDesastRepository.findMaxIdIntegrantesApoyosObrRedMitigGestRiesgDesast();
           if (maxIdIntegrantesApoyosObrRedMitigGestRiesgDesast == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdIntegrantesApoyosObrRedMitigGestRiesgDesast = Long.valueOf(0);
           }
           integrantesApoyosObrRedMitigGestRiesgDesastDTO.setIdIntegrantesApoyosObrRedMitigGestRiesgDesast(maxIdIntegrantesApoyosObrRedMitigGestRiesgDesast + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           integrantesApoyosObrRedMitigGestRiesgDesastRepository.save(integrantesApoyosObrRedMitigGestRiesgDesastDAO.integrantesApoyosObrRedMitigGestRiesgDesast(integrantesApoyosObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarIntegrantesApoyosObrRedMitigGestRiesgDesastporId(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast) {
        Optional<IntegrantesApoyosObrRedMitigGestRiesgDesast> integrantesApoyosObrRedMitigGestRiesgDesastId = integrantesApoyosObrRedMitigGestRiesgDesastRepository.findByIdIntegrantesApoyosObrRedMitigGestRiesgDesast(Long.valueOf(idIntegrantesApoyosObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (integrantesApoyosObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setIntegrantesApoyosObrRedMitigGestRiesgDesastDTO(integrantesApoyosObrRedMitigGestRiesgDesastDAO.integrantesApoyosObrRedMitigGestRiesgDesastDTO(integrantesApoyosObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (integrantesApoyosObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setIntegrantesApoyosObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarIntegrantesApoyosObrRedMitigGestRiesgDesast(IntegrantesApoyosObrRedMitigGestRiesgDesastDTO integrantesApoyosObrRedMitigGestRiesgDesastDTO) {
        Optional<IntegrantesApoyosObrRedMitigGestRiesgDesast> integrantesApoyosObrRedMitigGestRiesgDesastId = integrantesApoyosObrRedMitigGestRiesgDesastRepository.findByIdIntegrantesApoyosObrRedMitigGestRiesgDesast(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getIdIntegrantesApoyosObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (integrantesApoyosObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           integrantesApoyosObrRedMitigGestRiesgDesastRepository.save(integrantesApoyosObrRedMitigGestRiesgDesastDAO.integrantesApoyosObrRedMitigGestRiesgDesast(integrantesApoyosObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (integrantesApoyosObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setIntegrantesApoyosObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarIntegrantesApoyosObrRedMitigGestRiesgDesast(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast) {
        Optional<IntegrantesApoyosObrRedMitigGestRiesgDesast> integrantesApoyosObrRedMitigGestRiesgDesastId = integrantesApoyosObrRedMitigGestRiesgDesastRepository.findById(idIntegrantesApoyosObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (integrantesApoyosObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setIntegrantesApoyosObrRedMitigGestRiesgDesastDTO(integrantesApoyosObrRedMitigGestRiesgDesastDAO.integrantesApoyosObrRedMitigGestRiesgDesastDTO(integrantesApoyosObrRedMitigGestRiesgDesastId.get()));
           integrantesApoyosObrRedMitigGestRiesgDesastRepository.delete(integrantesApoyosObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (integrantesApoyosObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setIntegrantesApoyosObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
