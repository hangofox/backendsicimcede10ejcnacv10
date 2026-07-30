//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesApoyosAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesApoyosAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoAtencPrevEmergDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class IntegrantesApoyosAtencPrevEmergDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoAtencPrevEmergDesastRepository apoyoAtencPrevEmergDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoAtencPrevEmergDesastDAO apoyoAtencPrevEmergDesastDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param integrantesApoyosAtencPrevEmergDesastDTO
    * Recibe un DTO para crear un objeto integrantesApoyosAtencPrevEmergDesast.
    * @return integrantesApoyosAtencPrevEmergDesast
    */
    public IntegrantesApoyosAtencPrevEmergDesast integrantesApoyosAtencPrevEmergDesast(IntegrantesApoyosAtencPrevEmergDesastDTO integrantesApoyosAtencPrevEmergDesastDTO){
        IntegrantesApoyosAtencPrevEmergDesast integrantesApoyosAtencPrevEmergDesast = new IntegrantesApoyosAtencPrevEmergDesast();
        integrantesApoyosAtencPrevEmergDesast.setIdIntegrantesApoyosAtencPrevEmergDesast(integrantesApoyosAtencPrevEmergDesastDTO.getIdIntegrantesApoyosAtencPrevEmergDesast());
        integrantesApoyosAtencPrevEmergDesast.setGradoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getGradoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setNombresJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getNombresJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setPrimerApellidoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getPrimerApellidoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setSegundoApellidoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getSegundoApellidoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setNombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getNombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setCargoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getCargoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setGradoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getGradoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setNombresJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getNombresJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setPrimerApellidoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getPrimerApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setSegundoApellidoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getSegundoApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setCargoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getCargoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setGradoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getGradoCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setNombresCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getNombresCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setPrimerApellidoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getPrimerApellidoCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setSegundoApellidoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getSegundoApellidoCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setNombreArchivoFotoFirmaCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getNombreArchivoFotoFirmaCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesast.setCargoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesastDTO.getCargoCteUnidadMilitar());
        
        //MAPEAR APOYO, ATENCION, PREVENCION Y EMERGENCIA DE DESASTRE RELACIONADO.
        if (integrantesApoyosAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO() != null && integrantesApoyosAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(integrantesApoyosAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(integrantesApoyosAtencPrevEmergDesast::setApoyoAtencPrevEmergDesast);
        }
        
        return integrantesApoyosAtencPrevEmergDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param integrantesApoyosAtencPrevEmergDesast
    * Recibe un objeto integrantesApoyosAtencPrevEmergDesast para crear un DTO.
    * @return integrantesApoyosAtencPrevEmergDesastDTO
    */
    public IntegrantesApoyosAtencPrevEmergDesastDTO integrantesApoyosAtencPrevEmergDesastDTO(IntegrantesApoyosAtencPrevEmergDesast integrantesApoyosAtencPrevEmergDesast){
        IntegrantesApoyosAtencPrevEmergDesastDTO integrantesApoyosAtencPrevEmergDesastDTO = new IntegrantesApoyosAtencPrevEmergDesastDTO();
        integrantesApoyosAtencPrevEmergDesastDTO.setIdIntegrantesApoyosAtencPrevEmergDesast(integrantesApoyosAtencPrevEmergDesast.getIdIntegrantesApoyosAtencPrevEmergDesast());
        integrantesApoyosAtencPrevEmergDesastDTO.setGradoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getGradoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setNombresJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getNombresJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setPrimerApellidoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getPrimerApellidoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setSegundoApellidoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getSegundoApellidoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setNombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getNombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setCargoJefeGestionRiesgoUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getCargoJefeGestionRiesgoUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setGradoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getGradoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setNombresJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getNombresJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setPrimerApellidoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getPrimerApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setSegundoApellidoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getSegundoApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setCargoJefeOperacionesUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getCargoJefeOperacionesUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setGradoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getGradoCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setNombresCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getNombresCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setPrimerApellidoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getPrimerApellidoCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setSegundoApellidoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getSegundoApellidoCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setNombreArchivoFotoFirmaCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getNombreArchivoFotoFirmaCteUnidadMilitar());
        integrantesApoyosAtencPrevEmergDesastDTO.setCargoCteUnidadMilitar(integrantesApoyosAtencPrevEmergDesast.getCargoCteUnidadMilitar());
        
        //MAPEAR APOYO, ATENCION, PREVENCION Y EMERGENCIA DE DESASTRE RELACIONADO.
        if (integrantesApoyosAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast() != null && integrantesApoyosAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(integrantesApoyosAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(apoyoAten -> integrantesApoyosAtencPrevEmergDesastDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyoAten)));
        }
        
        return integrantesApoyosAtencPrevEmergDesastDTO;
    }
}
