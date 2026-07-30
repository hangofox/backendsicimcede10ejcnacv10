//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.GradoSiathDTO;
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
public interface GradoSiathService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    List<GradoSiathDTO> listarGradosSiath();
    List<GradoSiathDTO> listarGradosSiath(Long idGradoSiath, String orderBy, String orderMode);
    Slice<GradoSiathDTO> listarGradosSiathPag(Pageable pageable, Long idGradoSiath, String orderBy, String orderMode);
    RespuestaDTO crearGradoSiath(GradoSiathDTO gradoSiathDTO);
    RespuestaDTO consultarGradoSiathporId(Long idGradoSiath);
    RespuestaDTO consultarGradoSiathporNombreyFuerzaSiath(String nombreGradoSiath, Long fuerzaSiath);
    RespuestaDTO actualizarGradoSiath(GradoSiathDTO gradoSiathDTO);
    RespuestaDTO eliminarGradoSiath(Long idGradoSiath);
}
