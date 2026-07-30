//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualMultaYSancionatoriaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualMultaYSancionatoria;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialProyeccionAnualMultaYSancionatoriaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 13/04/2026.
    * @param historialProyeccionAnualMultaYSancionatoriaDTO
    * Recibe un DTO para crear un objeto historialProyeccionAnualMultaYSancionatoria.
    * @return historialProyeccionAnualMultaYSancionatoria
    */
    public HistorialProyeccionAnualMultaYSancionatoria historialProyeccionAnualMultaYSancionatoria(HistorialProyeccionAnualMultaYSancionatoriaDTO historialProyeccionAnualMultaYSancionatoriaDTO){
        HistorialProyeccionAnualMultaYSancionatoria historialProyeccionAnualMultaYSancionatoria = new HistorialProyeccionAnualMultaYSancionatoria();
        historialProyeccionAnualMultaYSancionatoria.setIdHistorialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoriaDTO.getIdHistorialProyeccionAnualMultaYSancionatoria());
        historialProyeccionAnualMultaYSancionatoria.setNumRegHistorialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoriaDTO.getNumRegHistorialProyeccionAnualMultaYSancionatoria().toUpperCase());
        historialProyeccionAnualMultaYSancionatoria.setNumeroAutoAmbientalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoriaDTO.getNumeroAutoAmbientalHistProyAnMultYSanc());
        historialProyeccionAnualMultaYSancionatoria.setDenominacionAutoAmbientalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoriaDTO.getDenominacionAutoAmbientalHistProyAnMultYSanc().toUpperCase());
        historialProyeccionAnualMultaYSancionatoria.setObservacionesAutoAmbientalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoriaDTO.getObservacionesAutoAmbientalHistProyAnMultYSanc());
        historialProyeccionAnualMultaYSancionatoria.setValorPresupuestalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoriaDTO.getValorPresupuestalHistProyAnMultYSanc());
        historialProyeccionAnualMultaYSancionatoria.setNombreArchivoDocumentoAnexoHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoriaDTO.getNombreArchivoDocumentoAnexoHistProyAnMultYSanc());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialProyeccionAnualMultaYSancionatoriaDTO.getUnidadMilitarDTO() != null && historialProyeccionAnualMultaYSancionatoriaDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialProyeccionAnualMultaYSancionatoriaDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(historialProyeccionAnualMultaYSancionatoria::setUnidadMilitar);
        }
        
        return historialProyeccionAnualMultaYSancionatoria;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 13/04/2026.
    * @param historialProyeccionAnualMultaYSancionatoria
    * Recibe un objeto historialProyeccionAnualMultaYSancionatoria para crear un DTO.
    * @return historialProyeccionAnualMultaYSancionatoriaDTO
    */
    public HistorialProyeccionAnualMultaYSancionatoriaDTO historialProyeccionAnualMultaYSancionatoriaDTO(HistorialProyeccionAnualMultaYSancionatoria historialProyeccionAnualMultaYSancionatoria){
        HistorialProyeccionAnualMultaYSancionatoriaDTO historialProyeccionAnualMultaYSancionatoriaDTO = new HistorialProyeccionAnualMultaYSancionatoriaDTO();
        historialProyeccionAnualMultaYSancionatoriaDTO.setIdHistorialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoria.getIdHistorialProyeccionAnualMultaYSancionatoria());
        historialProyeccionAnualMultaYSancionatoriaDTO.setNumRegHistorialProyeccionAnualMultaYSancionatoria(historialProyeccionAnualMultaYSancionatoria.getNumRegHistorialProyeccionAnualMultaYSancionatoria().toUpperCase());
        historialProyeccionAnualMultaYSancionatoriaDTO.setNumeroAutoAmbientalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoria.getNumeroAutoAmbientalHistProyAnMultYSanc());
        historialProyeccionAnualMultaYSancionatoriaDTO.setDenominacionAutoAmbientalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoria.getDenominacionAutoAmbientalHistProyAnMultYSanc().toUpperCase());
        historialProyeccionAnualMultaYSancionatoriaDTO.setObservacionesAutoAmbientalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoria.getObservacionesAutoAmbientalHistProyAnMultYSanc());
        historialProyeccionAnualMultaYSancionatoriaDTO.setValorPresupuestalHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoria.getValorPresupuestalHistProyAnMultYSanc());
        historialProyeccionAnualMultaYSancionatoriaDTO.setNombreArchivoDocumentoAnexoHistProyAnMultYSanc(historialProyeccionAnualMultaYSancionatoria.getNombreArchivoDocumentoAnexoHistProyAnMultYSanc());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialProyeccionAnualMultaYSancionatoria.getUnidadMilitar() != null && historialProyeccionAnualMultaYSancionatoria.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialProyeccionAnualMultaYSancionatoria.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> historialProyeccionAnualMultaYSancionatoriaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        return historialProyeccionAnualMultaYSancionatoriaDTO;
    }
}
