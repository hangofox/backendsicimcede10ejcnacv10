//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ApoyoAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ApoyoAtencPrevEmergDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ApoyoAtencPrevEmergDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoAtencPrevEmergDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ApoyoAtencPrevEmergDesastServiceImpl implements ApoyoAtencPrevEmergDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoAtencPrevEmergDesastDAO apoyoAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoAtencPrevEmergDesastRepository apoyoAtencPrevEmergDesastRepository;
    
    //CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR KEYWORD E ID UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idApoyoAtencPrevEmergDesast, String keyword, Long idUnidadMilitar, Long idProcesoApoyoAtencionPrevencion) {
        return apoyoAtencPrevEmergDesastRepository.findTotalRegistros(idApoyoAtencPrevEmergDesast, keyword, idUnidadMilitar, idProcesoApoyoAtencionPrevencion);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR KEYWORD E ID UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ApoyoAtencPrevEmergDesastDTO> listarApoyosAtencPrevEmergDesast(Long idApoyoAtencPrevEmergDesast, String keyword, Long idUnidadMilitar, Long idProcesoApoyoAtencionPrevencion, String orderBy, String orderMode) {
        List<ApoyoAtencPrevEmergDesast> apoyosAtencPrevEmergDesast = apoyoAtencPrevEmergDesastRepository.findAllApoyosAtencPrevEmergDesast(idApoyoAtencPrevEmergDesast, keyword, idUnidadMilitar, idProcesoApoyoAtencionPrevencion, orderBy, orderMode);
        List<ApoyoAtencPrevEmergDesastDTO> apoyoAtencPrevEmergDesastDTOS = new ArrayList<>();
        for (ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast : apoyosAtencPrevEmergDesast) {
            apoyoAtencPrevEmergDesastDTOS.add(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesast));
        }
        
        return apoyoAtencPrevEmergDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR KEYWORD E ID UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ApoyoAtencPrevEmergDesastDTO> listarApoyosAtencPrevEmergDesastPag(Pageable pageable, Long idApoyoAtencPrevEmergDesast, String keyword, Long idUnidadMilitar, Long idProcesoApoyoAtencionPrevencion, String orderBy, String orderMode) {
        Slice<ApoyoAtencPrevEmergDesast> apoyosAtencPrevEmergDesast = apoyoAtencPrevEmergDesastRepository.findAllApoyosAtencPrevEmergDesastPag(pageable, idApoyoAtencPrevEmergDesast, keyword, idUnidadMilitar, idProcesoApoyoAtencionPrevencion, orderBy, orderMode);
        return apoyosAtencPrevEmergDesast.map(apoyoAtencPrevEmergDesast -> apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesastDTO apoyoAtencPrevEmergDesastDTO) {
        Long maxIdApoyoAtencPrevEmergDesast = null;
        ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesastCodigoRadicado = apoyoAtencPrevEmergDesastRepository.findByCodigoRadicadoApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getCodigoRadicadoApoyoAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaCodigoRadicadoRegistroEncontrado = 0;
        
        if (!(apoyoAtencPrevEmergDesastCodigoRadicado == null)) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
           banderaCodigoRadicadoRegistroEncontrado = 1;
        }
        
        if (banderaCodigoRadicadoRegistroEncontrado == 1) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(null);
        }
        if (banderaCodigoRadicadoRegistroEncontrado == 0) {//SI NO ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL CÓDIGO RADICADO PROPORCIONADO.
           maxIdApoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesastRepository.findMaxIdApoyoAtencPrevEmergDesast();
           if (maxIdApoyoAtencPrevEmergDesast == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdApoyoAtencPrevEmergDesast = Long.valueOf(0);
           }
           apoyoAtencPrevEmergDesastDTO.setIdApoyoAtencPrevEmergDesast(maxIdApoyoAtencPrevEmergDesast + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL CÓDIGO DE RADICADO DE REGISTRO DEL APOYO COMBINANDO LA CADENA "APOY-ATENC" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-", LA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DE INICIACIÓN DEL APOYO DE ATENCIÓN Y PREVENCIÓN DE EMERGENCIAS Y DESASTRES EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIniciacionApoyoAtencPrevEmergDesastsinIntermedios = objetoFechaHMS.format(apoyoAtencPrevEmergDesastDTO.getFechaHMSIniciacionApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastDTO.setCodigoRadicadoApoyoAtencPrevEmergDesast("APOY-ATENC" + "-" + (maxIdApoyoAtencPrevEmergDesast + 1) + "-" + apoyoAtencPrevEmergDesastDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar() + "-" + fechaHMSIniciacionApoyoAtencPrevEmergDesastsinIntermedios);
           
           apoyoAtencPrevEmergDesastRepository.save(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarApoyoAtencPrevEmergDesastporId(Long idApoyoAtencPrevEmergDesast) {
        Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastId = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(Long.valueOf(idApoyoAtencPrevEmergDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (apoyoAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (apoyoAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CÓDIGO RADICADO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarApoyoAtencPrevEmergDesastporCodigoRadicado(String codigoRadicadoApoyoAtencPrevEmergDesast) {
        Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastCodigo = Optional.ofNullable(apoyoAtencPrevEmergDesastRepository.findByCodigoRadicadoApoyoAtencPrevEmergDesast(codigoRadicadoApoyoAtencPrevEmergDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
        
        if (apoyoAtencPrevEmergDesastCodigo.isPresent() == true) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastCodigo.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (apoyoAtencPrevEmergDesastCodigo.isPresent() == false) {//SI NO ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesastDTO apoyoAtencPrevEmergDesastDTO) {
        Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastId = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getIdApoyoAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (apoyoAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL CÓDIGO RADICADO DEL REGISTRO CON EL ID PROPORCIONADO.
           if (apoyoAtencPrevEmergDesastDTO.getCodigoRadicadoApoyoAtencPrevEmergDesast().equals(apoyoAtencPrevEmergDesastId.get().getCodigoRadicadoApoyoAtencPrevEmergDesast()) == true) {//SI EL CÓDIGO RADICADO DIGITADO ES IGUAL AL CÓDIGO RADICADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO);
              apoyoAtencPrevEmergDesastRepository.save(apoyoAtencPrevEmergDesast);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (apoyoAtencPrevEmergDesastDTO.getCodigoRadicadoApoyoAtencPrevEmergDesast().equals(apoyoAtencPrevEmergDesastId.get().getCodigoRadicadoApoyoAtencPrevEmergDesast()) == false) {//SI EL CÓDIGO RADICADO DIGITADO ES DIFERENTE AL CÓDIGO RADICADO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE CÓDIGO RADICADO DIGITADO EXISTE EN OTROS REGISTROS.
              ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesastCodigoRadicado = apoyoAtencPrevEmergDesastRepository.findByCodigoRadicadoApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getCodigoRadicadoApoyoAtencPrevEmergDesast());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaCodigoRadicadoRegistroEncontrado = 0;
              
              if (!(apoyoAtencPrevEmergDesastCodigoRadicado == null)) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
                 banderaCodigoRadicadoRegistroEncontrado = 1;
              }
              
              if (banderaCodigoRadicadoRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO RADICADO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CÓDIGO RADICADO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE CÓDIGO RADICADO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
                 respuestaDTO.setApoyoAtencPrevEmergDesastDTO(null);
              }
              if (banderaCodigoRadicadoRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO RADICADO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO);
                 apoyoAtencPrevEmergDesastRepository.save(apoyoAtencPrevEmergDesast);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (apoyoAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarApoyoAtencPrevEmergDesast(Long idApoyoAtencPrevEmergDesast) {
        Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastId = apoyoAtencPrevEmergDesastRepository.findById(idApoyoAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (apoyoAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastId.get()));
           apoyoAtencPrevEmergDesastRepository.delete(apoyoAtencPrevEmergDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (apoyoAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setApoyoAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
