//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoMantenimientoEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoMantenimientoEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoMantenimientoEquipoIngenieroRepository;
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
public class TipoMantenimientoEquipoIngenieroServiceImpl implements TipoMantenimientoEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoMantenimientoEquipoIngenieroDAO tipoMantenimientoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoMantenimientoEquipoIngenieroRepository tipoMantenimientoEquipoIngenieroRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoMantenimientoEquipoIngeniero, String keyword) {
        return tipoMantenimientoEquipoIngenieroRepository.findTotalRegistros(idTipoMantenimientoEquipoIngeniero, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoMantenimientoEquipoIngenieroDTO> listarTiposMantenimientosEquiposIngenieros(Long idTipoMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<TipoMantenimientoEquipoIngeniero> tiposMantenimientosEquiposIngenieros = tipoMantenimientoEquipoIngenieroRepository.findAllTiposMantenimientosEquiposIngenieros(idTipoMantenimientoEquipoIngeniero, keyword, orderBy, orderMode);
        List<TipoMantenimientoEquipoIngenieroDTO> tipoMantenimientoEquipoIngenieroDTOS = new ArrayList<>();
        
        for (TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero : tiposMantenimientosEquiposIngenieros){
            tipoMantenimientoEquipoIngenieroDTOS.add(tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngeniero));
        }
        
        return tipoMantenimientoEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoMantenimientoEquipoIngenieroDTO> listarTiposMantenimientosEquiposIngenierosPag(Pageable pageable, Long idTipoMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<TipoMantenimientoEquipoIngeniero> tiposMantenimientosEquiposIngenieros = tipoMantenimientoEquipoIngenieroRepository.findAllTiposMantenimientosEquiposIngenierosPag(pageable, idTipoMantenimientoEquipoIngeniero, keyword, orderBy, orderMode);
        return tiposMantenimientosEquiposIngenieros.map(tipoMantenimientoEquipoIngeniero -> tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoMantenimientoEquipoIngeniero(TipoMantenimientoEquipoIngenieroDTO tipoMantenimientoEquipoIngenieroDTO) {
        Long maxIdTipoMantenimientoEquipoIngeniero=null;
        TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngenieroNombre = tipoMantenimientoEquipoIngenieroRepository.findByNombreTipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO.getNombreTipoMantenimientoEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoMantenimientoEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoMantenimientoEquipoIngeniero = tipoMantenimientoEquipoIngenieroRepository.findMaxIdTipoMantenimientoEquipoIngeniero();
           if (maxIdTipoMantenimientoEquipoIngeniero==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoMantenimientoEquipoIngeniero=Long.valueOf(0);
           }
           tipoMantenimientoEquipoIngenieroDTO.setIdTipoMantenimientoEquipoIngeniero(maxIdTipoMantenimientoEquipoIngeniero+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoMantenimientoEquipoIngenieroRepository.save(tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoMantenimientoEquipoIngenieroporId(Long idTipoMantenimientoEquipoIngeniero) {
        Optional<TipoMantenimientoEquipoIngeniero> tipoMantenimientoEquipoIngenieroId = tipoMantenimientoEquipoIngenieroRepository.findByIdTipoMantenimientoEquipoIngeniero(Long.valueOf(idTipoMantenimientoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoMantenimientoEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoMantenimientoEquipoIngenieroporNombre(String nombreTipoMantenimientoEquipoIngeniero) {
        Optional<TipoMantenimientoEquipoIngeniero> tipoMantenimientoEquipoIngenieroNombre = Optional.ofNullable(tipoMantenimientoEquipoIngenieroRepository.findByNombreTipoMantenimientoEquipoIngeniero(String.valueOf(nombreTipoMantenimientoEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoEquipoIngenieroNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoMantenimientoEquipoIngenieroNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoMantenimientoEquipoIngeniero(TipoMantenimientoEquipoIngenieroDTO tipoMantenimientoEquipoIngenieroDTO) {
        Optional<TipoMantenimientoEquipoIngeniero> tipoMantenimientoEquipoIngenieroId = tipoMantenimientoEquipoIngenieroRepository.findByIdTipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO.getIdTipoMantenimientoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoMantenimientoEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoMantenimientoEquipoIngenieroDTO.getNombreTipoMantenimientoEquipoIngeniero().equals(tipoMantenimientoEquipoIngenieroId.get().getNombreTipoMantenimientoEquipoIngeniero())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero = tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO);
              tipoMantenimientoEquipoIngenieroRepository.save(tipoMantenimientoEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoMantenimientoEquipoIngenieroDTO.getNombreTipoMantenimientoEquipoIngeniero().equals(tipoMantenimientoEquipoIngenieroId.get().getNombreTipoMantenimientoEquipoIngeniero())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngenieroNombre = tipoMantenimientoEquipoIngenieroRepository.findByNombreTipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO.getNombreTipoMantenimientoEquipoIngeniero().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoMantenimientoEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero = tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO);
                 tipoMantenimientoEquipoIngenieroRepository.save(tipoMantenimientoEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoMantenimientoEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoMantenimientoEquipoIngeniero(Long idTipoMantenimientoEquipoIngeniero) {
        Optional<TipoMantenimientoEquipoIngeniero> tipoMantenimientoEquipoIngenieroId  = tipoMantenimientoEquipoIngenieroRepository.findById(idTipoMantenimientoEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoEquipoIngenieroId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngenieroId.get()));
           tipoMantenimientoEquipoIngenieroRepository.delete(tipoMantenimientoEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoMantenimientoEquipoIngenieroId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
