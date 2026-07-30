//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, String keyword);
    List<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO> listarTiposEmDesastGenObrRedMitigGestRiesgDesast(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode);
    Slice<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO> listarTiposEmDesastGenObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO);
    RespuestaDTO consultarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastporId(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
    RespuestaDTO consultarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastporNombre(String nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
    RespuestaDTO actualizarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastDTO);
    RespuestaDTO eliminarTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
}
