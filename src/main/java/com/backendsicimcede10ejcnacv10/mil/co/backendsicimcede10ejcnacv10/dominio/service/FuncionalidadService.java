//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FuncionalidadDTO;
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
public interface FuncionalidadService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idFuncionalidad, String keyword);
    List<FuncionalidadDTO> listarFuncionalidades(Long idFuncionalidad, String keyword, String orderBy, String orderMode);
    Slice<FuncionalidadDTO> listarFuncionalidadesPag(Pageable pageable, Long idFuncionalidad, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearFuncionalidad(FuncionalidadDTO funcionalidadDTO);
    RespuestaDTO consultarFuncionalidadporId(Long idFuncionalidad);
    RespuestaDTO consultarFuncionalidadporNombre(String nombreFuncionalidad);
    RespuestaDTO actualizarFuncionalidad(FuncionalidadDTO funcionalidadDTO);
    RespuestaDTO eliminarFuncionalidad(Long idFuncionalidad);
}
