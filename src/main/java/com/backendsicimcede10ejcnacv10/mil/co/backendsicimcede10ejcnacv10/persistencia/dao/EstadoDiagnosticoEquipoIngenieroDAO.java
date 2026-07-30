//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EstadoDiagnosticoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoDiagnosticoEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class EstadoDiagnosticoEquipoIngenieroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/03/2025.
    * @param estadoDiagnosticoEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto estadoDiagnosticoEquipoIngeniero.
    * @return estadoDiagnosticoEquipoIngeniero
    */
    public EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero(EstadoDiagnosticoEquipoIngenieroDTO estadoDiagnosticoEquipoIngenieroDTO){
        EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero = new EstadoDiagnosticoEquipoIngeniero();
        estadoDiagnosticoEquipoIngeniero.setIdEstadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO.getIdEstadoDiagnosticoEquipoIngeniero());
        estadoDiagnosticoEquipoIngeniero.setNombreEstadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO.getNombreEstadoDiagnosticoEquipoIngeniero().toUpperCase());
        
        return estadoDiagnosticoEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/03/2026.
    * @param estadoDiagnosticoEquipoIngeniero
    * Recibe un DTO para un objeto estadoDiagnosticoEquipoIngeniero para crear un DTO.
    * @return estadoDiagnosticoEquipoIngenieroDTO
    */
    public EstadoDiagnosticoEquipoIngenieroDTO estadoDiagnosticoEquipoIngenieroDTO(EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero){
        EstadoDiagnosticoEquipoIngenieroDTO estadoDiagnosticoEquipoIngenieroDTO = new EstadoDiagnosticoEquipoIngenieroDTO();
        estadoDiagnosticoEquipoIngenieroDTO.setIdEstadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngeniero.getIdEstadoDiagnosticoEquipoIngeniero());
        estadoDiagnosticoEquipoIngenieroDTO.setNombreEstadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngeniero.getNombreEstadoDiagnosticoEquipoIngeniero().toUpperCase());
        
        return estadoDiagnosticoEquipoIngenieroDTO;
    }
}
