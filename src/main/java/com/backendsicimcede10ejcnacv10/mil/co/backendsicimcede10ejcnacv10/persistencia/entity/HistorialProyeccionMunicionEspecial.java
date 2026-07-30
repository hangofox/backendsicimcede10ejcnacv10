//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_PROYECCIONES_MUNICIONES_ESPECIALES")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialProyeccionMunicionEspecial {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_PROYECCION_MUNICION_ESPECIAL", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialProyeccionMunicionEspecial;
    
    @Column(name = "NUM_REG_HISTORIAL_PROYECCION_MUNICION_ESPECIAL", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialProyeccionMunicionEspecial;
    
    //@Column(name = "ID_MUNICION_ESPECIAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idMunicionEspecial;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_MUNICION_ESPECIAL", columnDefinition = "NUMBER(20) NOT NULL")
    private MunicionEspecial municionEspecial;
    
    @Column(name = "VALOR_TOTAL_HISTORIAL_PROYECCION_MUNICION_ESPECIAL", columnDefinition = "VARCHAR2(150) NULL")
    private String valorTotalHistorialProyeccionMunicionEspecial;
    
    @Column(name = "NUMERO_RUBRO_PRESUPUESTAL_HIST_PROY_MUN_ESP", columnDefinition = "VARCHAR2(150) NULL")
    private String numeroRubroPresupuestalHistProyMunEsp;
    
    @Column(name = "NOMBRE_BIEN_O_SERVICIO_HISTORIAL_PROYECCION_MUNICION_ESPECIAL", columnDefinition = "VARCHAR2(250) NOT NULL")
    private String nombreBienOServicioHistorialProyeccionMunicionEspecial;
    
    @Column(name = "CANTIDAD_SOLICITADA_HISTORIAL_PROYECCION_MUNICION_ESPECIAL", columnDefinition = "NUMBER(20) NOT NULL")
    private Long cantidadSolicitadaHistorialProyeccionMunicionEspecial;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialProyeccionMunicionEspecial() {
        return idHistorialProyeccionMunicionEspecial;
    }
    public void setIdHistorialProyeccionMunicionEspecial(Long idHistorialProyeccionMunicionEspecial) {
        this.idHistorialProyeccionMunicionEspecial = idHistorialProyeccionMunicionEspecial;
    }
    public String getNumRegHistorialProyeccionMunicionEspecial() {
        return numRegHistorialProyeccionMunicionEspecial;
    }
    public void setNumRegHistorialProyeccionMunicionEspecial(String numRegHistorialProyeccionMunicionEspecial) {
        this.numRegHistorialProyeccionMunicionEspecial = numRegHistorialProyeccionMunicionEspecial;
    }
    public MunicionEspecial getMunicionEspecial() {
        return municionEspecial;
    }
    public void setMunicionEspecial(MunicionEspecial municionEspecial) {
        this.municionEspecial = municionEspecial;
    }
    public String getValorTotalHistorialProyeccionMunicionEspecial() {
        return valorTotalHistorialProyeccionMunicionEspecial;
    }
    public void setValorTotalHistorialProyeccionMunicionEspecial(String valorTotalHistorialProyeccionMunicionEspecial) {
        this.valorTotalHistorialProyeccionMunicionEspecial = valorTotalHistorialProyeccionMunicionEspecial;
    }
    public String getNumeroRubroPresupuestalHistProyMunEsp() {
        return numeroRubroPresupuestalHistProyMunEsp;
    }
    public void setNumeroRubroPresupuestalHistProyMunEsp(String numeroRubroPresupuestalHistProyMunEsp) {
        this.numeroRubroPresupuestalHistProyMunEsp = numeroRubroPresupuestalHistProyMunEsp;
    }
    public String getNombreBienOServicioHistorialProyeccionMunicionEspecial() {
        return nombreBienOServicioHistorialProyeccionMunicionEspecial;
    }
    public void setNombreBienOServicioHistorialProyeccionMunicionEspecial(String nombreBienOServicioHistorialProyeccionMunicionEspecial) {
        this.nombreBienOServicioHistorialProyeccionMunicionEspecial = nombreBienOServicioHistorialProyeccionMunicionEspecial;
    }
    public Long getCantidadSolicitadaHistorialProyeccionMunicionEspecial() {
        return cantidadSolicitadaHistorialProyeccionMunicionEspecial;
    }
    public void setCantidadSolicitadaHistorialProyeccionMunicionEspecial(Long cantidadSolicitadaHistorialProyeccionMunicionEspecial) {
        this.cantidadSolicitadaHistorialProyeccionMunicionEspecial = cantidadSolicitadaHistorialProyeccionMunicionEspecial;
    }*/
}
