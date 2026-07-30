//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoDocumentoAnexoSolicInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoDocumentoAnexoSolicInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoAnexoSolicInfraestRepository;
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
public class TipoDocumentoAnexoSolicInfraestServiceImpl implements TipoDocumentoAnexoSolicInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoAnexoSolicInfraestDAO tipoDocumentoAnexoSolicInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoAnexoSolicInfraestRepository tipoDocumentoAnexoSolicInfraestRepository;
    
    //CONTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR REGISTROS.
    public Long contarTotalRegistros(Long idTipoDocumentoAnexoSolicInfraest, String keyword) {
        return tipoDocumentoAnexoSolicInfraestRepository.findTotalRegistros(idTipoDocumentoAnexoSolicInfraest, keyword);
    }
    
    //LISTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoDocumentoAnexoSolicInfraestDTO> listarTiposDocumentosAnexosSolicInfraest(Long idTipoDocumentoAnexoSolicInfraest, String keyword, String orderBy, String orderMode) {
        List<TipoDocumentoAnexoSolicInfraest> tiposDocumentosAnexosSolicInfraest = tipoDocumentoAnexoSolicInfraestRepository.findAllTiposDocumentosAnexosSolicInfraest(idTipoDocumentoAnexoSolicInfraest, keyword, orderBy, orderMode);
        List<TipoDocumentoAnexoSolicInfraestDTO> tipoDocumentoAnexoSolicInfraestDTOS = new ArrayList<>();
        
        for (TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest : tiposDocumentosAnexosSolicInfraest){
            tipoDocumentoAnexoSolicInfraestDTOS.add(tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraest));
        }
        
        return tipoDocumentoAnexoSolicInfraestDTOS;
    }
    
    //LISTAR REGISTROS FILTRADOS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoDocumentoAnexoSolicInfraestDTO> listarTiposDocumentosAnexosSolicInfraestPag(Pageable pageable, Long idTipoDocumentoAnexoSolicInfraest, String keyword, String orderBy, String orderMode) {
        Slice<TipoDocumentoAnexoSolicInfraest> tiposDocumentosAnexosSolicInfraest = tipoDocumentoAnexoSolicInfraestRepository.findAllTiposDocumentosAnexosSolicInfraestPag(pageable, idTipoDocumentoAnexoSolicInfraest, keyword, orderBy, orderMode);
        return tiposDocumentosAnexosSolicInfraest.map(tipoDocumentoAnexoSolicInfraest -> tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoDocumentoAnexoSolicInfraest(TipoDocumentoAnexoSolicInfraestDTO tipoDocumentoAnexoSolicInfraestDTO) {
        Long maxIdTipoDocumentoAnexoSolicInfraest=null;
        TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraestNombre = tipoDocumentoAnexoSolicInfraestRepository.findByNombreTipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO.getNombreTipoDocumentoAnexoSolicInfraest().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoDocumentoAnexoSolicInfraestNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoDocumentoAnexoSolicInfraest = tipoDocumentoAnexoSolicInfraestRepository.findMaxIdTipoDocumentoAnexoSolicInfraest();
           if (maxIdTipoDocumentoAnexoSolicInfraest==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoDocumentoAnexoSolicInfraest=Long.valueOf(0);
           }
           tipoDocumentoAnexoSolicInfraestDTO.setIdTipoDocumentoAnexoSolicInfraest(maxIdTipoDocumentoAnexoSolicInfraest+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoDocumentoAnexoSolicInfraestRepository.save(tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDocumentoAnexoSolicInfraestporId(Long idTipoDocumentoAnexoSolicInfraest) {
        Optional<TipoDocumentoAnexoSolicInfraest> tipoDocumentoAnexoSolicInfraestId = tipoDocumentoAnexoSolicInfraestRepository.findByIdTipoDocumentoAnexoSolicInfraest(Long.valueOf(idTipoDocumentoAnexoSolicInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoSolicInfraestId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDocumentoAnexoSolicInfraestId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDocumentoAnexoSolicInfraestporNombre(String nombreTipoDocumentoAnexoSolicInfraest) {
        Optional<TipoDocumentoAnexoSolicInfraest> tipoDocumentoAnexoSolicInfraestNombre = Optional.ofNullable(tipoDocumentoAnexoSolicInfraestRepository.findByNombreTipoDocumentoAnexoSolicInfraest(String.valueOf(nombreTipoDocumentoAnexoSolicInfraest)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoSolicInfraestNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraestNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDocumentoAnexoSolicInfraestNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoDocumentoAnexoSolicInfraest(TipoDocumentoAnexoSolicInfraestDTO tipoDocumentoAnexoSolicInfraestDTO) {
        Optional<TipoDocumentoAnexoSolicInfraest> tipoDocumentoAnexoSolicInfraestId = tipoDocumentoAnexoSolicInfraestRepository.findByIdTipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO.getIdTipoDocumentoAnexoSolicInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoDocumentoAnexoSolicInfraestId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoDocumentoAnexoSolicInfraestDTO.getNombreTipoDocumentoAnexoSolicInfraest().equals(tipoDocumentoAnexoSolicInfraestId.get().getNombreTipoDocumentoAnexoSolicInfraest())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest = tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO);
              tipoDocumentoAnexoSolicInfraestRepository.save(tipoDocumentoAnexoSolicInfraest);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoDocumentoAnexoSolicInfraestDTO.getNombreTipoDocumentoAnexoSolicInfraest().equals(tipoDocumentoAnexoSolicInfraestId.get().getNombreTipoDocumentoAnexoSolicInfraest())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraestNombre = tipoDocumentoAnexoSolicInfraestRepository.findByNombreTipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO.getNombreTipoDocumentoAnexoSolicInfraest().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoDocumentoAnexoSolicInfraestNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest = tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO);
                 tipoDocumentoAnexoSolicInfraestRepository.save(tipoDocumentoAnexoSolicInfraest);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoDocumentoAnexoSolicInfraestId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoDocumentoAnexoSolicInfraest(Long idTipoDocumentoAnexoSolicInfraest) {
        Optional<TipoDocumentoAnexoSolicInfraest> tipoDocumentoAnexoSolicInfraestId  = tipoDocumentoAnexoSolicInfraestRepository.findById(idTipoDocumentoAnexoSolicInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDocumentoAnexoSolicInfraestId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraestId.get()));
           tipoDocumentoAnexoSolicInfraestRepository.delete(tipoDocumentoAnexoSolicInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoDocumentoAnexoSolicInfraestId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDocumentoAnexoSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
