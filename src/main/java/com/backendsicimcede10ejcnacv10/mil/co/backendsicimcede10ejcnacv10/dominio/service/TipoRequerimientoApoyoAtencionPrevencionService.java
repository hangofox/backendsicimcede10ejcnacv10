//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoRequerimientoApoyoAtencionPrevencionDTO;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoRequerimientoApoyoAtencionPrevencionService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTipoRequerimientoApoyoAtencionPrevencion, String keyword);
    List<TipoRequerimientoApoyoAtencionPrevencionDTO> listarTiposRequerimientosApoyosAtencionPrevencion(Long idTipoRequerimientoApoyoAtencionPrevencion, String keyword, String orderBy, String orderMode);
    Slice<TipoRequerimientoApoyoAtencionPrevencionDTO> listarTiposRequerimientosApoyosAtencionPrevencionPag(Pageable pageable, Long idTipoRequerimientoApoyoAtencionPrevencion, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoRequerimientoApoyoAtencionPrevencion(TipoRequerimientoApoyoAtencionPrevencionDTO tipoRequerimientoApoyoAtencionPrevencionDTO);
    RespuestaDTO consultarTipoRequerimientoApoyoAtencionPrevencionporId(Long idTipoRequerimientoApoyoAtencionPrevencion);
    RespuestaDTO consultarTipoRequerimientoApoyoAtencionPrevencionporNombre(String nombreTipoRequerimientoApoyoAtencionPrevencion);
    RespuestaDTO actualizarTipoRequerimientoApoyoAtencionPrevencion(TipoRequerimientoApoyoAtencionPrevencionDTO tipoRequerimientoApoyoAtencionPrevencionDTO);
    RespuestaDTO eliminarTipoRequerimientoApoyoAtencionPrevencion(Long idTipoRequerimientoApoyoAtencionPrevencion);
}
