//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEntidadInstitucionalDTO;
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
public interface TipoEntidadInstitucionalService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTipoEntidadInstitucional, String keyword);
    List<TipoEntidadInstitucionalDTO> listarTiposEntidadesInstitucionales(Long idTipoEntidadInstitucional, String keyword, String orderBy, String orderMode);
    Slice<TipoEntidadInstitucionalDTO> listarTiposEntidadesInstitucionalesPag(Pageable pageable, Long idTipoEntidadInstitucional, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoEntidadInstitucional(TipoEntidadInstitucionalDTO tipoEntidadInstitucionalDTO);
    RespuestaDTO consultarTipoEntidadInstitucionalporId(Long idTipoEntidadInstitucional);
    RespuestaDTO consultarTipoEntidadInstitucionalporNombre(String nombreTipoEntidadInstitucional);
    RespuestaDTO actualizarTipoEntidadInstitucional(TipoEntidadInstitucionalDTO tipoEntidadInstitucionalDTO);
    RespuestaDTO eliminarTipoEntidadInstitucional(Long idTipoEntidadInstitucional);
}
