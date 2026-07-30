//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InformacionFinancieraSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface InformacionFinancieraSolicitudInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(String keyword, Long idSolicitudInfraestructura);
    List<InformacionFinancieraSolicitudInfraestructuraDTO> listarInformacionesFinancierasSolicitudesInfraestructuras(String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode);
    Slice<InformacionFinancieraSolicitudInfraestructuraDTO> listarInformacionesFinancierasSolicitudesInfraestructurasPag(Pageable pageable, String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode);
    RespuestaDTO crearInformacionFinancieraSolicitudInfraestructura(InformacionFinancieraSolicitudInfraestructuraDTO informacionFinancieraSolicitudInfraestructuraDTO);
    RespuestaDTO consultarInformacionFinancieraSolicitudInfraestructuraporId(Long idInformacionFinancieraSolicitudInfraestructura);
    RespuestaDTO actualizarInformacionFinancieraSolicitudInfraestructura(InformacionFinancieraSolicitudInfraestructuraDTO informacionFinancieraSolicitudInfraestructuraDTO);
    RespuestaDTO eliminarInformacionFinancieraSolicitudInfraestructura(Long idInformacionFinancieraSolicitudInfraestructura);
}
