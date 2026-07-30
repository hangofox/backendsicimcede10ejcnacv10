//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualPozoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualPozo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoPozo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqGeneralRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoMantenimientoPozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionPlanAnualPozoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqGeneralRepository proyeccionPlanAnualAdqGeneralRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqGeneralDAO proyeccionPlanAnualAdqGeneralDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoMantenimientoPozoRepository tipoMantenimientoPozoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoMantenimientoPozoDAO tipoMantenimientoPozoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 22/04/2026.
    * @param proyeccionPlanAnualPozoDTO
    * Recibe un DTO para crear un objeto proyeccionPlanAnualPozo.
    * @return proyeccionPlanAnualPozo
    */
    public ProyeccionPlanAnualPozo proyeccionPlanAnualPozo(ProyeccionPlanAnualPozoDTO proyeccionPlanAnualPozoDTO){
        ProyeccionPlanAnualPozo proyeccionPlanAnualPozo = new ProyeccionPlanAnualPozo();
        proyeccionPlanAnualPozo.setIdProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getIdProyeccionPlanAnualPozo());
        proyeccionPlanAnualPozo.setNombreProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getNombreProyeccionPlanAnualPozo().toUpperCase());
        proyeccionPlanAnualPozo.setNombreYNumeroRubroProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getNombreYNumeroRubroProyeccionPlanAnualPozo().toUpperCase());
        proyeccionPlanAnualPozo.setValorSolicitadoProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getValorSolicitadoProyeccionPlanAnualPozo());
        proyeccionPlanAnualPozo.setNombreBienOServicioProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getNombreBienOServicioProyeccionPlanAnualPozo().toUpperCase());
        proyeccionPlanAnualPozo.setNombreArchivoDocumentoAnexoCotizProyPlAnPozo(proyeccionPlanAnualPozoDTO.getNombreArchivoDocumentoAnexoCotizProyPlAnPozo());
        
        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO() != null && proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyeccionPlanAnualPozo::setProyeccionPlanAnualAdqGeneral);
        }
        
        //MAPEAR TIPO MANTENIMIENTO POZO RELACIONADO.
        if (proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO() != null && proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO().getIdTipoMantenimientoPozo() != null) {
           Optional<TipoMantenimientoPozo> tipoMantenimientoPozoFk = tipoMantenimientoPozoRepository.findByIdTipoMantenimientoPozo(proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO().getIdTipoMantenimientoPozo());
           tipoMantenimientoPozoFk.ifPresent(proyeccionPlanAnualPozo::setTipoMantenimientoPozo);
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionPlanAnualPozoDTO.getInfraestructuraDTO() != null && proyeccionPlanAnualPozoDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionPlanAnualPozoDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(proyeccionPlanAnualPozo::setInfraestructura);
        }
        
        return proyeccionPlanAnualPozo;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 22/04/2026.
    * @param proyeccionPlanAnualPozo
    * Recibe un objeto proyeccionPlanAnualPozo para crear un DTO.
    * @return proyeccionPlanAnualPozoDTO
    */
    public ProyeccionPlanAnualPozoDTO proyeccionPlanAnualPozoDTO(ProyeccionPlanAnualPozo proyeccionPlanAnualPozo){
        ProyeccionPlanAnualPozoDTO proyeccionPlanAnualPozoDTO = new ProyeccionPlanAnualPozoDTO();
        proyeccionPlanAnualPozoDTO.setIdProyeccionPlanAnualPozo(proyeccionPlanAnualPozo.getIdProyeccionPlanAnualPozo());
        proyeccionPlanAnualPozoDTO.setNombreProyeccionPlanAnualPozo(proyeccionPlanAnualPozo.getNombreProyeccionPlanAnualPozo().toUpperCase());
        proyeccionPlanAnualPozoDTO.setNombreYNumeroRubroProyeccionPlanAnualPozo(proyeccionPlanAnualPozo.getNombreYNumeroRubroProyeccionPlanAnualPozo().toUpperCase());
        proyeccionPlanAnualPozoDTO.setValorSolicitadoProyeccionPlanAnualPozo(proyeccionPlanAnualPozo.getValorSolicitadoProyeccionPlanAnualPozo());
        proyeccionPlanAnualPozoDTO.setNombreBienOServicioProyeccionPlanAnualPozo(proyeccionPlanAnualPozo.getNombreBienOServicioProyeccionPlanAnualPozo().toUpperCase());
        proyeccionPlanAnualPozoDTO.setNombreArchivoDocumentoAnexoCotizProyPlAnPozo(proyeccionPlanAnualPozo.getNombreArchivoDocumentoAnexoCotizProyPlAnPozo());
        
        //MAPEAR PROYECCION DEL PLAN ANUAL DE ADQUISICION GENERAL RELACIONADA.
        if (proyeccionPlanAnualPozo.getProyeccionPlanAnualAdqGeneral() != null && proyeccionPlanAnualPozo.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral() != null) {
           Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralFk = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualPozo.getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral());
           proyeccionPlanAnualAdqGeneralFk.ifPresent(proyPlAnAdqGen -> proyeccionPlanAnualPozoDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyPlAnAdqGen)));
        }
        
        //MAPEAR TIPO MANTENIMIENTO POZO RELACIONADO.
        if (proyeccionPlanAnualPozo.getTipoMantenimientoPozo() != null && proyeccionPlanAnualPozo.getTipoMantenimientoPozo().getIdTipoMantenimientoPozo() != null) {
           Optional<TipoMantenimientoPozo> tipoMantenimientoPozoFk = tipoMantenimientoPozoRepository.findByIdTipoMantenimientoPozo(proyeccionPlanAnualPozo.getTipoMantenimientoPozo().getIdTipoMantenimientoPozo());
           tipoMantenimientoPozoFk.ifPresent(tipoMantPozo -> proyeccionPlanAnualPozoDTO.setTipoMantenimientoPozoDTO(tipoMantenimientoPozoDAO.tipoMantenimientoPozoDTO(tipoMantPozo)));
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (proyeccionPlanAnualPozo.getInfraestructura() != null && proyeccionPlanAnualPozo.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(proyeccionPlanAnualPozo.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> proyeccionPlanAnualPozoDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return proyeccionPlanAnualPozoDTO;
    }
}
