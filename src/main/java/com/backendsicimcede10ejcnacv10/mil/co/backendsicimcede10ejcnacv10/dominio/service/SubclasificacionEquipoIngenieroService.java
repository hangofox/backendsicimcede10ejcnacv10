//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SubclasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
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
public interface SubclasificacionEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idSubclasificacionEquipoIngeniero, String keyword, String nombreTipoDocumentoIdentificacion, String nombreSubclasificacionEquipoIngeniero);
    List<SubclasificacionEquipoIngenieroDTO> listarSubclasificacionesEquiposIngenieros(Long idSubclasificacionEquipoIngeniero, String keyword, String nombreSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero, String orderBy, String orderMode);
    Slice<SubclasificacionEquipoIngenieroDTO> listarSubclasificacionesEquiposIngenierosPag(Pageable pageable, Long idSubclasificacionEquipoIngeniero, String keyword, String nombreSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearSubclasificacionEquipoIngeniero(SubclasificacionEquipoIngenieroDTO subclasificacionEquipoIngenieroDTO);
    RespuestaDTO consultarSubclasificacionEquipoIngenieroporId(Long idSubclasificacionEquipoIngeniero);
    RespuestaDTO consultarSubclasificacionEquipoIngenieroporNombreSubclasificacionEquipoIngenieroYNombreClasificacionEquipoIngeniero(String nombreSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero);
    RespuestaDTO actualizarSubclasificacionEquipoIngeniero(SubclasificacionEquipoIngenieroDTO subclasificacionEquipoIngenieroDTO);
    RespuestaDTO eliminarSubclasificacionEquipoIngeniero(Long idSubclasificacionEquipoIngeniero);
}
