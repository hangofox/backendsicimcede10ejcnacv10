//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FotografiaAnexaSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.FotografiaAnexaSolicInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.FotografiaAnexaSolicInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.FotografiaAnexaSolicInfraestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class FotografiaAnexaSolicInfraestServiceImpl implements FotografiaAnexaSolicInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private FotografiaAnexaSolicInfraestDAO fotografiaAnexaSolicInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private FotografiaAnexaSolicInfraestRepository fotografiaAnexaSolicInfraestRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idFotografiasAnexasSolicInfraest, Long idSolicitudInfraestructura) {
        return fotografiaAnexaSolicInfraestRepository.findTotalRegistros(idFotografiasAnexasSolicInfraest, idSolicitudInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<FotografiaAnexaSolicInfraestDTO> listarFotografiasAnexasSolicInfraest(Long idFotografiasAnexasSolicInfraest, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        List<FotografiaAnexaSolicInfraest> fotografiasAnexasSolicInfraest = fotografiaAnexaSolicInfraestRepository.findAllFotografiasAnexasSolicInfraest(idFotografiasAnexasSolicInfraest, idSolicitudInfraestructura, orderBy, orderMode);
        List<FotografiaAnexaSolicInfraestDTO> fotografiaAnexaSolicInfraestDTOS = new ArrayList<>();
        for (FotografiaAnexaSolicInfraest fotografiaAnexaSolicInfraest : fotografiasAnexasSolicInfraest) {
            fotografiaAnexaSolicInfraestDTOS.add(fotografiaAnexaSolicInfraestDAO.fotografiaAnexaSolicInfraestDTO(fotografiaAnexaSolicInfraest));
        }
        
        return fotografiaAnexaSolicInfraestDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<FotografiaAnexaSolicInfraestDTO> listarFotografiasAnexasSolicInfraestPag(Pageable pageable, Long idFotografiasAnexasSolicInfraest, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        Slice<FotografiaAnexaSolicInfraest> fotografiasAnexasSolicInfraest = fotografiaAnexaSolicInfraestRepository.findAllFotografiasAnexasSolicInfraestPag(pageable, idFotografiasAnexasSolicInfraest, idSolicitudInfraestructura, orderBy, orderMode);
        return fotografiasAnexasSolicInfraest.map(fotografiaAnexaSolicInfraest -> fotografiaAnexaSolicInfraestDAO.fotografiaAnexaSolicInfraestDTO(fotografiaAnexaSolicInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearFotografiaAnexaSolicInfraest(FotografiaAnexaSolicInfraestDTO fotografiaAnexaSolicInfraestDTO) {
        Long maxIdFotografiasAnexasSolicInfraest = null;
        FotografiaAnexaSolicInfraest fotografiaAnexaExistenteEnSolicitudInfraestructura = fotografiaAnexaSolicInfraestRepository.findBySolicitudInfraestructuraId(fotografiaAnexaSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(fotografiaAnexaExistenteEnSolicitudInfraestructura == null)) {//SI YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_FOTOGRAFIA_ANEXA_YA_EXISTE_EN_SOLICITUD_INFRAESTRUCTURA, false);
           respuestaDTO.setFotografiaAnexaSolicInfraestDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdFotografiasAnexasSolicInfraest = fotografiaAnexaSolicInfraestRepository.findMaxIdFotografiasAnexasSolicInfraest();
           if (maxIdFotografiasAnexasSolicInfraest == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdFotografiasAnexasSolicInfraest = Long.valueOf(0);
           }
           fotografiaAnexaSolicInfraestDTO.setIdFotografiasAnexasSolicInfraest(maxIdFotografiasAnexasSolicInfraest + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           fotografiaAnexaSolicInfraestRepository.save(fotografiaAnexaSolicInfraestDAO.fotografiaAnexaSolicInfraest(fotografiaAnexaSolicInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarFotografiaAnexaSolicInfraestporId(Long idFotografiasAnexasSolicInfraest) {
        Optional<FotografiaAnexaSolicInfraest> fotografiaAnexaSolicInfraestId = fotografiaAnexaSolicInfraestRepository.findByIdFotografiasAnexasSolicInfraest(Long.valueOf(idFotografiasAnexasSolicInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (fotografiaAnexaSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setFotografiaAnexaSolicInfraestDTO(fotografiaAnexaSolicInfraestDAO.fotografiaAnexaSolicInfraestDTO(fotografiaAnexaSolicInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (fotografiaAnexaSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFotografiaAnexaSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarFotografiaAnexaSolicInfraest(FotografiaAnexaSolicInfraestDTO fotografiaAnexaSolicInfraestDTO) {
        Optional<FotografiaAnexaSolicInfraest> fotografiaAnexaSolicInfraestId = fotografiaAnexaSolicInfraestRepository.findByIdFotografiasAnexasSolicInfraest(fotografiaAnexaSolicInfraestDTO.getIdFotografiasAnexasSolicInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (fotografiaAnexaSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           fotografiaAnexaSolicInfraestRepository.save(fotografiaAnexaSolicInfraestDAO.fotografiaAnexaSolicInfraest(fotografiaAnexaSolicInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (fotografiaAnexaSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setFotografiaAnexaSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarFotografiaAnexaSolicInfraest(Long idFotografiasAnexasSolicInfraest) {
        Optional<FotografiaAnexaSolicInfraest> fotografiaAnexaSolicInfraestId = fotografiaAnexaSolicInfraestRepository.findById(idFotografiasAnexasSolicInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (fotografiaAnexaSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setFotografiaAnexaSolicInfraestDTO(fotografiaAnexaSolicInfraestDAO.fotografiaAnexaSolicInfraestDTO(fotografiaAnexaSolicInfraestId.get()));
           fotografiaAnexaSolicInfraestRepository.delete(fotografiaAnexaSolicInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (fotografiaAnexaSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFotografiaAnexaSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
