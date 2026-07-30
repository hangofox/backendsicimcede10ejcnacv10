//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastServiceImpl implements TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, String keyword) {
        return tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO> listarTiposEmDesastGenObrRedMitigGestRiesgDesast(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        List<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tiposEmDesastGenObrApoyoObrRedMitigGestRiesgDesast = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findAllTiposEmDesastGenObrRedMitigGestRiesgDesast(idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        List<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO> tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        
        for (TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast : tiposEmDesastGenObrApoyoObrRedMitigGestRiesgDesast){
            tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTOS.add(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast));
        }
        
        return tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO> listarTiposEmDesastGenObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        Slice<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tiposEmDesastGenObrApoyoObrRedMitigGestRiesgDesast = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findAllTiposEmDesastGenObrRedMitigGestRiesgDesastPag(pageable, idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        return tiposEmDesastGenObrApoyoObrRedMitigGestRiesgDesast.map(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast -> tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO) {
        Long maxIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast=null;
        TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findByNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findMaxIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast();
           if (maxIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast=Long.valueOf(0);
           }
           tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.setIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(maxIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.save(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastporId(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast) {
        Optional<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findByIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(Long.valueOf(idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastporNombre(String nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast) {
        Optional<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre = Optional.ofNullable(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findByNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(String.valueOf(nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO) {
        Optional<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findByIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.getIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().equals(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.get().getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO);
              tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.save(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().equals(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.get().getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findByNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO);
                 tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.save(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast) {
        Optional<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId  = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findById(idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.get()));
           tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.delete(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
