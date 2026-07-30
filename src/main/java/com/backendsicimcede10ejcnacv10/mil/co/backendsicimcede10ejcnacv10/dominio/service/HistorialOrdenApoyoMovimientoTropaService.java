//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialOrdenApoyoMovimientoTropaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialOrdenApoyoMovimientoTropaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialOrdenApoyoMovimientoTropa, String keyword);
    List<HistorialOrdenApoyoMovimientoTropaDTO> listarHistorialesOrdenesApoyosMovimientosTropas(Long idHistorialOrdenApoyoMovimientoTropa, String keyword, String orderBy, String orderMode);
    Slice<HistorialOrdenApoyoMovimientoTropaDTO> listarHistorialesOrdenesApoyosMovimientosTropasPag(Pageable pageable, Long idHistorialOrdenApoyoMovimientoTropa, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialOrdenApoyoMovimientoTropa(HistorialOrdenApoyoMovimientoTropaDTO historialOrdenApoyoMovimientoTropaDTO);
    RespuestaDTO consultarHistorialOrdenApoyoMovimientoTropaporId(Long idHistorialOrdenApoyoMovimientoTropa);
    RespuestaDTO consultarHistorialOrdenApoyoMovimientoTropaporNumReg(String numRegHistorialOrdenApoyoMovimientoTropa);
    RespuestaDTO actualizarHistorialOrdenApoyoMovimientoTropa(HistorialOrdenApoyoMovimientoTropaDTO historialOrdenApoyoMovimientoTropaDTO);
    RespuestaDTO eliminarHistorialOrdenApoyoMovimientoTropa(Long idHistorialOrdenApoyoMovimientoTropa);
}
