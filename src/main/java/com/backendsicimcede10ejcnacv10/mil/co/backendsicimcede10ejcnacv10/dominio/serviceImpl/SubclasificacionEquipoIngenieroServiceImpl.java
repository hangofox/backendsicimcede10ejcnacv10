//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SubclasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.SubclasificacionEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.SubclasificacionEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SubclasificacionEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class SubclasificacionEquipoIngenieroServiceImpl implements SubclasificacionEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private SubclasificacionEquipoIngenieroDAO subclasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SubclasificacionEquipoIngenieroRepository subclasificacionEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idSubclasificacionEquipoIngeniero, String keyword, String nombreSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero) {
        return subclasificacionEquipoIngenieroRepository.findTotalRegistros(idSubclasificacionEquipoIngeniero, keyword, nombreSubclasificacionEquipoIngeniero, nombreClasificacionEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<SubclasificacionEquipoIngenieroDTO> listarSubclasificacionesEquiposIngenieros(Long idSubclasificacionEquipoIngeniero, String keyword, String nombreSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero, String orderBy, String orderMode) {
        List<SubclasificacionEquipoIngeniero> subclasificacionesEquiposIngenieros = subclasificacionEquipoIngenieroRepository.findAllSubclasificacionesEquiposIngenieros(idSubclasificacionEquipoIngeniero, keyword, nombreSubclasificacionEquipoIngeniero, nombreClasificacionEquipoIngeniero, orderBy, orderMode);
        List<SubclasificacionEquipoIngenieroDTO> subclasificacionEquipoIngenieroDTOS = new ArrayList<>();
        for (SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero : subclasificacionesEquiposIngenieros) {
            subclasificacionEquipoIngenieroDTOS.add(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngeniero));
        }
        
        return subclasificacionEquipoIngenieroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<SubclasificacionEquipoIngenieroDTO> listarSubclasificacionesEquiposIngenierosPag(Pageable pageable, Long idSubclasificacionEquipoIngeniero, String keyword, String nombreSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero, String orderBy, String orderMode) {
        Slice<SubclasificacionEquipoIngeniero> subclasificacionesEquiposIngenieros = subclasificacionEquipoIngenieroRepository.findAllSubclasificacionesEquiposIngenierosPag(pageable, idSubclasificacionEquipoIngeniero, keyword, nombreSubclasificacionEquipoIngeniero, nombreClasificacionEquipoIngeniero, orderBy, orderMode);
        return subclasificacionesEquiposIngenieros.map(subclasificacionEquipoIngeniero -> subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearSubclasificacionEquipoIngeniero(SubclasificacionEquipoIngenieroDTO subclasificacionEquipoIngenieroDTO) {
        Long maxIdSubclasificacionEquipoIngeniero = null;
        SubclasificacionEquipoIngeniero subclasificacionEquipoIngenieroNombreSubclasificacionyNombreClasificacion = subclasificacionEquipoIngenieroRepository.findByNombreSubclasificacionEquipoIngenieroAndNombreClasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO.getNombreSubclasificacionEquipoIngeniero(), subclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getNombreClasificacionEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(subclasificacionEquipoIngenieroNombreSubclasificacionyNombreClasificacion == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_CLASIFICACION_YA_EXISTE, false);
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado == 0)) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdSubclasificacionEquipoIngeniero = subclasificacionEquipoIngenieroRepository.findMaxIdSubclasificacionEquipoIngeniero();
           if (maxIdSubclasificacionEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdSubclasificacionEquipoIngeniero = Long.valueOf(0);
           }
           subclasificacionEquipoIngenieroDTO.setIdSubclasificacionEquipoIngeniero(maxIdSubclasificacionEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           subclasificacionEquipoIngenieroRepository.save(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSubclasificacionEquipoIngenieroporId(Long idSubclasificacionEquipoIngeniero) {
        Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroId = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(Long.valueOf(idSubclasificacionEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (subclasificacionEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (subclasificacionEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y NOMBRE DE LA CLASIFICACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSubclasificacionEquipoIngenieroporNombreSubclasificacionEquipoIngenieroYNombreClasificacionEquipoIngeniero(String nombreSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero) {
        Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroNombreyNombreTipoDocumentoIdentificacion = Optional.ofNullable(subclasificacionEquipoIngenieroRepository.findByNombreSubclasificacionEquipoIngenieroAndNombreClasificacionEquipoIngeniero(nombreSubclasificacionEquipoIngeniero, nombreClasificacionEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (subclasificacionEquipoIngenieroNombreyNombreTipoDocumentoIdentificacion.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE Y NOMBRE PROPORCIONADO.
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroNombreyNombreTipoDocumentoIdentificacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (subclasificacionEquipoIngenieroNombreyNombreTipoDocumentoIdentificacion.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE Y NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarSubclasificacionEquipoIngeniero(SubclasificacionEquipoIngenieroDTO subclasificacionEquipoIngenieroDTO) {
        Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroId = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO.getIdSubclasificacionEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (subclasificacionEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ((subclasificacionEquipoIngenieroDTO.getNombreSubclasificacionEquipoIngeniero().equals(subclasificacionEquipoIngenieroId.get().getNombreSubclasificacionEquipoIngeniero()) == true)) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero = subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO);
              subclasificacionEquipoIngenieroRepository.save(subclasificacionEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (subclasificacionEquipoIngenieroDTO.getNombreSubclasificacionEquipoIngeniero().equals(subclasificacionEquipoIngenieroId.get().getNombreSubclasificacionEquipoIngeniero()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              SubclasificacionEquipoIngeniero subclasificacionEquipoIngenieroNombreSubclasificacionyNombreClasificacion = subclasificacionEquipoIngenieroRepository.findByNombreSubclasificacionEquipoIngenieroAndNombreClasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO.getNombreSubclasificacionEquipoIngeniero(), subclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getNombreClasificacionEquipoIngeniero());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(subclasificacionEquipoIngenieroNombreSubclasificacionyNombreClasificacion == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_CLASIFICACION_YA_EXISTE, false);
                 respuestaDTO.setSubclasificacionEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero = subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO);
                 subclasificacionEquipoIngenieroRepository.save(subclasificacionEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (subclasificacionEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarSubclasificacionEquipoIngeniero(Long idSubclasificacionEquipoIngeniero) {
        Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroId = subclasificacionEquipoIngenieroRepository.findById(idSubclasificacionEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (subclasificacionEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroId.get()));
           subclasificacionEquipoIngenieroRepository.delete(subclasificacionEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (subclasificacionEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSubclasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
