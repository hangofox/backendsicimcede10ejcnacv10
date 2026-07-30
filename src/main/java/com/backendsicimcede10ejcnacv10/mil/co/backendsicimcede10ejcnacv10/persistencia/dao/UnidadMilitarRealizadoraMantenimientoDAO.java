//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMilitarRealizadoraMantenimientoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitarRealizadoraMantenimiento;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class UnidadMilitarRealizadoraMantenimientoDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param unidadMilitarRealizadoraMantenimientoDTO
    * Recibe un DTO para crear un objeto unidadMilitarRealizadoraMantenimiento.
    * @return unidadMilitarRealizadoraMantenimiento
    */
    public UnidadMilitarRealizadoraMantenimiento unidadMilitarRealizadoraMantenimiento(UnidadMilitarRealizadoraMantenimientoDTO unidadMilitarRealizadoraMantenimientoDTO){
        UnidadMilitarRealizadoraMantenimiento unidadMilitarRealizadoraMantenimiento = new UnidadMilitarRealizadoraMantenimiento();
        unidadMilitarRealizadoraMantenimiento.setIdUnidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimientoDTO.getIdUnidadMilitarRealizadoraMantenimiento());
        unidadMilitarRealizadoraMantenimiento.setCodigoUnidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimientoDTO.getCodigoUnidadMilitarRealizadoraMantenimiento().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (unidadMilitarRealizadoraMantenimientoDTO.getUnidadMilitarDTO() != null && unidadMilitarRealizadoraMantenimientoDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(unidadMilitarRealizadoraMantenimientoDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitarRealizadoraMantenimiento::setUnidadMilitar);
        }
        
        return unidadMilitarRealizadoraMantenimiento;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param unidadMilitarRealizadoraMantenimiento
    * Recibe un objeto unidadMilitarRealizadoraMantenimiento para crear un DTO.
    * @return unidadMilitarRealizadoraMantenimientoDTO
    */
    public UnidadMilitarRealizadoraMantenimientoDTO unidadMilitarRealizadoraMantenimientoDTO(UnidadMilitarRealizadoraMantenimiento unidadMilitarRealizadoraMantenimiento){
        UnidadMilitarRealizadoraMantenimientoDTO unidadMilitarRealizadoraMantenimientoDTO = new UnidadMilitarRealizadoraMantenimientoDTO();
        unidadMilitarRealizadoraMantenimientoDTO.setIdUnidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimiento.getIdUnidadMilitarRealizadoraMantenimiento());
        unidadMilitarRealizadoraMantenimientoDTO.setCodigoUnidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimiento.getCodigoUnidadMilitarRealizadoraMantenimiento());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (unidadMilitarRealizadoraMantenimiento.getUnidadMilitar() != null && unidadMilitarRealizadoraMantenimiento.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(unidadMilitarRealizadoraMantenimiento.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> unidadMilitarRealizadoraMantenimientoDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return unidadMilitarRealizadoraMantenimientoDTO;
    }
}
