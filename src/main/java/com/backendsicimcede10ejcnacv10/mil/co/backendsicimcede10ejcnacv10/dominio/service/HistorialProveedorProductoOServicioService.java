//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProveedorProductoOServicioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 02/06/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialProveedorProductoOServicioService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialProveedorProductoOServicio, String keyword);
    List<HistorialProveedorProductoOServicioDTO> listarHistorialesProveedoresProductosOServicios(Long idHistorialProveedorProductoOServicio, String keyword, String orderBy, String orderMode);
    Slice<HistorialProveedorProductoOServicioDTO> listarHistorialesProveedoresProductosOServiciosPag(Pageable pageable, Long idHistorialProveedorProductoOServicio, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialProveedorProductoOServicio(HistorialProveedorProductoOServicioDTO historialProveedorProductoOServicioDTO);
    RespuestaDTO consultarHistorialProveedorProductoOServicioporId(Long idHistorialProveedorProductoOServicio);
    RespuestaDTO consultarHistorialProveedorProductoOServicioporNumReg(String numRegHistorialProveedorProductoOServicio);
    RespuestaDTO actualizarHistorialProveedorProductoOServicio(HistorialProveedorProductoOServicioDTO historialProveedorProductoOServicioDTO);
    RespuestaDTO eliminarHistorialProveedorProductoOServicio(Long idHistorialProveedorProductoOServicio);
}
