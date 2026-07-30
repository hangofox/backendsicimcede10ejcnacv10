//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ResponsableDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Responsable;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoIdentificacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ResponsableDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoIdentificacionRepository tipoDocumentoIdentificacionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoIdentificacionDAO tipoDocumentoIdentificacionDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param responsableDTO
    * Recibe un DTO para crear un objeto responsable.
    * @return responsable
    */
    public Responsable responsable(ResponsableDTO responsableDTO){
        Responsable responsable = new Responsable();
        responsable.setIdResponsable(responsableDTO.getIdResponsable());
        responsable.setUsuarioRedResponsable(responsableDTO.getUsuarioRedResponsable());
        responsable.setNumeroDocumentoIdentificacionResponsable(responsableDTO.getNumeroDocumentoIdentificacionResponsable());
        responsable.setLugarExpedicionDocumentoIdentificacionResponsable(responsableDTO.getLugarExpedicionDocumentoIdentificacionResponsable().toUpperCase());
        responsable.setGradoResponsable(responsableDTO.getGradoResponsable());
        responsable.setNombresResponsable(responsableDTO.getNombresResponsable().toUpperCase());
        responsable.setPrimerApellidoResponsable(responsableDTO.getPrimerApellidoResponsable().toUpperCase());
        responsable.setSegundoApellidoResponsable(responsableDTO.getSegundoApellidoResponsable());
        responsable.setArmaResponsable(responsableDTO.getArmaResponsable());
        responsable.setNombreArchivoFotoExtensionoFormatoResponsable(responsableDTO.getNombreArchivoFotoExtensionoFormatoResponsable());
        responsable.setFechaHMSNacimientoResponsable(responsableDTO.getFechaHMSNacimientoResponsable());
        responsable.setSexoResponsable(responsableDTO.getSexoResponsable().toUpperCase());
        responsable.setDireccionResponsable(responsableDTO.getDireccionResponsable().toUpperCase());
        responsable.setTelefonoResponsable(responsableDTO.getTelefonoResponsable());
        responsable.setMovilResponsable(responsableDTO.getMovilResponsable());
        responsable.setCorreoElectronicoPersonalResponsable(responsableDTO.getCorreoElectronicoPersonalResponsable());
        responsable.setCorreoElectronicoInstitucionalResponsable(responsableDTO.getCorreoElectronicoInstitucionalResponsable());
        responsable.setPaisOrigenResponsable(responsableDTO.getPaisOrigenResponsable().toUpperCase());
        responsable.setDepartamentooEstadoOrigenResponsable(responsableDTO.getDepartamentooEstadoOrigenResponsable().toUpperCase());
        responsable.setCiudadOrigenResponsable(responsableDTO.getCiudadOrigenResponsable().toUpperCase());
        responsable.setNumeroCursoResponsable(responsableDTO.getNumeroCursoResponsable());
        responsable.setPuestoCursoResponsable(responsableDTO.getPuestoCursoResponsable());
        responsable.setEscalafonAntiguedadResponsable(responsableDTO.getEscalafonAntiguedadResponsable());
        responsable.setFechaHMSIncorporacionFFMMResponsable(responsableDTO.getFechaHMSIncorporacionFFMMResponsable());
        responsable.setFechaHMSIngresoResponsable(responsableDTO.getFechaHMSIngresoResponsable());
        responsable.setFechaHMSModificacionResponsable(responsableDTO.getFechaHMSModificacionResponsable());
        responsable.setEstadoResponsable(responsableDTO.getEstadoResponsable().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (responsableDTO.getUnidadMilitarDTO() != null && responsableDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(responsableDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(responsable::setUnidadMilitar);
        }
        
        //MAPEAR TIPO DOCUMENTO IDENTIFICACION RELACIONADO.
        if (responsableDTO.getTipoDocumentoIdentificacionDTO() != null && responsableDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(responsableDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(responsable::setTipoDocumentoIdentificacion);
        }
        
        return responsable;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param responsable
    * Recibe un objeto responsable para crear un DTO.
    * @return responsableDTO
    */
    public ResponsableDTO responsableDTO(Responsable responsable){
        ResponsableDTO responsableDTO = new ResponsableDTO();
        responsableDTO.setIdResponsable(responsable.getIdResponsable());
        responsableDTO.setUsuarioRedResponsable(responsable.getUsuarioRedResponsable());
        responsableDTO.setNumeroDocumentoIdentificacionResponsable(responsable.getNumeroDocumentoIdentificacionResponsable());
        responsableDTO.setLugarExpedicionDocumentoIdentificacionResponsable(responsable.getLugarExpedicionDocumentoIdentificacionResponsable().toUpperCase());
        responsableDTO.setGradoResponsable(responsable.getGradoResponsable());
        responsableDTO.setNombresResponsable(responsable.getNombresResponsable().toUpperCase());
        responsableDTO.setPrimerApellidoResponsable(responsable.getPrimerApellidoResponsable().toUpperCase());
        responsableDTO.setSegundoApellidoResponsable(responsable.getSegundoApellidoResponsable());
        responsableDTO.setArmaResponsable(responsable.getArmaResponsable());
        responsableDTO.setNombreArchivoFotoExtensionoFormatoResponsable(responsable.getNombreArchivoFotoExtensionoFormatoResponsable());
        responsableDTO.setFechaHMSNacimientoResponsable(responsable.getFechaHMSNacimientoResponsable());
        responsableDTO.setSexoResponsable(responsable.getSexoResponsable().toUpperCase());
        responsableDTO.setDireccionResponsable(responsable.getDireccionResponsable().toUpperCase());
        responsableDTO.setTelefonoResponsable(responsable.getTelefonoResponsable());
        responsableDTO.setMovilResponsable(responsable.getMovilResponsable());
        responsableDTO.setCorreoElectronicoPersonalResponsable(responsable.getCorreoElectronicoPersonalResponsable());
        responsableDTO.setCorreoElectronicoInstitucionalResponsable(responsable.getCorreoElectronicoInstitucionalResponsable());
        responsableDTO.setPaisOrigenResponsable(responsable.getPaisOrigenResponsable().toUpperCase());
        responsableDTO.setDepartamentooEstadoOrigenResponsable(responsable.getDepartamentooEstadoOrigenResponsable().toUpperCase());
        responsableDTO.setCiudadOrigenResponsable(responsable.getCiudadOrigenResponsable().toUpperCase());
        responsableDTO.setNumeroCursoResponsable(responsable.getNumeroCursoResponsable());
        responsableDTO.setPuestoCursoResponsable(responsable.getPuestoCursoResponsable());
        responsableDTO.setEscalafonAntiguedadResponsable(responsable.getEscalafonAntiguedadResponsable());
        responsableDTO.setFechaHMSIncorporacionFFMMResponsable(responsable.getFechaHMSIncorporacionFFMMResponsable());
        responsableDTO.setFechaHMSIngresoResponsable(responsable.getFechaHMSIngresoResponsable());
        responsableDTO.setFechaHMSModificacionResponsable(responsable.getFechaHMSModificacionResponsable());
        responsableDTO.setEstadoResponsable(responsable.getEstadoResponsable().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (responsable.getUnidadMilitar() != null && responsable.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(responsable.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> responsableDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        //MAPEAR TIPO DOCUMENTO IDENTIFICACION RELACIONADO.
        if (responsable.getTipoDocumentoIdentificacion() != null && responsable.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(responsable.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(tipoDocumentoIdentificacion -> responsableDTO.setTipoDocumentoIdentificacionDTO(tipoDocumentoIdentificacionDAO.tipoDocumentoIdentificacionDTO(tipoDocumentoIdentificacion)));
        }
        
        return responsableDTO;
    }
}
