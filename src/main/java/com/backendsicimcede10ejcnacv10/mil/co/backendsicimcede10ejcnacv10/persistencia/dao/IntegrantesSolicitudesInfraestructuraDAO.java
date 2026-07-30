//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesSolicitudesInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesSolicitudesInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class IntegrantesSolicitudesInfraestructuraDAO {

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;

    @Autowired//INYECTAMOS EL DAO.
    private SolicitudInfraestructuraDAO solicitudInfraestructuraDAO;

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param integrantesSolicitudesInfraestructuraDTO
    * Recibe un DTO para crear un objeto integrantesSolicitudesInfraestructura.
    * @return integrantesSolicitudesInfraestructura
    */
    public IntegrantesSolicitudesInfraestructura integrantesSolicitudesInfraestructura(IntegrantesSolicitudesInfraestructuraDTO integrantesSolicitudesInfraestructuraDTO){
        IntegrantesSolicitudesInfraestructura integrantesSolicitudesInfraestructura = new IntegrantesSolicitudesInfraestructura();
        integrantesSolicitudesInfraestructura.setIdIntegrantesSolicitudesInfraestructura(integrantesSolicitudesInfraestructuraDTO.getIdIntegrantesSolicitudesInfraestructura());
        integrantesSolicitudesInfraestructura.setGradoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructuraDTO.getGradoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructura.setNombresJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructuraDTO.getNombresJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructura.setPrimerApellidoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructura.setSegundoApellidoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructura.setCargoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructuraDTO.getCargoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructura.setGradoCteBatallon(integrantesSolicitudesInfraestructuraDTO.getGradoCteBatallon());
        integrantesSolicitudesInfraestructura.setNombresCteBatallon(integrantesSolicitudesInfraestructuraDTO.getNombresCteBatallon());
        integrantesSolicitudesInfraestructura.setPrimerApellidoCteBatallon(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoCteBatallon());
        integrantesSolicitudesInfraestructura.setSegundoApellidoCteBatallon(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoCteBatallon());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaCteBatallon(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaCteBatallon());
        integrantesSolicitudesInfraestructura.setCargoCteBatallon(integrantesSolicitudesInfraestructuraDTO.getCargoCteBatallon());
        integrantesSolicitudesInfraestructura.setGradoCteOJem2doCteWBr(integrantesSolicitudesInfraestructuraDTO.getGradoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructura.setNombresCteOJem2doCteWBr(integrantesSolicitudesInfraestructuraDTO.getNombresCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructura.setPrimerApellidoCteOJem2doCteWBr(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructura.setSegundoApellidoCteOJem2doCteWBr(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaCteOJem2doCteWBr(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructura.setCargoCteOJem2doCteWBr(integrantesSolicitudesInfraestructuraDTO.getCargoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructura.setGradoFincaRaizDiv(integrantesSolicitudesInfraestructuraDTO.getGradoFincaRaizDiv());
        integrantesSolicitudesInfraestructura.setNombresFincaRaizDiv(integrantesSolicitudesInfraestructuraDTO.getNombresFincaRaizDiv());
        integrantesSolicitudesInfraestructura.setPrimerApellidoFincaRaizDiv(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoFincaRaizDiv());
        integrantesSolicitudesInfraestructura.setSegundoApellidoFincaRaizDiv(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoFincaRaizDiv());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaFincaRaizDiv(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaFincaRaizDiv());
        integrantesSolicitudesInfraestructura.setCargoFincaRaizDiv(integrantesSolicitudesInfraestructuraDTO.getCargoFincaRaizDiv());
        integrantesSolicitudesInfraestructura.setGradoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructuraDTO.getGradoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructura.setNombresJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructuraDTO.getNombresJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructura.setPrimerApellidoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructura.setSegundoApellidoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructura.setCargoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructuraDTO.getCargoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructura.setGradoCteDiv(integrantesSolicitudesInfraestructuraDTO.getGradoCteDiv());
        integrantesSolicitudesInfraestructura.setNombresCteDiv(integrantesSolicitudesInfraestructuraDTO.getNombresCteDiv());
        integrantesSolicitudesInfraestructura.setPrimerApellidoCteDiv(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoCteDiv());
        integrantesSolicitudesInfraestructura.setSegundoApellidoCteDiv(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoCteDiv());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaCteDiv(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaCteDiv());
        integrantesSolicitudesInfraestructura.setCargoCteDiv(integrantesSolicitudesInfraestructuraDTO.getCargoCteDiv());
        integrantesSolicitudesInfraestructura.setGradoFincaRaizComando(integrantesSolicitudesInfraestructuraDTO.getGradoFincaRaizComando());
        integrantesSolicitudesInfraestructura.setNombresFincaRaizComando(integrantesSolicitudesInfraestructuraDTO.getNombresFincaRaizComando());
        integrantesSolicitudesInfraestructura.setPrimerApellidoFincaRaizComando(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoFincaRaizComando());
        integrantesSolicitudesInfraestructura.setSegundoApellidoFincaRaizComando(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoFincaRaizComando());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaFincaRaizComando(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaFincaRaizComando());
        integrantesSolicitudesInfraestructura.setCargoFincaRaizComando(integrantesSolicitudesInfraestructuraDTO.getCargoFincaRaizComando());
        integrantesSolicitudesInfraestructura.setGradoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructuraDTO.getGradoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructura.setNombresJefeGestionIngenierosComando(integrantesSolicitudesInfraestructuraDTO.getNombresJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructura.setPrimerApellidoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructura.setSegundoApellidoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaJefeGestionIngenierosComando(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructura.setCargoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructuraDTO.getCargoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructura.setGradoCteComando(integrantesSolicitudesInfraestructuraDTO.getGradoCteComando());
        integrantesSolicitudesInfraestructura.setNombresCteComando(integrantesSolicitudesInfraestructuraDTO.getNombresCteComando());
        integrantesSolicitudesInfraestructura.setPrimerApellidoCteComando(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoCteComando());
        integrantesSolicitudesInfraestructura.setSegundoApellidoCteComando(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoCteComando());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaCteComando(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaCteComando());
        integrantesSolicitudesInfraestructura.setCargoCteComando(integrantesSolicitudesInfraestructuraDTO.getCargoCteComando());
        integrantesSolicitudesInfraestructura.setGradoFincaRaizCede(integrantesSolicitudesInfraestructuraDTO.getGradoFincaRaizCede());
        integrantesSolicitudesInfraestructura.setNombresFincaRaizCede(integrantesSolicitudesInfraestructuraDTO.getNombresFincaRaizCede());
        integrantesSolicitudesInfraestructura.setPrimerApellidoFincaRaizCede(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoFincaRaizCede());
        integrantesSolicitudesInfraestructura.setSegundoApellidoFincaRaizCede(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoFincaRaizCede());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaFincaRaizCede(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaFincaRaizCede());
        integrantesSolicitudesInfraestructura.setCargoFincaRaizCede(integrantesSolicitudesInfraestructuraDTO.getCargoFincaRaizCede());
        integrantesSolicitudesInfraestructura.setGradoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructuraDTO.getGradoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructura.setNombresJefeGestionIngenierosCede(integrantesSolicitudesInfraestructuraDTO.getNombresJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructura.setPrimerApellidoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructura.setSegundoApellidoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaJefeGestionIngenierosCede(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructura.setCargoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructuraDTO.getCargoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructura.setGradoCteCede(integrantesSolicitudesInfraestructuraDTO.getGradoCteCede());
        integrantesSolicitudesInfraestructura.setNombresCteCede(integrantesSolicitudesInfraestructuraDTO.getNombresCteCede());
        integrantesSolicitudesInfraestructura.setPrimerApellidoCteCede(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoCteCede());
        integrantesSolicitudesInfraestructura.setSegundoApellidoCteCede(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoCteCede());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaCteCede(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaCteCede());
        integrantesSolicitudesInfraestructura.setCargoCteCede(integrantesSolicitudesInfraestructuraDTO.getCargoCteCede());
        integrantesSolicitudesInfraestructura.setGradoFincaRaizJef(integrantesSolicitudesInfraestructuraDTO.getGradoFincaRaizJef());
        integrantesSolicitudesInfraestructura.setNombresFincaRaizJef(integrantesSolicitudesInfraestructuraDTO.getNombresFincaRaizJef());
        integrantesSolicitudesInfraestructura.setPrimerApellidoFincaRaizJef(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoFincaRaizJef());
        integrantesSolicitudesInfraestructura.setSegundoApellidoFincaRaizJef(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoFincaRaizJef());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaFincaRaizJef(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaFincaRaizJef());
        integrantesSolicitudesInfraestructura.setCargoFincaRaizJef(integrantesSolicitudesInfraestructuraDTO.getCargoFincaRaizJef());
        integrantesSolicitudesInfraestructura.setGradoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructuraDTO.getGradoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructura.setNombresJefeGestionIngenierosJef(integrantesSolicitudesInfraestructuraDTO.getNombresJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructura.setPrimerApellidoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructura.setSegundoApellidoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaJefeGestionIngenierosJef(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructura.setCargoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructuraDTO.getCargoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructura.setGradoCteJef(integrantesSolicitudesInfraestructuraDTO.getGradoCteJef());
        integrantesSolicitudesInfraestructura.setNombresCteJef(integrantesSolicitudesInfraestructuraDTO.getNombresCteJef());
        integrantesSolicitudesInfraestructura.setPrimerApellidoCteJef(integrantesSolicitudesInfraestructuraDTO.getPrimerApellidoCteJef());
        integrantesSolicitudesInfraestructura.setSegundoApellidoCteJef(integrantesSolicitudesInfraestructuraDTO.getSegundoApellidoCteJef());
        integrantesSolicitudesInfraestructura.setNombreArchivoFotoFirmaCteJef(integrantesSolicitudesInfraestructuraDTO.getNombreArchivoFotoFirmaCteJef());
        integrantesSolicitudesInfraestructura.setCargoCteJef(integrantesSolicitudesInfraestructuraDTO.getCargoCteJef());

        //MAPEAR SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (integrantesSolicitudesInfraestructuraDTO.getSolicitudInfraestructuraDTO() != null && integrantesSolicitudesInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(integrantesSolicitudesInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(integrantesSolicitudesInfraestructura::setSolicitudInfraestructura);
        }

        return integrantesSolicitudesInfraestructura;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/04/2026.
    * @param integrantesSolicitudesInfraestructura
    * Recibe un objeto integrantesSolicitudesInfraestructura para crear un DTO.
    * @return integrantesSolicitudesInfraestructuraDTO
    */
    public IntegrantesSolicitudesInfraestructuraDTO integrantesSolicitudesInfraestructuraDTO(IntegrantesSolicitudesInfraestructura integrantesSolicitudesInfraestructura){
        IntegrantesSolicitudesInfraestructuraDTO integrantesSolicitudesInfraestructuraDTO = new IntegrantesSolicitudesInfraestructuraDTO();
        integrantesSolicitudesInfraestructuraDTO.setIdIntegrantesSolicitudesInfraestructura(integrantesSolicitudesInfraestructura.getIdIntegrantesSolicitudesInfraestructura());
        integrantesSolicitudesInfraestructuraDTO.setGradoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructura.getGradoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructuraDTO.setNombresJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructura.getNombresJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructura.getPrimerApellidoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructura.getSegundoApellidoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructuraDTO.setCargoJefeGestionIngenierosBatallon(integrantesSolicitudesInfraestructura.getCargoJefeGestionIngenierosBatallon());
        integrantesSolicitudesInfraestructuraDTO.setGradoCteBatallon(integrantesSolicitudesInfraestructura.getGradoCteBatallon());
        integrantesSolicitudesInfraestructuraDTO.setNombresCteBatallon(integrantesSolicitudesInfraestructura.getNombresCteBatallon());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoCteBatallon(integrantesSolicitudesInfraestructura.getPrimerApellidoCteBatallon());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoCteBatallon(integrantesSolicitudesInfraestructura.getSegundoApellidoCteBatallon());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaCteBatallon(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaCteBatallon());
        integrantesSolicitudesInfraestructuraDTO.setCargoCteBatallon(integrantesSolicitudesInfraestructura.getCargoCteBatallon());
        integrantesSolicitudesInfraestructuraDTO.setGradoCteOJem2doCteWBr(integrantesSolicitudesInfraestructura.getGradoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructuraDTO.setNombresCteOJem2doCteWBr(integrantesSolicitudesInfraestructura.getNombresCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoCteOJem2doCteWBr(integrantesSolicitudesInfraestructura.getPrimerApellidoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoCteOJem2doCteWBr(integrantesSolicitudesInfraestructura.getSegundoApellidoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaCteOJem2doCteWBr(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructuraDTO.setCargoCteOJem2doCteWBr(integrantesSolicitudesInfraestructura.getCargoCteOJem2doCteWBr());
        integrantesSolicitudesInfraestructuraDTO.setGradoFincaRaizDiv(integrantesSolicitudesInfraestructura.getGradoFincaRaizDiv());
        integrantesSolicitudesInfraestructuraDTO.setNombresFincaRaizDiv(integrantesSolicitudesInfraestructura.getNombresFincaRaizDiv());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoFincaRaizDiv(integrantesSolicitudesInfraestructura.getPrimerApellidoFincaRaizDiv());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoFincaRaizDiv(integrantesSolicitudesInfraestructura.getSegundoApellidoFincaRaizDiv());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaFincaRaizDiv(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaFincaRaizDiv());
        integrantesSolicitudesInfraestructuraDTO.setCargoFincaRaizDiv(integrantesSolicitudesInfraestructura.getCargoFincaRaizDiv());
        integrantesSolicitudesInfraestructuraDTO.setGradoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructura.getGradoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructuraDTO.setNombresJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructura.getNombresJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructura.getPrimerApellidoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructura.getSegundoApellidoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructuraDTO.setCargoJefeGestionIngenierosDiv(integrantesSolicitudesInfraestructura.getCargoJefeGestionIngenierosDiv());
        integrantesSolicitudesInfraestructuraDTO.setGradoCteDiv(integrantesSolicitudesInfraestructura.getGradoCteDiv());
        integrantesSolicitudesInfraestructuraDTO.setNombresCteDiv(integrantesSolicitudesInfraestructura.getNombresCteDiv());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoCteDiv(integrantesSolicitudesInfraestructura.getPrimerApellidoCteDiv());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoCteDiv(integrantesSolicitudesInfraestructura.getSegundoApellidoCteDiv());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaCteDiv(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaCteDiv());
        integrantesSolicitudesInfraestructuraDTO.setCargoCteDiv(integrantesSolicitudesInfraestructura.getCargoCteDiv());
        integrantesSolicitudesInfraestructuraDTO.setGradoFincaRaizComando(integrantesSolicitudesInfraestructura.getGradoFincaRaizComando());
        integrantesSolicitudesInfraestructuraDTO.setNombresFincaRaizComando(integrantesSolicitudesInfraestructura.getNombresFincaRaizComando());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoFincaRaizComando(integrantesSolicitudesInfraestructura.getPrimerApellidoFincaRaizComando());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoFincaRaizComando(integrantesSolicitudesInfraestructura.getSegundoApellidoFincaRaizComando());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaFincaRaizComando(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaFincaRaizComando());
        integrantesSolicitudesInfraestructuraDTO.setCargoFincaRaizComando(integrantesSolicitudesInfraestructura.getCargoFincaRaizComando());
        integrantesSolicitudesInfraestructuraDTO.setGradoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructura.getGradoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructuraDTO.setNombresJefeGestionIngenierosComando(integrantesSolicitudesInfraestructura.getNombresJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructura.getPrimerApellidoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructura.getSegundoApellidoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaJefeGestionIngenierosComando(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructuraDTO.setCargoJefeGestionIngenierosComando(integrantesSolicitudesInfraestructura.getCargoJefeGestionIngenierosComando());
        integrantesSolicitudesInfraestructuraDTO.setGradoCteComando(integrantesSolicitudesInfraestructura.getGradoCteComando());
        integrantesSolicitudesInfraestructuraDTO.setNombresCteComando(integrantesSolicitudesInfraestructura.getNombresCteComando());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoCteComando(integrantesSolicitudesInfraestructura.getPrimerApellidoCteComando());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoCteComando(integrantesSolicitudesInfraestructura.getSegundoApellidoCteComando());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaCteComando(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaCteComando());
        integrantesSolicitudesInfraestructuraDTO.setCargoCteComando(integrantesSolicitudesInfraestructura.getCargoCteComando());
        integrantesSolicitudesInfraestructuraDTO.setGradoFincaRaizCede(integrantesSolicitudesInfraestructura.getGradoFincaRaizCede());
        integrantesSolicitudesInfraestructuraDTO.setNombresFincaRaizCede(integrantesSolicitudesInfraestructura.getNombresFincaRaizCede());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoFincaRaizCede(integrantesSolicitudesInfraestructura.getPrimerApellidoFincaRaizCede());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoFincaRaizCede(integrantesSolicitudesInfraestructura.getSegundoApellidoFincaRaizCede());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaFincaRaizCede(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaFincaRaizCede());
        integrantesSolicitudesInfraestructuraDTO.setCargoFincaRaizCede(integrantesSolicitudesInfraestructura.getCargoFincaRaizCede());
        integrantesSolicitudesInfraestructuraDTO.setGradoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructura.getGradoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructuraDTO.setNombresJefeGestionIngenierosCede(integrantesSolicitudesInfraestructura.getNombresJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructura.getPrimerApellidoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructura.getSegundoApellidoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaJefeGestionIngenierosCede(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructuraDTO.setCargoJefeGestionIngenierosCede(integrantesSolicitudesInfraestructura.getCargoJefeGestionIngenierosCede());
        integrantesSolicitudesInfraestructuraDTO.setGradoCteCede(integrantesSolicitudesInfraestructura.getGradoCteCede());
        integrantesSolicitudesInfraestructuraDTO.setNombresCteCede(integrantesSolicitudesInfraestructura.getNombresCteCede());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoCteCede(integrantesSolicitudesInfraestructura.getPrimerApellidoCteCede());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoCteCede(integrantesSolicitudesInfraestructura.getSegundoApellidoCteCede());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaCteCede(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaCteCede());
        integrantesSolicitudesInfraestructuraDTO.setCargoCteCede(integrantesSolicitudesInfraestructura.getCargoCteCede());
        integrantesSolicitudesInfraestructuraDTO.setGradoFincaRaizJef(integrantesSolicitudesInfraestructura.getGradoFincaRaizJef());
        integrantesSolicitudesInfraestructuraDTO.setNombresFincaRaizJef(integrantesSolicitudesInfraestructura.getNombresFincaRaizJef());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoFincaRaizJef(integrantesSolicitudesInfraestructura.getPrimerApellidoFincaRaizJef());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoFincaRaizJef(integrantesSolicitudesInfraestructura.getSegundoApellidoFincaRaizJef());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaFincaRaizJef(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaFincaRaizJef());
        integrantesSolicitudesInfraestructuraDTO.setCargoFincaRaizJef(integrantesSolicitudesInfraestructura.getCargoFincaRaizJef());
        integrantesSolicitudesInfraestructuraDTO.setGradoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructura.getGradoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructuraDTO.setNombresJefeGestionIngenierosJef(integrantesSolicitudesInfraestructura.getNombresJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructura.getPrimerApellidoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructura.getSegundoApellidoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaJefeGestionIngenierosJef(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructuraDTO.setCargoJefeGestionIngenierosJef(integrantesSolicitudesInfraestructura.getCargoJefeGestionIngenierosJef());
        integrantesSolicitudesInfraestructuraDTO.setGradoCteJef(integrantesSolicitudesInfraestructura.getGradoCteJef());
        integrantesSolicitudesInfraestructuraDTO.setNombresCteJef(integrantesSolicitudesInfraestructura.getNombresCteJef());
        integrantesSolicitudesInfraestructuraDTO.setPrimerApellidoCteJef(integrantesSolicitudesInfraestructura.getPrimerApellidoCteJef());
        integrantesSolicitudesInfraestructuraDTO.setSegundoApellidoCteJef(integrantesSolicitudesInfraestructura.getSegundoApellidoCteJef());
        integrantesSolicitudesInfraestructuraDTO.setNombreArchivoFotoFirmaCteJef(integrantesSolicitudesInfraestructura.getNombreArchivoFotoFirmaCteJef());
        integrantesSolicitudesInfraestructuraDTO.setCargoCteJef(integrantesSolicitudesInfraestructura.getCargoCteJef());

        //MAPEAR SOLICITUD INFRAESTRUCTURA RELACIONADA.
        if (integrantesSolicitudesInfraestructura.getSolicitudInfraestructura() != null && integrantesSolicitudesInfraestructura.getSolicitudInfraestructura().getIdSolicitudInfraestructura() != null) {
           Optional<SolicitudInfraestructura> solicitudInfraestructuraFk = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(integrantesSolicitudesInfraestructura.getSolicitudInfraestructura().getIdSolicitudInfraestructura());
           solicitudInfraestructuraFk.ifPresent(solicInfr -> integrantesSolicitudesInfraestructuraDTO.setSolicitudInfraestructuraDTO(solicitudInfraestructuraDAO.solicitudInfraestructuraDTO(solicInfr)));
        }

        return integrantesSolicitudesInfraestructuraDTO;
    }
}
