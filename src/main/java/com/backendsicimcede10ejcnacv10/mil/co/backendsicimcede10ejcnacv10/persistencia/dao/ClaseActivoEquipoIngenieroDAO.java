//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ClaseActivoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClaseActivoEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ClaseActivoEquipoIngenieroDAO {
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param claseActivoEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto claseActivoEquipoIngeniero.
    * @return claseActivoEquipoIngeniero
    */
    public ClaseActivoEquipoIngeniero claseActivoEquipoIngeniero(ClaseActivoEquipoIngenieroDTO claseActivoEquipoIngenieroDTO){
        ClaseActivoEquipoIngeniero claseActivoEquipoIngeniero = new ClaseActivoEquipoIngeniero();
        claseActivoEquipoIngeniero.setIdClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getIdClaseActivoEquipoIngeniero());
        claseActivoEquipoIngeniero.setNombreClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getNombreClaseActivoEquipoIngeniero().toUpperCase());
        claseActivoEquipoIngeniero.setNumeroClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getNumeroClaseActivoEquipoIngeniero().toUpperCase());
        return claseActivoEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param claseActivoEquipoIngeniero
    * Recibe un objeto claseActivoEquipoIngeniero para crear un DTO.
    * @return claseActivoEquipoIngenieroDTO
    */
    public ClaseActivoEquipoIngenieroDTO claseActivoEquipoIngenieroDTO(ClaseActivoEquipoIngeniero claseActivoEquipoIngeniero){
        ClaseActivoEquipoIngenieroDTO claseActivoEquipoIngenieroDTO = new ClaseActivoEquipoIngenieroDTO();
        claseActivoEquipoIngenieroDTO.setIdClaseActivoEquipoIngeniero(claseActivoEquipoIngeniero.getIdClaseActivoEquipoIngeniero());
        claseActivoEquipoIngenieroDTO.setNombreClaseActivoEquipoIngeniero(claseActivoEquipoIngeniero.getNombreClaseActivoEquipoIngeniero().toUpperCase());
        claseActivoEquipoIngenieroDTO.setNumeroClaseActivoEquipoIngeniero(claseActivoEquipoIngeniero.getNumeroClaseActivoEquipoIngeniero().toUpperCase());
        return claseActivoEquipoIngenieroDTO;
    }
}
