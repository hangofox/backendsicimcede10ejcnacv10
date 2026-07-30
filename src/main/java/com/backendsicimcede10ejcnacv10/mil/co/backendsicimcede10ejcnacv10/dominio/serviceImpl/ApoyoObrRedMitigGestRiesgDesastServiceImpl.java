//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ApoyoObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ApoyoObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ApoyoObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoObrRedMitigGestRiesgDesastRepository;
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
* @Since 27/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ApoyoObrRedMitigGestRiesgDesastServiceImpl implements ApoyoObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoObrRedMitigGestRiesgDesastDAO apoyoObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoObrRedMitigGestRiesgDesastRepository apoyoObrRedMitigGestRiesgDesastRepository;
    
    //CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR KEYWORD Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idApoyoObrRedMitigGestRiesgDesast, String keyword, String siglaoAcronimoUnidadMilitar) {
        return apoyoObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idApoyoObrRedMitigGestRiesgDesast, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR KEYWORD Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ApoyoObrRedMitigGestRiesgDesastDTO> listarApoyosObrRedMitigGestRiesgDesast(Long idApoyoObrRedMitigGestRiesgDesast, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<ApoyoObrRedMitigGestRiesgDesast> apoyosObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesastRepository.findAllApoyosObrRedMitigGestRiesgDesast(idApoyoObrRedMitigGestRiesgDesast, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<ApoyoObrRedMitigGestRiesgDesastDTO> apoyosObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        
        for (ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast : apoyosObrRedMitigGestRiesgDesast) {
            apoyosObrRedMitigGestRiesgDesastDTOS.add(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesast));
        }
        
        return apoyosObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR KEYWORD Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ApoyoObrRedMitigGestRiesgDesastDTO> listarApoyosObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idApoyoObrRedMitigGestRiesgDesast, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<ApoyoObrRedMitigGestRiesgDesast> apoyosObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesastRepository.findAllApoyosObrRedMitigGestRiesgDesastPag(pageable, idApoyoObrRedMitigGestRiesgDesast, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return apoyosObrRedMitigGestRiesgDesast.map(apoyoObrRedMitigGestRiesgDesast -> apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesastDTO apoyoObrRedMitigGestRiesgDesastDTO) {
        Long maxIdApoyoObrRedMitigGestRiesgDesast = null;
        ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesastCodigoRadicado = apoyoObrRedMitigGestRiesgDesastRepository.findByCodigoRadicadoApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaCodigoRadicadoRegistroEncontrado = 0;
        
        if (!(apoyoObrRedMitigGestRiesgDesastCodigoRadicado == null)) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
           banderaCodigoRadicadoRegistroEncontrado = 1;
        }
        
        if (banderaCodigoRadicadoRegistroEncontrado == 1) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        if (banderaCodigoRadicadoRegistroEncontrado == 0) {//SI NO ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL CÓDIGO RADICADO PROPORCIONADO.
           maxIdApoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesastRepository.findMaxIdApoyoObrRedMitigGestRiesgDesast();
           if (maxIdApoyoObrRedMitigGestRiesgDesast == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdApoyoObrRedMitigGestRiesgDesast = Long.valueOf(0);
           }
           apoyoObrRedMitigGestRiesgDesastDTO.setIdApoyoObrRedMitigGestRiesgDesast(maxIdApoyoObrRedMitigGestRiesgDesast + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL CÓDIGO DE RADICADO DE REGISTRO DEL APOYO COMBINANDO LA CADENA "APOY-OBR" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-", LA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DE INICIACIÓN DEL APOYO DE OBRAS DE REDUCCIÓN Y MITIGACIÓN DE GESTIÓN DEL RIESGO DE DESASTRES EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesastsinIntermedios = objetoFechaHMS.format(apoyoObrRedMitigGestRiesgDesastDTO.getFechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastDTO.setCodigoRadicadoApoyoObrRedMitigGestRiesgDesast("APOY-OBR" + "-" + (maxIdApoyoObrRedMitigGestRiesgDesast + 1) + "-" + apoyoObrRedMitigGestRiesgDesastDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar() + "-" + fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesastsinIntermedios);
           
           apoyoObrRedMitigGestRiesgDesastRepository.save(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarApoyoObrRedMitigGestRiesgDesastporId(Long idApoyoObrRedMitigGestRiesgDesast) {
        Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastId = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(Long.valueOf(idApoyoObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (apoyoObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (apoyoObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CÓDIGO RADICADO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarApoyoObrRedMitigGestRiesgDesastporCodigoRadicado(String codigoRadicadoApoyoObrRedMitigGestRiesgDesast) {
        Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastCodigo = Optional.ofNullable(apoyoObrRedMitigGestRiesgDesastRepository.findByCodigoRadicadoApoyoObrRedMitigGestRiesgDesast(codigoRadicadoApoyoObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
        
        if (apoyoObrRedMitigGestRiesgDesastCodigo.isPresent() == true) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastCodigo.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (apoyoObrRedMitigGestRiesgDesastCodigo.isPresent() == false) {//SI NO ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesastDTO apoyoObrRedMitigGestRiesgDesastDTO) {
        Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastId = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getIdApoyoObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (apoyoObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL CÓDIGO RADICADO DEL REGISTRO CON EL ID PROPORCIONADO.
           if (apoyoObrRedMitigGestRiesgDesastDTO.getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast().equals(apoyoObrRedMitigGestRiesgDesastId.get().getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast()) == true) {//SI EL CÓDIGO RADICADO DIGITADO ES IGUAL AL CÓDIGO RADICADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO);
              apoyoObrRedMitigGestRiesgDesastRepository.save(apoyoObrRedMitigGestRiesgDesast);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (apoyoObrRedMitigGestRiesgDesastDTO.getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast().equals(apoyoObrRedMitigGestRiesgDesastId.get().getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast()) == false) {//SI EL CÓDIGO RADICADO DIGITADO ES DIFERENTE AL CÓDIGO RADICADO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE CÓDIGO RADICADO DIGITADO EXISTE EN OTROS REGISTROS.
              ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesastCodigoRadicado = apoyoObrRedMitigGestRiesgDesastRepository.findByCodigoRadicadoApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaCodigoRadicadoRegistroEncontrado = 0;
              
              if (!(apoyoObrRedMitigGestRiesgDesastCodigoRadicado == null)) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
                 banderaCodigoRadicadoRegistroEncontrado = 1;
              }
              
              if (banderaCodigoRadicadoRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO RADICADO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CÓDIGO RADICADO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE CÓDIGO RADICADO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
                 respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(null);
              }
              if (banderaCodigoRadicadoRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO RADICADO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO);
                 apoyoObrRedMitigGestRiesgDesastRepository.save(apoyoObrRedMitigGestRiesgDesast);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (apoyoObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarApoyoObrRedMitigGestRiesgDesast(Long idApoyoObrRedMitigGestRiesgDesast) {
        Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastId = apoyoObrRedMitigGestRiesgDesastRepository.findById(idApoyoObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (apoyoObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastId.get()));
           apoyoObrRedMitigGestRiesgDesastRepository.delete(apoyoObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (apoyoObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setApoyoObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
