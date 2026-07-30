//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAsegBienDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualAsegBienService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualAsegBienDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAsegBien;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAsegBienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProyeccionPlanAnualAsegBienServiceImpl implements ProyeccionPlanAnualAsegBienService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAsegBienDAO proyeccionPlanAnualAsegBienDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAsegBienRepository proyeccionPlanAnualAsegBienRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualAsegBien, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAsegBien, String keyword) {
        return proyeccionPlanAnualAsegBienRepository.findTotalRegistros(idProyeccionPlanAnualAsegBien, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAsegBien, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualAsegBienDTO> listarProyeccionesPlanesAnualesAsegBienes(Long idProyeccionPlanAnualAsegBien, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAsegBien, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualAsegBien> proyeccionesPlanesAnualesAsegBienes = proyeccionPlanAnualAsegBienRepository.findAllProyeccionesPlanesAnualesAsegBienes(idProyeccionPlanAnualAsegBien, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAsegBien, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualAsegBienDTO> proyeccionPlanAnualAsegBienDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualAsegBien proyeccionPlanAnualAsegBien : proyeccionesPlanesAnualesAsegBienes) {
            proyeccionPlanAnualAsegBienDTOS.add(proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBienDTO(proyeccionPlanAnualAsegBien));
        }
        
        return proyeccionPlanAnualAsegBienDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualAsegBienDTO> listarProyeccionesPlanesAnualesAsegBienesPag(Pageable pageable, Long idProyeccionPlanAnualAsegBien, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAsegBien, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualAsegBien> proyeccionesPlanesAnualesAsegBienes = proyeccionPlanAnualAsegBienRepository.findAllProyeccionesPlanesAnualesAsegBienesPag(pageable, idProyeccionPlanAnualAsegBien, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAsegBien, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesAsegBienes.map(proyeccionPlanAnualAsegBien -> proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBienDTO(proyeccionPlanAnualAsegBien));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualAsegBien(ProyeccionPlanAnualAsegBienDTO proyeccionPlanAnualAsegBienDTO) {
        Long maxIdProyeccionPlanAnualAsegBien = null;
        ProyeccionPlanAnualAsegBien proyeccionPlanAnualAsegBienNombreEIdProyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAsegBienRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAsegBienDTO.getNombreProyeccionPlanAnualAsegBien().toUpperCase(), proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionPlanAnualAsegBienNombreEIdProyeccionPlanAnualAdqGeneral == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ASEG_BIEN_YA_EXISTE_EN_PLAN_ANUAL_ADQ_GENERAL, false);
           respuestaDTO.setProyeccionPlanAnualAsegBienDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionPlanAnualAsegBien = proyeccionPlanAnualAsegBienRepository.findMaxIdProyeccionPlanAnualAsegBien();
           if (maxIdProyeccionPlanAnualAsegBien == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionPlanAnualAsegBien = Long.valueOf(0);
           }
           proyeccionPlanAnualAsegBienDTO.setIdProyeccionPlanAnualAsegBien(maxIdProyeccionPlanAnualAsegBien + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionPlanAnualAsegBienRepository.save(proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBienDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualAsegBienporId(Long idProyeccionPlanAnualAsegBien) {
        Optional<ProyeccionPlanAnualAsegBien> proyeccionPlanAnualAsegBienId = proyeccionPlanAnualAsegBienRepository.findByIdProyeccionPlanAnualAsegBien(Long.valueOf(idProyeccionPlanAnualAsegBien));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAsegBienId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAsegBienDTO(proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBienDTO(proyeccionPlanAnualAsegBienId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualAsegBienId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAsegBienDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualAsegBien(ProyeccionPlanAnualAsegBienDTO proyeccionPlanAnualAsegBienDTO) {
        Optional<ProyeccionPlanAnualAsegBien> proyeccionPlanAnualAsegBienId = proyeccionPlanAnualAsegBienRepository.findByIdProyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBienDTO.getIdProyeccionPlanAnualAsegBien());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualAsegBienId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ((proyeccionPlanAnualAsegBienDTO.getNombreProyeccionPlanAnualAsegBien().equals(proyeccionPlanAnualAsegBienId.get().getNombreProyeccionPlanAnualAsegBien()) == true)) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI EL PLAN ANUAL ADQ GENERAL CAMBIO.
              if (proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAsegBienId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) {//SI EL PLAN ANUAL ADQ GENERAL NO CAMBIO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAsegBienRepository.save(proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBienDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAsegBienId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == false) {//SI EL PLAN ANUAL ADQ GENERAL CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN EL NUEVO PLAN ANUAL ADQ GENERAL.
                 ProyeccionPlanAnualAsegBien proyeccionPlanAnualAsegBienNombreEIdProyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAsegBienRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAsegBienDTO.getNombreProyeccionPlanAnualAsegBien().toUpperCase(), proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionPlanAnualAsegBienNombreEIdProyeccionPlanAnualAdqGeneral == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL NUEVO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN EL NUEVO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ASEG_BIEN_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL, false);
                    respuestaDTO.setProyeccionPlanAnualAsegBienDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN EL NUEVO PLAN ANUAL ADQ GENERAL SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualAsegBienRepository.save(proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBienDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (proyeccionPlanAnualAsegBienDTO.getNombreProyeccionPlanAnualAsegBien().equals(proyeccionPlanAnualAsegBienId.get().getNombreProyeccionPlanAnualAsegBien()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS ASOCIADOS AL MISMO PLAN ANUAL ADQ GENERAL.
              ProyeccionPlanAnualAsegBien proyeccionPlanAnualAsegBienNombreEIdProyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAsegBienRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAsegBienDTO.getNombreProyeccionPlanAnualAsegBien().toUpperCase(), proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(proyeccionPlanAnualAsegBienNombreEIdProyeccionPlanAnualAdqGeneral == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ASEG_BIEN_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL, false);
                 respuestaDTO.setProyeccionPlanAnualAsegBienDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualAsegBienRepository.save(proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBienDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionPlanAnualAsegBienId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualAsegBienDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualAsegBien(Long idProyeccionPlanAnualAsegBien) {
        Optional<ProyeccionPlanAnualAsegBien> proyeccionPlanAnualAsegBienId = proyeccionPlanAnualAsegBienRepository.findById(idProyeccionPlanAnualAsegBien);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAsegBienId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAsegBienDTO(proyeccionPlanAnualAsegBienDAO.proyeccionPlanAnualAsegBienDTO(proyeccionPlanAnualAsegBienId.get()));
           proyeccionPlanAnualAsegBienRepository.delete(proyeccionPlanAnualAsegBienId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualAsegBienId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAsegBienDTO(null);
        }
        
        return respuestaDTO;
    }
}
