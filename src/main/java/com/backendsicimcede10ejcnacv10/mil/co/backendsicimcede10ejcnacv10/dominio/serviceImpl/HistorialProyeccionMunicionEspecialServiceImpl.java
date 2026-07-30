//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionMunicionEspecialDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialProyeccionMunicionEspecialService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialProyeccionMunicionEspecialDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionMunicionEspecial;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProyeccionMunicionEspecialRepository;
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
* @Since 14/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialProyeccionMunicionEspecialServiceImpl implements HistorialProyeccionMunicionEspecialService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProyeccionMunicionEspecialDAO historialProyeccionMunicionEspecialDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProyeccionMunicionEspecialRepository historialProyeccionMunicionEspecialRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialProyeccionMunicionEspecial, String keyword) {
        return historialProyeccionMunicionEspecialRepository.findTotalRegistros(idHistorialProyeccionMunicionEspecial, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialProyeccionMunicionEspecialDTO> listarHistorialesProyeccionesMunicionesEspeciales(Long idHistorialProyeccionMunicionEspecial, String keyword, String orderBy, String orderMode) {
        List<HistorialProyeccionMunicionEspecial> historialesProyeccionesMunicionesEspeciales = historialProyeccionMunicionEspecialRepository.findAllHistorialesProyeccionesMunicionesEspeciales(idHistorialProyeccionMunicionEspecial, keyword, orderBy, orderMode);
        List<HistorialProyeccionMunicionEspecialDTO> historialProyeccionMunicionEspecialDTOS = new ArrayList<>();
        for (HistorialProyeccionMunicionEspecial historialProyeccionMunicionEspecial : historialesProyeccionesMunicionesEspeciales) {
            historialProyeccionMunicionEspecialDTOS.add(historialProyeccionMunicionEspecialDAO.historialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecial));
        }
        
        return historialProyeccionMunicionEspecialDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialProyeccionMunicionEspecialDTO> listarHistorialesProyeccionesMunicionesEspecialesPag(Pageable pageable, Long idHistorialProyeccionMunicionEspecial, String keyword, String orderBy, String orderMode) {
        Slice<HistorialProyeccionMunicionEspecial> historialesProyeccionesMunicionesEspeciales = historialProyeccionMunicionEspecialRepository.findAllHistorialesProyeccionesMunicionesEspecialesPag(pageable, idHistorialProyeccionMunicionEspecial, keyword, orderBy, orderMode);
        return historialesProyeccionesMunicionesEspeciales.map(historialProyeccionMunicionEspecial -> historialProyeccionMunicionEspecialDAO.historialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecial));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialProyeccionMunicionEspecial(HistorialProyeccionMunicionEspecialDTO historialProyeccionMunicionEspecialDTO) {
        Long maxIdHistorialProyeccionMunicionEspecial = historialProyeccionMunicionEspecialRepository.findMaxIdHistorialProyeccionMunicionEspecial();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdHistorialProyeccionMunicionEspecial == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdHistorialProyeccionMunicionEspecial = Long.valueOf(0);
        }
        historialProyeccionMunicionEspecialDTO.setIdHistorialProyeccionMunicionEspecial(maxIdHistorialProyeccionMunicionEspecial + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-PROY-MUN-ESP" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
        SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHMSIngresoHistorialProyeccionMunicionEspecialSinIntermedios = objetoFechaHMS.format(new Date());
        historialProyeccionMunicionEspecialDTO.setNumRegHistorialProyeccionMunicionEspecial("HIST-PROY-MUN-ESP" + "-" + (maxIdHistorialProyeccionMunicionEspecial + 1) + "-" + fechaHMSIngresoHistorialProyeccionMunicionEspecialSinIntermedios);
        
        historialProyeccionMunicionEspecialRepository.save(historialProyeccionMunicionEspecialDAO.historialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionMunicionEspecialportId(Long idHistorialProyeccionMunicionEspecial) {
        Optional<HistorialProyeccionMunicionEspecial> historialProyeccionMunicionEspecialId = historialProyeccionMunicionEspecialRepository.findByIdHistorialProyeccionMunicionEspecial(Long.valueOf(idHistorialProyeccionMunicionEspecial));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionMunicionEspecialId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecialDAO.historialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecialId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionMunicionEspecialId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialProyeccionMunicionEspecialportNumReg(String numRegHistorialProyeccionMunicionEspecial) {
        if (numRegHistorialProyeccionMunicionEspecial == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialProyeccionMunicionEspecial> historialProyeccionMunicionEspecialNumReg = Optional.ofNullable(historialProyeccionMunicionEspecialRepository.findByNumRegHistorialProyeccionMunicionEspecial(numRegHistorialProyeccionMunicionEspecial));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialProyeccionMunicionEspecialNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecialDAO.historialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecialNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialProyeccionMunicionEspecialNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialProyeccionMunicionEspecial(HistorialProyeccionMunicionEspecialDTO historialProyeccionMunicionEspecialDTO) {
        Optional<HistorialProyeccionMunicionEspecial> historialProyeccionMunicionEspecialId = historialProyeccionMunicionEspecialRepository.findByIdHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO.getIdHistorialProyeccionMunicionEspecial());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialProyeccionMunicionEspecialId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           //SE PRESERVA EL NÚMERO DE REGISTRO ORIGINAL DE LA BASE DE DATOS PARA NO VIOLAR LA RESTRICCIÓN ÚNICA:
           historialProyeccionMunicionEspecialDTO.setNumRegHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialId.get().getNumRegHistorialProyeccionMunicionEspecial());
           historialProyeccionMunicionEspecialRepository.save(historialProyeccionMunicionEspecialDAO.historialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (historialProyeccionMunicionEspecialId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialProyeccionMunicionEspecial(Long idHistorialProyeccionMunicionEspecial) {
        Optional<HistorialProyeccionMunicionEspecial> historialProyeccionMunicionEspecialId = historialProyeccionMunicionEspecialRepository.findById(idHistorialProyeccionMunicionEspecial);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialProyeccionMunicionEspecialId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecialDAO.historialProyeccionMunicionEspecialDTO(historialProyeccionMunicionEspecialId.get()));
           historialProyeccionMunicionEspecialRepository.delete(historialProyeccionMunicionEspecialId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialProyeccionMunicionEspecialId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialProyeccionMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
}
