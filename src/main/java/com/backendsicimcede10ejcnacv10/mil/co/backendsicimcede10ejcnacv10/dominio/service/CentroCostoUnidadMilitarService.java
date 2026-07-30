//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la interface del servicio.
*/
public interface CentroCostoUnidadMilitarService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idCentroCostoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar);
    List<CentroCostoUnidadMilitarDTO> listarCentrosCostosUnidadesMilitares(Long idCentroCostoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<CentroCostoUnidadMilitarDTO> listarCentrosCostosUnidadesMilitaresPag(Pageable pageable, Long idCentroCostoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearCentroCostoUnidadMilitar(CentroCostoUnidadMilitarDTO centroCostoUnidadMilitarDTO);
    RespuestaDTO consultarCentroCostoUnidadMilitarporId(Long idCentroCostoUnidadMilitar);
    RespuestaDTO consultarCentroCostoUnidadMilitarporCentroCostoySiglaoAcronimoUnidadMilitar(String centroCostoUnidadMilitar, String siglaoAcronimoUnidadMilitar);
    RespuestaDTO actualizarCentroCostoUnidadMilitar(CentroCostoUnidadMilitarDTO centroCostoUnidadMilitarDTO);
    RespuestaDTO eliminarCentroCostoUnidadMilitar(Long idCentroCostoUnidadMilitar);
}
