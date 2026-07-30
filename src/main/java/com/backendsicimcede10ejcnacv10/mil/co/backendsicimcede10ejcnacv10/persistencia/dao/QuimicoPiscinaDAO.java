//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.QuimicoPiscinaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.QuimicoPiscina;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class QuimicoPiscinaDAO {
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param quimicoPiscinaDTO
    * Recibe un DTO para crear un objeto quimicoPiscina.
    * @return quimicoPiscina
    */
    public QuimicoPiscina quimicoPiscina(QuimicoPiscinaDTO quimicoPiscinaDTO){
        QuimicoPiscina quimicoPiscina = new QuimicoPiscina();
        quimicoPiscina.setIdQuimicoPiscina(quimicoPiscinaDTO.getIdQuimicoPiscina());
        quimicoPiscina.setNombreQuimicoPiscina(quimicoPiscinaDTO.getNombreQuimicoPiscina().toUpperCase());
        return quimicoPiscina;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param quimicoPiscina
    * Recibe un objeto quimicoPiscina para crear un DTO.
    * @return quimicoPiscinaDTO
    */
    public QuimicoPiscinaDTO quimicoPiscinaDTO(QuimicoPiscina quimicoPiscina){
        QuimicoPiscinaDTO quimicoPiscinaDTO = new QuimicoPiscinaDTO();
        quimicoPiscinaDTO.setIdQuimicoPiscina(quimicoPiscina.getIdQuimicoPiscina());
        quimicoPiscinaDTO.setNombreQuimicoPiscina(quimicoPiscina.getNombreQuimicoPiscina().toUpperCase());
        return quimicoPiscinaDTO;
    }
}
