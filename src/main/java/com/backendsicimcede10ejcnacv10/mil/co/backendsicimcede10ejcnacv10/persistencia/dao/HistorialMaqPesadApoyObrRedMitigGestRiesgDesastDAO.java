//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaquinariaPesada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoObrRedMitigGestRiesgDesastRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.MaquinariaPesadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoObrRedMitigGestRiesgDesastRepository apoyoObrRedMitigGestRiesgDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoObrRedMitigGestRiesgDesastDAO apoyoObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private MaquinariaPesadaRepository maquinariaPesadaRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private MaquinariaPesadaDAO maquinariaPesadaDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto historialMaqPesadApoyObrRedMitigGestRiesgDesast.
    * @return historialMaqPesadApoyObrRedMitigGestRiesgDesast
    */
    public HistorialMaqPesadApoyObrRedMitigGestRiesgDesast historialMaqPesadApoyObrRedMitigGestRiesgDesast(HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO){
        HistorialMaqPesadApoyObrRedMitigGestRiesgDesast historialMaqPesadApoyObrRedMitigGestRiesgDesast = new HistorialMaqPesadApoyObrRedMitigGestRiesgDesast();
        historialMaqPesadApoyObrRedMitigGestRiesgDesast.setIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast());
        historialMaqPesadApoyObrRedMitigGestRiesgDesast.setNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast().toUpperCase());
        historialMaqPesadApoyObrRedMitigGestRiesgDesast.setTotalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getTotalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO DE OBRA DE REDUCCIÓN, MITIGACIÓN Y GESTIÓN DEL RIESGO DE DESASTRES RELACIONADO.
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO() != null && historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(historialMaqPesadApoyObrRedMitigGestRiesgDesast::setApoyoObrRedMitigGestRiesgDesast);
        }
        
        //MAPEAR MAQUINARIA PESADA RELACIONADA.
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getMaquinariaPesadaDTO() != null && historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getMaquinariaPesadaDTO().getIdMaquinariaPesada() != null) {
           Optional<MaquinariaPesada> maquinariaPesadaFk = maquinariaPesadaRepository.findByIdMaquinariaPesada(historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.getMaquinariaPesadaDTO().getIdMaquinariaPesada());
           maquinariaPesadaFk.ifPresent(historialMaqPesadApoyObrRedMitigGestRiesgDesast::setMaquinariaPesada);
        }
        
        return historialMaqPesadApoyObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMaqPesadApoyObrRedMitigGestRiesgDesast
    * Recibe un objeto historialMaqPesadApoyObrRedMitigGestRiesgDesast para crear un DTO.
    * @return historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO
    */
    public HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO(HistorialMaqPesadApoyObrRedMitigGestRiesgDesast historialMaqPesadApoyObrRedMitigGestRiesgDesast){
        HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO = new HistorialMaqPesadApoyObrRedMitigGestRiesgDesastDTO();
        historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.setIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesast.getIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast());
        historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.setNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesast.getNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast().toUpperCase());
        historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.setTotalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesast.getTotalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast());
        
        //MAPEAR APOYO DE OBRA DE REDUCCIÓN, MITIGACIÓN Y GESTIÓN DEL RIESGO DE DESASTRES RELACIONADO.
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast() != null && historialMaqPesadApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(historialMaqPesadApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(apoyoObrRedMitigGestRiesg -> historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesg)));
        }
        
        //MAPEAR MAQUINARIA PESADA RELACIONADA.
        if (historialMaqPesadApoyObrRedMitigGestRiesgDesast.getMaquinariaPesada() != null && historialMaqPesadApoyObrRedMitigGestRiesgDesast.getMaquinariaPesada().getIdMaquinariaPesada() != null) {
           Optional<MaquinariaPesada> maquinariaPesadaFk = maquinariaPesadaRepository.findByIdMaquinariaPesada(historialMaqPesadApoyObrRedMitigGestRiesgDesast.getMaquinariaPesada().getIdMaquinariaPesada());
           maquinariaPesadaFk.ifPresent(maqPesada -> historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO.setMaquinariaPesadaDTO(maquinariaPesadaDAO.maquinariaPesadaDTO(maqPesada)));
        }
        
        return historialMaqPesadApoyObrRedMitigGestRiesgDesastDTO;
    }
}
