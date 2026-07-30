//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqCdoIngDTO;
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
public interface ProyeccionPlanAnualAdqCdoIngService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idProyeccionPlanAnualAdqCdoIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqCdoIng, Long idDestinacionMantenimientoCdoIng, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, Long idInfraestructura, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<ProyeccionPlanAnualAdqCdoIngDTO> listarProyeccionesPlanesAnualesAdqCdosIng(Long idProyeccionPlanAnualAdqCdoIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqCdoIng, Long idDestinacionMantenimientoCdoIng, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, Long idInfraestructura, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionPlanAnualAdqCdoIngDTO> listarProyeccionesPlanesAnualesAdqCdosIngPag(Pageable pageable, Long idProyeccionPlanAnualAdqCdoIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqCdoIng, Long idDestinacionMantenimientoCdoIng, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, Long idInfraestructura, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionPlanAnualAdqCdoIng(ProyeccionPlanAnualAdqCdoIngDTO proyeccionPlanAnualAdqCdoIngDTO);
    RespuestaDTO consultarProyeccionPlanAnualAdqCdoIngporId(Long idProyeccionPlanAnualAdqCdoIng);
    RespuestaDTO actualizarProyeccionPlanAnualAdqCdoIng(ProyeccionPlanAnualAdqCdoIngDTO proyeccionPlanAnualAdqCdoIngDTO);
    RespuestaDTO eliminarProyeccionPlanAnualAdqCdoIng(Long idProyeccionPlanAnualAdqCdoIng);
}
