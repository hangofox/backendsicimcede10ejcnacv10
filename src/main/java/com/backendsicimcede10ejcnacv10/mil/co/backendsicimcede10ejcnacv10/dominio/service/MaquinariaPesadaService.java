//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MaquinariaPesadaDTO;
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
public interface MaquinariaPesadaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    List<MaquinariaPesadaDTO> listarMaquinariasPesadas();
    List<MaquinariaPesadaDTO> listarMaquinariasPesadas(Long idMaquinariaPesada, String orderBy, String orderMode);
    Slice<MaquinariaPesadaDTO> listarMaquinariasPesadasPag(Pageable pageable, Long idMaquinariaPesada, String orderBy, String orderMode);
    RespuestaDTO crearMaquinariaPesada(MaquinariaPesadaDTO maquinariaPesadaDTO);
    RespuestaDTO consultarMaquinariaPesadaporId(Long idMaquinariaPesada);
    RespuestaDTO consultarMaquinariaPesadaporNombre(String nombreMaquinariaPesada);
    RespuestaDTO actualizarMaquinariaPesada(MaquinariaPesadaDTO maquinariaPesadaDTO);
    RespuestaDTO eliminarMaquinariaPesada(Long idMaquinariaPesada);
}
