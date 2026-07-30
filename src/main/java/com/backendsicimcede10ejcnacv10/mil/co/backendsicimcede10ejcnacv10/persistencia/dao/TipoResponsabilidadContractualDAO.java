//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoResponsabilidadContractualDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoResponsabilidadContractual;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoResponsabilidadContractualDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoResponsabilidadContractualDTO
    * Recibe un DTO para crear un objeto tipoResponsabilidadContractual.
    * @return tipoResponsabilidadContractual
    */
    public TipoResponsabilidadContractual tipoResponsabilidadContractual(TipoResponsabilidadContractualDTO tipoResponsabilidadContractualDTO){
        TipoResponsabilidadContractual tipoResponsabilidadContractual = new TipoResponsabilidadContractual();
        tipoResponsabilidadContractual.setIdTipoResponsabilidadContractual(tipoResponsabilidadContractualDTO.getIdTipoResponsabilidadContractual());
        tipoResponsabilidadContractual.setNombreTipoResponsabilidadContractual(tipoResponsabilidadContractualDTO.getNombreTipoResponsabilidadContractual().toUpperCase());
        
        return tipoResponsabilidadContractual;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoResponsabilidadContractual
    * Recibe un DTO para un objeto tipoResponsabilidadContractual para crear un DTO.
    * @return tipoResponsabilidadContractualDTO
    */
    public TipoResponsabilidadContractualDTO tipoResponsabilidadContractualDTO(TipoResponsabilidadContractual tipoResponsabilidadContractual){
        TipoResponsabilidadContractualDTO tipoResponsabilidadContractualDTO = new TipoResponsabilidadContractualDTO();
        tipoResponsabilidadContractualDTO.setIdTipoResponsabilidadContractual(tipoResponsabilidadContractual.getIdTipoResponsabilidadContractual());
        tipoResponsabilidadContractualDTO.setNombreTipoResponsabilidadContractual(tipoResponsabilidadContractual.getNombreTipoResponsabilidadContractual().toUpperCase());
        
        return tipoResponsabilidadContractualDTO;
    }
}
