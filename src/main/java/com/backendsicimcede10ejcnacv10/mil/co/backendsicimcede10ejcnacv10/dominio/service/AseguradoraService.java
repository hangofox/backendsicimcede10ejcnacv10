//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.AseguradoraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface AseguradoraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idAseguradora, String keyword, String nombreTipoDocumentoIdentificacion, String nombreAseguradora);
    List<AseguradoraDTO> listarAseguradoras(Long idAseguradora, String keyword, String nombreTipoDocumentoIdentificacion, String nombreAseguradora, String orderBy, String orderMode);
    Slice<AseguradoraDTO> listarAseguradorasPag(Pageable pageable, Long idAseguradora, String keyword, String nombreTipoDocumentoIdentificacion, String nombreAseguradora, String orderBy, String orderMode);
    RespuestaDTO crearAseguradora(AseguradoraDTO aseguradoraDTO);
    RespuestaDTO consultarAseguradoraporId(Long idAseguradora);
    RespuestaDTO consultarAseguradoraporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionAseguradora);
    RespuestaDTO actualizarAseguradora(AseguradoraDTO aseguradoraDTO);
    RespuestaDTO eliminarAseguradora(Long idAseguradora);
}
