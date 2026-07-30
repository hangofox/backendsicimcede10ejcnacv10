//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualPozoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ProyeccionPlanAnualPozoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idProyeccionPlanAnualPozo, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualPozo, Long idTipoMantenimientoPozo, String nombreYNumeroRubroProyeccionPlanAnualPozo, String valorSolicitadoProyeccionPlanAnualPozo, String nombreBienOServicioProyeccionPlanAnualPozo, Long idInfraestructura, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<ProyeccionPlanAnualPozoDTO> listarProyeccionesPlanesAnualesPozos(Long idProyeccionPlanAnualPozo, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualPozo, Long idTipoMantenimientoPozo, String nombreYNumeroRubroProyeccionPlanAnualPozo, String valorSolicitadoProyeccionPlanAnualPozo, String nombreBienOServicioProyeccionPlanAnualPozo, Long idInfraestructura, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionPlanAnualPozoDTO> listarProyeccionesPlanesAnualesPozosPag(Pageable pageable, Long idProyeccionPlanAnualPozo, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualPozo, Long idTipoMantenimientoPozo, String nombreYNumeroRubroProyeccionPlanAnualPozo, String valorSolicitadoProyeccionPlanAnualPozo, String nombreBienOServicioProyeccionPlanAnualPozo, Long idInfraestructura, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionPlanAnualPozo(ProyeccionPlanAnualPozoDTO proyeccionPlanAnualPozoDTO);
    RespuestaDTO consultarProyeccionPlanAnualPozoporId(Long idProyeccionPlanAnualPozo);
    RespuestaDTO actualizarProyeccionPlanAnualPozo(ProyeccionPlanAnualPozoDTO proyeccionPlanAnualPozoDTO);
    RespuestaDTO eliminarProyeccionPlanAnualPozo(Long idProyeccionPlanAnualPozo);
}
