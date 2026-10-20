//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_INTEGRANTES_SOLICITUDES_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialIntegranteSolicitudInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialIntegranteSolicitudInfraestructura;
    
    @Column(name = "NUM_REG_HISTORIAL_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialIntegranteSolicitudInfraestructura;
    
    //@Column(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSolicitudInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private SolicitudInfraestructura solicitudInfraestructura;

    //UNIDAD MILITAR A LA QUE PERTENECE EL INTEGRANTE (PASO DE LA LÍNEA DE MANDO DE LA SOLICITUD):
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;

    @Column(name = "GRADO_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String gradoIntegranteSolicitudInfraestructura;

    @Column(name = "NOMBRES_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String nombresIntegranteSolicitudInfraestructura;

    @Column(name = "PRIMER_APELLIDO_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String primerApellidoIntegranteSolicitudInfraestructura;

    @Column(name = "SEGUNDO_APELLIDO_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String segundoApellidoIntegranteSolicitudInfraestructura;

    @Column(name = "NOMBRE_ARCHIVO_FOTO_FIRMA_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "CLOB NOT NULL")
    //@Lob
    private String nombreArchivoFotoFirmaIntegranteSolicitudInfraestructura;

    @Column(name = "CARGO_INTEGRANTE_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String cargoIntegranteSolicitudInfraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialIntegranteSolicitudInfraestructura() {
        return idHistorialIntegranteSolicitudInfraestructura;
    }
    public void setIdHistorialIntegranteSolicitudInfraestructura(Long idHistorialIntegranteSolicitudInfraestructura) {
        this.idHistorialIntegranteSolicitudInfraestructura = idHistorialIntegranteSolicitudInfraestructura;
    }
    public String getNumRegHistorialIntegranteSolicitudInfraestructura() {
        return numRegHistorialIntegranteSolicitudInfraestructura;
    }
    public void setNumRegHistorialIntegranteSolicitudInfraestructura(String numRegHistorialIntegranteSolicitudInfraestructura) {
        this.numRegHistorialIntegranteSolicitudInfraestructura = numRegHistorialIntegranteSolicitudInfraestructura;
    }
    public SolicitudInfraestructura getSolicitudInfraestructura() {
        return solicitudInfraestructura;
    }
    public void setSolicitudInfraestructura(SolicitudInfraestructura solicitudInfraestructura) {
        this.solicitudInfraestructura = solicitudInfraestructura;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getGradoIntegranteSolicitudInfraestructura() {
        return gradoIntegranteSolicitudInfraestructura;
    }
    public void setGradoIntegranteSolicitudInfraestructura(String gradoIntegranteSolicitudInfraestructura) {
        this.gradoIntegranteSolicitudInfraestructura = gradoIntegranteSolicitudInfraestructura;
    }
    public String getNombresIntegranteSolicitudInfraestructura() {
        return nombresIntegranteSolicitudInfraestructura;
    }
    public void setNombresIntegranteSolicitudInfraestructura(String nombresIntegranteSolicitudInfraestructura) {
        this.nombresIntegranteSolicitudInfraestructura = nombresIntegranteSolicitudInfraestructura;
    }
    public String getPrimerApellidoIntegranteSolicitudInfraestructura() {
        return primerApellidoIntegranteSolicitudInfraestructura;
    }
    public void setPrimerApellidoIntegranteSolicitudInfraestructura(String primerApellidoIntegranteSolicitudInfraestructura) {
        this.primerApellidoIntegranteSolicitudInfraestructura = primerApellidoIntegranteSolicitudInfraestructura;
    }
    public String getSegundoApellidoIntegranteSolicitudInfraestructura() {
        return segundoApellidoIntegranteSolicitudInfraestructura;
    }
    public void setSegundoApellidoIntegranteSolicitudInfraestructura(String segundoApellidoIntegranteSolicitudInfraestructura) {
        this.segundoApellidoIntegranteSolicitudInfraestructura = segundoApellidoIntegranteSolicitudInfraestructura;
    }
    public String getNombreArchivoFotoFirmaIntegranteSolicitudInfraestructura() {
        return nombreArchivoFotoFirmaIntegranteSolicitudInfraestructura;
    }
    public void setNombreArchivoFotoFirmaIntegranteSolicitudInfraestructura(String nombreArchivoFotoFirmaIntegranteSolicitudInfraestructura) {
        this.nombreArchivoFotoFirmaIntegranteSolicitudInfraestructura = nombreArchivoFotoFirmaIntegranteSolicitudInfraestructura;
    }
    public String getCargoIntegranteSolicitudInfraestructura() {
        return cargoIntegranteSolicitudInfraestructura;
    }
    public void setCargoIntegranteSolicitudInfraestructura(String cargoIntegranteSolicitudInfraestructura) {
        this.cargoIntegranteSolicitudInfraestructura = cargoIntegranteSolicitudInfraestructura;
    }*/
}
