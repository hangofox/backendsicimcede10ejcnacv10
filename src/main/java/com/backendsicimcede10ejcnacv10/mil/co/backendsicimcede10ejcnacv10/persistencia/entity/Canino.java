//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_CANINOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class Canino {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_CANINO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idCanino;
    
    @Column(name = "DENOMINACION_CANINO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String denominacionCanino;
    
    @Column(name = "NUMERO_CHIP_CANINO", columnDefinition="VARCHAR2(100) NOT NULL")
    private String numeroChipCanino;
    
    @Column(name = "NUMERO_INVENTARIO_CANINO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroInventarioCanino;
    
    @Column(name = "NUMERO_ACTIVO_FIJO_CANINO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroActivoFijoCanino;
    
    @Column(name = "NOMBRE_CANINO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreCanino;
    
    @Column(name = "COLOR_CANINO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String colorCanino;
    
    @Column(name = "NOMBRE_RAZA_CANINO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreRazaCanino;
    
    @Column(name = "VALOR_ADQUISICION_CANINO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorAdquisicionCanino;
    
    @Column(name = "VALOR_CONTABLE_CANINO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorContableCanino;
    
    @Column(name = "VALOR_COSTO_UNITARIO_CANINO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorCostoUnitarioCanino;
    
    //@Column(name = "ID_COMPANIA_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idCompaniaUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_COMPANIA_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private CompaniaUnidadMilitar companiaUnidadMilitar;
    
    //@Column(name = "ID_TIPO_DESPEJE_MILITAR_ARTEFACTO_EXPLOSIVO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDespejeMilitarArtefactoExplosivo;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DESPEJE_MILITAR_ARTEFACTO_EXPLOSIVO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo;
    
    @Column(name = "CENTRO_COSTO_COMPANIA_UNIDAD_MILITAR", columnDefinition="VARCHAR2(150) NOT NULL")
    private String centroCostoCompaniaUnidadMilitar;
    
    @Column(name = "FECHA_H_M_S_ALTA_CANINO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSAltaCanino;
    
    @Column(name = "TIEMPO_ANUAL_VIDA_UTIL_CANINO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String tiempoAnualVidaUtilCanino;
    
    @Column(name = "DESCRIPCION_CANINO", columnDefinition = "CLOB NULL")
    private String descripcionCanino;
    
    @Column(name = "FECHA_H_M_S_INGRESO_CANINO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoCanino;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_CANINO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionCanino;
    
    @Column(name = "ESTADO_USO_CANINO", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String estadoUsoCanino;

    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdCanino() {
        return idCanino;
    }
    public void setIdCanino(Long idCanino) {
        this.idCanino = idCanino;
    }
    public String getDenominacionCanino() {
        return denominacionCanino;
    }
    public void setDenominacionCanino(String denominacionCanino) {
        this.denominacionCanino = denominacionCanino;
    }
    public String getNumeroChipCanino() {
        return numeroChipCanino;
    }
    public void setNumeroChipCanino(String numeroChipCanino) {
        this.numeroChipCanino = numeroChipCanino;
    }
    public String getNumeroInventarioCanino() {
        return numeroInventarioCanino;
    }
    public void setNumeroInventarioCanino(String numeroInventarioCanino) {
        this.numeroInventarioCanino = numeroInventarioCanino;
    }
    public String getNumeroActivoFijoCanino() {
        return numeroActivoFijoCanino;
    }
    public void setNumeroActivoFijoCanino(String numeroActivoFijoCanino) {
        this.numeroActivoFijoCanino = numeroActivoFijoCanino;
    }
    public String getNombreCanino() {
        return nombreCanino;
    }
    public void setNombreCanino(String nombreCanino) {
        this.nombreCanino = nombreCanino;
    }
    public String getColorCanino() {
        return colorCanino;
    }
    public void setColorCanino(String colorCanino) {
        this.colorCanino = colorCanino;
    }
    public String getNombreRazaCanino() {
        return nombreRazaCanino;
    }
    public void setNombreRazaCanino(String nombreRazaCanino) {
        this.nombreRazaCanino = nombreRazaCanino;
    }
    public String getValorAdquisicionCanino() {
        return valorAdquisicionCanino;
    }
    public void setValorAdquisicionCanino(String valorAdquisicionCanino) {
        this.valorAdquisicionCanino = valorAdquisicionCanino;
    }
    public String getValorContableCanino() {
        return valorContableCanino;
    }
    public void setValorContableCanino(String valorContableCanino) {
        this.valorContableCanino = valorContableCanino;
    }
    public String getValorCostoUnitarioCanino() {
        return valorCostoUnitarioCanino;
    }
    public void setValorCostoUnitarioCanino(String valorCostoUnitarioCanino) {
        this.valorCostoUnitarioCanino = valorCostoUnitarioCanino;
    }
    public CompaniaUnidadMilitar getCompaniaUnidadMilitar() {
        return companiaUnidadMilitar;
    }
    public void setCompaniaUnidadMilitar(CompaniaUnidadMilitar companiaUnidadMilitar) {
        this.companiaUnidadMilitar = companiaUnidadMilitar;
    }
    public TipoDespejeMilitarArtefactoExplosivo getTipoDespejeMilitarArtefactoExplosivo() {
        return tipoDespejeMilitarArtefactoExplosivo;
    }
    public void setTipoDespejeMilitarArtefactoExplosivo(TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo) {
        this.tipoDespejeMilitarArtefactoExplosivo = tipoDespejeMilitarArtefactoExplosivo;
    }
    public String getCentroCostoCompaniaUnidadMilitar() {
        return centroCostoCompaniaUnidadMilitar;
    }
    public void setCentroCostoCompaniaUnidadMilitar(String centroCostoCompaniaUnidadMilitar) {
        this.centroCostoCompaniaUnidadMilitar = centroCostoCompaniaUnidadMilitar;
    }
    public Date getFechaHMSAltaCanino() {
        return fechaHMSAltaCanino;
    }
    public void setFechaHMSAltaCanino(Date fechaHMSAltaCanino) {
        this.fechaHMSAltaCanino = fechaHMSAltaCanino;
    }
    public String getTiempoAnualVidaUtilCanino() {
        return tiempoAnualVidaUtilCanino;
    }
    public void setTiempoAnualVidaUtilCanino(String tiempoAnualVidaUtilCanino) {
        this.tiempoAnualVidaUtilCanino = tiempoAnualVidaUtilCanino;
    }
    public String getDescripcionCanino() {
        return descripcionCanino;
    }
    public void setDescripcionCanino(String descripcionCanino) {
        this.descripcionCanino = descripcionCanino;
    }
    public Date getFechaHMSIngresoCanino() {
        return fechaHMSIngresoCanino;
    }
    public void setFechaHMSIngresoCanino(Date fechaHMSIngresoCanino) {
        this.fechaHMSIngresoCanino = fechaHMSIngresoCanino;
    }
    public Date getFechaHMSModificacionCanino() {
        return fechaHMSModificacionCanino;
    }
    public void setFechaHMSModificacionCanino(Date fechaHMSModificacionCanino) {
        this.fechaHMSModificacionCanino = fechaHMSModificacionCanino;
    }
    public String getEstadoUsoCanino() {
        return estadoUsoCanino;
    }
    public void setEstadoUsoCanino(String estadoUsoCanino) {
        this.estadoUsoCanino = estadoUsoCanino;
    }*/
}
