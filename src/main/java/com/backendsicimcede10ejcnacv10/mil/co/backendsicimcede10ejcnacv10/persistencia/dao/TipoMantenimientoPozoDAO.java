//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoMantenimientoPozoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoPozo;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoMantenimientoPozoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoMantenimientoPozoDTO
    * Recibe un DTO para crear un objeto tipoMantenimientoPozo.
    * @return tipoMantenimientoPozo
    */
    public TipoMantenimientoPozo tipoMantenimientoPozo(TipoMantenimientoPozoDTO tipoMantenimientoPozoDTO){
        TipoMantenimientoPozo tipoMantenimientoPozo = new TipoMantenimientoPozo();
        tipoMantenimientoPozo.setIdTipoMantenimientoPozo(tipoMantenimientoPozoDTO.getIdTipoMantenimientoPozo());
        tipoMantenimientoPozo.setNombreTipoMantenimientoPozo(tipoMantenimientoPozoDTO.getNombreTipoMantenimientoPozo().toUpperCase());
        
        return tipoMantenimientoPozo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoMantenimientoPozo
    * Recibe un DTO para un objeto tipoMantenimientoPozo para crear un DTO.
    * @return tipoMantenimientoPozoDTO
    */
    public TipoMantenimientoPozoDTO tipoMantenimientoPozoDTO(TipoMantenimientoPozo tipoMantenimientoPozo){
        TipoMantenimientoPozoDTO tipoMantenimientoPozoDTO = new TipoMantenimientoPozoDTO();
        tipoMantenimientoPozoDTO.setIdTipoMantenimientoPozo(tipoMantenimientoPozo.getIdTipoMantenimientoPozo());
        tipoMantenimientoPozoDTO.setNombreTipoMantenimientoPozo(tipoMantenimientoPozo.getNombreTipoMantenimientoPozo().toUpperCase());
        
        return tipoMantenimientoPozoDTO;
    }
}
