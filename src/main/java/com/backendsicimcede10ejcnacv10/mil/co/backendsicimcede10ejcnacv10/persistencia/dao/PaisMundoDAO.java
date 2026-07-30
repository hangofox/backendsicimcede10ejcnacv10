//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PaisMundoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PaisMundo;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class PaisMundoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param paisMundoDTO
    * Recibe un DTO para crear un objeto paisMundo.
    * @return paisMundo
    */
    public PaisMundo paisMundo(PaisMundoDTO paisMundoDTO){
        PaisMundo paisMundo = new PaisMundo();
        paisMundo.setIdPaisMundo(paisMundoDTO.getIdPaisMundo());
        paisMundo.setNombrePaisMundo(paisMundoDTO.getNombrePaisMundo().toUpperCase());
        
        return paisMundo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param paisMundo
    * Recibe un DTO para un objeto paisMundo para crear un DTO.
    * @return paisMundoDTO
    */
    public PaisMundoDTO paisMundoDTO(PaisMundo paisMundo){
        PaisMundoDTO paisMundoDTO = new PaisMundoDTO();
        paisMundoDTO.setIdPaisMundo(paisMundo.getIdPaisMundo());
        paisMundoDTO.setNombrePaisMundo(paisMundo.getNombrePaisMundo().toUpperCase());

        return paisMundoDTO;
    }
}
