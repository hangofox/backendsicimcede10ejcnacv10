//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqEquipFijIngDTO;
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
public interface ProyeccionPlanAnualAdqEquipFijIngService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idProyeccionPlanAnualAdqEquipFijIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqEquipFijIng, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<ProyeccionPlanAnualAdqEquipFijIngDTO> listarProyeccionesPlanesAnualesAdqEquipFijIng(Long idProyeccionPlanAnualAdqEquipFijIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqEquipFijIng, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionPlanAnualAdqEquipFijIngDTO> listarProyeccionesPlanesAnualesAdqEquipFijIngPag(Pageable pageable, Long idProyeccionPlanAnualAdqEquipFijIng, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqEquipFijIng, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionPlanAnualAdqEquipFijIng(ProyeccionPlanAnualAdqEquipFijIngDTO proyeccionPlanAnualAdqEquipFijIngDTO);
    RespuestaDTO consultarProyeccionPlanAnualAdqEquipFijIngporId(Long idProyeccionPlanAnualAdqEquipFijIng);
    RespuestaDTO actualizarProyeccionPlanAnualAdqEquipFijIng(ProyeccionPlanAnualAdqEquipFijIngDTO proyeccionPlanAnualAdqEquipFijIngDTO);
    RespuestaDTO eliminarProyeccionPlanAnualAdqEquipFijIng(Long idProyeccionPlanAnualAdqEquipFijIng);
}
