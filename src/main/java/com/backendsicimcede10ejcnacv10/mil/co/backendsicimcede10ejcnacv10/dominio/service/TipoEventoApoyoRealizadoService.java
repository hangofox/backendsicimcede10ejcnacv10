//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEventoApoyoRealizadoDTO;
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
public interface TipoEventoApoyoRealizadoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTipoEventoApoyoRealizado, String keyword);
    List<TipoEventoApoyoRealizadoDTO> listarTiposEventosApoyosRealizados(Long idTipoEventoApoyoRealizado, String keyword, String orderBy, String orderMode);
    Slice<TipoEventoApoyoRealizadoDTO> listarTiposEventosApoyosRealizadosPag(Pageable pageable, Long idTipoEventoApoyoRealizado, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoEventoApoyoRealizado(TipoEventoApoyoRealizadoDTO tipoEventoApoyoRealizadoDTO);
    RespuestaDTO consultarTipoEventoApoyoRealizadoporId(Long idTipoEventoApoyoRealizado);
    RespuestaDTO consultarTipoEventoApoyoRealizadoporNombre(String nombreTipoEventoApoyoRealizado);
    RespuestaDTO actualizarTipoEventoApoyoRealizado(TipoEventoApoyoRealizadoDTO tipoEventoApoyoRealizadoDTO);
    RespuestaDTO eliminarTipoEventoApoyoRealizado(Long idTipoEventoApoyoRealizado);
}
