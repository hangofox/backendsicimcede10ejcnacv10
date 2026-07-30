//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqCdoIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualAdqCdoIngService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualAdqCdoIngDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqCdoIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqCdoIngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProyeccionPlanAnualAdqCdoIngServiceImpl implements ProyeccionPlanAnualAdqCdoIngService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqCdoIngDAO proyeccionPlanAnualAdqCdoIngDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqCdoIngRepository proyeccionPlanAnualAdqCdoIngRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualAdqCdoIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqCdoIng, Long idDestinacionMantenimientoCdoIng, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, Long idInfraestructura, String keyword) {
        return proyeccionPlanAnualAdqCdoIngRepository.findTotalRegistros(idProyeccionPlanAnualAdqCdoIng, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqCdoIng, idDestinacionMantenimientoCdoIng, valorSolicitadoProyeccionPlanAnualAdqCdoIng, idInfraestructura, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualAdqCdoIngDTO> listarProyeccionesPlanesAnualesAdqCdosIng(Long idProyeccionPlanAnualAdqCdoIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqCdoIng, Long idDestinacionMantenimientoCdoIng, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, Long idInfraestructura, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualAdqCdoIng> proyeccionesPlanesAnualesAdqCdosIng = proyeccionPlanAnualAdqCdoIngRepository.findAllProyeccionesPlanesAnualesAdqCdosIng(idProyeccionPlanAnualAdqCdoIng, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqCdoIng, idDestinacionMantenimientoCdoIng, valorSolicitadoProyeccionPlanAnualAdqCdoIng, idInfraestructura, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualAdqCdoIngDTO> proyeccionPlanAnualAdqCdoIngDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIng : proyeccionesPlanesAnualesAdqCdosIng) {
            proyeccionPlanAnualAdqCdoIngDTOS.add(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIngDTO(proyeccionPlanAnualAdqCdoIng));
        }
        
        return proyeccionPlanAnualAdqCdoIngDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualAdqCdoIngDTO> listarProyeccionesPlanesAnualesAdqCdosIngPag(Pageable pageable, Long idProyeccionPlanAnualAdqCdoIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqCdoIng, Long idDestinacionMantenimientoCdoIng, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, Long idInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualAdqCdoIng> proyeccionesPlanesAnualesAdqCdosIng = proyeccionPlanAnualAdqCdoIngRepository.findAllProyeccionesPlanesAnualesAdqCdosIngPag(pageable, idProyeccionPlanAnualAdqCdoIng, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqCdoIng, idDestinacionMantenimientoCdoIng, valorSolicitadoProyeccionPlanAnualAdqCdoIng, idInfraestructura, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesAdqCdosIng.map(proyeccionPlanAnualAdqCdoIng -> proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIngDTO(proyeccionPlanAnualAdqCdoIng));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualAdqCdoIng(ProyeccionPlanAnualAdqCdoIngDTO proyeccionPlanAnualAdqCdoIngDTO) {
        Long maxIdProyeccionPlanAnualAdqCdoIng = null;
        ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIngNombreIdProyeccionPlanAnualAdqGeneralIdDestinacionMantenimientoCdoIngEIdInfraestructura = proyeccionPlanAnualAdqCdoIngRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdDestinacionMantenimientoCdoIngAndIdInfraestructura(proyeccionPlanAnualAdqCdoIngDTO.getNombreProyeccionPlanAnualAdqCdoIng().toUpperCase(), proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO().getIdDestinacionMantenimientoCdoIng(), proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO().getIdInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionPlanAnualAdqCdoIngNombreIdProyeccionPlanAnualAdqGeneralIdDestinacionMantenimientoCdoIngEIdInfraestructura == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL, DESTINACION MANTENIMIENTO CDO ING E INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING_YA_EXISTE_EN_PLAN_ANUAL_ADQ_GENERAL_DESTINACION_MANTENIMIENTO_CDO_ING_E_INFRAESTRUCTURA, false);
           respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionPlanAnualAdqCdoIng = proyeccionPlanAnualAdqCdoIngRepository.findMaxIdProyeccionPlanAnualAdqCdoIng();
           if (maxIdProyeccionPlanAnualAdqCdoIng == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionPlanAnualAdqCdoIng = Long.valueOf(0);
           }
           proyeccionPlanAnualAdqCdoIngDTO.setIdProyeccionPlanAnualAdqCdoIng(maxIdProyeccionPlanAnualAdqCdoIng + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionPlanAnualAdqCdoIngRepository.save(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualAdqCdoIngporId(Long idProyeccionPlanAnualAdqCdoIng) {
        Optional<ProyeccionPlanAnualAdqCdoIng> proyeccionPlanAnualAdqCdoIngId = proyeccionPlanAnualAdqCdoIngRepository.findByIdProyeccionPlanAnualAdqCdoIng(Long.valueOf(idProyeccionPlanAnualAdqCdoIng));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqCdoIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIngDTO(proyeccionPlanAnualAdqCdoIngId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualAdqCdoIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualAdqCdoIng(ProyeccionPlanAnualAdqCdoIngDTO proyeccionPlanAnualAdqCdoIngDTO) {
        Optional<ProyeccionPlanAnualAdqCdoIng> proyeccionPlanAnualAdqCdoIngId = proyeccionPlanAnualAdqCdoIngRepository.findByIdProyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO.getIdProyeccionPlanAnualAdqCdoIng());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualAdqCdoIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ((proyeccionPlanAnualAdqCdoIngDTO.getNombreProyeccionPlanAnualAdqCdoIng().equals(proyeccionPlanAnualAdqCdoIngId.get().getNombreProyeccionPlanAnualAdqCdoIng()) == true)) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI LOS FK CAMBIARON.
              if ((proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqCdoIngId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) && (proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO().getIdDestinacionMantenimientoCdoIng().equals(proyeccionPlanAnualAdqCdoIngId.get().getDestinacionMantenimientoCdoIng().getIdDestinacionMantenimientoCdoIng()) == true) && (proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionPlanAnualAdqCdoIngId.get().getInfraestructura().getIdInfraestructura()) == true)) {//SI EL PLAN ANUAL ADQ GENERAL, DESTINACION MANTENIMIENTO CDO ING E INFRAESTRUCTURA NO CAMBIARON SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAdqCdoIngRepository.save(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (!((proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqCdoIngId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) && (proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO().getIdDestinacionMantenimientoCdoIng().equals(proyeccionPlanAnualAdqCdoIngId.get().getDestinacionMantenimientoCdoIng().getIdDestinacionMantenimientoCdoIng()) == true) && (proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionPlanAnualAdqCdoIngId.get().getInfraestructura().getIdInfraestructura()) == true))) {//SI ALGUNO DE LOS FK CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN LA NUEVA COMBINACION DE FK.
                 ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIngNombreIdProyeccionPlanAnualAdqGeneralIdDestinacionMantenimientoCdoIngEIdInfraestructura = proyeccionPlanAnualAdqCdoIngRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdDestinacionMantenimientoCdoIngAndIdInfraestructura(proyeccionPlanAnualAdqCdoIngDTO.getNombreProyeccionPlanAnualAdqCdoIng().toUpperCase(), proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO().getIdDestinacionMantenimientoCdoIng(), proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO().getIdInfraestructura());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionPlanAnualAdqCdoIngNombreIdProyeccionPlanAnualAdqGeneralIdDestinacionMantenimientoCdoIngEIdInfraestructura == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO CON LA NUEVA COMBINACION DE FK MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCUENTRA EL REGISTRO REPETIDO MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_DESTINACION_MANTENIMIENTO_CDO_ING_E_INFRAESTRUCTURA, false);
                    respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA NO ENCUENTRA REGISTRO REPETIDO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualAdqCdoIngRepository.save(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (proyeccionPlanAnualAdqCdoIngDTO.getNombreProyeccionPlanAnualAdqCdoIng().equals(proyeccionPlanAnualAdqCdoIngId.get().getNombreProyeccionPlanAnualAdqCdoIng()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS CON LA MISMA COMBINACION DE FK.
              ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIngNombreIdProyeccionPlanAnualAdqGeneralIdDestinacionMantenimientoCdoIngEIdInfraestructura = proyeccionPlanAnualAdqCdoIngRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdDestinacionMantenimientoCdoIngAndIdInfraestructura(proyeccionPlanAnualAdqCdoIngDTO.getNombreProyeccionPlanAnualAdqCdoIng().toUpperCase(), proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO().getIdDestinacionMantenimientoCdoIng(), proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO().getIdInfraestructura());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(proyeccionPlanAnualAdqCdoIngNombreIdProyeccionPlanAnualAdqGeneralIdDestinacionMantenimientoCdoIngEIdInfraestructura == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO CON LA MISMA COMBINACION DE FK MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCUENTRA EL REGISTRO REPETIDO MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_DESTINACION_MANTENIMIENTO_CDO_ING_E_INFRAESTRUCTURA, false);
                 respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA NO ENCUENTRA REGISTRO REPETIDO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAdqCdoIngRepository.save(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionPlanAnualAdqCdoIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualAdqCdoIng(Long idProyeccionPlanAnualAdqCdoIng) {
        Optional<ProyeccionPlanAnualAdqCdoIng> proyeccionPlanAnualAdqCdoIngId = proyeccionPlanAnualAdqCdoIngRepository.findById(idProyeccionPlanAnualAdqCdoIng);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqCdoIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIngDTO(proyeccionPlanAnualAdqCdoIngId.get()));
           proyeccionPlanAnualAdqCdoIngRepository.delete(proyeccionPlanAnualAdqCdoIngId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualAdqCdoIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
}
