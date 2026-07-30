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
@Table(name = "TABLA_INCLUSIONES_SEGUROS_LINEAS_BLANCAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class InclusionSeguroLineaBlanca {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INCLUSION_SEGURO_LINEA_BLANCA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idInclusionSeguroLineaBlanca;
    
    //@Column(name = "ID_ASEGURAMIENTO_LINEA_BLANCA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idAseguramientoLineaBlanca;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ASEGURAMIENTO_LINEA_BLANCA", columnDefinition = "NUMBER(20) NOT NULL")
    private AseguramientoLineaBlanca aseguramientoLineaBlanca;
    
    @Column(name = "FECHA_H_M_S_INICIACION_INCLUSION_SEGURO_LINEA_BLANCA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionInclusionSeguroLineaBlanca;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_INCLUSION_SEGURO_LINEA_BLANCA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionInclusionSeguroLineaBlanca;
    
    @Column(name = "DESCRIPCION_INCLUSION_SEGURO_LINEA_BLANCA", columnDefinition="CLOB NULL")
    private String descripcionInclusionSeguroLineaBlanca;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdInclusionSeguroLineaBlanca() {
        return idInclusionSeguroLineaBlanca;
    }
    public void setIdInclusionSeguroLineaBlanca(Long idInclusionSeguroLineaBlanca) {
        this.idInclusionSeguroLineaBlanca = idInclusionSeguroLineaBlanca;
    }
    public AseguramientoLineaBlanca getAseguramientoLineaBlanca() {
        return aseguramientoLineaBlanca;
    }
    public void setAseguramientoLineaBlanca(AseguramientoLineaBlanca aseguramientoLineaBlanca) {
        this.aseguramientoLineaBlanca = aseguramientoLineaBlanca;
    }
    public Date getFechaHMSIniciacionInclusionSeguroLineaBlanca() {
        return fechaHMSIniciacionInclusionSeguroLineaBlanca;
    }
    public void setFechaHMSIniciacionInclusionSeguroLineaBlanca(Date fechaHMSIniciacionInclusionSeguroLineaBlanca) {
        this.fechaHMSIniciacionInclusionSeguroLineaBlanca = fechaHMSIniciacionInclusionSeguroLineaBlanca;
    }
    public Date getFechaHMSFinalizacionInclusionSeguroLineaBlanca() {
        return fechaHMSFinalizacionInclusionSeguroLineaBlanca;
    }
    public void setFechaHMSFinalizacionInclusionSeguroLineaBlanca(Date fechaHMSFinalizacionInclusionSeguroLineaBlanca) {
        this.fechaHMSFinalizacionInclusionSeguroLineaBlanca = fechaHMSFinalizacionInclusionSeguroLineaBlanca;
    }
    public String getDescripcionInclusionSeguroLineaBlanca() {
        return descripcionInclusionSeguroLineaBlanca;
    }
    public void setDescripcionInclusionSeguroLineaBlanca(String descripcionInclusionSeguroLineaBlanca) {
        this.descripcionInclusionSeguroLineaBlanca = descripcionInclusionSeguroLineaBlanca;
    }*/
}
