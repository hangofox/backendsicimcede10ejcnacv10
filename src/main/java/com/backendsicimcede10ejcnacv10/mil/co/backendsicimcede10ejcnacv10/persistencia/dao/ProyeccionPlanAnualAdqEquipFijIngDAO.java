//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqEquipFijIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqEquipFijIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionPlanAnualAdqEquipFijIngDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqGeneralRepository proyeccionPlanAnualAdqGeneralRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqGeneralDAO proyeccionPlanAnualAdqGeneralDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualAdqEquipFijIngDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualAdqEquipFijIng.
    * @return proyeccionPlanAnualAdqEquipFijIng
    */
    public ProyeccionPlanAnualAdqEquipFijIng proyeccionPlanAnualAdqEquipFijIng(ProyeccionPlanAnualAdqEquipFijIngDTO proyeccionPlanAnualAdqEquipFijIngDTO){
        ProyeccionPlanAnualAdqEquipFijIng proyeccionPlanAnualAdqEquipFijIng = new ProyeccionPlanAnualAdqEquipFijIng();
        proyeccionPlanAnualAdqEquipFijIng.setIdProyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIngDTO.getIdProyeccionPlanAnualAdqEquipFijIng());
        proyeccionPlanAnualAdqEquipFijIng.setNombreProyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIngDTO.getNombreProyeccionPlanAnualAdqEquipFijIng().toUpperCase());
        
        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO() != null && proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqEquipFijIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyeccionPlanAnualAdqEquipFijIng::setProyeccionPlanAnualAdqGeneral);
        }
        
        return proyeccionPlanAnualAdqEquipFijIng;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualAdqEquipFijIng
    * Recibe un objeto proyeccionPlanAnualAdqEquipFijIng para crear un DTO.
    * @return proyeccionPlanAnualAdqEquipFijIngDTO
    */
    public ProyeccionPlanAnualAdqEquipFijIngDTO proyeccionPlanAnualAdqEquipFijIngDTO(ProyeccionPlanAnualAdqEquipFijIng proyeccionPlanAnualAdqEquipFijIng){
        ProyeccionPlanAnualAdqEquipFijIngDTO proyeccionPlanAnualAdqEquipFijIngDTO = new ProyeccionPlanAnualAdqEquipFijIngDTO();
        proyeccionPlanAnualAdqEquipFijIngDTO.setIdProyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIng.getIdProyeccionPlanAnualAdqEquipFijIng());
        proyeccionPlanAnualAdqEquipFijIngDTO.setNombreProyeccionPlanAnualAdqEquipFijIng(proyeccionPlanAnualAdqEquipFijIng.getNombreProyeccionPlanAnualAdqEquipFijIng().toUpperCase());
        
        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualAdqEquipFijIng.getProyeccionPlanAnualAdqGeneral() != null && proyeccionPlanAnualAdqEquipFijIng.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqEquipFijIng.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyPlAnAdqGen -> proyeccionPlanAnualAdqEquipFijIngDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyPlAnAdqGen)));
        }
        
        return proyeccionPlanAnualAdqEquipFijIngDTO;
    }
}
