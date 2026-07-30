//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface EquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, String estado);
    List<EquipoIngenieroDTO> listarEquiposIngenieros(Long idEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, String estado, String orderBy, String orderMode);
    Slice<EquipoIngenieroDTO> listarEquiposIngenierosPag(Pageable pageable, Long idEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, String estado, String orderBy, String orderMode);
    RespuestaDTO crearEquipoIngeniero(EquipoIngenieroDTO equipoIngenieroDTO);
    RespuestaDTO consultarEquipoIngenieroporId(Long idEquipoIngeniero);
    RespuestaDTO consultarEquipoIngenieroporNumeroInventarioNumeroActivoFijo(String numeroInventarioEquipoIngeniero, String numeroActivoFijoEquipoIngeniero);
    RespuestaDTO actualizarEquipoIngeniero(EquipoIngenieroDTO equipoIngenieroDTO);
    RespuestaDTO eliminarEquipoIngeniero(Long idEquipoIngeniero);
}
