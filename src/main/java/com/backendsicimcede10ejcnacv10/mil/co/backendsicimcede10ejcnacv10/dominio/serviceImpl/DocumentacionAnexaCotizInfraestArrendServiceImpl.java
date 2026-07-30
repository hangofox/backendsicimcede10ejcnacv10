//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaCotizInfraestArrendDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DocumentacionAnexaCotizInfraestArrendService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DocumentacionAnexaCotizInfraestArrendDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizInfraestArrend;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DocumentacionAnexaCotizInfraestArrendRepository;
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
public class DocumentacionAnexaCotizInfraestArrendServiceImpl implements DocumentacionAnexaCotizInfraestArrendService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DocumentacionAnexaCotizInfraestArrendDAO documentacionAnexaCotizInfraestArrendDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DocumentacionAnexaCotizInfraestArrendRepository documentacionAnexaCotizInfraestArrendRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDocumentacionAnexaCotizInfraestArrend, String keyword, Long idProyeccionPlanAnualArrendamiento) {
        return documentacionAnexaCotizInfraestArrendRepository.findTotalRegistros(idDocumentacionAnexaCotizInfraestArrend, keyword, idProyeccionPlanAnualArrendamiento);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR TODA LA DOCUMENTACION ANEXAS DE LAS COTIZACIONES DE LAS INFRAESTRUCTURAS ARRENDADAS SIN PAGINACIÓN (PARA SELECTS DEL FRONTEND):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DocumentacionAnexaCotizInfraestArrendDTO> listarDocumentacionAnexasCotizInfraestArrend(Long idDocumentacionAnexaCotizInfraestArrend, String keyword, Long idProyeccionPlanAnualArrendamiento, String orderBy, String orderMode) {
        List<DocumentacionAnexaCotizInfraestArrend> documentacionAnexasCotizInfraestArrend = documentacionAnexaCotizInfraestArrendRepository.findAllDocumentacionesAnexasCotizInfraestArrend(idDocumentacionAnexaCotizInfraestArrend, keyword, idProyeccionPlanAnualArrendamiento, orderBy, orderMode);
        List<DocumentacionAnexaCotizInfraestArrendDTO> documentacionAnexaCotizInfraestArrendDTOS = new ArrayList<>();
        for (DocumentacionAnexaCotizInfraestArrend documentacionAnexaCotizInfraestArrend : documentacionAnexasCotizInfraestArrend) {
            documentacionAnexaCotizInfraestArrendDTOS.add(documentacionAnexaCotizInfraestArrendDAO.documentacionAnexaCotizInfraestArrendDTO(documentacionAnexaCotizInfraestArrend));
        }
        
        return documentacionAnexaCotizInfraestArrendDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR/FILTRAR/ORDENAR/PAGINAR DOCUMENTACION ANEXAS DE LAS COTIZACIONES DE LAS INFRAESTRUCTURAS ARRENDADAS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<DocumentacionAnexaCotizInfraestArrendDTO> listarDocumentacionAnexasCotizInfraestArrendPag(Pageable pageable, Long idDocumentacionAnexaCotizInfraestArrend, String keyword, Long idProyeccionPlanAnualArrendamiento, String orderBy, String orderMode) {
        Slice<DocumentacionAnexaCotizInfraestArrend> documentacionAnexasCotizInfraestArrend = documentacionAnexaCotizInfraestArrendRepository.findAllDocumentacionesAnexasCotizInfraestArrendPag(pageable, idDocumentacionAnexaCotizInfraestArrend, keyword, idProyeccionPlanAnualArrendamiento, orderBy, orderMode);
        return documentacionAnexasCotizInfraestArrend.map(docAnexaCotizInfraestArrend -> documentacionAnexaCotizInfraestArrendDAO.documentacionAnexaCotizInfraestArrendDTO(docAnexaCotizInfraestArrend));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDocumentacionAnexaCotizInfraestArrend(DocumentacionAnexaCotizInfraestArrendDTO documentacionAnexaCotizInfraestArrendDTO) {
        Long maxIdDocumentacionAnexaCotizInfraestArrend = documentacionAnexaCotizInfraestArrendRepository.findMaxIdDocumentacionAnexaCotizInfraestArrend();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdDocumentacionAnexaCotizInfraestArrend == null) {
           maxIdDocumentacionAnexaCotizInfraestArrend = Long.valueOf(0);
        }
        documentacionAnexaCotizInfraestArrendDTO.setIdDocumentacionAnexaCotizInfraestArrend(maxIdDocumentacionAnexaCotizInfraestArrend + 1);
        
        documentacionAnexaCotizInfraestArrendRepository.save(documentacionAnexaCotizInfraestArrendDAO.documentacionAnexaCotizInfraestArrend(documentacionAnexaCotizInfraestArrendDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDocumentacionAnexaCotizInfraestArrendporId(Long idDocumentacionAnexaCotizInfraestArrend) {
        Optional<DocumentacionAnexaCotizInfraestArrend> documentacionAnexaCotizInfraestArrendId = documentacionAnexaCotizInfraestArrendRepository.findByIdDocumentacionAnexaCotizInfraestArrend(Long.valueOf(idDocumentacionAnexaCotizInfraestArrend));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaCotizInfraestArrendId.isPresent() == true) {
           respuestaDTO.setDocumentacionAnexaCotizInfraestArrendDTO(documentacionAnexaCotizInfraestArrendDAO.documentacionAnexaCotizInfraestArrendDTO(documentacionAnexaCotizInfraestArrendId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (documentacionAnexaCotizInfraestArrendId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaCotizInfraestArrendDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDocumentacionAnexaCotizInfraestArrend(DocumentacionAnexaCotizInfraestArrendDTO documentacionAnexaCotizInfraestArrendDTO) {
        Optional<DocumentacionAnexaCotizInfraestArrend> documentacionAnexaCotizInfraestArrendId = documentacionAnexaCotizInfraestArrendRepository.findByIdDocumentacionAnexaCotizInfraestArrend(documentacionAnexaCotizInfraestArrendDTO.getIdDocumentacionAnexaCotizInfraestArrend());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (documentacionAnexaCotizInfraestArrendId.isPresent() == true) {
           documentacionAnexaCotizInfraestArrendRepository.save(documentacionAnexaCotizInfraestArrendDAO.documentacionAnexaCotizInfraestArrend(documentacionAnexaCotizInfraestArrendDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (documentacionAnexaCotizInfraestArrendId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDocumentacionAnexaCotizInfraestArrendDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDocumentacionAnexaCotizInfraestArrend(Long idDocumentacionAnexaCotizInfraestArrend) {
        Optional<DocumentacionAnexaCotizInfraestArrend> documentacionAnexaCotizInfraestArrendId = documentacionAnexaCotizInfraestArrendRepository.findById(idDocumentacionAnexaCotizInfraestArrend);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaCotizInfraestArrendId.isPresent() == true) {
           respuestaDTO.setDocumentacionAnexaCotizInfraestArrendDTO(documentacionAnexaCotizInfraestArrendDAO.documentacionAnexaCotizInfraestArrendDTO(documentacionAnexaCotizInfraestArrendId.get()));
           documentacionAnexaCotizInfraestArrendRepository.delete(documentacionAnexaCotizInfraestArrendId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (documentacionAnexaCotizInfraestArrendId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaCotizInfraestArrendDTO(null);
        }
        
        return respuestaDTO;
    }
}
