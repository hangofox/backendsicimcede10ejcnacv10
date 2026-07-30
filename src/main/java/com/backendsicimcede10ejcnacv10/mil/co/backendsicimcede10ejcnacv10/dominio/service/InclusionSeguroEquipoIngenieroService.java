//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface InclusionSeguroEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idInclusionSeguroEquipoIngeniero, String keyword, Long idAseguramientoEquipoIngeniero);
    List<InclusionSeguroEquipoIngenieroDTO> listarInclusionesSeguroEquipoIngeniero(Long idInclusionSeguroEquipoIngeniero, String keyword, Long idAseguramientoEquipoIngeniero, String orderBy, String orderMode);
    Slice<InclusionSeguroEquipoIngenieroDTO> listarInclusionesSeguroEquipoIngeneroPag(Pageable pageable, Long idInclusionSeguroEquipoIngeniero, String keyword, Long idAseguramientoEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearInclusionSeguroEquipoIngeniero(InclusionSeguroEquipoIngenieroDTO inclusionSeguroEquipoIngenieroDTO);
    RespuestaDTO consultarInclusionSeguroEquipoIngenieroporId(Long idInclusionSeguroEquipoIngeniero);
    RespuestaDTO actualizarInclusionSeguroEquipoIngeniero(InclusionSeguroEquipoIngenieroDTO inclusionSeguroEquipoIngenieroDTO);
    RespuestaDTO eliminarInclusionSeguroEquipoIngeniero(Long idInclusionSeguroEquipoIngeniero);
}
