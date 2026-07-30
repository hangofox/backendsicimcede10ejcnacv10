//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoRequerimientoApoyoAtencionPrevencionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoRequerimientoApoyoAtencionPrevencionService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoRequerimientoApoyoAtencionPrevencionDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoRequerimientoApoyoAtencionPrevencion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoRequerimientoApoyoAtencionPrevencionRepository;
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
public class TipoRequerimientoApoyoAtencionPrevencionServiceImpl implements TipoRequerimientoApoyoAtencionPrevencionService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoRequerimientoApoyoAtencionPrevencionDAO tipoRequerimientoApoyoAtencionPrevencionDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoRequerimientoApoyoAtencionPrevencionRepository tipoRequerimientoApoyoAtencionPrevencionRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoRequerimientoApoyoAtencionPrevencion, String keyword) {
        return tipoRequerimientoApoyoAtencionPrevencionRepository.findTotalRegistros(idTipoRequerimientoApoyoAtencionPrevencion, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoRequerimientoApoyoAtencionPrevencionDTO> listarTiposRequerimientosApoyosAtencionPrevencion(Long idTipoRequerimientoApoyoAtencionPrevencion, String keyword, String orderBy, String orderMode) {
        List<TipoRequerimientoApoyoAtencionPrevencion> tiposRequerimientosApoyosAtencionesPrevenciones = tipoRequerimientoApoyoAtencionPrevencionRepository.findAllTiposRequerimientosApoyosAtencionPrevencion(idTipoRequerimientoApoyoAtencionPrevencion, keyword, orderBy, orderMode);
        List<TipoRequerimientoApoyoAtencionPrevencionDTO> tipoRequerimientoApoyoAtencionPrevencionDTOS = new ArrayList<>();
        
        for (TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion : tiposRequerimientosApoyosAtencionesPrevenciones){
            tipoRequerimientoApoyoAtencionPrevencionDTOS.add(tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencion));
        }
        
        return tipoRequerimientoApoyoAtencionPrevencionDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoRequerimientoApoyoAtencionPrevencionDTO> listarTiposRequerimientosApoyosAtencionPrevencionPag(Pageable pageable, Long idTipoRequerimientoApoyoAtencionPrevencion, String keyword, String orderBy, String orderMode) {
        Slice<TipoRequerimientoApoyoAtencionPrevencion> tiposRequerimientosApoyosAtencionesPrevenciones = tipoRequerimientoApoyoAtencionPrevencionRepository.findAllTiposRequerimientosApoyosAtencionPrevencionPag(pageable, idTipoRequerimientoApoyoAtencionPrevencion, keyword, orderBy, orderMode);
        return tiposRequerimientosApoyosAtencionesPrevenciones.map(tipoRequerimientoApoyoAtencionPrevencion -> tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencion));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoRequerimientoApoyoAtencionPrevencion(TipoRequerimientoApoyoAtencionPrevencionDTO tipoRequerimientoApoyoAtencionPrevencionDTO) {
        Long maxIdTipoRequerimientoApoyoAtencionPrevencion=null;
        TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencionNombre = tipoRequerimientoApoyoAtencionPrevencionRepository.findByNombreTipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO.getNombreTipoRequerimientoApoyoAtencionPrevencion().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoRequerimientoApoyoAtencionPrevencionNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoRequerimientoApoyoAtencionPrevencion = tipoRequerimientoApoyoAtencionPrevencionRepository.findMaxIdTipoRequerimientoApoyoAtencionPrevencion();
           if (maxIdTipoRequerimientoApoyoAtencionPrevencion==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoRequerimientoApoyoAtencionPrevencion=Long.valueOf(0);
           }
           tipoRequerimientoApoyoAtencionPrevencionDTO.setIdTipoRequerimientoApoyoAtencionPrevencion(maxIdTipoRequerimientoApoyoAtencionPrevencion+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoRequerimientoApoyoAtencionPrevencionRepository.save(tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoRequerimientoApoyoAtencionPrevencionporId(Long idTipoRequerimientoApoyoAtencionPrevencion) {
        Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionId = tipoRequerimientoApoyoAtencionPrevencionRepository.findByIdTipoRequerimientoApoyoAtencionPrevencion(Long.valueOf(idTipoRequerimientoApoyoAtencionPrevencion));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoRequerimientoApoyoAtencionPrevencionId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoRequerimientoApoyoAtencionPrevencionId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoRequerimientoApoyoAtencionPrevencionporNombre(String nombreTipoRequerimientoApoyoAtencionPrevencion) {
        Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionNombre = Optional.ofNullable(tipoRequerimientoApoyoAtencionPrevencionRepository.findByNombreTipoRequerimientoApoyoAtencionPrevencion(String.valueOf(nombreTipoRequerimientoApoyoAtencionPrevencion)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoRequerimientoApoyoAtencionPrevencionNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoRequerimientoApoyoAtencionPrevencionNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoRequerimientoApoyoAtencionPrevencion(TipoRequerimientoApoyoAtencionPrevencionDTO tipoRequerimientoApoyoAtencionPrevencionDTO) {
        Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionId = tipoRequerimientoApoyoAtencionPrevencionRepository.findByIdTipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO.getIdTipoRequerimientoApoyoAtencionPrevencion());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoRequerimientoApoyoAtencionPrevencionId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoRequerimientoApoyoAtencionPrevencionDTO.getNombreTipoRequerimientoApoyoAtencionPrevencion().equals(tipoRequerimientoApoyoAtencionPrevencionId.get().getNombreTipoRequerimientoApoyoAtencionPrevencion())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion = tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO);
              tipoRequerimientoApoyoAtencionPrevencionRepository.save(tipoRequerimientoApoyoAtencionPrevencion);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoRequerimientoApoyoAtencionPrevencionDTO.getNombreTipoRequerimientoApoyoAtencionPrevencion().equals(tipoRequerimientoApoyoAtencionPrevencionId.get().getNombreTipoRequerimientoApoyoAtencionPrevencion())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencionNombre = tipoRequerimientoApoyoAtencionPrevencionRepository.findByNombreTipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO.getNombreTipoRequerimientoApoyoAtencionPrevencion().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoRequerimientoApoyoAtencionPrevencionNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion = tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO);
                 tipoRequerimientoApoyoAtencionPrevencionRepository.save(tipoRequerimientoApoyoAtencionPrevencion);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoRequerimientoApoyoAtencionPrevencionId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoRequerimientoApoyoAtencionPrevencion(Long idTipoRequerimientoApoyoAtencionPrevencion) {
        Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionId  = tipoRequerimientoApoyoAtencionPrevencionRepository.findById(idTipoRequerimientoApoyoAtencionPrevencion);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoRequerimientoApoyoAtencionPrevencionId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionId.get()));
           tipoRequerimientoApoyoAtencionPrevencionRepository.delete(tipoRequerimientoApoyoAtencionPrevencionId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoRequerimientoApoyoAtencionPrevencionId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(null);
        }
        
        return respuestaDTO;
    }
}
