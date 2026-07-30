//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PelotonUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PelotonUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CompaniaUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CompaniaUnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class PelotonUnidadMilitarDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CompaniaUnidadMilitarRepository companiaUnidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private CompaniaUnidadMilitarDAO companiaUnidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param pelotonUnidadMilitarDTO
    * Recibe un DTO para crear un objeto pelotonUnidadMilitar.
    * @return pelotonUnidadMilitar
    */
    public PelotonUnidadMilitar pelotonUnidadMilitar(PelotonUnidadMilitarDTO pelotonUnidadMilitarDTO){
        PelotonUnidadMilitar pelotonUnidadMilitar = new PelotonUnidadMilitar();
        pelotonUnidadMilitar.setIdPelotonUnidadMilitar(pelotonUnidadMilitarDTO.getIdPelotonUnidadMilitar());
        pelotonUnidadMilitar.setNombrePelotonUnidadMilitar(pelotonUnidadMilitarDTO.getNombrePelotonUnidadMilitar().toUpperCase());
        
        //MAPEAR COMPAÑIA DE UNIDAD MILITAR RELACIONADA.
        if (pelotonUnidadMilitarDTO.getCompaniaUnidadMilitarDTO() != null && pelotonUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getIdCompaniaUnidadMilitar() != null) {
           Optional<CompaniaUnidadMilitar> companiaUnidadMilitarFk = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(pelotonUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getIdCompaniaUnidadMilitar());
           companiaUnidadMilitarFk.ifPresent(pelotonUnidadMilitar::setCompaniaUnidadMilitar);
        }
        
        return pelotonUnidadMilitar;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param pelotonUnidadMilitar
    * Recibe un objeto pelotonUnidadMilitar para crear un DTO.
    * @return pelotonUnidadMilitarDTO
    */
    public PelotonUnidadMilitarDTO pelotonUnidadMilitarDTO(PelotonUnidadMilitar pelotonUnidadMilitar){
        PelotonUnidadMilitarDTO pelotonUnidadMilitarDTO = new PelotonUnidadMilitarDTO();
        pelotonUnidadMilitarDTO.setIdPelotonUnidadMilitar(pelotonUnidadMilitar.getIdPelotonUnidadMilitar());
        pelotonUnidadMilitarDTO.setNombrePelotonUnidadMilitar(pelotonUnidadMilitar.getNombrePelotonUnidadMilitar().toUpperCase());
        
        //MAPEAR COMPAÑIA DE UNIDAD MILITAR RELACIONADA.
        if (pelotonUnidadMilitar.getCompaniaUnidadMilitar() != null && pelotonUnidadMilitar.getCompaniaUnidadMilitar().getIdCompaniaUnidadMilitar() != null) {
           Optional<CompaniaUnidadMilitar> companiaUnidadMilitarFk = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(pelotonUnidadMilitar.getCompaniaUnidadMilitar().getIdCompaniaUnidadMilitar());
           companiaUnidadMilitarFk.ifPresent(companiaUnidadMilitar -> pelotonUnidadMilitarDTO.setCompaniaUnidadMilitarDTO(companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitar)));
        }
        
        return pelotonUnidadMilitarDTO;
    }
}
