//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoCompaniaUnidadMilitarDTO;
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
public interface CentroCostoCompaniaUnidadMilitarService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idCentroCostoCompaniaUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar);
    List<CentroCostoCompaniaUnidadMilitarDTO> listarCentrosCostosCompaniasUnidadesMilitares(Long idCentroCostoCompaniaUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar, String orderBy, String orderMode);
    Slice<CentroCostoCompaniaUnidadMilitarDTO> listarCentrosCostosCompaniasUnidadesMilitaresPag(Pageable pageable, Long idCentroCostoCompaniaUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearCentroCostoCompaniaUnidadMilitar(CentroCostoCompaniaUnidadMilitarDTO centroCostoCompaniaUnidadMilitarDTO);
    RespuestaDTO consultarCentroCostoCompaniaUnidadMilitarporId(Long idCentroCostoCompaniaUnidadMilitar);
    RespuestaDTO consultarCentroCostoCompaniaUnidadMilitarporNombreYNombreCompaniaUnidadMilitar(String centroCostoCompaniaUnidadMilitar, String nombreCompaniaUnidadMilitar);
    RespuestaDTO actualizarCentroCostoCompaniaUnidadMilitar(CentroCostoCompaniaUnidadMilitarDTO centroCostoCompaniaUnidadMilitarDTO);
    RespuestaDTO eliminarCentroCostoCompaniaUnidadMilitar(Long idCentroCostoCompaniaUnidadMilitar);
}
