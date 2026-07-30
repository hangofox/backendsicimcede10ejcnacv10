//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
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
public class ProyeccionPlanAnualAdqInfraestDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqGeneralRepository proyeccionPlanAnualAdqGeneralRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqGeneralDAO proyeccionPlanAnualAdqGeneralDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualAdqInfraestDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualAdqInfraest.
    * @return proyeccionPlanAnualAdqInfraest
    */
    public ProyeccionPlanAnualAdqInfraest proyeccionPlanAnualAdqInfraest(ProyeccionPlanAnualAdqInfraestDTO proyeccionPlanAnualAdqInfraestDTO){
        ProyeccionPlanAnualAdqInfraest proyeccionPlanAnualAdqInfraest = new ProyeccionPlanAnualAdqInfraest();
        proyeccionPlanAnualAdqInfraest.setIdProyeccionPlanAnualAdqInfraest(proyeccionPlanAnualAdqInfraestDTO.getIdProyeccionPlanAnualAdqInfraest());
        proyeccionPlanAnualAdqInfraest.setNombreProyeccionPlanAnualInfraest(proyeccionPlanAnualAdqInfraestDTO.getNombreProyeccionPlanAnualInfraest().toUpperCase());
        
        //MAPEAR PROYECCION PLAN ANUAL ADQ GENERAL RELACIONADA.
        if (proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO() != null && proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqInfraestDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyeccionPlanAnualAdqInfraest::setProyeccionPlanAnualAdqGeneral);
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO() != null && proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionPlanAnualAdqInfraestDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(proyeccionPlanAnualAdqInfraest::setInfraestructura);
        }
        
        return proyeccionPlanAnualAdqInfraest;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualAdqInfraest
    * Recibe un objeto proyeccionPlanAnualAdqInfraest para crear un DTO.
    * @return proyeccionPlanAnualAdqInfraestDTO
    */
    public ProyeccionPlanAnualAdqInfraestDTO proyeccionPlanAnualAdqInfraestDTO(ProyeccionPlanAnualAdqInfraest proyeccionPlanAnualAdqInfraest){
        ProyeccionPlanAnualAdqInfraestDTO proyeccionPlanAnualAdqInfraestDTO = new ProyeccionPlanAnualAdqInfraestDTO();
        proyeccionPlanAnualAdqInfraestDTO.setIdProyeccionPlanAnualAdqInfraest(proyeccionPlanAnualAdqInfraest.getIdProyeccionPlanAnualAdqInfraest());
        proyeccionPlanAnualAdqInfraestDTO.setNombreProyeccionPlanAnualInfraest(proyeccionPlanAnualAdqInfraest.getNombreProyeccionPlanAnualInfraest().toUpperCase());
        
        //MAPEAR PROYECCION PLAN ANUAL ADQ GENERAL RELACIONADA.
        if (proyeccionPlanAnualAdqInfraest.getProyeccionPlanAnualAdqGeneral() != null && proyeccionPlanAnualAdqInfraest.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqInfraest.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyPlAnAdqGen -> proyeccionPlanAnualAdqInfraestDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyPlAnAdqGen)));
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionPlanAnualAdqInfraest.getInfraestructura() != null && proyeccionPlanAnualAdqInfraest.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionPlanAnualAdqInfraest.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> proyeccionPlanAnualAdqInfraestDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return proyeccionPlanAnualAdqInfraestDTO;
    }
}
