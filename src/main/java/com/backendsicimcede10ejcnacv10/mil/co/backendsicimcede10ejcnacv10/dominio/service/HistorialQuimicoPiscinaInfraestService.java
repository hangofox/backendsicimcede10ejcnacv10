//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialQuimicoPiscinaInfraestDTO;
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
public interface HistorialQuimicoPiscinaInfraestService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialQuimicoPiscinaInfraest, String keyword, Long idInfraestructura);
    List<HistorialQuimicoPiscinaInfraestDTO> listarHistorialesQuimicosPiscinasInfraest(Long idHistorialQuimicoPiscinaInfraest, String keyword, Long idInfraestructura, String orderBy, String orderMode);
    Slice<HistorialQuimicoPiscinaInfraestDTO> listarHistorialesQuimicosPiscinasInfraestPag(Pageable pageable, Long idHistorialQuimicoPiscinaInfraest, String keyword, Long idInfraestructura, String orderBy, String orderMode);
    RespuestaDTO crearHistorialQuimicoPiscinaInfraest(HistorialQuimicoPiscinaInfraestDTO historialQuimicoPiscinaInfraestDTO);
    RespuestaDTO consultarHistorialQuimicoPiscinaInfraestporId(Long idHistorialQuimicoPiscinaInfraest);
    RespuestaDTO consultarHistorialQuimicoPiscinaInfraestporNumReg(String numRegHistorialQuimicoPiscinaInfraest);
    RespuestaDTO consultarHistorialQuimicoPiscinaInfraestporNombre(String nombreHistorialQuimicoPiscinaInfraest);
    RespuestaDTO actualizarHistorialQuimicoPiscinaInfraest(HistorialQuimicoPiscinaInfraestDTO historialQuimicoPiscinaInfraestDTO);
    RespuestaDTO eliminarHistorialQuimicoPiscinaInfraest(Long idHistorialQuimicoPiscinaInfraest);
}
