//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_CUENTAS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class CuentaEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_CUENTA_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idCuentaEquipoIngeniero;
    
    @Column(name = "NOMBRE_CUENTA_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreCuentaEquipoIngeniero;
    
    @Column(name = "NUMERO_CUENTA_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numeroCuentaEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdCuentaEquipoIngeniero() {
        return idCuentaEquipoIngeniero;
    }
    public void setIdCuentaEquipoIngeniero(Long idCuentaEquipoIngeniero) {
        this.idCuentaEquipoIngeniero = idCuentaEquipoIngeniero;
    }
    public String getNombreCuentaEquipoIngeniero() {
        return nombreCuentaEquipoIngeniero;
    }
    public void setNombreCuentaEquipoIngeniero(String nombreCuentaEquipoIngeniero) {
        this.nombreCuentaEquipoIngeniero = nombreCuentaEquipoIngeniero;
    }
    public String getNumeroCuentaEquipoIngeniero() {
        return numeroCuentaEquipoIngeniero;
    }
    public void setNumeroCuentaEquipoIngeniero(String numeroCuentaEquipoIngeniero) {
        this.numeroCuentaEquipoIngeniero = numeroCuentaEquipoIngeniero;
    }*/
}
