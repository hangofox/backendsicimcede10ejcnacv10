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
@Table(name = "TABLA_INTEGRANTES_APOYOS_OBR_RED_MITIG_GEST_RIESG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class IntegrantesApoyosObrRedMitigGestRiesgDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INTEGRANTES_APOYOS_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idIntegrantesApoyosObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoObrRedMitigGestRiesgDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "GRADO_JEFE_SECCION_TECNICA_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeSeccionTecnicaUnidadMilitar;
    
    @Column(name = "NOMBRES_JEFE_SECCION_TECNICA_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeSeccionTecnicaUnidadMilitar;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_SECCION_TECNICA_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeSeccionTecnicaUnidadMilitar;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_SECCION_TECNICA_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeSeccionTecnicaUnidadMilitar;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_SECCION_TECNICA_UNIDAD_MILITAR", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar;
    
    @Column(name = "CARGO_JEFE_SECCION_TECNICA_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeSeccionTecnicaUnidadMilitar;
    
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
    public Long getIdIntegrantesApoyosObrRedMitigGestRiesgDesast() {
        return idIntegrantesApoyosObrRedMitigGestRiesgDesast;
    }
    public void setIdIntegrantesApoyosObrRedMitigGestRiesgDesast(Long idIntegrantesApoyosObrRedMitigGestRiesgDesast) {
        this.idIntegrantesApoyosObrRedMitigGestRiesgDesast = idIntegrantesApoyosObrRedMitigGestRiesgDesast;
    }
    public ApoyoObrRedMitigGestRiesgDesast getApoyoObrRedMitigGestRiesgDesast() {
        return apoyoObrRedMitigGestRiesgDesast;
    }
    public void setApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast) {
        this.apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesast;
    }
    public String getGradoJefeSeccionTecnicaUnidadMilitar() {
        return gradoJefeSeccionTecnicaUnidadMilitar;
    }
    public void setGradoJefeSeccionTecnicaUnidadMilitar(String gradoJefeSeccionTecnicaUnidadMilitar) {
        this.gradoJefeSeccionTecnicaUnidadMilitar = gradoJefeSeccionTecnicaUnidadMilitar;
    }
    public String getNombresJefeSeccionTecnicaUnidadMilitar() {
        return nombresJefeSeccionTecnicaUnidadMilitar;
    }
    public void setNombresJefeSeccionTecnicaUnidadMilitar(String nombresJefeSeccionTecnicaUnidadMilitar) {
        this.nombresJefeSeccionTecnicaUnidadMilitar = nombresJefeSeccionTecnicaUnidadMilitar;
    }
    public String getPrimerApellidoJefeSeccionTecnicaUnidadMilitar() {
        return primerApellidoJefeSeccionTecnicaUnidadMilitar;
    }
    public void setPrimerApellidoJefeSeccionTecnicaUnidadMilitar(String primerApellidoJefeSeccionTecnicaUnidadMilitar) {
        this.primerApellidoJefeSeccionTecnicaUnidadMilitar = primerApellidoJefeSeccionTecnicaUnidadMilitar;
    }
    public String getSegundoApellidoJefeSeccionTecnicaUnidadMilitar() {
        return segundoApellidoJefeSeccionTecnicaUnidadMilitar;
    }
    public void setSegundoApellidoJefeSeccionTecnicaUnidadMilitar(String segundoApellidoJefeSeccionTecnicaUnidadMilitar) {
        this.segundoApellidoJefeSeccionTecnicaUnidadMilitar = segundoApellidoJefeSeccionTecnicaUnidadMilitar;
    }
    public String getNombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar() {
        return nombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar;
    }
    public void setNombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar(String nombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar) {
        this.nombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar = nombreArchivoFotoFirmaJefeSeccionTecnicaUnidadMilitar;
    }
    public String getCargoJefeSeccionTecnicaUnidadMilitar() {
        return cargoJefeSeccionTecnicaUnidadMilitar;
    }
    public void setCargoJefeSeccionTecnicaUnidadMilitar(String cargoJefeSeccionTecnicaUnidadMilitar) {
        this.cargoJefeSeccionTecnicaUnidadMilitar = cargoJefeSeccionTecnicaUnidadMilitar;
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
