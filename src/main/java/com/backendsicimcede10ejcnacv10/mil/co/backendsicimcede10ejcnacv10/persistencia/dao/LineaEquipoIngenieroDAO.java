//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class LineaEquipoIngenieroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param lineaEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto lineaEquipoIngeniero.
    * @return lineaEquipoIngeniero
    */
    public LineaEquipoIngeniero lineaEquipoIngeniero(LineaEquipoIngenieroDTO lineaEquipoIngenieroDTO){
        LineaEquipoIngeniero lineaEquipoIngeniero = new LineaEquipoIngeniero();
        lineaEquipoIngeniero.setIdLineaEquipoIngeniero(lineaEquipoIngenieroDTO.getIdLineaEquipoIngeniero());
        lineaEquipoIngeniero.setNombreLineaEquipoIngeniero(lineaEquipoIngenieroDTO.getNombreLineaEquipoIngeniero().toUpperCase());

        return lineaEquipoIngeniero;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param lineaEquipoIngeniero
    * Recibe un DTO para un objeto lineaEquipoIngeniero para crear un DTO.
    * @return lineaEquipoIngenieroDTO
    */
    public LineaEquipoIngenieroDTO lineaEquipoIngenieroDTO(LineaEquipoIngeniero lineaEquipoIngeniero){
        LineaEquipoIngenieroDTO lineaEquipoIngenieroDTO = new LineaEquipoIngenieroDTO();
        lineaEquipoIngenieroDTO.setIdLineaEquipoIngeniero(lineaEquipoIngeniero.getIdLineaEquipoIngeniero());
        lineaEquipoIngenieroDTO.setNombreLineaEquipoIngeniero(lineaEquipoIngeniero.getNombreLineaEquipoIngeniero().toUpperCase());

        return lineaEquipoIngenieroDTO;
    }
}
