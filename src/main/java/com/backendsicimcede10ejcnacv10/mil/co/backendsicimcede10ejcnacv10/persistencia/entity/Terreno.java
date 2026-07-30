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
@Table(name = "TABLA_TERRENOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class Terreno {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_TERRENO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idTerreno;
    
    @Column(name = "DENOMINACION_TERRENO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String denominacionTerreno;
    
    @Column(name = "NUMERO_INVENTARIO_TERRENO", columnDefinition="VARCHAR2(255) NULL")
    private String numeroInventarioTerreno;
    
    @Column(name = "NUMERO_ACTIVO_FIJO_TERRENO", columnDefinition="VARCHAR2(255) NULL")
    private String numeroActivoFijoTerreno;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    //@Column(name = "ID_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSociedadUnidadCentralizadora;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition = "NUMBER(20) NOT NULL")
    private SociedadUnidadCentralizadora sociedadUnidadCentralizadora;
    
    @Column(name = "NUMERO_CATASTRAL_TERRENO", columnDefinition="VARCHAR2(255) NULL")
    private String numeroCatastralTerreno;
    
    @Column(name = "NUMERO_ESCRITURA_TERRENO", columnDefinition="VARCHAR2(255) NULL")
    private String numeroEscrituraTerreno;
    
    @Column(name = "NUMERO_NOTARIA_TERRENO", columnDefinition="VARCHAR2(255) NULL")
    private String numeroNotariaTerreno;
    
    @Column(name = "LUGAR_UBICACION_NOTARIA_TERRENO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String lugarUbicacionNotariaTerreno;
    
    @Column(name = "FECHA_H_M_S_MATRICULA_TERRENO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSMatriculaTerreno;
    
    @Column(name = "PAIS_ORIGEN_TERRENO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String paisOrigenTerreno;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_TERRENO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String departamentoOEstadoOrigenTerreno;
    
    @Column(name = "CIUDAD_ORIGEN_TERRENO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String ciudadOrigenTerreno;
    
    @Column(name = "DIRECCION_TERRENO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String direccionTerreno;
    
    @Column(name = "LATITUD_TERRENO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String latitudTerreno;
    
    @Column(name = "LONGITUD_TERRENO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String longitudTerreno;
    
    @Column(name = "NUMERO_AREA_TERRENO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroAreaTerreno;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_TERRENO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaTerreno;
    
    @Column(name = "SI_O_NO_EXONERADO_IMPUESTO_PREDIAL_TERRENO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String siONoExoneradoImpuestoPredialTerreno;
    
    @Column(name = "NUMERO_ANOS_EXONERACION_IMPUESTO_PREDIAL_TERRENO", columnDefinition="NUMBER(20) NOT NULL")
    private Long numeroAnosExoneracionImpuestoPredialTerreno;
    
    @Column(name = "OBSERVACIONES_TERRENO", columnDefinition="CLOB NULL")
    private String observacionesTerreno;
    
    @Column(name = "FECHA_H_M_S_ALTA_TERRENO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSAltaTerreno;
    
    @Column(name = "FECHA_H_M_S_INGRESO_TERRENO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoTerreno;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_TERRENO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionTerreno;
    
    //@Column(name = "ID_ESTADO_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEstadoTerreno;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ESTADO_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    private EstadoTerreno estadoTerreno;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdTerreno() {
        return idTerreno;
    }
    public void setIdTerreno(Long idTerreno) {
        this.idTerreno = idTerreno;
    }
    public String getDenominacionTerreno() {
        return denominacionTerreno;
    }
    public void setDenominacionTerreno(String denominacionTerreno) {
        this.denominacionTerreno = denominacionTerreno;
    }
    public String getNumeroInventarioTerreno() {
        return numeroInventarioTerreno;
    }
    public void setNumeroInventarioTerreno(String numeroInventarioTerreno) {
        this.numeroInventarioTerreno = numeroInventarioTerreno;
    }
    public String getNumeroActivoFijoTerreno() {
        return numeroActivoFijoTerreno;
    }
    public void setNumeroActivoFijoTerreno(String numeroActivoFijoTerreno) {
        this.numeroActivoFijoTerreno = numeroActivoFijoTerreno;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public SociedadUnidadCentralizadora getSociedadUnidadCentralizadora() {
        return sociedadUnidadCentralizadora;
    }
    public void setSociedadUnidadCentralizadora(SociedadUnidadCentralizadora sociedadUnidadCentralizadora) {
        this.sociedadUnidadCentralizadora = sociedadUnidadCentralizadora;
    }
    public String getNumeroCatastralTerreno() {
        return numeroCatastralTerreno;
    }
    public void setNumeroCatastralTerreno(String numeroCatastralTerreno) {
        this.numeroCatastralTerreno = numeroCatastralTerreno;
    }
    public String getNumeroEscrituraTerreno() {
        return numeroEscrituraTerreno;
    }
    public void setNumeroEscrituraTerreno(String numeroEscrituraTerreno) {
        this.numeroEscrituraTerreno = numeroEscrituraTerreno;
    }
    public String getNumeroNotariaTerreno() {
        return numeroNotariaTerreno;
    }
    public void setNumeroNotariaTerreno(String numeroNotariaTerreno) {
        this.numeroNotariaTerreno = numeroNotariaTerreno;
    }
    public String getLugarUbicacionNotariaTerreno() {
        return lugarUbicacionNotariaTerreno;
    }
    public void setLugarUbicacionNotariaTerreno(String lugarUbicacionNotariaTerreno) {
        this.lugarUbicacionNotariaTerreno = lugarUbicacionNotariaTerreno;
    }
    public Date getFechaHMSMatriculaTerreno() {
        return fechaHMSMatriculaTerreno;
    }
    public void setFechaHMSMatriculaTerreno(Date fechaHMSMatriculaTerreno) {
        this.fechaHMSMatriculaTerreno = fechaHMSMatriculaTerreno;
    }
    public String getPaisOrigenTerreno() {
        return paisOrigenTerreno;
    }
    public void setPaisOrigenTerreno(String paisOrigenTerreno) {
        this.paisOrigenTerreno = paisOrigenTerreno;
    }
    public String getDepartamentoOEstadoOrigenTerreno() {
        return departamentoOEstadoOrigenTerreno;
    }
    public void setDepartamentoOEstadoOrigenTerreno(String departamentoOEstadoOrigenTerreno) {
        this.departamentoOEstadoOrigenTerreno = departamentoOEstadoOrigenTerreno;
    }
    public String getCiudadOrigenTerreno() {
        return ciudadOrigenTerreno;
    }
    public void setCiudadOrigenTerreno(String ciudadOrigenTerreno) {
        this.ciudadOrigenTerreno = ciudadOrigenTerreno;
    }
    public String getDireccionTerreno() {
        return direccionTerreno;
    }
    public void setDireccionTerreno(String direccionTerreno) {
        this.direccionTerreno = direccionTerreno;
    }
    public String getLatitudTerreno() {
        return latitudTerreno;
    }
    public void setLatitudTerreno(String latitudTerreno) {
        this.latitudTerreno = latitudTerreno;
    }
    public String getLongitudTerreno() {
        return longitudTerreno;
    }
    public void setLongitudTerreno(String longitudTerreno) {
        this.longitudTerreno = longitudTerreno;
    }
    public String getNumeroAreaTerreno() {
        return numeroAreaTerreno;
    }
    public void setNumeroAreaTerreno(String numeroAreaTerreno) {
        this.numeroAreaTerreno = numeroAreaTerreno;
    }
    public String getNombreUnidadMedidaTerreno() {
        return nombreUnidadMedidaTerreno;
    }
    public void setNombreUnidadMedidaTerreno(String nombreUnidadMedidaTerreno) {
        this.nombreUnidadMedidaTerreno = nombreUnidadMedidaTerreno;
    }
    public String getSiONoExoneradoImpuestoPredialTerreno() {
        return siONoExoneradoImpuestoPredialTerreno;
    }
    public void setSiONoExoneradoImpuestoPredialTerreno(String siONoExoneradoImpuestoPredialTerreno) {
        this.siONoExoneradoImpuestoPredialTerreno = siONoExoneradoImpuestoPredialTerreno;
    }
    public Long getNumeroAnosExoneracionImpuestoPredialTerreno() {
        return numeroAnosExoneracionImpuestoPredialTerreno;
    }
    public void setNumeroAnosExoneracionImpuestoPredialTerreno(Long numeroAnosExoneracionImpuestoPredialTerreno) {
        this.numeroAnosExoneracionImpuestoPredialTerreno = numeroAnosExoneracionImpuestoPredialTerreno;
    }
    public String getObservacionesTerreno() {
        return observacionesTerreno;
    }
    public void setObservacionesTerreno(String observacionesTerreno) {
        this.observacionesTerreno = observacionesTerreno;
    }
    public Date getFechaHMSAltaTerreno() {
        return fechaHMSAltaTerreno;
    }
    public void setFechaHMSAltaTerreno(Date fechaHMSAltaTerreno) {
        this.fechaHMSAltaTerreno = fechaHMSAltaTerreno;
    }
    public Date getFechaHMSIngresoTerreno() {
        return fechaHMSIngresoTerreno;
    }
    public void setFechaHMSIngresoTerreno(Date fechaHMSIngresoTerreno) {
        this.fechaHMSIngresoTerreno = fechaHMSIngresoTerreno;
    }
    public Date getFechaHMSModificacionTerreno() {
        return fechaHMSModificacionTerreno;
    }
    public void setFechaHMSModificacionTerreno(Date fechaHMSModificacionTerreno) {
        this.fechaHMSModificacionTerreno = fechaHMSModificacionTerreno;
    }
    public EstadoTerreno getEstadoTerreno() {
        return estadoTerreno;
    }
    public void setEstadoTerreno(EstadoTerreno estadoTerreno) {
        this.estadoTerreno = estadoTerreno;
    }*/
}
