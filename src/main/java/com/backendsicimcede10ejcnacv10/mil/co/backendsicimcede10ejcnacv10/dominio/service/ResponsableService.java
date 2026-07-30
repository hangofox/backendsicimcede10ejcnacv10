//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ResponsableDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
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
public interface ResponsableService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idResponsable, String siglaoAcronimoUnidadMilitar, String estadoResponsable, String keyword);
    //1. LISTADO DE REGISTROS FILTRADOS.
    List<ResponsableDTO> listarResponsables(Long idResponsable, String siglaoAcronimoUnidadMilitar, String estadoResponsable, String keyword, String orderBy, String orderMode);
    Slice<ResponsableDTO> listarResponsablesPag(Pageable pageable, Long idResponsable, String siglaoAcronimoUnidadMilitar, String estadoResponsable, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearResponsable(ResponsableDTO usuarioDTO);
    RespuestaDTO consultarResponsableporId(Long idResponsable);
    RespuestaDTO consultarResponsableporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionResponsable);
    RespuestaDTO actualizarResponsable(ResponsableDTO usuarioDTO);
    RespuestaDTO eliminarResponsable(Long idResponsable);
}
