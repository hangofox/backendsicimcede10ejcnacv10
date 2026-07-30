//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class EquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idEquipoIngeniero;
    
    @Column(name = "DENOMINACION_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String denominacionEquipoIngeniero;
    
    @Column(name = "NUMERO_INVENTARIO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NULL")
    private String numeroInventarioEquipoIngeniero;
    
    @Column(name = "NUMERO_ACTIVO_FIJO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NULL")
    private String numeroActivoFijoEquipoIngeniero;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "CENTRO_COSTO_UNIDAD_MILITAR_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String centroCostoUnidadMilitarEquipoIngeniero;
    
    //@Column(name = "ID_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSociedadUnidadCentralizadora;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition = "NUMBER(20) NOT NULL")
    private SociedadUnidadCentralizadora sociedadUnidadCentralizadora;
    
    //@Column(name = "ID_CLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idClasificacionEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_CLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private ClasificacionEquipoIngeniero clasificacionEquipoIngeniero;
    
    //@Column(name = "ID_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSubclasificacionEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero;
    
    //@Column(name = "ID_ELEMENTO_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idElementoSubclasificacionEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ELEMENTO_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero;
    
    //@Column(name = "ID_TIPO_ALTA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoAltaEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_ALTA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero;
    
    @Column(name = "MARCA_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(100) NOT NULL")
    private String marcaEquipoIngeniero;
    
    @Column(name = "MODELO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(100) NOT NULL")
    private String modeloEquipoIngeniero;
    
    @Column(name = "CAPACIDAD_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(100) NOT NULL")
    private String capacidadEquipoIngeniero;
    
    @Column(name = "EMPADRONAMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String empadronamientoEquipoIngeniero;
    
    @Column(name = "NUMERO_PLACA_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String numeroPlacaEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_MATRICULA_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSMatriculaEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_ALTA_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSAltaEquipoIngeniero;
    
    @Column(name = "VALOR_ADQUISICION_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String valorAdquisicionEquipoIngeniero;
    
    @Column(name = "VALOR_CONTABLE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String valorContableEquipoIngeniero;
    
    @Column(name = "VALOR_DEPRECIACION_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String valorDepreciacionEquipoIngeniero;
    
    @Column(name = "OBSERVACIONES_EQUIPO_INGENIERO", columnDefinition="CLOB NULL")
    //@Lob
    private String observacionesEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_INGRESO_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionEquipoIngeniero;
    
    @Column(name = "ESTADO_USO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String estadoUsoEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdEquipoIngeniero() {
        return idEquipoIngeniero;
    }
    public void setIdEquipoIngeniero(Long idEquipoIngeniero) {
        this.idEquipoIngeniero = idEquipoIngeniero;
    }
    public String getDenominacionEquipoIngeniero() {
        return denominacionEquipoIngeniero;
    }
    public void setDenominacionEquipoIngeniero(String denominacionEquipoIngeniero) {
        this.denominacionEquipoIngeniero = denominacionEquipoIngeniero;
    }
    public String getNumeroInventarioEquipoIngeniero() {
        return numeroInventarioEquipoIngeniero;
    }
    public void setNumeroInventarioEquipoIngeniero(String numeroInventarioEquipoIngeniero) {
        this.numeroInventarioEquipoIngeniero = numeroInventarioEquipoIngeniero;
    }
    public String getNumeroActivoFijoEquipoIngeniero() {
        return numeroActivoFijoEquipoIngeniero;
    }
    public void setNumeroActivoFijoEquipoIngeniero(String numeroActivoFijoEquipoIngeniero) {
        this.numeroActivoFijoEquipoIngeniero = numeroActivoFijoEquipoIngeniero;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getCentroCostoUnidadMilitarEquipoIngeniero() {
        return centroCostoUnidadMilitarEquipoIngeniero;
    }
    public void setCentroCostoUnidadMilitarEquipoIngeniero(String centroCostoUnidadMilitarEquipoIngeniero) {
        this.centroCostoUnidadMilitarEquipoIngeniero = centroCostoUnidadMilitarEquipoIngeniero;
    }
    public SociedadUnidadCentralizadora getSociedadUnidadCentralizadora() {
        return sociedadUnidadCentralizadora;
    }
    public void setSociedadUnidadCentralizadora(SociedadUnidadCentralizadora sociedadUnidadCentralizadora) {
        this.sociedadUnidadCentralizadora = sociedadUnidadCentralizadora;
    }
    public ClasificacionEquipoIngeniero getClasificacionEquipoIngeniero() {
        return clasificacionEquipoIngeniero;
    }
    public void setClasificacionEquipoIngeniero(ClasificacionEquipoIngeniero clasificacionEquipoIngeniero) {
        this.clasificacionEquipoIngeniero = clasificacionEquipoIngeniero;
    }
    public SubclasificacionEquipoIngeniero getSubclasificacionEquipoIngeniero() {
        return subclasificacionEquipoIngeniero;
    }
    public void setSubclasificacionEquipoIngeniero(SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero) {
        this.subclasificacionEquipoIngeniero = subclasificacionEquipoIngeniero;
    }
    public ElementoSubclasificacionEquipoIngeniero getElementoSubclasificacionEquipoIngeniero() {
        return elementoSubclasificacionEquipoIngeniero;
    }
    public void setElementoSubclasificacionEquipoIngeniero(ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero) {
        this.elementoSubclasificacionEquipoIngeniero = elementoSubclasificacionEquipoIngeniero;
    }
    public TipoAltaEquipoIngeniero getTipoAltaEquipoIngeniero() {
        return tipoAltaEquipoIngeniero;
    }
    public void setTipoAltaEquipoIngeniero(TipoAltaEquipoIngeniero tipoAltaEquipoIngeniero) {
        this.tipoAltaEquipoIngeniero = tipoAltaEquipoIngeniero;
    }
    public String getMarcaEquipoIngeniero() {
        return marcaEquipoIngeniero;
    }
    public void setMarcaEquipoIngeniero(String marcaEquipoIngeniero) {
        this.marcaEquipoIngeniero = marcaEquipoIngeniero;
    }
    public String getModeloEquipoIngeniero() {
        return modeloEquipoIngeniero;
    }
    public void setModeloEquipoIngeniero(String modeloEquipoIngeniero) {
        this.modeloEquipoIngeniero = modeloEquipoIngeniero;
    }
    public String getCapacidadEquipoIngeniero() {
        return capacidadEquipoIngeniero;
    }
    public void setCapacidadEquipoIngeniero(String capacidadEquipoIngeniero) {
        this.capacidadEquipoIngeniero = capacidadEquipoIngeniero;
    }
    public String getEmpadronamientoEquipoIngeniero() {
        return empadronamientoEquipoIngeniero;
    }
    public void setEmpadronamientoEquipoIngeniero(String empadronamientoEquipoIngeniero) {
        this.empadronamientoEquipoIngeniero = empadronamientoEquipoIngeniero;
    }
    public String getNumeroPlacaEquipoIngeniero() {
        return numeroPlacaEquipoIngeniero;
    }
    public void setNumeroPlacaEquipoIngeniero(String numeroPlacaEquipoIngeniero) {
        this.numeroPlacaEquipoIngeniero = numeroPlacaEquipoIngeniero;
    }
    public Date getFechaHMSMatriculaEquipoIngeniero() {
        return fechaHMSMatriculaEquipoIngeniero;
    }
    public void setFechaHMSMatriculaEquipoIngeniero(Date fechaHMSMatriculaEquipoIngeniero) {
        this.fechaHMSMatriculaEquipoIngeniero = fechaHMSMatriculaEquipoIngeniero;
    }
    public Date getFechaHMSAltaEquipoIngeniero() {
        return fechaHMSAltaEquipoIngeniero;
    }
    public void setFechaHMSAltaEquipoIngeniero(Date fechaHMSAltaEquipoIngeniero) {
        this.fechaHMSAltaEquipoIngeniero = fechaHMSAltaEquipoIngeniero;
    }
    public String getValorAdquisicionEquipoIngeniero() {
        return valorAdquisicionEquipoIngeniero;
    }
    public void setValorAdquisicionEquipoIngeniero(String valorAdquisicionEquipoIngeniero) {
        this.valorAdquisicionEquipoIngeniero = valorAdquisicionEquipoIngeniero;
    }
    public String getValorContableEquipoIngeniero() {
        return valorContableEquipoIngeniero;
    }
    public void setValorContableEquipoIngeniero(String valorContableEquipoIngeniero) {
        this.valorContableEquipoIngeniero = valorContableEquipoIngeniero;
    }
    public String getValorDepreciacionEquipoIngeniero() {
        return valorDepreciacionEquipoIngeniero;
    }
    public void setValorDepreciacionEquipoIngeniero(String valorDepreciacionEquipoIngeniero) {
        this.valorDepreciacionEquipoIngeniero = valorDepreciacionEquipoIngeniero;
    }
    public String getObservacionesEquipoIngeniero() {
        return observacionesEquipoIngeniero;
    }
    public void setObservacionesEquipoIngeniero(String observacionesEquipoIngeniero) {
        this.observacionesEquipoIngeniero = observacionesEquipoIngeniero;
    }
    public Date getFechaHMSIngresoEquipoIngeniero() {
        return fechaHMSIngresoEquipoIngeniero;
    }
    public void setFechaHMSIngresoEquipoIngeniero(Date fechaHMSIngresoEquipoIngeniero) {
        this.fechaHMSIngresoEquipoIngeniero = fechaHMSIngresoEquipoIngeniero;
    }
    public Date getFechaHMSModificacionEquipoIngeniero() {
        return fechaHMSModificacionEquipoIngeniero;
    }
    public void setFechaHMSModificacionEquipoIngeniero(Date fechaHMSModificacionEquipoIngeniero) {
        this.fechaHMSModificacionEquipoIngeniero = fechaHMSModificacionEquipoIngeniero;
    }
    public String getEstadoUsoEquipoIngeniero() {
        return estadoUsoEquipoIngeniero;
    }
    public void setEstadoUsoEquipoIngeniero(String estadoUsoEquipoIngeniero) {
        this.estadoUsoEquipoIngeniero = estadoUsoEquipoIngeniero;
    }*/
}
