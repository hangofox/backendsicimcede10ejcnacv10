//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialMaqPesadApoyObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialMaqPesadApoyObrRedMitigGestRiesgDesastRepository;
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
public class HistorialMaqPesadApoyObrRedMitigGestRiesgDesastServiceImpl implements HistorialMaqPesadApoyObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDAO historialMaqPesadApoyObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialMaqPesadApoyObrRedMitigGestRiesgDesastRepository historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, String keyword) {
        return historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO> listarHistorialesMaqPesadApoyObrRedMitigGestRiesgDesast(Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        List<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> historialesMaqPesadApoyObrRedMitigGestRiesgDesast = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findAllHistorialesMaqPesadApoyObrRedMitigGestRiesgDesast(idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        List<HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO> historialMaqPesadApoyObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        for (HistorialMaqPesadApoyObrRedMitigGestRiesgDesast historialMaqPesadApoyObrRedMitigGestRiesgDesast : historialesMaqPesadApoyObrRedMitigGestRiesgDesast) {
            historialMaqPesadApoyObrRedMitigGestRiesgDesastDTOS.add(historialMaqPesadApoyObrRedMitigGestRiesgDesastDAO.historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(historialMaqPesadApoyObrRedMitigGestRiesgDesast));
        }
        
        return historialMaqPesadApoyObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO> listarHistorialesMaqPesadApoyObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        Slice<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> historialesMaqPesadApoyObrRedMitigGestRiesgDesast = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findAllHistorialesMaqPesadApoyObrRedMitigGestRiesgDesastPag(pageable, idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        return historialesMaqPesadApoyObrRedMitigGestRiesgDesast.map(historialMaqPesadApoyObrRedMitigGestRiesgDesast -> historialMaqPesadApoyObrRedMitigGestRiesgDesastDAO.historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(historialMaqPesadApoyObrRedMitigGestRiesgDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO) {
        Long maxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast = null;
        HistorialMaqPesadApoyObrRedMitigGestRiesgDesast historialMaqPesadApoyObrRedMitigGestRiesgDesastUnico = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialMaqPesadApoyObrRedMitigGestRiesgDesastUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO.
           maxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findMaxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast();
           if (maxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast == null) {
              maxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast = Long.valueOf(0);
           }
           historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.setIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(maxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast + 1);
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-MAQ-PESAD-APOY-OBR-RED-MITIG-GEST-RIESG-DESAST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialMaqPesadApoyObrRedMitigGestRiesgDesastSinIntermedios = objetoFechaHMS.format(new Date());
           historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.setNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast("HIST-MAQ-PESAD-APOY-OBR-RED-MITIG-GEST-RIESG-DESAST" + "-" + (maxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast + 1) + "-" + fechaHMSIngresoHistorialMaqPesadApoyObrRedMitigGestRiesgDesastSinIntermedios);
           
           historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.save(historialMaqPesadApoyObrRedMitigGestRiesgDesastDAO.historialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialMaqPesadApoyObrRedMitigGestRiesgDesastporId(Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) {
        Optional<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> historialMaqPesadApoyObrRedMitigGestRiesgDesastId = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findByIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(Long.valueOf(idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(historialMaqPesadApoyObrRedMitigGestRiesgDesastDAO.historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(historialMaqPesadApoyObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO.
    public RespuestaDTO consultarHistorialMaqPesadApoyObrRedMitigGestRiesgDesastporNumReg(String numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) {
        HistorialMaqPesadApoyObrRedMitigGestRiesgDesast historialMaqPesadApoyObrRedMitigGestRiesgDesastNumReg = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (!(historialMaqPesadApoyObrRedMitigGestRiesgDesastNumReg == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(historialMaqPesadApoyObrRedMitigGestRiesgDesastDAO.historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(historialMaqPesadApoyObrRedMitigGestRiesgDesastNumReg));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastNumReg == null) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO) {
        Optional<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> historialMaqPesadApoyObrRedMitigGestRiesgDesastId = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findByIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialMaqPesadApoyObrRedMitigGestRiesgDesast historialMaqPesadApoyObrRedMitigGestRiesgDesastUnico = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialMaqPesadApoyObrRedMitigGestRiesgDesastUnico == null) && !(historialMaqPesadApoyObrRedMitigGestRiesgDesastUnico.getIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast().equals(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.save(historialMaqPesadApoyObrRedMitigGestRiesgDesastDAO.historialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) {
        Optional<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> historialMaqPesadApoyObrRedMitigGestRiesgDesastId = historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.findById(idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialMaqPesadApoyObrRedMitigGestRiesgDesastRepository.delete(historialMaqPesadApoyObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
