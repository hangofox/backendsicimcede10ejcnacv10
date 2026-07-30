//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialDemeritoYDesgasteEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialDemeritoYDesgasteEquipoIngenieroService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialDemeritoYDesgasteEquipoIngeniero, String keyword);
    List<HistorialDemeritoYDesgasteEquipoIngenieroDTO> listarHistorialesDemeritosYDesgastesEquiposIngenieros(Long idHistorialDemeritoYDesgasteEquipoIngeniero, String keyword, String orderBy, String orderMode);
    Slice<HistorialDemeritoYDesgasteEquipoIngenieroDTO> listarHistorialesDemeritosYDesgastesEquiposIngenierosPag(Pageable pageable, Long idHistorialDemeritoYDesgasteEquipoIngeniero, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialDemeritoYDesgasteEquipoIngeniero(HistorialDemeritoYDesgasteEquipoIngenieroDTO historialDemeritoYDesgasteEquipoIngenieroDTO);
    RespuestaDTO consultarHistorialDemeritoYDesgasteEquipoIngenieroporId(Long idHistorialDemeritoYDesgasteEquipoIngeniero);
    RespuestaDTO consultarHistorialDemeritoYDesgasteEquipoIngenieroporNumReg(String numRegHistorialDemeritoYDesgasteEquipoIngeniero);
    RespuestaDTO actualizarHistorialDemeritoYDesgasteEquipoIngeniero(HistorialDemeritoYDesgasteEquipoIngenieroDTO historialDemeritoYDesgasteEquipoIngenieroDTO);
    RespuestaDTO eliminarHistorialDemeritoYDesgasteEquipoIngeniero(Long idHistorialDemeritoYDesgasteEquipoIngeniero);
}
