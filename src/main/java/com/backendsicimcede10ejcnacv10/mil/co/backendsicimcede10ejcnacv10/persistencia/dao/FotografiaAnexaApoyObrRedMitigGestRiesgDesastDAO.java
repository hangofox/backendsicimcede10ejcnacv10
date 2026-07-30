//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoObrRedMitigGestRiesgDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class FotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoObrRedMitigGestRiesgDesastRepository apoyoObrRedMitigGestRiesgDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoObrRedMitigGestRiesgDesastDAO apoyoObrRedMitigGestRiesgDesastDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO
    * Recibe un DTO para crear un objeto fotografiaAnexaApoyObrRedMitigGestRiesgDesast.
    * @return fotografiaAnexaApoyObrRedMitigGestRiesgDesast
    */
    public FotografiaAnexaApoyObrRedMitigGestRiesgDesast fotografiaAnexaApoyObrRedMitigGestRiesgDesast(FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO){
        FotografiaAnexaApoyObrRedMitigGestRiesgDesast fotografiaAnexaApoyObrRedMitigGestRiesgDesast = new FotografiaAnexaApoyObrRedMitigGestRiesgDesast();
        fotografiaAnexaApoyObrRedMitigGestRiesgDesast.setIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast());
        fotografiaAnexaApoyObrRedMitigGestRiesgDesast.setNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1());
        fotografiaAnexaApoyObrRedMitigGestRiesgDesast.setNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2());
        
        //MAPEAR APOYO, OBRA, REDUCCION, MITIGACION, GESTION DEL RIESGO Y DESASTRE RELACIONADO.
        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO() != null && fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(fotografiaAnexaApoyObrRedMitigGestRiesgDesast::setApoyoObrRedMitigGestRiesgDesast);
        }
        
        return fotografiaAnexaApoyObrRedMitigGestRiesgDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param fotografiaAnexaApoyObrRedMitigGestRiesgDesast
    * Recibe un objeto fotografiaAnexaApoyObrRedMitigGestRiesgDesast para crear un DTO.
    * @return fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO
    */
    public FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(FotografiaAnexaApoyObrRedMitigGestRiesgDesast fotografiaAnexaApoyObrRedMitigGestRiesgDesast){
        FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO = new FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO();
        fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.setIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesast.getIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast());
        fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.setNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1(fotografiaAnexaApoyObrRedMitigGestRiesgDesast.getNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1());
        fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.setNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2(fotografiaAnexaApoyObrRedMitigGestRiesgDesast.getNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2());
        
        //MAPEAR APOYO, OBRA, REDUCCION, MITIGACION, GESTION DEL RIESGO Y DESASTRE RELACIONADO.
        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast() != null && fotografiaAnexaApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast() != null) {
           Optional<ApoyoObrRedMitigGestRiesgDesast> apoyoObrRedMitigGestRiesgDesastFk = apoyoObrRedMitigGestRiesgDesastRepository.findByIdApoyoObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesast.getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast());
           apoyoObrRedMitigGestRiesgDesastFk.ifPresent(apoyObrRedMitGestRiesgDes -> fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.setApoyoObrRedMitigGestRiesgDesastDTO(apoyoObrRedMitigGestRiesgDesastDAO.apoyoObrRedMitigGestRiesgDesastDTO(apoyObrRedMitGestRiesgDes)));
        }
        
        return fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO;
    }
}
