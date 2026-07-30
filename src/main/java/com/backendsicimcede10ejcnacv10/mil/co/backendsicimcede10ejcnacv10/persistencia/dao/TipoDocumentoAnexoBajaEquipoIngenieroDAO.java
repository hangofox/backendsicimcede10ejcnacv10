//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoBajaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoBajaEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoDocumentoAnexoBajaEquipoIngenieroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDocumentoAnexoBajaEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto tipoDocumentoAnexoBajaEquipoIngeniero.
    * @return tipoDocumentoAnexoBajaEquipoIngeniero
    */
    public TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero(TipoDocumentoAnexoBajaEquipoIngenieroDTO tipoDocumentoAnexoBajaEquipoIngenieroDTO){
        TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero = new TipoDocumentoAnexoBajaEquipoIngeniero();
        tipoDocumentoAnexoBajaEquipoIngeniero.setIdTipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO.getIdTipoDocumentoAnexoBajaEquipoIngeniero());
        tipoDocumentoAnexoBajaEquipoIngeniero.setNombreTipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngenieroDTO.getNombreTipoDocumentoAnexoBajaEquipoIngeniero().toUpperCase());
        
        return tipoDocumentoAnexoBajaEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDocumentoAnexoBajaEquipoIngeniero
    * Recibe un DTO para un objeto tipoDocumentoAnexoBajaEquipoIngeniero para crear un DTO.
    * @return tipoDocumentoAnexoBajaEquipoIngenieroDTO
    */
    public TipoDocumentoAnexoBajaEquipoIngenieroDTO tipoDocumentoAnexoBajaEquipoIngenieroDTO(TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero){
        TipoDocumentoAnexoBajaEquipoIngenieroDTO tipoDocumentoAnexoBajaEquipoIngenieroDTO = new TipoDocumentoAnexoBajaEquipoIngenieroDTO();
        tipoDocumentoAnexoBajaEquipoIngenieroDTO.setIdTipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngeniero.getIdTipoDocumentoAnexoBajaEquipoIngeniero());
        tipoDocumentoAnexoBajaEquipoIngenieroDTO.setNombreTipoDocumentoAnexoBajaEquipoIngeniero(tipoDocumentoAnexoBajaEquipoIngeniero.getNombreTipoDocumentoAnexoBajaEquipoIngeniero().toUpperCase());
        
        return tipoDocumentoAnexoBajaEquipoIngenieroDTO;
    }
}
