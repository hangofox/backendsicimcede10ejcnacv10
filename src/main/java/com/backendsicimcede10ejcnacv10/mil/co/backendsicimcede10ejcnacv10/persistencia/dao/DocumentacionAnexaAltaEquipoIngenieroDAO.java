//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaAltaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaAltaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoAltaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoAnexoAltaEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DocumentacionAnexaAltaEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoAnexoAltaEquipoIngenieroRepository tipoDocumentoAnexoAltaEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoAnexoAltaEquipoIngenieroDAO tipoDocumentoAnexoAltaEquipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param documentacionAnexaAltaEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto documentacionAnexaAltaEquipoIngeniero.
    * @return documentacionAnexaAltaEquipoIngeniero
    */
    public DocumentacionAnexaAltaEquipoIngeniero documentacionAnexaAltaEquipoIngeniero(DocumentacionAnexaAltaEquipoIngenieroDTO documentacionAnexaAltaEquipoIngenieroDTO){
        DocumentacionAnexaAltaEquipoIngeniero documentacionAnexaAltaEquipoIngeniero = new DocumentacionAnexaAltaEquipoIngeniero();
        documentacionAnexaAltaEquipoIngeniero.setIdDocumentacionAnexaAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO.getIdDocumentacionAnexaAltaEquipoIngeniero());
        documentacionAnexaAltaEquipoIngeniero.setNombreDocumentoAnexoAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO.getNombreDocumentoAnexoAltaEquipoIngeniero().toUpperCase());
        documentacionAnexaAltaEquipoIngeniero.setNombreArchivoDocumentoAnexoAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO.getNombreArchivoDocumentoAnexoAltaEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaAltaEquipoIngenieroDTO.getEquipoIngenieroDTO() != null && documentacionAnexaAltaEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(documentacionAnexaAltaEquipoIngeniero::setEquipoIngeniero);
        }
        
        //MAPEAR TIPO DE DOCUMENTO ANEXO ALTA EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaAltaEquipoIngenieroDTO.getTipoDocumentoAnexoAltaEquipoIngenieroDTO() != null && documentacionAnexaAltaEquipoIngenieroDTO.getTipoDocumentoAnexoAltaEquipoIngenieroDTO().getIdTipoDocumentoAnexoAltaEquipoIngeniero() != null) {
           Optional<TipoDocumentoAnexoAltaEquipoIngeniero> tipoDocumentoAnexoAltaEquipoIngenieroFk = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO.getTipoDocumentoAnexoAltaEquipoIngenieroDTO().getIdTipoDocumentoAnexoAltaEquipoIngeniero());
           tipoDocumentoAnexoAltaEquipoIngenieroFk.ifPresent(documentacionAnexaAltaEquipoIngeniero::setTipoDocumentoAnexoAltaEquipoIngeniero);
        }
        
        return documentacionAnexaAltaEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param documentacionAnexaAltaEquipoIngeniero
    * Recibe un objeto documentacionAnexaAltaEquipoIngeniero para crear un DTO.
    * @return documentacionAnexaAltaEquipoIngenieroDTO
    */
    public DocumentacionAnexaAltaEquipoIngenieroDTO documentacionAnexaAltaEquipoIngenieroDTO(DocumentacionAnexaAltaEquipoIngeniero documentacionAnexaAltaEquipoIngeniero){
        DocumentacionAnexaAltaEquipoIngenieroDTO documentacionAnexaAltaEquipoIngenieroDTO = new DocumentacionAnexaAltaEquipoIngenieroDTO();
        documentacionAnexaAltaEquipoIngenieroDTO.setIdDocumentacionAnexaAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngeniero.getIdDocumentacionAnexaAltaEquipoIngeniero());
        documentacionAnexaAltaEquipoIngenieroDTO.setNombreDocumentoAnexoAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngeniero.getNombreDocumentoAnexoAltaEquipoIngeniero().toUpperCase());
        documentacionAnexaAltaEquipoIngenieroDTO.setNombreArchivoDocumentoAnexoAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngeniero.getNombreArchivoDocumentoAnexoAltaEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaAltaEquipoIngeniero.getEquipoIngeniero() != null && documentacionAnexaAltaEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(documentacionAnexaAltaEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(equipIng -> documentacionAnexaAltaEquipoIngenieroDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipIng)));
        }
        
        //MAPEAR TIPO DE DOCUMENTO ANEXO DE ALTA EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaAltaEquipoIngeniero.getTipoDocumentoAnexoAltaEquipoIngeniero() != null && documentacionAnexaAltaEquipoIngeniero.getTipoDocumentoAnexoAltaEquipoIngeniero().getIdTipoDocumentoAnexoAltaEquipoIngeniero() != null) {
           Optional<TipoDocumentoAnexoAltaEquipoIngeniero> tipoDocumentoAnexoAltaEquipoIngenieroFk = tipoDocumentoAnexoAltaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngeniero.getTipoDocumentoAnexoAltaEquipoIngeniero().getIdTipoDocumentoAnexoAltaEquipoIngeniero());
           tipoDocumentoAnexoAltaEquipoIngenieroFk.ifPresent(tipoDocAnexo -> documentacionAnexaAltaEquipoIngenieroDTO.setTipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocumentoAnexoAltaEquipoIngenieroDAO.tipoDocumentoAnexoAltaEquipoIngenieroDTO(tipoDocAnexo)));
        }
        
        return documentacionAnexaAltaEquipoIngenieroDTO;
    }
}
