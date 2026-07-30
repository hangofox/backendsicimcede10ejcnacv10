//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.security;

//IMPORTACIÓN DE LIBRERIAS:
import org.springframework.context.annotation.Configuration;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Clase de configuración principal para establecer las reglas de seguridad
* en la aplicación Spring Boot utilizando Spring Security.
*
* Esta clase:
* - Define los endpoints públicos y protegidos.
* - Habilita los filtros personalizados para autenticación y autorización con JWT.
* - Establece una política de sesión sin estado (stateless).
* - Define el manejador de autenticación y el codificador de contraseñas.
*/
@Configuration//DECLARACIÓN DE COMPONENT PARA INYECTAR LA CONFIGURACIÓN DE SEGURIDAD.
@AllArgsConstructor//GENERA AUTOMÁTICAMENTE UN CONSTRUCTOR CON LOS ARGUMENTOS NECESARIOS.
public class WebSecurityConfig {
    
    //SERVICIO PERSONALIZADO PARA OBTENER LOS DETALLES DEL USUARIO DESDE LA BASE DE DATOS:
    private final UserDetailsService userDetailsService;
    
    //FILTRO PERSONALIZADO PARA VERIFICAR LA VALIDEZ DEL TOKEN JWT EN CADA SOLICITUD.
    private final JWTAuthorizationFilter jwtAuthorizationFilter;
    
    //PERMITE LA CONFIGURACIÓN DE SEGURIDAD HTTP.
    //NOTA: Se inyecta el manejador de autenticación.
    @Bean//DEVUELVE UN OBJETO QUE DEBE SER REGISTRADO EN EL CONTENEDOR DE SPRING.
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        
        //SE CREA EL FILTRO DE AUTENTICACIÓN Y SE CONFIGURA PARA INTERCEPTAR EL ENDPOINT "/login":
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        
        //ESTE BLOQUE CONSTRUYE Y DEVUELVE LA CADENA DE FILTROS DE SEGURIDAD (SecurityFilterChain) QUE DEFINE:
        //-Qué endpoints son públicos y cuáles requieren autenticación.
        //-Que no se usará protección CSRF (porque se usa JWT).
        //-Que se trabajará sin sesiones (stateless).
        //-Que se usarán filtros personalizados para autenticación y autorización con JWT.
        return http
                .csrf().disable()//Se desactiva la protección CSRF porque se trabaja con JWT (no con sesiones).
                .authorizeRequests()//Se empieza la configuración de las rutas permitidas.
                //ENDPOINTS PÚBLICOS AUTORIZADOS SIN AUTENTICACIÓN:
                .antMatchers("/login").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/usuario/getUsuarioRecuperacionContrasenaAccesobyNumeroDocumentoIdentificacion/**").permitAll()
                .antMatchers("/usuario/updateRecoveryPasswordAccessUserbyCodigoActivacionAndIdUsuarioAndPasswordUsuario/**").permitAll()
                .antMatchers("/parametrosSistema/getParametrosSistemaCorreoElectronicoRecuperacionContrasenaAccesoUsuariobyId/**").permitAll()
                .antMatchers("/email/sendEmail**").permitAll()
                .antMatchers("/recuperacionContrasenaAccesoUsuario/createRecuperacionContrasenaAccesoUsuario").permitAll()
                .antMatchers("/recuperacionContrasenaAccesoUsuario/updateRecuperacionContrasenaAccesoUsuario").permitAll()
                .antMatchers("/recuperacionContrasenaAccesoUsuario/getRecuperacionContrasenaAccesoUsuariobyCodigoActivacion/**").permitAll()
                .antMatchers("/recuperacionContrasenaAccesoUsuario/updateEstadosUsosCodigosActivacionesContrasenasAccesosUsuariosRecuperacionesContrasenasAccesosUsuarios/**").permitAll()
                .antMatchers("/recuperacionContrasenaAccesoUsuario/toEmptyRecuperacionesContrasenasAccesosUsuariosbyIdUsuario/**").permitAll()
                
                //CUALQUIER OTRA PETICIÓN REQUIERE AUTENTICACIÓN:
                .anyRequest()//Cualquier otra solicitud...
                .authenticated()//Requiere estar autenticado.
                .and()
                .httpBasic()//Autenticación básica para pruebas o herramientas externas (como Postman).
                .and()
                .sessionManagement()//Configura la política de manejo de sesiones de Spring Security.
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//Define que no se guarda sesión en el servidor (stateless, ideal para JWT).
                .and()
                .addFilter(jwtAuthenticationFilter)//Agrega el filtro personalizado de autenticación JWT (login).
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)//Agrega el filtro de autorización JWT antes del filtro por defecto de Spring.
                .build();//Construye y retorna la cadena de filtros configurada.
    }
    
    /*@Bean//DEVUELVE UN OBJETO QUE DEBE SER REGISTRADO EN EL CONTENEDOR DE SPRING.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
    /**
    * ✅ Reemplazo de BCryptPasswordEncoder por un PasswordEncoder personalizado.
    * Este encoder no encripta nada. Compara directamente lo que llega (desde Postman)
    * contra la contraseña almacenada en la base de datos.
    */
    @Bean//DEVUELVE UN OBJETO QUE DEBE SER REGISTRADO EN EL CONTENEDOR DE SPRING.
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override//SOBRESCRIBIMOS EL METODO DE CODIFICACIÓN DEL PASSWORD.
            public String encode(CharSequence rawPassword) {
                //No se codifica, se retorna tal cual.
                return rawPassword.toString();
            }
            
            @Override//SOBRESCRIBIMOS EL METODO DE COMPARACIÓN DIRECTA SIN CODIFICACIÓN.
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                //Comparación directa sin codificación adicional.
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }
    
    //CONFIGURA Y EXPONE EL MANEJADOR DE AUTENTICACIÓN:
    //NOTA: Se enlaza el `UserDetailsService` y el `PasswordEncoder` definidos previamente.
    @Bean//DEVUELVE UN OBJETO QUE DEBE SER REGISTRADO EN EL CONTENEDOR DE SPRING.
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }
}

