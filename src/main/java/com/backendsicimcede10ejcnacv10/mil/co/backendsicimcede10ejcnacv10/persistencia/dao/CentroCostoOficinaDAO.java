//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoOficinaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoOficina;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Oficina;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 18/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CentroCostoOficinaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private OficinaRepository oficinaRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private OficinaDAO oficinaDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 18/12/2025.
    * @param centroCostoOficinaDTO
    * Recibe un DTO para crear un objeto centroCostoOficina.
    * @return centroCostoOficina
    */
    public CentroCostoOficina centroCostoOficina(CentroCostoOficinaDTO centroCostoOficinaDTO){
        CentroCostoOficina centroCostoOficina = new CentroCostoOficina();
        centroCostoOficina.setIdCentroCostoOficina(centroCostoOficinaDTO.getIdCentroCostoOficina());
        centroCostoOficina.setCentroCostoOficina(centroCostoOficinaDTO.getCentroCostoOficina());
        
        //MAPEAR OFICINA RELACIONADA.
        if (centroCostoOficinaDTO.getOficinaDTO() != null && centroCostoOficinaDTO.getOficinaDTO().getIdOficina() != null) {
           Optional<Oficina> oficinaFk = oficinaRepository.findByIdOficina(centroCostoOficinaDTO.getOficinaDTO().getIdOficina());
           oficinaFk.ifPresent(centroCostoOficina::setOficina);
        }
        
        return centroCostoOficina;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 18/12/2025.
    * @param centroCostoOficina
    * Recibe un objeto centroCostoOficina para crear un DTO.
    * @return centroCostoOficinaDTO
    */
    public CentroCostoOficinaDTO centroCostoOficinaDTO(CentroCostoOficina centroCostoOficina){
        CentroCostoOficinaDTO centroCostoOficinaDTO = new CentroCostoOficinaDTO();
        centroCostoOficinaDTO.setIdCentroCostoOficina(centroCostoOficina.getIdCentroCostoOficina());
        centroCostoOficinaDTO.setCentroCostoOficina(centroCostoOficina.getCentroCostoOficina());
        
        //MAPEAR OFICINA RELACIONADA.
        if (centroCostoOficina.getOficina() != null && centroCostoOficina.getOficina().getIdOficina() != null) {
           Optional<Oficina> oficinaFk = oficinaRepository.findByIdOficina(centroCostoOficina.getOficina().getIdOficina());
           oficinaFk.ifPresent(oficina -> centroCostoOficinaDTO.setOficinaDTO(oficinaDAO.oficinaDTO(oficina)));
        }
        
        return centroCostoOficinaDTO;
    }
}
