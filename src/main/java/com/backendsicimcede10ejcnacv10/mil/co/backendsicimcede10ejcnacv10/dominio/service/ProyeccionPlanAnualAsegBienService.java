//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAsegBienDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ProyeccionPlanAnualAsegBienService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idProyeccionPlanAnualAsegBien, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAsegBien, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<ProyeccionPlanAnualAsegBienDTO> listarProyeccionesPlanesAnualesAsegBienes(Long idProyeccionPlanAnualAsegBien, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAsegBien, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionPlanAnualAsegBienDTO> listarProyeccionesPlanesAnualesAsegBienesPag(Pageable pageable, Long idProyeccionPlanAnualAsegBien, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAsegBien, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionPlanAnualAsegBien(ProyeccionPlanAnualAsegBienDTO proyeccionPlanAnualAsegBienDTO);
    RespuestaDTO consultarProyeccionPlanAnualAsegBienporId(Long idProyeccionPlanAnualAsegBien);
    RespuestaDTO actualizarProyeccionPlanAnualAsegBien(ProyeccionPlanAnualAsegBienDTO proyeccionPlanAnualAsegBienDTO);
    RespuestaDTO eliminarProyeccionPlanAnualAsegBien(Long idProyeccionPlanAnualAsegBien);
}
