//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqGeneralDTO;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ProyeccionPlanAnualAdqGeneralService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqGeneral, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<ProyeccionPlanAnualAdqGeneralDTO> listarProyeccionesPlanesAnualesAdqGenerales(Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqGeneral, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionPlanAnualAdqGeneralDTO> listarProyeccionesPlanesAnualesAdqGeneralesPag(Pageable pageable, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqGeneral, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneralDTO proyeccionPlanAnualAdqGeneralDTO);
    RespuestaDTO consultarProyeccionPlanAnualAdqGeneralporId(Long idProyeccionPlanAnualAdqGeneral);
    RespuestaDTO consultarProyeccionPlanAnualAdqGeneralporNombre(String nombreProyeccionPlanAnualAdqGeneral);
    RespuestaDTO actualizarProyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneralDTO proyeccionPlanAnualAdqGeneralDTO);
    RespuestaDTO eliminarProyeccionPlanAnualAdqGeneral(Long idProyeccionPlanAnualAdqGeneral);
}
