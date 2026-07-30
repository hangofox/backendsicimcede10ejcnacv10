//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de los métodos de respuesta en la interface para el envio del correo electrónico.
*/
//DECLARACIÓN DE LA INTERFACE DE LA CLASE PRINCIPAL DEL SERVICIO:
public interface TokenCodigoActivacionRecuperacionContrasenaService {
    //DECLARACIÓN DE LOS METODOS DE RESPUESTA EN LA INTERFACE PARA GENERACIÓN DEL TOKEN DE CÓDIGO DE ACTIVACIÓN PARA RECUPERACIÓN DE CONTRASEÑA DE ACCESO:
    RespuestaDTO consultarTokenCodigoActivacionRecuperacionContrasenaporTiempoMinutosValidez(Long tiempoMinutosValidez);
}
