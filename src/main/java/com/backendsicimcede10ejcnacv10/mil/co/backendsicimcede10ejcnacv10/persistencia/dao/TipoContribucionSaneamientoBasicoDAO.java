//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoContribucionSaneamientoBasicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContribucionSaneamientoBasico;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoContribucionSaneamientoBasicoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoContribucionSaneamientoBasicoDTO
    * Recibe un DTO para crear un objeto tipoContribucionSaneamientoBasico.
    * @return tipoContribucionSaneamientoBasico
    */
    public TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico(TipoContribucionSaneamientoBasicoDTO tipoContribucionSaneamientoBasicoDTO){
        TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico = new TipoContribucionSaneamientoBasico();
        tipoContribucionSaneamientoBasico.setIdTipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO.getIdTipoContribucionSaneamientoBasico());
        tipoContribucionSaneamientoBasico.setNombreTipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO.getNombreTipoContribucionSaneamientoBasico().toUpperCase());
        
        return tipoContribucionSaneamientoBasico;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoContribucionSaneamientoBasico
    * Recibe un DTO para un objeto tipoContribucionSaneamientoBasico para crear un DTO.
    * @return tipoContribucionSaneamientoBasicoDTO
    */
    public TipoContribucionSaneamientoBasicoDTO tipoContribucionSaneamientoBasicoDTO(TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico){
        TipoContribucionSaneamientoBasicoDTO tipoContribucionSaneamientoBasicoDTO = new TipoContribucionSaneamientoBasicoDTO();
        tipoContribucionSaneamientoBasicoDTO.setIdTipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasico.getIdTipoContribucionSaneamientoBasico());
        tipoContribucionSaneamientoBasicoDTO.setNombreTipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasico.getNombreTipoContribucionSaneamientoBasico().toUpperCase());
        
        return tipoContribucionSaneamientoBasicoDTO;
    }
}
