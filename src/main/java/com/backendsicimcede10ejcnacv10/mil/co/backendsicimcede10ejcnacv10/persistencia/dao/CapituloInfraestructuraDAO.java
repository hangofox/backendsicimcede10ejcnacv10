//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CapituloInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CapituloInfraestructura;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CapituloInfraestructuraDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param capituloInfraestructuraDTO
    * Recibe un DTO para crear un objeto capituloInfraestructura.
    * @return capituloInfraestructura
    */
    public CapituloInfraestructura capituloInfraestructura(CapituloInfraestructuraDTO capituloInfraestructuraDTO){
        CapituloInfraestructura capituloInfraestructura = new CapituloInfraestructura();
        capituloInfraestructura.setIdCapituloInfraestructura(capituloInfraestructuraDTO.getIdCapituloInfraestructura());
        capituloInfraestructura.setNombreCapituloInfraestructura(capituloInfraestructuraDTO.getNombreCapituloInfraestructura().toUpperCase());
        
        return capituloInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param capituloInfraestructura
    * Recibe un objeto capituloInfraestructura para crear un DTO.
    * @return capituloInfraestructuraDTO
    */
    public CapituloInfraestructuraDTO capituloInfraestructuraDTO(CapituloInfraestructura capituloInfraestructura){
        CapituloInfraestructuraDTO capituloInfraestructuraDTO = new CapituloInfraestructuraDTO();
        capituloInfraestructuraDTO.setIdCapituloInfraestructura(capituloInfraestructura.getIdCapituloInfraestructura());
        capituloInfraestructuraDTO.setNombreCapituloInfraestructura(capituloInfraestructura.getNombreCapituloInfraestructura().toUpperCase());
        
        return capituloInfraestructuraDTO;
    }
}
