//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ContribucionSaneamientoBasicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ContribucionSaneamientoBasico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProveedorProductoOServicio;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContribucionSaneamientoBasico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProveedorProductoOServicioRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoContribucionSaneamientoBasicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ContribucionSaneamientoBasicoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProveedorProductoOServicioRepository historialProveedorProductoOServicioRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialProveedorProductoOServicioDAO historialProveedorProductoOServicioDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoContribucionSaneamientoBasicoRepository tipoContribucionSaneamientoBasicoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoContribucionSaneamientoBasicoDAO tipoContribucionSaneamientoBasicoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param contribucionSaneamientoBasicoDTO
    * Recibe un DTO para crear un objeto contribucionSaneamientoBasico.
    * @return contribucionSaneamientoBasico
    */
    public ContribucionSaneamientoBasico contribucionSaneamientoBasico(ContribucionSaneamientoBasicoDTO contribucionSaneamientoBasicoDTO){
        ContribucionSaneamientoBasico contribucionSaneamientoBasico = new ContribucionSaneamientoBasico();
        contribucionSaneamientoBasico.setIdContribucionSaneamientoBasico(contribucionSaneamientoBasicoDTO.getIdContribucionSaneamientoBasico());
        contribucionSaneamientoBasico.setValorPagoContribucionSaneamientoBasico(contribucionSaneamientoBasicoDTO.getValorPagoContribucionSaneamientoBasico());
        contribucionSaneamientoBasico.setFechaHMSContribucionSaneamientoBasico(contribucionSaneamientoBasicoDTO.getFechaHMSContribucionSaneamientoBasico());
        contribucionSaneamientoBasico.setNombreArchivoDocumentoAnexoFactContribSanBas(contribucionSaneamientoBasicoDTO.getNombreArchivoDocumentoAnexoFactContribSanBas());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (contribucionSaneamientoBasicoDTO.getInfraestructuraDTO() != null && contribucionSaneamientoBasicoDTO.getInfraestructuraDTO().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(contribucionSaneamientoBasicoDTO.getInfraestructuraDTO().getIdInfraestructura());
           infraestructuraFk.ifPresent(contribucionSaneamientoBasico::setInfraestructura);
        }
        
        //MAPEAR HISTORIAL DE PROVEEDOR DE PRODUCTO O SERVICIO RELACIONADO.
        if (contribucionSaneamientoBasicoDTO.getHistorialProveedorProductoOServicioDTO() != null && contribucionSaneamientoBasicoDTO.getHistorialProveedorProductoOServicioDTO().getIdHistorialProveedorProductoOServicio() != null) {
           Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioFk = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(contribucionSaneamientoBasicoDTO.getHistorialProveedorProductoOServicioDTO().getIdHistorialProveedorProductoOServicio());
           historialProveedorProductoOServicioFk.ifPresent(contribucionSaneamientoBasico::setHistorialProveedorProductoOServicio);
        }
        
        //MAPEAR TIPO DE CONTRIBUCIÓN DE SANEAMIENTO BÁSICO RELACIONADO.
        if (contribucionSaneamientoBasicoDTO.getTipoContribucionSaneamientoBasicoDTO() != null && contribucionSaneamientoBasicoDTO.getTipoContribucionSaneamientoBasicoDTO().getIdTipoContribucionSaneamientoBasico() != null) {
           Optional<TipoContribucionSaneamientoBasico> tipoContribucionSaneamientoBasicoFk = tipoContribucionSaneamientoBasicoRepository.findByIdTipoContribucionSaneamientoBasico(contribucionSaneamientoBasicoDTO.getTipoContribucionSaneamientoBasicoDTO().getIdTipoContribucionSaneamientoBasico());
           tipoContribucionSaneamientoBasicoFk.ifPresent(contribucionSaneamientoBasico::setTipoContribucionSaneamientoBasico);
        }
        
        return contribucionSaneamientoBasico;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param contribucionSaneamientoBasico
    * Recibe un objeto contribucionSaneamientoBasico para crear un DTO.
    * @return contribucionSaneamientoBasicoDTO
    */
    public ContribucionSaneamientoBasicoDTO contribucionSaneamientoBasicoDTO(ContribucionSaneamientoBasico contribucionSaneamientoBasico){
        ContribucionSaneamientoBasicoDTO contribucionSaneamientoBasicoDTO = new ContribucionSaneamientoBasicoDTO();
        contribucionSaneamientoBasicoDTO.setIdContribucionSaneamientoBasico(contribucionSaneamientoBasico.getIdContribucionSaneamientoBasico());
        contribucionSaneamientoBasicoDTO.setValorPagoContribucionSaneamientoBasico(contribucionSaneamientoBasico.getValorPagoContribucionSaneamientoBasico());
        contribucionSaneamientoBasicoDTO.setFechaHMSContribucionSaneamientoBasico(contribucionSaneamientoBasico.getFechaHMSContribucionSaneamientoBasico());
        contribucionSaneamientoBasicoDTO.setNombreArchivoDocumentoAnexoFactContribSanBas(contribucionSaneamientoBasico.getNombreArchivoDocumentoAnexoFactContribSanBas());
        
        //MAPEAR INFRAESTRUCTURA RELACIONADA.
        if (contribucionSaneamientoBasico.getInfraestructura() != null && contribucionSaneamientoBasico.getInfraestructura().getIdInfraestructura() != null) {
           Optional<Infraestructura> infraestructuraFk = infraestructuraRepository.findByIdInfraestructura(contribucionSaneamientoBasico.getInfraestructura().getIdInfraestructura());
           infraestructuraFk.ifPresent(infra -> contribucionSaneamientoBasicoDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infra)));
        }
        
        //MAPEAR HISTORIAL DE PROVEEDOR DE PRODUCTO O SERVICIO RELACIONADO.
        if (contribucionSaneamientoBasico.getHistorialProveedorProductoOServicio() != null && contribucionSaneamientoBasico.getHistorialProveedorProductoOServicio().getIdHistorialProveedorProductoOServicio() != null) {
           Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioFk = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(contribucionSaneamientoBasico.getHistorialProveedorProductoOServicio().getIdHistorialProveedorProductoOServicio());
           historialProveedorProductoOServicioFk.ifPresent(prov -> contribucionSaneamientoBasicoDTO.setHistorialProveedorProductoOServicioDTO(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(prov)));
        }
        
        //MAPEAR TIPO DE CONTRIBUCIÓN DE SANEAMIENTO BÁSICO RELACIONADO.
        if (contribucionSaneamientoBasico.getTipoContribucionSaneamientoBasico() != null && contribucionSaneamientoBasico.getTipoContribucionSaneamientoBasico().getIdTipoContribucionSaneamientoBasico() != null) {
           Optional<TipoContribucionSaneamientoBasico> tipoContribucionSaneamientoBasicoFk = tipoContribucionSaneamientoBasicoRepository.findByIdTipoContribucionSaneamientoBasico(contribucionSaneamientoBasico.getTipoContribucionSaneamientoBasico().getIdTipoContribucionSaneamientoBasico());
           tipoContribucionSaneamientoBasicoFk.ifPresent(tipContrib -> contribucionSaneamientoBasicoDTO.setTipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasicoDTO(tipContrib)));
        }
        
        return contribucionSaneamientoBasicoDTO;
    }
}
