//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAdqPapeleriaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAdqPapeleria;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
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
public class HistorialProyeccionAnualAdqPapeleriaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 10/04/2026.
    * @param historialProyeccionAnualAdqPapeleriaDTO
    * Recibe un DTO para crear un objeto historialProyeccionAnualAdqPapeleria.
    * @return historialProyeccionAnualAdqPapeleria
    */
    public HistorialProyeccionAnualAdqPapeleria historialProyeccionAnualAdqPapeleria(HistorialProyeccionAnualAdqPapeleriaDTO historialProyeccionAnualAdqPapeleriaDTO){
        HistorialProyeccionAnualAdqPapeleria historialProyeccionAnualAdqPapeleria = new HistorialProyeccionAnualAdqPapeleria();
        historialProyeccionAnualAdqPapeleria.setIdHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleriaDTO.getIdHistorialProyeccionAnualAdqPapeleria());
        historialProyeccionAnualAdqPapeleria.setNumRegHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleriaDTO.getNumRegHistorialProyeccionAnualAdqPapeleria().toUpperCase());
        historialProyeccionAnualAdqPapeleria.setValorContratoHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleriaDTO.getValorContratoHistorialProyeccionAnualAdqPapeleria());
        historialProyeccionAnualAdqPapeleria.setNumeroRubroPresupuestalHistProyAnAdqPap(historialProyeccionAnualAdqPapeleriaDTO.getNumeroRubroPresupuestalHistProyAnAdqPap());
        historialProyeccionAnualAdqPapeleria.setNombreArchivoDocumentoAnexoContratHistProyAnAdqPap(historialProyeccionAnualAdqPapeleriaDTO.getNombreArchivoDocumentoAnexoContratHistProyAnAdqPap());
        historialProyeccionAnualAdqPapeleria.setNombreArchivoDocumentoAnexoCotizHistProyAnAdqPap(historialProyeccionAnualAdqPapeleriaDTO.getNombreArchivoDocumentoAnexoCotizHistProyAnAdqPap());
        historialProyeccionAnualAdqPapeleria.setNombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap(historialProyeccionAnualAdqPapeleriaDTO.getNombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialProyeccionAnualAdqPapeleriaDTO.getUnidadMilitarDTO() != null && historialProyeccionAnualAdqPapeleriaDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialProyeccionAnualAdqPapeleriaDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(historialProyeccionAnualAdqPapeleria::setUnidadMilitar);
        }
        
        return historialProyeccionAnualAdqPapeleria;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 10/04/2026.
    * @param historialProyeccionAnualAdqPapeleria
    * Recibe un objeto historialProyeccionAnualAdqPapeleria para crear un DTO.
    * @return historialProyeccionAnualAdqPapeleriaDTO
    */
    public HistorialProyeccionAnualAdqPapeleriaDTO historialProyeccionAnualAdqPapeleriaDTO(HistorialProyeccionAnualAdqPapeleria historialProyeccionAnualAdqPapeleria){
        HistorialProyeccionAnualAdqPapeleriaDTO historialProyeccionAnualAdqPapeleriaDTO = new HistorialProyeccionAnualAdqPapeleriaDTO();
        historialProyeccionAnualAdqPapeleriaDTO.setIdHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleria.getIdHistorialProyeccionAnualAdqPapeleria());
        historialProyeccionAnualAdqPapeleriaDTO.setNumRegHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleria.getNumRegHistorialProyeccionAnualAdqPapeleria().toUpperCase());
        historialProyeccionAnualAdqPapeleriaDTO.setValorContratoHistorialProyeccionAnualAdqPapeleria(historialProyeccionAnualAdqPapeleria.getValorContratoHistorialProyeccionAnualAdqPapeleria());
        historialProyeccionAnualAdqPapeleriaDTO.setNumeroRubroPresupuestalHistProyAnAdqPap(historialProyeccionAnualAdqPapeleria.getNumeroRubroPresupuestalHistProyAnAdqPap());
        historialProyeccionAnualAdqPapeleriaDTO.setNombreArchivoDocumentoAnexoContratHistProyAnAdqPap(historialProyeccionAnualAdqPapeleria.getNombreArchivoDocumentoAnexoContratHistProyAnAdqPap());
        historialProyeccionAnualAdqPapeleriaDTO.setNombreArchivoDocumentoAnexoCotizHistProyAnAdqPap(historialProyeccionAnualAdqPapeleria.getNombreArchivoDocumentoAnexoCotizHistProyAnAdqPap());
        historialProyeccionAnualAdqPapeleriaDTO.setNombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap(historialProyeccionAnualAdqPapeleria.getNombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialProyeccionAnualAdqPapeleria.getUnidadMilitar() != null && historialProyeccionAnualAdqPapeleria.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialProyeccionAnualAdqPapeleria.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> historialProyeccionAnualAdqPapeleriaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        return historialProyeccionAnualAdqPapeleriaDTO;
    }
}
