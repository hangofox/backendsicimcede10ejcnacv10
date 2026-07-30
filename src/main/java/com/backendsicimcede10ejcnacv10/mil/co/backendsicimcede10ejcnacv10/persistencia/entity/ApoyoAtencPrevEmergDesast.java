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
@Table(name = "TABLA_APOYOS_ATENC_PREV_EMERG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ApoyoAtencPrevEmergDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idApoyoAtencPrevEmergDesast;
    
    @Column(name = "CODIGO_RADICADO_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(255) NOT NULL")
    private String codigoRadicadoApoyoAtencPrevEmergDesast;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "PAIS_ORIGEN_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String paisOrigenApoyoAtencPrevEmergDesast;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String departamentoOEstadoOrigenApoyoAtencPrevEmergDesast;
    
    @Column(name = "CIUDAD_ORIGEN_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String ciudadOrigenApoyoAtencPrevEmergDesast;
    
    @Column(name = "LATITUD_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(50) NOT NULL")
    private String latitudApoyoAtencPrevEmergDesast;
    
    @Column(name = "LONGITUD_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(50) NOT NULL")
    private String longitudApoyoAtencPrevEmergDesast;
    
    @Column(name = "FECHA_H_M_S_INICIACION_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionApoyoAtencPrevEmergDesast;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionApoyoAtencPrevEmergDesast;
    
    //@Column(name = "ID_TIPO_ENTIDAD_INSTITUCIONAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoEntidadInstitucional;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_ENTIDAD_INSTITUCIONAL", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoEntidadInstitucional tipoEntidadInstitucional;
    
    @Column(name = "NOMBRE_ENTIDAD_INSTITUCIONAL_SOLIC_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast;
    
    //@Column(name = "ID_TIPO_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoRequerimientoApoyoAtencionPrevencion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion;
    
    //@Column(name = "ID_PROCESO_APOYO_ATENCION_PREVENCION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProcesoApoyoAtencionPrevencion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROCESO_APOYO_ATENCION_PREVENCION", columnDefinition = "NUMBER(20) NOT NULL")
    private ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencion;
    
    @Column(name = "CODIGO_RADICADO_TIPO_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="VARCHAR2(255) NOT NULL")
    private String codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion;
    
    //@Column(name = "ID_TIPO_EVENTO_APOYO_REALIZADO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoEventoApoyoRealizado;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_EVENTO_APOYO_REALIZADO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoEventoApoyoRealizado tipoEventoApoyoRealizado;
    
    @Column(name = "NUMERO_HERIDOS_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroHeridosRequerimientoApoyoAtencionPrevencion;
    
    @Column(name = "NUMERO_MUERTOS_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroMuertosRequerimientoApoyoAtencionPrevencion;
    
    @Column(name = "NUMERO_DESAPARECIDOS_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroDesaparecidosRequerimientoApoyoAtencionPrevencion;
    
    @Column(name = "NUMERO_VIVIENDAS_AFECTADAS_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion;
    
    @Column(name = "NUMERO_PUENTES_AFECTADOS_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion;
    
    @Column(name = "NUMERO_VIAS_AFECTADAS_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroViasAfectadasRequerimientoApoyoAtencionPrevencion;
    
    @Column(name = "NUMERO_HECTAREAS_AFECTADAS_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion;
    
    @Column(name = "DESCRIPCION_AFECTACION_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition="CLOB NULL")
    //@Lob
    private String descripcionAfectacionApoyoAtencPrevEmergDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdApoyoAtencPrevEmergDesast() {
        return idApoyoAtencPrevEmergDesast;
    }
    public void setIdApoyoAtencPrevEmergDesast(Long idApoyoAtencPrevEmergDesast) {
        this.idApoyoAtencPrevEmergDesast = idApoyoAtencPrevEmergDesast;
    }
    public String getCodigoRadicadoApoyoAtencPrevEmergDesast() {
        return codigoRadicadoApoyoAtencPrevEmergDesast;
    }
    public void setCodigoRadicadoApoyoAtencPrevEmergDesast(String codigoRadicadoApoyoAtencPrevEmergDesast) {
        this.codigoRadicadoApoyoAtencPrevEmergDesast = codigoRadicadoApoyoAtencPrevEmergDesast;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getPaisOrigenApoyoAtencPrevEmergDesast() {
        return paisOrigenApoyoAtencPrevEmergDesast;
    }
    public void setPaisOrigenApoyoAtencPrevEmergDesast(String paisOrigenApoyoAtencPrevEmergDesast) {
        this.paisOrigenApoyoAtencPrevEmergDesast = paisOrigenApoyoAtencPrevEmergDesast;
    }
    public String getDepartamentoOEstadoOrigenApoyoAtencPrevEmergDesast() {
        return departamentoOEstadoOrigenApoyoAtencPrevEmergDesast;
    }
    public void setDepartamentoOEstadoOrigenApoyoAtencPrevEmergDesast(String departamentoOEstadoOrigenApoyoAtencPrevEmergDesast) {
        this.departamentoOEstadoOrigenApoyoAtencPrevEmergDesast = departamentoOEstadoOrigenApoyoAtencPrevEmergDesast;
    }
    public String getCiudadOrigenApoyoAtencPrevEmergDesast() {
        return ciudadOrigenApoyoAtencPrevEmergDesast;
    }
    public void setCiudadOrigenApoyoAtencPrevEmergDesast(String ciudadOrigenApoyoAtencPrevEmergDesast) {
        this.ciudadOrigenApoyoAtencPrevEmergDesast = ciudadOrigenApoyoAtencPrevEmergDesast;
    }
    public String getLatitudApoyoAtencPrevEmergDesast() {
        return latitudApoyoAtencPrevEmergDesast;
    }
    public void setLatitudApoyoAtencPrevEmergDesast(String latitudApoyoAtencPrevEmergDesast) {
        this.latitudApoyoAtencPrevEmergDesast = latitudApoyoAtencPrevEmergDesast;
    }
    public String getLongitudApoyoAtencPrevEmergDesast() {
        return longitudApoyoAtencPrevEmergDesast;
    }
    public void setLongitudApoyoAtencPrevEmergDesast(String longitudApoyoAtencPrevEmergDesast) {
        this.longitudApoyoAtencPrevEmergDesast = longitudApoyoAtencPrevEmergDesast;
    }
    public Date getFechaHMSIniciacionApoyoAtencPrevEmergDesast() {
        return fechaHMSIniciacionApoyoAtencPrevEmergDesast;
    }
    public void setFechaHMSIniciacionApoyoAtencPrevEmergDesast(Date fechaHMSIniciacionApoyoAtencPrevEmergDesast) {
        this.fechaHMSIniciacionApoyoAtencPrevEmergDesast = fechaHMSIniciacionApoyoAtencPrevEmergDesast;
    }
    public Date getFechaHMSFinalizacionApoyoAtencPrevEmergDesast() {
        return fechaHMSFinalizacionApoyoAtencPrevEmergDesast;
    }
    public void setFechaHMSFinalizacionApoyoAtencPrevEmergDesast(Date fechaHMSFinalizacionApoyoAtencPrevEmergDesast) {
        this.fechaHMSFinalizacionApoyoAtencPrevEmergDesast = fechaHMSFinalizacionApoyoAtencPrevEmergDesast;
    }
    public TipoEntidadInstitucional getTipoEntidadInstitucional() {
        return tipoEntidadInstitucional;
    }
    public void setTipoEntidadInstitucional(TipoEntidadInstitucional tipoEntidadInstitucional) {
        this.tipoEntidadInstitucional = tipoEntidadInstitucional;
    }
    public String getNombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast() {
        return nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast;
    }
    public void setNombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast(String nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast) {
        this.nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast = nombreEntidadInstitucionalSolicApoyoAtencPrevEmergDesast;
    }
    public TipoRequerimientoApoyoAtencionPrevencion getTipoRequerimientoApoyoAtencionPrevencion() {
        return tipoRequerimientoApoyoAtencionPrevencion;
    }
    public void setTipoRequerimientoApoyoAtencionPrevencion(TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion) {
        this.tipoRequerimientoApoyoAtencionPrevencion = tipoRequerimientoApoyoAtencionPrevencion;
    }
    public ProcesoApoyoAtencionPrevencion getProcesoApoyoAtencionPrevencion() {
        return procesoApoyoAtencionPrevencion;
    }
    public void setProcesoApoyoAtencionPrevencion(ProcesoApoyoAtencionPrevencion procesoApoyoAtencionPrevencion) {
        this.procesoApoyoAtencionPrevencion = procesoApoyoAtencionPrevencion;
    }
    public String getCodigoRadicadoTipoRequerimientoApoyoAtencionPrevencion() {
        return codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion;
    }
    public void setCodigoRadicadoTipoRequerimientoApoyoAtencionPrevencion(String codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion) {
        this.codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion = codigoRadicadoTipoRequerimientoApoyoAtencionPrevencion;
    }
    public TipoEventoApoyoRealizado getTipoEventoApoyoRealizado() {
        return tipoEventoApoyoRealizado;
    }
    public void setTipoEventoApoyoRealizado(TipoEventoApoyoRealizado tipoEventoApoyoRealizado) {
        this.tipoEventoApoyoRealizado = tipoEventoApoyoRealizado;
    }
    public Long getNumeroHeridosRequerimientoApoyoAtencionPrevencion() {
        return numeroHeridosRequerimientoApoyoAtencionPrevencion;
    }
    public void setNumeroHeridosRequerimientoApoyoAtencionPrevencion(Long numeroHeridosRequerimientoApoyoAtencionPrevencion) {
        this.numeroHeridosRequerimientoApoyoAtencionPrevencion = numeroHeridosRequerimientoApoyoAtencionPrevencion;
    }
    public Long getNumeroMuertosRequerimientoApoyoAtencionPrevencion() {
        return numeroMuertosRequerimientoApoyoAtencionPrevencion;
    }
    public void setNumeroMuertosRequerimientoApoyoAtencionPrevencion(Long numeroMuertosRequerimientoApoyoAtencionPrevencion) {
        this.numeroMuertosRequerimientoApoyoAtencionPrevencion = numeroMuertosRequerimientoApoyoAtencionPrevencion;
    }
    public Long getNumeroDesaparecidosRequerimientoApoyoAtencionPrevencion() {
        return numeroDesaparecidosRequerimientoApoyoAtencionPrevencion;
    }
    public void setNumeroDesaparecidosRequerimientoApoyoAtencionPrevencion(Long numeroDesaparecidosRequerimientoApoyoAtencionPrevencion) {
        this.numeroDesaparecidosRequerimientoApoyoAtencionPrevencion = numeroDesaparecidosRequerimientoApoyoAtencionPrevencion;
    }
    public Long getNumeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion() {
        return numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion;
    }
    public void setNumeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion(Long numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion) {
        this.numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion = numeroViviendasAfectadasRequerimientoApoyoAtencionPrevencion;
    }
    public Long getNumeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion() {
        return numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion;
    }
    public void setNumeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion(Long numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion) {
        this.numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion = numeroPuentesAfectadosRequerimientoApoyoAtencionPrevencion;
    }
    public Long getNumeroViasAfectadasRequerimientoApoyoAtencionPrevencion() {
        return numeroViasAfectadasRequerimientoApoyoAtencionPrevencion;
    }
    public void setNumeroViasAfectadasRequerimientoApoyoAtencionPrevencion(Long numeroViasAfectadasRequerimientoApoyoAtencionPrevencion) {
        this.numeroViasAfectadasRequerimientoApoyoAtencionPrevencion = numeroViasAfectadasRequerimientoApoyoAtencionPrevencion;
    }
    public Long getNumeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion() {
        return numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion;
    }
    public void setNumeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion(Long numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion) {
        this.numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion = numeroHectareasAfectadasRequerimientoApoyoAtencionPrevencion;
    }
    public String getDescripcionAfectacionApoyoAtencPrevEmergDesast() {
        return descripcionAfectacionApoyoAtencPrevEmergDesast;
    }
    public void setDescripcionAfectacionApoyoAtencPrevEmergDesast(String descripcionAfectacionApoyoAtencPrevEmergDesast) {
        this.descripcionAfectacionApoyoAtencPrevEmergDesast = descripcionAfectacionApoyoAtencPrevEmergDesast;
    }*/
}
