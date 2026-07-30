//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_INFORMACION_FINANCIERA_SOLICITUDES_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class InformacionFinancieraSolicitudInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INFORMACION_FINANCIERA_SOLICITUD_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idInformacionFinancieraSolicitudInfraestructura;
    
    //@Column(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSolicitudInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private SolicitudInfraestructura solicitudInfraestructura;
    
    //@Column(name = "ID_TIPO_FUENTE_FINANCIACION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoFuenteFinanciacion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_FUENTE_FINANCIACION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoFuenteFinanciacion tipoFuenteFinanciacion;
    
    @Column(name = "OBSERVACIONES_PRESUPUESTO_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    //@Lob
    private String observacionesPresupuestoInfraestructura;
    
    //@Column(name = "ID_ACTIVIDAD_PRODUCTO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idActividadProductoInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ACTIVIDAD_PRODUCTO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private ActividadProductoInfraestructura actividadProductoInfraestructura;
    
    @Column(name = "CANTIDAD_ACTIVIDAD_PRODUCTO_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long cantidadActividadProductoInfraestructura;
    
    @Column(name = "VALOR_COSTO_UNITARIO_CAPITULO_PRODUCTO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NULL")
    private String valorCostoUnitarioCapituloProductoInfraestructura;
    
    @Column(name = "NUMERO_AREA_INTERVENCION_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroAreaIntervencionInfraestructura;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_AREA_INTERVENCION_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaAreaIntervencionInfraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdInformacionFinancieraSolicitudInfraestructura() {
        return idInformacionFinancieraSolicitudInfraestructura;
    }
    public void setIdInformacionFinancieraSolicitudInfraestructura(Long idInformacionFinancieraSolicitudInfraestructura) {
        this.idInformacionFinancieraSolicitudInfraestructura = idInformacionFinancieraSolicitudInfraestructura;
    }
    public SolicitudInfraestructura getSolicitudInfraestructura() {
        return solicitudInfraestructura;
    }
    public void setSolicitudInfraestructura(SolicitudInfraestructura solicitudInfraestructura) {
        this.solicitudInfraestructura = solicitudInfraestructura;
    }
    public TipoFuenteFinanciacion getTipoFuenteFinanciacion() {
        return tipoFuenteFinanciacion;
    }
    public void setTipoFuenteFinanciacion(TipoFuenteFinanciacion tipoFuenteFinanciacion) {
        this.tipoFuenteFinanciacion = tipoFuenteFinanciacion;
    }
    public String getObservacionesPresupuestoInfraestructura() {
        return observacionesPresupuestoInfraestructura;
    }
    public void setObservacionesPresupuestoInfraestructura(String observacionesPresupuestoInfraestructura) {
        this.observacionesPresupuestoInfraestructura = observacionesPresupuestoInfraestructura;
    }
    public ActividadProductoInfraestructura getActividadProductoInfraestructura() {
        return actividadProductoInfraestructura;
    }
    public void setActividadProductoInfraestructura(ActividadProductoInfraestructura actividadProductoInfraestructura) {
        this.actividadProductoInfraestructura = actividadProductoInfraestructura;
    }
    public Long getCantidadActividadProductoInfraestructura() {
        return cantidadActividadProductoInfraestructura;
    }
    public void setCantidadActividadProductoInfraestructura(Long cantidadActividadProductoInfraestructura) {
        this.cantidadActividadProductoInfraestructura = cantidadActividadProductoInfraestructura;
    }
    public String getValorCostoUnitarioCapituloProductoInfraestructura() {
        return valorCostoUnitarioCapituloProductoInfraestructura;
    }
    public void setValorCostoUnitarioCapituloProductoInfraestructura(String valorCostoUnitarioCapituloProductoInfraestructura) {
        this.valorCostoUnitarioCapituloProductoInfraestructura = valorCostoUnitarioCapituloProductoInfraestructura;
    }
    public String getNumeroAreaIntervencionInfraestructura() {
        return numeroAreaIntervencionInfraestructura;
    }
    public void setNumeroAreaIntervencionInfraestructura(String numeroAreaIntervencionInfraestructura) {
        this.numeroAreaIntervencionInfraestructura = numeroAreaIntervencionInfraestructura;
    }
    public String getNombreUnidadMedidaAreaIntervencionInfraestructura() {
        return nombreUnidadMedidaAreaIntervencionInfraestructura;
    }
    public void setNombreUnidadMedidaAreaIntervencionInfraestructura(String nombreUnidadMedidaAreaIntervencionInfraestructura) {
        this.nombreUnidadMedidaAreaIntervencionInfraestructura = nombreUnidadMedidaAreaIntervencionInfraestructura;
    }*/
}
