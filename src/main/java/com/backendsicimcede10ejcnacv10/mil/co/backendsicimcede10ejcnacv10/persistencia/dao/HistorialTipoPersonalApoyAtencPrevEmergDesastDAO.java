//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialTipoPersonalApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialTipoPersonalApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoPersonalApoyo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoAtencPrevEmergDesastRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoPersonalApoyoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialTipoPersonalApoyAtencPrevEmergDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoAtencPrevEmergDesastRepository apoyoAtencPrevEmergDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoAtencPrevEmergDesastDAO apoyoAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoPersonalApoyoRepository tipoPersonalApoyoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoPersonalApoyoDAO tipoPersonalApoyoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialTipoPersonalApoyAtencPrevEmergDesastDTO
    * Recibe un DTO para crear un objeto historialTipoPersonalApoyAtencPrevEmergDesast.
    * @return historialTipoPersonalApoyAtencPrevEmergDesast
    */
    public HistorialTipoPersonalApoyAtencPrevEmergDesast historialTipoPersonalApoyAtencPrevEmergDesast(HistorialTipoPersonalApoyAtencPrevEmergDesastDTO historialTipoPersonalApoyAtencPrevEmergDesastDTO){
        HistorialTipoPersonalApoyAtencPrevEmergDesast historialTipoPersonalApoyAtencPrevEmergDesast = new HistorialTipoPersonalApoyAtencPrevEmergDesast();
        historialTipoPersonalApoyAtencPrevEmergDesast.setIdHistorialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getIdHistorialTipoPersonalApoyAtencPrevEmergDesast());
        historialTipoPersonalApoyAtencPrevEmergDesast.setNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast().toUpperCase());
        historialTipoPersonalApoyAtencPrevEmergDesast.setCantidadPersonalApoyo(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getCantidadPersonalApoyo());
        historialTipoPersonalApoyAtencPrevEmergDesast.setDiasEmpleadosTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getDiasEmpleadosTipoPersonalApoyAtencPrevEmergDesast());
        
        //MAPEAR APOYO DE ATENCIÓN, PREVENCIÓN DE EMERGENCIAS Y DESASTRES RELACIONADO.
        if (historialTipoPersonalApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO() != null && historialTipoPersonalApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(historialTipoPersonalApoyAtencPrevEmergDesast::setApoyoAtencPrevEmergDesast);
        }
        
        //MAPEAR TIPO DE PERSONAL DE APOYO RELACIONADO.
        if (historialTipoPersonalApoyAtencPrevEmergDesastDTO.getTipoPersonalApoyoDTO() != null && historialTipoPersonalApoyAtencPrevEmergDesastDTO.getTipoPersonalApoyoDTO().getIdTipoPersonalApoyo() != null) {
           Optional<TipoPersonalApoyo> tipoPersonalApoyoFk = tipoPersonalApoyoRepository.findByIdTipoPersonalApoyo(historialTipoPersonalApoyAtencPrevEmergDesastDTO.getTipoPersonalApoyoDTO().getIdTipoPersonalApoyo());
           tipoPersonalApoyoFk.ifPresent(historialTipoPersonalApoyAtencPrevEmergDesast::setTipoPersonalApoyo);
        }
        
        return historialTipoPersonalApoyAtencPrevEmergDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialTipoPersonalApoyAtencPrevEmergDesast
    * Recibe un objeto historialTipoPersonalApoyAtencPrevEmergDesast para crear un DTO.
    * @return historialTipoPersonalApoyAtencPrevEmergDesastDTO
    */
    public HistorialTipoPersonalApoyAtencPrevEmergDesastDTO historialTipoPersonalApoyAtencPrevEmergDesastDTO(HistorialTipoPersonalApoyAtencPrevEmergDesast historialTipoPersonalApoyAtencPrevEmergDesast){
        HistorialTipoPersonalApoyAtencPrevEmergDesastDTO historialTipoPersonalApoyAtencPrevEmergDesastDTO = new HistorialTipoPersonalApoyAtencPrevEmergDesastDTO();
        historialTipoPersonalApoyAtencPrevEmergDesastDTO.setIdHistorialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesast.getIdHistorialTipoPersonalApoyAtencPrevEmergDesast());
        historialTipoPersonalApoyAtencPrevEmergDesastDTO.setNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesast.getNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast().toUpperCase());
        historialTipoPersonalApoyAtencPrevEmergDesastDTO.setCantidadPersonalApoyo(historialTipoPersonalApoyAtencPrevEmergDesast.getCantidadPersonalApoyo());
        historialTipoPersonalApoyAtencPrevEmergDesastDTO.setDiasEmpleadosTipoPersonalApoyAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesast.getDiasEmpleadosTipoPersonalApoyAtencPrevEmergDesast());
        
        //MAPEAR APOYO DE ATENCIÓN, PREVENCIÓN DE EMERGENCIAS Y DESASTRES RELACIONADO.
        if (historialTipoPersonalApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast() != null && historialTipoPersonalApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialTipoPersonalApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(apoyoAtencPrevEmergDesast -> historialTipoPersonalApoyAtencPrevEmergDesastDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesast)));
        }
        
        //MAPEAR TIPO DE PERSONAL DE APOYO RELACIONADO.
        if (historialTipoPersonalApoyAtencPrevEmergDesast.getTipoPersonalApoyo() != null && historialTipoPersonalApoyAtencPrevEmergDesast.getTipoPersonalApoyo().getIdTipoPersonalApoyo() != null) {
           Optional<TipoPersonalApoyo> tipoPersonalApoyoFk = tipoPersonalApoyoRepository.findByIdTipoPersonalApoyo(historialTipoPersonalApoyAtencPrevEmergDesast.getTipoPersonalApoyo().getIdTipoPersonalApoyo());
           tipoPersonalApoyoFk.ifPresent(tipoPersonalApoyo -> historialTipoPersonalApoyAtencPrevEmergDesastDTO.setTipoPersonalApoyoDTO(tipoPersonalApoyoDAO.tipoPersonalApoyoDTO(tipoPersonalApoyo)));
        }
        
        return historialTipoPersonalApoyAtencPrevEmergDesastDTO;
    }
}
