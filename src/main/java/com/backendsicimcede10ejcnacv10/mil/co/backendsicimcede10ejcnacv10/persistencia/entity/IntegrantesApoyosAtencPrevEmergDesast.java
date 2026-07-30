//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_INTEGRANTES_APOYOS_ATENC_PREV_EMERG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class IntegrantesApoyosAtencPrevEmergDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INTEGRANTES_APOYOS_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idIntegrantesApoyosAtencPrevEmergDesast;
    
    //@Column(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoAtencPrevEmergDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast;
    
    @Column(name = "GRADO_JEFE_GESTION_RIESGO_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeGestionRiesgoUnidadMilitar;
    
    @Column(name = "NOMBRES_JEFE_GESTION_RIESGO_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeGestionRiesgoUnidadMilitar;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_GESTION_RIESGO_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeGestionRiesgoUnidadMilitar;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_GESTION_RIESGO_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeGestionRiesgoUnidadMilitar;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_GESTION_RIESGO_UNIDAD_MILITAR", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar;
    
    @Column(name = "CARGO_JEFE_GESTION_RIESGO_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeGestionRiesgoUnidadMilitar;
    
    @Column(name = "GRADO_JEFE_OPERACIONES_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeOperacionesUnidadMilitar;
    
    @Column(name = "NOMBRES_JEFE_OPERACIONES_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeOperacionesUnidadMilitar;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_OPERACIONES_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeOperacionesUnidadMilitar;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_OPERACIONES_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeOperacionesUnidadMilitar;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_OPERACIONES_UNIDAD_MILITAR", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeOperacionesUnidadMilitar;
    
    @Column(name = "CARGO_JEFE_OPERACIONES_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeOperacionesUnidadMilitar;
    
    @Column(name = "GRADO_CTE_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoCteUnidadMilitar;
    
    @Column(name = "NOMBRES_CTE_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresCteUnidadMilitar;
    
    @Column(name = "PRIMER_APELLIDO_CTE_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoCteUnidadMilitar;
    
    @Column(name = "SEGUNDO_APELLIDO_CTE_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoCteUnidadMilitar;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_CTE_UNIDAD_MILITAR", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaCteUnidadMilitar;
    
    @Column(name = "CARGO_CTE_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoCteUnidadMilitar;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdIntegrantesApoyosAtencPrevEmergDesast() {
        return idIntegrantesApoyosAtencPrevEmergDesast;
    }
    public void setIdIntegrantesApoyosAtencPrevEmergDesast(Long idIntegrantesApoyosAtencPrevEmergDesast) {
        this.idIntegrantesApoyosAtencPrevEmergDesast = idIntegrantesApoyosAtencPrevEmergDesast;
    }
    public ApoyoAtencPrevEmergDesast getApoyoAtencPrevEmergDesast() {
        return apoyoAtencPrevEmergDesast;
    }
    public void setApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast) {
        this.apoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesast;
    }
    public String getGradoJefeGestionRiesgoUnidadMilitar() {
        return gradoJefeGestionRiesgoUnidadMilitar;
    }
    public void setGradoJefeGestionRiesgoUnidadMilitar(String gradoJefeGestionRiesgoUnidadMilitar) {
        this.gradoJefeGestionRiesgoUnidadMilitar = gradoJefeGestionRiesgoUnidadMilitar;
    }
    public String getNombresJefeGestionRiesgoUnidadMilitar() {
        return nombresJefeGestionRiesgoUnidadMilitar;
    }
    public void setNombresJefeGestionRiesgoUnidadMilitar(String nombresJefeGestionRiesgoUnidadMilitar) {
        this.nombresJefeGestionRiesgoUnidadMilitar = nombresJefeGestionRiesgoUnidadMilitar;
    }
    public String getPrimerApellidoJefeGestionRiesgoUnidadMilitar() {
        return primerApellidoJefeGestionRiesgoUnidadMilitar;
    }
    public void setPrimerApellidoJefeGestionRiesgoUnidadMilitar(String primerApellidoJefeGestionRiesgoUnidadMilitar) {
        this.primerApellidoJefeGestionRiesgoUnidadMilitar = primerApellidoJefeGestionRiesgoUnidadMilitar;
    }
    public String getSegundoApellidoJefeGestionRiesgoUnidadMilitar() {
        return segundoApellidoJefeGestionRiesgoUnidadMilitar;
    }
    public void setSegundoApellidoJefeGestionRiesgoUnidadMilitar(String segundoApellidoJefeGestionRiesgoUnidadMilitar) {
        this.segundoApellidoJefeGestionRiesgoUnidadMilitar = segundoApellidoJefeGestionRiesgoUnidadMilitar;
    }
    public String getNombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar() {
        return nombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar;
    }
    public void setNombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar(String nombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar) {
        this.nombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar = nombreArchivoFotoFirmaJefeGestionRiesgoUnidadMilitar;
    }
    public String getCargoJefeGestionRiesgoUnidadMilitar() {
        return cargoJefeGestionRiesgoUnidadMilitar;
    }
    public void setCargoJefeGestionRiesgoUnidadMilitar(String cargoJefeGestionRiesgoUnidadMilitar) {
        this.cargoJefeGestionRiesgoUnidadMilitar = cargoJefeGestionRiesgoUnidadMilitar;
    }
    public String getGradoJefeOperacionesUnidadMilitar() {
        return gradoJefeOperacionesUnidadMilitar;
    }
    public void setGradoJefeOperacionesUnidadMilitar(String gradoJefeOperacionesUnidadMilitar) {
        this.gradoJefeOperacionesUnidadMilitar = gradoJefeOperacionesUnidadMilitar;
    }
    public String getNombresJefeOperacionesUnidadMilitar() {
        return nombresJefeOperacionesUnidadMilitar;
    }
    public void setNombresJefeOperacionesUnidadMilitar(String nombresJefeOperacionesUnidadMilitar) {
        this.nombresJefeOperacionesUnidadMilitar = nombresJefeOperacionesUnidadMilitar;
    }
    public String getPrimerApellidoJefeOperacionesUnidadMilitar() {
        return primerApellidoJefeOperacionesUnidadMilitar;
    }
    public void setPrimerApellidoJefeOperacionesUnidadMilitar(String primerApellidoJefeOperacionesUnidadMilitar) {
        this.primerApellidoJefeOperacionesUnidadMilitar = primerApellidoJefeOperacionesUnidadMilitar;
    }
    public String getSegundoApellidoJefeOperacionesUnidadMilitar() {
        return segundoApellidoJefeOperacionesUnidadMilitar;
    }
    public void setSegundoApellidoJefeOperacionesUnidadMilitar(String segundoApellidoJefeOperacionesUnidadMilitar) {
        this.segundoApellidoJefeOperacionesUnidadMilitar = segundoApellidoJefeOperacionesUnidadMilitar;
    }
    public String getNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar() {
        return nombreArchivoFotoFirmaJefeOperacionesUnidadMilitar;
    }
    public void setNombreArchivoFotoFirmaJefeOperacionesUnidadMilitar(String nombreArchivoFotoFirmaJefeOperacionesUnidadMilitar) {
        this.nombreArchivoFotoFirmaJefeOperacionesUnidadMilitar = nombreArchivoFotoFirmaJefeOperacionesUnidadMilitar;
    }
    public String getCargoJefeOperacionesUnidadMilitar() {
        return cargoJefeOperacionesUnidadMilitar;
    }
    public void setCargoJefeOperacionesUnidadMilitar(String cargoJefeOperacionesUnidadMilitar) {
        this.cargoJefeOperacionesUnidadMilitar = cargoJefeOperacionesUnidadMilitar;
    }
    public String getGradoCteUnidadMilitar() {
        return gradoCteUnidadMilitar;
    }
    public void setGradoCteUnidadMilitar(String gradoCteUnidadMilitar) {
        this.gradoCteUnidadMilitar = gradoCteUnidadMilitar;
    }
    public String getNombresCteUnidadMilitar() {
        return nombresCteUnidadMilitar;
    }
    public void setNombresCteUnidadMilitar(String nombresCteUnidadMilitar) {
        this.nombresCteUnidadMilitar = nombresCteUnidadMilitar;
    }
    public String getPrimerApellidoCteUnidadMilitar() {
        return primerApellidoCteUnidadMilitar;
    }
    public void setPrimerApellidoCteUnidadMilitar(String primerApellidoCteUnidadMilitar) {
        this.primerApellidoCteUnidadMilitar = primerApellidoCteUnidadMilitar;
    }
    public String getSegundoApellidoCteUnidadMilitar() {
        return segundoApellidoCteUnidadMilitar;
    }
    public void setSegundoApellidoCteUnidadMilitar(String segundoApellidoCteUnidadMilitar) {
        this.segundoApellidoCteUnidadMilitar = segundoApellidoCteUnidadMilitar;
    }
    public String getNombreArchivoFotoFirmaCteUnidadMilitar() {
        return nombreArchivoFotoFirmaCteUnidadMilitar;
    }
    public void setNombreArchivoFotoFirmaCteUnidadMilitar(String nombreArchivoFotoFirmaCteUnidadMilitar) {
        this.nombreArchivoFotoFirmaCteUnidadMilitar = nombreArchivoFotoFirmaCteUnidadMilitar;
    }
    public String getCargoCteUnidadMilitar() {
        return cargoCteUnidadMilitar;
    }
    public void setCargoCteUnidadMilitar(String cargoCteUnidadMilitar) {
        this.cargoCteUnidadMilitar = cargoCteUnidadMilitar;
    }*/
}
