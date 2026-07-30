//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoActividadExpEquipHerrYPerrDispArtefExpDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoActividadExpEquipHerrYPerrDispArtefExp;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoActividadExpEquipHerrYPerrDispArtefExpDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoActividadExpEquipHerrYPerrDispArtefExpDTO
    * Recibe un DTO para crear un objeto tipoActividadExpEquipHerrYPerrDispArtefExp.
    * @return tipoActividadExpEquipHerrYPerrDispArtefExp
    */
    public TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExp(TipoActividadExpEquipHerrYPerrDispArtefExpDTO tipoActividadExpEquipHerrYPerrDispArtefExpDTO){
        TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExp = new TipoActividadExpEquipHerrYPerrDispArtefExp();
        tipoActividadExpEquipHerrYPerrDispArtefExp.setIdTipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO.getIdTipoActividadExpEquipHerrYPerrDispArtefExp());
        tipoActividadExpEquipHerrYPerrDispArtefExp.setNombreTipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO.getNombreTipoActividadExpEquipHerrYPerrDispArtefExp().toUpperCase());
        
        return tipoActividadExpEquipHerrYPerrDispArtefExp;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoActividadExpEquipHerrYPerrDispArtefExp
    * Recibe un DTO para un objeto tipoActividadExpEquipHerrYPerrDispArtefExp para crear un DTO.
    * @return tipoActividadExpEquipHerrYPerrDispArtefExpDTO
    */
    public TipoActividadExpEquipHerrYPerrDispArtefExpDTO tipoActividadExpEquipHerrYPerrDispArtefExpDTO(TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExp){
        TipoActividadExpEquipHerrYPerrDispArtefExpDTO tipoActividadExpEquipHerrYPerrDispArtefExpDTO = new TipoActividadExpEquipHerrYPerrDispArtefExpDTO();
        tipoActividadExpEquipHerrYPerrDispArtefExpDTO.setIdTipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExp.getIdTipoActividadExpEquipHerrYPerrDispArtefExp());
        tipoActividadExpEquipHerrYPerrDispArtefExpDTO.setNombreTipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExp.getNombreTipoActividadExpEquipHerrYPerrDispArtefExp().toUpperCase());
        
        return tipoActividadExpEquipHerrYPerrDispArtefExpDTO;
    }
}
