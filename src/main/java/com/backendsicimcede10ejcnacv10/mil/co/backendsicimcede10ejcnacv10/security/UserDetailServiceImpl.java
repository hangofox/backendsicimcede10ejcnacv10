//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.security;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Usuario;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan los repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UsuarioRepository usuarioRepository;
    
    //CARGAR USUARIO POR NICKNAME:
    @Override//SOBREESCRIBIMOS EL METODO DE CARGAR USUARIO POR NICKNAME.
    public UserDetails loadUserByUsername(String nicknameUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNicknameUsuario(nicknameUsuario);
        
        if (usuario == null) {
           throw new UsernameNotFoundException("El usuario con nickname: " + nicknameUsuario + " no existe.");
        }
        
        return new UserDetailsImpl(usuario);
    }
}
