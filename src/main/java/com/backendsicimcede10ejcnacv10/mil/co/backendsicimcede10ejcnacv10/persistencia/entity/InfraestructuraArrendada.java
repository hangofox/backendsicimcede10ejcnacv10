//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_INFRAESTRUCTURAS_ARRENDADAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class InfraestructuraArrendada {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INFRAESTRUCTURA_ARRENDADA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idInfraestructuraArrendada;
    
    //@Column(name = "ID_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idHistorialProveedorProductoOServicio;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "NUMBER(20) NOT NULL")
    private HistorialProveedorProductoOServicio historialProveedorProductoOServicio;
    
    @Column(name = "DENOMINACION_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String denominacionInfraestructuraArrendada;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    //@Column(name = "ID_TIPO_ESTRUCTURA_INFRAESTRUCTURA_ARRENDADA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoEstructuraInfraestructuraArrendada;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_ESTRUCTURA_INFRAESTRUCTURA_ARRENDADA", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada;
    
    @Column(name = "PAIS_ORIGEN_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String paisOrigenInfraestructuraArrendada;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String departamentoOEstadoOrigenInfraestructuraArrendada;
    
    @Column(name = "CIUDAD_ORIGEN_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String ciudadOrigenInfraestructuraArrendada;
    
    @Column(name = "DIRECCION_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String direccionInfraestructuraArrendada;
    
    @Column(name = "NUMERO_LARGO_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroLargoInfraestructuraArrendada;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_LARGO_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaLargoInfraestructuraArrendada;
    
    @Column(name = "NUMERO_ANCHURA_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroAnchuraInfraestructuraArrendada;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_ANCHURA_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaAnchuraInfraestructuraArrendada;
    
    @Column(name = "NUMERO_PROFUNDIDAD_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroProfundidadInfraestructuraArrendada;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_PROFUNDIDAD_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaProfundidadInfraestructuraArrendada;
    
    @Column(name = "NUMERO_PISOS_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroPisosInfraestructuraArrendada;
    
    @Column(name = "ESTADO_USO_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String estadoUsoInfraestructuraArrendada;
    
    @Column(name = "LATITUD_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String latitudInfraestructuraArrendada;
    
    @Column(name = "LONGITUD_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String longitudInfraestructuraArrendada;
    
    @Column(name = "ESTRATO_INFRAESTRUCTURA_ARRENDADA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String estratoInfraestructuraArrendada;
    
    @Column(name = "FECHA_H_M_S_INGRESO_INFRAESTRUCTURA_ARRENDADA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoInfraestructuraArrendada;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_INFRAESTRUCTURA_ARRENDADA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionInfraestructuraArrendada;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdInfraestructuraArrendada() {
        return idInfraestructuraArrendada;
    }
    public void setIdInfraestructuraArrendada(Long idInfraestructuraArrendada) {
        this.idInfraestructuraArrendada = idInfraestructuraArrendada;
    }
    public HistorialProveedorProductoOServicio getHistorialProveedorProductoOServicio() {
        return historialProveedorProductoOServicio;
    }
    public void setHistorialProveedorProductoOServicio(HistorialProveedorProductoOServicio historialProveedorProductoOServicio) {
        this.historialProveedorProductoOServicio = historialProveedorProductoOServicio;
    }
    public String getDenominacionInfraestructuraArrendada() {
        return denominacionInfraestructuraArrendada;
    }
    public void setDenominacionInfraestructuraArrendada(String denominacionInfraestructuraArrendada) {
        this.denominacionInfraestructuraArrendada = denominacionInfraestructuraArrendada;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public TipoEstructuraInfraestructuraArrendada getTipoEstructuraInfraestructuraArrendada() {
        return tipoEstructuraInfraestructuraArrendada;
    }
    public void setTipoEstructuraInfraestructuraArrendada(TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada) {
        this.tipoEstructuraInfraestructuraArrendada = tipoEstructuraInfraestructuraArrendada;
    }
    public String getPaisOrigenInfraestructuraArrendada() {
        return paisOrigenInfraestructuraArrendada;
    }
    public void setPaisOrigenInfraestructuraArrendada(String paisOrigenInfraestructuraArrendada) {
        this.paisOrigenInfraestructuraArrendada = paisOrigenInfraestructuraArrendada;
    }
    public String getDepartamentoOEstadoOrigenInfraestructuraArrendada() {
        return departamentoOEstadoOrigenInfraestructuraArrendada;
    }
    public void setDepartamentoOEstadoOrigenInfraestructuraArrendada(String departamentoOEstadoOrigenInfraestructuraArrendada) {
        this.departamentoOEstadoOrigenInfraestructuraArrendada = departamentoOEstadoOrigenInfraestructuraArrendada;
    }
    public String getCiudadOrigenInfraestructuraArrendada() {
        return ciudadOrigenInfraestructuraArrendada;
    }
    public void setCiudadOrigenInfraestructuraArrendada(String ciudadOrigenInfraestructuraArrendada) {
        this.ciudadOrigenInfraestructuraArrendada = ciudadOrigenInfraestructuraArrendada;
    }
    public String getDireccionInfraestructuraArrendada() {
        return direccionInfraestructuraArrendada;
    }
    public void setDireccionInfraestructuraArrendada(String direccionInfraestructuraArrendada) {
        this.direccionInfraestructuraArrendada = direccionInfraestructuraArrendada;
    }
    public String getNumeroLargoInfraestructuraArrendada() {
        return numeroLargoInfraestructuraArrendada;
    }
    public void setNumeroLargoInfraestructuraArrendada(String numeroLargoInfraestructuraArrendada) {
        this.numeroLargoInfraestructuraArrendada = numeroLargoInfraestructuraArrendada;
    }
    public String getNombreUnidadMedidaLargoInfraestructuraArrendada() {
        return nombreUnidadMedidaLargoInfraestructuraArrendada;
    }
    public void setNombreUnidadMedidaLargoInfraestructuraArrendada(String nombreUnidadMedidaLargoInfraestructuraArrendada) {
        this.nombreUnidadMedidaLargoInfraestructuraArrendada = nombreUnidadMedidaLargoInfraestructuraArrendada;
    }
    public String getNumeroAnchuraInfraestructuraArrendada() {
        return numeroAnchuraInfraestructuraArrendada;
    }
    public void setNumeroAnchuraInfraestructuraArrendada(String numeroAnchuraInfraestructuraArrendada) {
        this.numeroAnchuraInfraestructuraArrendada = numeroAnchuraInfraestructuraArrendada;
    }
    public String getNombreUnidadMedidaAnchuraInfraestructuraArrendada() {
        return nombreUnidadMedidaAnchuraInfraestructuraArrendada;
    }
    public void setNombreUnidadMedidaAnchuraInfraestructuraArrendada(String nombreUnidadMedidaAnchuraInfraestructuraArrendada) {
        this.nombreUnidadMedidaAnchuraInfraestructuraArrendada = nombreUnidadMedidaAnchuraInfraestructuraArrendada;
    }
    public String getNumeroProfundidadInfraestructuraArrendada() {
        return numeroProfundidadInfraestructuraArrendada;
    }
    public void setNumeroProfundidadInfraestructuraArrendada(String numeroProfundidadInfraestructuraArrendada) {
        this.numeroProfundidadInfraestructuraArrendada = numeroProfundidadInfraestructuraArrendada;
    }
    public String getNombreUnidadMedidaProfundidadInfraestructuraArrendada() {
        return nombreUnidadMedidaProfundidadInfraestructuraArrendada;
    }
    public void setNombreUnidadMedidaProfundidadInfraestructuraArrendada(String nombreUnidadMedidaProfundidadInfraestructuraArrendada) {
        this.nombreUnidadMedidaProfundidadInfraestructuraArrendada = nombreUnidadMedidaProfundidadInfraestructuraArrendada;
    }
    public String getNumeroPisosInfraestructuraArrendada() {
        return numeroPisosInfraestructuraArrendada;
    }
    public void setNumeroPisosInfraestructuraArrendada(String numeroPisosInfraestructuraArrendada) {
        this.numeroPisosInfraestructuraArrendada = numeroPisosInfraestructuraArrendada;
    }
    public String getEstadoUsoInfraestructuraArrendada() {
        return estadoUsoInfraestructuraArrendada;
    }
    public void setEstadoUsoInfraestructuraArrendada(String estadoUsoInfraestructuraArrendada) {
        this.estadoUsoInfraestructuraArrendada = estadoUsoInfraestructuraArrendada;
    }
    public String getLatitudInfraestructuraArrendada() {
        return latitudInfraestructuraArrendada;
    }
    public void setLatitudInfraestructuraArrendada(String latitudInfraestructuraArrendada) {
        this.latitudInfraestructuraArrendada = latitudInfraestructuraArrendada;
    }
    public String getLongitudInfraestructuraArrendada() {
        return longitudInfraestructuraArrendada;
    }
    public void setLongitudInfraestructuraArrendada(String longitudInfraestructuraArrendada) {
        this.longitudInfraestructuraArrendada = longitudInfraestructuraArrendada;
    }
    public String getEstratoInfraestructuraArrendada() {
        return estratoInfraestructuraArrendada;
    }
    public void setEstratoInfraestructuraArrendada(String estratoInfraestructuraArrendada) {
        this.estratoInfraestructuraArrendada = estratoInfraestructuraArrendada;
    }
    public Date getFechaHMSIngresoInfraestructuraArrendada() {
        return fechaHMSIngresoInfraestructuraArrendada;
    }
    public void setFechaHMSIngresoInfraestructuraArrendada(Date fechaHMSIngresoInfraestructuraArrendada) {
        this.fechaHMSIngresoInfraestructuraArrendada = fechaHMSIngresoInfraestructuraArrendada;
    }
    public Date getFechaHMSModificacionInfraestructuraArrendada() {
        return fechaHMSModificacionInfraestructuraArrendada;
    }
    public void setFechaHMSModificacionInfraestructuraArrendada(Date fechaHMSModificacionInfraestructuraArrendada) {
        this.fechaHMSModificacionInfraestructuraArrendada = fechaHMSModificacionInfraestructuraArrendada;
    }*/
}
