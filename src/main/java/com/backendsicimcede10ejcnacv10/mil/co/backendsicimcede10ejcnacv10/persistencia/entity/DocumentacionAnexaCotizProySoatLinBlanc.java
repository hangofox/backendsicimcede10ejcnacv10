//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_DOCUMENTACION_ANEXAS_COTIZ_PROY_SOATS_LIN_BLANC")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class DocumentacionAnexaCotizProySoatLinBlanc {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_DOCUMENTACION_ANEXA_COTIZ_PROY_SOAT_LIN_BLANC", columnDefinition="NUMBER(20) NOT NULL")
    private Long idDocumentacionAnexaCotizProySoatLinBlanc;
    
    //@Column(name = "ID_PROYECCION_SOAT_LINEA_BLANCA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionSoatLineaBlanca;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_SOAT_LINEA_BLANCA", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionSoatLineaBlanca proyeccionSoatLineaBlanca;
    
    @Column(name = "NOMBRE_DOCUMENTO_ANEXO_COTIZ_PROY_SOAT_LIN_BLANC", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreDocumentoAnexoCotizProySoatLinBlanc;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_COTIZ_PROY_SOAT_LIN_BLANC", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoCotizProySoatLinBlanc;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdDocumentacionAnexaCotizProySoatLinBlanc() {
        return idDocumentacionAnexaCotizProySoatLinBlanc;
    }
    public void setIdDocumentacionAnexaCotizProySoatLinBlanc(Long idDocumentacionAnexaCotizProySoatLinBlanc) {
        this.idDocumentacionAnexaCotizProySoatLinBlanc = idDocumentacionAnexaCotizProySoatLinBlanc;
    }
    public ProyeccionSoatLineaBlanca getProyeccionSoatLineaBlanca() {
        return proyeccionSoatLineaBlanca;
    }
    public void setProyeccionSoatLineaBlanca(ProyeccionSoatLineaBlanca proyeccionSoatLineaBlanca) {
        this.proyeccionSoatLineaBlanca = proyeccionSoatLineaBlanca;
    }
    public String getNombreDocumentoAnexoCotizProySoatLinBlanc() {
        return nombreDocumentoAnexoCotizProySoatLinBlanc;
    }
    public void setNombreDocumentoAnexoCotizProySoatLinBlanc(String nombreDocumentoAnexoCotizProySoatLinBlanc) {
        this.nombreDocumentoAnexoCotizProySoatLinBlanc = nombreDocumentoAnexoCotizProySoatLinBlanc;
    }
    public String getNombreArchivoDocumentoAnexoCotizProySoatLinBlanc() {
        return nombreArchivoDocumentoAnexoCotizProySoatLinBlanc;
    }
    public void setNombreArchivoDocumentoAnexoCotizProySoatLinBlanc(String nombreArchivoDocumentoAnexoCotizProySoatLinBlanc) {
        this.nombreArchivoDocumentoAnexoCotizProySoatLinBlanc = nombreArchivoDocumentoAnexoCotizProySoatLinBlanc;
    }*/
}
