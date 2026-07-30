//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InformacionFinancieraSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.InformacionFinancieraSolicitudInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.InformacionFinancieraSolicitudInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InformacionFinancieraSolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InformacionFinancieraSolicitudInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class InformacionFinancieraSolicitudInfraestructuraServiceImpl implements InformacionFinancieraSolicitudInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private InformacionFinancieraSolicitudInfraestructuraDAO informacionFinancieraSolicitudInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InformacionFinancieraSolicitudInfraestructuraRepository informacionFinancieraSolicitudInfraestructuraRepository;
    
    //CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR KEYWORD E ID DE SOLICITUD DE INFRAESTRUCTURA):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(String keyword, Long idSolicitudInfraestructura) {
        return informacionFinancieraSolicitudInfraestructuraRepository.findTotalRegistros(keyword, idSolicitudInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR KEYWORD E ID DE SOLICITUD DE INFRAESTRUCTURA):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<InformacionFinancieraSolicitudInfraestructuraDTO> listarInformacionesFinancierasSolicitudesInfraestructuras(String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        List<InformacionFinancieraSolicitudInfraestructura> informacionesFinancierasSolicitudesInfraestructuras = informacionFinancieraSolicitudInfraestructuraRepository.findAllInformacionesFinancierasSolicitudesInfraestructuras(keyword, idSolicitudInfraestructura, orderBy, orderMode);
        List<InformacionFinancieraSolicitudInfraestructuraDTO> informacionesFinancierasSolicitudesInfraestructurasDTOS = new ArrayList<>();
        
        for (InformacionFinancieraSolicitudInfraestructura informacionFinancieraSolicitudInfraestructura : informacionesFinancierasSolicitudesInfraestructuras) {
            informacionesFinancierasSolicitudesInfraestructurasDTOS.add(informacionFinancieraSolicitudInfraestructuraDAO.informacionFinancieraSolicitudInfraestructuraDTO(informacionFinancieraSolicitudInfraestructura));
        }
        
        return informacionesFinancierasSolicitudesInfraestructurasDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR KEYWORD E ID DE SOLICITUD DE INFRAESTRUCTURA):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<InformacionFinancieraSolicitudInfraestructuraDTO> listarInformacionesFinancierasSolicitudesInfraestructurasPag(Pageable pageable, String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        Slice<InformacionFinancieraSolicitudInfraestructura> informacionesFinancierasSolicitudesInfraestructuras = informacionFinancieraSolicitudInfraestructuraRepository.findAllInformacionesFinancierasSolicitudesInfraestructurasPag(pageable, keyword, idSolicitudInfraestructura, orderBy, orderMode);
        return informacionesFinancierasSolicitudesInfraestructuras.map(informacionFinancieraSolicitudInfraestructura -> informacionFinancieraSolicitudInfraestructuraDAO.informacionFinancieraSolicitudInfraestructuraDTO(informacionFinancieraSolicitudInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearInformacionFinancieraSolicitudInfraestructura(InformacionFinancieraSolicitudInfraestructuraDTO informacionFinancieraSolicitudInfraestructuraDTO) {
        Long maxIdInformacionFinancieraSolicitudInfraestructura = informacionFinancieraSolicitudInfraestructuraRepository.findMaxIdInformacionFinancieraSolicitudInfraestructura();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdInformacionFinancieraSolicitudInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdInformacionFinancieraSolicitudInfraestructura = Long.valueOf(0);
        }
        informacionFinancieraSolicitudInfraestructuraDTO.setIdInformacionFinancieraSolicitudInfraestructura(maxIdInformacionFinancieraSolicitudInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        informacionFinancieraSolicitudInfraestructuraRepository.save(informacionFinancieraSolicitudInfraestructuraDAO.informacionFinancieraSolicitudInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarInformacionFinancieraSolicitudInfraestructuraporId(Long idInformacionFinancieraSolicitudInfraestructura) {
        Optional<InformacionFinancieraSolicitudInfraestructura> informacionFinancieraId = informacionFinancieraSolicitudInfraestructuraRepository.findByIdInformacionFinancieraSolicitudInfraestructura(Long.valueOf(idInformacionFinancieraSolicitudInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (informacionFinancieraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setInformacionFinancieraSolicitudInfraestructuraDTO(informacionFinancieraSolicitudInfraestructuraDAO.informacionFinancieraSolicitudInfraestructuraDTO(informacionFinancieraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (informacionFinancieraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInformacionFinancieraSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarInformacionFinancieraSolicitudInfraestructura(InformacionFinancieraSolicitudInfraestructuraDTO informacionFinancieraSolicitudInfraestructuraDTO) {
        Optional<InformacionFinancieraSolicitudInfraestructura> informacionFinancieraId = informacionFinancieraSolicitudInfraestructuraRepository.findByIdInformacionFinancieraSolicitudInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getIdInformacionFinancieraSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (informacionFinancieraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           informacionFinancieraSolicitudInfraestructuraRepository.save(informacionFinancieraSolicitudInfraestructuraDAO.informacionFinancieraSolicitudInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (informacionFinancieraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setInformacionFinancieraSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarInformacionFinancieraSolicitudInfraestructura(Long idInformacionFinancieraSolicitudInfraestructura) {
        Optional<InformacionFinancieraSolicitudInfraestructura> informacionFinancieraId = informacionFinancieraSolicitudInfraestructuraRepository.findById(idInformacionFinancieraSolicitudInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (informacionFinancieraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setInformacionFinancieraSolicitudInfraestructuraDTO(informacionFinancieraSolicitudInfraestructuraDAO.informacionFinancieraSolicitudInfraestructuraDTO(informacionFinancieraId.get()));
           informacionFinancieraSolicitudInfraestructuraRepository.delete(informacionFinancieraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (informacionFinancieraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInformacionFinancieraSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
