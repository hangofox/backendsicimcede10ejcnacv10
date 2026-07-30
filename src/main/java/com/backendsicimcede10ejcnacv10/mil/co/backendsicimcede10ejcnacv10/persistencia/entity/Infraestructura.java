//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class Infraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idInfraestructura;
    
    @Column(name = "DENOMINACION_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String denominacionInfraestructura;
    
    @Column(name = "NUMERO_INVENTARIO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NULL")
    private String numeroInventarioInfraestructura;
    
    @Column(name = "NUMERO_ACTIVO_FIJO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NULL")
    private String numeroActivoFijoInfraestructura;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "CENTRO_COSTO_UNIDAD_MILITAR_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NULL")
    private String centroCostoUnidadMilitarInfraestructura;
    
    //@Column(name = "ID_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSociedadUnidadCentralizadora;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition = "NUMBER(20) NOT NULL")
    private SociedadUnidadCentralizadora sociedadUnidadCentralizadora;
    
    //@Column(name = "ID_TIPO_ESTRUCTURA_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoEstructuraInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_ESTRUCTURA_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoEstructuraInfraestructura tipoEstructuraInfraestructura;
    
    //@Column(name = "ID_FUNCIONALIDAD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idFuncionalidadInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_FUNCIONALIDAD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private FuncionalidadInfraestructura funcionalidadInfraestructura;
    
    //@Column(name = "ID_SEGURO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSeguro;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SEGURO", columnDefinition = "NUMBER(20) NOT NULL")
    private Seguro seguro;
    
    @Column(name = "PAIS_ORIGEN_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String paisOrigenInfraestructura;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String departamentoOEstadoOrigenInfraestructura;
    
    @Column(name = "CIUDAD_ORIGEN_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String ciudadOrigenInfraestructura;
    
    @Column(name = "DIRECCION_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String direccionInfraestructura;
    
    @Column(name = "FECHA_H_M_S_AMORTIZACION_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSAmortizacionInfraestructura;
    
    @Column(name = "FECHA_H_M_S_ALTA_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSAltaInfraestructura;
    
    @Column(name = "NUMERO_LARGO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroLargoInfraestructura;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_LARGO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaLargoInfraestructura;
    
    @Column(name = "NUMERO_ANCHURA_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroAnchuraInfraestructura;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_ANCHURA_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaAnchuraInfraestructura;
    
    @Column(name = "NUMERO_PROFUNDIDAD_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroProfundidadInfraestructura;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_PROFUNDIDAD_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaProfundidadInfraestructura;
    
    @Column(name = "NUMERO_PISOS_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String numeroPisosInfraestructura;
    
    @Column(name = "ESTADO_USO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String estadoUsoInfraestructura;
    
    @Column(name = "LATITUD_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String latitudInfraestructura;
    
    @Column(name = "LONGITUD_INFRAESTRUCTURA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String longitudInfraestructura;
    
    @Column(name = "NORMA_SISMORESISTENTE_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String normaSismoresistenteInfraestructura;
    
    @Column(name = "PROPIEDAD_HORIZONTAL_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String propiedadHorizontalInfraestructura;
    
    @Column(name = "DENOMINACION_POSTERIOR_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String denominacionPosteriorInfraestructura;
    
    @Column(name = "ESTRATO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String estratoInfraestructura;
    
    @Column(name = "NUMERO_CUENTA_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroCuentaInfraestructura;
    
    @Column(name = "NUMERO_SUBCUENTA_INFRAESTRUCTURA", columnDefinition="VARCHAR2(255) NOT NULL")
    private String numeroSubcuentaInfraestructura;
    
    @Column(name = "VALOR_CONTABLE_INFRAESTRUCTURA", columnDefinition="VARCHAR2(150) NULL")
    private String valorContableInfraestructura;
    
    //@Column(name = "ID_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTerreno;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    private Terreno terreno;
    
    @Column(name = "FECHA_H_M_S_INGRESO_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoInfraestructura;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionInfraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdInfraestructura() {
        return idInfraestructura;
    }
    public void setIdInfraestructura(Long idInfraestructura) {
        this.idInfraestructura = idInfraestructura;
    }
    public String getDenominacionInfraestructura() {
        return denominacionInfraestructura;
    }
    public void setDenominacionInfraestructura(String denominacionInfraestructura) {
        this.denominacionInfraestructura = denominacionInfraestructura;
    }
    public String getNumeroInventarioInfraestructura() {
        return numeroInventarioInfraestructura;
    }
    public void setNumeroInventarioInfraestructura(String numeroInventarioInfraestructura) {
        this.numeroInventarioInfraestructura = numeroInventarioInfraestructura;
    }
    public String getNumeroActivoFijoInfraestructura() {
        return numeroActivoFijoInfraestructura;
    }
    public void setNumeroActivoFijoInfraestructura(String numeroActivoFijoInfraestructura) {
        this.numeroActivoFijoInfraestructura = numeroActivoFijoInfraestructura;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getCentroCostoUnidadMilitarInfraestructura() {
        return centroCostoUnidadMilitarInfraestructura;
    }
    public void setCentroCostoUnidadMilitarInfraestructura(String centroCostoUnidadMilitarInfraestructura) {
        this.centroCostoUnidadMilitarInfraestructura = centroCostoUnidadMilitarInfraestructura;
    }
    public SociedadUnidadCentralizadora getSociedadUnidadCentralizadora() {
        return sociedadUnidadCentralizadora;
    }
    public void setSociedadUnidadCentralizadora(SociedadUnidadCentralizadora sociedadUnidadCentralizadora) {
        this.sociedadUnidadCentralizadora = sociedadUnidadCentralizadora;
    }
    public TipoEstructuraInfraestructura getTipoEstructuraInfraestructura() {
        return tipoEstructuraInfraestructura;
    }
    public void setTipoEstructuraInfraestructura(TipoEstructuraInfraestructura tipoEstructuraInfraestructura) {
        this.tipoEstructuraInfraestructura = tipoEstructuraInfraestructura;
    }
    public FuncionalidadInfraestructura getFuncionalidadInfraestructura() {
        return funcionalidadInfraestructura;
    }
    public void setFuncionalidadInfraestructura(FuncionalidadInfraestructura funcionalidadInfraestructura) {
        this.funcionalidadInfraestructura = funcionalidadInfraestructura;
    }
    public Seguro getSeguro() {
        return seguro;
    }
    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    public String getPaisOrigenInfraestructura() {
        return paisOrigenInfraestructura;
    }
    public void setPaisOrigenInfraestructura(String paisOrigenInfraestructura) {
        this.paisOrigenInfraestructura = paisOrigenInfraestructura;
    }
    public String getDepartamentoOEstadoOrigenInfraestructura() {
        return departamentoOEstadoOrigenInfraestructura;
    }
    public void setDepartamentoOEstadoOrigenInfraestructura(String departamentoOEstadoOrigenInfraestructura) {
        this.departamentoOEstadoOrigenInfraestructura = departamentoOEstadoOrigenInfraestructura;
    }
    public String getCiudadOrigenInfraestructura() {
        return ciudadOrigenInfraestructura;
    }
    public void setCiudadOrigenInfraestructura(String ciudadOrigenInfraestructura) {
        this.ciudadOrigenInfraestructura = ciudadOrigenInfraestructura;
    }
    public String getDireccionInfraestructura() {
        return direccionInfraestructura;
    }
    public void setDireccionInfraestructura(String direccionInfraestructura) {
        this.direccionInfraestructura = direccionInfraestructura;
    }
    public Date getFechaHMSAmortizacionInfraestructura() {
        return fechaHMSAmortizacionInfraestructura;
    }
    public void setFechaHMSAmortizacionInfraestructura(Date fechaHMSAmortizacionInfraestructura) {
        this.fechaHMSAmortizacionInfraestructura = fechaHMSAmortizacionInfraestructura;
    }
    public Date getFechaHMSAltaInfraestructura() {
        return fechaHMSAltaInfraestructura;
    }
    public void setFechaHMSAltaInfraestructura(Date fechaHMSAltaInfraestructura) {
        this.fechaHMSAltaInfraestructura = fechaHMSAltaInfraestructura;
    }
    public String getNumeroLargoInfraestructura() {
        return numeroLargoInfraestructura;
    }
    public void setNumeroLargoInfraestructura(String numeroLargoInfraestructura) {
        this.numeroLargoInfraestructura = numeroLargoInfraestructura;
    }
    public String getNombreUnidadMedidaLargoInfraestructura() {
        return nombreUnidadMedidaLargoInfraestructura;
    }
    public void setNombreUnidadMedidaLargoInfraestructura(String nombreUnidadMedidaLargoInfraestructura) {
        this.nombreUnidadMedidaLargoInfraestructura = nombreUnidadMedidaLargoInfraestructura;
    }
    public String getNumeroAnchuraInfraestructura() {
        return numeroAnchuraInfraestructura;
    }
    public void setNumeroAnchuraInfraestructura(String numeroAnchuraInfraestructura) {
        this.numeroAnchuraInfraestructura = numeroAnchuraInfraestructura;
    }
    public String getNombreUnidadMedidaAnchuraInfraestructura() {
        return nombreUnidadMedidaAnchuraInfraestructura;
    }
    public void setNombreUnidadMedidaAnchuraInfraestructura(String nombreUnidadMedidaAnchuraInfraestructura) {
        this.nombreUnidadMedidaAnchuraInfraestructura = nombreUnidadMedidaAnchuraInfraestructura;
    }
    public String getNumeroProfundidadInfraestructura() {
        return numeroProfundidadInfraestructura;
    }
    public void setNumeroProfundidadInfraestructura(String numeroProfundidadInfraestructura) {
        this.numeroProfundidadInfraestructura = numeroProfundidadInfraestructura;
    }
    public String getNombreUnidadMedidaProfundidadInfraestructura() {
        return nombreUnidadMedidaProfundidadInfraestructura;
    }
    public void setNombreUnidadMedidaProfundidadInfraestructura(String nombreUnidadMedidaProfundidadInfraestructura) {
        this.nombreUnidadMedidaProfundidadInfraestructura = nombreUnidadMedidaProfundidadInfraestructura;
    }
    public String getNumeroPisosInfraestructura() {
        return numeroPisosInfraestructura;
    }
    public void setNumeroPisosInfraestructura(String numeroPisosInfraestructura) {
        this.numeroPisosInfraestructura = numeroPisosInfraestructura;
    }
    public String getEstadoUsoInfraestructura() {
        return estadoUsoInfraestructura;
    }
    public void setEstadoUsoInfraestructura(String estadoUsoInfraestructura) {
        this.estadoUsoInfraestructura = estadoUsoInfraestructura;
    }
    public String getLatitudInfraestructura() {
        return latitudInfraestructura;
    }
    public void setLatitudInfraestructura(String latitudInfraestructura) {
        this.latitudInfraestructura = latitudInfraestructura;
    }
    public String getLongitudInfraestructura() {
        return longitudInfraestructura;
    }
    public void setLongitudInfraestructura(String longitudInfraestructura) {
        this.longitudInfraestructura = longitudInfraestructura;
    }
    public String getNormaSismoresistenteInfraestructura() {
        return normaSismoresistenteInfraestructura;
    }
    public void setNormaSismoresistenteInfraestructura(String normaSismoresistenteInfraestructura) {
        this.normaSismoresistenteInfraestructura = normaSismoresistenteInfraestructura;
    }
    public String getPropiedadHorizontalInfraestructura() {
        return propiedadHorizontalInfraestructura;
    }
    public void setPropiedadHorizontalInfraestructura(String propiedadHorizontalInfraestructura) {
        this.propiedadHorizontalInfraestructura = propiedadHorizontalInfraestructura;
    }
    public String getDenominacionPosteriorInfraestructura() {
        return denominacionPosteriorInfraestructura;
    }
    public void setDenominacionPosteriorInfraestructura(String denominacionPosteriorInfraestructura) {
        this.denominacionPosteriorInfraestructura = denominacionPosteriorInfraestructura;
    }
    public String getEstratoInfraestructura() {
        return estratoInfraestructura;
    }
    public void setEstratoInfraestructura(String estratoInfraestructura) {
        this.estratoInfraestructura = estratoInfraestructura;
    }
    public String getNumeroCuentaInfraestructura() {
        return numeroCuentaInfraestructura;
    }
    public void setNumeroCuentaInfraestructura(String numeroCuentaInfraestructura) {
        this.numeroCuentaInfraestructura = numeroCuentaInfraestructura;
    }
    public String getNumeroSubcuentaInfraestructura() {
        return numeroSubcuentaInfraestructura;
    }
    public void setNumeroSubcuentaInfraestructura(String numeroSubcuentaInfraestructura) {
        this.numeroSubcuentaInfraestructura = numeroSubcuentaInfraestructura;
    }
    public String getValorContableInfraestructura() {
        return valorContableInfraestructura;
    }
    public void setValorContableInfraestructura(String valorContableInfraestructura) {
        this.valorContableInfraestructura = valorContableInfraestructura;
    }
    public Terreno getTerreno() {
        return terreno;
    }
    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
    public Date getFechaHMSIngresoInfraestructura() {
        return fechaHMSIngresoInfraestructura;
    }
    public void setFechaHMSIngresoInfraestructura(Date fechaHMSIngresoInfraestructura) {
        this.fechaHMSIngresoInfraestructura = fechaHMSIngresoInfraestructura;
    }
    public Date getFechaHMSModificacionInfraestructura() {
        return fechaHMSModificacionInfraestructura;
    }
    public void setFechaHMSModificacionInfraestructura(Date fechaHMSModificacionInfraestructura) {
        this.fechaHMSModificacionInfraestructura = fechaHMSModificacionInfraestructura;
    }*/
}
