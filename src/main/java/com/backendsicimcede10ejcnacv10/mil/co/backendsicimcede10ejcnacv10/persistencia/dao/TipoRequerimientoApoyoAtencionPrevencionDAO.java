//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoRequerimientoApoyoAtencionPrevencionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoRequerimientoApoyoAtencionPrevencion;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoRequerimientoApoyoAtencionPrevencionDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoRequerimientoApoyoAtencionPrevencionDTO
    * Recibe un DTO para crear un objeto tipoRequerimientoApoyoAtencionPrevencion.
    * @return tipoRequerimientoApoyoAtencionPrevencion
    */
    public TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion(TipoRequerimientoApoyoAtencionPrevencionDTO tipoRequerimientoApoyoAtencionPrevencionDTO){
        TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion = new TipoRequerimientoApoyoAtencionPrevencion();
        tipoRequerimientoApoyoAtencionPrevencion.setIdTipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO.getIdTipoRequerimientoApoyoAtencionPrevencion());
        tipoRequerimientoApoyoAtencionPrevencion.setNombreTipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencionDTO.getNombreTipoRequerimientoApoyoAtencionPrevencion().toUpperCase());
        
        return tipoRequerimientoApoyoAtencionPrevencion;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoRequerimientoApoyoAtencionPrevencion
    * Recibe un DTO para un objeto tipoRequerimientoApoyoAtencionPrevencion para crear un DTO.
    * @return tipoRequerimientoApoyoAtencionPrevencionDTO
    */
    public TipoRequerimientoApoyoAtencionPrevencionDTO tipoRequerimientoApoyoAtencionPrevencionDTO(TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion){
        TipoRequerimientoApoyoAtencionPrevencionDTO tipoRequerimientoApoyoAtencionPrevencionDTO = new TipoRequerimientoApoyoAtencionPrevencionDTO();
        tipoRequerimientoApoyoAtencionPrevencionDTO.setIdTipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencion.getIdTipoRequerimientoApoyoAtencionPrevencion());
        tipoRequerimientoApoyoAtencionPrevencionDTO.setNombreTipoRequerimientoApoyoAtencionPrevencion(tipoRequerimientoApoyoAtencionPrevencion.getNombreTipoRequerimientoApoyoAtencionPrevencion().toUpperCase());
        
        return tipoRequerimientoApoyoAtencionPrevencionDTO;
    }
}
