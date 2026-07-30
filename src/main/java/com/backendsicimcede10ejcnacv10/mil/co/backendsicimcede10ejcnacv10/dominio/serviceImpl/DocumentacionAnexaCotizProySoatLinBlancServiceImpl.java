//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaCotizProySoatLinBlancDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DocumentacionAnexaCotizProySoatLinBlancService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DocumentacionAnexaCotizProySoatLinBlancDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizProySoatLinBlanc;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DocumentacionAnexaCotizProySoatLinBlancRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 09/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class DocumentacionAnexaCotizProySoatLinBlancServiceImpl implements DocumentacionAnexaCotizProySoatLinBlancService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DocumentacionAnexaCotizProySoatLinBlancDAO documentacionAnexaCotizProySoatLinBlancDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DocumentacionAnexaCotizProySoatLinBlancRepository documentacionAnexaCotizProySoatLinBlancRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDocumentacionAnexaCotizProySoatLinBlanc, String keyword, Long idProyeccionSoatLineaBlanca) {
        return documentacionAnexaCotizProySoatLinBlancRepository.findTotalRegistros(idDocumentacionAnexaCotizProySoatLinBlanc, keyword, idProyeccionSoatLineaBlanca);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR TODA LA DOCUMENTACION ANEXAS DE LAS COTIZACIONES DE LAS PROYECCIONES DEL SOAT DE LAS LINEAS BLANCAS SIN PAGINACIÓN (PARA SELECTS DEL FRONTEND):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DocumentacionAnexaCotizProySoatLinBlancDTO> listarDocumentacionAnexasCotizProySoatLinBlanc(Long idDocumentacionAnexaCotizProySoatLinBlanc, String keyword, Long idProyeccionSoatLineaBlanca, String orderBy, String orderMode) {
        List<DocumentacionAnexaCotizProySoatLinBlanc> documentacionAnexasCotizProySoatLinBlanc = documentacionAnexaCotizProySoatLinBlancRepository.findAllDocumentacionesAnexasCotizProySoatLinBlanc(idDocumentacionAnexaCotizProySoatLinBlanc, keyword, idProyeccionSoatLineaBlanca, orderBy, orderMode);
        List<DocumentacionAnexaCotizProySoatLinBlancDTO> documentacionAnexaCotizProySoatLinBlancDTOS = new ArrayList<>();
        for (DocumentacionAnexaCotizProySoatLinBlanc documentacionAnexaCotizProySoatLinBlanc : documentacionAnexasCotizProySoatLinBlanc) {
            documentacionAnexaCotizProySoatLinBlancDTOS.add(documentacionAnexaCotizProySoatLinBlancDAO.documentacionAnexaCotizProySoatLinBlancDTO(documentacionAnexaCotizProySoatLinBlanc));
        }
        
        return documentacionAnexaCotizProySoatLinBlancDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR/FILTRAR/ORDENAR/PAGINAR DOCUMENTACION ANEXAS DE LAS COTIZACIONES DE LAS PROYECCIONES DEL SOAT DE LAS LINEAS BLANCAS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<DocumentacionAnexaCotizProySoatLinBlancDTO> listarDocumentacionAnexasCotizProySoatLinBlancPag(Pageable pageable, Long idDocumentacionAnexaCotizProySoatLinBlanc, String keyword, Long idProyeccionSoatLineaBlanca, String orderBy, String orderMode) {
        Slice<DocumentacionAnexaCotizProySoatLinBlanc> documentacionAnexasCotizProySoatLinBlanc = documentacionAnexaCotizProySoatLinBlancRepository.findAllDocumentacionesAnexasCotizProySoatLinBlancPag(pageable, idDocumentacionAnexaCotizProySoatLinBlanc, keyword, idProyeccionSoatLineaBlanca, orderBy, orderMode);
        return documentacionAnexasCotizProySoatLinBlanc.map(docAnexaCotizProySoatLinBlanc -> documentacionAnexaCotizProySoatLinBlancDAO.documentacionAnexaCotizProySoatLinBlancDTO(docAnexaCotizProySoatLinBlanc));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDocumentacionAnexaCotizProySoatLinBlanc(DocumentacionAnexaCotizProySoatLinBlancDTO documentacionAnexaCotizProySoatLinBlancDTO) {
        Long maxIdDocumentacionAnexaCotizProySoatLinBlanc = documentacionAnexaCotizProySoatLinBlancRepository.findMaxIdDocumentacionAnexaCotizProySoatLinBlanc();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdDocumentacionAnexaCotizProySoatLinBlanc == null) {
           maxIdDocumentacionAnexaCotizProySoatLinBlanc = Long.valueOf(0);
        }
        documentacionAnexaCotizProySoatLinBlancDTO.setIdDocumentacionAnexaCotizProySoatLinBlanc(maxIdDocumentacionAnexaCotizProySoatLinBlanc + 1);
        
        documentacionAnexaCotizProySoatLinBlancRepository.save(documentacionAnexaCotizProySoatLinBlancDAO.documentacionAnexaCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlancDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDocumentacionAnexaCotizProySoatLinBlancporId(Long idDocumentacionAnexaCotizProySoatLinBlanc) {
        Optional<DocumentacionAnexaCotizProySoatLinBlanc> documentacionAnexaCotizProySoatLinBlancId = documentacionAnexaCotizProySoatLinBlancRepository.findByIdDocumentacionAnexaCotizProySoatLinBlanc(Long.valueOf(idDocumentacionAnexaCotizProySoatLinBlanc));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaCotizProySoatLinBlancId.isPresent() == true) {
           respuestaDTO.setDocumentacionAnexaCotizProySoatLinBlancDTO(documentacionAnexaCotizProySoatLinBlancDAO.documentacionAnexaCotizProySoatLinBlancDTO(documentacionAnexaCotizProySoatLinBlancId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (documentacionAnexaCotizProySoatLinBlancId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaCotizProySoatLinBlancDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDocumentacionAnexaCotizProySoatLinBlanc(DocumentacionAnexaCotizProySoatLinBlancDTO documentacionAnexaCotizProySoatLinBlancDTO) {
        Optional<DocumentacionAnexaCotizProySoatLinBlanc> documentacionAnexaCotizProySoatLinBlancId = documentacionAnexaCotizProySoatLinBlancRepository.findByIdDocumentacionAnexaCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlancDTO.getIdDocumentacionAnexaCotizProySoatLinBlanc());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (documentacionAnexaCotizProySoatLinBlancId.isPresent() == true) {
           documentacionAnexaCotizProySoatLinBlancRepository.save(documentacionAnexaCotizProySoatLinBlancDAO.documentacionAnexaCotizProySoatLinBlanc(documentacionAnexaCotizProySoatLinBlancDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (documentacionAnexaCotizProySoatLinBlancId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDocumentacionAnexaCotizProySoatLinBlancDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDocumentacionAnexaCotizProySoatLinBlanc(Long idDocumentacionAnexaCotizProySoatLinBlanc) {
        Optional<DocumentacionAnexaCotizProySoatLinBlanc> documentacionAnexaCotizProySoatLinBlancId = documentacionAnexaCotizProySoatLinBlancRepository.findById(idDocumentacionAnexaCotizProySoatLinBlanc);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaCotizProySoatLinBlancId.isPresent() == true) {
           respuestaDTO.setDocumentacionAnexaCotizProySoatLinBlancDTO(documentacionAnexaCotizProySoatLinBlancDAO.documentacionAnexaCotizProySoatLinBlancDTO(documentacionAnexaCotizProySoatLinBlancId.get()));
           documentacionAnexaCotizProySoatLinBlancRepository.delete(documentacionAnexaCotizProySoatLinBlancId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (documentacionAnexaCotizProySoatLinBlancId.isPresent() == false) {
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaCotizProySoatLinBlancDTO(null);
        }
        
        return respuestaDTO;
    }
}
