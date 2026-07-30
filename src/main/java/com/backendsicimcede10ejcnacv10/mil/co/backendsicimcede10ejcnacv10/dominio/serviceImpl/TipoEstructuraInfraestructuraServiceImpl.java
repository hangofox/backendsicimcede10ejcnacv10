//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEstructuraInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoEstructuraInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoEstructuraInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEstructuraInfraestructuraRepository;
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
public class TipoEstructuraInfraestructuraServiceImpl implements TipoEstructuraInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEstructuraInfraestructuraDAO tipoEstructuraInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEstructuraInfraestructuraRepository tipoEstructuraInfraestructuraRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoEstructuraInfraestructura, String keyword) {
        return tipoEstructuraInfraestructuraRepository.findTotalRegistros(idTipoEstructuraInfraestructura, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoEstructuraInfraestructuraDTO> listarTiposEstructurasInfraestructuras(Long idTipoEstructuraInfraestructura, String keyword, String orderBy, String orderMode) {
        List<TipoEstructuraInfraestructura> tiposEstructurasInfraestructuras = tipoEstructuraInfraestructuraRepository.findAllTiposEstructurasInfraestructuras(idTipoEstructuraInfraestructura, keyword, orderBy, orderMode);
        List<TipoEstructuraInfraestructuraDTO> tipoEstructuraInfraestructuraDTOS = new ArrayList<>();
        
        for (TipoEstructuraInfraestructura tipoEstructuraInfraestructura : tiposEstructurasInfraestructuras){
            tipoEstructuraInfraestructuraDTOS.add(tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructura));
        }
        
        return tipoEstructuraInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoEstructuraInfraestructuraDTO> listarTiposEstructurasInfraestructurasPag(Pageable pageable, Long idTipoEstructuraInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<TipoEstructuraInfraestructura> tiposEstructurasInfraestructuras = tipoEstructuraInfraestructuraRepository.findAllTiposEstructurasInfraestructurasPag(pageable, idTipoEstructuraInfraestructura, keyword, orderBy, orderMode);
        return tiposEstructurasInfraestructuras.map(tipoEstructuraInfraestructura -> tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoEstructuraInfraestructura(TipoEstructuraInfraestructuraDTO tipoEstructuraInfraestructuraDTO) {
        Long maxIdTipoEstructuraInfraestructura=null;
        TipoEstructuraInfraestructura tipoEstructuraInfraestructuraNombre = tipoEstructuraInfraestructuraRepository.findByNombreTipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO.getNombreTipoEstructuraInfraestructura().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoEstructuraInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoEstructuraInfraestructura = tipoEstructuraInfraestructuraRepository.findMaxIdTipoEstructuraInfraestructura();
           if (maxIdTipoEstructuraInfraestructura==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoEstructuraInfraestructura=Long.valueOf(0);
           }
           tipoEstructuraInfraestructuraDTO.setIdTipoEstructuraInfraestructura(maxIdTipoEstructuraInfraestructura+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoEstructuraInfraestructuraRepository.save(tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEstructuraInfraestructuraporId(Long idTipoEstructuraInfraestructura) {
        Optional<TipoEstructuraInfraestructura> tipoEstructuraInfraestructuraId = tipoEstructuraInfraestructuraRepository.findByIdTipoEstructuraInfraestructura(Long.valueOf(idTipoEstructuraInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEstructuraInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEstructuraInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEstructuraInfraestructuraporNombre(String nombreTipoEstructuraInfraestructura) {
        Optional<TipoEstructuraInfraestructura> tipoEstructuraInfraestructuraNombre = Optional.ofNullable(tipoEstructuraInfraestructuraRepository.findByNombreTipoEstructuraInfraestructura(String.valueOf(nombreTipoEstructuraInfraestructura)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoEstructuraInfraestructuraNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructuraNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEstructuraInfraestructuraNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoEstructuraInfraestructura(TipoEstructuraInfraestructuraDTO tipoEstructuraInfraestructuraDTO) {
        Optional<TipoEstructuraInfraestructura> tipoEstructuraInfraestructuraId = tipoEstructuraInfraestructuraRepository.findByIdTipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO.getIdTipoEstructuraInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoEstructuraInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoEstructuraInfraestructuraDTO.getNombreTipoEstructuraInfraestructura().equals(tipoEstructuraInfraestructuraId.get().getNombreTipoEstructuraInfraestructura())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoEstructuraInfraestructura tipoEstructuraInfraestructura = tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO);
              tipoEstructuraInfraestructuraRepository.save(tipoEstructuraInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoEstructuraInfraestructuraDTO.getNombreTipoEstructuraInfraestructura().equals(tipoEstructuraInfraestructuraId.get().getNombreTipoEstructuraInfraestructura())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoEstructuraInfraestructura tipoEstructuraInfraestructuraNombre = tipoEstructuraInfraestructuraRepository.findByNombreTipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO.getNombreTipoEstructuraInfraestructura().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoEstructuraInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoEstructuraInfraestructuraDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoEstructuraInfraestructura tipoEstructuraInfraestructura = tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO);
                 tipoEstructuraInfraestructuraRepository.save(tipoEstructuraInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoEstructuraInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoEstructuraInfraestructura(Long idTipoEstructuraInfraestructura) {
        Optional<TipoEstructuraInfraestructura> tipoEstructuraInfraestructuraId  = tipoEstructuraInfraestructuraRepository.findById(idTipoEstructuraInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEstructuraInfraestructuraId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructuraId.get()));
           tipoEstructuraInfraestructuraRepository.delete(tipoEstructuraInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoEstructuraInfraestructuraId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
