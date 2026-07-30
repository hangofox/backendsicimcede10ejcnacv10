//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FotografiaAnexaSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class FotografiaAnexaSolicInfraestDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private SolicitudInfraestructuraDAO solicitudInfraestructuraDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param fotografiaAnexaSolicInfraestDTO
    * Recibe un DTO para crear un objeto fotografiaAnexaSolicInfraest.
    * @return fotografiaAnexaSolicInfraest
    */
    public FotografiaAnexaSolicInfraest fotografiaAnexaSolicInfraest(FotografiaAnexaSolicInfraestDTO fotografiaAnexaSolicInfraestDTO){
        FotografiaAnexaSolicInfraest fotografiaAnexaSolicInfraest = new FotografiaAnexaSolicInfraest();
        fotografiaAnexaSolicInfraest.setIdFotografiasAnexasSolicInfraest(fotografiaAnexaSolicInfraestDTO.getIdFotografiasAnexasSolicInfraest());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoVistaSolicInfraest1(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoVistaSolicInfraest1());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoVistaSolicInfraest2(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoVistaSolicInfraest2());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1());
        fotografiaAnexaSolicInfraest.setNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2(fotografiaAnexaSolicInfraestDTO.getNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2());
        
        //MAPEAR SOLICITUD DE INFRAESTRUCTURA RELACIONADA.
        if (fotografiaAnexaSolicInfraestDTO.getSolicitudInfraestructuraDTO() != null && fotografiaAnexaSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(fotografiaAnexaSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(fotografiaAnexaSolicInfraest::setSolicitudInfraestructura);
        }
        
        return fotografiaAnexaSolicInfraest;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 31/03/2026.
    * @param fotografiaAnexaSolicInfraest
    * Recibe un objeto fotografiaAnexaSolicInfraest para crear un DTO.
    * @return fotografiaAnexaSolicInfraestDTO
    */
    public FotografiaAnexaSolicInfraestDTO fotografiaAnexaSolicInfraestDTO(FotografiaAnexaSolicInfraest fotografiaAnexaSolicInfraest){
        FotografiaAnexaSolicInfraestDTO fotografiaAnexaSolicInfraestDTO = new FotografiaAnexaSolicInfraestDTO();
        fotografiaAnexaSolicInfraestDTO.setIdFotografiasAnexasSolicInfraest(fotografiaAnexaSolicInfraest.getIdFotografiasAnexasSolicInfraest());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoVistaSolicInfraest1(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoVistaSolicInfraest1());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoVistaSolicInfraest2(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoVistaSolicInfraest2());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1());
        fotografiaAnexaSolicInfraestDTO.setNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2(fotografiaAnexaSolicInfraest.getNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2());
        
        //MAPEAR SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (fotografiaAnexaSolicInfraest.getSolicitudInfraestructura() != null && fotografiaAnexaSolicInfraest.getSolicitudInfraestructura().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(fotografiaAnexaSolicInfraest.getSolicitudInfraestructura().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(solicInfra -> fotografiaAnexaSolicInfraestDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicInfra)));
        }
        
        return fotografiaAnexaSolicInfraestDTO;
    }
}
