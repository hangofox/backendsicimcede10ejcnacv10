//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoAltaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoAltaEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoDocumentoAnexoAltaEquipoIngenieroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDocumentoAnexoAltaEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto tipoDocumentoAnexoAltaEquipoIngeniero.
    * @return tipoDocumentoAnexoAltaEquipoIngeniero
    */
    public TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngeniero(TipoDocumentoAnexoAltaEquipoIngenieroDTO tipoDocumentoAnexoAltaEquipoIngenieroDTO){
        TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngeniero = new TipoDocumentoAnexoAltaEquipoIngeniero();
        tipoDocumentoAnexoAltaEquipoIngeniero.setIdTipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO.getIdTipoDocumentoAnexoAltaEquipoIngeniero());
        tipoDocumentoAnexoAltaEquipoIngeniero.setNombreTipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoAltaEquipoIngeniero().toUpperCase());
        
        return tipoDocumentoAnexoAltaEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDocumentoAnexoAltaEquipoIngeniero
    * Recibe un DTO para un objeto tipoDocumentoAnexoAltaEquipoIngeniero para crear un DTO.
    * @return tipoDocumentoAnexoAltaEquipoIngenieroDTO
    */
    public TipoDocumentoAnexoAltaEquipoIngenieroDTO tipoDocumentoAnexoAltaEquipoIngenieroDTO(TipoDocumentoAnexoAltaEquipoIngeniero tipoDocumentoAnexoAltaEquipoIngeniero){
        TipoDocumentoAnexoAltaEquipoIngenieroDTO tipoDocumentoAnexoAltaEquipoIngenieroDTO = new TipoDocumentoAnexoAltaEquipoIngenieroDTO();
        tipoDocumentoAnexoAltaEquipoIngenieroDTO.setIdTipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngeniero.getIdTipoDocumentoAnexoAltaEquipoIngeniero());
        tipoDocumentoAnexoAltaEquipoIngenieroDTO.setNombreTipoDocumentoAnexoAltaEquipoIngeniero(tipoDocumentoAnexoAltaEquipoIngeniero.getNombreTipoDocumentoAnexoAltaEquipoIngeniero().toUpperCase());
        
        return tipoDocumentoAnexoAltaEquipoIngenieroDTO;
    }
}
