//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualArrendamientoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InfraestructuraArrendada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualArrendamiento;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraArrendadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionPlanAnualArrendamientoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraArrendadaRepository infraestructuraArrendadaRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraArrendadaDAO infraestructuraArrendadaDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualArrendamientoDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualArrendamiento.
    * @return proyeccionPlanAnualArrendamiento
    */
    public ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamiento(ProyeccionPlanAnualArrendamientoDTO proyeccionPlanAnualArrendamientoDTO){
        ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamiento = new ProyeccionPlanAnualArrendamiento();
        proyeccionPlanAnualArrendamiento.setIdProyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamientoDTO.getIdProyeccionPlanAnualArrendamiento());
        proyeccionPlanAnualArrendamiento.setNombreProyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamientoDTO.getNombreProyeccionPlanAnualArrendamiento().toUpperCase());
        
        //MAPEAR INFRAESTRUCTURA ARRENDADA RELACIONADA.
        if (proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO() != null && proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO().getIdInfraestructuraArrendada() != null) {
           Optional<InfraestructuraArrendada> infraestructuraArrendadaFk = infraestructuraArrendadaRepository.findByIdInfraestructuraArrendada(proyeccionPlanAnualArrendamientoDTO.getInfraestructuraArrendadaDTO().getIdInfraestructuraArrendada());
           infraestructuraArrendadaFk.ifPresent(proyeccionPlanAnualArrendamiento::setInfraestructuraArrendada);
        }
        
        return proyeccionPlanAnualArrendamiento;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualArrendamiento
    * Recibe un objeto proyeccionPlanAnualArrendamiento para crear un DTO.
    * @return proyeccionPlanAnualArrendamientoDTO
    */
    public ProyeccionPlanAnualArrendamientoDTO proyeccionPlanAnualArrendamientoDTO(ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamiento){
        ProyeccionPlanAnualArrendamientoDTO proyeccionPlanAnualArrendamientoDTO = new ProyeccionPlanAnualArrendamientoDTO();
        proyeccionPlanAnualArrendamientoDTO.setIdProyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamiento.getIdProyeccionPlanAnualArrendamiento());
        proyeccionPlanAnualArrendamientoDTO.setNombreProyeccionPlanAnualArrendamiento(proyeccionPlanAnualArrendamiento.getNombreProyeccionPlanAnualArrendamiento().toUpperCase());
        
        //MAPEAR INFRAESTRUCTURA ARRENDADA RELACIONADA.
        if (proyeccionPlanAnualArrendamiento.getInfraestructuraArrendada() != null && proyeccionPlanAnualArrendamiento.getInfraestructuraArrendada().getIdInfraestructuraArrendada() != null) {
           Optional<InfraestructuraArrendada> infraestructuraArrendadaFk = infraestructuraArrendadaRepository.findByIdInfraestructuraArrendada(proyeccionPlanAnualArrendamiento.getInfraestructuraArrendada().getIdInfraestructuraArrendada());
           infraestructuraArrendadaFk.ifPresent(infArrend -> proyeccionPlanAnualArrendamientoDTO.setInfraestructuraArrendadaDTO(infraestructuraArrendadaDAO.infraestructuraArrendadaDTO(infArrend)));
        }
        
        return proyeccionPlanAnualArrendamientoDTO;
    }
}
