//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ClaseActivoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ClaseActivoEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idClaseActivoEquipoIngeniero, String keyword, String nombreClaseActivoEquipoIngeniero);
    List<ClaseActivoEquipoIngenieroDTO> listarClasesActivosEquiposIngenieros(Long idClaseActivoEquipoIngeniero, String keyword, String nombreClaseActivoEquipoIngeniero, String orderBy, String orderMode);
    Slice<ClaseActivoEquipoIngenieroDTO> listarClasesActivosEquiposIngenierosProPag(Pageable pageable, Long idClaseActivoEquipoIngeniero, String keyword, String nombreClaseActivoEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearClaseActivoEquipoIngeniero(ClaseActivoEquipoIngenieroDTO claseActivoEquipoIngenieroDTO);
    RespuestaDTO consultarClaseActivoEquipoIngenieroporId(Long idClaseActivoEquipoIngeniero);
    RespuestaDTO consultarClaseActivoEquipoIngenieroporNombreClaseActivoEquipoIngeniero(String nombreClaseActivoEquipoIngeniero);
    RespuestaDTO consultarClaseActivoEquipoIngenieroporNumeroClaseActivoEquipoIngeniero(String numeroClaseActivoEquipoIngeniero);
    RespuestaDTO actualizarClaseActivoEquipoIngeniero(ClaseActivoEquipoIngenieroDTO claseActivoEquipoIngenieroDTO);
    RespuestaDTO eliminarClaseActivoEquipoIngeniero(Long idClaseActivoEquipoIngeniero);
}
