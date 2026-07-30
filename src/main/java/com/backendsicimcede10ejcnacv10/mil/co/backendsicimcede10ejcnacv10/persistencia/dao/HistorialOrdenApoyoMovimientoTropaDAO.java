//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialOrdenApoyoMovimientoTropaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialOrdenApoyoMovimientoTropa;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoAtencPrevEmergDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialOrdenApoyoMovimientoTropaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoAtencPrevEmergDesastRepository apoyoAtencPrevEmergDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoAtencPrevEmergDesastDAO apoyoAtencPrevEmergDesastDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param historialOrdenApoyoMovimientoTropaDTO
    * Recibe un DTO para crear un objeto historialOrdenApoyoMovimientoTropa.
    * @return historialOrdenApoyoMovimientoTropa
    */
    public HistorialOrdenApoyoMovimientoTropa historialOrdenApoyoMovimientoTropa(HistorialOrdenApoyoMovimientoTropaDTO historialOrdenApoyoMovimientoTropaDTO){
        HistorialOrdenApoyoMovimientoTropa historialOrdenApoyoMovimientoTropa = new HistorialOrdenApoyoMovimientoTropa();
        historialOrdenApoyoMovimientoTropa.setIdHistorialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO.getIdHistorialOrdenApoyoMovimientoTropa());
        historialOrdenApoyoMovimientoTropa.setNumRegHistorialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO.getNumRegHistorialOrdenApoyoMovimientoTropa().toUpperCase());
        historialOrdenApoyoMovimientoTropa.setNumeroOficioHrOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO.getNumeroOficioHrOrdenApoyoMovimientoTropa().toUpperCase());
        historialOrdenApoyoMovimientoTropa.setAsuntoOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropaDTO.getAsuntoOrdenApoyoMovimientoTropa());
        
        //MAPEAR APOYO, ATENCION, PREVENCION, EMERGENCIA Y DESASTRE RELACIONADO.
        if (historialOrdenApoyoMovimientoTropaDTO.getApoyoAtencPrevEmergDesastDTO() != null && historialOrdenApoyoMovimientoTropaDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialOrdenApoyoMovimientoTropaDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(historialOrdenApoyoMovimientoTropa::setApoyoAtencPrevEmergDesast);
        }
        
        return historialOrdenApoyoMovimientoTropa;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param historialOrdenApoyoMovimientoTropa
    * Recibe un objeto historialOrdenApoyoMovimientoTropa para crear un DTO.
    * @return historialOrdenApoyoMovimientoTropaDTO
    */
    public HistorialOrdenApoyoMovimientoTropaDTO historialOrdenApoyoMovimientoTropaDTO(HistorialOrdenApoyoMovimientoTropa historialOrdenApoyoMovimientoTropa){
        HistorialOrdenApoyoMovimientoTropaDTO historialOrdenApoyoMovimientoTropaDTO = new HistorialOrdenApoyoMovimientoTropaDTO();
        historialOrdenApoyoMovimientoTropaDTO.setIdHistorialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropa.getIdHistorialOrdenApoyoMovimientoTropa());
        historialOrdenApoyoMovimientoTropaDTO.setNumRegHistorialOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropa.getNumRegHistorialOrdenApoyoMovimientoTropa().toUpperCase());
        historialOrdenApoyoMovimientoTropaDTO.setNumeroOficioHrOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropa.getNumeroOficioHrOrdenApoyoMovimientoTropa().toUpperCase());
        historialOrdenApoyoMovimientoTropaDTO.setAsuntoOrdenApoyoMovimientoTropa(historialOrdenApoyoMovimientoTropa.getAsuntoOrdenApoyoMovimientoTropa());
        
        //MAPEAR APOYO, ATENCION, PREVENCION, EMERGENCIA Y DESASTRE RELACIONADO.
        if (historialOrdenApoyoMovimientoTropa.getApoyoAtencPrevEmergDesast() != null && historialOrdenApoyoMovimientoTropa.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialOrdenApoyoMovimientoTropa.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(apoyoAten -> historialOrdenApoyoMovimientoTropaDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAten)));
        }
        
        return historialOrdenApoyoMovimientoTropaDTO;
    }
}
