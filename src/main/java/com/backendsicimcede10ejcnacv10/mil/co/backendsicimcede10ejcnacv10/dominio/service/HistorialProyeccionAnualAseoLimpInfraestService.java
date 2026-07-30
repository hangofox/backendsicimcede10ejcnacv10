//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionAnualAseoLimpInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialProyeccionAnualAseoLimpInfraestService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialProyeccionAnualAseoLimpInfraest, String keyword);
    List<HistorialProyeccionAnualAseoLimpInfraestDTO> listarHistorialesProyeccionesAnualesAseoLimpInfraest(Long idHistorialProyeccionAnualAseoLimpInfraest, String keyword, String orderBy, String orderMode);
    Slice<HistorialProyeccionAnualAseoLimpInfraestDTO> listarHistorialesProyeccionesAnualesAseoLimpInfraestPag(Pageable pageable, Long idHistorialProyeccionAnualAseoLimpInfraest, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialProyeccionAnualAseoLimpInfraest(HistorialProyeccionAnualAseoLimpInfraestDTO historialProyeccionAnualAseoLimpInfraestDTO);
    RespuestaDTO consultarHistorialProyeccionAnualAseoLimpInfraestportId(Long idHistorialProyeccionAnualAseoLimpInfraest);
    RespuestaDTO consultarHistorialProyeccionAnualAseoLimpInfraestportNumReg(String numRegHistorialProyeccionAnualAseoLimpInfraest);
    RespuestaDTO actualizarHistorialProyeccionAnualAseoLimpInfraest(HistorialProyeccionAnualAseoLimpInfraestDTO historialProyeccionAnualAseoLimpInfraestDTO);
    RespuestaDTO eliminarHistorialProyeccionAnualAseoLimpInfraest(Long idHistorialProyeccionAnualAseoLimpInfraest);
}
