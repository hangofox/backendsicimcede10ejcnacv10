//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualEquipSubsDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualEquipSubsService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualEquipSubsDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualEquipSubs;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualEquipSubsRepository;
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
public class ProyeccionPlanAnualEquipSubsServiceImpl implements ProyeccionPlanAnualEquipSubsService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualEquipSubsDAO proyeccionPlanAnualEquipSubsDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualEquipSubsRepository proyeccionPlanAnualEquipSubsRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualEquipSubs, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualEquipSubs, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, String valorSolicitadoProyeccionPlanAnualEquipSubs, String nombreBienOServicioProyeccionPlanAnualEquipSubs, String keyword) {
        return proyeccionPlanAnualEquipSubsRepository.findTotalRegistros(idProyeccionPlanAnualEquipSubs, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualEquipSubs, idEquipoIngeniero, nombreYNumeroRubroProyeccionPlanAnualEquipSubs, valorSolicitadoProyeccionPlanAnualEquipSubs, nombreBienOServicioProyeccionPlanAnualEquipSubs, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualEquipSubsDTO> listarProyeccionesPlanesAnualesEquipSubs(Long idProyeccionPlanAnualEquipSubs, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualEquipSubs, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, String valorSolicitadoProyeccionPlanAnualEquipSubs, String nombreBienOServicioProyeccionPlanAnualEquipSubs, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualEquipSubs> proyeccionesPlanesAnualesEquipSubs = proyeccionPlanAnualEquipSubsRepository.findAllProyeccionesPlanesAnualesEquipSubs(idProyeccionPlanAnualEquipSubs, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualEquipSubs, idEquipoIngeniero, nombreYNumeroRubroProyeccionPlanAnualEquipSubs, valorSolicitadoProyeccionPlanAnualEquipSubs, nombreBienOServicioProyeccionPlanAnualEquipSubs, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualEquipSubsDTO> proyeccionPlanAnualEquipSubsDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualEquipSubs proyeccionPlanAnualEquipSubs : proyeccionesPlanesAnualesEquipSubs) {
            proyeccionPlanAnualEquipSubsDTOS.add(proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubsDTO(proyeccionPlanAnualEquipSubs));
        }
        
        return proyeccionPlanAnualEquipSubsDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualEquipSubsDTO> listarProyeccionesPlanesAnualesEquipSubsPag(Pageable pageable, Long idProyeccionPlanAnualEquipSubs, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualEquipSubs, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, String valorSolicitadoProyeccionPlanAnualEquipSubs, String nombreBienOServicioProyeccionPlanAnualEquipSubs, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualEquipSubs> proyeccionesPlanesAnualesEquipSubs = proyeccionPlanAnualEquipSubsRepository.findAllProyeccionesPlanesAnualesEquipSubsPag(pageable, idProyeccionPlanAnualEquipSubs, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualEquipSubs, idEquipoIngeniero, nombreYNumeroRubroProyeccionPlanAnualEquipSubs, valorSolicitadoProyeccionPlanAnualEquipSubs, nombreBienOServicioProyeccionPlanAnualEquipSubs, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesEquipSubs.map(proyeccionPlanAnualEquipSubs -> proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubsDTO(proyeccionPlanAnualEquipSubs));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualEquipSubs(ProyeccionPlanAnualEquipSubsDTO proyeccionPlanAnualEquipSubsDTO) {
        Long maxIdProyeccionPlanAnualEquipSubs = null;
        ProyeccionPlanAnualEquipSubs proyeccionPlanAnualEquipSubsNombreIdProyeccionPlanAnualAdqGeneralEIdEquipoIngeniero = proyeccionPlanAnualEquipSubsRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdEquipoIngeniero(proyeccionPlanAnualEquipSubsDTO.getNombreProyeccionPlanAnualEquipSubs().toUpperCase(), proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionPlanAnualEquipSubsNombreIdProyeccionPlanAnualAdqGeneralEIdEquipoIngeniero == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_EQUIP_SUBS_YA_EXISTE_EN_PLAN_ANUAL_ADQ_GENERAL_Y_EQUIPO_INGENIERO, false);
           respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y EQUIPO DE INGENIERO CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionPlanAnualEquipSubs = proyeccionPlanAnualEquipSubsRepository.findMaxIdProyeccionPlanAnualEquipSubs();
           if (maxIdProyeccionPlanAnualEquipSubs == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionPlanAnualEquipSubs = Long.valueOf(0);
           }
           proyeccionPlanAnualEquipSubsDTO.setIdProyeccionPlanAnualEquipSubs(maxIdProyeccionPlanAnualEquipSubs + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionPlanAnualEquipSubsRepository.save(proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualEquipSubsporId(Long idProyeccionPlanAnualEquipSubs) {
        Optional<ProyeccionPlanAnualEquipSubs> proyeccionPlanAnualEquipSubsId = proyeccionPlanAnualEquipSubsRepository.findByIdProyeccionPlanAnualEquipSubs(Long.valueOf(idProyeccionPlanAnualEquipSubs));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualEquipSubsId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubsDTO(proyeccionPlanAnualEquipSubsId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualEquipSubsId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualEquipSubs(ProyeccionPlanAnualEquipSubsDTO proyeccionPlanAnualEquipSubsDTO) {
        Optional<ProyeccionPlanAnualEquipSubs> proyeccionPlanAnualEquipSubsId = proyeccionPlanAnualEquipSubsRepository.findByIdProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO.getIdProyeccionPlanAnualEquipSubs());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualEquipSubsId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (proyeccionPlanAnualEquipSubsDTO.getNombreProyeccionPlanAnualEquipSubs().equals(proyeccionPlanAnualEquipSubsId.get().getNombreProyeccionPlanAnualEquipSubs()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI EL PLAN ANUAL ADQ GENERAL O EL EQUIPO DE INGENIERO CAMBIARON.
              if ((proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualEquipSubsId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) &&
                  (proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero().equals(proyeccionPlanAnualEquipSubsId.get().getEquipoIngeniero().getIdEquipoIngeniero()) == true)) {//SI EL PLAN ANUAL ADQ GENERAL Y EL EQUIPO DE INGENIERO NO CAMBIARON SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualEquipSubsRepository.save(proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (!((proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualEquipSubsId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) &&
                   (proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero().equals(proyeccionPlanAnualEquipSubsId.get().getEquipoIngeniero().getIdEquipoIngeniero()) == true))) {//SI EL PLAN ANUAL ADQ GENERAL O EL EQUIPO DE INGENIERO CAMBIARON SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN LA NUEVA COMBINACION.
                 ProyeccionPlanAnualEquipSubs proyeccionPlanAnualEquipSubsNombreIdProyeccionPlanAnualAdqGeneralEIdEquipoIngeniero = proyeccionPlanAnualEquipSubsRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdEquipoIngeniero(proyeccionPlanAnualEquipSubsDTO.getNombreProyeccionPlanAnualEquipSubs().toUpperCase(), proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionPlanAnualEquipSubsNombreIdProyeccionPlanAnualAdqGeneralEIdEquipoIngeniero == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO A LA NUEVA COMBINACION MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN LA NUEVA COMBINACION MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_EQUIP_SUBS_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_Y_EQUIPO_INGENIERO, false);
                    respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN LA NUEVA COMBINACION SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualEquipSubsRepository.save(proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (proyeccionPlanAnualEquipSubsDTO.getNombreProyeccionPlanAnualEquipSubs().equals(proyeccionPlanAnualEquipSubsId.get().getNombreProyeccionPlanAnualEquipSubs()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS ASOCIADOS AL MISMO PLAN ANUAL ADQ GENERAL Y EQUIPO DE INGENIERO.
              ProyeccionPlanAnualEquipSubs proyeccionPlanAnualEquipSubsNombreIdProyeccionPlanAnualAdqGeneralEIdEquipoIngeniero = proyeccionPlanAnualEquipSubsRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdEquipoIngeniero(proyeccionPlanAnualEquipSubsDTO.getNombreProyeccionPlanAnualEquipSubs().toUpperCase(), proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(proyeccionPlanAnualEquipSubsNombreIdProyeccionPlanAnualAdqGeneralEIdEquipoIngeniero == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y EQUIPO DE INGENIERO Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_EQUIP_SUBS_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_Y_EQUIPO_INGENIERO, false);
                 respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y EQUIPO DE INGENIERO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualEquipSubsRepository.save(proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionPlanAnualEquipSubsId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualEquipSubs(Long idProyeccionPlanAnualEquipSubs) {
        Optional<ProyeccionPlanAnualEquipSubs> proyeccionPlanAnualEquipSubsId = proyeccionPlanAnualEquipSubsRepository.findById(idProyeccionPlanAnualEquipSubs);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualEquipSubsId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(proyeccionPlanAnualEquipSubsDAO.proyeccionPlanAnualEquipSubsDTO(proyeccionPlanAnualEquipSubsId.get()));
           proyeccionPlanAnualEquipSubsRepository.delete(proyeccionPlanAnualEquipSubsId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualEquipSubsId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualEquipSubsDTO(null);
        }
        
        return respuestaDTO;
    }
}
