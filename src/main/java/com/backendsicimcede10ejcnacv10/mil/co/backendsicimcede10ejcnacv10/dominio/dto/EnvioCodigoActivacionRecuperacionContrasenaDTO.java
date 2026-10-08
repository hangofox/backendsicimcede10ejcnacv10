//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;

/**
* Declaración del método DTO.
* Petición pública para enviar el código de activación de recuperación de contraseña de acceso.
* Solo viaja el id del usuario y el medio de envío: el código, los datos SMTP y la plantilla
* los resuelve el backend y nunca llegan al navegador.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DTO.
public class EnvioCodigoActivacionRecuperacionContrasenaDTO {
    private Long idUsuario;//ID DEL USUARIO QUE SOLICITA LA RECUPERACIÓN.
    private String medioEnvio;//"CORREO ELECTRONICO INSTITUCIONAL" O "CORREO ELECTRONICO PERSONAL".
}
