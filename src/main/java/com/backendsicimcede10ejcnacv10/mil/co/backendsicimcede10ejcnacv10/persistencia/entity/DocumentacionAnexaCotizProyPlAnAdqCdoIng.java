//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_DOCUMENTACION_ANEXAS_COTIZ_PROY_PL_AN_ADQ_CDOS_ING")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class DocumentacionAnexaCotizProyPlAnAdqCdoIng {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_DOCUMENTACION_ANEXA_COTIZ_PROY_PL_AN_ADQ_CDO_ING", columnDefinition="NUMBER(20) NOT NULL")
    private Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng;
    
    //@Column(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionPlanAnualAdqCdoIng;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_CDO_ING", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIng;
    
    @Column(name = "NOMBRE_DOCUMENTO_ANEXO_COTIZ_PROY_PL_AN_ADQ_CDO_ING", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreDocumentoAnexoCotizProyPlAnAdqCdoIng;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_COTIZ_PROY_PL_AN_ADQ_CDO_ING", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdDocumentacionAnexaCotizProyPlAnAdqCdoIng() {
        return idDocumentacionAnexaCotizProyPlAnAdqCdoIng;
    }
    public void setIdDocumentacionAnexaCotizProyPlAnAdqCdoIng(Long idDocumentacionAnexaCotizProyPlAnAdqCdoIng) {
        this.idDocumentacionAnexaCotizProyPlAnAdqCdoIng = idDocumentacionAnexaCotizProyPlAnAdqCdoIng;
    }
    public ProyeccionPlanAnualAdqCdoIng getProyeccionPlanAnualAdqCdoIng() {
        return proyeccionPlanAnualAdqCdoIng;
    }
    public void setProyeccionPlanAnualAdqCdoIng(ProyeccionPlanAnualAdqCdoIng proyeccionPlanAnualAdqCdoIng) {
        this.proyeccionPlanAnualAdqCdoIng = proyeccionPlanAnualAdqCdoIng;
    }
    public String getNombreDocumentoAnexoCotizProyPlAnAdqCdoIng() {
        return nombreDocumentoAnexoCotizProyPlAnAdqCdoIng;
    }
    public void setNombreDocumentoAnexoCotizProyPlAnAdqCdoIng(String nombreDocumentoAnexoCotizProyPlAnAdqCdoIng) {
        this.nombreDocumentoAnexoCotizProyPlAnAdqCdoIng = nombreDocumentoAnexoCotizProyPlAnAdqCdoIng;
    }
    public String getNombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng() {
        return nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng;
    }
    public void setNombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng(String nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng) {
        this.nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng = nombreArchivoDocumentoAnexoCotizProyPlAnAdqCdoIng;
    }*/
}
