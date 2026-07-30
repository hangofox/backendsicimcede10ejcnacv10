//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProcesoApoyoAtencionPrevencionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProcesoApoyoAtencionPrevencion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoRequerimientoApoyoAtencionPrevencion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoRequerimientoApoyoAtencionPrevencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProcesoApoyoAtencionPrevencionDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoRequerimientoApoyoAtencionPrevencionRepository tipoRequerimientoApoyoAtencionPrevencionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoRequerimientoApoyoAtencionPrevencionDAO tipoRequerimientoApoyoAtencionPrevencionDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param procesoApoyoAtencionPrevencionDTO
    * Recibe un DTO para crear un objeto procesoApoyoAtencionPrevencion.
    * @return procesoApoyoAtencionPrevencion
    */
    public ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencion(ProcesoApoyoAtencionPrevencionDTO procesoApoyoAtencionPrevencionDTO){
        ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencion = new ProcesoApoyoAtencionPrevencion();
        procesoApoyoAtencionPrevencion.setIdProcesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO.getIdProcesoApoyoAtencionPrevencion());
        procesoApoyoAtencionPrevencion.setNombreProcesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO.getNombreProcesoApoyoAtencionPrevencion().toUpperCase());
        
        //MAPEAR TIPO DE REQUERIMIENTO DE APOYO, ATENCIÓN Y PREVENCIÓN RELACIONADO.
        if (procesoApoyoAtencionPrevencionDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO() != null && procesoApoyoAtencionPrevencionDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO().getIdTipoRequerimientoApoyoAtencionPrevencion() != null) {
           Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionFk = tipoRequerimientoApoyoAtencionPrevencionRepository.findByIdTipoRequerimientoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencionDTO.getTipoRequerimientoApoyoAtencionPrevencionDTO().getIdTipoRequerimientoApoyoAtencionPrevencion());
           tipoRequerimientoApoyoAtencionPrevencionFk.ifPresent(procesoApoyoAtencionPrevencion::setTipoRequerimientoApoyoAtencionPrevencion);
        }
        
        return procesoApoyoAtencionPrevencion;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 25/03/2026.
    * @param procesoApoyoAtencionPrevencion
    * Recibe un objeto procesoApoyoAtencionPrevencion para crear un DTO.
    * @return procesoApoyoAtencionPrevencionDTO
    */
    public ProcesoApoyoAtencionPrevencionDTO procesoApoyoAtencionPrevencionDTO(ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencion){
        ProcesoApoyoAtencionPrevencionDTO procesoApoyoAtencionPrevencionDTO = new ProcesoApoyoAtencionPrevencionDTO();
        procesoApoyoAtencionPrevencionDTO.setIdProcesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencion.getIdProcesoApoyoAtencionPrevencion());
        procesoApoyoAtencionPrevencionDTO.setNombreProcesoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencion.getNombreProcesoApoyoAtencionPrevencion().toUpperCase());
        
        //MAPEAR TIPO DE REQUERIMIENTO DE APOYO, ATENCIÓN Y PREVENCIÓN RELACIONADO.
        if (procesoApoyoAtencionPrevencion.getTipoRequerimientoApoyoAtencionPrevencion() != null && procesoApoyoAtencionPrevencion.getTipoRequerimientoApoyoAtencionPrevencion().getIdTipoRequerimientoApoyoAtencionPrevencion() != null) {
           Optional<TipoRequerimientoApoyoAtencionPrevencion> tipoRequerimientoApoyoAtencionPrevencionFk = tipoRequerimientoApoyoAtencionPrevencionRepository.findByIdTipoRequerimientoApoyoAtencionPrevencion(procesoApoyoAtencionPrevencion.getTipoRequerimientoApoyoAtencionPrevencion().getIdTipoRequerimientoApoyoAtencionPrevencion());
           tipoRequerimientoApoyoAtencionPrevencionFk.ifPresent(tipoReqApoyo -> procesoApoyoAtencionPrevencionDTO.setTipoRequerimientoApoyoAtencionPrevencionDTO(tipoRequerimientoApoyoAtencionPrevencionDAO.tipoRequerimientoApoyoAtencionPrevencionDTO(tipoReqApoyo)));
        }
        
        return procesoApoyoAtencionPrevencionDTO;
    }
}
