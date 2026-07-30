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
* @Since 01/08/2023.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_REGIONES_DANE_COLOMBIA")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class RegionDaneColombia {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_REGION_DANE_COLOMBIA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idRegionDaneColombia;
    
    @Column(name = "NOMBRE_PAIS_DANE_COLOMBIA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombrePaisDaneColombia;
    
    @Column(name = "NOMBRE_DEPARTAMENTO_DANE_COLOMBIA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreDepartamentoDaneColombia;
    
    @Column(name = "NOMBRE_CIUDAD_MUNICIPIO_DANE_COLOMBIA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreCiudadMunicipioDaneColombia;
    
    @Column(name = "CODIGO_DANE_COLOMBIA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String codigoDaneColombia;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdRegionDaneColombia() {
        return idRegionDaneColombia;
    }
    public void setIdRegionDaneColombia(Long idRegionDaneColombia) {
        this.idRegionDaneColombia = idRegionDaneColombia;
    }
    public String getNombrePaisDaneColombia() {
        return nombrePaisDaneColombia;
    }
    public void setNombrePaisDaneColombia(String nombrePaisDaneColombia) {
        this.nombrePaisDaneColombia = nombrePaisDaneColombia;
    }
    public String getNombreDepartamentoDaneColombia() {
        return nombreDepartamentoDaneColombia;
    }
    public void setNombreDepartamentoDaneColombia(String nombreDepartamentoDaneColombia) {
        this.nombreDepartamentoDaneColombia = nombreDepartamentoDaneColombia;
    }
    public String getNombreCiudadMunicipioDaneColombia() {
        return nombreCiudadMunicipioDaneColombia;
    }
    public void setNombreCiudadMunicipioDaneColombia(String nombreCiudadMunicipioDaneColombia) {
        this.nombreCiudadMunicipioDaneColombia = nombreCiudadMunicipioDaneColombia;
    }
    public String getCodigoDaneColombia() {
        return codigoDaneColombia;
    }
    public void setCodigoDaneColombia(String codigoDaneColombia) {
        this.codigoDaneColombia = codigoDaneColombia;
    }*/
}
