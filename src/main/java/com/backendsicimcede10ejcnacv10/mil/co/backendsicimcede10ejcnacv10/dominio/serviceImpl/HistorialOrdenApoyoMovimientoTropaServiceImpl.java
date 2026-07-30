//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialOrdenApoyoMovimientoTropaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialOrdenApoyoMovimientoTropaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialOrdenApoyoMovimientoTropaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialOrdenApoyoMovimientoTropa;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialOrdenApoyoMovimientoTropaRepository;
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
public class HistorialOrdenApoyoMovimientoTropaServiceImpl implements HistorialOrdenApoyoMovimientoTropaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialOrdenApoyoMovimientoTropaDAO historialOrdenApoyoMovimientoTropaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialOrdenApoyoMovimientoTropaRepository historialOrdenApoyoMovimientoTropaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialOrdenApoyoMovimientoTropa, String keyword) {
        return historialOrdenApoyoMovimientoTropaRepository.findTotalRegistros(idHistorialOrdenApoyoMovimientoTropa, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialOrdenApoyoMovimientoTropaDTO> listarHistorialesOrdenesApoyosMovimientosTropas(Long idHistorialOrdenApoyoMovimientoTropa, String keyword, String orderBy, String orderMode) {
        List<HistorialOrdenApoyoMovimientoTropa> historialesOrdenesApoyosMovimientosTropas = historialOrdenApoyoMovimientoTropaRepository.findAllHistorialesOrdenesApoyosMovimientosTropas(idHistorialOrdenApoyoMovimientoTropa, keyword, orderBy, orderMode);
        List<HistorialOrdenApoyoMovimientoTropaDTO> historialOrdenApoyoMovimientoTropaDTOS = new ArrayList<>();
        for (HistorialOrdenApoyoMovimientoTropa historialOrdenApoyoMovimientoTropa : historialesOrdenesApoyosMovimientosTropas) {
            historialOrdenApoyoMovimientoTropaDTOS.add(historialOrdenApoyoMovimientoTropaDAO.historialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropa));
        }
        
        return historialOrdenApoyoMovimientoTropaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialOrdenApoyoMovimientoTropaDTO> listarHistorialesOrdenesApoyosMovimientosTropasPag(Pageable pageable, Long idHistorialOrdenApoyoMovimientoTropa, String keyword, String orderBy, String orderMode) {
        Slice<HistorialOrdenApoyoMovimientoTropa> historialesOrdenesApoyosMovimientosTropas = historialOrdenApoyoMovimientoTropaRepository.findAllHistorialesOrdenesApoyosMovimientosTropasPag(pageable, idHistorialOrdenApoyoMovimientoTropa, keyword, orderBy, orderMode);
        return historialesOrdenesApoyosMovimientosTropas.map(historialOrdenApoyoMovimientoTropa -> historialOrdenApoyoMovimientoTropaDAO.historialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropa));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialOrdenApoyoMovimientoTropa(HistorialOrdenApoyoMovimientoTropaDTO historialOrdenApoyoMovimientoTropaDTO) {
        Long maxIdHistorialOrdenApoyoMovimientoTropa = null;
        HistorialOrdenApoyoMovimientoTropa historialOrdenApoyoMovimientoTropaUnico = historialOrdenApoyoMovimientoTropaRepository.findByNumRegHistorialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO.getNumRegHistorialOrdenApoyoMovimientoTropa());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialOrdenApoyoMovimientoTropaUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialOrdenApoyoMovimientoTropa = historialOrdenApoyoMovimientoTropaRepository.findMaxIdHistorialOrdenApoyoMovimientoTropa();
           if (maxIdHistorialOrdenApoyoMovimientoTropa == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialOrdenApoyoMovimientoTropa = Long.valueOf(0);
           }
           historialOrdenApoyoMovimientoTropaDTO.setIdHistorialOrdenApoyoMovimientoTropa(maxIdHistorialOrdenApoyoMovimientoTropa + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-ORD-APOY-MOV-TROP" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialOrdenApoyoMovimientoTropaSinIntermedios = objetoFechaHMS.format(new Date());
           historialOrdenApoyoMovimientoTropaDTO.setNumRegHistorialOrdenApoyoMovimientoTropa("HIST-ORD-APOY-MOV-TROP" + "-" + (maxIdHistorialOrdenApoyoMovimientoTropa + 1) + "-" + fechaHMSIngresoHistorialOrdenApoyoMovimientoTropaSinIntermedios);
           
           historialOrdenApoyoMovimientoTropaRepository.save(historialOrdenApoyoMovimientoTropaDAO.historialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialOrdenApoyoMovimientoTropaporId(Long idHistorialOrdenApoyoMovimientoTropa) {
        Optional<HistorialOrdenApoyoMovimientoTropa> historialOrdenApoyoMovimientoTropaId = historialOrdenApoyoMovimientoTropaRepository.findByIdHistorialOrdenApoyoMovimientoTropa(Long.valueOf(idHistorialOrdenApoyoMovimientoTropa));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialOrdenApoyoMovimientoTropaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropaDAO.historialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialOrdenApoyoMovimientoTropaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialOrdenApoyoMovimientoTropaporNumReg(String numRegHistorialOrdenApoyoMovimientoTropa) {
        if (numRegHistorialOrdenApoyoMovimientoTropa == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialOrdenApoyoMovimientoTropa> historialOrdenApoyoMovimientoTropaNumReg = Optional.ofNullable(historialOrdenApoyoMovimientoTropaRepository.findByNumRegHistorialOrdenApoyoMovimientoTropa(numRegHistorialOrdenApoyoMovimientoTropa));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialOrdenApoyoMovimientoTropaNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropaDAO.historialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropaNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialOrdenApoyoMovimientoTropaNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialOrdenApoyoMovimientoTropa(HistorialOrdenApoyoMovimientoTropaDTO historialOrdenApoyoMovimientoTropaDTO) {
        Optional<HistorialOrdenApoyoMovimientoTropa> historialOrdenApoyoMovimientoTropaId = historialOrdenApoyoMovimientoTropaRepository.findByIdHistorialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO.getIdHistorialOrdenApoyoMovimientoTropa());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialOrdenApoyoMovimientoTropaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialOrdenApoyoMovimientoTropa historialOrdenApoyoMovimientoTropaUnico = historialOrdenApoyoMovimientoTropaRepository.findByNumRegHistorialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO.getNumRegHistorialOrdenApoyoMovimientoTropa());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialOrdenApoyoMovimientoTropaUnico == null) && !(historialOrdenApoyoMovimientoTropaUnico.getIdHistorialOrdenApoyoMovimientoTropa().equals(historialOrdenApoyoMovimientoTropaDTO.getIdHistorialOrdenApoyoMovimientoTropa()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialOrdenApoyoMovimientoTropaRepository.save(historialOrdenApoyoMovimientoTropaDAO.historialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialOrdenApoyoMovimientoTropaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialOrdenApoyoMovimientoTropa(Long idHistorialOrdenApoyoMovimientoTropa) {
        Optional<HistorialOrdenApoyoMovimientoTropa> historialOrdenApoyoMovimientoTropaId = historialOrdenApoyoMovimientoTropaRepository.findById(idHistorialOrdenApoyoMovimientoTropa);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialOrdenApoyoMovimientoTropaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropaDAO.historialOrdenApoyoMovimientoTropaDTO(historialOrdenApoyoMovimientoTropaId.get()));
           historialOrdenApoyoMovimientoTropaRepository.delete(historialOrdenApoyoMovimientoTropaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialOrdenApoyoMovimientoTropaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialOrdenApoyoMovimientoTropaDTO(null);
        }
        
        return respuestaDTO;
    }
}
