//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualEquipSubsDTO;
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
public interface ProyeccionPlanAnualEquipSubsService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idProyeccionPlanAnualEquipSubs, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualEquipSubs, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, String valorSolicitadoProyeccionPlanAnualEquipSubs, String nombreBienOServicioProyeccionPlanAnualEquipSubs, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<ProyeccionPlanAnualEquipSubsDTO> listarProyeccionesPlanesAnualesEquipSubs(Long idProyeccionPlanAnualEquipSubs, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualEquipSubs, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, String valorSolicitadoProyeccionPlanAnualEquipSubs, String nombreBienOServicioProyeccionPlanAnualEquipSubs, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionPlanAnualEquipSubsDTO> listarProyeccionesPlanesAnualesEquipSubsPag(Pageable pageable, Long idProyeccionPlanAnualEquipSubs, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualEquipSubs, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, String valorSolicitadoProyeccionPlanAnualEquipSubs, String nombreBienOServicioProyeccionPlanAnualEquipSubs, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionPlanAnualEquipSubs(ProyeccionPlanAnualEquipSubsDTO proyeccionPlanAnualEquipSubsDTO);
    RespuestaDTO consultarProyeccionPlanAnualEquipSubsporId(Long idProyeccionPlanAnualEquipSubs);
    RespuestaDTO actualizarProyeccionPlanAnualEquipSubs(ProyeccionPlanAnualEquipSubsDTO proyeccionPlanAnualEquipSubsDTO);
    RespuestaDTO eliminarProyeccionPlanAnualEquipSubs(Long idProyeccionPlanAnualEquipSubs);
}
