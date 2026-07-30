//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RegionDaneColombiaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;
//import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface RegionDaneColombiaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros();
    Long contarTotalRegistrosporPalabraClave(String keyword);
    List<RegionDaneColombiaDTO> listarRegionesDaneColombia();
    List<RegionDaneColombiaDTO> listarRegionesDaneColombia(String keyword, String orderBy, String orderMode);
    Slice<RegionDaneColombiaDTO> listarRegionesDaneColombiaPag(Pageable pageable, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearRegionDaneColombia(RegionDaneColombiaDTO regionDaneColombiaDTO);
    RespuestaDTO consultarRegionDaneColombiaporId(Long idRegionDaneColombia);
    RespuestaDTO consultarRegionDaneColombiaporNombreCiudadMunicipioDane(String nombreCiudadMunicipioDaneColombia);
    RespuestaDTO consultarRegionDaneColombiaporCodigoDane(String codigoDaneColombia);
    RespuestaDTO actualizarRegionDaneColombia(RegionDaneColombiaDTO regionDaneColombiaDTO);
    RespuestaDTO eliminarRegionDaneColombia(Long idRegionDaneColombia);
}
