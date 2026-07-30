//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialEquipTranspApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la interface de la clase del servicio.
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface HistorialEquipTranspApoyAtencPrevEmergDesastService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialEquipTranspApoyAtencPrevEmergDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero);
    List<HistorialEquipTranspApoyAtencPrevEmergDesastDTO> listarHistorialesEquipsTranspsApoyAtencPrevEmergDesast(Long idHistorialEquipTranspApoyAtencPrevEmergDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero, String orderBy, String orderMode);
    Slice<HistorialEquipTranspApoyAtencPrevEmergDesastDTO> listarHistorialesEquipsTranspsApoyAtencPrevEmergDesastPag(Pageable pageable, Long idHistorialEquipTranspApoyAtencPrevEmergDesast, String keyword, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, Long idEquipoIngeniero, String orderBy, String orderMode);
    RespuestaDTO crearHistorialEquipTranspApoyAtencPrevEmergDesast(HistorialEquipTranspApoyAtencPrevEmergDesastDTO historialEquipTranspApoyAtencPrevEmergDesastDTO);
    RespuestaDTO consultarHistorialEquipTranspApoyAtencPrevEmergDesastporId(Long idHistorialEquipTranspApoyAtencPrevEmergDesast);
    RespuestaDTO consultarHistorialEquipTranspApoyAtencPrevEmergDesastporNumReg(String numRegHistorialEquipTranspApoyAtencPrevEmergDesast);
    RespuestaDTO actualizarHistorialEquipTranspApoyAtencPrevEmergDesast(HistorialEquipTranspApoyAtencPrevEmergDesastDTO historialEquipTranspApoyAtencPrevEmergDesastDTO);
    RespuestaDTO eliminarHistorialEquipTranspApoyAtencPrevEmergDesast(Long idHistorialEquipTranspApoyAtencPrevEmergDesast);
}
