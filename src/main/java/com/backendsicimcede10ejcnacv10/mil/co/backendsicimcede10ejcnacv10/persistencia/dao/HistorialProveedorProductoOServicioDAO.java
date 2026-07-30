//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProveedorProductoOServicioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProveedorProductoOServicio;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 02/06/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialProveedorProductoOServicioDAO {
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 02/06/2026.
    * @param historialProveedorProductoOServicioDTO
    * Recibe un DTO para crear un objeto historialProveedorProductoOServicio.
    * @return historialProveedorProductoOServicio
    */
    public HistorialProveedorProductoOServicio historialProveedorProductoOServicio(HistorialProveedorProductoOServicioDTO historialProveedorProductoOServicioDTO){
        HistorialProveedorProductoOServicio historialProveedorProductoOServicio = new HistorialProveedorProductoOServicio();
        historialProveedorProductoOServicio.setIdHistorialProveedorProductoOServicio(historialProveedorProductoOServicioDTO.getIdHistorialProveedorProductoOServicio());
        historialProveedorProductoOServicio.setNumRegHistorialProveedorProductoOServicio(historialProveedorProductoOServicioDTO.getNumRegHistorialProveedorProductoOServicio().toUpperCase());
        historialProveedorProductoOServicio.setSiglaOAcronimoUnidadMilitar(historialProveedorProductoOServicioDTO.getSiglaOAcronimoUnidadMilitar().toUpperCase());
        historialProveedorProductoOServicio.setNombreTipoDocumentoIdentificacion(historialProveedorProductoOServicioDTO.getNombreTipoDocumentoIdentificacion().toUpperCase());
        historialProveedorProductoOServicio.setNumeroDocumentoIdentificacionProvProdOServ(historialProveedorProductoOServicioDTO.getNumeroDocumentoIdentificacionProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setLugarExpedicionDocumentoIdentificacionProvProdOServ(historialProveedorProductoOServicioDTO.getLugarExpedicionDocumentoIdentificacionProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setNombresProvProdOServ(historialProveedorProductoOServicioDTO.getNombresProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setPrimerApellidoProvProdOServ(historialProveedorProductoOServicioDTO.getPrimerApellidoProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setSegundoApellidoProvProdOServ(historialProveedorProductoOServicioDTO.getSegundoApellidoProvProdOServ());
        historialProveedorProductoOServicio.setDireccionProvProdOServ(historialProveedorProductoOServicioDTO.getDireccionProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setTelefonoProvProdOServ(historialProveedorProductoOServicioDTO.getTelefonoProvProdOServ());
        historialProveedorProductoOServicio.setMovilProvProdOServ(historialProveedorProductoOServicioDTO.getMovilProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setCorreoElectronicoPersonalProvProdOServ(historialProveedorProductoOServicioDTO.getCorreoElectronicoPersonalProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setCorreoElectronicoInstitucionalProvProdOServ(historialProveedorProductoOServicioDTO.getCorreoElectronicoInstitucionalProvProdOServ());
        historialProveedorProductoOServicio.setPaisOrigenProvProdOServ(historialProveedorProductoOServicioDTO.getPaisOrigenProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setDepartamentoOEstadoOrigenProvProdOServ(historialProveedorProductoOServicioDTO.getDepartamentoOEstadoOrigenProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setCiudadOrigenProvProdOServ(historialProveedorProductoOServicioDTO.getCiudadOrigenProvProdOServ().toUpperCase());
        historialProveedorProductoOServicio.setFechaHMSIngresoProvProdOServ(historialProveedorProductoOServicioDTO.getFechaHMSIngresoProvProdOServ());
        historialProveedorProductoOServicio.setFechaHMSModificacionProvProdOServ(historialProveedorProductoOServicioDTO.getFechaHMSModificacionProvProdOServ());
        
        return historialProveedorProductoOServicio;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 02/06/2026.
    * @param historialProveedorProductoOServicio
    * Recibe un objeto historialProveedorProductoOServicio para crear un DTO.
    * @return historialProveedorProductoOServicioDTO
    */
    public HistorialProveedorProductoOServicioDTO historialProveedorProductoOServicioDTO(HistorialProveedorProductoOServicio historialProveedorProductoOServicio){
        HistorialProveedorProductoOServicioDTO historialProveedorProductoOServicioDTO = new HistorialProveedorProductoOServicioDTO();
        historialProveedorProductoOServicioDTO.setIdHistorialProveedorProductoOServicio(historialProveedorProductoOServicio.getIdHistorialProveedorProductoOServicio());
        historialProveedorProductoOServicioDTO.setNumRegHistorialProveedorProductoOServicio(historialProveedorProductoOServicio.getNumRegHistorialProveedorProductoOServicio().toUpperCase());
        historialProveedorProductoOServicioDTO.setSiglaOAcronimoUnidadMilitar(historialProveedorProductoOServicio.getSiglaOAcronimoUnidadMilitar().toUpperCase());
        historialProveedorProductoOServicioDTO.setNombreTipoDocumentoIdentificacion(historialProveedorProductoOServicio.getNombreTipoDocumentoIdentificacion().toUpperCase());
        historialProveedorProductoOServicioDTO.setNumeroDocumentoIdentificacionProvProdOServ(historialProveedorProductoOServicio.getNumeroDocumentoIdentificacionProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setLugarExpedicionDocumentoIdentificacionProvProdOServ(historialProveedorProductoOServicio.getLugarExpedicionDocumentoIdentificacionProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setNombresProvProdOServ(historialProveedorProductoOServicio.getNombresProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setPrimerApellidoProvProdOServ(historialProveedorProductoOServicio.getPrimerApellidoProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setSegundoApellidoProvProdOServ(historialProveedorProductoOServicio.getSegundoApellidoProvProdOServ());
        historialProveedorProductoOServicioDTO.setDireccionProvProdOServ(historialProveedorProductoOServicio.getDireccionProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setTelefonoProvProdOServ(historialProveedorProductoOServicio.getTelefonoProvProdOServ());
        historialProveedorProductoOServicioDTO.setMovilProvProdOServ(historialProveedorProductoOServicio.getMovilProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setCorreoElectronicoPersonalProvProdOServ(historialProveedorProductoOServicio.getCorreoElectronicoPersonalProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setCorreoElectronicoInstitucionalProvProdOServ(historialProveedorProductoOServicio.getCorreoElectronicoInstitucionalProvProdOServ());
        historialProveedorProductoOServicioDTO.setPaisOrigenProvProdOServ(historialProveedorProductoOServicio.getPaisOrigenProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setDepartamentoOEstadoOrigenProvProdOServ(historialProveedorProductoOServicio.getDepartamentoOEstadoOrigenProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setCiudadOrigenProvProdOServ(historialProveedorProductoOServicio.getCiudadOrigenProvProdOServ().toUpperCase());
        historialProveedorProductoOServicioDTO.setFechaHMSIngresoProvProdOServ(historialProveedorProductoOServicio.getFechaHMSIngresoProvProdOServ());
        historialProveedorProductoOServicioDTO.setFechaHMSModificacionProvProdOServ(historialProveedorProductoOServicio.getFechaHMSModificacionProvProdOServ());
        
        return historialProveedorProductoOServicioDTO;
    }
}
