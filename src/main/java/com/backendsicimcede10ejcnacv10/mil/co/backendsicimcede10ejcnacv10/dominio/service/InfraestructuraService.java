//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InfraestructuraDTO;
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
public interface InfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar);
    List<InfraestructuraDTO> listarInfraestructuras(Long idInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<InfraestructuraDTO> listarInfraestructurasPag(Pageable pageable, Long idInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearInfraestructura(InfraestructuraDTO infraestructuraDTO);
    RespuestaDTO consultarInfraestructuraporId(Long idInfraestructura);
    RespuestaDTO consultarInfraestructuraporNumeroInventarioNumeroActivoFijo(String numeroInventarioInfraestructura, String numeroActivoFijoInfraestructura);
    RespuestaDTO actualizarInfraestructura(InfraestructuraDTO infraestructuraDTO);
    RespuestaDTO eliminarInfraestructura(Long idInfraestructura);
}
