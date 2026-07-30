//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ContratoProyeccionSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ContratoProyeccionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContratoSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoResponsabilidadContractual;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionSeguroInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoContratoSeguroInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoResponsabilidadContractualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ContratoProyeccionSeguroInfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionSeguroInfraestructuraRepository proyeccionSeguroInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionSeguroInfraestructuraDAO proyeccionSeguroInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoContratoSeguroInfraestructuraRepository tipoContratoSeguroInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoContratoSeguroInfraestructuraDAO tipoContratoSeguroInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoResponsabilidadContractualRepository tipoResponsabilidadContractualRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoResponsabilidadContractualDAO tipoResponsabilidadContractualDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param contratoProyeccionSeguroInfraestructuraDTO
    * Recibe un DTO para crear un objeto contratoProyeccionSeguroInfraestructura.
    * @return contratoProyeccionSeguroInfraestructura
    */
    public ContratoProyeccionSeguroInfraestructura contratoProyeccionSeguroInfraestructura(ContratoProyeccionSeguroInfraestructuraDTO contratoProyeccionSeguroInfraestructuraDTO){
        ContratoProyeccionSeguroInfraestructura contratoProyeccionSeguroInfraestructura = new ContratoProyeccionSeguroInfraestructura();
        contratoProyeccionSeguroInfraestructura.setIdContratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getIdContratoProyeccionSeguroInfraestructura());
        contratoProyeccionSeguroInfraestructura.setNumeroContratoSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getNumeroContratoSeguroInfraestructura().toUpperCase());
        contratoProyeccionSeguroInfraestructura.setFechaHMSContratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getFechaHMSContratoProyeccionSeguroInfraestructura());
        contratoProyeccionSeguroInfraestructura.setDescripcionContratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getDescripcionContratoProyeccionSeguroInfraestructura());
        
        //MAPEAR PROYECCION DE SEGURO DE INFRAESTRUCTURA RELACIONADA.
        if (contratoProyeccionSeguroInfraestructuraDTO.getProyeccionSeguroInfraestructuraDTO() != null && contratoProyeccionSeguroInfraestructuraDTO.getProyeccionSeguroInfraestructuraDTO().getIdProyeccionSeguroInfraestructura() != null) {
           Optional<ProyeccionSeguroInfraestructura> proyeccionSeguroInfraestructuraFk = proyeccionSeguroInfraestructuraRepository.findByIdProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getProyeccionSeguroInfraestructuraDTO().getIdProyeccionSeguroInfraestructura());
           proyeccionSeguroInfraestructuraFk.ifPresent(contratoProyeccionSeguroInfraestructura::setProyeccionSeguroInfraestructura);
        }
        
        //MAPEAR TIPO DE CONTRATO SEGURO INFRAESTRUCTURA RELACIONADO.
        if (contratoProyeccionSeguroInfraestructuraDTO.getTipoContratoSeguroInfraestructuraDTO() != null && contratoProyeccionSeguroInfraestructuraDTO.getTipoContratoSeguroInfraestructuraDTO().getIdTipoContratoSeguroInfraestructura() != null) {
           Optional<TipoContratoSeguroInfraestructura> tipoContratoSeguroInfraestructuraFk = tipoContratoSeguroInfraestructuraRepository.findByIdTipoContratoSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getTipoContratoSeguroInfraestructuraDTO().getIdTipoContratoSeguroInfraestructura());
           tipoContratoSeguroInfraestructuraFk.ifPresent(contratoProyeccionSeguroInfraestructura::setTipoContratoSeguroInfraestructura);
        }
        
        //MAPEAR TIPO DE RESPONSABILIDAD CONTRACTUAL RELACIONADO.
        if (contratoProyeccionSeguroInfraestructuraDTO.getTipoResponsabilidadContractualDTO() != null && contratoProyeccionSeguroInfraestructuraDTO.getTipoResponsabilidadContractualDTO().getIdTipoResponsabilidadContractual() != null) {
           Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualFk = tipoResponsabilidadContractualRepository.findByIdTipoResponsabilidadContractual(contratoProyeccionSeguroInfraestructuraDTO.getTipoResponsabilidadContractualDTO().getIdTipoResponsabilidadContractual());
           tipoResponsabilidadContractualFk.ifPresent(contratoProyeccionSeguroInfraestructura::setTipoResponsabilidadContractual);
        }
        
        return contratoProyeccionSeguroInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param contratoProyeccionSeguroInfraestructura
    * Recibe un objeto contratoProyeccionSeguroInfraestructura para crear un DTO.
    * @return contratoProyeccionSeguroInfraestructuraDTO
    */
    public ContratoProyeccionSeguroInfraestructuraDTO contratoProyeccionSeguroInfraestructuraDTO(ContratoProyeccionSeguroInfraestructura contratoProyeccionSeguroInfraestructura){
        ContratoProyeccionSeguroInfraestructuraDTO contratoProyeccionSeguroInfraestructuraDTO = new ContratoProyeccionSeguroInfraestructuraDTO();
        contratoProyeccionSeguroInfraestructuraDTO.setIdContratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructura.getIdContratoProyeccionSeguroInfraestructura());
        contratoProyeccionSeguroInfraestructuraDTO.setNumeroContratoSeguroInfraestructura(contratoProyeccionSeguroInfraestructura.getNumeroContratoSeguroInfraestructura().toUpperCase());
        contratoProyeccionSeguroInfraestructuraDTO.setFechaHMSContratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructura.getFechaHMSContratoProyeccionSeguroInfraestructura());
        contratoProyeccionSeguroInfraestructuraDTO.setDescripcionContratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructura.getDescripcionContratoProyeccionSeguroInfraestructura());
        
        //MAPEAR PROYECCION DE SEGURO DE INFRAESTRUCTURA RELACIONADA.
        if (contratoProyeccionSeguroInfraestructura.getProyeccionSeguroInfraestructura() != null && contratoProyeccionSeguroInfraestructura.getProyeccionSeguroInfraestructura().getIdProyeccionSeguroInfraestructura() != null) {
           Optional<ProyeccionSeguroInfraestructura> proyeccionSeguroInfraestructuraFk = proyeccionSeguroInfraestructuraRepository.findByIdProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructura.getProyeccionSeguroInfraestructura().getIdProyeccionSeguroInfraestructura());
           proyeccionSeguroInfraestructuraFk.ifPresent(proySegInfra -> contratoProyeccionSeguroInfraestructuraDTO.setProyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructuraDTO(proySegInfra)));
        }
        
        //MAPEAR TIPO DE CONTRATO SEGURO DE INFRAESTRUCTURA RELACIONADO.
        if (contratoProyeccionSeguroInfraestructura.getTipoContratoSeguroInfraestructura() != null && contratoProyeccionSeguroInfraestructura.getTipoContratoSeguroInfraestructura().getIdTipoContratoSeguroInfraestructura() != null) {
           Optional<TipoContratoSeguroInfraestructura> tipoContratoSeguroInfraestructuraFk = tipoContratoSeguroInfraestructuraRepository.findByIdTipoContratoSeguroInfraestructura(contratoProyeccionSeguroInfraestructura.getTipoContratoSeguroInfraestructura().getIdTipoContratoSeguroInfraestructura());
           tipoContratoSeguroInfraestructuraFk.ifPresent(tipoCont -> contratoProyeccionSeguroInfraestructuraDTO.setTipoContratoSeguroInfraestructuraDTO(tipoContratoSeguroInfraestructuraDAO.tipoContratoSeguroInfraestructuraDTO(tipoCont)));
        }
        
        //MAPEAR TIPO DE RESPONSABILIDAD CONTRACTUAL RELACIONADO.
        if (contratoProyeccionSeguroInfraestructura.getTipoResponsabilidadContractual() != null && contratoProyeccionSeguroInfraestructura.getTipoResponsabilidadContractual().getIdTipoResponsabilidadContractual() != null) {
           Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualFk = tipoResponsabilidadContractualRepository.findByIdTipoResponsabilidadContractual(contratoProyeccionSeguroInfraestructura.getTipoResponsabilidadContractual().getIdTipoResponsabilidadContractual());
           tipoResponsabilidadContractualFk.ifPresent(tipoRespCont -> contratoProyeccionSeguroInfraestructuraDTO.setTipoResponsabilidadContractualDTO(tipoResponsabilidadContractualDAO.tipoResponsabilidadContractualDTO(tipoRespCont)));
        }
        
        return contratoProyeccionSeguroInfraestructuraDTO;
    }
}
