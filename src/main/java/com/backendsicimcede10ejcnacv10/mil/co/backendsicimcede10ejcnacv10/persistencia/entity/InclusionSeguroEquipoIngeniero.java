//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_INCLUSIONES_SEGUROS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class InclusionSeguroEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INCLUSION_SEGURO_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idInclusionSeguroEquipoIngeniero;
    
    //@Column(name = "ID_ASEGURAMIENTO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idAseguramientoEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ASEGURAMIENTO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_INICIACION_INCLUSION_SEGURO_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionInclusionSeguroEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_INCLUSION_SEGURO_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionInclusionSeguroEquipoIngeniero;
    
    @Column(name = "DESCRIPCION_INCLUSION_SEGURO_EQUIPO_INGENIERO", columnDefinition="CLOB NULL")
    private String descripcionInclusionSeguroEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdInclusionSeguroEquipoIngeniero() {
        return idInclusionSeguroEquipoIngeniero;
    }
    public void setIdInclusionSeguroEquipoIngeniero(Long idInclusionSeguroEquipoIngeniero) {
        this.idInclusionSeguroEquipoIngeniero = idInclusionSeguroEquipoIngeniero;
    }
    public AseguramientoEquipoIngeniero getAseguramientoEquipoIngeniero() {
        return aseguramientoEquipoIngeniero;
    }
    public void setAseguramientoEquipoIngeniero(AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero) {
        this.aseguramientoEquipoIngeniero = aseguramientoEquipoIngeniero;
    }
    public Date getFechaHMSIniciacionInclusionSeguroEquipoIngeniero() {
        return fechaHMSIniciacionInclusionSeguroEquipoIngeniero;
    }
    public void setFechaHMSIniciacionInclusionSeguroEquipoIngeniero(Date fechaHMSIniciacionInclusionSeguroEquipoIngeniero) {
        this.fechaHMSIniciacionInclusionSeguroEquipoIngeniero = fechaHMSIniciacionInclusionSeguroEquipoIngeniero;
    }
    public Date getFechaHMSFinalizacionInclusionSeguroEquipoIngeniero() {
        return fechaHMSFinalizacionInclusionSeguroEquipoIngeniero;
    }
    public void setFechaHMSFinalizacionInclusionSeguroEquipoIngeniero(Date fechaHMSFinalizacionInclusionSeguroEquipoIngeniero) {
        this.fechaHMSFinalizacionInclusionSeguroEquipoIngeniero = fechaHMSFinalizacionInclusionSeguroEquipoIngeniero;
    }
    public String getDescripcionInclusionSeguroEquipoIngeniero() {
        return descripcionInclusionSeguroEquipoIngeniero;
    }
    public void setDescripcionInclusionSeguroEquipoIngeniero(String descripcionInclusionSeguroEquipoIngeniero) {
        this.descripcionInclusionSeguroEquipoIngeniero = descripcionInclusionSeguroEquipoIngeniero;
    }*/
}
