//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.AseguradoraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Aseguradora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoIdentificacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDocumentoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class AseguradoraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDocumentoIdentificacionRepository tipoDocumentoIdentificacionRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDocumentoIdentificacionDAO tipoDocumentoIdentificacionDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param aseguradoraDTO
    * Recibe un DTO para crear un objeto aseguradora.
    * @return aseguradora
    */
    public Aseguradora aseguradora(AseguradoraDTO aseguradoraDTO){
        Aseguradora aseguradora = new Aseguradora();
        aseguradora.setIdAseguradora(aseguradoraDTO.getIdAseguradora());
        aseguradora.setNombreAseguradora(aseguradoraDTO.getNombreAseguradora().toUpperCase());
        aseguradora.setNumeroDocumentoIdentificacionAseguradora(aseguradoraDTO.getNumeroDocumentoIdentificacionAseguradora().toUpperCase());
        aseguradora.setPaisOrigenAseguradora(aseguradoraDTO.getPaisOrigenAseguradora().toUpperCase());
        aseguradora.setDepartamentoOEstadoOrigenAseguradora(aseguradoraDTO.getDepartamentoOEstadoOrigenAseguradora().toUpperCase());
        aseguradora.setCiudadOrigenAseguradora(aseguradoraDTO.getCiudadOrigenAseguradora().toUpperCase());
        aseguradora.setDireccionAseguradora(aseguradoraDTO.getDireccionAseguradora().toUpperCase());
        aseguradora.setEstadoAseguradora(aseguradoraDTO.getEstadoAseguradora().toUpperCase());
        
        //MAPEAR TIPO DOCUMENTO IDENTIFICACION RELACIONADO.
        if (aseguradoraDTO.getTipoDocumentoIdentificacionDTO() != null && aseguradoraDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(aseguradoraDTO.getTipoDocumentoIdentificacionDTO().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(aseguradora::setTipoDocumentoIdentificacion);
        }
        
        return aseguradora;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param aseguradora
    * Recibe un objeto aseguradora para crear un DTO.
    * @return aseguradoraDTO
    */
    public AseguradoraDTO aseguradoraDTO(Aseguradora aseguradora){
        AseguradoraDTO aseguradoraDTO = new AseguradoraDTO();
        aseguradoraDTO.setIdAseguradora(aseguradora.getIdAseguradora());
        aseguradoraDTO.setNombreAseguradora(aseguradora.getNombreAseguradora().toUpperCase());
        aseguradoraDTO.setNumeroDocumentoIdentificacionAseguradora(aseguradora.getNumeroDocumentoIdentificacionAseguradora().toUpperCase());
        aseguradoraDTO.setPaisOrigenAseguradora(aseguradora.getPaisOrigenAseguradora().toUpperCase());
        aseguradoraDTO.setDepartamentoOEstadoOrigenAseguradora(aseguradora.getDepartamentoOEstadoOrigenAseguradora().toUpperCase());
        aseguradoraDTO.setCiudadOrigenAseguradora(aseguradora.getCiudadOrigenAseguradora().toUpperCase());
        aseguradoraDTO.setDireccionAseguradora(aseguradora.getDireccionAseguradora().toUpperCase());
        aseguradoraDTO.setEstadoAseguradora(aseguradora.getEstadoAseguradora().toUpperCase());
        
        //MAPEAR TIPO DOCUMENTO IDENTIFICACION RELACIONADO.
        if (aseguradora.getTipoDocumentoIdentificacion() != null && aseguradora.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion() != null) {
           Optional<TipoDocumentoIdentificacion> tipoDocumentoIdentificacionFk = tipoDocumentoIdentificacionRepository.findByIdTipoDocumentoIdentificacion(aseguradora.getTipoDocumentoIdentificacion().getIdTipoDocumentoIdentificacion());
           tipoDocumentoIdentificacionFk.ifPresent(tipoDocIdent -> aseguradoraDTO.setTipoDocumentoIdentificacionDTO(tipoDocumentoIdentificacionDAO.tipoDocumentoIdentificacionDTO(tipoDocIdent)));
        }
        
        return aseguradoraDTO;
    }
}
