//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaMandoUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Esta es la declaración de la interface del servicio.
*/
public interface LineaMandoUnidadMilitarService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idLineaMandoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar);
    List<LineaMandoUnidadMilitarDTO> listarLineasMandosUnidadesMilitares(Long idLineaMandoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<LineaMandoUnidadMilitarDTO> listarLineasMandosUnidadesMilitaresPag(Pageable pageable, Long idLineaMandoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearLineaMandoUnidadMilitar(LineaMandoUnidadMilitarDTO lineaMandoUnidadMilitarDTO);
    RespuestaDTO consultarLineaMandoUnidadMilitarporId(Long idLineaMandoUnidadMilitar);
    RespuestaDTO consultarLineaMandoUnidadMilitarporLineaMandoySiglaoAcronimoUnidadMilitar(String lineaMandoUnidadMilitar, String siglaoAcronimoUnidadMilitar);
    RespuestaDTO actualizarLineaMandoUnidadMilitar(LineaMandoUnidadMilitarDTO lineaMandoUnidadMilitarDTO);
    RespuestaDTO eliminarLineaMandoUnidadMilitar(Long idLineaMandoUnidadMilitar);
}
