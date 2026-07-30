//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoMantenimientoEquipoIngenieroDAO {
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoMantenimientoEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto tipoMantenimientoEquipoIngeniero.
    * @return tipoMantenimientoEquipoIngeniero
    */
    public TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero(TipoMantenimientoEquipoIngenieroDTO tipoMantenimientoEquipoIngenieroDTO){
        TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero = new TipoMantenimientoEquipoIngeniero();
        tipoMantenimientoEquipoIngeniero.setIdTipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO.getIdTipoMantenimientoEquipoIngeniero());
        tipoMantenimientoEquipoIngeniero.setNombreTipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngenieroDTO.getNombreTipoMantenimientoEquipoIngeniero().toUpperCase());
        
        return tipoMantenimientoEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoMantenimientoEquipoIngeniero
    * Recibe un objeto tipoMantenimientoEquipoIngeniero para crear un DTO.
    * @return tipoMantenimientoEquipoIngenieroDTO
    */
    public TipoMantenimientoEquipoIngenieroDTO tipoMantenimientoEquipoIngenieroDTO(TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero){
        TipoMantenimientoEquipoIngenieroDTO tipoMantenimientoEquipoIngenieroDTO = new TipoMantenimientoEquipoIngenieroDTO();
        tipoMantenimientoEquipoIngenieroDTO.setIdTipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngeniero.getIdTipoMantenimientoEquipoIngeniero());
        tipoMantenimientoEquipoIngenieroDTO.setNombreTipoMantenimientoEquipoIngeniero(tipoMantenimientoEquipoIngeniero.getNombreTipoMantenimientoEquipoIngeniero().toUpperCase());
        
        return tipoMantenimientoEquipoIngenieroDTO;
    }
}
