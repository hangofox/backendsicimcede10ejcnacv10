//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoServicioPublicoDTO;
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
public interface TipoServicioPublicoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTipoServicioPublico, String keyword);
    List<TipoServicioPublicoDTO> listarTiposServiciosPublicos(Long idTipoServicioPublico, String keyword, String orderBy, String orderMode);
    Slice<TipoServicioPublicoDTO> listarTiposServiciosPublicosPag(Pageable pageable, Long idTipoServicioPublico, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoServicioPublico(TipoServicioPublicoDTO tipoServicioPublicoDTO);
    RespuestaDTO consultarTipoServicioPublicoporId(Long idTipoServicioPublico);
    RespuestaDTO consultarTipoServicioPublicoporNombre(String nombreTipoServicioPublico);
    RespuestaDTO actualizarTipoServicioPublico(TipoServicioPublicoDTO tipoServicioPublicoDTO);
    RespuestaDTO eliminarTipoServicioPublico(Long idTipoServicioPublico);
}
