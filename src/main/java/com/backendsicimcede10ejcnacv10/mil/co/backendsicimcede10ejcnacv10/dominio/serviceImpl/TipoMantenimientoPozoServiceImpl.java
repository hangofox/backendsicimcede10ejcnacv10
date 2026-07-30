//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoMantenimientoPozoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoMantenimientoPozoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoMantenimientoPozoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoPozo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoMantenimientoPozoRepository;
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
public class TipoMantenimientoPozoServiceImpl implements TipoMantenimientoPozoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoMantenimientoPozoDAO tipoMantenimientoPozoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoMantenimientoPozoRepository tipoMantenimientoPozoRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoMantenimientoPozo, String keyword) {
        return tipoMantenimientoPozoRepository.findTotalRegistros(idTipoMantenimientoPozo, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoMantenimientoPozoDTO> listarTiposMantenimientosPozos(Long idTipoMantenimientoPozo, String keyword, String orderBy, String orderMode) {
        List<TipoMantenimientoPozo> tiposMantenimientosPozos = tipoMantenimientoPozoRepository.findAllTiposMantenimientosPozos(idTipoMantenimientoPozo, keyword, orderBy, orderMode);
        List<TipoMantenimientoPozoDTO> tipoMantenimientoPozoDTOS = new ArrayList<>();
        
        for (TipoMantenimientoPozo tipoMantenimientoPozo : tiposMantenimientosPozos){
            tipoMantenimientoPozoDTOS.add(tipoMantenimientoPozoDAO.tipoMantenimientoPozoDTO(tipoMantenimientoPozo));
        }
        
        return tipoMantenimientoPozoDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoMantenimientoPozoDTO> listarTiposMantenimientosPozosPag(Pageable pageable, Long idTipoMantenimientoPozo, String keyword, String orderBy, String orderMode) {
        Slice<TipoMantenimientoPozo> tiposMantenimientosPozos = tipoMantenimientoPozoRepository.findAllTiposMantenimientosPozosPag(pageable, idTipoMantenimientoPozo, keyword, orderBy, orderMode);
        return tiposMantenimientosPozos.map(tipoMantenimientoPozo -> tipoMantenimientoPozoDAO.tipoMantenimientoPozoDTO(tipoMantenimientoPozo));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoMantenimientoPozo(TipoMantenimientoPozoDTO tipoMantenimientoPozoDTO) {
        Long maxIdTipoMantenimientoPozo=null;
        TipoMantenimientoPozo tipoMantenimientoPozoNombre = tipoMantenimientoPozoRepository.findByNombreTipoMantenimientoPozo(tipoMantenimientoPozoDTO.getNombreTipoMantenimientoPozo().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoMantenimientoPozoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoMantenimientoPozoDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoMantenimientoPozo = tipoMantenimientoPozoRepository.findMaxIdTipoMantenimientoPozo();
           if (maxIdTipoMantenimientoPozo==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoMantenimientoPozo=Long.valueOf(0);
           }
           tipoMantenimientoPozoDTO.setIdTipoMantenimientoPozo(maxIdTipoMantenimientoPozo+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoMantenimientoPozoRepository.save(tipoMantenimientoPozoDAO.tipoMantenimientoPozo(tipoMantenimientoPozoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoMantenimientoPozoporId(Long idTipoMantenimientoPozo) {
        Optional<TipoMantenimientoPozo> tipoMantenimientoPozoId = tipoMantenimientoPozoRepository.findByIdTipoMantenimientoPozo(Long.valueOf(idTipoMantenimientoPozo));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoPozoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoPozoDTO(tipoMantenimientoPozoDAO.tipoMantenimientoPozoDTO(tipoMantenimientoPozoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoMantenimientoPozoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoPozoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoMantenimientoPozoporNombre(String nombreTipoMantenimientoPozo) {
        Optional<TipoMantenimientoPozo> tipoMantenimientoPozoNombre = Optional.ofNullable(tipoMantenimientoPozoRepository.findByNombreTipoMantenimientoPozo(String.valueOf(nombreTipoMantenimientoPozo)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoPozoNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoPozoDTO(tipoMantenimientoPozoDAO.tipoMantenimientoPozoDTO(tipoMantenimientoPozoNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoMantenimientoPozoNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoPozoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoMantenimientoPozo(TipoMantenimientoPozoDTO tipoMantenimientoPozoDTO) {
        Optional<TipoMantenimientoPozo> tipoMantenimientoPozoId = tipoMantenimientoPozoRepository.findByIdTipoMantenimientoPozo(tipoMantenimientoPozoDTO.getIdTipoMantenimientoPozo());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoMantenimientoPozoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoMantenimientoPozoDTO.getNombreTipoMantenimientoPozo().equals(tipoMantenimientoPozoId.get().getNombreTipoMantenimientoPozo())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoMantenimientoPozo tipoMantenimientoPozo = tipoMantenimientoPozoDAO.tipoMantenimientoPozo(tipoMantenimientoPozoDTO);
              tipoMantenimientoPozoRepository.save(tipoMantenimientoPozo);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoMantenimientoPozoDTO.getNombreTipoMantenimientoPozo().equals(tipoMantenimientoPozoId.get().getNombreTipoMantenimientoPozo())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoMantenimientoPozo tipoMantenimientoPozoNombre = tipoMantenimientoPozoRepository.findByNombreTipoMantenimientoPozo(tipoMantenimientoPozoDTO.getNombreTipoMantenimientoPozo().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoMantenimientoPozoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoMantenimientoPozoDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoMantenimientoPozo tipoMantenimientoPozo = tipoMantenimientoPozoDAO.tipoMantenimientoPozo(tipoMantenimientoPozoDTO);
                 tipoMantenimientoPozoRepository.save(tipoMantenimientoPozo);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoMantenimientoPozoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoMantenimientoPozoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoMantenimientoPozo(Long idTipoMantenimientoPozo) {
        Optional<TipoMantenimientoPozo> tipoMantenimientoPozoId  = tipoMantenimientoPozoRepository.findById(idTipoMantenimientoPozo);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoPozoId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoPozoDTO(tipoMantenimientoPozoDAO.tipoMantenimientoPozoDTO(tipoMantenimientoPozoId.get()));
           tipoMantenimientoPozoRepository.delete(tipoMantenimientoPozoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoMantenimientoPozoId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoPozoDTO(null);
        }
        
        return respuestaDTO;
    }
}
