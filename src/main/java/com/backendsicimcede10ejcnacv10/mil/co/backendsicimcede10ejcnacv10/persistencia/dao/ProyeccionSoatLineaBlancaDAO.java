//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionSoatLineaBlancaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSoatLineaBlanca;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ProyeccionSoatLineaBlancaDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionSoatLineaBlancaDTO
    * Recibe un DTO para crear un objeto proyeccionSoatLineaBlanca.
    * @return proyeccionSoatLineaBlanca
    */
    public ProyeccionSoatLineaBlanca proyeccionSoatLineaBlanca(ProyeccionSoatLineaBlancaDTO proyeccionSoatLineaBlancaDTO){
        ProyeccionSoatLineaBlanca proyeccionSoatLineaBlanca = new ProyeccionSoatLineaBlanca();
        proyeccionSoatLineaBlanca.setIdProyeccionSoatLineaBlanca(proyeccionSoatLineaBlancaDTO.getIdProyeccionSoatLineaBlanca());
        proyeccionSoatLineaBlanca.setValorSolicitadoProyeccionSoatLineaBlanca(proyeccionSoatLineaBlancaDTO.getValorSolicitadoProyeccionSoatLineaBlanca());
        proyeccionSoatLineaBlanca.setFechaHMSProyeccionSoatLineaBlanca(proyeccionSoatLineaBlancaDTO.getFechaHMSProyeccionSoatLineaBlanca());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (proyeccionSoatLineaBlancaDTO.getEquipoIngenieroDTO() != null && proyeccionSoatLineaBlancaDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(proyeccionSoatLineaBlancaDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(proyeccionSoatLineaBlanca::setEquipoIngeniero);
        }
        
        return proyeccionSoatLineaBlanca;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 08/04/2026.
    * @param proyeccionSoatLineaBlanca
    * Recibe un objeto proyeccionSoatLineaBlanca para crear un DTO.
    * @return proyeccionSoatLineaBlancaDTO
    */
    public ProyeccionSoatLineaBlancaDTO proyeccionSoatLineaBlancaDTO(ProyeccionSoatLineaBlanca proyeccionSoatLineaBlanca){
        ProyeccionSoatLineaBlancaDTO proyeccionSoatLineaBlancaDTO = new ProyeccionSoatLineaBlancaDTO();
        proyeccionSoatLineaBlancaDTO.setIdProyeccionSoatLineaBlanca(proyeccionSoatLineaBlanca.getIdProyeccionSoatLineaBlanca());
        proyeccionSoatLineaBlancaDTO.setValorSolicitadoProyeccionSoatLineaBlanca(proyeccionSoatLineaBlanca.getValorSolicitadoProyeccionSoatLineaBlanca());
        proyeccionSoatLineaBlancaDTO.setFechaHMSProyeccionSoatLineaBlanca(proyeccionSoatLineaBlanca.getFechaHMSProyeccionSoatLineaBlanca());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (proyeccionSoatLineaBlanca.getEquipoIngeniero() != null && proyeccionSoatLineaBlanca.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(proyeccionSoatLineaBlanca.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(eqIng -> proyeccionSoatLineaBlancaDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(eqIng)));
        }
        
        return proyeccionSoatLineaBlancaDTO;
    }
}
