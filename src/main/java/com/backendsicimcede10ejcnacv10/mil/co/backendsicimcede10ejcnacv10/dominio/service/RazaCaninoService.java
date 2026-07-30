//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RazaCaninoDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface RazaCaninoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    List<RazaCaninoDTO> listarRazasCaninos();
    List<RazaCaninoDTO> listarRazasCaninosOrdenadosporId(Long idRazaCanino, String keyword, String orderBy, String orderMode);
    Slice<RazaCaninoDTO> listarRazasCaninosOrdenadosporIdPag(Pageable pageable, Long idRazaCanino, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearRazaCanino(RazaCaninoDTO razaCaninoDTO);
    RespuestaDTO consultarRazaCaninoporId(Long idRazaCanino);
    RespuestaDTO consultarRazaCaninoporNombre(String nombreRazaCanino);
    RespuestaDTO actualizarRazaCanino(RazaCaninoDTO razaCaninoDTO);
    RespuestaDTO eliminarRazaCanino(Long idRazaCanino);
}
