//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMaqPesadApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMaqPesadApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaquinariaPesada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoAtencPrevEmergDesastRepository;
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
public class HistorialMaqPesadApoyAtencPrevEmergDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoAtencPrevEmergDesastRepository apoyoAtencPrevEmergDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoAtencPrevEmergDesastDAO apoyoAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private MaquinariaPesadaRepository maquinariaPesadaRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private MaquinariaPesadaDAO maquinariaPesadaDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMaqPesadApoyAtencPrevEmergDesastDTO
    * Recibe un DTO para crear un objeto historialMaqPesadApoyAtencPrevEmergDesast.
    * @return historialMaqPesadApoyAtencPrevEmergDesast
    */
    public HistorialMaqPesadApoyAtencPrevEmergDesast historialMaqPesadApoyAtencPrevEmergDesast(HistorialMaqPesadApoyAtencPrevEmergDesastDTO historialMaqPesadApoyAtencPrevEmergDesastDTO){
        HistorialMaqPesadApoyAtencPrevEmergDesast historialMaqPesadApoyAtencPrevEmergDesast = new HistorialMaqPesadApoyAtencPrevEmergDesast();
        historialMaqPesadApoyAtencPrevEmergDesast.setIdHistorialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO.getIdHistorialMaqPesadApoyAtencPrevEmergDesast());
        historialMaqPesadApoyAtencPrevEmergDesast.setNumRegHistorialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO.getNumRegHistorialMaqPesadApoyAtencPrevEmergDesast().toUpperCase());
        historialMaqPesadApoyAtencPrevEmergDesast.setDiasEmpleadosMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO.getDiasEmpleadosMaqPesadApoyAtencPrevEmergDesast());
        
        //MAPEAR APOYO DE ATENCIÓN, PREVENCIÓN DE EMERGENCIAS Y DESASTRES RELACIONADO.
        if (historialMaqPesadApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO() != null && historialMaqPesadApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(historialMaqPesadApoyAtencPrevEmergDesast::setApoyoAtencPrevEmergDesast);
        }
        
        //MAPEAR MAQUINARIA PESADA RELACIONADA.
        if (historialMaqPesadApoyAtencPrevEmergDesastDTO.getMaquinariaPesadaDTO() != null && historialMaqPesadApoyAtencPrevEmergDesastDTO.getMaquinariaPesadaDTO().getIdMaquinariaPesada() != null) {
           Optional<MaquinariaPesada> maquinariaPesadaFk = maquinariaPesadaRepository.findByIdMaquinariaPesada(historialMaqPesadApoyAtencPrevEmergDesastDTO.getMaquinariaPesadaDTO().getIdMaquinariaPesada());
           maquinariaPesadaFk.ifPresent(historialMaqPesadApoyAtencPrevEmergDesast::setMaquinariaPesada);
        }
        
        return historialMaqPesadApoyAtencPrevEmergDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialMaqPesadApoyAtencPrevEmergDesast
    * Recibe un objeto historialMaqPesadApoyAtencPrevEmergDesast para crear un DTO.
    * @return historialMaqPesadApoyAtencPrevEmergDesastDTO
    */
    public HistorialMaqPesadApoyAtencPrevEmergDesastDTO historialMaqPesadApoyAtencPrevEmergDesastDTO(HistorialMaqPesadApoyAtencPrevEmergDesast historialMaqPesadApoyAtencPrevEmergDesast){
        HistorialMaqPesadApoyAtencPrevEmergDesastDTO historialMaqPesadApoyAtencPrevEmergDesastDTO = new HistorialMaqPesadApoyAtencPrevEmergDesastDTO();
        historialMaqPesadApoyAtencPrevEmergDesastDTO.setIdHistorialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesast.getIdHistorialMaqPesadApoyAtencPrevEmergDesast());
        historialMaqPesadApoyAtencPrevEmergDesastDTO.setNumRegHistorialMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesast.getNumRegHistorialMaqPesadApoyAtencPrevEmergDesast().toUpperCase());
        historialMaqPesadApoyAtencPrevEmergDesastDTO.setDiasEmpleadosMaqPesadApoyAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesast.getDiasEmpleadosMaqPesadApoyAtencPrevEmergDesast());
        
        //MAPEAR APOYO DE ATENCIÓN, PREVENCIÓN DE EMERGENCIAS Y DESASTRES RELACIONADO.
        if (historialMaqPesadApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast() != null && historialMaqPesadApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(historialMaqPesadApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(apoyoAtencPrevEmergDesast -> historialMaqPesadApoyAtencPrevEmergDesastDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesast)));
        }
        
        //MAPEAR MAQUINARIA PESADA RELACIONADA.
        if (historialMaqPesadApoyAtencPrevEmergDesast.getMaquinariaPesada() != null && historialMaqPesadApoyAtencPrevEmergDesast.getMaquinariaPesada().getIdMaquinariaPesada() != null) {
           Optional<MaquinariaPesada> maquinariaPesadaFk = maquinariaPesadaRepository.findByIdMaquinariaPesada(historialMaqPesadApoyAtencPrevEmergDesast.getMaquinariaPesada().getIdMaquinariaPesada());
           maquinariaPesadaFk.ifPresent(maqPesada -> historialMaqPesadApoyAtencPrevEmergDesastDTO.setMaquinariaPesadaDTO(maquinariaPesadaDAO.maquinariaPesadaDTO(maqPesada)));
        }
        
        return historialMaqPesadApoyAtencPrevEmergDesastDTO;
    }
}
