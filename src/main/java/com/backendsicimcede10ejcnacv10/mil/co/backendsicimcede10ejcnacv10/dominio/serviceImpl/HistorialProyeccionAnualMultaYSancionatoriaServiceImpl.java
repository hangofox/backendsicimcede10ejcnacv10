//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualMultaYSancionatoriaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialProyeccionAnualMultaYSancionatoriaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialProyeccionAnualMultaYSancionatoriaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualMultaYSancionatoria;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProyeccionAnualMultaYSancionatoriaRepository;
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
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialProyeccionAnualMultaYSancionatoriaServiceImpl implements HistorialProyeccionAnualMultaYSancionatoriaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProyeccionAnualMultaYSancionatoriaDAO historialProyeccionAnualMultaYSancionatoriaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProyeccionAnualMultaYSancionatoriaRepository historialProyeccionAnualMultaYSancionatoriaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialProyeccionAnualMultaYSancionatoria, String keyword) {
        return historialProyeccionAnualMultaYSancionatoriaRepository.findTotalRegistros(idHistorialProyeccionAnualMultaYSancionatoria, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialProyeccionAnualMultaYSancionatoriaDTO> listarHistorialesProyeccionesAnualesMultasYSancionatorias(Long idHistorialProyeccionAnualMultaYSancionatoria, String keyword, String orderBy, String orderMode) {
        List<HistorialProyeccionAnualMultaYSancionatoria> historialesProyeccionesAnualesMultasYSancionatorias = historialProyeccionAnualMultaYSancionatoriaRepository.findAllHistorialesProyeccionesAnualesMultasYSancionatorias(idHistorialProyeccionAnualMultaYSancionatoria, keyword, orderBy, orderMode);
        List<HistorialProyeccionAnualMultaYSancionatoriaDTO> historialProyeccionAnualMultaYSancionatoriaDTOS = new ArrayList<>();
        for (HistorialProyeccionAnualMultaYSancionatoria historialProyeccionAnualMultaYSancionatoria : historialesProyeccionesAnualesMultasYSancionatorias) {
            historialProyeccionAnualMultaYSancionatoriaDTOS.add(historialProyeccionAnualMultaYSancionatoriaDAO.historialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoria));
        }
        
        return historialProyeccionAnualMultaYSancionatoriaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialProyeccionAnualMultaYSancionatoriaDTO> listarHistorialesProyeccionesAnualesMultasYSancionatoriasPag(Pageable pageable, Long idHistorialProyeccionAnualMultaYSancionatoria, String keyword, String orderBy, String orderMode) {
        Slice<HistorialProyeccionAnualMultaYSancionatoria> historialesProyeccionesAnualesMultasYSancionatorias = historialProyeccionAnualMultaYSancionatoriaRepository.findAllHistorialesProyeccionesAnualesMultasYSancionatoriasPag(pageable, idHistorialProyeccionAnualMultaYSancionatoria, keyword, orderBy, orderMode);
        return historialesProyeccionesAnualesMultasYSancionatorias.map(historialProyeccionAnualMultaYSancionatoria -> historialProyeccionAnualMultaYSancionatoriaDAO.historialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoria));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialProyeccionAnualMultaYSancionatoria(HistorialProyeccionAnualMultaYSancionatoriaDTO historialProyeccionAnualMultaYSancionatoriaDTO) {
        Long maxIdHistorialProyeccionAnualMultaYSancionatoria = null;
        HistorialProyeccionAnualMultaYSancionatoria historialProyeccionAnualMultaYSancionatoriaUnico = historialProyeccionAnualMultaYSancionatoriaRepository.findByNumRegHistorialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoriaDTO.getNumRegHistorialProyeccionAnualMultaYSancionatoria());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialProyeccionAnualMultaYSancionatoriaUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialProyeccionAnualMultaYSancionatoria = historialProyeccionAnualMultaYSancionatoriaRepository.findMaxIdHistorialProyeccionAnualMultaYSancionatoria();
           if (maxIdHistorialProyeccionAnualMultaYSancionatoria == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialProyeccionAnualMultaYSancionatoria = Long.valueOf(0);
           }
           historialProyeccionAnualMultaYSancionatoriaDTO.setIdHistorialProyeccionAnualMultaYSancionatoria(maxIdHistorialProyeccionAnualMultaYSancionatoria + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-PROY-AN-MULT-SANC" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialProyeccionAnualMultaYSancionatoriaSinIntermedios = objetoFechaHMS.format(new Date());
           historialProyeccionAnualMultaYSancionatoriaDTO.setNumRegHistorialProyeccionAnualMultaYSancionatoria("HIST-PROY-AN-MULT-SANC" + "-" + (maxIdHistorialProyeccionAnualMultaYSancionatoria + 1) + "-" + fechaHMSIngresoHistorialProyeccionAnualMultaYSancionatoriaSinIntermedios);
           
           historialProyeccionAnualMultaYSancionatoriaRepository.save(historialProyeccionAnualMultaYSancionatoriaDAO.historialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoriaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionAnualMultaYSancionatoriaporId(Long idHistorialProyeccionAnualMultaYSancionatoria) {
        Optional<HistorialProyeccionAnualMultaYSancionatoria> historialProyeccionAnualMultaYSancionatoriaId = historialProyeccionAnualMultaYSancionatoriaRepository.findByIdHistorialProyeccionAnualMultaYSancionatoria(Long.valueOf(idHistorialProyeccionAnualMultaYSancionatoria));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualMultaYSancionatoriaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoriaDAO.historialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoriaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionAnualMultaYSancionatoriaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionAnualMultaYSancionatoriaporNumReg(String numRegHistorialProyeccionAnualMultaYSancionatoria) {
        if (numRegHistorialProyeccionAnualMultaYSancionatoria == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialProyeccionAnualMultaYSancionatoria> historialProyeccionAnualMultaYSancionatoriaNumReg = Optional.ofNullable(historialProyeccionAnualMultaYSancionatoriaRepository.findByNumRegHistorialProyeccionAnualMultaYSancionatoria(numRegHistorialProyeccionAnualMultaYSancionatoria));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualMultaYSancionatoriaNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoriaDAO.historialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoriaNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionAnualMultaYSancionatoriaNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialProyeccionAnualMultaYSancionatoria(HistorialProyeccionAnualMultaYSancionatoriaDTO historialProyeccionAnualMultaYSancionatoriaDTO) {
        Optional<HistorialProyeccionAnualMultaYSancionatoria> historialProyeccionAnualMultaYSancionatoriaId = historialProyeccionAnualMultaYSancionatoriaRepository.findByIdHistorialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoriaDTO.getIdHistorialProyeccionAnualMultaYSancionatoria());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialProyeccionAnualMultaYSancionatoriaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialProyeccionAnualMultaYSancionatoria historialProyeccionAnualMultaYSancionatoriaUnico = historialProyeccionAnualMultaYSancionatoriaRepository.findByNumRegHistorialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoriaDTO.getNumRegHistorialProyeccionAnualMultaYSancionatoria());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialProyeccionAnualMultaYSancionatoriaUnico == null) && !(historialProyeccionAnualMultaYSancionatoriaUnico.getIdHistorialProyeccionAnualMultaYSancionatoria().equals(historialProyeccionAnualMultaYSancionatoriaDTO.getIdHistorialProyeccionAnualMultaYSancionatoria()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialProyeccionAnualMultaYSancionatoriaRepository.save(historialProyeccionAnualMultaYSancionatoriaDAO.historialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoriaDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialProyeccionAnualMultaYSancionatoriaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialProyeccionAnualMultaYSancionatoria(Long idHistorialProyeccionAnualMultaYSancionatoria) {
        Optional<HistorialProyeccionAnualMultaYSancionatoria> historialProyeccionAnualMultaYSancionatoriaId = historialProyeccionAnualMultaYSancionatoriaRepository.findById(idHistorialProyeccionAnualMultaYSancionatoria);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualMultaYSancionatoriaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoriaDAO.historialProyeccionAnualMultaYSancionatoriaDTO(historialProyeccionAnualMultaYSancionatoriaId.get()));
           historialProyeccionAnualMultaYSancionatoriaRepository.delete(historialProyeccionAnualMultaYSancionatoriaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialProyeccionAnualMultaYSancionatoriaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualMultaYSancionatoriaDTO(null);
        }
        
        return respuestaDTO;
    }
}
