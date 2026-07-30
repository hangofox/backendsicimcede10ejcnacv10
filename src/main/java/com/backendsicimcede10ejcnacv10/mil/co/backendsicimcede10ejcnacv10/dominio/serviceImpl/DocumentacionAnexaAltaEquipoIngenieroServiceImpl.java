//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaAltaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DocumentacionAnexaAltaEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DocumentacionAnexaAltaEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaAltaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DocumentacionAnexaAltaEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class DocumentacionAnexaAltaEquipoIngenieroServiceImpl implements DocumentacionAnexaAltaEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DocumentacionAnexaAltaEquipoIngenieroDAO documentacionAnexaAltaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DocumentacionAnexaAltaEquipoIngenieroRepository documentacionAnexaAltaEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDocumentacionAnexaAltaEquipoIngeniero, String keyword, Long idEquipoIngeniero) {
        return documentacionAnexaAltaEquipoIngenieroRepository.findTotalRegistros(idDocumentacionAnexaAltaEquipoIngeniero, keyword, idEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR TODA LA DOCUMENTACION ANEXAS DE LAS ALTAS DE LOS EQUIPOS DE INGENIEROS SIN PAGINACIÓN (PARA SELECTS DEL FRONTEND):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DocumentacionAnexaAltaEquipoIngenieroDTO> listarDocumentacionAnexasAltasEquiposIngenieros(Long idDocumentacionAnexaAltaEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode) {
        List<DocumentacionAnexaAltaEquipoIngeniero> documentacionAnexasAltasEquiposIngenieros = documentacionAnexaAltaEquipoIngenieroRepository.findAllDocumentacionAnexasAltasEquiposIngenieros(idDocumentacionAnexaAltaEquipoIngeniero, keyword, idEquipoIngeniero, orderBy, orderMode);
        List<DocumentacionAnexaAltaEquipoIngenieroDTO> documentacionAnexaAltaEquipoIngeneroDTOS = new ArrayList<>();
        for (DocumentacionAnexaAltaEquipoIngeniero documentacionAnexaAltaEquipoIngeniero : documentacionAnexasAltasEquiposIngenieros) {
            documentacionAnexaAltaEquipoIngeneroDTOS.add(documentacionAnexaAltaEquipoIngenieroDAO.documentacionAnexaAltaEquipoIngenieroDTO(documentacionAnexaAltaEquipoIngeniero));
        }
        
        return documentacionAnexaAltaEquipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR/FILTRAR/ORDENAR/PAGINAR DOCUMENTACION ANEXAS DE LAS ALTAS DE LOS EQUIPOS DE INGENIEROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<DocumentacionAnexaAltaEquipoIngenieroDTO> listarDocumentacionAnexasAltasEquiposIngenierosPag(Pageable pageable, Long idDocumentacionAnexaAltaEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode) {
        Slice<DocumentacionAnexaAltaEquipoIngeniero> documentacionAnexasAltasEquiposIngenieros = documentacionAnexaAltaEquipoIngenieroRepository.findAllDocumentacionAnexasAltasEquiposIngenierosPag(pageable, idDocumentacionAnexaAltaEquipoIngeniero, keyword, idEquipoIngeniero, orderBy, orderMode);
        return documentacionAnexasAltasEquiposIngenieros.map(documentacionAnexaAltaEquipoIngeniero -> documentacionAnexaAltaEquipoIngenieroDAO.documentacionAnexaAltaEquipoIngenieroDTO(documentacionAnexaAltaEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDocumentacionAnexaAltaEquipoIngeniero(DocumentacionAnexaAltaEquipoIngenieroDTO documentacionAnexaAltaEquipoIngenieroDTO) {
        Long maxIdDocumentacionAnexaAltaEquipoIngeniero = documentacionAnexaAltaEquipoIngenieroRepository.findMaxIdDocumentacionAnexaAltaEquipoIngeniero();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        if (maxIdDocumentacionAnexaAltaEquipoIngeniero == null) {
           maxIdDocumentacionAnexaAltaEquipoIngeniero = Long.valueOf(0);
        }
        documentacionAnexaAltaEquipoIngenieroDTO.setIdDocumentacionAnexaAltaEquipoIngeniero(maxIdDocumentacionAnexaAltaEquipoIngeniero + 1);
        documentacionAnexaAltaEquipoIngenieroRepository.save(documentacionAnexaAltaEquipoIngenieroDAO.documentacionAnexaAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDocumentacionAnexaAltaEquipoIngenieroporId(Long idDocumentacionAnexaAltaEquipoIngeniero) {
        Optional<DocumentacionAnexaAltaEquipoIngeniero> documentacionAnexaAltaEquipoIngenieroId = documentacionAnexaAltaEquipoIngenieroRepository.findByIdDocumentacionAnexaAltaEquipoIngeniero(Long.valueOf(idDocumentacionAnexaAltaEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaAltaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setDocumentacionAnexaAltaEquipoIngenieroDTO(documentacionAnexaAltaEquipoIngenieroDAO.documentacionAnexaAltaEquipoIngenieroDTO(documentacionAnexaAltaEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (documentacionAnexaAltaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDocumentacionAnexaAltaEquipoIngeniero(DocumentacionAnexaAltaEquipoIngenieroDTO documentacionAnexaAltaEquipoIngenieroDTO) {
        Optional<DocumentacionAnexaAltaEquipoIngeniero> documentacionAnexaAltaEquipoIngenieroId = documentacionAnexaAltaEquipoIngenieroRepository.findByIdDocumentacionAnexaAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO.getIdDocumentacionAnexaAltaEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (documentacionAnexaAltaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           documentacionAnexaAltaEquipoIngenieroRepository.save(documentacionAnexaAltaEquipoIngenieroDAO.documentacionAnexaAltaEquipoIngeniero(documentacionAnexaAltaEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (documentacionAnexaAltaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDocumentacionAnexaAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDocumentacionAnexaAltaEquipoIngeniero(Long idDocumentacionAnexaAltaEquipoIngeniero) {
        Optional<DocumentacionAnexaAltaEquipoIngeniero> documentacionAnexaAltaEquipoIngenieroId = documentacionAnexaAltaEquipoIngenieroRepository.findById(idDocumentacionAnexaAltaEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaAltaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           documentacionAnexaAltaEquipoIngenieroRepository.delete(documentacionAnexaAltaEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (documentacionAnexaAltaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaAltaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
