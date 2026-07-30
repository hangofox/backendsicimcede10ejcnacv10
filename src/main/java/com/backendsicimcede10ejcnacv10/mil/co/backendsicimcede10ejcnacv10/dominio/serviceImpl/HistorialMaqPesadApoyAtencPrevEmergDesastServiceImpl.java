//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMaqPesadApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialMaqPesadApoyAtencPrevEmergDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialMaqPesadApoyAtencPrevEmergDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMaqPesadApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialMaqPesadApoyAtencPrevEmergDesastRepository;
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
public class HistorialMaqPesadApoyAtencPrevEmergDesastServiceImpl implements HistorialMaqPesadApoyAtencPrevEmergDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialMaqPesadApoyAtencPrevEmergDesastDAO historialMaqPesadApoyAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialMaqPesadApoyAtencPrevEmergDesastRepository historialMaqPesadApoyAtencPrevEmergDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialMaqPesadApoyAtencPrevEmergDesast, String keyword) {
        return historialMaqPesadApoyAtencPrevEmergDesastRepository.findTotalRegistros(idHistorialMaqPesadApoyAtencPrevEmergDesast, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialMaqPesadApoyAtencPrevEmergDesastDTO> listarHistorialesMaqPesadApoyAtencPrevEmergDesast(Long idHistorialMaqPesadApoyAtencPrevEmergDesast, String keyword, String orderBy, String orderMode) {
        List<HistorialMaqPesadApoyAtencPrevEmergDesast> historialesMaqPesadApoyAtencPrevEmergDesast = historialMaqPesadApoyAtencPrevEmergDesastRepository.findAllHistorialesMaqPesadApoyAtencPrevEmergDesast(idHistorialMaqPesadApoyAtencPrevEmergDesast, keyword, orderBy, orderMode);
        List<HistorialMaqPesadApoyAtencPrevEmergDesastDTO> historialMaqPesadApoyAtencPrevEmergDesastDTOS = new ArrayList<>();
        for (HistorialMaqPesadApoyAtencPrevEmergDesast historialMaqPesadApoyAtencPrevEmergDesast : historialesMaqPesadApoyAtencPrevEmergDesast) {
            historialMaqPesadApoyAtencPrevEmergDesastDTOS.add(historialMaqPesadApoyAtencPrevEmergDesastDAO.historialMaqPesadApoyAtencPrevEmergDesastDTO(historialMaqPesadApoyAtencPrevEmergDesast));
        }
        
        return historialMaqPesadApoyAtencPrevEmergDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialMaqPesadApoyAtencPrevEmergDesastDTO> listarHistorialesMaqPesadApoyAtencPrevEmergDesastPag(Pageable pageable, Long idHistorialMaqPesadApoyAtencPrevEmergDesast, String keyword, String orderBy, String orderMode) {
        Slice<HistorialMaqPesadApoyAtencPrevEmergDesast> historialesMaqPesadApoyAtencPrevEmergDesast = historialMaqPesadApoyAtencPrevEmergDesastRepository.findAllHistorialesMaqPesadApoyAtencPrevEmergDesastPag(pageable, idHistorialMaqPesadApoyAtencPrevEmergDesast, keyword, orderBy, orderMode);
        return historialesMaqPesadApoyAtencPrevEmergDesast.map(historialMaqPesadApoyAtencPrevEmergDesast -> historialMaqPesadApoyAtencPrevEmergDesastDAO.historialMaqPesadApoyAtencPrevEmergDesastDTO(historialMaqPesadApoyAtencPrevEmergDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialMaqPesadApoyAtencPrevEmergDesast(HistorialMaqPesadApoyAtencPrevEmergDesastDTO historialMaqPesadApoyAtencPrevEmergDesastDTO) {
        Long maxIdHistorialMaqPesadApoyAtencPrevEmergDesast = null;
        HistorialMaqPesadApoyAtencPrevEmergDesast historialMaqPesadApoyAtencPrevEmergDesastUnico = historialMaqPesadApoyAtencPrevEmergDesastRepository.findByNumRegHistorialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO.getNumRegHistorialMaqPesadApoyAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialMaqPesadApoyAtencPrevEmergDesastUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO.
           maxIdHistorialMaqPesadApoyAtencPrevEmergDesast = historialMaqPesadApoyAtencPrevEmergDesastRepository.findMaxIdHistorialMaqPesadApoyAtencPrevEmergDesast();
           if (maxIdHistorialMaqPesadApoyAtencPrevEmergDesast == null) {
              maxIdHistorialMaqPesadApoyAtencPrevEmergDesast = Long.valueOf(0);
           }
           historialMaqPesadApoyAtencPrevEmergDesastDTO.setIdHistorialMaqPesadApoyAtencPrevEmergDesast(maxIdHistorialMaqPesadApoyAtencPrevEmergDesast + 1);
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-MAQ-PESAD-APOY-ATENC-PREV-EMERG-DESAST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialMaqPesadApoyAtencPrevEmergDesastSinIntermedios = objetoFechaHMS.format(new Date());
           historialMaqPesadApoyAtencPrevEmergDesastDTO.setNumRegHistorialMaqPesadApoyAtencPrevEmergDesast("HIST-MAQ-PESAD-APOY-ATENC-PREV-EMERG-DESAST" + "-" + (maxIdHistorialMaqPesadApoyAtencPrevEmergDesast + 1) + "-" + fechaHMSIngresoHistorialMaqPesadApoyAtencPrevEmergDesastSinIntermedios);
           
           historialMaqPesadApoyAtencPrevEmergDesastRepository.save(historialMaqPesadApoyAtencPrevEmergDesastDAO.historialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialMaqPesadApoyAtencPrevEmergDesastporId(Long idHistorialMaqPesadApoyAtencPrevEmergDesast) {
        Optional<HistorialMaqPesadApoyAtencPrevEmergDesast> historialMaqPesadApoyAtencPrevEmergDesastId = historialMaqPesadApoyAtencPrevEmergDesastRepository.findByIdHistorialMaqPesadApoyAtencPrevEmergDesast(Long.valueOf(idHistorialMaqPesadApoyAtencPrevEmergDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMaqPesadApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(historialMaqPesadApoyAtencPrevEmergDesastDAO.historialMaqPesadApoyAtencPrevEmergDesastDTO(historialMaqPesadApoyAtencPrevEmergDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMaqPesadApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO.
    public RespuestaDTO consultarHistorialMaqPesadApoyAtencPrevEmergDesastporNumReg(String numRegHistorialMaqPesadApoyAtencPrevEmergDesast) {
        HistorialMaqPesadApoyAtencPrevEmergDesast historialMaqPesadApoyAtencPrevEmergDesastNumReg = historialMaqPesadApoyAtencPrevEmergDesastRepository.findByNumRegHistorialMaqPesadApoyAtencPrevEmergDesast(numRegHistorialMaqPesadApoyAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (!(historialMaqPesadApoyAtencPrevEmergDesastNumReg == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(historialMaqPesadApoyAtencPrevEmergDesastDAO.historialMaqPesadApoyAtencPrevEmergDesastDTO(historialMaqPesadApoyAtencPrevEmergDesastNumReg));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMaqPesadApoyAtencPrevEmergDesastNumReg == null) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialMaqPesadApoyAtencPrevEmergDesast(HistorialMaqPesadApoyAtencPrevEmergDesastDTO historialMaqPesadApoyAtencPrevEmergDesastDTO) {
        Optional<HistorialMaqPesadApoyAtencPrevEmergDesast> historialMaqPesadApoyAtencPrevEmergDesastId = historialMaqPesadApoyAtencPrevEmergDesastRepository.findByIdHistorialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO.getIdHistorialMaqPesadApoyAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialMaqPesadApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialMaqPesadApoyAtencPrevEmergDesast historialMaqPesadApoyAtencPrevEmergDesastUnico = historialMaqPesadApoyAtencPrevEmergDesastRepository.findByNumRegHistorialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO.getNumRegHistorialMaqPesadApoyAtencPrevEmergDesast());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialMaqPesadApoyAtencPrevEmergDesastUnico == null) && !(historialMaqPesadApoyAtencPrevEmergDesastUnico.getIdHistorialMaqPesadApoyAtencPrevEmergDesast().equals(historialMaqPesadApoyAtencPrevEmergDesastDTO.getIdHistorialMaqPesadApoyAtencPrevEmergDesast()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialMaqPesadApoyAtencPrevEmergDesastRepository.save(historialMaqPesadApoyAtencPrevEmergDesastDAO.historialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialMaqPesadApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialMaqPesadApoyAtencPrevEmergDesast(Long idHistorialMaqPesadApoyAtencPrevEmergDesast) {
        Optional<HistorialMaqPesadApoyAtencPrevEmergDesast> historialMaqPesadApoyAtencPrevEmergDesastId = historialMaqPesadApoyAtencPrevEmergDesastRepository.findById(idHistorialMaqPesadApoyAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMaqPesadApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialMaqPesadApoyAtencPrevEmergDesastRepository.delete(historialMaqPesadApoyAtencPrevEmergDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialMaqPesadApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMaqPesadApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
