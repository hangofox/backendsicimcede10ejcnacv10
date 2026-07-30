//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DocumentacionAnexaSolicInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DocumentacionAnexaSolicInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DocumentacionAnexaSolicInfraestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class DocumentacionAnexaSolicInfraestServiceImpl implements DocumentacionAnexaSolicInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DocumentacionAnexaSolicInfraestDAO documentacionAnexaSolicInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DocumentacionAnexaSolicInfraestRepository documentacionAnexaSolicInfraestRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDocumentacionAnexaSolicInfraest, String keyword, Long idSolicitudInfraestructura) {
        return documentacionAnexaSolicInfraestRepository.findTotalRegistros(idDocumentacionAnexaSolicInfraest, keyword, idSolicitudInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR TODA LA DOCUMENTACION ANEXAS DE LAS SOLICITUDES DE INFRAESTRUCTURAS SIN PAGINACIÓN (PARA SELECTS DEL FRONTEND):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DocumentacionAnexaSolicInfraestDTO> listarDocumentacionAnexasSolicInfraest(Long idDocumentacionAnexaSolicInfraest, String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        List<DocumentacionAnexaSolicInfraest> documentacionAnexasSolicInfraests = documentacionAnexaSolicInfraestRepository.findAllDocumentacionAnexasSolicInfraest(idDocumentacionAnexaSolicInfraest, keyword, idSolicitudInfraestructura, orderBy, orderMode);
        List<DocumentacionAnexaSolicInfraestDTO> documentacionAnexaSolicInfraestDTOS = new ArrayList<>();
        for (DocumentacionAnexaSolicInfraest documentacionAnexaSolicInfraest : documentacionAnexasSolicInfraests) {
            documentacionAnexaSolicInfraestDTOS.add(documentacionAnexaSolicInfraestDAO.documentacionAnexaSolicInfraestDTO(documentacionAnexaSolicInfraest));
        }
        
        return documentacionAnexaSolicInfraestDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR/FILTRAR/ORDENAR/PAGINAR DOCUMENTACION ANEXAS DE LAS SOLICITUDES DE INFRAESTRUCTURAS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<DocumentacionAnexaSolicInfraestDTO> listarDocumentacionAnexasSolicInfraestPag(Pageable pageable, Long idDocumentacionAnexaSolicInfraest, String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        Slice<DocumentacionAnexaSolicInfraest> documentacionAnexasSolicInfraest = documentacionAnexaSolicInfraestRepository.findAllDocumentacionAnexasSolicInfraestPag(pageable, idDocumentacionAnexaSolicInfraest, keyword, idSolicitudInfraestructura, orderBy, orderMode);
        return documentacionAnexasSolicInfraest.map(documentacionAnexaSolicInfraest -> documentacionAnexaSolicInfraestDAO.documentacionAnexaSolicInfraestDTO(documentacionAnexaSolicInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDocumentacionAnexaSolicInfraest(DocumentacionAnexaSolicInfraestDTO documentacionAnexaSolicInfraestDTO) {
        Long maxIdDocumentacionAnexaSolicInfraest = documentacionAnexaSolicInfraestRepository.findMaxIdDocumentacionAnexaSolicInfraest();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        if (maxIdDocumentacionAnexaSolicInfraest == null) {
           maxIdDocumentacionAnexaSolicInfraest = Long.valueOf(0);
        }
        documentacionAnexaSolicInfraestDTO.setIdDocumentacionAnexaSolicInfraest(maxIdDocumentacionAnexaSolicInfraest + 1);
        documentacionAnexaSolicInfraestRepository.save(documentacionAnexaSolicInfraestDAO.documentacionAnexaSolicInfraest(documentacionAnexaSolicInfraestDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDocumentacionAnexaSolicInfraestporId(Long idDocumentacionAnexaSolicInfraest) {
        Optional<DocumentacionAnexaSolicInfraest> documentacionAnexaSolicInfraestId = documentacionAnexaSolicInfraestRepository.findByIdDocumentacionAnexaSolicInfraest(Long.valueOf(idDocumentacionAnexaSolicInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setDocumentacionAnexaSolicInfraestDTO(documentacionAnexaSolicInfraestDAO.documentacionAnexaSolicInfraestDTO(documentacionAnexaSolicInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (documentacionAnexaSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDocumentacionAnexaSolicInfraest(DocumentacionAnexaSolicInfraestDTO documentacionAnexaSolicInfraestDTO) {
        Optional<DocumentacionAnexaSolicInfraest> documentacionAnexaSolicInfraestId = documentacionAnexaSolicInfraestRepository.findByIdDocumentacionAnexaSolicInfraest(documentacionAnexaSolicInfraestDTO.getIdDocumentacionAnexaSolicInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (documentacionAnexaSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           documentacionAnexaSolicInfraestRepository.save(documentacionAnexaSolicInfraestDAO.documentacionAnexaSolicInfraest(documentacionAnexaSolicInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (documentacionAnexaSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDocumentacionAnexaSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDocumentacionAnexaSolicInfraest(Long idDocumentacionAnexaSolicInfraest) {
        Optional<DocumentacionAnexaSolicInfraest> documentacionAnexaSolicInfraestId = documentacionAnexaSolicInfraestRepository.findById(idDocumentacionAnexaSolicInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           documentacionAnexaSolicInfraestRepository.delete(documentacionAnexaSolicInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (documentacionAnexaSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
