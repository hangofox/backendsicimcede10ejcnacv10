//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEventoApoyoRealizadoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoEventoApoyoRealizadoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoEventoApoyoRealizadoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEventoApoyoRealizado;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEventoApoyoRealizadoRepository;
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
public class TipoEventoApoyoRealizadoServiceImpl implements TipoEventoApoyoRealizadoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEventoApoyoRealizadoDAO tipoEventoApoyoRealizadoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEventoApoyoRealizadoRepository tipoEventoApoyoRealizadoRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoEventoApoyoRealizado, String keyword) {
        return tipoEventoApoyoRealizadoRepository.findTotalRegistros(idTipoEventoApoyoRealizado, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoEventoApoyoRealizadoDTO> listarTiposEventosApoyosRealizados(Long idTipoEventoApoyoRealizado, String keyword, String orderBy, String orderMode) {
        List<TipoEventoApoyoRealizado> tiposEventosApoyosRealizados = tipoEventoApoyoRealizadoRepository.findAllTiposEventosApoyosRealizados(idTipoEventoApoyoRealizado, keyword, orderBy, orderMode);
        List<TipoEventoApoyoRealizadoDTO> tipoEventoApoyoRealizadoDTOS = new ArrayList<>();
        
        for (TipoEventoApoyoRealizado tipoEventoApoyoRealizado : tiposEventosApoyosRealizados){
            tipoEventoApoyoRealizadoDTOS.add(tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizado));
        }
        
        return tipoEventoApoyoRealizadoDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoEventoApoyoRealizadoDTO> listarTiposEventosApoyosRealizadosPag(Pageable pageable, Long idTipoEventoApoyoRealizado, String keyword, String orderBy, String orderMode) {
        Slice<TipoEventoApoyoRealizado> tiposEventosApoyosRealizados = tipoEventoApoyoRealizadoRepository.findAllTiposEventosApoyosRealizadosPag(pageable, idTipoEventoApoyoRealizado, keyword, orderBy, orderMode);
        return tiposEventosApoyosRealizados.map(tipoEventoApoyoRealizado -> tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizado));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoEventoApoyoRealizado(TipoEventoApoyoRealizadoDTO tipoEventoApoyoRealizadoDTO) {
        Long maxIdTipoEventoApoyoRealizado=null;
        TipoEventoApoyoRealizado tipoEventoApoyoRealizadoNombre = tipoEventoApoyoRealizadoRepository.findByNombreTipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO.getNombreTipoEventoApoyoRealizado().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoEventoApoyoRealizadoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoEventoApoyoRealizado = tipoEventoApoyoRealizadoRepository.findMaxIdTipoEventoApoyoRealizado();
           if (maxIdTipoEventoApoyoRealizado==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoEventoApoyoRealizado=Long.valueOf(0);
           }
           tipoEventoApoyoRealizadoDTO.setIdTipoEventoApoyoRealizado(maxIdTipoEventoApoyoRealizado+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoEventoApoyoRealizadoRepository.save(tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEventoApoyoRealizadoporId(Long idTipoEventoApoyoRealizado) {
        Optional<TipoEventoApoyoRealizado> tipoEventoApoyoRealizadoId = tipoEventoApoyoRealizadoRepository.findByIdTipoEventoApoyoRealizado(Long.valueOf(idTipoEventoApoyoRealizado));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEventoApoyoRealizadoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizadoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEventoApoyoRealizadoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEventoApoyoRealizadoporNombre(String nombreTipoEventoApoyoRealizado) {
        Optional<TipoEventoApoyoRealizado> tipoEventoApoyoRealizadoNombre = Optional.ofNullable(tipoEventoApoyoRealizadoRepository.findByNombreTipoEventoApoyoRealizado(String.valueOf(nombreTipoEventoApoyoRealizado)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoEventoApoyoRealizadoNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizadoNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEventoApoyoRealizadoNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoEventoApoyoRealizado(TipoEventoApoyoRealizadoDTO tipoEventoApoyoRealizadoDTO) {
        Optional<TipoEventoApoyoRealizado> tipoEventoApoyoRealizadoId = tipoEventoApoyoRealizadoRepository.findByIdTipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO.getIdTipoEventoApoyoRealizado());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoEventoApoyoRealizadoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoEventoApoyoRealizadoDTO.getNombreTipoEventoApoyoRealizado().equals(tipoEventoApoyoRealizadoId.get().getNombreTipoEventoApoyoRealizado())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoEventoApoyoRealizado tipoEventoApoyoRealizado = tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO);
              tipoEventoApoyoRealizadoRepository.save(tipoEventoApoyoRealizado);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoEventoApoyoRealizadoDTO.getNombreTipoEventoApoyoRealizado().equals(tipoEventoApoyoRealizadoId.get().getNombreTipoEventoApoyoRealizado())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoEventoApoyoRealizado tipoEventoApoyoRealizadoNombre = tipoEventoApoyoRealizadoRepository.findByNombreTipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO.getNombreTipoEventoApoyoRealizado().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoEventoApoyoRealizadoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoEventoApoyoRealizadoDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoEventoApoyoRealizado tipoEventoApoyoRealizado = tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO);
                 tipoEventoApoyoRealizadoRepository.save(tipoEventoApoyoRealizado);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoEventoApoyoRealizadoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoEventoApoyoRealizado(Long idTipoEventoApoyoRealizado) {
        Optional<TipoEventoApoyoRealizado> tipoEventoApoyoRealizadoId  = tipoEventoApoyoRealizadoRepository.findById(idTipoEventoApoyoRealizado);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEventoApoyoRealizadoId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizadoId.get()));
           tipoEventoApoyoRealizadoRepository.delete(tipoEventoApoyoRealizadoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoEventoApoyoRealizadoId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEventoApoyoRealizadoDTO(null);
        }
        
        return respuestaDTO;
    }
}
