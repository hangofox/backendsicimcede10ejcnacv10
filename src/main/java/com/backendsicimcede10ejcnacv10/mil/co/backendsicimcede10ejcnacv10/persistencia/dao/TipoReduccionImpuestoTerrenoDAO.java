//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoReduccionImpuestoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoReduccionImpuestoTerreno;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoReduccionImpuestoTerrenoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoReduccionImpuestoTerrenoDTO
    * Recibe un DTO para crear un objeto tipoReduccionImpuestoTerreno.
    * @return tipoReduccionImpuestoTerreno
    */
    public TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno(TipoReduccionImpuestoTerrenoDTO tipoReduccionImpuestoTerrenoDTO){
        TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno = new TipoReduccionImpuestoTerreno();
        tipoReduccionImpuestoTerreno.setIdTipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO.getIdTipoReduccionImpuestoTerreno());
        tipoReduccionImpuestoTerreno.setNombreTipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO.getNombreTipoReduccionImpuestoTerreno().toUpperCase());
        
        return tipoReduccionImpuestoTerreno;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoReduccionImpuestoTerreno
    * Recibe un DTO para un objeto tipoReduccionImpuestoTerreno para crear un DTO.
    * @return tipoReduccionImpuestoTerrenoDTO
    */
    public TipoReduccionImpuestoTerrenoDTO tipoReduccionImpuestoTerrenoDTO(TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno){
        TipoReduccionImpuestoTerrenoDTO tipoReduccionImpuestoTerrenoDTO = new TipoReduccionImpuestoTerrenoDTO();
        tipoReduccionImpuestoTerrenoDTO.setIdTipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerreno.getIdTipoReduccionImpuestoTerreno());
        tipoReduccionImpuestoTerrenoDTO.setNombreTipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerreno.getNombreTipoReduccionImpuestoTerreno().toUpperCase());
        
        return tipoReduccionImpuestoTerrenoDTO;
    }
}
