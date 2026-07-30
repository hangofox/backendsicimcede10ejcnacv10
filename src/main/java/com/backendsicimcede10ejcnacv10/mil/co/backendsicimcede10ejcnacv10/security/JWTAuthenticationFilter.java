//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.security;

//IMPORTACIÓN DE LIBRERIAS:
import com.fasterxml.jackson.databind.ObjectMapper;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
//import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
//import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* 
* Este filtro personalizado extiende de `UsernamePasswordAuthenticationFilter` y se encarga de:
* 1. Recibir las credenciales de usuario desde una petición de login (JSON).
* 2. Validar dichas credenciales con el `AuthenticationManager`.
* 3. Si las credenciales son válidas, generar y devolver un JWT como respuesta al cliente.
*/
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    //REALIZAR AUTENTICACIÓN DEL USUARIO.
    //NOTA: Se leen las credenciales (usuario y contraseña) del cuerpo de la petición.
    @Override//SOBREESCRIBIMOS EL METODO DE REALZIAR AUTENTICACIÓN DEL USUARIO.
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials = new AuthCredentials();
        
        try {
          //CONVIERTE EL CUERPO JSON DE LA PETICIÓN EN UN OBJETO AuthCredentials:
          authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }
        catch (IOException e) {
          //EN CASO DE ERROR, LAS CREDENCIALES PERMANECERÁN VACÍAS (AUNQUE PODRÍA MANEJARSE MEJOR).
        }
        
        //CREA EL TOKEN DE AUTENTICACIÓN CON EL USUARIO Y CONTRASEÑA:
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getNicknameUsuario(),
                authCredentials.getPasswordUsuario(),
                Collections.emptyList()
        );
        
        //RETORNA EL RESULTADO DE AUTENTICAR LAS CREDENCIALES CON EL AuthenticationManager:
        return getAuthenticationManager().authenticate(usernamePAT);
    }
    
    /*//ENVIAR EL TOKEN DE AUTORIZACIÓN GENERADO CUANDO SE HA AUTENTICADO.
    @Override//SOBREESCRIBIMOS EL METODO DE ENVIAR EL TOKEN DE AUTORIZACIÓN GENERADO CUANDO SE HA AUTENTICADO.
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //SE OBTIENE EL USUARIO AUTENTICADO DESDE EL RESULTADO:
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        //SE GENERA EL TOKEN JWT CON LA INFORMACIÓN DEL USUARIO:
        String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());
        
        //Aquí imprimimos el token recién generado al hacer login:
        //System.out.println("TOKEN GENERADO EN LOGIN: " + token);
        
        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();
        
        super.successfulAuthentication(request, response, chain, authResult);
    }*/
    
    //ENVIAR EL TOKEN DE AUTORIZACIÓN GENERADO CUANDO SE HA AUTENTICADO.
    @Override//SOBREESCRIBIMOS EL METODO DE ENVIAR EL TOKEN DE AUTORIZACIÓN GENERADO CUANDO SE HA AUTENTICADO.
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //SE OBTIENE EL USUARIO AUTENTICADO DESDE EL RESULTADO:
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        
        try {
            //SE GENERA EL TOKEN JWT CON LA INFORMACIÓN DEL USUARIO:
            String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());
            //AQUÍ IMPRIMOS EL TOKEN RECIÉN AL HACER LOGIN:
            //CONFIGURACIÓN DE LA RESPUESTA PARA DEVOLVER JSON:
            //System.out.println("TOKEN DE AUTORIZACIÓN GENERADO EN LOGIN: " + token);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{");
            response.getWriter().write("\"tokenAutorizacion\":\"" + token + "\"" + ",");
            response.getWriter().write(" \"mensaje\":\"" + MensajesConstantes.MSG_TOKEN_AUTORIZACION_USUARIO_EXITO + "\"");
            response.getWriter().write("}");
            response.getWriter().flush();
        } catch (Exception e) {
            //EN CASO DE ERROR AL GENERAR EL TOKEN, SE RESPONDE CON UN MENSAJE DE ERROR EN JSON:
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{");
            response.getWriter().write("\"tokenAutorizacion\":\"" + null + ",");
            response.getWriter().write("\"mensaje\":\"" + MensajesConstantes.MSG_ERROR_GENERACION_TOKEN_AUTORIZACION_USUARIO + "\"");
            response.getWriter().write("}");
        }
    }
}
