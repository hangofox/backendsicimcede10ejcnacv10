//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialMantenimientoEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialMantenimientoEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialMantenimientoEquipoIngenieroRepository;
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
public class HistorialMantenimientoEquipoIngenieroServiceImpl implements HistorialMantenimientoEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialMantenimientoEquipoIngenieroDAO historialMantenimientoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialMantenimientoEquipoIngenieroRepository historialMantenimientoEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialMantenimientoEquipoIngeniero, String keyword) {
        return historialMantenimientoEquipoIngenieroRepository.findTotalRegistros(idHistorialMantenimientoEquipoIngeniero, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialMantenimientoEquipoIngenieroDTO> listarHistorialesMantenimientosEquiposIngenieros(Long idHistorialMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<HistorialMantenimientoEquipoIngeniero> historialesMantenimientosEquiposIngenieros = historialMantenimientoEquipoIngenieroRepository.findAllHistorialesMantenimientosEquiposIngenieros(idHistorialMantenimientoEquipoIngeniero, keyword, orderBy, orderMode);
        List<HistorialMantenimientoEquipoIngenieroDTO> historialMantenimientoEquipoIngenierosDTOS = new ArrayList<>();
        for (HistorialMantenimientoEquipoIngeniero historialMantenimientoEquipoIngeniero : historialesMantenimientosEquiposIngenieros) {
            historialMantenimientoEquipoIngenierosDTOS.add(historialMantenimientoEquipoIngenieroDAO.historialMantenimientoEquipoIngenieroDTO(historialMantenimientoEquipoIngeniero));
        }
        
        return historialMantenimientoEquipoIngenierosDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialMantenimientoEquipoIngenieroDTO> listarHistorialesMantenimientosEquiposIngenierosPag(Pageable pageable, Long idHistorialMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<HistorialMantenimientoEquipoIngeniero> historialesMantenimientosEquiposIngenieros = historialMantenimientoEquipoIngenieroRepository.findAllHistorialesMantenimientosEquiposIngenierosPag(pageable, idHistorialMantenimientoEquipoIngeniero, keyword, orderBy, orderMode);
        return historialesMantenimientosEquiposIngenieros.map(historialMantenimientoEquipoIngeniero -> historialMantenimientoEquipoIngenieroDAO.historialMantenimientoEquipoIngenieroDTO(historialMantenimientoEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialMantenimientoEquipoIngeniero(HistorialMantenimientoEquipoIngenieroDTO historialMantenimientoEquipoIngenieroDTO) {
        Long maxIdHistorialMantenimientoEquipoIngeniero = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        maxIdHistorialMantenimientoEquipoIngeniero = historialMantenimientoEquipoIngenieroRepository.findMaxIdHistorialMantenimientoEquipoIngeniero();
        if (maxIdHistorialMantenimientoEquipoIngeniero == null) {
           maxIdHistorialMantenimientoEquipoIngeniero = Long.valueOf(0);
        }
        historialMantenimientoEquipoIngenieroDTO.setIdHistorialMantenimientoEquipoIngeniero(maxIdHistorialMantenimientoEquipoIngeniero + 1);
        
        //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-MTTO-EQUIP-ING" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
        SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHMSMantenimientoEquipoIngenieroSinIntermedios = objetoFechaHMS.format(historialMantenimientoEquipoIngenieroDTO.getFechaHMSMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngenieroDTO.setNumRegHistorialMantenimientoEquipoIngeniero("HIST-MTTO-EQUIP-ING" + "-" + (maxIdHistorialMantenimientoEquipoIngeniero + 1) + "-" + fechaHMSMantenimientoEquipoIngenieroSinIntermedios);
        
        historialMantenimientoEquipoIngenieroRepository.save(historialMantenimientoEquipoIngenieroDAO.historialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialMantenimientoEquipoIngenieroporId(Long idHistorialMantenimientoEquipoIngeniero) {
        Optional<HistorialMantenimientoEquipoIngeniero> historialMantenimientoEquipoIngenieroId = historialMantenimientoEquipoIngenieroRepository.findByIdHistorialMantenimientoEquipoIngeniero(Long.valueOf(idHistorialMantenimientoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMantenimientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialMantenimientoEquipoIngenieroDTO(historialMantenimientoEquipoIngenieroDAO.historialMantenimientoEquipoIngenieroDTO(historialMantenimientoEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMantenimientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO.
    public RespuestaDTO consultarHistorialMantenimientoEquipoIngenieroporNumReg(String numRegHistorialMantenimientoEquipoIngeniero) {
        if (numRegHistorialMantenimientoEquipoIngeniero == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoEquipoIngenieroDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialMantenimientoEquipoIngeniero> historialMantenimientoEquipoIngenieroNumReg = Optional.ofNullable(historialMantenimientoEquipoIngenieroRepository.findByNumRegHistorialMantenimientoEquipoIngeniero(numRegHistorialMantenimientoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialMantenimientoEquipoIngenieroNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialMantenimientoEquipoIngenieroDTO(historialMantenimientoEquipoIngenieroDAO.historialMantenimientoEquipoIngenieroDTO(historialMantenimientoEquipoIngenieroNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMantenimientoEquipoIngenieroNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoEquipoIngenieroDTO(null);
        }

        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialMantenimientoEquipoIngeniero(HistorialMantenimientoEquipoIngenieroDTO historialMantenimientoEquipoIngenieroDTO) {
        Optional<HistorialMantenimientoEquipoIngeniero> historialMantenimientoEquipoIngenieroId = historialMantenimientoEquipoIngenieroRepository.findByIdHistorialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getIdHistorialMantenimientoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialMantenimientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NUMERO DE REGISTRO CON EL ID PROPORCIONADO.
           //SE PRESERVA EL NÚMERO DE REGISTRO ORIGINAL DE LA BASE DE DATOS PARA NO VIOLAR LA RESTRICCIÓN ÚNICA:
           historialMantenimientoEquipoIngenieroDTO.setNumRegHistorialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroId.get().getNumRegHistorialMantenimientoEquipoIngeniero());
           historialMantenimientoEquipoIngenieroRepository.save(historialMantenimientoEquipoIngenieroDAO.historialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (historialMantenimientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialMantenimientoEquipoIngeniero(Long idHistorialMantenimientoEquipoIngeniero) {
        Optional<HistorialMantenimientoEquipoIngeniero> historialMantenimientoEquipoIngenieroId = historialMantenimientoEquipoIngenieroRepository.findById(idHistorialMantenimientoEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMantenimientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialMantenimientoEquipoIngenieroRepository.delete(historialMantenimientoEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialMantenimientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
