//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SubclasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SubclasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClasificacionEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClasificacionEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class SubclasificacionEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ClasificacionEquipoIngenieroRepository clasificacionEquipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ClasificacionEquipoIngenieroDAO clasificacionEquipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param subclasificacionEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto subclasificacionEquipoIngeniero.
    * @return subclasificacionEquipoIngeniero
    */
    public SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero(SubclasificacionEquipoIngenieroDTO subclasificacionEquipoIngenieroDTO){
        SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero = new SubclasificacionEquipoIngeniero();
        subclasificacionEquipoIngeniero.setIdSubclasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO.getIdSubclasificacionEquipoIngeniero());
        subclasificacionEquipoIngeniero.setNombreSubclasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO.getNombreSubclasificacionEquipoIngeniero());
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (subclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO() != null && subclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(subclasificacionEquipoIngenieroDTO.getClasificacionEquipoIngenieroDTO().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(subclasificacionEquipoIngeniero::setClasificacionEquipoIngeniero);
        }
        
        return subclasificacionEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param subclasificacionEquipoIngeniero
    * Recibe un objeto subclasificacionEquipoIngeniero para crear un DTO.
    * @return subclasificacionEquipoIngenieroDTO
    */
    public SubclasificacionEquipoIngenieroDTO subclasificacionEquipoIngenieroDTO(SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero){
        SubclasificacionEquipoIngenieroDTO subclasificacionEquipoIngenieroDTO = new SubclasificacionEquipoIngenieroDTO();
        subclasificacionEquipoIngenieroDTO.setIdSubclasificacionEquipoIngeniero(subclasificacionEquipoIngeniero.getIdSubclasificacionEquipoIngeniero());
        subclasificacionEquipoIngenieroDTO.setNombreSubclasificacionEquipoIngeniero(subclasificacionEquipoIngeniero.getNombreSubclasificacionEquipoIngeniero());
        
        //MAPEAR CLASIFICACIÓN DE EQUIPO DE INGENIERO RELACIONADA.
        if (subclasificacionEquipoIngeniero.getClasificacionEquipoIngeniero() != null && subclasificacionEquipoIngeniero.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero() != null) {
           Optional<ClasificacionEquipoIngeniero> clasificacionEquipoIngenieroFk = clasificacionEquipoIngenieroRepository.findByIdClasificacionEquipoIngeniero(subclasificacionEquipoIngeniero.getClasificacionEquipoIngeniero().getIdClasificacionEquipoIngeniero());
           clasificacionEquipoIngenieroFk.ifPresent(clasificacionEquipoIngeniero -> subclasificacionEquipoIngenieroDTO.setClasificacionEquipoIngenieroDTO(clasificacionEquipoIngenieroDAO.clasificacionEquipoIngenieroDTO(clasificacionEquipoIngeniero)));
        }
        
        return subclasificacionEquipoIngenieroDTO;
    }
}
