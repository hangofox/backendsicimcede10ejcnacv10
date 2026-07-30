//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoIdentificacionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoIdentificacion;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoDocumentoIdentificacionDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param tipoDocumentoIdentificacionDTO
    * Recibe un DTO para crear un objeto tipoDocumentoIdentificacion.
    * @return tipoDocumentoIdentificacion
    */
    public TipoDocumentoIdentificacion tipoDocumentoIdentificacion(TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionDTO){
        TipoDocumentoIdentificacion tipoDocumentoIdentificacion = new TipoDocumentoIdentificacion();
        tipoDocumentoIdentificacion.setIdTipoDocumentoIdentificacion(tipoDocumentoIdentificacionDTO.getIdTipoDocumentoIdentificacion());
        tipoDocumentoIdentificacion.setNombreTipoDocumentoIdentificacion(tipoDocumentoIdentificacionDTO.getNombreTipoDocumentoIdentificacion().toUpperCase());
        
        return tipoDocumentoIdentificacion;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param tipoDocumentoIdentificacion
    * Recibe un DTO para un objeto tipoDocumentoIdentificacion para crear un DTO.
    * @return tipoDocumentoIdentificacionDTO
    */
    public TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionDTO(TipoDocumentoIdentificacion tipoDocumentoIdentificacion){
        TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionDTO = new TipoDocumentoIdentificacionDTO();
        tipoDocumentoIdentificacionDTO.setIdTipoDocumentoIdentificacion(tipoDocumentoIdentificacion.getIdTipoDocumentoIdentificacion());
        tipoDocumentoIdentificacionDTO.setNombreTipoDocumentoIdentificacion(tipoDocumentoIdentificacion.getNombreTipoDocumentoIdentificacion().toUpperCase());
        
        return tipoDocumentoIdentificacionDTO;
    }
}
