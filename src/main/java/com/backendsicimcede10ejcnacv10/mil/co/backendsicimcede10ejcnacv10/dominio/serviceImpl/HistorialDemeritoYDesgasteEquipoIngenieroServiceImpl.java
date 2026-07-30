//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialDemeritoYDesgasteEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialDemeritoYDesgasteEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialDemeritoYDesgasteEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialDemeritoYDesgasteEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialDemeritoYDesgasteEquipoIngenieroRepository;
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
* @Since 30/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialDemeritoYDesgasteEquipoIngenieroServiceImpl implements HistorialDemeritoYDesgasteEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialDemeritoYDesgasteEquipoIngenieroDAO historialDemeritoYDesgasteEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialDemeritoYDesgasteEquipoIngenieroRepository historialDemeritoYDesgasteEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialDemeritoYDesgasteEquipoIngeniero, String keyword) {
        return historialDemeritoYDesgasteEquipoIngenieroRepository.findTotalRegistros(idHistorialDemeritoYDesgasteEquipoIngeniero, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialDemeritoYDesgasteEquipoIngenieroDTO> listarHistorialesDemeritosYDesgastesEquiposIngenieros(Long idHistorialDemeritoYDesgasteEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<HistorialDemeritoYDesgasteEquipoIngeniero> historialesDemeritosYDesgastesEquiposIngenieros = historialDemeritoYDesgasteEquipoIngenieroRepository.findAllHistorialesDemeritosYDesgastesEquiposIngenieros(idHistorialDemeritoYDesgasteEquipoIngeniero, keyword, orderBy, orderMode);
        List<HistorialDemeritoYDesgasteEquipoIngenieroDTO> historialDemeritoYDesgasteEquipoIngeneroDTOS = new ArrayList<>();
        for (HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngeniero : historialesDemeritosYDesgastesEquiposIngenieros) {
            historialDemeritoYDesgasteEquipoIngeneroDTOS.add(historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngeniero));
        }
        
        return historialDemeritoYDesgasteEquipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialDemeritoYDesgasteEquipoIngenieroDTO> listarHistorialesDemeritosYDesgastesEquiposIngenierosPag(Pageable pageable, Long idHistorialDemeritoYDesgasteEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<HistorialDemeritoYDesgasteEquipoIngeniero> historialesDemeritosYDesgastesEquiposIngenieros = historialDemeritoYDesgasteEquipoIngenieroRepository.findAllHistorialesDemeritosYDesgastesEquiposIngenierosPag(pageable, idHistorialDemeritoYDesgasteEquipoIngeniero, keyword, orderBy, orderMode);
        return historialesDemeritosYDesgastesEquiposIngenieros.map(historialDemeritoYDesgasteEquipoIngeniero -> historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialDemeritoYDesgasteEquipoIngeniero(HistorialDemeritoYDesgasteEquipoIngenieroDTO historialDemeritoYDesgasteEquipoIngenieroDTO) {
        Long maxIdHistorialDemeritoYDesgasteEquipoIngeniero = null;
        HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngenieroUnico = historialDemeritoYDesgasteEquipoIngenieroRepository.findByNumRegHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getNumRegHistorialDemeritoYDesgasteEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(historialDemeritoYDesgasteEquipoIngenieroUnico == null)) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE REGISTRO DEL HISTORIAL EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialDemeritoYDesgasteEquipoIngeniero = historialDemeritoYDesgasteEquipoIngenieroRepository.findMaxIdHistorialDemeritoYDesgasteEquipoIngeniero();
           if (maxIdHistorialDemeritoYDesgasteEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialDemeritoYDesgasteEquipoIngeniero = Long.valueOf(0);
           }
           historialDemeritoYDesgasteEquipoIngenieroDTO.setIdHistorialDemeritoYDesgasteEquipoIngeniero(maxIdHistorialDemeritoYDesgasteEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-DEMER-DESGAST-EQUIP-ING" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoHistorialDemeritoYDesgasteEquipoIngenieroSinIntermedios = objetoFechaHMS.format(new Date());
           historialDemeritoYDesgasteEquipoIngenieroDTO.setNumRegHistorialDemeritoYDesgasteEquipoIngeniero("HIST-DEMER-DESGAST-EQUIP-ING" + "-" + (maxIdHistorialDemeritoYDesgasteEquipoIngeniero + 1) + "-" + fechaHMSIngresoHistorialDemeritoYDesgasteEquipoIngenieroSinIntermedios);
           
           historialDemeritoYDesgasteEquipoIngenieroRepository.save(historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialDemeritoYDesgasteEquipoIngenieroporId(Long idHistorialDemeritoYDesgasteEquipoIngeniero) {
        Optional<HistorialDemeritoYDesgasteEquipoIngeniero> historialDemeritoYDesgasteEquipoIngenieroId = historialDemeritoYDesgasteEquipoIngenieroRepository.findByIdHistorialDemeritoYDesgasteEquipoIngeniero(Long.valueOf(idHistorialDemeritoYDesgasteEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialDemeritoYDesgasteEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialDemeritoYDesgasteEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialDemeritoYDesgasteEquipoIngenieroporNumReg(String numRegHistorialDemeritoYDesgasteEquipoIngeniero) {
        if (numRegHistorialDemeritoYDesgasteEquipoIngeniero == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialDemeritoYDesgasteEquipoIngeniero> historialDemeritoYDesgasteEquipoIngenieroNumReg = Optional.ofNullable(historialDemeritoYDesgasteEquipoIngenieroRepository.findByNumRegHistorialDemeritoYDesgasteEquipoIngeniero(numRegHistorialDemeritoYDesgasteEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialDemeritoYDesgasteEquipoIngenieroNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngenieroNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialDemeritoYDesgasteEquipoIngenieroNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialDemeritoYDesgasteEquipoIngeniero(HistorialDemeritoYDesgasteEquipoIngenieroDTO historialDemeritoYDesgasteEquipoIngenieroDTO) {
        Optional<HistorialDemeritoYDesgasteEquipoIngeniero> historialDemeritoYDesgasteEquipoIngenieroId = historialDemeritoYDesgasteEquipoIngenieroRepository.findByIdHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getIdHistorialDemeritoYDesgasteEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialDemeritoYDesgasteEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngenieroUnico = historialDemeritoYDesgasteEquipoIngenieroRepository.findByNumRegHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getNumRegHistorialDemeritoYDesgasteEquipoIngeniero());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(historialDemeritoYDesgasteEquipoIngenieroUnico == null) && !(historialDemeritoYDesgasteEquipoIngenieroUnico.getIdHistorialDemeritoYDesgasteEquipoIngeniero().equals(historialDemeritoYDesgasteEquipoIngenieroDTO.getIdHistorialDemeritoYDesgasteEquipoIngeniero()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO DE REGISTRO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO CAMPO ÚNICO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO CAMPO ÚNICO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              historialDemeritoYDesgasteEquipoIngenieroRepository.save(historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialDemeritoYDesgasteEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialDemeritoYDesgasteEquipoIngeniero(Long idHistorialDemeritoYDesgasteEquipoIngeniero) {
        Optional<HistorialDemeritoYDesgasteEquipoIngeniero> historialDemeritoYDesgasteEquipoIngenieroId = historialDemeritoYDesgasteEquipoIngenieroRepository.findById(idHistorialDemeritoYDesgasteEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialDemeritoYDesgasteEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngenieroId.get()));
           historialDemeritoYDesgasteEquipoIngenieroRepository.delete(historialDemeritoYDesgasteEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialDemeritoYDesgasteEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
