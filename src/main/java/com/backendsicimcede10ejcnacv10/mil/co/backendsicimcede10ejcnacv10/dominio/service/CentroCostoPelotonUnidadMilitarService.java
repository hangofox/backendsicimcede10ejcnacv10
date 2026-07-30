//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoPelotonUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface CentroCostoPelotonUnidadMilitarService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idCentroCostoPelotonUnidadMilitar, String keyword, String nombrePelotonUnidadMilitar);
    List<CentroCostoPelotonUnidadMilitarDTO> listarCentrosCostosPelotonesUnidadesMilitares(Long idCentroCostoPelotonUnidadMilitar, String keyword, String nombrePelotonUnidadMilitar, String orderBy, String orderMode);
    Slice<CentroCostoPelotonUnidadMilitarDTO> listarCentrosCostosPelotonesUnidadesMilitaresPag(Pageable pageable, Long idCentroCostoPelotonUnidadMilitar, String keyword, String nombrePelotonUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearCentroCostoPelotonUnidadMilitar(CentroCostoPelotonUnidadMilitarDTO centroCostoPelotonUnidadMilitarDTO);
    RespuestaDTO consultarCentroCostoPelotonUnidadMilitarporId(Long idCentroCostoPelotonUnidadMilitar);
    RespuestaDTO consultarCentroCostoPelotonUnidadMilitarporNombreYNombrePelotonUnidadMilitar(String centroCostoPelotonUnidadMilitar, String nombrePelotonUnidadMilitar);
    RespuestaDTO actualizarCentroCostoPelotonUnidadMilitar(CentroCostoPelotonUnidadMilitarDTO centroCostoPelotonUnidadMilitarDTO);
    RespuestaDTO eliminarCentroCostoPelotonUnidadMilitar(Long idCentroCostoPelotonUnidadMilitar);
}
