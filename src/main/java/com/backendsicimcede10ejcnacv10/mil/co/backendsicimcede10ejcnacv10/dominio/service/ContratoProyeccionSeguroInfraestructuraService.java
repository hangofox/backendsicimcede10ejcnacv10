//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ContratoProyeccionSeguroInfraestructuraDTO;
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
public interface ContratoProyeccionSeguroInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idContratoProyeccionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura);
    List<ContratoProyeccionSeguroInfraestructuraDTO> listarContratosProyeccionesSegurosInfraestructuras(Long idContratoProyeccionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura, String orderBy, String orderMode);
    Slice<ContratoProyeccionSeguroInfraestructuraDTO> listarContratosProyeccionesSegurosInfraestructurasPag(Pageable pageable, Long idContratoProyeccionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura, String orderBy, String orderMode);
    RespuestaDTO crearContratoProyeccionSeguroInfraestructura(ContratoProyeccionSeguroInfraestructuraDTO contratoProyeccionSeguroInfraestructuraDTO);
    RespuestaDTO consultarContratoProyeccionSeguroInfraestructuraporId(Long idContratoProyeccionSeguroInfraestructura);
    RespuestaDTO consultarContratoProyeccionSeguroInfraestructuraporNumeroContrato(String numeroContratoSeguroInfraestructura);
    RespuestaDTO actualizarContratoProyeccionSeguroInfraestructura(ContratoProyeccionSeguroInfraestructuraDTO contratoProyeccionSeguroInfraestructuraDTO);
    RespuestaDTO eliminarContratoProyeccionSeguroInfraestructura(Long idContratoProyeccionSeguroInfraestructura);
}
