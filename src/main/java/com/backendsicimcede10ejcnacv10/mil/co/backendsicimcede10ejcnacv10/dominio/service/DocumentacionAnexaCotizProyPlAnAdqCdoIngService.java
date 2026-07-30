//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface DocumentacionAnexaCotizProyPlAnAdqCdoIngService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, String keyword, Long idProyeccionPlanAnualAdqCdoIng);
    List<DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO> listarDocumentacionAnexasCotizProyPlAnAdqCdoIng(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, String keyword, Long idProyeccionPlanAnualAdqCdoIng, String orderBy, String orderMode);
    Slice<DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO> listarDocumentacionAnexasCotizProyPlAnAdqCdoIngPag(Pageable pageable, Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng, String keyword, Long idProyeccionPlanAnualAdqCdoIng, String orderBy, String orderMode);
    RespuestaDTO crearDocumentacionAnexaCotizProyPlAnAdqCdoIng(DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO documentacionAnexaCotizProyPlAnAdqCdoIngDTO);
    RespuestaDTO consultarDocumentacionAnexaCotizProyPlAnAdqCdoIngporId(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng);
    RespuestaDTO actualizarDocumentacionAnexaCotizProyPlAnAdqCdoIng(DocumentacionAnexaCotizProyPlAnAdqCdoIngDTO documentacionAnexaCotizProyPlAnAdqCdoIngDTO);
    RespuestaDTO eliminarDocumentacionAnexaCotizProyPlAnAdqCdoIng(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng);
}
