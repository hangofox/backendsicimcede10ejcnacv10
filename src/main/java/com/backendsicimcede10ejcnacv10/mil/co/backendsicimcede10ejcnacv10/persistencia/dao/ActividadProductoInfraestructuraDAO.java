//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ActividadProductoInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ActividadProductoInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CapituloInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CapituloInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ActividadProductoInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CapituloInfraestructuraRepository capituloInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private CapituloInfraestructuraDAO capituloInfraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param actividadProductoInfraestructuraDTO
    * Recibe un DTO para crear un objeto actividadProductoInfraestructura.
    * @return actividadProductoInfraestructura
    */
    public ActividadProductoInfraestructura actividadProductoInfraestructura(ActividadProductoInfraestructuraDTO actividadProductoInfraestructuraDTO){
        ActividadProductoInfraestructura actividadProductoInfraestructura = new ActividadProductoInfraestructura();
        actividadProductoInfraestructura.setIdActividadProductoInfraestructura(actividadProductoInfraestructuraDTO.getIdActividadProductoInfraestructura());
        actividadProductoInfraestructura.setNombreActividadProductoInfraestructura(actividadProductoInfraestructuraDTO.getNombreActividadProductoInfraestructura().toUpperCase());
        actividadProductoInfraestructura.setSiglaOAcronimoUnidadMedidaActividadProductoInfraestructura(actividadProductoInfraestructuraDTO.getSiglaOAcronimoUnidadMedidaActividadProductoInfraestructura().toUpperCase());
        
        //MAPEAR CAPÍTULO DE INFRAESTRUCTURA RELACIONADO.
        if (actividadProductoInfraestructuraDTO.getCapituloInfraestructuraDTO() != null && actividadProductoInfraestructuraDTO.getCapituloInfraestructuraDTO().getIdCapituloInfraestructura() != null) {
           Optional<CapituloInfraestructura> capituloInfraestructuraFk = capituloInfraestructuraRepository.findByIdCapituloInfraestructura(actividadProductoInfraestructuraDTO.getCapituloInfraestructuraDTO().getIdCapituloInfraestructura());
           capituloInfraestructuraFk.ifPresent(actividadProductoInfraestructura::setCapituloInfraestructura);
        }
        
        return actividadProductoInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param actividadProductoInfraestructura
    * Recibe un objeto actividadProductoInfraestructura para crear un DTO.
    * @return actividadProductoInfraestructuraDTO
    */
    public ActividadProductoInfraestructuraDTO actividadProductoInfraestructuraDTO(ActividadProductoInfraestructura actividadProductoInfraestructura){
        ActividadProductoInfraestructuraDTO actividadProductoInfraestructuraDTO = new ActividadProductoInfraestructuraDTO();
        actividadProductoInfraestructuraDTO.setIdActividadProductoInfraestructura(actividadProductoInfraestructura.getIdActividadProductoInfraestructura());
        actividadProductoInfraestructuraDTO.setNombreActividadProductoInfraestructura(actividadProductoInfraestructura.getNombreActividadProductoInfraestructura().toUpperCase());
        actividadProductoInfraestructuraDTO.setSiglaOAcronimoUnidadMedidaActividadProductoInfraestructura(actividadProductoInfraestructura.getSiglaOAcronimoUnidadMedidaActividadProductoInfraestructura().toUpperCase());
        
        //MAPEAR CAPÍTULO DE INFRAESTRUCTURA RELACIONADO.
        if (actividadProductoInfraestructura.getCapituloInfraestructura() != null && actividadProductoInfraestructura.getCapituloInfraestructura().getIdCapituloInfraestructura() != null) {
           Optional<CapituloInfraestructura> capituloInfraestructuraFk = capituloInfraestructuraRepository.findByIdCapituloInfraestructura(actividadProductoInfraestructura.getCapituloInfraestructura().getIdCapituloInfraestructura());
           capituloInfraestructuraFk.ifPresent(capituloInfraestructura -> actividadProductoInfraestructuraDTO.setCapituloInfraestructuraDTO(capituloInfraestructuraDAO.capituloInfraestructuraDTO(capituloInfraestructura)));
        }
        
        return actividadProductoInfraestructuraDTO;
    }
}
