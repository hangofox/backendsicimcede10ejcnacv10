//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoContratoSeguroInfraestructuraDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoContratoSeguroInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idTipoContratoSeguroInfraestructura, String keyword);
    //1. LISTADO DE REGISTROS FILTRADOS.
    List<TipoContratoSeguroInfraestructuraDTO> listarTiposContratosSegurosInfraestructuras(Long idTipoContratoSeguroInfraestructura, String keyword, String orderBy, String orderMode);
    Slice<TipoContratoSeguroInfraestructuraDTO> listarTiposContratosSegurosInfraestructurasPag(Pageable pageable, Long idTipoContratoSeguroInfraestructura, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoContratoSeguroInfraestructura(TipoContratoSeguroInfraestructuraDTO tipoContratoSeguroInfraestructuraDTO);
    RespuestaDTO consultarTipoContratoSeguroInfraestructuraporId(Long idTipoContratoSeguroInfraestructura);
    RespuestaDTO consultarTipoContratoSeguroInfraestructuraporNombre(String nombreTipoContratoSeguroInfraestructura);
    RespuestaDTO actualizarTipoContratoSeguroInfraestructura(TipoContratoSeguroInfraestructuraDTO tipoContratoSeguroInfraestructuraDTO);
    RespuestaDTO eliminarTipoContratoSeguroInfraestructura(Long idTipoContratoSeguroInfraestructura);
}
