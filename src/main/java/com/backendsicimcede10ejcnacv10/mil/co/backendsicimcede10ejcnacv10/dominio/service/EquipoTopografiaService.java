//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EquipoTopografiaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* Esta es la declaración de la interface del servicio.
*/
public interface EquipoTopografiaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idEquipoTopografia, String keyword, String siglaoAcronimoUnidadMilitar);
    List<EquipoTopografiaDTO> listarEquiposTopografias(Long idEquipoTopografia, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<EquipoTopografiaDTO> listarEquiposTopografiasPag(Pageable pageable, Long idEquipoTopografia, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearEquipoTopografia(EquipoTopografiaDTO equipoTopografiaDTO);
    RespuestaDTO consultarEquipoTopografiaporId(Long idEquipoTopografia);
    RespuestaDTO consultarEquipoTopografiaporDenominacionySiglaoAcronimoUnidadMilitar(String denominacionEquipoTopografia, String siglaoAcronimoUnidadMilitar);
    RespuestaDTO actualizarEquipoTopografia(EquipoTopografiaDTO equipoTopografiaDTO);
    RespuestaDTO eliminarEquipoTopografia(Long idEquipoTopografia);
}
