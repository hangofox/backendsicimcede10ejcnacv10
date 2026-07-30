//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualEquipSubsDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualEquipSubs;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
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
public class ProyeccionPlanAnualEquipSubsDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqGeneralRepository proyeccionPlanAnualAdqGeneralRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqGeneralDAO proyeccionPlanAnualAdqGeneralDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualEquipSubsDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualEquipSubs.
    * @return proyeccionPlanAnualEquipSubs
    */
    public ProyeccionPlanAnualEquipSubs proyeccionPlanAnualEquipSubs(ProyeccionPlanAnualEquipSubsDTO proyeccionPlanAnualEquipSubsDTO){
        ProyeccionPlanAnualEquipSubs proyeccionPlanAnualEquipSubs = new ProyeccionPlanAnualEquipSubs();
        proyeccionPlanAnualEquipSubs.setIdProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO.getIdProyeccionPlanAnualEquipSubs());
        proyeccionPlanAnualEquipSubs.setNombreProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO.getNombreProyeccionPlanAnualEquipSubs().toUpperCase());
        proyeccionPlanAnualEquipSubs.setNombreYNumeroRubroProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO.getNombreYNumeroRubroProyeccionPlanAnualEquipSubs().toUpperCase());
        proyeccionPlanAnualEquipSubs.setValorSolicitadoProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO.getValorSolicitadoProyeccionPlanAnualEquipSubs());
        proyeccionPlanAnualEquipSubs.setNombreBienOServicioProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubsDTO.getNombreBienOServicioProyeccionPlanAnualEquipSubs().toUpperCase());
        proyeccionPlanAnualEquipSubs.setNombreArchivoDocumentoAnexoProyPlAnNecEquipSubs(proyeccionPlanAnualEquipSubsDTO.getNombreArchivoDocumentoAnexoProyPlAnNecEquipSubs());
        
        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO() != null && proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualEquipSubsDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyeccionPlanAnualEquipSubs::setProyeccionPlanAnualAdqGeneral);
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO() != null && proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(proyeccionPlanAnualEquipSubsDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(proyeccionPlanAnualEquipSubs::setEquipoIngeniero);
        }
        
        return proyeccionPlanAnualEquipSubs;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionPlanAnualEquipSubs
    * Recibe un objeto proyeccionPlanAnualEquipSubs para crear un DTO.
    * @return proyeccionPlanAnualEquipSubsDTO
    */
    public ProyeccionPlanAnualEquipSubsDTO proyeccionPlanAnualEquipSubsDTO(ProyeccionPlanAnualEquipSubs proyeccionPlanAnualEquipSubs){
        ProyeccionPlanAnualEquipSubsDTO proyeccionPlanAnualEquipSubsDTO = new ProyeccionPlanAnualEquipSubsDTO();
        proyeccionPlanAnualEquipSubsDTO.setIdProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubs.getIdProyeccionPlanAnualEquipSubs());
        proyeccionPlanAnualEquipSubsDTO.setNombreProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubs.getNombreProyeccionPlanAnualEquipSubs().toUpperCase());
        proyeccionPlanAnualEquipSubsDTO.setNombreYNumeroRubroProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubs.getNombreYNumeroRubroProyeccionPlanAnualEquipSubs().toUpperCase());
        proyeccionPlanAnualEquipSubsDTO.setValorSolicitadoProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubs.getValorSolicitadoProyeccionPlanAnualEquipSubs());
        proyeccionPlanAnualEquipSubsDTO.setNombreBienOServicioProyeccionPlanAnualEquipSubs(proyeccionPlanAnualEquipSubs.getNombreBienOServicioProyeccionPlanAnualEquipSubs().toUpperCase());
        proyeccionPlanAnualEquipSubsDTO.setNombreArchivoDocumentoAnexoProyPlAnNecEquipSubs(proyeccionPlanAnualEquipSubs.getNombreArchivoDocumentoAnexoProyPlAnNecEquipSubs());
        
        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualEquipSubs.getProyeccionPlanAnualAdqGeneral() != null && proyeccionPlanAnualEquipSubs.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualEquipSubs.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyPlAnAdqGen -> proyeccionPlanAnualEquipSubsDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyPlAnAdqGen)));
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (proyeccionPlanAnualEquipSubs.getEquipoIngeniero() != null && proyeccionPlanAnualEquipSubs.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(proyeccionPlanAnualEquipSubs.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(equipIng -> proyeccionPlanAnualEquipSubsDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipIng)));
        }
        
        return proyeccionPlanAnualEquipSubsDTO;
    }
}
