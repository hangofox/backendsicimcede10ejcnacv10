//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoPelotonUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoPelotonUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PelotonUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.PelotonUnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CentroCostoPelotonUnidadMilitarDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private PelotonUnidadMilitarRepository pelotonUnidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private PelotonUnidadMilitarDAO pelotonUnidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param centroCostoPelotonUnidadMilitarDTO
    * Recibe un DTO para crear un objeto centroCostoPelotonUnidadMilitar.
    * @return centroCostoPelotonUnidadMilitar
    */
    public CentroCostoPelotonUnidadMilitar centroCostoPelotonUnidadMilitar(CentroCostoPelotonUnidadMilitarDTO centroCostoPelotonUnidadMilitarDTO){
        CentroCostoPelotonUnidadMilitar centroCostoPelotonUnidadMilitar = new CentroCostoPelotonUnidadMilitar();
        centroCostoPelotonUnidadMilitar.setIdCentroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO.getIdCentroCostoPelotonUnidadMilitar());
        centroCostoPelotonUnidadMilitar.setCentroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO.getCentroCostoPelotonUnidadMilitar().toUpperCase());
        
        //MAPEAR PELOTÓN DE UNIDAD MILITAR RELACIONADO.
        if (centroCostoPelotonUnidadMilitarDTO.getPelotonUnidadMilitarDTO() != null && centroCostoPelotonUnidadMilitarDTO.getPelotonUnidadMilitarDTO().getIdPelotonUnidadMilitar() != null) {
           Optional<PelotonUnidadMilitar> pelotonUnidadMilitarFk = pelotonUnidadMilitarRepository.findByIdPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO.getPelotonUnidadMilitarDTO().getIdPelotonUnidadMilitar());
           pelotonUnidadMilitarFk.ifPresent(centroCostoPelotonUnidadMilitar::setPelotonUnidadMilitar);
        }
        
        return centroCostoPelotonUnidadMilitar;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param centroCostoPelotonUnidadMilitar
    * Recibe un objeto centroCostoPelotonUnidadMilitar para crear un DTO.
    * @return centroCostoPelotonUnidadMilitarDTO
    */
    public CentroCostoPelotonUnidadMilitarDTO centroCostoPelotonUnidadMilitarDTO(CentroCostoPelotonUnidadMilitar centroCostoPelotonUnidadMilitar){
        CentroCostoPelotonUnidadMilitarDTO centroCostoPelotonUnidadMilitarDTO = new CentroCostoPelotonUnidadMilitarDTO();
        centroCostoPelotonUnidadMilitarDTO.setIdCentroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitar.getIdCentroCostoPelotonUnidadMilitar());
        centroCostoPelotonUnidadMilitarDTO.setCentroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitar.getCentroCostoPelotonUnidadMilitar().toUpperCase());
        
        //MAPEAR PELOTÓN DE UNIDAD MILITAR RELACIONADO.
        if (centroCostoPelotonUnidadMilitar.getPelotonUnidadMilitar() != null && centroCostoPelotonUnidadMilitar.getPelotonUnidadMilitar().getIdPelotonUnidadMilitar() != null) {
           Optional<PelotonUnidadMilitar> pelotonUnidadMilitarFk = pelotonUnidadMilitarRepository.findByIdPelotonUnidadMilitar(centroCostoPelotonUnidadMilitar.getPelotonUnidadMilitar().getIdPelotonUnidadMilitar());
           pelotonUnidadMilitarFk.ifPresent(pelotonUnidadMilitar -> centroCostoPelotonUnidadMilitarDTO.setPelotonUnidadMilitarDTO(pelotonUnidadMilitarDAO.pelotonUnidadMilitarDTO(pelotonUnidadMilitar)));
        }
        
        return centroCostoPelotonUnidadMilitarDTO;
    }
}
