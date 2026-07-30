//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.GradoSiathDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.GradoSiath;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class GradoSiathDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param gradoSiathDTO
    * Recibe un DTO para crear un objeto gradoSiath.
    * @return gradoSiath
    */
    public GradoSiath gradoSiath(GradoSiathDTO gradoSiathDTO){
        GradoSiath gradoSiath = new GradoSiath();
        gradoSiath.setIdGradoSiath(gradoSiathDTO.getIdGradoSiath());
        gradoSiath.setNombreGradoSiath(gradoSiathDTO.getNombreGradoSiath().toUpperCase());
        gradoSiath.setDescripcionGradoSiath(gradoSiathDTO.getDescripcionGradoSiath().toUpperCase());
        gradoSiath.setIdSiath(gradoSiathDTO.getIdSiath());
        gradoSiath.setFuerzaSiath(gradoSiathDTO.getFuerzaSiath());
        gradoSiath.setCategoria(gradoSiathDTO.getCategoria());
        gradoSiath.setIdCategoriaSiath(gradoSiathDTO.getIdCategoriaSiath());
        gradoSiath.setOrden(gradoSiathDTO.getOrden());
        gradoSiath.setPeriodicidadConceptos(gradoSiathDTO.getPeriodicidadConceptos());
        
        return gradoSiath;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param gradoSiath
    * Recibe un DTO para un objeto gradoSiath para crear un DTO.
    * @return gradoSiathDTO
    */
    public GradoSiathDTO gradoSiathDTO(GradoSiath gradoSiath){
        GradoSiathDTO gradoSiathDTO = new GradoSiathDTO();
        gradoSiathDTO.setIdGradoSiath(gradoSiath.getIdGradoSiath());
        gradoSiathDTO.setNombreGradoSiath(gradoSiath.getNombreGradoSiath().toUpperCase());
        gradoSiathDTO.setDescripcionGradoSiath(gradoSiath.getDescripcionGradoSiath().toUpperCase());
        gradoSiathDTO.setIdSiath(gradoSiath.getIdSiath());
        gradoSiathDTO.setFuerzaSiath(gradoSiath.getFuerzaSiath());
        gradoSiathDTO.setCategoria(gradoSiath.getCategoria());
        gradoSiathDTO.setIdCategoriaSiath(gradoSiath.getIdCategoriaSiath());
        gradoSiathDTO.setOrden(gradoSiath.getOrden());
        gradoSiathDTO.setPeriodicidadConceptos(gradoSiath.getPeriodicidadConceptos());
        
        return gradoSiathDTO;
    }
}
