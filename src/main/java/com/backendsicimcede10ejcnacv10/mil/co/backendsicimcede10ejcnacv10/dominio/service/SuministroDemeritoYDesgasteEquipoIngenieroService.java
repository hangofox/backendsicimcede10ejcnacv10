//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SuministroDemeritoYDesgasteEquipoIngenieroDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface SuministroDemeritoYDesgasteEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idSuministroDemeritoYDesgasteEquipoIngeniero, String keyword, Long idHistorialDemeritoYDesgasteEquipoIngeniero);
    List<SuministroDemeritoYDesgasteEquipoIngenieroDTO> listarSuministrosDemeritosYDesgastesEquiposIngenieros(Long idSuministroDemeritoYDesgasteEquipoIngeniero, String keyword, Long idHistorialDemeritoYDesgasteEquipoIngeniero, String orderBy, String orderMode);
    Slice<SuministroDemeritoYDesgasteEquipoIngenieroDTO> listarSuministrosDemeritosYDesgastesEquiposIngenierosPag(Pageable pageable, Long idSuministroDemeritoYDesgasteEquipoIngeniero, String keyword, Long idHistorialDemeritoYDesgasteEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearSuministroDemeritoYDesgasteEquipoIngeniero(SuministroDemeritoYDesgasteEquipoIngenieroDTO suministroDemeritoYDesgasteEquipoIngenieroDTO);
    RespuestaDTO consultarSuministroDemeritoYDesgasteEquipoIngenieroporId(Long idSuministroDemeritoYDesgasteEquipoIngeniero);
    RespuestaDTO actualizarSuministroDemeritoYDesgasteEquipoIngeniero(SuministroDemeritoYDesgasteEquipoIngenieroDTO suministroDemeritoYDesgasteEquipoIngenieroDTO);
    RespuestaDTO eliminarSuministroDemeritoYDesgasteEquipoIngeniero(Long idSuministroDemeritoYDesgasteEquipoIngeniero);
}
