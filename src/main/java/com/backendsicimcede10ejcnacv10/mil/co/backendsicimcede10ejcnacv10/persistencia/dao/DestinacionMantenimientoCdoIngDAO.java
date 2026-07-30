//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DestinacionMantenimientoCdoIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DestinacionMantenimientoCdoIng;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DestinacionMantenimientoCdoIngDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 22/12/2025.
    * @param destinacionMantenimientoCdoIngDTO
    * Recibe un DTO para crear un objeto destinacionMantenimientoCdoIng.
    * @return destinacionMantenimientoCdoIng
    */
    public DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIng(DestinacionMantenimientoCdoIngDTO destinacionMantenimientoCdoIngDTO){
        DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIng = new DestinacionMantenimientoCdoIng();
        destinacionMantenimientoCdoIng.setIdDestinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO.getIdDestinacionMantenimientoCdoIng());
        destinacionMantenimientoCdoIng.setNombreDestinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO.getNombreDestinacionMantenimientoCdoIng().toUpperCase());
        
        return destinacionMantenimientoCdoIng;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 22/12/2025.
    * @param destinacionMantenimientoCdoIng
    * Recibe un DTO para un objeto destinacionMantenimientoCdoIng para crear un DTO.
    * @return destinacionMantenimientoCdoIngDTO
    */
    public DestinacionMantenimientoCdoIngDTO destinacionMantenimientoCdoIngDTO(DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIng){
        DestinacionMantenimientoCdoIngDTO destinacionMantenimientoCdoIngDTO = new DestinacionMantenimientoCdoIngDTO();
        destinacionMantenimientoCdoIngDTO.setIdDestinacionMantenimientoCdoIng(destinacionMantenimientoCdoIng.getIdDestinacionMantenimientoCdoIng());
        destinacionMantenimientoCdoIngDTO.setNombreDestinacionMantenimientoCdoIng(destinacionMantenimientoCdoIng.getNombreDestinacionMantenimientoCdoIng().toUpperCase());
        
        return destinacionMantenimientoCdoIngDTO;
    }
}
