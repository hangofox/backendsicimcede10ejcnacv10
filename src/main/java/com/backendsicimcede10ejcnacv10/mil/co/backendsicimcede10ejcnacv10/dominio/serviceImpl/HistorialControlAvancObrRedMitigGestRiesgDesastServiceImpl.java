//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialControlAvancObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialControlAvancObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialControlAvancObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialControlAvancObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialControlAvancObrRedMitigGestRiesgDesastRepository;
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
* @Since 01/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialControlAvancObrRedMitigGestRiesgDesastServiceImpl implements HistorialControlAvancObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialControlAvancObrRedMitigGestRiesgDesastDAO historialControlAvancObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialControlAvancObrRedMitigGestRiesgDesastRepository historialControlAvancObrRedMitigGestRiesgDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialControlAvancObrRedMitigGestRiesgDesast, String keyword) {
        return historialControlAvancObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idHistorialControlAvancObrRedMitigGestRiesgDesast, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialControlAvancObrRedMitigGestRiesgDesastDTO> listarHistorialesControlesAvancsObrRedMitigGestRiesgDesast(Long idHistorialControlAvancObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        List<HistorialControlAvancObrRedMitigGestRiesgDesast> historialesControlesAvancsObrRedMitigGestRiesgDesast = historialControlAvancObrRedMitigGestRiesgDesastRepository.findAllHistorialesControlesAvancsObrRedMitigGestRiesgDesast(idHistorialControlAvancObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        List<HistorialControlAvancObrRedMitigGestRiesgDesastDTO> historialControlAvancObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        for (HistorialControlAvancObrRedMitigGestRiesgDesast historialControlAvancObrRedMitigGestRiesgDesast : historialesControlesAvancsObrRedMitigGestRiesgDesast) {
            historialControlAvancObrRedMitigGestRiesgDesastDTOS.add(historialControlAvancObrRedMitigGestRiesgDesastDAO.historialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesast));
        }
        
        return historialControlAvancObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialControlAvancObrRedMitigGestRiesgDesastDTO> listarHistorialesControlesAvancsObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idHistorialControlAvancObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode) {
        Slice<HistorialControlAvancObrRedMitigGestRiesgDesast> historialesControlesAvancsObrRedMitigGestRiesgDesast = historialControlAvancObrRedMitigGestRiesgDesastRepository.findAllHistorialesControlesAvancsObrRedMitigGestRiesgDesastPag(pageable, idHistorialControlAvancObrRedMitigGestRiesgDesast, keyword, orderBy, orderMode);
        return historialesControlesAvancsObrRedMitigGestRiesgDesast.map(historialControlAvancObrRedMitigGestRiesgDesast -> historialControlAvancObrRedMitigGestRiesgDesastDAO.historialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialControlAvancObrRedMitigGestRiesgDesast(HistorialControlAvancObrRedMitigGestRiesgDesastDTO historialControlAvancObrRedMitigGestRiesgDesastDTO) {
        Long maxIdHistorialControlAvancObrRedMitigGestRiesgDesast = null;
        HistorialControlAvancObrRedMitigGestRiesgDesast historialControlAvancObrRedMitigGestRiesgDesastUnico = historialControlAvancObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getNumRegHistorialControlAvancObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialControlAvancObrRedMitigGestRiesgDesastUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialControlAvancObrRedMitigGestRiesgDesast = historialControlAvancObrRedMitigGestRiesgDesastRepository.findMaxIdHistorialControlAvancObrRedMitigGestRiesgDesast();
           if (maxIdHistorialControlAvancObrRedMitigGestRiesgDesast == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialControlAvancObrRedMitigGestRiesgDesast = Long.valueOf(0);
           }
           historialControlAvancObrRedMitigGestRiesgDesastDTO.setIdHistorialControlAvancObrRedMitigGestRiesgDesast(maxIdHistorialControlAvancObrRedMitigGestRiesgDesast + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-CTR-AVANC-OBR-RED-MITIG-GEST-RIESG-DESAST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialControlAvancObrRedMitigGestRiesgDesastSinIntermedios = objetoFechaHMS.format(new Date());
           historialControlAvancObrRedMitigGestRiesgDesastDTO.setNumRegHistorialControlAvancObrRedMitigGestRiesgDesast("HIST-CTR-AVANC-OBR-RED-MITIG-GEST-RIESG-DESAST" + "-" + (maxIdHistorialControlAvancObrRedMitigGestRiesgDesast + 1) + "-" + fechaHMSIngresoHistorialControlAvancObrRedMitigGestRiesgDesastSinIntermedios);
           
           historialControlAvancObrRedMitigGestRiesgDesastRepository.save(historialControlAvancObrRedMitigGestRiesgDesastDAO.historialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialControlAvancObrRedMitigGestRiesgDesastporId(Long idHistorialControlAvancObrRedMitigGestRiesgDesast) {
        Optional<HistorialControlAvancObrRedMitigGestRiesgDesast> historialControlAvancObrRedMitigGestRiesgDesastId = historialControlAvancObrRedMitigGestRiesgDesastRepository.findByIdHistorialControlAvancObrRedMitigGestRiesgDesast(Long.valueOf(idHistorialControlAvancObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialControlAvancObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesastDAO.historialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialControlAvancObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialControlAvancObrRedMitigGestRiesgDesastporNumReg(String numRegHistorialControlAvancObrRedMitigGestRiesgDesast) {
        if (numRegHistorialControlAvancObrRedMitigGestRiesgDesast == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialControlAvancObrRedMitigGestRiesgDesast> historialControlAvancObrRedMitigGestRiesgDesastNumReg = Optional.ofNullable(historialControlAvancObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialControlAvancObrRedMitigGestRiesgDesast(numRegHistorialControlAvancObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialControlAvancObrRedMitigGestRiesgDesastNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesastDAO.historialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesastNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialControlAvancObrRedMitigGestRiesgDesastNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialControlAvancObrRedMitigGestRiesgDesast(HistorialControlAvancObrRedMitigGestRiesgDesastDTO historialControlAvancObrRedMitigGestRiesgDesastDTO) {
        Optional<HistorialControlAvancObrRedMitigGestRiesgDesast> historialControlAvancObrRedMitigGestRiesgDesastId = historialControlAvancObrRedMitigGestRiesgDesastRepository.findByIdHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getIdHistorialControlAvancObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialControlAvancObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialControlAvancObrRedMitigGestRiesgDesast historialControlAvancObrRedMitigGestRiesgDesastUnico = historialControlAvancObrRedMitigGestRiesgDesastRepository.findByNumRegHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getNumRegHistorialControlAvancObrRedMitigGestRiesgDesast());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialControlAvancObrRedMitigGestRiesgDesastUnico == null) && !(historialControlAvancObrRedMitigGestRiesgDesastUnico.getIdHistorialControlAvancObrRedMitigGestRiesgDesast().equals(historialControlAvancObrRedMitigGestRiesgDesastDTO.getIdHistorialControlAvancObrRedMitigGestRiesgDesast()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialControlAvancObrRedMitigGestRiesgDesastRepository.save(historialControlAvancObrRedMitigGestRiesgDesastDAO.historialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialControlAvancObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialControlAvancObrRedMitigGestRiesgDesast(Long idHistorialControlAvancObrRedMitigGestRiesgDesast) {
        Optional<HistorialControlAvancObrRedMitigGestRiesgDesast> historialControlAvancObrRedMitigGestRiesgDesastId = historialControlAvancObrRedMitigGestRiesgDesastRepository.findById(idHistorialControlAvancObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialControlAvancObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesastDAO.historialControlAvancObrRedMitigGestRiesgDesastDTO(historialControlAvancObrRedMitigGestRiesgDesastId.get()));
           historialControlAvancObrRedMitigGestRiesgDesastRepository.delete(historialControlAvancObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialControlAvancObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialControlAvancObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
