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
@Table(name = "TABLA_DOCUMENTACION_ANEXAS_COTIZ_INFRAEST_ARREND")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class DocumentacionAnexaCotizInfraestArrend {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_DOCUMENTACION_ANEXA_COTIZ_INFRAEST_ARREND", columnDefinition="NUMBER(20) NOT NULL")
    private Long idDocumentacionAnexaCotizInfraestArrend;
    
    //@Column(name = "ID_PROYECCION_PLAN_ANUAL_ARRENDAMIENTO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionPlanAnualArrendamiento;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_PLAN_ANUAL_ARRENDAMIENTO", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamiento;
    
    @Column(name = "NOMBRE_DOCUMENTO_ANEXO_COTIZ_INFRAEST_ARREND", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreDocumentoAnexoCotizInfraestArrend;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_COTIZ_INFRAEST_ARREND", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoCotizInfraestArrend;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdDocumentacionAnexaCotizInfraestArrend() {
        return idDocumentacionAnexaCotizInfraestArrend;
    }
    public void setIdDocumentacionAnexaCotizInfraestArrend(Long idDocumentacionAnexaCotizInfraestArrend) {
        this.idDocumentacionAnexaCotizInfraestArrend = idDocumentacionAnexaCotizInfraestArrend;
    }
    public ProyeccionPlanAnualArrendamiento getProyeccionPlanAnualArrendamiento() {
        return proyeccionPlanAnualArrendamiento;
    }
    public void setProyeccionPlanAnualArrendamiento(ProyeccionPlanAnualArrendamiento proyeccionPlanAnualArrendamiento) {
        this.proyeccionPlanAnualArrendamiento = proyeccionPlanAnualArrendamiento;
    }
    public String getNombreDocumentoAnexoCotizInfraestArrend() {
        return nombreDocumentoAnexoCotizInfraestArrend;
    }
    public void setNombreDocumentoAnexoCotizInfraestArrend(String nombreDocumentoAnexoCotizInfraestArrend) {
        this.nombreDocumentoAnexoCotizInfraestArrend = nombreDocumentoAnexoCotizInfraestArrend;
    }
    public String getNombreArchivoDocumentoAnexoCotizInfraestArrend() {
        return nombreArchivoDocumentoAnexoCotizInfraestArrend;
    }
    public void setNombreArchivoDocumentoAnexoCotizInfraestArrend(String nombreArchivoDocumentoAnexoCotizInfraestArrend) {
        this.nombreArchivoDocumentoAnexoCotizInfraestArrend = nombreArchivoDocumentoAnexoCotizInfraestArrend;
    }*/
}
