//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository;
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
public class HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastServiceImpl implements HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO historialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, String keyword) {
        return historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO> listarHistorialesTiposPersonalApoyObrRedMitigGestRiesgDesast(Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        List<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> historialesTiposPersonalApoyObrRedMitigGestRiesgDesast = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findAllHistorialesTiposPersonalApoyObrRedMitigGestRiesgDesast(idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        List<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO> historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        for (HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast historialTipoPersonalApoyObrRedMitigGestRiesgDesast : historialesTiposPersonalApoyObrRedMitigGestRiesgDesast) {
            historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTOS.add(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO.historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(historialTipoPersonalApoyObrRedMitigGestRiesgDesast));
        }
        
        return historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO> listarHistorialesTiposPersonalApoyObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        Slice<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> historialesTiposPersonalApoyObrRedMitigGestRiesgDesast = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findAllHistorialesTiposPersonalApoyObrRedMitigGestRiesgDesastPag(pageable, idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        return historialesTiposPersonalApoyObrRedMitigGestRiesgDesast.map(historialTipoPersonalApoyObrRedMitigGestRiesgDesast -> historialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO.historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(historialTipoPersonalApoyObrRedMitigGestRiesgDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO) {
        Long maxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast = null;
        HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast historialTipoPersonalApoyObrRedMitigGestRiesgDesastUnico = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialTipoPersonalApoyObrRedMitigGestRiesgDesastUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO.
           maxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findMaxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast();
           if (maxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast == null) {
              maxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast = Long.valueOf(0);
           }
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-TIP-PERS-APOY-OBR-RED-MITIG-GEST-RIESG-DESAST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastSinIntermedios = objetoFechaHMS.format(new Date());
           historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast("HIST-TIP-PERS-APOY-OBR-RED-MITIG-GEST-RIESG-DESAST" + "-" + (maxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast + 1) + "-" + fechaHMSIngresoHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastSinIntermedios);
           
           historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(maxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast + 1);
           historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.save(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO.historialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastporId(Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) {
        Optional<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> historialTipoPersonalApoyObrRedMitigGestRiesgDesastId = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findByIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(Long.valueOf(idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO.historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO.
    public RespuestaDTO consultarHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastporNumReg(String numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) {
        HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast historialTipoPersonalApoyObrRedMitigGestRiesgDesastNumReg = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (!(historialTipoPersonalApoyObrRedMitigGestRiesgDesastNumReg == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO.historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(historialTipoPersonalApoyObrRedMitigGestRiesgDesastNumReg));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastNumReg == null) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO) {
        Optional<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> historialTipoPersonalApoyObrRedMitigGestRiesgDesastId = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findByIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast historialTipoPersonalApoyObrRedMitigGestRiesgDesastUnico = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialTipoPersonalApoyObrRedMitigGestRiesgDesastUnico == null) && !(historialTipoPersonalApoyObrRedMitigGestRiesgDesastUnico.getIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast().equals(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.save(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO.historialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) {
        Optional<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> historialTipoPersonalApoyObrRedMitigGestRiesgDesastId = historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.findById(idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository.delete(historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
