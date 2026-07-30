//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionTecnicomecanicaEquipTranspDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ProyeccionTecnicomecanicaEquipTranspService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idProyeccionTecnicomecanicaEquipTransp, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<ProyeccionTecnicomecanicaEquipTranspDTO> listarProyeccionesTecnicomecanicasEquipsTransps(Long idProyeccionTecnicomecanicaEquipTransp, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionTecnicomecanicaEquipTranspDTO> listarProyeccionesTecnicomecanicasEquipsTranspsPag(Pageable pageable, Long idProyeccionTecnicomecanicaEquipTransp, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionTecnicomecanicaEquipTransp(ProyeccionTecnicomecanicaEquipTranspDTO proyeccionTecnicomecanicaEquipTranspDTO);
    RespuestaDTO consultarProyeccionTecnicomecanicaEquipTranspporId(Long idProyeccionTecnicomecanicaEquipTransp);
    RespuestaDTO actualizarProyeccionTecnicomecanicaEquipTransp(ProyeccionTecnicomecanicaEquipTranspDTO proyeccionTecnicomecanicaEquipTranspDTO);
    RespuestaDTO eliminarProyeccionTecnicomecanicaEquipTransp(Long idProyeccionTecnicomecanicaEquipTransp);
}
