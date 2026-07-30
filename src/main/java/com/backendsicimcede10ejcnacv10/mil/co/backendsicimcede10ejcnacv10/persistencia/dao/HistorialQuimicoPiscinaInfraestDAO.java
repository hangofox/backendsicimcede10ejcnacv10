//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialQuimicoPiscinaInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialQuimicoPiscinaInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Oficina;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialQuimicoPiscinaInfraestDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private OficinaRepository oficinaRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private OficinaDAO oficinaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialQuimicoPiscinaInfraestDTO
    * Recibe un DTO para crear un objeto historialQuimicoPiscinaInfraest.
    * @return historialQuimicoPiscinaInfraest
    */
    public HistorialQuimicoPiscinaInfraest historialQuimicoPiscinaInfraest(HistorialQuimicoPiscinaInfraestDTO historialQuimicoPiscinaInfraestDTO){
        HistorialQuimicoPiscinaInfraest historialQuimicoPiscinaInfraest = new HistorialQuimicoPiscinaInfraest();
        historialQuimicoPiscinaInfraest.setIdHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO.getIdHistorialQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraest.setNumRegHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO.getNumRegHistorialQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraest.setNombreHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO.getNombreHistorialQuimicoPiscinaInfraest().toUpperCase());
        historialQuimicoPiscinaInfraest.setCentroCostoOficinaQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO.getCentroCostoOficinaQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraest.setFechaHMSIngresoQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO.getFechaHMSIngresoQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraest.setFechaHMSModificacionQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO.getFechaHMSModificacionQuimicoPiscinaInfraest());
        
        //MAPEAR OFICINA RELACIONADA.
        if (historialQuimicoPiscinaInfraestDTO.getOficinaDTO() != null && historialQuimicoPiscinaInfraestDTO.getOficinaDTO().getIdOficina() != null) {
           Optional<Oficina> oficinaFk = oficinaRepository.findByIdOficina(historialQuimicoPiscinaInfraestDTO.getOficinaDTO().getIdOficina());
           oficinaFk.ifPresent(historialQuimicoPiscinaInfraest::setOficina);
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO() != null && historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(historialQuimicoPiscinaInfraest::setInfraestructura);
        }
        
        return historialQuimicoPiscinaInfraest;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialQuimicoPiscinaInfraest
    * Recibe un objeto historialQuimicoPiscinaInfraest para crear un DTO.
    * @return historialQuimicoPiscinaInfraestDTO
    */
    public HistorialQuimicoPiscinaInfraestDTO historialQuimicoPiscinaInfraestDTO(HistorialQuimicoPiscinaInfraest historialQuimicoPiscinaInfraest){
        HistorialQuimicoPiscinaInfraestDTO historialQuimicoPiscinaInfraestDTO = new HistorialQuimicoPiscinaInfraestDTO();
        historialQuimicoPiscinaInfraestDTO.setIdHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraest.getIdHistorialQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraestDTO.setNumRegHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraest.getNumRegHistorialQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraestDTO.setNombreHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraest.getNombreHistorialQuimicoPiscinaInfraest().toUpperCase());
        historialQuimicoPiscinaInfraestDTO.setCentroCostoOficinaQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraest.getCentroCostoOficinaQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraestDTO.setFechaHMSIngresoQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraest.getFechaHMSIngresoQuimicoPiscinaInfraest());
        historialQuimicoPiscinaInfraestDTO.setFechaHMSModificacionQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraest.getFechaHMSModificacionQuimicoPiscinaInfraest());
        
        //MAPEAR OFICINA RELACIONADA.
        if (historialQuimicoPiscinaInfraest.getOficina() != null && historialQuimicoPiscinaInfraest.getOficina().getIdOficina() != null) {
           Optional<Oficina> oficinaFk = oficinaRepository.findByIdOficina(historialQuimicoPiscinaInfraest.getOficina().getIdOficina());
           oficinaFk.ifPresent(oficina -> historialQuimicoPiscinaInfraestDTO.setOficinaDTO(oficinaDAO.oficinaDTO(oficina)));
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialQuimicoPiscinaInfraest.getInfraestructura() != null && historialQuimicoPiscinaInfraest.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialQuimicoPiscinaInfraest.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infraestructura -> historialQuimicoPiscinaInfraestDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infraestructura)));
        }
        
        return historialQuimicoPiscinaInfraestDTO;
    }
}
