//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CompaniaUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CompaniaUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CompaniaUnidadMilitarDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param companiaUnidadMilitarDTO
    * Recibe un DTO para crear un objeto companiaUnidadMilitar.
    * @return companiaUnidadMilitar
    */
    public CompaniaUnidadMilitar companiaUnidadMilitar(CompaniaUnidadMilitarDTO companiaUnidadMilitarDTO){
        CompaniaUnidadMilitar companiaUnidadMilitar = new CompaniaUnidadMilitar();
        companiaUnidadMilitar.setIdCompaniaUnidadMilitar(companiaUnidadMilitarDTO.getIdCompaniaUnidadMilitar());
        companiaUnidadMilitar.setNombreCompaniaUnidadMilitar(companiaUnidadMilitarDTO.getNombreCompaniaUnidadMilitar().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (companiaUnidadMilitarDTO.getUnidadMilitarDTO() != null && companiaUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(companiaUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(companiaUnidadMilitar::setUnidadMilitar);
        }
        
        return companiaUnidadMilitar;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param companiaUnidadMilitar
    * Recibe un objeto companiaUnidadMilitar para crear un DTO.
    * @return companiaUnidadMilitarDTO
    */
    public CompaniaUnidadMilitarDTO companiaUnidadMilitarDTO(CompaniaUnidadMilitar companiaUnidadMilitar){
        CompaniaUnidadMilitarDTO companiaUnidadMilitarDTO = new CompaniaUnidadMilitarDTO();
        companiaUnidadMilitarDTO.setIdCompaniaUnidadMilitar(companiaUnidadMilitar.getIdCompaniaUnidadMilitar());
        companiaUnidadMilitarDTO.setNombreCompaniaUnidadMilitar(companiaUnidadMilitar.getNombreCompaniaUnidadMilitar().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (companiaUnidadMilitar.getUnidadMilitar() != null && companiaUnidadMilitar.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(companiaUnidadMilitar.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> companiaUnidadMilitarDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return companiaUnidadMilitarDTO;
    }
}
