//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAdqServPublicDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 10/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialProyeccionAnualAdqServPublicService {
    Long contarTotalRegistros(Long idHistorialProyeccionAnualAdqServPublic, String keyword);
    List<HistorialProyeccionAnualAdqServPublicDTO> listarHistorialesProyeccionesAnualesAdqServPublic(Long idHistorialProyeccionAnualAdqServPublic, String keyword, String orderBy, String orderMode);
    Slice<HistorialProyeccionAnualAdqServPublicDTO> listarHistorialesProyeccionesAnualesAdqServPublicPag(Pageable pageable, Long idHistorialProyeccionAnualAdqServPublic, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialProyeccionAnualAdqServPublic(HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO);
    RespuestaDTO consultarHistorialProyeccionAnualAdqServPublicporId(Long idHistorialProyeccionAnualAdqServPublic);
    RespuestaDTO actualizarHistorialProyeccionAnualAdqServPublic(HistorialProyeccionAnualAdqServPublicDTO historialProyeccionAnualAdqServPublicDTO);
    RespuestaDTO eliminarHistorialProyeccionAnualAdqServPublic(Long idHistorialProyeccionAnualAdqServPublic);
}
