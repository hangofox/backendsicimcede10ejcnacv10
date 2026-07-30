//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoSolicitudInfraestructuraDTO;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoSolicitudInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTipoSolicitudInfraestructura, String keyword);
    List<TipoSolicitudInfraestructuraDTO> listarTiposSolicitudesInfraestructuras(Long idTipoSolicitudInfraestructura, String keyword, String orderBy, String orderMode);
    Slice<TipoSolicitudInfraestructuraDTO> listarTiposSolicitudesInfraestructurasPag(Pageable pageable, Long idTipoSolicitudInfraestructura, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoSolicitudInfraestructura(TipoSolicitudInfraestructuraDTO tipoSolicitudInfraestructuraDTO);
    RespuestaDTO consultarTipoSolicitudInfraestructuraporId(Long idTipoSolicitudInfraestructura);
    RespuestaDTO consultarTipoSolicitudInfraestructuraporNombre(String nombreTipoSolicitudInfraestructura);
    RespuestaDTO actualizarTipoSolicitudInfraestructura(TipoSolicitudInfraestructuraDTO tipoSolicitudInfraestructuraDTO);
    RespuestaDTO eliminarTipoSolicitudInfraestructura(Long idTipoSolicitudInfraestructura);
}
