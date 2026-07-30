//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ElementoSubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoObrRedMitigGestRiesgDesastRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SubclasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ElementoSubclasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoObrRedMitigGestRiesgDesastRepository apoyoObrRedMitigGestRiesgDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoObrRedMitigGestRiesgDesastDAO apoyoObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ClasificacionEquipoIngenieroRepository clasificacionEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ClasificacionEquipoIngenieroDAO clasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SubclasificacionEquipoIngenieroRepository subclasificacionEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SubclasificacionEquipoIngenieroDAO subclasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ElementoSubclasificacionEquipoIngenieroRepository elementoSubclasificacionEquipoIngenieroRepository;
    
    @Lazy//ROMPE LA REFERENCIA CIRCULAR CON elementoSubclasificacionEquipoIngenieroDAO.
    @Autowired//INYECTAMOS EL DAO.
    private ElementoSubclasificacionEquipoIngenieroDAO elementoSubclasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto historialEquipTranspApoyObrRedMitigGestRiesgDesast.
    * @return historialEquipTranspApoyObrRedMitigGestRiesgDesast
    */
    public HistorialEquipTranspApoyObrRedMitigGestRiesgDesast historialEquipTranspApoyObrRedMitigGestRiesgDesast(HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO){
        HistorialEquipTranspApoyObrRedMitigGestRiesgDesast historialEquipTranspApoyObrRedMitigGestRiesgDesast = new HistorialEquipTranspApoyObrRedMitigGestRiesgDesast();
        historialEquipTranspApoyObrRedMitigGestRiesgDesast.setIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast());
        historialEquipTranspApoyObrRedMitigGestRiesgDesast.setNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast().toUpperCase());
        historialEquipTranspApoyObrRedMitigGestRiesgDesast.setNumeroPlacaEquipoTransporte(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getNumeroPlacaEquipoTransporte().toUpperCase());
        historialEquipTranspApoyObrRedMitigGestRiesgDesast.setTotalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getTotalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO, OBRA, REDUCCIÓN, MITIGACIÓN Y GESTIÓN DEL RIESGO DE DESASTRE RELACIONADO.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(historialEquipTranspApoyObrRedMitigGestRiesgDesast::setApoyoObrRedMitigGestRiesgDesast);
        }
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getClasificacionEquipoIngenieroDTO() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(historialEquipTranspApoyObrRedMitigGestRiesgDesast::setClasificacionEquipoIngeniero);
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getSubclasificacionEquipoIngenieroDTO() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(historialEquipTranspApoyObrRedMitigGestRiesgDesast::setSubclasificacionEquipoIngeniero);
        }
        
        //MAPEAR ELEMENTO SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getElementoSubclasificacionEquipoIngenieroDTO() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getElementoSubclasificacionEquipoIngenieroDTO().getIdElementoSubclasificacionEquipoIngeniero() != null) {
           Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroFk = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getElementoSubclasificacionEquipoIngenieroDTO().getIdElementoSubclasificacionEquipoIngeniero());
           elementoSubclasificacionEquipoIngenieroFk.ifPresent(historialEquipTranspApoyObrRedMitigGestRiesgDesast::setElementoSubclasificacionEquipoIngeniero);
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getEquipoIngenieroDTO() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(historialEquipTranspApoyObrRedMitigGestRiesgDesast::setEquipoIngeniero);
        }
        
        return historialEquipTranspApoyObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialEquipTranspApoyObrRedMitigGestRiesgDesast
    * Recibe un objeto historialEquipTranspApoyObrRedMitigGestRiesgDesast para crear un DTO.
    * @return historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO
    */
    public HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO(HistorialEquipTranspApoyObrRedMitigGestRiesgDesast historialEquipTranspApoyObrRedMitigGestRiesgDesast){
        HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO = new HistorialEquipTranspApoyObrRedMitigGestRiesgDesastDTO();
        historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast());
        historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast().toUpperCase());
        historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setNumeroPlacaEquipoTransporte(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getNumeroPlacaEquipoTransporte().toUpperCase());
        historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setTotalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getTotalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO, OBRA, REDUCCIÓN, MITIGACIÓN Y GESTIÓN DEL RIESGO DE DESASTRE RELACIONADO.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(apoyObrRed -> historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyObrRed)));
        }
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesast.getClasificacionEquipoIngeniero() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesast.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(clasifEqIng -> historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasifEqIng)));
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesast.getSubclasificacionEquipoIngeniero() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesast.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(subclasifEqIng -> historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setSubclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasifEqIng)));
        }
        
        //MAPEAR ELEMENTO SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesast.getElementoSubclasificacionEquipoIngeniero() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesast.getElementoSubclasificacionEquipoIngeniero().getIdElementoSubclasificacionEquipoIngeniero() != null) {
           Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroFk = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getElementoSubclasificacionEquipoIngeniero().getIdElementoSubclasificacionEquipoIngeniero());
           elementoSubclasificacionEquipoIngenieroFk.ifPresent(elemSubclasifEqIng -> historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setElementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elemSubclasifEqIng)));
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyObrRedMitigGestRiesgDesast.getEquipoIngeniero() != null && historialEquipTranspApoyObrRedMitigGestRiesgDesast.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialEquipTranspApoyObrRedMitigGestRiesgDesast.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(eqIng -> historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(eqIng)));
        }
        
        return historialEquipTranspApoyObrRedMitigGestRiesgDesastDTO;
    }
}
