//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CapituloInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface CapituloInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    List<CapituloInfraestructuraDTO> listarCapitulosInfraestructuras();
    List<CapituloInfraestructuraDTO> listarCapitulosInfraestructurasOrdenadosporId(String orderMode);
    Slice<CapituloInfraestructuraDTO> listarCapitulosInfraestructurasOrdenadosporIdPag(Pageable pageable, String orderMode);
    RespuestaDTO crearCapituloInfraestructura(CapituloInfraestructuraDTO capituloInfraestructuraDTO);
    RespuestaDTO consultarCapituloInfraestructuraporId(Long idCapituloInfraestructura);
    RespuestaDTO consultarCapituloInfraestructuraporNombre(String nombreCapituloInfraestructura);
    RespuestaDTO actualizarCapituloInfraestructura(CapituloInfraestructuraDTO capituloInfraestructuraDTO);
    RespuestaDTO eliminarCapituloInfraestructura(Long idCapituloInfraestructura);
}
