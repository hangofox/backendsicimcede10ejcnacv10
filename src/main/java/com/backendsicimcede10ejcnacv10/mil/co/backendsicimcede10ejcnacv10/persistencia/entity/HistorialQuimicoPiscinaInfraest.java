//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_QUIMICOS_PISCINAS_INFRAEST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialQuimicoPiscinaInfraest {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_QUIMICO_PISCINA_INFRAEST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialQuimicoPiscinaInfraest;
    
    @Column(name = "NUM_REG_HISTORIAL_QUIMICO_PISCINA_INFRAEST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialQuimicoPiscinaInfraest;
    
    @Column(name = "NOMBRE_HISTORIAL_QUIMICO_PISCINA_INFRAEST", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreHistorialQuimicoPiscinaInfraest;
    
    //@Column(name = "ID_OFICINA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idOficina;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_OFICINA", columnDefinition = "NUMBER(20) NOT NULL")
    private Oficina oficina;
    
    @Column(name = "CENTRO_COSTO_OFICINA_QUIMICO_PISCINA_INFRAEST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String centroCostoOficinaQuimicoPiscinaInfraest;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    @Column(name = "FECHA_H_M_S_INGRESO_QUIMICO_PISCINA_INFRAEST", columnDefinition="TIMESTAMP NOT NULL")
    private Date fechaHMSIngresoQuimicoPiscinaInfraest;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_QUIMICO_PISCINA_INFRAEST", columnDefinition="TIMESTAMP NOT NULL")
    private Date fechaHMSModificacionQuimicoPiscinaInfraest;
    
    public Long getIdHistorialQuimicoPiscinaInfraest() {
        return idHistorialQuimicoPiscinaInfraest;
    }
    public void setIdHistorialQuimicoPiscinaInfraest(Long idHistorialQuimicoPiscinaInfraest) {
        this.idHistorialQuimicoPiscinaInfraest = idHistorialQuimicoPiscinaInfraest;
    }
    public String getNumRegHistorialQuimicoPiscinaInfraest() {
        return numRegHistorialQuimicoPiscinaInfraest;
    }
    public void setNumRegHistorialQuimicoPiscinaInfraest(String numRegHistorialQuimicoPiscinaInfraest) {
        this.numRegHistorialQuimicoPiscinaInfraest = numRegHistorialQuimicoPiscinaInfraest;
    }
    public String getNombreHistorialQuimicoPiscinaInfraest() {
        return nombreHistorialQuimicoPiscinaInfraest;
    }
    public void setNombreHistorialQuimicoPiscinaInfraest(String nombreHistorialQuimicoPiscinaInfraest) {
        this.nombreHistorialQuimicoPiscinaInfraest = nombreHistorialQuimicoPiscinaInfraest;
    }
    public Oficina getOficina() {
        return oficina;
    }
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public String getCentroCostoOficinaQuimicoPiscinaInfraest() {
        return centroCostoOficinaQuimicoPiscinaInfraest;
    }
    public void setCentroCostoOficinaQuimicoPiscinaInfraest(String centroCostoOficinaQuimicoPiscinaInfraest) {
        this.centroCostoOficinaQuimicoPiscinaInfraest = centroCostoOficinaQuimicoPiscinaInfraest;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public Date getFechaHMSIngresoQuimicoPiscinaInfraest() {
        return fechaHMSIngresoQuimicoPiscinaInfraest;
    }
    public void setFechaHMSIngresoQuimicoPiscinaInfraest(Date fechaHMSIngresoQuimicoPiscinaInfraest) {
        this.fechaHMSIngresoQuimicoPiscinaInfraest = fechaHMSIngresoQuimicoPiscinaInfraest;
    }
    public Date getFechaHMSModificacionQuimicoPiscinaInfraest() {
        return fechaHMSModificacionQuimicoPiscinaInfraest;
    }
    public void setFechaHMSModificacionQuimicoPiscinaInfraest(Date fechaHMSModificacionQuimicoPiscinaInfraest) {
        this.fechaHMSModificacionQuimicoPiscinaInfraest = fechaHMSModificacionQuimicoPiscinaInfraest;
    }
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialQuimicoPiscinaInfraest() {
        return idHistorialQuimicoPiscinaInfraest;
    }
    public void setIdHistorialQuimicoPiscinaInfraest(Long idHostorialQuimicoPiscinaInfraest) {
        this.idHistorialQuimicoPiscinaInfraest = idHistorialQuimicoPiscinaInfraest;
    }
    public String getNombreHistorialQuimicoPiscinaInfraest() {
        return nombreHistorialQuimicoPiscinaInfraest;
    }
    public void setNombreHistorialQuimicoPiscinaInfraest(String nombreHistorialQuimicoPiscinaInfraest) {
        this.nombreHistorialQuimicoPiscinaInfraest = nombreHistorialQuimicoPiscinaInfraest;
    }
    public Oficina getOficina() {
        return oficina;
    }
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public String getCentroCostoOficinaQuimicoPiscinaInfraest() {
        return centroCostoOficinaQuimicoPiscinaInfraest;
    }
    public void setCentroCostoOficinaQuimicoPiscinaInfraest(String centroCostoOficinaQuimicoPiscinaInfraest) {
        this.centroCostoOficinaQuimicoPiscinaInfraest = centroCostoOficinaQuimicoPiscinaInfraest;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public Date getFechaHMSIngresoQuimicoPiscinaInfraest() {
        return fechaHMSIngresoQuimicoPiscinaInfraest;
    }
    public void setFechaHMSIngresoQuimicoPiscinaInfraest(Date fechaHMSIngresoQuimicoPiscinaInfraest) {
        this.fechaHMSIngresoQuimicoPiscinaInfraest = fechaHMSIngresoQuimicoPiscinaInfraest;
    }
    public Date getFechaHMSModificacionQuimicoPiscinaInfraest() {
        return fechaHMSModificacionQuimicoPiscinaInfraest;
    }
    public void setFechaHMSModificacionQuimicoPiscinaInfraest(Date fechaHMSModificacionQuimicoPiscinaInfraest) {
        this.fechaHMSModificacionQuimicoPiscinaInfraest = fechaHMSModificacionQuimicoPiscinaInfraest;
    }*/
}
