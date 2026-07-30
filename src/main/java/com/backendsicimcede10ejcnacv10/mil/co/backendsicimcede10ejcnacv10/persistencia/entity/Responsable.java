//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_RESPONSABLES")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class Responsable {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_RESPONSABLE", columnDefinition="NUMBER(20) NOT NULL")
    private Long idResponsable;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "USUARIO_RED_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String usuarioRedResponsable;
    
    //@Column(name = "ID_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDocumentoIdentificacion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @OneToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDocumentoIdentificacion tipoDocumentoIdentificacion;
    
    @Column(name = "NUMERO_DOCUMENTO_IDENTIFICACION_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numeroDocumentoIdentificacionResponsable;
    
    @Column(name = "LUGAR_EXPEDICION_DOCUMENTO_IDENTIFICACION_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String lugarExpedicionDocumentoIdentificacionResponsable;
    
    @Column(name = "GRADO_RESPONSABLE", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoResponsable;
    
    @Column(name = "NOMBRES_RESPONSABLE", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String nombresResponsable;
    
    @Column(name = "PRIMER_APELLIDO_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String primerApellidoResponsable;
    
    @Column(name = "SEGUNDO_APELLIDO_RESPONSABLE", columnDefinition = "VARCHAR2(150) NULL")
    private String segundoApellidoResponsable;
    
    @Column(name = "ARMA_RESPONSABLE", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String armaResponsable;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_RESPONSABLE", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionoFormatoResponsable;
    
    @Column(name = "FECHA_H_M_S_NACIMIENTO_RESPONSABLE", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSNacimientoResponsable;
    
    @Column(name = "SEXO_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String sexoResponsable;
    
    @Column(name = "DIRECCION_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String direccionResponsable;
    
    @Column(name = "TELEFONO_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String telefonoResponsable;
    
    @Column(name = "MOVIL_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String movilResponsable;
    
    @Column(name = "CORREO_ELECTRONICO_PERSONAL_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String correoElectronicoPersonalResponsable;
    
    @Column(name = "CORREO_ELECTRONICO_INSTITUCIONAL_RESPONSABLE", columnDefinition = "VARCHAR2(150) NULL")
    private String correoElectronicoInstitucionalResponsable;
    
    @Column(name = "PAIS_ORIGEN_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String paisOrigenResponsable;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String departamentooEstadoOrigenResponsable;
    
    @Column(name = "CIUDAD_ORIGEN_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String ciudadOrigenResponsable;
    
    @Column(name = "NUMERO_CURSO_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String numeroCursoResponsable;
    
    @Column(name = "PUESTO_CURSO_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String puestoCursoResponsable;
    
    @Column(name = "ESCALAFON_ANTIGUEDAD_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String escalafonAntiguedadResponsable;
    
    @Column(name = "FECHA_H_M_S_INCORPORACION_FFMM_RESPONSABLE", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIncorporacionFFMMResponsable;
    
    @Column(name = "FECHA_H_M_S_INGRESO_RESPONSABLE", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoResponsable;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_RESPONSABLE", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionResponsable;
    
    @Column(name = "ESTADO_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String estadoResponsable;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdResponsable() {
        return idResponsable;
    }
    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getUsuarioRedResponsable() {
        return usuarioRedResponsable;
    }
    public void setUsuarioRedResponsable(String usuarioRedResponsable) {
        this.usuarioRedResponsable = usuarioRedResponsable;
    }
    public TipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
        return tipoDocumentoIdentificacion;
    }
    public void setTipoDocumentoIdentificacion(TipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }
    public String getNumeroDocumentoIdentificacionResponsable() {
        return numeroDocumentoIdentificacionResponsable;
    }
    public void setNumeroDocumentoIdentificacionResponsable(String numeroDocumentoIdentificacionResponsable) {
        this.numeroDocumentoIdentificacionResponsable = numeroDocumentoIdentificacionResponsable;
    }
    public String getLugarExpedicionDocumentoIdentificacionResponsable() {
        return lugarExpedicionDocumentoIdentificacionResponsable;
    }
    public void setLugarExpedicionDocumentoIdentificacionResponsable(String lugarExpedicionDocumentoIdentificacionResponsable) {
        this.lugarExpedicionDocumentoIdentificacionResponsable = lugarExpedicionDocumentoIdentificacionResponsable;
    }
    public String getGradoResponsable() {
        return gradoResponsable;
    }
    public void setGradoResponsable(String gradoResponsable) {
        this.gradoResponsable = gradoResponsable;
    }
    public String getNombresResponsable() {
        return nombresResponsable;
    }
    public void setNombresResponsable(String nombresResponsable) {
        this.nombresResponsable = nombresResponsable;
    }
    public String getPrimerApellidoResponsable() {
        return primerApellidoResponsable;
    }
    public void setPrimerApellidoResponsable(String primerApellidoResponsable) {
        this.primerApellidoResponsable = primerApellidoResponsable;
    }
    public String getSegundoApellidoResponsable() {
        return segundoApellidoResponsable;
    }
    public void setSegundoApellidoResponsable(String segundoApellidoResponsable) {
        this.segundoApellidoResponsable = segundoApellidoResponsable;
    }
    public String getArmaResponsable() {
        return armaResponsable;
    }
    public void setArmaResponsable(String armaResponsable) {
        this.armaResponsable = armaResponsable;
    }
    public String getNombreArchivoFotoExtensionoFormatoResponsable() {
        return nombreArchivoFotoExtensionoFormatoResponsable;
    }
    public void setNombreArchivoFotoExtensionoFormatoResponsable(String nombreArchivoFotoExtensionoFormatoResponsable) {
        this.nombreArchivoFotoExtensionoFormatoResponsable = nombreArchivoFotoExtensionoFormatoResponsable;
    }
    public Date getFechaHMSNacimientoResponsable() {
        return fechaHMSNacimientoResponsable;
    }
    public void setFechaHMSNacimientoResponsable(Date fechaHMSNacimientoResponsable) {
        this.fechaHMSNacimientoResponsable = fechaHMSNacimientoResponsable;
    }
    public String getSexoResponsable() {
        return sexoResponsable;
    }
    public void setSexoResponsable(String sexoResponsable) {
        this.sexoResponsable = sexoResponsable;
    }
    public String getDireccionResponsable() {
        return direccionResponsable;
    }
    public void setDireccionResponsable(String direccionResponsable) {
        this.direccionResponsable = direccionResponsable;
    }
    public String getTelefonoResponsable() {
        return telefonoResponsable;
    }
    public void setTelefonoResponsable(String telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }
    public String getMovilResponsable() {
        return movilResponsable;
    }
    public void setMovilResponsable(String movilResponsable) {
        this.movilResponsable = movilResponsable;
    }
    public String getCorreoElectronicoPersonalResponsable() {
        return correoElectronicoPersonalResponsable;
    }
    public void setCorreoElectronicoPersonalResponsable(String correoElectronicoPersonalResponsable) {
        this.correoElectronicoPersonalResponsable = correoElectronicoPersonalResponsable;
    }
    public String getCorreoElectronicoInstitucionalResponsable() {
        return correoElectronicoInstitucionalResponsable;
    }
    public void setCorreoElectronicoInstitucionalResponsable(String correoElectronicoInstitucionalResponsable) {
        this.correoElectronicoInstitucionalResponsable = correoElectronicoInstitucionalResponsable;
    }
    public String getPaisOrigenResponsable() {
        return paisOrigenResponsable;
    }
    public void setPaisOrigenResponsable(String paisOrigenResponsable) {
        this.paisOrigenResponsable = paisOrigenResponsable;
    }
    public String getDepartamentooEstadoOrigenResponsable() {
        return departamentooEstadoOrigenResponsable;
    }
    public void setDepartamentooEstadoOrigenResponsable(String departamentooEstadoOrigenResponsable) {
        this.departamentooEstadoOrigenResponsable = departamentooEstadoOrigenResponsable;
    }
    public String getCiudadOrigenResponsable() {
        return ciudadOrigenResponsable;
    }
    public void setCiudadOrigenResponsable(String ciudadOrigenResponsable) {
        this.ciudadOrigenResponsable = ciudadOrigenResponsable;
    }
    public String getNumeroCursoResponsable() {
        return numeroCursoResponsable;
    }
    public void setNumeroCursoResponsable(String numeroCursoResponsable) {
        this.numeroCursoResponsable = numeroCursoResponsable;
    }
    public String getPuestoCursoResponsable() {
        return puestoCursoResponsable;
    }
    public void setPuestoCursoResponsable(String puestoCursoResponsable) {
        this.puestoCursoResponsable = puestoCursoResponsable;
    }
    public String getEscalafonAntiguedadResponsable() {
        return escalafonAntiguedadResponsable;
    }
    public void setEscalafonAntiguedadResponsable(String escalafonAntiguedadResponsable) {
        this.escalafonAntiguedadResponsable = escalafonAntiguedadResponsable;
    }
    public Date getFechaHMSIncorporacionFFMMResponsable() {
        return fechaHMSIncorporacionFFMMResponsable;
    }
    public void setFechaHMSIncorporacionFFMMResponsable(Date fechaHMSIncorporacionFFMMResponsable) {
        this.fechaHMSIncorporacionFFMMResponsable = fechaHMSIncorporacionFFMMResponsable;
    }
    public Date getFechaHMSIngresoResponsable() {
        return fechaHMSIngresoResponsable;
    }
    public void setFechaHMSIngresoResponsable(Date fechaHMSIngresoResponsable) {
        this.fechaHMSIngresoResponsable = fechaHMSIngresoResponsable;
    }
    public Date getFechaHMSModificacionResponsable() {
        return fechaHMSModificacionResponsable;
    }
    public void setFechaHMSModificacionResponsable(Date fechaHMSModificacionResponsable) {
        this.fechaHMSModificacionResponsable = fechaHMSModifciacionResponsable;
    }
    public String getEstadoResponsable() {
        return estadoResponsable;
    }
    public void setEstadoResponsable(String estadoResponsable) {
        this.estadoResponsable = estadoResponsable;
    }*/
}
