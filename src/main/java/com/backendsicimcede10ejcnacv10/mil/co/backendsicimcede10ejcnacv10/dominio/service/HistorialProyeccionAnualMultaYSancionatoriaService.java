//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualMultaYSancionatoriaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialProyeccionAnualMultaYSancionatoriaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialProyeccionAnualMultaYSancionatoria, String keyword);
    List<HistorialProyeccionAnualMultaYSancionatoriaDTO> listarHistorialesProyeccionesAnualesMultasYSancionatorias(Long idHistorialProyeccionAnualMultaYSancionatoria, String keyword, String orderBy, String orderMode);
    Slice<HistorialProyeccionAnualMultaYSancionatoriaDTO> listarHistorialesProyeccionesAnualesMultasYSancionatoriasPag(Pageable pageable, Long idHistorialProyeccionAnualMultaYSancionatoria, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialProyeccionAnualMultaYSancionatoria(HistorialProyeccionAnualMultaYSancionatoriaDTO historialProyeccionAnualMultaYSancionatoriaDTO);
    RespuestaDTO consultarHistorialProyeccionAnualMultaYSancionatoriaporId(Long idHistorialProyeccionAnualMultaYSancionatoria);
    RespuestaDTO consultarHistorialProyeccionAnualMultaYSancionatoriaporNumReg(String numRegHistorialProyeccionAnualMultaYSancionatoria);
    RespuestaDTO actualizarHistorialProyeccionAnualMultaYSancionatoria(HistorialProyeccionAnualMultaYSancionatoriaDTO historialProyeccionAnualMultaYSancionatoriaDTO);
    RespuestaDTO eliminarHistorialProyeccionAnualMultaYSancionatoria(Long idHistorialProyeccionAnualMultaYSancionatoria);
}
