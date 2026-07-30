//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ApoyoAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ApoyoAtencPrevEmergDesastService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idApoyoAtencPrevEmergDesast, String keyword, Long idUnidadMilitar, Long idProcesoApoyoAtencionPrevencion);
    List<ApoyoAtencPrevEmergDesastDTO> listarApoyosAtencPrevEmergDesast(Long idApoyoAtencPrevEmergDesast, String keyword, Long idUnidadMilitar, Long idProcesoApoyoAtencionPrevencion, String orderBy, String orderMode);
    Slice<ApoyoAtencPrevEmergDesastDTO> listarApoyosAtencPrevEmergDesastPag(Pageable pageable, Long idApoyoAtencPrevEmergDesast, String keyword, Long idUnidadMilitar, Long idProcesoApoyoAtencionPrevencion, String orderBy, String orderMode);
    RespuestaDTO crearApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesastDTO apoyoAtencPrevEmergDesastDTO);
    RespuestaDTO consultarApoyoAtencPrevEmergDesastporId(Long idApoyoAtencPrevEmergDesast);
    RespuestaDTO consultarApoyoAtencPrevEmergDesastporCodigoRadicado(String codigoRadicadoApoyoAtencPrevEmergDesast);
    RespuestaDTO actualizarApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesastDTO apoyoAtencPrevEmergDesastDTO);
    RespuestaDTO eliminarApoyoAtencPrevEmergDesast(Long idApoyoAtencPrevEmergDesast);
}
