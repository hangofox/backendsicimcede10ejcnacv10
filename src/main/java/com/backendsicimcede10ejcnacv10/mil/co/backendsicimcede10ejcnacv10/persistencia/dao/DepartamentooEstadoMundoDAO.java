//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DepartamentooEstadoMundoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DepartamentooEstadoMundo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PaisMundo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.PaisMundoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class DepartamentooEstadoMundoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private PaisMundoRepository paisMundoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private PaisMundoDAO paisMundoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param departamentooEstadoMundoDTO
    * Recibe un DTO para crear un objeto departamento o estado del mundo.
    * @return departamentooEstadoMundo
    */
    public DepartamentooEstadoMundo departamentooEstadoMundo(DepartamentooEstadoMundoDTO departamentooEstadoMundoDTO){
        DepartamentooEstadoMundo departamentooEstadoMundo = new DepartamentooEstadoMundo();
        departamentooEstadoMundo.setIdDepartamentooEstadoMundo(departamentooEstadoMundoDTO.getIdDepartamentooEstadoMundo());
        departamentooEstadoMundo.setNombreDepartamentooEstadoMundo(departamentooEstadoMundoDTO.getNombreDepartamentooEstadoMundo().toUpperCase());
        
        //MAPEAR PAIS DEL MUNDO RELACIONADO.
        if (departamentooEstadoMundoDTO.getPaisMundoDTO() != null && departamentooEstadoMundoDTO.getPaisMundoDTO().getIdPaisMundo() != null) {
           Optional<PaisMundo> paisMundoFk = paisMundoRepository.findByIdPaisMundo(departamentooEstadoMundoDTO.getPaisMundoDTO().getIdPaisMundo());
           paisMundoFk.ifPresent(departamentooEstadoMundo::setPaisMundo);
        }
        
        return departamentooEstadoMundo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param departamentooEstadoMundo
    * Recibe un objeto departamento o estado del mundo para crear un DTO.
    * @return departamentooEstadoMundoDTO
    */
    public DepartamentooEstadoMundoDTO departamentooEstadoMundoDTO(DepartamentooEstadoMundo departamentooEstadoMundo){
        DepartamentooEstadoMundoDTO departamentooEstadoMundoDTO = new DepartamentooEstadoMundoDTO();
        departamentooEstadoMundoDTO.setIdDepartamentooEstadoMundo(departamentooEstadoMundo.getIdDepartamentooEstadoMundo());
        departamentooEstadoMundoDTO.setNombreDepartamentooEstadoMundo(departamentooEstadoMundo.getNombreDepartamentooEstadoMundo().toUpperCase());
        
        //MAPEAR PAIS DEL MUNDO RELACIONADO.
        if (departamentooEstadoMundo.getPaisMundo() != null && departamentooEstadoMundo.getPaisMundo().getIdPaisMundo() != null) {
           Optional<PaisMundo> paisMundoFk = paisMundoRepository.findByIdPaisMundo(departamentooEstadoMundo.getPaisMundo().getIdPaisMundo());
           paisMundoFk.ifPresent(paisMundo -> departamentooEstadoMundoDTO.setPaisMundoDTO(paisMundoDAO.paisMundoDTO(paisMundo)));
        }
        
        return departamentooEstadoMundoDTO;
    }
}
