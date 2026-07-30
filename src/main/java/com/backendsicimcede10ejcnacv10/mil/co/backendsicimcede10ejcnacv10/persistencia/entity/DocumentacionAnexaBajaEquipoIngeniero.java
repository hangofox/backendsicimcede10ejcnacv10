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
@Table(name = "TABLA_DOCUMENTACION_ANEXAS_BAJAS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class DocumentacionAnexaBajaEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_DOCUMENTACION_ANEXA_BAJA_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idDocumentacionAnexaBajaEquipoIngeniero;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "NOMBRE_DOCUMENTO_ANEXO_BAJA_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreDocumentoAnexoBajaEquipoIngeniero;
    
    //@Column(name = "ID_TIPO_DOCUMENTO_ANEXO_BAJA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDocumentoAnexoBajaEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DOCUMENTO_ANEXO_BAJA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_BAJA_EQUIPO_INGENIERO", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoBajaEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdDocumentacionAnexaBajaEquipoIngeniero() {
        return idDocumentacionAnexaBajaEquipoIngeniero;
    }
    public void setIdDocumentacionAnexaBajaEquipoIngeniero(Long idDocumentacionAnexaBajaEquipoIngeniero) {
        this.idDocumentacionAnexaBajaEquipoIngeniero = idDocumentacionAnexaBajaEquipoIngeniero;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public String getNombreDocumentoAnexoBajaEquipoIngeniero() {
        return nombreDocumentoAnexoBajaEquipoIngeniero;
    }
    public void setNombreDocumentoAnexoBajaEquipoIngeniero(String nombreDocumentoAnexoBajaEquipoIngeniero) {
        this.nombreDocumentoAnexoBajaEquipoIngeniero = nombreDocumentoAnexoBajaEquipoIngeniero;
    }
    public TipoDocumentoAnexoBajaEquipoIngeniero getTipoDocumentoAnexoBajaEquipoIngeniero() {
        return tipoDocumentoAnexoBajaEquipoIngeniero;
    }
    public void setTipoDocumentoAnexoBajaEquipoIngeniero(TipoDocumentoAnexoBajaEquipoIngeniero tipoDocumentoAnexoBajaEquipoIngeniero) {
        this.tipoDocumentoAnexoBajaEquipoIngeniero = tipoDocumentoAnexoBajaEquipoIngeniero;
    }
    public String getNombreArchivoDocumentoAnexoBajaEquipoIngeniero() {
        return nombreArchivoDocumentoAnexoBajaEquipoIngeniero;
    }
    public void setNombreArchivoDocumentoAnexoBajaEquipoIngeniero(String nombreArchivoDocumentoAnexoBajaEquipoIngeniero) {
        this.nombreArchivoDocumentoAnexoBajaEquipoIngeniero = nombreArchivoDocumentoAnexoBajaEquipoIngeniero;
    }*/
}
