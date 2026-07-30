//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CiudadMundoDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface CiudadMundoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //CONTADOR DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idCiudadMundo, Long idPaisMundo, Long idDepartamentooEstadoMundo, String nombrePaisMundo, String nombreDepartamentooEstadoMundo, String keyword);
    //LISTADO DE REGISTROS FILTRADOS.
    List<CiudadMundoDTO> listarCiudadesMundo(Long idCiudadMundo, Long idPaisMundo, Long idDepartamentooEstadoMundo, String nombrePaisMundo, String nombreDepartamentooEstadoMundo, String keyword, String orderBy, String orderMode);
    Slice<CiudadMundoDTO> listarCiudadesMundoPag(Pageable pageable, Long idCiudadMundo, Long idPaisMundo, Long idDepartamentooEstadoMundo, String nombrePaisMundo, String nombreDepartamentooEstadoMundo, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearCiudadMundo(CiudadMundoDTO ciudadMundoDTO);
    RespuestaDTO consultarCiudadMundoporId(Long idCiudadMundo);
    RespuestaDTO consultarCiudadMundoporIdPaisMundoeIdDepartamentooEstadoMundoeIdCiudadMundo(Long idPaisMundo, Long idDepartamentooEstadoMundo, Long idCiudadMundo);
    RespuestaDTO consultarCiudadMundoporNombrePaisMundoyNombreDepartamentooEstadoMundoyNombreCiudadMundo(String nombrePaisMundo, String nombreDepartamentooEstadoMundo, String nombreCiudadMundo);
    RespuestaDTO actualizarCiudadMundo(CiudadMundoDTO ciudadMundoDTO);
    RespuestaDTO eliminarCiudadMundo(Long idCiudadMundo);
}
