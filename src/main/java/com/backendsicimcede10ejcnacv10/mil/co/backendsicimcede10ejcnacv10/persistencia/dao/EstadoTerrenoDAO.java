//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EstadoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoTerreno;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class EstadoTerrenoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param estadoTerrenoDTO
    * Recibe un DTO para crear un objeto estadoTerreno.
    * @return estadoTerreno
    */
    public EstadoTerreno estadoTerreno(EstadoTerrenoDTO estadoTerrenoDTO){
        EstadoTerreno estadoTerreno = new EstadoTerreno();
        estadoTerreno.setIdEstadoTerreno(estadoTerrenoDTO.getIdEstadoTerreno());
        estadoTerreno.setNombreEstadoTerreno(estadoTerrenoDTO.getNombreEstadoTerreno().toUpperCase());
        
        return estadoTerreno;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param estadoTerreno
    * Recibe un DTO para un objeto estadoTerreno para crear un DTO.
    * @return estadoTerrenoDTO
    */
    public EstadoTerrenoDTO estadoTerrenoDTO(EstadoTerreno estadoTerreno){
        EstadoTerrenoDTO estadoTerrenoDTO = new EstadoTerrenoDTO();
        estadoTerrenoDTO.setIdEstadoTerreno(estadoTerreno.getIdEstadoTerreno());
        estadoTerrenoDTO.setNombreEstadoTerreno(estadoTerreno.getNombreEstadoTerreno().toUpperCase());
        
        return estadoTerrenoDTO;
    }
}
