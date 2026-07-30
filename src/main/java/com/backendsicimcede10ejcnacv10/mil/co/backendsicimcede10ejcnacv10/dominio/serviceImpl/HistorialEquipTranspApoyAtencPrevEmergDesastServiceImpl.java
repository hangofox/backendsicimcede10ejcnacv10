//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialEquipTranspApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialEquipTranspApoyAtencPrevEmergDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialEquipTranspApoyAtencPrevEmergDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialEquipTranspApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialEquipTranspApoyAtencPrevEmergDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class HistorialEquipTranspApoyAtencPrevEmergDesastServiceImpl implements HistorialEquipTranspApoyAtencPrevEmergDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialEquipTranspApoyAtencPrevEmergDesastDAO historialEquipTranspApoyAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialEquipTranspApoyAtencPrevEmergDesastRepository historialEquipTranspApoyAtencPrevEmergDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialEquipTranspApoyAtencPrevEmergDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero) {
        return historialEquipTranspApoyAtencPrevEmergDesastRepository.findTotalRegistros(idHistorialEquipTranspApoyAtencPrevEmergDesast, keyword, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, idEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialEquipTranspApoyAtencPrevEmergDesastDTO> listarHistorialesEquipsTranspsApoyAtencPrevEmergDesast(Long idHistorialEquipTranspApoyAtencPrevEmergDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero, String orderBy, String orderMode) {
        List<HistorialEquipTranspApoyAtencPrevEmergDesast> historialesEquipsTranspsApoyAtencPrevEmergDesast = historialEquipTranspApoyAtencPrevEmergDesastRepository.findAllHistorialesEquipsTranspsApoyAtencPrevEmergDesast(idHistorialEquipTranspApoyAtencPrevEmergDesast, keyword, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, idEquipoIngeniero, orderBy, orderMode);
        List<HistorialEquipTranspApoyAtencPrevEmergDesastDTO> historialEquipTranspApoyAtencPrevEmergDesastDTOS = new ArrayList<>();
        for (HistorialEquipTranspApoyAtencPrevEmergDesast historialEquipTranspApoyAtencPrevEmergDesast : historialesEquipsTranspsApoyAtencPrevEmergDesast) {
            historialEquipTranspApoyAtencPrevEmergDesastDTOS.add(historialEquipTranspApoyAtencPrevEmergDesastDAO.historialEquipTranspApoyAtencPrevEmergDesastDTO(historialEquipTranspApoyAtencPrevEmergDesast));
        }
        
        return historialEquipTranspApoyAtencPrevEmergDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialEquipTranspApoyAtencPrevEmergDesastDTO> listarHistorialesEquipsTranspsApoyAtencPrevEmergDesastPag(Pageable pageable, Long idHistorialEquipTranspApoyAtencPrevEmergDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero, String orderBy, String orderMode) {
        Slice<HistorialEquipTranspApoyAtencPrevEmergDesast> historialesEquipsTranspsApoyAtencPrevEmergDesast = historialEquipTranspApoyAtencPrevEmergDesastRepository.findAllHistorialesEquipsTranspsApoyAtencPrevEmergDesastPag(pageable, idHistorialEquipTranspApoyAtencPrevEmergDesast, keyword, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, idEquipoIngeniero, orderBy, orderMode);
        return historialesEquipsTranspsApoyAtencPrevEmergDesast.map(historialEquipTranspApoyAtencPrevEmergDesast -> historialEquipTranspApoyAtencPrevEmergDesastDAO.historialEquipTranspApoyAtencPrevEmergDesastDTO(historialEquipTranspApoyAtencPrevEmergDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialEquipTranspApoyAtencPrevEmergDesast(HistorialEquipTranspApoyAtencPrevEmergDesastDTO historialEquipTranspApoyAtencPrevEmergDesastDTO) {
        Long maxIdHistorialEquipTranspApoyAtencPrevEmergDesast = historialEquipTranspApoyAtencPrevEmergDesastRepository.findMaxIdHistorialEquipTranspApoyAtencPrevEmergDesast();
        HistorialEquipTranspApoyAtencPrevEmergDesast historialEquipTranspApoyAtencPrevEmergDesastUnica = historialEquipTranspApoyAtencPrevEmergDesastRepository.findByNumRegHistorialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO.getNumRegHistorialEquipTranspApoyAtencPrevEmergDesast().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialEquipTranspApoyAtencPrevEmergDesastUnica == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           if (maxIdHistorialEquipTranspApoyAtencPrevEmergDesast == null) {
              maxIdHistorialEquipTranspApoyAtencPrevEmergDesast = Long.valueOf(0);
           }
           historialEquipTranspApoyAtencPrevEmergDesastDTO.setIdHistorialEquipTranspApoyAtencPrevEmergDesast(maxIdHistorialEquipTranspApoyAtencPrevEmergDesast + 1);
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-EQUIP-TRANSP-APOY-ATENC-PREV-EMERG-DESAST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialEquipTranspApoyAtencPrevEmergDesastSinIntermedios = objetoFechaHMS.format(new Date());
           historialEquipTranspApoyAtencPrevEmergDesastDTO.setNumRegHistorialEquipTranspApoyAtencPrevEmergDesast("HIST-EQUIP-TRANSP-APOY-ATENC-PREV-EMERG-DESAST" + "-" + (maxIdHistorialEquipTranspApoyAtencPrevEmergDesast + 1) + "-" + fechaHMSIngresoHistorialEquipTranspApoyAtencPrevEmergDesastSinIntermedios);
           
           historialEquipTranspApoyAtencPrevEmergDesastRepository.save(historialEquipTranspApoyAtencPrevEmergDesastDAO.historialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialEquipTranspApoyAtencPrevEmergDesastporId(Long idHistorialEquipTranspApoyAtencPrevEmergDesast) {
        Optional<HistorialEquipTranspApoyAtencPrevEmergDesast> historialEquipTranspApoyAtencPrevEmergDesastId = historialEquipTranspApoyAtencPrevEmergDesastRepository.findByIdHistorialEquipTranspApoyAtencPrevEmergDesast(Long.valueOf(idHistorialEquipTranspApoyAtencPrevEmergDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialEquipTranspApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(historialEquipTranspApoyAtencPrevEmergDesastDAO.historialEquipTranspApoyAtencPrevEmergDesastDTO(historialEquipTranspApoyAtencPrevEmergDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialEquipTranspApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialEquipTranspApoyAtencPrevEmergDesastporNumReg(String numRegHistorialEquipTranspApoyAtencPrevEmergDesast) {
        Optional<HistorialEquipTranspApoyAtencPrevEmergDesast> historialEquipTranspApoyAtencPrevEmergDesastNumReg = Optional.ofNullable(historialEquipTranspApoyAtencPrevEmergDesastRepository.findByNumRegHistorialEquipTranspApoyAtencPrevEmergDesast(numRegHistorialEquipTranspApoyAtencPrevEmergDesast.toUpperCase()));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialEquipTranspApoyAtencPrevEmergDesastNumReg.isPresent() == true) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(historialEquipTranspApoyAtencPrevEmergDesastDAO.historialEquipTranspApoyAtencPrevEmergDesastDTO(historialEquipTranspApoyAtencPrevEmergDesastNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialEquipTranspApoyAtencPrevEmergDesastNumReg.isPresent() == false) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialEquipTranspApoyAtencPrevEmergDesast(HistorialEquipTranspApoyAtencPrevEmergDesastDTO historialEquipTranspApoyAtencPrevEmergDesastDTO) {
        Optional<HistorialEquipTranspApoyAtencPrevEmergDesast> historialEquipTranspApoyAtencPrevEmergDesastId = historialEquipTranspApoyAtencPrevEmergDesastRepository.findByIdHistorialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO.getIdHistorialEquipTranspApoyAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialEquipTranspApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialEquipTranspApoyAtencPrevEmergDesast historialEquipTranspApoyAtencPrevEmergDesastUnico = historialEquipTranspApoyAtencPrevEmergDesastRepository.findByNumRegHistorialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO.getNumRegHistorialEquipTranspApoyAtencPrevEmergDesast());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialEquipTranspApoyAtencPrevEmergDesastUnico == null) && !(historialEquipTranspApoyAtencPrevEmergDesastUnico.getIdHistorialEquipTranspApoyAtencPrevEmergDesast().equals(historialEquipTranspApoyAtencPrevEmergDesastDTO.getIdHistorialEquipTranspApoyAtencPrevEmergDesast()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialEquipTranspApoyAtencPrevEmergDesastRepository.save(historialEquipTranspApoyAtencPrevEmergDesastDAO.historialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialEquipTranspApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialEquipTranspApoyAtencPrevEmergDesast(Long idHistorialEquipTranspApoyAtencPrevEmergDesast) {
        Optional<HistorialEquipTranspApoyAtencPrevEmergDesast> historialEquipTranspApoyAtencPrevEmergDesastId = historialEquipTranspApoyAtencPrevEmergDesastRepository.findById(idHistorialEquipTranspApoyAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialEquipTranspApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialEquipTranspApoyAtencPrevEmergDesastRepository.delete(historialEquipTranspApoyAtencPrevEmergDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialEquipTranspApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialEquipTranspApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
