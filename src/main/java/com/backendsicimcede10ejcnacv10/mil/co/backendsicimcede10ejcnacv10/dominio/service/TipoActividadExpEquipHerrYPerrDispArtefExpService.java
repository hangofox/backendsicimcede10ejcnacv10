//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoActividadExpEquipHerrYPerrDispArtefExpDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoActividadExpEquipHerrYPerrDispArtefExpService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idTipoActividadExpEquipHerrYPerrDispArtefExp, String keyword);
    //1. LISTADO DE REGISTROS FILTRADOS.
    List<TipoActividadExpEquipHerrYPerrDispArtefExpDTO> listarTiposActividadesExpEquipHerrYPerrDispArtefExp(Long idTipoActividadExpEquipHerrYPerrDispArtefExp, String keyword, String orderBy, String orderMode);
    Slice<TipoActividadExpEquipHerrYPerrDispArtefExpDTO> listarTiposActividadesExpEquipHerrYPerrDispArtefExpPag(Pageable pageable, Long idTipoActividadExpEquipHerrYPerrDispArtefExp, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoActividadExpEquipHerrYPerrDispArtefExp(TipoActividadExpEquipHerrYPerrDispArtefExpDTO tipoActividadExpEquipHerrYPerrDispArtefExpDTO);
    RespuestaDTO consultarTipoActividadExpEquipHerrYPerrDispArtefExpporId(Long idTipoActividadExpEquipHerrYPerrDispArtefExp);
    RespuestaDTO consultarTipoActividadExpEquipHerrYPerrDispArtefExpporNombre(String nombreTipoActividadExpEquipHerrYPerrDispArtefExp);
    RespuestaDTO actualizarTipoActividadExpEquipHerrYPerrDispArtefExp(TipoActividadExpEquipHerrYPerrDispArtefExpDTO tipoActividadExpEquipHerrYPerrDispArtefExpDTO);
    RespuestaDTO eliminarTipoActividadExpEquipHerrYPerrDispArtefExp(Long idTipoActividadExpEquipHerrYPerrDispArtefExp);
}
