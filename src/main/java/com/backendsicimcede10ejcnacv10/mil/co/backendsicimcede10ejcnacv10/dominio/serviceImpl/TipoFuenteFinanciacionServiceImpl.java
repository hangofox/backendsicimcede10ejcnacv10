//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoFuenteFinanciacionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoFuenteFinanciacionService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoFuenteFinanciacionDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoFuenteFinanciacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoFuenteFinanciacionRepository;
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
public class TipoFuenteFinanciacionServiceImpl implements TipoFuenteFinanciacionService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoFuenteFinanciacionDAO tipoFuenteFinanciacionDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoFuenteFinanciacionRepository tipoFuenteFinanciacionRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoFuenteFinanciacion, String keyword) {
        return tipoFuenteFinanciacionRepository.findTotalRegistros(idTipoFuenteFinanciacion, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoFuenteFinanciacionDTO> listarTiposFuentesFinanciaciones(Long idTipoFuenteFinanciacion, String keyword, String orderBy, String orderMode) {
        List<TipoFuenteFinanciacion> tiposFuentesFinanciaciones = tipoFuenteFinanciacionRepository.findAllTiposFuentesFinanciaciones(idTipoFuenteFinanciacion, keyword, orderBy, orderMode);
        List<TipoFuenteFinanciacionDTO> tipoFuenteFinanciacionDTOS = new ArrayList<>();
        
        for (TipoFuenteFinanciacion tipoFuenteFinanciacion : tiposFuentesFinanciaciones){
            tipoFuenteFinanciacionDTOS.add(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFinanciacion));
        }
        
        return tipoFuenteFinanciacionDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoFuenteFinanciacionDTO> listarTiposFuentesFinanciacionesPag(Pageable pageable, Long idTipoFuenteFinanciacion, String keyword, String orderBy, String orderMode) {
        Slice<TipoFuenteFinanciacion> tiposFuentesFinanciaciones = tipoFuenteFinanciacionRepository.findAllTiposFuentesFinanciacionesPag(pageable, idTipoFuenteFinanciacion, keyword, orderBy, orderMode);
        return tiposFuentesFinanciaciones.map(tipoFuenteFinanciacion -> tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFinanciacion));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoFuenteFinanciacion(TipoFuenteFinanciacionDTO tipoFuenteFinanciacionDTO) {
        Long maxIdTipoFuenteFinanciacion=null;
        TipoFuenteFinanciacion tipoFuenteFinanciacionNombre = tipoFuenteFinanciacionRepository.findByNombreTipoFuenteFinanciacion(tipoFuenteFinanciacionDTO.getNombreTipoFuenteFinanciacion().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoFuenteFinanciacionNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoFuenteFinanciacionDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoFuenteFinanciacion = tipoFuenteFinanciacionRepository.findMaxIdTipoFuenteFinanciacion();
           if (maxIdTipoFuenteFinanciacion==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoFuenteFinanciacion=Long.valueOf(0);
           }
           tipoFuenteFinanciacionDTO.setIdTipoFuenteFinanciacion(maxIdTipoFuenteFinanciacion+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoFuenteFinanciacionRepository.save(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacion(tipoFuenteFinanciacionDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoFuenteFinanciacionporId(Long idTipoFuenteFinanciacion) {
        Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionId = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(Long.valueOf(idTipoFuenteFinanciacion));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoFuenteFinanciacionId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoFuenteFinanciacionDTO(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFinanciacionId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoFuenteFinanciacionId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoFuenteFinanciacionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoFuenteFinanciacionporNombre(String nombreTipoFuenteFinanciacion) {
        Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionNombre = Optional.ofNullable(tipoFuenteFinanciacionRepository.findByNombreTipoFuenteFinanciacion(String.valueOf(nombreTipoFuenteFinanciacion)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoFuenteFinanciacionNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoFuenteFinanciacionDTO(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFinanciacionNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoFuenteFinanciacionNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoFuenteFinanciacionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoFuenteFinanciacion(TipoFuenteFinanciacionDTO tipoFuenteFinanciacionDTO) {
        Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionId = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(tipoFuenteFinanciacionDTO.getIdTipoFuenteFinanciacion());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoFuenteFinanciacionId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoFuenteFinanciacionDTO.getNombreTipoFuenteFinanciacion().equals(tipoFuenteFinanciacionId.get().getNombreTipoFuenteFinanciacion())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoFuenteFinanciacion tipoFuenteFinanciacion = tipoFuenteFinanciacionDAO.tipoFuenteFinanciacion(tipoFuenteFinanciacionDTO);
              tipoFuenteFinanciacionRepository.save(tipoFuenteFinanciacion);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoFuenteFinanciacionDTO.getNombreTipoFuenteFinanciacion().equals(tipoFuenteFinanciacionId.get().getNombreTipoFuenteFinanciacion())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoFuenteFinanciacion tipoFuenteFinanciacionNombre = tipoFuenteFinanciacionRepository.findByNombreTipoFuenteFinanciacion(tipoFuenteFinanciacionDTO.getNombreTipoFuenteFinanciacion().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoFuenteFinanciacionNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoFuenteFinanciacionDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoFuenteFinanciacion tipoFuenteFinanciacion = tipoFuenteFinanciacionDAO.tipoFuenteFinanciacion(tipoFuenteFinanciacionDTO);
                 tipoFuenteFinanciacionRepository.save(tipoFuenteFinanciacion);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoFuenteFinanciacionId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoFuenteFinanciacionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoFuenteFinanciacion(Long idTipoFuenteFinanciacion) {
        Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionId  = tipoFuenteFinanciacionRepository.findById(idTipoFuenteFinanciacion);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoFuenteFinanciacionId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoFuenteFinanciacionDTO(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFinanciacionId.get()));
           tipoFuenteFinanciacionRepository.delete(tipoFuenteFinanciacionId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoFuenteFinanciacionId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoFuenteFinanciacionDTO(null);
        }
        
        return respuestaDTO;
    }
}
