//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ComodatoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface ComodatoTerrenoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idComodatoTerreno, String keyword, Long idTerreno);
    List<ComodatoTerrenoDTO> listarComodatosTerrenos(Long idComodatoTerreno, String keyword, Long idTerreno, String orderBy, String orderMode);
    Slice<ComodatoTerrenoDTO> listarComodatosTerrenosPag(Pageable pageable, Long idComodatoTerreno, String keyword, Long idTerreno, String orderBy, String orderMode);
    RespuestaDTO crearComodatoTerreno(ComodatoTerrenoDTO comodatoTerrenoDTO);
    RespuestaDTO consultarComodatoTerrenoporId(Long idComodatoTerreno);
    RespuestaDTO actualizarComodatoTerreno(ComodatoTerrenoDTO comodatoTerrenoDTO);
    RespuestaDTO eliminarComodatoTerreno(Long idComodatoTerreno);
}
