//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoPersonalApoyoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoPersonalApoyo;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoPersonalApoyoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoPersonalApoyoDTO
    * Recibe un DTO para crear un objeto tipoPersonalApoyo.
    * @return tipoPersonalApoyo
    */
    public TipoPersonalApoyo tipoPersonalApoyo(TipoPersonalApoyoDTO tipoPersonalApoyoDTO){
        TipoPersonalApoyo tipoPersonalApoyo = new TipoPersonalApoyo();
        tipoPersonalApoyo.setIdTipoPersonalApoyo(tipoPersonalApoyoDTO.getIdTipoPersonalApoyo());
        tipoPersonalApoyo.setNombreTipoPersonalApoyo(tipoPersonalApoyoDTO.getNombreTipoPersonalApoyo().toUpperCase());
        
        return tipoPersonalApoyo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoPersonalApoyo
    * Recibe un DTO para un objeto tipoPersonalApoyo para crear un DTO.
    * @return tipoPersonalApoyoDTO
    */
    public TipoPersonalApoyoDTO tipoPersonalApoyoDTO(TipoPersonalApoyo tipoPersonalApoyo){
        TipoPersonalApoyoDTO tipoPersonalApoyoDTO = new TipoPersonalApoyoDTO();
        tipoPersonalApoyoDTO.setIdTipoPersonalApoyo(tipoPersonalApoyo.getIdTipoPersonalApoyo());
        tipoPersonalApoyoDTO.setNombreTipoPersonalApoyo(tipoPersonalApoyo.getNombreTipoPersonalApoyo().toUpperCase());
        
        return tipoPersonalApoyoDTO;
    }
}
