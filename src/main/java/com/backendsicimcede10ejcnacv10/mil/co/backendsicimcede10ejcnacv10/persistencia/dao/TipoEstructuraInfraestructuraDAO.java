//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEstructuraInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructura;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoEstructuraInfraestructuraDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEstructuraInfraestructuraDTO
    * Recibe un DTO para crear un objeto tipoEstructuraInfraestructura.
    * @return tipoEstructuraInfraestructura
    */
    public TipoEstructuraInfraestructura tipoEstructuraInfraestructura(TipoEstructuraInfraestructuraDTO tipoEstructuraInfraestructuraDTO){
        TipoEstructuraInfraestructura tipoEstructuraInfraestructura = new TipoEstructuraInfraestructura();
        tipoEstructuraInfraestructura.setIdTipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO.getIdTipoEstructuraInfraestructura());
        tipoEstructuraInfraestructura.setNombreTipoEstructuraInfraestructura(tipoEstructuraInfraestructuraDTO.getNombreTipoEstructuraInfraestructura().toUpperCase());
        
        return tipoEstructuraInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEstructuraInfraestructura
    * Recibe un DTO para un objeto tipoEstructuraInfraestructura para crear un DTO.
    * @return tipoEstructuraInfraestructuraDTO
    */
    public TipoEstructuraInfraestructuraDTO tipoEstructuraInfraestructuraDTO(TipoEstructuraInfraestructura tipoEstructuraInfraestructura){
        TipoEstructuraInfraestructuraDTO tipoEstructuraInfraestructuraDTO = new TipoEstructuraInfraestructuraDTO();
        tipoEstructuraInfraestructuraDTO.setIdTipoEstructuraInfraestructura(tipoEstructuraInfraestructura.getIdTipoEstructuraInfraestructura());
        tipoEstructuraInfraestructuraDTO.setNombreTipoEstructuraInfraestructura(tipoEstructuraInfraestructura.getNombreTipoEstructuraInfraestructura().toUpperCase());
        
        return tipoEstructuraInfraestructuraDTO;
    }
}
