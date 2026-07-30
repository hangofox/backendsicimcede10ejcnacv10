//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CompaniaUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface CompaniaUnidadMilitarService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idCompaniaUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar);
    List<CompaniaUnidadMilitarDTO> listarCompaniasUnidadesMilitares(Long idCompaniaUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<CompaniaUnidadMilitarDTO> listarCompaniasUnidadesMilitaresPag(Pageable pageable, Long idCompaniaUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearCompaniaUnidadMilitar(CompaniaUnidadMilitarDTO companiaUnidadMilitarDTO);
    RespuestaDTO consultarCompaniaUnidadMilitarporId(Long idCompaniaUnidadMilitar);
    RespuestaDTO consultarCompaniaUnidadMilitarporNombreySAUnidadMilitar(String nombreCompaniaUnidadMilitar, String siglaoAcronimoUnidadMilitar);
    RespuestaDTO actualizarCompaniaUnidadMilitar(CompaniaUnidadMilitarDTO companiaUnidadMilitarDTO);
    RespuestaDTO eliminarCompaniaUnidadMilitar(Long idCompaniaUnidadMilitar);
}
