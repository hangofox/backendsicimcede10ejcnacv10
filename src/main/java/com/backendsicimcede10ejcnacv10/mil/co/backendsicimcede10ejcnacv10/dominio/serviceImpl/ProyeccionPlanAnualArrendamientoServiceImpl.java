//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualArrendamientoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualArrendamientoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualArrendamientoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualArrendamiento;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualArrendamientoRepository;
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
public class ProyeccionPlanAnualArrendamientoServiceImpl implements ProyeccionPlanAnualArrendamientoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualArrendamientoDAO proyeccionPlanAnualArrendamientoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualArrendamientoRepository proyeccionPlanAnualArrendamientoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualArrendamiento, Long idInfraestructuraArrendada, String nombreProyeccionPlanAnualArrendamiento, String keyword) {
        return proyeccionPlanAnualArrendamientoRepository.findTotalRegistros(idProyeccionPlanAnualArrendamiento, idInfraestructuraArrendada, nombreProyeccionPlanAnualArrendamiento, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualArrendamientoDTO> listarProyeccionesPlanesAnualesArrendamientos(Long idProyeccionPlanAnualArrendamiento, Long idInfraestructuraArrendada, String nombreProyeccionPlanAnualArrendamiento, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualArrendamiento> proyeccionesPlanesAnualesArrendamientos = proyeccionPlanAnualArrendamientoRepository.findAllProyeccionesPlanesAnualesArrendamientos(idProyeccionPlanAnualArrendamiento, idInfraestructuraArrendada, nombreProyeccionPlanAnualArrendamiento, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualArrendamientoDTO> proyeccionPlanAnualArrendamientoDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamiento : proyeccionesPlanesAnualesArrendamientos) {
            proyeccionPlanAnualArrendamientoDTOS.add(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamiento));
        }
        
        return proyeccionPlanAnualArrendamientoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualArrendamientoDTO> listarProyeccionesPlanesAnualesArrendamientosPag(Pageable pageable, Long idProyeccionPlanAnualArrendamiento, Long idInfraestructuraArrendada, String nombreProyeccionPlanAnualArrendamiento, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualArrendamiento> proyeccionesPlanesAnualesArrendamientos = proyeccionPlanAnualArrendamientoRepository.findAllProyeccionesPlanesAnualesArrendamientosPag(pageable, idProyeccionPlanAnualArrendamiento, idInfraestructuraArrendada, nombreProyeccionPlanAnualArrendamiento, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesArrendamientos.map(proyeccionPlanAnualArrendamiento -> proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamiento));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualArrendamiento(ProyeccionPlanAnualArrendamientoDTO proyeccionPlanAnualArrendamientoDTO) {
        Long maxIdProyeccionPlanAnualArrendamiento = null;
        ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamientoNombreEIdInfraestArrendada = proyeccionPlanAnualArrendamientoRepository.findByNombreProyeccionPlanAnualArrendamientoAndIdInfraestructuraArrendada(proyeccionPlanAnualArrendamientoDTO.getNombreProyeccionPlanAnualArrendamiento().toUpperCase(), proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO().getIdInfraestructuraArrendada());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionPlanAnualArrendamientoNombreEIdInfraestArrendada == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA ARRENDADA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA ARRENDADA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ARRENDAMIENTO_YA_EXISTE_EN_INFRAESTRUCTURA_ARRENDADA, false);
           respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA ARRENDADA CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionPlanAnualArrendamiento = proyeccionPlanAnualArrendamientoRepository.findMaxIdProyeccionPlanAnualArrendamiento();
           if (maxIdProyeccionPlanAnualArrendamiento == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionPlanAnualArrendamiento = Long.valueOf(0);
           }
           proyeccionPlanAnualArrendamientoDTO.setIdProyeccionPlanAnualArrendamiento(maxIdProyeccionPlanAnualArrendamiento + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionPlanAnualArrendamientoRepository.save(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamientoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualArrendamientoporId(Long idProyeccionPlanAnualArrendamiento) {
        Optional<ProyeccionPlanAnualArrendamiento> proyeccionPlanAnualArrendamientoId = proyeccionPlanAnualArrendamientoRepository.findByIdProyeccionPlanAnualArrendamiento(Long.valueOf(idProyeccionPlanAnualArrendamiento));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualArrendamientoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamientoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualArrendamientoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualArrendamiento(ProyeccionPlanAnualArrendamientoDTO proyeccionPlanAnualArrendamientoDTO) {
        Optional<ProyeccionPlanAnualArrendamiento> proyeccionPlanAnualArrendamientoId = proyeccionPlanAnualArrendamientoRepository.findByIdProyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamientoDTO.getIdProyeccionPlanAnualArrendamiento());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualArrendamientoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (proyeccionPlanAnualArrendamientoDTO.getNombreProyeccionPlanAnualArrendamiento().equals(proyeccionPlanAnualArrendamientoId.get().getNombreProyeccionPlanAnualArrendamiento()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI LA INFRAESTRUCTURA ARRENDADA CAMBIO.
              if ( (proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO().getIdInfraestructuraArrendada().equals(proyeccionPlanAnualArrendamientoId.get().getInfraestructuraArrendada().getIdInfraestructuraArrendada())==true) ) {//SI LA INFRAESTRUCTURA ARRENDADA NO CAMBIO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualArrendamientoRepository.save(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamientoDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO().getIdInfraestructuraArrendada().equals(proyeccionPlanAnualArrendamientoId.get().getInfraestructuraArrendada().getIdInfraestructuraArrendada())==false) {//SI LA INFRAESTRUCTURA ARRENDADA CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN LA NUEVA INFRAESTRUCTURA ARRENDADA.
                 ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamientoNombreEIdInfraestArrendada = proyeccionPlanAnualArrendamientoRepository.findByNombreProyeccionPlanAnualArrendamientoAndIdInfraestructuraArrendada(proyeccionPlanAnualArrendamientoDTO.getNombreProyeccionPlanAnualArrendamiento().toUpperCase(), proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO().getIdInfraestructuraArrendada());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionPlanAnualArrendamientoNombreEIdInfraestArrendada == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A LA NUEVA INFRAESTRUCTURA ARRENDADA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN LA NUEVA INFRAESTRUCTURA ARRENDADA MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ARRENDAMIENTO_NO_MODIFICAR_EN_INFRAESTRUCTURA_ARRENDADA, false);
                    respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN LA NUEVA INFRAESTRUCTURA ARRENDADA SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualArrendamientoRepository.save(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamientoDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (proyeccionPlanAnualArrendamientoDTO.getNombreProyeccionPlanAnualArrendamiento().equals(proyeccionPlanAnualArrendamientoId.get().getNombreProyeccionPlanAnualArrendamiento()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA ARRENDADA.
              ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamientoNombreEIdInfraestArrendada = proyeccionPlanAnualArrendamientoRepository.findByNombreProyeccionPlanAnualArrendamientoAndIdInfraestructuraArrendada(proyeccionPlanAnualArrendamientoDTO.getNombreProyeccionPlanAnualArrendamiento().toUpperCase(), proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO().getIdInfraestructuraArrendada());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(proyeccionPlanAnualArrendamientoNombreEIdInfraestArrendada == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA ARRENDADA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA ARRENDADA Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_ARRENDAMIENTO_NO_MODIFICAR_EN_INFRAESTRUCTURA_ARRENDADA, false);
                 respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA ARRENDADA SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionPlanAnualArrendamientoRepository.save(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamientoDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionPlanAnualArrendamientoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualArrendamiento(Long idProyeccionPlanAnualArrendamiento) {
        Optional<ProyeccionPlanAnualArrendamiento> proyeccionPlanAnualArrendamientoId = proyeccionPlanAnualArrendamientoRepository.findById(idProyeccionPlanAnualArrendamiento);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualArrendamientoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamientoId.get()));
           proyeccionPlanAnualArrendamientoRepository.delete(proyeccionPlanAnualArrendamientoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualArrendamientoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualArrendamientoDTO(null);
        }
        
        return respuestaDTO;
    }
}
