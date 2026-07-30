//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEntidadInstitucionalDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoEntidadInstitucionalService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoEntidadInstitucionalDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEntidadInstitucional;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEntidadInstitucionalRepository;
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
public class TipoEntidadInstitucionalServiceImpl implements TipoEntidadInstitucionalService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEntidadInstitucionalDAO tipoEntidadInstitucionalDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEntidadInstitucionalRepository tipoEntidadInstitucionalRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoEntidadInstitucional, String keyword) {
        return tipoEntidadInstitucionalRepository.findTotalRegistros(idTipoEntidadInstitucional, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoEntidadInstitucionalDTO> listarTiposEntidadesInstitucionales(Long idTipoEntidadInstitucional, String keyword, String orderBy, String orderMode) {
        List<TipoEntidadInstitucional> tiposEntidadesInstitucionales = tipoEntidadInstitucionalRepository.findAllTiposEntidadesInstitucionales(idTipoEntidadInstitucional, keyword, orderBy, orderMode);
        List<TipoEntidadInstitucionalDTO> tipoEntidadInstitucionalDTOS = new ArrayList<>();
        
        for (TipoEntidadInstitucional tipoEntidadInstitucional : tiposEntidadesInstitucionales){
            tipoEntidadInstitucionalDTOS.add(tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipoEntidadInstitucional));
        }
        
        return tipoEntidadInstitucionalDTOS;
    }
    
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<TipoEntidadInstitucionalDTO> listarTiposEntidadesInstitucionalesPag(Pageable pageable, Long idTipoEntidadInstitucional, String keyword, String orderBy, String orderMode) {
        Slice<TipoEntidadInstitucional> tiposEntidadesInstitucionales = tipoEntidadInstitucionalRepository.findAllTiposEntidadesInstitucionalesPag(pageable, idTipoEntidadInstitucional, keyword, orderBy, orderMode);
        return tiposEntidadesInstitucionales.map(tipoEntidadInstitucional -> tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipoEntidadInstitucional));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoEntidadInstitucional(TipoEntidadInstitucionalDTO tipoEntidadInstitucionalDTO) {
        Long maxIdTipoEntidadInstitucional=null;
        TipoEntidadInstitucional tipoEntidadInstitucionalNombre = tipoEntidadInstitucionalRepository.findByNombreTipoEntidadInstitucional(tipoEntidadInstitucionalDTO.getNombreTipoEntidadInstitucional().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoEntidadInstitucionalNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoEntidadInstitucionalDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoEntidadInstitucional = tipoEntidadInstitucionalRepository.findMaxIdTipoEntidadInstitucional();
           if (maxIdTipoEntidadInstitucional==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoEntidadInstitucional=Long.valueOf(0);
           }
           tipoEntidadInstitucionalDTO.setIdTipoEntidadInstitucional(maxIdTipoEntidadInstitucional+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoEntidadInstitucionalRepository.save(tipoEntidadInstitucionalDAO.tipoEntidadInstitucional(tipoEntidadInstitucionalDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEntidadInstitucionalporId(Long idTipoEntidadInstitucional) {
        Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalId = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(Long.valueOf(idTipoEntidadInstitucional));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEntidadInstitucionalId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEntidadInstitucionalDTO(tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipoEntidadInstitucionalId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEntidadInstitucionalId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEntidadInstitucionalDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEntidadInstitucionalporNombre(String nombreTipoEntidadInstitucional) {
        Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalNombre = Optional.ofNullable(tipoEntidadInstitucionalRepository.findByNombreTipoEntidadInstitucional(String.valueOf(nombreTipoEntidadInstitucional)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoEntidadInstitucionalNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoEntidadInstitucionalDTO(tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipoEntidadInstitucionalNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEntidadInstitucionalNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEntidadInstitucionalDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoEntidadInstitucional(TipoEntidadInstitucionalDTO tipoEntidadInstitucionalDTO) {
        Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalId = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(tipoEntidadInstitucionalDTO.getIdTipoEntidadInstitucional());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoEntidadInstitucionalId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoEntidadInstitucionalDTO.getNombreTipoEntidadInstitucional().equals(tipoEntidadInstitucionalId.get().getNombreTipoEntidadInstitucional())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoEntidadInstitucional tipoEntidadInstitucional = tipoEntidadInstitucionalDAO.tipoEntidadInstitucional(tipoEntidadInstitucionalDTO);
              tipoEntidadInstitucionalRepository.save(tipoEntidadInstitucional);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoEntidadInstitucionalDTO.getNombreTipoEntidadInstitucional().equals(tipoEntidadInstitucionalId.get().getNombreTipoEntidadInstitucional())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoEntidadInstitucional tipoEntidadInstitucionalNombre = tipoEntidadInstitucionalRepository.findByNombreTipoEntidadInstitucional(tipoEntidadInstitucionalDTO.getNombreTipoEntidadInstitucional().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoEntidadInstitucionalNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoEntidadInstitucionalDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoEntidadInstitucional tipoEntidadInstitucional = tipoEntidadInstitucionalDAO.tipoEntidadInstitucional(tipoEntidadInstitucionalDTO);
                 tipoEntidadInstitucionalRepository.save(tipoEntidadInstitucional);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoEntidadInstitucionalId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoEntidadInstitucionalDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoEntidadInstitucional(Long idTipoEntidadInstitucional) {
        Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalId  = tipoEntidadInstitucionalRepository.findById(idTipoEntidadInstitucional);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEntidadInstitucionalId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEntidadInstitucionalDTO(tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipoEntidadInstitucionalId.get()));
           tipoEntidadInstitucionalRepository.delete(tipoEntidadInstitucionalId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoEntidadInstitucionalId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEntidadInstitucionalDTO(null);
        }
        
        return respuestaDTO;
    }
}
