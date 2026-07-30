//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoMantenimientoInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoMantenimientoInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoMantenimientoInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoMantenimientoInfraestructuraRepository;
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
public class TipoMantenimientoInfraestructuraServiceImpl implements TipoMantenimientoInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoMantenimientoInfraestructuraDAO tipoMantenimientoInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoMantenimientoInfraestructuraRepository tipoMantenimientoInfraestructuraRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoMantenimientoInfraestructura, String keyword) {
        return tipoMantenimientoInfraestructuraRepository.findTotalRegistros(idTipoMantenimientoInfraestructura, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoMantenimientoInfraestructuraDTO> listarTiposMantenimientosInfraestructuras(Long idTipoMantenimientoInfraestructura, String keyword, String orderBy, String orderMode) {
        List<TipoMantenimientoInfraestructura> tiposMantenimientosInfraestructuras = tipoMantenimientoInfraestructuraRepository.findAllTiposMantenimientosInfraestructuras(idTipoMantenimientoInfraestructura, keyword, orderBy, orderMode);
        List<TipoMantenimientoInfraestructuraDTO> tipoMantenimientoInfraestructuraDTOS = new ArrayList<>();
        
        for (TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura : tiposMantenimientosInfraestructuras){
            tipoMantenimientoInfraestructuraDTOS.add(tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructura));
        }
        
        return tipoMantenimientoInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoMantenimientoInfraestructuraDTO> listarTiposMantenimientosInfraestructurasPag(Pageable pageable, Long idTipoMantenimientoInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<TipoMantenimientoInfraestructura> tiposMantenimientosInfraestructuras = tipoMantenimientoInfraestructuraRepository.findAllTiposMantenimientosInfraestructurasPag(pageable, idTipoMantenimientoInfraestructura, keyword, orderBy, orderMode);
        return tiposMantenimientosInfraestructuras.map(tipoMantenimientoInfraestructura -> tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoMantenimientoInfraestructura(TipoMantenimientoInfraestructuraDTO tipoMantenimientoInfraestructuraDTO) {
        Long maxIdTipoMantenimientoInfraestructura=null;
        TipoMantenimientoInfraestructura tipoMantenimientoInfraestructuraNombre = tipoMantenimientoInfraestructuraRepository.findByNombreTipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO.getNombreTipoMantenimientoInfraestructura().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoMantenimientoInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoMantenimientoInfraestructura = tipoMantenimientoInfraestructuraRepository.findMaxIdTipoMantenimientoInfraestructura();
           if (maxIdTipoMantenimientoInfraestructura==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoMantenimientoInfraestructura=Long.valueOf(0);
           }
           tipoMantenimientoInfraestructuraDTO.setIdTipoMantenimientoInfraestructura(maxIdTipoMantenimientoInfraestructura+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoMantenimientoInfraestructuraRepository.save(tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoMantenimientoInfraestructuraporId(Long idTipoMantenimientoInfraestructura) {
        Optional<TipoMantenimientoInfraestructura> tipoMantenimientoInfraestructuraId = tipoMantenimientoInfraestructuraRepository.findByIdTipoMantenimientoInfraestructura(Long.valueOf(idTipoMantenimientoInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoMantenimientoInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoMantenimientoInfraestructuraporNombre(String nombreTipoMantenimientoInfraestructura) {
        Optional<TipoMantenimientoInfraestructura> tipoMantenimientoInfraestructuraNombre = Optional.ofNullable(tipoMantenimientoInfraestructuraRepository.findByNombreTipoMantenimientoInfraestructura(String.valueOf(nombreTipoMantenimientoInfraestructura)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoInfraestructuraNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructuraNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoMantenimientoInfraestructuraNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoMantenimientoInfraestructura(TipoMantenimientoInfraestructuraDTO tipoMantenimientoInfraestructuraDTO) {
        Optional<TipoMantenimientoInfraestructura> tipoMantenimientoInfraestructuraId = tipoMantenimientoInfraestructuraRepository.findByIdTipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO.getIdTipoMantenimientoInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoMantenimientoInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoMantenimientoInfraestructuraDTO.getNombreTipoMantenimientoInfraestructura().equals(tipoMantenimientoInfraestructuraId.get().getNombreTipoMantenimientoInfraestructura())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura = tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO);
              tipoMantenimientoInfraestructuraRepository.save(tipoMantenimientoInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoMantenimientoInfraestructuraDTO.getNombreTipoMantenimientoInfraestructura().equals(tipoMantenimientoInfraestructuraId.get().getNombreTipoMantenimientoInfraestructura())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoMantenimientoInfraestructura tipoMantenimientoInfraestructuraNombre = tipoMantenimientoInfraestructuraRepository.findByNombreTipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO.getNombreTipoMantenimientoInfraestructura().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoMantenimientoInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoMantenimientoInfraestructuraDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura = tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO);
                 tipoMantenimientoInfraestructuraRepository.save(tipoMantenimientoInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoMantenimientoInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoMantenimientoInfraestructura(Long idTipoMantenimientoInfraestructura) {
        Optional<TipoMantenimientoInfraestructura> tipoMantenimientoInfraestructuraId  = tipoMantenimientoInfraestructuraRepository.findById(idTipoMantenimientoInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoMantenimientoInfraestructuraId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructuraId.get()));
           tipoMantenimientoInfraestructuraRepository.delete(tipoMantenimientoInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoMantenimientoInfraestructuraId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
