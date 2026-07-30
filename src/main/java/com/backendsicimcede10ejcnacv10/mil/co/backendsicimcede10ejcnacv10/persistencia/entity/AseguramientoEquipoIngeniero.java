//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_ASEGURAMIENTOS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class AseguramientoEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_ASEGURAMIENTO_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idAseguramientoEquipoIngeniero;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_INICIACION_ASEGURAMIENTO_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionAseguramientoEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_ASEGURAMIENTO_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionAseguramientoEquipoIngeniero;
    
    //@Column(name = "ID_ASEGURADORA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idAseguradora;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ASEGURADORA", columnDefinition = "NUMBER(20) NOT NULL")
    private Aseguradora aseguradora;
    
    @Column(name = "NUMERO_SEGURO_ASEGURAMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(250) NOT NULL")
    private String numeroSeguroAseguramientoEquipoIngeniero;
    
    @Column(name = "VALOR_SOLICITADO_ASEGURAMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoAseguramientoEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdAseguramientoEquipoIngeniero() {
        return idAseguramientoEquipoIngeniero;
    }
    public void setIdAseguramientoEquipoIngeniero(Long idAseguramientoEquipoIngeniero) {
        this.idAseguramientoEquipoIngeniero = idAseguramientoEquipoIngeniero;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public Date getFechaHMSIniciacionAseguramientoEquipoIngeniero() {
        return fechaHMSIniciacionAseguramientoEquipoIngeniero;
    }
    public void setFechaHMSIniciacionAseguramientoEquipoIngeniero(Date fechaHMSIniciacionAseguramientoEquipoIngeniero) {
        this.fechaHMSIniciacionAseguramientoEquipoIngeniero = fechaHMSIniciacionAseguramientoEquipoIngeniero;
    }
    public Date getFechaHMSFinalizacionAseguramientoEquipoIngeniero() {
        return fechaHMSFinalizacionAseguramientoEquipoIngeniero;
    }
    public void setFechaHMSFinalizacionAseguramientoEquipoIngeniero(Date fechaHMSFinalizacionAseguramientoEquipoIngeniero) {
        this.fechaHMSFinalizacionAseguramientoEquipoIngeniero = fechaHMSFinalizacionAseguramientoEquipoIngeniero;
    }
    public Aseguradora getAseguradora() {
        return aseguradora;
    }
    public void setAseguradora(Aseguradora aseguradora) {
        this.aseguradora = aseguradora;
    }
    public String getNumeroSeguroAseguramientoEquipoIngeniero() {
        return numeroSeguroAseguramientoEquipoIngeniero;
    }
    public void setNumeroSeguroAseguramientoEquipoIngeniero(String numeroSeguroAseguramientoEquipoIngeniero) {
        this.numeroSeguroAseguramientoEquipoIngeniero = numeroSeguroAseguramientoEquipoIngeniero;
    }
    public String getValorSolicitadoAseguramientoEquipoIngeniero() {
        return valorSolicitadoAseguramientoEquipoIngeniero;
    }
    public void setValorSolicitadoAseguramientoEquipoIngeniero(String valorSolicitadoAseguramientoEquipoIngeniero) {
        this.valorSolicitadoAseguramientoEquipoIngeniero = valorSolicitadoAseguramientoEquipoIngeniero;
    }*/
}
