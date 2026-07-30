//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesSolicitudesInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.IntegrantesSolicitudesInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.IntegrantesSolicitudesInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesSolicitudesInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.IntegrantesSolicitudesInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
public class IntegrantesSolicitudesInfraestructuraServiceImpl implements IntegrantesSolicitudesInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private IntegrantesSolicitudesInfraestructuraDAO integrantesSolicitudesInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private IntegrantesSolicitudesInfraestructuraRepository integrantesSolicitudesInfraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idIntegrantesSolicitudesInfraestructura, Long idSolicitudInfraestructura) {
        return integrantesSolicitudesInfraestructuraRepository.findTotalRegistros(idIntegrantesSolicitudesInfraestructura, idSolicitudInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<IntegrantesSolicitudesInfraestructuraDTO> listarIntegrantesSolicitudesInfraestructuras(Long idIntegrantesSolicitudesInfraestructura, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        List<IntegrantesSolicitudesInfraestructura> integrantesSolicitudesInfraestructuras = integrantesSolicitudesInfraestructuraRepository.findAllIntegrantesSolicitudesInfraestructuras(idIntegrantesSolicitudesInfraestructura, idSolicitudInfraestructura, orderBy, orderMode);
        List<IntegrantesSolicitudesInfraestructuraDTO> integrantesSolicitudesInfraestructuraDTOS = new ArrayList<>();
        for (IntegrantesSolicitudesInfraestructura integrantesSolicitudesInfraestructura : integrantesSolicitudesInfraestructuras) {
            integrantesSolicitudesInfraestructuraDTOS.add(integrantesSolicitudesInfraestructuraDAO.integrantesSolicitudesInfraestructuraDTO(integrantesSolicitudesInfraestructura));
        }
        
        return integrantesSolicitudesInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<IntegrantesSolicitudesInfraestructuraDTO> listarIntegrantesSolicitudesInfraestructurasPag(Pageable pageable, Long idIntegrantesSolicitudesInfraestructura, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        Slice<IntegrantesSolicitudesInfraestructura> integrantesSolicitudesInfraestructuras = integrantesSolicitudesInfraestructuraRepository.findAllIntegrantesSolicitudesInfraestructurasPag(pageable, idIntegrantesSolicitudesInfraestructura, idSolicitudInfraestructura, orderBy, orderMode);
        return integrantesSolicitudesInfraestructuras.map(integrantesSolicitudesInfraestructura -> integrantesSolicitudesInfraestructuraDAO.integrantesSolicitudesInfraestructuraDTO(integrantesSolicitudesInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearIntegrantesSolicitudesInfraestructura(IntegrantesSolicitudesInfraestructuraDTO integrantesSolicitudesInfraestructuraDTO) {
        Long maxIdIntegrantesSolicitudesInfraestructura = null;
        IntegrantesSolicitudesInfraestructura integrantesExistentesEnSolicitudInfraestructura = integrantesSolicitudesInfraestructuraRepository.findBySolicitudInfraestructuraId(integrantesSolicitudesInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(integrantesExistentesEnSolicitudInfraestructura == null)) {//SI YA EXISTE UN REGISTRO DE INTEGRANTES PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE INTEGRANTES PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_INTEGRANTES_YA_EXISTE_EN_SOLICITUD_INFRAESTRUCTURA, false);
           respuestaDTO.setIntegrantesSolicitudesInfraestructuraDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE INTEGRANTES PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdIntegrantesSolicitudesInfraestructura = integrantesSolicitudesInfraestructuraRepository.findMaxIdIntegrantesSolicitudesInfraestructura();
           if (maxIdIntegrantesSolicitudesInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdIntegrantesSolicitudesInfraestructura = Long.valueOf(0);
           }
           integrantesSolicitudesInfraestructuraDTO.setIdIntegrantesSolicitudesInfraestructura(maxIdIntegrantesSolicitudesInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           integrantesSolicitudesInfraestructuraRepository.save(integrantesSolicitudesInfraestructuraDAO.integrantesSolicitudesInfraestructura(integrantesSolicitudesInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarIntegrantesSolicitudesInfraestructuraporId(Long idIntegrantesSolicitudesInfraestructura) {
        Optional<IntegrantesSolicitudesInfraestructura> integrantesSolicitudesInfraestructuraId = integrantesSolicitudesInfraestructuraRepository.findByIdIntegrantesSolicitudesInfraestructura(Long.valueOf(idIntegrantesSolicitudesInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (integrantesSolicitudesInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setIntegrantesSolicitudesInfraestructuraDTO(integrantesSolicitudesInfraestructuraDAO.integrantesSolicitudesInfraestructuraDTO(integrantesSolicitudesInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (integrantesSolicitudesInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setIntegrantesSolicitudesInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarIntegrantesSolicitudesInfraestructura(IntegrantesSolicitudesInfraestructuraDTO integrantesSolicitudesInfraestructuraDTO) {
        Optional<IntegrantesSolicitudesInfraestructura> integrantesSolicitudesInfraestructuraId = integrantesSolicitudesInfraestructuraRepository.findByIdIntegrantesSolicitudesInfraestructura(integrantesSolicitudesInfraestructuraDTO.getIdIntegrantesSolicitudesInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (integrantesSolicitudesInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           integrantesSolicitudesInfraestructuraRepository.save(integrantesSolicitudesInfraestructuraDAO.integrantesSolicitudesInfraestructura(integrantesSolicitudesInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (integrantesSolicitudesInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setIntegrantesSolicitudesInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarIntegrantesSolicitudesInfraestructura(Long idIntegrantesSolicitudesInfraestructura) {
        Optional<IntegrantesSolicitudesInfraestructura> integrantesSolicitudesInfraestructuraId = integrantesSolicitudesInfraestructuraRepository.findById(idIntegrantesSolicitudesInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (integrantesSolicitudesInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setIntegrantesSolicitudesInfraestructuraDTO(integrantesSolicitudesInfraestructuraDAO.integrantesSolicitudesInfraestructuraDTO(integrantesSolicitudesInfraestructuraId.get()));
           integrantesSolicitudesInfraestructuraRepository.delete(integrantesSolicitudesInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (integrantesSolicitudesInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setIntegrantesSolicitudesInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
