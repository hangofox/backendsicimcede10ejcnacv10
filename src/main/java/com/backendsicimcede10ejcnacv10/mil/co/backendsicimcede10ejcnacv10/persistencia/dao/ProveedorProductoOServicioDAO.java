//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProveedorProductoOServicioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProveedorProductoOServicio;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoIdentificacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProveedorProductoOServicioDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoIdentificacionRepository tipoDocumentoIdentificacionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoIdentificacionDAO tipoDocumentoIdentificacionDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param proveedorProductoOServicioDTO
    * Recibe un DTO para crear un objeto proveedorProductoOServicio.
    * @return proveedorProductoOServicio
    */
    public ProveedorProductoOServicio proveedorProductoOServicio(ProveedorProductoOServicioDTO proveedorProductoOServicioDTO){
        ProveedorProductoOServicio proveedorProductoOServicio = new ProveedorProductoOServicio();
        proveedorProductoOServicio.setIdProveedorProductoOServicio(proveedorProductoOServicioDTO.getIdProveedorProductoOServicio());
        proveedorProductoOServicio.setNumeroDocumentoIdentificacionProvProdOServ(proveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ());
        proveedorProductoOServicio.setLugarExpedicionDocumentoIdentificacionProvProdOServ(proveedorProductoOServicioDTO.getLugarExpedicionDocumentoIdentificacionProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setNombresProvProdOServ(proveedorProductoOServicioDTO.getNombresProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setPrimerApellidoProvProdOServ(proveedorProductoOServicioDTO.getPrimerApellidoProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setSegundoApellidoProvProdOServ(proveedorProductoOServicioDTO.getSegundoApellidoProvProdOServ());
        proveedorProductoOServicio.setDireccionProvProdOServ(proveedorProductoOServicioDTO.getDireccionProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setTelefonoProvProdOServ(proveedorProductoOServicioDTO.getTelefonoProvProdOServ());
        proveedorProductoOServicio.setMovilProvProdOServ(proveedorProductoOServicioDTO.getMovilProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setCorreoElectronicoPersonalProvProdOServ(proveedorProductoOServicioDTO.getCorreoElectronicoPersonalProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setCorreoElectronicoInstitucionalProvProdOServ(proveedorProductoOServicioDTO.getCorreoElectronicoInstitucionalProvProdOServ());
        proveedorProductoOServicio.setPaisOrigenProvProdOServ(proveedorProductoOServicioDTO.getPaisOrigenProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setDepartamentoOEstadoOrigenProvProdOServ(proveedorProductoOServicioDTO.getDepartamentoOEstadoOrigenProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setCiudadOrigenProvProdOServ(proveedorProductoOServicioDTO.getCiudadOrigenProvProdOServ().toUpperCase());
        proveedorProductoOServicio.setFechaHMSIngresoProvProdOServ(proveedorProductoOServicioDTO.getFechaHMSIngresoProvProdOServ());
        proveedorProductoOServicio.setFechaHMSModificacionProvProdOServ(proveedorProductoOServicioDTO.getFechaHMSModificacionProvProdOServ());
        proveedorProductoOServicio.setEstadoProvProdOServ(proveedorProductoOServicioDTO.getEstadoProvProdOServ().toUpperCase());

        //MAPEAR TIPO DOCUMENTO DE IDENTIFICACIÓN RELACIONADO.
        if (proveedorProductoOServicioDTO.getTipoDocumentoIdentificacionDTO() != null && proveedorProductoOServicioDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(proveedorProductoOServicioDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(proveedorProductoOServicio::setTipoDocumentoIdentificacion);
        }
        
        return proveedorProductoOServicio;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 27/03/2026.
    * @param proveedorProductoOServicio
    * Recibe un objeto proveedorProductoOServicio para crear un DTO.
    * @return proveedorProductoOServicioDTO
    */
    public ProveedorProductoOServicioDTO proveedorProductoOServicioDTO(ProveedorProductoOServicio proveedorProductoOServicio){
        ProveedorProductoOServicioDTO proveedorProductoOServicioDTO = new ProveedorProductoOServicioDTO();
        proveedorProductoOServicioDTO.setIdProveedorProductoOServicio(proveedorProductoOServicio.getIdProveedorProductoOServicio());
        proveedorProductoOServicioDTO.setNumeroDocumentoIdentificacionProvProdOServ(proveedorProductoOServicio.getNumeroDocumentoIdentificacionProvProdOServ());
        proveedorProductoOServicioDTO.setLugarExpedicionDocumentoIdentificacionProvProdOServ(proveedorProductoOServicio.getLugarExpedicionDocumentoIdentificacionProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setNombresProvProdOServ(proveedorProductoOServicio.getNombresProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setPrimerApellidoProvProdOServ(proveedorProductoOServicio.getPrimerApellidoProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setSegundoApellidoProvProdOServ(proveedorProductoOServicio.getSegundoApellidoProvProdOServ());
        proveedorProductoOServicioDTO.setDireccionProvProdOServ(proveedorProductoOServicio.getDireccionProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setTelefonoProvProdOServ(proveedorProductoOServicio.getTelefonoProvProdOServ());
        proveedorProductoOServicioDTO.setMovilProvProdOServ(proveedorProductoOServicio.getMovilProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setCorreoElectronicoPersonalProvProdOServ(proveedorProductoOServicio.getCorreoElectronicoPersonalProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setCorreoElectronicoInstitucionalProvProdOServ(proveedorProductoOServicio.getCorreoElectronicoInstitucionalProvProdOServ());
        proveedorProductoOServicioDTO.setPaisOrigenProvProdOServ(proveedorProductoOServicio.getPaisOrigenProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setDepartamentoOEstadoOrigenProvProdOServ(proveedorProductoOServicio.getDepartamentoOEstadoOrigenProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setCiudadOrigenProvProdOServ(proveedorProductoOServicio.getCiudadOrigenProvProdOServ().toUpperCase());
        proveedorProductoOServicioDTO.setFechaHMSIngresoProvProdOServ(proveedorProductoOServicio.getFechaHMSIngresoProvProdOServ());
        proveedorProductoOServicioDTO.setFechaHMSModificacionProvProdOServ(proveedorProductoOServicio.getFechaHMSModificacionProvProdOServ());
        proveedorProductoOServicioDTO.setEstadoProvProdOServ(proveedorProductoOServicio.getEstadoProvProdOServ().toUpperCase());

        //MAPEAR TIPO DOCUMENTO DE IDENTIFICACIÓN RELACIONADO.
        if (proveedorProductoOServicio.getTipoDocumentoIdentificacion() != null && proveedorProductoOServicio.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(proveedorProductoOServicio.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(tipoDocIdent -> proveedorProductoOServicioDTO.setTipoDocumentoIdentificacionDTO(tipoDocumentoIdentificacionDAO.tipoDocumentoIdentificacionDTO(tipoDocIdent)));
        }
        
        return proveedorProductoOServicioDTO;
    }
}
