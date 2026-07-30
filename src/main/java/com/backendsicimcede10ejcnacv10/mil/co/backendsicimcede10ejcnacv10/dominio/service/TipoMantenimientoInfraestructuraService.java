//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoMantenimientoInfraestructuraDTO;
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
public interface TipoMantenimientoInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTipoMantenimientoInfraestructura, String keyword);
    List<TipoMantenimientoInfraestructuraDTO> listarTiposMantenimientosInfraestructuras(Long idTipoMantenimientoInfraestructura, String keyword, String orderBy, String orderMode);
    Slice<TipoMantenimientoInfraestructuraDTO> listarTiposMantenimientosInfraestructurasPag(Pageable pageable, Long idTipoMantenimientoInfraestructura, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoMantenimientoInfraestructura(TipoMantenimientoInfraestructuraDTO tipoMantenimientoInfraestructuraDTO);
    RespuestaDTO consultarTipoMantenimientoInfraestructuraporId(Long idTipoMantenimientoInfraestructura);
    RespuestaDTO consultarTipoMantenimientoInfraestructuraporNombre(String nombreTipoMantenimientoInfraestructura);
    RespuestaDTO actualizarTipoMantenimientoInfraestructura(TipoMantenimientoInfraestructuraDTO tipoMantenimientoInfraestructuraDTO);
    RespuestaDTO eliminarTipoMantenimientoInfraestructura(Long idTipoMantenimientoInfraestructura);
}
