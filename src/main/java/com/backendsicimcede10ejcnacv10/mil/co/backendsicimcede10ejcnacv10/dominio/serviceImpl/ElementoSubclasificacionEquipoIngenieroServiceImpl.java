//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ElementoSubclasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ElementoSubclasificacionEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ElementoSubclasificacionEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ElementoSubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ElementoSubclasificacionEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 19/06/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ElementoSubclasificacionEquipoIngenieroServiceImpl implements ElementoSubclasificacionEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ElementoSubclasificacionEquipoIngenieroDAO elementoSubclasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ElementoSubclasificacionEquipoIngenieroRepository elementoSubclasificacionEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idElementoSubclasificacionEquipoIngeniero, String keyword, String nombreElementoSubclasificacionEquipoIngeniero) {
        return elementoSubclasificacionEquipoIngenieroRepository.findTotalRegistros(idElementoSubclasificacionEquipoIngeniero, keyword, nombreElementoSubclasificacionEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ElementoSubclasificacionEquipoIngenieroDTO> listarElementosSubclasificacionesEquiposIngenieros(Long idElementoSubclasificacionEquipoIngeniero, String keyword, String nombreElementoSubclasificacionEquipoIngeniero, String orderBy, String orderMode) {
        List<ElementoSubclasificacionEquipoIngeniero> elementosSubclasificacionesEquiposIngenieros = elementoSubclasificacionEquipoIngenieroRepository.findAllElementosSubclasificacionesEquiposIngenieros(idElementoSubclasificacionEquipoIngeniero, keyword, nombreElementoSubclasificacionEquipoIngeniero, orderBy, orderMode);
        List<ElementoSubclasificacionEquipoIngenieroDTO> elementoSubclasificacionEquipoIngenieroDTOS = new ArrayList<>();
        for (ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero : elementosSubclasificacionesEquiposIngenieros) {
            elementoSubclasificacionEquipoIngenieroDTOS.add(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngeniero));
        }
        
        return elementoSubclasificacionEquipoIngenieroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ElementoSubclasificacionEquipoIngenieroDTO> listarElementosSubclasificacionesEquiposIngenierosPag(Pageable pageable, Long idElementoSubclasificacionEquipoIngeniero, String keyword, String nombreElementoSubclasificacionEquipoIngeniero, String orderBy, String orderMode) {
        Slice<ElementoSubclasificacionEquipoIngeniero> elementosSubclasificacionesEquiposIngenieros = elementoSubclasificacionEquipoIngenieroRepository.findAllElementosSubclasificacionesEquiposIngenierosPag(pageable, idElementoSubclasificacionEquipoIngeniero, keyword, nombreElementoSubclasificacionEquipoIngeniero, orderBy, orderMode);
        return elementosSubclasificacionesEquiposIngenieros.map(elementoSubclasificacionEquipoIngeniero -> elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearElementoSubclasificacionEquipoIngeniero(ElementoSubclasificacionEquipoIngenieroDTO elementoSubclasificacionEquipoIngenieroDTO) {
        Long maxIdElementoSubclasificacionEquipoIngeniero = null;
        ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngenieroExistente = elementoSubclasificacionEquipoIngenieroRepository.findByNombreElementoSubclasificacionEquipoIngenieroAndIdSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getNombreElementoSubclasificacionEquipoIngeniero().toUpperCase(), elementoSubclasificacionEquipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(elementoSubclasificacionEquipoIngenieroExistente == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_CLASIFICACION_SUBCLASIFICACION_CUENTA_CLASE_ACTIVO_EQUIPO_INGENIERO_YA_EXISTE, false);
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado == 0)) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdElementoSubclasificacionEquipoIngeniero = elementoSubclasificacionEquipoIngenieroRepository.findMaxIdElementoSubclasificacionEquipoIngeniero();
           if (maxIdElementoSubclasificacionEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdElementoSubclasificacionEquipoIngeniero = Long.valueOf(0);
           }
           elementoSubclasificacionEquipoIngenieroDTO.setIdElementoSubclasificacionEquipoIngeniero(maxIdElementoSubclasificacionEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           elementoSubclasificacionEquipoIngenieroRepository.save(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarElementoSubclasificacionEquipoIngenieroporId(Long idElementoSubclasificacionEquipoIngeniero) {
        Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroId = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(Long.valueOf(idElementoSubclasificacionEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (elementoSubclasificacionEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (elementoSubclasificacionEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE, NOMBRE CLASIFICACION, NOMBRE SUBCLASIFICACION, NOMBRE CUENTA Y NOMBRE CLASE ACTIVO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarElementoSubclasificacionEquipoIngenieroporNombreElementoSubclasificacionEquipoIngenieroYNombreClasificacionEquipoIngenieroYNombreSubclasificacionEquipoIngenieroYNombreCuentaEquipoIngenieroYNombreClaseActivoEquipoIngeniero(String nombreElementoSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreCuentaEquipoIngeniero, String nombreClaseActivoEquipoIngeniero) {
        Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroNombre = Optional.ofNullable(elementoSubclasificacionEquipoIngenieroRepository.findByNombreElementoSubclasificacionEquipoIngenieroAndNombreClasificacionEquipoIngenieroAndNombreSubclasificacionEquipoIngenieroAndNombreCuentaEquipoIngenieroAndNombreClaseActivoEquipoIngeniero(nombreElementoSubclasificacionEquipoIngeniero, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreCuentaEquipoIngeniero, nombreClaseActivoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (elementoSubclasificacionEquipoIngenieroNombre.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO Y SUS RELACIONES EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON LOS NOMBRES PROPORCIONADOS.
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (elementoSubclasificacionEquipoIngenieroNombre.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO Y SUS RELACIONES EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarElementoSubclasificacionEquipoIngeniero(ElementoSubclasificacionEquipoIngenieroDTO elementoSubclasificacionEquipoIngenieroDTO) {
        Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroId = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getIdElementoSubclasificacionEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (elementoSubclasificacionEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ((elementoSubclasificacionEquipoIngenieroDTO.getNombreElementoSubclasificacionEquipoIngeniero().equals(elementoSubclasificacionEquipoIngenieroId.get().getNombreElementoSubclasificacionEquipoIngeniero()) == true)) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero = elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO);
              elementoSubclasificacionEquipoIngenieroRepository.save(elementoSubclasificacionEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (elementoSubclasificacionEquipoIngenieroDTO.getNombreElementoSubclasificacionEquipoIngeniero().equals(elementoSubclasificacionEquipoIngenieroId.get().getNombreElementoSubclasificacionEquipoIngeniero()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngenieroExistente = elementoSubclasificacionEquipoIngenieroRepository.findByNombreElementoSubclasificacionEquipoIngenieroAndIdSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getNombreElementoSubclasificacionEquipoIngeniero().toUpperCase(), elementoSubclasificacionEquipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(elementoSubclasificacionEquipoIngenieroExistente == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_CLASIFICACION_SUBCLASIFICACION_CUENTA_CLASE_ACTIVO_EQUIPO_INGENIERO_YA_EXISTE, false);
                 respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero = elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO);
                 elementoSubclasificacionEquipoIngenieroRepository.save(elementoSubclasificacionEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (elementoSubclasificacionEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarElementoSubclasificacionEquipoIngeniero(Long idElementoSubclasificacionEquipoIngeniero) {
        Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroId = elementoSubclasificacionEquipoIngenieroRepository.findById(idElementoSubclasificacionEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (elementoSubclasificacionEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroId.get()));
           elementoSubclasificacionEquipoIngenieroRepository.delete(elementoSubclasificacionEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (elementoSubclasificacionEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setElementoSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
