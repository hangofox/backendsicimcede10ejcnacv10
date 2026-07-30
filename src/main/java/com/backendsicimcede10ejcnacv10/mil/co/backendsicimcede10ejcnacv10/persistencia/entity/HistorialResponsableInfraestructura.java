//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_RESPONSABLES_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialResponsableInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_RESPONSABLE_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialResponsableInfraestructura;
    
    @Column(name = "NUM_REG_HISTORIAL_RESPONSABLE_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialResponsableInfraestructura;
    
    @Column(name = "SIGLA_O_ACRONIMO_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(250) NOT NULL")
    private String siglaOAcronimoUnidadMilitar;
    
    @Column(name = "NOMBRE_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String nombreTipoDocumentoIdentificacion;
    
    @Column(name = "NUMERO_DOCUMENTO_IDENTIFICACION_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numeroDocumentoIdentificacionResponsable;
    
    @Column(name = "LUGAR_EXPEDICION_DOCUMENTO_IDENTIFICACION_RESPONSABLE", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String lugarExpedicionDocumentoIdentificacionResponsable;
    
    @Column(name = "GRADO_RESPONSABLE", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoResponsable;
    
    @Column(name = "NOMBRES_RESPONSABLE", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String nombresResponsable;
    
    @Column(name = "PRIMER_APELLIDO_RESPONSABLE", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String primerApellidoResponsable;
    
    @Column(name = "SEGUNDO_APELLIDO_RESPONSABLE", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoResponsable;
    
    @Column(name = "SI_O_NO_ACTUAL_RESPONSABLE_PREDETERMINADO", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String siONoActualResponsablePredeterminado;
    
    @Column(name = "NUMERO_CURSO_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String numeroCursoResponsable;
    
    @Column(name = "PUESTO_CURSO_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String puestoCursoResponsable;
    
    @Column(name = "ESCALAFON_ANTIGUEDAD_RESPONSABLE", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String escalafonAntiguedadResponsable;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    @Column(name = "FECHA_H_M_S_INGRESO_RESPONSABLE", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoResponsable;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_RESPONSABLE", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionResponsable;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialResponsableInfraestructura() {
        return idHistorialResponsableInfraestructura;
    }
    public void setIdHistorialResponsableInfraestructura(Long idHistorialResponsableInfraestructura) {
        this.idHistorialResponsableInfraestructura = idHistorialResponsableInfraestructura;
    }
    public String getNumRegHistorialResponsableInfraestructura() {
        return numRegHistorialResponsableInfraestructura;
    }
    public void setNumRegHistorialResponsableInfraestructura(String numRegHistorialResponsableInfraestructura) {
        this.numRegHistorialResponsableInfraestructura = numRegHistorialResponsableInfraestructura;
    }
    public String getSiglaOAcronimoUnidadMilitar() {
        return siglaOAcronimoUnidadMilitar;
    }
    public void setSiglaOAcronimoUnidadMilitar(String siglaOAcronimoUnidadMilitar) {
        this.siglaOAcronimoUnidadMilitar = siglaOAcronimoUnidadMilitar;
    }
    public String getNombreTipoDocumentoIdentificacion() {
        return nombreTipoDocumentoIdentificacion;
    }
    public void setNombreTipoDocumentoIdentificacion(String nombreTipoDocumentoIdentificacion) {
        this.nombreTipoDocumentoIdentificacion = nombreTipoDocumentoIdentificacion;
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
    public String getSiONoActualResponsablePredeterminado() {
        return siONoActualResponsablePredeterminado;
    }
    public void setSiONoActualResponsablePredeterminado(String siONoActualResponsablePredeterminado) {
        this.siONoActualResponsablePredeterminado = siONoActualResponsablePredeterminado;
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
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
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
        this.fechaHMSModificacionResponsable = fechaHMSModificacionResponsable;
    }*/
}
