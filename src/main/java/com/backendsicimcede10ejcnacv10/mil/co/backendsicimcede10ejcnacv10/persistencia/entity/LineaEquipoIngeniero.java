//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.io.Serializable;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_LINEAS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class LineaEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_LINEA_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idLineaEquipoIngeniero;
    
    @Column(name = "NOMBRE_LINEA_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreLineaEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdLineaEquipoIngeniero() {
        return idLineaEquipoIngeniero;
    }
    public void setIdLineaEquipoIngeniero(Long idLineaEquipoIngeniero) {
        this.idLineaEquipoIngeniero = idLineaEquipoIngeniero;
    }
    public String getNombreLineaEquipoIngeniero() {
        return nombreLineaEquipoIngeniero;
    }
    public void setNombreLineaEquipoIngeniero(String nombreLineaEquipoIngeniero) {
        this.nombreLineaEquipoIngeniero = nombreLineaEquipoIngeniero;
    }*/
}
