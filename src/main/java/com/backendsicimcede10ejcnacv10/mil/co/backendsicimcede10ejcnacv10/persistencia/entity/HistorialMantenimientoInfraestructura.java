//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_MANTENIMIENTOS_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialMantenimientoInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialMantenimientoInfraestructura;
    
    @Column(name = "NUM_REG_HISTORIAL_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialMantenimientoInfraestructura;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    //@Column(name = "ID_TIPO_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoMantenimientoInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura;
    
    @Column(name = "ASUNTO_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition="CLOB NOT NULL")
    private String asuntoMantenimientoInfraestructura;
    
    @Column(name = "DESCRIPCION_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition="CLOB NOT NULL")
    private String descripcionMantenimientoInfraestructura;
    
    @Column(name = "FECHA_H_M_S_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSMantenimientoInfraestructura;
    
    @Column(name = "VALOR_COSTO_MANTENIMIENTO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NULL")
    private String valorCostoMantenimientoInfraestructura;
    
    //@Column(name = "ID_TIPO_FUENTE_FINANCIACION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoFuenteFinanciacion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_FUENTE_FINANCIACION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoFuenteFinanciacion tipoFuenteFinanciacion;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialMantenimientoInfraestructura() {
        return idHistorialMantenimientoInfraestructura;
    }
    public void setIdHistorialMantenimientoInfraestructura(Long idHistorialMantenimientoInfraestructura) {
        this.idHistorialMantenimientoInfraestructura = idHistorialMantenimientoInfraestructura;
    }
    public String getNumRegHistorialMantenimientoInfraestructura() {
        return numRegHistorialMantenimientoInfraestructura;
    }
    public void setNumRegHistorialMantenimientoInfraestructura(String numRegHistorialMantenimientoInfraestructura) {
        this.numRegHistorialMantenimientoInfraestructura = numRegHistorialMantenimientoInfraestructura;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public TipoMantenimientoInfraestructura getTipoMantenimientoInfraestructura() {
        return tipoMantenimientoInfraestructura;
    }
    public void setTipoMantenimientoInfraestructura(TipoMantenimientoInfraestructura tipoMantenimientoInfraestructura) {
        this.tipoMantenimientoInfraestructura = tipoMantenimientoInfraestructura;
    }
    public String getAsuntoMantenimientoInfraestructura() {
        return asuntoMantenimientoInfraestructura;
    }
    public void setAsuntoMantenimientoInfraestructura(String asuntoMantenimientoInfraestructura) {
        this.asuntoMantenimientoInfraestructura = asuntoMantenimientoInfraestructura;
    }
    public String getDescripcionMantenimientoInfraestructura() {
        return descripcionMantenimientoInfraestructura;
    }
    public void setDescripcionMantenimientoInfraestructura(String descripcionMantenimientoInfraestructura) {
        this.descripcionMantenimientoInfraestructura = descripcionMantenimientoInfraestructura;
    }
    public Date getFechaHMSMantenimientoInfraestructura() {
        return fechaHMSMantenimientoInfraestructura;
    }
    public void setFechaHMSMantenimientoInfraestructura(Date fechaHMSMantenimientoInfraestructura) {
        this.fechaHMSMantenimientoInfraestructura = fechaHMSMantenimientoInfraestructura;
    }
    public String getValorCostoMantenimientoInfraestructura() {
        return valorCostoMantenimientoInfraestructura;
    }
    public void setValorCostoMantenimientoInfraestructura(String valorCostoMantenimientoInfraestructura) {
        this.valorCostoMantenimientoInfraestructura = valorCostoMantenimientoInfraestructura;
    }
    public TipoFuenteFinanciacion getTipoFuenteFinanciacion() {
        return tipoFuenteFinanciacion;
    }
    public void setTipoFuenteFinanciacion(TipoFuenteFinanciacion tipoFuenteFinanciacion) {
        this.tipoFuenteFinanciacion = tipoFuenteFinanciacion;
    }*/
}
