//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.GerenteProyectoSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.GerenteProyectoSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class GerenteProyectoSolicInfraestDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SolicitudInfraestructuraDAO solicitudInfraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param gerenteProyectoSolicInfraestDTO
    * Recibe un DTO para crear un objeto gerenteProyectoSolicInfraest.
    * @return gerenteProyectoSolicInfraest
    */
    public GerenteProyectoSolicInfraest gerenteProyectoSolicInfraest(GerenteProyectoSolicInfraestDTO gerenteProyectoSolicInfraestDTO){
        GerenteProyectoSolicInfraest gerenteProyectoSolicInfraest = new GerenteProyectoSolicInfraest();
        gerenteProyectoSolicInfraest.setIdGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getIdGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraest.setGradoGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getGradoGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraest.setNombresGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getNombresGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraest.setPrimerApellidoGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getPrimerApellidoGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraest.setSegundoApellidoGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getSegundoApellidoGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraest.setMovilGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getMovilGerenteProyectoSolicInfraest().toUpperCase());
        gerenteProyectoSolicInfraest.setCargoActualGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getCargoActualGerenteProyectoSolicInfraest());
        
        //MAPEAR SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (gerenteProyectoSolicInfraestDTO.getSolicitudInfraestructuraDTO() != null && gerenteProyectoSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(gerenteProyectoSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(gerenteProyectoSolicInfraest::setSolicitudInfraestructura);
        }
        
        return gerenteProyectoSolicInfraest;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param gerenteProyectoSolicInfraest
    * Recibe un objeto gerenteProyectoSolicInfraest para crear un DTO.
    * @return gerenteProyectoSolicInfraestDTO
    */
    public GerenteProyectoSolicInfraestDTO gerenteProyectoSolicInfraestDTO(GerenteProyectoSolicInfraest gerenteProyectoSolicInfraest){
        GerenteProyectoSolicInfraestDTO gerenteProyectoSolicInfraestDTO = new GerenteProyectoSolicInfraestDTO();
        gerenteProyectoSolicInfraestDTO.setIdGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraest.getIdGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraestDTO.setGradoGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraest.getGradoGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraestDTO.setNombresGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraest.getNombresGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraestDTO.setPrimerApellidoGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraest.getPrimerApellidoGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraestDTO.setSegundoApellidoGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraest.getSegundoApellidoGerenteProyectoSolicInfraest());
        gerenteProyectoSolicInfraestDTO.setMovilGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraest.getMovilGerenteProyectoSolicInfraest().toUpperCase());
        gerenteProyectoSolicInfraestDTO.setCargoActualGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraest.getCargoActualGerenteProyectoSolicInfraest());
        
        //MAPEAR SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (gerenteProyectoSolicInfraest.getSolicitudInfraestructura() != null && gerenteProyectoSolicInfraest.getSolicitudInfraestructura().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(gerenteProyectoSolicInfraest.getSolicitudInfraestructura().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(solicInfra -> gerenteProyectoSolicInfraestDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicInfra)));
        }
        
        return gerenteProyectoSolicInfraestDTO;
    }
}
