//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialPagoAnualImpuestoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialPagoAnualImpuestoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Terreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEntidadInstitucional;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoReduccionImpuestoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TerrenoRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEntidadInstitucionalRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoReduccionImpuestoTerrenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialPagoAnualImpuestoTerrenoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TerrenoRepository terrenoRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEntidadInstitucionalRepository tipoEntidadInstitucionalRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoReduccionImpuestoTerrenoRepository tipoReduccionImpuestoTerrenoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TerrenoDAO terrenoDAO;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEntidadInstitucionalDAO tipoEntidadInstitucionalDAO;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoReduccionImpuestoTerrenoDAO tipoReduccionImpuestoTerrenoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param historialPagoAnualImpuestoTerrenoDTO
    * Recibe un DTO para crear un objeto historialPagoAnualImpuestoTerreno.
    * @return historialPagoAnualImpuestoTerreno
    */
    public HistorialPagoAnualImpuestoTerreno historialPagoAnualImpuestoTerreno(HistorialPagoAnualImpuestoTerrenoDTO historialPagoAnualImpuestoTerrenoDTO){
        HistorialPagoAnualImpuestoTerreno historialPagoAnualImpuestoTerreno = new HistorialPagoAnualImpuestoTerreno();
        historialPagoAnualImpuestoTerreno.setIdHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getIdHistorialPagoAnualImpuestoTerreno());
        historialPagoAnualImpuestoTerreno.setNumRegHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getNumRegHistorialPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerreno.setValorTotalHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getValorTotalHistorialPagoAnualImpuestoTerreno());
        historialPagoAnualImpuestoTerreno.setFechaHMSHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getFechaHMSHistorialPagoAnualImpuestoTerreno());
        historialPagoAnualImpuestoTerreno.setNombreEntidadInstitucionalPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getNombreEntidadInstitucionalPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerreno.setNumeroFacturaHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getNumeroFacturaHistorialPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerreno.setSiONoReduccionHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getSiONoReduccionHistorialPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerreno.setNumeroPorcentajeReduccHistPagAnImpTerr(historialPagoAnualImpuestoTerrenoDTO.getNumeroPorcentajeReduccHistPagAnImpTerr());
        historialPagoAnualImpuestoTerreno.setNombreArchivoDocumentoAnexoFactHistPagAnImpTerr(historialPagoAnualImpuestoTerrenoDTO.getNombreArchivoDocumentoAnexoFactHistPagAnImpTerr());
        
        //MAPEAR TERRENO RELACIONADO.
        if (historialPagoAnualImpuestoTerrenoDTO.getTerrenoDTO() != null && historialPagoAnualImpuestoTerrenoDTO.getTerrenoDTO().getIdTerreno() != null) {
           Optional<Terreno> terrenoFk = terrenoRepository.findByIdTerreno(historialPagoAnualImpuestoTerrenoDTO.getTerrenoDTO().getIdTerreno());
           terrenoFk.ifPresent(historialPagoAnualImpuestoTerreno::setTerreno);
        }
        
        //MAPEAR TIPO DE ENTIDAD INSTITUCIONAL RELACIONADO.
        if (historialPagoAnualImpuestoTerrenoDTO.getTipoEntidadInstitucionalDTO() != null && historialPagoAnualImpuestoTerrenoDTO.getTipoEntidadInstitucionalDTO().getIdTipoEntidadInstitucional() != null) {
           Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalFk = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(historialPagoAnualImpuestoTerrenoDTO.getTipoEntidadInstitucionalDTO().getIdTipoEntidadInstitucional());
           tipoEntidadInstitucionalFk.ifPresent(historialPagoAnualImpuestoTerreno::setTipoEntidadInstitucional);
        }
        
        //MAPEAR TIPO DE REDUCCION DEL IMPUESTO DEL TERRENO RELACIONADO.
        if (historialPagoAnualImpuestoTerrenoDTO.getTipoReduccionImpuestoTerrenoDTO() != null && historialPagoAnualImpuestoTerrenoDTO.getTipoReduccionImpuestoTerrenoDTO().getIdTipoReduccionImpuestoTerreno() != null) {
           Optional<TipoReduccionImpuestoTerreno> tipoReduccionImpuestoTerrenoFk = tipoReduccionImpuestoTerrenoRepository.findByIdTipoReduccionImpuestoTerreno(historialPagoAnualImpuestoTerrenoDTO.getTipoReduccionImpuestoTerrenoDTO().getIdTipoReduccionImpuestoTerreno());
           tipoReduccionImpuestoTerrenoFk.ifPresent(historialPagoAnualImpuestoTerreno::setTipoReduccionImpuestoTerreno);
        }
        
        return historialPagoAnualImpuestoTerreno;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param historialPagoAnualImpuestoTerreno
    * Recibe un objeto historialPagoAnualImpuestoTerreno para crear un DTO.
    * @return historialPagoAnualImpuestoTerrenoDTO
    */
    public HistorialPagoAnualImpuestoTerrenoDTO historialPagoAnualImpuestoTerrenoDTO(HistorialPagoAnualImpuestoTerreno historialPagoAnualImpuestoTerreno){
        HistorialPagoAnualImpuestoTerrenoDTO historialPagoAnualImpuestoTerrenoDTO = new HistorialPagoAnualImpuestoTerrenoDTO();
        historialPagoAnualImpuestoTerrenoDTO.setIdHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerreno.getIdHistorialPagoAnualImpuestoTerreno());
        historialPagoAnualImpuestoTerrenoDTO.setNumRegHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerreno.getNumRegHistorialPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerrenoDTO.setValorTotalHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerreno.getValorTotalHistorialPagoAnualImpuestoTerreno());
        historialPagoAnualImpuestoTerrenoDTO.setFechaHMSHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerreno.getFechaHMSHistorialPagoAnualImpuestoTerreno());
        historialPagoAnualImpuestoTerrenoDTO.setNombreEntidadInstitucionalPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerreno.getNombreEntidadInstitucionalPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerrenoDTO.setNumeroFacturaHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerreno.getNumeroFacturaHistorialPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerrenoDTO.setSiONoReduccionHistorialPagoAnualImpuestoTerreno(historialPagoAnualImpuestoTerreno.getSiONoReduccionHistorialPagoAnualImpuestoTerreno().toUpperCase());
        historialPagoAnualImpuestoTerrenoDTO.setNumeroPorcentajeReduccHistPagAnImpTerr(historialPagoAnualImpuestoTerreno.getNumeroPorcentajeReduccHistPagAnImpTerr());
        historialPagoAnualImpuestoTerrenoDTO.setNombreArchivoDocumentoAnexoFactHistPagAnImpTerr(historialPagoAnualImpuestoTerreno.getNombreArchivoDocumentoAnexoFactHistPagAnImpTerr());
        
        //MAPEAR TERRENO RELACIONADO.
        if (historialPagoAnualImpuestoTerreno.getTerreno() != null && historialPagoAnualImpuestoTerreno.getTerreno().getIdTerreno() != null) {
           Optional<Terreno> terrenoFk = terrenoRepository.findByIdTerreno(historialPagoAnualImpuestoTerreno.getTerreno().getIdTerreno());
           terrenoFk.ifPresent(terr -> historialPagoAnualImpuestoTerrenoDTO.setTerrenoDTO(terrenoDAO.terrenoDTO(terr)));
        }
        
        //MAPEAR TIPO DE ENTIDAD INSTITUCIONAL RELACIONADO.
        if (historialPagoAnualImpuestoTerreno.getTipoEntidadInstitucional() != null && historialPagoAnualImpuestoTerreno.getTipoEntidadInstitucional().getIdTipoEntidadInstitucional() != null) {
           Optional<TipoEntidadInstitucional> tipoEntidadInstitucionalFk = tipoEntidadInstitucionalRepository.findByIdTipoEntidadInstitucional(historialPagoAnualImpuestoTerreno.getTipoEntidadInstitucional().getIdTipoEntidadInstitucional());
           tipoEntidadInstitucionalFk.ifPresent(tipoEnt -> historialPagoAnualImpuestoTerrenoDTO.setTipoEntidadInstitucionalDTO(tipoEntidadInstitucionalDAO.tipoEntidadInstitucionalDTO(tipoEnt)));
        }
        
        //MAPEAR TIPO DE REDUCCION DEL IMPUESTO DEL TERRENO RELACIONADO.
        if (historialPagoAnualImpuestoTerreno.getTipoReduccionImpuestoTerreno() != null && historialPagoAnualImpuestoTerreno.getTipoReduccionImpuestoTerreno().getIdTipoReduccionImpuestoTerreno() != null) {
           Optional<TipoReduccionImpuestoTerreno> tipoReduccionImpuestoTerrenoFk = tipoReduccionImpuestoTerrenoRepository.findByIdTipoReduccionImpuestoTerreno(historialPagoAnualImpuestoTerreno.getTipoReduccionImpuestoTerreno().getIdTipoReduccionImpuestoTerreno());
           tipoReduccionImpuestoTerrenoFk.ifPresent(tipoRed -> historialPagoAnualImpuestoTerrenoDTO.setTipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerrenoDTO(tipoRed)));
        }
        
        return historialPagoAnualImpuestoTerrenoDTO;
    }
}
