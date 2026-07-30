//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.OficinaDTO;
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
public interface OficinaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idOficina, String keyword, String siglaoAcronimoUnidadMilitar);
    List<OficinaDTO> listarOficinas(Long idOficina, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<OficinaDTO> listarOficinasPag(Pageable pageable, Long idOficina, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearOficina(OficinaDTO oficinaDTO);
    RespuestaDTO consultarOficinaporId(Long idOficina);
    RespuestaDTO consultarOficinaporNombreySAUnidadMilitar(String nombreOficina, String siglaoAcronimoUnidadMilitar);
    RespuestaDTO actualizarOficina(OficinaDTO oficinaDTO);
    RespuestaDTO eliminarOficina(Long idOficina);
}
