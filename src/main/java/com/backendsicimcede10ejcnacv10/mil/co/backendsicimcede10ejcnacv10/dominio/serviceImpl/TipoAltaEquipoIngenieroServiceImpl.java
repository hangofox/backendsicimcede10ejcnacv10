//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoAltaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoAltaEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoAltaEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoAltaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoAltaEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
public class TipoAltaEquipoIngenieroServiceImpl implements TipoAltaEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoAltaEquipoIngenieroDAO tipoAltaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoAltaEquipoIngenieroRepository tipoAltaEquipoIngenieroRepository;
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR KEYWORD DE TIPO ALTA EQUIPO INGENIERO):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idTipoAltaEquipoIngeniero, String keyword) {
        return tipoAltaEquipoIngenieroRepository.findTotalRegistros(idTipoAltaEquipoIngeniero, keyword);
    }
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR KEYWORD DE TIPO ALTA EQUIPO INGENIERO):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoAltaEquipoIngenieroDTO> listarTiposAltasEquiposIngenieros(Long idTipoAltaEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<TipoAltaEquipoIngeniero> tiposAltasEquiposIngenieros = tipoAltaEquipoIngenieroRepository.findAllTiposAltasEquiposIngenieros(idTipoAltaEquipoIngeniero, keyword, orderBy, orderMode);
        List<TipoAltaEquipoIngenieroDTO> tipoAltaEquipoIngenieroDTOS = new ArrayList<>();
        
        for (TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero : tiposAltasEquiposIngenieros){
            tipoAltaEquipoIngenieroDTOS.add(tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngeniero));
        }
        
        return tipoAltaEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR KEYWORD DE TIPO ALTA EQUIPO INGENIERO):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<TipoAltaEquipoIngenieroDTO> listarTiposAltasEquiposIngenierosPag(Pageable pageable, Long idTipoAltaEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<TipoAltaEquipoIngeniero> tiposAltasEquiposIngenieros = tipoAltaEquipoIngenieroRepository.findAllTiposAltasEquiposIngenierosPag(pageable, idTipoAltaEquipoIngeniero, keyword, orderBy, orderMode);
        return tiposAltasEquiposIngenieros.map(tipoAltaEquipoIngeniero -> tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoAltaEquipoIngeniero(TipoAltaEquipoIngenieroDTO tipoAltaEquipoIngenieroDTO) {
        Long maxIdTipoAltaEquipoIngeniero=null;
        TipoAltaEquipoIngeniero tipoAltaEquipoIngenieroNombre = tipoAltaEquipoIngenieroRepository.findByNombreTipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO.getNombreTipoAltaEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoAltaEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoAltaEquipoIngeniero = tipoAltaEquipoIngenieroRepository.findMaxIdTipoAltaEquipoIngeniero();
           if (maxIdTipoAltaEquipoIngeniero==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoAltaEquipoIngeniero=Long.valueOf(0);
           }
           tipoAltaEquipoIngenieroDTO.setIdTipoAltaEquipoIngeniero(maxIdTipoAltaEquipoIngeniero+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoAltaEquipoIngenieroRepository.save(tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoAltaEquipoIngenieroporId(Long idTipoAltaEquipoIngeniero) {
        Optional<TipoAltaEquipoIngeniero> tipoAltaEquipoIngenieroId = tipoAltaEquipoIngenieroRepository.findByIdTipoAltaEquipoIngeniero(Long.valueOf(idTipoAltaEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoAltaEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoAltaEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoAltaEquipoIngenieroporNombre(String nombreTipoAltaEquipoIngeniero) {
        Optional<TipoAltaEquipoIngeniero> tipoAltaEquipoIngenieroNombre = Optional.ofNullable(tipoAltaEquipoIngenieroRepository.findByNombreTipoAltaEquipoIngeniero(String.valueOf(nombreTipoAltaEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoAltaEquipoIngenieroNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoAltaEquipoIngenieroNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoAltaEquipoIngeniero(TipoAltaEquipoIngenieroDTO tipoAltaEquipoIngenieroDTO) {
        Optional<TipoAltaEquipoIngeniero> tipoAltaEquipoIngenieroId = tipoAltaEquipoIngenieroRepository.findByIdTipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO.getIdTipoAltaEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoAltaEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoAltaEquipoIngenieroDTO.getNombreTipoAltaEquipoIngeniero().equals(tipoAltaEquipoIngenieroId.get().getNombreTipoAltaEquipoIngeniero())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero = tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO);
              tipoAltaEquipoIngenieroRepository.save(tipoAltaEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoAltaEquipoIngenieroDTO.getNombreTipoAltaEquipoIngeniero().equals(tipoAltaEquipoIngenieroId.get().getNombreTipoAltaEquipoIngeniero())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoAltaEquipoIngeniero tipoAltaEquipoIngenieroNombre = tipoAltaEquipoIngenieroRepository.findByNombreTipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO.getNombreTipoAltaEquipoIngeniero().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoAltaEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoAltaEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero = tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO);
                 tipoAltaEquipoIngenieroRepository.save(tipoAltaEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoAltaEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoAltaEquipoIngeniero(Long idTipoAltaEquipoIngeniero) {
        Optional<TipoAltaEquipoIngeniero> tipoAltaEquipoIngenieroId  = tipoAltaEquipoIngenieroRepository.findById(idTipoAltaEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoAltaEquipoIngenieroId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngenieroId.get()));
           tipoAltaEquipoIngenieroRepository.delete(tipoAltaEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoAltaEquipoIngenieroId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
