//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoSolicitudInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoSolicitudInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoSolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoSolicitudInfraestructuraRepository;
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
public class TipoSolicitudInfraestructuraServiceImpl implements TipoSolicitudInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoSolicitudInfraestructuraDAO tipoSolicitudInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoSolicitudInfraestructuraRepository tipoSolicitudInfraestructuraRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoSolicitudInfraestructura, String keyword) {
        return tipoSolicitudInfraestructuraRepository.findTotalRegistros(idTipoSolicitudInfraestructura, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoSolicitudInfraestructuraDTO> listarTiposSolicitudesInfraestructuras(Long idTipoSolicitudInfraestructura, String keyword, String orderBy, String orderMode) {
        List<TipoSolicitudInfraestructura> tiposSolicitudesInfraestructuras = tipoSolicitudInfraestructuraRepository.findAllTiposSolicitudesInfraestructuras(idTipoSolicitudInfraestructura, keyword, orderBy, orderMode);
        List<TipoSolicitudInfraestructuraDTO> tipoSolicitudInfraestructuraDTOS = new ArrayList<>();
        
        for (TipoSolicitudInfraestructura tipoSolicitudInfraestructura : tiposSolicitudesInfraestructuras){
            tipoSolicitudInfraestructuraDTOS.add(tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructura));
        }
        
        return tipoSolicitudInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoSolicitudInfraestructuraDTO> listarTiposSolicitudesInfraestructurasPag(Pageable pageable, Long idTipoSolicitudInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<TipoSolicitudInfraestructura> tiposSolicitudesInfraestructuras = tipoSolicitudInfraestructuraRepository.findAllTiposSolicitudesInfraestructurasPag(pageable, idTipoSolicitudInfraestructura, keyword, orderBy, orderMode);
        return tiposSolicitudesInfraestructuras.map(tipoSolicitudInfraestructura -> tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoSolicitudInfraestructura(TipoSolicitudInfraestructuraDTO tipoSolicitudInfraestructuraDTO) {
        Long maxIdTipoSolicitudInfraestructura=null;
        TipoSolicitudInfraestructura tipoSolicitudInfraestructuraNombre = tipoSolicitudInfraestructuraRepository.findByNombreTipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO.getNombreTipoSolicitudInfraestructura().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoSolicitudInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoSolicitudInfraestructura = tipoSolicitudInfraestructuraRepository.findMaxIdTipoSolicitudInfraestructura();
           if (maxIdTipoSolicitudInfraestructura==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoSolicitudInfraestructura=Long.valueOf(0);
           }
           tipoSolicitudInfraestructuraDTO.setIdTipoSolicitudInfraestructura(maxIdTipoSolicitudInfraestructura+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoSolicitudInfraestructuraRepository.save(tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoSolicitudInfraestructuraporId(Long idTipoSolicitudInfraestructura) {
        Optional<TipoSolicitudInfraestructura> tipoSolicitudInfraestructuraId = tipoSolicitudInfraestructuraRepository.findByIdTipoSolicitudInfraestructura(Long.valueOf(idTipoSolicitudInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoSolicitudInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoSolicitudInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoSolicitudInfraestructuraporNombre(String nombreTipoSolicitudInfraestructura) {
        Optional<TipoSolicitudInfraestructura> tipoSolicitudInfraestructuraNombre = Optional.ofNullable(tipoSolicitudInfraestructuraRepository.findByNombreTipoSolicitudInfraestructura(String.valueOf(nombreTipoSolicitudInfraestructura)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoSolicitudInfraestructuraNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructuraNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoSolicitudInfraestructuraNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoSolicitudInfraestructura(TipoSolicitudInfraestructuraDTO tipoSolicitudInfraestructuraDTO) {
        Optional<TipoSolicitudInfraestructura> tipoSolicitudInfraestructuraId = tipoSolicitudInfraestructuraRepository.findByIdTipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO.getIdTipoSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoSolicitudInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoSolicitudInfraestructuraDTO.getNombreTipoSolicitudInfraestructura().equals(tipoSolicitudInfraestructuraId.get().getNombreTipoSolicitudInfraestructura())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoSolicitudInfraestructura tipoSolicitudInfraestructura = tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO);
              tipoSolicitudInfraestructuraRepository.save(tipoSolicitudInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoSolicitudInfraestructuraDTO.getNombreTipoSolicitudInfraestructura().equals(tipoSolicitudInfraestructuraId.get().getNombreTipoSolicitudInfraestructura())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoSolicitudInfraestructura tipoSolicitudInfraestructuraNombre = tipoSolicitudInfraestructuraRepository.findByNombreTipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO.getNombreTipoSolicitudInfraestructura().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoSolicitudInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoSolicitudInfraestructuraDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoSolicitudInfraestructura tipoSolicitudInfraestructura = tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO);
                 tipoSolicitudInfraestructuraRepository.save(tipoSolicitudInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoSolicitudInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoSolicitudInfraestructura(Long idTipoSolicitudInfraestructura) {
        Optional<TipoSolicitudInfraestructura> tipoSolicitudInfraestructuraId  = tipoSolicitudInfraestructuraRepository.findById(idTipoSolicitudInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoSolicitudInfraestructuraId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructuraId.get()));
           tipoSolicitudInfraestructuraRepository.delete(tipoSolicitudInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoSolicitudInfraestructuraId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
