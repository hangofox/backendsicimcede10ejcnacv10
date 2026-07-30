//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PaisMundoDTO;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface PaisMundoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros();
    List<PaisMundoDTO> listarPaisesMundo();
    List<PaisMundoDTO> listarPaisesMundoOrdenadosporId(String orderBy, String orderMode);
    Slice<PaisMundoDTO> listarPaisesMundoOrdenadosporIdPag(Pageable pageable, String orderBy, String orderMode);
    RespuestaDTO crearPaisMundo(PaisMundoDTO paisMundoDTO);
    RespuestaDTO consultarPaisMundoporId(Long idPaisMundo);
    RespuestaDTO consultarPaisMundoporNombre(String nombrePaisMundo);
    RespuestaDTO actualizarPaisMundo(PaisMundoDTO paisMundoDTO);
    RespuestaDTO eliminarPaisMundo(Long idPaisMundo);
}
