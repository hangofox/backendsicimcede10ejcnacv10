//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ElementoSubclasificacionEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 19/06/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ElementoSubclasificacionEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idElementoSubclasificacionEquipoIngeniero, String keyword, String nombreElementoSubclasificacionEquipoIngeniero);
    List<ElementoSubclasificacionEquipoIngenieroDTO> listarElementosSubclasificacionesEquiposIngenieros(Long idElementoSubclasificacionEquipoIngeniero, String keyword, String nombreElementoSubclasificacionEquipoIngeniero, String orderBy, String orderMode);
    Slice<ElementoSubclasificacionEquipoIngenieroDTO> listarElementosSubclasificacionesEquiposIngenierosPag(Pageable pageable, Long idElementoSubclasificacionEquipoIngeniero, String keyword, String nombreElementoSubclasificacionEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearElementoSubclasificacionEquipoIngeniero(ElementoSubclasificacionEquipoIngenieroDTO elementoSubclasificacionEquipoIngenieroDTO);
    RespuestaDTO consultarElementoSubclasificacionEquipoIngenieroporId(Long idElementoSubclasificacionEquipoIngeniero);
    RespuestaDTO consultarElementoSubclasificacionEquipoIngenieroporNombreElementoSubclasificacionEquipoIngenieroYNombreClasificacionEquipoIngenieroYNombreSubclasificacionEquipoIngenieroYNombreCuentaEquipoIngenieroYNombreClaseActivoEquipoIngeniero(String nombreElementoSubclasificacionEquipoIngeniero, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreCuentaEquipoIngeniero, String nombreClaseActivoEquipoIngeniero);
    RespuestaDTO actualizarElementoSubclasificacionEquipoIngeniero(ElementoSubclasificacionEquipoIngenieroDTO elementoSubclasificacionEquipoIngenieroDTO);
    RespuestaDTO eliminarElementoSubclasificacionEquipoIngeniero(Long idElementoSubclasificacionEquipoIngeniero);
}
