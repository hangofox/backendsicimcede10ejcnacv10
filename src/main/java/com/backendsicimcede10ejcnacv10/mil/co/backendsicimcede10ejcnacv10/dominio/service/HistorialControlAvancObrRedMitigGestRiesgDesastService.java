//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialControlAvancObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialControlAvancObrRedMitigGestRiesgDesastService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialControlAvancObrRedMitigGestRiesgDesast, String keyword);
    List<HistorialControlAvancObrRedMitigGestRiesgDesastDTO> listarHistorialesControlesAvancsObrRedMitigGestRiesgDesast(Long idHistorialControlAvancObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode);
    Slice<HistorialControlAvancObrRedMitigGestRiesgDesastDTO> listarHistorialesControlesAvancsObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idHistorialControlAvancObrRedMitigGestRiesgDesast, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialControlAvancObrRedMitigGestRiesgDesast(HistorialControlAvancObrRedMitigGestRiesgDesastDTO historialControlAvancObrRedMitigGestRiesgDesastDTO);
    RespuestaDTO consultarHistorialControlAvancObrRedMitigGestRiesgDesastporId(Long idHistorialControlAvancObrRedMitigGestRiesgDesast);
    RespuestaDTO consultarHistorialControlAvancObrRedMitigGestRiesgDesastporNumReg(String numRegHistorialControlAvancObrRedMitigGestRiesgDesast);
    RespuestaDTO actualizarHistorialControlAvancObrRedMitigGestRiesgDesast(HistorialControlAvancObrRedMitigGestRiesgDesastDTO historialControlAvancObrRedMitigGestRiesgDesastDTO);
    RespuestaDTO eliminarHistorialControlAvancObrRedMitigGestRiesgDesast(Long idHistorialControlAvancObrRedMitigGestRiesgDesast);
}
