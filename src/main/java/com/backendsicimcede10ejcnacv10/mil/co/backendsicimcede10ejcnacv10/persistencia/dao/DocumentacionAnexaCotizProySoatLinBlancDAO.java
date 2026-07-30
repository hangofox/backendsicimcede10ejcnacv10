//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaCotizProySoatLinBlancDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizProySoatLinBlanc;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSoatLineaBlanca;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionSoatLineaBlancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 09/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DocumentacionAnexaCotizProySoatLinBlancDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionSoatLineaBlancaRepository proyeccionSoatLineaBlancaRepository;

    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionSoatLineaBlancaDAO proyeccionSoatLineaBlancaDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 09/04/2026.
    * @param documentacionAnexaCotizProySoatLinBlancDTO
    * Recibe un DTO para crear un objeto documentacionAnexaCotizProySoatLinBlanc.
    * @return documentacionAnexaCotizProySoatLinBlanc
    */
    public DocumentacionAnexaCotizProySoatLinBlanc documentacionAnexaCotizProySoatLinBlanc(DocumentacionAnexaCotizProySoatLinBlancDTO documentacionAnexaCotizProySoatLinBlancDTO){
        DocumentacionAnexaCotizProySoatLinBlanc documentacionAnexaCotizProySoatLinBlanc = new DocumentacionAnexaCotizProySoatLinBlanc();
        documentacionAnexaCotizProySoatLinBlanc.setIdDocumentacionAnexaCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlancDTO.getIdDocumentacionAnexaCotizProySoatLinBlanc());
        documentacionAnexaCotizProySoatLinBlanc.setNombreDocumentoAnexoCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlancDTO.getNombreDocumentoAnexoCotizProySoatLinBlanc().toUpperCase());
        documentacionAnexaCotizProySoatLinBlanc.setNombreArchivoDocumentoAnexoCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlancDTO.getNombreArchivoDocumentoAnexoCotizProySoatLinBlanc());

        //MAPEAR PROYECCION SOAT LINEA BLANCA RELACIONADA.
        if (documentacionAnexaCotizProySoatLinBlancDTO.getProyeccionSoatLineaBlancaDTO() != null && documentacionAnexaCotizProySoatLinBlancDTO.getProyeccionSoatLineaBlancaDTO().getIdProyeccionSoatLineaBlanca() != null) {
           Optional<ProyeccionSoatLineaBlanca> proyeccionSoatLineaBlancaFk = proyeccionSoatLineaBlancaRepository.findByIdProyeccionSoatLineaBlanca(documentacionAnexaCotizProySoatLinBlancDTO.getProyeccionSoatLineaBlancaDTO().getIdProyeccionSoatLineaBlanca());
           proyeccionSoatLineaBlancaFk.ifPresent(documentacionAnexaCotizProySoatLinBlanc::setProyeccionSoatLineaBlanca);
        }

        return documentacionAnexaCotizProySoatLinBlanc;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 09/04/2026.
    * @param documentacionAnexaCotizProySoatLinBlanc
    * Recibe un objeto documentacionAnexaCotizProySoatLinBlanc para crear un DTO.
    * @return documentacionAnexaCotizProySoatLinBlancDTO
    */
    public DocumentacionAnexaCotizProySoatLinBlancDTO documentacionAnexaCotizProySoatLinBlancDTO(DocumentacionAnexaCotizProySoatLinBlanc documentacionAnexaCotizProySoatLinBlanc){
        DocumentacionAnexaCotizProySoatLinBlancDTO documentacionAnexaCotizProySoatLinBlancDTO = new DocumentacionAnexaCotizProySoatLinBlancDTO();
        documentacionAnexaCotizProySoatLinBlancDTO.setIdDocumentacionAnexaCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlanc.getIdDocumentacionAnexaCotizProySoatLinBlanc());
        documentacionAnexaCotizProySoatLinBlancDTO.setNombreDocumentoAnexoCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlanc.getNombreDocumentoAnexoCotizProySoatLinBlanc().toUpperCase());
        documentacionAnexaCotizProySoatLinBlancDTO.setNombreArchivoDocumentoAnexoCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlanc.getNombreArchivoDocumentoAnexoCotizProySoatLinBlanc());

        //MAPEAR PROYECCION SOAT LINEA BLANCA RELACIONADA.
        if (documentacionAnexaCotizProySoatLinBlanc.getProyeccionSoatLineaBlanca() != null && documentacionAnexaCotizProySoatLinBlanc.getProyeccionSoatLineaBlanca().getIdProyeccionSoatLineaBlanca() != null) {
           Optional<ProyeccionSoatLineaBlanca> proyeccionSoatLineaBlancaFk = proyeccionSoatLineaBlancaRepository.findByIdProyeccionSoatLineaBlanca(documentacionAnexaCotizProySoatLinBlanc.getProyeccionSoatLineaBlanca().getIdProyeccionSoatLineaBlanca());
           proyeccionSoatLineaBlancaFk.ifPresent(proySOATLinBlanc -> documentacionAnexaCotizProySoatLinBlancDTO.setProyeccionSoatLineaBlancaDTO(proyeccionSoatLineaBlancaDAO.proyeccionSoatLineaBlancaDTO(proySOATLinBlanc)));
        }

        return documentacionAnexaCotizProySoatLinBlancDTO;
    }
}
