//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InformacionFinancieraSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ActividadProductoInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InformacionFinancieraSolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoFuenteFinanciacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ActividadProductoInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoFuenteFinanciacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class InformacionFinancieraSolicitudInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SolicitudInfraestructuraDAO solicitudInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoFuenteFinanciacionRepository tipoFuenteFinanciacionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoFuenteFinanciacionDAO tipoFuenteFinanciacionDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ActividadProductoInfraestructuraRepository actividadProductoInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ActividadProductoInfraestructuraDAO actividadProductoInfraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param informacionFinancieraSolicitudInfraestructuraDTO
    * Recibe un DTO para crear un objeto informacionFinancieraSolicitudInfraestructura.
    * @return informacionFinancieraSolicitudInfraestructura
    */
    public InformacionFinancieraSolicitudInfraestructura informacionFinancieraSolicitudInfraestructura(InformacionFinancieraSolicitudInfraestructuraDTO informacionFinancieraSolicitudInfraestructuraDTO){
        InformacionFinancieraSolicitudInfraestructura informacionFinancieraSolicitudInfraestructura = new InformacionFinancieraSolicitudInfraestructura();
        informacionFinancieraSolicitudInfraestructura.setIdInformacionFinancieraSolicitudInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getIdInformacionFinancieraSolicitudInfraestructura());
        informacionFinancieraSolicitudInfraestructura.setObservacionesPresupuestoInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getObservacionesPresupuestoInfraestructura());
        informacionFinancieraSolicitudInfraestructura.setCantidadActividadProductoInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getCantidadActividadProductoInfraestructura());
        informacionFinancieraSolicitudInfraestructura.setValorCostoUnitarioCapituloProductoInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getValorCostoUnitarioCapituloProductoInfraestructura());
        informacionFinancieraSolicitudInfraestructura.setNumeroAreaIntervencionInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getNumeroAreaIntervencionInfraestructura().toUpperCase());
        informacionFinancieraSolicitudInfraestructura.setNombreUnidadMedidaAreaIntervencionInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getNombreUnidadMedidaAreaIntervencionInfraestructura().toUpperCase());
        
        //MAPEAR SOLICITUD DE INFRAESTRUCTURA RELACIONADA.
        if (informacionFinancieraSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO() != null && informacionFinancieraSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(informacionFinancieraSolicitudInfraestructura::setSolicitudInfraestructura);
        }
        
        //MAPEAR TIPO FUENTE DE FINANCIACIÓN RELACIONADA.
        if (informacionFinancieraSolicitudInfraestructuraDTO.getTipoFuenteFinanciacionDTO() != null && informacionFinancieraSolicitudInfraestructuraDTO.getTipoFuenteFinanciacionDTO().getIdTipoFuenteFinanciacion() != null) {
           Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionFk = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(informacionFinancieraSolicitudInfraestructuraDTO.getTipoFuenteFinanciacionDTO().getIdTipoFuenteFinanciacion());
           tipoFuenteFinanciacionFk.ifPresent(informacionFinancieraSolicitudInfraestructura::setTipoFuenteFinanciacion);
        }
        
        //MAPEAR ACTIVIDAD DEL PRODUCTO DE INFRAESTRUCTURA RELACIONADA.
        if (informacionFinancieraSolicitudInfraestructuraDTO.getActividadProductoInfraestructuraDTO() != null && informacionFinancieraSolicitudInfraestructuraDTO.getActividadProductoInfraestructuraDTO().getIdActividadProductoInfraestructura() != null) {
           Optional<ActividadProductoInfraestructura> actividadProductoInfraestructuraFk = actividadProductoInfraestructuraRepository.findByIdActividadProductoInfraestructura(informacionFinancieraSolicitudInfraestructuraDTO.getActividadProductoInfraestructuraDTO().getIdActividadProductoInfraestructura());
           actividadProductoInfraestructuraFk.ifPresent(informacionFinancieraSolicitudInfraestructura::setActividadProductoInfraestructura);
        }
        
        return informacionFinancieraSolicitudInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param informacionFinancieraSolicitudInfraestructura
    * Recibe un objeto informacionFinancieraSolicitudInfraestructura para crear un DTO.
    * @return informacionFinancieraSolicitudInfraestructuraDTO
    */
    public InformacionFinancieraSolicitudInfraestructuraDTO informacionFinancieraSolicitudInfraestructuraDTO(InformacionFinancieraSolicitudInfraestructura informacionFinancieraSolicitudInfraestructura){
        InformacionFinancieraSolicitudInfraestructuraDTO informacionFinancieraSolicitudInfraestructuraDTO = new InformacionFinancieraSolicitudInfraestructuraDTO();
        informacionFinancieraSolicitudInfraestructuraDTO.setIdInformacionFinancieraSolicitudInfraestructura(informacionFinancieraSolicitudInfraestructura.getIdInformacionFinancieraSolicitudInfraestructura());
        informacionFinancieraSolicitudInfraestructuraDTO.setObservacionesPresupuestoInfraestructura(informacionFinancieraSolicitudInfraestructura.getObservacionesPresupuestoInfraestructura());
        informacionFinancieraSolicitudInfraestructuraDTO.setCantidadActividadProductoInfraestructura(informacionFinancieraSolicitudInfraestructura.getCantidadActividadProductoInfraestructura());
        informacionFinancieraSolicitudInfraestructuraDTO.setValorCostoUnitarioCapituloProductoInfraestructura(informacionFinancieraSolicitudInfraestructura.getValorCostoUnitarioCapituloProductoInfraestructura());
        informacionFinancieraSolicitudInfraestructuraDTO.setNumeroAreaIntervencionInfraestructura(informacionFinancieraSolicitudInfraestructura.getNumeroAreaIntervencionInfraestructura().toUpperCase());
        informacionFinancieraSolicitudInfraestructuraDTO.setNombreUnidadMedidaAreaIntervencionInfraestructura(informacionFinancieraSolicitudInfraestructura.getNombreUnidadMedidaAreaIntervencionInfraestructura().toUpperCase());
        
        //MAPEAR SOLICITUD DE INFRAESTRUCTURA RELACIONADA.
        if (informacionFinancieraSolicitudInfraestructura.getSolicitudInfraestructura() != null && informacionFinancieraSolicitudInfraestructura.getSolicitudInfraestructura().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(informacionFinancieraSolicitudInfraestructura.getSolicitudInfraestructura().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(solicInfra -> informacionFinancieraSolicitudInfraestructuraDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicInfra)));
        }
        
        //MAPEAR TIPO FUENTE DE FINANCIACIÓN RELACIONADA.
        if (informacionFinancieraSolicitudInfraestructura.getTipoFuenteFinanciacion() != null && informacionFinancieraSolicitudInfraestructura.getTipoFuenteFinanciacion().getIdTipoFuenteFinanciacion() != null) {
           Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionFk = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(informacionFinancieraSolicitudInfraestructura.getTipoFuenteFinanciacion().getIdTipoFuenteFinanciacion());
           tipoFuenteFinanciacionFk.ifPresent(tipoFuenteFin -> informacionFinancieraSolicitudInfraestructuraDTO.setTipoFuenteFinanciacionDTO(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFin)));
        }
        
        //MAPEAR ACTIVIDAD DEL PRODUCTO DE INFRAESTRUCTURA RELACIONADA.
        if (informacionFinancieraSolicitudInfraestructura.getActividadProductoInfraestructura() != null && informacionFinancieraSolicitudInfraestructura.getActividadProductoInfraestructura().getIdActividadProductoInfraestructura() != null) {
           Optional<ActividadProductoInfraestructura> actividadProductoInfraestructuraFk = actividadProductoInfraestructuraRepository.findByIdActividadProductoInfraestructura(informacionFinancieraSolicitudInfraestructura.getActividadProductoInfraestructura().getIdActividadProductoInfraestructura());
           actividadProductoInfraestructuraFk.ifPresent(actProdInfra -> informacionFinancieraSolicitudInfraestructuraDTO.setActividadProductoInfraestructuraDTO(actividadProductoInfraestructuraDAO.actividadProductoInfraestructuraDTO(actProdInfra)));
        }
        
        return informacionFinancieraSolicitudInfraestructuraDTO;
    }
}
