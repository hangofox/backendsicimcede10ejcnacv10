//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TerrenoDTO;
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
public interface TerrenoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idTerreno, String keyword, String siglaoAcronimoUnidadMilitar);
    List<TerrenoDTO> listarTerrenos(Long idTerreno, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<TerrenoDTO> listarTerrenosPag(Pageable pageable, Long idTerreno, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearTerreno(TerrenoDTO terrenoDTO);
    RespuestaDTO consultarTerrenoportId(Long idTerreno);
    RespuestaDTO consultarTerrenoportNumeroInventarioNumeroActivoFijo(String numeroInventarioTerreno, String numeroActivoFijoTerreno);
    RespuestaDTO actualizarTerreno(TerrenoDTO terrenoDTO);
    RespuestaDTO eliminarTerreno(Long idTerreno);
}
