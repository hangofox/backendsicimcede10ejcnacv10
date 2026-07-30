//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoSolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoSolicitudInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class SolicitudInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoSolicitudInfraestructuraRepository tipoSolicitudInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoSolicitudInfraestructuraDAO tipoSolicitudInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param solicitudInfraestructuraDTO
    * Recibe un DTO para crear un objeto solicitudInfraestructura.
    * @return solicitudInfraestructura
    */
    public SolicitudInfraestructura solicitudInfraestructura(SolicitudInfraestructuraDTO solicitudInfraestructuraDTO){
        SolicitudInfraestructura solicitudInfraestructura = new SolicitudInfraestructura();
        solicitudInfraestructura.setIdSolicitudInfraestructura(solicitudInfraestructuraDTO.getIdSolicitudInfraestructura());
        solicitudInfraestructura.setCodigoRadicadoSolicitudInfraestructura(solicitudInfraestructuraDTO.getCodigoRadicadoSolicitudInfraestructura());
        solicitudInfraestructura.setFechaHMSSolicitudInfraestructura(solicitudInfraestructuraDTO.getFechaHMSSolicitudInfraestructura());
        solicitudInfraestructura.setNombreSolicitudInfraestructura(solicitudInfraestructuraDTO.getNombreSolicitudInfraestructura().toUpperCase());
        solicitudInfraestructura.setNombreDependenciaSolicitudInfraestructura(solicitudInfraestructuraDTO.getNombreDependenciaSolicitudInfraestructura().toUpperCase());
        solicitudInfraestructura.setNumeroFuncionariosSolicitudInfraestructura(solicitudInfraestructuraDTO.getNumeroFuncionariosSolicitudInfraestructura());
        solicitudInfraestructura.setNumeroUsuariosSolicitudInfraestructura(solicitudInfraestructuraDTO.getNumeroUsuariosSolicitudInfraestructura());
        solicitudInfraestructura.setObservacionesJuridicasEstadoPredioInfraestructura(solicitudInfraestructuraDTO.getObservacionesJuridicasEstadoPredioInfraestructura());
        solicitudInfraestructura.setObservacionesEstadoAmbientalInfraestructura(solicitudInfraestructuraDTO.getObservacionesEstadoAmbientalInfraestructura());
        solicitudInfraestructura.setJustificacionNecesidadInfraestructura(solicitudInfraestructuraDTO.getJustificacionNecesidadInfraestructura());
        solicitudInfraestructura.setDescripcionGeneralNecesidadInfraestructura(solicitudInfraestructuraDTO.getDescripcionGeneralNecesidadInfraestructura());
        solicitudInfraestructura.setDescripcionImpactoEsperadoInfraestructura(solicitudInfraestructuraDTO.getDescripcionImpactoEsperadoInfraestructura());
        solicitudInfraestructura.setFechaHMSIngresoSolicitudInfraestructura(solicitudInfraestructuraDTO.getFechaHMSIngresoSolicitudInfraestructura());
        solicitudInfraestructura.setFechaHMSModificacionSolicitudInfraestructura(solicitudInfraestructuraDTO.getFechaHMSModificacionSolicitudInfraestructura());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (solicitudInfraestructuraDTO.getUnidadMilitarDTO() != null && solicitudInfraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(solicitudInfraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(solicitudInfraestructura::setUnidadMilitar);
        }
        
        //MAPEAR TIPO SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (solicitudInfraestructuraDTO.getTipoSolicitudInfraestructuraDTO() != null && solicitudInfraestructuraDTO.getTipoSolicitudInfraestructuraDTO().getIdTipoSolicitudInfraestructura() != null) {
           Optional<TipoSolicitudInfraestructura> tipoSolicitudInfraestructuraFk = tipoSolicitudInfraestructuraRepository.findByIdTipoSolicitudInfraestructura(solicitudInfraestructuraDTO.getTipoSolicitudInfraestructuraDTO().getIdTipoSolicitudInfraestructura());
           tipoSolicitudInfraestructuraFk.ifPresent(solicitudInfraestructura::setTipoSolicitudInfraestructura);
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (solicitudInfraestructuraDTO.getInfraestructuraDTO() != null && solicitudInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(solicitudInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(solicitudInfraestructura::setInfraestructura);
        }
        
        return solicitudInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param solicitudInfraestructura
    * Recibe un objeto solicitudInfraestructura para crear un DTO.
    * @return solicitudInfraestructuraDTO
    */
    public SolicitudInfraestructuraDTO solicitudInfraestructuraDTO(SolicitudInfraestructura solicitudInfraestructura){
        SolicitudInfraestructuraDTO solicitudInfraestructuraDTO = new SolicitudInfraestructuraDTO();
        solicitudInfraestructuraDTO.setIdSolicitudInfraestructura(solicitudInfraestructura.getIdSolicitudInfraestructura());
        solicitudInfraestructuraDTO.setCodigoRadicadoSolicitudInfraestructura(solicitudInfraestructura.getCodigoRadicadoSolicitudInfraestructura());
        solicitudInfraestructuraDTO.setFechaHMSSolicitudInfraestructura(solicitudInfraestructura.getFechaHMSSolicitudInfraestructura());
        solicitudInfraestructuraDTO.setNombreSolicitudInfraestructura(solicitudInfraestructura.getNombreSolicitudInfraestructura().toUpperCase());
        solicitudInfraestructuraDTO.setNombreDependenciaSolicitudInfraestructura(solicitudInfraestructura.getNombreDependenciaSolicitudInfraestructura().toUpperCase());
        solicitudInfraestructuraDTO.setNumeroFuncionariosSolicitudInfraestructura(solicitudInfraestructura.getNumeroFuncionariosSolicitudInfraestructura());
        solicitudInfraestructuraDTO.setNumeroUsuariosSolicitudInfraestructura(solicitudInfraestructura.getNumeroUsuariosSolicitudInfraestructura());
        solicitudInfraestructuraDTO.setObservacionesJuridicasEstadoPredioInfraestructura(solicitudInfraestructura.getObservacionesJuridicasEstadoPredioInfraestructura());
        solicitudInfraestructuraDTO.setObservacionesEstadoAmbientalInfraestructura(solicitudInfraestructura.getObservacionesEstadoAmbientalInfraestructura());
        solicitudInfraestructuraDTO.setJustificacionNecesidadInfraestructura(solicitudInfraestructura.getJustificacionNecesidadInfraestructura());
        solicitudInfraestructuraDTO.setDescripcionGeneralNecesidadInfraestructura(solicitudInfraestructura.getDescripcionGeneralNecesidadInfraestructura());
        solicitudInfraestructuraDTO.setDescripcionImpactoEsperadoInfraestructura(solicitudInfraestructura.getDescripcionImpactoEsperadoInfraestructura());
        solicitudInfraestructuraDTO.setFechaHMSIngresoSolicitudInfraestructura(solicitudInfraestructura.getFechaHMSIngresoSolicitudInfraestructura());
        solicitudInfraestructuraDTO.setFechaHMSModificacionSolicitudInfraestructura(solicitudInfraestructura.getFechaHMSModificacionSolicitudInfraestructura());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (solicitudInfraestructura.getUnidadMilitar() != null && solicitudInfraestructura.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(solicitudInfraestructura.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> solicitudInfraestructuraDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        //MAPEAR TIPO SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (solicitudInfraestructura.getTipoSolicitudInfraestructura() != null && solicitudInfraestructura.getTipoSolicitudInfraestructura().getIdTipoSolicitudInfraestructura() != null) {
           Optional<TipoSolicitudInfraestructura> tipoSolicitudInfraestructuraFk = tipoSolicitudInfraestructuraRepository.findByIdTipoSolicitudInfraestructura(solicitudInfraestructura.getTipoSolicitudInfraestructura().getIdTipoSolicitudInfraestructura());
           tipoSolicitudInfraestructuraFk.ifPresent(tipoSolInfra -> solicitudInfraestructuraDTO.setTipoSolicitudInfraestructuraDTO(tipoSolicitudInfraestructuraDAO.tipoSolicitudInfraestructuraDTO(tipoSolInfra)));
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (solicitudInfraestructura.getInfraestructura() != null && solicitudInfraestructura.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(solicitudInfraestructura.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> solicitudInfraestructuraDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return solicitudInfraestructuraDTO;
    }
}
