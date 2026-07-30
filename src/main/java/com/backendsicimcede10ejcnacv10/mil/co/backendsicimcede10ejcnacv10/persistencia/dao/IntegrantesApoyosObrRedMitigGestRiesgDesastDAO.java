//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesApoyosObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesApoyosObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoObrRedMitigGestRiesgDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class IntegrantesApoyosObrRedMitigGestRiesgDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoObrRedMitigGestRiesgDesastRepository apoyoObrRedMitigGestRiesgDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoObrRedMitigGestRiesgDesastDAO apoyoObrRedMitigGestRiesgDesastDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param integrantesApoyosObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto integrantesApoyosObrRedMitigGestRiesgDesast.
    * @return integrantesApoyosObrRedMitigGestRiesgDesast
    */
    public IntegrantesApoyosObrRedMitigGestRiesgDesast integrantesApoyosObrRedMitigGestRiesgDesast(IntegrantesApoyosObrRedMitigGestRiesgDesastDTO integrantesApoyosObrRedMitigGestRiesgDesastDTO){
        IntegrantesApoyosObrRedMitigGestRiesgDesast integrantesApoyosObrRedMitigGestRiesgDesast = new IntegrantesApoyosObrRedMitigGestRiesgDesast();
        integrantesApoyosObrRedMitigGestRiesgDesast.setIdIntegrantesApoyosObrRedMitigGestRiesgDesast(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getIdIntegrantesApoyosObrRedMitigGestRiesgDesast());
        integrantesApoyosObrRedMitigGestRiesgDesast.setGradoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getGradoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setNombresJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getNombresJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setPrimerApellidoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getPrimerApellidoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setSegundoApellidoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getSegundoApellidoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setNombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getNombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setCargoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getCargoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setGradoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getGradoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setNombresJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getNombresJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setPrimerApellidoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getPrimerApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setSegundoApellidoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getSegundoApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setCargoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getCargoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setGradoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getGradoCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setNombresCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getNombresCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setPrimerApellidoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getPrimerApellidoCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setSegundoApellidoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getSegundoApellidoCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setNombreArchivoFotoFirmaCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getNombreArchivoFotoFirmaCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesast.setCargoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getCargoCteUnidadMilitar());
        
        //MAPEAR APOYO, OBRA, REDUCCION, MITIGACION Y GESTION DEL RIESGO DE DESASTRE RELACIONADO.
        if (integrantesApoyosObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO() != null && integrantesApoyosObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(integrantesApoyosObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(integrantesApoyosObrRedMitigGestRiesgDesast::setApoyoObrRedMitigGestRiesgDesast);
        }
        
        return integrantesApoyosObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param integrantesApoyosObrRedMitigGestRiesgDesast
    * Recibe un objeto integrantesApoyosObrRedMitigGestRiesgDesast para crear un DTO.
    * @return integrantesApoyosObrRedMitigGestRiesgDesastDTO
    */
    public IntegrantesApoyosObrRedMitigGestRiesgDesastDTO integrantesApoyosObrRedMitigGestRiesgDesastDTO(IntegrantesApoyosObrRedMitigGestRiesgDesast integrantesApoyosObrRedMitigGestRiesgDesast){
        IntegrantesApoyosObrRedMitigGestRiesgDesastDTO integrantesApoyosObrRedMitigGestRiesgDesastDTO = new IntegrantesApoyosObrRedMitigGestRiesgDesastDTO();
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setIdIntegrantesApoyosObrRedMitigGestRiesgDesast(integrantesApoyosObrRedMitigGestRiesgDesast.getIdIntegrantesApoyosObrRedMitigGestRiesgDesast());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setGradoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getGradoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setNombresJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getNombresJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setPrimerApellidoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getPrimerApellidoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setSegundoApellidoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getSegundoApellidoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setNombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getNombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setCargoJefeSeccionTecnicaUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getCargoJefeSeccionTecnicaUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setGradoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getGradoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setNombresJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getNombresJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setPrimerApellidoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getPrimerApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setSegundoApellidoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getSegundoApellidoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setCargoJefeOperacionesUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getCargoJefeOperacionesUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setGradoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getGradoCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setNombresCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getNombresCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setPrimerApellidoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getPrimerApellidoCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setSegundoApellidoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getSegundoApellidoCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setNombreArchivoFotoFirmaCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getNombreArchivoFotoFirmaCteUnidadMilitar());
        integrantesApoyosObrRedMitigGestRiesgDesastDTO.setCargoCteUnidadMilitar(integrantesApoyosObrRedMitigGestRiesgDesast.getCargoCteUnidadMilitar());
        
        //MAPEAR APOYO, OBRA, REDUCCION, MITIGACION Y GESTION DEL RIESGO DE DESASTRE RELACIONADO.
        if (integrantesApoyosObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast() != null && integrantesApoyosObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(integrantesApoyosObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(apoyoObr -> integrantesApoyosObrRedMitigGestRiesgDesastDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyoObr)));
        }
        
        return integrantesApoyosObrRedMitigGestRiesgDesastDTO;
    }
}
