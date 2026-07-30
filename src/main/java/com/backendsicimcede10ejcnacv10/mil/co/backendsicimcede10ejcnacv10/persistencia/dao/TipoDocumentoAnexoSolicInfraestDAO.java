//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoAnexoSolicInfraest;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoDocumentoAnexoSolicInfraestDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDocumentoAnexoSolicInfraestDTO
    * Recibe un DTO para crear un objeto tipoDocumentoAnexoSolicInfraest.
    * @return tipoDocumentoAnexoSolicInfraest
    */
    public TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest(TipoDocumentoAnexoSolicInfraestDTO tipoDocumentoAnexoSolicInfraestDTO){
        TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest = new TipoDocumentoAnexoSolicInfraest();
        tipoDocumentoAnexoSolicInfraest.setIdTipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO.getIdTipoDocumentoAnexoSolicInfraest());
        tipoDocumentoAnexoSolicInfraest.setNombreTipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraestDTO.getNombreTipoDocumentoAnexoSolicInfraest().toUpperCase());
        
        return tipoDocumentoAnexoSolicInfraest;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDocumentoAnexoSolicInfraest
    * Recibe un DTO para un objeto tipoDocumentoAnexoSolicInfraest para crear un DTO.
    * @return tipoDocumentoAnexoSolicInfraestDTO
    */
    public TipoDocumentoAnexoSolicInfraestDTO tipoDocumentoAnexoSolicInfraestDTO(TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest){
        TipoDocumentoAnexoSolicInfraestDTO tipoDocumentoAnexoSolicInfraestDTO = new TipoDocumentoAnexoSolicInfraestDTO();
        tipoDocumentoAnexoSolicInfraestDTO.setIdTipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraest.getIdTipoDocumentoAnexoSolicInfraest());
        tipoDocumentoAnexoSolicInfraestDTO.setNombreTipoDocumentoAnexoSolicInfraest(tipoDocumentoAnexoSolicInfraest.getNombreTipoDocumentoAnexoSolicInfraest().toUpperCase());
        
        return tipoDocumentoAnexoSolicInfraestDTO;
    }
}
