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
@Table(name = "TABLA_SOLICITUDES_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class SolicitudInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idSolicitudInfraestructura;
    
    @Column(name = "CODIGO_RADICADO_SOLICITUD_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String codigoRadicadoSolicitudInfraestructura;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "FECHA_H_M_S_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSSolicitudInfraestructura;
    
    //@Column(name = "ID_TIPO_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoSolicitudInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoSolicitudInfraestructura tipoSolicitudInfraestructura;
    
    @Column(name = "NOMBRE_SOLICITUD_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreSolicitudInfraestructura;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    @Column(name = "NOMBRE_DEPENDENCIA_SOLICITUD_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreDependenciaSolicitudInfraestructura;
    
    @Column(name = "NUMERO_FUNCIONARIOS_SOLICITUD_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroFuncionariosSolicitudInfraestructura;
    
    @Column(name = "NUMERO_USUARIOS_SOLICITUD_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroUsuariosSolicitudInfraestructura;
    
    @Column(name = "OBSERVACIONES_JURIDICAS_ESTADO_PREDIO_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    //@Lob
    private String observacionesJuridicasEstadoPredioInfraestructura;
    
    @Column(name = "OBSERVACIONES_ESTADO_AMBIENTAL_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    //@Lob
    private String observacionesEstadoAmbientalInfraestructura;
    
    @Column(name = "JUSTIFICACION_NECESIDAD_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    //@Lob
    private String justificacionNecesidadInfraestructura;
    
    @Column(name = "DESCRIPCION_GENERAL_NECESIDAD_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    //@Lob
    private String descripcionGeneralNecesidadInfraestructura;
    
    @Column(name = "DESCRIPCION_IMPACTO_ESPERADO_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    //@Lob
    private String descripcionImpactoEsperadoInfraestructura;
    
    @Column(name = "FECHA_H_M_S_INGRESO_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoSolicitudInfraestructura;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionSolicitudInfraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdSolicitudInfraestructura() {
        return idSolicitudInfraestructura;
    }
    public void setIdSolicitudInfraestructura(Long idSolicitudInfraestructura) {
        this.idSolicitudInfraestructura = idSolicitudInfraestructura;
    }
    public String getCodigoRadicadoSolicitudInfraestructura() {
        return codigoRadicadoSolicitudInfraestructura;
    }
    public void setCodigoRadicadoSolicitudInfraestructura(String codigoRadicadoSolicitudInfraestructura) {
        this.codigoRadicadoSolicitudInfraestructura = codigoRadicadoSolicitudInfraestructura;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public Date getFechaHMSSolicitudInfraestructura() {
        return fechaHMSSolicitudInfraestructura;
    }
    public void setFechaHMSSolicitudInfraestructura(Date fechaHMSSolicitudInfraestructura) {
        this.fechaHMSSolicitudInfraestructura = fechaHMSSolicitudInfraestructura;
    }
    public TipoSolicitudInfraestructura getTipoSolicitudInfraestructura() {
        return tipoSolicitudInfraestructura;
    }
    public void setTipoSolicitudInfraestructura(TipoSolicitudInfraestructura tipoSolicitudInfraestructura) {
        this.tipoSolicitudInfraestructura = tipoSolicitudInfraestructura;
    }
    public String getNombreSolicitudInfraestructura() {
        return nombreSolicitudInfraestructura;
    }
    public void setNombreSolicitudInfraestructura(String nombreSolicitudInfraestructura) {
        this.nombreSolicitudInfraestructura = nombreSolicitudInfraestructura;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public String getNombreDependenciaSolicitudInfraestructura() {
        return nombreDependenciaSolicitudInfraestructura;
    }
    public void setNombreDependenciaSolicitudInfraestructura(String nombreDependenciaSolicitudInfraestructura) {
        this.nombreDependenciaSolicitudInfraestructura = nombreDependenciaSolicitudInfraestructura;
    }
    public Long getNumeroFuncionariosSolicitudInfraestructura() {
        return numeroFuncionariosSolicitudInfraestructura;
    }
    public void setNumeroFuncionariosSolicitudInfraestructura(Long numeroFuncionariosSolicitudInfraestructura) {
        this.numeroFuncionariosSolicitudInfraestructura = numeroFuncionariosSolicitudInfraestructura;
    }
    public Long getNumeroUsuariosSolicitudInfraestructura() {
        return numeroUsuariosSolicitudInfraestructura;
    }
    public void setNumeroUsuariosSolicitudInfraestructura(Long numeroUsuariosSolicitudInfraestructura) {
        this.numeroUsuariosSolicitudInfraestructura = numeroUsuariosSolicitudInfraestructura;
    }
    public String getObservacionesJuridicasEstadoPredioInfraestructura() {
        return observacionesJuridicasEstadoPredioInfraestructura;
    }
    public void setObservacionesJuridicasEstadoPredioInfraestructura(String observacionesJuridicasEstadoPredioInfraestructura) {
        this.observacionesJuridicasEstadoPredioInfraestructura = observacionesJuridicasEstadoPredioInfraestructura;
    }
    public String getObservacionesEstadoAmbientalInfraestructura() {
        return observacionesEstadoAmbientalInfraestructura;
    }
    public void setObservacionesEstadoAmbientalInfraestructura(String observacionesEstadoAmbientalInfraestructura) {
        this.observacionesEstadoAmbientalInfraestructura = observacionesEstadoAmbientalInfraestructura;
    }
    public String getJustificacionNecesidadInfraestructura() {
        return justificacionNecesidadInfraestructura;
    }
    public void setJustificacionNecesidadInfraestructura(String justificacionNecesidadInfraestructura) {
        this.justificacionNecesidadInfraestructura = justificacionNecesidadInfraestructura;
    }
    public String getDescripcionGeneralNecesidadInfraestructura() {
        return descripcionGeneralNecesidadInfraestructura;
    }
    public void setDescripcionGeneralNecesidadInfraestructura(String descripcionGeneralNecesidadInfraestructura) {
        this.descripcionGeneralNecesidadInfraestructura = descripcionGeneralNecesidadInfraestructura;
    }
    public String getDescripcionImpactoEsperadoInfraestructura() {
        return descripcionImpactoEsperadoInfraestructura;
    }
    public void setDescripcionImpactoEsperadoInfraestructura(String descripcionImpactoEsperadoInfraestructura) {
        this.descripcionImpactoEsperadoInfraestructura = descripcionImpactoEsperadoInfraestructura;
    }
    public Date getFechaHMSIngresoSolicitudInfraestructura() {
        return fechaHMSIngresoSolicitudInfraestructura;
    }
    public void setFechaHMSIngresoSolicitudInfraestructura(Date fechaHMSIngresoSolicitudInfraestructura) {
        this.fechaHMSIngresoSolicitudInfraestructura = fechaHMSIngresoSolicitudInfraestructura;
    }
    public Date getFechaHMSModificacionSolicitudInfraestructura() {
        return fechaHMSModificacionSolicitudInfraestructura;
    }
    public void setFechaHMSModificacionSolicitudInfraestructura(Date fechaHMSModificacionSolicitudInfraestructura) {
        this.fechaHMSModificacionSolicitudInfraestructura = fechaHMSModificacionSolicitudInfraestructura;
    }*/
}
