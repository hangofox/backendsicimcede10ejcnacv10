//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ParametrosSistemaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/07/2026.
* Declaración de la interface de la clase del servicio.
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface ParametrosSistemaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idParametrosSistema);
    List<ParametrosSistemaDTO> listarParametrosSistema(Long idParametrosSistema, String orderBy, String orderMode);
    Slice<ParametrosSistemaDTO> listarParametrosSistemaPag(Pageable pageable, Long idParametrosSistema, String orderBy, String orderMode);
    RespuestaDTO crearParametrosSistema(ParametrosSistemaDTO parametrosSistemaDTO);
    RespuestaDTO consultarParametrosSistemaporId(Long idParametrosSistema);
    RespuestaDTO actualizarParametrosSistema(ParametrosSistemaDTO parametrosSistemaDTO);
    RespuestaDTO eliminarParametrosSistema(Long idParametrosSistema);
}
