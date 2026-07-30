//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.security;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método autenticación de credenciales.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA AUTENTICACIÓN DE CREDENCIALES.
public class AuthCredentials {
    
    //DECLARACIÓN DE LAS VARIABLES DE LOS CAMPOS DE LA TABLA DE USUARIOS PARA LAS CREDENCIALES DE AUTENTICACIÓN:
    private String nicknameUsuario;
    private String passwordUsuario;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE USUARIOS PARA LAS CREDENCIALES DE AUTENTICACIÓN:
    public String getNicknameUsuario() {
        return nicknameUsuario;
    }
    public void setNicknameUsuario(String nicknameUsuario) {
        this.nicknameUsuario = nicknameUsuario;
    }
    public String getPasswordUsuario() {
        return passwordUsuario;
    }
    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }*/
}