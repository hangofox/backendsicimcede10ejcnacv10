//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialResponsableInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialResponsableInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
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
public class HistorialResponsableInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 14/04/2026.
    * @param historialResponsableInfraestructuraDTO
    * Recibe un DTO para crear un objeto historialResponsableInfraestructura.
    * @return historialResponsableInfraestructura
    */
    public HistorialResponsableInfraestructura historialResponsableInfraestructura(HistorialResponsableInfraestructuraDTO historialResponsableInfraestructuraDTO){
        HistorialResponsableInfraestructura historialResponsableInfraestructura = new HistorialResponsableInfraestructura();
        historialResponsableInfraestructura.setIdHistorialResponsableInfraestructura(historialResponsableInfraestructuraDTO.getIdHistorialResponsableInfraestructura());
        historialResponsableInfraestructura.setNumRegHistorialResponsableInfraestructura(historialResponsableInfraestructuraDTO.getNumRegHistorialResponsableInfraestructura().toUpperCase());
        historialResponsableInfraestructura.setSiglaOAcronimoUnidadMilitar(historialResponsableInfraestructuraDTO.getSiglaOAcronimoUnidadMilitar().toUpperCase());
        historialResponsableInfraestructura.setNombreTipoDocumentoIdentificacion(historialResponsableInfraestructuraDTO.getNombreTipoDocumentoIdentificacion().toUpperCase());
        historialResponsableInfraestructura.setNumeroDocumentoIdentificacionResponsable(historialResponsableInfraestructuraDTO.getNumeroDocumentoIdentificacionResponsable().toUpperCase());
        historialResponsableInfraestructura.setLugarExpedicionDocumentoIdentificacionResponsable(historialResponsableInfraestructuraDTO.getLugarExpedicionDocumentoIdentificacionResponsable().toUpperCase());
        historialResponsableInfraestructura.setGradoResponsable(historialResponsableInfraestructuraDTO.getGradoResponsable());
        historialResponsableInfraestructura.setNombresResponsable(historialResponsableInfraestructuraDTO.getNombresResponsable().toUpperCase());
        historialResponsableInfraestructura.setPrimerApellidoResponsable(historialResponsableInfraestructuraDTO.getPrimerApellidoResponsable().toUpperCase());
        historialResponsableInfraestructura.setSegundoApellidoResponsable(historialResponsableInfraestructuraDTO.getSegundoApellidoResponsable());
        historialResponsableInfraestructura.setSiONoActualResponsablePredeterminado(historialResponsableInfraestructuraDTO.getSiONoActualResponsablePredeterminado().toUpperCase());
        historialResponsableInfraestructura.setNumeroCursoResponsable(historialResponsableInfraestructuraDTO.getNumeroCursoResponsable().toUpperCase());
        historialResponsableInfraestructura.setPuestoCursoResponsable(historialResponsableInfraestructuraDTO.getPuestoCursoResponsable().toUpperCase());
        historialResponsableInfraestructura.setEscalafonAntiguedadResponsable(historialResponsableInfraestructuraDTO.getEscalafonAntiguedadResponsable().toUpperCase());
        historialResponsableInfraestructura.setFechaHMSIngresoResponsable(historialResponsableInfraestructuraDTO.getFechaHMSIngresoResponsable());
        historialResponsableInfraestructura.setFechaHMSModificacionResponsable(historialResponsableInfraestructuraDTO.getFechaHMSModificacionResponsable());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialResponsableInfraestructuraDTO.getInfraestructuraDTO() != null && historialResponsableInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialResponsableInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(historialResponsableInfraestructura::setInfraestructura);
        }
        
        return historialResponsableInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 14/04/2026.
    * @param historialResponsableInfraestructura
    * Recibe un objeto historialResponsableInfraestructura para crear un DTO.
    * @return historialResponsableInfraestructuraDTO
    */
    public HistorialResponsableInfraestructuraDTO historialResponsableInfraestructuraDTO(HistorialResponsableInfraestructura historialResponsableInfraestructura){
        HistorialResponsableInfraestructuraDTO historialResponsableInfraestructuraDTO = new HistorialResponsableInfraestructuraDTO();
        historialResponsableInfraestructuraDTO.setIdHistorialResponsableInfraestructura(historialResponsableInfraestructura.getIdHistorialResponsableInfraestructura());
        historialResponsableInfraestructuraDTO.setNumRegHistorialResponsableInfraestructura(historialResponsableInfraestructura.getNumRegHistorialResponsableInfraestructura().toUpperCase());
        historialResponsableInfraestructuraDTO.setSiglaOAcronimoUnidadMilitar(historialResponsableInfraestructura.getSiglaOAcronimoUnidadMilitar().toUpperCase());
        historialResponsableInfraestructuraDTO.setNombreTipoDocumentoIdentificacion(historialResponsableInfraestructura.getNombreTipoDocumentoIdentificacion().toUpperCase());
        historialResponsableInfraestructuraDTO.setNumeroDocumentoIdentificacionResponsable(historialResponsableInfraestructura.getNumeroDocumentoIdentificacionResponsable().toUpperCase());
        historialResponsableInfraestructuraDTO.setLugarExpedicionDocumentoIdentificacionResponsable(historialResponsableInfraestructura.getLugarExpedicionDocumentoIdentificacionResponsable().toUpperCase());
        historialResponsableInfraestructuraDTO.setGradoResponsable(historialResponsableInfraestructura.getGradoResponsable());
        historialResponsableInfraestructuraDTO.setNombresResponsable(historialResponsableInfraestructura.getNombresResponsable().toUpperCase());
        historialResponsableInfraestructuraDTO.setPrimerApellidoResponsable(historialResponsableInfraestructura.getPrimerApellidoResponsable().toUpperCase());
        historialResponsableInfraestructuraDTO.setSegundoApellidoResponsable(historialResponsableInfraestructura.getSegundoApellidoResponsable());
        historialResponsableInfraestructuraDTO.setSiONoActualResponsablePredeterminado(historialResponsableInfraestructura.getSiONoActualResponsablePredeterminado().toUpperCase());
        historialResponsableInfraestructuraDTO.setNumeroCursoResponsable(historialResponsableInfraestructura.getNumeroCursoResponsable().toUpperCase());
        historialResponsableInfraestructuraDTO.setPuestoCursoResponsable(historialResponsableInfraestructura.getPuestoCursoResponsable().toUpperCase());
        historialResponsableInfraestructuraDTO.setEscalafonAntiguedadResponsable(historialResponsableInfraestructura.getEscalafonAntiguedadResponsable().toUpperCase());
        historialResponsableInfraestructuraDTO.setFechaHMSIngresoResponsable(historialResponsableInfraestructura.getFechaHMSIngresoResponsable());
        historialResponsableInfraestructuraDTO.setFechaHMSModificacionResponsable(historialResponsableInfraestructura.getFechaHMSModificacionResponsable());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialResponsableInfraestructura.getInfraestructura() != null && historialResponsableInfraestructura.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialResponsableInfraestructura.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> historialResponsableInfraestructuraDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return historialResponsableInfraestructuraDTO;
    }
}
