//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ElementoSubclasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClaseActivoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CuentaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ElementoSubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClaseActivoEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClasificacionEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CuentaEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.LineaEquipoIngenieroRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SubclasificacionEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 19/06/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ElementoSubclasificacionEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ClasificacionEquipoIngenieroRepository clasificacionEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ClasificacionEquipoIngenieroDAO clasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SubclasificacionEquipoIngenieroRepository subclasificacionEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SubclasificacionEquipoIngenieroDAO subclasificacionEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private LineaEquipoIngenieroRepository lineaEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private LineaEquipoIngenieroDAO lineaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CuentaEquipoIngenieroRepository cuentaEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private CuentaEquipoIngenieroDAO cuentaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ClaseActivoEquipoIngenieroRepository claseActivoEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ClaseActivoEquipoIngenieroDAO claseActivoEquipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 19/06/2026.
    * @param elementoSubclasificacionEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto elementoSubclasificacionEquipoIngeniero.
    * @return elementoSubclasificacionEquipoIngeniero
    */
    public ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero(ElementoSubclasificacionEquipoIngenieroDTO elementoSubclasificacionEquipoIngenieroDTO){
        ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero = new ElementoSubclasificacionEquipoIngeniero();
        elementoSubclasificacionEquipoIngeniero.setIdElementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getIdElementoSubclasificacionEquipoIngeniero());
        elementoSubclasificacionEquipoIngeniero.setNombreElementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getNombreElementoSubclasificacionEquipoIngeniero().toUpperCase());
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO() != null && elementoSubclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(elementoSubclasificacionEquipoIngeniero::setClasificacionEquipoIngeniero);
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO() != null && elementoSubclasificacionEquipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getSubclasificacionEquipoIngenieroDTO().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(elementoSubclasificacionEquipoIngeniero::setSubclasificacionEquipoIngeniero);
        }
        
        //MAPEAR LÍNEA DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngenieroDTO.getLineaEquipoIngenieroDTO() != null && elementoSubclasificacionEquipoIngenieroDTO.getLineaEquipoIngenieroDTO().getIdLineaEquipoIngeniero() != null) {
           Optional<LineaEquipoIngeniero> lineaEquipoIngenieroFk = lineaEquipoIngenieroRepository.findByIdLineaEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getLineaEquipoIngenieroDTO().getIdLineaEquipoIngeniero());
           lineaEquipoIngenieroFk.ifPresent(elementoSubclasificacionEquipoIngeniero::setLineaEquipoIngeniero);
        }
        
        //MAPEAR CUENTA DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngenieroDTO.getCuentaEquipoIngenieroDTO() != null && elementoSubclasificacionEquipoIngenieroDTO.getCuentaEquipoIngenieroDTO().getIdCuentaEquipoIngeniero() != null) {
           Optional<CuentaEquipoIngeniero> cuentaEquipoIngenieroFk = cuentaEquipoIngenieroRepository.findByIdCuentaEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getCuentaEquipoIngenieroDTO().getIdCuentaEquipoIngeniero());
           cuentaEquipoIngenieroFk.ifPresent(elementoSubclasificacionEquipoIngeniero::setCuentaEquipoIngeniero);
        }
        
        //MAPEAR CLASE ACTIVO DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngenieroDTO.getClaseActivoEquipoIngenieroDTO() != null && elementoSubclasificacionEquipoIngenieroDTO.getClaseActivoEquipoIngenieroDTO().getIdClaseActivoEquipoIngeniero() != null) {
           Optional<ClaseActivoEquipoIngeniero> claseActivoEquipoIngenieroFk = claseActivoEquipoIngenieroRepository.findByIdClaseActivoEquipoIngeniero(elementoSubclasificacionEquipoIngenieroDTO.getClaseActivoEquipoIngenieroDTO().getIdClaseActivoEquipoIngeniero());
           claseActivoEquipoIngenieroFk.ifPresent(elementoSubclasificacionEquipoIngeniero::setClaseActivoEquipoIngeniero);
        }
        
        return elementoSubclasificacionEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 19/06/2026.
    * @param elementoSubclasificacionEquipoIngeniero
    * Recibe un objeto elementoSubclasificacionEquipoIngeniero para crear un DTO.
    * @return elementoSubclasificacionEquipoIngenieroDTO
    */
    public ElementoSubclasificacionEquipoIngenieroDTO elementoSubclasificacionEquipoIngenieroDTO(ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero){
        ElementoSubclasificacionEquipoIngenieroDTO elementoSubclasificacionEquipoIngenieroDTO = new ElementoSubclasificacionEquipoIngenieroDTO();
        elementoSubclasificacionEquipoIngenieroDTO.setIdElementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngeniero.getIdElementoSubclasificacionEquipoIngeniero());
        elementoSubclasificacionEquipoIngenieroDTO.setNombreElementoSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngeniero.getNombreElementoSubclasificacionEquipoIngeniero().toUpperCase());
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngeniero.getClasificacionEquipoIngeniero() != null && elementoSubclasificacionEquipoIngeniero.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngeniero.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(clasifEqIng -> elementoSubclasificacionEquipoIngenieroDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasifEqIng)));
        }
        
        //MAPEAR SUBCLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngeniero.getSubclasificacionEquipoIngeniero() != null && elementoSubclasificacionEquipoIngeniero.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero() != null) {
           Optional<SubclasificacionEquipoIngeniero> subclasificacionEquipoIngenieroFk = subclasificacionEquipoIngenieroRepository.findByIdSubclasificacionEquipoIngeniero(elementoSubclasificacionEquipoIngeniero.getSubclasificacionEquipoIngeniero().getIdSubclasificacionEquipoIngeniero());
           subclasificacionEquipoIngenieroFk.ifPresent(subclasifEqIng -> elementoSubclasificacionEquipoIngenieroDTO.setSubclasificacionEquipoIngenieroDTO(subclasificacionEquipoIngenieroDAO.subclasificacionEquipoIngenieroDTO(subclasifEqIng)));
        }
        
        //MAPEAR LÍNEA DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngeniero.getLineaEquipoIngeniero() != null && elementoSubclasificacionEquipoIngeniero.getLineaEquipoIngeniero().getIdLineaEquipoIngeniero() != null) {
           Optional<LineaEquipoIngeniero> lineaEquipoIngenieroFk = lineaEquipoIngenieroRepository.findByIdLineaEquipoIngeniero(elementoSubclasificacionEquipoIngeniero.getLineaEquipoIngeniero().getIdLineaEquipoIngeniero());
           lineaEquipoIngenieroFk.ifPresent(linEquIng -> elementoSubclasificacionEquipoIngenieroDTO.setLineaEquipoIngenieroDTO(lineaEquipoIngenieroDAO.lineaEquipoIngenieroDTO(linEquIng)));
        }
        
        //MAPEAR CUENTA DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngeniero.getCuentaEquipoIngeniero() != null && elementoSubclasificacionEquipoIngeniero.getCuentaEquipoIngeniero().getIdCuentaEquipoIngeniero() != null) {
           Optional<CuentaEquipoIngeniero> cuentaEquipoIngenieroFk = cuentaEquipoIngenieroRepository.findByIdCuentaEquipoIngeniero(elementoSubclasificacionEquipoIngeniero.getCuentaEquipoIngeniero().getIdCuentaEquipoIngeniero());
           cuentaEquipoIngenieroFk.ifPresent(cuentaEqIng -> elementoSubclasificacionEquipoIngenieroDTO.setCuentaEquipoIngenieroDTO(cuentaEquipoIngenieroDAO.cuentaEquipoIngenieroDTO(cuentaEqIng)));
        }
        
        //MAPEAR CLASE ACTIVO DE EQUIPO DE INGENIERO RELACIONADA.
        if (elementoSubclasificacionEquipoIngeniero.getClaseActivoEquipoIngeniero() != null && elementoSubclasificacionEquipoIngeniero.getClaseActivoEquipoIngeniero().getIdClaseActivoEquipoIngeniero() != null) {
           Optional<ClaseActivoEquipoIngeniero> claseActivoEquipoIngenieroFk = claseActivoEquipoIngenieroRepository.findByIdClaseActivoEquipoIngeniero(elementoSubclasificacionEquipoIngeniero.getClaseActivoEquipoIngeniero().getIdClaseActivoEquipoIngeniero());
           claseActivoEquipoIngenieroFk.ifPresent(claseActEqIng -> elementoSubclasificacionEquipoIngenieroDTO.setClaseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngenieroDTO(claseActEqIng)));
        }
        
        return elementoSubclasificacionEquipoIngenieroDTO;
    }
}
