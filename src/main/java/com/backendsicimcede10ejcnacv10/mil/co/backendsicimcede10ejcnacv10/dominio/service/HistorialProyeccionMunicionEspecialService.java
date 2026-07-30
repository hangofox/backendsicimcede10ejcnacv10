//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialProyeccionMunicionEspecialDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialProyeccionMunicionEspecialService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialProyeccionMunicionEspecial, String keyword);
    List<HistorialProyeccionMunicionEspecialDTO> listarHistorialesProyeccionesMunicionesEspeciales(Long idHistorialProyeccionMunicionEspecial, String keyword, String orderBy, String orderMode);
    Slice<HistorialProyeccionMunicionEspecialDTO> listarHistorialesProyeccionesMunicionesEspecialesPag(Pageable pageable, Long idHistorialProyeccionMunicionEspecial, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialProyeccionMunicionEspecial(HistorialProyeccionMunicionEspecialDTO historialProyeccionMunicionEspecialDTO);
    RespuestaDTO consultarHistorialProyeccionMunicionEspecialportId(Long idHistorialProyeccionMunicionEspecial);
    RespuestaDTO consultarHistorialProyeccionMunicionEspecialportNumReg(String numRegHistorialProyeccionMunicionEspecial);
    RespuestaDTO actualizarHistorialProyeccionMunicionEspecial(HistorialProyeccionMunicionEspecialDTO historialProyeccionMunicionEspecialDTO);
    RespuestaDTO eliminarHistorialProyeccionMunicionEspecial(Long idHistorialProyeccionMunicionEspecial);
}
