//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_EQUIPOS_TOPOGRAFIAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class EquipoTopografia {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_EQUIPO_TOPOGRAFIA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idEquipoTopografia;
    
    @Column(name = "DENOMINACION_EQUIPO_TOPOGRAFIA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String denominacionEquipoTopografia;
    
    @Column(name = "NUMERO_INVENTARIO_EQUIPO_TOPOGRAFIA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroInventarioEquipoTopografia;
    
    @Column(name = "NUMERO_ACTIVO_FIJO_EQUIPO_TOPOGRAFIA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroActivoFijoEquipoTopografia;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "CENTRO_COSTO_UNIDAD_MILITAR_EQUIPO_TOPOGRAFIA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String centroCostoUnidadMilitarEquipoTopografia;
    
    @Column(name = "FECHA_H_M_S_INGRESO_EQUIPO_TOPOGRAFIA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoEquipoTopografia;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_EQUIPO_TOPOGRAFIA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionEquipoTopografia;
    
    @Column(name = "ESTADO_EQUIPO_TOPOGRAFIA", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String estadoEquipoTopografia;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdEquipoTopografia() {
        return idEquipoTopografia;
    }
    public void setIdEquipoTopografia(Long idEquipoTopografia) {
        this.idEquipoTopografia = idEquipoTopografia;
    }
    public String getDenominacionEquipoTopografia() {
        return denominacionEquipoTopografia;
    }
    public void setDenominacionEquipoTopografia(String denominacionEquipoTopografia) {
        this.denominacionEquipoTopografia = denominacionEquipoTopografia;
    }
    public String getNumeroInventarioEquipoTopografia() {
        return numeroInventarioEquipoTopografia;
    }
    public void setNumeroInventarioEquipoTopografia(String numeroInventarioEquipoTopografia) {
        this.numeroInventarioEquipoTopografia = numeroInventarioEquipoTopografia;
    }
    public String getNumeroActivoFijoEquipoTopografia() {
        return numeroActivoFijoEquipoTopografia;
    }
    public void setNumeroActivoFijoEquipoTopografia(String numeroActivoFijoEquipoTopografia) {
        this.numeroActivoFijoEquipoTopografia = numeroActivoFijoEquipoTopografia;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getCentroCostoUnidadMilitarEquipoTopografia() {
        return centroCostoUnidadMilitarEquipoTopografia;
    }
    public void setCentroCostoUnidadMilitarEquipoTopografia(String centroCostoUnidadMilitarEquipoTopografia) {
        this.centroCostoUnidadMilitarEquipoTopografia = centroCostoUnidadMilitarEquipoTopografia;
    }
    public Date getFechaHMSIngresoEquipoTopografia() {
        return fechaHMSIngresoEquipoTopografia;
    }
    public void setFechaHMSIngresoEquipoTopografia(Date fechaHMSIngresoEquipoTopografia) {
        this.fechaHMSIngresoEquipoTopografia = fechaHMSIngresoEquipoTopografia;
    }
    public Date getFechaHMSModificacionEquipoTopografia() {
        return fechaHMSModificacionEquipoTopografia;
    }
    public void setFechaHMSModificacionEquipoTopografia(Date fechaHMSModificacionEquipoTopografia) {
        this.fechaHMSModificacionEquipoTopografia = fechaHMSModificacionEquipoTopografia;
    }
    public String getEstadoEquipoTopografia() {
        return estadoEquipoTopografia;
    }
    public void setEstadoEquipoTopografia(String estadoEquipoTopografia) {
        this.estadoEquipoTopografia = estadoEquipoTopografia;
    }*/
}
