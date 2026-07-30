//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoMantenimientoInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoInfraestructura;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoMantenimientoInfraestructuraDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoMantenimientoInfraestructuraDTO
    * Recibe un DTO para crear un objeto tipoMantenimientoInfraestructura.
    * @return tipoMantenimientoInfraestructura
    */
    public TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura(TipoMantenimientoInfraestructuraDTO tipoMantenimientoInfraestructuraDTO){
        TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura = new TipoMantenimientoInfraestructura();
        tipoMantenimientoInfraestructura.setIdTipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO.getIdTipoMantenimientoInfraestructura());
        tipoMantenimientoInfraestructura.setNombreTipoMantenimientoInfraestructura(tipoMantenimientoInfraestructuraDTO.getNombreTipoMantenimientoInfraestructura().toUpperCase());
        
        return tipoMantenimientoInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoMantenimientoInfraestructura
    * Recibe un DTO para un objeto tipoMantenimientoInfraestructura para crear un DTO.
    * @return tipoMantenimientoInfraestructuraDTO
    */
    public TipoMantenimientoInfraestructuraDTO tipoMantenimientoInfraestructuraDTO(TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura){
        TipoMantenimientoInfraestructuraDTO tipoMantenimientoInfraestructuraDTO = new TipoMantenimientoInfraestructuraDTO();
        tipoMantenimientoInfraestructuraDTO.setIdTipoMantenimientoInfraestructura(tipoMantenimientoInfraestructura.getIdTipoMantenimientoInfraestructura());
        tipoMantenimientoInfraestructuraDTO.setNombreTipoMantenimientoInfraestructura(tipoMantenimientoInfraestructura.getNombreTipoMantenimientoInfraestructura().toUpperCase());
        
        return tipoMantenimientoInfraestructuraDTO;
    }
}
