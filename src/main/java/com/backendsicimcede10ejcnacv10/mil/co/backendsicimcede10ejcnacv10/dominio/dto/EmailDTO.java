//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DTO.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LOS DTO.
//Anotacion de lombok que me crea automaticamente los get, set constructor.
public class EmailDTO {
    //ESTE DTO SOLO RECIBE LO ESTRICTAMENTE NECESARIO PARA IDENTIFICAR AL USUARIO Y EL MEDIO DE ENVÍO ELEGIDO
    //(MISMO PATRÓN DEL BACKEND SIGEPS). EmailServiceImpl RESUELVE INTERNAMENTE TODO LO DEMÁS, CONSULTANDO LA BASE DE DATOS:
    //- CORREO ELECTRÓNICO DE DESTINO (Usuario, SEGÚN medioEnvio).
    //- NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN (Usuario).
    //- CÓDIGO DE ACTIVACIÓN VIGENTE (RecuperacionContrasenaAccesoUsuario, EL MÁS RECIENTE PARA ESE USUARIO).
    //- ASUNTO, PLANTILLA HTML Y CONFIGURACIÓN SMTP (ParametrosSistema).
    //NINGUNO DE ESOS DATOS VIAJA POR EL NAVEGADOR (NI EN RESPUESTA NI EN PETICIÓN).
    private Long idUsuario;
    private String medioEnvio;//ESPERA "INSTITUCIONAL" O "PERSONAL".
}
