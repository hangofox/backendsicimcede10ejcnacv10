//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqGeneralDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionPlanAnualAdqGeneralDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param proyeccionPlanAnualAdqGeneralDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualAdqGeneral.
    * @return proyeccionPlanAnualAdqGeneral
    */
    public ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneralDTO proyeccionPlanAnualAdqGeneralDTO){
        ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral = new ProyeccionPlanAnualAdqGeneral();
        proyeccionPlanAnualAdqGeneral.setIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO.getIdProyeccionPlanAnualAdqGeneral());
        proyeccionPlanAnualAdqGeneral.setNombreProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO.getNombreProyeccionPlanAnualAdqGeneral().toUpperCase());
        
        return proyeccionPlanAnualAdqGeneral;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param proyeccionPlanAnualAdqGeneral
    * Recibe un DTO para un objeto proyeccionPlanAnualAdqGeneral para crear un DTO.
    * @return proyeccionPlanAnualAdqGeneralDTO
    */
    public ProyeccionPlanAnualAdqGeneralDTO proyeccionPlanAnualAdqGeneralDTO(ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral){
        ProyeccionPlanAnualAdqGeneralDTO proyeccionPlanAnualAdqGeneralDTO = new ProyeccionPlanAnualAdqGeneralDTO();
        proyeccionPlanAnualAdqGeneralDTO.setIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneral.getIdProyeccionPlanAnualAdqGeneral());
        proyeccionPlanAnualAdqGeneralDTO.setNombreProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneral.getNombreProyeccionPlanAnualAdqGeneral().toUpperCase());
        
        return proyeccionPlanAnualAdqGeneralDTO;
    }
}
