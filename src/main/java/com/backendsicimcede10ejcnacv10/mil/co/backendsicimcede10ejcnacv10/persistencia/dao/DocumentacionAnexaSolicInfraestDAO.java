//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoAnexoSolicInfraestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DocumentacionAnexaSolicInfraestDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SolicitudInfraestructuraDAO solicitudInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoAnexoSolicInfraestRepository tipoDocumentoAnexoSolicInfraestRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoAnexoSolicInfraestDAO tipoDocumentoAnexoSolicInfraestDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param documentacionAnexaSolicInfraestDTO
    * Recibe un DTO para crear un objeto documentacionAnexaSolicInfraest.
    * @return documentacionAnexaSolicInfraest
    */
    public DocumentacionAnexaSolicInfraest documentacionAnexaSolicInfraest(DocumentacionAnexaSolicInfraestDTO documentacionAnexaSolicInfraestDTO){
        DocumentacionAnexaSolicInfraest documentacionAnexaSolicInfraest = new DocumentacionAnexaSolicInfraest();
        documentacionAnexaSolicInfraest.setIdDocumentacionAnexaSolicInfraest(documentacionAnexaSolicInfraestDTO.getIdDocumentacionAnexaSolicInfraest());
        documentacionAnexaSolicInfraest.setNombreDocumentoAnexoSolicInfraest(documentacionAnexaSolicInfraestDTO.getNombreDocumentoAnexoSolicInfraest().toUpperCase());
        documentacionAnexaSolicInfraest.setNombreArchivoDocumentoAnexoSolicInfraest(documentacionAnexaSolicInfraestDTO.getNombreArchivoDocumentoAnexoSolicInfraest());
        
        //MAPEAR SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (documentacionAnexaSolicInfraestDTO.getSolicitudInfraestructuraDTO() != null && documentacionAnexaSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(documentacionAnexaSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(documentacionAnexaSolicInfraest::setSolicitudInfraestructura);
        }
        
        //MAPEAR TIPO DOCUMENTO ANEXO DE SOLICITUD DE INFRAESTRUCTURA RELACIONADO.
        if (documentacionAnexaSolicInfraestDTO.getTipoDocumentoAnexoSolicInfraestDTO() != null && documentacionAnexaSolicInfraestDTO.getTipoDocumentoAnexoSolicInfraestDTO().getIdTipoDocumentoAnexoSolicInfraest() != null) {
           Optional<TipoDocumentoAnexoSolicInfraest> tipoDocumentoAnexoSolicInfraestFk = tipoDocumentoAnexoSolicInfraestRepository.findByIdTipoDocumentoAnexoSolicInfraest(documentacionAnexaSolicInfraestDTO.getTipoDocumentoAnexoSolicInfraestDTO().getIdTipoDocumentoAnexoSolicInfraest());
           tipoDocumentoAnexoSolicInfraestFk.ifPresent(documentacionAnexaSolicInfraest::setTipoDocumentoAnexoSolicInfraest);
        }
        
        return documentacionAnexaSolicInfraest;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param documentacionAnexaSolicInfraest
    * Recibe un objeto documentacionAnexaSolicInfraest para crear un DTO.
    * @return documentacionAnexaSolicInfraestDTO
    */
    public DocumentacionAnexaSolicInfraestDTO documentacionAnexaSolicInfraestDTO(DocumentacionAnexaSolicInfraest documentacionAnexaSolicInfraest){
        DocumentacionAnexaSolicInfraestDTO documentacionAnexaSolicInfraestDTO = new DocumentacionAnexaSolicInfraestDTO();
        documentacionAnexaSolicInfraestDTO.setIdDocumentacionAnexaSolicInfraest(documentacionAnexaSolicInfraest.getIdDocumentacionAnexaSolicInfraest());
        documentacionAnexaSolicInfraestDTO.setNombreDocumentoAnexoSolicInfraest(documentacionAnexaSolicInfraest.getNombreDocumentoAnexoSolicInfraest().toUpperCase());
        documentacionAnexaSolicInfraestDTO.setNombreArchivoDocumentoAnexoSolicInfraest(documentacionAnexaSolicInfraest.getNombreArchivoDocumentoAnexoSolicInfraest());
        
        //MAPEAR SOLICITUD DE INFRAESTRUCTURA RELACIONADA.
        if (documentacionAnexaSolicInfraest.getSolicitudInfraestructura() != null && documentacionAnexaSolicInfraest.getSolicitudInfraestructura().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(documentacionAnexaSolicInfraest.getSolicitudInfraestructura().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(solicInfra -> documentacionAnexaSolicInfraestDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicInfra)));
        }
        
        //MAPEAR TIPO DOCUMENTO ANEXO DE SOLICITUD DE INFRAESTRUCTURA RELACIONADO.
        if (documentacionAnexaSolicInfraest.getTipoDocumentoAnexoSolicInfraest() != null && documentacionAnexaSolicInfraest.getTipoDocumentoAnexoSolicInfraest().getIdTipoDocumentoAnexoSolicInfraest() != null) {
           Optional<TipoDocumentoAnexoSolicInfraest> tipoDocumentoAnexoSolicInfraestFk = tipoDocumentoAnexoSolicInfraestRepository.findByIdTipoDocumentoAnexoSolicInfraest(documentacionAnexaSolicInfraest.getTipoDocumentoAnexoSolicInfraest().getIdTipoDocumentoAnexoSolicInfraest());
           tipoDocumentoAnexoSolicInfraestFk.ifPresent(tipoDocAnexo -> documentacionAnexaSolicInfraestDTO.setTipoDocumentoAnexoSolicInfraestDTO(tipoDocumentoAnexoSolicInfraestDAO.tipoDocumentoAnexoSolicInfraestDTO(tipoDocAnexo)));
        }
        
        return documentacionAnexaSolicInfraestDTO;
    }
}
