//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EstadoDiagnosticoEquipoIngenieroDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface EstadoDiagnosticoEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    List<EstadoDiagnosticoEquipoIngenieroDTO> listarEstadosDiagnosticosEquiposIngenieros();
    List<EstadoDiagnosticoEquipoIngenieroDTO> listarEstadosDiagnosticosEquiposIngenieros(Long idEstadoDiagnosticoEquipoIngeniero, String orderBy, String orderMode);
    Slice<EstadoDiagnosticoEquipoIngenieroDTO> listarEstadosDiagnosticosEquiposIngenierosPag(Pageable pageable, Long idEstadoDiagnosticoEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearEstadoDiagnosticoEquipoIngeniero(EstadoDiagnosticoEquipoIngenieroDTO estadoDiagnosticoEquipoIngenieroDTO);
    RespuestaDTO consultarEstadoDiagnosticoEquipoIngenieroporId(Long idEstadoDiagnosticoEquipoIngeniero);
    RespuestaDTO consultarEstadoDiagnosticoEquipoIngenieroporNombre(String nombreEstadoDiagnosticoEquipoIngeniero);
    RespuestaDTO actualizarEstadoDiagnosticoEquipoIngeniero(EstadoDiagnosticoEquipoIngenieroDTO estadoDiagnosticoEquipoIngenieroDTO);
    RespuestaDTO eliminarEstadoDiagnosticoEquipoIngeniero(Long idEstadoDiagnosticoEquipoIngeniero);
}
