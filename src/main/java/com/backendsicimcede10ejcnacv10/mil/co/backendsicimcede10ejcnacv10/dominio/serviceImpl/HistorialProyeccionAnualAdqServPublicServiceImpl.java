//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAdqServPublicDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialProyeccionAnualAdqServPublicService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialProyeccionAnualAdqServPublicDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAdqServPublic;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProyeccionAnualAdqServPublicRepository;
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
public class HistorialProyeccionAnualAdqServPublicServiceImpl implements HistorialProyeccionAnualAdqServPublicService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProyeccionAnualAdqServPublicDAO historialProyeccionAnualAdqServPublicDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProyeccionAnualAdqServPublicRepository historialProyeccionAnualAdqServPublicRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialProyeccionAnualAdqServPublic, String keyword) {
        return historialProyeccionAnualAdqServPublicRepository.findTotalRegistros(idHistorialProyeccionAnualAdqServPublic, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialProyeccionAnualAdqServPublicDTO> listarHistorialesProyeccionesAnualesAdqServPublic(Long idHistorialProyeccionAnualAdqServPublic, String keyword, String orderBy, String orderMode) {
        List<HistorialProyeccionAnualAdqServPublic> historialesProyeccionesAnualesAdqServPublic = historialProyeccionAnualAdqServPublicRepository.findAllHistorialesProyeccionesAnualesAdqServPublic(idHistorialProyeccionAnualAdqServPublic, keyword, orderBy, orderMode);
        List<HistorialProyeccionAnualAdqServPublicDTO> historialProyeccionAnualAdqServPublicDTOS = new ArrayList<>();
        for (HistorialProyeccionAnualAdqServPublic historialProyeccionAnualAdqServPublic : historialesProyeccionesAnualesAdqServPublic) {
            historialProyeccionAnualAdqServPublicDTOS.add(historialProyeccionAnualAdqServPublicDAO.historialProyeccionAnualAdqServPublicDTO(historialProyeccionAnualAdqServPublic));
        }
        return historialProyeccionAnualAdqServPublicDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialProyeccionAnualAdqServPublicDTO> listarHistorialesProyeccionesAnualesAdqServPublicPag(Pageable pageable, Long idHistorialProyeccionAnualAdqServPublic, String keyword, String orderBy, String orderMode) {
        Slice<HistorialProyeccionAnualAdqServPublic> historialesProyeccionesAnualesAdqServPublic = historialProyeccionAnualAdqServPublicRepository.findAllHistorialesProyeccionesAnualesAdqServPublicPag(pageable, idHistorialProyeccionAnualAdqServPublic, keyword, orderBy, orderMode);
        return historialesProyeccionesAnualesAdqServPublic.map(historialProyeccionAnualAdqServPublic -> historialProyeccionAnualAdqServPublicDAO.historialProyeccionAnualAdqServPublicDTO(historialProyeccionAnualAdqServPublic));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialProyeccionAnualAdqServPublic(HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO) {
        Long maxIdHistorialProyeccionAnualAdqServPublic = historialProyeccionAnualAdqServPublicRepository.findMaxIdHistorialProyeccionAnualAdqServPublic();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdHistorialProyeccionAnualAdqServPublic == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdHistorialProyeccionAnualAdqServPublic = Long.valueOf(0);
        }
        historialProyeccionAnualAdqServPublicDTO.setIdHistorialProyeccionAnualAdqServPublic(maxIdHistorialProyeccionAnualAdqServPublic + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-PROY-AN-ADQ-SERV-PUBLIC" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
        SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHMSIngresoHistorialProyeccionAnualAdqServPublicSinIntermedios = objetoFechaHMS.format(new Date());
        historialProyeccionAnualAdqServPublicDTO.setNumRegHistorialProyeccionAnualAdqServPublic("HIST-PROY-AN-ADQ-SERV-PUBLIC" + "-" + (maxIdHistorialProyeccionAnualAdqServPublic + 1) + "-" + fechaHMSIngresoHistorialProyeccionAnualAdqServPublicSinIntermedios);
        
        historialProyeccionAnualAdqServPublicRepository.save(historialProyeccionAnualAdqServPublicDAO.historialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionAnualAdqServPublicporId(Long idHistorialProyeccionAnualAdqServPublic) {
        Optional<HistorialProyeccionAnualAdqServPublic> historialProyeccionAnualAdqServPublicId = historialProyeccionAnualAdqServPublicRepository.findByIdHistorialProyeccionAnualAdqServPublic(Long.valueOf(idHistorialProyeccionAnualAdqServPublic));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualAdqServPublicId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualAdqServPublicDTO(historialProyeccionAnualAdqServPublicDAO.historialProyeccionAnualAdqServPublicDTO(historialProyeccionAnualAdqServPublicId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionAnualAdqServPublicId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAdqServPublicDTO(null);
        }
        
        return respuestaDTO;
    }
    
    /*//MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialProyeccionAnualAdqServPublic(HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO) {
        Optional<HistorialProyeccionAnualAdqServPublic> historialProyeccionAnualAdqServPublicId = historialProyeccionAnualAdqServPublicRepository.findByIdHistorialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getIdHistorialProyeccionAnualAdqServPublic());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialProyeccionAnualAdqServPublicId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           historialProyeccionAnualAdqServPublicRepository.save(historialProyeccionAnualAdqServPublicDAO.historialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (historialProyeccionAnualAdqServPublicId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialProyeccionAnualAdqServPublicDTO(null);
        }
        
        return respuestaDTO;
    }*/
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialProyeccionAnualAdqServPublic(HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO) {
        Optional<HistorialProyeccionAnualAdqServPublic> historialProyeccionAnualAdqServPublicId = historialProyeccionAnualAdqServPublicRepository.findByIdHistorialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getIdHistorialProyeccionAnualAdqServPublic());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialProyeccionAnualAdqServPublicId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialProyeccionAnualAdqServPublic historialProyeccionAnualAdqServPublicUnico = historialProyeccionAnualAdqServPublicRepository.findByNumRegHistorialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getNumRegHistorialProyeccionAnualAdqServPublic());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialProyeccionAnualAdqServPublicUnico == null) && !(historialProyeccionAnualAdqServPublicUnico.getIdHistorialProyeccionAnualAdqServPublic().equals(historialProyeccionAnualAdqServPublicDTO.getIdHistorialProyeccionAnualAdqServPublic()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialProyeccionAnualAdqServPublicDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialProyeccionAnualAdqServPublicRepository.save(historialProyeccionAnualAdqServPublicDAO.historialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialProyeccionAnualAdqServPublicId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialProyeccionAnualAdqServPublicDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialProyeccionAnualAdqServPublic(Long idHistorialProyeccionAnualAdqServPublic) {
        Optional<HistorialProyeccionAnualAdqServPublic> historialProyeccionAnualAdqServPublicId = historialProyeccionAnualAdqServPublicRepository.findById(idHistorialProyeccionAnualAdqServPublic);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionAnualAdqServPublicId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionAnualAdqServPublicDTO(historialProyeccionAnualAdqServPublicDAO.historialProyeccionAnualAdqServPublicDTO(historialProyeccionAnualAdqServPublicId.get()));
           historialProyeccionAnualAdqServPublicRepository.delete(historialProyeccionAnualAdqServPublicId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialProyeccionAnualAdqServPublicId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionAnualAdqServPublicDTO(null);
        }
        
        return respuestaDTO;
    }
}
