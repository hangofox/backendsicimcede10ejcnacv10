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
@Table(name = "TABLA_INCLUSIONES_SEGUROS_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class InclusionSeguroInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INCLUSION_SEGURO_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idInclusionSeguroInfraestructura;
    
    //@Column(name = "ID_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionSeguroInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura;
    
    @Column(name = "FECHA_H_M_S_INICIACION_INCLUSION_SEGURO_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionInclusionSeguroInfraestructura;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_INCLUSION_SEGURO_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionInclusionSeguroInfraestructura;
    
    @Column(name = "DESCRIPCION_INCLUSION_SEGURO_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    private String descripcionInclusionSeguroInfraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdInclusionSeguroInfraestructura() {
        return idInclusionSeguroInfraestructura;
    }
    public void setIdInclusionSeguroInfraestructura(Long idInclusionSeguroInfraestructura) {
        this.idInclusionSeguroInfraestructura = idInclusionSeguroInfraestructura;
    }
    public ProyeccionSeguroInfraestructura getProyeccionSeguroInfraestructura() {
        return proyeccionSeguroInfraestructura;
    }
    public void setProyeccionSeguroInfraestructura(ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura) {
        this.proyeccionSeguroInfraestructura = proyeccionSeguroInfraestructura;
    }
    public Date getFechaHMSIniciacionInclusionSeguroInfraestructura() {
        return fechaHMSIniciacionInclusionSeguroInfraestructura;
    }
    public void setFechaHMSIniciacionInclusionSeguroInfraestructura(Date fechaHMSIniciacionInclusionSeguroInfraestructura) {
        this.fechaHMSIniciacionInclusionSeguroInfraestructura = fechaHMSIniciacionInclusionSeguroInfraestructura;
    }
    public Date getFechaHMSFinalizacionInclusionSeguroInfraestructura() {
        return fechaHMSFinalizacionInclusionSeguroInfraestructura;
    }
    public void setFechaHMSFinalizacionInclusionSeguroInfraestructura(Date fechaHMSFinalizacionInclusionSeguroInfraestructura) {
        this.fechaHMSFinalizacionInclusionSeguroInfraestructura = fechaHMSFinalizacionInclusionSeguroInfraestructura;
    }
    public String getDescripcionInclusionSeguroInfraestructura() {
        return descripcionInclusionSeguroInfraestructura;
    }
    public void setDescripcionInclusionSeguroInfraestructura(String descripcionInclusionSeguroInfraestructura) {
        this.descripcionInclusionSeguroInfraestructura = descripcionInclusionSeguroInfraestructura;
    }*/
}
