//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionSeguroInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 14/04/2026.
    * @param proyeccionSeguroInfraestructuraDTO
    * Recibe un DTO para crear un objeto proyeccionSeguroInfraestructura.
    * @return proyeccionSeguroInfraestructura
    */
    public ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura(ProyeccionSeguroInfraestructuraDTO proyeccionSeguroInfraestructuraDTO){
        ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura = new ProyeccionSeguroInfraestructura();
        proyeccionSeguroInfraestructura.setIdProyeccionSeguroInfraestructura(proyeccionSeguroInfraestructuraDTO.getIdProyeccionSeguroInfraestructura());
        proyeccionSeguroInfraestructura.setValorSolicitadoProySegInfraest(proyeccionSeguroInfraestructuraDTO.getValorSolicitadoProySegInfraest());
        proyeccionSeguroInfraestructura.setValorSolicitadoTodoRiesgoProySegInfraest(proyeccionSeguroInfraestructuraDTO.getValorSolicitadoTodoRiesgoProySegInfraest());
        proyeccionSeguroInfraestructura.setValorSolicitadoRenegociacionProySegInfraest(proyeccionSeguroInfraestructuraDTO.getValorSolicitadoRenegociacionProySegInfraest());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionSeguroInfraestructuraDTO.getInfraestructuraDTO() != null && proyeccionSeguroInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionSeguroInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(proyeccionSeguroInfraestructura::setInfraestructura);
        }
        
        return proyeccionSeguroInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 14/04/2026.
    * @param proyeccionSeguroInfraestructura
    * Recibe un objeto proyeccionSeguroInfraestructura para crear un DTO.
    * @return proyeccionSeguroInfraestructuraDTO
    */
    public ProyeccionSeguroInfraestructuraDTO proyeccionSeguroInfraestructuraDTO(ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura){
        ProyeccionSeguroInfraestructuraDTO proyeccionSeguroInfraestructuraDTO = new ProyeccionSeguroInfraestructuraDTO();
        proyeccionSeguroInfraestructuraDTO.setIdProyeccionSeguroInfraestructura(proyeccionSeguroInfraestructura.getIdProyeccionSeguroInfraestructura());
        proyeccionSeguroInfraestructuraDTO.setValorSolicitadoProySegInfraest(proyeccionSeguroInfraestructura.getValorSolicitadoProySegInfraest());
        proyeccionSeguroInfraestructuraDTO.setValorSolicitadoTodoRiesgoProySegInfraest(proyeccionSeguroInfraestructura.getValorSolicitadoTodoRiesgoProySegInfraest());
        proyeccionSeguroInfraestructuraDTO.setValorSolicitadoRenegociacionProySegInfraest(proyeccionSeguroInfraestructura.getValorSolicitadoRenegociacionProySegInfraest());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionSeguroInfraestructura.getInfraestructura() != null && proyeccionSeguroInfraestructura.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionSeguroInfraestructura.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> proyeccionSeguroInfraestructuraDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return proyeccionSeguroInfraestructuraDTO;
    }
}
