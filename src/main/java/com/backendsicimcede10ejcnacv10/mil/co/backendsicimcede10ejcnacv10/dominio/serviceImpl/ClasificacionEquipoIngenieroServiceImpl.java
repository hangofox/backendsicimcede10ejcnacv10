//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ClasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ClasificacionEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ClasificacionEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClasificacionEquipoIngenieroRepository;
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
public class ClasificacionEquipoIngenieroServiceImpl implements ClasificacionEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ClasificacionEquipoIngenieroDAO clasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ClasificacionEquipoIngenieroRepository clasificacionEquipoIngenieroRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idClasificacionEquipoIngeniero, String keyword) {
        return clasificacionEquipoIngenieroRepository.findTotalRegistros(idClasificacionEquipoIngeniero, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ClasificacionEquipoIngenieroDTO> listarClasificacionesEquiposIngenieros(Long idClasificacionEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<ClasificacionEquipoIngeniero> clasificacionesEquiposIngenieros = clasificacionEquipoIngenieroRepository.findAllClasificacionesEquiposIngenieros(idClasificacionEquipoIngeniero, keyword, orderBy, orderMode);
        List<ClasificacionEquipoIngenieroDTO> clasificacionEquipoIngenieroDTOS = new ArrayList<>();
        
        for (ClasificacionEquipoIngeniero clasificacionEquipoIngeniero : clasificacionesEquiposIngenieros){
            clasificacionEquipoIngenieroDTOS.add(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasificacionEquipoIngeniero));
        }
        
        return clasificacionEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ClasificacionEquipoIngenieroDTO> listarClasificacionesEquiposIngenierosPag(Pageable pageable, Long idClasificacionEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<ClasificacionEquipoIngeniero> clasificacionesEquiposIngenieros = clasificacionEquipoIngenieroRepository.findAllClasificacionesEquiposIngenierosPag(pageable, idClasificacionEquipoIngeniero, keyword, orderBy, orderMode);
        return clasificacionesEquiposIngenieros.map(clasificacionEquipoIngeniero -> clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasificacionEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearClasificacionEquipoIngeniero(ClasificacionEquipoIngenieroDTO clasificacionEquipoIngenieroDTO) {
        Long maxIdClasificacionEquipoIngeniero=null;
        ClasificacionEquipoIngeniero clasificacionEquipoIngenieroNombre = clasificacionEquipoIngenieroRepository.findByNombreClasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO.getNombreClasificacionEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(clasificacionEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setClasificacionEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdClasificacionEquipoIngeniero = clasificacionEquipoIngenieroRepository.findMaxIdClasificacionEquipoIngeniero();
           if (maxIdClasificacionEquipoIngeniero==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdClasificacionEquipoIngeniero=Long.valueOf(0);
           }
           clasificacionEquipoIngenieroDTO.setIdClasificacionEquipoIngeniero(maxIdClasificacionEquipoIngeniero+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           clasificacionEquipoIngenieroRepository.save(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarClasificacionEquipoIngenieroporId(Long idClasificacionEquipoIngeniero) {
        Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroId = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(Long.valueOf(idClasificacionEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (clasificacionEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (clasificacionEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setClasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarClasificacionEquipoIngenieroporNombre(String nombreClasificacionEquipoIngeniero) {
        Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroNombre = Optional.ofNullable(clasificacionEquipoIngenieroRepository.findByNombreClasificacionEquipoIngeniero(String.valueOf(nombreClasificacionEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (clasificacionEquipoIngenieroNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (clasificacionEquipoIngenieroNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setClasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarClasificacionEquipoIngeniero(ClasificacionEquipoIngenieroDTO clasificacionEquipoIngenieroDTO) {
        Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroId = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO.getIdClasificacionEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (clasificacionEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (clasificacionEquipoIngenieroDTO.getNombreClasificacionEquipoIngeniero().equals(clasificacionEquipoIngenieroId.get().getNombreClasificacionEquipoIngeniero())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ClasificacionEquipoIngeniero clasificacionEquipoIngeniero = clasificacionEquipoIngenieroDAO.clasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO);
              clasificacionEquipoIngenieroRepository.save(clasificacionEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (clasificacionEquipoIngenieroDTO.getNombreClasificacionEquipoIngeniero().equals(clasificacionEquipoIngenieroId.get().getNombreClasificacionEquipoIngeniero())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              ClasificacionEquipoIngeniero clasificacionEquipoIngenieroNombre = clasificacionEquipoIngenieroRepository.findByNombreClasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO.getNombreClasificacionEquipoIngeniero().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(clasificacionEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setClasificacionEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 ClasificacionEquipoIngeniero clasificacionEquipoIngeniero = clasificacionEquipoIngenieroDAO.clasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO);
                 clasificacionEquipoIngenieroRepository.save(clasificacionEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (clasificacionEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setClasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarClasificacionEquipoIngeniero(Long idClasificacionEquipoIngeniero) {
        Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroId = clasificacionEquipoIngenieroRepository.findById(idClasificacionEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (clasificacionEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroId.get()));
           clasificacionEquipoIngenieroRepository.delete(clasificacionEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (clasificacionEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setClasificacionEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
