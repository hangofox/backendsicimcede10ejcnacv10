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
@Table(name = "TABLA_GRADOS_SIATH")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class GradoSiath {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_GRADO_SIATH", columnDefinition="NUMBER(20) NOT NULL")
    private Long idGradoSiath;
    
    @Column(name = "NOMBRE_GRADO_SIATH", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreGradoSiath;
    
    @Column(name = "DESCRIPCION_GRADO_SIATH", columnDefinition="VARCHAR2(500) NOT NULL")
    private String descripcionGradoSiath;
    
    @Column(name = "ID_SIATH", columnDefinition="VARCHAR2(20) NULL")
    private Long idSiath;
    
    @Column(name = "FUERZA_SIATH", columnDefinition="NUMBER(20) NOT NULL")
    private String fuerzaSiath;
    
    @Column(name = "CATEGORIA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String categoria;
    
    @Column(name = "ID_CATEGORIA_SIATH", columnDefinition="NUMBER(20) NOT NULL")
    private Long idCategoriaSiath;
    
    @Column(name = "ORDEN", columnDefinition="NUMBER(20) NOT NULL")
    private Long orden;
    
    @Column(name = "PERIODICIDAD_CONCEPTOS", columnDefinition="NUMBER(20) NULL")
    private Long periodicidadConceptos;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdGradoSiath() {
        return idGradoSiath;
    }
    public void setIdGradoSiath(Long idGradoSiath) {
        this.idGradoSiath = idGradoSiath;
    }
    public String getNombreGradoSiath() {
        return nombreGradoSiath;
    }
    public void setNombreGradoSiath(String nombreGradoSiath) {
        this.nombreGradoSiath = nombreGradoSiath;
    }
    public String getDescripcionGradoSiath() {
        return descripcionGradoSiath;
    }
    public void setDescripcionGradoSiath(String descripcionGradoSiath) {
        this.descripcionGradoSiath = descripcionGradoSiath;
    }
    public Long getIdSiath() {
        return idSiath;
    }
    public void setIdSiath(Long idSiath) {
        this.idSiath = idSiath;
    }
    public String getFuerzaSiath() {
        return fuerzaSiath;
    }
    public void setFuerzaSiath(String fuerzaSiath) {
        this.fuerzaSiath = fuerzaSiath;
    }
    public Long getCategoriaSiath() {
        return categoriaSiath;
    }
    public void setCategoria(String categoria) {
        this.idCategoria = categoria;
    }
    public Long getIdCategoriaSiath() {
        return idCategoriaSiath;
    }
    public void setIdCategoriaSiath(Long idCategoriaSiath) {
        this.idCategoriaSiath = idCategoriaSiath;
    }
    public Long getOrden() {
        return orden;
    }
    public void setOrden(Long orden) {
        this.orden = orden;
    }
    public Long getPeriodicidadConceptos() {
        return periodicidadConceptos;
    }
    public void setPeriodicidadConceptos(Long periodicidadConceptos) {
        this.periodicidadConceptos = periodicidadConceptos;
    }*/
}
