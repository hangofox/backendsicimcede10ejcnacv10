//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CiudadMundoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CiudadMundo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PaisMundo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DepartamentooEstadoMundo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.PaisMundoRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DepartamentooEstadoMundoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CiudadMundoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private PaisMundoRepository paisMundoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private PaisMundoDAO paisMundoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DepartamentooEstadoMundoRepository departamentooEstadoMundoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private DepartamentooEstadoMundoDAO departamentooEstadoMundoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param ciudadMundoDTO
    * Recibe un DTO para crear un objeto ciudad del mundo.
    * @return ciudadMundo
    */
    public CiudadMundo ciudadMundo(CiudadMundoDTO ciudadMundoDTO){
        CiudadMundo ciudadMundo = new CiudadMundo();
        ciudadMundo.setIdCiudadMundo(ciudadMundoDTO.getIdCiudadMundo());
        ciudadMundo.setNombreCiudadMundo(ciudadMundoDTO.getNombreCiudadMundo().toUpperCase());
        
        //MAPEAR PAIS DEL MUNDO RELACIONADO.
        if (ciudadMundoDTO.getPaisMundoDTO() != null && ciudadMundoDTO.getPaisMundoDTO().getIdPaisMundo() != null) {
           Optional<PaisMundo> paisMundoFk = paisMundoRepository.findByIdPaisMundo(ciudadMundoDTO.getPaisMundoDTO().getIdPaisMundo());
           paisMundoFk.ifPresent(ciudadMundo::setPaisMundo);
        }
        
        //MAPEAR DEPARTAMENTO O ESTADO DEL MUNDO RELACIONADO.
        if (ciudadMundoDTO.getDepartamentooEstadoMundoDTO() != null && ciudadMundoDTO.getDepartamentooEstadoMundoDTO().getIdDepartamentooEstadoMundo() != null) {
           Optional<DepartamentooEstadoMundo> departamentooEstadoMundoFk = departamentooEstadoMundoRepository.findByIdDepartamentooEstadoMundo(ciudadMundoDTO.getDepartamentooEstadoMundoDTO().getIdDepartamentooEstadoMundo());
           departamentooEstadoMundoFk.ifPresent(ciudadMundo::setDepartamentooEstadoMundo);
        }
        
        return ciudadMundo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param ciudadMundo
    * Recibe un objeto ciudad del mundo para crear un DTO.
    * @return ciudadMundoDTO
    */
    public CiudadMundoDTO ciudadMundoDTO(CiudadMundo ciudadMundo){
        CiudadMundoDTO ciudadMundoDTO = new CiudadMundoDTO();
        ciudadMundoDTO.setIdCiudadMundo(ciudadMundo.getIdCiudadMundo());
        ciudadMundoDTO.setNombreCiudadMundo(ciudadMundo.getNombreCiudadMundo().toUpperCase());
        
        //MAPEAR PAIS DEL MUNDO RELACIONADO.
        if (ciudadMundo.getPaisMundo() != null && ciudadMundo.getPaisMundo().getIdPaisMundo() != null) {
           Optional<PaisMundo> paisMundoFk = paisMundoRepository.findByIdPaisMundo(ciudadMundo.getPaisMundo().getIdPaisMundo());
           paisMundoFk.ifPresent(paisMundo -> ciudadMundoDTO.setPaisMundoDTO(paisMundoDAO.paisMundoDTO(paisMundo)));
        }
        
        //MAPEAR DEPARTAMENTO O ESTADO DEL MUNDO RELACIONADO.
        if (ciudadMundo.getDepartamentooEstadoMundo() != null && ciudadMundo.getDepartamentooEstadoMundo().getIdDepartamentooEstadoMundo() != null) {
           Optional<DepartamentooEstadoMundo> departamentooEstadoMundoFk = departamentooEstadoMundoRepository.findByIdDepartamentooEstadoMundo(ciudadMundo.getDepartamentooEstadoMundo().getIdDepartamentooEstadoMundo());
           departamentooEstadoMundoFk.ifPresent(departamentooEstadoMundo -> ciudadMundoDTO.setDepartamentooEstadoMundoDTO(departamentooEstadoMundoDAO.departamentooEstadoMundoDTO(departamentooEstadoMundo)));
        }
        
        return ciudadMundoDTO;
    }
}
