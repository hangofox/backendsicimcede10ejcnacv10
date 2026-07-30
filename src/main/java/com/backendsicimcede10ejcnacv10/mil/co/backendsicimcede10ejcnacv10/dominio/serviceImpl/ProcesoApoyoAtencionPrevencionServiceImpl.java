//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProcesoApoyoAtencionPrevencionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProcesoApoyoAtencionPrevencionService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProcesoApoyoAtencionPrevencionDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProcesoApoyoAtencionPrevencion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProcesoApoyoAtencionPrevencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProcesoApoyoAtencionPrevencionServiceImpl implements ProcesoApoyoAtencionPrevencionService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProcesoApoyoAtencionPrevencionDAO procesoApoyoAtencionPrevencionDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProcesoApoyoAtencionPrevencionRepository procesoApoyoAtencionPrevencionRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProcesoApoyoAtencionPrevencion, String keyword, String nombreTipoRequerimientoApoyoAtencionPrevencion) {
        return procesoApoyoAtencionPrevencionRepository.findTotalRegistros(idProcesoApoyoAtencionPrevencion, keyword, nombreTipoRequerimientoApoyoAtencionPrevencion);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProcesoApoyoAtencionPrevencionDTO> listarProcesosApoyosAtencionPrevencion(Long idProcesoApoyoAtencionPrevencion, String keyword, String nombreTipoRequerimientoApoyoAtencionPrevencion, String orderBy, String orderMode) {
        List<ProcesoApoyoAtencionPrevencion> procesosApoyosAtencionPrevencion = procesoApoyoAtencionPrevencionRepository.findAllProcesosApoyosAtencionPrevencion(idProcesoApoyoAtencionPrevencion, keyword, nombreTipoRequerimientoApoyoAtencionPrevencion, orderBy, orderMode);
        List<ProcesoApoyoAtencionPrevencionDTO> procesoApoyoAtencionPrevencionDTOS = new ArrayList<>();
        for (ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencion : procesosApoyosAtencionPrevencion) {
            procesoApoyoAtencionPrevencionDTOS.add(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencion));
        }
        
        return procesoApoyoAtencionPrevencionDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<ProcesoApoyoAtencionPrevencionDTO> listarProcesosApoyosAtencionPrevencionPag(Pageable pageable, Long idProcesoApoyoAtencionPrevencion, String keyword, String nombreTipoRequerimientoApoyoAtencionPrevencion, String orderBy, String orderMode) {
        Slice<ProcesoApoyoAtencionPrevencion> procesosApoyosAtencionPrevencion = procesoApoyoAtencionPrevencionRepository.findAllProcesosApoyosAtencionPrevencionPag(pageable, idProcesoApoyoAtencionPrevencion, keyword, nombreTipoRequerimientoApoyoAtencionPrevencion, orderBy, orderMode);
        return procesosApoyosAtencionPrevencion.map(procesoApoyoAtencionPrevencion -> procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencion));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProcesoApoyoAtencionPrevencion(ProcesoApoyoAtencionPrevencionDTO procesoApoyoAtencionPrevencionDTO) {
        Long maxIdProcesoApoyoAtencionPrevencion = null;
        ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencionNombreYTipo = procesoApoyoAtencionPrevencionRepository.findByNombreTipoRequerimientoApoyoAtencionPrevencionAndNombreProcesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO().getNombreTipoRequerimientoApoyoAtencionPrevencion(), procesoApoyoAtencionPrevencionDTO.getNombreProcesoApoyoAtencionPrevencion().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(procesoApoyoAtencionPrevencionNombreYTipo == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProcesoApoyoAtencionPrevencion = procesoApoyoAtencionPrevencionRepository.findMaxIdProcesoApoyoAtencionPrevencion();
           if (maxIdProcesoApoyoAtencionPrevencion == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdProcesoApoyoAtencionPrevencion = Long.valueOf(0);
           }
           procesoApoyoAtencionPrevencionDTO.setIdProcesoApoyoAtencionPrevencion(maxIdProcesoApoyoAtencionPrevencion + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           procesoApoyoAtencionPrevencionRepository.save(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProcesoApoyoAtencionPrevencionporId(Long idProcesoApoyoAtencionPrevencion) {
        Optional<ProcesoApoyoAtencionPrevencion> procesoApoyoAtencionPrevencionId = procesoApoyoAtencionPrevencionRepository.findByIdProcesoApoyoAtencionPrevencion(Long.valueOf(idProcesoApoyoAtencionPrevencion));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (procesoApoyoAtencionPrevencionId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencionId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (procesoApoyoAtencionPrevencionId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y NOMBRE TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProcesoApoyoAtencionPrevencionporNombreYNombreTipoRequerimientoApoyoAtencionPrevencion(String nombreProcesoApoyoAtencionPrevencion, String nombreTipoRequerimientoApoyoAtencionPrevencion) {
        Optional<ProcesoApoyoAtencionPrevencion> procesoApoyoAtencionPrevencionNombre = Optional.ofNullable(procesoApoyoAtencionPrevencionRepository.findByNombreTipoRequerimientoApoyoAtencionPrevencionAndNombreProcesoApoyoAtencionPrevencion(String.valueOf(nombreTipoRequerimientoApoyoAtencionPrevencion), String.valueOf(nombreProcesoApoyoAtencionPrevencion)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (procesoApoyoAtencionPrevencionNombre.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencionNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (procesoApoyoAtencionPrevencionNombre.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProcesoApoyoAtencionPrevencion(ProcesoApoyoAtencionPrevencionDTO procesoApoyoAtencionPrevencionDTO) {
        Optional<ProcesoApoyoAtencionPrevencion> procesoApoyoAtencionPrevencionId = procesoApoyoAtencionPrevencionRepository.findByIdProcesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO.getIdProcesoApoyoAtencionPrevencion());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (procesoApoyoAtencionPrevencionId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (procesoApoyoAtencionPrevencionDTO.getNombreProcesoApoyoAtencionPrevencion().equals(procesoApoyoAtencionPrevencionId.get().getNombreProcesoApoyoAtencionPrevencion()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              procesoApoyoAtencionPrevencionRepository.save(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (procesoApoyoAtencionPrevencionDTO.getNombreProcesoApoyoAtencionPrevencion().equals(procesoApoyoAtencionPrevencionId.get().getNombreProcesoApoyoAtencionPrevencion()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UN MISMO TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN.
              ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencionNombreYTipo = procesoApoyoAtencionPrevencionRepository.findByNombreTipoRequerimientoApoyoAtencionPrevencionAndNombreProcesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO().getNombreTipoRequerimientoApoyoAtencionPrevencion(), procesoApoyoAtencionPrevencionDTO.getNombreProcesoApoyoAtencionPrevencion().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(procesoApoyoAtencionPrevencionNombreYTipo == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO TIPO DE REQUERIMIENTO APOYO ATENCIÓN PREVENCIÓN SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 procesoApoyoAtencionPrevencionRepository.save(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (procesoApoyoAtencionPrevencionId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProcesoApoyoAtencionPrevencion(Long idProcesoApoyoAtencionPrevencion) {
        Optional<ProcesoApoyoAtencionPrevencion> procesoApoyoAtencionPrevencionId = procesoApoyoAtencionPrevencionRepository.findById(idProcesoApoyoAtencionPrevencion);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (procesoApoyoAtencionPrevencionId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencionId.get()));
           procesoApoyoAtencionPrevencionRepository.delete(procesoApoyoAtencionPrevencionId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (procesoApoyoAtencionPrevencionId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProcesoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
}
