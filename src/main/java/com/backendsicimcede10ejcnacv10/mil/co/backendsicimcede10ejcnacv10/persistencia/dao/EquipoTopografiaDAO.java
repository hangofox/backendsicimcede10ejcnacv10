//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EquipoTopografiaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoTopografia;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class EquipoTopografiaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 21/03/2026.
    * @param equipoTopografiaDTO
    * Recibe un DTO para crear un objeto equipoTopografia.
    * @return equipoTopografia
    */
    public EquipoTopografia equipoTopografia(EquipoTopografiaDTO equipoTopografiaDTO){
        EquipoTopografia equipoTopografia = new EquipoTopografia();
        equipoTopografia.setIdEquipoTopografia(equipoTopografiaDTO.getIdEquipoTopografia());
        equipoTopografia.setDenominacionEquipoTopografia(equipoTopografiaDTO.getDenominacionEquipoTopografia().toUpperCase());
        equipoTopografia.setNumeroInventarioEquipoTopografia(equipoTopografiaDTO.getNumeroInventarioEquipoTopografia());
        equipoTopografia.setNumeroActivoFijoEquipoTopografia(equipoTopografiaDTO.getNumeroActivoFijoEquipoTopografia());
        equipoTopografia.setCentroCostoUnidadMilitarEquipoTopografia(equipoTopografiaDTO.getCentroCostoUnidadMilitarEquipoTopografia());
        equipoTopografia.setFechaHMSIngresoEquipoTopografia(equipoTopografiaDTO.getFechaHMSIngresoEquipoTopografia());
        equipoTopografia.setFechaHMSModificacionEquipoTopografia(equipoTopografiaDTO.getFechaHMSModificacionEquipoTopografia());
        equipoTopografia.setEstadoEquipoTopografia(equipoTopografiaDTO.getEstadoEquipoTopografia());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (equipoTopografiaDTO.getUnidadMilitarDTO() != null && equipoTopografiaDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(equipoTopografiaDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(equipoTopografia::setUnidadMilitar);
        }
        
        return equipoTopografia;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 21/03/2026.
    * @param equipoTopografia
    * Recibe un objeto equipoTopografia para crear un DTO.
    * @return equipoTopografiaDTO
    */
    public EquipoTopografiaDTO equipoTopografiaDTO(EquipoTopografia equipoTopografia){
        EquipoTopografiaDTO equipoTopografiaDTO = new EquipoTopografiaDTO();
        equipoTopografiaDTO.setIdEquipoTopografia(equipoTopografia.getIdEquipoTopografia());
        equipoTopografiaDTO.setDenominacionEquipoTopografia(equipoTopografia.getDenominacionEquipoTopografia().toUpperCase());
        equipoTopografiaDTO.setNumeroInventarioEquipoTopografia(equipoTopografia.getNumeroInventarioEquipoTopografia());
        equipoTopografiaDTO.setNumeroActivoFijoEquipoTopografia(equipoTopografia.getNumeroActivoFijoEquipoTopografia());
        equipoTopografiaDTO.setCentroCostoUnidadMilitarEquipoTopografia(equipoTopografia.getCentroCostoUnidadMilitarEquipoTopografia());
        equipoTopografiaDTO.setFechaHMSIngresoEquipoTopografia(equipoTopografia.getFechaHMSIngresoEquipoTopografia());
        equipoTopografiaDTO.setFechaHMSModificacionEquipoTopografia(equipoTopografia.getFechaHMSModificacionEquipoTopografia());
        equipoTopografiaDTO.setEstadoEquipoTopografia(equipoTopografia.getEstadoEquipoTopografia());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (equipoTopografia.getUnidadMilitar() != null && equipoTopografia.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(equipoTopografia.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> equipoTopografiaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return equipoTopografiaDTO;
    }
}
