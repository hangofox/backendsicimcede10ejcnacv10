//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialIntegranteSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialIntegranteSolicitudInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialIntegranteSolicitudInfraestructura, Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar);
    List<HistorialIntegranteSolicitudInfraestructuraDTO> listarHistorialesIntegrantesSolicitudesInfraestructuras(Long idHistorialIntegranteSolicitudInfraestructura, Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<HistorialIntegranteSolicitudInfraestructuraDTO> listarHistorialesIntegrantesSolicitudesInfraestructurasPag(Pageable pageable, Long idHistorialIntegranteSolicitudInfraestructura, Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearHistorialIntegranteSolicitudInfraestructura(HistorialIntegranteSolicitudInfraestructuraDTO historialIntegranteSolicitudInfraestructuraDTO);
    RespuestaDTO consultarHistorialIntegranteSolicitudInfraestructuraporId(Long idHistorialIntegranteSolicitudInfraestructura);
    RespuestaDTO consultarHistorialIntegranteSolicitudInfraestructuraporNumReg(String numRegHistorialIntegranteSolicitudInfraestructura);
    RespuestaDTO actualizarHistorialIntegranteSolicitudInfraestructura(HistorialIntegranteSolicitudInfraestructuraDTO historialIntegranteSolicitudInfraestructuraDTO);
    RespuestaDTO eliminarHistorialIntegranteSolicitudInfraestructura(Long idHistorialIntegranteSolicitudInfraestructura);
}
