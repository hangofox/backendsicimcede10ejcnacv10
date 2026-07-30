//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.OficinaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Oficina;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class OficinaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param oficinaDTO
    * Recibe un DTO para crear un objeto oficina.
    * @return oficina
    */
    public Oficina oficina(OficinaDTO oficinaDTO){
        Oficina oficina = new Oficina();
        oficina.setIdOficina(oficinaDTO.getIdOficina());
        oficina.setNombreOficina(oficinaDTO.getNombreOficina().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (oficinaDTO.getUnidadMilitarDTO() != null && oficinaDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(oficinaDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(oficina::setUnidadMilitar);
        }
        
        return oficina;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param oficina
    * Recibe un objeto oficina para crear un DTO.
    * @return oficinaDTO
    */
    public OficinaDTO oficinaDTO(Oficina oficina){
        OficinaDTO oficinaDTO = new OficinaDTO();
        oficinaDTO.setIdOficina(oficina.getIdOficina());
        oficinaDTO.setNombreOficina(oficina.getNombreOficina().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (oficina.getUnidadMilitar() != null && oficina.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(oficina.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> oficinaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return oficinaDTO;
    }
}
