//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaEquipoIngenieroDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface LineaEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idLineaEquipoIngeniero, String keyword);
    List<LineaEquipoIngenieroDTO> listarLineasEquiposIngenieros(Long idLineaEquipoIngeniero, String keyword, String orderBy, String orderMode);
    Slice<LineaEquipoIngenieroDTO> listarLineasEquiposIngenierosPag(Pageable pageable, Long idLineaEquipoIngeniero, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearLineaEquipoIngeniero(LineaEquipoIngenieroDTO lineaEquipoIngenieroDTO);
    RespuestaDTO consultarLineaEquipoIngenieroporId(Long idLineaEquipoIngeniero);
    RespuestaDTO consultarLineaEquipoIngenieroporNombre(String nombreLineaEquipoIngeniero);
    RespuestaDTO actualizarLineaEquipoIngeniero(LineaEquipoIngenieroDTO lineaEquipoIngenieroDTO);
    RespuestaDTO eliminarLineaEquipoIngeniero(Long idLineaEquipoIngeniero);
}
