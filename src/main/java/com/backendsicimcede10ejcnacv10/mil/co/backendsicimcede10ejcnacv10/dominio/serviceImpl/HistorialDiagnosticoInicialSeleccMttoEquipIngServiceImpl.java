//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialDiagnosticoInicialSeleccMttoEquipIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialDiagnosticoInicialSeleccMttoEquipIngService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialDiagnosticoInicialSeleccMttoEquipIngDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialDiagnosticoInicialSeleccMttoEquipIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialDiagnosticoInicialSeleccMttoEquipIngRepository;
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
public class HistorialDiagnosticoInicialSeleccMttoEquipIngServiceImpl implements HistorialDiagnosticoInicialSeleccMttoEquipIngService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialDiagnosticoInicialSeleccMttoEquipIngDAO historialDiagnosticoInicialSeleccMttoEquipIngDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialDiagnosticoInicialSeleccMttoEquipIngRepository historialDiagnosticoInicialSeleccMttoEquipIngRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialDiagnosticoInicialSeleccMttoEquipIng, String keyword) {
        return historialDiagnosticoInicialSeleccMttoEquipIngRepository.findTotalRegistros(idHistorialDiagnosticoInicialSeleccMttoEquipIng, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialDiagnosticoInicialSeleccMttoEquipIngDTO> listarHistorialesDiagnosticosInicialesSeleccMttoEquipIng(Long idHistorialDiagnosticoInicialSeleccMttoEquipIng, String keyword, String orderBy, String orderMode) {
        List<HistorialDiagnosticoInicialSeleccMttoEquipIng> historialesDiagnosticosInicialesSeleccMttoEquipIng = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findAllHistorialesDiagnosticosInicialesSeleccMttoEquipIng(idHistorialDiagnosticoInicialSeleccMttoEquipIng, keyword, orderBy, orderMode);
        List<HistorialDiagnosticoInicialSeleccMttoEquipIngDTO> historialDiagnosticoInicialSeleccMttoEquipIngDTOS = new ArrayList<>();
        for (HistorialDiagnosticoInicialSeleccMttoEquipIng historialDiagnosticoInicialSeleccMttoEquipIng : historialesDiagnosticosInicialesSeleccMttoEquipIng) {
            historialDiagnosticoInicialSeleccMttoEquipIngDTOS.add(historialDiagnosticoInicialSeleccMttoEquipIngDAO.historialDiagnosticoInicialSeleccMttoEquipIngDTO(historialDiagnosticoInicialSeleccMttoEquipIng));
        }
        
        return historialDiagnosticoInicialSeleccMttoEquipIngDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialDiagnosticoInicialSeleccMttoEquipIngDTO> listarHistorialesDiagnosticosInicialesSeleccMttoEquipIngPag(Pageable pageable, Long idHistorialDiagnosticoInicialSeleccMttoEquipIng, String keyword, String orderBy, String orderMode) {
        Slice<HistorialDiagnosticoInicialSeleccMttoEquipIng> historialesDiagnosticosInicialesSeleccMttoEquipIng = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findAllHistorialesDiagnosticosInicialesSeleccMttoEquipIngPag(pageable, idHistorialDiagnosticoInicialSeleccMttoEquipIng, keyword, orderBy, orderMode);
        return historialesDiagnosticosInicialesSeleccMttoEquipIng.map(historialDiagnosticoInicialSeleccMttoEquipIng -> historialDiagnosticoInicialSeleccMttoEquipIngDAO.historialDiagnosticoInicialSeleccMttoEquipIngDTO(historialDiagnosticoInicialSeleccMttoEquipIng));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialDiagnosticoInicialSeleccMttoEquipIng(HistorialDiagnosticoInicialSeleccMttoEquipIngDTO historialDiagnosticoInicialSeleccMttoEquipIngDTO) {
        Long maxIdHistorialDiagnosticoInicialSeleccMttoEquipIng = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findMaxIdHistorialDiagnosticoInicialSeleccMttoEquipIng();
        HistorialDiagnosticoInicialSeleccMttoEquipIng historialDiagnosticoInicialSeleccMttoEquipIngUnica = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findByNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialDiagnosticoInicialSeleccMttoEquipIngUnica == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           if (maxIdHistorialDiagnosticoInicialSeleccMttoEquipIng == null) {
              maxIdHistorialDiagnosticoInicialSeleccMttoEquipIng = Long.valueOf(0);
           }
           historialDiagnosticoInicialSeleccMttoEquipIngDTO.setIdHistorialDiagnosticoInicialSeleccMttoEquipIng(maxIdHistorialDiagnosticoInicialSeleccMttoEquipIng + 1);
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-DIAG-INIC-SELECC-MTTO-EQUIP-ING" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialDiagnosticoInicialSeleccMttoEquipIngSinIntermedios = objetoFechaHMS.format(new Date());
           historialDiagnosticoInicialSeleccMttoEquipIngDTO.setNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng("HIST-DIAG-INIC-SELECC-MTTO-EQUIP-ING" + "-" + (maxIdHistorialDiagnosticoInicialSeleccMttoEquipIng + 1) + "-" + fechaHMSIngresoHistorialDiagnosticoInicialSeleccMttoEquipIngSinIntermedios);
           
           historialDiagnosticoInicialSeleccMttoEquipIngRepository.save(historialDiagnosticoInicialSeleccMttoEquipIngDAO.historialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialDiagnosticoInicialSeleccMttoEquipIngporId(Long idHistorialDiagnosticoInicialSeleccMttoEquipIng) {
        Optional<HistorialDiagnosticoInicialSeleccMttoEquipIng> historialDiagnosticoInicialSeleccMttoEquipIngId = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findByIdHistorialDiagnosticoInicialSeleccMttoEquipIng(Long.valueOf(idHistorialDiagnosticoInicialSeleccMttoEquipIng));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialDiagnosticoInicialSeleccMttoEquipIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(historialDiagnosticoInicialSeleccMttoEquipIngDAO.historialDiagnosticoInicialSeleccMttoEquipIngDTO(historialDiagnosticoInicialSeleccMttoEquipIngId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialDiagnosticoInicialSeleccMttoEquipIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialDiagnosticoInicialSeleccMttoEquipIngporNumReg(String numRegHistorialDiagnosticoInicialSeleccMttoEquipIng) {
        Optional<HistorialDiagnosticoInicialSeleccMttoEquipIng> historialDiagnosticoInicialSeleccMttoEquipIngNumReg = Optional.ofNullable(historialDiagnosticoInicialSeleccMttoEquipIngRepository.findByNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng(numRegHistorialDiagnosticoInicialSeleccMttoEquipIng.toUpperCase()));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialDiagnosticoInicialSeleccMttoEquipIngNumReg.isPresent() == true) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(historialDiagnosticoInicialSeleccMttoEquipIngDAO.historialDiagnosticoInicialSeleccMttoEquipIngDTO(historialDiagnosticoInicialSeleccMttoEquipIngNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialDiagnosticoInicialSeleccMttoEquipIngNumReg.isPresent() == false) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialDiagnosticoInicialSeleccMttoEquipIng(HistorialDiagnosticoInicialSeleccMttoEquipIngDTO historialDiagnosticoInicialSeleccMttoEquipIngDTO) {
        Optional<HistorialDiagnosticoInicialSeleccMttoEquipIng> historialDiagnosticoInicialSeleccMttoEquipIngId = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findByIdHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getIdHistorialDiagnosticoInicialSeleccMttoEquipIng());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialDiagnosticoInicialSeleccMttoEquipIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialDiagnosticoInicialSeleccMttoEquipIng historialDiagnosticoInicialSeleccMttoEquipIngUnico = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findByNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialDiagnosticoInicialSeleccMttoEquipIngUnico == null) && !(historialDiagnosticoInicialSeleccMttoEquipIngUnico.getIdHistorialDiagnosticoInicialSeleccMttoEquipIng().equals(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getIdHistorialDiagnosticoInicialSeleccMttoEquipIng()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialDiagnosticoInicialSeleccMttoEquipIngRepository.save(historialDiagnosticoInicialSeleccMttoEquipIngDAO.historialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialDiagnosticoInicialSeleccMttoEquipIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialDiagnosticoInicialSeleccMttoEquipIng(Long idHistorialDiagnosticoInicialSeleccMttoEquipIng) {
        Optional<HistorialDiagnosticoInicialSeleccMttoEquipIng> historialDiagnosticoInicialSeleccMttoEquipIngId = historialDiagnosticoInicialSeleccMttoEquipIngRepository.findById(idHistorialDiagnosticoInicialSeleccMttoEquipIng);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialDiagnosticoInicialSeleccMttoEquipIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialDiagnosticoInicialSeleccMttoEquipIngRepository.delete(historialDiagnosticoInicialSeleccMttoEquipIngId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialDiagnosticoInicialSeleccMttoEquipIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialDiagnosticoInicialSeleccMttoEquipIngDTO(null);
        }
        
        return respuestaDTO;
    }
}
