//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMilitarRealizadoraMantenimientoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la interface del servicio.
*/
public interface UnidadMilitarRealizadoraMantenimientoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idUnidadMilitarRealizadoraMantenimiento, String keyword, String siglaoAcronimoUnidadMilitar);
    List<UnidadMilitarRealizadoraMantenimientoDTO> listarUnidadesMilitaresRealizadorasMantenimientos(Long idUnidadMilitarRealizadoraMantenimiento, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<UnidadMilitarRealizadoraMantenimientoDTO> listarUnidadesMilitaresRealizadorasMantenimientosPag(Pageable pageable, Long idUnidadMilitarRealizadoraMantenimiento, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearUnidadMilitarRealizadoraMantenimiento(UnidadMilitarRealizadoraMantenimientoDTO unidadMilitarRealizadoraMantenimientoDTO);
    RespuestaDTO consultarUnidadMilitarRealizadoraMantenimientoportId(Long idUnidadMilitarRealizadoraMantenimiento);
    RespuestaDTO consultarUnidadMilitarRealizadoraMantenimientoporCodigo(String codigoUnidadMilitarRealizadoraMantenimiento);
    RespuestaDTO actualizarUnidadMilitarRealizadoraMantenimiento(UnidadMilitarRealizadoraMantenimientoDTO unidadMilitarRealizadoraMantenimientoDTO);
    RespuestaDTO eliminarUnidadMilitarRealizadoraMantenimiento(Long idUnidadMilitarRealizadoraMantenimiento);
}
