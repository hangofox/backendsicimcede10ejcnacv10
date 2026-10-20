//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialIntegranteSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialIntegranteSolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialIntegranteSolicitudInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SolicitudInfraestructuraDAO solicitudInfraestructuraDAO;

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;

    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/10/2026.
    * @param historialIntegranteSolicitudInfraestructuraDTO
    * Recibe un DTO para crear un objeto historialIntegranteSolicitudInfraestructura.
    * @return historialIntegranteSolicitudInfraestructura
    */
    public HistorialIntegranteSolicitudInfraestructura historialIntegranteSolicitudInfraestructura(HistorialIntegranteSolicitudInfraestructuraDTO historialIntegranteSolicitudInfraestructuraDTO){
        HistorialIntegranteSolicitudInfraestructura historialIntegranteSolicitudInfraestructura = new HistorialIntegranteSolicitudInfraestructura();
        historialIntegranteSolicitudInfraestructura.setIdHistorialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getIdHistorialIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructura.setNumRegHistorialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getNumRegHistorialIntegranteSolicitudInfraestructura().toUpperCase());
        historialIntegranteSolicitudInfraestructura.setGradoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getGradoIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructura.setNombresIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getNombresIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructura.setPrimerApellidoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getPrimerApellidoIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructura.setSegundoApellidoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getSegundoApellidoIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructura.setNombreArchivoFotoFirmaIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getNombreArchivoFotoFirmaIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructura.setCargoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getCargoIntegranteSolicitudInfraestructura());
        
        //MAPEAR SOLICITUD DE INFRAESTRUCTURA RELACIONADA.
        if (historialIntegranteSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO() != null && historialIntegranteSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(historialIntegranteSolicitudInfraestructura::setSolicitudInfraestructura);
        }

        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialIntegranteSolicitudInfraestructuraDTO.getUnidadMilitarDTO() != null && historialIntegranteSolicitudInfraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialIntegranteSolicitudInfraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(historialIntegranteSolicitudInfraestructura::setUnidadMilitar);
        }

        return historialIntegranteSolicitudInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/10/2026.
    * @param historialIntegranteSolicitudInfraestructura
    * Recibe un objeto historialIntegranteSolicitudInfraestructura para crear un DTO.
    * @return historialIntegranteSolicitudInfraestructuraDTO
    */
    public HistorialIntegranteSolicitudInfraestructuraDTO historialIntegranteSolicitudInfraestructuraDTO(HistorialIntegranteSolicitudInfraestructura historialIntegranteSolicitudInfraestructura){
        HistorialIntegranteSolicitudInfraestructuraDTO historialIntegranteSolicitudInfraestructuraDTO = new HistorialIntegranteSolicitudInfraestructuraDTO();
        historialIntegranteSolicitudInfraestructuraDTO.setIdHistorialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getIdHistorialIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructuraDTO.setNumRegHistorialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getNumRegHistorialIntegranteSolicitudInfraestructura().toUpperCase());
        historialIntegranteSolicitudInfraestructuraDTO.setGradoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getGradoIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructuraDTO.setNombresIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getNombresIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructuraDTO.setPrimerApellidoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getPrimerApellidoIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructuraDTO.setSegundoApellidoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getSegundoApellidoIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructuraDTO.setNombreArchivoFotoFirmaIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getNombreArchivoFotoFirmaIntegranteSolicitudInfraestructura());
        historialIntegranteSolicitudInfraestructuraDTO.setCargoIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getCargoIntegranteSolicitudInfraestructura());
        
        //MAPEAR SOLICITUD DE INFRAESTRUCTURA RELACIONADA.
        if (historialIntegranteSolicitudInfraestructura.getSolicitudInfraestructura() != null && historialIntegranteSolicitudInfraestructura.getSolicitudInfraestructura().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(historialIntegranteSolicitudInfraestructura.getSolicitudInfraestructura().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(solicInfr -> historialIntegranteSolicitudInfraestructuraDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicInfr)));
        }

        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialIntegranteSolicitudInfraestructura.getUnidadMilitar() != null && historialIntegranteSolicitudInfraestructura.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialIntegranteSolicitudInfraestructura.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> historialIntegranteSolicitudInfraestructuraDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }

        return historialIntegranteSolicitudInfraestructuraDTO;
    }
}
