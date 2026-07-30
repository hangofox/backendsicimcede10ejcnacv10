//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialIntegranteDocumentosDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface HistorialIntegranteDocumentosService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialIntegranteDocumentos, String keyword);
    List<HistorialIntegranteDocumentosDTO> listarHistorialesIntegrantesDocumentos(Long idHistorialIntegranteDocumentos, String keyword, String orderBy, String orderMode);
    Slice<HistorialIntegranteDocumentosDTO> listarHistorialesIntegrantesDocumentosPag(Pageable pageable, Long idHistorialIntegranteDocumentos, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialIntegranteDocumentos(HistorialIntegranteDocumentosDTO historialIntegranteDocumentosDTO);
    RespuestaDTO consultarHistorialIntegranteDocumentosporId(Long idHistorialIntegranteDocumentos);
    RespuestaDTO consultarHistorialIntegranteDocumentosporNumReg(String numRegHistorialIntegranteDocumentos);
    RespuestaDTO actualizarHistorialIntegranteDocumentos(HistorialIntegranteDocumentosDTO historialIntegranteDocumentosDTO);
    RespuestaDTO eliminarHistorialIntegranteDocumentos(Long idHistorialIntegranteDocumentos);
}
