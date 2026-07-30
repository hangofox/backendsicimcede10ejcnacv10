//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_APOYOS_OBR_RED_MITIG_GEST_RIESG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ApoyoObrRedMitigGestRiesgDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "CODIGO_RADICADO_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(255) NOT NULL")
    private String codigoRadicadoApoyoObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "PAIS_ORIGEN_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String paisOrigenApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "CIUDAD_ORIGEN_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String ciudadOrigenApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "LATITUD_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(50) NOT NULL")
    private String latitudApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "LONGITUD_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(50) NOT NULL")
    private String longitudApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "FECHA_H_M_S_INICIACION_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_TIPO_ENTIDAD_INSTITUCIONAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoEntidadInstitucional;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_ENTIDAD_INSTITUCIONAL", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoEntidadInstitucional tipoEntidadInstitucional;
    
    @Column(name = "NOMBRE_ENTIDAD_INSTITUCIONAL_SOLIC_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "CODIGO_RADICADO_HR_OFICIO_AUTORIZACION_CDO_ING_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(255) NOT NULL")
    private String codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_TIPO_EM_DESAST_GEN_OBR_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_EM_DESAST_GEN_OBR_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUMERO_POB_BENEF_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroPobBenefApoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "DESCRIPCION_OBR_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="CLOB NULL")
    //@Lob
    private String descripcionObrApoyoObrRedMitigGestRiesgDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdApoyoObrRedMitigGestRiesgDesast() {
        return idApoyoObrRedMitigGestRiesgDesast;
    }
    public void setIdApoyoObrRedMitigGestRiesgDesast(Long idApoyoObrRedMitigGestRiesgDesast) {
        this.idApoyoObrRedMitigGestRiesgDesast = idApoyoObrRedMitigGestRiesgDesast;
    }
    public String getCodigoRadicadoApoyoObrRedMitigGestRiesgDesast() {
        return codigoRadicadoApoyoObrRedMitigGestRiesgDesast;
    }
    public void setCodigoRadicadoApoyoObrRedMitigGestRiesgDesast(String codigoRadicadoApoyoObrRedMitigGestRiesgDesast) {
        this.codigoRadicadoApoyoObrRedMitigGestRiesgDesast = codigoRadicadoApoyoObrRedMitigGestRiesgDesast;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getPaisOrigenApoyoObrRedMitigGestRiesgDesast() {
        return paisOrigenApoyoObrRedMitigGestRiesgDesast;
    }
    public void setPaisOrigenApoyoObrRedMitigGestRiesgDesast(String paisOrigenApoyoObrRedMitigGestRiesgDesast) {
        this.paisOrigenApoyoObrRedMitigGestRiesgDesast = paisOrigenApoyoObrRedMitigGestRiesgDesast;
    }
    public String getDepartamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast() {
        return departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast;
    }
    public void setDepartamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast(String departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast) {
        this.departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast = departamentoOEstadoOrigenApoyoObrRedMitigGestRiesgDesast;
    }
    public String getCiudadOrigenApoyoObrRedMitigGestRiesgDesast() {
        return ciudadOrigenApoyoObrRedMitigGestRiesgDesast;
    }
    public void setCiudadOrigenApoyoObrRedMitigGestRiesgDesast(String ciudadOrigenApoyoObrRedMitigGestRiesgDesast) {
        this.ciudadOrigenApoyoObrRedMitigGestRiesgDesast = ciudadOrigenApoyoObrRedMitigGestRiesgDesast;
    }
    public String getLatitudApoyoObrRedMitigGestRiesgDesast() {
        return latitudApoyoObrRedMitigGestRiesgDesast;
    }
    public void setLatitudApoyoObrRedMitigGestRiesgDesast(String latitudApoyoObrRedMitigGestRiesgDesast) {
        this.latitudApoyoObrRedMitigGestRiesgDesast = latitudApoyoObrRedMitigGestRiesgDesast;
    }
    public String getLongitudApoyoObrRedMitigGestRiesgDesast() {
        return longitudApoyoObrRedMitigGestRiesgDesast;
    }
    public void setLongitudApoyoObrRedMitigGestRiesgDesast(String longitudApoyoObrRedMitigGestRiesgDesast) {
        this.longitudApoyoObrRedMitigGestRiesgDesast = longitudApoyoObrRedMitigGestRiesgDesast;
    }
    public Date getFechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast() {
        return fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast;
    }
    public void setFechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast(Date fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast) {
        this.fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast = fechaHMSIniciacionApoyoObrRedMitigGestRiesgDesast;
    }
    public Date getFechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast() {
        return fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast;
    }
    public void setFechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast(Date fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast) {
        this.fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast = fechaHMSFinalizacionApoyoObrRedMitigGestRiesgDesast;
    }
    public TipoEntidadInstitucional getTipoEntidadInstitucional() {
        return tipoEntidadInstitucional;
    }
    public void setTipoEntidadInstitucional(TipoEntidadInstitucional tipoEntidadInstitucional) {
        this.tipoEntidadInstitucional = tipoEntidadInstitucional;
    }
    public String getNombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast() {
        return nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast;
    }
    public void setNombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast(String nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast) {
        this.nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast = nombreEntidadInstitucionalSolicApoyoObrRedMitigGestRiesgDesast;
    }
    public String getCodigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast() {
        return codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast;
    }
    public void setCodigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast(String codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast) {
        this.codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast = codigoRadicadoHrOficioAutorizacionCdoIngApoyoObrRedMitigGestRiesgDesast;
    }
    public TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast getTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast() {
        return tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
    }
    public void setTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast) {
        this.tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast = tipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
    }
    public Long getNumeroPobBenefApoyoObrRedMitigGestRiesgDesast() {
        return numeroPobBenefApoyoObrRedMitigGestRiesgDesast;
    }
    public void setNumeroPobBenefApoyoObrRedMitigGestRiesgDesast(Long numeroPobBenefApoyoObrRedMitigGestRiesgDesast) {
        this.numeroPobBenefApoyoObrRedMitigGestRiesgDesast = numeroPobBenefApoyoObrRedMitigGestRiesgDesast;
    }
    public String getDescripcionObrApoyoObrRedMitigGestRiesgDesast() {
        return descripcionObrApoyoObrRedMitigGestRiesgDesast;
    }
    public void setDescripcionObrApoyoObrRedMitigGestRiesgDesast(String descripcionObrApoyoObrRedMitigGestRiesgDesast) {
        this.descripcionObrApoyoObrRedMitigGestRiesgDesast = descripcionObrApoyoObrRedMitigGestRiesgDesast;
    }*/
}
