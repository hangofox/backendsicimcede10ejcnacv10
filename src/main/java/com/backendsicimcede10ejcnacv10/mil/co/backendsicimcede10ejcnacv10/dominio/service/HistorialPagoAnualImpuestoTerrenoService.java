//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialPagoAnualImpuestoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialPagoAnualImpuestoTerrenoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialPagoAnualImpuestoTerreno, String keyword);
    List<HistorialPagoAnualImpuestoTerrenoDTO> listarHistorialesPagosAnualesImpuestosTerrenos(Long idHistorialPagoAnualImpuestoTerreno, String keyword, String orderBy, String orderMode);
    Slice<HistorialPagoAnualImpuestoTerrenoDTO> listarHistorialesPagosAnualesImpuestosTerminosPag(Pageable pageable, Long idHistorialPagoAnualImpuestoTerreno, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialPagoAnualImpuestoTerreno(HistorialPagoAnualImpuestoTerrenoDTO historialPagoAnualImpuestoTerrenoDTO);
    RespuestaDTO consultarHistorialPagoAnualImpuestoTerrenoportId(Long idHistorialPagoAnualImpuestoTerreno);
    RespuestaDTO consultarHistorialPagoAnualImpuestoTerrenoportNumReg(String numRegHistorialPagoAnualImpuestoTerreno);
    RespuestaDTO actualizarHistorialPagoAnualImpuestoTerreno(HistorialPagoAnualImpuestoTerrenoDTO historialPagoAnualImpuestoTerrenoDTO);
    RespuestaDTO eliminarHistorialPagoAnualImpuestoTerreno(Long idHistorialPagoAnualImpuestoTerreno);
}
