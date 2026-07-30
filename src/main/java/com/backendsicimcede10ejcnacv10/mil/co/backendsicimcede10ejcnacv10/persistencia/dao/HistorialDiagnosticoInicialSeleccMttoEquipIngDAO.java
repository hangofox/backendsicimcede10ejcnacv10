//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialDiagnosticoInicialSeleccMttoEquipIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoDiagnosticoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialDiagnosticoInicialSeleccMttoEquipIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EstadoDiagnosticoEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialDiagnosticoInicialSeleccMttoEquipIngDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EstadoDiagnosticoEquipoIngenieroRepository estadoDiagnosticoEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EstadoDiagnosticoEquipoIngenieroDAO estadoDiagnosticoEquipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialDiagnosticoInicialSeleccMttoEquipIngDTO
    * Recibe un DTO para crear un objeto historialDiagnosticoInicialSeleccMttoEquipIng.
    * @return historialDiagnosticoInicialSeleccMttoEquipIng
    */
    public HistorialDiagnosticoInicialSeleccMttoEquipIng historialDiagnosticoInicialSeleccMttoEquipIng(HistorialDiagnosticoInicialSeleccMttoEquipIngDTO historialDiagnosticoInicialSeleccMttoEquipIngDTO){
        HistorialDiagnosticoInicialSeleccMttoEquipIng historialDiagnosticoInicialSeleccMttoEquipIng = new HistorialDiagnosticoInicialSeleccMttoEquipIng();
        historialDiagnosticoInicialSeleccMttoEquipIng.setIdHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getIdHistorialDiagnosticoInicialSeleccMttoEquipIng());
        historialDiagnosticoInicialSeleccMttoEquipIng.setNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng().toUpperCase());
        historialDiagnosticoInicialSeleccMttoEquipIng.setNombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getNombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng());
        historialDiagnosticoInicialSeleccMttoEquipIng.setDescripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getDescripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialDiagnosticoInicialSeleccMttoEquipIngDTO.getUnidadMilitarDTO() != null && historialDiagnosticoInicialSeleccMttoEquipIngDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(historialDiagnosticoInicialSeleccMttoEquipIng::setUnidadMilitar);
        }
        
        //MAPEAR UNIDAD MILITAR REALIZADORA DE MANTENIMIENTO RELACIONADA.
        if (historialDiagnosticoInicialSeleccMttoEquipIngDTO.getUnidadMilitarRealizadoraMantenimientoDTO() != null && historialDiagnosticoInicialSeleccMttoEquipIngDTO.getUnidadMilitarRealizadoraMantenimientoDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarRealizadoraFk = unidadMilitarRepository.findByIdUnidadMilitar(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getUnidadMilitarRealizadoraMantenimientoDTO().getIdUnidadMilitar());
           unidadMilitarRealizadoraFk.ifPresent(historialDiagnosticoInicialSeleccMttoEquipIng::setUnidadMilitarRealizadoraMantenimiento);
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialDiagnosticoInicialSeleccMttoEquipIngDTO.getEquipoIngenieroDTO() != null && historialDiagnosticoInicialSeleccMttoEquipIngDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(historialDiagnosticoInicialSeleccMttoEquipIng::setEquipoIngeniero);
        }
        
        //MAPEAR ESTADO DE DIAGNOSTICO DE EQUIPO DE INGENIERO RELACIONADO.
        if (historialDiagnosticoInicialSeleccMttoEquipIngDTO.getEstadoDiagnosticoEquipoIngenieroDTO() != null && historialDiagnosticoInicialSeleccMttoEquipIngDTO.getEstadoDiagnosticoEquipoIngenieroDTO().getIdEstadoDiagnosticoEquipoIngeniero() != null) {
           Optional<EstadoDiagnosticoEquipoIngeniero> estadoDiagnosticoEquipoIngenieroFk = estadoDiagnosticoEquipoIngenieroRepository.findByIdEstadoDiagnosticoEquipoIngeniero(historialDiagnosticoInicialSeleccMttoEquipIngDTO.getEstadoDiagnosticoEquipoIngenieroDTO().getIdEstadoDiagnosticoEquipoIngeniero());
           estadoDiagnosticoEquipoIngenieroFk.ifPresent(historialDiagnosticoInicialSeleccMttoEquipIng::setEstadoDiagnosticoEquipoIngeniero);
        }
        
        return historialDiagnosticoInicialSeleccMttoEquipIng;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialDiagnosticoInicialSeleccMttoEquipIng
    * Recibe un objeto historialDiagnosticoInicialSeleccMttoEquipIng para crear un DTO.
    * @return historialDiagnosticoInicialSeleccMttoEquipIngDTO
    */
    public HistorialDiagnosticoInicialSeleccMttoEquipIngDTO historialDiagnosticoInicialSeleccMttoEquipIngDTO(HistorialDiagnosticoInicialSeleccMttoEquipIng historialDiagnosticoInicialSeleccMttoEquipIng){
        HistorialDiagnosticoInicialSeleccMttoEquipIngDTO historialDiagnosticoInicialSeleccMttoEquipIngDTO = new HistorialDiagnosticoInicialSeleccMttoEquipIngDTO();
        historialDiagnosticoInicialSeleccMttoEquipIngDTO.setIdHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIng.getIdHistorialDiagnosticoInicialSeleccMttoEquipIng());
        historialDiagnosticoInicialSeleccMttoEquipIngDTO.setNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIng.getNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng().toUpperCase());
        historialDiagnosticoInicialSeleccMttoEquipIngDTO.setNombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIng.getNombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng());
        historialDiagnosticoInicialSeleccMttoEquipIngDTO.setDescripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng(historialDiagnosticoInicialSeleccMttoEquipIng.getDescripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialDiagnosticoInicialSeleccMttoEquipIng.getUnidadMilitar() != null && historialDiagnosticoInicialSeleccMttoEquipIng.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialDiagnosticoInicialSeleccMttoEquipIng.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> historialDiagnosticoInicialSeleccMttoEquipIngDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        //MAPEAR UNIDAD MILITAR REALIZADORA MANTENIMIENTO RELACIONADA.
        if (historialDiagnosticoInicialSeleccMttoEquipIng.getUnidadMilitarRealizadoraMantenimiento() != null && historialDiagnosticoInicialSeleccMttoEquipIng.getUnidadMilitarRealizadoraMantenimiento().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarRealizadoraFk = unidadMilitarRepository.findByIdUnidadMilitar(historialDiagnosticoInicialSeleccMttoEquipIng.getUnidadMilitarRealizadoraMantenimiento().getIdUnidadMilitar());
           unidadMilitarRealizadoraFk.ifPresent(unidMilReal -> historialDiagnosticoInicialSeleccMttoEquipIngDTO.setUnidadMilitarRealizadoraMantenimientoDTO(unidadMilitarDAO.unidadMilitarDTO(unidMilReal)));
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialDiagnosticoInicialSeleccMttoEquipIng.getEquipoIngeniero() != null && historialDiagnosticoInicialSeleccMttoEquipIng.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialDiagnosticoInicialSeleccMttoEquipIng.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(equipIng -> historialDiagnosticoInicialSeleccMttoEquipIngDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipIng)));
        }
        
        //MAPEAR ESTADO DE DIAGNOSTICO DE EQUIPO DE INGENIERO RELACIONADO.
        if (historialDiagnosticoInicialSeleccMttoEquipIng.getEstadoDiagnosticoEquipoIngeniero() != null && historialDiagnosticoInicialSeleccMttoEquipIng.getEstadoDiagnosticoEquipoIngeniero().getIdEstadoDiagnosticoEquipoIngeniero() != null) {
           Optional<EstadoDiagnosticoEquipoIngeniero> estadoDiagnosticoEquipoIngenieroFk = estadoDiagnosticoEquipoIngenieroRepository.findByIdEstadoDiagnosticoEquipoIngeniero(historialDiagnosticoInicialSeleccMttoEquipIng.getEstadoDiagnosticoEquipoIngeniero().getIdEstadoDiagnosticoEquipoIngeniero());
           estadoDiagnosticoEquipoIngenieroFk.ifPresent(estDiag -> historialDiagnosticoInicialSeleccMttoEquipIngDTO.setEstadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngenieroDTO(estDiag)));
        }
        
        return historialDiagnosticoInicialSeleccMttoEquipIngDTO;
    }
}
