//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoUnidadMilitar;
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
public class CentroCostoUnidadMilitarDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param centroCostoUnidadMilitarDTO
    * Recibe un DTO para crear un objeto centroCostoUnidadMilitar.
    * @return centroCostoUnidadMilitar
    */
    public CentroCostoUnidadMilitar centroCostoUnidadMilitar(CentroCostoUnidadMilitarDTO centroCostoUnidadMilitarDTO){
        CentroCostoUnidadMilitar centroCostoUnidadMilitar = new CentroCostoUnidadMilitar();
        centroCostoUnidadMilitar.setIdCentroCostoUnidadMilitar(centroCostoUnidadMilitarDTO.getIdCentroCostoUnidadMilitar());
        centroCostoUnidadMilitar.setCentroCostoUnidadMilitar(centroCostoUnidadMilitarDTO.getCentroCostoUnidadMilitar().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (centroCostoUnidadMilitarDTO.getUnidadMilitarDTO() != null && centroCostoUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(centroCostoUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(centroCostoUnidadMilitar::setUnidadMilitar);
        }
        
        return centroCostoUnidadMilitar;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param centroCostoUnidadMilitar
    * Recibe un objeto centroCostoUnidadMilitar para crear un DTO.
    * @return centroCostoUnidadMilitarDTO
    */
    public CentroCostoUnidadMilitarDTO centroCostoUnidadMilitarDTO(CentroCostoUnidadMilitar centroCostoUnidadMilitar){
        CentroCostoUnidadMilitarDTO centroCostoUnidadMilitarDTO = new CentroCostoUnidadMilitarDTO();
        centroCostoUnidadMilitarDTO.setIdCentroCostoUnidadMilitar(centroCostoUnidadMilitar.getIdCentroCostoUnidadMilitar());
        centroCostoUnidadMilitarDTO.setCentroCostoUnidadMilitar(centroCostoUnidadMilitar.getCentroCostoUnidadMilitar().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (centroCostoUnidadMilitar.getUnidadMilitar() != null && centroCostoUnidadMilitar.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(centroCostoUnidadMilitar.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> centroCostoUnidadMilitarDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return centroCostoUnidadMilitarDTO;
    }
}
