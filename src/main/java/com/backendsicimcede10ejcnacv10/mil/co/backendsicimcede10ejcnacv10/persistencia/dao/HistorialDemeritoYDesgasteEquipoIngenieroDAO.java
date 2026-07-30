//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialDemeritoYDesgasteEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialDemeritoYDesgasteEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialDemeritoYDesgasteEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/03/2026.
    * @param historialDemeritoYDesgasteEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto historialDemeritoYDesgasteEquipoIngeniero.
    * @return historialDemeritoYDesgasteEquipoIngeniero
    */
    public HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngeniero(HistorialDemeritoYDesgasteEquipoIngenieroDTO historialDemeritoYDesgasteEquipoIngenieroDTO){
        HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngeniero = new HistorialDemeritoYDesgasteEquipoIngeniero();
        historialDemeritoYDesgasteEquipoIngeniero.setIdHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getIdHistorialDemeritoYDesgasteEquipoIngeniero());
        historialDemeritoYDesgasteEquipoIngeniero.setNumRegHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getNumRegHistorialDemeritoYDesgasteEquipoIngeniero().toUpperCase());
        historialDemeritoYDesgasteEquipoIngeniero.setNombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getNombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero().toUpperCase());
        historialDemeritoYDesgasteEquipoIngeniero.setValorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getValorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero());
        historialDemeritoYDesgasteEquipoIngeniero.setHorasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getHorasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero());
        historialDemeritoYDesgasteEquipoIngeniero.setKilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getKilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialDemeritoYDesgasteEquipoIngenieroDTO.getEquipoIngenieroDTO() != null && historialDemeritoYDesgasteEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialDemeritoYDesgasteEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(historialDemeritoYDesgasteEquipoIngeniero::setEquipoIngeniero);
        }
        
        return historialDemeritoYDesgasteEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/03/2026.
    * @param historialDemeritoYDesgasteEquipoIngeniero
    * Recibe un objeto historialDemeritoYDesgasteEquipoIngeniero para crear un DTO.
    * @return historialDemeritoYDesgasteEquipoIngenieroDTO
    */
    public HistorialDemeritoYDesgasteEquipoIngenieroDTO historialDemeritoYDesgasteEquipoIngenieroDTO(HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngeniero){
        HistorialDemeritoYDesgasteEquipoIngenieroDTO historialDemeritoYDesgasteEquipoIngenieroDTO = new HistorialDemeritoYDesgasteEquipoIngenieroDTO();
        historialDemeritoYDesgasteEquipoIngenieroDTO.setIdHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngeniero.getIdHistorialDemeritoYDesgasteEquipoIngeniero());
        historialDemeritoYDesgasteEquipoIngenieroDTO.setNumRegHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngeniero.getNumRegHistorialDemeritoYDesgasteEquipoIngeniero().toUpperCase());
        historialDemeritoYDesgasteEquipoIngenieroDTO.setNombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngeniero.getNombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero().toUpperCase());
        historialDemeritoYDesgasteEquipoIngenieroDTO.setValorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngeniero.getValorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero());
        historialDemeritoYDesgasteEquipoIngenieroDTO.setHorasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngeniero.getHorasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero());
        historialDemeritoYDesgasteEquipoIngenieroDTO.setKilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero(historialDemeritoYDesgasteEquipoIngeniero.getKilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (historialDemeritoYDesgasteEquipoIngeniero.getEquipoIngeniero() != null && historialDemeritoYDesgasteEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(historialDemeritoYDesgasteEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(equIng -> historialDemeritoYDesgasteEquipoIngenieroDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equIng)));
        }
        
        return historialDemeritoYDesgasteEquipoIngenieroDTO;
    }
}
