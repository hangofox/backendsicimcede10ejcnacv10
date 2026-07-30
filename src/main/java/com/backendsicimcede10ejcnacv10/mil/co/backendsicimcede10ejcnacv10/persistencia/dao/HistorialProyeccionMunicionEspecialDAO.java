//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionMunicionEspecialDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionMunicionEspecial;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MunicionEspecial;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.MunicionEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialProyeccionMunicionEspecialDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private MunicionEspecialRepository municionEspecialRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private MunicionEspecialDAO municionEspecialDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 14/04/2026.
    * @param historialProyeccionMunicionEspecialDTO
    * Recibe un DTO para crear un objeto historialProyeccionMunicionEspecial.
    * @return historialProyeccionMunicionEspecial
    */
    public HistorialProyeccionMunicionEspecial historialProyeccionMunicionEspecial(HistorialProyeccionMunicionEspecialDTO historialProyeccionMunicionEspecialDTO){
        HistorialProyeccionMunicionEspecial historialProyeccionMunicionEspecial = new HistorialProyeccionMunicionEspecial();
        historialProyeccionMunicionEspecial.setIdHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO.getIdHistorialProyeccionMunicionEspecial());
        historialProyeccionMunicionEspecial.setNumRegHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO.getNumRegHistorialProyeccionMunicionEspecial().toUpperCase());
        historialProyeccionMunicionEspecial.setValorTotalHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO.getValorTotalHistorialProyeccionMunicionEspecial());
        historialProyeccionMunicionEspecial.setNumeroRubroPresupuestalHistProyMunEsp(historialProyeccionMunicionEspecialDTO.getNumeroRubroPresupuestalHistProyMunEsp());
        historialProyeccionMunicionEspecial.setNombreBienOServicioHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO.getNombreBienOServicioHistorialProyeccionMunicionEspecial().toUpperCase());
        historialProyeccionMunicionEspecial.setCantidadSolicitadaHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecialDTO.getCantidadSolicitadaHistorialProyeccionMunicionEspecial());
        
        //MAPEAR MUNICION ESPECIAL RELACIONADA.
        if (historialProyeccionMunicionEspecialDTO.getMunicionEspecialDTO() != null && historialProyeccionMunicionEspecialDTO.getMunicionEspecialDTO().getIdMunicionEspecial() != null) {
           Optional<MunicionEspecial> municionEspecialFk = municionEspecialRepository.findByIdMunicionEspecial(historialProyeccionMunicionEspecialDTO.getMunicionEspecialDTO().getIdMunicionEspecial());
           municionEspecialFk.ifPresent(historialProyeccionMunicionEspecial::setMunicionEspecial);
        }
        
        return historialProyeccionMunicionEspecial;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 14/04/2026.
    * @param historialProyeccionMunicionEspecial
    * Recibe un objeto historialProyeccionMunicionEspecial para crear un DTO.
    * @return historialProyeccionMunicionEspecialDTO
    */
    public HistorialProyeccionMunicionEspecialDTO historialProyeccionMunicionEspecialDTO(HistorialProyeccionMunicionEspecial historialProyeccionMunicionEspecial){
        HistorialProyeccionMunicionEspecialDTO historialProyeccionMunicionEspecialDTO = new HistorialProyeccionMunicionEspecialDTO();
        historialProyeccionMunicionEspecialDTO.setIdHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecial.getIdHistorialProyeccionMunicionEspecial());
        historialProyeccionMunicionEspecialDTO.setNumRegHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecial.getNumRegHistorialProyeccionMunicionEspecial().toUpperCase());
        historialProyeccionMunicionEspecialDTO.setValorTotalHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecial.getValorTotalHistorialProyeccionMunicionEspecial());
        historialProyeccionMunicionEspecialDTO.setNumeroRubroPresupuestalHistProyMunEsp(historialProyeccionMunicionEspecial.getNumeroRubroPresupuestalHistProyMunEsp());
        historialProyeccionMunicionEspecialDTO.setNombreBienOServicioHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecial.getNombreBienOServicioHistorialProyeccionMunicionEspecial().toUpperCase());
        historialProyeccionMunicionEspecialDTO.setCantidadSolicitadaHistorialProyeccionMunicionEspecial(historialProyeccionMunicionEspecial.getCantidadSolicitadaHistorialProyeccionMunicionEspecial());
        
        //MAPEAR MUNICION ESPECIAL RELACIONADA.
        if (historialProyeccionMunicionEspecial.getMunicionEspecial() != null && historialProyeccionMunicionEspecial.getMunicionEspecial().getIdMunicionEspecial() != null) {
           Optional<MunicionEspecial> municionEspecialFk = municionEspecialRepository.findByIdMunicionEspecial(historialProyeccionMunicionEspecial.getMunicionEspecial().getIdMunicionEspecial());
           municionEspecialFk.ifPresent(munEsp -> historialProyeccionMunicionEspecialDTO.setMunicionEspecialDTO(municionEspecialDAO.municionEspecialDTO(munEsp)));
        }
        
        return historialProyeccionMunicionEspecialDTO;
    }
}
