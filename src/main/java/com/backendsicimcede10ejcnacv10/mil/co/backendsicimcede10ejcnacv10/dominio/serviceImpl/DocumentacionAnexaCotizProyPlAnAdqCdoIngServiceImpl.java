//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DocumentacionAnexaCotizProyPlAnAdqCdoIngService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DocumentacionAnexaCotizProyPlAnAdqCdoIngDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DocumentacionAnexaCotizProyPlAnAdqCdoIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DocumentacionAnexaCotizProyPlAnAdqCdoIngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class DocumentacionAnexaCotizProyPlAnAdqCdoIngServiceImpl implements DocumentacionAnexaCotizProyPlAnAdqCdoIngService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DocumentacionAnexaCotizProyPlAnAdqCdoIngDAO documentacionAnexaCotizProyPlAnAdqCdoIngDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DocumentacionAnexaCotizProyPlAnAdqCdoIngRepository documentacionAnexaCotizProyPlAnAdqCdoIngRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, String keyword, Long idProyeccionPlanAnualAdqCdoIng) {
        return documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findTotalRegistros(idDocumentacionAnexaCotizProyPlAnAdqCdoIng, keyword, idProyeccionPlanAnualAdqCdoIng);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR TODA LA DOCUMENTACION ANEXAS DE LAS COTIZACIONES DE LAS PROYECCIONES DE LA PLANEACION ANUAL DE ADQUISICION DEL COMANDO DE INGENIEROS SIN PAGINACIÓN (PARA SELECTS DEL FRONTEND):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO> listarDocumentacionAnexasCotizProyPlAnAdqCdoIng(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, String keyword, Long idProyeccionPlanAnualAdqCdoIng, String orderBy, String orderMode) {
        List<DocumentacionAnexaCotizProyPlAnAdqCdoIng> documentacionAnexasCotizProyPlAnAdqCdoIng = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findAllDocumentacionesAnexasCotizProyPlAnAdqCdoIng(idDocumentacionAnexaCotizProyPlAnAdqCdoIng, keyword, idProyeccionPlanAnualAdqCdoIng, orderBy, orderMode);
        List<DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO> documentacionAnexaCotizProyPlAnAdqCdoIngDTOS = new ArrayList<>();
        for (DocumentacionAnexaCotizProyPlAnAdqCdoIng documentacionAnexaCotizProyPlAnAdqCdoIng : documentacionAnexasCotizProyPlAnAdqCdoIng) {
            documentacionAnexaCotizProyPlAnAdqCdoIngDTOS.add(documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIngDTO(documentacionAnexaCotizProyPlAnAdqCdoIng));
        }
        
        return documentacionAnexaCotizProyPlAnAdqCdoIngDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR/FILTRAR/ORDENAR/PAGINAR DOCUMENTACION ANEXAS DE LAS COTIZACIONES DE LAS PROYECCIONES DE LA PLANEACION ANUAL DE ADQUISICION DEL COMANDO DE INGENIEROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO> listarDocumentacionAnexasCotizProyPlAnAdqCdoIngPag(Pageable pageable, Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, String keyword, Long idProyeccionPlanAnualAdqCdoIng, String orderBy, String orderMode) {
        Slice<DocumentacionAnexaCotizProyPlAnAdqCdoIng> documentacionAnexasCotizProyPlAnAdqCdoIng = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findAllDocumentacionesAnexasCotizProyPlAnAdqCdoIngPag(pageable, idDocumentacionAnexaCotizProyPlAnAdqCdoIng, keyword, idProyeccionPlanAnualAdqCdoIng, orderBy, orderMode);
        return documentacionAnexasCotizProyPlAnAdqCdoIng.map(docAnexaCotizProyPlAnAdqCdoIng -> documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIngDTO(docAnexaCotizProyPlAnAdqCdoIng));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDocumentacionAnexaCotizProyPlAnAdqCdoIng(DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO documentacionAnexaCotizProyPlAnAdqCdoIngDTO) {
        Long maxIdDocumentacionAnexaCotizProyPlAnAdqCdoIng = null;
        DocumentacionAnexaCotizProyPlAnAdqCdoIng documentacionAnexaCotizProyPlAnAdqCdoIngNombreEIdProyeccionPlanAnualAdqCdoIng = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findByNombreAndIdProyeccionPlanAnualAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng().toUpperCase(), documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO().getIdProyeccionPlanAnualAdqCdoIng());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(documentacionAnexaCotizProyPlAnAdqCdoIngNombreEIdProyeccionPlanAnualAdqCdoIng == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ASOCIADO A LA MISMA PROYECCION PLAN ANUAL ADQ CDO ING MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO A LA MISMA PROYECCION PLAN ANUAL ADQ CDO ING MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_DOCUMENTACION_ANEXA_COTIZ_PROY_PL_AN_ADQ_CDO_ING_YA_EXISTE_EN_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING, false);
           respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO A LA MISMA PROYECCION PLAN ANUAL ADQ CDO ING CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdDocumentacionAnexaCotizProyPlAnAdqCdoIng = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findMaxIdDocumentacionAnexaCotizProyPlAnAdqCdoIng();
           if (maxIdDocumentacionAnexaCotizProyPlAnAdqCdoIng == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdDocumentacionAnexaCotizProyPlAnAdqCdoIng = Long.valueOf(0);
           }
           documentacionAnexaCotizProyPlAnAdqCdoIngDTO.setIdDocumentacionAnexaCotizProyPlAnAdqCdoIng(maxIdDocumentacionAnexaCotizProyPlAnAdqCdoIng + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           documentacionAnexaCotizProyPlAnAdqCdoIngRepository.save(documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDocumentacionAnexaCotizProyPlAnAdqCdoIngporId(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng) {
        Optional<DocumentacionAnexaCotizProyPlAnAdqCdoIng> documentacionAnexaCotizProyPlAnAdqCdoIngId = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findByIdDocumentacionAnexaCotizProyPlAnAdqCdoIng(Long.valueOf(idDocumentacionAnexaCotizProyPlAnAdqCdoIng));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaCotizProyPlAnAdqCdoIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIngDTO(documentacionAnexaCotizProyPlAnAdqCdoIngId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (documentacionAnexaCotizProyPlAnAdqCdoIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDocumentacionAnexaCotizProyPlAnAdqCdoIng(DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO documentacionAnexaCotizProyPlAnAdqCdoIngDTO) {
        Optional<DocumentacionAnexaCotizProyPlAnAdqCdoIng> documentacionAnexaCotizProyPlAnAdqCdoIngId = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findByIdDocumentacionAnexaCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getIdDocumentacionAnexaCotizProyPlAnAdqCdoIng());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (documentacionAnexaCotizProyPlAnAdqCdoIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ((documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng().equals(documentacionAnexaCotizProyPlAnAdqCdoIngId.get().getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng()) == true)) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI LA PROYECCION PLAN ANUAL ADQ CDO ING CAMBIO.
              if (documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO().getIdProyeccionPlanAnualAdqCdoIng().equals(documentacionAnexaCotizProyPlAnAdqCdoIngId.get().getProyeccionPlanAnualAdqCdoIng().getIdProyeccionPlanAnualAdqCdoIng()) == true) {//SI LA PROYECCION PLAN ANUAL ADQ CDO ING NO CAMBIO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 documentacionAnexaCotizProyPlAnAdqCdoIngRepository.save(documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO().getIdProyeccionPlanAnualAdqCdoIng().equals(documentacionAnexaCotizProyPlAnAdqCdoIngId.get().getProyeccionPlanAnualAdqCdoIng().getIdProyeccionPlanAnualAdqCdoIng()) == false) {//SI LA PROYECCION PLAN ANUAL ADQ CDO ING CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN LA NUEVA PROYECCION PLAN ANUAL ADQ CDO ING.
                 DocumentacionAnexaCotizProyPlAnAdqCdoIng documentacionAnexaCotizProyPlAnAdqCdoIngNombreEIdProyeccionPlanAnualAdqCdoIng = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findByNombreAndIdProyeccionPlanAnualAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng().toUpperCase(), documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO().getIdProyeccionPlanAnualAdqCdoIng());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(documentacionAnexaCotizProyPlAnAdqCdoIngNombreEIdProyeccionPlanAnualAdqCdoIng == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO A LA NUEVA PROYECCION PLAN ANUAL ADQ CDO ING MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN LA NUEVA PROYECCION PLAN ANUAL ADQ CDO ING MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_DOCUMENTACION_ANEXA_COTIZ_PROY_PL_AN_ADQ_CDO_ING_NO_MODIFICAR_EN_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING, false);
                    respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN LA NUEVA PROYECCION PLAN ANUAL ADQ CDO ING SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    documentacionAnexaCotizProyPlAnAdqCdoIngRepository.save(documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng().equals(documentacionAnexaCotizProyPlAnAdqCdoIngId.get().getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS ASOCIADOS A LA MISMA PROYECCION PLAN ANUAL ADQ CDO ING.
              DocumentacionAnexaCotizProyPlAnAdqCdoIng documentacionAnexaCotizProyPlAnAdqCdoIngNombreEIdProyeccionPlanAnualAdqCdoIng = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findByNombreAndIdProyeccionPlanAnualAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng().toUpperCase(), documentacionAnexaCotizProyPlAnAdqCdoIngDTO.getProyeccionPlanAnualAdqCdoIngDTO().getIdProyeccionPlanAnualAdqCdoIng());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(documentacionAnexaCotizProyPlAnAdqCdoIngNombreEIdProyeccionPlanAnualAdqCdoIng == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO A LA MISMA PROYECCION PLAN ANUAL ADQ CDO ING MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO ASOCIADO A LA MISMA PROYECCION PLAN ANUAL ADQ CDO ING Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_DOCUMENTACION_ANEXA_COTIZ_PROY_PL_AN_ADQ_CDO_ING_NO_MODIFICAR_EN_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING, false);
                 respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS ASOCIADO A LA MISMA PROYECCION PLAN ANUAL ADQ CDO ING SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 documentacionAnexaCotizProyPlAnAdqCdoIngRepository.save(documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIng(documentacionAnexaCotizProyPlAnAdqCdoIngDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (documentacionAnexaCotizProyPlAnAdqCdoIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDocumentacionAnexaCotizProyPlAnAdqCdoIng(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng) {
        Optional<DocumentacionAnexaCotizProyPlAnAdqCdoIng> documentacionAnexaCotizProyPlAnAdqCdoIngId = documentacionAnexaCotizProyPlAnAdqCdoIngRepository.findById(idDocumentacionAnexaCotizProyPlAnAdqCdoIng);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (documentacionAnexaCotizProyPlAnAdqCdoIngId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(documentacionAnexaCotizProyPlAnAdqCdoIngDAO.documentacionAnexaCotizProyPlAnAdqCdoIngDTO(documentacionAnexaCotizProyPlAnAdqCdoIngId.get()));
           documentacionAnexaCotizProyPlAnAdqCdoIngRepository.delete(documentacionAnexaCotizProyPlAnAdqCdoIngId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (documentacionAnexaCotizProyPlAnAdqCdoIngId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDocumentacionAnexaCotizProyPlAnAdqCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
}
