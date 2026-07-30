//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroLineaBlancaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.AseguramientoLineaBlanca;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroLineaBlanca;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.AseguramientoLineaBlancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class InclusionSeguroLineaBlancaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private AseguramientoLineaBlancaRepository aseguramientoLineaBlancaRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private AseguramientoLineaBlancaDAO aseguramientoLineaBlancaDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param inclusionSeguroLineaBlancaDTO
    * Recibe un DTO para crear un objeto inclusionSeguroLineaBlanca.
    * @return inclusionSeguroLineaBlanca
    */
    public InclusionSeguroLineaBlanca inclusionSeguroLineaBlanca(InclusionSeguroLineaBlancaDTO inclusionSeguroLineaBlancaDTO){
        InclusionSeguroLineaBlanca inclusionSeguroLineaBlanca = new InclusionSeguroLineaBlanca();
        inclusionSeguroLineaBlanca.setIdInclusionSeguroLineaBlanca(inclusionSeguroLineaBlancaDTO.getIdInclusionSeguroLineaBlanca());
        inclusionSeguroLineaBlanca.setFechaHMSIniciacionInclusionSeguroLineaBlanca(inclusionSeguroLineaBlancaDTO.getFechaHMSIniciacionInclusionSeguroLineaBlanca());
        inclusionSeguroLineaBlanca.setFechaHMSFinalizacionInclusionSeguroLineaBlanca(inclusionSeguroLineaBlancaDTO.getFechaHMSFinalizacionInclusionSeguroLineaBlanca());
        inclusionSeguroLineaBlanca.setDescripcionInclusionSeguroLineaBlanca(inclusionSeguroLineaBlancaDTO.getDescripcionInclusionSeguroLineaBlanca());
        
        //MAPEAR ASEGURAMIENTO DE LÍNEA BLANCA RELACIONADO.
        if (inclusionSeguroLineaBlancaDTO.getAseguramientoLineaBlancaDTO() != null && inclusionSeguroLineaBlancaDTO.getAseguramientoLineaBlancaDTO().getIdAseguramientoLineaBlanca() != null) {
           Optional<AseguramientoLineaBlanca> aseguramientoLineaBlancaFk = aseguramientoLineaBlancaRepository.findByIdAseguramientoLineaBlanca(inclusionSeguroLineaBlancaDTO.getAseguramientoLineaBlancaDTO().getIdAseguramientoLineaBlanca());
           aseguramientoLineaBlancaFk.ifPresent(inclusionSeguroLineaBlanca::setAseguramientoLineaBlanca);
        }
        
        return inclusionSeguroLineaBlanca;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param inclusionSeguroLineaBlanca
    * Recibe un objeto inclusionSeguroLineaBlanca para crear un DTO.
    * @return inclusionSeguroLineaBlancaDTO
    */
    public InclusionSeguroLineaBlancaDTO inclusionSeguroLineaBlancaDTO(InclusionSeguroLineaBlanca inclusionSeguroLineaBlanca){
        InclusionSeguroLineaBlancaDTO inclusionSeguroLineaBlancaDTO = new InclusionSeguroLineaBlancaDTO();
        inclusionSeguroLineaBlancaDTO.setIdInclusionSeguroLineaBlanca(inclusionSeguroLineaBlanca.getIdInclusionSeguroLineaBlanca());
        inclusionSeguroLineaBlancaDTO.setFechaHMSIniciacionInclusionSeguroLineaBlanca(inclusionSeguroLineaBlanca.getFechaHMSIniciacionInclusionSeguroLineaBlanca());
        inclusionSeguroLineaBlancaDTO.setFechaHMSFinalizacionInclusionSeguroLineaBlanca(inclusionSeguroLineaBlanca.getFechaHMSFinalizacionInclusionSeguroLineaBlanca());
        inclusionSeguroLineaBlancaDTO.setDescripcionInclusionSeguroLineaBlanca(inclusionSeguroLineaBlanca.getDescripcionInclusionSeguroLineaBlanca());
        
        //MAPEAR ASEGURAMIENTO DE LÍNEA BLANCA RELACIONADO.
        if (inclusionSeguroLineaBlanca.getAseguramientoLineaBlanca() != null && inclusionSeguroLineaBlanca.getAseguramientoLineaBlanca().getIdAseguramientoLineaBlanca() != null) {
           Optional<AseguramientoLineaBlanca> aseguramientoLineaBlancaFk = aseguramientoLineaBlancaRepository.findByIdAseguramientoLineaBlanca(inclusionSeguroLineaBlanca.getAseguramientoLineaBlanca().getIdAseguramientoLineaBlanca());
           aseguramientoLineaBlancaFk.ifPresent(aseguramientoLineaBlanca -> inclusionSeguroLineaBlancaDTO.setAseguramientoLineaBlancaDTO(aseguramientoLineaBlancaDAO.aseguramientoLineaBlancaDTO(aseguramientoLineaBlanca)));
        }
        
        return inclusionSeguroLineaBlancaDTO;
    }
}
