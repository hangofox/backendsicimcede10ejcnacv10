//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaMandoUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class LineaMandoUnidadMilitarDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/10/2026.
    * @param lineaMandoUnidadMilitarDTO
    * Recibe un DTO para crear un objeto lineaMandoUnidadMilitar.
    * @return lineaMandoUnidadMilitar
    */
    public LineaMandoUnidadMilitar lineaMandoUnidadMilitar(LineaMandoUnidadMilitarDTO lineaMandoUnidadMilitarDTO){
        LineaMandoUnidadMilitar lineaMandoUnidadMilitar = new LineaMandoUnidadMilitar();
        lineaMandoUnidadMilitar.setIdLineaMandoUnidadMilitar(lineaMandoUnidadMilitarDTO.getIdLineaMandoUnidadMilitar());
        lineaMandoUnidadMilitar.setLineaMandoUnidadMilitar(lineaMandoUnidadMilitarDTO.getLineaMandoUnidadMilitar().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (lineaMandoUnidadMilitarDTO.getUnidadMilitarDTO() != null && lineaMandoUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(lineaMandoUnidadMilitar::setUnidadMilitar);
        }
        
        return lineaMandoUnidadMilitar;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/10/2026.
    * @param lineaMandoUnidadMilitar
    * Recibe un objeto lineaMandoUnidadMilitar para crear un DTO.
    * @return lineaMandoUnidadMilitarDTO
    */
    public LineaMandoUnidadMilitarDTO lineaMandoUnidadMilitarDTO(LineaMandoUnidadMilitar lineaMandoUnidadMilitar){
        LineaMandoUnidadMilitarDTO lineaMandoUnidadMilitarDTO = new LineaMandoUnidadMilitarDTO();
        lineaMandoUnidadMilitarDTO.setIdLineaMandoUnidadMilitar(lineaMandoUnidadMilitar.getIdLineaMandoUnidadMilitar());
        lineaMandoUnidadMilitarDTO.setLineaMandoUnidadMilitar(lineaMandoUnidadMilitar.getLineaMandoUnidadMilitar().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (lineaMandoUnidadMilitar.getUnidadMilitar() != null && lineaMandoUnidadMilitar.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitar.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> lineaMandoUnidadMilitarDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return lineaMandoUnidadMilitarDTO;
    }
}
