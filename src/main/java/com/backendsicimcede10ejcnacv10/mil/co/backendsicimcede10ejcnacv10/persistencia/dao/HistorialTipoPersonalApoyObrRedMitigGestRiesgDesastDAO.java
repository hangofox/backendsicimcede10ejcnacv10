//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoPersonalApoyo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoObrRedMitigGestRiesgDesastRepository;
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
public class HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoObrRedMitigGestRiesgDesastRepository apoyoObrRedMitigGestRiesgDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoObrRedMitigGestRiesgDesastDAO apoyoObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoPersonalApoyoRepository tipoPersonalApoyoRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoPersonalApoyoDAO tipoPersonalApoyoDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto historialTipoPersonalApoyObrRedMitigGestRiesgDesast.
    * @return historialTipoPersonalApoyObrRedMitigGestRiesgDesast
    */
    public HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast historialTipoPersonalApoyObrRedMitigGestRiesgDesast(HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO){
        HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast historialTipoPersonalApoyObrRedMitigGestRiesgDesast = new HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast();
        historialTipoPersonalApoyObrRedMitigGestRiesgDesast.setIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast());
        historialTipoPersonalApoyObrRedMitigGestRiesgDesast.setNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast().toUpperCase());
        historialTipoPersonalApoyObrRedMitigGestRiesgDesast.setCantidadPersonalApoyo(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getCantidadPersonalApoyo());
        historialTipoPersonalApoyObrRedMitigGestRiesgDesast.setNombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getNombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO DE OBRA DE REDUCCIÓN, MITIGACIÓN Y GESTIÓN DEL RIESGO DE DESASTRES RELACIONADO.
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO() != null && historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(historialTipoPersonalApoyObrRedMitigGestRiesgDesast::setApoyoObrRedMitigGestRiesgDesast);
        }
        
        //MAPEAR TIPO DE PERSONAL DE APOYO RELACIONADO.
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getTipoPersonalApoyoDTO() != null && historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getTipoPersonalApoyoDTO().getIdTipoPersonalApoyo() != null) {
           Optional<TipoPersonalApoyo> tipoPersonalApoyoFk = tipoPersonalApoyoRepository.findByIdTipoPersonalApoyo(historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.getTipoPersonalApoyoDTO().getIdTipoPersonalApoyo());
           tipoPersonalApoyoFk.ifPresent(historialTipoPersonalApoyObrRedMitigGestRiesgDesast::setTipoPersonalApoyo);
        }
        
        return historialTipoPersonalApoyObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialTipoPersonalApoyObrRedMitigGestRiesgDesast
    * Recibe un objeto historialTipoPersonalApoyObrRedMitigGestRiesgDesast para crear un DTO.
    * @return historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO
    */
    public HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO(HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast historialTipoPersonalApoyObrRedMitigGestRiesgDesast){
        HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO = new HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO();
        historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast());
        historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast().toUpperCase());
        historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setCantidadPersonalApoyo(historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getCantidadPersonalApoyo());
        historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setNombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getNombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO DE OBRA DE REDUCCIÓN, MITIGACIÓN Y GESTIÓN DEL RIESGO DE DESASTRES RELACIONADO.
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast() != null && historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(apoyoObrRedMitigGestRiesg -> historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesg)));
        }
        
        //MAPEAR TIPO DE PERSONAL DE APOYO RELACIONADO.
        if (historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getTipoPersonalApoyo() != null && historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getTipoPersonalApoyo().getIdTipoPersonalApoyo() != null) {
           Optional<TipoPersonalApoyo> tipoPersonalApoyoFk = tipoPersonalApoyoRepository.findByIdTipoPersonalApoyo(historialTipoPersonalApoyObrRedMitigGestRiesgDesast.getTipoPersonalApoyo().getIdTipoPersonalApoyo());
           tipoPersonalApoyoFk.ifPresent(tipoPersonalApoyo -> historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO.setTipoPersonalApoyoDTO(tipoPersonalApoyoDAO.tipoPersonalApoyoDTO(tipoPersonalApoyo)));
        }
        
        return historialTipoPersonalApoyObrRedMitigGestRiesgDesastDTO;
    }
}
