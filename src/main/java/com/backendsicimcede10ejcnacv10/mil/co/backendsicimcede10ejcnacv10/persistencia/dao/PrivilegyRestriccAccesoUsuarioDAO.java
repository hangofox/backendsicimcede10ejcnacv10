//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PrivilegyRestriccAccesoUsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Funcionalidad;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PrivilegyRestriccAccesoUsuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Rol;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Usuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.FuncionalidadRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.RolRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class PrivilegyRestriccAccesoUsuarioDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UsuarioRepository usuarioRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private FuncionalidadRepository funcionalidadRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private RolRepository rolRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL DAO.
    private UsuarioDAO usuarioDAO;
    
    @Autowired//INYECTAMOS EL DAO.
    private FuncionalidadDAO funcionalidadDAO;
    
    @Autowired//INYECTAMOS EL DAO.
    private RolDAO rolDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param privilegyRestriccAccesoUsuarioDTO
    * Recibe un DTO para crear un objeto privilegyRestriccAccesoUsuario.
    * @return privilegyRestriccAccesoUsuario
    */
    public PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuario(PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO){
        PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuario = new PrivilegyRestriccAccesoUsuario();
        privilegyRestriccAccesoUsuario.setIdPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuarioDTO.getIdPrivilegioyRestriccionAccesoUsuario());
        privilegyRestriccAccesoUsuario.setNumeroRegistroPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuarioDTO.getNumeroRegistroPrivilegioyRestriccionAccesoUsuario());
        privilegyRestriccAccesoUsuario.setUrlAccesoUsuario(privilegyRestriccAccesoUsuarioDTO.getUrlAccesoUsuario());
        privilegyRestriccAccesoUsuario.setSioNoPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuarioDTO.getSioNoPrivilegioyRestriccionAccesoUsuario());
        privilegyRestriccAccesoUsuario.setFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuarioDTO.getFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (privilegyRestriccAccesoUsuarioDTO.getUnidadMilitarDTO() != null && privilegyRestriccAccesoUsuarioDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(privilegyRestriccAccesoUsuarioDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(privilegyRestriccAccesoUsuario::setUnidadMilitar);
        }
        
        //MAPEAR USUARIO RELACIONADO.
        if (privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO() != null && privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario() != null) {
           Optional<Usuario> usuarioFk = usuarioRepository.findByIdUsuario(privilegyRestriccAccesoUsuarioDTO.getUsuarioDTO().getIdUsuario());
           usuarioFk.ifPresent(privilegyRestriccAccesoUsuario::setUsuario);
        }
        
        //MAPEAR FUNCIONALIDAD RELACIONADA.
        if (privilegyRestriccAccesoUsuarioDTO.getFuncionalidadDTO() != null && privilegyRestriccAccesoUsuarioDTO.getFuncionalidadDTO().getIdFuncionalidad() != null) {
           Optional<Funcionalidad> funcionalidadFk = funcionalidadRepository.findByIdFuncionalidad(privilegyRestriccAccesoUsuarioDTO.getFuncionalidadDTO().getIdFuncionalidad());
           funcionalidadFk.ifPresent(privilegyRestriccAccesoUsuario::setFuncionalidad);
        }
        
        //MAPEAR ROL RELACIONADO.
        if (privilegyRestriccAccesoUsuarioDTO.getRolDTO() != null && privilegyRestriccAccesoUsuarioDTO.getRolDTO().getIdRol() != null) {
           Optional<Rol> rolFk = rolRepository.findByIdRol(privilegyRestriccAccesoUsuarioDTO.getRolDTO().getIdRol());
           rolFk.ifPresent(privilegyRestriccAccesoUsuario::setRol);
        }
        
        return privilegyRestriccAccesoUsuario;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param privilegyRestriccAccesoUsuario
    * Recibe un objeto privilegyRestriccAccesoUsuario para crear un DTO.
    * @return privilegyRestriccAccesoUsuarioDTO
    */
    public PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO(PrivilegyRestriccAccesoUsuario privilegyRestriccAccesoUsuario){
        PrivilegyRestriccAccesoUsuarioDTO privilegyRestriccAccesoUsuarioDTO = new PrivilegyRestriccAccesoUsuarioDTO();
        privilegyRestriccAccesoUsuarioDTO.setIdPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuario.getIdPrivilegioyRestriccionAccesoUsuario());
        privilegyRestriccAccesoUsuarioDTO.setNumeroRegistroPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuario.getNumeroRegistroPrivilegioyRestriccionAccesoUsuario());
        privilegyRestriccAccesoUsuarioDTO.setUrlAccesoUsuario(privilegyRestriccAccesoUsuario.getUrlAccesoUsuario());
        privilegyRestriccAccesoUsuarioDTO.setSioNoPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuario.getSioNoPrivilegioyRestriccionAccesoUsuario());
        privilegyRestriccAccesoUsuarioDTO.setFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario(privilegyRestriccAccesoUsuario.getFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (privilegyRestriccAccesoUsuario.getUnidadMilitar() != null && privilegyRestriccAccesoUsuario.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(privilegyRestriccAccesoUsuario.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> privilegyRestriccAccesoUsuarioDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        //MAPEAR USUARIO RELACIONADO.
        if (privilegyRestriccAccesoUsuario.getUsuario() != null && privilegyRestriccAccesoUsuario.getUsuario().getIdUsuario() != null) {
           Optional<Usuario> usuarioFk = usuarioRepository.findByIdUsuario(privilegyRestriccAccesoUsuario.getUsuario().getIdUsuario());
           usuarioFk.ifPresent(usuario -> privilegyRestriccAccesoUsuarioDTO.setUsuarioDTO(usuarioDAO.usuarioDTO(usuario)));
        }
        
        //MAPEAR FUNCIONALIDAD RELACIONADA.
        if (privilegyRestriccAccesoUsuario.getFuncionalidad() != null && privilegyRestriccAccesoUsuario.getFuncionalidad().getIdFuncionalidad() != null) {
           Optional<Funcionalidad> funcionalidadFk = funcionalidadRepository.findByIdFuncionalidad(privilegyRestriccAccesoUsuario.getFuncionalidad().getIdFuncionalidad());
           funcionalidadFk.ifPresent(funcionalidad -> privilegyRestriccAccesoUsuarioDTO.setFuncionalidadDTO(funcionalidadDAO.funcionalidadDTO(funcionalidad)));
        }
        
        //MAPEAR ROL RELACIONADO.
        if (privilegyRestriccAccesoUsuario.getRol() != null && privilegyRestriccAccesoUsuario.getRol().getIdRol() != null) {
           Optional<Rol> rolFk = rolRepository.findByIdRol(privilegyRestriccAccesoUsuario.getRol().getIdRol());
           rolFk.ifPresent(rol -> privilegyRestriccAccesoUsuarioDTO.setRolDTO(rolDAO.rolDTO(rol)));
        }
        
        return privilegyRestriccAccesoUsuarioDTO;
    }
}
