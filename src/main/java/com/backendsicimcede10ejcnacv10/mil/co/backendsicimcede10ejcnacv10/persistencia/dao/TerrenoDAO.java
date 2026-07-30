//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SociedadUnidadCentralizadora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Terreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EstadoTerrenoRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SociedadUnidadCentralizadoraRepository;
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
public class TerrenoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SociedadUnidadCentralizadoraRepository sociedadUnidadCentralizadoraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SociedadUnidadCentralizadoraDAO sociedadUnidadCentralizadoraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EstadoTerrenoRepository estadoTerrenoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EstadoTerrenoDAO estadoTerrenoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param terrenoDTO
    * Recibe un DTO para crear un objeto terreno.
    * @return terreno
    */
    public Terreno terreno(TerrenoDTO terrenoDTO){
        Terreno terreno = new Terreno();
        terreno.setIdTerreno(terrenoDTO.getIdTerreno());
        terreno.setDenominacionTerreno(terrenoDTO.getDenominacionTerreno().toUpperCase());
        terreno.setNumeroInventarioTerreno(terrenoDTO.getNumeroInventarioTerreno());
        terreno.setNumeroActivoFijoTerreno(terrenoDTO.getNumeroActivoFijoTerreno());
        terreno.setNumeroCatastralTerreno(terrenoDTO.getNumeroCatastralTerreno());
        terreno.setNumeroEscrituraTerreno(terrenoDTO.getNumeroEscrituraTerreno());
        terreno.setNumeroNotariaTerreno(terrenoDTO.getNumeroNotariaTerreno());
        terreno.setLugarUbicacionNotariaTerreno(terrenoDTO.getLugarUbicacionNotariaTerreno().toUpperCase());
        terreno.setFechaHMSMatriculaTerreno(terrenoDTO.getFechaHMSMatriculaTerreno());
        terreno.setPaisOrigenTerreno(terrenoDTO.getPaisOrigenTerreno().toUpperCase());
        terreno.setDepartamentoOEstadoOrigenTerreno(terrenoDTO.getDepartamentoOEstadoOrigenTerreno().toUpperCase());
        terreno.setCiudadOrigenTerreno(terrenoDTO.getCiudadOrigenTerreno().toUpperCase());
        terreno.setDireccionTerreno(terrenoDTO.getDireccionTerreno().toUpperCase());
        terreno.setLatitudTerreno(terrenoDTO.getLatitudTerreno().toUpperCase());
        terreno.setLongitudTerreno(terrenoDTO.getLongitudTerreno().toUpperCase());
        terreno.setNumeroAreaTerreno(terrenoDTO.getNumeroAreaTerreno().toUpperCase());
        terreno.setNombreUnidadMedidaTerreno(terrenoDTO.getNombreUnidadMedidaTerreno().toUpperCase());
        terreno.setSiONoExoneradoImpuestoPredialTerreno(terrenoDTO.getSiONoExoneradoImpuestoPredialTerreno().toUpperCase());
        terreno.setNumeroAnosExoneracionImpuestoPredialTerreno(terrenoDTO.getNumeroAnosExoneracionImpuestoPredialTerreno());
        terreno.setObservacionesTerreno(terrenoDTO.getObservacionesTerreno());
        terreno.setFechaHMSAltaTerreno(terrenoDTO.getFechaHMSAltaTerreno());
        terreno.setFechaHMSIngresoTerreno(terrenoDTO.getFechaHMSIngresoTerreno());
        terreno.setFechaHMSModificacionTerreno(terrenoDTO.getFechaHMSModificacionTerreno());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (terrenoDTO.getUnidadMilitarDTO() != null && terrenoDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(terrenoDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(terreno::setUnidadMilitar);
        }
        
        //MAPEAR SOCIEDAD UNIDAD CENTRALIZADORA RELACIONADA.
        if (terrenoDTO.getSociedadUnidadCentralizadoraDTO() != null && terrenoDTO.getSociedadUnidadCentralizadoraDTO().getIdSociedadUnidadCentralizadora() != null) {
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraFk = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(terrenoDTO.getSociedadUnidadCentralizadoraDTO().getIdSociedadUnidadCentralizadora());
           sociedadUnidadCentralizadoraFk.ifPresent(terreno::setSociedadUnidadCentralizadora);
        }
        
        //MAPEAR ESTADO TERRENO RELACIONADO.
        if (terrenoDTO.getEstadoTerrenoDTO() != null && terrenoDTO.getEstadoTerrenoDTO().getIdEstadoTerreno() != null) {
           Optional<EstadoTerreno> estadoTerrenoFk = estadoTerrenoRepository.findByIdEstadoTerreno(terrenoDTO.getEstadoTerrenoDTO().getIdEstadoTerreno());
           estadoTerrenoFk.ifPresent(terreno::setEstadoTerreno);
        }
        
        return terreno;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param terreno
    * Recibe un objeto terreno para crear un DTO.
    * @return terrenoDTO
    */
    public TerrenoDTO terrenoDTO(Terreno terreno){
        TerrenoDTO terrenoDTO = new TerrenoDTO();
        terrenoDTO.setIdTerreno(terreno.getIdTerreno());
        terrenoDTO.setDenominacionTerreno(terreno.getDenominacionTerreno().toUpperCase());
        terrenoDTO.setNumeroInventarioTerreno(terreno.getNumeroInventarioTerreno());
        terrenoDTO.setNumeroActivoFijoTerreno(terreno.getNumeroActivoFijoTerreno());
        terrenoDTO.setNumeroCatastralTerreno(terreno.getNumeroCatastralTerreno());
        terrenoDTO.setNumeroEscrituraTerreno(terreno.getNumeroEscrituraTerreno());
        terrenoDTO.setNumeroNotariaTerreno(terreno.getNumeroNotariaTerreno());
        terrenoDTO.setLugarUbicacionNotariaTerreno(terreno.getLugarUbicacionNotariaTerreno().toUpperCase());
        terrenoDTO.setFechaHMSMatriculaTerreno(terreno.getFechaHMSMatriculaTerreno());
        terrenoDTO.setPaisOrigenTerreno(terreno.getPaisOrigenTerreno().toUpperCase());
        terrenoDTO.setDepartamentoOEstadoOrigenTerreno(terreno.getDepartamentoOEstadoOrigenTerreno().toUpperCase());
        terrenoDTO.setCiudadOrigenTerreno(terreno.getCiudadOrigenTerreno().toUpperCase());
        terrenoDTO.setDireccionTerreno(terreno.getDireccionTerreno().toUpperCase());
        terrenoDTO.setLatitudTerreno(terreno.getLatitudTerreno().toUpperCase());
        terrenoDTO.setLongitudTerreno(terreno.getLongitudTerreno().toUpperCase());
        terrenoDTO.setNumeroAreaTerreno(terreno.getNumeroAreaTerreno().toUpperCase());
        terrenoDTO.setNombreUnidadMedidaTerreno(terreno.getNombreUnidadMedidaTerreno().toUpperCase());
        terrenoDTO.setSiONoExoneradoImpuestoPredialTerreno(terreno.getSiONoExoneradoImpuestoPredialTerreno().toUpperCase());
        terrenoDTO.setNumeroAnosExoneracionImpuestoPredialTerreno(terreno.getNumeroAnosExoneracionImpuestoPredialTerreno());
        terrenoDTO.setObservacionesTerreno(terreno.getObservacionesTerreno());
        terrenoDTO.setFechaHMSAltaTerreno(terreno.getFechaHMSAltaTerreno());
        terrenoDTO.setFechaHMSIngresoTerreno(terreno.getFechaHMSIngresoTerreno());
        terrenoDTO.setFechaHMSModificacionTerreno(terreno.getFechaHMSModificacionTerreno());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (terreno.getUnidadMilitar() != null && terreno.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(terreno.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> terrenoDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        //MAPEAR SOCIEDAD UNIDAD CENTRALIZADORA RELACIONADA.
        if (terreno.getSociedadUnidadCentralizadora() != null && terreno.getSociedadUnidadCentralizadora().getIdSociedadUnidadCentralizadora() != null) {
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraFk = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(terreno.getSociedadUnidadCentralizadora().getIdSociedadUnidadCentralizadora());
           sociedadUnidadCentralizadoraFk.ifPresent(socUniCent -> terrenoDTO.setSociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(socUniCent)));
        }
        
        //MAPEAR ESTADO TERRENO RELACIONADO.
        if (terreno.getEstadoTerreno() != null && terreno.getEstadoTerreno().getIdEstadoTerreno() != null) {
           Optional<EstadoTerreno> estadoTerrenoFk = estadoTerrenoRepository.findByIdEstadoTerreno(terreno.getEstadoTerreno().getIdEstadoTerreno());
           estadoTerrenoFk.ifPresent(estTerr -> terrenoDTO.setEstadoTerrenoDTO(estadoTerrenoDAO.estadoTerrenoDTO(estTerr)));
        }
        
        return terrenoDTO;
    }
}
