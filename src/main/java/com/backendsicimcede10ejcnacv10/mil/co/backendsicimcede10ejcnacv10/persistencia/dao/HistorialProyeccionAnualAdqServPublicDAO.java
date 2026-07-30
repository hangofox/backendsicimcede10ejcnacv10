//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAdqServPublicDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAdqServPublic;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoServicioPublico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoServicioPublicoRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 10/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialProyeccionAnualAdqServPublicDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoServicioPublicoRepository tipoServicioPublicoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoServicioPublicoDAO tipoServicioPublicoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 10/04/2026.
    * @param historialProyeccionAnualAdqServPublicDTO
    * Recibe un DTO para crear un objeto historialProyeccionAnualAdqServPublic.
    * @return historialProyeccionAnualAdqServPublic
    */
    public HistorialProyeccionAnualAdqServPublic historialProyeccionAnualAdqServPublic(HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO){
        HistorialProyeccionAnualAdqServPublic historialProyeccionAnualAdqServPublic = new HistorialProyeccionAnualAdqServPublic();
        historialProyeccionAnualAdqServPublic.setIdHistorialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getIdHistorialProyeccionAnualAdqServPublic());
        historialProyeccionAnualAdqServPublic.setNumRegHistorialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getNumRegHistorialProyeccionAnualAdqServPublic().toUpperCase());
        historialProyeccionAnualAdqServPublic.setValorTotalHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getValorTotalHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublic.setFechaHMSHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getFechaHMSHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublic.setTelefonoHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getTelefonoHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublic.setMovilHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getMovilHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublic.setNombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic(historialProyeccionAnualAdqServPublicDTO.getNombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialProyeccionAnualAdqServPublicDTO.getInfraestructuraDTO() != null && historialProyeccionAnualAdqServPublicDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialProyeccionAnualAdqServPublicDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(historialProyeccionAnualAdqServPublic::setInfraestructura);
        }
        
        //MAPEAR TIPO SERVICIO DE PUBLICO RELACIONADO.
        if (historialProyeccionAnualAdqServPublicDTO.getTipoServicioPublicoDTO() != null && historialProyeccionAnualAdqServPublicDTO.getTipoServicioPublicoDTO().getIdTipoServicioPublico() != null) {
           Optional<TipoServicioPublico> tipoServicioPublicoFk = tipoServicioPublicoRepository.findByIdTipoServicioPublico(historialProyeccionAnualAdqServPublicDTO.getTipoServicioPublicoDTO().getIdTipoServicioPublico());
           tipoServicioPublicoFk.ifPresent(historialProyeccionAnualAdqServPublic::setTipoServicioPublico);
        }
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialProyeccionAnualAdqServPublicDTO.getUnidadMilitarDTO() != null && historialProyeccionAnualAdqServPublicDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialProyeccionAnualAdqServPublicDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(historialProyeccionAnualAdqServPublic::setUnidadMilitar);
        }
        
        return historialProyeccionAnualAdqServPublic;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 10/04/2026.
    * @param historialProyeccionAnualAdqServPublic
    * Recibe un objeto historialProyeccionAnualAdqServPublic para crear un DTO.
    * @return historialProyeccionAnualAdqServPublicDTO
    */
    public HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO(HistorialProyeccionAnualAdqServPublic historialProyeccionAnualAdqServPublic){
        HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO = new HistorialProyeccionAnualAdqServPublicDTO();
        historialProyeccionAnualAdqServPublicDTO.setIdHistorialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublic.getIdHistorialProyeccionAnualAdqServPublic());
        historialProyeccionAnualAdqServPublicDTO.setNumRegHistorialProyeccionAnualAdqServPublic(historialProyeccionAnualAdqServPublic.getNumRegHistorialProyeccionAnualAdqServPublic().toUpperCase());
        historialProyeccionAnualAdqServPublicDTO.setValorTotalHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublic.getValorTotalHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublicDTO.setFechaHMSHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublic.getFechaHMSHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublicDTO.setTelefonoHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublic.getTelefonoHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublicDTO.setMovilHistorialPagoAnualAdqServPublic(historialProyeccionAnualAdqServPublic.getMovilHistorialPagoAnualAdqServPublic());
        historialProyeccionAnualAdqServPublicDTO.setNombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic(historialProyeccionAnualAdqServPublic.getNombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialProyeccionAnualAdqServPublic.getInfraestructura() != null && historialProyeccionAnualAdqServPublic.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialProyeccionAnualAdqServPublic.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> historialProyeccionAnualAdqServPublicDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        //MAPEAR TIPO SERVICIO PUBLICO RELACIONADO.
        if (historialProyeccionAnualAdqServPublic.getTipoServicioPublico() != null && historialProyeccionAnualAdqServPublic.getTipoServicioPublico().getIdTipoServicioPublico() != null) {
           Optional<TipoServicioPublico> tipoServicioPublicoFk = tipoServicioPublicoRepository.findByIdTipoServicioPublico(historialProyeccionAnualAdqServPublic.getTipoServicioPublico().getIdTipoServicioPublico());
           tipoServicioPublicoFk.ifPresent(tipoServPubl -> historialProyeccionAnualAdqServPublicDTO.setTipoServicioPublicoDTO(tipoServicioPublicoDAO.tipoServicioPublicoDTO(tipoServPubl)));
        }
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialProyeccionAnualAdqServPublic.getUnidadMilitar() != null && historialProyeccionAnualAdqServPublic.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialProyeccionAnualAdqServPublic.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> historialProyeccionAnualAdqServPublicDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        return historialProyeccionAnualAdqServPublicDTO;
    }
}
