//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ApoyoAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEntidadInstitucional;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEventoApoyoRealizado;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProcesoApoyoAtencionPrevencion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoRequerimientoApoyoAtencionPrevencion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProcesoApoyoAtencionPrevencionRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEntidadInstitucionalRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEventoApoyoRealizadoRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoRequerimientoApoyoAtencionPrevencionRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ApoyoAtencPrevEmergDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEntidadInstitucionalRepository tipoEntidadInstitucionalRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEntidadInstitucionalDAO tipoEntidadInstitucionalDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoRequerimientoApoyoAtencionPrevencionRepository tipoRequerimientoApoyoAtencionPrevencionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoRequerimientoApoyoAtencionPrevencionDAO tipoRequerimientoApoyoAtencionPrevencionDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProcesoApoyoAtencionPrevencionRepository procesoApoyoAtencionPrevencionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProcesoApoyoAtencionPrevencionDAO procesoApoyoAtencionPrevencionDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEventoApoyoRealizadoRepository tipoEventoApoyoRealizadoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEventoApoyoRealizadoDAO tipoEventoApoyoRealizadoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param apoyoAtencPrevEmergDesastDTO
    * Recibe un DTO para crear un objeto apoyoAtencPrevEmergDesast.
    * @return apoyoAtencPrevEmergDesast
    */
    public ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesastDTO apoyoAtencPrevEmergDesastDTO){
        ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast = new ApoyoAtencPrevEmergDesast();
        apoyoAtencPrevEmergDesast.setIdApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getIdApoyoAtencPrevEmergDesast());
        apoyoAtencPrevEmergDesast.setCodigoRadicadoApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getCodigoRadicadoApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesast.setPaisOrigenApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getPaisOrigenApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesast.setDepartamentoOEstadoOrigenApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getDepartamentoOEstadoOrigenApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesast.setCiudadOrigenApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getCiudadOrigenApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesast.setLatitudApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getLatitudApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesast.setLongitudApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getLongitudApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesast.setFechaHMSIniciacionApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getFechaHMSIniciacionApoyoAtencPrevEmergDesast());
        apoyoAtencPrevEmergDesast.setFechaHMSFinalizacionApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getFechaHMSFinalizacionApoyoAtencPrevEmergDesast());
        apoyoAtencPrevEmergDesast.setNombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getNombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesast.setCodigoRadicadoTipoRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getCodigoRadicadoTipoRequerimientoApoyoAtencionPrevencion().toUpperCase());
        apoyoAtencPrevEmergDesast.setNumeroHeridosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getNumeroHeridosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesast.setNumeroMuertosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getNumeroMuertosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesast.setNumeroDesaparecidosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getNumeroDesaparecidosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesast.setNumeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getNumeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesast.setNumeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getNumeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesast.setNumeroViasAfectadasRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getNumeroViasAfectadasRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesast.setNumeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getNumeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesast.setDescripcionAfectacionApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesastDTO.getDescripcionAfectacionApoyoAtencPrevEmergDesast());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (apoyoAtencPrevEmergDesastDTO.getUnidadMilitarDTO() != null && apoyoAtencPrevEmergDesastDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(apoyoAtencPrevEmergDesastDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(apoyoAtencPrevEmergDesast::setUnidadMilitar);
        }
        
        //MAPEAR TIPO ENTIDAD INSTITUCIONAL RELACIONADO.
        if (apoyoAtencPrevEmergDesastDTO.getTipoEntidadInstitucionalDTO() != null && apoyoAtencPrevEmergDesastDTO.getTipoEntidadInstitucionalDTO().getIdTipoEntidadInstitucional() != null) {
           Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalFk = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(apoyoAtencPrevEmergDesastDTO.getTipoEntidadInstitucionalDTO().getIdTipoEntidadInstitucional());
           tipoEntidadInstitucionalFk.ifPresent(apoyoAtencPrevEmergDesast::setTipoEntidadInstitucional);
        }
        
        //MAPEAR TIPO DE REQUERIMIENTO, APOYO, ATENCION Y PREVENCIÓN RELACIONADO.
        if (apoyoAtencPrevEmergDesastDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO() != null && apoyoAtencPrevEmergDesastDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO().getIdTipoRequerimientoApoyoAtencionPrevencion() != null) {
           Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionFk = tipoRequerimientoApoyoAtencionPrevencionRepository.findByIdTipoRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO().getIdTipoRequerimientoApoyoAtencionPrevencion());
           tipoRequerimientoApoyoAtencionPrevencionFk.ifPresent(apoyoAtencPrevEmergDesast::setTipoRequerimientoApoyoAtencionPrevencion);
        }
        
        //MAPEAR PROCESO APOYO, ATENCIÓN Y PREVENCIÓN RELACIONADO.
        if (apoyoAtencPrevEmergDesastDTO.getProcesoApoyoAtencionPrevencionDTO() != null && apoyoAtencPrevEmergDesastDTO.getProcesoApoyoAtencionPrevencionDTO().getIdProcesoApoyoAtencionPrevencion() != null) {
           Optional<ProcesoApoyoAtencionPrevencion> procesoApoyoAtencionPrevencionFk = procesoApoyoAtencionPrevencionRepository.findByIdProcesoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesastDTO.getProcesoApoyoAtencionPrevencionDTO().getIdProcesoApoyoAtencionPrevencion());
           procesoApoyoAtencionPrevencionFk.ifPresent(apoyoAtencPrevEmergDesast::setProcesoApoyoAtencionPrevencion);
        }
        
        //MAPEAR TIPO EVENTO Y APOYO REALIZADO RELACIONADO.
        if (apoyoAtencPrevEmergDesastDTO.getTipoEventoApoyoRealizadoDTO() != null && apoyoAtencPrevEmergDesastDTO.getTipoEventoApoyoRealizadoDTO().getIdTipoEventoApoyoRealizado() != null) {
           Optional<TipoEventoApoyoRealizado> tipoEventoApoyoRealizadoFk = tipoEventoApoyoRealizadoRepository.findByIdTipoEventoApoyoRealizado(apoyoAtencPrevEmergDesastDTO.getTipoEventoApoyoRealizadoDTO().getIdTipoEventoApoyoRealizado());
           tipoEventoApoyoRealizadoFk.ifPresent(apoyoAtencPrevEmergDesast::setTipoEventoApoyoRealizado);
        }
        
        return apoyoAtencPrevEmergDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param apoyoAtencPrevEmergDesast
    * Recibe un objeto apoyoAtencPrevEmergDesast para crear un DTO.
    * @return apoyoAtencPrevEmergDesastDTO
    */
    public ApoyoAtencPrevEmergDesastDTO apoyoAtencPrevEmergDesastDTO(ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast){
        ApoyoAtencPrevEmergDesastDTO apoyoAtencPrevEmergDesastDTO = new ApoyoAtencPrevEmergDesastDTO();
        apoyoAtencPrevEmergDesastDTO.setIdApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getIdApoyoAtencPrevEmergDesast());
        apoyoAtencPrevEmergDesastDTO.setCodigoRadicadoApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getCodigoRadicadoApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setPaisOrigenApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getPaisOrigenApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setDepartamentoOEstadoOrigenApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getDepartamentoOEstadoOrigenApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setCiudadOrigenApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getCiudadOrigenApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setLatitudApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getLatitudApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setLongitudApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getLongitudApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setFechaHMSIniciacionApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getFechaHMSIniciacionApoyoAtencPrevEmergDesast());
        apoyoAtencPrevEmergDesastDTO.setFechaHMSFinalizacionApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getFechaHMSFinalizacionApoyoAtencPrevEmergDesast());
        apoyoAtencPrevEmergDesastDTO.setNombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getNombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setCodigoRadicadoTipoRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getCodigoRadicadoTipoRequerimientoApoyoAtencionPrevencion().toUpperCase());
        apoyoAtencPrevEmergDesastDTO.setNumeroHeridosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getNumeroHeridosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesastDTO.setNumeroMuertosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getNumeroMuertosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesastDTO.setNumeroDesaparecidosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getNumeroDesaparecidosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesastDTO.setNumeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getNumeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesastDTO.setNumeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getNumeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesastDTO.setNumeroViasAfectadasRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getNumeroViasAfectadasRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesastDTO.setNumeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getNumeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion());
        apoyoAtencPrevEmergDesastDTO.setDescripcionAfectacionApoyoAtencPrevEmergDesast(apoyoAtencPrevEmergDesast.getDescripcionAfectacionApoyoAtencPrevEmergDesast());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (apoyoAtencPrevEmergDesast.getUnidadMilitar() != null && apoyoAtencPrevEmergDesast.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(apoyoAtencPrevEmergDesast.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> apoyoAtencPrevEmergDesastDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        //MAPEAR TIPO ENTIDAD INSTITUCIONAL RELACIONADO.
        if (apoyoAtencPrevEmergDesast.getTipoEntidadInstitucional() != null && apoyoAtencPrevEmergDesast.getTipoEntidadInstitucional().getIdTipoEntidadInstitucional() != null) {
           Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalFk = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(apoyoAtencPrevEmergDesast.getTipoEntidadInstitucional().getIdTipoEntidadInstitucional());
           tipoEntidadInstitucionalFk.ifPresent(tipEntIns -> apoyoAtencPrevEmergDesastDTO.setTipoEntidadInstitucionalDTO(tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipEntIns)));
        }
        
        //MAPEAR TIPO REQUERIMIENTO, APOYO, ATENCION Y PREVENCIÓN RELACIONADO.
        if (apoyoAtencPrevEmergDesast.getTipoRequerimientoApoyoAtencionPrevencion() != null && apoyoAtencPrevEmergDesast.getTipoRequerimientoApoyoAtencionPrevencion().getIdTipoRequerimientoApoyoAtencionPrevencion() != null) {
           Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionFk = tipoRequerimientoApoyoAtencionPrevencionRepository.findByIdTipoRequerimientoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getTipoRequerimientoApoyoAtencionPrevencion().getIdTipoRequerimientoApoyoAtencionPrevencion());
           tipoRequerimientoApoyoAtencionPrevencionFk.ifPresent(tipReqApoyAtencPrev -> apoyoAtencPrevEmergDesastDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencionDTO(tipReqApoyAtencPrev)));
        }
        
        //MAPEAR PROCESO APOYO, ATENCIÓN Y PREVENCIÓN RELACIONADO.
        if (apoyoAtencPrevEmergDesast.getProcesoApoyoAtencionPrevencion() != null && apoyoAtencPrevEmergDesast.getProcesoApoyoAtencionPrevencion().getIdProcesoApoyoAtencionPrevencion() != null) {
           Optional<ProcesoApoyoAtencionPrevencion> procesoApoyoAtencionPrevencionFk = procesoApoyoAtencionPrevencionRepository.findByIdProcesoApoyoAtencionPrevencion(apoyoAtencPrevEmergDesast.getProcesoApoyoAtencionPrevencion().getIdProcesoApoyoAtencionPrevencion());
           procesoApoyoAtencionPrevencionFk.ifPresent(procApoyAtencPrev -> apoyoAtencPrevEmergDesastDTO.setProcesoApoyoAtencionPrevencionDTO(procesoApoyoAtencionPrevencionDAO.procesoApoyoAtencionPrevencionDTO(procApoyAtencPrev)));
        }
        
        //MAPEAR TIPO EVENTO Y APOYO REALIZADO RELACIONADO.
        if (apoyoAtencPrevEmergDesast.getTipoEventoApoyoRealizado() != null && apoyoAtencPrevEmergDesast.getTipoEventoApoyoRealizado().getIdTipoEventoApoyoRealizado() != null) {
           Optional<TipoEventoApoyoRealizado> tipoEventoApoyoRealizadoFk = tipoEventoApoyoRealizadoRepository.findByIdTipoEventoApoyoRealizado(apoyoAtencPrevEmergDesast.getTipoEventoApoyoRealizado().getIdTipoEventoApoyoRealizado());
           tipoEventoApoyoRealizadoFk.ifPresent(tipEvApoyReal -> apoyoAtencPrevEmergDesastDTO.setTipoEventoApoyoRealizadoDTO(tipoEventoApoyoRealizadoDAO.tipoEventoApoyoRealizadoDTO(tipEvApoyReal)));
        }
        
        return apoyoAtencPrevEmergDesastDTO;
    }
}
