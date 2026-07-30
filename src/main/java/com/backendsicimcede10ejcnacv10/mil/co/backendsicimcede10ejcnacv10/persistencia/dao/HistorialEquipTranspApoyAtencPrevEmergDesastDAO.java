//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialEquipTranspApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ElementoSubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialEquipTranspApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoAtencPrevEmergDesastRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SubclasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ElementoSubclasificacionEquipoIngenieroRepository;import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
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
public class HistorialEquipTranspApoyAtencPrevEmergDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoAtencPrevEmergDesastRepository apoyoAtencPrevEmergDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoAtencPrevEmergDesastDAO apoyoAtencPrevEmergDesastDAO;
    
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
    * @param historialEquipTranspApoyAtencPrevEmergDesastDTO
    * Recibe un DTO para crear un objeto historialEquipTranspApoyAtencPrevEmergDesast.
    * @return historialEquipTranspApoyAtencPrevEmergDesast
    */
    public HistorialEquipTranspApoyAtencPrevEmergDesast historialEquipTranspApoyAtencPrevEmergDesast(HistorialEquipTranspApoyAtencPrevEmergDesastDTO historialEquipTranspApoyAtencPrevEmergDesastDTO){
        HistorialEquipTranspApoyAtencPrevEmergDesast historialEquipTranspApoyAtencPrevEmergDesast = new HistorialEquipTranspApoyAtencPrevEmergDesast();
        historialEquipTranspApoyAtencPrevEmergDesast.setIdHistorialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO.getIdHistorialEquipTranspApoyAtencPrevEmergDesast());
        historialEquipTranspApoyAtencPrevEmergDesast.setNumRegHistorialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO.getNumRegHistorialEquipTranspApoyAtencPrevEmergDesast().toUpperCase());
        historialEquipTranspApoyAtencPrevEmergDesast.setNumeroPlacaEquipoTransporte(historialEquipTranspApoyAtencPrevEmergDesastDTO.getNumeroPlacaEquipoTransporte().toUpperCase());
        historialEquipTranspApoyAtencPrevEmergDesast.setDiasEmpleadosEquipoTransporte(historialEquipTranspApoyAtencPrevEmergDesastDTO.getDiasEmpleadosEquipoTransporte());
        
        //MAPEAR APOYO, ATENCIÓN, PREVENCIÓN Y EMERGENICA DE DESASTRE RELACIONADO.
        if (historialEquipTranspApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO() != null && historialEquipTranspApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(historialEquipTranspApoyAtencPrevEmergDesast::setApoyoAtencPrevEmergDesast);
        }
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyAtencPrevEmergDesastDTO.getClasificacionEquipoIngenieroDTO() != null && historialEquipTranspApoyAtencPrevEmergDesastDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesastDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(historialEquipTranspApoyAtencPrevEmergDesast::setClasificacionEquipoIngeniero);
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyAtencPrevEmergDesastDTO.getSubclasificacionEquipoIngenieroDTO() != null && historialEquipTranspApoyAtencPrevEmergDesastDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesastDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(historialEquipTranspApoyAtencPrevEmergDesast::setSubclasificacionEquipoIngeniero);
        }
        
        //MAPEAR ELEMENTO SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyAtencPrevEmergDesastDTO.getElementoSubclasificacionEquipoIngenieroDTO() != null && historialEquipTranspApoyAtencPrevEmergDesastDTO.getElementoSubclasificacionEquipoIngenieroDTO().getIdElementoSubclasificacionEquipoIngeniero() != null) {
           Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroFk = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesastDTO.getElementoSubclasificacionEquipoIngenieroDTO().getIdElementoSubclasificacionEquipoIngeniero());
           elementoSubclasificacionEquipoIngenieroFk.ifPresent(historialEquipTranspApoyAtencPrevEmergDesast::setElementoSubclasificacionEquipoIngeniero);
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyAtencPrevEmergDesastDTO.getEquipoIngenieroDTO() != null && historialEquipTranspApoyAtencPrevEmergDesastDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesastDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(historialEquipTranspApoyAtencPrevEmergDesast::setEquipoIngeniero);
        }
        
        return historialEquipTranspApoyAtencPrevEmergDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialEquipTranspApoyAtencPrevEmergDesast
    * Recibe un objeto historialEquipTranspApoyAtencPrevEmergDesast para crear un DTO.
    * @return historialEquipTranspApoyAtencPrevEmergDesastDTO
    */
    public HistorialEquipTranspApoyAtencPrevEmergDesastDTO historialEquipTranspApoyAtencPrevEmergDesastDTO(HistorialEquipTranspApoyAtencPrevEmergDesast historialEquipTranspApoyAtencPrevEmergDesast){
        HistorialEquipTranspApoyAtencPrevEmergDesastDTO historialEquipTranspApoyAtencPrevEmergDesastDTO = new HistorialEquipTranspApoyAtencPrevEmergDesastDTO();
        historialEquipTranspApoyAtencPrevEmergDesastDTO.setIdHistorialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesast.getIdHistorialEquipTranspApoyAtencPrevEmergDesast());
        historialEquipTranspApoyAtencPrevEmergDesastDTO.setNumRegHistorialEquipTranspApoyAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesast.getNumRegHistorialEquipTranspApoyAtencPrevEmergDesast().toUpperCase());
        historialEquipTranspApoyAtencPrevEmergDesastDTO.setNumeroPlacaEquipoTransporte(historialEquipTranspApoyAtencPrevEmergDesast.getNumeroPlacaEquipoTransporte().toUpperCase());
        historialEquipTranspApoyAtencPrevEmergDesastDTO.setDiasEmpleadosEquipoTransporte(historialEquipTranspApoyAtencPrevEmergDesast.getDiasEmpleadosEquipoTransporte());
        
        //MAPEAR APOYO ATENCIÓN, PREVENCIÓN, EMERG DESAST RELACIONADO.
        if (historialEquipTranspApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast() != null && historialEquipTranspApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialEquipTranspApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(apoyAtenc -> historialEquipTranspApoyAtencPrevEmergDesastDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyAtenc)));
        }
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyAtencPrevEmergDesast.getClasificacionEquipoIngeniero() != null && historialEquipTranspApoyAtencPrevEmergDesast.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesast.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(clasifEqIng -> historialEquipTranspApoyAtencPrevEmergDesastDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasifEqIng)));
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (historialEquipTranspApoyAtencPrevEmergDesast.getSubclasificacionEquipoIngeniero() != null && historialEquipTranspApoyAtencPrevEmergDesast.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesast.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(subclasifEqIng -> historialEquipTranspApoyAtencPrevEmergDesastDTO.setSubclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasifEqIng)));
        }
        
        //MAPEAR ELEMENTO SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyAtencPrevEmergDesast.getElementoSubclasificacionEquipoIngeniero() != null && historialEquipTranspApoyAtencPrevEmergDesast.getElementoSubclasificacionEquipoIngeniero().getIdElementoSubclasificacionEquipoIngeniero() != null) {
           Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroFk = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesast.getElementoSubclasificacionEquipoIngeniero().getIdElementoSubclasificacionEquipoIngeniero());
           elementoSubclasificacionEquipoIngenieroFk.ifPresent(elemSubclasifEqIng -> historialEquipTranspApoyAtencPrevEmergDesastDTO.setElementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elemSubclasifEqIng)));
        }
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialEquipTranspApoyAtencPrevEmergDesast.getEquipoIngeniero() != null && historialEquipTranspApoyAtencPrevEmergDesast.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialEquipTranspApoyAtencPrevEmergDesast.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(eqIng -> historialEquipTranspApoyAtencPrevEmergDesastDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(eqIng)));
        }
        
        return historialEquipTranspApoyAtencPrevEmergDesastDTO;
    }
}
