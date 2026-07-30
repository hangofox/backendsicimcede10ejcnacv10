//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoAltaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoDocumentoAnexoAltaEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoDocumentoAnexoAltaEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoAltaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoAnexoAltaEquipoIngenieroRepository;
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
public class TipoDocumentoAnexoAltaEquipoIngenieroServiceImpl implements TipoDocumentoAnexoAltaEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoAnexoAltaEquipoIngenieroDAO tipoDocumentoAnexoAltaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoAnexoAltaEquipoIngenieroRepository tipoDocumentoAnexoAltaEquipoIngenieroRepository;
    
    //CONTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR REGISTROS.
    public Long contarTotalRegistros(Long idTipoDocumentoAnexoAltaEquipoIngeniero, String keyword) {
        return tipoDocumentoAnexoAltaEquipoIngenieroRepository.findTotalRegistros(idTipoDocumentoAnexoAltaEquipoIngeniero, keyword);
    }
    
    //LISTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoDocumentoAnexoAltaEquipoIngenieroDTO> listarTiposDocumentosAnexosAltasEquiposIngenieros(Long idTipoDocumentoAnexoAltaEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<TipoDocumentoAnexoAltaEquipoIngeniero> tiposDocumentosAnexosAltasEquiposIngenieros = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findAllTiposDocumentosAnexosAltasEquiposIngenieros(idTipoDocumentoAnexoAltaEquipoIngeniero, keyword, orderBy, orderMode);
        List<TipoDocumentoAnexoAltaEquipoIngenieroDTO> tipoDocumentoAnexoAltaEquipoIngenieroDTOS = new ArrayList<>();
        
        for (TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngeniero : tiposDocumentosAnexosAltasEquiposIngenieros){
            tipoDocumentoAnexoAltaEquipoIngenieroDTOS.add(tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngeniero));
        }
        
        return tipoDocumentoAnexoAltaEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS FILTRADOS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoDocumentoAnexoAltaEquipoIngenieroDTO> listarTiposDocumentosAnexosAltasEquiposIngenierosPag(Pageable pageable, Long idTipoDocumentoAnexoAltaEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<TipoDocumentoAnexoAltaEquipoIngeniero> tiposDocumentosAnexosAltasEquiposIngenieros = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findAllTiposDocumentosAnexosAltasEquiposIngenierosPag(pageable, idTipoDocumentoAnexoAltaEquipoIngeniero, keyword, orderBy, orderMode);
        return tiposDocumentosAnexosAltasEquiposIngenieros.map(tipoDocumentoAnexoAltaEquipoIngeniero -> tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoDocumentoAnexoAltaEquipoIngeniero(TipoDocumentoAnexoAltaEquipoIngenieroDTO tipoDocumentoAnexoAltaEquipoIngenieroDTO) {
        Long maxIdTipoDocumentoAnexoAltaEquipoIngeniero=null;
        TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngenieroNombre = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findByNombreTipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoAltaEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoDocumentoAnexoAltaEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoDocumentoAnexoAltaEquipoIngeniero = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findMaxIdTipoDocumentoAnexoAltaEquipoIngeniero();
           if (maxIdTipoDocumentoAnexoAltaEquipoIngeniero==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoDocumentoAnexoAltaEquipoIngeniero=Long.valueOf(0);
           }
           tipoDocumentoAnexoAltaEquipoIngenieroDTO.setIdTipoDocumentoAnexoAltaEquipoIngeniero(maxIdTipoDocumentoAnexoAltaEquipoIngeniero+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoDocumentoAnexoAltaEquipoIngenieroRepository.save(tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDocumentoAnexoAltaEquipoIngenieroporId(Long idTipoDocumentoAnexoAltaEquipoIngeniero) {
        Optional<TipoDocumentoAnexoAltaEquipoIngeniero> tipoDocumentoAnexoAltaEquipoIngenieroId = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoAltaEquipoIngeniero(Long.valueOf(idTipoDocumentoAnexoAltaEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoAltaEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDocumentoAnexoAltaEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDocumentoAnexoAltaEquipoIngenieroporNombre(String nombreTipoDocumentoAnexoAltaEquipoIngeniero) {
        Optional<TipoDocumentoAnexoAltaEquipoIngeniero> tipoDocumentoAnexoAltaEquipoIngenieroNombre = Optional.ofNullable(tipoDocumentoAnexoAltaEquipoIngenieroRepository.findByNombreTipoDocumentoAnexoAltaEquipoIngeniero(String.valueOf(nombreTipoDocumentoAnexoAltaEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoAltaEquipoIngenieroNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDocumentoAnexoAltaEquipoIngenieroNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoDocumentoAnexoAltaEquipoIngeniero(TipoDocumentoAnexoAltaEquipoIngenieroDTO tipoDocumentoAnexoAltaEquipoIngenieroDTO) {
        Optional<TipoDocumentoAnexoAltaEquipoIngeniero> tipoDocumentoAnexoAltaEquipoIngenieroId = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO.getIdTipoDocumentoAnexoAltaEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoDocumentoAnexoAltaEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoDocumentoAnexoAltaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoAltaEquipoIngeniero().equals(tipoDocumentoAnexoAltaEquipoIngenieroId.get().getNombreTipoDocumentoAnexoAltaEquipoIngeniero())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngeniero = tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO);
              tipoDocumentoAnexoAltaEquipoIngenieroRepository.save(tipoDocumentoAnexoAltaEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoDocumentoAnexoAltaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoAltaEquipoIngeniero().equals(tipoDocumentoAnexoAltaEquipoIngenieroId.get().getNombreTipoDocumentoAnexoAltaEquipoIngeniero())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngenieroNombre = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findByNombreTipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoAltaEquipoIngeniero().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoDocumentoAnexoAltaEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngeniero = tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO);
                 tipoDocumentoAnexoAltaEquipoIngenieroRepository.save(tipoDocumentoAnexoAltaEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoDocumentoAnexoAltaEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoDocumentoAnexoAltaEquipoIngeniero(Long idTipoDocumentoAnexoAltaEquipoIngeniero) {
        Optional<TipoDocumentoAnexoAltaEquipoIngeniero> tipoDocumentoAnexoAltaEquipoIngenieroId  = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findById(idTipoDocumentoAnexoAltaEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoAltaEquipoIngenieroId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngenieroId.get()));
           tipoDocumentoAnexoAltaEquipoIngenieroRepository.delete(tipoDocumentoAnexoAltaEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoDocumentoAnexoAltaEquipoIngenieroId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
