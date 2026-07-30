//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TokenCodigoActivacionRecuperacionContrasenaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TokenCodigoActivacionRecuperacionContrasenaService;
//import java.util.Properties;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class TokenCodigoActivacionRecuperacionContrasenaServiceImpl implements TokenCodigoActivacionRecuperacionContrasenaService {
    
    //CLAVE SECRETA PARA FIRMAR EL TOKEN (DEBE SER SEGURA Y ALMACENADA ADECUADAMENTE):
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    //GENERAR TOKEN DE CÓDIGO DE ACTIVACIÓN PARA RECUPERACIÓN DE CONTRASEÑA DE ACCESO:
    @Override//SOBREESCRIBIMOS EL METODO DE GENERAR TOKEN DE CÓDIGO DE ACTIVACIÓN PARA RECUPERACIÓN DE CONTRASEÑA DE ACCESO.
    public RespuestaDTO consultarTokenCodigoActivacionRecuperacionContrasenaporTiempoMinutosValidez(Long tiempoMinutosValidez) {
        TokenCodigoActivacionRecuperacionContrasenaDTO tokenCodigoActivacionRecuperacionContrasenaDTO = new TokenCodigoActivacionRecuperacionContrasenaDTO();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_TOKEN_CODIGO_ACTIVACION_NO_GENERADO, false);
        
        try {
            Date tiempoAhora = new Date();
            Date expiracion = new Date(tiempoAhora.getTime() + tiempoMinutosValidez * 60 * 1000);
            
            String tokenCodigoActivacionRecuperacionContrasena = Jwts.builder().setSubject("codigo-activacion").setIssuedAt(tiempoAhora).setExpiration(expiracion).signWith(key).compact();
            tokenCodigoActivacionRecuperacionContrasenaDTO.setTokenCodigoActivacionRecuperacionContrasena(tokenCodigoActivacionRecuperacionContrasena);
            tokenCodigoActivacionRecuperacionContrasenaDTO.setTiempoMinutosValidez(tiempoMinutosValidez);
            
            respuestaDTO.setTokenCodigoActivacionRecuperacionContrasenaDTO(tokenCodigoActivacionRecuperacionContrasenaDTO);
            respuestaDTO.setMensaje(MensajesConstantes.MSG_TOKEN_CODIGO_ACTIVACION_GENERADO_EXITO);
            respuestaDTO.setBanderaexito(true);
        } catch (Exception e) {
            respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_ERROR_GENERACION_TOKEN_CODIGO_ACTIVACION + " " + e.getMessage(), false);
        }
        
        return respuestaDTO;
    }
}
