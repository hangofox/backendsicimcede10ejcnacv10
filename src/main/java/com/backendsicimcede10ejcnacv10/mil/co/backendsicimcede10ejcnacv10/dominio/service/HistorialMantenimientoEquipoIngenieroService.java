//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialMantenimientoEquipoIngenieroDTO;
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
public interface HistorialMantenimientoEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialMantenimientoEquipoIngeniero, String keyword);
    List<HistorialMantenimientoEquipoIngenieroDTO> listarHistorialesMantenimientosEquiposIngenieros(Long idHistorialMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode);
    Slice<HistorialMantenimientoEquipoIngenieroDTO> listarHistorialesMantenimientosEquiposIngenierosPag(Pageable pageable, Long idHistorialMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialMantenimientoEquipoIngeniero(HistorialMantenimientoEquipoIngenieroDTO historialMantenimientoEquipoIngenieroDTO);
    RespuestaDTO consultarHistorialMantenimientoEquipoIngenieroporId(Long idHistorialMantenimientoEquipoIngeniero);
    RespuestaDTO consultarHistorialMantenimientoEquipoIngenieroporNumReg(String numRegHistorialMantenimientoEquipoIngeniero);
    RespuestaDTO actualizarHistorialMantenimientoEquipoIngeniero(HistorialMantenimientoEquipoIngenieroDTO historialMantenimientoEquipoIngenieroDTO);
    RespuestaDTO eliminarHistorialMantenimientoEquipoIngeniero(Long idHistorialMantenimientoEquipoIngeniero);
}
