//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_DOCUMENTACION_ANEXAS_SOLIC_INFRAEST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class DocumentacionAnexaSolicInfraest {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_DOCUMENTACION_ANEXA_SOLIC_INFRAEST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idDocumentacionAnexaSolicInfraest;
    
    //@Column(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSolicitudInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private SolicitudInfraestructura solicitudInfraestructura;
    
    @Column(name = "NOMBRE_DOCUMENTO_ANEXO_SOLIC_INFRAEST", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreDocumentoAnexoSolicInfraest;
    
    //@Column(name = "ID_TIPO_DOCUMENTO_ANEXO_SOLIC_INFRAEST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDocumentoAnexoSolicInfraest;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DOCUMENTO_ANEXO_SOLIC_INFRAEST", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_SOLIC_INFRAEST", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoSolicInfraest;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdDocumentacionAnexaSolicInfraest() {
        return idDocumentacionAnexaSolicInfraest;
    }
    public void setIdDocumentacionAnexaSolicInfraest(Long idDocumentacionAnexaSolicInfraest) {
        this.idDocumentacionAnexaSolicInfraest = idDocumentacionAnexaSolicInfraest;
    }
    public SolicitudInfraestructura getSolicitudInfraestructura() {
        return solicitudInfraestructura;
    }
    public void setSolicitudInfraestructura(SolicitudInfraestructura solicitudInfraestructura) {
        this.solicitudInfraestructura = solicitudInfraestructura;
    }
    public String getNombreDocumentoAnexoSolicInfraest() {
        return nombreDocumentoAnexoSolicInfraest;
    }
    public void setNombreDocumentoAnexoSolicInfraest(String nombreDocumentoAnexoSolicInfraest) {
        this.nombreDocumentoAnexoSolicInfraest = nombreDocumentoAnexoSolicInfraest;
    }
    public TipoDocumentoAnexoSolicInfraest getTipoDocumentoAnexoSolicInfraest() {
        return tipoDocumentoAnexoSolicInfraest;
    }
    public void setTipoDocumentoAnexoSolicInfraest(TipoDocumentoAnexoSolicInfraest tipoDocumentoAnexoSolicInfraest) {
        this.tipoDocumentoAnexoSolicInfraest = tipoDocumentoAnexoSolicInfraest;
    }
    public String getNombreArchivoDocumentoAnexoSolicInfraest() {
        return nombreArchivoDocumentoAnexoSolicInfraest;
    }
    public void setNombreArchivoDocumentoAnexoSolicInfraest(String nombreArchivoDocumentoAnexoSolicInfraest) {
        this.nombreArchivoDocumentoAnexoSolicInfraest = nombreArchivoDocumentoAnexoSolicInfraest;
    }*/
}
