//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RecuperacionContrasenaAccesoUsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDocumentoIdentificacionDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoUsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RecuperacionContrasenaAccesoUsuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Usuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDocumentoIdentificacion;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoUsuario;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class RecuperacionContrasenaAccesoUsuarioDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param recuperacionContrasenaAccesoUsuarioDTO
    * Recibe un DTO para crear un objeto recuperacionContrasenaAccesoUsuario.
    * @return recuperacionContrasenaAccesoUsuario
    */
    public RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario(RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO){
        RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario = new RecuperacionContrasenaAccesoUsuario();
        recuperacionContrasenaAccesoUsuario.setIdRecuperacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO.getIdRecuperacionContrasenaAccesoUsuario());
        recuperacionContrasenaAccesoUsuario.setUsuario(usuarioDTOToEntity(recuperacionContrasenaAccesoUsuarioDTO.getUsuarioDTO()));
        recuperacionContrasenaAccesoUsuario.setCodigoActivacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO.getCodigoActivacionContrasenaAccesoUsuario());
        recuperacionContrasenaAccesoUsuario.setFechaHMSExpCodActivContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO.getFechaHMSExpCodActivContrasenaAccesoUsuario());
        recuperacionContrasenaAccesoUsuario.setEstadoUsoCodigoActivacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuarioDTO.getEstadoUsoCodigoActivacionContrasenaAccesoUsuario());
        
        return recuperacionContrasenaAccesoUsuario;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param recuperacionContrasenaAccesoUsuario
    * Recibe un DTO para un objeto recuperacionContrasenaAccesoUsuario para crear un DTO.
    * @return recuperacionContrasenaAccesoUsuarioDTO
    */
    public RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO(RecuperacionContrasenaAccesoUsuario recuperacionContrasenaAccesoUsuario){
        RecuperacionContrasenaAccesoUsuarioDTO recuperacionContrasenaAccesoUsuarioDTO = new RecuperacionContrasenaAccesoUsuarioDTO();
        recuperacionContrasenaAccesoUsuarioDTO.setIdRecuperacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuario.getIdRecuperacionContrasenaAccesoUsuario());
        recuperacionContrasenaAccesoUsuarioDTO.setUsuarioDTO(usuarioEntityToDTO(recuperacionContrasenaAccesoUsuario.getUsuario()));
        recuperacionContrasenaAccesoUsuarioDTO.setCodigoActivacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuario.getCodigoActivacionContrasenaAccesoUsuario());
        recuperacionContrasenaAccesoUsuarioDTO.setFechaHMSExpCodActivContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuario.getFechaHMSExpCodActivContrasenaAccesoUsuario());
        recuperacionContrasenaAccesoUsuarioDTO.setEstadoUsoCodigoActivacionContrasenaAccesoUsuario(recuperacionContrasenaAccesoUsuario.getEstadoUsoCodigoActivacionContrasenaAccesoUsuario());
        
        return recuperacionContrasenaAccesoUsuarioDTO;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * MÉTODOS PARA CAMPOS RELACIONALES.
    */
    
    //CONVIERTO DTO A ENTIDAD:
    private Usuario usuarioDTOToEntity(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
           return null;
        }
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        usuario.setNicknameUsuario(usuarioDTO.getNicknameUsuario());
        usuario.setPasswordUsuario(usuarioDTO.getPasswordUsuario());
        //usuario.setIdTipoDocumentoIdentificacion(usuarioDTO.getIdTipoDocumentoIdentificacion());
        usuario.setTipoDocumentoIdentificacion(tipoDocumentoIdentificacionDTOToEntity(usuarioDTO.getTipoDocumentoIdentificacionDTO()));
        usuario.setNumeroDocumentoIdentificacionUsuario(usuarioDTO.getNumeroDocumentoIdentificacionUsuario());
        usuario.setLugarExpedicionDocumentoIdentificacionUsuario(usuarioDTO.getLugarExpedicionDocumentoIdentificacionUsuario());
        usuario.setGradoUsuario(usuarioDTO.getGradoUsuario());
        usuario.setNombresUsuario(usuarioDTO.getNombresUsuario().toUpperCase());
        usuario.setPrimerApellidoUsuario(usuarioDTO.getPrimerApellidoUsuario());
        usuario.setSegundoApellidoUsuario(usuarioDTO.getSegundoApellidoUsuario());
        usuario.setNombreArchivoFotoExtensionoFormatoUsuario(usuarioDTO.getNombreArchivoFotoExtensionoFormatoUsuario());
        usuario.setFechaHMSNacimientoUsuario(usuarioDTO.getFechaHMSNacimientoUsuario());
        usuario.setSexoUsuario(usuarioDTO.getSexoUsuario());
        usuario.setDireccionUsuario(usuarioDTO.getDireccionUsuario());
        usuario.setTelefonoUsuario(usuarioDTO.getTelefonoUsuario());
        usuario.setMovilUsuario(usuarioDTO.getMovilUsuario());
        usuario.setCorreoElectronicoPersonalUsuario(usuarioDTO.getCorreoElectronicoPersonalUsuario());
        usuario.setCorreoElectronicoInstitucionalUsuario(usuarioDTO.getCorreoElectronicoInstitucionalUsuario());
        usuario.setPaisOrigenUsuario(usuarioDTO.getPaisOrigenUsuario().toUpperCase());
        usuario.setDepartamentooEstadoOrigenUsuario(usuarioDTO.getDepartamentooEstadoOrigenUsuario());
        usuario.setCiudadOrigenUsuario(usuarioDTO.getCiudadOrigenUsuario());
        //usuario.setIdTipoUsuario(usuarioDTO.getIdTipoUsuario());
        usuario.setTipoUsuario(tipoUsuarioDTOToEntity(usuarioDTO.getTipoUsuarioDTO()));
        usuario.setFechaHMSIngresoUsuario(usuarioDTO.getFechaHMSIngresoUsuario());
        usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());
        
        return usuario;
    }
    
    //CONVIERTO ENTIDAD A DTO:
    private UsuarioDTO usuarioEntityToDTO(Usuario usuario) {
        if (usuario == null) {
           return null;
        }
        
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNicknameUsuario(usuario.getNicknameUsuario());
        usuarioDTO.setPasswordUsuario(usuario.getPasswordUsuario());
        //usuarioDTO.setIdTipoDocumentoIdentificacion(usuario.getIdTipoDocumentoIdentificacion());
        usuarioDTO.setTipoDocumentoIdentificacionDTO(tipoDocumentoIdentificacionEntityToDTO(usuario.getTipoDocumentoIdentificacion()));
        usuarioDTO.setNumeroDocumentoIdentificacionUsuario(usuario.getNumeroDocumentoIdentificacionUsuario());
        usuarioDTO.setLugarExpedicionDocumentoIdentificacionUsuario(usuario.getLugarExpedicionDocumentoIdentificacionUsuario());
        usuarioDTO.setGradoUsuario(usuario.getGradoUsuario());
        usuarioDTO.setNombresUsuario(usuario.getNombresUsuario());
        usuarioDTO.setPrimerApellidoUsuario(usuario.getPrimerApellidoUsuario());
        usuarioDTO.setSegundoApellidoUsuario(usuario.getSegundoApellidoUsuario());
        usuarioDTO.setNombreArchivoFotoExtensionoFormatoUsuario(usuario.getNombreArchivoFotoExtensionoFormatoUsuario());
        usuarioDTO.setFechaHMSNacimientoUsuario(usuario.getFechaHMSNacimientoUsuario());
        usuarioDTO.setSexoUsuario(usuario.getSexoUsuario());
        usuarioDTO.setDireccionUsuario(usuario.getDireccionUsuario());
        usuarioDTO.setTelefonoUsuario(usuario.getTelefonoUsuario());
        usuarioDTO.setMovilUsuario(usuario.getMovilUsuario());
        usuarioDTO.setCorreoElectronicoPersonalUsuario(usuario.getCorreoElectronicoPersonalUsuario());
        usuarioDTO.setCorreoElectronicoInstitucionalUsuario(usuario.getCorreoElectronicoInstitucionalUsuario());
        usuarioDTO.setPaisOrigenUsuario(usuario.getPaisOrigenUsuario());
        usuarioDTO.setDepartamentooEstadoOrigenUsuario(usuario.getDepartamentooEstadoOrigenUsuario());
        usuarioDTO.setCiudadOrigenUsuario(usuario.getCiudadOrigenUsuario());
        //usuarioDTO.setIdTipoUsuario(usuario.getIdTipoUsuario());
        usuarioDTO.setTipoUsuarioDTO(tipoUsuarioEntityToDTO(usuario.getTipoUsuario()));
        usuarioDTO.setFechaHMSIngresoUsuario(usuario.getFechaHMSIngresoUsuario());
        usuarioDTO.setEstadoUsuario(usuario.getEstadoUsuario());
        
        return usuarioDTO;
    }
    
    //CONVIERTO DTO A ENTIDAD:
    private TipoDocumentoIdentificacion tipoDocumentoIdentificacionDTOToEntity(TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionDTO) {
        if (tipoDocumentoIdentificacionDTO == null) {
            return null;
        }
        
        TipoDocumentoIdentificacion tipoDocumentoIdentificacion = new TipoDocumentoIdentificacion();
        tipoDocumentoIdentificacion.setIdTipoDocumentoIdentificacion(tipoDocumentoIdentificacionDTO.getIdTipoDocumentoIdentificacion());
        tipoDocumentoIdentificacion.setNombreTipoDocumentoIdentificacion(tipoDocumentoIdentificacionDTO.getNombreTipoDocumentoIdentificacion());
        
        return tipoDocumentoIdentificacion;
    }
    
    //CONVIERTO ENTIDAD A DTO:
    private TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionEntityToDTO(TipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
        if (tipoDocumentoIdentificacion == null) {
            return null;
        }
        
        TipoDocumentoIdentificacionDTO tipoDocumentoIdentificacionDTO = new TipoDocumentoIdentificacionDTO();
        tipoDocumentoIdentificacionDTO.setIdTipoDocumentoIdentificacion(tipoDocumentoIdentificacion.getIdTipoDocumentoIdentificacion());
        tipoDocumentoIdentificacionDTO.setNombreTipoDocumentoIdentificacion(tipoDocumentoIdentificacion.getNombreTipoDocumentoIdentificacion());
        
        return tipoDocumentoIdentificacionDTO;
    }
    
    //CONVIERTO DTO A ENTIDAD:
    private TipoUsuario tipoUsuarioDTOToEntity(TipoUsuarioDTO tipoUsuarioDTO) {
        if (tipoUsuarioDTO == null) {
            return null;
        }
        
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(tipoUsuarioDTO.getIdTipoUsuario());
        tipoUsuario.setNombreTipoUsuario(tipoUsuarioDTO.getNombreTipoUsuario());
        
        return tipoUsuario;
    }
    
    //CONVIERTO ENTIDAD A DTO:
    private TipoUsuarioDTO tipoUsuarioEntityToDTO(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null) {
            return null;
        }
        
        TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();
        tipoUsuarioDTO.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
        tipoUsuarioDTO.setNombreTipoUsuario(tipoUsuario.getNombreTipoUsuario());
        
        return tipoUsuarioDTO;
    }
}
