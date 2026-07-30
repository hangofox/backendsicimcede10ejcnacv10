//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MaterialTecnicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la interface del servicio.
*/
public interface MaterialTecnicoService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idMaterialTecnico, String keyword, String siglaoAcronimoUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo);
    List<MaterialTecnicoDTO> listarMaterialesTecnicos(Long idMaterialTecnico, String keyword, String siglaoAcronimoUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode);
    Slice<MaterialTecnicoDTO> listarMaterialesTecnicosPag(Pageable pageable, Long idMaterialTecnico, String keyword, String siglaoAcronimoUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode);
    RespuestaDTO crearMaterialTecnico(MaterialTecnicoDTO materialTecnicoDTO);
    RespuestaDTO consultarMaterialTecnicoporId(Long idMaterialTecnico);
    RespuestaDTO consultarMaterialTecnicoporNumeroInventarioNumeroActivoFijo(String numeroInventarioMaterialTecnico, String numeroActivoFijoMaterialTecnico);
    RespuestaDTO actualizarMaterialTecnico(MaterialTecnicoDTO materialTecnicoDTO);
    RespuestaDTO eliminarMaterialTecnico(Long idMaterialTecnico);
}
