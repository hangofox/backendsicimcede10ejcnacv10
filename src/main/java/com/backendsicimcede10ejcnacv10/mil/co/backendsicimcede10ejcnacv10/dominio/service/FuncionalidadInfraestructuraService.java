//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FuncionalidadInfraestructuraDTO;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface FuncionalidadInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    List<FuncionalidadInfraestructuraDTO> listarFuncionalidadesInfraestructura();
    List<FuncionalidadInfraestructuraDTO> listarFuncionalidadesInfraestructuraOrdenadasporId(String orderBy, String orderMode);
    Slice<FuncionalidadInfraestructuraDTO> listarFuncionalidadesInfraestructuraOrdenadasporIdPag(Pageable pageable, String orderBy, String orderMode);
    RespuestaDTO crearFuncionalidadInfraestructura(FuncionalidadInfraestructuraDTO funcionalidadInfraestructuraDTO);
    RespuestaDTO consultarFuncionalidadInfraestructuraporId(Long idFuncionalidadInfraestructura);
    RespuestaDTO consultarFuncionalidadInfraestructuraporNombre(String nombreFuncionalidadInfraestructura);
    RespuestaDTO actualizarFuncionalidadInfraestructura(FuncionalidadInfraestructuraDTO funcionalidadInfraestructuraDTO);
    RespuestaDTO eliminarFuncionalidadInfraestructura(Long idFuncionalidadInfraestructura);
}
