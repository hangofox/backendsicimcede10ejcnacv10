//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizProyPlAnAdqCdoIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqCdoIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqCdoIngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DocumentacionAnexaCotizProyPlAnAdqCdoIngDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqCdoIngRepository proyeccionPlanAnualAdqCdoIngRepository;

    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqCdoIngDAO proyeccionPlanAnualAdqCdoIngDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param documentacionAnexaCotizProyPlAnAdqCdoIngDTO
    * Recibe un DTO para crear un objeto documentacionAnexaCotizProyPlAnAdqCdoIng.
    * @return documentacionAnexaCotizProyPlAnAdqCdoIng
    */
    public DocumentacionAnexaCotizProyPlAnAdqCdoIng documentacionAnexaCotizProyPlAnAdqCdoIng(DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO documentacionAnexaCotizProyPlAnAdqCdoIngDTO){
        DocumentacionAnexaCotizProyPlAnAdqCdoIng documentacionAnexaCotizProyPlAnAdqCdoIng = new DocumentacionAnexaCotizProyPlAnAdqCdoIng();
        documentacionAnexaCotizProyPlAnAdqCdoIng.setIdDocumentacionAnexaCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getIdDocumentacionAnexaCotizProyPlAnAdqCdoIng());
        documentacionAnexaCotizProyPlAnAdqCdoIng.setNombreDocumentoAnexoCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng().toUpperCase());
        documentacionAnexaCotizProyPlAnAdqCdoIng.setNombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getNombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng());

        //MAPEAR PROYECCION PLAN ANUAL ADQ CDO ING RELACIONADA.
        if (documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO() != null && documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO().getIdProyeccionPlanAnualAdqCdoIng() != null) {
           Optional<ProyeccionPlanAnualAdqCdoIng> proyeccionPlanAnualAdqCdoIngFk = proyeccionPlanAnualAdqCdoIngRepository.findByIdProyeccionPlanAnualAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO().getIdProyeccionPlanAnualAdqCdoIng());
           proyeccionPlanAnualAdqCdoIngFk.ifPresent(documentacionAnexaCotizProyPlAnAdqCdoIng::setProyeccionPlanAnualAdqCdoIng);
        }

        return documentacionAnexaCotizProyPlAnAdqCdoIng;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param documentacionAnexaCotizProyPlAnAdqCdoIng
    * Recibe un objeto documentacionAnexaCotizProyPlAnAdqCdoIng para crear un DTO.
    * @return documentacionAnexaCotizProyPlAnAdqCdoIngDTO
    */
    public DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO documentacionAnexaCotizProyPlAnAdqCdoIngDTO(DocumentacionAnexaCotizProyPlAnAdqCdoIng documentacionAnexaCotizProyPlAnAdqCdoIng){
        DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO documentacionAnexaCotizProyPlAnAdqCdoIngDTO = new DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO();
        documentacionAnexaCotizProyPlAnAdqCdoIngDTO.setIdDocumentacionAnexaCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIng.getIdDocumentacionAnexaCotizProyPlAnAdqCdoIng());
        documentacionAnexaCotizProyPlAnAdqCdoIngDTO.setNombreDocumentoAnexoCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIng.getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng().toUpperCase());
        documentacionAnexaCotizProyPlAnAdqCdoIngDTO.setNombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIng.getNombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng());

        //MAPEAR PROYECCION PLAN ANUAL ADQ CDO ING RELACIONADA.
        if (documentacionAnexaCotizProyPlAnAdqCdoIng.getProyeccionPlanAnualAdqCdoIng() != null && documentacionAnexaCotizProyPlAnAdqCdoIng.getProyeccionPlanAnualAdqCdoIng().getIdProyeccionPlanAnualAdqCdoIng() != null) {
           Optional<ProyeccionPlanAnualAdqCdoIng> proyeccionPlanAnualAdqCdoIngFk = proyeccionPlanAnualAdqCdoIngRepository.findByIdProyeccionPlanAnualAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIng.getProyeccionPlanAnualAdqCdoIng().getIdProyeccionPlanAnualAdqCdoIng());
           proyeccionPlanAnualAdqCdoIngFk.ifPresent(proyPlAnAdqCdoIng -> documentacionAnexaCotizProyPlAnAdqCdoIngDTO.setProyeccionPlanAnualAdqCdoIngDTO(proyeccionPlanAnualAdqCdoIngDAO.proyeccionPlanAnualAdqCdoIngDTO(proyPlAnAdqCdoIng)));
        }

        return documentacionAnexaCotizProyPlAnAdqCdoIngDTO;
    }
}
