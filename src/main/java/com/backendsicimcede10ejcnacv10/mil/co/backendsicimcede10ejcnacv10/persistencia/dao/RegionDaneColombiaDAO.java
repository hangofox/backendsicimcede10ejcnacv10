//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RegionDaneColombiaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RegionDaneColombia;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class RegionDaneColombiaDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param regionDaneColombiaDTO
    * Recibe un DTO para crear un objeto regionDaneColombia.
    * @return regionDaneColombia
    */
    public RegionDaneColombia regionDaneColombia(RegionDaneColombiaDTO regionDaneColombiaDTO){
        RegionDaneColombia regionDaneColombia = new RegionDaneColombia();
        regionDaneColombia.setIdRegionDaneColombia(regionDaneColombiaDTO.getIdRegionDaneColombia());
        regionDaneColombia.setNombrePaisDaneColombia(regionDaneColombiaDTO.getNombrePaisDaneColombia().toUpperCase());
        regionDaneColombia.setNombreDepartamentoDaneColombia(regionDaneColombiaDTO.getNombreDepartamentoDaneColombia().toUpperCase());
        regionDaneColombia.setNombreCiudadMunicipioDaneColombia(regionDaneColombiaDTO.getNombreCiudadMunicipioDaneColombia().toUpperCase());
        regionDaneColombia.setCodigoDaneColombia(regionDaneColombiaDTO.getCodigoDaneColombia());
        
        return regionDaneColombia;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param regionDaneColombia
    * Recibe un DTO para un objeto regionDaneColombia para crear un DTO.
    * @return regionDaneColombiaDTO
    */
    public RegionDaneColombiaDTO regionDaneColombiaDTO(RegionDaneColombia regionDaneColombia){
        RegionDaneColombiaDTO regionDaneColombiaDTO = new RegionDaneColombiaDTO();
        regionDaneColombiaDTO.setIdRegionDaneColombia(regionDaneColombia.getIdRegionDaneColombia());
        regionDaneColombiaDTO.setNombrePaisDaneColombia(regionDaneColombia.getNombrePaisDaneColombia().toUpperCase());
        regionDaneColombiaDTO.setNombreDepartamentoDaneColombia(regionDaneColombia.getNombreDepartamentoDaneColombia().toUpperCase());
        regionDaneColombiaDTO.setNombreCiudadMunicipioDaneColombia(regionDaneColombia.getNombreCiudadMunicipioDaneColombia().toUpperCase());
        regionDaneColombiaDTO.setCodigoDaneColombia(regionDaneColombia.getCodigoDaneColombia());
        
        return regionDaneColombiaDTO;
    }
}
