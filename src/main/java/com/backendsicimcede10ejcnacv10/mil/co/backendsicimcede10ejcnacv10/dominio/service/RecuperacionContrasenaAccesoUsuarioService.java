//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RecuperacionContrasenaAccesoUsuarioDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.List;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de los métodos de respuesta en la interface para los cruds (creación, lectura (listar y consultar),
* edición y eliminación de un registro).
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface RecuperacionContrasenaAccesoUsuarioService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA LOS CRUDS QUE SON LOS METODOS PARA LA
    //CREACIÓN, LECTURA (LISTAR Y CONSULTAR), EDICIÓN Y ELIMINACIÓN DE UN REGISTRO:
    List<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuarios();
    List<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosOrdenadasporId(String orderBy, String orderMode);
    Slice<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosOrdenadasporIdPag(Pageable pageable, String orderBy, String orderMode);
    List<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosporIdUsuarioyOrdenadasporId(Long idUsuario, String orderBy, String orderMode);
    Slice<RecuperacionContrasenaAccesoUsuarioDTO> listarRecuperacionesContrasenasAccesosUsuariosporIdUsuarioyOrdenadasporIdPag(Pageable pageable, Long idUsuario, String orderBy, String orderMode);
    RespuestaDTO crearRecuperacionContrasenaAccesoUsuario(RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO);
    RespuestaDTO consultarRecuperacionContrasenaAccesoUsuarioporId(Long idRecuperacionContrasenaAccesoUsuario);
    RespuestaDTO consultarRecuperacionContrasenaAccesoUsuarioporCodigoActivacion(String codigoActivacionRecuperacionContrasenaAccesoUsuario);
    RespuestaDTO actualizarRecuperacionContrasenaAccesoUsuario(RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO);
    RespuestaDTO eliminarRecuperacionContrasenaAccesoUsuario(Long idRecuperacionContrasenaAccesoUsuario);
    RespuestaDTO actualizarEstadosUsosCodigosActivacionesContrasenasAccesosUsuarios(Date fechaHMSExpCodActivContrasenaAccesoUsuario);
    RespuestaDTO vaciarRecuperacionesContrasenasAccesosUsuariosporIdUsuario(Long idUsuario);
}
