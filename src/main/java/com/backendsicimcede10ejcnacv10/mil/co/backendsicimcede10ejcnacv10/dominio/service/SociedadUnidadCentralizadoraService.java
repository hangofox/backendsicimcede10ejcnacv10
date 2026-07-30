//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SociedadUnidadCentralizadoraDTO;
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
public interface SociedadUnidadCentralizadoraService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idSociedadUnidadCentralizadora, String keyword, String siglaoAcronimoUnidadMilitar);
    List<SociedadUnidadCentralizadoraDTO> listarSociedadesUnidadesCentralizadoras(Long idSociedadUnidadCentralizadora, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    Slice<SociedadUnidadCentralizadoraDTO> listarSociedadesUnidadesCentralizadorasPag(Pageable pageable, Long idSociedadUnidadCentralizadora, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode);
    RespuestaDTO crearSociedadUnidadCentralizadora(SociedadUnidadCentralizadoraDTO sociedadUnidadCentralizadoraDTO);
    RespuestaDTO consultarSociedadUnidadCentralizadoraporId(Long idSociedadUnidadCentralizadora);
    RespuestaDTO consultarSociedadUnidadCentralizadoraporCodigo(String codigoSociedadUnidadCentralizadora);
    RespuestaDTO actualizarSociedadUnidadCentralizadora(SociedadUnidadCentralizadoraDTO sociedadUnidadCentralizadoraDTO);
    RespuestaDTO eliminarSociedadUnidadCentralizadora(Long idSociedadUnidadCentralizadora);
}
