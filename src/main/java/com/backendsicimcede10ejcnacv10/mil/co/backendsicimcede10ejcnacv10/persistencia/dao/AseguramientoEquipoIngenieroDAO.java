//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.AseguramientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Aseguradora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.AseguramientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.AseguradoraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class AseguramientoEquipoIngenieroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private AseguradoraRepository aseguradoraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private AseguradoraDAO aseguradoraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param aseguramientoEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto aseguramientoEquipoIngeniero.
    * @return aseguramientoEquipoIngeniero
    */
    public AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero(AseguramientoEquipoIngenieroDTO aseguramientoEquipoIngenieroDTO){
        AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero = new AseguramientoEquipoIngeniero();
        aseguramientoEquipoIngeniero.setIdAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getIdAseguramientoEquipoIngeniero());
        aseguramientoEquipoIngeniero.setFechaHMSIniciacionAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getFechaHMSIniciacionAseguramientoEquipoIngeniero());
        aseguramientoEquipoIngeniero.setFechaHMSFinalizacionAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getFechaHMSFinalizacionAseguramientoEquipoIngeniero());
        aseguramientoEquipoIngeniero.setNumeroSeguroAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getNumeroSeguroAseguramientoEquipoIngeniero().toUpperCase());
        aseguramientoEquipoIngeniero.setValorSolicitadoAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getValorSolicitadoAseguramientoEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (aseguramientoEquipoIngenieroDTO.getEquipoIngenieroDTO() != null && aseguramientoEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(aseguramientoEquipoIngeniero::setEquipoIngeniero);
        }
        
        //MAPEAR ASEGURADORA RELACIONADA.
        if (aseguramientoEquipoIngenieroDTO.getAseguradoraDTO() != null && aseguramientoEquipoIngenieroDTO.getAseguradoraDTO().getIdAseguradora() != null) {
           Optional<Aseguradora> aseguradoraFk = aseguradoraRepository.findByIdAseguradora(aseguramientoEquipoIngenieroDTO.getAseguradoraDTO().getIdAseguradora());
           aseguradoraFk.ifPresent(aseguramientoEquipoIngeniero::setAseguradora);
        }
        
        return aseguramientoEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param aseguramientoEquipoIngeniero
    * Recibe un objeto aseguramientoEquipoIngeniero para crear un DTO.
    * @return aseguramientoEquipoIngenieroDTO
    */
    public AseguramientoEquipoIngenieroDTO aseguramientoEquipoIngenieroDTO(AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero){
        AseguramientoEquipoIngenieroDTO aseguramientoEquipoIngenieroDTO = new AseguramientoEquipoIngenieroDTO();
        aseguramientoEquipoIngenieroDTO.setIdAseguramientoEquipoIngeniero(aseguramientoEquipoIngeniero.getIdAseguramientoEquipoIngeniero());
        aseguramientoEquipoIngenieroDTO.setFechaHMSIniciacionAseguramientoEquipoIngeniero(aseguramientoEquipoIngeniero.getFechaHMSIniciacionAseguramientoEquipoIngeniero());
        aseguramientoEquipoIngenieroDTO.setFechaHMSFinalizacionAseguramientoEquipoIngeniero(aseguramientoEquipoIngeniero.getFechaHMSFinalizacionAseguramientoEquipoIngeniero());
        aseguramientoEquipoIngenieroDTO.setNumeroSeguroAseguramientoEquipoIngeniero(aseguramientoEquipoIngeniero.getNumeroSeguroAseguramientoEquipoIngeniero().toUpperCase());
        aseguramientoEquipoIngenieroDTO.setValorSolicitadoAseguramientoEquipoIngeniero(aseguramientoEquipoIngeniero.getValorSolicitadoAseguramientoEquipoIngeniero());
        
        //MAPEAR EQUIPO DE INGENIERO RELACIONADO.
        if (aseguramientoEquipoIngeniero.getEquipoIngeniero() != null && aseguramientoEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero() != null) {
           Optional<EquipoIngeniero> equipoIngenieroFk = equipoIngenieroRepository.findByIdEquipoIngeniero(aseguramientoEquipoIngeniero.getEquipoIngeniero().getIdEquipoIngeniero());
           equipoIngenieroFk.ifPresent(equIng -> aseguramientoEquipoIngenieroDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equIng)));
        }
        
        //MAPEAR ASEGURADORA RELACIONADA.
        if (aseguramientoEquipoIngeniero.getAseguradora() != null && aseguramientoEquipoIngeniero.getAseguradora().getIdAseguradora() != null) {
           Optional<Aseguradora> aseguradoraFk = aseguradoraRepository.findByIdAseguradora(aseguramientoEquipoIngeniero.getAseguradora().getIdAseguradora());
           aseguradoraFk.ifPresent(aseg -> aseguramientoEquipoIngenieroDTO.setAseguradoraDTO(aseguradoraDAO.aseguradoraDTO(aseg)));
        }
        
        return aseguramientoEquipoIngenieroDTO;
    }
}
