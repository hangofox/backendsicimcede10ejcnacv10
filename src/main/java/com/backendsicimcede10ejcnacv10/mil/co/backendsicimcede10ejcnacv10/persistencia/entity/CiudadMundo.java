//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_CIUDADES_MUNDO")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class CiudadMundo {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_CIUDAD_MUNDO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idCiudadMundo;
    
    @Column(name = "NOMBRE_CIUDAD_MUNDO", columnDefinition="VARCHAR(250) NOT NULL")
    private String nombreCiudadMundo;
    
    @OneToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PAIS_MUNDO", columnDefinition = "NUMBER(20) NOT NULL")
    private PaisMundo paisMundo;
    
    @OneToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_DEPARTAMENTO_O_ESTADO_MUNDO", columnDefinition = "NUMBER(20) NOT NULL")
    private DepartamentooEstadoMundo departamentooEstadoMundo;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdCiudadMundo() {
        return idCiudadMundo;
    }
    public void setIdCiudadMundo(Long idCiudadMundo) {
        this.idCiudadMundo = idCiudadMundo;
    }
    public String getNombreCiudadMundo() {
        return nombreCiudadMundo;
    }
    public void setNombreCiudadMundo(String nombreCiudadMundo) {
        this.nombreCiudadMundo = nombreCiudadMundo;
    }
    public PaisMundo getPaisMundo() {
        return paisMundo;
    }
    public void setPaisMundo(PaisMundo paisMundo) {
        this.paisMundo = paisMundo;
    }
    public DepartamentooEstadoMundo getDepartamentooEstadoMundo() {
        return departamentooEstadoMundo;
    }
    public void setDepartamentooEstadoMundo(DepartamentooEstadoMundo departamentooEstadoMundo) {
        this.departamentooEstadoMundo = departamentooEstadoMundo;
    }*/
}
