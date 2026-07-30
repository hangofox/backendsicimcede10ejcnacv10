//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaBajaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DocumentacionAnexaBajaEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DocumentacionAnexaBajaEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaBajaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DocumentacionAnexaBajaEquipoIngenieroRepository;
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
public class DocumentacionAnexaBajaEquipoIngenieroServiceImpl implements DocumentacionAnexaBajaEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DocumentacionAnexaBajaEquipoIngenieroDAO documentacionAnexaBajaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DocumentacionAnexaBajaEquipoIngenieroRepository documentacionAnexaBajaEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDocumentacionAnexaBajaEquipoIngeniero, String keyword, Long idEquipoIngeniero) {
        return documentacionAnexaBajaEquipoIngenieroRepository.findTotalRegistros(idDocumentacionAnexaBajaEquipoIngeniero, keyword, idEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR TODA LA DOCUMENTACION ANEXAS DE LAS BAJAS DE LOS EQUIPOS DE INGENIEROS SIN PAGINACIÓN (PARA SELECTS DEL FRONTEND):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DocumentacionAnexaBajaEquipoIngenieroDTO> listarDocumentacionAnexasBajasEquiposIngenieros(Long idDocumentacionAnexaBajaEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode) {
        List<DocumentacionAnexaBajaEquipoIngeniero> documentacionAnexasBajasEquiposIngenieros = documentacionAnexaBajaEquipoIngenieroRepository.findAllDocumentacionAnexasBajasEquiposIngenieros(idDocumentacionAnexaBajaEquipoIngeniero, keyword, idEquipoIngeniero, orderBy, orderMode);
        List<DocumentacionAnexaBajaEquipoIngenieroDTO> documentacionAnexaBajaEquipoIngeneroDTOS = new ArrayList<>();
        for (DocumentacionAnexaBajaEquipoIngeniero documentacionAnexaBajaEquipoIngeniero : documentacionAnexasBajasEquiposIngenieros) {
            documentacionAnexaBajaEquipoIngeneroDTOS.add(documentacionAnexaBajaEquipoIngenieroDAO.documentacionAnexaBajaEquipoIngenieroDTO(documentacionAnexaBajaEquipoIngeniero));
        }
        
        return documentacionAnexaBajaEquipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR/FILTRAR/ORDENAR/PAGINAR DOCUMENTACION ANEXAS DE LAS BAJAS DE LOS EQUIPOS DE INGENIEROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<DocumentacionAnexaBajaEquipoIngenieroDTO> listarDocumentacionAnexasBajasEquiposIngenierosPag(Pageable pageable, Long idDocumentacionAnexaBajaEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode) {
        Slice<DocumentacionAnexaBajaEquipoIngeniero> documentacionAnexasBajasEquiposIngenieros = documentacionAnexaBajaEquipoIngenieroRepository.findAllDocumentacionAnexasBajasEquiposIngenierosPag(pageable, idDocumentacionAnexaBajaEquipoIngeniero, keyword, idEquipoIngeniero, orderBy, orderMode);
        return documentacionAnexasBajasEquiposIngenieros.map(documentacionAnexaBajaEquipoIngeniero -> documentacionAnexaBajaEquipoIngenieroDAO.documentacionAnexaBajaEquipoIngenieroDTO(documentacionAnexaBajaEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDocumentacionAnexaBajaEquipoIngeniero(DocumentacionAnexaBajaEquipoIngenieroDTO documentacionAnexaBajaEquipoIngenieroDTO) {
        Long maxIdDocumentacionAnexaBajaEquipoIngeniero = documentacionAnexaBajaEquipoIngenieroRepository.findMaxIdDocumentacionAnexaBajaEquipoIngeniero();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        if (maxIdDocumentacionAnexaBajaEquipoIngeniero == null) {
           maxIdDocumentacionAnexaBajaEquipoIngeniero = Long.valueOf(0);
        }
        documentacionAnexaBajaEquipoIngenieroDTO.setIdDocumentacionAnexaBajaEquipoIngeniero(maxIdDocumentacionAnexaBajaEquipoIngeniero + 1);
        documentacionAnexaBajaEquipoIngenieroRepository.save(documentacionAnexaBajaEquipoIngenieroDAO.documentacionAnexaBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDocumentacionAnexaBajaEquipoIngenieroporId(Long idDocumentacionAnexaBajaEquipoIngeniero) {
        Optional<DocumentacionAnexaBajaEquipoIngeniero> documentacionAnexaBajaEquipoIngenieroId = documentacionAnexaBajaEquipoIngenieroRepository.findByIdDocumentacionAnexaBajaEquipoIngeniero(Long.valueOf(idDocumentacionAnexaBajaEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaBajaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setDocumentacionAnexaBajaEquipoIngenieroDTO(documentacionAnexaBajaEquipoIngenieroDAO.documentacionAnexaBajaEquipoIngenieroDTO(documentacionAnexaBajaEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (documentacionAnexaBajaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaBajaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDocumentacionAnexaBajaEquipoIngeniero(DocumentacionAnexaBajaEquipoIngenieroDTO documentacionAnexaBajaEquipoIngenieroDTO) {
        Optional<DocumentacionAnexaBajaEquipoIngeniero> documentacionAnexaBajaEquipoIngenieroId = documentacionAnexaBajaEquipoIngenieroRepository.findByIdDocumentacionAnexaBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO.getIdDocumentacionAnexaBajaEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (documentacionAnexaBajaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           documentacionAnexaBajaEquipoIngenieroRepository.save(documentacionAnexaBajaEquipoIngenieroDAO.documentacionAnexaBajaEquipoIngeniero(documentacionAnexaBajaEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (documentacionAnexaBajaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDocumentacionAnexaBajaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDocumentacionAnexaBajaEquipoIngeniero(Long idDocumentacionAnexaBajaEquipoIngeniero) {
        Optional<DocumentacionAnexaBajaEquipoIngeniero> documentacionAnexaBajaEquipoIngenieroId = documentacionAnexaBajaEquipoIngenieroRepository.findById(idDocumentacionAnexaBajaEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaBajaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           documentacionAnexaBajaEquipoIngenieroRepository.delete(documentacionAnexaBajaEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (documentacionAnexaBajaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaBajaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
