//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroLineaBlancaDTO;
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
public interface InclusionSeguroLineaBlancaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idInclusionSeguroLineaBlanca, String keyword, Long idAseguramientoLineaBlanca);
    List<InclusionSeguroLineaBlancaDTO> listarInclusionesSeguroLineaBlanca(Long idInclusionSeguroLineaBlanca, String keyword, Long idAseguramientoLineaBlanca, String orderBy, String orderMode);
    Slice<InclusionSeguroLineaBlancaDTO> listarInclusionesSeguroLineaBlancaPag(Pageable pageable, Long idInclusionSeguroLineaBlanca, String keyword, Long idAseguramientoLineaBlanca, String orderBy, String orderMode);
    RespuestaDTO crearInclusionSeguroLineaBlanca(InclusionSeguroLineaBlancaDTO inclusionSeguroLineaBlancaDTO);
    RespuestaDTO consultarInclusionSeguroLineaBlancaporId(Long idInclusionSeguroLineaBlanca);
    RespuestaDTO actualizarInclusionSeguroLineaBlanca(InclusionSeguroLineaBlancaDTO inclusionSeguroLineaBlancaDTO);
    RespuestaDTO eliminarInclusionSeguroLineaBlanca(Long idInclusionSeguroLineaBlanca);
}
