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
@Table(name = "TABLA_COMODATOS_TERRENOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ComodatoTerreno {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_COMODATO_TERRENO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idComodatoTerreno;
    
    //@Column(name = "ID_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTerreno;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    private Terreno terreno;
    
    @Column(name = "FECHA_H_M_S_INICIACION_COMODATO_TERRENO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionComodatoTerreno;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_COMODATO_TERRENO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionComodatoTerreno;
    
    //@Column(name = "ID_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idHistorialProveedorProductoOServicio;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "NUMBER(20) NOT NULL")
    private HistorialProveedorProductoOServicio historialProveedorProductoOServicio;
    
    @Column(name = "ESTADO_TERRENO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String estadoTerreno;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdComodatoTerreno() {
        return idComodatoTerreno;
    }
    public void setIdComodatoTerreno(Long idComodatoTerreno) {
        this.idComodatoTerreno = idComodatoTerreno;
    }
    public Terreno getTerreno() {
        return terreno;
    }
    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
    public Date getFechaHMSIniciacionComodatoTerreno() {
        return fechaHMSIniciacionComodatoTerreno;
    }
    public void setFechaHMSIniciacionComodatoTerreno(Date fechaHMSIniciacionComodatoTerreno) {
        this.fechaHMSIniciacionComodatoTerreno = fechaHMSIniciacionComodatoTerreno;
    }
    public Date getFechaHMSFinalizacionComodatoTerreno() {
        return fechaHMSFinalizacionComodatoTerreno;
    }
    public void setFechaHMSFinalizacionComodatoTerreno(Date fechaHMSFinalizacionComodatoTerreno) {
        this.fechaHMSFinalizacionComodatoTerreno = fechaHMSFinalizacionComodatoTerreno;
    }
    public HistorialProveedorProductoOServicio getHistorialProveedorProductoOServicio() {
        return historialProveedorProductoOServicio;
    }
    public void setHistorialProveedorProductoOServicio(HistorialProveedorProductoOServicio historialProveedorProductoOServicio) {
        this.historialProveedorProductoOServicio = historialProveedorProductoOServicio;
    }
    public String getEstadoTerreno() {
        return estadoTerreno;
    }
    public void setEstadoTerreno(String estadoTerreno) {
        this.estadoTerreno = estadoTerreno;
    }*/
}
