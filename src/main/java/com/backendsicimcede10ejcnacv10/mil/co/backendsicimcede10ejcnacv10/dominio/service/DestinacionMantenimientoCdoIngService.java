//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DestinacionMantenimientoCdoIngDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface DestinacionMantenimientoCdoIngService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idDestinacionMantenimientoCdoIng, String keyword);
    List<DestinacionMantenimientoCdoIngDTO> listarDestinacionesMantenimientosCdosIng(Long idDestinacionMantenimientoCdoIng, String keyword, String orderBy, String orderMode);
    Slice<DestinacionMantenimientoCdoIngDTO> listarDestinacionesMantenimientosCdosIngOrdenadosporIdPag(Pageable pageable, Long idDestinacionMantenimientoCdoIng, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearDestinacionMantenimientoCdoIng(DestinacionMantenimientoCdoIngDTO destinacionMantenimientoCdoIngDTO);
    RespuestaDTO consultarDestinacionMantenimientoCdoIngporId(Long idDestinacionMantenimientoCdoIng);
    RespuestaDTO consultarDestinacionMantenimientoCdoIngporNombre(String nombreDestinacionMantenimientoCdoIng);
    RespuestaDTO actualizarDestinacionMantenimientoCdoIng(DestinacionMantenimientoCdoIngDTO destinacionMantenimientoCdoIngDTO);
    RespuestaDTO eliminarDestinacionMantenimientoCdoIng(Long idDestinacionMantenimientoCdoIng);
}
