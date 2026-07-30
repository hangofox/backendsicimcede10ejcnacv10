//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FotografiaAnexaApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ApoyoAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ApoyoAtencPrevEmergDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class FotografiaAnexaApoyAtencPrevEmergDesastDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ApoyoAtencPrevEmergDesastRepository apoyoAtencPrevEmergDesastRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private ApoyoAtencPrevEmergDesastDAO apoyoAtencPrevEmergDesastDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param fotografiaAnexaApoyAtencPrevEmergDesastDTO
    * Recibe un DTO para crear un objeto fotografiaAnexaApoyAtencPrevEmergDesast.
    * @return fotografiaAnexaApoyAtencPrevEmergDesast
    */
    public FotografiaAnexaApoyAtencPrevEmergDesast fotografiaAnexaApoyAtencPrevEmergDesast(FotografiaAnexaApoyAtencPrevEmergDesastDTO fotografiaAnexaApoyAtencPrevEmergDesastDTO){
        FotografiaAnexaApoyAtencPrevEmergDesast fotografiaAnexaApoyAtencPrevEmergDesast = new FotografiaAnexaApoyAtencPrevEmergDesast();
        fotografiaAnexaApoyAtencPrevEmergDesast.setIdFotografiasAnexasApoyAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getIdFotografiasAnexasApoyAtencPrevEmergDesast());
        fotografiaAnexaApoyAtencPrevEmergDesast.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1());
        fotografiaAnexaApoyAtencPrevEmergDesast.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2());
        fotografiaAnexaApoyAtencPrevEmergDesast.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3());
        fotografiaAnexaApoyAtencPrevEmergDesast.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4());
        
        //MAPEAR APOYO, ATENCION, PREVENCION, EMERGENCIA Y DESASTRE RELACIONADO.
        if (fotografiaAnexaApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO() != null && fotografiaAnexaApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(fotografiaAnexaApoyAtencPrevEmergDesast::setApoyoAtencPrevEmergDesast);
        }
        
        return fotografiaAnexaApoyAtencPrevEmergDesast;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param fotografiaAnexaApoyAtencPrevEmergDesast
    * Recibe un objeto fotografiaAnexaApoyAtencPrevEmergDesast para crear un DTO.
    * @return fotografiaAnexaApoyAtencPrevEmergDesastDTO
    */
    public FotografiaAnexaApoyAtencPrevEmergDesastDTO fotografiaAnexaApoyAtencPrevEmergDesastDTO(FotografiaAnexaApoyAtencPrevEmergDesast fotografiaAnexaApoyAtencPrevEmergDesast){
        FotografiaAnexaApoyAtencPrevEmergDesastDTO fotografiaAnexaApoyAtencPrevEmergDesastDTO = new FotografiaAnexaApoyAtencPrevEmergDesastDTO();
        fotografiaAnexaApoyAtencPrevEmergDesastDTO.setIdFotografiasAnexasApoyAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesast.getIdFotografiasAnexasApoyAtencPrevEmergDesast());
        fotografiaAnexaApoyAtencPrevEmergDesastDTO.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1(fotografiaAnexaApoyAtencPrevEmergDesast.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1());
        fotografiaAnexaApoyAtencPrevEmergDesastDTO.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2(fotografiaAnexaApoyAtencPrevEmergDesast.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2());
        fotografiaAnexaApoyAtencPrevEmergDesastDTO.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3(fotografiaAnexaApoyAtencPrevEmergDesast.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3());
        fotografiaAnexaApoyAtencPrevEmergDesastDTO.setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4(fotografiaAnexaApoyAtencPrevEmergDesast.getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4());
        
        //MAPEAR APOYO, ATENCION, PREVENCION, EMERGENCIA Y DESASTRE RELACIONADO.
        if (fotografiaAnexaApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast() != null && fotografiaAnexaApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast() != null) {
           Optional<ApoyoAtencPrevEmergDesast> apoyoAtencPrevEmergDesastFk = apoyoAtencPrevEmergDesastRepository.findByIdApoyoAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesast.getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast());
           apoyoAtencPrevEmergDesastFk.ifPresent(apoyAtencPrevEmergDes -> fotografiaAnexaApoyAtencPrevEmergDesastDTO.setApoyoAtencPrevEmergDesastDTO(apoyoAtencPrevEmergDesastDAO.apoyoAtencPrevEmergDesastDTO(apoyAtencPrevEmergDes)));
        }
        
        return fotografiaAnexaApoyAtencPrevEmergDesastDTO;
    }
}
