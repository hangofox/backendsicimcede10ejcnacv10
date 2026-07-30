//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PersonalMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la interface del servicio.
*/
public interface PersonalMantenimientoEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idPersonalMantenimientoEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar);
    List<PersonalMantenimientoEquipoIngenieroDTO> listarPersonalMantenimientosEquiposIngenieros(Long idPersonalMantenimientoEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<PersonalMantenimientoEquipoIngenieroDTO> listarPersonalMantenimientosEquiposIngenierosPag(Pageable pageable, Long idPersonalMantenimientoEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearPersonalMantenimientoEquipoIngeniero(PersonalMantenimientoEquipoIngenieroDTO personalMantenimientoEquipoIngenieroDTO);
    RespuestaDTO consultarPersonalMantenimientoEquipoIngenieroporId(Long idPersonalMantenimientoEquipoIngeniero);
    RespuestaDTO consultarPersonalMantenimientoEquipoIngenieroporNumDocIdentif(String numDocIdentifPersonalMantenimientoEquipoIngeniero);
    RespuestaDTO actualizarPersonalMantenimientoEquipoIngeniero(PersonalMantenimientoEquipoIngenieroDTO personalMantenimientoEquipoIngenieroDTO);
    RespuestaDTO eliminarPersonalMantenimientoEquipoIngeniero(Long idPersonalMantenimientoEquipoIngeniero);
}
