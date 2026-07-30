//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.SolicitudInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.SolicitudInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
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
public class SolicitudInfraestructuraServiceImpl implements SolicitudInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private SolicitudInfraestructuraDAO solicitudInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;
    
    //CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR KEYWORD Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar) {
        return solicitudInfraestructuraRepository.findTotalRegistros(idSolicitudInfraestructura, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR KEYWORD Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<SolicitudInfraestructuraDTO> listarSolicitudesInfraestructuras(Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<SolicitudInfraestructura> solicitudesInfraestructuras = solicitudInfraestructuraRepository.findAllSolicitudesInfraestructuras(idSolicitudInfraestructura, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<SolicitudInfraestructuraDTO> solicitudesInfraestructurasDTOS = new ArrayList<>();
        
        for (SolicitudInfraestructura solicitudInfraestructura : solicitudesInfraestructuras) {
            solicitudesInfraestructurasDTOS.add(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicitudInfraestructura));
        }
        
        return solicitudesInfraestructurasDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR KEYWORD Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<SolicitudInfraestructuraDTO> listarSolicitudesInfraestructurasPag(Pageable pageable, Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<SolicitudInfraestructura> solicitudesInfraestructuras = solicitudInfraestructuraRepository.findAllSolicitudesInfraestructurasPag(pageable, idSolicitudInfraestructura, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return solicitudesInfraestructuras.map(solicitudInfraestructura -> solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicitudInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearSolicitudInfraestructura(SolicitudInfraestructuraDTO solicitudInfraestructuraDTO) {
        Long maxIdSolicitudInfraestructura = null;
        SolicitudInfraestructura solicitudInfraestructuraCodigoRadicado = solicitudInfraestructuraRepository.findByCodigoRadicadoSolicitudInfraestructura(solicitudInfraestructuraDTO.getCodigoRadicadoSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaCodigoRadicadoRegistroEncontrado = 0;
        
        if (!(solicitudInfraestructuraCodigoRadicado == null)) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
           banderaCodigoRadicadoRegistroEncontrado = 1;
        }
        
        if (banderaCodigoRadicadoRegistroEncontrado == 1) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           respuestaDTO.setSolicitudInfraestructuraDTO(null);
        }
        if (banderaCodigoRadicadoRegistroEncontrado == 0) {//SI NO ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL CÓDIGO RADICADO PROPORCIONADO.
           maxIdSolicitudInfraestructura = solicitudInfraestructuraRepository.findMaxIdSolicitudInfraestructura();
           if (maxIdSolicitudInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdSolicitudInfraestructura = Long.valueOf(0);
           }
           solicitudInfraestructuraDTO.setIdSolicitudInfraestructura(maxIdSolicitudInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL CÓDIGO DE RADICADO DE REGISTRO DE LA SOLICITUD COMBINANDO LA CADENA "SOL-INF" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-", LA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO SOLICITUD DE INFRAESTRUCTURA EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoSolicitudInfraestructurasinIntermedios = objetoFechaHMS.format(solicitudInfraestructuraDTO.getFechaHMSIngresoSolicitudInfraestructura());
           solicitudInfraestructuraDTO.setCodigoRadicadoSolicitudInfraestructura("SOL-INF" + "-" + (maxIdSolicitudInfraestructura + 1) + "-" + solicitudInfraestructuraDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar() + "-" + fechaHMSIngresoSolicitudInfraestructurasinIntermedios);
           
           solicitudInfraestructuraRepository.save(solicitudInfraestructuraDAO.solicitudInfraestructura(solicitudInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSolicitudInfraestructuraporId(Long idSolicitudInfraestructura) {
        Optional<SolicitudInfraestructura> solicitudInfraestructuraId = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(Long.valueOf(idSolicitudInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (solicitudInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicitudInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (solicitudInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CÓDIGO RADICADO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSolicitudInfraestructuraporCodigoRadicado(String codigoRadicadoSolicitudInfraestructura) {
        Optional<SolicitudInfraestructura> solicitudInfraestructuraCodigo = Optional.ofNullable(solicitudInfraestructuraRepository.findByCodigoRadicadoSolicitudInfraestructura(codigoRadicadoSolicitudInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
        
        if (solicitudInfraestructuraCodigo.isPresent() == true) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicitudInfraestructuraCodigo.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (solicitudInfraestructuraCodigo.isPresent() == false) {//SI NO ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL CÓDIGO RADICADO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
           respuestaDTO.setSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarSolicitudInfraestructura(SolicitudInfraestructuraDTO solicitudInfraestructuraDTO) {
        Optional<SolicitudInfraestructura> solicitudInfraestructuraId = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(solicitudInfraestructuraDTO.getIdSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (solicitudInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL CÓDIGO RADICADO DEL REGISTRO CON EL ID PROPORCIONADO.
           if (solicitudInfraestructuraDTO.getCodigoRadicadoSolicitudInfraestructura().equals(solicitudInfraestructuraId.get().getCodigoRadicadoSolicitudInfraestructura()) == true) {//SI EL CÓDIGO RADICADO DIGITADO ES IGUAL AL CÓDIGO RADICADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              SolicitudInfraestructura solicitudInfraestructura = solicitudInfraestructuraDAO.solicitudInfraestructura(solicitudInfraestructuraDTO);
              solicitudInfraestructuraRepository.save(solicitudInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (solicitudInfraestructuraDTO.getCodigoRadicadoSolicitudInfraestructura().equals(solicitudInfraestructuraId.get().getCodigoRadicadoSolicitudInfraestructura()) == false) {//SI EL CÓDIGO RADICADO DIGITADO ES DIFERENTE AL CÓDIGO RADICADO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE CÓDIGO RADICADO DIGITADO EXISTE EN OTROS REGISTROS.
              SolicitudInfraestructura solicitudInfraestructuraCodigoRadicado = solicitudInfraestructuraRepository.findByCodigoRadicadoSolicitudInfraestructura(solicitudInfraestructuraDTO.getCodigoRadicadoSolicitudInfraestructura());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaCodigoRadicadoRegistroEncontrado = 0;
              
              if (!(solicitudInfraestructuraCodigoRadicado == null)) {//SI ENCONTRO EL CÓDIGO RADICADO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO RADICADO DE REGISTRO REPETIDO CON EL CÓDIGO RADICADO PROPORCIONADO.
                 banderaCodigoRadicadoRegistroEncontrado = 1;
              }
              
              if (banderaCodigoRadicadoRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO RADICADO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CÓDIGO RADICADO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE CÓDIGO RADICADO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
                 respuestaDTO.setSolicitudInfraestructuraDTO(null);
              }
              if (banderaCodigoRadicadoRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO RADICADO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 SolicitudInfraestructura solicitudInfraestructura = solicitudInfraestructuraDAO.solicitudInfraestructura(solicitudInfraestructuraDTO);
                 solicitudInfraestructuraRepository.save(solicitudInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (solicitudInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarSolicitudInfraestructura(Long idSolicitudInfraestructura) {
        Optional<SolicitudInfraestructura> solicitudInfraestructuraId = solicitudInfraestructuraRepository.findById(idSolicitudInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (solicitudInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicitudInfraestructuraId.get()));
           solicitudInfraestructuraRepository.delete(solicitudInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (solicitudInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
