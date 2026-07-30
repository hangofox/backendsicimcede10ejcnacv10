//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialIntegranteDocumentosDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CargoIntegranteDocumentos;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialIntegranteDocumentos;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoIdentificacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CargoIntegranteDocumentosRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoIdentificacionRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class HistorialIntegranteDocumentosDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoIdentificacionRepository tipoDocumentoIdentificacionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoIdentificacionDAO tipoDocumentoIdentificacionDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CargoIntegranteDocumentosRepository cargoIntegranteDocumentosRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private CargoIntegranteDocumentosDAO cargoIntegranteDocumentosDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialIntegranteDocumentosDTO
    * Recibe un DTO para crear un objeto historialIntegranteDocumentos.
    * @return historialIntegranteDocumentos
    */
    public HistorialIntegranteDocumentos historialIntegranteDocumentos(HistorialIntegranteDocumentosDTO historialIntegranteDocumentosDTO){
        HistorialIntegranteDocumentos historialIntegranteDocumentos = new HistorialIntegranteDocumentos();
        historialIntegranteDocumentos.setIdHistorialIntegranteDocumentos(historialIntegranteDocumentosDTO.getIdHistorialIntegranteDocumentos());
        historialIntegranteDocumentos.setNumRegHistorialIntegranteDocumentos(historialIntegranteDocumentosDTO.getNumRegHistorialIntegranteDocumentos().toUpperCase());
        historialIntegranteDocumentos.setGradoIntegranteDocumentos(historialIntegranteDocumentosDTO.getGradoIntegranteDocumentos());
        historialIntegranteDocumentos.setNombresYApellidosIntegranteDocumentos(historialIntegranteDocumentosDTO.getNombresYApellidosIntegranteDocumentos());
        historialIntegranteDocumentos.setCargoIntegranteDocumentos(historialIntegranteDocumentosDTO.getCargoIntegranteDocumentos());
        historialIntegranteDocumentos.setNumeroDocumentoIdentificacionIntegranteDocumentos(historialIntegranteDocumentosDTO.getNumeroDocumentoIdentificacionIntegranteDocumentos());
        historialIntegranteDocumentos.setNombreArchivoFotoFirmaIntegranteDocumentos(historialIntegranteDocumentosDTO.getNombreArchivoFotoFirmaIntegranteDocumentos());
        historialIntegranteDocumentos.setSiONoIntegranteDocumentos(historialIntegranteDocumentosDTO.getSiONoIntegranteDocumentos());
        historialIntegranteDocumentos.setSiONoActualIntegranteDocumentosPredeterminado(historialIntegranteDocumentosDTO.getSiONoActualIntegranteDocumentosPredeterminado());
        historialIntegranteDocumentos.setNumeroCursoIntegranteDocumentos(historialIntegranteDocumentosDTO.getNumeroCursoIntegranteDocumentos());
        historialIntegranteDocumentos.setPuestoCursoIntegranteDocumentos(historialIntegranteDocumentosDTO.getPuestoCursoIntegranteDocumentos());
        historialIntegranteDocumentos.setEscalafonAntiguedadIntegranteDocumentos(historialIntegranteDocumentosDTO.getEscalafonAntiguedadIntegranteDocumentos());
        historialIntegranteDocumentos.setFechaHMSIngresoIntegranteDocumentos(historialIntegranteDocumentosDTO.getFechaHMSIngresoIntegranteDocumentos());
        historialIntegranteDocumentos.setFechaHMSModificacionIntegranteDocumentos(historialIntegranteDocumentosDTO.getFechaHMSModificacionIntegranteDocumentos());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialIntegranteDocumentosDTO.getUnidadMilitarDTO() != null && historialIntegranteDocumentosDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialIntegranteDocumentosDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(historialIntegranteDocumentos::setUnidadMilitar);
        }
        
        //MAPEAR TIPO DE DOCUMENTO DE IDENTIFICACIÓN RELACIONADO.
        if (historialIntegranteDocumentosDTO.getTipoDocumentoIdentificacionDTO() != null && historialIntegranteDocumentosDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(historialIntegranteDocumentosDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(historialIntegranteDocumentos::setTipoDocumentoIdentificacion);
        }
        
        //MAPEAR CARGO DE INTEGRANTE DE DOCUMENTOS RELACIONADO.
        if (historialIntegranteDocumentosDTO.getCargoIntegranteDocumentosDTO() != null && historialIntegranteDocumentosDTO.getCargoIntegranteDocumentosDTO().getIdCargoIntegranteDocumentos() != null) {
           Optional<CargoIntegranteDocumentos> cargoIntegranteDocumentosFk = cargoIntegranteDocumentosRepository.findByIdCargoIntegranteDocumentos(historialIntegranteDocumentosDTO.getCargoIntegranteDocumentosDTO().getIdCargoIntegranteDocumentos());
           cargoIntegranteDocumentosFk.ifPresent(historialIntegranteDocumentos::setCargoIntegranteDocumentosFK);
        }
        
        return historialIntegranteDocumentos;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 15/04/2026.
    * @param historialIntegranteDocumentos
    * Recibe un objeto historialIntegranteDocumentos para crear un DTO.
    * @return historialIntegranteDocumentosDTO
    */
    public HistorialIntegranteDocumentosDTO historialIntegranteDocumentosDTO(HistorialIntegranteDocumentos historialIntegranteDocumentos){
        HistorialIntegranteDocumentosDTO historialIntegranteDocumentosDTO = new HistorialIntegranteDocumentosDTO();
        historialIntegranteDocumentosDTO.setIdHistorialIntegranteDocumentos(historialIntegranteDocumentos.getIdHistorialIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setNumRegHistorialIntegranteDocumentos(historialIntegranteDocumentos.getNumRegHistorialIntegranteDocumentos().toUpperCase());
        historialIntegranteDocumentosDTO.setGradoIntegranteDocumentos(historialIntegranteDocumentos.getGradoIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setNombresYApellidosIntegranteDocumentos(historialIntegranteDocumentos.getNombresYApellidosIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setCargoIntegranteDocumentos(historialIntegranteDocumentos.getCargoIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setNumeroDocumentoIdentificacionIntegranteDocumentos(historialIntegranteDocumentos.getNumeroDocumentoIdentificacionIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setNombreArchivoFotoFirmaIntegranteDocumentos(historialIntegranteDocumentos.getNombreArchivoFotoFirmaIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setSiONoIntegranteDocumentos(historialIntegranteDocumentos.getSiONoIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setSiONoActualIntegranteDocumentosPredeterminado(historialIntegranteDocumentos.getSiONoActualIntegranteDocumentosPredeterminado());
        historialIntegranteDocumentosDTO.setNumeroCursoIntegranteDocumentos(historialIntegranteDocumentos.getNumeroCursoIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setPuestoCursoIntegranteDocumentos(historialIntegranteDocumentos.getPuestoCursoIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setEscalafonAntiguedadIntegranteDocumentos(historialIntegranteDocumentos.getEscalafonAntiguedadIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setFechaHMSIngresoIntegranteDocumentos(historialIntegranteDocumentos.getFechaHMSIngresoIntegranteDocumentos());
        historialIntegranteDocumentosDTO.setFechaHMSModificacionIntegranteDocumentos(historialIntegranteDocumentos.getFechaHMSModificacionIntegranteDocumentos());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (historialIntegranteDocumentos.getUnidadMilitar() != null && historialIntegranteDocumentos.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(historialIntegranteDocumentos.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidMil -> historialIntegranteDocumentosDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidMil)));
        }
        
        //MAPEAR TIPO DE DOCUMENTO DE IDENTIFICACIÓN RELACIONADO.
        if (historialIntegranteDocumentos.getTipoDocumentoIdentificacion() != null && historialIntegranteDocumentos.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(historialIntegranteDocumentos.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(tipoDocIdent -> historialIntegranteDocumentosDTO.setTipoDocumentoIdentificacionDTO(tipoDocumentoIdentificacionDAO.tipoDocumentoIdentificacionDTO(tipoDocIdent)));
        }
        
        //MAPEAR CARGO DE INTEGRANTE DE DOCUMENTOS RELACIONADO.
        if (historialIntegranteDocumentos.getCargoIntegranteDocumentosFK() != null && historialIntegranteDocumentos.getCargoIntegranteDocumentosFK().getIdCargoIntegranteDocumentos() != null) {
           Optional<CargoIntegranteDocumentos> cargoIntegranteDocumentosFk = cargoIntegranteDocumentosRepository.findByIdCargoIntegranteDocumentos(historialIntegranteDocumentos.getCargoIntegranteDocumentosFK().getIdCargoIntegranteDocumentos());
           cargoIntegranteDocumentosFk.ifPresent(cargoIntDoc -> historialIntegranteDocumentosDTO.setCargoIntegranteDocumentosDTO(cargoIntegranteDocumentosDAO.cargoIntegranteDocumentosDTO(cargoIntDoc)));
        }
        
        return historialIntegranteDocumentosDTO;
    }
}
