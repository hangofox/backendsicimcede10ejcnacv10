//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CaninoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Canino;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CompaniaUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeMilitarArtefactoExplosivo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CompaniaUnidadMilitarRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDespejeMilitarArtefactoExplosivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CaninoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CompaniaUnidadMilitarRepository companiaUnidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private CompaniaUnidadMilitarDAO companiaUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDespejeMilitarArtefactoExplosivoRepository tipoDespejeMilitarArtefactoExplosivoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDespejeMilitarArtefactoExplosivoDAO tipoDespejeMilitarArtefactoExplosivoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/03/2026.
    * @param caninoDTO
    * Recibe un DTO para crear un objeto canino.
    * @return canino
    */
    public Canino canino(CaninoDTO caninoDTO){
        Canino canino = new Canino();
        canino.setIdCanino(caninoDTO.getIdCanino());
        canino.setDenominacionCanino(caninoDTO.getDenominacionCanino().toUpperCase());
        canino.setNumeroChipCanino(caninoDTO.getNumeroChipCanino());
        canino.setNumeroInventarioCanino(caninoDTO.getNumeroInventarioCanino());
        canino.setNumeroActivoFijoCanino(caninoDTO.getNumeroActivoFijoCanino());
        canino.setNombreCanino(caninoDTO.getNombreCanino().toUpperCase());
        canino.setColorCanino(caninoDTO.getColorCanino().toUpperCase());
        canino.setNombreRazaCanino(caninoDTO.getNombreRazaCanino().toUpperCase());
        canino.setValorAdquisicionCanino(caninoDTO.getValorAdquisicionCanino());
        canino.setValorContableCanino(caninoDTO.getValorContableCanino());
        canino.setValorCostoUnitarioCanino(caninoDTO.getValorCostoUnitarioCanino());
        canino.setCentroCostoCompaniaUnidadMilitar(caninoDTO.getCentroCostoCompaniaUnidadMilitar());
        canino.setFechaHMSAltaCanino(caninoDTO.getFechaHMSAltaCanino());
        canino.setTiempoAnualVidaUtilCanino(caninoDTO.getTiempoAnualVidaUtilCanino());
        canino.setDescripcionCanino(caninoDTO.getDescripcionCanino());
        canino.setFechaHMSIngresoCanino(caninoDTO.getFechaHMSIngresoCanino());
        canino.setFechaHMSModificacionCanino(caninoDTO.getFechaHMSModificacionCanino());
        canino.setEstadoUsoCanino(caninoDTO.getEstadoUsoCanino());
        
        //MAPEAR COMPAÑIA DE UNIDAD MILITAR RELACIONADA.
        if (caninoDTO.getCompaniaUnidadMilitarDTO() != null && caninoDTO.getCompaniaUnidadMilitarDTO().getIdCompaniaUnidadMilitar() != null) {
           Optional<CompaniaUnidadMilitar> companiaUnidadMilitarFk = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(caninoDTO.getCompaniaUnidadMilitarDTO().getIdCompaniaUnidadMilitar());
           companiaUnidadMilitarFk.ifPresent(canino::setCompaniaUnidadMilitar);
        }
        
        //MAPEAR TIPO DE DESPEJE MILITAR DE ARTEFACTO EXPLOSIVO RELACIONADO.
        if (caninoDTO.getTipoDespejeMilitarArtefactoExplosivoDTO() != null && caninoDTO.getTipoDespejeMilitarArtefactoExplosivoDTO().getIdTipoDespejeMilitarArtefactoExplosivo() != null) {
           Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoFk = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(caninoDTO.getTipoDespejeMilitarArtefactoExplosivoDTO().getIdTipoDespejeMilitarArtefactoExplosivo());
           tipoDespejeMilitarArtefactoExplosivoFk.ifPresent(canino::setTipoDespejeMilitarArtefactoExplosivo);
        }
        
        return canino;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 20/03/2026.
    * @param canino
    * Recibe un objeto canino para crear un DTO.
    * @return caninoDTO
    */
    public CaninoDTO caninoDTO(Canino canino){
        CaninoDTO caninoDTO = new CaninoDTO();
        caninoDTO.setIdCanino(canino.getIdCanino());
        caninoDTO.setDenominacionCanino(canino.getDenominacionCanino().toUpperCase());
        caninoDTO.setNumeroChipCanino(canino.getNumeroChipCanino());
        caninoDTO.setNumeroInventarioCanino(canino.getNumeroInventarioCanino());
        caninoDTO.setNumeroActivoFijoCanino(canino.getNumeroActivoFijoCanino());
        caninoDTO.setNombreCanino(canino.getNombreCanino().toUpperCase());
        caninoDTO.setColorCanino(canino.getColorCanino().toUpperCase());
        caninoDTO.setNombreRazaCanino(canino.getNombreRazaCanino().toUpperCase());
        caninoDTO.setValorAdquisicionCanino(canino.getValorAdquisicionCanino());
        caninoDTO.setValorContableCanino(canino.getValorContableCanino());
        caninoDTO.setValorCostoUnitarioCanino(canino.getValorCostoUnitarioCanino());
        caninoDTO.setCentroCostoCompaniaUnidadMilitar(canino.getCentroCostoCompaniaUnidadMilitar());
        caninoDTO.setFechaHMSAltaCanino(canino.getFechaHMSAltaCanino());
        caninoDTO.setTiempoAnualVidaUtilCanino(canino.getTiempoAnualVidaUtilCanino());
        caninoDTO.setDescripcionCanino(canino.getDescripcionCanino());
        caninoDTO.setFechaHMSIngresoCanino(canino.getFechaHMSIngresoCanino());
        caninoDTO.setFechaHMSModificacionCanino(canino.getFechaHMSModificacionCanino());
        caninoDTO.setEstadoUsoCanino(canino.getEstadoUsoCanino());
        
        //MAPEAR COMPAÑIA DE UNIDAD MILITAR RELACIONADA.
        if (canino.getCompaniaUnidadMilitar() != null && canino.getCompaniaUnidadMilitar().getIdCompaniaUnidadMilitar() != null) {
           Optional<CompaniaUnidadMilitar> companiaUnidadMilitarFk = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(canino.getCompaniaUnidadMilitar().getIdCompaniaUnidadMilitar());
           companiaUnidadMilitarFk.ifPresent(companiaUnidadMilitar -> caninoDTO.setCompaniaUnidadMilitarDTO(companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitar)));
        }
        
        //MAPEAR TIPO DE DESPEJE MILITAR DE ARTEFACTO EXPLOSIVO RELACIONADO.
        if (canino.getTipoDespejeMilitarArtefactoExplosivo() != null && canino.getTipoDespejeMilitarArtefactoExplosivo().getIdTipoDespejeMilitarArtefactoExplosivo() != null) {
           Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoFk = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(canino.getTipoDespejeMilitarArtefactoExplosivo().getIdTipoDespejeMilitarArtefactoExplosivo());
           tipoDespejeMilitarArtefactoExplosivoFk.ifPresent(tipoDespejeMilitarArtefactoExplosivo -> caninoDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivo)));
        }
        
        return caninoDTO;
    }
}
