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
@Table(name = "TABLA_MATERIALES_TECNICOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class MaterialTecnico {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_MATERIAL_TECNICO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idMaterialTecnico;
    
    @Column(name = "NOMBRE_MATERIAL_TECNICO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreMaterialTecnico;
    
    @Column(name = "SERIAL_MATERIAL_TECNICO", columnDefinition="VARCHAR2(100) NOT NULL")
    private String serialMaterialTecnico;
    
    @Column(name = "NUMERO_INVENTARIO_MATERIAL_TECNICO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroInventarioMaterialTecnico;
    
    @Column(name = "NUMERO_ACTIVO_FIJO_MATERIAL_TECNICO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroActivoFijoMaterialTecnico;
    
    @Column(name = "VALOR_ADQUISICION_MATERIAL_TECNICO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorAdquisicionMaterialTecnico;
    
    @Column(name = "VALOR_CONTABLE_MATERIAL_TECNICO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorContableMaterialTecnico;
    
    @Column(name = "VALOR_COSTO_UNITARIO_MATERIAL_TECNICO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String valorCostoUnitarioMaterialTecnico;
    
    @Column(name = "CODIGO_CONTABLE_MATERIAL_TECNICO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String codigoContableMaterialTecnico;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    //@Column(name = "ID_TIPO_DESPEJE_MILITAR_ARTEFACTO_EXPLOSIVO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDespejeMilitarArtefactoExplosivo;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DESPEJE_MILITAR_ARTEFACTO_EXPLOSIVO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo;
    
    @Column(name = "CENTRO_COSTO_UNIDAD_MILITAR", columnDefinition="VARCHAR2(150) NOT NULL")
    private String centroCostoUnidadMilitar;
    
    @Column(name = "FECHA_H_M_S_ALTA_MATERIAL_TECNICO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSAltaMaterialTecnico;
    
    @Column(name = "TIEMPO_ANUAL_VIDA_UTIL_MATERIAL_TECNICO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String tiempoAnualVidaUtilMaterialTecnico;
    
    @Column(name = "FECHA_H_M_S_INGRESO_MATERIAL_TECNICO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoMaterialTecnico;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_MATERIAL_TECNICO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionMaterialTecnico;
    
    @Column(name = "ESTADO_USO_MATERIAL_TECNICO", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String estadoUsoMaterialTecnico;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdMaterialTecnico() {
        return idMaterialTecnico;
    }
    public void setIdMaterialTecnico(Long idMaterialTecnico) {
        this.idMaterialTecnico = idMaterialTecnico;
    }
    public String getNombreMaterialTecnico() {
        return nombreMaterialTecnico;
    }
    public void setNombreMaterialTecnico(String nombreMaterialTecnico) {
        this.nombreMaterialTecnico = nombreMaterialTecnico;
    }
    public String getSerialMaterialTecnico() {
        return serialMaterialTecnico;
    }
    public void setSerialMaterialTecnico(String serialMaterialTecnico) {
        this.serialMaterialTecnico = serialMaterialTecnico;
    }
    public String getNumeroInventarioMaterialTecnico() {
        return numeroInventarioMaterialTecnico;
    }
    public void setNumeroInventarioMaterialTecnico(String numeroInventarioMaterialTecnico) {
        this.numeroInventarioMaterialTecnico = numeroInventarioMaterialTecnico;
    }
    public String getNumeroActivoFijoMaterialTecnico() {
        return numeroActivoFijoMaterialTecnico;
    }
    public void setNumeroActivoFijoMaterialTecnico(String numeroActivoFijoMaterialTecnico) {
        this.numeroActivoFijoMaterialTecnico = numeroActivoFijoMaterialTecnico;
    }
    public String getValorAdquisicionMaterialTecnico() {
        return valorAdquisicionMaterialTecnico;
    }
    public void setValorAdquisicionMaterialTecnico(String valorAdquisicionMaterialTecnico) {
        this.valorAdquisicionMaterialTecnico = valorAdquisicionMaterialTecnico;
    }
    public String getValorContableMaterialTecnico() {
        return valorContableMaterialTecnico;
    }
    public void setValorContableMaterialTecnico(String valorContableMaterialTecnico) {
        this.valorContableMaterialTecnico = valorContableMaterialTecnico;
    }
    public String getValorCostoUnitarioMaterialTecnico() {
        return valorCostoUnitarioMaterialTecnico;
    }
    public void setValorCostoUnitarioMaterialTecnico(String valorCostoUnitarioMaterialTecnico) {
        this.valorCostoUnitarioMaterialTecnico = valorCostoUnitarioMaterialTecnico;
    }
    public String getCodigoContableMaterialTecnico() {
        return codigoContableMaterialTecnico;
    }
    public void setCodigoContableMaterialTecnico(String codigoContableMaterialTecnico) {
        this.codigoContableMaterialTecnico = codigoContableMaterialTecnico;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public TipoDespejeMilitarArtefactoExplosivo getTipoDespejeMilitarArtefactoExplosivo() {
        return tipoDespejeMilitarArtefactoExplosivo;
    }
    public void setTipoDespejeMilitarArtefactoExplosivo(TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo) {
        this.tipoDespejeMilitarArtefactoExplosivo = tipoDespejeMilitarArtefactoExplosivo;
    }
    public String getCentroCostoUnidadMilitar() {
        return centroCostoUnidadMilitar;
    }
    public void setCentroCostoUnidadMilitar(String centroCostoUnidadMilitar) {
        this.centroCostoUnidadMilitar = centroCostoUnidadMilitar;
    }
    public Date getFechaHMSAltaMaterialTecnico() {
        return fechaHMSAltaMaterialTecnico;
    }
    public void setFechaHMSAltaMaterialTecnico(Date fechaHMSAltaMaterialTecnico) {
        this.fechaHMSAltaMaterialTecnico = fechaHMSAltaMaterialTecnico;
    }
    public String getTiempoAnualVidaUtilMaterialTecnico() {
        return tiempoAnualVidaUtilMaterialTecnico;
    }
    public void setTiempoAnualVidaUtilMaterialTecnico(String tiempoAnualVidaUtilMaterialTecnico) {
        this.tiempoAnualVidaUtilMaterialTecnico = tiempoAnualVidaUtilMaterialTecnico;
    }
    public Date getFechaHMSIngresoMaterialTecnico() {
        return fechaHMSIngresoMaterialTecnico;
    }
    public void setFechaHMSIngresoMaterialTecnico(Date fechaHMSIngresoMaterialTecnico) {
        this.fechaHMSIngresoMaterialTecnico = fechaHMSIngresoMaterialTecnico;
    }
    public Date getFechaHMSModificacionMaterialTecnico() {
        return fechaHMSModificacionMaterialTecnico;
    }
    public void setFechaHMSModificacionMaterialTecnico(Date fechaHMSModificacionMaterialTecnico) {
        this.fechaHMSModificacionMaterialTecnico = fechaHMSModificacionMaterialTecnico;
    }
    public String getEstadoUsoMaterialTecnico() {
        return estadoUsoMaterialTecnico;
    }
    public void setEstadoUsoMaterialTecnico(String estadoUsoMaterialTecnico) {
        this.estadoUsoMaterialTecnico = estadoUsoMaterialTecnico;
    }*/
}
