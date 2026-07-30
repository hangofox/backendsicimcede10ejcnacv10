//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FuncionalidadInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Seguro;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SociedadUnidadCentralizadora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Terreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.FuncionalidadInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SeguroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SociedadUnidadCentralizadoraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TerrenoRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEstructuraInfraestructuraRepository;
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
public class InfraestructuraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SociedadUnidadCentralizadoraRepository sociedadUnidadCentralizadoraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SociedadUnidadCentralizadoraDAO sociedadUnidadCentralizadoraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEstructuraInfraestructuraRepository tipoEstructuraInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEstructuraInfraestructuraDAO tipoEstructuraInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private FuncionalidadInfraestructuraRepository funcionalidadInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private FuncionalidadInfraestructuraDAO funcionalidadInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SeguroRepository seguroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SeguroDAO seguroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TerrenoRepository terrenoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TerrenoDAO terrenoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param infraestructuraDTO
    * Recibe un DTO para crear un objeto infraestructura.
    * @return infraestructura
    */
    public Infraestructura infraestructura(InfraestructuraDTO infraestructuraDTO){
        Infraestructura infraestructura = new Infraestructura();
        infraestructura.setIdInfraestructura(infraestructuraDTO.getIdInfraestructura());
        infraestructura.setDenominacionInfraestructura(infraestructuraDTO.getDenominacionInfraestructura().toUpperCase());
        infraestructura.setNumeroInventarioInfraestructura(infraestructuraDTO.getNumeroInventarioInfraestructura());
        infraestructura.setNumeroActivoFijoInfraestructura(infraestructuraDTO.getNumeroActivoFijoInfraestructura());
        infraestructura.setCentroCostoUnidadMilitarInfraestructura(infraestructuraDTO.getCentroCostoUnidadMilitarInfraestructura());
        infraestructura.setPaisOrigenInfraestructura(infraestructuraDTO.getPaisOrigenInfraestructura().toUpperCase());
        infraestructura.setDepartamentoOEstadoOrigenInfraestructura(infraestructuraDTO.getDepartamentoOEstadoOrigenInfraestructura().toUpperCase());
        infraestructura.setCiudadOrigenInfraestructura(infraestructuraDTO.getCiudadOrigenInfraestructura().toUpperCase());
        infraestructura.setDireccionInfraestructura(infraestructuraDTO.getDireccionInfraestructura().toUpperCase());
        infraestructura.setFechaHMSAmortizacionInfraestructura(infraestructuraDTO.getFechaHMSAmortizacionInfraestructura());
        infraestructura.setFechaHMSAltaInfraestructura(infraestructuraDTO.getFechaHMSAltaInfraestructura());
        infraestructura.setNumeroLargoInfraestructura(infraestructuraDTO.getNumeroLargoInfraestructura().toUpperCase());
        infraestructura.setNombreUnidadMedidaLargoInfraestructura(infraestructuraDTO.getNombreUnidadMedidaLargoInfraestructura().toUpperCase());
        infraestructura.setNumeroAnchuraInfraestructura(infraestructuraDTO.getNumeroAnchuraInfraestructura().toUpperCase());
        infraestructura.setNombreUnidadMedidaAnchuraInfraestructura(infraestructuraDTO.getNombreUnidadMedidaAnchuraInfraestructura().toUpperCase());
        infraestructura.setNumeroProfundidadInfraestructura(infraestructuraDTO.getNumeroProfundidadInfraestructura().toUpperCase());
        infraestructura.setNombreUnidadMedidaProfundidadInfraestructura(infraestructuraDTO.getNombreUnidadMedidaProfundidadInfraestructura().toUpperCase());
        infraestructura.setNumeroPisosInfraestructura(infraestructuraDTO.getNumeroPisosInfraestructura().toUpperCase());
        infraestructura.setEstadoUsoInfraestructura(infraestructuraDTO.getEstadoUsoInfraestructura().toUpperCase());
        infraestructura.setLatitudInfraestructura(infraestructuraDTO.getLatitudInfraestructura().toUpperCase());
        infraestructura.setLongitudInfraestructura(infraestructuraDTO.getLongitudInfraestructura().toUpperCase());
        infraestructura.setNormaSismoresistenteInfraestructura(infraestructuraDTO.getNormaSismoresistenteInfraestructura().toUpperCase());
        infraestructura.setPropiedadHorizontalInfraestructura(infraestructuraDTO.getPropiedadHorizontalInfraestructura().toUpperCase());
        infraestructura.setDenominacionPosteriorInfraestructura(infraestructuraDTO.getDenominacionPosteriorInfraestructura().toUpperCase());
        infraestructura.setEstratoInfraestructura(infraestructuraDTO.getEstratoInfraestructura().toUpperCase());
        infraestructura.setNumeroCuentaInfraestructura(infraestructuraDTO.getNumeroCuentaInfraestructura().toUpperCase());
        infraestructura.setNumeroSubcuentaInfraestructura(infraestructuraDTO.getNumeroSubcuentaInfraestructura().toUpperCase());
        infraestructura.setValorContableInfraestructura(infraestructuraDTO.getValorContableInfraestructura());
        infraestructura.setFechaHMSIngresoInfraestructura(infraestructuraDTO.getFechaHMSIngresoInfraestructura());
        infraestructura.setFechaHMSModificacionInfraestructura(infraestructuraDTO.getFechaHMSModificacionInfraestructura());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (infraestructuraDTO.getUnidadMilitarDTO() != null && infraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(infraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(infraestructura::setUnidadMilitar);
        }
        
        //MAPEAR SOCIEDAD UNIDAD CENTRALIZADORA RELACIONADA.
        if (infraestructuraDTO.getSociedadUnidadCentralizadoraDTO() != null && infraestructuraDTO.getSociedadUnidadCentralizadoraDTO().getIdSociedadUnidadCentralizadora() != null) {
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraFk = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(infraestructuraDTO.getSociedadUnidadCentralizadoraDTO().getIdSociedadUnidadCentralizadora());
           sociedadUnidadCentralizadoraFk.ifPresent(infraestructura::setSociedadUnidadCentralizadora);
        }
        
        //MAPEAR TIPO ESTRUCTURA INFRAESTRUCTURA RELACIONADA.
        if (infraestructuraDTO.getTipoEstructuraInfraestructuraDTO() != null && infraestructuraDTO.getTipoEstructuraInfraestructuraDTO().getIdTipoEstructuraInfraestructura() != null) {
           Optional<TipoEstructuraInfraestructura> tipoEstructuraInfraestructuraFk = tipoEstructuraInfraestructuraRepository.findByIdTipoEstructuraInfraestructura(infraestructuraDTO.getTipoEstructuraInfraestructuraDTO().getIdTipoEstructuraInfraestructura());
           tipoEstructuraInfraestructuraFk.ifPresent(infraestructura::setTipoEstructuraInfraestructura);
        }
        
        //MAPEAR FUNCIONALIDAD INFRAESTRUCTURA RELACIONADA.
        if (infraestructuraDTO.getFuncionalidadInfraestructuraDTO() != null && infraestructuraDTO.getFuncionalidadInfraestructuraDTO().getIdFuncionalidadInfraestructura() != null) {
           Optional<FuncionalidadInfraestructura> funcionalidadInfraestructuraFk = funcionalidadInfraestructuraRepository.findByIdFuncionalidadInfraestructura(infraestructuraDTO.getFuncionalidadInfraestructuraDTO().getIdFuncionalidadInfraestructura());
           funcionalidadInfraestructuraFk.ifPresent(infraestructura::setFuncionalidadInfraestructura);
        }
        
        //MAPEAR SEGURO RELACIONADO.
        if (infraestructuraDTO.getSeguroDTO() != null && infraestructuraDTO.getSeguroDTO().getIdSeguro() != null) {
           Optional<Seguro> seguroFk = seguroRepository.findByIdSeguro(infraestructuraDTO.getSeguroDTO().getIdSeguro());
           seguroFk.ifPresent(infraestructura::setSeguro);
        }
        
        //MAPEAR TERRENO RELACIONADO.
        if (infraestructuraDTO.getTerrenoDTO() != null && infraestructuraDTO.getTerrenoDTO().getIdTerreno() != null) {
           Optional<Terreno> terrenoFk = terrenoRepository.findByIdTerreno(infraestructuraDTO.getTerrenoDTO().getIdTerreno());
           terrenoFk.ifPresent(infraestructura::setTerreno);
        }
        
        return infraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param infraestructura
    * Recibe un objeto infraestructura para crear un DTO.
    * @return infraestructuraDTO
    */
    public InfraestructuraDTO infraestructuraDTO(Infraestructura infraestructura){
        InfraestructuraDTO infraestructuraDTO = new InfraestructuraDTO();
        infraestructuraDTO.setIdInfraestructura(infraestructura.getIdInfraestructura());
        infraestructuraDTO.setDenominacionInfraestructura(infraestructura.getDenominacionInfraestructura().toUpperCase());
        infraestructuraDTO.setNumeroInventarioInfraestructura(infraestructura.getNumeroInventarioInfraestructura());
        infraestructuraDTO.setNumeroActivoFijoInfraestructura(infraestructura.getNumeroActivoFijoInfraestructura());
        infraestructuraDTO.setCentroCostoUnidadMilitarInfraestructura(infraestructura.getCentroCostoUnidadMilitarInfraestructura());
        infraestructuraDTO.setPaisOrigenInfraestructura(infraestructura.getPaisOrigenInfraestructura().toUpperCase());
        infraestructuraDTO.setDepartamentoOEstadoOrigenInfraestructura(infraestructura.getDepartamentoOEstadoOrigenInfraestructura().toUpperCase());
        infraestructuraDTO.setCiudadOrigenInfraestructura(infraestructura.getCiudadOrigenInfraestructura().toUpperCase());
        infraestructuraDTO.setDireccionInfraestructura(infraestructura.getDireccionInfraestructura().toUpperCase());
        infraestructuraDTO.setFechaHMSAmortizacionInfraestructura(infraestructura.getFechaHMSAmortizacionInfraestructura());
        infraestructuraDTO.setFechaHMSAltaInfraestructura(infraestructura.getFechaHMSAltaInfraestructura());
        infraestructuraDTO.setNumeroLargoInfraestructura(infraestructura.getNumeroLargoInfraestructura().toUpperCase());
        infraestructuraDTO.setNombreUnidadMedidaLargoInfraestructura(infraestructura.getNombreUnidadMedidaLargoInfraestructura().toUpperCase());
        infraestructuraDTO.setNumeroAnchuraInfraestructura(infraestructura.getNumeroAnchuraInfraestructura().toUpperCase());
        infraestructuraDTO.setNombreUnidadMedidaAnchuraInfraestructura(infraestructura.getNombreUnidadMedidaAnchuraInfraestructura().toUpperCase());
        infraestructuraDTO.setNumeroProfundidadInfraestructura(infraestructura.getNumeroProfundidadInfraestructura().toUpperCase());
        infraestructuraDTO.setNombreUnidadMedidaProfundidadInfraestructura(infraestructura.getNombreUnidadMedidaProfundidadInfraestructura().toUpperCase());
        infraestructuraDTO.setNumeroPisosInfraestructura(infraestructura.getNumeroPisosInfraestructura().toUpperCase());
        infraestructuraDTO.setEstadoUsoInfraestructura(infraestructura.getEstadoUsoInfraestructura().toUpperCase());
        infraestructuraDTO.setLatitudInfraestructura(infraestructura.getLatitudInfraestructura().toUpperCase());
        infraestructuraDTO.setLongitudInfraestructura(infraestructura.getLongitudInfraestructura().toUpperCase());
        infraestructuraDTO.setNormaSismoresistenteInfraestructura(infraestructura.getNormaSismoresistenteInfraestructura().toUpperCase());
        infraestructuraDTO.setPropiedadHorizontalInfraestructura(infraestructura.getPropiedadHorizontalInfraestructura().toUpperCase());
        infraestructuraDTO.setDenominacionPosteriorInfraestructura(infraestructura.getDenominacionPosteriorInfraestructura().toUpperCase());
        infraestructuraDTO.setEstratoInfraestructura(infraestructura.getEstratoInfraestructura().toUpperCase());
        infraestructuraDTO.setNumeroCuentaInfraestructura(infraestructura.getNumeroCuentaInfraestructura().toUpperCase());
        infraestructuraDTO.setNumeroSubcuentaInfraestructura(infraestructura.getNumeroSubcuentaInfraestructura().toUpperCase());
        infraestructuraDTO.setValorContableInfraestructura(infraestructura.getValorContableInfraestructura());
        infraestructuraDTO.setFechaHMSIngresoInfraestructura(infraestructura.getFechaHMSIngresoInfraestructura());
        infraestructuraDTO.setFechaHMSModificacionInfraestructura(infraestructura.getFechaHMSModificacionInfraestructura());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (infraestructura.getUnidadMilitar() != null && infraestructura.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(infraestructura.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> infraestructuraDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        //MAPEAR SOCIEDAD UNIDAD CENTRALIZADORA RELACIONADA.
        if (infraestructura.getSociedadUnidadCentralizadora() != null && infraestructura.getSociedadUnidadCentralizadora().getIdSociedadUnidadCentralizadora() != null) {
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraFk = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(infraestructura.getSociedadUnidadCentralizadora().getIdSociedadUnidadCentralizadora());
           sociedadUnidadCentralizadoraFk.ifPresent(socUniCent -> infraestructuraDTO.setSociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(socUniCent)));
        }
        
        //MAPEAR TIPO ESTRUCTURA INFRAESTRUCTURA RELACIONADA.
        if (infraestructura.getTipoEstructuraInfraestructura() != null && infraestructura.getTipoEstructuraInfraestructura().getIdTipoEstructuraInfraestructura() != null) {
           Optional<TipoEstructuraInfraestructura> tipoEstructuraInfraestructuraFk = tipoEstructuraInfraestructuraRepository.findByIdTipoEstructuraInfraestructura(infraestructura.getTipoEstructuraInfraestructura().getIdTipoEstructuraInfraestructura());
           tipoEstructuraInfraestructuraFk.ifPresent(tipoEstInfra -> infraestructuraDTO.setTipoEstructuraInfraestructuraDTO(tipoEstructuraInfraestructuraDAO.tipoEstructuraInfraestructuraDTO(tipoEstInfra)));
        }
        
        //MAPEAR FUNCIONALIDAD INFRAESTRUCTURA RELACIONADA.
        if (infraestructura.getFuncionalidadInfraestructura() != null && infraestructura.getFuncionalidadInfraestructura().getIdFuncionalidadInfraestructura() != null) {
           Optional<FuncionalidadInfraestructura> funcionalidadInfraestructuraFk = funcionalidadInfraestructuraRepository.findByIdFuncionalidadInfraestructura(infraestructura.getFuncionalidadInfraestructura().getIdFuncionalidadInfraestructura());
           funcionalidadInfraestructuraFk.ifPresent(funcInfra -> infraestructuraDTO.setFuncionalidadInfraestructuraDTO(funcionalidadInfraestructuraDAO.funcionalidadInfraestructuraDTO(funcInfra)));
        }
        
        //MAPEAR SEGURO RELACIONADO.
        if (infraestructura.getSeguro() != null && infraestructura.getSeguro().getIdSeguro() != null) {
           Optional<Seguro> seguroFk = seguroRepository.findByIdSeguro(infraestructura.getSeguro().getIdSeguro());
           seguroFk.ifPresent(seg -> infraestructuraDTO.setSeguroDTO(seguroDAO.seguroDTO(seg)));
        }
        
        //MAPEAR TERRENO RELACIONADO.
        if (infraestructura.getTerreno() != null && infraestructura.getTerreno().getIdTerreno() != null) {
           Optional<Terreno> terrenoFk = terrenoRepository.findByIdTerreno(infraestructura.getTerreno().getIdTerreno());
           terrenoFk.ifPresent(terr -> infraestructuraDTO.setTerrenoDTO(terrenoDAO.terrenoDTO(terr)));
        }
        
        return infraestructuraDTO;
    }
}
