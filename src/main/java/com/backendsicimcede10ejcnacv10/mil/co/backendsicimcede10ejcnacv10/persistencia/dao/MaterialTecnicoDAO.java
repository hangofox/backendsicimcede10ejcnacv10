//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MaterialTecnicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaterialTecnico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeMilitarArtefactoExplosivo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDespejeMilitarArtefactoExplosivoRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class MaterialTecnicoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDespejeMilitarArtefactoExplosivoRepository tipoDespejeMilitarArtefactoExplosivoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDespejeMilitarArtefactoExplosivoDAO tipoDespejeMilitarArtefactoExplosivoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param materialTecnicoDTO
    * Recibe un DTO para crear un objeto materialTecnico.
    * @return materialTecnico
    */
    public MaterialTecnico materialTecnico(MaterialTecnicoDTO materialTecnicoDTO){
        MaterialTecnico materialTecnico = new MaterialTecnico();
        materialTecnico.setIdMaterialTecnico(materialTecnicoDTO.getIdMaterialTecnico());
        materialTecnico.setNombreMaterialTecnico(materialTecnicoDTO.getNombreMaterialTecnico().toUpperCase());
        materialTecnico.setSerialMaterialTecnico(materialTecnicoDTO.getSerialMaterialTecnico());
        materialTecnico.setNumeroInventarioMaterialTecnico(materialTecnicoDTO.getNumeroInventarioMaterialTecnico());
        materialTecnico.setNumeroActivoFijoMaterialTecnico(materialTecnicoDTO.getNumeroActivoFijoMaterialTecnico());
        materialTecnico.setValorAdquisicionMaterialTecnico(materialTecnicoDTO.getValorAdquisicionMaterialTecnico());
        materialTecnico.setValorContableMaterialTecnico(materialTecnicoDTO.getValorContableMaterialTecnico());
        materialTecnico.setValorCostoUnitarioMaterialTecnico(materialTecnicoDTO.getValorCostoUnitarioMaterialTecnico());
        materialTecnico.setCodigoContableMaterialTecnico(materialTecnicoDTO.getCodigoContableMaterialTecnico());
        materialTecnico.setCentroCostoUnidadMilitar(materialTecnicoDTO.getCentroCostoUnidadMilitar());
        materialTecnico.setFechaHMSAltaMaterialTecnico(materialTecnicoDTO.getFechaHMSAltaMaterialTecnico());
        materialTecnico.setTiempoAnualVidaUtilMaterialTecnico(materialTecnicoDTO.getTiempoAnualVidaUtilMaterialTecnico());
        materialTecnico.setFechaHMSIngresoMaterialTecnico(materialTecnicoDTO.getFechaHMSIngresoMaterialTecnico());
        materialTecnico.setFechaHMSModificacionMaterialTecnico(materialTecnicoDTO.getFechaHMSModificacionMaterialTecnico());
        materialTecnico.setEstadoUsoMaterialTecnico(materialTecnicoDTO.getEstadoUsoMaterialTecnico());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (materialTecnicoDTO.getUnidadMilitarDTO() != null && materialTecnicoDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(materialTecnicoDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(materialTecnico::setUnidadMilitar);
        }
        
        //MAPEAR TIPO DE DESPEJE MILITAR DE ARTEFACTO EXPLOSIVO RELACIONADO.
        if (materialTecnicoDTO.getTipoDespejeMilitarArtefactoExplosivoDTO() != null && materialTecnicoDTO.getTipoDespejeMilitarArtefactoExplosivoDTO().getIdTipoDespejeMilitarArtefactoExplosivo() != null) {
           Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoFk = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(materialTecnicoDTO.getTipoDespejeMilitarArtefactoExplosivoDTO().getIdTipoDespejeMilitarArtefactoExplosivo());
           tipoDespejeMilitarArtefactoExplosivoFk.ifPresent(materialTecnico::setTipoDespejeMilitarArtefactoExplosivo);
        }
        
        return materialTecnico;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param materialTecnico
    * Recibe un objeto materialTecnico para crear un DTO.
    * @return materialTecnicoDTO
    */
    public MaterialTecnicoDTO materialTecnicoDTO(MaterialTecnico materialTecnico){
        MaterialTecnicoDTO materialTecnicoDTO = new MaterialTecnicoDTO();
        materialTecnicoDTO.setIdMaterialTecnico(materialTecnico.getIdMaterialTecnico());
        materialTecnicoDTO.setNombreMaterialTecnico(materialTecnico.getNombreMaterialTecnico().toUpperCase());
        materialTecnicoDTO.setSerialMaterialTecnico(materialTecnico.getSerialMaterialTecnico());
        materialTecnicoDTO.setNumeroInventarioMaterialTecnico(materialTecnico.getNumeroInventarioMaterialTecnico());
        materialTecnicoDTO.setNumeroActivoFijoMaterialTecnico(materialTecnico.getNumeroActivoFijoMaterialTecnico());
        materialTecnicoDTO.setValorAdquisicionMaterialTecnico(materialTecnico.getValorAdquisicionMaterialTecnico());
        materialTecnicoDTO.setValorContableMaterialTecnico(materialTecnico.getValorContableMaterialTecnico());
        materialTecnicoDTO.setValorCostoUnitarioMaterialTecnico(materialTecnico.getValorCostoUnitarioMaterialTecnico());
        materialTecnicoDTO.setCodigoContableMaterialTecnico(materialTecnico.getCodigoContableMaterialTecnico());
        materialTecnicoDTO.setCentroCostoUnidadMilitar(materialTecnico.getCentroCostoUnidadMilitar());
        materialTecnicoDTO.setFechaHMSAltaMaterialTecnico(materialTecnico.getFechaHMSAltaMaterialTecnico());
        materialTecnicoDTO.setTiempoAnualVidaUtilMaterialTecnico(materialTecnico.getTiempoAnualVidaUtilMaterialTecnico());
        materialTecnicoDTO.setFechaHMSIngresoMaterialTecnico(materialTecnico.getFechaHMSIngresoMaterialTecnico());
        materialTecnicoDTO.setFechaHMSModificacionMaterialTecnico(materialTecnico.getFechaHMSModificacionMaterialTecnico());
        materialTecnicoDTO.setEstadoUsoMaterialTecnico(materialTecnico.getEstadoUsoMaterialTecnico());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (materialTecnico.getUnidadMilitar() != null && materialTecnico.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(materialTecnico.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> materialTecnicoDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        //MAPEAR TIPO DE DESPEJE MILITAR DE ARTEFACTO EXPLOSIVO RELACIONADO.
        if (materialTecnico.getTipoDespejeMilitarArtefactoExplosivo() != null && materialTecnico.getTipoDespejeMilitarArtefactoExplosivo().getIdTipoDespejeMilitarArtefactoExplosivo() != null) {
           Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoFk = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(materialTecnico.getTipoDespejeMilitarArtefactoExplosivo().getIdTipoDespejeMilitarArtefactoExplosivo());
           tipoDespejeMilitarArtefactoExplosivoFk.ifPresent(tipoDespejeMilitarArtefactoExplosivo -> materialTecnicoDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivo)));
        }
        
        return materialTecnicoDTO;
    }
}
