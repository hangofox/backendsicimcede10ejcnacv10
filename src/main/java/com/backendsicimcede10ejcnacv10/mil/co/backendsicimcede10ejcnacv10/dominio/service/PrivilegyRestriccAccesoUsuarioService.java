//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PrivilegyRestriccAccesoUsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface PrivilegyRestriccAccesoUsuarioService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idPrivilegyRestriccAccesoUsuario, String keyword, Long idFuncionalidad, String nombreFuncionalidad, Long idRol, String nombreRol, String siglaoAcronimoUnidadMilitar, Long idUsuario);
    List<PrivilegyRestriccAccesoUsuarioDTO> listarPrivilegyRestriccAccesosUsuarios(Long idPrivilegioyRestriccionAccesoUsuario, String keyword, Long idFuncionalidad, String nombreFuncionalidad, Long idRol, String nombreRol, String siglaoAcronimoUnidadMilitar, Long idUsuario, String orderBy, String orderMode);
    Slice<PrivilegyRestriccAccesoUsuarioDTO> listarPrivilegyRestriccAccesosUsuariosPag(Pageable pageable, Long idPrivilegioyRestriccionAccesoUsuario, String keyword, Long idFuncionalidad, String nombreFuncionalidad, Long idRol, String nombreRol, String siglaoAcronimoUnidadMilitar, Long idUsuario, String orderBy, String orderMode);
    RespuestaDTO crearPrivilegyRestriccAccesoUsuario(PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO);
    RespuestaDTO crearPrivilegyRestriccAccesosUsuarios(List<PrivilegyRestriccAccesoUsuarioDTO> privilegyRestriccAccesoUsuarioDTOS);
    RespuestaDTO consultarPrivilegyRestriccAccesoUsuarioporId(Long idPrivilegioyRestriccionAccesoUsuario);
    RespuestaDTO consultarPrivilegyRestriccAccesoUsuarioporSAUnidadMilitareIdUsuarioeIdFuncionalidadeIdRol(String siglaoAcronimoUnidadMilitar, Long idUsuario, Long idFuncionalidad, Long idRol);
    RespuestaDTO consultarPrivilegyRestriccAccesoUsuarioporSAUnidadMilitareIdUsuarioyNombreFuncionalidadyNombreRol(String siglaoAcronimoUnidadMilitar, Long idUsuario, String nombreFuncionalidad, String nombreRol);
    RespuestaDTO actualizarPrivilegyRestriccAccesoUsuario(PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO);
    RespuestaDTO eliminarPrivilegyRestriccAccesoUsuario(Long idPrivilegioyRestriccionAccesoUsuario);
    RespuestaDTO vaciarPrivilegyRestriccAccesosUsuariosNivelGeneralporIdUsuario(Long idUsuario);
    RespuestaDTO vaciarPrivilegyRestriccAccesosUsuariosUnidadMilitarporIdUsuarioySAUnidadMilitar(Long idUsuario, String siglaoAcronimoUnidadMilitar);
}
