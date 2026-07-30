//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SaneamientoBasicoDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface SaneamientoBasicoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idSaneamientoBasico, String keyword, Long idInfraestructura);
    List<SaneamientoBasicoDTO> listarSaneamientosBasicos(Long idSaneamientoBasico, String keyword, Long idInfraestructura, String orderBy, String orderMode);
    Slice<SaneamientoBasicoDTO> listarSaneamientosBasicosPag(Pageable pageable, Long idSaneamientoBasico, String keyword, Long idInfraestructura, String orderBy, String orderMode);
    RespuestaDTO crearSaneamientoBasico(SaneamientoBasicoDTO saneamientoBasicoDTO);
    RespuestaDTO consultarSaneamientoBasicoporId(Long idSaneamientoBasico);
    RespuestaDTO actualizarSaneamientoBasico(SaneamientoBasicoDTO saneamientoBasicoDTO);
    RespuestaDTO eliminarSaneamientoBasico(Long idSaneamientoBasico);
}
