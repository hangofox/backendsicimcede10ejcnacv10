//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoAltaEquipoIngenieroDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoDocumentoAnexoAltaEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idTipoDocumentoAnexoAltaEquipoIngeniero, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<TipoDocumentoAnexoAltaEquipoIngenieroDTO> listarTiposDocumentosAnexosAltasEquiposIngenieros(Long idTipoDocumentoAnexoAltaEquipoIngeniero, String keyword, String orderBy, String orderMode);
    Slice<TipoDocumentoAnexoAltaEquipoIngenieroDTO> listarTiposDocumentosAnexosAltasEquiposIngenierosPag(Pageable pageable, Long idTipoDocumentoAnexoAltaEquipoIngeniero, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoDocumentoAnexoAltaEquipoIngeniero(TipoDocumentoAnexoAltaEquipoIngenieroDTO tipoDocumentoAnexoAltaEquipoIngenieroDTO);
    RespuestaDTO consultarTipoDocumentoAnexoAltaEquipoIngenieroporId(Long idTipoDocumentoAnexoAltaEquipoIngeniero);
    RespuestaDTO consultarTipoDocumentoAnexoAltaEquipoIngenieroporNombre(String nombreTipoDocumentoAnexoAltaEquipoIngeniero);
    RespuestaDTO actualizarTipoDocumentoAnexoAltaEquipoIngeniero(TipoDocumentoAnexoAltaEquipoIngenieroDTO tipoDocumentoAnexoAltaEquipoIngenieroDTO);
    RespuestaDTO eliminarTipoDocumentoAnexoAltaEquipoIngeniero(Long idTipoDocumentoAnexoAltaEquipoIngeniero);
}
