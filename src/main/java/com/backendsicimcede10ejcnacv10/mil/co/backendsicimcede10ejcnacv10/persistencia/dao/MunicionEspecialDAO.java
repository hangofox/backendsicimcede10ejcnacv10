//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MunicionEspecialDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MunicionEspecial;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PelotonUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeMilitarArtefactoExplosivo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.PelotonUnidadMilitarRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDespejeMilitarArtefactoExplosivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class MunicionEspecialDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private PelotonUnidadMilitarRepository pelotonUnidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private PelotonUnidadMilitarDAO pelotonUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDespejeMilitarArtefactoExplosivoRepository tipoDespejeMilitarArtefactoExplosivoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDespejeMilitarArtefactoExplosivoDAO tipoDespejeMilitarArtefactoExplosivoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param municionEspecialDTO
    * Recibe un DTO para crear un objeto municionEspecial.
    * @return municionEspecial
    */
    public MunicionEspecial municionEspecial(MunicionEspecialDTO municionEspecialDTO){
        MunicionEspecial municionEspecial = new MunicionEspecial();
        municionEspecial.setIdMunicionEspecial(municionEspecialDTO.getIdMunicionEspecial());
        municionEspecial.setNombreMunicionEspecial(municionEspecialDTO.getNombreMunicionEspecial().toUpperCase());
        municionEspecial.setCantidadMunicionEspecial(municionEspecialDTO.getCantidadMunicionEspecial());
        municionEspecial.setLoteMunicionEspecial(municionEspecialDTO.getLoteMunicionEspecial().toUpperCase());
        municionEspecial.setValorAdquisicionMunicionEspecial(municionEspecialDTO.getValorAdquisicionMunicionEspecial());
        municionEspecial.setValorContableMunicionEspecial(municionEspecialDTO.getValorContableMunicionEspecial());
        municionEspecial.setFechaHMSAltaMunicionEspecial(municionEspecialDTO.getFechaHMSAltaMunicionEspecial());
        municionEspecial.setCentroCostoPelotonUnidadMilitar(municionEspecialDTO.getCentroCostoPelotonUnidadMilitar());
        municionEspecial.setFechaHMSIngresoMunicionEspecial(municionEspecialDTO.getFechaHMSIngresoMunicionEspecial());
        municionEspecial.setFechaHMSModificacionMunicionEspecial(municionEspecialDTO.getFechaHMSModificacionMunicionEspecial());
        municionEspecial.setEstadoMunicionEspecial(municionEspecialDTO.getEstadoMunicionEspecial());
        
        //MAPEAR PELOTÓN DE UNIDAD MILITAR RELACIONADO.
        if (municionEspecialDTO.getPelotonUnidadMilitarDTO() != null && municionEspecialDTO.getPelotonUnidadMilitarDTO().getIdPelotonUnidadMilitar() != null) {
           Optional<PelotonUnidadMilitar> pelotonUnidadMilitarFk = pelotonUnidadMilitarRepository.findByIdPelotonUnidadMilitar(municionEspecialDTO.getPelotonUnidadMilitarDTO().getIdPelotonUnidadMilitar());
           pelotonUnidadMilitarFk.ifPresent(municionEspecial::setPelotonUnidadMilitar);
        }
        
        //MAPEAR TIPO DE DESPEJE MILITAR DE ARTEFACTO EXPLOSIVO RELACIONADO.
        if (municionEspecialDTO.getTipoDespejeMilitarArtefactoExplosivoDTO() != null && municionEspecialDTO.getTipoDespejeMilitarArtefactoExplosivoDTO().getIdTipoDespejeMilitarArtefactoExplosivo() != null) {
           Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoFk = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(municionEspecialDTO.getTipoDespejeMilitarArtefactoExplosivoDTO().getIdTipoDespejeMilitarArtefactoExplosivo());
           tipoDespejeMilitarArtefactoExplosivoFk.ifPresent(municionEspecial::setTipoDespejeMilitarArtefactoExplosivo);
        }
        
        return municionEspecial;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param municionEspecial
    * Recibe un objeto municionEspecial para crear un DTO.
    * @return municionEspecialDTO
    */
    public MunicionEspecialDTO municionEspecialDTO(MunicionEspecial municionEspecial){
        MunicionEspecialDTO municionEspecialDTO = new MunicionEspecialDTO();
        municionEspecialDTO.setIdMunicionEspecial(municionEspecial.getIdMunicionEspecial());
        municionEspecialDTO.setNombreMunicionEspecial(municionEspecial.getNombreMunicionEspecial().toUpperCase());
        municionEspecialDTO.setCantidadMunicionEspecial(municionEspecial.getCantidadMunicionEspecial());
        municionEspecialDTO.setLoteMunicionEspecial(municionEspecial.getLoteMunicionEspecial().toUpperCase());
        municionEspecialDTO.setValorAdquisicionMunicionEspecial(municionEspecial.getValorAdquisicionMunicionEspecial());
        municionEspecialDTO.setValorContableMunicionEspecial(municionEspecial.getValorContableMunicionEspecial());
        municionEspecialDTO.setFechaHMSAltaMunicionEspecial(municionEspecial.getFechaHMSAltaMunicionEspecial());
        municionEspecialDTO.setCentroCostoPelotonUnidadMilitar(municionEspecial.getCentroCostoPelotonUnidadMilitar());
        municionEspecialDTO.setFechaHMSIngresoMunicionEspecial(municionEspecial.getFechaHMSIngresoMunicionEspecial());
        municionEspecialDTO.setFechaHMSModificacionMunicionEspecial(municionEspecial.getFechaHMSModificacionMunicionEspecial());
        municionEspecialDTO.setEstadoMunicionEspecial(municionEspecial.getEstadoMunicionEspecial());
        
        //MAPEAR PELOTÓN DE UNIDAD MILITAR RELACIONADO.
        if (municionEspecial.getPelotonUnidadMilitar() != null && municionEspecial.getPelotonUnidadMilitar().getIdPelotonUnidadMilitar() != null) {
           Optional<PelotonUnidadMilitar> pelotonUnidadMilitarFk = pelotonUnidadMilitarRepository.findByIdPelotonUnidadMilitar(municionEspecial.getPelotonUnidadMilitar().getIdPelotonUnidadMilitar());
           pelotonUnidadMilitarFk.ifPresent(pelotonUnidadMilitar -> municionEspecialDTO.setPelotonUnidadMilitarDTO(pelotonUnidadMilitarDAO.pelotonUnidadMilitarDTO(pelotonUnidadMilitar)));
        }
        
        //MAPEAR TIPO DE DESPEJE MILITAR DE ARTEFACTO EXPLOSIVO RELACIONADO.
        if (municionEspecial.getTipoDespejeMilitarArtefactoExplosivo() != null && municionEspecial.getTipoDespejeMilitarArtefactoExplosivo().getIdTipoDespejeMilitarArtefactoExplosivo() != null) {
           Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoFk = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(municionEspecial.getTipoDespejeMilitarArtefactoExplosivo().getIdTipoDespejeMilitarArtefactoExplosivo());
           tipoDespejeMilitarArtefactoExplosivoFk.ifPresent(tipoDespejeMilitarArtefactoExplosivo -> municionEspecialDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivo)));
        }
        
        return municionEspecialDTO;
    }
}
