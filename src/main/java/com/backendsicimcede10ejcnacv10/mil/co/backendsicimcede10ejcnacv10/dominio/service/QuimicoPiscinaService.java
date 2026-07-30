//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.QuimicoPiscinaDTO;
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
public interface QuimicoPiscinaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idQuimicoPiscina, String keyword);
    List<QuimicoPiscinaDTO> listarQuimicosPiscinas(Long idQuimicoPiscina, String keyword, String orderBy, String orderMode);
    Slice<QuimicoPiscinaDTO> listarQuimicosPiscinasPag(Pageable pageable, Long idQuimicoPiscina, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearQuimicoPiscina(QuimicoPiscinaDTO quimicoPiscinaDTO);
    RespuestaDTO consultarQuimicoPiscinaporId(Long idQuimicoPiscina);
    RespuestaDTO consultarQuimicoPiscinaporNombre(String nombreQuimicoPiscina);
    RespuestaDTO actualizarQuimicoPiscina(QuimicoPiscinaDTO quimicoPiscinaDTO);
    RespuestaDTO eliminarQuimicoPiscina(Long idQuimicoPiscina);
}
