//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaContratInfraestArrendDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DocumentacionAnexaContratInfraestArrendService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DocumentacionAnexaContratInfraestArrendDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaContratInfraestArrend;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DocumentacionAnexaContratInfraestArrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class DocumentacionAnexaContratInfraestArrendServiceImpl implements DocumentacionAnexaContratInfraestArrendService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DocumentacionAnexaContratInfraestArrendDAO documentacionAnexaContratInfraestArrendDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DocumentacionAnexaContratInfraestArrendRepository documentacionAnexaContratInfraestArrendRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDocumentacionAnexaContratInfraestArrend, String keyword, Long idProyeccionPlanAnualArrendamiento) {
        return documentacionAnexaContratInfraestArrendRepository.findTotalRegistros(idDocumentacionAnexaContratInfraestArrend, keyword, idProyeccionPlanAnualArrendamiento);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR TODA LA DOCUMENTACION ANEXAS DE LOS CONTRATOS DE INFRAESTRAESTRUCTURAS ARRENDADAS SIN PAGINACIÓN (PARA SELECTS DEL FRONTEND):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DocumentacionAnexaContratInfraestArrendDTO> listarDocumentacionAnexasContratInfraestArrend(Long idDocumentacionAnexaContratInfraestArrend, String keyword, Long idProyeccionPlanAnualArrendamiento, String orderBy, String orderMode) {
        List<DocumentacionAnexaContratInfraestArrend> documentacionAnexasContratInfraestArrend = documentacionAnexaContratInfraestArrendRepository.findAllDocumentacionesAnexasContratInfraestArrend(idDocumentacionAnexaContratInfraestArrend, keyword, idProyeccionPlanAnualArrendamiento, orderBy, orderMode);
        List<DocumentacionAnexaContratInfraestArrendDTO> documentacionAnexaContratInfraestArrendDTOS = new ArrayList<>();
        for (DocumentacionAnexaContratInfraestArrend documentacionAnexaContratInfraestArrend : documentacionAnexasContratInfraestArrend) {
            documentacionAnexaContratInfraestArrendDTOS.add(documentacionAnexaContratInfraestArrendDAO.documentacionAnexaContratInfraestArrendDTO(documentacionAnexaContratInfraestArrend));
        }
        
        return documentacionAnexaContratInfraestArrendDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR/FILTRAR/ORDENAR/PAGINAR DOCUMENTACION ANEXAS DE LOS CONTRATOS DE INFRAESTRAESTRUCTURAS ARRENDADAS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<DocumentacionAnexaContratInfraestArrendDTO> listarDocumentacionAnexasContratInfraestArrendPag(Pageable pageable, Long idDocumentacionAnexaContratInfraestArrend, String keyword, Long idProyeccionPlanAnualArrendamiento, String orderBy, String orderMode) {
        Slice<DocumentacionAnexaContratInfraestArrend> documentacionAnexasContratInfraestArrend = documentacionAnexaContratInfraestArrendRepository.findAllDocumentacionesAnexasContratInfraestArrendPag(pageable, idDocumentacionAnexaContratInfraestArrend, keyword, idProyeccionPlanAnualArrendamiento, orderBy, orderMode);
        return documentacionAnexasContratInfraestArrend.map(docAnexaContratInfraestArrend -> documentacionAnexaContratInfraestArrendDAO.documentacionAnexaContratInfraestArrendDTO(docAnexaContratInfraestArrend));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDocumentacionAnexaContratInfraestArrend(DocumentacionAnexaContratInfraestArrendDTO documentacionAnexaContratInfraestArrendDTO) {
        Long maxIdDocumentacionAnexaContratInfraestArrend = documentacionAnexaContratInfraestArrendRepository.findMaxIdDocumentacionAnexaContratInfraestArrend();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdDocumentacionAnexaContratInfraestArrend == null) {
           maxIdDocumentacionAnexaContratInfraestArrend = Long.valueOf(0);
        }
        documentacionAnexaContratInfraestArrendDTO.setIdDocumentacionAnexaContratInfraestArrend(maxIdDocumentacionAnexaContratInfraestArrend + 1);
        
        documentacionAnexaContratInfraestArrendRepository.save(documentacionAnexaContratInfraestArrendDAO.documentacionAnexaContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDocumentacionAnexaContratInfraestArrendporId(Long idDocumentacionAnexaContratInfraestArrend) {
        Optional<DocumentacionAnexaContratInfraestArrend> documentacionAnexaContratInfraestArrendId = documentacionAnexaContratInfraestArrendRepository.findByIdDocumentacionAnexaContratInfraestArrend(Long.valueOf(idDocumentacionAnexaContratInfraestArrend));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaContratInfraestArrendId.isPresent() == true) {
           respuestaDTO.setDocumentacionAnexaContratInfraestArrendDTO(documentacionAnexaContratInfraestArrendDAO.documentacionAnexaContratInfraestArrendDTO(documentacionAnexaContratInfraestArrendId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (documentacionAnexaContratInfraestArrendId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaContratInfraestArrendDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDocumentacionAnexaContratInfraestArrend(DocumentacionAnexaContratInfraestArrendDTO documentacionAnexaContratInfraestArrendDTO) {
        Optional<DocumentacionAnexaContratInfraestArrend> documentacionAnexaContratInfraestArrendId = documentacionAnexaContratInfraestArrendRepository.findByIdDocumentacionAnexaContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO.getIdDocumentacionAnexaContratInfraestArrend());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (documentacionAnexaContratInfraestArrendId.isPresent() == true) {
           documentacionAnexaContratInfraestArrendRepository.save(documentacionAnexaContratInfraestArrendDAO.documentacionAnexaContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (documentacionAnexaContratInfraestArrendId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDocumentacionAnexaContratInfraestArrendDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDocumentacionAnexaContratInfraestArrend(Long idDocumentacionAnexaContratInfraestArrend) {
        Optional<DocumentacionAnexaContratInfraestArrend> documentacionAnexaContratInfraestArrendId = documentacionAnexaContratInfraestArrendRepository.findById(idDocumentacionAnexaContratInfraestArrend);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaContratInfraestArrendId.isPresent() == true) {
           respuestaDTO.setDocumentacionAnexaContratInfraestArrendDTO(documentacionAnexaContratInfraestArrendDAO.documentacionAnexaContratInfraestArrendDTO(documentacionAnexaContratInfraestArrendId.get()));
           documentacionAnexaContratInfraestArrendRepository.delete(documentacionAnexaContratInfraestArrendId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (documentacionAnexaContratInfraestArrendId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaContratInfraestArrendDTO(null);
        }
        
        return respuestaDTO;
    }
}
