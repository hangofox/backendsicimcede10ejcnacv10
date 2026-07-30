//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoSolicitudInfraestructura;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoSolicitudInfraestructuraDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoSolicitudInfraestructuraDTO
    * Recibe un DTO para crear un objeto tipoSolicitudInfraestructura.
    * @return tipoSolicitudInfraestructura
    */
    public TipoSolicitudInfraestructura tipoSolicitudInfraestructura(TipoSolicitudInfraestructuraDTO tipoSolicitudInfraestructuraDTO){
        TipoSolicitudInfraestructura tipoSolicitudInfraestructura = new TipoSolicitudInfraestructura();
        tipoSolicitudInfraestructura.setIdTipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO.getIdTipoSolicitudInfraestructura());
        tipoSolicitudInfraestructura.setNombreTipoSolicitudInfraestructura(tipoSolicitudInfraestructuraDTO.getNombreTipoSolicitudInfraestructura().toUpperCase());
        
        return tipoSolicitudInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoSolicitudInfraestructura
    * Recibe un DTO para un objeto tipoSolicitudInfraestructura para crear un DTO.
    * @return tipoSolicitudInfraestructuraDTO
    */
    public TipoSolicitudInfraestructuraDTO tipoSolicitudInfraestructuraDTO(TipoSolicitudInfraestructura tipoSolicitudInfraestructura){
        TipoSolicitudInfraestructuraDTO tipoSolicitudInfraestructuraDTO = new TipoSolicitudInfraestructuraDTO();
        tipoSolicitudInfraestructuraDTO.setIdTipoSolicitudInfraestructura(tipoSolicitudInfraestructura.getIdTipoSolicitudInfraestructura());
        tipoSolicitudInfraestructuraDTO.setNombreTipoSolicitudInfraestructura(tipoSolicitudInfraestructura.getNombreTipoSolicitudInfraestructura().toUpperCase());
        
        return tipoSolicitudInfraestructuraDTO;
    }
}
