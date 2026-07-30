//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 02/06/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_PROVEEDORES_PRODUCTOS_O_SERVICIOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialProveedorProductoOServicio {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialProveedorProductoOServicio;
    
    @Column(name = "NUM_REG_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialProveedorProductoOServicio;
    
    @Column(name = "SIGLA_O_ACRONIMO_UNIDAD_MILITAR", columnDefinition = "VARCHAR2(250) NOT NULL")
    private String siglaOAcronimoUnidadMilitar;
    
    @Column(name = "NOMBRE_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String nombreTipoDocumentoIdentificacion;
    
    @Column(name = "NUMERO_DOCUMENTO_IDENTIFICACION_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numeroDocumentoIdentificacionProvProdOServ;
    
    @Column(name = "LUGAR_EXPEDICION_DOCUMENTO_IDENTIFICACION_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String lugarExpedicionDocumentoIdentificacionProvProdOServ;
    
    @Column(name = "NOMBRES_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String nombresProvProdOServ;
    
    @Column(name = "PRIMER_APELLIDO_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String primerApellidoProvProdOServ;
    
    @Column(name = "SEGUNDO_APELLIDO_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(255) NULL")
    private String segundoApellidoProvProdOServ;
    
    @Column(name = "DIRECCION_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String direccionProvProdOServ;
    
    @Column(name = "TELEFONO_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NULL")
    private String telefonoProvProdOServ;
    
    @Column(name = "MOVIL_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String movilProvProdOServ;
    
    @Column(name = "CORREO_ELECTRONICO_PERSONAL_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String correoElectronicoPersonalProvProdOServ;
    
    @Column(name = "CORREO_ELECTRONICO_INSTITUCIONAL_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NULL")
    private String correoElectronicoInstitucionalProvProdOServ;
    
    @Column(name = "PAIS_ORIGEN_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String paisOrigenProvProdOServ;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String departamentoOEstadoOrigenProvProdOServ;
    
    @Column(name = "CIUDAD_ORIGEN_PROV_PROD_O_SERV", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String ciudadOrigenProvProdOServ;
    
    @Column(name = "FECHA_H_M_S_INGRESO_PROV_PROD_O_SERV", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoProvProdOServ;
    
    @Column(name = "FECHA_H_M_S_MODIFICACION_PROV_PROD_O_SERV", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSModificacionProvProdOServ;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialProveedorProductoOServicio() {
        return idHistorialProveedorProductoOServicio;
    }
    public void setIdHistorialProveedorProductoOServicio(Long idHistorialProveedorProductoOServicio) {
        this.idHistorialProveedorProductoOServicio = idHistorialProveedorProductoOServicio;
    }
    public String getNumRegHistorialProveedorProductoOServicio() {
        return numRegHistorialProveedorProductoOServicio;
    }
    public void setNumRegHistorialProveedorProductoOServicio(String numRegHistorialProveedorProductoOServicio) {
        this.numRegHistorialProveedorProductoOServicio = numRegHistorialProveedorProductoOServicio;
    }
    public String getSiglaOAcronimoUnidadMilitar() {
        return siglaOAcronimoUnidadMilitar;
    }
    public void setSiglaOAcronimoUnidadMilitar(String siglaOAcronimoUnidadMilitar) {
        this.siglaOAcronimoUnidadMilitar = siglaOAcronimoUnidadMilitar;
    }
    public String getNombreTipoDocumentoIdentificacion() {
        return nombreTipoDocumentoIdentificacion;
    }
    public void setNombreTipoDocumentoIdentificacion(String nombreTipoDocumentoIdentificacion) {
        this.nombreTipoDocumentoIdentificacion = nombreTipoDocumentoIdentificacion;
    }
    public String getNumeroDocumentoIdentificacionProvProdOServ() {
        return numeroDocumentoIdentificacionProvProdOServ;
    }
    public void setNumeroDocumentoIdentificacionProvProdOServ(String numeroDocumentoIdentificacionProvProdOServ) {
        this.numeroDocumentoIdentificacionProvProdOServ = numeroDocumentoIdentificacionProvProdOServ;
    }
    public String getLugarExpedicionDocumentoIdentificacionProvProdOServ() {
        return lugarExpedicionDocumentoIdentificacionProvProdOServ;
    }
    public void setLugarExpedicionDocumentoIdentificacionProvProdOServ(String lugarExpedicionDocumentoIdentificacionProvProdOServ) {
        this.lugarExpedicionDocumentoIdentificacionProvProdOServ = lugarExpedicionDocumentoIdentificacionProvProdOServ;
    }
    public String getNombresProvProdOServ() {
        return nombresProvProdOServ;
    }
    public void setNombresProvProdOServ(String nombresProvProdOServ) {
        this.nombresProvProdOServ = nombresProvProdOServ;
    }
    public String getPrimerApellidoProvProdOServ() {
        return primerApellidoProvProdOServ;
    }
    public void setPrimerApellidoProvProdOServ(String primerApellidoProvProdOServ) {
        this.primerApellidoProvProdOServ = primerApellidoProvProdOServ;
    }
    public String getSegundoApellidoProvProdOServ() {
        return segundoApellidoProvProdOServ;
    }
    public void setSegundoApellidoProvProdOServ(String segundoApellidoProvProdOServ) {
        this.segundoApellidoProvProdOServ = segundoApellidoProvProdOServ;
    }
    public String getDireccionProvProdOServ() {
        return direccionProvProdOServ;
    }
    public void setDireccionProvProdOServ(String direccionProvProdOServ) {
        this.direccionProvProdOServ = direccionProvProdOServ;
    }
    public String getTelefonoProvProdOServ() {
        return telefonoProvProdOServ;
    }
    public void setTelefonoProvProdOServ(String telefonoProvProdOServ) {
        this.telefonoProvProdOServ = telefonoProvProdOServ;
    }
    public String getMovilProvProdOServ() {
        return movilProvProdOServ;
    }
    public void setMovilProvProdOServ(String movilProvProdOServ) {
        this.movilProvProdOServ = movilProvProdOServ;
    }
    public String getCorreoElectronicoPersonalProvProdOServ() {
        return correoElectronicoPersonalProvProdOServ;
    }
    public void setCorreoElectronicoPersonalProvProdOServ(String correoElectronicoPersonalProvProdOServ) {
        this.correoElectronicoPersonalProvProdOServ = correoElectronicoPersonalProvProdOServ;
    }
    public String getCorreoElectronicoInstitucionalProvProdOServ() {
        return correoElectronicoInstitucionalProvProdOServ;
    }
    public void setCorreoElectronicoInstitucionalProvProdOServ(String correoElectronicoInstitucionalProvProdOServ) {
        this.correoElectronicoInstitucionalProvProdOServ = correoElectronicoInstitucionalProvProdOServ;
    }
    public String getPaisOrigenProvProdOServ() {
        return paisOrigenProvProdOServ;
    }
    public void setPaisOrigenProvProdOServ(String paisOrigenProvProdOServ) {
        this.paisOrigenProvProdOServ = paisOrigenProvProdOServ;
    }
    public String getDepartamentoOEstadoOrigenProvProdOServ() {
        return departamentoOEstadoOrigenProvProdOServ;
    }
    public void setDepartamentoOEstadoOrigenProvProdOServ(String departamentoOEstadoOrigenProvProdOServ) {
        this.departamentoOEstadoOrigenProvProdOServ = departamentoOEstadoOrigenProvProdOServ;
    }
    public String getCiudadOrigenProvProdOServ() {
        return ciudadOrigenProvProdOServ;
    }
    public void setCiudadOrigenProvProdOServ(String ciudadOrigenProvProdOServ) {
        this.ciudadOrigenProvProdOServ = ciudadOrigenProvProdOServ;
    }
    public Date getFechaHMSIngresoProvProdOServ() {
        return fechaHMSIngresoProvProdOServ;
    }
    public void setFechaHMSIngresoProvProdOServ(Date fechaHMSIngresoProvProdOServ) {
        this.fechaHMSIngresoProvProdOServ = fechaHMSIngresoProvProdOServ;
    }
    public Date getFechaHMSModificacionProvProdOServ() {
        return fechaHMSModificacionProvProdOServ;
    }
    public void setFechaHMSModificacionProvProdOServ(Date fechaHMSModificacionProvProdOServ) {
        this.fechaHMSModificacionProvProdOServ = fechaHMSModificacionProvProdOServ;
    }*/
}
