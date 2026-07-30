//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_MUNICIONES_ESPECIALES")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class MunicionEspecial {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_MUNICION_ESPECIAL", columnDefinition="NUMBER(20) NOT NULL")
    private Long idMunicionEspecial;
    
    @Column(name = "NOMBRE_MUNICION_ESPECIAL", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreMunicionEspecial;
    
    @Column(name = "CANTIDAD_MUNICION_ESPECIAL", columnDefinition="NUMBER(20) NOT NULL")
    private String cantidadMunicionEspecial;
    
    @Column(name = "LOTE_MUNICION_ESPECIAL", columnDefinition="VARCHAR2(100) NOT NULL")
    private String loteMunicionEspecial;
    
    @Column(name = "VALOR_ADQUISICION_MUNICION_ESPECIAL", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorAdquisicionMunicionEspecial;
    
    @Column(name = "VALOR_CONTABLE_MUNICION_ESPECIAL", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorContableMunicionEspecial;
    
    @Column(name = "FECHA_H_M_S_ALTA_MUNICION_ESPECIAL", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSAltaMunicionEspecial;
    
    //@Column(name = "ID_PELOTON_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idPelotonUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PELOTON_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private PelotonUnidadMilitar pelotonUnidadMilitar;
    
    //@Column(name = "ID_TIPO_DESPEJE_MILITAR_ARTEFACTO_EXPLOSIVO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDespejeMilitarArtefactoExplosivo;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DESPEJE_MILITAR_ARTEFACTO_EXPLOSIVO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo;
    
    @Column(name = "CENTRO_COSTO_PELOTON_UNIDAD_MILITAR", columnDefinition="VARCHAR2(150) NOT NULL")
    private String centroCostoPelotonUnidadMilitar;
    
    @Column(name = "FECHA_H_M_S_INGRESO_MUNICION_ESPECIAL", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoMunicionEspecial;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_MUNICION_ESPECIAL", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionMunicionEspecial;
    
    @Column(name = "ESTADO_MUNICION_ESPECIAL", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String estadoMunicionEspecial;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdMunicionEspecial() {
        return idMunicionEspecial;
    }
    public void setIdMunicionEspecial(Long idMunicionEspecial) {
        this.idMunicionEspecial = idMunicionEspecial;
    }
    public String getNombreMunicionEspecial() {
        return nombreMunicionEspecial;
    }
    public void setNombreMunicionEspecial(String nombreMunicionEspecial) {
        this.nombreMunicionEspecial = nombreMunicionEspecial;
    }
    public String getCantidadMunicionEspecial() {
        return cantidadMunicionEspecial;
    }
    public void setCantidadMunicionEspecial(String cantidadMunicionEspecial) {
        this.cantidadMunicionEspecial = cantidadMunicionEspecial;
    }
    public String getLoteMunicionEspecial() {
        return loteMunicionEspecial;
    }
    public void setLoteMunicionEspecial(String loteMunicionEspecial) {
        this.loteMunicionEspecial = loteMunicionEspecial;
    }
    public String getValorAdquisicionMunicionEspecial() {
        return valorAdquisicionMunicionEspecial;
    }
    public void setValorAdquisicionMunicionEspecial(String valorAdquisicionMunicionEspecial) {
        this.valorAdquisicionMunicionEspecial = valorAdquisicionMunicionEspecial;
    }
    public String getValorContableMunicionEspecial() {
        return valorContableMunicionEspecial;
    }
    public void setValorContableMunicionEspecial(String valorContableMunicionEspecial) {
        this.valorContableMunicionEspecial = valorContableMunicionEspecial;
    }
    public Date getFechaHMSAltaMunicionEspecial() {
        return fechaHMSAltaMunicionEspecial;
    }
    public void setFechaHMSAltaMunicionEspecial(Date fechaHMSAltaMunicionEspecial) {
        this.fechaHMSAltaMunicionEspecial = fechaHMSAltaMunicionEspecial;
    }
    public PelotonUnidadMilitar getPelotonUnidadMilitar() {
        return pelotonUnidadMilitar;
    }
    public void setPelotonUnidadMilitar(PelotonUnidadMilitar pelotonUnidadMilitar) {
        this.pelotonUnidadMilitar = pelotonUnidadMilitar;
    }
    public TipoDespejeMilitarArtefactoExplosivo getTipoDespejeMilitarArtefactoExplosivo() {
        return tipoDespejeMilitarArtefactoExplosivo;
    }
    public void setTipoDespejeMilitarArtefactoExplosivo(TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo) {
        this.tipoDespejeMilitarArtefactoExplosivo = tipoDespejeMilitarArtefactoExplosivo;
    }
    public String getCentroCostoPelotonUnidadMilitar() {
        return centroCostoPelotonUnidadMilitar;
    }
    public void setCentroCostoPelotonUnidadMilitar(String centroCostoPelotonUnidadMilitar) {
        this.centroCostoPelotonUnidadMilitar = centroCostoPelotonUnidadMilitar;
    }
    public Date getFechaHMSIngresoMunicionEspecial() {
        return fechaHMSIngresoMunicionEspecial;
    }
    public void setFechaHMSIngresoMunicionEspecial(Date fechaHMSIngresoMunicionEspecial) {
        this.fechaHMSIngresoMunicionEspecial = fechaHMSIngresoMunicionEspecial;
    }
    public Date getFechaHMSModificacionMunicionEspecial() {
        return fechaHMSModificacionMunicionEspecial;
    }
    public void setFechaHMSModificacionMunicionEspecial(Date fechaHMSModificacionMunicionEspecial) {
        this.fechaHMSModificacionMunicionEspecial = fechaHMSModificacionMunicionEspecial;
    }
    public String getEstadoMunicionEspecial() {
        return estadoMunicionEspecial;
    }
    public void setEstadoMunicionEspecial(String estadoMunicionEspecial) {
        this.estadoMunicionEspecial = estadoMunicionEspecial;
    }*/
}
