//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialTipoPersonalApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialTipoPersonalApoyAtencPrevEmergDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialTipoPersonalApoyAtencPrevEmergDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialTipoPersonalApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialTipoPersonalApoyAtencPrevEmergDesastRepository;
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
public class HistorialTipoPersonalApoyAtencPrevEmergDesastServiceImpl implements HistorialTipoPersonalApoyAtencPrevEmergDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialTipoPersonalApoyAtencPrevEmergDesastDAO historialTipoPersonalApoyAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialTipoPersonalApoyAtencPrevEmergDesastRepository historialTipoPersonalApoyAtencPrevEmergDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialTipoPersonalApoyAtencPrevEmergDesast, String keyword) {
        return historialTipoPersonalApoyAtencPrevEmergDesastRepository.findTotalRegistros(idHistorialTipoPersonalApoyAtencPrevEmergDesast, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialTipoPersonalApoyAtencPrevEmergDesastDTO> listarHistorialesTiposPersonalApoyAtencPrevEmergDesast(Long idHistorialTipoPersonalApoyAtencPrevEmergDesast, String keyword, String orderBy, String orderMode) {
        List<HistorialTipoPersonalApoyAtencPrevEmergDesast> historialesTiposPersonalApoyAtencPrevEmergDesast = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findAllHistorialesTiposPersonalApoyAtencPrevEmergDesast(idHistorialTipoPersonalApoyAtencPrevEmergDesast, keyword, orderBy, orderMode);
        List<HistorialTipoPersonalApoyAtencPrevEmergDesastDTO> historialTipoPersonalApoyAtencPrevEmergDesastDTOS = new ArrayList<>();
        for (HistorialTipoPersonalApoyAtencPrevEmergDesast historialTipoPersonalApoyAtencPrevEmergDesast : historialesTiposPersonalApoyAtencPrevEmergDesast) {
            historialTipoPersonalApoyAtencPrevEmergDesastDTOS.add(historialTipoPersonalApoyAtencPrevEmergDesastDAO.historialTipoPersonalApoyAtencPrevEmergDesastDTO(historialTipoPersonalApoyAtencPrevEmergDesast));
        }
        
        return historialTipoPersonalApoyAtencPrevEmergDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialTipoPersonalApoyAtencPrevEmergDesastDTO> listarHistorialesTiposPersonalApoyAtencPrevEmergDesastPag(Pageable pageable, Long idHistorialTipoPersonalApoyAtencPrevEmergDesast, String keyword, String orderBy, String orderMode) {
        Slice<HistorialTipoPersonalApoyAtencPrevEmergDesast> historialesTiposPersonalApoyAtencPrevEmergDesast = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findAllHistorialesTiposPersonalApoyAtencPrevEmergDesastPag(pageable, idHistorialTipoPersonalApoyAtencPrevEmergDesast, keyword, orderBy, orderMode);
        return historialesTiposPersonalApoyAtencPrevEmergDesast.map(historialTipoPersonalApoyAtencPrevEmergDesast -> historialTipoPersonalApoyAtencPrevEmergDesastDAO.historialTipoPersonalApoyAtencPrevEmergDesastDTO(historialTipoPersonalApoyAtencPrevEmergDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialTipoPersonalApoyAtencPrevEmergDesast(HistorialTipoPersonalApoyAtencPrevEmergDesastDTO historialTipoPersonalApoyAtencPrevEmergDesastDTO) {
        Long maxIdHistorialTipoPersonalApoyAtencPrevEmergDesast = null;
        HistorialTipoPersonalApoyAtencPrevEmergDesast historialTipoPersonalApoyAtencPrevEmergDesastUnico = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findByNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialTipoPersonalApoyAtencPrevEmergDesastUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO.
           maxIdHistorialTipoPersonalApoyAtencPrevEmergDesast = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findMaxIdHistorialTipoPersonalApoyAtencPrevEmergDesast();
           if (maxIdHistorialTipoPersonalApoyAtencPrevEmergDesast == null) {
              maxIdHistorialTipoPersonalApoyAtencPrevEmergDesast = Long.valueOf(0);
           }
           historialTipoPersonalApoyAtencPrevEmergDesastDTO.setIdHistorialTipoPersonalApoyAtencPrevEmergDesast(maxIdHistorialTipoPersonalApoyAtencPrevEmergDesast + 1);
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-TIP-PERS-APOY-ATENC-PREV-EMERG-DESAST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialTipoPersonalApoyAtencPrevEmergDesastSinIntermedios = objetoFechaHMS.format(new Date());
           historialTipoPersonalApoyAtencPrevEmergDesastDTO.setNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast("HIST-TIP-PERS-APOY-ATENC-PREV-EMERG-DESAST" + "-" + (maxIdHistorialTipoPersonalApoyAtencPrevEmergDesast + 1) + "-" + fechaHMSIngresoHistorialTipoPersonalApoyAtencPrevEmergDesastSinIntermedios);
           
           historialTipoPersonalApoyAtencPrevEmergDesastRepository.save(historialTipoPersonalApoyAtencPrevEmergDesastDAO.historialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialTipoPersonalApoyAtencPrevEmergDesastporId(Long idHistorialTipoPersonalApoyAtencPrevEmergDesast) {
        Optional<HistorialTipoPersonalApoyAtencPrevEmergDesast> historialTipoPersonalApoyAtencPrevEmergDesastId = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findByIdHistorialTipoPersonalApoyAtencPrevEmergDesast(Long.valueOf(idHistorialTipoPersonalApoyAtencPrevEmergDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialTipoPersonalApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(historialTipoPersonalApoyAtencPrevEmergDesastDAO.historialTipoPersonalApoyAtencPrevEmergDesastDTO(historialTipoPersonalApoyAtencPrevEmergDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialTipoPersonalApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO.
    public RespuestaDTO consultarHistorialTipoPersonalApoyAtencPrevEmergDesastporNumReg(String numRegHistorialTipoPersonalApoyAtencPrevEmergDesast) {
        HistorialTipoPersonalApoyAtencPrevEmergDesast historialTipoPersonalApoyAtencPrevEmergDesastNumReg = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findByNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast(numRegHistorialTipoPersonalApoyAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (!(historialTipoPersonalApoyAtencPrevEmergDesastNumReg == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(historialTipoPersonalApoyAtencPrevEmergDesastDAO.historialTipoPersonalApoyAtencPrevEmergDesastDTO(historialTipoPersonalApoyAtencPrevEmergDesastNumReg));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialTipoPersonalApoyAtencPrevEmergDesastNumReg == null) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialTipoPersonalApoyAtencPrevEmergDesast(HistorialTipoPersonalApoyAtencPrevEmergDesastDTO historialTipoPersonalApoyAtencPrevEmergDesastDTO) {
        Optional<HistorialTipoPersonalApoyAtencPrevEmergDesast> historialTipoPersonalApoyAtencPrevEmergDesastId = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findByIdHistorialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getIdHistorialTipoPersonalApoyAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialTipoPersonalApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialTipoPersonalApoyAtencPrevEmergDesast historialTipoPersonalApoyAtencPrevEmergDesastUnico = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findByNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialTipoPersonalApoyAtencPrevEmergDesastUnico == null) && !(historialTipoPersonalApoyAtencPrevEmergDesastUnico.getIdHistorialTipoPersonalApoyAtencPrevEmergDesast().equals(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getIdHistorialTipoPersonalApoyAtencPrevEmergDesast()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialTipoPersonalApoyAtencPrevEmergDesastRepository.save(historialTipoPersonalApoyAtencPrevEmergDesastDAO.historialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialTipoPersonalApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialTipoPersonalApoyAtencPrevEmergDesast(Long idHistorialTipoPersonalApoyAtencPrevEmergDesast) {
        Optional<HistorialTipoPersonalApoyAtencPrevEmergDesast> historialTipoPersonalApoyAtencPrevEmergDesastId = historialTipoPersonalApoyAtencPrevEmergDesastRepository.findById(idHistorialTipoPersonalApoyAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialTipoPersonalApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialTipoPersonalApoyAtencPrevEmergDesastRepository.delete(historialTipoPersonalApoyAtencPrevEmergDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialTipoPersonalApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
