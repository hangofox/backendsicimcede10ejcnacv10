//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProveedorProductoOServicioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProveedorProductoOServicioService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProveedorProductoOServicioDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProveedorProductoOServicio;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProveedorProductoOServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProveedorProductoOServicioServiceImpl implements ProveedorProductoOServicioService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProveedorProductoOServicioDAO proveedorProductoOServicioDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProveedorProductoOServicioRepository proveedorProductoOServicioRepository;
    
    //CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR ESTADO/KEYWORD):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProveedorProductoOServicio, String estadoProveedorProductoOServicio, String keyword) {
        return proveedorProductoOServicioRepository.findTotalRegistros(idProveedorProductoOServicio, estadoProveedorProductoOServicio, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR ESTADO/KEYWORD):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProveedorProductoOServicioDTO> listarProveedoresProductosOServicios(Long idProveedorProductoOServicio, String estadoProveedorProductoOServicio, String keyword, String orderBy, String orderMode) {
        List<ProveedorProductoOServicio> proveedoresProductosOServicios = proveedorProductoOServicioRepository.findAllProveedoresProductosOServicios(idProveedorProductoOServicio, estadoProveedorProductoOServicio, keyword, orderBy, orderMode);
        List<ProveedorProductoOServicioDTO> proveedoresProductosOServiciosDTOS = new ArrayList<>();
        
        for (ProveedorProductoOServicio proveedorProductoOServicio : proveedoresProductosOServicios) {
            proveedoresProductosOServiciosDTOS.add(proveedorProductoOServicioDAO.proveedorProductoOServicioDTO(proveedorProductoOServicio));
        }
        
        return proveedoresProductosOServiciosDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR ESTADO/KEYWORD):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProveedorProductoOServicioDTO> listarProveedoresProductosOServiciosPag(Pageable pageable, Long idProveedorProductoOServicio, String estadoProveedorProductoOServicio, String keyword, String orderBy, String orderMode) {
        Slice<ProveedorProductoOServicio> proveedoresProductosOServicios = proveedorProductoOServicioRepository.findAllProveedoresProductosOServiciosPag(pageable, idProveedorProductoOServicio, estadoProveedorProductoOServicio, keyword, orderBy, orderMode);
        return proveedoresProductosOServicios.map(proveedorProductoOServicio -> proveedorProductoOServicioDAO.proveedorProductoOServicioDTO(proveedorProductoOServicio));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProveedorProductoOServicio(ProveedorProductoOServicioDTO proveedorProductoOServicioDTO) {
        Long maxIdProveedorProductoOServicio = null;
        ProveedorProductoOServicio proveedorProductoOServicioNumeroDocumentoIdentificacion = proveedorProductoOServicioRepository.findByNumeroDocumentoIdentificacionProvProdOServ(proveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
        
        if (!(proveedorProductoOServicioNumeroDocumentoIdentificacion == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           banderaNumeroDocumentoIdentificacionRegistroEncontrado = 1;
        }
        
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 1) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
           respuestaDTO.setProveedorProductoOServicioDTO(null);
        }
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           maxIdProveedorProductoOServicio = proveedorProductoOServicioRepository.findMaxIdProveedorProductoOServicio();
           if (maxIdProveedorProductoOServicio == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProveedorProductoOServicio = Long.valueOf(0);
           }
           proveedorProductoOServicioDTO.setIdProveedorProductoOServicio(maxIdProveedorProductoOServicio + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proveedorProductoOServicioRepository.save(proveedorProductoOServicioDAO.proveedorProductoOServicio(proveedorProductoOServicioDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProveedorProductoOServicioporId(Long idProveedorProductoOServicio) {
        Optional<ProveedorProductoOServicio> proveedorProductoOServicioId = proveedorProductoOServicioRepository.findByIdProveedorProductoOServicio(Long.valueOf(idProveedorProductoOServicio));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proveedorProductoOServicioId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProveedorProductoOServicioDTO(proveedorProductoOServicioDAO.proveedorProductoOServicioDTO(proveedorProductoOServicioId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proveedorProductoOServicioId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProveedorProductoOServicioporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionProvProdOServ) {
        Optional<ProveedorProductoOServicio> proveedorProductoOServicioNumeroDocumentoIdentificacion = Optional.ofNullable(proveedorProductoOServicioRepository.findByNumeroDocumentoIdentificacionProvProdOServ(numeroDocumentoIdentificacionProvProdOServ));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
        
        if (proveedorProductoOServicioNumeroDocumentoIdentificacion.isPresent() == true) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO.setProveedorProductoOServicioDTO(proveedorProductoOServicioDAO.proveedorProductoOServicioDTO(proveedorProductoOServicioNumeroDocumentoIdentificacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proveedorProductoOServicioNumeroDocumentoIdentificacion.isPresent() == false) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
           respuestaDTO.setProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProveedorProductoOServicio(ProveedorProductoOServicioDTO proveedorProductoOServicioDTO) {
        Optional<ProveedorProductoOServicio> proveedorProductoOServicioId = proveedorProductoOServicioRepository.findByIdProveedorProductoOServicio(proveedorProductoOServicioDTO.getIdProveedorProductoOServicio());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proveedorProductoOServicioId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO CON EL ID PROPORCIONADO.
           if (proveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ().equals(proveedorProductoOServicioId.get().getNumeroDocumentoIdentificacionProvProdOServ()) == true) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES IGUAL AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ProveedorProductoOServicio proveedorProductoOServicio = proveedorProductoOServicioDAO.proveedorProductoOServicio(proveedorProductoOServicioDTO);
              proveedorProductoOServicioRepository.save(proveedorProductoOServicio);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (proveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ().equals(proveedorProductoOServicioId.get().getNumeroDocumentoIdentificacionProvProdOServ()) == false) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES DIFERENTE AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO EXISTE EN OTROS REGISTROS.
              ProveedorProductoOServicio proveedorProductoOServicioNumeroDocumentoIdentificacion = proveedorProductoOServicioRepository.findByNumeroDocumentoIdentificacionProvProdOServ(proveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
              
              if (!(proveedorProductoOServicioNumeroDocumentoIdentificacion == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
                 banderaNumeroDocumentoIdentificacionRegistroEncontrado = 1;
              }
              
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
                 respuestaDTO.setProveedorProductoOServicioDTO(null);
              }
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 ProveedorProductoOServicio proveedorProductoOServicio = proveedorProductoOServicioDAO.proveedorProductoOServicio(proveedorProductoOServicioDTO);
                 proveedorProductoOServicioRepository.save(proveedorProductoOServicio);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proveedorProductoOServicioId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProveedorProductoOServicio(Long idProveedorProductoOServicio) {
        Optional<ProveedorProductoOServicio> proveedorProductoOServicioId = proveedorProductoOServicioRepository.findById(idProveedorProductoOServicio);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proveedorProductoOServicioId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProveedorProductoOServicioDTO(proveedorProductoOServicioDAO.proveedorProductoOServicioDTO(proveedorProductoOServicioId.get()));
           proveedorProductoOServicioRepository.delete(proveedorProductoOServicioId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proveedorProductoOServicioId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
}
