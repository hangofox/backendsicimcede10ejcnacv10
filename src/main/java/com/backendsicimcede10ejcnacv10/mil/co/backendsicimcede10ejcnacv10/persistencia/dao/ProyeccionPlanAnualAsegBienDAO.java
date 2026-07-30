//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAsegBienDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAsegBien;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionPlanAnualAsegBienDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqGeneralRepository proyeccionPlanAnualAdqGeneralRepository;

    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqGeneralDAO proyeccionPlanAnualAdqGeneralDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 13/04/2026.
    * @param proyeccionPlanAnualAsegBienDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualAsegBien.
    * @return proyeccionPlanAnualAsegBien
    */
    public ProyeccionPlanAnualAsegBien proyeccionPlanAnualAsegBien(ProyeccionPlanAnualAsegBienDTO proyeccionPlanAnualAsegBienDTO){
        ProyeccionPlanAnualAsegBien proyeccionPlanAnualAsegBien = new ProyeccionPlanAnualAsegBien();
        proyeccionPlanAnualAsegBien.setIdProyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBienDTO.getIdProyeccionPlanAnualAsegBien());
        proyeccionPlanAnualAsegBien.setNombreProyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBienDTO.getNombreProyeccionPlanAnualAsegBien().toUpperCase());

        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO() != null && proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAsegBienDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyeccionPlanAnualAsegBien::setProyeccionPlanAnualAdqGeneral);
        }

        return proyeccionPlanAnualAsegBien;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 13/04/2026.
    * @param proyeccionPlanAnualAsegBien
    * Recibe un objeto proyeccionPlanAnualAsegBien para crear un DTO.
    * @return proyeccionPlanAnualAsegBienDTO
    */
    public ProyeccionPlanAnualAsegBienDTO proyeccionPlanAnualAsegBienDTO(ProyeccionPlanAnualAsegBien proyeccionPlanAnualAsegBien){
        ProyeccionPlanAnualAsegBienDTO proyeccionPlanAnualAsegBienDTO = new ProyeccionPlanAnualAsegBienDTO();
        proyeccionPlanAnualAsegBienDTO.setIdProyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBien.getIdProyeccionPlanAnualAsegBien());
        proyeccionPlanAnualAsegBienDTO.setNombreProyeccionPlanAnualAsegBien(proyeccionPlanAnualAsegBien.getNombreProyeccionPlanAnualAsegBien().toUpperCase());

        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualAsegBien.getProyeccionPlanAnualAdqGeneral() != null && proyeccionPlanAnualAsegBien.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAsegBien.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyPlAnAdqGen -> proyeccionPlanAnualAsegBienDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyPlAnAdqGen)));
        }

        return proyeccionPlanAnualAsegBienDTO;
    }
}
