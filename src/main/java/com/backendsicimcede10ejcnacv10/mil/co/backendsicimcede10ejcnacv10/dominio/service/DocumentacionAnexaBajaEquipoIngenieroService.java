//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DocumentacionAnexaBajaEquipoIngenieroDTO;
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
public interface DocumentacionAnexaBajaEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idDocumentacionAnexaBajaEquipoIngeniero, String keyword, Long idEquipoIngeniero);
    List<DocumentacionAnexaBajaEquipoIngenieroDTO> listarDocumentacionAnexasBajasEquiposIngenieros(Long idDocumentacionAnexaBajaEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode);
    Slice<DocumentacionAnexaBajaEquipoIngenieroDTO> listarDocumentacionAnexasBajasEquiposIngenierosPag(Pageable pageable, Long idDocumentacionAnexaBajaEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearDocumentacionAnexaBajaEquipoIngeniero(DocumentacionAnexaBajaEquipoIngenieroDTO documentacionAnexaBajaEquipoIngenieroDTO);
    RespuestaDTO consultarDocumentacionAnexaBajaEquipoIngenieroporId(Long idDocumentacionAnexaBajaEquipoIngeniero);
    RespuestaDTO actualizarDocumentacionAnexaBajaEquipoIngeniero(DocumentacionAnexaBajaEquipoIngenieroDTO documentacionAnexaBajaEquipoIngenieroDTO);
    RespuestaDTO eliminarDocumentacionAnexaBajaEquipoIngeniero(Long idDocumentacionAnexaBajaEquipoIngeniero);
}
