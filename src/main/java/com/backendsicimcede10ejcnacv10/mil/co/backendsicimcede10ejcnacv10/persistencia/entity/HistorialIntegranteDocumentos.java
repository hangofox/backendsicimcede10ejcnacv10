//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_INTEGRANTES_DOCUMENTOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialIntegranteDocumentos {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_INTEGRANTE_DOCUMENTOS", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialIntegranteDocumentos;
    
    @Column(name = "NUM_REG_HISTORIAL_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialIntegranteDocumentos;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "GRADO_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(255) NOT NULL")
    private String gradoIntegranteDocumentos;
    
    @Column(name = "NOMBRES_Y_APELLIDOS_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombresYApellidosIntegranteDocumentos;
    
    @Column(name = "CARGO_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(255) NOT NULL")
    private String cargoIntegranteDocumentos;
    
    //@Column(name = "ID_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDocumentoIdentificacion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDocumentoIdentificacion tipoDocumentoIdentificacion;
    
    @Column(name = "NUMERO_DOCUMENTO_IDENTIFICACION_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numeroDocumentoIdentificacionIntegranteDocumentos;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_INTEGRANTE_DOCUMENTOS", columnDefinition="CLOB NULL")
    private String nombreArchivoFotoFirmaIntegranteDocumentos;
    
    //@Column(name = "ID_CARGO_INTEGRANTE_DOCUMENTOS", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idCargoIntegranteDocumentos;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_CARGO_INTEGRANTE_DOCUMENTOS", columnDefinition = "NUMBER(20) NOT NULL")
    private CargoIntegranteDocumentos cargoIntegranteDocumentosFK;
    
    @Column(name = "SI_O_NO_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(50) NOT NULL")
    private String siONoIntegranteDocumentos;
    
    @Column(name = "SI_O_NO_ACTUAL_INTEGRANTE_DOCUMENTOS_PREDETERMINADO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String siONoActualIntegranteDocumentosPredeterminado;
    
    @Column(name = "NUMERO_CURSO_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroCursoIntegranteDocumentos;
    
    @Column(name = "PUESTO_CURSO_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(50) NOT NULL")
    private String puestoCursoIntegranteDocumentos;
    
    @Column(name = "ESCALAFON_ANTIGUEDAD_INTEGRANTE_DOCUMENTOS", columnDefinition="VARCHAR2(50) NOT NULL")
    private String escalafonAntiguedadIntegranteDocumentos;
    
    @Column(name = "FECHA_H_M_S_INGRESO_INTEGRANTE_DOCUMENTOS", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoIntegranteDocumentos;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_INTEGRANTE_DOCUMENTOS", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionIntegranteDocumentos;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialIntegranteDocumentos() {
        return idHistorialIntegranteDocumentos;
    }
    public void setIdHistorialIntegranteDocumentos(Long idHistorialIntegranteDocumentos) {
        this.idHistorialIntegranteDocumentos = idHistorialIntegranteDocumentos;
    }
    public String getNumRegHistorialIntegranteDocumentos() {
        return numRegHistorialIntegranteDocumentos;
    }
    public void setNumRegHistorialIntegranteDocumentos(String numRegHistorialIntegranteDocumentos) {
        this.numRegHistorialIntegranteDocumentos = numRegHistorialIntegranteDocumentos;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getGradoIntegranteDocumentos() {
        return gradoIntegranteDocumentos;
    }
    public void setGradoIntegranteDocumentos(String gradoIntegranteDocumentos) {
        this.gradoIntegranteDocumentos = gradoIntegranteDocumentos;
    }
    public String getNombresYApellidosIntegranteDocumentos() {
        return nombresYApellidosIntegranteDocumentos;
    }
    public void setNombresYApellidosIntegranteDocumentos(String nombresYApellidosIntegranteDocumentos) {
        this.nombresYApellidosIntegranteDocumentos = nombresYApellidosIntegranteDocumentos;
    }
    public String getCargoIntegranteDocumentos() {
        return cargoIntegranteDocumentos;
    }
    public void setCargoIntegranteDocumentos(String cargoIntegranteDocumentos) {
        this.cargoIntegranteDocumentos = cargoIntegranteDocumentos;
    }
    public TipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
        return tipoDocumentoIdentificacion;
    }
    public void setTipoDocumentoIdentificacion(TipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }
    public String getNumeroDocumentoIdentificacionIntegranteDocumentos() {
        return numeroDocumentoIdentificacionIntegranteDocumentos;
    }
    public void setNumeroDocumentoIdentificacionIntegranteDocumentos(String numeroDocumentoIdentificacionIntegranteDocumentos) {
        this.numeroDocumentoIdentificacionIntegranteDocumentos = numeroDocumentoIdentificacionIntegranteDocumentos;
    }
    public String getNombreArchivoFotoFirmaIntegranteDocumentos() {
        return nombreArchivoFotoFirmaIntegranteDocumentos;
    }
    public void setNombreArchivoFotoFirmaIntegranteDocumentos(String nombreArchivoFotoFirmaIntegranteDocumentos) {
        this.nombreArchivoFotoFirmaIntegranteDocumentos = nombreArchivoFotoFirmaIntegranteDocumentos;
    }
    public CargoIntegranteDocumentos getCargoIntegranteDocumentosFK() {
        return cargoIntegranteDocumentosFK;
    }
    public void setCargoIntegranteDocumentosFK(CargoIntegranteDocumentos cargoIntegranteDocumentosFK) {
        this.cargoIntegranteDocumentosFK = cargoIntegranteDocumentosFK;
    }
    public String getSiONoIntegranteDocumentos() {
        return siONoIntegranteDocumentos;
    }
    public void setSiONoIntegranteDocumentos(String siONoIntegranteDocumentos) {
        this.siONoIntegranteDocumentos = siONoIntegranteDocumentos;
    }
    public String getSiONoActualIntegranteDocumentosPredeterminado() {
        return siONoActualIntegranteDocumentosPredeterminado;
    }
    public void setSiONoActualIntegranteDocumentosPredeterminado(String siONoActualIntegranteDocumentosPredeterminado) {
        this.siONoActualIntegranteDocumentosPredeterminado = siONoActualIntegranteDocumentosPredeterminado;
    }
    public String getNumeroCursoIntegranteDocumentos() {
        return numeroCursoIntegranteDocumentos;
    }
    public void setNumeroCursoIntegranteDocumentos(String numeroCursoIntegranteDocumentos) {
        this.numeroCursoIntegranteDocumentos = numeroCursoIntegranteDocumentos;
    }
    public String getPuestoCursoIntegranteDocumentos() {
        return puestoCursoIntegranteDocumentos;
    }
    public void setPuestoCursoIntegranteDocumentos(String puestoCursoIntegranteDocumentos) {
        this.puestoCursoIntegranteDocumentos = puestoCursoIntegranteDocumentos;
    }
    public String getEscalafonAntiguedadIntegranteDocumentos() {
        return escalafonAntiguedadIntegranteDocumentos;
    }
    public void setEscalafonAntiguedadIntegranteDocumentos(String escalafonAntiguedadIntegranteDocumentos) {
        this.escalafonAntiguedadIntegranteDocumentos = escalafonAntiguedadIntegranteDocumentos;
    }
    public Date getFechaHMSIngresoIntegranteDocumentos() {
        return fechaHMSIngresoIntegranteDocumentos;
    }
    public void setFechaHMSIngresoIntegranteDocumentos(Date fechaHMSIngresoIntegranteDocumentos) {
        this.fechaHMSIngresoIntegranteDocumentos = fechaHMSIngresoIntegranteDocumentos;
    }
    public Date getFechaHMSModificacionIntegranteDocumentos() {
        return fechaHMSModificacionIntegranteDocumentos;
    }
    public void setFechaHMSModificacionIntegranteDocumentos(Date fechaHMSModificacionIntegranteDocumentos) {
        this.fechaHMSModificacionIntegranteDocumentos = fechaHMSModificacionIntegranteDocumentos;
    }*/
}
