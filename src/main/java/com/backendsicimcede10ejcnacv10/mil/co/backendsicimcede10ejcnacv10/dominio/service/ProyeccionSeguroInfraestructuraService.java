//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ProyeccionSeguroInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idProyeccionSeguroInfraestructura, Long idInfraestructura, String valorSolicitadoProySegInfraest, String valorSolicitadoTodoRiesgoProySegInfraest, String valorSolicitadoRenegociacionProySegInfraest, String keyword);
    List<ProyeccionSeguroInfraestructuraDTO> listarProyeccionesSegurosInfraestructuras(Long idProyeccionSeguroInfraestructura, Long idInfraestructura, String valorSolicitadoProySegInfraest, String valorSolicitadoTodoRiesgoProySegInfraest, String valorSolicitadoRenegociacionProySegInfraest, String keyword, String orderBy, String orderMode);
    Slice<ProyeccionSeguroInfraestructuraDTO> listarProyeccionesSegurosInfraestructurasPag(Pageable pageable, Long idProyeccionSeguroInfraestructura, Long idInfraestructura, String valorSolicitadoProySegInfraest, String valorSolicitadoTodoRiesgoProySegInfraest, String valorSolicitadoRenegociacionProySegInfraest, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearProyeccionSeguroInfraestructura(ProyeccionSeguroInfraestructuraDTO proyeccionSeguroInfraestructuraDTO);
    RespuestaDTO consultarProyeccionSeguroInfraestructuraporId(Long idProyeccionSeguroInfraestructura);
    RespuestaDTO actualizarProyeccionSeguroInfraestructura(ProyeccionSeguroInfraestructuraDTO proyeccionSeguroInfraestructuraDTO);
    RespuestaDTO eliminarProyeccionSeguroInfraestructura(Long idProyeccionSeguroInfraestructura);
}
