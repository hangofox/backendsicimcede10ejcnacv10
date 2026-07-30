//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_FOTOGRAFIAS_ANEXAS_SOLIC_INFRAEST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class FotografiaAnexaSolicInfraest {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_FOTOGRAFIAS_ANEXAS_SOLIC_INFRAEST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idFotografiasAnexasSolicInfraest;
    
    //@Column(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSolicitudInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private SolicitudInfraestructura solicitudInfraestructura;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_POSIB_LOC_EDIF_SOLIC_INFRAEST", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_VISTA_PAN_GR_SOLIC_INFRAEST", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_VISTA_SOLIC_INFRAEST1", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoVistaSolicInfraest1;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_VISTA_SOLIC_INFRAEST2", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoVistaSolicInfraest2;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_ACERC_DET_SOLIC_INFRAEST1", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_ACERC_DET_SOLIC_INFRAEST2", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_FOT_ADIC_SOLIC_INFRAEST1", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_FOT_ADIC_SOLIC_INFRAEST2", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdFotografiasAnexasSolicInfraest() {
        return idFotografiasAnexasSolicInfraest;
    }
    public void setIdFotografiasAnexasSolicInfraest(Long idFotografiasAnexasSolicInfraest) {
        this.idFotografiasAnexasSolicInfraest = idFotografiasAnexasSolicInfraest;
    }
    public SolicitudInfraestructura getSolicitudInfraestructura() {
        return solicitudInfraestructura;
    }
    public void setSolicitudInfraestructura(SolicitudInfraestructura solicitudInfraestructura) {
        this.solicitudInfraestructura = solicitudInfraestructura;
    }
    public String getNombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest() {
        return nombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest;
    }
    public void setNombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest(String nombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest) {
        this.nombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest = nombreArchivoFotoExtensionOFormatoPosibLocEdifSolicInfraest;
    }
    public String getNombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest() {
        return nombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest;
    }
    public void setNombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest(String nombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest) {
        this.nombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest = nombreArchivoFotoExtensionOFormatoVistaPanGrSolicInfraest;
    }
    public String getNombreArchivoFotoExtensionOFormatoVistaSolicInfraest1() {
        return nombreArchivoFotoExtensionOFormatoVistaSolicInfraest1;
    }
    public void setNombreArchivoFotoExtensionOFormatoVistaSolicInfraest1(String nombreArchivoFotoExtensionOFormatoVistaSolicInfraest1) {
        this.nombreArchivoFotoExtensionOFormatoVistaSolicInfraest1 = nombreArchivoFotoExtensionOFormatoVistaSolicInfraest1;
    }
    public String getNombreArchivoFotoExtensionOFormatoVistaSolicInfraest2() {
        return nombreArchivoFotoExtensionOFormatoVistaSolicInfraest2;
    }
    public void setNombreArchivoFotoExtensionOFormatoVistaSolicInfraest2(String nombreArchivoFotoExtensionOFormatoVistaSolicInfraest2) {
        this.nombreArchivoFotoExtensionOFormatoVistaSolicInfraest2 = nombreArchivoFotoExtensionOFormatoVistaSolicInfraest2;
    }
    public String getNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1() {
        return nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1;
    }
    public void setNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1(String nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1) {
        this.nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1 = nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest1;
    }
    public String getNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2() {
        return nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2;
    }
    public void setNombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2(String nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2) {
        this.nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2 = nombreArchivoFotoExtensionOFormatoAcercDetSolicInfraest2;
    }
    public String getNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1() {
        return nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1;
    }
    public void setNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1(String nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1) {
        this.nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1 = nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest1;
    }
    public String getNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2() {
        return nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2;
    }
    public void setNombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2(String nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2) {
        this.nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2 = nombreArchivoFotoExtensionOFormatoFotAdicSolicInfraest2;
    }*/
}
