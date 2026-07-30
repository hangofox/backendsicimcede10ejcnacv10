//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ComodatoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ComodatoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProveedorProductoOServicio;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Terreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialProveedorProductoOServicioRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TerrenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ComodatoTerrenoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TerrenoRepository terrenoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TerrenoDAO terrenoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialProveedorProductoOServicioRepository historialProveedorProductoOServicioRepository;

    @Autowired//INYECTAMOS EL DAO.
    private HistorialProveedorProductoOServicioDAO historialProveedorProductoOServicioDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param comodatoTerrenoDTO
    * Recibe un DTO para crear un objeto comodatoTerreno.
    * @return comodatoTerreno
    */
    public ComodatoTerreno comodatoTerreno(ComodatoTerrenoDTO comodatoTerrenoDTO){
        ComodatoTerreno comodatoTerreno = new ComodatoTerreno();
        comodatoTerreno.setIdComodatoTerreno(comodatoTerrenoDTO.getIdComodatoTerreno());
        comodatoTerreno.setFechaHMSIniciacionComodatoTerreno(comodatoTerrenoDTO.getFechaHMSIniciacionComodatoTerreno());
        comodatoTerreno.setFechaHMSFinalizacionComodatoTerreno(comodatoTerrenoDTO.getFechaHMSFinalizacionComodatoTerreno());
        comodatoTerreno.setEstadoTerreno(comodatoTerrenoDTO.getEstadoTerreno().toUpperCase());
        
        //MAPEAR TERRENO RELACIONADO.
        if (comodatoTerrenoDTO.getTerrenoDTO() != null && comodatoTerrenoDTO.getTerrenoDTO().getIdTerreno() != null) {
           Optional<Terreno> terrenoFk = terrenoRepository.findByIdTerreno(comodatoTerrenoDTO.getTerrenoDTO().getIdTerreno());
           terrenoFk.ifPresent(comodatoTerreno::setTerreno);
        }
        
        //MAPEAR HISTORIAL PROVEEDOR DEL PRODUCTO O SERVICIO RELACIONADO.
        if (comodatoTerrenoDTO.getHistorialProveedorProductoOServicioDTO() != null && comodatoTerrenoDTO.getHistorialProveedorProductoOServicioDTO().getIdHistorialProveedorProductoOServicio() != null) {
           Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioFk = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(comodatoTerrenoDTO.getHistorialProveedorProductoOServicioDTO().getIdHistorialProveedorProductoOServicio());
           historialProveedorProductoOServicioFk.ifPresent(comodatoTerreno::setHistorialProveedorProductoOServicio);
        }

        return comodatoTerreno;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param comodatoTerreno
    * Recibe un objeto comodatoTerreno para crear un DTO.
    * @return comodatoTerrenoDTO
    */
    public ComodatoTerrenoDTO comodatoTerrenoDTO(ComodatoTerreno comodatoTerreno){
        ComodatoTerrenoDTO comodatoTerrenoDTO = new ComodatoTerrenoDTO();
        comodatoTerrenoDTO.setIdComodatoTerreno(comodatoTerreno.getIdComodatoTerreno());
        comodatoTerrenoDTO.setFechaHMSIniciacionComodatoTerreno(comodatoTerreno.getFechaHMSIniciacionComodatoTerreno());
        comodatoTerrenoDTO.setFechaHMSFinalizacionComodatoTerreno(comodatoTerreno.getFechaHMSFinalizacionComodatoTerreno());
        comodatoTerrenoDTO.setEstadoTerreno(comodatoTerreno.getEstadoTerreno().toUpperCase());
        
        //MAPEAR TERRENO RELACIONADO.
        if (comodatoTerreno.getTerreno() != null && comodatoTerreno.getTerreno().getIdTerreno() != null) {
           Optional<Terreno> terrenoFk = terrenoRepository.findByIdTerreno(comodatoTerreno.getTerreno().getIdTerreno());
           terrenoFk.ifPresent(terr -> comodatoTerrenoDTO.setTerrenoDTO(terrenoDAO.terrenoDTO(terr)));
        }
        
        //MAPEAR HISTORIAL PROVEEDOR DEL PRODUCTO O SERVICIO RELACIONADO.
        if (comodatoTerreno.getHistorialProveedorProductoOServicio() != null && comodatoTerreno.getHistorialProveedorProductoOServicio().getIdHistorialProveedorProductoOServicio() != null) {
           Optional<HistorialProveedorProductoOServicio> historialProveedorProductoOServicioFk = historialProveedorProductoOServicioRepository.findByIdHistorialProveedorProductoOServicio(comodatoTerreno.getHistorialProveedorProductoOServicio().getIdHistorialProveedorProductoOServicio());
           historialProveedorProductoOServicioFk.ifPresent(histProvProdServ -> comodatoTerrenoDTO.setHistorialProveedorProductoOServicioDTO(historialProveedorProductoOServicioDAO.historialProveedorProductoOServicioDTO(histProvProdServ)));
        }
        
        return comodatoTerrenoDTO;
    }
}
