//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAseoLimpInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialProyeccionAnualAseoLimpInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialProyeccionAnualAseoLimpInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAseoLimpInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProyeccionAnualAseoLimpInfraestRepository;
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
public class HistorialProyeccionAnualAseoLimpInfraestServiceImpl implements HistorialProyeccionAnualAseoLimpInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProyeccionAnualAseoLimpInfraestDAO historialProyeccionAnualAseoLimpInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProyeccionAnualAseoLimpInfraestRepository historialProyeccionAnualAseoLimpInfraestRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialProyeccionAnualAseoLimpInfraest, String keyword) {
        return historialProyeccionAnualAseoLimpInfraestRepository.findTotalRegistros(idHistorialProyeccionAnualAseoLimpInfraest, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialProyeccionAnualAseoLimpInfraestDTO> listarHistorialesProyeccionesAnualesAseoLimpInfraest(Long idHistorialProyeccionAnualAseoLimpInfraest, String keyword, String orderBy, String orderMode) {
        List<HistorialProyeccionAnualAseoLimpInfraest> historialesProyeccionesAnualesAseoLimpInfraest = historialProyeccionAnualAseoLimpInfraestRepository.findAllHistorialesProyeccionesAnualesAseoLimpInfraest(idHistorialProyeccionAnualAseoLimpInfraest, keyword, orderBy, orderMode);
        List<HistorialProyeccionAnualAseoLimpInfraestDTO> historialProyeccionAnualAseoLimpInfraestDTOS = new ArrayList<>();
        for (HistorialProyeccionAnualAseoLimpInfraest historialProyeccionAnualAseoLimpInfraest : historialesProyeccionesAnualesAseoLimpInfraest) {
            historialProyeccionAnualAseoLimpInfraestDTOS.add(historialProyeccionAnualAseoLimpInfraestDAO.historialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraest));
        }
        
        return historialProyeccionAnualAseoLimpInfraestDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialProyeccionAnualAseoLimpInfraestDTO> listarHistorialesProyeccionesAnualesAseoLimpInfraestPag(Pageable pageable, Long idHistorialProyeccionAnualAseoLimpInfraest, String keyword, String orderBy, String orderMode) {
        Slice<HistorialProyeccionAnualAseoLimpInfraest> historialesProyeccionesAnualesAseoLimpInfraest = historialProyeccionAnualAseoLimpInfraestRepository.findAllHistorialesProyeccionesAnualesAseoLimpInfraestPag(pageable, idHistorialProyeccionAnualAseoLimpInfraest, keyword, orderBy, orderMode);
        return historialesProyeccionesAnualesAseoLimpInfraest.map(historialProyeccionAnualAseoLimpInfraest -> historialProyeccionAnualAseoLimpInfraestDAO.historialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialProyeccionAnualAseoLimpInfraest(HistorialProyeccionAnualAseoLimpInfraestDTO historialProyeccionAnualAseoLimpInfraestDTO) {
        Long maxIdHistorialProyeccionAnualAseoLimpInfraest = null;
        HistorialProyeccionAnualAseoLimpInfraest historialProyeccionAnualAseoLimpInfraestUnico = historialProyeccionAnualAseoLimpInfraestRepository.findByNumRegHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getNumRegHistorialProyeccionAnualAseoLimpInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialProyeccionAnualAseoLimpInfraestUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialProyeccionAnualAseoLimpInfraest = historialProyeccionAnualAseoLimpInfraestRepository.findMaxIdHistorialProyeccionAnualAseoLimpInfraest();
           if (maxIdHistorialProyeccionAnualAseoLimpInfraest == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialProyeccionAnualAseoLimpInfraest = Long.valueOf(0);
           }
           historialProyeccionAnualAseoLimpInfraestDTO.setIdHistorialProyeccionAnualAseoLimpInfraest(maxIdHistorialProyeccionAnualAseoLimpInfraest + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-PROY-AN-ASEO-LIMP-INFRAEST" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialProyeccionAnualAseoLimpInfraestSinIntermedios = objetoFechaHMS.format(new Date());
           historialProyeccionAnualAseoLimpInfraestDTO.setNumRegHistorialProyeccionAnualAseoLimpInfraest("HIST-PROY-AN-ASEO-LIMP-INFRAEST" + "-" + (maxIdHistorialProyeccionAnualAseoLimpInfraest + 1) + "-" + fechaHMSIngresoHistorialProyeccionAnualAseoLimpInfraestSinIntermedios);
           
           historialProyeccionAnualAseoLimpInfraestRepository.save(historialProyeccionAnualAseoLimpInfraestDAO.historialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionAnualAseoLimpInfraestportId(Long idHistorialProyeccionAnualAseoLimpInfraest) {
        Optional<HistorialProyeccionAnualAseoLimpInfraest> historialProyeccionAnualAseoLimpInfraestId = historialProyeccionAnualAseoLimpInfraestRepository.findByIdHistorialProyeccionAnualAseoLimpInfraest(Long.valueOf(idHistorialProyeccionAnualAseoLimpInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualAseoLimpInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraestDAO.historialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionAnualAseoLimpInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionAnualAseoLimpInfraestportNumReg(String numRegHistorialProyeccionAnualAseoLimpInfraest) {
        if (numRegHistorialProyeccionAnualAseoLimpInfraest == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialProyeccionAnualAseoLimpInfraest> historialProyeccionAnualAseoLimpInfraestNumReg = Optional.ofNullable(historialProyeccionAnualAseoLimpInfraestRepository.findByNumRegHistorialProyeccionAnualAseoLimpInfraest(numRegHistorialProyeccionAnualAseoLimpInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualAseoLimpInfraestNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraestDAO.historialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraestNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionAnualAseoLimpInfraestNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialProyeccionAnualAseoLimpInfraest(HistorialProyeccionAnualAseoLimpInfraestDTO historialProyeccionAnualAseoLimpInfraestDTO) {
        Optional<HistorialProyeccionAnualAseoLimpInfraest> historialProyeccionAnualAseoLimpInfraestId = historialProyeccionAnualAseoLimpInfraestRepository.findByIdHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getIdHistorialProyeccionAnualAseoLimpInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialProyeccionAnualAseoLimpInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialProyeccionAnualAseoLimpInfraest historialProyeccionAnualAseoLimpInfraestUnico = historialProyeccionAnualAseoLimpInfraestRepository.findByNumRegHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getNumRegHistorialProyeccionAnualAseoLimpInfraest());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialProyeccionAnualAseoLimpInfraestUnico == null) && !(historialProyeccionAnualAseoLimpInfraestUnico.getIdHistorialProyeccionAnualAseoLimpInfraest().equals(historialProyeccionAnualAseoLimpInfraestDTO.getIdHistorialProyeccionAnualAseoLimpInfraest()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialProyeccionAnualAseoLimpInfraestRepository.save(historialProyeccionAnualAseoLimpInfraestDAO.historialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialProyeccionAnualAseoLimpInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialProyeccionAnualAseoLimpInfraest(Long idHistorialProyeccionAnualAseoLimpInfraest) {
        Optional<HistorialProyeccionAnualAseoLimpInfraest> historialProyeccionAnualAseoLimpInfraestId = historialProyeccionAnualAseoLimpInfraestRepository.findById(idHistorialProyeccionAnualAseoLimpInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualAseoLimpInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraestDAO.historialProyeccionAnualAseoLimpInfraestDTO(historialProyeccionAnualAseoLimpInfraestId.get()));
           historialProyeccionAnualAseoLimpInfraestRepository.delete(historialProyeccionAnualAseoLimpInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialProyeccionAnualAseoLimpInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAseoLimpInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
