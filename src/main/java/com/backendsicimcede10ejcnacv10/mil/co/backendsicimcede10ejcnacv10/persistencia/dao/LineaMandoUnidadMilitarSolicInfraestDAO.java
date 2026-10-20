//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaMandoUnidadMilitarSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitarSolicInfraest;
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
public class LineaMandoUnidadMilitarSolicInfraestDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/10/2026.
    * @param lineaMandoUnidadMilitarSolicInfraestDTO
    * Recibe un DTO para crear un objeto lineaMandoUnidadMilitarSolicInfraest.
    * @return lineaMandoUnidadMilitarSolicInfraest
    */
    public LineaMandoUnidadMilitarSolicInfraest lineaMandoUnidadMilitarSolicInfraest(LineaMandoUnidadMilitarSolicInfraestDTO lineaMandoUnidadMilitarSolicInfraestDTO){
        LineaMandoUnidadMilitarSolicInfraest lineaMandoUnidadMilitarSolicInfraest = new LineaMandoUnidadMilitarSolicInfraest();
        lineaMandoUnidadMilitarSolicInfraest.setIdLineaMandoUnidadMilitarSolicInfraest(lineaMandoUnidadMilitarSolicInfraestDTO.getIdLineaMandoUnidadMilitarSolicInfraest());
        lineaMandoUnidadMilitarSolicInfraest.setLineaMandoUnidadMilitarSolicInfraest(lineaMandoUnidadMilitarSolicInfraestDTO.getLineaMandoUnidadMilitarSolicInfraest().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (lineaMandoUnidadMilitarSolicInfraestDTO.getUnidadMilitarDTO() != null && lineaMandoUnidadMilitarSolicInfraestDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitarSolicInfraestDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(lineaMandoUnidadMilitarSolicInfraest::setUnidadMilitar);
        }
        
        return lineaMandoUnidadMilitarSolicInfraest;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/10/2026.
    * @param lineaMandoUnidadMilitarSolicInfraest
    * Recibe un objeto lineaMandoUnidadMilitarSolicInfraest para crear un DTO.
    * @return lineaMandoUnidadMilitarSolicInfraestDTO
    */
    public LineaMandoUnidadMilitarSolicInfraestDTO lineaMandoUnidadMilitarSolicInfraestDTO(LineaMandoUnidadMilitarSolicInfraest lineaMandoUnidadMilitarSolicInfraest){
        LineaMandoUnidadMilitarSolicInfraestDTO lineaMandoUnidadMilitarSolicInfraestDTO = new LineaMandoUnidadMilitarSolicInfraestDTO();
        lineaMandoUnidadMilitarSolicInfraestDTO.setIdLineaMandoUnidadMilitarSolicInfraest(lineaMandoUnidadMilitarSolicInfraest.getIdLineaMandoUnidadMilitarSolicInfraest());
        lineaMandoUnidadMilitarSolicInfraestDTO.setLineaMandoUnidadMilitarSolicInfraest(lineaMandoUnidadMilitarSolicInfraest.getLineaMandoUnidadMilitarSolicInfraest().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (lineaMandoUnidadMilitarSolicInfraest.getUnidadMilitar() != null && lineaMandoUnidadMilitarSolicInfraest.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitarSolicInfraest.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> lineaMandoUnidadMilitarSolicInfraestDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return lineaMandoUnidadMilitarSolicInfraestDTO;
    }
}
