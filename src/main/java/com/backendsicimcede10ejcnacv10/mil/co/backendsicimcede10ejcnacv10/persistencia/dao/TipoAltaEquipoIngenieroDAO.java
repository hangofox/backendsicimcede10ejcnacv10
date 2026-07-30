//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoAltaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoAltaEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoAltaEquipoIngenieroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoAltaEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto tipoAltaEquipoIngeniero.
    * @return tipoAltaEquipoIngeniero
    */
    public TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero(TipoAltaEquipoIngenieroDTO tipoAltaEquipoIngenieroDTO){
        TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero = new TipoAltaEquipoIngeniero();
        tipoAltaEquipoIngeniero.setIdTipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO.getIdTipoAltaEquipoIngeniero());
        tipoAltaEquipoIngeniero.setNombreTipoAltaEquipoIngeniero(tipoAltaEquipoIngenieroDTO.getNombreTipoAltaEquipoIngeniero().toUpperCase());
        
        return tipoAltaEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoAltaEquipoIngeniero
    * Recibe un DTO para un objeto tipoAltaEquipoIngeniero para crear un DTO.
    * @return tipoAltaEquipoIngenieroDTO
    */
    public TipoAltaEquipoIngenieroDTO tipoAltaEquipoIngenieroDTO(TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero){
        TipoAltaEquipoIngenieroDTO tipoAltaEquipoIngenieroDTO = new TipoAltaEquipoIngenieroDTO();
        tipoAltaEquipoIngenieroDTO.setIdTipoAltaEquipoIngeniero(tipoAltaEquipoIngeniero.getIdTipoAltaEquipoIngeniero());
        tipoAltaEquipoIngenieroDTO.setNombreTipoAltaEquipoIngeniero(tipoAltaEquipoIngeniero.getNombreTipoAltaEquipoIngeniero().toUpperCase());
        
        return tipoAltaEquipoIngenieroDTO;
    }
}
