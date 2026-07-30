//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAdqPapeleriaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialProyeccionAnualAdqPapeleriaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialProyeccionAnualAdqPapeleriaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAdqPapeleria;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProyeccionAnualAdqPapeleriaRepository;
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
* @Since 10/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialProyeccionAnualAdqPapeleriaServiceImpl implements HistorialProyeccionAnualAdqPapeleriaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProyeccionAnualAdqPapeleriaDAO historialProyeccionAnualAdqPapeleriaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProyeccionAnualAdqPapeleriaRepository historialProyeccionAnualAdqPapeleriaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialProyeccionAnualAdqPapeleria, String keyword) {
        return historialProyeccionAnualAdqPapeleriaRepository.findTotalRegistros(idHistorialProyeccionAnualAdqPapeleria, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialProyeccionAnualAdqPapeleriaDTO> listarHistorialesProyeccionesAnualesAdqPapelerias(Long idHistorialProyeccionAnualAdqPapeleria, String keyword, String orderBy, String orderMode) {
        List<HistorialProyeccionAnualAdqPapeleria> historialesProyeccionesAnualesAdqPapelerias = historialProyeccionAnualAdqPapeleriaRepository.findAllHistorialesProyeccionesAnualesAdqPapelerias(idHistorialProyeccionAnualAdqPapeleria, keyword, orderBy, orderMode);
        List<HistorialProyeccionAnualAdqPapeleriaDTO> historialProyeccionAnualAdqPapeleriaDTOS = new ArrayList<>();
        for (HistorialProyeccionAnualAdqPapeleria historialProyeccionAnualAdqPapeleria : historialesProyeccionesAnualesAdqPapelerias) {
            historialProyeccionAnualAdqPapeleriaDTOS.add(historialProyeccionAnualAdqPapeleriaDAO.historialProyeccionAnualAdqPapeleriaDTO(historialProyeccionAnualAdqPapeleria));
        }
        
        return historialProyeccionAnualAdqPapeleriaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialProyeccionAnualAdqPapeleriaDTO> listarHistorialesProyeccionesAnualesAdqPapeleriasPag(Pageable pageable, Long idHistorialProyeccionAnualAdqPapeleria, String keyword, String orderBy, String orderMode) {
        Slice<HistorialProyeccionAnualAdqPapeleria> historialesProyeccionesAnualesAdqPapelerias = historialProyeccionAnualAdqPapeleriaRepository.findAllHistorialesProyeccionesAnualesAdqPapeleriasPag(pageable, idHistorialProyeccionAnualAdqPapeleria, keyword, orderBy, orderMode);
        return historialesProyeccionesAnualesAdqPapelerias.map(historialProyeccionAnualAdqPapeleria -> historialProyeccionAnualAdqPapeleriaDAO.historialProyeccionAnualAdqPapeleriaDTO(historialProyeccionAnualAdqPapeleria));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialProyeccionAnualAdqPapeleria(HistorialProyeccionAnualAdqPapeleriaDTO historialProyeccionAnualAdqPapeleriaDTO) {
        Long maxIdHistorialProyeccionAnualAdqPapeleria = historialProyeccionAnualAdqPapeleriaRepository.findMaxIdHistorialProyeccionAnualAdqPapeleria();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdHistorialProyeccionAnualAdqPapeleria == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdHistorialProyeccionAnualAdqPapeleria = Long.valueOf(0);
        }
        historialProyeccionAnualAdqPapeleriaDTO.setIdHistorialProyeccionAnualAdqPapeleria(maxIdHistorialProyeccionAnualAdqPapeleria + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-PROY-AN-ADQ-PAP" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
        SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHMSIngresoHistorialProyeccionAnualAdqPapeleriaSinIntermedios = objetoFechaHMS.format(new Date());
        historialProyeccionAnualAdqPapeleriaDTO.setNumRegHistorialProyeccionAnualAdqPapeleria("HIST-PROY-AN-ADQ-PAP" + "-" + (maxIdHistorialProyeccionAnualAdqPapeleria + 1) + "-" + fechaHMSIngresoHistorialProyeccionAnualAdqPapeleriaSinIntermedios);
        
        historialProyeccionAnualAdqPapeleriaRepository.save(historialProyeccionAnualAdqPapeleriaDAO.historialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleriaDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionAnualAdqPapeleriaaporId(Long idHistorialProyeccionAnualAdqPapeleria) {
        Optional<HistorialProyeccionAnualAdqPapeleria> historialProyeccionAnualAdqPapeleriaId = historialProyeccionAnualAdqPapeleriaRepository.findByIdHistorialProyeccionAnualAdqPapeleria(Long.valueOf(idHistorialProyeccionAnualAdqPapeleria));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualAdqPapeleriaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualAdqPapeleriaDTO(historialProyeccionAnualAdqPapeleriaDAO.historialProyeccionAnualAdqPapeleriaDTO(historialProyeccionAnualAdqPapeleriaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionAnualAdqPapeleriaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAdqPapeleriaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialProyeccionAnualAdqPapeleria(HistorialProyeccionAnualAdqPapeleriaDTO historialProyeccionAnualAdqPapeleriaDTO) {
        Optional<HistorialProyeccionAnualAdqPapeleria> historialProyeccionAnualAdqPapeleriaId = historialProyeccionAnualAdqPapeleriaRepository.findByIdHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleriaDTO.getIdHistorialProyeccionAnualAdqPapeleria());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialProyeccionAnualAdqPapeleriaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialProyeccionAnualAdqPapeleria historialProyeccionAnualAdqPapeleriaUnico = historialProyeccionAnualAdqPapeleriaRepository.findByNumRegHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleriaDTO.getNumRegHistorialProyeccionAnualAdqPapeleria());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialProyeccionAnualAdqPapeleriaUnico == null) && !(historialProyeccionAnualAdqPapeleriaUnico.getIdHistorialProyeccionAnualAdqPapeleria().equals(historialProyeccionAnualAdqPapeleriaDTO.getIdHistorialProyeccionAnualAdqPapeleria()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialProyeccionAnualAdqPapeleriaDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialProyeccionAnualAdqPapeleriaRepository.save(historialProyeccionAnualAdqPapeleriaDAO.historialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleriaDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialProyeccionAnualAdqPapeleriaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialProyeccionAnualAdqPapeleriaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialProyeccionAnualAdqPapeleria(Long idHistorialProyeccionAnualAdqPapeleria) {
        Optional<HistorialProyeccionAnualAdqPapeleria> historialProyeccionAnualAdqPapeleriaId = historialProyeccionAnualAdqPapeleriaRepository.findById(idHistorialProyeccionAnualAdqPapeleria);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualAdqPapeleriaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualAdqPapeleriaDTO(historialProyeccionAnualAdqPapeleriaDAO.historialProyeccionAnualAdqPapeleriaDTO(historialProyeccionAnualAdqPapeleriaId.get()));
           historialProyeccionAnualAdqPapeleriaRepository.delete(historialProyeccionAnualAdqPapeleriaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialProyeccionAnualAdqPapeleriaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAdqPapeleriaDTO(null);
        }
        
        return respuestaDTO;
    }
}
