//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SociedadUnidadCentralizadora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoAltaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ElementoSubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SociedadUnidadCentralizadoraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoAltaEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SubclasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ElementoSubclasificacionEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class EquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SociedadUnidadCentralizadoraRepository sociedadUnidadCentralizadoraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SociedadUnidadCentralizadoraDAO sociedadUnidadCentralizadoraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ClasificacionEquipoIngenieroRepository clasificacionEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ClasificacionEquipoIngenieroDAO clasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SubclasificacionEquipoIngenieroRepository subclasificacionEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SubclasificacionEquipoIngenieroDAO subclasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ElementoSubclasificacionEquipoIngenieroRepository elementoSubclasificacionEquipoIngenieroRepository;
    
    @Lazy//ROMPE LA REFERENCIA CIRCULAR CON elementoSubclasificacionEquipoIngenieroDAO.
    @Autowired//INYECTAMOS EL DAO.
    private ElementoSubclasificacionEquipoIngenieroDAO elementoSubclasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoAltaEquipoIngenieroRepository tipoAltaEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoAltaEquipoIngenieroDAO tipoAltaEquipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/03/2026.
    * @param equipoIngenieroDTO
    * Recibe un DTO para crear un objeto equipoIngeniero.
    * @return equipoIngeniero
    */
    public EquipoIngeniero equipoIngeniero(EquipoIngenieroDTO equipoIngenieroDTO){
        EquipoIngeniero equipoIngeniero = new EquipoIngeniero();
        equipoIngeniero.setIdEquipoIngeniero(equipoIngenieroDTO.getIdEquipoIngeniero());
        equipoIngeniero.setDenominacionEquipoIngeniero(equipoIngenieroDTO.getDenominacionEquipoIngeniero().toUpperCase());
        equipoIngeniero.setNumeroInventarioEquipoIngeniero(equipoIngenieroDTO.getNumeroInventarioEquipoIngeniero());
        equipoIngeniero.setNumeroActivoFijoEquipoIngeniero(equipoIngenieroDTO.getNumeroActivoFijoEquipoIngeniero());
        equipoIngeniero.setCentroCostoUnidadMilitarEquipoIngeniero(equipoIngenieroDTO.getCentroCostoUnidadMilitarEquipoIngeniero().toUpperCase());
        equipoIngeniero.setMarcaEquipoIngeniero(equipoIngenieroDTO.getMarcaEquipoIngeniero().toUpperCase());
        equipoIngeniero.setModeloEquipoIngeniero(equipoIngenieroDTO.getModeloEquipoIngeniero().toUpperCase());
        equipoIngeniero.setCapacidadEquipoIngeniero(equipoIngenieroDTO.getCapacidadEquipoIngeniero().toUpperCase());
        equipoIngeniero.setEmpadronamientoEquipoIngeniero(equipoIngenieroDTO.getEmpadronamientoEquipoIngeniero().toUpperCase());
        equipoIngeniero.setNumeroPlacaEquipoIngeniero(equipoIngenieroDTO.getNumeroPlacaEquipoIngeniero());
        equipoIngeniero.setFechaHMSMatriculaEquipoIngeniero(equipoIngenieroDTO.getFechaHMSMatriculaEquipoIngeniero());
        equipoIngeniero.setFechaHMSAltaEquipoIngeniero(equipoIngenieroDTO.getFechaHMSAltaEquipoIngeniero());
        equipoIngeniero.setValorAdquisicionEquipoIngeniero(equipoIngenieroDTO.getValorAdquisicionEquipoIngeniero());
        equipoIngeniero.setValorContableEquipoIngeniero(equipoIngenieroDTO.getValorContableEquipoIngeniero());
        equipoIngeniero.setValorDepreciacionEquipoIngeniero(equipoIngenieroDTO.getValorDepreciacionEquipoIngeniero());
        equipoIngeniero.setObservacionesEquipoIngeniero(equipoIngenieroDTO.getObservacionesEquipoIngeniero());
        equipoIngeniero.setFechaHMSIngresoEquipoIngeniero(equipoIngenieroDTO.getFechaHMSIngresoEquipoIngeniero());
        equipoIngeniero.setFechaHMSModificacionEquipoIngeniero(equipoIngenieroDTO.getFechaHMSModificacionEquipoIngeniero());
        equipoIngeniero.setEstadoUsoEquipoIngeniero(equipoIngenieroDTO.getEstadoUsoEquipoIngeniero().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (equipoIngenieroDTO.getUnidadMilitarDTO() != null && equipoIngenieroDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(equipoIngenieroDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(equipoIngeniero::setUnidadMilitar);
        }
        
        //MAPEAR SOCIEDAD UNIDAD CENTRALIZADORA RELACIONADA.
        if (equipoIngenieroDTO.getSociedadUnidadCentralizadoraDTO() != null && equipoIngenieroDTO.getSociedadUnidadCentralizadoraDTO().getIdSociedadUnidadCentralizadora() != null) {
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraFk = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(equipoIngenieroDTO.getSociedadUnidadCentralizadoraDTO().getIdSociedadUnidadCentralizadora());
           sociedadUnidadCentralizadoraFk.ifPresent(equipoIngeniero::setSociedadUnidadCentralizadora);
        }
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (equipoIngenieroDTO.getClasificacionEquipoIngenieroDTO() != null && equipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(equipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(equipoIngeniero::setClasificacionEquipoIngeniero);
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (equipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO() != null && equipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(equipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(equipoIngeniero::setSubclasificacionEquipoIngeniero);
        }
        
        //MAPEAR ELEMENTO SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADO.
        if (equipoIngenieroDTO.getElementoSubclasificacionEquipoIngenieroDTO() != null && equipoIngenieroDTO.getElementoSubclasificacionEquipoIngenieroDTO().getIdElementoSubclasificacionEquipoIngeniero() != null) {
           Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroFk = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(equipoIngenieroDTO.getElementoSubclasificacionEquipoIngenieroDTO().getIdElementoSubclasificacionEquipoIngeniero());
           elementoSubclasificacionEquipoIngenieroFk.ifPresent(equipoIngeniero::setElementoSubclasificacionEquipoIngeniero);
        }
        
        //MAPEAR TIPO DE ALTA DE EQUIPO DE INGENIERO RELACIONADO.
        if (equipoIngenieroDTO.getTipoAltaEquipoIngenieroDTO() != null && equipoIngenieroDTO.getTipoAltaEquipoIngenieroDTO().getIdTipoAltaEquipoIngeniero() != null) {
           Optional<TipoAltaEquipoIngeniero> tipoAltaEquipoIngenieroFk = tipoAltaEquipoIngenieroRepository.findByIdTipoAltaEquipoIngeniero(equipoIngenieroDTO.getTipoAltaEquipoIngenieroDTO().getIdTipoAltaEquipoIngeniero());
           tipoAltaEquipoIngenieroFk.ifPresent(equipoIngeniero::setTipoAltaEquipoIngeniero);
        }
        
        return equipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/03/2026.
    * @param equipoIngeniero
    * Recibe un objeto equipoIngeniero para crear un DTO.
    * @return equipoIngenieroDTO
    */
    public EquipoIngenieroDTO equipoIngenieroDTO(EquipoIngeniero equipoIngeniero){
        EquipoIngenieroDTO equipoIngenieroDTO = new EquipoIngenieroDTO();
        equipoIngenieroDTO.setIdEquipoIngeniero(equipoIngeniero.getIdEquipoIngeniero());
        equipoIngenieroDTO.setDenominacionEquipoIngeniero(equipoIngeniero.getDenominacionEquipoIngeniero().toUpperCase());
        equipoIngenieroDTO.setNumeroInventarioEquipoIngeniero(equipoIngeniero.getNumeroInventarioEquipoIngeniero());
        equipoIngenieroDTO.setNumeroActivoFijoEquipoIngeniero(equipoIngeniero.getNumeroActivoFijoEquipoIngeniero());
        equipoIngenieroDTO.setCentroCostoUnidadMilitarEquipoIngeniero(equipoIngeniero.getCentroCostoUnidadMilitarEquipoIngeniero().toUpperCase());
        equipoIngenieroDTO.setMarcaEquipoIngeniero(equipoIngeniero.getMarcaEquipoIngeniero().toUpperCase());
        equipoIngenieroDTO.setModeloEquipoIngeniero(equipoIngeniero.getModeloEquipoIngeniero().toUpperCase());
        equipoIngenieroDTO.setCapacidadEquipoIngeniero(equipoIngeniero.getCapacidadEquipoIngeniero().toUpperCase());
        equipoIngenieroDTO.setEmpadronamientoEquipoIngeniero(equipoIngeniero.getEmpadronamientoEquipoIngeniero().toUpperCase());
        equipoIngenieroDTO.setNumeroPlacaEquipoIngeniero(equipoIngeniero.getNumeroPlacaEquipoIngeniero());
        equipoIngenieroDTO.setFechaHMSMatriculaEquipoIngeniero(equipoIngeniero.getFechaHMSMatriculaEquipoIngeniero());
        equipoIngenieroDTO.setFechaHMSAltaEquipoIngeniero(equipoIngeniero.getFechaHMSAltaEquipoIngeniero());
        equipoIngenieroDTO.setValorAdquisicionEquipoIngeniero(equipoIngeniero.getValorAdquisicionEquipoIngeniero());
        equipoIngenieroDTO.setValorContableEquipoIngeniero(equipoIngeniero.getValorContableEquipoIngeniero());
        equipoIngenieroDTO.setValorDepreciacionEquipoIngeniero(equipoIngeniero.getValorDepreciacionEquipoIngeniero());
        equipoIngenieroDTO.setObservacionesEquipoIngeniero(equipoIngeniero.getObservacionesEquipoIngeniero());
        equipoIngenieroDTO.setFechaHMSIngresoEquipoIngeniero(equipoIngeniero.getFechaHMSIngresoEquipoIngeniero());
        equipoIngenieroDTO.setFechaHMSModificacionEquipoIngeniero(equipoIngeniero.getFechaHMSModificacionEquipoIngeniero());
        equipoIngenieroDTO.setEstadoUsoEquipoIngeniero(equipoIngeniero.getEstadoUsoEquipoIngeniero().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (equipoIngeniero.getUnidadMilitar() != null && equipoIngeniero.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(equipoIngeniero.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> equipoIngenieroDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        //MAPEAR SOCIEDAD UNIDAD CENTRALIZADORA RELACIONADA.
        if (equipoIngeniero.getSociedadUnidadCentralizadora() != null && equipoIngeniero.getSociedadUnidadCentralizadora().getIdSociedadUnidadCentralizadora() != null) {
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraFk = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(equipoIngeniero.getSociedadUnidadCentralizadora().getIdSociedadUnidadCentralizadora());
           sociedadUnidadCentralizadoraFk.ifPresent(socUniCent -> equipoIngenieroDTO.setSociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(socUniCent)));
        }
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (equipoIngeniero.getClasificacionEquipoIngeniero() != null && equipoIngeniero.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(equipoIngeniero.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(clasifEqIng -> equipoIngenieroDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasifEqIng)));
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (equipoIngeniero.getSubclasificacionEquipoIngeniero() != null && equipoIngeniero.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(equipoIngeniero.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(subclasifEqIng -> equipoIngenieroDTO.setSubclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasifEqIng)));
        }
        
        //MAPEAR ELEMENTO SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADO.
        if (equipoIngeniero.getElementoSubclasificacionEquipoIngeniero() != null && equipoIngeniero.getElementoSubclasificacionEquipoIngeniero().getIdElementoSubclasificacionEquipoIngeniero() != null) {
           Optional<ElementoSubclasificacionEquipoIngeniero> elementoSubclasificacionEquipoIngenieroFk = elementoSubclasificacionEquipoIngenieroRepository.findByIdElementoSubclasificacionEquipoIngeniero(equipoIngeniero.getElementoSubclasificacionEquipoIngeniero().getIdElementoSubclasificacionEquipoIngeniero());
           elementoSubclasificacionEquipoIngenieroFk.ifPresent(elemSubclasifEqIng -> equipoIngenieroDTO.setElementoSubclasificacionEquipoIngenieroDTO(elementoSubclasificacionEquipoIngenieroDAO.elementoSubclasificacionEquipoIngenieroDTO(elemSubclasifEqIng)));
        }
        
        //MAPEAR TIPO DE ALTA DE EQUIPO DE INGENIERO RELACIONADO.
        if (equipoIngeniero.getTipoAltaEquipoIngeniero() != null && equipoIngeniero.getTipoAltaEquipoIngeniero().getIdTipoAltaEquipoIngeniero() != null) {
           Optional<TipoAltaEquipoIngeniero> tipoAltaEquipoIngenieroFk = tipoAltaEquipoIngenieroRepository.findByIdTipoAltaEquipoIngeniero(equipoIngeniero.getTipoAltaEquipoIngeniero().getIdTipoAltaEquipoIngeniero());
           tipoAltaEquipoIngenieroFk.ifPresent(tipoAltEquIng -> equipoIngenieroDTO.setTipoAltaEquipoIngenieroDTO(tipoAltaEquipoIngenieroDAO.tipoAltaEquipoIngenieroDTO(tipoAltEquIng)));
        }
        
        return equipoIngenieroDTO;
    }
}
