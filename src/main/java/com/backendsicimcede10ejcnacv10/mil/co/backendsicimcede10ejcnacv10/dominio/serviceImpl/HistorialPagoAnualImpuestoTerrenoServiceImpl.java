//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialPagoAnualImpuestoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialPagoAnualImpuestoTerrenoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialPagoAnualImpuestoTerrenoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialPagoAnualImpuestoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialPagoAnualImpuestoTerrenoRepository;
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
public class HistorialPagoAnualImpuestoTerrenoServiceImpl implements HistorialPagoAnualImpuestoTerrenoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialPagoAnualImpuestoTerrenoDAO historialPagoAnualImpuestoTerrenoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialPagoAnualImpuestoTerrenoRepository historialPagoAnualImpuestoTerrenoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialPagoAnualImpuestoTerreno, String keyword) {
        return historialPagoAnualImpuestoTerrenoRepository.findTotalRegistros(idHistorialPagoAnualImpuestoTerreno, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialPagoAnualImpuestoTerrenoDTO> listarHistorialesPagosAnualesImpuestosTerrenos(Long idHistorialPagoAnualImpuestoTerreno, String keyword, String orderBy, String orderMode) {
        List<HistorialPagoAnualImpuestoTerreno> historialesPagosAnualesImpuestosTerrenos = historialPagoAnualImpuestoTerrenoRepository.findAllHistorialesPagosAnualesImpuestosTerrenos(idHistorialPagoAnualImpuestoTerreno, keyword, orderBy, orderMode);
        List<HistorialPagoAnualImpuestoTerrenoDTO> historialPagoAnualImpuestoTerrenoDTOS = new ArrayList<>();
        for (HistorialPagoAnualImpuestoTerreno historialPagoAnualImpuestoTerreno : historialesPagosAnualesImpuestosTerrenos) {
            historialPagoAnualImpuestoTerrenoDTOS.add(historialPagoAnualImpuestoTerrenoDAO.historialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerreno));
        }
        
        return historialPagoAnualImpuestoTerrenoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialPagoAnualImpuestoTerrenoDTO> listarHistorialesPagosAnualesImpuestosTerminosPag(Pageable pageable, Long idHistorialPagoAnualImpuestoTerreno, String keyword, String orderBy, String orderMode) {
        Slice<HistorialPagoAnualImpuestoTerreno> historialesPagosAnualesImpuestosTerrenos = historialPagoAnualImpuestoTerrenoRepository.findAllHistorialesPagosAnualesImpuestosTerminosPag(pageable, idHistorialPagoAnualImpuestoTerreno, keyword, orderBy, orderMode);
        return historialesPagosAnualesImpuestosTerrenos.map(historialPagoAnualImpuestoTerreno -> historialPagoAnualImpuestoTerrenoDAO.historialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerreno));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialPagoAnualImpuestoTerreno(HistorialPagoAnualImpuestoTerrenoDTO historialPagoAnualImpuestoTerrenoDTO) {
        Long maxIdHistorialPagoAnualImpuestoTerreno = null;
        HistorialPagoAnualImpuestoTerreno historialPagoAnualImpuestoTerrenoUnico = historialPagoAnualImpuestoTerrenoRepository.findByNumRegHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getNumRegHistorialPagoAnualImpuestoTerreno());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialPagoAnualImpuestoTerrenoUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialPagoAnualImpuestoTerreno = historialPagoAnualImpuestoTerrenoRepository.findMaxIdHistorialPagoAnualImpuestoTerreno();
           if (maxIdHistorialPagoAnualImpuestoTerreno == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialPagoAnualImpuestoTerreno = Long.valueOf(0);
           }
           historialPagoAnualImpuestoTerrenoDTO.setIdHistorialPagoAnualImpuestoTerreno(maxIdHistorialPagoAnualImpuestoTerreno + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-PAG-AN-IMP-TERR" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialPagoAnualImpuestoTerrenoSinIntermedios = objetoFechaHMS.format(new Date());
           historialPagoAnualImpuestoTerrenoDTO.setNumRegHistorialPagoAnualImpuestoTerreno("HIST-PAG-AN-IMP-TERR" + "-" + (maxIdHistorialPagoAnualImpuestoTerreno + 1) + "-" + fechaHMSIngresoHistorialPagoAnualImpuestoTerrenoSinIntermedios);
           
           historialPagoAnualImpuestoTerrenoRepository.save(historialPagoAnualImpuestoTerrenoDAO.historialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialPagoAnualImpuestoTerrenoportId(Long idHistorialPagoAnualImpuestoTerreno) {
        Optional<HistorialPagoAnualImpuestoTerreno> historialPagoAnualImpuestoTerrenoId = historialPagoAnualImpuestoTerrenoRepository.findByIdHistorialPagoAnualImpuestoTerreno(Long.valueOf(idHistorialPagoAnualImpuestoTerreno));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialPagoAnualImpuestoTerrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerrenoDAO.historialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerrenoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialPagoAnualImpuestoTerrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialPagoAnualImpuestoTerrenoportNumReg(String numRegHistorialPagoAnualImpuestoTerreno) {
        if (numRegHistorialPagoAnualImpuestoTerreno == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialPagoAnualImpuestoTerreno> historialPagoAnualImpuestoTerrenoNumReg = Optional.ofNullable(historialPagoAnualImpuestoTerrenoRepository.findByNumRegHistorialPagoAnualImpuestoTerreno(numRegHistorialPagoAnualImpuestoTerreno));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialPagoAnualImpuestoTerrenoNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerrenoDAO.historialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerrenoNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialPagoAnualImpuestoTerrenoNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialPagoAnualImpuestoTerreno(HistorialPagoAnualImpuestoTerrenoDTO historialPagoAnualImpuestoTerrenoDTO) {
        Optional<HistorialPagoAnualImpuestoTerreno> historialPagoAnualImpuestoTerrenoId = historialPagoAnualImpuestoTerrenoRepository.findByIdHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getIdHistorialPagoAnualImpuestoTerreno());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialPagoAnualImpuestoTerrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialPagoAnualImpuestoTerreno historialPagoAnualImpuestoTerrenoUnico = historialPagoAnualImpuestoTerrenoRepository.findByNumRegHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getNumRegHistorialPagoAnualImpuestoTerreno());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialPagoAnualImpuestoTerrenoUnico == null) && !(historialPagoAnualImpuestoTerrenoUnico.getIdHistorialPagoAnualImpuestoTerreno().equals(historialPagoAnualImpuestoTerrenoDTO.getIdHistorialPagoAnualImpuestoTerreno()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialPagoAnualImpuestoTerrenoRepository.save(historialPagoAnualImpuestoTerrenoDAO.historialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialPagoAnualImpuestoTerrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialPagoAnualImpuestoTerreno(Long idHistorialPagoAnualImpuestoTerreno) {
        Optional<HistorialPagoAnualImpuestoTerreno> historialPagoAnualImpuestoTerrenoId = historialPagoAnualImpuestoTerrenoRepository.findById(idHistorialPagoAnualImpuestoTerreno);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialPagoAnualImpuestoTerrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerrenoDAO.historialPagoAnualImpuestoTerrenoDTO(historialPagoAnualImpuestoTerrenoId.get()));
           historialPagoAnualImpuestoTerrenoRepository.delete(historialPagoAnualImpuestoTerrenoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialPagoAnualImpuestoTerrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialPagoAnualImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
}
