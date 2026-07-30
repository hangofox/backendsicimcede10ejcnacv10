//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDespejeArtefactoExplosivoDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TipoDespejeArtefactoExplosivoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    //1. CONTADORES DE REGISTROS FILTRADOS.
    Long contarTotalRegistros(Long idTipoDespejeArtefactoExplosivo, String keyword);
    //2. LISTADO DE REGISTROS FILTRADOS.
    List<TipoDespejeArtefactoExplosivoDTO> listarTiposDespejesArtefactosExplosivos(Long idTipoDespejeArtefactoExplosivo, String keyword, String orderBy, String orderMode);
    Slice<TipoDespejeArtefactoExplosivoDTO> listarTiposDespejesArtefactosExplosivosPag(Pageable pageable, Long idTipoDespejeArtefactoExplosivo, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearTipoDespejeArtefactoExplosivo(TipoDespejeArtefactoExplosivoDTO tipoDespejeArtefactoExplosivoDTO);
    RespuestaDTO consultarTipoDespejeArtefactoExplosivoporId(Long idTipoDespejeArtefactoExplosivo);
    RespuestaDTO consultarTipoDespejeArtefactoExplosivoporNombre(String nombreTipoDespejeArtefactoExplosivo);
    RespuestaDTO actualizarTipoDespejeArtefactoExplosivo(TipoDespejeArtefactoExplosivoDTO tipoDespejeArtefactoExplosivoDTO);
    RespuestaDTO eliminarTipoDespejeArtefactoExplosivo(Long idTipoDespejeArtefactoExplosivo);
}
