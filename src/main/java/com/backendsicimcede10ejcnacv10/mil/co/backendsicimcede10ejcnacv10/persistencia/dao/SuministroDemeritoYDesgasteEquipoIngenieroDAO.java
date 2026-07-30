//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SuministroDemeritoYDesgasteEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialDemeritoYDesgasteEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SuministroDemeritoYDesgasteEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialDemeritoYDesgasteEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class SuministroDemeritoYDesgasteEquipoIngenieroDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialDemeritoYDesgasteEquipoIngenieroRepository historialDemeritoYDesgasteEquipoIngenieroRepository;

    @Autowired//INYECTAMOS EL DAO.
    private HistorialDemeritoYDesgasteEquipoIngenieroDAO historialDemeritoYDesgasteEquipoIngenieroDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/03/2026.
    * @param suministroDemeritoYDesgasteEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto suministroDemeritoYDesgasteEquipoIngeniero.
    * @return suministroDemeritoYDesgasteEquipoIngeniero
    */
    public SuministroDemeritoYDesgasteEquipoIngeniero suministroDemeritoYDesgasteEquipoIngeniero(SuministroDemeritoYDesgasteEquipoIngenieroDTO suministroDemeritoYDesgasteEquipoIngenieroDTO){
        SuministroDemeritoYDesgasteEquipoIngeniero suministroDemeritoYDesgasteEquipoIngeniero = new SuministroDemeritoYDesgasteEquipoIngeniero();
        suministroDemeritoYDesgasteEquipoIngeniero.setIdSuministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngenieroDTO.getIdSuministroDemeritoYDesgasteEquipoIngeniero());
        suministroDemeritoYDesgasteEquipoIngeniero.setNombreSuministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngenieroDTO.getNombreSuministroDemeritoYDesgasteEquipoIngeniero().toUpperCase());
        suministroDemeritoYDesgasteEquipoIngeniero.setValorSuministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngenieroDTO.getValorSuministroDemeritoYDesgasteEquipoIngeniero());

        //MAPEAR HISTORIAL DEMERITO Y DESGASTE EQUIPO INGENIERO RELACIONADO.
        if (suministroDemeritoYDesgasteEquipoIngenieroDTO.getHistorialDemeritoYDesgasteEquipoIngenieroDTO() != null && suministroDemeritoYDesgasteEquipoIngenieroDTO.getHistorialDemeritoYDesgasteEquipoIngenieroDTO().getIdHistorialDemeritoYDesgasteEquipoIngeniero() != null) {
           Optional<HistorialDemeritoYDesgasteEquipoIngeniero> historialDemeritoYDesgasteEquipoIngenieroFk = historialDemeritoYDesgasteEquipoIngenieroRepository.findByIdHistorialDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngenieroDTO.getHistorialDemeritoYDesgasteEquipoIngenieroDTO().getIdHistorialDemeritoYDesgasteEquipoIngeniero());
           historialDemeritoYDesgasteEquipoIngenieroFk.ifPresent(suministroDemeritoYDesgasteEquipoIngeniero::setHistorialDemeritoYDesgasteEquipoIngeniero);
        }

        return suministroDemeritoYDesgasteEquipoIngeniero;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/03/2026.
    * @param suministroDemeritoYDesgasteEquipoIngeniero
    * Recibe un objeto suministroDemeritoYDesgasteEquipoIngeniero para crear un DTO.
    * @return suministroDemeritoYDesgasteEquipoIngenieroDTO
    */
    public SuministroDemeritoYDesgasteEquipoIngenieroDTO suministroDemeritoYDesgasteEquipoIngenieroDTO(SuministroDemeritoYDesgasteEquipoIngeniero suministroDemeritoYDesgasteEquipoIngeniero){
        SuministroDemeritoYDesgasteEquipoIngenieroDTO suministroDemeritoYDesgasteEquipoIngenieroDTO = new SuministroDemeritoYDesgasteEquipoIngenieroDTO();
        suministroDemeritoYDesgasteEquipoIngenieroDTO.setIdSuministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngeniero.getIdSuministroDemeritoYDesgasteEquipoIngeniero());
        suministroDemeritoYDesgasteEquipoIngenieroDTO.setNombreSuministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngeniero.getNombreSuministroDemeritoYDesgasteEquipoIngeniero().toUpperCase());
        suministroDemeritoYDesgasteEquipoIngenieroDTO.setValorSuministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngeniero.getValorSuministroDemeritoYDesgasteEquipoIngeniero());

        //MAPEAR HISTORIAL DEMERITO Y DESGASTE EQUIPO INGENIERO RELACIONADO.
        if (suministroDemeritoYDesgasteEquipoIngeniero.getHistorialDemeritoYDesgasteEquipoIngeniero() != null && suministroDemeritoYDesgasteEquipoIngeniero.getHistorialDemeritoYDesgasteEquipoIngeniero().getIdHistorialDemeritoYDesgasteEquipoIngeniero() != null) {
           Optional<HistorialDemeritoYDesgasteEquipoIngeniero> historialDemeritoYDesgasteEquipoIngenieroFk = historialDemeritoYDesgasteEquipoIngenieroRepository.findByIdHistorialDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngeniero.getHistorialDemeritoYDesgasteEquipoIngeniero().getIdHistorialDemeritoYDesgasteEquipoIngeniero());
           historialDemeritoYDesgasteEquipoIngenieroFk.ifPresent(histDemDesgEquIng -> suministroDemeritoYDesgasteEquipoIngenieroDTO.setHistorialDemeritoYDesgasteEquipoIngenieroDTO(historialDemeritoYDesgasteEquipoIngenieroDAO.historialDemeritoYDesgasteEquipoIngenieroDTO(histDemDesgEquIng)));
        }

        return suministroDemeritoYDesgasteEquipoIngenieroDTO;
    }
}
