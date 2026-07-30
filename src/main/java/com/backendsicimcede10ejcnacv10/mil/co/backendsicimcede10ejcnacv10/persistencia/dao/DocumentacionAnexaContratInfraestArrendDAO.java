//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaContratInfraestArrendDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaContratInfraestArrend;
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
public class DocumentacionAnexaContratInfraestArrendDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualArrendamientoRepository proyeccionPlanAnualArrendamientoRepository;

    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualArrendamientoDAO proyeccionPlanAnualArrendamientoDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param documentacionAnexaContratInfraestArrendDTO
    * Recibe un DTO para crear un objeto documentacionAnexaContratInfraestArrend.
    * @return documentacionAnexaContratInfraestArrend
    */
    public DocumentacionAnexaContratInfraestArrend documentacionAnexaContratInfraestArrend(DocumentacionAnexaContratInfraestArrendDTO documentacionAnexaContratInfraestArrendDTO){
        DocumentacionAnexaContratInfraestArrend documentacionAnexaContratInfraestArrend = new DocumentacionAnexaContratInfraestArrend();
        documentacionAnexaContratInfraestArrend.setIdDocumentacionAnexaContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO.getIdDocumentacionAnexaContratInfraestArrend());
        documentacionAnexaContratInfraestArrend.setNombreDocumentoAnexoContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO.getNombreDocumentoAnexoContratInfraestArrend().toUpperCase());
        documentacionAnexaContratInfraestArrend.setValorAlquilerContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO.getValorAlquilerContratInfraestArrend());
        documentacionAnexaContratInfraestArrend.setNombreUnidadMedidaAlquilerContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO.getNombreUnidadMedidaAlquilerContratInfraestArrend().toUpperCase());
        documentacionAnexaContratInfraestArrend.setNombreArchivoDocumentoAnexoContratInfraestArrend(documentacionAnexaContratInfraestArrendDTO.getNombreArchivoDocumentoAnexoContratInfraestArrend());

        //MAPEAR PROYECCION PLAN ANUAL ARRENDAMIENTO RELACIONADA.
        if (documentacionAnexaContratInfraestArrendDTO.getProyeccionPlanAnualArrendamientoDTO() != null && documentacionAnexaContratInfraestArrendDTO.getProyeccionPlanAnualArrendamientoDTO().getIdProyeccionPlanAnualArrendamiento() != null) {
           Optional<ProyeccionPlanAnualArrendamiento> proyeccionPlanAnualArrendamientoFk = proyeccionPlanAnualArrendamientoRepository.findByIdProyeccionPlanAnualArrendamiento(documentacionAnexaContratInfraestArrendDTO.getProyeccionPlanAnualArrendamientoDTO().getIdProyeccionPlanAnualArrendamiento());
           proyeccionPlanAnualArrendamientoFk.ifPresent(documentacionAnexaContratInfraestArrend::setProyeccionPlanAnualArrendamiento);
        }

        return documentacionAnexaContratInfraestArrend;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param documentacionAnexaContratInfraestArrend
    * Recibe un objeto documentacionAnexaContratInfraestArrend para crear un DTO.
    * @return documentacionAnexaContratInfraestArrendDTO
    */
    public DocumentacionAnexaContratInfraestArrendDTO documentacionAnexaContratInfraestArrendDTO(DocumentacionAnexaContratInfraestArrend documentacionAnexaContratInfraestArrend){
        DocumentacionAnexaContratInfraestArrendDTO documentacionAnexaContratInfraestArrendDTO = new DocumentacionAnexaContratInfraestArrendDTO();
        documentacionAnexaContratInfraestArrendDTO.setIdDocumentacionAnexaContratInfraestArrend(documentacionAnexaContratInfraestArrend.getIdDocumentacionAnexaContratInfraestArrend());
        documentacionAnexaContratInfraestArrendDTO.setNombreDocumentoAnexoContratInfraestArrend(documentacionAnexaContratInfraestArrend.getNombreDocumentoAnexoContratInfraestArrend().toUpperCase());
        documentacionAnexaContratInfraestArrendDTO.setValorAlquilerContratInfraestArrend(documentacionAnexaContratInfraestArrend.getValorAlquilerContratInfraestArrend());
        documentacionAnexaContratInfraestArrendDTO.setNombreUnidadMedidaAlquilerContratInfraestArrend(documentacionAnexaContratInfraestArrend.getNombreUnidadMedidaAlquilerContratInfraestArrend().toUpperCase());
        documentacionAnexaContratInfraestArrendDTO.setNombreArchivoDocumentoAnexoContratInfraestArrend(documentacionAnexaContratInfraestArrend.getNombreArchivoDocumentoAnexoContratInfraestArrend());

        //MAPEAR PROYECCION PLAN ANUAL ARRENDAMIENTO RELACIONADA.
        if (documentacionAnexaContratInfraestArrend.getProyeccionPlanAnualArrendamiento() != null && documentacionAnexaContratInfraestArrend.getProyeccionPlanAnualArrendamiento().getIdProyeccionPlanAnualArrendamiento() != null) {
           Optional<ProyeccionPlanAnualArrendamiento> proyeccionPlanAnualArrendamientoFk = proyeccionPlanAnualArrendamientoRepository.findByIdProyeccionPlanAnualArrendamiento(documentacionAnexaContratInfraestArrend.getProyeccionPlanAnualArrendamiento().getIdProyeccionPlanAnualArrendamiento());
           proyeccionPlanAnualArrendamientoFk.ifPresent(proyPlAnArrend -> documentacionAnexaContratInfraestArrendDTO.setProyeccionPlanAnualArrendamientoDTO(proyeccionPlanAnualArrendamientoDAO.proyeccionPlanAnualArrendamientoDTO(proyPlAnArrend)));
        }

        return documentacionAnexaContratInfraestArrendDTO;
    }
}
