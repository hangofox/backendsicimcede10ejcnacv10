//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.NivelMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoFuenteFinanciacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.NivelMantenimientoEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoFuenteFinanciacionRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoMantenimientoEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialMantenimientoEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private NivelMantenimientoEquipoIngenieroRepository nivelMantenimientoEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private NivelMantenimientoEquipoIngenieroDAO nivelMantenimientoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoMantenimientoEquipoIngenieroRepository tipoMantenimientoEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoMantenimientoEquipoIngenieroDAO tipoMantenimientoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoFuenteFinanciacionRepository tipoFuenteFinanciacionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoFuenteFinanciacionDAO tipoFuenteFinanciacionDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMantenimientoEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto historialMantenimientoEquipoIngeniero.
    * @return historialMantenimientoEquipoIngeniero
    */
    public HistorialMantenimientoEquipoIngeniero historialMantenimientoEquipoIngeniero(HistorialMantenimientoEquipoIngenieroDTO historialMantenimientoEquipoIngenieroDTO){
        HistorialMantenimientoEquipoIngeniero historialMantenimientoEquipoIngeniero = new HistorialMantenimientoEquipoIngeniero();
        historialMantenimientoEquipoIngeniero.setIdHistorialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getIdHistorialMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngeniero.setNumRegHistorialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getNumRegHistorialMantenimientoEquipoIngeniero().toUpperCase());
        historialMantenimientoEquipoIngeniero.setAsuntoMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getAsuntoMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngeniero.setDescripcionMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getDescripcionMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngeniero.setFechaHMSMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getFechaHMSMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngeniero.setValorCostoMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getValorCostoMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngeniero.setNombreDocumentoAnexoContratoMttoEquipIng(historialMantenimientoEquipoIngenieroDTO.getNombreDocumentoAnexoContratoMttoEquipIng());
        historialMantenimientoEquipoIngeniero.setNombreArchivoDocumentoAnexoContratoMttoEquipIng(historialMantenimientoEquipoIngenieroDTO.getNombreArchivoDocumentoAnexoContratoMttoEquipIng());
        
        //MAPEAR EQUIPO INGENIERO RELACIONADO.
        if (historialMantenimientoEquipoIngenieroDTO.getEquipoIngenieroDTO() != null && historialMantenimientoEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(historialMantenimientoEquipoIngeniero::setEquipoIngeniero);
        }
        
        //MAPEAR NIVEL DE MANTENIMIENTO DE EQUIPO INGENIERO RELACIONADO.
        if (historialMantenimientoEquipoIngenieroDTO.getNivelMantenimientoEquipoIngenieroDTO() != null && historialMantenimientoEquipoIngenieroDTO.getNivelMantenimientoEquipoIngenieroDTO().getIdNivelMantenimientoEquipoIngeniero() != null) {
           Optional<NivelMantenimientoEquipoIngeniero> nivelMantenimientoEquipoIngenieroFk = nivelMantenimientoEquipoIngenieroRepository.findByIdNivelMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getNivelMantenimientoEquipoIngenieroDTO().getIdNivelMantenimientoEquipoIngeniero());
           nivelMantenimientoEquipoIngenieroFk.ifPresent(historialMantenimientoEquipoIngeniero::setNivelMantenimientoEquipoIngeniero);
        }
        
        //MAPEAR TIPO DE MANTENIMIENTO DE EQUIPO INGENIERO RELACIONADO.
        if (historialMantenimientoEquipoIngenieroDTO.getTipoMantenimientoEquipoIngenieroDTO() != null && historialMantenimientoEquipoIngenieroDTO.getTipoMantenimientoEquipoIngenieroDTO().getIdTipoMantenimientoEquipoIngeniero() != null) {
           Optional<TipoMantenimientoEquipoIngeniero> tipoMantenimientoEquipoIngenieroFk = tipoMantenimientoEquipoIngenieroRepository.findByIdTipoMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngenieroDTO.getTipoMantenimientoEquipoIngenieroDTO().getIdTipoMantenimientoEquipoIngeniero());
           tipoMantenimientoEquipoIngenieroFk.ifPresent(historialMantenimientoEquipoIngeniero::setTipoMantenimientoEquipoIngeniero);
        }
        
        //MAPEAR TIPO DE FUENTE DE FINANCIACIÓN RELACIONADA.
        if (historialMantenimientoEquipoIngenieroDTO.getTipoFuenteFinanciacionDTO() != null && historialMantenimientoEquipoIngenieroDTO.getTipoFuenteFinanciacionDTO().getIdTipoFuenteFinanciacion() != null) {
           Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionFk = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(historialMantenimientoEquipoIngenieroDTO.getTipoFuenteFinanciacionDTO().getIdTipoFuenteFinanciacion());
           tipoFuenteFinanciacionFk.ifPresent(historialMantenimientoEquipoIngeniero::setTipoFuenteFinanciacion);
        }
        
        return historialMantenimientoEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMantenimientoEquipoIngeniero
    * Recibe un objeto historialMantenimientoEquipoIngeniero para crear un DTO.
    * @return historialMantenimientoEquipoIngenieroDTO
    */
    public HistorialMantenimientoEquipoIngenieroDTO historialMantenimientoEquipoIngenieroDTO(HistorialMantenimientoEquipoIngeniero historialMantenimientoEquipoIngeniero){
        HistorialMantenimientoEquipoIngenieroDTO historialMantenimientoEquipoIngenieroDTO = new HistorialMantenimientoEquipoIngenieroDTO();
        historialMantenimientoEquipoIngenieroDTO.setIdHistorialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getIdHistorialMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngenieroDTO.setNumRegHistorialMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getNumRegHistorialMantenimientoEquipoIngeniero().toUpperCase());
        historialMantenimientoEquipoIngenieroDTO.setAsuntoMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getAsuntoMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngenieroDTO.setDescripcionMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getDescripcionMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngenieroDTO.setFechaHMSMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getFechaHMSMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngenieroDTO.setValorCostoMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getValorCostoMantenimientoEquipoIngeniero());
        historialMantenimientoEquipoIngenieroDTO.setNombreDocumentoAnexoContratoMttoEquipIng(historialMantenimientoEquipoIngeniero.getNombreDocumentoAnexoContratoMttoEquipIng());
        historialMantenimientoEquipoIngenieroDTO.setNombreArchivoDocumentoAnexoContratoMttoEquipIng(historialMantenimientoEquipoIngeniero.getNombreArchivoDocumentoAnexoContratoMttoEquipIng());
        
        //MAPEAR EQUIPO INGENIERO RELACIONADO.
        if (historialMantenimientoEquipoIngeniero.getEquipoIngeniero() != null && historialMantenimientoEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialMantenimientoEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(equipoIng -> historialMantenimientoEquipoIngenieroDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipoIng)));
        }
        
        //MAPEAR NIVEL DE MANTENIMIENTO DE EQUIPO INGENIERO RELACIONADO.
        if (historialMantenimientoEquipoIngeniero.getNivelMantenimientoEquipoIngeniero() != null && historialMantenimientoEquipoIngeniero.getNivelMantenimientoEquipoIngeniero().getIdNivelMantenimientoEquipoIngeniero() != null) {
           Optional<NivelMantenimientoEquipoIngeniero> nivelMantenimientoEquipoIngenieroFk = nivelMantenimientoEquipoIngenieroRepository.findByIdNivelMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getNivelMantenimientoEquipoIngeniero().getIdNivelMantenimientoEquipoIngeniero());
           nivelMantenimientoEquipoIngenieroFk.ifPresent(nivelMttoEquipIng -> historialMantenimientoEquipoIngenieroDTO.setNivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngenieroDTO(nivelMttoEquipIng)));
        }
        
        //MAPEAR TIPO DE MANTENIMIENTO DE EQUIPO INGENIERO RELACIONADO.
        if (historialMantenimientoEquipoIngeniero.getTipoMantenimientoEquipoIngeniero() != null && historialMantenimientoEquipoIngeniero.getTipoMantenimientoEquipoIngeniero().getIdTipoMantenimientoEquipoIngeniero() != null) {
           Optional<TipoMantenimientoEquipoIngeniero> tipoMantenimientoEquipoIngenieroFk = tipoMantenimientoEquipoIngenieroRepository.findByIdTipoMantenimientoEquipoIngeniero(historialMantenimientoEquipoIngeniero.getTipoMantenimientoEquipoIngeniero().getIdTipoMantenimientoEquipoIngeniero());
           tipoMantenimientoEquipoIngenieroFk.ifPresent(tipoMttoEquipIng -> historialMantenimientoEquipoIngenieroDTO.setTipoMantenimientoEquipoIngenieroDTO(tipoMantenimientoEquipoIngenieroDAO.tipoMantenimientoEquipoIngenieroDTO(tipoMttoEquipIng)));
        }
        
        //MAPEAR TIPO DE FUENTE DE FINANCIACIÓN RELACIONADA.
        if (historialMantenimientoEquipoIngeniero.getTipoFuenteFinanciacion() != null && historialMantenimientoEquipoIngeniero.getTipoFuenteFinanciacion().getIdTipoFuenteFinanciacion() != null) {
           Optional<TipoFuenteFinanciacion> tipoFuenteFinanciacionFk = tipoFuenteFinanciacionRepository.findByIdTipoFuenteFinanciacion(historialMantenimientoEquipoIngeniero.getTipoFuenteFinanciacion().getIdTipoFuenteFinanciacion());
           tipoFuenteFinanciacionFk.ifPresent(tipoFuenteFin -> historialMantenimientoEquipoIngenieroDTO.setTipoFuenteFinanciacionDTO(tipoFuenteFinanciacionDAO.tipoFuenteFinanciacionDTO(tipoFuenteFin)));
        }
        
        return historialMantenimientoEquipoIngenieroDTO;
    }
}
