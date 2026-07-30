//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_CONTROLES_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialControlAvancObrRedMitigGestRiesgDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_CONTROL_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialControlAvancObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUM_REG_HISTORIAL_CONTROL_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialControlAvancObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoObrRedMitigGestRiesgDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "NOMBRE_HISTORIAL_CONTROL_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String nombreHistorialControlAvancObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUMERO_PORCENTAJE_ACT_PROG_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "VARCHAR2(150) NULL")
    private String numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUMERO_PORCENTAJE_ACT_EJEC_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "VARCHAR2(150) NULL")
    private String numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUMERO_PORCENTAJE_ACT_FALT_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "VARCHAR2(150) NULL")
    private String numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast;
    
    @Column(name = "OBSERVACIONES_HISTORIAL_CONTROL_AVANC_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "CLOB NULL")
    //@Lob
    private String observacionesHistorialControlAvancObrRedMitigGestRiesgDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialControlAvancObrRedMitigGestRiesgDesast() {
        return idHistorialControlAvancObrRedMitigGestRiesgDesast;
    }
    public void setIdHistorialControlAvancObrRedMitigGestRiesgDesast(Long idHistorialControlAvancObrRedMitigGestRiesgDesast) {
        this.idHistorialControlAvancObrRedMitigGestRiesgDesast = idHistorialControlAvancObrRedMitigGestRiesgDesast;
    }
    public String getNumRegHistorialControlAvancObrRedMitigGestRiesgDesast() {
        return numRegHistorialControlAvancObrRedMitigGestRiesgDesast;
    }
    public void setNumRegHistorialControlAvancObrRedMitigGestRiesgDesast(String numRegHistorialControlAvancObrRedMitigGestRiesgDesast) {
        this.numRegHistorialControlAvancObrRedMitigGestRiesgDesast = numRegHistorialControlAvancObrRedMitigGestRiesgDesast;
    }
    public ApoyoObrRedMitigGestRiesgDesast getApoyoObrRedMitigGestRiesgDesast() {
        return apoyoObrRedMitigGestRiesgDesast;
    }
    public void setApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast) {
        this.apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesast;
    }
    public String getNombreHistorialControlAvancObrRedMitigGestRiesgDesast() {
        return nombreHistorialControlAvancObrRedMitigGestRiesgDesast;
    }
    public void setNombreHistorialControlAvancObrRedMitigGestRiesgDesast(String nombreHistorialControlAvancObrRedMitigGestRiesgDesast) {
        this.nombreHistorialControlAvancObrRedMitigGestRiesgDesast = nombreHistorialControlAvancObrRedMitigGestRiesgDesast;
    }
    public String getNumeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast() {
        return numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast;
    }
    public void setNumeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast(String numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast) {
        this.numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast = numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast;
    }
    public String getNumeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast() {
        return numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast;
    }
    public void setNumeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast(String numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast) {
        this.numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast = numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast;
    }
    public String getNumeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast() {
        return numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast;
    }
    public void setNumeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast(String numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast) {
        this.numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast = numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast;
    }
    public String getObservacionesHistorialControlAvancObrRedMitigGestRiesgDesast() {
        return observacionesHistorialControlAvancObrRedMitigGestRiesgDesast;
    }
    public void setObservacionesHistorialControlAvancObrRedMitigGestRiesgDesast(String observacionesHistorialControlAvancObrRedMitigGestRiesgDesast) {
        this.observacionesHistorialControlAvancObrRedMitigGestRiesgDesast = observacionesHistorialControlAvancObrRedMitigGestRiesgDesast;
    }*/
}
