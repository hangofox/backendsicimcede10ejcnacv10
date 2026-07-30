//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast.
    * @return tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast
    */
    public TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO){
        TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast = new TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast();
        tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast.setIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.getIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast());
        tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast.setNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        
        return tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast
    * Recibe un DTO para un objeto tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast para crear un DTO.
    * @return tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO
    */
    public TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast){
        TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO = new TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO();
        tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.setIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast.getIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast());
        tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO.setNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast.getNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        
        return tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO;
    }
}
