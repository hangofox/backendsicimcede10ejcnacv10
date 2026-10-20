//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaMandoUnidadMilitarSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Esta es la declaración de la interface del servicio.
*/
public interface LineaMandoUnidadMilitarSolicInfraestService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idLineaMandoUnidadMilitarSolicInfraest, String keyword, String siglaoAcronimoUnidadMilitar);
    List<LineaMandoUnidadMilitarSolicInfraestDTO> listarLineasMandosUnidadesMilitaresSolicInfraest(Long idLineaMandoUnidadMilitarSolicInfraest, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<LineaMandoUnidadMilitarSolicInfraestDTO> listarLineasMandosUnidadesMilitaresSolicInfraestPag(Pageable pageable, Long idLineaMandoUnidadMilitarSolicInfraest, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearLineaMandoUnidadMilitarSolicInfraest(LineaMandoUnidadMilitarSolicInfraestDTO lineaMandoUnidadMilitarSolicInfraestDTO);
    RespuestaDTO consultarLineaMandoUnidadMilitarSolicInfraestporId(Long idLineaMandoUnidadMilitarSolicInfraest);
    RespuestaDTO consultarLineaMandoUnidadMilitarSolicInfraestporLineaMandoySiglaoAcronimoUnidadMilitar(String lineaMandoUnidadMilitarSolicInfraest, String siglaoAcronimoUnidadMilitar);
    RespuestaDTO actualizarLineaMandoUnidadMilitarSolicInfraest(LineaMandoUnidadMilitarSolicInfraestDTO lineaMandoUnidadMilitarSolicInfraestDTO);
    RespuestaDTO eliminarLineaMandoUnidadMilitarSolicInfraest(Long idLineaMandoUnidadMilitarSolicInfraest);
}
