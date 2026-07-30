//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaBajaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaBajaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoBajaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoAnexoBajaEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DocumentacionAnexaBajaEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoAnexoBajaEquipoIngenieroRepository tipoDocumentoAnexoBajaEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoAnexoBajaEquipoIngenieroDAO tipoDocumentoAnexoBajaEquipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param documentacionAnexaBajaEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto documentacionAnexaBajaEquipoIngeniero.
    * @return documentacionAnexaBajaEquipoIngeniero
    */
    public DocumentacionAnexaBajaEquipoIngeniero documentacionAnexaBajaEquipoIngeniero(DocumentacionAnexaBajaEquipoIngenieroDTO documentacionAnexaBajaEquipoIngenieroDTO){
        DocumentacionAnexaBajaEquipoIngeniero documentacionAnexaBajaEquipoIngeniero = new DocumentacionAnexaBajaEquipoIngeniero();
        documentacionAnexaBajaEquipoIngeniero.setIdDocumentacionAnexaBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO.getIdDocumentacionAnexaBajaEquipoIngeniero());
        documentacionAnexaBajaEquipoIngeniero.setNombreDocumentoAnexoBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO.getNombreDocumentoAnexoBajaEquipoIngeniero().toUpperCase());
        documentacionAnexaBajaEquipoIngeniero.setNombreArchivoDocumentoAnexoBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO.getNombreArchivoDocumentoAnexoBajaEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaBajaEquipoIngenieroDTO.getEquipoIngenieroDTO() != null && documentacionAnexaBajaEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(documentacionAnexaBajaEquipoIngeniero::setEquipoIngeniero);
        }
        
        //MAPEAR TIPO DE DOCUMENTO ANEXO DE BAJA DE EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaBajaEquipoIngenieroDTO.getTipoDocumentoAnexoBajaEquipoIngenieroDTO() != null && documentacionAnexaBajaEquipoIngenieroDTO.getTipoDocumentoAnexoBajaEquipoIngenieroDTO().getIdTipoDocumentoAnexoBajaEquipoIngeniero() != null) {
           Optional<TipoDocumentoAnexoBajaEquipoIngeniero> tipoDocumentoAnexoBajaEquipoIngenieroFk = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO.getTipoDocumentoAnexoBajaEquipoIngenieroDTO().getIdTipoDocumentoAnexoBajaEquipoIngeniero());
           tipoDocumentoAnexoBajaEquipoIngenieroFk.ifPresent(documentacionAnexaBajaEquipoIngeniero::setTipoDocumentoAnexoBajaEquipoIngeniero);
        }
        
        return documentacionAnexaBajaEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param documentacionAnexaBajaEquipoIngeniero
    * Recibe un objeto documentacionAnexaBajaEquipoIngeniero para crear un DTO.
    * @return documentacionAnexaBajaEquipoIngenieroDTO
    */
    public DocumentacionAnexaBajaEquipoIngenieroDTO documentacionAnexaBajaEquipoIngenieroDTO(DocumentacionAnexaBajaEquipoIngeniero documentacionAnexaBajaEquipoIngeniero){
        DocumentacionAnexaBajaEquipoIngenieroDTO documentacionAnexaBajaEquipoIngenieroDTO = new DocumentacionAnexaBajaEquipoIngenieroDTO();
        documentacionAnexaBajaEquipoIngenieroDTO.setIdDocumentacionAnexaBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngeniero.getIdDocumentacionAnexaBajaEquipoIngeniero());
        documentacionAnexaBajaEquipoIngenieroDTO.setNombreDocumentoAnexoBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngeniero.getNombreDocumentoAnexoBajaEquipoIngeniero().toUpperCase());
        documentacionAnexaBajaEquipoIngenieroDTO.setNombreArchivoDocumentoAnexoBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngeniero.getNombreArchivoDocumentoAnexoBajaEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaBajaEquipoIngeniero.getEquipoIngeniero() != null && documentacionAnexaBajaEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(documentacionAnexaBajaEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(equipIng -> documentacionAnexaBajaEquipoIngenieroDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipIng)));
        }
        
        //MAPEAR TIPO DE DOCUMENTO ANEXO DE BAJA DE EQUIPO DE INGENIERO RELACIONADO.
        if (documentacionAnexaBajaEquipoIngeniero.getTipoDocumentoAnexoBajaEquipoIngeniero() != null && documentacionAnexaBajaEquipoIngeniero.getTipoDocumentoAnexoBajaEquipoIngeniero().getIdTipoDocumentoAnexoBajaEquipoIngeniero() != null) {
           Optional<TipoDocumentoAnexoBajaEquipoIngeniero> tipoDocumentoAnexoBajaEquipoIngenieroFk = tipoDocumentoAnexoBajaEquipoIngenieroRepository.findByIdTipoDocumentoAnexoBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngeniero.getTipoDocumentoAnexoBajaEquipoIngeniero().getIdTipoDocumentoAnexoBajaEquipoIngeniero());
           tipoDocumentoAnexoBajaEquipoIngenieroFk.ifPresent(tipoDocAnexo -> documentacionAnexaBajaEquipoIngenieroDTO.setTipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocumentoAnexoBajaEquipoIngenieroDAO.tipoDocumentoAnexoBajaEquipoIngenieroDTO(tipoDocAnexo)));
        }
        
        return documentacionAnexaBajaEquipoIngenieroDTO;
    }
}
