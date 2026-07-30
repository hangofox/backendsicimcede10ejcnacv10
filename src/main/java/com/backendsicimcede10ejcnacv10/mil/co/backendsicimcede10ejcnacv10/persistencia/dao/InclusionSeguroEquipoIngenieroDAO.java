//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.AseguramientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.AseguramientoEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class InclusionSeguroEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private AseguramientoEquipoIngenieroRepository aseguramientoEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private AseguramientoEquipoIngenieroDAO aseguramientoEquipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param inclusionSeguroEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto inclusionSeguroEquipoIngeniero.
    * @return inclusionSeguroEquipoIngeniero
    */
    public InclusionSeguroEquipoIngeniero inclusionSeguroEquipoIngeniero(InclusionSeguroEquipoIngenieroDTO inclusionSeguroEquipoIngenieroDTO){
        InclusionSeguroEquipoIngeniero inclusionSeguroEquipoIngeniero = new InclusionSeguroEquipoIngeniero();
        inclusionSeguroEquipoIngeniero.setIdInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO.getIdInclusionSeguroEquipoIngeniero());
        inclusionSeguroEquipoIngeniero.setFechaHMSIniciacionInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO.getFechaHMSIniciacionInclusionSeguroEquipoIngeniero());
        inclusionSeguroEquipoIngeniero.setFechaHMSFinalizacionInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO.getFechaHMSFinalizacionInclusionSeguroEquipoIngeniero());
        inclusionSeguroEquipoIngeniero.setDescripcionInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO.getDescripcionInclusionSeguroEquipoIngeniero());
        
        //MAPEAR ASEGURAMIENTO DE EQUIPO INGENIERO RELACIONADO.
        if (inclusionSeguroEquipoIngenieroDTO.getAseguramientoEquipoIngenieroDTO() != null && inclusionSeguroEquipoIngenieroDTO.getAseguramientoEquipoIngenieroDTO().getIdAseguramientoEquipoIngeniero() != null) {
           Optional<AseguramientoEquipoIngeniero> aseguramientoEquipoIngenieroFk = aseguramientoEquipoIngenieroRepository.findByIdAseguramientoEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO.getAseguramientoEquipoIngenieroDTO().getIdAseguramientoEquipoIngeniero());
           aseguramientoEquipoIngenieroFk.ifPresent(inclusionSeguroEquipoIngeniero::setAseguramientoEquipoIngeniero);
        }
        
        return inclusionSeguroEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param inclusionSeguroEquipoIngeniero
    * Recibe un objeto inclusionSeguroEquipoIngeniero para crear un DTO.
    * @return inclusionSeguroEquipoIngenieroDTO
    */
    public InclusionSeguroEquipoIngenieroDTO inclusionSeguroEquipoIngenieroDTO(InclusionSeguroEquipoIngeniero inclusionSeguroEquipoIngeniero){
        InclusionSeguroEquipoIngenieroDTO inclusionSeguroEquipoIngenieroDTO = new InclusionSeguroEquipoIngenieroDTO();
        inclusionSeguroEquipoIngenieroDTO.setIdInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngeniero.getIdInclusionSeguroEquipoIngeniero());
        inclusionSeguroEquipoIngenieroDTO.setFechaHMSIniciacionInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngeniero.getFechaHMSIniciacionInclusionSeguroEquipoIngeniero());
        inclusionSeguroEquipoIngenieroDTO.setFechaHMSFinalizacionInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngeniero.getFechaHMSFinalizacionInclusionSeguroEquipoIngeniero());
        inclusionSeguroEquipoIngenieroDTO.setDescripcionInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngeniero.getDescripcionInclusionSeguroEquipoIngeniero());
        
        //MAPEAR ASEGURAMIENTO DE EQUIPO INGENIERO RELACIONADO.
        if (inclusionSeguroEquipoIngeniero.getAseguramientoEquipoIngeniero() != null && inclusionSeguroEquipoIngeniero.getAseguramientoEquipoIngeniero().getIdAseguramientoEquipoIngeniero() != null) {
           Optional<AseguramientoEquipoIngeniero> aseguramientoEquipoIngenieroFk = aseguramientoEquipoIngenieroRepository.findByIdAseguramientoEquipoIngeniero(inclusionSeguroEquipoIngeniero.getAseguramientoEquipoIngeniero().getIdAseguramientoEquipoIngeniero());
           aseguramientoEquipoIngenieroFk.ifPresent(aseguramientoEquipoIngeniero -> inclusionSeguroEquipoIngenieroDTO.setAseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngeniero)));
        }
        
        return inclusionSeguroEquipoIngenieroDTO;
    }
}
