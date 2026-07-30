//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMedidaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMedida;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class UnidadMedidaDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param unidadMedidaDTO
    * Recibe un DTO para crear un objeto unidadMedida.
    * @return unidadMedida
    */
    public UnidadMedida unidadMedida(UnidadMedidaDTO unidadMedidaDTO){
        UnidadMedida unidadMedida = new UnidadMedida();
        unidadMedida.setIdUnidadMedida(unidadMedidaDTO.getIdUnidadMedida());
        unidadMedida.setNombreUnidadMedida(unidadMedidaDTO.getNombreUnidadMedida().toUpperCase());
        unidadMedida.setSiglaoAcronimoUnidadMedida(unidadMedidaDTO.getSiglaoAcronimoUnidadMedida().toUpperCase());
        unidadMedida.setNombreCategoriaUnidadMedida(unidadMedidaDTO.getNombreCategoriaUnidadMedida().toUpperCase());
        
        return unidadMedida;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param unidadMedida
    * Recibe un DTO para un objeto unidadMedida para crear un DTO.
    * @return unidadMedidaDTO
    */
    public UnidadMedidaDTO unidadMedidaDTO(UnidadMedida unidadMedida){
        UnidadMedidaDTO unidadMedidaDTO = new UnidadMedidaDTO();
        unidadMedidaDTO.setIdUnidadMedida(unidadMedida.getIdUnidadMedida());
        unidadMedidaDTO.setNombreUnidadMedida(unidadMedida.getNombreUnidadMedida().toUpperCase());
        unidadMedidaDTO.setSiglaoAcronimoUnidadMedida(unidadMedida.getSiglaoAcronimoUnidadMedida().toUpperCase());
        unidadMedidaDTO.setNombreCategoriaUnidadMedida(unidadMedida.getNombreCategoriaUnidadMedida().toUpperCase());
        
        return unidadMedidaDTO;
    }
}
