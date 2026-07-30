//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualAdqInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualAdqInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqInfraestRepository;
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
public class ProyeccionPlanAnualAdqInfraestServiceImpl implements ProyeccionPlanAnualAdqInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqInfraestDAO proyeccionPlanAnualAdqInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqInfraestRepository proyeccionPlanAnualAdqInfraestRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualAdqInfraest, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualInfraest, Long idInfraestructura, String keyword) {
        return proyeccionPlanAnualAdqInfraestRepository.findTotalRegistros(idProyeccionPlanAnualAdqInfraest, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualInfraest, idInfraestructura, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualAdqInfraestDTO> listarProyeccionesPlanesAnualesAdqInfraest(Long idProyeccionPlanAnualAdqInfraest, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualInfraest, Long idInfraestructura, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualAdqInfraest> proyeccionesPlanesAnualesAdqInfraest = proyeccionPlanAnualAdqInfraestRepository.findAllProyeccionesPlanesAnualesAdqInfraest(idProyeccionPlanAnualAdqInfraest, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualInfraest, idInfraestructura, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualAdqInfraestDTO> proyeccionPlanAnualAdqInfraestDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualAdqInfraest proyeccionPlanAnualAdqInfraest : proyeccionesPlanesAnualesAdqInfraest) {
            proyeccionPlanAnualAdqInfraestDTOS.add(proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraestDTO(proyeccionPlanAnualAdqInfraest));
        }
        
        return proyeccionPlanAnualAdqInfraestDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualAdqInfraestDTO> listarProyeccionesPlanesAnualesAdqInfraestPag(Pageable pageable, Long idProyeccionPlanAnualAdqInfraest, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualInfraest, Long idInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualAdqInfraest> proyeccionesPlanesAnualesAdqInfraest = proyeccionPlanAnualAdqInfraestRepository.findAllProyeccionesPlanesAnualesAdqInfraestPag(pageable, idProyeccionPlanAnualAdqInfraest, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualInfraest, idInfraestructura, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesAdqInfraest.map(proyeccionPlanAnualAdqInfraest -> proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraestDTO(proyeccionPlanAnualAdqInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualAdqInfraest(ProyeccionPlanAnualAdqInfraestDTO proyeccionPlanAnualAdqInfraestDTO) {
        Long maxIdProyeccionPlanAnualAdqInfraest = null;
        ProyeccionPlanAnualAdqInfraest proyeccionPlanAnualAdqInfraestNombreIdProyeccionPlanAnualAdqGeneralEIdInfraest = proyeccionPlanAnualAdqInfraestRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdInfraestructura(proyeccionPlanAnualAdqInfraestDTO.getNombreProyeccionPlanAnualInfraest().toUpperCase(), proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO().getIdInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionPlanAnualAdqInfraestNombreIdProyeccionPlanAnualAdqGeneralEIdInfraest == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_INFRAEST_YA_EXISTE_EN_PLAN_ANUAL_ADQ_GENERAL_E_INFRAESTRUCTURA, false);
           respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionPlanAnualAdqInfraest = proyeccionPlanAnualAdqInfraestRepository.findMaxIdProyeccionPlanAnualAdqInfraest();
           if (maxIdProyeccionPlanAnualAdqInfraest == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionPlanAnualAdqInfraest = Long.valueOf(0);
           }
           proyeccionPlanAnualAdqInfraestDTO.setIdProyeccionPlanAnualAdqInfraest(maxIdProyeccionPlanAnualAdqInfraest + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionPlanAnualAdqInfraestRepository.save(proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraest(proyeccionPlanAnualAdqInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualAdqInfraestporId(Long idProyeccionPlanAnualAdqInfraest) {
        Optional<ProyeccionPlanAnualAdqInfraest> proyeccionPlanAnualAdqInfraestId = proyeccionPlanAnualAdqInfraestRepository.findByIdProyeccionPlanAnualAdqInfraest(Long.valueOf(idProyeccionPlanAnualAdqInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraestDTO(proyeccionPlanAnualAdqInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualAdqInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualAdqInfraest(ProyeccionPlanAnualAdqInfraestDTO proyeccionPlanAnualAdqInfraestDTO) {
        Optional<ProyeccionPlanAnualAdqInfraest> proyeccionPlanAnualAdqInfraestId = proyeccionPlanAnualAdqInfraestRepository.findByIdProyeccionPlanAnualAdqInfraest(proyeccionPlanAnualAdqInfraestDTO.getIdProyeccionPlanAnualAdqInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualAdqInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (proyeccionPlanAnualAdqInfraestDTO.getNombreProyeccionPlanAnualInfraest().equals(proyeccionPlanAnualAdqInfraestId.get().getNombreProyeccionPlanAnualInfraest()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI EL PLAN ANUAL ADQ GENERAL O LA INFRAESTRUCTURA CAMBIARON.
              if ((proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqInfraestId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) &&
                  (proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionPlanAnualAdqInfraestId.get().getInfraestructura().getIdInfraestructura()) == true)) {//SI EL PLAN ANUAL ADQ GENERAL Y LA INFRAESTRUCTURA NO CAMBIARON SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAdqInfraestRepository.save(proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraest(proyeccionPlanAnualAdqInfraestDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (!((proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqInfraestId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) &&
                   (proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionPlanAnualAdqInfraestId.get().getInfraestructura().getIdInfraestructura()) == true))) {//SI EL PLAN ANUAL ADQ GENERAL O LA INFRAESTRUCTURA CAMBIARON SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN LA NUEVA COMBINACION.
                 ProyeccionPlanAnualAdqInfraest proyeccionPlanAnualAdqInfraestNombreIdProyeccionPlanAnualAdqGeneralEIdInfraest = proyeccionPlanAnualAdqInfraestRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdInfraestructura(proyeccionPlanAnualAdqInfraestDTO.getNombreProyeccionPlanAnualInfraest().toUpperCase(), proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO().getIdInfraestructura());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionPlanAnualAdqInfraestNombreIdProyeccionPlanAnualAdqGeneralEIdInfraest == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL NUEVO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN LA NUEVA COMBINACION MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_INFRAEST_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_E_INFRAESTRUCTURA, false);
                    respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN LA NUEVA COMBINACION SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualAdqInfraestRepository.save(proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraest(proyeccionPlanAnualAdqInfraestDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (proyeccionPlanAnualAdqInfraestDTO.getNombreProyeccionPlanAnualInfraest().equals(proyeccionPlanAnualAdqInfraestId.get().getNombreProyeccionPlanAnualInfraest()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS ASOCIADOS AL MISMO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA.
              ProyeccionPlanAnualAdqInfraest proyeccionPlanAnualAdqInfraestNombreIdProyeccionPlanAnualAdqGeneralEIdInfraest = proyeccionPlanAnualAdqInfraestRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdInfraestructura(proyeccionPlanAnualAdqInfraestDTO.getNombreProyeccionPlanAnualInfraest().toUpperCase(), proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO().getIdInfraestructura());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(proyeccionPlanAnualAdqInfraestNombreIdProyeccionPlanAnualAdqGeneralEIdInfraest == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO Y ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_INFRAEST_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_E_INFRAESTRUCTURA, false);
                 respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL E INFRAESTRUCTURA SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAdqInfraestRepository.save(proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraest(proyeccionPlanAnualAdqInfraestDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionPlanAnualAdqInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualAdqInfraest(Long idProyeccionPlanAnualAdqInfraest) {
        Optional<ProyeccionPlanAnualAdqInfraest> proyeccionPlanAnualAdqInfraestId = proyeccionPlanAnualAdqInfraestRepository.findById(idProyeccionPlanAnualAdqInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(proyeccionPlanAnualAdqInfraestDAO.proyeccionPlanAnualAdqInfraestDTO(proyeccionPlanAnualAdqInfraestId.get()));
           proyeccionPlanAnualAdqInfraestRepository.delete(proyeccionPlanAnualAdqInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualAdqInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
