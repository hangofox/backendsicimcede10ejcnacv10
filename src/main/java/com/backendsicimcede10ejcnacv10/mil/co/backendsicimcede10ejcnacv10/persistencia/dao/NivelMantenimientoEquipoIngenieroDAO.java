//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.NivelMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.NivelMantenimientoEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class NivelMantenimientoEquipoIngenieroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param nivelMantenimientoEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto nivelMantenimientoEquipoIngeniero.
    * @return nivelMantenimientoEquipoIngeniero
    */
    public NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero(NivelMantenimientoEquipoIngenieroDTO nivelMantenimientoEquipoIngenieroDTO){
        NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero = new NivelMantenimientoEquipoIngeniero();
        nivelMantenimientoEquipoIngeniero.setIdNivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO.getIdNivelMantenimientoEquipoIngeniero());
        nivelMantenimientoEquipoIngeniero.setNombreNivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO.getNombreNivelMantenimientoEquipoIngeniero().toUpperCase());

        return nivelMantenimientoEquipoIngeniero;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param nivelMantenimientoEquipoIngeniero
    * Recibe un DTO para un objeto nivelMantenimientoEquipoIngeniero para crear un DTO.
    * @return nivelMantenimientoEquipoIngenieroDTO
    */
    public NivelMantenimientoEquipoIngenieroDTO nivelMantenimientoEquipoIngenieroDTO(NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero){
        NivelMantenimientoEquipoIngenieroDTO nivelMantenimientoEquipoIngenieroDTO = new NivelMantenimientoEquipoIngenieroDTO();
        nivelMantenimientoEquipoIngenieroDTO.setIdNivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngeniero.getIdNivelMantenimientoEquipoIngeniero());
        nivelMantenimientoEquipoIngenieroDTO.setNombreNivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngeniero.getNombreNivelMantenimientoEquipoIngeniero().toUpperCase());

        return nivelMantenimientoEquipoIngenieroDTO;
    }
}
