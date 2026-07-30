//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoContratoSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoContratoSeguroInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoContratoSeguroInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContratoSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoContratoSeguroInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
public class TipoContratoSeguroInfraestructuraServiceImpl implements TipoContratoSeguroInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoContratoSeguroInfraestructuraDAO tipoContratoSeguroInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoContratoSeguroInfraestructuraRepository tipoContratoSeguroInfraestructuraRepository;
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR KEYWORD/ID DE TIPO CONTRATO SEGURO INFRAESTRUCTURA):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idTipoContratoSeguroInfraestructura, String keyword) {
        return tipoContratoSeguroInfraestructuraRepository.findTotalRegistros(idTipoContratoSeguroInfraestructura, keyword);
    }
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR KEYWORD/ID DE TIPO CONTRATO SEGURO INFRAESTRUCTURA):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoContratoSeguroInfraestructuraDTO> listarTiposContratosSegurosInfraestructuras(Long idTipoContratoSeguroInfraestructura, String keyword, String orderBy, String orderMode) {
        List<TipoContratoSeguroInfraestructura> tiposContratosSegurosInfraestructuras = tipoContratoSeguroInfraestructuraRepository.findAllTiposContratosSegurosInfraestructuras(idTipoContratoSeguroInfraestructura, keyword, orderBy, orderMode);
        List<TipoContratoSeguroInfraestructuraDTO> tipoContratoSeguroInfraestructuraDTOS = new ArrayList<>();
        
        for (TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura : tiposContratosSegurosInfraestructuras){
            tipoContratoSeguroInfraestructuraDTOS.add(tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructura));
        }
        
        return tipoContratoSeguroInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR KEYWORD/ID DE TIPO CONTRATO SEGURO INFRAESTRUCTURA):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<TipoContratoSeguroInfraestructuraDTO> listarTiposContratosSegurosInfraestructurasPag(Pageable pageable, Long idTipoContratoSeguroInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<TipoContratoSeguroInfraestructura> tiposContratosSegurosInfraestructuras = tipoContratoSeguroInfraestructuraRepository.findAllTiposContratosSegurosInfraestructurasPag(pageable, idTipoContratoSeguroInfraestructura, keyword, orderBy, orderMode);
        return tiposContratosSegurosInfraestructuras.map(tipoContratoSeguroInfraestructura -> tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoContratoSeguroInfraestructura(TipoContratoSeguroInfraestructuraDTO tipoContratoSeguroInfraestructuraDTO) {
        Long maxIdTipoContratoSeguroInfraestructura=null;
        TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructuraNombre = tipoContratoSeguroInfraestructuraRepository.findByNombreTipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO.getNombreTipoContratoSeguroInfraestructura().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoContratoSeguroInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoContratoSeguroInfraestructura = tipoContratoSeguroInfraestructuraRepository.findMaxIdTipoContratoSeguroInfraestructura();
           if (maxIdTipoContratoSeguroInfraestructura==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoContratoSeguroInfraestructura=Long.valueOf(0);
           }
           tipoContratoSeguroInfraestructuraDTO.setIdTipoContratoSeguroInfraestructura(maxIdTipoContratoSeguroInfraestructura+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoContratoSeguroInfraestructuraRepository.save(tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoContratoSeguroInfraestructuraporId(Long idTipoContratoSeguroInfraestructura) {
        Optional<TipoContratoSeguroInfraestructura> tipoContratoSeguroInfraestructuraId = tipoContratoSeguroInfraestructuraRepository.findByIdTipoContratoSeguroInfraestructura(Long.valueOf(idTipoContratoSeguroInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoContratoSeguroInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoContratoSeguroInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoContratoSeguroInfraestructuraporNombre(String nombreTipoContratoSeguroInfraestructura) {
        Optional<TipoContratoSeguroInfraestructura> tipoContratoSeguroInfraestructuraNombre = Optional.ofNullable(tipoContratoSeguroInfraestructuraRepository.findByNombreTipoContratoSeguroInfraestructura(String.valueOf(nombreTipoContratoSeguroInfraestructura)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoContratoSeguroInfraestructuraNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructuraNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoContratoSeguroInfraestructuraNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoContratoSeguroInfraestructura(TipoContratoSeguroInfraestructuraDTO tipoContratoSeguroInfraestructuraDTO) {
        Optional<TipoContratoSeguroInfraestructura> tipoContratoSeguroInfraestructuraId = tipoContratoSeguroInfraestructuraRepository.findByIdTipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO.getIdTipoContratoSeguroInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoContratoSeguroInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoContratoSeguroInfraestructuraDTO.getNombreTipoContratoSeguroInfraestructura().equals(tipoContratoSeguroInfraestructuraId.get().getNombreTipoContratoSeguroInfraestructura())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura = tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO);
              tipoContratoSeguroInfraestructuraRepository.save(tipoContratoSeguroInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoContratoSeguroInfraestructuraDTO.getNombreTipoContratoSeguroInfraestructura().equals(tipoContratoSeguroInfraestructuraId.get().getNombreTipoContratoSeguroInfraestructura())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructuraNombre = tipoContratoSeguroInfraestructuraRepository.findByNombreTipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO.getNombreTipoContratoSeguroInfraestructura().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoContratoSeguroInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura = tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO);
                 tipoContratoSeguroInfraestructuraRepository.save(tipoContratoSeguroInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoContratoSeguroInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoContratoSeguroInfraestructura(Long idTipoContratoSeguroInfraestructura) {
        Optional<TipoContratoSeguroInfraestructura> tipoContratoSeguroInfraestructuraId  = tipoContratoSeguroInfraestructuraRepository.findById(idTipoContratoSeguroInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoContratoSeguroInfraestructuraId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructuraId.get()));
           tipoContratoSeguroInfraestructuraRepository.delete(tipoContratoSeguroInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoContratoSeguroInfraestructuraId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoContratoSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
