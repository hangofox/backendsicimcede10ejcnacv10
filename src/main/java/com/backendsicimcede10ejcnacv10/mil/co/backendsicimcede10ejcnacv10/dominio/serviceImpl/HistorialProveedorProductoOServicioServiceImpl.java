//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProveedorProductoOServicioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialProveedorProductoOServicioService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialProveedorProductoOServicioDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProveedorProductoOServicio;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProveedorProductoOServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 02/06/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialProveedorProductoOServicioServiceImpl implements HistorialProveedorProductoOServicioService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProveedorProductoOServicioDAO historialProveedorProductoOServicioDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProveedorProductoOServicioRepository historialProveedorProductoOServicioRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialProveedorProductoOServicio, String keyword) {
        return historialProveedorProductoOServicioRepository.findTotalRegistros(idHistorialProveedorProductoOServicio, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialProveedorProductoOServicioDTO> listarHistorialesProveedoresProductosOServicios(Long idHistorialProveedorProductoOServicio, String keyword, String orderBy, String orderMode) {
        List<HistorialProveedorProductoOServicio> historialesProveedoresProductosOServicios = historialProveedorProductoOServicioRepository.findAllHistorialesProveedoresProductosOServicios(idHistorialProveedorProductoOServicio, keyword, orderBy, orderMode);
        List<HistorialProveedorProductoOServicioDTO> historialProveedorProductoOServicioDTOS = new ArrayList<>();
        for (HistorialProveedorProductoOServicio historialProveedorProductoOServicio : historialesProveedoresProductosOServicios) {
            historialProveedorProductoOServicioDTOS.add(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(historialProveedorProductoOServicio));
        }
        
        return historialProveedorProductoOServicioDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialProveedorProductoOServicioDTO> listarHistorialesProveedoresProductosOServiciosPag(Pageable pageable, Long idHistorialProveedorProductoOServicio, String keyword, String orderBy, String orderMode) {
        Slice<HistorialProveedorProductoOServicio> historialesProveedoresProductosOServicios = historialProveedorProductoOServicioRepository.findAllHistorialesProveedoresProductosOServiciosPag(pageable, idHistorialProveedorProductoOServicio, keyword, orderBy, orderMode);
        return historialesProveedoresProductosOServicios.map(historialProveedorProductoOServicio -> historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(historialProveedorProductoOServicio));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialProveedorProductoOServicio(HistorialProveedorProductoOServicioDTO historialProveedorProductoOServicioDTO) {
        Long maxIdHistorialProveedorProductoOServicio = null;
        HistorialProveedorProductoOServicio historialProveedorProductoOServicioNumeroDocumentoIdentificacion = historialProveedorProductoOServicioRepository.findByNumeroDocumentoIdentificacionProvProdOServAndSiglaOAcronimoUnidadMilitar(historialProveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ(), historialProveedorProductoOServicioDTO.getSiglaOAcronimoUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroDocumentoIdentificacionRegistroEncontrado=0;
        
        if (!(historialProveedorProductoOServicioNumeroDocumentoIdentificacion==null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO Y ASOCIADO CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
           banderaNumeroDocumentoIdentificacionRegistroEncontrado=1;
        }
        
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO Y ASOCIADO CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_O_NIC_EN_UNIDAD_MILITAR_YA_EXISTE, false);
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(null);
        }
        if ((banderaNumeroDocumentoIdentificacionRegistroEncontrado==0)) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
           maxIdHistorialProveedorProductoOServicio = historialProveedorProductoOServicioRepository.findMaxIdHistorialProveedorProductoOServicio();
           if (maxIdHistorialProveedorProductoOServicio == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialProveedorProductoOServicio = Long.valueOf(0);
           }
           
           historialProveedorProductoOServicioDTO.setIdHistorialProveedorProductoOServicio(maxIdHistorialProveedorProductoOServicio + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DE LA AGRUPACIÓN COMBINANDO LA CADENA "HIST-PROV" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-", LA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR, LA CADENA "-" Y EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL PROVEEDOR DEL PRODUCTO O SERVICIO:
           historialProveedorProductoOServicioDTO.setNumRegHistorialProveedorProductoOServicio("HIST-PROV" + "-" + (maxIdHistorialProveedorProductoOServicio+1) + "-" + historialProveedorProductoOServicioDTO.getSiglaOAcronimoUnidadMilitar() + "-" + historialProveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ());
           
           historialProveedorProductoOServicioRepository.save(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicio(historialProveedorProductoOServicioDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProveedorProductoOServicioporId(Long idHistorialProveedorProductoOServicio) {
        Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioId = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(Long.valueOf(idHistorialProveedorProductoOServicio));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProveedorProductoOServicioId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(historialProveedorProductoOServicioId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProveedorProductoOServicioId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProveedorProductoOServicioporNumReg(String numRegHistorialProveedorProductoOServicio) {
        if (numRegHistorialProveedorProductoOServicio == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioNumReg = Optional.ofNullable(historialProveedorProductoOServicioRepository.findByNumRegHistorialProveedorProductoOServicio(numRegHistorialProveedorProductoOServicio));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialProveedorProductoOServicioNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(historialProveedorProductoOServicioNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProveedorProductoOServicioNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialProveedorProductoOServicio(HistorialProveedorProductoOServicioDTO historialProveedorProductoOServicioDTO) {
        Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioId = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(historialProveedorProductoOServicioDTO.getIdHistorialProveedorProductoOServicio());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialProveedorProductoOServicioId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (historialProveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ().equals(historialProveedorProductoOServicioId.get().getNumeroDocumentoIdentificacionProvProdOServ())==true) ) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO ES IGUAL AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              HistorialProveedorProductoOServicio historialProveedorProductoOServicio = historialProveedorProductoOServicioDAO.historialProveedorProductoOServicio(historialProveedorProductoOServicioDTO);
              historialProveedorProductoOServicioRepository.save(historialProveedorProductoOServicio);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (historialProveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ().equals(historialProveedorProductoOServicioId.get().getNumeroDocumentoIdentificacionProvProdOServ())==false) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO ES DIFERENTE AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO EXISTE EN OTROS REGISTROS.
              HistorialProveedorProductoOServicio historialProveedorProductoOServicioNumeroDocumentoIdentificacionySAUnidadMilitar = historialProveedorProductoOServicioRepository.findByNumeroDocumentoIdentificacionProvProdOServAndSiglaOAcronimoUnidadMilitar(historialProveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ(), historialProveedorProductoOServicioDTO.getSiglaOAcronimoUnidadMilitar());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
              
              if (!(historialProveedorProductoOServicioNumeroDocumentoIdentificacionySAUnidadMilitar == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
                 banderaNumeroDocumentoIdentificacionRegistroEncontrado = 1;
              }
              
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR ALMACENADOS EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL Y MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_O_NIC_EN_UNIDAD_MILITAR_YA_EXISTE, false);
                 respuestaDTO.setHistorialProveedorProductoOServicioDTO(null);
              }
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 historialProveedorProductoOServicioRepository.save(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicio(historialProveedorProductoOServicioDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (historialProveedorProductoOServicioId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialProveedorProductoOServicio(Long idHistorialProveedorProductoOServicio) {
        Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioId = historialProveedorProductoOServicioRepository.findById(idHistorialProveedorProductoOServicio);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProveedorProductoOServicioId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(historialProveedorProductoOServicioId.get()));
           historialProveedorProductoOServicioRepository.delete(historialProveedorProductoOServicioId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialProveedorProductoOServicioId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProveedorProductoOServicioDTO(null);
        }
        
        return respuestaDTO;
    }
}
