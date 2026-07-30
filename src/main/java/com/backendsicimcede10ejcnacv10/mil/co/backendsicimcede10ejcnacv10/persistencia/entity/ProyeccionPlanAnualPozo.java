//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROYECCIONES_PLANES_ANUALES_POZOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProyeccionPlanAnualPozo {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROYECCION_PLAN_ANUAL_POZO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idProyeccionPlanAnualPozo;
    
    //@Column(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_GENERAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionPlanAnualAdqGeneral;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_GENERAL", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral;
    
    @Column(name = "NOMBRE_PROYECCION_PLAN_ANUAL_POZO", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreProyeccionPlanAnualPozo;
    
    //@Column(name = "ID_TIPO_MANTENIMIENTO_POZO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoMantenimientoPozo;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_MANTENIMIENTO_POZO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoMantenimientoPozo tipoMantenimientoPozo;
    
    @Column(name = "NOMBRE_Y_NUMERO_RUBRO_PROYECCION_PLAN_ANUAL_POZO", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreYNumeroRubroProyeccionPlanAnualPozo;
    
    @Column(name = "VALOR_SOLICITADO_PROYECCION_PLAN_ANUAL_POZO", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoProyeccionPlanAnualPozo;
    
    @Column(name = "NOMBRE_BIEN_O_SERVICIO_PROYECCION_PLAN_ANUAL_POZO", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreBienOServicioProyeccionPlanAnualPozo;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_COTIZ_PROY_PL_AN_POZO", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoCotizProyPlAnPozo;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdProyeccionPlanAnualPozo() {
        return idProyeccionPlanAnualPozo;
    }
    public void setIdProyeccionPlanAnualPozo(Long idProyeccionPlanAnualPozo) {
        this.idProyeccionPlanAnualPozo = idProyeccionPlanAnualPozo;
    }
    public ProyeccionPlanAnualAdqGeneral getProyeccionPlanAnualAdqGeneral() {
        return proyeccionPlanAnualAdqGeneral;
    }
    public void setProyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral) {
        this.proyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqGeneral;
    }
    public String getNombreProyeccionPlanAnualPozo() {
        return nombreProyeccionPlanAnualPozo;
    }
    public void setNombreProyeccionPlanAnualPozo(String nombreProyeccionPlanAnualPozo) {
        this.nombreProyeccionPlanAnualPozo = nombreProyeccionPlanAnualPozo;
    }
    public TipoMantenimientoPozo getTipoMantenimientoPozo() {
        return tipoMantenimientoPozo;
    }
    public void setTipoMantenimientoPozo(TipoMantenimientoPozo tipoMantenimientoPozo) {
        this.tipoMantenimientoPozo = tipoMantenimientoPozo;
    }
    public String getNombreYNumeroRubroProyeccionPlanAnualPozo() {
        return nombreYNumeroRubroProyeccionPlanAnualPozo;
    }
    public void setNombreYNumeroRubroProyeccionPlanAnualPozo(String nombreYNumeroRubroProyeccionPlanAnualPozo) {
        this.nombreYNumeroRubroProyeccionPlanAnualPozo = nombreYNumeroRubroProyeccionPlanAnualPozo;
    }
    public String getValorSolicitadoProyeccionPlanAnualPozo() {
        return valorSolicitadoProyeccionPlanAnualPozo;
    }
    public void setValorSolicitadoProyeccionPlanAnualPozo(String valorSolicitadoProyeccionPlanAnualPozo) {
        this.valorSolicitadoProyeccionPlanAnualPozo = valorSolicitadoProyeccionPlanAnualPozo;
    }
    public String getNombreBienOServicioProyeccionPlanAnualPozo() {
        return nombreBienOServicioProyeccionPlanAnualPozo;
    }
    public void setNombreBienOServicioProyeccionPlanAnualPozo(String nombreBienOServicioProyeccionPlanAnualPozo) {
        this.nombreBienOServicioProyeccionPlanAnualPozo = nombreBienOServicioProyeccionPlanAnualPozo;
    }
    public String getNombreArchivoDocumentoAnexoCotizProyPlAnPozo() {
        return nombreArchivoDocumentoAnexoCotizProyPlAnPozo;
    }
    public void setNombreArchivoDocumentoAnexoCotizProyPlAnPozo(String nombreArchivoDocumentoAnexoCotizProyPlAnPozo) {
        this.nombreArchivoDocumentoAnexoCotizProyPlAnPozo = nombreArchivoDocumentoAnexoCotizProyPlAnPozo;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }*/
}
