//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionTecnicomecanicaEquipTranspDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionTecnicomecanicaEquipTransp;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionTecnicomecanicaEquipTranspDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param proyeccionTecnicomecanicaEquipTranspDTO
    * Recibe un DTO para crear un objeto proyeccionTecnicomecanicaEquipTransp.
    * @return proyeccionTecnicomecanicaEquipTransp
    */
    public ProyeccionTecnicomecanicaEquipTransp proyeccionTecnicomecanicaEquipTransp(ProyeccionTecnicomecanicaEquipTranspDTO proyeccionTecnicomecanicaEquipTranspDTO){
        ProyeccionTecnicomecanicaEquipTransp proyeccionTecnicomecanicaEquipTransp = new ProyeccionTecnicomecanicaEquipTransp();
        proyeccionTecnicomecanicaEquipTransp.setIdProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO.getIdProyeccionTecnicomecanicaEquipTransp());
        proyeccionTecnicomecanicaEquipTransp.setNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO.getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp());
        proyeccionTecnicomecanicaEquipTransp.setValorSolicitadoProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO.getValorSolicitadoProyeccionTecnicomecanicaEquipTransp());
        proyeccionTecnicomecanicaEquipTransp.setFechaHMSProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO.getFechaHMSProyeccionTecnicomecanicaEquipTransp());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO() != null && proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(proyeccionTecnicomecanicaEquipTransp::setEquipoIngeniero);
        }
        
        return proyeccionTecnicomecanicaEquipTransp;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param proyeccionTecnicomecanicaEquipTransp
    * Recibe un objeto proyeccionTecnicomecanicaEquipTransp para crear un DTO.
    * @return proyeccionTecnicomecanicaEquipTranspDTO
    */
    public ProyeccionTecnicomecanicaEquipTranspDTO proyeccionTecnicomecanicaEquipTranspDTO(ProyeccionTecnicomecanicaEquipTransp proyeccionTecnicomecanicaEquipTransp){
        ProyeccionTecnicomecanicaEquipTranspDTO proyeccionTecnicomecanicaEquipTranspDTO = new ProyeccionTecnicomecanicaEquipTranspDTO();
        proyeccionTecnicomecanicaEquipTranspDTO.setIdProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTransp.getIdProyeccionTecnicomecanicaEquipTransp());
        proyeccionTecnicomecanicaEquipTranspDTO.setNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTransp.getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp());
        proyeccionTecnicomecanicaEquipTranspDTO.setValorSolicitadoProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTransp.getValorSolicitadoProyeccionTecnicomecanicaEquipTransp());
        proyeccionTecnicomecanicaEquipTranspDTO.setFechaHMSProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTransp.getFechaHMSProyeccionTecnicomecanicaEquipTransp());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (proyeccionTecnicomecanicaEquipTransp.getEquipoIngeniero() != null && proyeccionTecnicomecanicaEquipTransp.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(proyeccionTecnicomecanicaEquipTransp.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(eqIng -> proyeccionTecnicomecanicaEquipTranspDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(eqIng)));
        }
        
        return proyeccionTecnicomecanicaEquipTranspDTO;
    }
}
