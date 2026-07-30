//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UsuarioDTO;
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
public interface UsuarioService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    Long contarTotalRegistros(Long idUsuario, String keyword);
    List<UsuarioDTO> listarUsuarios(Long idUsuario, String keyword, String orderBy, String orderMode);
    Slice<UsuarioDTO> listarUsuariosPag(Pageable pageable, Long idUsuario, String keyword, String orderBy, String orderMode);
    RespuestaDTO crearUsuario(UsuarioDTO usuarioDTO);
    RespuestaDTO consultarUsuarioporId(Long idUsuario);
    RespuestaDTO consultarUsuarioporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionUsuario);
    RespuestaDTO consultarUsuarioRecuperacionContrasenaAccesoporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionUsuario);
    RespuestaDTO consultarUsuarioporNicknameYPassword(String nicknameUsuario, String passwordUsuario);
    RespuestaDTO actualizarUsuario(UsuarioDTO usuarioDTO);
    RespuestaDTO recuperacionContrasenaAccesoUsuario(String codigoActivacionContrasenaAccesoUsuario, Long idUsuario, String passwordUsuario);
    RespuestaDTO eliminarUsuario(Long idUsuario);
}
