//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMantenimientoInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMantenimientoInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoFuenteFinanciacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoFuenteFinanciacionRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoMantenimientoInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialMantenimientoInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoMantenimientoInfraestructuraRepository tipoMantenimientoInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoMantenimientoInfraestructuraDAO tipoMantenimientoInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoFuenteFinanciacionRepository tipoFuenteFinanciacionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoFuenteFinanciacionDAO tipoFuenteFinanciacionDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMantenimientoInfraestructuraDTO
    * Recibe un DTO para crear un objeto historialMantenimientoInfraestructura.
    * @return historialMantenimientoInfraestructura
    */
    public HistorialMantenimientoInfraestructura historialMantenimientoInfraestructura(HistorialMantenimientoInfraestructuraDTO historialMantenimientoInfraestructuraDTO){
        HistorialMantenimientoInfraestructura historialMantenimientoInfraestructura = new HistorialMantenimientoInfraestructura();
        historialMantenimientoInfraestructura.setIdHistorialMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getIdHistorialMantenimientoInfraestructura());
        historialMantenimientoInfraestructura.setNumRegHistorialMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getNumRegHistorialMantenimientoInfraestructura().toUpperCase());
        historialMantenimientoInfraestructura.setAsuntoMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getAsuntoMantenimientoInfraestructura());
        historialMantenimientoInfraestructura.setDescripcionMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getDescripcionMantenimientoInfraestructura());
        historialMantenimientoInfraestructura.setFechaHMSMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getFechaHMSMantenimientoInfraestructura());
        historialMantenimientoInfraestructura.setValorCostoMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getValorCostoMantenimientoInfraestructura());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialMantenimientoInfraestructuraDTO.getInfraestructuraDTO() != null && historialMantenimientoInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialMantenimientoInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(historialMantenimientoInfraestructura::setInfraestructura);
        }
        
        //MAPEAR TIPO DE MANTENIMIENTO DE INFRAESTRUCTURA RELACIONADO.
        if (historialMantenimientoInfraestructuraDTO.getTipoMantenimientoInfraestructuraDTO() != null && historialMantenimientoInfraestructuraDTO.getTipoMantenimientoInfraestructuraDTO().getIdTipoMantenimientoInfraestructura() != null) {
           Optional<TipoMantenimientoInfraestructura> tipoMantenimientoInfraestructuraFk = tipoMantenimientoInfraestructuraRepository.findByIdTipoMantenimientoInfraestructura(historialMantenimientoInfraestructuraDTO.getTipoMantenimientoInfraestructuraDTO().getIdTipoMantenimientoInfraestructura());
           tipoMantenimientoInfraestructuraFk.ifPresent(historialMantenimientoInfraestructura::setTipoMantenimientoInfraestructura);
        }
        
        //MAPEAR TIPO DE FUENTE DE FINANCIACIÓN RELACIONADA.
        if (historialMantenimientoInfraestructuraDTO.getTipoFuenteFinanciacionDTO() != null && historialMantenimientoInfraestructuraDTO.getTipoFuenteFinanciacionDTO().getIdTipoFuenteFinanciacion() != null) {
           Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionFk = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(historialMantenimientoInfraestructuraDTO.getTipoFuenteFinanciacionDTO().getIdTipoFuenteFinanciacion());
           tipoFuenteFinanciacionFk.ifPresent(historialMantenimientoInfraestructura::setTipoFuenteFinanciacion);
        }
        
        return historialMantenimientoInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMantenimientoInfraestructura
    * Recibe un objeto historialMantenimientoInfraestructura para crear un DTO.
    * @return historialMantenimientoInfraestructuraDTO
    */
    public HistorialMantenimientoInfraestructuraDTO historialMantenimientoInfraestructuraDTO(HistorialMantenimientoInfraestructura historialMantenimientoInfraestructura){
        HistorialMantenimientoInfraestructuraDTO historialMantenimientoInfraestructuraDTO = new HistorialMantenimientoInfraestructuraDTO();
        historialMantenimientoInfraestructuraDTO.setIdHistorialMantenimientoInfraestructura(historialMantenimientoInfraestructura.getIdHistorialMantenimientoInfraestructura());
        historialMantenimientoInfraestructuraDTO.setNumRegHistorialMantenimientoInfraestructura(historialMantenimientoInfraestructura.getNumRegHistorialMantenimientoInfraestructura().toUpperCase());
        historialMantenimientoInfraestructuraDTO.setAsuntoMantenimientoInfraestructura(historialMantenimientoInfraestructura.getAsuntoMantenimientoInfraestructura());
        historialMantenimientoInfraestructuraDTO.setDescripcionMantenimientoInfraestructura(historialMantenimientoInfraestructura.getDescripcionMantenimientoInfraestructura());
        historialMantenimientoInfraestructuraDTO.setFechaHMSMantenimientoInfraestructura(historialMantenimientoInfraestructura.getFechaHMSMantenimientoInfraestructura());
        historialMantenimientoInfraestructuraDTO.setValorCostoMantenimientoInfraestructura(historialMantenimientoInfraestructura.getValorCostoMantenimientoInfraestructura());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialMantenimientoInfraestructura.getInfraestructura() != null && historialMantenimientoInfraestructura.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialMantenimientoInfraestructura.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infraest -> historialMantenimientoInfraestructuraDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infraest)));
        }
        
        //MAPEAR TIPO DE MANTENIMIENTO DE INFRAESTRUCTURA RELACIONADO.
        if (historialMantenimientoInfraestructura.getTipoMantenimientoInfraestructura() != null && historialMantenimientoInfraestructura.getTipoMantenimientoInfraestructura().getIdTipoMantenimientoInfraestructura() != null) {
           Optional<TipoMantenimientoInfraestructura> tipoMantenimientoInfraestructuraFk = tipoMantenimientoInfraestructuraRepository.findByIdTipoMantenimientoInfraestructura(historialMantenimientoInfraestructura.getTipoMantenimientoInfraestructura().getIdTipoMantenimientoInfraestructura());
           tipoMantenimientoInfraestructuraFk.ifPresent(tipoMttoInfraest -> historialMantenimientoInfraestructuraDTO.setTipoMantenimientoInfraestructuraDTO(tipoMantenimientoInfraestructuraDAO.tipoMantenimientoInfraestructuraDTO(tipoMttoInfraest)));
        }
        
        //MAPEAR TIPO DE FUENTE DE FINANCIACIÓN RELACIONADA.
        if (historialMantenimientoInfraestructura.getTipoFuenteFinanciacion() != null && historialMantenimientoInfraestructura.getTipoFuenteFinanciacion().getIdTipoFuenteFinanciacion() != null) {
           Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionFk = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(historialMantenimientoInfraestructura.getTipoFuenteFinanciacion().getIdTipoFuenteFinanciacion());
           tipoFuenteFinanciacionFk.ifPresent(tipoFuenteFin -> historialMantenimientoInfraestructuraDTO.setTipoFuenteFinanciacionDTO(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFin)));
        }
        
        return historialMantenimientoInfraestructuraDTO;
    }
}
