//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAseoLimpInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAseoLimpInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialProyeccionAnualAseoLimpInfraestDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 13/04/2026.
    * @param historialProyeccionAnualAseoLimpInfraestDTO
    * Recibe un DTO para crear un objeto historialProyeccionAnualAseoLimpInfraest.
    * @return historialProyeccionAnualAseoLimpInfraest
    */
    public HistorialProyeccionAnualAseoLimpInfraest historialProyeccionAnualAseoLimpInfraest(HistorialProyeccionAnualAseoLimpInfraestDTO historialProyeccionAnualAseoLimpInfraestDTO){
        HistorialProyeccionAnualAseoLimpInfraest historialProyeccionAnualAseoLimpInfraest = new HistorialProyeccionAnualAseoLimpInfraest();
        historialProyeccionAnualAseoLimpInfraest.setIdHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getIdHistorialProyeccionAnualAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraest.setNumRegHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getNumRegHistorialProyeccionAnualAseoLimpInfraest().toUpperCase());
        historialProyeccionAnualAseoLimpInfraest.setValorContratoHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getValorContratoHistorialProyeccionAnualAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraest.setNumeroPersonalHumanoHistProyAnAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getNumeroPersonalHumanoHistProyAnAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraest.setNombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getNombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraest.setNombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraestDTO.getNombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialProyeccionAnualAseoLimpInfraestDTO.getInfraestructuraDTO() != null && historialProyeccionAnualAseoLimpInfraestDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialProyeccionAnualAseoLimpInfraestDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(historialProyeccionAnualAseoLimpInfraest::setInfraestructura);
        }
        
        return historialProyeccionAnualAseoLimpInfraest;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 13/04/2026.
    * @param historialProyeccionAnualAseoLimpInfraest
    * Recibe un objeto historialProyeccionAnualAseoLimpInfraest para crear un DTO.
    * @return historialProyeccionAnualAseoLimpInfraestDTO
    */
    public HistorialProyeccionAnualAseoLimpInfraestDTO historialProyeccionAnualAseoLimpInfraestDTO(HistorialProyeccionAnualAseoLimpInfraest historialProyeccionAnualAseoLimpInfraest){
        HistorialProyeccionAnualAseoLimpInfraestDTO historialProyeccionAnualAseoLimpInfraestDTO = new HistorialProyeccionAnualAseoLimpInfraestDTO();
        historialProyeccionAnualAseoLimpInfraestDTO.setIdHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraest.getIdHistorialProyeccionAnualAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraestDTO.setNumRegHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraest.getNumRegHistorialProyeccionAnualAseoLimpInfraest().toUpperCase());
        historialProyeccionAnualAseoLimpInfraestDTO.setValorContratoHistorialProyeccionAnualAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraest.getValorContratoHistorialProyeccionAnualAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraestDTO.setNumeroPersonalHumanoHistProyAnAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraest.getNumeroPersonalHumanoHistProyAnAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraestDTO.setNombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraest.getNombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest());
        historialProyeccionAnualAseoLimpInfraestDTO.setNombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest(historialProyeccionAnualAseoLimpInfraest.getNombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (historialProyeccionAnualAseoLimpInfraest.getInfraestructura() != null && historialProyeccionAnualAseoLimpInfraest.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(historialProyeccionAnualAseoLimpInfraest.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> historialProyeccionAnualAseoLimpInfraestDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return historialProyeccionAnualAseoLimpInfraestDTO;
    }
}
