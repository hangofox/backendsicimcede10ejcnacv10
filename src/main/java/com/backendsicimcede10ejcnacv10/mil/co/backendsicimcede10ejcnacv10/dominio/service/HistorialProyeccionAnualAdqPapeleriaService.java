//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAdqPapeleriaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 10/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialProyeccionAnualAdqPapeleriaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialProyeccionAnualAdqPapeleria, String keyword);
    List<HistorialProyeccionAnualAdqPapeleriaDTO> listarHistorialesProyeccionesAnualesAdqPapelerias(Long idHistorialProyeccionAnualAdqPapeleria, String keyword, String orderBy, String orderMode);
    Slice<HistorialProyeccionAnualAdqPapeleriaDTO> listarHistorialesProyeccionesAnualesAdqPapeleriasPag(Pageable pageable, Long idHistorialProyeccionAnualAdqPapeleria, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialProyeccionAnualAdqPapeleria(HistorialProyeccionAnualAdqPapeleriaDTO historialProyeccionAnualAdqPapeleriaDTO);
    RespuestaDTO consultarHistorialProyeccionAnualAdqPapeleriaaporId(Long idHistorialProyeccionAnualAdqPapeleria);
    RespuestaDTO actualizarHistorialProyeccionAnualAdqPapeleria(HistorialProyeccionAnualAdqPapeleriaDTO historialProyeccionAnualAdqPapeleriaDTO);
    RespuestaDTO eliminarHistorialProyeccionAnualAdqPapeleria(Long idHistorialProyeccionAnualAdqPapeleria);
}
