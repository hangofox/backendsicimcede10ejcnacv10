//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoIdentificacionDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoDocumentoIdentificacionService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idTipoDocumentoIdentificacion, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<TipoDocumentoIdentificacionDTO> listarTiposDocumentosIdentificacion(Long idTipoDocumentoIdentificacion, String keyword, String orderBy, String orderMode);
    Slice<TipoDocumentoIdentificacionDTO> listarTiposDocumentosIdentificacionPag(Pageable pageable, Long idTipoDocumentoIdentificacion, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoDocumentoIdentificacion(TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionDTO);
    RespuestaDTO consultarTipoDocumentoIdentificacionporId(Long idTipoDocumentoIdentificacion);
    RespuestaDTO consultarTipoDocumentoIdentificacionporNombre(String nombreTipoDocumentoIdentificacion);
    RespuestaDTO actualizarTipoDocumentoIdentificacion(TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionDTO);
    RespuestaDTO eliminarTipoDocumentoIdentificacion(Long idTipoDocumentoIdentificacion);
}
