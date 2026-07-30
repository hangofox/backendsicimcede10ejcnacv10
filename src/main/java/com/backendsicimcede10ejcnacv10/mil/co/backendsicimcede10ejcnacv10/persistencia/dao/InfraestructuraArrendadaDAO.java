//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InfraestructuraArrendadaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InfraestructuraArrendada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProveedorProductoOServicio;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructuraArrendada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProveedorProductoOServicioRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEstructuraInfraestructuraArrendadaRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class InfraestructuraArrendadaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProveedorProductoOServicioRepository historialProveedorProductoOServicioRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProveedorProductoOServicioDAO historialProveedorProductoOServicioDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEstructuraInfraestructuraArrendadaRepository tipoEstructuraInfraestructuraArrendadaRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEstructuraInfraestructuraArrendadaDAO tipoEstructuraInfraestructuraArrendadaDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param infraestructuraArrendadaDTO
    * Recibe un DTO para crear un objeto infraestructuraArrendada.
    * @return infraestructuraArrendada
    */
    public InfraestructuraArrendada infraestructuraArrendada(InfraestructuraArrendadaDTO infraestructuraArrendadaDTO){
        InfraestructuraArrendada infraestructuraArrendada = new InfraestructuraArrendada();
        infraestructuraArrendada.setIdInfraestructuraArrendada(infraestructuraArrendadaDTO.getIdInfraestructuraArrendada());
        infraestructuraArrendada.setDenominacionInfraestructuraArrendada(infraestructuraArrendadaDTO.getDenominacionInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setPaisOrigenInfraestructuraArrendada(infraestructuraArrendadaDTO.getPaisOrigenInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setDepartamentoOEstadoOrigenInfraestructuraArrendada(infraestructuraArrendadaDTO.getDepartamentoOEstadoOrigenInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setCiudadOrigenInfraestructuraArrendada(infraestructuraArrendadaDTO.getCiudadOrigenInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setDireccionInfraestructuraArrendada(infraestructuraArrendadaDTO.getDireccionInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setNumeroLargoInfraestructuraArrendada(infraestructuraArrendadaDTO.getNumeroLargoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setNombreUnidadMedidaLargoInfraestructuraArrendada(infraestructuraArrendadaDTO.getNombreUnidadMedidaLargoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setNumeroAnchuraInfraestructuraArrendada(infraestructuraArrendadaDTO.getNumeroAnchuraInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setNombreUnidadMedidaAnchuraInfraestructuraArrendada(infraestructuraArrendadaDTO.getNombreUnidadMedidaAnchuraInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setNumeroProfundidadInfraestructuraArrendada(infraestructuraArrendadaDTO.getNumeroProfundidadInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setNombreUnidadMedidaProfundidadInfraestructuraArrendada(infraestructuraArrendadaDTO.getNombreUnidadMedidaProfundidadInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setNumeroPisosInfraestructuraArrendada(infraestructuraArrendadaDTO.getNumeroPisosInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setEstadoUsoInfraestructuraArrendada(infraestructuraArrendadaDTO.getEstadoUsoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setLatitudInfraestructuraArrendada(infraestructuraArrendadaDTO.getLatitudInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setLongitudInfraestructuraArrendada(infraestructuraArrendadaDTO.getLongitudInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setEstratoInfraestructuraArrendada(infraestructuraArrendadaDTO.getEstratoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendada.setFechaHMSIngresoInfraestructuraArrendada(infraestructuraArrendadaDTO.getFechaHMSIngresoInfraestructuraArrendada());
        infraestructuraArrendada.setFechaHMSModificacionInfraestructuraArrendada(infraestructuraArrendadaDTO.getFechaHMSModificacionInfraestructuraArrendada());
        
        //MAPEAR HISTORIAL DEL PROVEEDOR DEL PRODUCTO O SERVICIO RELACIONADO.
        if (infraestructuraArrendadaDTO.getHistorialProveedorProductoOServicioDTO() != null && infraestructuraArrendadaDTO.getHistorialProveedorProductoOServicioDTO().getIdHistorialProveedorProductoOServicio() != null) {
           Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioFk = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(infraestructuraArrendadaDTO.getHistorialProveedorProductoOServicioDTO().getIdHistorialProveedorProductoOServicio());
           historialProveedorProductoOServicioFk.ifPresent(infraestructuraArrendada::setHistorialProveedorProductoOServicio);
        }
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (infraestructuraArrendadaDTO.getUnidadMilitarDTO() != null && infraestructuraArrendadaDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(infraestructuraArrendadaDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(infraestructuraArrendada::setUnidadMilitar);
        }
        
        //MAPEAR TIPO DE ESTRUCTURA DE INFRAESTRUCTURA ARRENDADA RELACIONADA.
        if (infraestructuraArrendadaDTO.getTipoEstructuraInfraestructuraArrendadaDTO() != null && infraestructuraArrendadaDTO.getTipoEstructuraInfraestructuraArrendadaDTO().getIdTipoEstructuraInfraestructuraArrendada() != null) {
           Optional<TipoEstructuraInfraestructuraArrendada> tipoEstructuraInfraestructuraArrendadaFk = tipoEstructuraInfraestructuraArrendadaRepository.findByIdTipoEstructuraInfraestructuraArrendada(infraestructuraArrendadaDTO.getTipoEstructuraInfraestructuraArrendadaDTO().getIdTipoEstructuraInfraestructuraArrendada());
           tipoEstructuraInfraestructuraArrendadaFk.ifPresent(infraestructuraArrendada::setTipoEstructuraInfraestructuraArrendada);
        }
        
        return infraestructuraArrendada;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param infraestructuraArrendada
    * Recibe un objeto infraestructuraArrendada para crear un DTO.
    * @return infraestructuraArrendadaDTO
    */
    public InfraestructuraArrendadaDTO infraestructuraArrendadaDTO(InfraestructuraArrendada infraestructuraArrendada){
        InfraestructuraArrendadaDTO infraestructuraArrendadaDTO = new InfraestructuraArrendadaDTO();
        infraestructuraArrendadaDTO.setIdInfraestructuraArrendada(infraestructuraArrendada.getIdInfraestructuraArrendada());
        infraestructuraArrendadaDTO.setDenominacionInfraestructuraArrendada(infraestructuraArrendada.getDenominacionInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setPaisOrigenInfraestructuraArrendada(infraestructuraArrendada.getPaisOrigenInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setDepartamentoOEstadoOrigenInfraestructuraArrendada(infraestructuraArrendada.getDepartamentoOEstadoOrigenInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setCiudadOrigenInfraestructuraArrendada(infraestructuraArrendada.getCiudadOrigenInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setDireccionInfraestructuraArrendada(infraestructuraArrendada.getDireccionInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setNumeroLargoInfraestructuraArrendada(infraestructuraArrendada.getNumeroLargoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setNombreUnidadMedidaLargoInfraestructuraArrendada(infraestructuraArrendada.getNombreUnidadMedidaLargoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setNumeroAnchuraInfraestructuraArrendada(infraestructuraArrendada.getNumeroAnchuraInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setNombreUnidadMedidaAnchuraInfraestructuraArrendada(infraestructuraArrendada.getNombreUnidadMedidaAnchuraInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setNumeroProfundidadInfraestructuraArrendada(infraestructuraArrendada.getNumeroProfundidadInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setNombreUnidadMedidaProfundidadInfraestructuraArrendada(infraestructuraArrendada.getNombreUnidadMedidaProfundidadInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setNumeroPisosInfraestructuraArrendada(infraestructuraArrendada.getNumeroPisosInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setEstadoUsoInfraestructuraArrendada(infraestructuraArrendada.getEstadoUsoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setLatitudInfraestructuraArrendada(infraestructuraArrendada.getLatitudInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setLongitudInfraestructuraArrendada(infraestructuraArrendada.getLongitudInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setEstratoInfraestructuraArrendada(infraestructuraArrendada.getEstratoInfraestructuraArrendada().toUpperCase());
        infraestructuraArrendadaDTO.setFechaHMSIngresoInfraestructuraArrendada(infraestructuraArrendada.getFechaHMSIngresoInfraestructuraArrendada());
        infraestructuraArrendadaDTO.setFechaHMSModificacionInfraestructuraArrendada(infraestructuraArrendada.getFechaHMSModificacionInfraestructuraArrendada());
        
        //MAPEAR HISTORIAL DEL PROVEEDOR DE PRODUCTO O SERVICIO RELACIONADO.
        if (infraestructuraArrendada.getHistorialProveedorProductoOServicio() != null && infraestructuraArrendada.getHistorialProveedorProductoOServicio().getIdHistorialProveedorProductoOServicio() != null) {
           Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioFk = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(infraestructuraArrendada.getHistorialProveedorProductoOServicio().getIdHistorialProveedorProductoOServicio());
           historialProveedorProductoOServicioFk.ifPresent(provProdServ -> infraestructuraArrendadaDTO.setHistorialProveedorProductoOServicioDTO(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(provProdServ)));
        }
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (infraestructuraArrendada.getUnidadMilitar() != null && infraestructuraArrendada.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(infraestructuraArrendada.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> infraestructuraArrendadaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        //MAPEAR TIPO DE ESTRUCTURA DE INFRAESTRUCTURA ARRENDADA RELACIONADA.
        if (infraestructuraArrendada.getTipoEstructuraInfraestructuraArrendada() != null && infraestructuraArrendada.getTipoEstructuraInfraestructuraArrendada().getIdTipoEstructuraInfraestructuraArrendada() != null) {
           Optional<TipoEstructuraInfraestructuraArrendada> tipoEstructuraInfraestructuraArrendadaFk = tipoEstructuraInfraestructuraArrendadaRepository.findByIdTipoEstructuraInfraestructuraArrendada(infraestructuraArrendada.getTipoEstructuraInfraestructuraArrendada().getIdTipoEstructuraInfraestructuraArrendada());
           tipoEstructuraInfraestructuraArrendadaFk.ifPresent(tipoEstInfraArr -> infraestructuraArrendadaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendadaDTO(tipoEstInfraArr)));
        }
        
        return infraestructuraArrendadaDTO;
    }
}
