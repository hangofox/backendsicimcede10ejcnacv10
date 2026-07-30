//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqCdoIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DestinacionMantenimientoCdoIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqCdoIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DestinacionMantenimientoCdoIngRepository;
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
public class ProyeccionPlanAnualAdqCdoIngDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqGeneralRepository proyeccionPlanAnualAdqGeneralRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqGeneralDAO proyeccionPlanAnualAdqGeneralDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DestinacionMantenimientoCdoIngRepository destinacionMantenimientoCdoIngRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private DestinacionMantenimientoCdoIngDAO destinacionMantenimientoCdoIngDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualAdqCdoIngDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualAdqCdoIng.
    * @return proyeccionPlanAnualAdqCdoIng
    */
    public ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIng(ProyeccionPlanAnualAdqCdoIngDTO proyeccionPlanAnualAdqCdoIngDTO){
        ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIng = new ProyeccionPlanAnualAdqCdoIng();
        proyeccionPlanAnualAdqCdoIng.setIdProyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO.getIdProyeccionPlanAnualAdqCdoIng());
        proyeccionPlanAnualAdqCdoIng.setNombreProyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO.getNombreProyeccionPlanAnualAdqCdoIng().toUpperCase());
        proyeccionPlanAnualAdqCdoIng.setValorSolicitadoProyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIngDTO.getValorSolicitadoProyeccionPlanAnualAdqCdoIng());
        
        //MAPEAR PROYECCION PLAN ANUAL ADQ GENERAL RELACIONADA.
        if (proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO() != null && proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqCdoIngDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyeccionPlanAnualAdqCdoIng::setProyeccionPlanAnualAdqGeneral);
        }
        
        //MAPEAR DESTINACION MANTENIMIENTO CDO ING RELACIONADA.
        if (proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO() != null && proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO().getIdDestinacionMantenimientoCdoIng() != null) {
           Optional<DestinacionMantenimientoCdoIng> destinacionMantenimientoCdoIngFk = destinacionMantenimientoCdoIngRepository.findByIdDestinacionMantenimientoCdoIng(proyeccionPlanAnualAdqCdoIngDTO.getDestinacionMantenimientoCdoIngDTO().getIdDestinacionMantenimientoCdoIng());
           destinacionMantenimientoCdoIngFk.ifPresent(proyeccionPlanAnualAdqCdoIng::setDestinacionMantenimientoCdoIng);
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO() != null && proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionPlanAnualAdqCdoIngDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(proyeccionPlanAnualAdqCdoIng::setInfraestructura);
        }
        
        return proyeccionPlanAnualAdqCdoIng;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualAdqCdoIng
    * Recibe un objeto proyeccionPlanAnualAdqCdoIng para crear un DTO.
    * @return proyeccionPlanAnualAdqCdoIngDTO
    */
    public ProyeccionPlanAnualAdqCdoIngDTO proyeccionPlanAnualAdqCdoIngDTO(ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIng){
        ProyeccionPlanAnualAdqCdoIngDTO proyeccionPlanAnualAdqCdoIngDTO = new ProyeccionPlanAnualAdqCdoIngDTO();
        proyeccionPlanAnualAdqCdoIngDTO.setIdProyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIng.getIdProyeccionPlanAnualAdqCdoIng());
        proyeccionPlanAnualAdqCdoIngDTO.setNombreProyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIng.getNombreProyeccionPlanAnualAdqCdoIng().toUpperCase());
        proyeccionPlanAnualAdqCdoIngDTO.setValorSolicitadoProyeccionPlanAnualAdqCdoIng(proyeccionPlanAnualAdqCdoIng.getValorSolicitadoProyeccionPlanAnualAdqCdoIng());
        
        //MAPEAR PROYECCION PLAN ANUAL ADQ GENERAL RELACIONADA.
        if (proyeccionPlanAnualAdqCdoIng.getProyeccionPlanAnualAdqGeneral() != null && proyeccionPlanAnualAdqCdoIng.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqCdoIng.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyPlAnAdqGen -> proyeccionPlanAnualAdqCdoIngDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyPlAnAdqGen)));
        }
        
        //MAPEAR DESTINACION MANTENIMIENTO CDO ING RELACIONADA.
        if (proyeccionPlanAnualAdqCdoIng.getDestinacionMantenimientoCdoIng() != null && proyeccionPlanAnualAdqCdoIng.getDestinacionMantenimientoCdoIng().getIdDestinacionMantenimientoCdoIng() != null) {
           Optional<DestinacionMantenimientoCdoIng> destinacionMantenimientoCdoIngFk = destinacionMantenimientoCdoIngRepository.findByIdDestinacionMantenimientoCdoIng(proyeccionPlanAnualAdqCdoIng.getDestinacionMantenimientoCdoIng().getIdDestinacionMantenimientoCdoIng());
           destinacionMantenimientoCdoIngFk.ifPresent(destMantCdoIng -> proyeccionPlanAnualAdqCdoIngDTO.setDestinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIngDTO(destMantCdoIng)));
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionPlanAnualAdqCdoIng.getInfraestructura() != null && proyeccionPlanAnualAdqCdoIng.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionPlanAnualAdqCdoIng.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> proyeccionPlanAnualAdqCdoIngDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return proyeccionPlanAnualAdqCdoIngDTO;
    }
}
