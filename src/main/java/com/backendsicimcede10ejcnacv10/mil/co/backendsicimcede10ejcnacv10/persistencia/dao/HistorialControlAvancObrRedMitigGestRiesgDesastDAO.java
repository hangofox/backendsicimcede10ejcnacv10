//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialControlAvancObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialControlAvancObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoObrRedMitigGestRiesgDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialControlAvancObrRedMitigGestRiesgDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoObrRedMitigGestRiesgDesastRepository apoyoObrRedMitigGestRiesgDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoObrRedMitigGestRiesgDesastDAO apoyoObrRedMitigGestRiesgDesastDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param historialControlAvancObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto historialControlAvancObrRedMitigGestRiesgDesast.
    * @return historialControlAvancObrRedMitigGestRiesgDesast
    */
    public HistorialControlAvancObrRedMitigGestRiesgDesast historialControlAvancObrRedMitigGestRiesgDesast(HistorialControlAvancObrRedMitigGestRiesgDesastDTO historialControlAvancObrRedMitigGestRiesgDesastDTO){
        HistorialControlAvancObrRedMitigGestRiesgDesast historialControlAvancObrRedMitigGestRiesgDesast = new HistorialControlAvancObrRedMitigGestRiesgDesast();
        historialControlAvancObrRedMitigGestRiesgDesast.setIdHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getIdHistorialControlAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesast.setNumRegHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getNumRegHistorialControlAvancObrRedMitigGestRiesgDesast().toUpperCase());
        historialControlAvancObrRedMitigGestRiesgDesast.setNombreHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getNombreHistorialControlAvancObrRedMitigGestRiesgDesast().toUpperCase());
        historialControlAvancObrRedMitigGestRiesgDesast.setNumeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getNumeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesast.setNumeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getNumeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesast.setNumeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getNumeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesast.setObservacionesHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getObservacionesHistorialControlAvancObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO, OBRA, REDUCCION, MITIGACION Y GESTION DEL RIESGO DE DESASTRE RELACIONADO.
        if (historialControlAvancObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO() != null && historialControlAvancObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(historialControlAvancObrRedMitigGestRiesgDesast::setApoyoObrRedMitigGestRiesgDesast);
        }
        
        return historialControlAvancObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param historialControlAvancObrRedMitigGestRiesgDesast
    * Recibe un objeto historialControlAvancObrRedMitigGestRiesgDesast para crear un DTO.
    * @return historialControlAvancObrRedMitigGestRiesgDesastDTO
    */
    public HistorialControlAvancObrRedMitigGestRiesgDesastDTO historialControlAvancObrRedMitigGestRiesgDesastDTO(HistorialControlAvancObrRedMitigGestRiesgDesast historialControlAvancObrRedMitigGestRiesgDesast){
        HistorialControlAvancObrRedMitigGestRiesgDesastDTO historialControlAvancObrRedMitigGestRiesgDesastDTO = new HistorialControlAvancObrRedMitigGestRiesgDesastDTO();
        historialControlAvancObrRedMitigGestRiesgDesastDTO.setIdHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getIdHistorialControlAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesastDTO.setNumRegHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getNumRegHistorialControlAvancObrRedMitigGestRiesgDesast().toUpperCase());
        historialControlAvancObrRedMitigGestRiesgDesastDTO.setNombreHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getNombreHistorialControlAvancObrRedMitigGestRiesgDesast().toUpperCase());
        historialControlAvancObrRedMitigGestRiesgDesastDTO.setNumeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getNumeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesastDTO.setNumeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getNumeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesastDTO.setNumeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getNumeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast());
        historialControlAvancObrRedMitigGestRiesgDesastDTO.setObservacionesHistorialControlAvancObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getObservacionesHistorialControlAvancObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO, OBRA, REDUCCION, MITIGACION Y GESTION DEL RIESGO DE DESASTRE RELACIONADO.
        if (historialControlAvancObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast() != null && historialControlAvancObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialControlAvancObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(apoyoObr -> historialControlAvancObrRedMitigGestRiesgDesastDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObr)));
        }
        
        return historialControlAvancObrRedMitigGestRiesgDesastDTO;
    }
}
