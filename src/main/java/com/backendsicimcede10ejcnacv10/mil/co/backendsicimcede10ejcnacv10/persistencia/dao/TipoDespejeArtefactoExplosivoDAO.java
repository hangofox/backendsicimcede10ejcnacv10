//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDespejeArtefactoExplosivoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeArtefactoExplosivo;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoDespejeArtefactoExplosivoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDespejeArtefactoExplosivoDTO
    * Recibe un DTO para crear un objeto tipoDespejeArtefactoExplosivo.
    * @return tipoDespejeArtefactoExplosivo
    */
    public TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivo(TipoDespejeArtefactoExplosivoDTO tipoDespejeArtefactoExplosivoDTO){
        TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivo = new TipoDespejeArtefactoExplosivo();
        tipoDespejeArtefactoExplosivo.setIdTipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO.getIdTipoDespejeArtefactoExplosivo());
        tipoDespejeArtefactoExplosivo.setNombreTipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO.getNombreTipoDespejeArtefactoExplosivo().toUpperCase());
        
        return tipoDespejeArtefactoExplosivo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDespejeArtefactoExplosivo
    * Recibe un DTO para un objeto tipoDespejeArtefactoExplosivo para crear un DTO.
    * @return tipoDespejeArtefactoExplosivoDTO
    */
    public TipoDespejeArtefactoExplosivoDTO tipoDespejeArtefactoExplosivoDTO(TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivo){
        TipoDespejeArtefactoExplosivoDTO tipoDespejeArtefactoExplosivoDTO = new TipoDespejeArtefactoExplosivoDTO();
        tipoDespejeArtefactoExplosivoDTO.setIdTipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivo.getIdTipoDespejeArtefactoExplosivo());
        tipoDespejeArtefactoExplosivoDTO.setNombreTipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivo.getNombreTipoDespejeArtefactoExplosivo().toUpperCase());
        
        return tipoDespejeArtefactoExplosivoDTO;
    }
}
