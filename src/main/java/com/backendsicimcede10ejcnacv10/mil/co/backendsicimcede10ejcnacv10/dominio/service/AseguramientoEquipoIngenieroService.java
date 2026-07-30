//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.AseguramientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface AseguramientoEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idAseguramientoEquipoIngeniero, String keyword, Long idEquipoIngeniero);
    List<AseguramientoEquipoIngenieroDTO> listarAseguramientosEquiposIngenieros(Long idAseguramientoEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode);
    Slice<AseguramientoEquipoIngenieroDTO> listarAseguramientosEquiposIngenierosPag(Pageable pageable, Long idAseguramientoEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearAseguramientoEquipoIngeniero(AseguramientoEquipoIngenieroDTO aseguramientoEquipoIngenieroDTO);
    RespuestaDTO consultarAseguramientoEquipoIngenieroporId(Long idAseguramientoEquipoIngeniero);
    RespuestaDTO actualizarAseguramientoEquipoIngeniero(AseguramientoEquipoIngenieroDTO aseguramientoEquipoIngenieroDTO);
    RespuestaDTO eliminarAseguramientoEquipoIngeniero(Long idAseguramientoEquipoIngeniero);
}
