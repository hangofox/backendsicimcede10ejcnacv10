//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionSeguroInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class InclusionSeguroInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionSeguroInfraestructuraRepository proyeccionSeguroInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionSeguroInfraestructuraDAO proyeccionSeguroInfraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param inclusionSeguroInfraestructuraDTO
    * Recibe un DTO para crear un objeto inclusionSeguroInfraestructura.
    * @return inclusionSeguroInfraestructura
    */
    public InclusionSeguroInfraestructura inclusionSeguroInfraestructura(InclusionSeguroInfraestructuraDTO inclusionSeguroInfraestructuraDTO){
        InclusionSeguroInfraestructura inclusionSeguroInfraestructura = new InclusionSeguroInfraestructura();
        inclusionSeguroInfraestructura.setIdInclusionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO.getIdInclusionSeguroInfraestructura());
        inclusionSeguroInfraestructura.setFechaHMSIniciacionInclusionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO.getFechaHMSIniciacionInclusionSeguroInfraestructura());
        inclusionSeguroInfraestructura.setFechaHMSFinalizacionInclusionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO.getFechaHMSFinalizacionInclusionSeguroInfraestructura());
        inclusionSeguroInfraestructura.setDescripcionInclusionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO.getDescripcionInclusionSeguroInfraestructura());
        
        //MAPEAR PROYECCIÓN DE SEGURO DE INFRAESTRUCTURA RELACIONADA.
        if (inclusionSeguroInfraestructuraDTO.getProyeccionSeguroInfraestructuraDTO() != null && inclusionSeguroInfraestructuraDTO.getProyeccionSeguroInfraestructuraDTO().getIdProyeccionSeguroInfraestructura() != null) {
           Optional<ProyeccionSeguroInfraestructura> proyeccionSeguroInfraestructuraFk = proyeccionSeguroInfraestructuraRepository.findByIdProyeccionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO.getProyeccionSeguroInfraestructuraDTO().getIdProyeccionSeguroInfraestructura());
           proyeccionSeguroInfraestructuraFk.ifPresent(inclusionSeguroInfraestructura::setProyeccionSeguroInfraestructura);
        }
        
        return inclusionSeguroInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param inclusionSeguroInfraestructura
    * Recibe un objeto inclusionSeguroInfraestructura para crear un DTO.
    * @return inclusionSeguroInfraestructuraDTO
    */
    public InclusionSeguroInfraestructuraDTO inclusionSeguroInfraestructuraDTO(InclusionSeguroInfraestructura inclusionSeguroInfraestructura){
        InclusionSeguroInfraestructuraDTO inclusionSeguroInfraestructuraDTO = new InclusionSeguroInfraestructuraDTO();
        inclusionSeguroInfraestructuraDTO.setIdInclusionSeguroInfraestructura(inclusionSeguroInfraestructura.getIdInclusionSeguroInfraestructura());
        inclusionSeguroInfraestructuraDTO.setFechaHMSIniciacionInclusionSeguroInfraestructura(inclusionSeguroInfraestructura.getFechaHMSIniciacionInclusionSeguroInfraestructura());
        inclusionSeguroInfraestructuraDTO.setFechaHMSFinalizacionInclusionSeguroInfraestructura(inclusionSeguroInfraestructura.getFechaHMSFinalizacionInclusionSeguroInfraestructura());
        inclusionSeguroInfraestructuraDTO.setDescripcionInclusionSeguroInfraestructura(inclusionSeguroInfraestructura.getDescripcionInclusionSeguroInfraestructura());
        
        //MAPEAR PROYECCIÓN DE SEGURO DE INFRAESTRUCTURA RELACIONADA.
        if (inclusionSeguroInfraestructura.getProyeccionSeguroInfraestructura() != null && inclusionSeguroInfraestructura.getProyeccionSeguroInfraestructura().getIdProyeccionSeguroInfraestructura() != null) {
           Optional<ProyeccionSeguroInfraestructura> proyeccionSeguroInfraestructuraFk = proyeccionSeguroInfraestructuraRepository.findByIdProyeccionSeguroInfraestructura(inclusionSeguroInfraestructura.getProyeccionSeguroInfraestructura().getIdProyeccionSeguroInfraestructura());
           proyeccionSeguroInfraestructuraFk.ifPresent(proyeccionSeguroInfraestructura -> inclusionSeguroInfraestructuraDTO.setProyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructura)));
        }
        
        return inclusionSeguroInfraestructuraDTO;
    }
}
