//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ClasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ClasificacionEquipoIngenieroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param clasificacionEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto clasificacionEquipoIngeniero.
    * @return clasificacionEquipoIngeniero
    */
    public ClasificacionEquipoIngeniero clasificacionEquipoIngeniero(ClasificacionEquipoIngenieroDTO clasificacionEquipoIngenieroDTO){
        ClasificacionEquipoIngeniero clasificacionEquipoIngeniero = new ClasificacionEquipoIngeniero();
        clasificacionEquipoIngeniero.setIdClasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO.getIdClasificacionEquipoIngeniero());
        clasificacionEquipoIngeniero.setNombreClasificacionEquipoIngeniero(clasificacionEquipoIngenieroDTO.getNombreClasificacionEquipoIngeniero().toUpperCase());
        
        return clasificacionEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param clasificacionEquipoIngeniero
    * Recibe un DTO para un objeto clasificacionEquipoIngeniero para crear un DTO.
    * @return clasificacionEquipoIngenieroDTO
    */
    public ClasificacionEquipoIngenieroDTO clasificacionEquipoIngenieroDTO(ClasificacionEquipoIngeniero clasificacionEquipoIngeniero){
        ClasificacionEquipoIngenieroDTO clasificacionEquipoIngenieroDTO = new ClasificacionEquipoIngenieroDTO();
        clasificacionEquipoIngenieroDTO.setIdClasificacionEquipoIngeniero(clasificacionEquipoIngeniero.getIdClasificacionEquipoIngeniero());
        clasificacionEquipoIngenieroDTO.setNombreClasificacionEquipoIngeniero(clasificacionEquipoIngeniero.getNombreClasificacionEquipoIngeniero().toUpperCase());
        
        return clasificacionEquipoIngenieroDTO;
    }
}
