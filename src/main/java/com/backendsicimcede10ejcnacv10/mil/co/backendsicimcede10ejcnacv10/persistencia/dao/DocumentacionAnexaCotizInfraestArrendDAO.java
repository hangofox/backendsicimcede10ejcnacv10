//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaCotizInfraestArrendDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizInfraestArrend;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualArrendamiento;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualArrendamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DocumentacionAnexaCotizInfraestArrendDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualArrendamientoRepository proyeccionPlanAnualArrendamientoRepository;

    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualArrendamientoDAO proyeccionPlanAnualArrendamientoDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param documentacionAnexaCotizInfraestArrendDTO
    * Recibe un DTO para crear un objeto documentacionAnexaCotizInfraestArrend.
    * @return documentacionAnexaCotizInfraestArrend
    */
    public DocumentacionAnexaCotizInfraestArrend documentacionAnexaCotizInfraestArrend(DocumentacionAnexaCotizInfraestArrendDTO documentacionAnexaCotizInfraestArrendDTO){
        DocumentacionAnexaCotizInfraestArrend documentacionAnexaCotizInfraestArrend = new DocumentacionAnexaCotizInfraestArrend();
        documentacionAnexaCotizInfraestArrend.setIdDocumentacionAnexaCotizInfraestArrend(documentacionAnexaCotizInfraestArrendDTO.getIdDocumentacionAnexaCotizInfraestArrend());
        documentacionAnexaCotizInfraestArrend.setNombreDocumentoAnexoCotizInfraestArrend(documentacionAnexaCotizInfraestArrendDTO.getNombreDocumentoAnexoCotizInfraestArrend().toUpperCase());
        documentacionAnexaCotizInfraestArrend.setNombreArchivoDocumentoAnexoCotizInfraestArrend(documentacionAnexaCotizInfraestArrendDTO.getNombreArchivoDocumentoAnexoCotizInfraestArrend());

        //MAPEAR PROYECCION PLAN ANUAL ARRENDAMIENTO RELACIONADA.
        if (documentacionAnexaCotizInfraestArrendDTO.getProyeccionPlanAnualArrendamientoDTO() != null && documentacionAnexaCotizInfraestArrendDTO.getProyeccionPlanAnualArrendamientoDTO().getIdProyeccionPlanAnualArrendamiento() != null) {
           Optional<ProyeccionPlanAnualArrendamiento> proyeccionPlanAnualArrendamientoFk = proyeccionPlanAnualArrendamientoRepository.findByIdProyeccionPlanAnualArrendamiento(documentacionAnexaCotizInfraestArrendDTO.getProyeccionPlanAnualArrendamientoDTO().getIdProyeccionPlanAnualArrendamiento());
           proyeccionPlanAnualArrendamientoFk.ifPresent(documentacionAnexaCotizInfraestArrend::setProyeccionPlanAnualArrendamiento);
        }

        return documentacionAnexaCotizInfraestArrend;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param documentacionAnexaCotizInfraestArrend
    * Recibe un objeto documentacionAnexaCotizInfraestArrend para crear un DTO.
    * @return documentacionAnexaCotizInfraestArrendDTO
    */
    public DocumentacionAnexaCotizInfraestArrendDTO documentacionAnexaCotizInfraestArrendDTO(DocumentacionAnexaCotizInfraestArrend documentacionAnexaCotizInfraestArrend){
        DocumentacionAnexaCotizInfraestArrendDTO documentacionAnexaCotizInfraestArrendDTO = new DocumentacionAnexaCotizInfraestArrendDTO();
        documentacionAnexaCotizInfraestArrendDTO.setIdDocumentacionAnexaCotizInfraestArrend(documentacionAnexaCotizInfraestArrend.getIdDocumentacionAnexaCotizInfraestArrend());
        documentacionAnexaCotizInfraestArrendDTO.setNombreDocumentoAnexoCotizInfraestArrend(documentacionAnexaCotizInfraestArrend.getNombreDocumentoAnexoCotizInfraestArrend().toUpperCase());
        documentacionAnexaCotizInfraestArrendDTO.setNombreArchivoDocumentoAnexoCotizInfraestArrend(documentacionAnexaCotizInfraestArrend.getNombreArchivoDocumentoAnexoCotizInfraestArrend());

        //MAPEAR PROYECCION PLAN ANUAL ARRENDAMIENTO RELACIONADA.
        if (documentacionAnexaCotizInfraestArrend.getProyeccionPlanAnualArrendamiento() != null && documentacionAnexaCotizInfraestArrend.getProyeccionPlanAnualArrendamiento().getIdProyeccionPlanAnualArrendamiento() != null) {
           Optional<ProyeccionPlanAnualArrendamiento> proyeccionPlanAnualArrendamientoFk = proyeccionPlanAnualArrendamientoRepository.findByIdProyeccionPlanAnualArrendamiento(documentacionAnexaCotizInfraestArrend.getProyeccionPlanAnualArrendamiento().getIdProyeccionPlanAnualArrendamiento());
           proyeccionPlanAnualArrendamientoFk.ifPresent(proyPlAnArrend -> documentacionAnexaCotizInfraestArrendDTO.setProyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamientoDTO(proyPlAnArrend)));
        }

        return documentacionAnexaCotizInfraestArrendDTO;
    }
}
