//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.IntegrantesApoyosObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface IntegrantesApoyosObrRedMitigGestRiesgDesastService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String gradoJefeSeccionTecnicaUnidadMilitar, String nombresJefeSeccionTecnicaUnidadMilitar, String primerApellidoJefeSeccionTecnicaUnidadMilitar, String segundoApellidoJefeSeccionTecnicaUnidadMilitar, String cargoJefeSeccionTecnicaUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword);
    List<IntegrantesApoyosObrRedMitigGestRiesgDesastDTO> listarIntegrantesApoyosObrRedMitigGestRiesgDesast(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String gradoJefeSeccionTecnicaUnidadMilitar, String nombresJefeSeccionTecnicaUnidadMilitar, String primerApellidoJefeSeccionTecnicaUnidadMilitar, String segundoApellidoJefeSeccionTecnicaUnidadMilitar, String cargoJefeSeccionTecnicaUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword, String orderBy, String orderMode);
    Slice<IntegrantesApoyosObrRedMitigGestRiesgDesastDTO> listarIntegrantesApoyosObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idIntegrantesApoyosObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String gradoJefeSeccionTecnicaUnidadMilitar, String nombresJefeSeccionTecnicaUnidadMilitar, String primerApellidoJefeSeccionTecnicaUnidadMilitar, String segundoApellidoJefeSeccionTecnicaUnidadMilitar, String cargoJefeSeccionTecnicaUnidadMilitar, String gradoJefeOperacionesUnidadMilitar, String nombresJefeOperacionesUnidadMilitar, String primerApellidoJefeOperacionesUnidadMilitar, String segundoApellidoJefeOperacionesUnidadMilitar, String cargoJefeOperacionesUnidadMilitar, String gradoCteUnidadMilitar, String nombresCteUnidadMilitar, String primerApellidoCteUnidadMilitar, String segundoApellidoCteUnidadMilitar, String cargoCteUnidadMilitar, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearIntegrantesApoyosObrRedMitigGestRiesgDesast(IntegrantesApoyosObrRedMitigGestRiesgDesastDTO integrantesApoyosObrRedMitigGestRiesgDesastDTO);
    RespuestaDTO consultarIntegrantesApoyosObrRedMitigGestRiesgDesastporId(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast);
    RespuestaDTO actualizarIntegrantesApoyosObrRedMitigGestRiesgDesast(IntegrantesApoyosObrRedMitigGestRiesgDesastDTO integrantesApoyosObrRedMitigGestRiesgDesastDTO);
    RespuestaDTO eliminarIntegrantesApoyosObrRedMitigGestRiesgDesast(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast);
}
