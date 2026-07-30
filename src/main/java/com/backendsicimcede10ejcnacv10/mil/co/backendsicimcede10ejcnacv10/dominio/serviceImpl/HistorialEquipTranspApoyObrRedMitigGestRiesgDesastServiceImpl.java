//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialEquipTranspApoyObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialEquipTranspApoyObrRedMitigGestRiesgDesastRepository;
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
public class HistorialEquipTranspApoyObrRedMitigGestRiesgDesastServiceImpl implements HistorialEquipTranspApoyObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDAO historialEquipTranspApoyObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialEquipTranspApoyObrRedMitigGestRiesgDesastRepository historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero) {
        return historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, keyword, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, idEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO> listarHistorialesEquipsTranspsApoyObrRedMitigGestRiesgDesast(Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero, String orderBy, String orderMode) {
        List<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> historialesEquipsTranspsApoyObrRedMitigGestRiesgDesast = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findAllHistorialesEquipsTranspsApoyObrRedMitigGestRiesgDesast(idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, keyword, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, idEquipoIngeniero, orderBy, orderMode);
        List<HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO> historialEquipTranspApoyObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        for (HistorialEquipTranspApoyObrRedMitigGestRiesgDesast historialEquipTranspApoyObrRedMitigGestRiesgDesast : historialesEquipsTranspsApoyObrRedMitigGestRiesgDesast) {
            historialEquipTranspApoyObrRedMitigGestRiesgDesastDTOS.add(historialEquipTranspApoyObrRedMitigGestRiesgDesastDAO.historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(historialEquipTranspApoyObrRedMitigGestRiesgDesast));
        }
        
        return historialEquipTranspApoyObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO> listarHistorialesEquipsTranspsApoyObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero, String orderBy, String orderMode) {
        Slice<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> historialesEquipsTranspsApoyObrRedMitigGestRiesgDesast = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findAllHistorialesEquipsTranspsApoyObrRedMitigGestRiesgDesastPag(pageable, idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, keyword, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, idEquipoIngeniero, orderBy, orderMode);
        return historialesEquipsTranspsApoyObrRedMitigGestRiesgDesast.map(historialEquipTranspApoyObrRedMitigGestRiesgDesast -> historialEquipTranspApoyObrRedMitigGestRiesgDesastDAO.historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(historialEquipTranspApoyObrRedMitigGestRiesgDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO) {
        Long maxIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findMaxIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast();
        HistorialEquipTranspApoyObrRedMitigGestRiesgDesast historialEquipTranspApoyObrRedMitigGestRiesgDesastUnica = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialEquipTranspApoyObrRedMitigGestRiesgDesastUnica == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO...
           if (maxIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast == null) {
              maxIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast = Long.valueOf(0);
           }
           historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(maxIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast + 1);
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-EQUIP-TRANSP-APOY-OBR-RED-MITIG-GEST-RIESG-DESAST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialEquipTranspApoyObrRedMitigGestRiesgDesasSinIntermedios = objetoFechaHMS.format(new Date());
           historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast("HIST-EQUIP-TRANSP-APOY-OBR-RED-MITIG-GEST-RIESG-DESAST" + "-" + (maxIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast + 1) + "-" + fechaHMSIngresoHistorialEquipTranspApoyObrRedMitigGestRiesgDesasSinIntermedios);
           
           historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.save(historialEquipTranspApoyObrRedMitigGestRiesgDesastDAO.historialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialEquipTranspApoyObrRedMitigGestRiesgDesastporId(Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) {
        Optional<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> historialEquipTranspApoyObrRedMitigGestRiesgDesastId = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findByIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(Long.valueOf(idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(historialEquipTranspApoyObrRedMitigGestRiesgDesastDAO.historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(historialEquipTranspApoyObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialEquipTranspApoyObrRedMitigGestRiesgDesastporNumReg(String numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) {
        Optional<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> historialEquipTranspApoyObrRedMitigGestRiesgDesastNumReg = Optional.ofNullable(historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast.toUpperCase()));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastNumReg.isPresent() == true) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(historialEquipTranspApoyObrRedMitigGestRiesgDesastDAO.historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(historialEquipTranspApoyObrRedMitigGestRiesgDesastNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastNumReg.isPresent() == false) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO) {
        Optional<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> historialEquipTranspApoyObrRedMitigGestRiesgDesastId = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findByIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);

        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialEquipTranspApoyObrRedMitigGestRiesgDesast historialEquipTranspApoyObrRedMitigGestRiesgDesastUnico = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast());

           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;

           if (!(historialEquipTranspApoyObrRedMitigGestRiesgDesastUnico == null) && !(historialEquipTranspApoyObrRedMitigGestRiesgDesastUnico.getIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast().equals(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }

           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.save(historialEquipTranspApoyObrRedMitigGestRiesgDesastDAO.historialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(null);
        }

        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) {
        Optional<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> historialEquipTranspApoyObrRedMitigGestRiesgDesastId = historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.findById(idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialEquipTranspApoyObrRedMitigGestRiesgDesastRepository.delete(historialEquipTranspApoyObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
