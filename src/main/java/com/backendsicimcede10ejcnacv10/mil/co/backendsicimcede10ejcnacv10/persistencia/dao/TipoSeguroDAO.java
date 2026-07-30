//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoSeguroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoSeguro;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoSeguroDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoSeguroDTO
    * Recibe un DTO para crear un objeto tipoSeguro.
    * @return tipoSeguro
    */
    public TipoSeguro tipoSeguro(TipoSeguroDTO tipoSeguroDTO){
        TipoSeguro tipoSeguro = new TipoSeguro();
        tipoSeguro.setIdTipoSeguro(tipoSeguroDTO.getIdTipoSeguro());
        tipoSeguro.setNombreTipoSeguro(tipoSeguroDTO.getNombreTipoSeguro().toUpperCase());
        
        return tipoSeguro;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoSeguro
    * Recibe un DTO para un objeto tipoSeguro para crear un DTO.
    * @return tipoSeguroDTO
    */
    public TipoSeguroDTO tipoSeguroDTO(TipoSeguro tipoSeguro){
        TipoSeguroDTO tipoSeguroDTO = new TipoSeguroDTO();
        tipoSeguroDTO.setIdTipoSeguro(tipoSeguro.getIdTipoSeguro());
        tipoSeguroDTO.setNombreTipoSeguro(tipoSeguro.getNombreTipoSeguro().toUpperCase());
        
        return tipoSeguroDTO;
    }
}
