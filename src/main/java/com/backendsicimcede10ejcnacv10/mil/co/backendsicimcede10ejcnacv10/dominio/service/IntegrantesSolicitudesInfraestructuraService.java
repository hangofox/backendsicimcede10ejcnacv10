//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesSolicitudesInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface IntegrantesSolicitudesInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idIntegrantesSolicitudesInfraestructura, Long idSolicitudInfraestructura);
    List<IntegrantesSolicitudesInfraestructuraDTO> listarIntegrantesSolicitudesInfraestructuras(Long idIntegrantesSolicitudesInfraestructura, Long idSolicitudInfraestructura, String orderBy, String orderMode);
    Slice<IntegrantesSolicitudesInfraestructuraDTO> listarIntegrantesSolicitudesInfraestructurasPag(Pageable pageable, Long idIntegrantesSolicitudesInfraestructura, Long idSolicitudInfraestructura, String orderBy, String orderMode);
    RespuestaDTO crearIntegrantesSolicitudesInfraestructura(IntegrantesSolicitudesInfraestructuraDTO integrantesSolicitudesInfraestructuraDTO);
    RespuestaDTO consultarIntegrantesSolicitudesInfraestructuraporId(Long idIntegrantesSolicitudesInfraestructura);
    RespuestaDTO actualizarIntegrantesSolicitudesInfraestructura(IntegrantesSolicitudesInfraestructuraDTO integrantesSolicitudesInfraestructuraDTO);
    RespuestaDTO eliminarIntegrantesSolicitudesInfraestructura(Long idIntegrantesSolicitudesInfraestructura);
}
