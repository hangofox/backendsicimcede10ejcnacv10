//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.NivelMantenimientoEquipoIngenieroDTO;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface NivelMantenimientoEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idNivelMantenimientoEquipoIngeniero, String keyword);
    List<NivelMantenimientoEquipoIngenieroDTO> listarNivelesMantenimientosEquiposIngenieros(Long idNivelMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode);
    Slice<NivelMantenimientoEquipoIngenieroDTO> listarNivelesMantenimientosEquiposIngenierosOrdenadosporIdPag(Pageable pageable, Long idNivelMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearNivelMantenimientoEquipoIngeniero(NivelMantenimientoEquipoIngenieroDTO nivelMantenimientoEquipoIngenieroDTO);
    RespuestaDTO consultarNivelMantenimientoEquipoIngenieroporId(Long idNivelMantenimientoEquipoIngeniero);
    RespuestaDTO consultarNivelMantenimientoEquipoIngenieroporNombre(String nombreNivelMantenimientoEquipoIngeniero);
    RespuestaDTO actualizarNivelMantenimientoEquipoIngeniero(NivelMantenimientoEquipoIngenieroDTO nivelMantenimientoEquipoIngenieroDTO);
    RespuestaDTO eliminarNivelMantenimientoEquipoIngeniero(Long idNivelMantenimientoEquipoIngeniero);
}
