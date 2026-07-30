//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PersonalMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PersonalMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
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
public class PersonalMantenimientoEquipoIngenieroDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;

    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param personalMantenimientoEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto personalMantenimientoEquipoIngeniero.
    * @return personalMantenimientoEquipoIngeniero
    */
    public PersonalMantenimientoEquipoIngeniero personalMantenimientoEquipoIngeniero(PersonalMantenimientoEquipoIngenieroDTO personalMantenimientoEquipoIngenieroDTO){
        PersonalMantenimientoEquipoIngeniero personalMantenimientoEquipoIngeniero = new PersonalMantenimientoEquipoIngeniero();
        personalMantenimientoEquipoIngeniero.setIdPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getIdPersonalMantenimientoEquipoIngeniero());
        personalMantenimientoEquipoIngeniero.setNumDocIdentifPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getNumDocIdentifPersonalMantenimientoEquipoIngeniero());
        personalMantenimientoEquipoIngeniero.setGradoPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getGradoPersonalMantenimientoEquipoIngeniero());
        personalMantenimientoEquipoIngeniero.setNombresyApellidosPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getNombresyApellidosPersonalMantenimientoEquipoIngeniero().toUpperCase());
        personalMantenimientoEquipoIngeniero.setCargoPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getCargoPersonalMantenimientoEquipoIngeniero());

        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (personalMantenimientoEquipoIngenieroDTO.getUnidadMilitarDTO() != null && personalMantenimientoEquipoIngenieroDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(personalMantenimientoEquipoIngenieroDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(personalMantenimientoEquipoIngeniero::setUnidadMilitar);
        }

        return personalMantenimientoEquipoIngeniero;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param personalMantenimientoEquipoIngeniero
    * Recibe un objeto personalMantenimientoEquipoIngeniero para crear un DTO.
    * @return personalMantenimientoEquipoIngenieroDTO
    */
    public PersonalMantenimientoEquipoIngenieroDTO personalMantenimientoEquipoIngenieroDTO(PersonalMantenimientoEquipoIngeniero personalMantenimientoEquipoIngeniero){
        PersonalMantenimientoEquipoIngenieroDTO personalMantenimientoEquipoIngenieroDTO = new PersonalMantenimientoEquipoIngenieroDTO();
        personalMantenimientoEquipoIngenieroDTO.setIdPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngeniero.getIdPersonalMantenimientoEquipoIngeniero());
        personalMantenimientoEquipoIngenieroDTO.setNumDocIdentifPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngeniero.getNumDocIdentifPersonalMantenimientoEquipoIngeniero());
        personalMantenimientoEquipoIngenieroDTO.setGradoPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngeniero.getGradoPersonalMantenimientoEquipoIngeniero());
        personalMantenimientoEquipoIngenieroDTO.setNombresyApellidosPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngeniero.getNombresyApellidosPersonalMantenimientoEquipoIngeniero().toUpperCase());
        personalMantenimientoEquipoIngenieroDTO.setCargoPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngeniero.getCargoPersonalMantenimientoEquipoIngeniero());

        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (personalMantenimientoEquipoIngeniero.getUnidadMilitar() != null && personalMantenimientoEquipoIngeniero.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(personalMantenimientoEquipoIngeniero.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> personalMantenimientoEquipoIngenieroDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }

        return personalMantenimientoEquipoIngenieroDTO;
    }
}
