//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SaneamientoBasicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Oficina;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SaneamientoBasico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class SaneamientoBasicoDAO {
    
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
    * @Since 30/03/2026.
    * @param saneamientoBasicoDTO
    * Recibe un DTO para crear un objeto saneamientoBasico.
    * @return saneamientoBasico
    */
    public SaneamientoBasico saneamientoBasico(SaneamientoBasicoDTO saneamientoBasicoDTO){
        SaneamientoBasico saneamientoBasico = new SaneamientoBasico();
        saneamientoBasico.setIdSaneamientoBasico(saneamientoBasicoDTO.getIdSaneamientoBasico());
        saneamientoBasico.setNombreCaudalSaneamientoBasico(saneamientoBasicoDTO.getNombreCaudalSaneamientoBasico().toUpperCase());
        saneamientoBasico.setNombreUnidadMedidaSaneamientoBasico(saneamientoBasicoDTO.getNombreUnidadMedidaSaneamientoBasico().toUpperCase());
        saneamientoBasico.setCentroCostoOficinaSaneamientoBasico(saneamientoBasicoDTO.getCentroCostoOficinaSaneamientoBasico().toUpperCase());
        
        //MAPEAR OFICINA RELACIONADA.
        if (saneamientoBasicoDTO.getOficinaDTO() != null && saneamientoBasicoDTO.getOficinaDTO().getIdOficina() != null) {
           Optional<Oficina> oficinaFk = oficinaRepository.findByIdOficina(saneamientoBasicoDTO.getOficinaDTO().getIdOficina());
           oficinaFk.ifPresent(saneamientoBasico::setOficina);
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (saneamientoBasicoDTO.getInfraestructuraDTO() != null && saneamientoBasicoDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(saneamientoBasicoDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(saneamientoBasico::setInfraestructura);
        }
        
        return saneamientoBasico;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/03/2026.
    * @param saneamientoBasico
    * Recibe un objeto saneamientoBasico para crear un DTO.
    * @return saneamientoBasicoDTO
    */
    public SaneamientoBasicoDTO saneamientoBasicoDTO(SaneamientoBasico saneamientoBasico){
        SaneamientoBasicoDTO saneamientoBasicoDTO = new SaneamientoBasicoDTO();
        saneamientoBasicoDTO.setIdSaneamientoBasico(saneamientoBasico.getIdSaneamientoBasico());
        saneamientoBasicoDTO.setNombreCaudalSaneamientoBasico(saneamientoBasico.getNombreCaudalSaneamientoBasico().toUpperCase());
        saneamientoBasicoDTO.setNombreUnidadMedidaSaneamientoBasico(saneamientoBasico.getNombreUnidadMedidaSaneamientoBasico().toUpperCase());
        saneamientoBasicoDTO.setCentroCostoOficinaSaneamientoBasico(saneamientoBasico.getCentroCostoOficinaSaneamientoBasico().toUpperCase());
        
        //MAPEAR OFICINA RELACIONADA.
        if (saneamientoBasico.getOficina() != null && saneamientoBasico.getOficina().getIdOficina() != null) {
           Optional<Oficina> oficinaFk = oficinaRepository.findByIdOficina(saneamientoBasico.getOficina().getIdOficina());
           oficinaFk.ifPresent(ofic -> saneamientoBasicoDTO.setOficinaDTO(oficinaDAO.oficinaDTO(ofic)));
        }
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (saneamientoBasico.getInfraestructura() != null && saneamientoBasico.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(saneamientoBasico.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> saneamientoBasicoDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        return saneamientoBasicoDTO;
    }
}
