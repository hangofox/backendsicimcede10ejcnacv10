//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEntidadInstitucionalDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEntidadInstitucional;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoEntidadInstitucionalDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEntidadInstitucionalDTO
    * Recibe un DTO para crear un objeto tipoEntidadInstitucional.
    * @return tipoEntidadInstitucional
    */
    public TipoEntidadInstitucional tipoEntidadInstitucional(TipoEntidadInstitucionalDTO tipoEntidadInstitucionalDTO){
        TipoEntidadInstitucional tipoEntidadInstitucional = new TipoEntidadInstitucional();
        tipoEntidadInstitucional.setIdTipoEntidadInstitucional(tipoEntidadInstitucionalDTO.getIdTipoEntidadInstitucional());
        tipoEntidadInstitucional.setNombreTipoEntidadInstitucional(tipoEntidadInstitucionalDTO.getNombreTipoEntidadInstitucional().toUpperCase());
        
        return tipoEntidadInstitucional;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEntidadInstitucional
    * Recibe un DTO para un objeto tipoEntidadInstitucional para crear un DTO.
    * @return tipoEntidadInstitucionalDTO
    */
    public TipoEntidadInstitucionalDTO tipoEntidadInstitucionalDTO(TipoEntidadInstitucional tipoEntidadInstitucional){
        TipoEntidadInstitucionalDTO tipoEntidadInstitucionalDTO = new TipoEntidadInstitucionalDTO();
        tipoEntidadInstitucionalDTO.setIdTipoEntidadInstitucional(tipoEntidadInstitucional.getIdTipoEntidadInstitucional());
        tipoEntidadInstitucionalDTO.setNombreTipoEntidadInstitucional(tipoEntidadInstitucional.getNombreTipoEntidadInstitucional().toUpperCase());
        
        return tipoEntidadInstitucionalDTO;
    }
}
