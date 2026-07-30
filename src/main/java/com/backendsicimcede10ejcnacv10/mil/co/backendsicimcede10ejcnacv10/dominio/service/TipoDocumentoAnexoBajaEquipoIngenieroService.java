//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoAnexoBajaEquipoIngenieroDTO;
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
public interface TipoDocumentoAnexoBajaEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idTipoDocumentoAnexoBajaEquipoIngeniero, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<TipoDocumentoAnexoBajaEquipoIngenieroDTO> listarTiposDocumentosAnexosBajasEquiposIngenieros(Long idTipoDocumentoAnexoBajaEquipoIngeniero, String keyword, String orderBy, String orderMode);
    Slice<TipoDocumentoAnexoBajaEquipoIngenieroDTO> listarTiposDocumentosAnexosBajasEquiposIngenierosPag(Pageable pageable, Long idTipoDocumentoAnexoBajaEquipoIngeniero, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoDocumentoAnexoBajaEquipoIngeniero(TipoDocumentoAnexoBajaEquipoIngenieroDTO tipoDocumentoAnexoBajaEquipoIngenieroDTO);
    RespuestaDTO consultarTipoDocumentoAnexoBajaEquipoIngenieroporId(Long idTipoDocumentoAnexoBajaEquipoIngeniero);
    RespuestaDTO consultarTipoDocumentoAnexoBajaEquipoIngenieroporNombre(String nombreTipoDocumentoAnexoBajaEquipoIngeniero);
    RespuestaDTO actualizarTipoDocumentoAnexoBajaEquipoIngeniero(TipoDocumentoAnexoBajaEquipoIngenieroDTO tipoDocumentoAnexoBajaEquipoIngenieroDTO);
    RespuestaDTO eliminarTipoDocumentoAnexoBajaEquipoIngeniero(Long idTipoDocumentoAnexoBajaEquipoIngeniero);
}
