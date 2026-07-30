//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialResponsableInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Esta es la declaración de la interfaz del servicio.
*/
public interface HistorialResponsableInfraestructuraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idHistorialResponsableInfraestructura, String keyword);
    List<HistorialResponsableInfraestructuraDTO> listarHistorialesResponsablesInfraestructuras(Long idHistorialResponsableInfraestructura, String keyword, String orderBy, String orderMode);
    Slice<HistorialResponsableInfraestructuraDTO> listarHistorialesResponsablesInfraestructurasPag(Pageable pageable, Long idHistorialResponsableInfraestructura, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearHistorialResponsableInfraestructura(HistorialResponsableInfraestructuraDTO historialResponsableInfraestructuraDTO);
    RespuestaDTO consultarHistorialResponsableInfraestructuraporId(Long idHistorialResponsableInfraestructura);
    RespuestaDTO consultarHistorialResponsableInfraestructuraporNumReg(String numRegHistorialResponsableInfraestructura);
    RespuestaDTO actualizarHistorialResponsableInfraestructura(HistorialResponsableInfraestructuraDTO historialResponsableInfraestructuraDTO);
    RespuestaDTO eliminarHistorialResponsableInfraestructura(Long idHistorialResponsableInfraestructura);
}
