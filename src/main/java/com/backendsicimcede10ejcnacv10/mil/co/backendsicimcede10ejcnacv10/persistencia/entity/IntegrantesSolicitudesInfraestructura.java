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
@Table(name = "TABLA_INTEGRANTES_SOLICITUDES_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class IntegrantesSolicitudesInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INTEGRANTES_SOLICITUDES_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idIntegrantesSolicitudesInfraestructura;
    
    //@Column(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSolicitudInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private SolicitudInfraestructura solicitudInfraestructura;
    
    @Column(name = "GRADO_JEFE_GESTION_INGENIEROS_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeGestionIngenierosBatallon;
    
    @Column(name = "NOMBRES_JEFE_GESTION_INGENIEROS_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeGestionIngenierosBatallon;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_GESTION_INGENIEROS_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeGestionIngenierosBatallon;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_GESTION_INGENIEROS_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeGestionIngenierosBatallon;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_GESTION_INGENIEROS_BATALLON", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeGestionIngenierosBatallon;
    
    @Column(name = "CARGO_JEFE_GESTION_INGENIEROS_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeGestionIngenierosBatallon;
    
    @Column(name = "GRADO_CTE_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoCteBatallon;
    
    @Column(name = "NOMBRES_CTE_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresCteBatallon;
    
    @Column(name = "PRIMER_APELLIDO_CTE_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoCteBatallon;
    
    @Column(name = "SEGUNDO_APELLIDO_CTE_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoCteBatallon;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_CTE_BATALLON", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaCteBatallon;
    
    @Column(name = "CARGO_CTE_BATALLON", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoCteBatallon;
    
    @Column(name = "GRADO_CTE_O_JEM_2DO_CTE_BR", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoCteOJem2doCteWBr;
    
    @Column(name = "NOMBRES_CTE_O_JEM_2DO_CTE_BR", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresCteOJem2doCteWBr;
    
    @Column(name = "PRIMER_APELLIDO_CTE_O_JEM_2DO_CTE_BR", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoCteOJem2doCteWBr;
    
    @Column(name = "SEGUNDO_APELLIDO_CTE_O_JEM_2DO_CTE_BR", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoCteOJem2doCteWBr;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_CTE_O_JEM_2DO_CTE_BR", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaCteOJem2doCteWBr;
    
    @Column(name = "CARGO_CTE_O_JEM_2DO_CTE_BR", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoCteOJem2doCteWBr;
    
    @Column(name = "GRADO_FINCA_RAIZ_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoFincaRaizDiv;
    
    @Column(name = "NOMBRES_FINCA_RAIZ_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresFincaRaizDiv;
    
    @Column(name = "PRIMER_APELLIDO_FINCA_RAIZ_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoFincaRaizDiv;
    
    @Column(name = "SEGUNDO_APELLIDO_FINCA_RAIZ_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoFincaRaizDiv;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_FINCA_RAIZ_DIV", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaFincaRaizDiv;
    
    @Column(name = "CARGO_FINCA_RAIZ_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoFincaRaizDiv;
    
    @Column(name = "GRADO_JEFE_GESTION_INGENIEROS_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeGestionIngenierosDiv;
    
    @Column(name = "NOMBRES_JEFE_GESTION_INGENIEROS_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeGestionIngenierosDiv;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_GESTION_INGENIEROS_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeGestionIngenierosDiv;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_GESTION_INGENIEROS_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeGestionIngenierosDiv;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_GESTION_INGENIEROS_DIV", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeGestionIngenierosDiv;
    
    @Column(name = "CARGO_JEFE_GESTION_INGENIEROS_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeGestionIngenierosDiv;
    
    @Column(name = "GRADO_CTE_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoCteDiv;
    
    @Column(name = "NOMBRES_CTE_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresCteDiv;
    
    @Column(name = "PRIMER_APELLIDO_CTE_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoCteDiv;
    
    @Column(name = "SEGUNDO_APELLIDO_CTE_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoCteDiv;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_CTE_DIV", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaCteDiv;
    
    @Column(name = "CARGO_CTE_DIV", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoCteDiv;
    
    @Column(name = "GRADO_FINCA_RAIZ_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoFincaRaizComando;
    
    @Column(name = "NOMBRES_FINCA_RAIZ_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresFincaRaizComando;
    
    @Column(name = "PRIMER_APELLIDO_FINCA_RAIZ_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoFincaRaizComando;
    
    @Column(name = "SEGUNDO_APELLIDO_FINCA_RAIZ_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoFincaRaizComando;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_FINCA_RAIZ_COMANDO", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaFincaRaizComando;
    
    @Column(name = "CARGO_FINCA_RAIZ_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoFincaRaizComando;
    
    @Column(name = "GRADO_JEFE_GESTION_INGENIEROS_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeGestionIngenierosComando;
    
    @Column(name = "NOMBRES_JEFE_GESTION_INGENIEROS_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeGestionIngenierosComando;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_GESTION_INGENIEROS_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeGestionIngenierosComando;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_GESTION_INGENIEROS_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeGestionIngenierosComando;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_GESTION_INGENIEROS_COMANDO", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeGestionIngenierosComando;
    
    @Column(name = "CARGO_JEFE_GESTION_INGENIEROS_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeGestionIngenierosComando;
    
    @Column(name = "GRADO_CTE_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoCteComando;
    
    @Column(name = "NOMBRES_CTE_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresCteComando;
    
    @Column(name = "PRIMER_APELLIDO_CTE_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoCteComando;
    
    @Column(name = "SEGUNDO_APELLIDO_CTE_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoCteComando;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_CTE_COMANDO", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaCteComando;
    
    @Column(name = "CARGO_CTE_COMANDO", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoCteComando;
    
    @Column(name = "GRADO_FINCA_RAIZ_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoFincaRaizCede;
    
    @Column(name = "NOMBRES_FINCA_RAIZ_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresFincaRaizCede;
    
    @Column(name = "PRIMER_APELLIDO_FINCA_RAIZ_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoFincaRaizCede;
    
    @Column(name = "SEGUNDO_APELLIDO_FINCA_RAIZ_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoFincaRaizCede;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_FINCA_RAIZ_CEDE", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaFincaRaizCede;
    
    @Column(name = "CARGO_FINCA_RAIZ_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoFincaRaizCede;
    
    @Column(name = "GRADO_JEFE_GESTION_INGENIEROS_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeGestionIngenierosCede;
    
    @Column(name = "NOMBRES_JEFE_GESTION_INGENIEROS_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeGestionIngenierosCede;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_GESTION_INGENIEROS_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeGestionIngenierosCede;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_GESTION_INGENIEROS_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeGestionIngenierosCede;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_GESTION_INGENIEROS_CEDE", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeGestionIngenierosCede;
    
    @Column(name = "CARGO_JEFE_GESTION_INGENIEROS_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeGestionIngenierosCede;
    
    @Column(name = "GRADO_CTE_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoCteCede;
    
    @Column(name = "NOMBRES_CTE_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresCteCede;
    
    @Column(name = "PRIMER_APELLIDO_CTE_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoCteCede;
    
    @Column(name = "SEGUNDO_APELLIDO_CTE_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoCteCede;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_CTE_CEDE", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaCteCede;
    
    @Column(name = "CARGO_CTE_CEDE", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoCteCede;
    
    @Column(name = "GRADO_FINCA_RAIZ_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoFincaRaizJef;
    
    @Column(name = "NOMBRES_FINCA_RAIZ_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresFincaRaizJef;
    
    @Column(name = "PRIMER_APELLIDO_FINCA_RAIZ_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoFincaRaizJef;
    
    @Column(name = "SEGUNDO_APELLIDO_FINCA_RAIZ_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoFincaRaizJef;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_FINCA_RAIZ_JEF", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaFincaRaizJef;
    
    @Column(name = "CARGO_FINCA_RAIZ_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoFincaRaizJef;
    
    @Column(name = "GRADO_JEFE_GESTION_INGENIEROS_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoJefeGestionIngenierosJef;
    
    @Column(name = "NOMBRES_JEFE_GESTION_INGENIEROS_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresJefeGestionIngenierosJef;
    
    @Column(name = "PRIMER_APELLIDO_JEFE_GESTION_INGENIEROS_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoJefeGestionIngenierosJef;
    
    @Column(name = "SEGUNDO_APELLIDO_JEFE_GESTION_INGENIEROS_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoJefeGestionIngenierosJef;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_JEFE_GESTION_INGENIEROS_JEF", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaJefeGestionIngenierosJef;
    
    @Column(name = "CARGO_JEFE_GESTION_INGENIEROS_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoJefeGestionIngenierosJef;
    
    @Column(name = "GRADO_CTE_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String gradoCteJef;
    
    @Column(name = "NOMBRES_CTE_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String nombresCteJef;
    
    @Column(name = "PRIMER_APELLIDO_CTE_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String primerApellidoCteJef;
    
    @Column(name = "SEGUNDO_APELLIDO_CTE_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoCteJef;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_CTE_JEF", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoFotoFirmaCteJef;
    
    @Column(name = "CARGO_CTE_JEF", columnDefinition = "VARCHAR2(255) NULL")
    private String cargoCteJef;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdIntegrantesSolicitudesInfraestructura() {
        return idIntegrantesSolicitudesInfraestructura;
    }
    public void setIdIntegrantesSolicitudesInfraestructura(Long idIntegrantesSolicitudesInfraestructura) {
        this.idIntegrantesSolicitudesInfraestructura = idIntegrantesSolicitudesInfraestructura;
    }
    public SolicitudInfraestructura getSolicitudInfraestructura() {
        return solicitudInfraestructura;
    }
    public void setSolicitudInfraestructura(SolicitudInfraestructura solicitudInfraestructura) {
        this.solicitudInfraestructura = solicitudInfraestructura;
    }
    public String getGradoJefeGestionIngenierosBatallon() {
        return gradoJefeGestionIngenierosBatallon;
    }
    public void setGradoJefeGestionIngenierosBatallon(String gradoJefeGestionIngenierosBatallon) {
        this.gradoJefeGestionIngenierosBatallon = gradoJefeGestionIngenierosBatallon;
    }
    public String getNombresJefeGestionIngenierosBatallon() {
        return nombresJefeGestionIngenierosBatallon;
    }
    public void setNombresJefeGestionIngenierosBatallon(String nombresJefeGestionIngenierosBatallon) {
        this.nombresJefeGestionIngenierosBatallon = nombresJefeGestionIngenierosBatallon;
    }
    public String getPrimerApellidoJefeGestionIngenierosBatallon() {
        return primerApellidoJefeGestionIngenierosBatallon;
    }
    public void setPrimerApellidoJefeGestionIngenierosBatallon(String primerApellidoJefeGestionIngenierosBatallon) {
        this.primerApellidoJefeGestionIngenierosBatallon = primerApellidoJefeGestionIngenierosBatallon;
    }
    public String getSegundoApellidoJefeGestionIngenierosBatallon() {
        return segundoApellidoJefeGestionIngenierosBatallon;
    }
    public void setSegundoApellidoJefeGestionIngenierosBatallon(String segundoApellidoJefeGestionIngenierosBatallon) {
        this.segundoApellidoJefeGestionIngenierosBatallon = segundoApellidoJefeGestionIngenierosBatallon;
    }
    public String getNombreArchivoFotoFirmaJefeGestionIngenierosBatallon() {
        return nombreArchivoFotoFirmaJefeGestionIngenierosBatallon;
    }
    public void setNombreArchivoFotoFirmaJefeGestionIngenierosBatallon(String nombreArchivoFotoFirmaJefeGestionIngenierosBatallon) {
        this.nombreArchivoFotoFirmaJefeGestionIngenierosBatallon = nombreArchivoFotoFirmaJefeGestionIngenierosBatallon;
    }
    public String getCargoJefeGestionIngenierosBatallon() {
        return cargoJefeGestionIngenierosBatallon;
    }
    public void setCargoJefeGestionIngenierosBatallon(String cargoJefeGestionIngenierosBatallon) {
        this.cargoJefeGestionIngenierosBatallon = cargoJefeGestionIngenierosBatallon;
    }
    public String getGradoCteBatallon() {
        return gradoCteBatallon;
    }
    public void setGradoCteBatallon(String gradoCteBatallon) {
        this.gradoCteBatallon = gradoCteBatallon;
    }
    public String getNombresCteBatallon() {
        return nombresCteBatallon;
    }
    public void setNombresCteBatallon(String nombresCteBatallon) {
        this.nombresCteBatallon = nombresCteBatallon;
    }
    public String getPrimerApellidoCteBatallon() {
        return primerApellidoCteBatallon;
    }
    public void setPrimerApellidoCteBatallon(String primerApellidoCteBatallon) {
        this.primerApellidoCteBatallon = primerApellidoCteBatallon;
    }
    public String getSegundoApellidoCteBatallon() {
        return segundoApellidoCteBatallon;
    }
    public void setSegundoApellidoCteBatallon(String segundoApellidoCteBatallon) {
        this.segundoApellidoCteBatallon = segundoApellidoCteBatallon;
    }
    public String getNombreArchivoFotoFirmaCteBatallon() {
        return nombreArchivoFotoFirmaCteBatallon;
    }
    public void setNombreArchivoFotoFirmaCteBatallon(String nombreArchivoFotoFirmaCteBatallon) {
        this.nombreArchivoFotoFirmaCteBatallon = nombreArchivoFotoFirmaCteBatallon;
    }
    public String getCargoCteBatallon() {
        return cargoCteBatallon;
    }
    public void setCargoCteBatallon(String cargoCteBatallon) {
        this.cargoCteBatallon = cargoCteBatallon;
    }
    public String getGradoCteOJem2doCteWBr() {
        return gradoCteOJem2doCteWBr;
    }
    public void setGradoCteOJem2doCteWBr(String gradoCteOJem2doCteWBr) {
        this.gradoCteOJem2doCteWBr = gradoCteOJem2doCteWBr;
    }
    public String getNombresCteOJem2doCteWBr() {
        return nombresCteOJem2doCteWBr;
    }
    public void setNombresCteOJem2doCteWBr(String nombresCteOJem2doCteWBr) {
        this.nombresCteOJem2doCteWBr = nombresCteOJem2doCteWBr;
    }
    public String getPrimerApellidoCteOJem2doCteWBr() {
        return primerApellidoCteOJem2doCteWBr;
    }
    public void setPrimerApellidoCteOJem2doCteWBr(String primerApellidoCteOJem2doCteWBr) {
        this.primerApellidoCteOJem2doCteWBr = primerApellidoCteOJem2doCteWBr;
    }
    public String getSegundoApellidoCteOJem2doCteWBr() {
        return segundoApellidoCteOJem2doCteWBr;
    }
    public void setSegundoApellidoCteOJem2doCteWBr(String segundoApellidoCteOJem2doCteWBr) {
        this.segundoApellidoCteOJem2doCteWBr = segundoApellidoCteOJem2doCteWBr;
    }
    public String getNombreArchivoFotoFirmaCteOJem2doCteWBr() {
        return nombreArchivoFotoFirmaCteOJem2doCteWBr;
    }
    public void setNombreArchivoFotoFirmaCteOJem2doCteWBr(String nombreArchivoFotoFirmaCteOJem2doCteWBr) {
        this.nombreArchivoFotoFirmaCteOJem2doCteWBr = nombreArchivoFotoFirmaCteOJem2doCteWBr;
    }
    public String getCargoCteOJem2doCteWBr() {
        return cargoCteOJem2doCteWBr;
    }
    public void setCargoCteOJem2doCteWBr(String cargoCteOJem2doCteWBr) {
        this.cargoCteOJem2doCteWBr = cargoCteOJem2doCteWBr;
    }
    public String getGradoFincaRaizDiv() {
        return gradoFincaRaizDiv;
    }
    public void setGradoFincaRaizDiv(String gradoFincaRaizDiv) {
        this.gradoFincaRaizDiv = gradoFincaRaizDiv;
    }
    public String getNombresFincaRaizDiv() {
        return nombresFincaRaizDiv;
    }
    public void setNombresFincaRaizDiv(String nombresFincaRaizDiv) {
        this.nombresFincaRaizDiv = nombresFincaRaizDiv;
    }
    public String getPrimerApellidoFincaRaizDiv() {
        return primerApellidoFincaRaizDiv;
    }
    public void setPrimerApellidoFincaRaizDiv(String primerApellidoFincaRaizDiv) {
        this.primerApellidoFincaRaizDiv = primerApellidoFincaRaizDiv;
    }
    public String getSegundoApellidoFincaRaizDiv() {
        return segundoApellidoFincaRaizDiv;
    }
    public void setSegundoApellidoFincaRaizDiv(String segundoApellidoFincaRaizDiv) {
        this.segundoApellidoFincaRaizDiv = segundoApellidoFincaRaizDiv;
    }
    public String getNombreArchivoFotoFirmaFincaRaizDiv() {
        return nombreArchivoFotoFirmaFincaRaizDiv;
    }
    public void setNombreArchivoFotoFirmaFincaRaizDiv(String nombreArchivoFotoFirmaFincaRaizDiv) {
        this.nombreArchivoFotoFirmaFincaRaizDiv = nombreArchivoFotoFirmaFincaRaizDiv;
    }
    public String getCargoFincaRaizDiv() {
        return cargoFincaRaizDiv;
    }
    public void setCargoFincaRaizDiv(String cargoFincaRaizDiv) {
        this.cargoFincaRaizDiv = cargoFincaRaizDiv;
    }
    public String getGradoJefeGestionIngenierosDiv() {
        return gradoJefeGestionIngenierosDiv;
    }
    public void setGradoJefeGestionIngenierosDiv(String gradoJefeGestionIngenierosDiv) {
        this.gradoJefeGestionIngenierosDiv = gradoJefeGestionIngenierosDiv;
    }
    public String getNombresJefeGestionIngenierosDiv() {
        return nombresJefeGestionIngenierosDiv;
    }
    public void setNombresJefeGestionIngenierosDiv(String nombresJefeGestionIngenierosDiv) {
        this.nombresJefeGestionIngenierosDiv = nombresJefeGestionIngenierosDiv;
    }
    public String getPrimerApellidoJefeGestionIngenierosDiv() {
        return primerApellidoJefeGestionIngenierosDiv;
    }
    public void setPrimerApellidoJefeGestionIngenierosDiv(String primerApellidoJefeGestionIngenierosDiv) {
        this.primerApellidoJefeGestionIngenierosDiv = primerApellidoJefeGestionIngenierosDiv;
    }
    public String getSegundoApellidoJefeGestionIngenierosDiv() {
        return segundoApellidoJefeGestionIngenierosDiv;
    }
    public void setSegundoApellidoJefeGestionIngenierosDiv(String segundoApellidoJefeGestionIngenierosDiv) {
        this.segundoApellidoJefeGestionIngenierosDiv = segundoApellidoJefeGestionIngenierosDiv;
    }
    public String getNombreArchivoFotoFirmaJefeGestionIngenierosDiv() {
        return nombreArchivoFotoFirmaJefeGestionIngenierosDiv;
    }
    public void setNombreArchivoFotoFirmaJefeGestionIngenierosDiv(String nombreArchivoFotoFirmaJefeGestionIngenierosDiv) {
        this.nombreArchivoFotoFirmaJefeGestionIngenierosDiv = nombreArchivoFotoFirmaJefeGestionIngenierosDiv;
    }
    public String getCargoJefeGestionIngenierosDiv() {
        return cargoJefeGestionIngenierosDiv;
    }
    public void setCargoJefeGestionIngenierosDiv(String cargoJefeGestionIngenierosDiv) {
        this.cargoJefeGestionIngenierosDiv = cargoJefeGestionIngenierosDiv;
    }
    public String getGradoCteDiv() {
        return gradoCteDiv;
    }
    public void setGradoCteDiv(String gradoCteDiv) {
        this.gradoCteDiv = gradoCteDiv;
    }
    public String getNombresCteDiv() {
        return nombresCteDiv;
    }
    public void setNombresCteDiv(String nombresCteDiv) {
        this.nombresCteDiv = nombresCteDiv;
    }
    public String getPrimerApellidoCteDiv() {
        return primerApellidoCteDiv;
    }
    public void setPrimerApellidoCteDiv(String primerApellidoCteDiv) {
        this.primerApellidoCteDiv = primerApellidoCteDiv;
    }
    public String getSegundoApellidoCteDiv() {
        return segundoApellidoCteDiv;
    }
    public void setSegundoApellidoCteDiv(String segundoApellidoCteDiv) {
        this.segundoApellidoCteDiv = segundoApellidoCteDiv;
    }
    public String getNombreArchivoFotoFirmaCteDiv() {
        return nombreArchivoFotoFirmaCteDiv;
    }
    public void setNombreArchivoFotoFirmaCteDiv(String nombreArchivoFotoFirmaCteDiv) {
        this.nombreArchivoFotoFirmaCteDiv = nombreArchivoFotoFirmaCteDiv;
    }
    public String getCargoCteDiv() {
        return cargoCteDiv;
    }
    public void setCargoCteDiv(String cargoCteDiv) {
        this.cargoCteDiv = cargoCteDiv;
    }
    public String getGradoFincaRaizComando() {
        return gradoFincaRaizComando;
    }
    public void setGradoFincaRaizComando(String gradoFincaRaizComando) {
        this.gradoFincaRaizComando = gradoFincaRaizComando;
    }
    public String getNombresFincaRaizComando() {
        return nombresFincaRaizComando;
    }
    public void setNombresFincaRaizComando(String nombresFincaRaizComando) {
        this.nombresFincaRaizComando = nombresFincaRaizComando;
    }
    public String getPrimerApellidoFincaRaizComando() {
        return primerApellidoFincaRaizComando;
    }
    public void setPrimerApellidoFincaRaizComando(String primerApellidoFincaRaizComando) {
        this.primerApellidoFincaRaizComando = primerApellidoFincaRaizComando;
    }
    public String getSegundoApellidoFincaRaizComando() {
        return segundoApellidoFincaRaizComando;
    }
    public void setSegundoApellidoFincaRaizComando(String segundoApellidoFincaRaizComando) {
        this.segundoApellidoFincaRaizComando = segundoApellidoFincaRaizComando;
    }
    public String getNombreArchivoFotoFirmaFincaRaizComando() {
        return nombreArchivoFotoFirmaFincaRaizComando;
    }
    public void setNombreArchivoFotoFirmaFincaRaizComando(String nombreArchivoFotoFirmaFincaRaizComando) {
        this.nombreArchivoFotoFirmaFincaRaizComando = nombreArchivoFotoFirmaFincaRaizComando;
    }
    public String getCargoFincaRaizComando() {
        return cargoFincaRaizComando;
    }
    public void setCargoFincaRaizComando(String cargoFincaRaizComando) {
        this.cargoFincaRaizComando = cargoFincaRaizComando;
    }
    public String getGradoJefeGestionIngenierosComando() {
        return gradoJefeGestionIngenierosComando;
    }
    public void setGradoJefeGestionIngenierosComando(String gradoJefeGestionIngenierosComando) {
        this.gradoJefeGestionIngenierosComando = gradoJefeGestionIngenierosComando;
    }
    public String getNombresJefeGestionIngenierosComando() {
        return nombresJefeGestionIngenierosComando;
    }
    public void setNombresJefeGestionIngenierosComando(String nombresJefeGestionIngenierosComando) {
        this.nombresJefeGestionIngenierosComando = nombresJefeGestionIngenierosComando;
    }
    public String getPrimerApellidoJefeGestionIngenierosComando() {
        return primerApellidoJefeGestionIngenierosComando;
    }
    public void setPrimerApellidoJefeGestionIngenierosComando(String primerApellidoJefeGestionIngenierosComando) {
        this.primerApellidoJefeGestionIngenierosComando = primerApellidoJefeGestionIngenierosComando;
    }
    public String getSegundoApellidoJefeGestionIngenierosComando() {
        return segundoApellidoJefeGestionIngenierosComando;
    }
    public void setSegundoApellidoJefeGestionIngenierosComando(String segundoApellidoJefeGestionIngenierosComando) {
        this.segundoApellidoJefeGestionIngenierosComando = segundoApellidoJefeGestionIngenierosComando;
    }
    public String getNombreArchivoFotoFirmaJefeGestionIngenierosComando() {
        return nombreArchivoFotoFirmaJefeGestionIngenierosComando;
    }
    public void setNombreArchivoFotoFirmaJefeGestionIngenierosComando(String nombreArchivoFotoFirmaJefeGestionIngenierosComando) {
        this.nombreArchivoFotoFirmaJefeGestionIngenierosComando = nombreArchivoFotoFirmaJefeGestionIngenierosComando;
    }
    public String getCargoJefeGestionIngenierosComando() {
        return cargoJefeGestionIngenierosComando;
    }
    public void setCargoJefeGestionIngenierosComando(String cargoJefeGestionIngenierosComando) {
        this.cargoJefeGestionIngenierosComando = cargoJefeGestionIngenierosComando;
    }
    public String getGradoCteComando() {
        return gradoCteComando;
    }
    public void setGradoCteComando(String gradoCteComando) {
        this.gradoCteComando = gradoCteComando;
    }
    public String getNombresCteComando() {
        return nombresCteComando;
    }
    public void setNombresCteComando(String nombresCteComando) {
        this.nombresCteComando = nombresCteComando;
    }
    public String getPrimerApellidoCteComando() {
        return primerApellidoCteComando;
    }
    public void setPrimerApellidoCteComando(String primerApellidoCteComando) {
        this.primerApellidoCteComando = primerApellidoCteComando;
    }
    public String getSegundoApellidoCteComando() {
        return segundoApellidoCteComando;
    }
    public void setSegundoApellidoCteComando(String segundoApellidoCteComando) {
        this.segundoApellidoCteComando = segundoApellidoCteComando;
    }
    public String getNombreArchivoFotoFirmaCteComando() {
        return nombreArchivoFotoFirmaCteComando;
    }
    public void setNombreArchivoFotoFirmaCteComando(String nombreArchivoFotoFirmaCteComando) {
        this.nombreArchivoFotoFirmaCteComando = nombreArchivoFotoFirmaCteComando;
    }
    public String getCargoCteComando() {
        return cargoCteComando;
    }
    public void setCargoCteComando(String cargoCteComando) {
        this.cargoCteComando = cargoCteComando;
    }
    public String getGradoFincaRaizCede() {
        return gradoFincaRaizCede;
    }
    public void setGradoFincaRaizCede(String gradoFincaRaizCede) {
        this.gradoFincaRaizCede = gradoFincaRaizCede;
    }
    public String getNombresFincaRaizCede() {
        return nombresFincaRaizCede;
    }
    public void setNombresFincaRaizCede(String nombresFincaRaizCede) {
        this.nombresFincaRaizCede = nombresFincaRaizCede;
    }
    public String getPrimerApellidoFincaRaizCede() {
        return primerApellidoFincaRaizCede;
    }
    public void setPrimerApellidoFincaRaizCede(String primerApellidoFincaRaizCede) {
        this.primerApellidoFincaRaizCede = primerApellidoFincaRaizCede;
    }
    public String getSegundoApellidoFincaRaizCede() {
        return segundoApellidoFincaRaizCede;
    }
    public void setSegundoApellidoFincaRaizCede(String segundoApellidoFincaRaizCede) {
        this.segundoApellidoFincaRaizCede = segundoApellidoFincaRaizCede;
    }
    public String getNombreArchivoFotoFirmaFincaRaizCede() {
        return nombreArchivoFotoFirmaFincaRaizCede;
    }
    public void setNombreArchivoFotoFirmaFincaRaizCede(String nombreArchivoFotoFirmaFincaRaizCede) {
        this.nombreArchivoFotoFirmaFincaRaizCede = nombreArchivoFotoFirmaFincaRaizCede;
    }
    public String getCargoFincaRaizCede() {
        return cargoFincaRaizCede;
    }
    public void setCargoFincaRaizCede(String cargoFincaRaizCede) {
        this.cargoFincaRaizCede = cargoFincaRaizCede;
    }
    public String getGradoJefeGestionIngenierosCede() {
        return gradoJefeGestionIngenierosCede;
    }
    public void setGradoJefeGestionIngenierosCede(String gradoJefeGestionIngenierosCede) {
        this.gradoJefeGestionIngenierosCede = gradoJefeGestionIngenierosCede;
    }
    public String getNombresJefeGestionIngenierosCede() {
        return nombresJefeGestionIngenierosCede;
    }
    public void setNombresJefeGestionIngenierosCede(String nombresJefeGestionIngenierosCede) {
        this.nombresJefeGestionIngenierosCede = nombresJefeGestionIngenierosCede;
    }
    public String getPrimerApellidoJefeGestionIngenierosCede() {
        return primerApellidoJefeGestionIngenierosCede;
    }
    public void setPrimerApellidoJefeGestionIngenierosCede(String primerApellidoJefeGestionIngenierosCede) {
        this.primerApellidoJefeGestionIngenierosCede = primerApellidoJefeGestionIngenierosCede;
    }
    public String getSegundoApellidoJefeGestionIngenierosCede() {
        return segundoApellidoJefeGestionIngenierosCede;
    }
    public void setSegundoApellidoJefeGestionIngenierosCede(String segundoApellidoJefeGestionIngenierosCede) {
        this.segundoApellidoJefeGestionIngenierosCede = segundoApellidoJefeGestionIngenierosCede;
    }
    public String getNombreArchivoFotoFirmaJefeGestionIngenierosCede() {
        return nombreArchivoFotoFirmaJefeGestionIngenierosCede;
    }
    public void setNombreArchivoFotoFirmaJefeGestionIngenierosCede(String nombreArchivoFotoFirmaJefeGestionIngenierosCede) {
        this.nombreArchivoFotoFirmaJefeGestionIngenierosCede = nombreArchivoFotoFirmaJefeGestionIngenierosCede;
    }
    public String getCargoJefeGestionIngenierosCede() {
        return cargoJefeGestionIngenierosCede;
    }
    public void setCargoJefeGestionIngenierosCede(String cargoJefeGestionIngenierosCede) {
        this.cargoJefeGestionIngenierosCede = cargoJefeGestionIngenierosCede;
    }
    public String getGradoCteCede() {
        return gradoCteCede;
    }
    public void setGradoCteCede(String gradoCteCede) {
        this.gradoCteCede = gradoCteCede;
    }
    public String getNombresCteCede() {
        return nombresCteCede;
    }
    public void setNombresCteCede(String nombresCteCede) {
        this.nombresCteCede = nombresCteCede;
    }
    public String getPrimerApellidoCteCede() {
        return primerApellidoCteCede;
    }
    public void setPrimerApellidoCteCede(String primerApellidoCteCede) {
        this.primerApellidoCteCede = primerApellidoCteCede;
    }
    public String getSegundoApellidoCteCede() {
        return segundoApellidoCteCede;
    }
    public void setSegundoApellidoCteCede(String segundoApellidoCteCede) {
        this.segundoApellidoCteCede = segundoApellidoCteCede;
    }
    public String getNombreArchivoFotoFirmaCteCede() {
        return nombreArchivoFotoFirmaCteCede;
    }
    public void setNombreArchivoFotoFirmaCteCede(String nombreArchivoFotoFirmaCteCede) {
        this.nombreArchivoFotoFirmaCteCede = nombreArchivoFotoFirmaCteCede;
    }
    public String getCargoCteCede() {
        return cargoCteCede;
    }
    public void setCargoCteCede(String cargoCteCede) {
        this.cargoCteCede = cargoCteCede;
    }
    public String getGradoFincaRaizJef() {
        return gradoFincaRaizJef;
    }
    public void setGradoFincaRaizJef(String gradoFincaRaizJef) {
        this.gradoFincaRaizJef = gradoFincaRaizJef;
    }
    public String getNombresFincaRaizJef() {
        return nombresFincaRaizJef;
    }
    public void setNombresFincaRaizJef(String nombresFincaRaizJef) {
        this.nombresFincaRaizJef = nombresFincaRaizJef;
    }
    public String getPrimerApellidoFincaRaizJef() {
        return primerApellidoFincaRaizJef;
    }
    public void setPrimerApellidoFincaRaizJef(String primerApellidoFincaRaizJef) {
        this.primerApellidoFincaRaizJef = primerApellidoFincaRaizJef;
    }
    public String getSegundoApellidoFincaRaizJef() {
        return segundoApellidoFincaRaizJef;
    }
    public void setSegundoApellidoFincaRaizJef(String segundoApellidoFincaRaizJef) {
        this.segundoApellidoFincaRaizJef = segundoApellidoFincaRaizJef;
    }
    public String getNombreArchivoFotoFirmaFincaRaizJef() {
        return nombreArchivoFotoFirmaFincaRaizJef;
    }
    public void setNombreArchivoFotoFirmaFincaRaizJef(String nombreArchivoFotoFirmaFincaRaizJef) {
        this.nombreArchivoFotoFirmaFincaRaizJef = nombreArchivoFotoFirmaFincaRaizJef;
    }
    public String getCargoFincaRaizJef() {
        return cargoFincaRaizJef;
    }
    public void setCargoFincaRaizJef(String cargoFincaRaizJef) {
        this.cargoFincaRaizJef = cargoFincaRaizJef;
    }
    public String getGradoJefeGestionIngenierosJef() {
        return gradoJefeGestionIngenierosJef;
    }
    public void setGradoJefeGestionIngenierosJef(String gradoJefeGestionIngenierosJef) {
        this.gradoJefeGestionIngenierosJef = gradoJefeGestionIngenierosJef;
    }
    public String getNombresJefeGestionIngenierosJef() {
        return nombresJefeGestionIngenierosJef;
    }
    public void setNombresJefeGestionIngenierosJef(String nombresJefeGestionIngenierosJef) {
        this.nombresJefeGestionIngenierosJef = nombresJefeGestionIngenierosJef;
    }
    public String getPrimerApellidoJefeGestionIngenierosJef() {
        return primerApellidoJefeGestionIngenierosJef;
    }
    public void setPrimerApellidoJefeGestionIngenierosJef(String primerApellidoJefeGestionIngenierosJef) {
        this.primerApellidoJefeGestionIngenierosJef = primerApellidoJefeGestionIngenierosJef;
    }
    public String getSegundoApellidoJefeGestionIngenierosJef() {
        return segundoApellidoJefeGestionIngenierosJef;
    }
    public void setSegundoApellidoJefeGestionIngenierosJef(String segundoApellidoJefeGestionIngenierosJef) {
        this.segundoApellidoJefeGestionIngenierosJef = segundoApellidoJefeGestionIngenierosJef;
    }
    public String getNombreArchivoFotoFirmaJefeGestionIngenierosJef() {
        return nombreArchivoFotoFirmaJefeGestionIngenierosJef;
    }
    public void setNombreArchivoFotoFirmaJefeGestionIngenierosJef(String nombreArchivoFotoFirmaJefeGestionIngenierosJef) {
        this.nombreArchivoFotoFirmaJefeGestionIngenierosJef = nombreArchivoFotoFirmaJefeGestionIngenierosJef;
    }
    public String getCargoJefeGestionIngenierosJef() {
        return cargoJefeGestionIngenierosJef;
    }
    public void setCargoJefeGestionIngenierosJef(String cargoJefeGestionIngenierosJef) {
        this.cargoJefeGestionIngenierosJef = cargoJefeGestionIngenierosJef;
    }
    public String getGradoCteJef() {
        return gradoCteJef;
    }
    public void setGradoCteJef(String gradoCteJef) {
        this.gradoCteJef = gradoCteJef;
    }
    public String getNombresCteJef() {
        return nombresCteJef;
    }
    public void setNombresCteJef(String nombresCteJef) {
        this.nombresCteJef = nombresCteJef;
    }
    public String getPrimerApellidoCteJef() {
        return primerApellidoCteJef;
    }
    public void setPrimerApellidoCteJef(String primerApellidoCteJef) {
        this.primerApellidoCteJef = primerApellidoCteJef;
    }
    public String getSegundoApellidoCteJef() {
        return segundoApellidoCteJef;
    }
    public void setSegundoApellidoCteJef(String segundoApellidoCteJef) {
        this.segundoApellidoCteJef = segundoApellidoCteJef;
    }
    public String getNombreArchivoFotoFirmaCteJef() {
        return nombreArchivoFotoFirmaCteJef;
    }
    public void setNombreArchivoFotoFirmaCteJef(String nombreArchivoFotoFirmaCteJef) {
        this.nombreArchivoFotoFirmaCteJef = nombreArchivoFotoFirmaCteJef;
    }
    public String getCargoCteJef() {
        return cargoCteJef;
    }
    public void setCargoCteJef(String cargoCteJef) {
        this.cargoCteJef = cargoCteJef;
    }*/
}
