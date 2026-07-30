//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMantenimientoInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialMantenimientoInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialMantenimientoInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMantenimientoInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialMantenimientoInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialMantenimientoInfraestructuraServiceImpl implements HistorialMantenimientoInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialMantenimientoInfraestructuraDAO historialMantenimientoInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialMantenimientoInfraestructuraRepository historialMantenimientoInfraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialMantenimientoInfraestructura, String keyword) {
        return historialMantenimientoInfraestructuraRepository.findTotalRegistros(idHistorialMantenimientoInfraestructura, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialMantenimientoInfraestructuraDTO> listarHistorialesMantenimientosInfraestructuras(Long idHistorialMantenimientoInfraestructura, String keyword, String orderBy, String orderMode) {
        List<HistorialMantenimientoInfraestructura> historialesMantenimientosInfraestructuras = historialMantenimientoInfraestructuraRepository.findAllHistorialesMantenimientosInfraestructuras(idHistorialMantenimientoInfraestructura, keyword, orderBy, orderMode);
        List<HistorialMantenimientoInfraestructuraDTO> historialMantenimientoInfraestructuraDTOS = new ArrayList<>();
        for (HistorialMantenimientoInfraestructura historialMantenimientoInfraestructura : historialesMantenimientosInfraestructuras) {
            historialMantenimientoInfraestructuraDTOS.add(historialMantenimientoInfraestructuraDAO.historialMantenimientoInfraestructuraDTO(historialMantenimientoInfraestructura));
        }
        
        return historialMantenimientoInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialMantenimientoInfraestructuraDTO> listarHistorialesMantenimientosInfraestructurasPag(Pageable pageable, Long idHistorialMantenimientoInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<HistorialMantenimientoInfraestructura> historialesMantenimientosInfraestructuras = historialMantenimientoInfraestructuraRepository.findAllHistorialesMantenimientosInfraestructurasPag(pageable, idHistorialMantenimientoInfraestructura, keyword, orderBy, orderMode);
        return historialesMantenimientosInfraestructuras.map(historialMantenimientoInfraestructura -> historialMantenimientoInfraestructuraDAO.historialMantenimientoInfraestructuraDTO(historialMantenimientoInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialMantenimientoInfraestructura(HistorialMantenimientoInfraestructuraDTO historialMantenimientoInfraestructuraDTO) {
        Long maxIdHistorialMantenimientoInfraestructura = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        maxIdHistorialMantenimientoInfraestructura = historialMantenimientoInfraestructuraRepository.findMaxIdHistorialMantenimientoInfraestructura();
        if (maxIdHistorialMantenimientoInfraestructura == null) {
           maxIdHistorialMantenimientoInfraestructura = Long.valueOf(0);
        }
        historialMantenimientoInfraestructuraDTO.setIdHistorialMantenimientoInfraestructura(maxIdHistorialMantenimientoInfraestructura + 1);
        
        //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-MTTO-INFRAEST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
        SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHMSMantenimientoInfraestructuraSinIntermedios = objetoFechaHMS.format(historialMantenimientoInfraestructuraDTO.getFechaHMSMantenimientoInfraestructura());
        historialMantenimientoInfraestructuraDTO.setNumRegHistorialMantenimientoInfraestructura("HIST-MTTO-INFRAEST" + "-" + (maxIdHistorialMantenimientoInfraestructura + 1) + "-" + fechaHMSMantenimientoInfraestructuraSinIntermedios);
        
        historialMantenimientoInfraestructuraRepository.save(historialMantenimientoInfraestructuraDAO.historialMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialMantenimientoInfraestructuraporId(Long idHistorialMantenimientoInfraestructura) {
        Optional<HistorialMantenimientoInfraestructura> historialMantenimientoInfraestructuraId = historialMantenimientoInfraestructuraRepository.findByIdHistorialMantenimientoInfraestructura(Long.valueOf(idHistorialMantenimientoInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMantenimientoInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialMantenimientoInfraestructuraDTO(historialMantenimientoInfraestructuraDAO.historialMantenimientoInfraestructuraDTO(historialMantenimientoInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMantenimientoInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO.
    public RespuestaDTO consultarHistorialMantenimientoInfraestructuraporNumReg(String numRegHistorialMantenimientoInfraestructura) {
        if (numRegHistorialMantenimientoInfraestructura == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoInfraestructuraDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialMantenimientoInfraestructura> historialMantenimientoInfraestructuraNumReg = Optional.ofNullable(historialMantenimientoInfraestructuraRepository.findByNumRegHistorialMantenimientoInfraestructura(numRegHistorialMantenimientoInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialMantenimientoInfraestructuraNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialMantenimientoInfraestructuraDTO(historialMantenimientoInfraestructuraDAO.historialMantenimientoInfraestructuraDTO(historialMantenimientoInfraestructuraNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMantenimientoInfraestructuraNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialMantenimientoInfraestructura(HistorialMantenimientoInfraestructuraDTO historialMantenimientoInfraestructuraDTO) {
        Optional<HistorialMantenimientoInfraestructura> historialMantenimientoInfraestructuraId = historialMantenimientoInfraestructuraRepository.findByIdHistorialMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getIdHistorialMantenimientoInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialMantenimientoInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NUMERO DE REGISTRO CON EL ID PROPORCIONADO.
           //SE PRESERVA EL NÚMERO DE REGISTRO ORIGINAL DE LA BASE DE DATOS PARA NO VIOLAR LA RESTRICCIÓN ÚNICA:
           historialMantenimientoInfraestructuraDTO.setNumRegHistorialMantenimientoInfraestructura(historialMantenimientoInfraestructuraId.get().getNumRegHistorialMantenimientoInfraestructura());
           historialMantenimientoInfraestructuraRepository.save(historialMantenimientoInfraestructuraDAO.historialMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (historialMantenimientoInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialMantenimientoInfraestructura(Long idHistorialMantenimientoInfraestructura) {
        Optional<HistorialMantenimientoInfraestructura> historialMantenimientoInfraestructuraId = historialMantenimientoInfraestructuraRepository.findById(idHistorialMantenimientoInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMantenimientoInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialMantenimientoInfraestructuraRepository.delete(historialMantenimientoInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialMantenimientoInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
