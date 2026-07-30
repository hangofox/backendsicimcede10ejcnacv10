//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoFuenteFinanciacionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoFuenteFinanciacion;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoFuenteFinanciacionDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoFuenteFinanciacionDTO
    * Recibe un DTO para crear un objeto tipoFuenteFinanciacion.
    * @return tipoFuenteFinanciacion
    */
    public TipoFuenteFinanciacion tipoFuenteFinanciacion(TipoFuenteFinanciacionDTO tipoFuenteFinanciacionDTO){
        TipoFuenteFinanciacion tipoFuenteFinanciacion = new TipoFuenteFinanciacion();
        tipoFuenteFinanciacion.setIdTipoFuenteFinanciacion(tipoFuenteFinanciacionDTO.getIdTipoFuenteFinanciacion());
        tipoFuenteFinanciacion.setNombreTipoFuenteFinanciacion(tipoFuenteFinanciacionDTO.getNombreTipoFuenteFinanciacion().toUpperCase());
        tipoFuenteFinanciacion.setClasificacionTipoFuenteFinanciacion(tipoFuenteFinanciacionDTO.getClasificacionTipoFuenteFinanciacion().toUpperCase());
        
        return tipoFuenteFinanciacion;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoFuenteFinanciacion
    * Recibe un DTO para un objeto tipoFuenteFinanciacion para crear un DTO.
    * @return tipoFuenteFinanciacionDTO
    */
    public TipoFuenteFinanciacionDTO tipoFuenteFinanciacionDTO(TipoFuenteFinanciacion tipoFuenteFinanciacion){
        TipoFuenteFinanciacionDTO tipoFuenteFinanciacionDTO = new TipoFuenteFinanciacionDTO();
        tipoFuenteFinanciacionDTO.setIdTipoFuenteFinanciacion(tipoFuenteFinanciacion.getIdTipoFuenteFinanciacion());
        tipoFuenteFinanciacionDTO.setNombreTipoFuenteFinanciacion(tipoFuenteFinanciacion.getNombreTipoFuenteFinanciacion().toUpperCase());
        tipoFuenteFinanciacionDTO.setClasificacionTipoFuenteFinanciacion(tipoFuenteFinanciacion.getClasificacionTipoFuenteFinanciacion().toUpperCase());
        
        return tipoFuenteFinanciacionDTO;
    }
}
