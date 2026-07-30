//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoCompaniaUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoCompaniaUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CompaniaUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CompaniaUnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CentroCostoCompaniaUnidadMilitarDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CompaniaUnidadMilitarRepository companiaUnidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private CompaniaUnidadMilitarDAO companiaUnidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param centroCostoCompaniaUnidadMilitarDTO
    * Recibe un DTO para crear un objeto centroCostoCompaniaUnidadMilitar.
    * @return centroCostoCompaniaUnidadMilitar
    */
    public CentroCostoCompaniaUnidadMilitar centroCostoCompaniaUnidadMilitar(CentroCostoCompaniaUnidadMilitarDTO centroCostoCompaniaUnidadMilitarDTO){
        CentroCostoCompaniaUnidadMilitar centroCostoCompaniaUnidadMilitar = new CentroCostoCompaniaUnidadMilitar();
        centroCostoCompaniaUnidadMilitar.setIdCentroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO.getIdCentroCostoCompaniaUnidadMilitar());
        centroCostoCompaniaUnidadMilitar.setCentroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO.getCentroCostoCompaniaUnidadMilitar().toUpperCase());
        
        //MAPEAR COMPAÑIA DE UNIDAD MILITAR RELACIONADA.
        if (centroCostoCompaniaUnidadMilitarDTO.getCompaniaUnidadMilitarDTO() != null && centroCostoCompaniaUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getIdCompaniaUnidadMilitar() != null) {
           Optional<CompaniaUnidadMilitar> companiaUnidadMilitarFk = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getIdCompaniaUnidadMilitar());
           companiaUnidadMilitarFk.ifPresent(centroCostoCompaniaUnidadMilitar::setCompaniaUnidadMilitar);
        }
        
        return centroCostoCompaniaUnidadMilitar;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param centroCostoCompaniaUnidadMilitar
    * Recibe un objeto centroCostoCompaniaUnidadMilitar para crear un DTO.
    * @return centroCostoCompaniaUnidadMilitarDTO
    */
    public CentroCostoCompaniaUnidadMilitarDTO centroCostoCompaniaUnidadMilitarDTO(CentroCostoCompaniaUnidadMilitar centroCostoCompaniaUnidadMilitar){
        CentroCostoCompaniaUnidadMilitarDTO centroCostoCompaniaUnidadMilitarDTO = new CentroCostoCompaniaUnidadMilitarDTO();
        centroCostoCompaniaUnidadMilitarDTO.setIdCentroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitar.getIdCentroCostoCompaniaUnidadMilitar());
        centroCostoCompaniaUnidadMilitarDTO.setCentroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitar.getCentroCostoCompaniaUnidadMilitar().toUpperCase());
        
        //MAPEAR COMPAÑIA DE UNIDAD MILITAR RELACIONADA.
        if (centroCostoCompaniaUnidadMilitar.getCompaniaUnidadMilitar() != null && centroCostoCompaniaUnidadMilitar.getCompaniaUnidadMilitar().getIdCompaniaUnidadMilitar() != null) {
           Optional<CompaniaUnidadMilitar> companiaUnidadMilitarFk = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitar.getCompaniaUnidadMilitar().getIdCompaniaUnidadMilitar());
           companiaUnidadMilitarFk.ifPresent(companiaUnidadMilitar -> centroCostoCompaniaUnidadMilitarDTO.setCompaniaUnidadMilitarDTO(companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitar)));
        }
        
        return centroCostoCompaniaUnidadMilitarDTO;
    }
}
