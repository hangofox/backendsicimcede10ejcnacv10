//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProcesoApoyoAtencionPrevencionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ProcesoApoyoAtencionPrevencionService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idProcesoApoyoAtencionPrevencion, String keyword, String nombreTipoRequerimientoApoyoAtencionPrevencion);
    List<ProcesoApoyoAtencionPrevencionDTO> listarProcesosApoyosAtencionPrevencion(Long idProcesoApoyoAtencionPrevencion, String keyword, String nombreTipoRequerimientoApoyoAtencionPrevencion, String orderBy, String orderMode);
    Slice<ProcesoApoyoAtencionPrevencionDTO> listarProcesosApoyosAtencionPrevencionPag(Pageable pageable, Long idProcesoApoyoAtencionPrevencion, String keyword, String nombreTipoRequerimientoApoyoAtencionPrevencion, String orderBy, String orderMode);
    RespuestaDTO crearProcesoApoyoAtencionPrevencion(ProcesoApoyoAtencionPrevencionDTO procesoApoyoAtencionPrevencionDTO);
    RespuestaDTO consultarProcesoApoyoAtencionPrevencionporId(Long idProcesoApoyoAtencionPrevencion);
    RespuestaDTO consultarProcesoApoyoAtencionPrevencionporNombreYNombreTipoRequerimientoApoyoAtencionPrevencion(String nombreProcesoApoyoAtencionPrevencion, String nombreTipoRequerimientoApoyoAtencionPrevencion);
    RespuestaDTO actualizarProcesoApoyoAtencionPrevencion(ProcesoApoyoAtencionPrevencionDTO procesoApoyoAtencionPrevencionDTO);
    RespuestaDTO eliminarProcesoApoyoAtencionPrevencion(Long idProcesoApoyoAtencionPrevencion);
}
