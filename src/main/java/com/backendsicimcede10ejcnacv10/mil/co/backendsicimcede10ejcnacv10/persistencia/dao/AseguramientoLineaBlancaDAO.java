//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.AseguramientoLineaBlancaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.AseguramientoLineaBlanca;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Aseguradora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoResponsabilidadContractual;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.AseguradoraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
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
public class AseguramientoLineaBlancaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private AseguradoraRepository aseguradoraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private AseguradoraDAO aseguradoraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoResponsabilidadContractualRepository tipoResponsabilidadContractualRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoResponsabilidadContractualDAO tipoResponsabilidadContractualDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param aseguramientoLineaBlancaDTO
    * Recibe un DTO para crear un objeto aseguramientoLineaBlanca.
    * @return aseguramientoLineaBlanca
    */
    public AseguramientoLineaBlanca aseguramientoLineaBlanca(AseguramientoLineaBlancaDTO aseguramientoLineaBlancaDTO){
        AseguramientoLineaBlanca aseguramientoLineaBlanca = new AseguramientoLineaBlanca();
        aseguramientoLineaBlanca.setIdAseguramientoLineaBlanca(aseguramientoLineaBlancaDTO.getIdAseguramientoLineaBlanca());
        aseguramientoLineaBlanca.setNumeroSeguroAseguramientoLineaBlanca(aseguramientoLineaBlancaDTO.getNumeroSeguroAseguramientoLineaBlanca().toUpperCase());
        aseguramientoLineaBlanca.setFechaHMSIniciacionAseguramientoLineaBlanca(aseguramientoLineaBlancaDTO.getFechaHMSIniciacionAseguramientoLineaBlanca());
        aseguramientoLineaBlanca.setFechaHMSFinalizacionAseguramientoLineaBlanca(aseguramientoLineaBlancaDTO.getFechaHMSFinalizacionAseguramientoLineaBlanca());
        aseguramientoLineaBlanca.setValorSolicitadoAseguramientoLineaBlanca(aseguramientoLineaBlancaDTO.getValorSolicitadoAseguramientoLineaBlanca());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (aseguramientoLineaBlancaDTO.getEquipoIngenieroDTO() != null && aseguramientoLineaBlancaDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(aseguramientoLineaBlancaDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(aseguramientoLineaBlanca::setEquipoIngeniero);
        }
        
        //MAPEAR ASEGURADORA RELACIONADA.
        if (aseguramientoLineaBlancaDTO.getAseguradoraDTO() != null && aseguramientoLineaBlancaDTO.getAseguradoraDTO().getIdAseguradora() != null) {
           Optional<Aseguradora> aseguradoraFk = aseguradoraRepository.findByIdAseguradora(aseguramientoLineaBlancaDTO.getAseguradoraDTO().getIdAseguradora());
           aseguradoraFk.ifPresent(aseguramientoLineaBlanca::setAseguradora);
        }
        
        //MAPEAR TIPO DE RESPONSABILIDAD CONTRACTUAL RELACIONADO.
        if (aseguramientoLineaBlancaDTO.getTipoResponsabilidadContractualDTO() != null && aseguramientoLineaBlancaDTO.getTipoResponsabilidadContractualDTO().getIdTipoResponsabilidadContractual() != null) {
           Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualFk = tipoResponsabilidadContractualRepository.findByIdTipoResponsabilidadContractual(aseguramientoLineaBlancaDTO.getTipoResponsabilidadContractualDTO().getIdTipoResponsabilidadContractual());
           tipoResponsabilidadContractualFk.ifPresent(aseguramientoLineaBlanca::setTipoResponsabilidadContractual);
        }
        
        return aseguramientoLineaBlanca;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param aseguramientoLineaBlanca
    * Recibe un objeto aseguramientoLineaBlanca para crear un DTO.
    * @return aseguramientoLineaBlancaDTO
    */
    public AseguramientoLineaBlancaDTO aseguramientoLineaBlancaDTO(AseguramientoLineaBlanca aseguramientoLineaBlanca){
        AseguramientoLineaBlancaDTO aseguramientoLineaBlancaDTO = new AseguramientoLineaBlancaDTO();
        aseguramientoLineaBlancaDTO.setIdAseguramientoLineaBlanca(aseguramientoLineaBlanca.getIdAseguramientoLineaBlanca());
        aseguramientoLineaBlancaDTO.setNumeroSeguroAseguramientoLineaBlanca(aseguramientoLineaBlanca.getNumeroSeguroAseguramientoLineaBlanca().toUpperCase());
        aseguramientoLineaBlancaDTO.setFechaHMSIniciacionAseguramientoLineaBlanca(aseguramientoLineaBlanca.getFechaHMSIniciacionAseguramientoLineaBlanca());
        aseguramientoLineaBlancaDTO.setFechaHMSFinalizacionAseguramientoLineaBlanca(aseguramientoLineaBlanca.getFechaHMSFinalizacionAseguramientoLineaBlanca());
        aseguramientoLineaBlancaDTO.setValorSolicitadoAseguramientoLineaBlanca(aseguramientoLineaBlanca.getValorSolicitadoAseguramientoLineaBlanca());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (aseguramientoLineaBlanca.getEquipoIngeniero() != null && aseguramientoLineaBlanca.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(aseguramientoLineaBlanca.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(eqIng -> aseguramientoLineaBlancaDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(eqIng)));
        }
        
        //MAPEAR ASEGURADORA RELACIONADA.
        if (aseguramientoLineaBlanca.getAseguradora() != null && aseguramientoLineaBlanca.getAseguradora().getIdAseguradora() != null) {
           Optional<Aseguradora> aseguradoraFk = aseguradoraRepository.findByIdAseguradora(aseguramientoLineaBlanca.getAseguradora().getIdAseguradora());
           aseguradoraFk.ifPresent(aseg -> aseguramientoLineaBlancaDTO.setAseguradoraDTO(aseguradoraDAO.aseguradoraDTO(aseg)));
        }
        
        //MAPEAR TIPO DE RESPONSABILIDAD CONTRACTUAL RELACIONADO.
        if (aseguramientoLineaBlanca.getTipoResponsabilidadContractual() != null && aseguramientoLineaBlanca.getTipoResponsabilidadContractual().getIdTipoResponsabilidadContractual() != null) {
           Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualFk = tipoResponsabilidadContractualRepository.findByIdTipoResponsabilidadContractual(aseguramientoLineaBlanca.getTipoResponsabilidadContractual().getIdTipoResponsabilidadContractual());
           tipoResponsabilidadContractualFk.ifPresent(tipoRespCont -> aseguramientoLineaBlancaDTO.setTipoResponsabilidadContractualDTO(tipoResponsabilidadContractualDAO.tipoResponsabilidadContractualDTO(tipoRespCont)));
        }
        
        return aseguramientoLineaBlancaDTO;
    }
}
