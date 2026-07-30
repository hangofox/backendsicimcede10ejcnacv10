//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoContratoSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContratoSeguroInfraestructura;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoContratoSeguroInfraestructuraDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoContratoSeguroInfraestructuraDTO
    * Recibe un DTO para crear un objeto tipoContratoSeguroInfraestructura.
    * @return tipoContratoSeguroInfraestructura
    */
    public TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura(TipoContratoSeguroInfraestructuraDTO tipoContratoSeguroInfraestructuraDTO){
        TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura = new TipoContratoSeguroInfraestructura();
        tipoContratoSeguroInfraestructura.setIdTipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO.getIdTipoContratoSeguroInfraestructura());
        tipoContratoSeguroInfraestructura.setNombreTipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructuraDTO.getNombreTipoContratoSeguroInfraestructura().toUpperCase());
        
        return tipoContratoSeguroInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoContratoSeguroInfraestructura
    * Recibe un DTO para un objeto tipoContratoSeguroInfraestructura para crear un DTO.
    * @return tipoContratoSeguroInfraestructuraDTO
    */
    public TipoContratoSeguroInfraestructuraDTO tipoContratoSeguroInfraestructuraDTO(TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura){
        TipoContratoSeguroInfraestructuraDTO tipoContratoSeguroInfraestructuraDTO = new TipoContratoSeguroInfraestructuraDTO();
        tipoContratoSeguroInfraestructuraDTO.setIdTipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructura.getIdTipoContratoSeguroInfraestructura());
        tipoContratoSeguroInfraestructuraDTO.setNombreTipoContratoSeguroInfraestructura(tipoContratoSeguroInfraestructura.getNombreTipoContratoSeguroInfraestructura().toUpperCase());
        
        return tipoContratoSeguroInfraestructuraDTO;
    }
}
