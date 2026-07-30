//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ApoyoObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEntidadInstitucional;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEntidadInstitucionalRepository;
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
public class ApoyoObrRedMitigGestRiesgDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEntidadInstitucionalRepository tipoEntidadInstitucionalRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEntidadInstitucionalDAO tipoEntidadInstitucionalDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param apoyoObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto apoyoObrRedMitigGestRiesgDesast.
    * @return apoyoObrRedMitigGestRiesgDesast
    */
    public ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesastDTO apoyoObrRedMitigGestRiesgDesastDTO){
        ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast = new ApoyoObrRedMitigGestRiesgDesast();
        apoyoObrRedMitigGestRiesgDesast.setIdApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getIdApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesast.setCodigoRadicadoApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesast.setPaisOrigenApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getPaisOrigenApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesast.setDepartamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getDepartamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesast.setCiudadOrigenApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getCiudadOrigenApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesast.setLatitudApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getLatitudApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesast.setLongitudApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getLongitudApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesast.setFechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getFechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesast.setFechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getFechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesast.setNombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getNombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesast.setCodigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getCodigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesast.setNumeroPobBenefApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getNumeroPobBenefApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesast.setDescripcionObrApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getDescripcionObrApoyoObrRedMitigGestRiesgDesast());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (apoyoObrRedMitigGestRiesgDesastDTO.getUnidadMilitarDTO() != null && apoyoObrRedMitigGestRiesgDesastDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(apoyoObrRedMitigGestRiesgDesastDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(apoyoObrRedMitigGestRiesgDesast::setUnidadMilitar);
        }
        
        //MAPEAR TIPO ENTIDAD INSTITUCIONAL RELACIONADA.
        if (apoyoObrRedMitigGestRiesgDesastDTO.getTipoEntidadInstitucionalDTO() != null && apoyoObrRedMitigGestRiesgDesastDTO.getTipoEntidadInstitucionalDTO().getIdTipoEntidadInstitucional() != null) {
           Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalFk = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(apoyoObrRedMitigGestRiesgDesastDTO.getTipoEntidadInstitucionalDTO().getIdTipoEntidadInstitucional());
           tipoEntidadInstitucionalFk.ifPresent(apoyoObrRedMitigGestRiesgDesast::setTipoEntidadInstitucional);
        }
        
        //MAPEAR TIPO EMERGENCIA DESASTRE GENERADORA DE OBRA RELACIONADA.
        if (apoyoObrRedMitigGestRiesgDesastDTO.getTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO() != null && apoyoObrRedMitigGestRiesgDesastDTO.getTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO().getIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tipoEmDesastGenObrFk = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findByIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesastDTO.getTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO().getIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast());
           tipoEmDesastGenObrFk.ifPresent(apoyoObrRedMitigGestRiesgDesast::setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
        }
        
        return apoyoObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param apoyoObrRedMitigGestRiesgDesast
    * Recibe un objeto apoyoObrRedMitigGestRiesgDesast para crear un DTO.
    * @return apoyoObrRedMitigGestRiesgDesastDTO
    */
    public ApoyoObrRedMitigGestRiesgDesastDTO apoyoObrRedMitigGestRiesgDesastDTO(ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast){
        ApoyoObrRedMitigGestRiesgDesastDTO apoyoObrRedMitigGestRiesgDesastDTO = new ApoyoObrRedMitigGestRiesgDesastDTO();
        apoyoObrRedMitigGestRiesgDesastDTO.setIdApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getIdApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesastDTO.setCodigoRadicadoApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesastDTO.setPaisOrigenApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getPaisOrigenApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesastDTO.setDepartamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getDepartamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesastDTO.setCiudadOrigenApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getCiudadOrigenApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesastDTO.setLatitudApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getLatitudApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesastDTO.setLongitudApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getLongitudApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesastDTO.setFechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getFechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesastDTO.setFechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getFechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesastDTO.setNombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getNombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesastDTO.setCodigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getCodigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast().toUpperCase());
        apoyoObrRedMitigGestRiesgDesastDTO.setNumeroPobBenefApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getNumeroPobBenefApoyoObrRedMitigGestRiesgDesast());
        apoyoObrRedMitigGestRiesgDesastDTO.setDescripcionObrApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getDescripcionObrApoyoObrRedMitigGestRiesgDesast());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (apoyoObrRedMitigGestRiesgDesast.getUnidadMilitar() != null && apoyoObrRedMitigGestRiesgDesast.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(apoyoObrRedMitigGestRiesgDesast.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> apoyoObrRedMitigGestRiesgDesastDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        //MAPEAR TIPO ENTIDAD INSTITUCIONAL RELACIONADA.
        if (apoyoObrRedMitigGestRiesgDesast.getTipoEntidadInstitucional() != null && apoyoObrRedMitigGestRiesgDesast.getTipoEntidadInstitucional().getIdTipoEntidadInstitucional() != null) {
           Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalFk = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(apoyoObrRedMitigGestRiesgDesast.getTipoEntidadInstitucional().getIdTipoEntidadInstitucional());
           tipoEntidadInstitucionalFk.ifPresent(tipoEntInst -> apoyoObrRedMitigGestRiesgDesastDTO.setTipoEntidadInstitucionalDTO(tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipoEntInst)));
        }
        
        //MAPEAR TIPO EMERGENCIA DESASTRE GENERADORA DE OBRA RELACIONADA.
        if (apoyoObrRedMitigGestRiesgDesast.getTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast() != null && apoyoObrRedMitigGestRiesgDesast.getTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().getIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> tipoEmDesastGenObrFk = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository.findByIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(apoyoObrRedMitigGestRiesgDesast.getTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast().getIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast());
           tipoEmDesastGenObrFk.ifPresent(tipoEmDesastGenObr -> apoyoObrRedMitigGestRiesgDesastDTO.setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDAO.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO(tipoEmDesastGenObr)));
        }
        
        return apoyoObrRedMitigGestRiesgDesastDTO;
    }
}
