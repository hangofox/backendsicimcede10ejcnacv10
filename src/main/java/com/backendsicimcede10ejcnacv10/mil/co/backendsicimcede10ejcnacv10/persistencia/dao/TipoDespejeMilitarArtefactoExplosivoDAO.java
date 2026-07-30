//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDespejeMilitarArtefactoExplosivoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeMilitarArtefactoExplosivo;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoDespejeMilitarArtefactoExplosivoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDespejeMilitarArtefactoExplosivoDTO
    * Recibe un DTO para crear un objeto tipoDespejeMilitarArtefactoExplosivo.
    * @return tipoDespejeMilitarArtefactoExplosivo
    */
    public TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo(TipoDespejeMilitarArtefactoExplosivoDTO tipoDespejeMilitarArtefactoExplosivoDTO){
        TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo = new TipoDespejeMilitarArtefactoExplosivo();
        tipoDespejeMilitarArtefactoExplosivo.setIdTipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO.getIdTipoDespejeMilitarArtefactoExplosivo());
        tipoDespejeMilitarArtefactoExplosivo.setNombreTipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO.getNombreTipoDespejeMilitarArtefactoExplosivo().toUpperCase());
        
        return tipoDespejeMilitarArtefactoExplosivo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoDespejeMilitarArtefactoExplosivo
    * Recibe un DTO para un objeto tipoDespejeMilitarArtefactoExplosivo para crear un DTO.
    * @return tipoDespejeMilitarArtefactoExplosivoDTO
    */
    public TipoDespejeMilitarArtefactoExplosivoDTO tipoDespejeMilitarArtefactoExplosivoDTO(TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo){
        TipoDespejeMilitarArtefactoExplosivoDTO tipoDespejeMilitarArtefactoExplosivoDTO = new TipoDespejeMilitarArtefactoExplosivoDTO();
        tipoDespejeMilitarArtefactoExplosivoDTO.setIdTipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivo.getIdTipoDespejeMilitarArtefactoExplosivo());
        tipoDespejeMilitarArtefactoExplosivoDTO.setNombreTipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivo.getNombreTipoDespejeMilitarArtefactoExplosivo().toUpperCase());
        
        return tipoDespejeMilitarArtefactoExplosivoDTO;
    }
}
