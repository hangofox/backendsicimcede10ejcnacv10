//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoBajaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoDocumentoAnexoBajaEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoDocumentoAnexoBajaEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoBajaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoAnexoBajaEquipoIngenieroRepository;
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
public class TipoDocumentoAnexoBajaEquipoIngenieroServiceImpl implements TipoDocumentoAnexoBajaEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoAnexoBajaEquipoIngenieroDAO tipoDocumentoAnexoBajaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoAnexoBajaEquipoIngenieroRepository tipoDocumentoAnexoBajaEquipoIngenieroRepository;
    
    //CONTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR REGISTROS.
    public Long contarTotalRegistros(Long idTipoDocumentoAnexoBajaEquipoIngeniero, String keyword) {
        return tipoDocumentoAnexoBajaEquipoIngenieroRepository.findTotalRegistros(idTipoDocumentoAnexoBajaEquipoIngeniero, keyword);
    }
    
    //LISTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoDocumentoAnexoBajaEquipoIngenieroDTO> listarTiposDocumentosAnexosBajasEquiposIngenieros(Long idTipoDocumentoAnexoBajaEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<TipoDocumentoAnexoBajaEquipoIngeniero> tiposDocumentosAnexosBajasEquiposIngenieros = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findAllTiposDocumentosAnexosBajasEquiposIngenieros(idTipoDocumentoAnexoBajaEquipoIngeniero, keyword, orderBy, orderMode);
        List<TipoDocumentoAnexoBajaEquipoIngenieroDTO> tipoDocumentoAnexoBajaEquipoIngenieroDTOS = new ArrayList<>();
        
        for (TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero : tiposDocumentosAnexosBajasEquiposIngenieros){
            tipoDocumentoAnexoBajaEquipoIngenieroDTOS.add(tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngeniero));
        }
        
        return tipoDocumentoAnexoBajaEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS FILTRADOS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoDocumentoAnexoBajaEquipoIngenieroDTO> listarTiposDocumentosAnexosBajasEquiposIngenierosPag(Pageable pageable, Long idTipoDocumentoAnexoBajaEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<TipoDocumentoAnexoBajaEquipoIngeniero> tiposDocumentosAnexosBajasEquiposIngenieros = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findAllTiposDocumentosAnexosBajasEquiposIngenierosPag(pageable, idTipoDocumentoAnexoBajaEquipoIngeniero, keyword, orderBy, orderMode);
        return tiposDocumentosAnexosBajasEquiposIngenieros.map(tipoDocumentoAnexoBajaEquipoIngeniero -> tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoDocumentoAnexoBajaEquipoIngeniero(TipoDocumentoAnexoBajaEquipoIngenieroDTO tipoDocumentoAnexoBajaEquipoIngenieroDTO) {
        Long maxIdTipoDocumentoAnexoBajaEquipoIngeniero=null;
        TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngenieroNombre = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findByNombreTipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoBajaEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoDocumentoAnexoBajaEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoDocumentoAnexoBajaEquipoIngeniero = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findMaxIdTipoDocumentoAnexoBajaEquipoIngeniero();
           if (maxIdTipoDocumentoAnexoBajaEquipoIngeniero==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoDocumentoAnexoBajaEquipoIngeniero=Long.valueOf(0);
           }
           tipoDocumentoAnexoBajaEquipoIngenieroDTO.setIdTipoDocumentoAnexoBajaEquipoIngeniero(maxIdTipoDocumentoAnexoBajaEquipoIngeniero+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoDocumentoAnexoBajaEquipoIngenieroRepository.save(tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDocumentoAnexoBajaEquipoIngenieroporId(Long idTipoDocumentoAnexoBajaEquipoIngeniero) {
        Optional<TipoDocumentoAnexoBajaEquipoIngeniero> tipoDocumentoAnexoBajaEquipoIngenieroId = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoBajaEquipoIngeniero(Long.valueOf(idTipoDocumentoAnexoBajaEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoBajaEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDocumentoAnexoBajaEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDocumentoAnexoBajaEquipoIngenieroporNombre(String nombreTipoDocumentoAnexoBajaEquipoIngeniero) {
        Optional<TipoDocumentoAnexoBajaEquipoIngeniero> tipoDocumentoAnexoBajaEquipoIngenieroNombre = Optional.ofNullable(tipoDocumentoAnexoBajaEquipoIngenieroRepository.findByNombreTipoDocumentoAnexoBajaEquipoIngeniero(String.valueOf(nombreTipoDocumentoAnexoBajaEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoBajaEquipoIngenieroNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDocumentoAnexoBajaEquipoIngenieroNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoDocumentoAnexoBajaEquipoIngeniero(TipoDocumentoAnexoBajaEquipoIngenieroDTO tipoDocumentoAnexoBajaEquipoIngenieroDTO) {
        Optional<TipoDocumentoAnexoBajaEquipoIngeniero> tipoDocumentoAnexoBajaEquipoIngenieroId = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO.getIdTipoDocumentoAnexoBajaEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoDocumentoAnexoBajaEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoDocumentoAnexoBajaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoBajaEquipoIngeniero().equals(tipoDocumentoAnexoBajaEquipoIngenieroId.get().getNombreTipoDocumentoAnexoBajaEquipoIngeniero())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero = tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO);
              tipoDocumentoAnexoBajaEquipoIngenieroRepository.save(tipoDocumentoAnexoBajaEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoDocumentoAnexoBajaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoBajaEquipoIngeniero().equals(tipoDocumentoAnexoBajaEquipoIngenieroId.get().getNombreTipoDocumentoAnexoBajaEquipoIngeniero())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngenieroNombre = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findByNombreTipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoBajaEquipoIngeniero().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoDocumentoAnexoBajaEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero = tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO);
                 tipoDocumentoAnexoBajaEquipoIngenieroRepository.save(tipoDocumentoAnexoBajaEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoDocumentoAnexoBajaEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoDocumentoAnexoBajaEquipoIngeniero(Long idTipoDocumentoAnexoBajaEquipoIngeniero) {
        Optional<TipoDocumentoAnexoBajaEquipoIngeniero> tipoDocumentoAnexoBajaEquipoIngenieroId  = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findById(idTipoDocumentoAnexoBajaEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoBajaEquipoIngenieroId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngenieroId.get()));
           tipoDocumentoAnexoBajaEquipoIngenieroRepository.delete(tipoDocumentoAnexoBajaEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoDocumentoAnexoBajaEquipoIngenieroId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
