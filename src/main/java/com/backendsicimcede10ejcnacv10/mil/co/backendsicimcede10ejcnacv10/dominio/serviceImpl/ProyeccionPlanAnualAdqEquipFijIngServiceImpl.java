//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqEquipFijIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualAdqEquipFijIngService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualAdqEquipFijIngDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqEquipFijIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqEquipFijIngRepository;
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
public class ProyeccionPlanAnualAdqEquipFijIngServiceImpl implements ProyeccionPlanAnualAdqEquipFijIngService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqEquipFijIngDAO proyeccionPlanAnualAdqEquipFijIngDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqEquipFijIngRepository proyeccionPlanAnualAdqEquipFijIngRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualAdqEquipFijIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqEquipFijIng, String keyword) {
        return proyeccionPlanAnualAdqEquipFijIngRepository.findTotalRegistros(idProyeccionPlanAnualAdqEquipFijIng, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqEquipFijIng, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualAdqEquipFijIngDTO> listarProyeccionesPlanesAnualesAdqEquipFijIng(Long idProyeccionPlanAnualAdqEquipFijIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqEquipFijIng, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualAdqEquipFijIng> proyeccionesPlanesAnualesAdqEquipFijIng = proyeccionPlanAnualAdqEquipFijIngRepository.findAllProyeccionesPlanesAnualesAdqEquipFijIng(idProyeccionPlanAnualAdqEquipFijIng, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqEquipFijIng, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualAdqEquipFijIngDTO> proyeccionPlanAnualAdqEquipFijIngDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualAdqEquipFijIng proyeccionPlanAnualAdqEquipFijIng : proyeccionesPlanesAnualesAdqEquipFijIng) {
            proyeccionPlanAnualAdqEquipFijIngDTOS.add(proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIngDTO(proyeccionPlanAnualAdqEquipFijIng));
        }
        
        return proyeccionPlanAnualAdqEquipFijIngDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualAdqEquipFijIngDTO> listarProyeccionesPlanesAnualesAdqEquipFijIngPag(Pageable pageable, Long idProyeccionPlanAnualAdqEquipFijIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqEquipFijIng, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualAdqEquipFijIng> proyeccionesPlanesAnualesAdqEquipFijIng = proyeccionPlanAnualAdqEquipFijIngRepository.findAllProyeccionesPlanesAnualesAdqEquipFijIngPag(pageable, idProyeccionPlanAnualAdqEquipFijIng, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqEquipFijIng, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesAdqEquipFijIng.map(proyeccionPlanAnualAdqEquipFijIng -> proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIngDTO(proyeccionPlanAnualAdqEquipFijIng));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualAdqEquipFijIng(ProyeccionPlanAnualAdqEquipFijIngDTO proyeccionPlanAnualAdqEquipFijIngDTO) {
        Long maxIdProyeccionPlanAnualAdqEquipFijIng = null;
        ProyeccionPlanAnualAdqEquipFijIng proyeccionPlanAnualAdqEquipFijIngNombreEIdProyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqEquipFijIngRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqEquipFijIngDTO.getNombreProyeccionPlanAnualAdqEquipFijIng().toUpperCase(), proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionPlanAnualAdqEquipFijIngNombreEIdProyeccionPlanAnualAdqGeneral == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_EQUIP_FIJ_ING_YA_EXISTE_EN_PLAN_ANUAL_ADQ_GENERAL, false);
           respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionPlanAnualAdqEquipFijIng = proyeccionPlanAnualAdqEquipFijIngRepository.findMaxIdProyeccionPlanAnualAdqEquipFijIng();
           if (maxIdProyeccionPlanAnualAdqEquipFijIng == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionPlanAnualAdqEquipFijIng = Long.valueOf(0);
           }
           proyeccionPlanAnualAdqEquipFijIngDTO.setIdProyeccionPlanAnualAdqEquipFijIng(maxIdProyeccionPlanAnualAdqEquipFijIng + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionPlanAnualAdqEquipFijIngRepository.save(proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIngDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualAdqEquipFijIngporId(Long idProyeccionPlanAnualAdqEquipFijIng) {
        Optional<ProyeccionPlanAnualAdqEquipFijIng> proyeccionPlanAnualAdqEquipFijIngId = proyeccionPlanAnualAdqEquipFijIngRepository.findByIdProyeccionPlanAnualAdqEquipFijIng(Long.valueOf(idProyeccionPlanAnualAdqEquipFijIng));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqEquipFijIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIngDTO(proyeccionPlanAnualAdqEquipFijIngId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualAdqEquipFijIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualAdqEquipFijIng(ProyeccionPlanAnualAdqEquipFijIngDTO proyeccionPlanAnualAdqEquipFijIngDTO) {
        Optional<ProyeccionPlanAnualAdqEquipFijIng> proyeccionPlanAnualAdqEquipFijIngId = proyeccionPlanAnualAdqEquipFijIngRepository.findByIdProyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIngDTO.getIdProyeccionPlanAnualAdqEquipFijIng());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualAdqEquipFijIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ((proyeccionPlanAnualAdqEquipFijIngDTO.getNombreProyeccionPlanAnualAdqEquipFijIng().equals(proyeccionPlanAnualAdqEquipFijIngId.get().getNombreProyeccionPlanAnualAdqEquipFijIng()) == true)) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI EL PLAN ANUAL ADQ GENERAL CAMBIO.
              if (proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqEquipFijIngId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) {//SI EL PLAN ANUAL ADQ GENERAL NO CAMBIO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAdqEquipFijIngRepository.save(proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIngDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqEquipFijIngId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == false) {//SI EL PLAN ANUAL ADQ GENERAL CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN EL NUEVO PLAN ANUAL ADQ GENERAL.
                 ProyeccionPlanAnualAdqEquipFijIng proyeccionPlanAnualAdqEquipFijIngNombreEIdProyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqEquipFijIngRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqEquipFijIngDTO.getNombreProyeccionPlanAnualAdqEquipFijIng().toUpperCase(), proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionPlanAnualAdqEquipFijIngNombreEIdProyeccionPlanAnualAdqGeneral == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL NUEVO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN EL NUEVO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_EQUIP_FIJ_ING_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL, false);
                    respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN EL NUEVO PLAN ANUAL ADQ GENERAL SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualAdqEquipFijIngRepository.save(proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIngDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (proyeccionPlanAnualAdqEquipFijIngDTO.getNombreProyeccionPlanAnualAdqEquipFijIng().equals(proyeccionPlanAnualAdqEquipFijIngId.get().getNombreProyeccionPlanAnualAdqEquipFijIng()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS ASOCIADOS AL MISMO PLAN ANUAL ADQ GENERAL.
              ProyeccionPlanAnualAdqEquipFijIng proyeccionPlanAnualAdqEquipFijIngNombreEIdProyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqEquipFijIngRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqEquipFijIngDTO.getNombreProyeccionPlanAnualAdqEquipFijIng().toUpperCase(), proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(proyeccionPlanAnualAdqEquipFijIngNombreEIdProyeccionPlanAnualAdqGeneral == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ADQ_EQUIP_FIJ_ING_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL, false);
                 respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAdqEquipFijIngRepository.save(proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIngDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionPlanAnualAdqEquipFijIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualAdqEquipFijIng(Long idProyeccionPlanAnualAdqEquipFijIng) {
        Optional<ProyeccionPlanAnualAdqEquipFijIng> proyeccionPlanAnualAdqEquipFijIngId = proyeccionPlanAnualAdqEquipFijIngRepository.findById(idProyeccionPlanAnualAdqEquipFijIng);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqEquipFijIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(proyeccionPlanAnualAdqEquipFijIngDAO.proyeccionPlanAnualAdqEquipFijIngDTO(proyeccionPlanAnualAdqEquipFijIngId.get()));
           proyeccionPlanAnualAdqEquipFijIngRepository.delete(proyeccionPlanAnualAdqEquipFijIngId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualAdqEquipFijIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqEquipFijIngDTO(null);
        }
        
        return respuestaDTO;
    }
}
