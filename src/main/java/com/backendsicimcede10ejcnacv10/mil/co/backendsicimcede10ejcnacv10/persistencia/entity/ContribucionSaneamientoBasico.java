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
@Table(name = "TABLA_CONTRIBUCIONES_SANEAMIENTOS_BASICOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ContribucionSaneamientoBasico {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_CONTRIBUCION_SANEAMIENTO_BASICO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idContribucionSaneamientoBasico;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    //@Column(name = "ID_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idHistorialProveedorProductoOServicio;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_HISTORIAL_PROVEEDOR_PRODUCTO_O_SERVICIO", columnDefinition = "NUMBER(20) NOT NULL")
    private HistorialProveedorProductoOServicio historialProveedorProductoOServicio;
    
    //@Column(name = "ID_TIPO_CONTRIBUCION_SANEAMIENTO_BASICO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoContribucionSaneamientoBasico;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_CONTRIBUCION_SANEAMIENTO_BASICO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico;
    
    @Column(name = "VALOR_PAGO_CONTRIBUCION_SANEAMIENTO_BASICO", columnDefinition="VARCHAR2(150) NULL")
    private String valorPagoContribucionSaneamientoBasico;
    
    @Column(name = "FECHA_H_M_S_CONTRIBUCION_SANEAMIENTO_BASICO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSContribucionSaneamientoBasico;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_FACT_CONTRIB_SAN_BAS", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoFactContribSanBas;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdContribucionSaneamientoBasico() {
        return idContribucionSaneamientoBasico;
    }
    public void setIdContribucionSaneamientoBasico(Long idContribucionSaneamientoBasico) {
        this.idContribucionSaneamientoBasico = idContribucionSaneamientoBasico;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public HistorialProveedorProductoOServicio getHistorialProveedorProductoOServicio() {
        return historialProveedorProductoOServicio;
    }
    public void setHistorialProveedorProductoOServicio(HistorialProveedorProductoOServicio historialProveedorProductoOServicio) {
        this.historialProveedorProductoOServicio = historialProveedorProductoOServicio;
    }
    public TipoContribucionSaneamientoBasico getTipoContribucionSaneamientoBasico() {
        return tipoContribucionSaneamientoBasico;
    }
    public void setTipoContribucionSaneamientoBasico(TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico) {
        this.tipoContribucionSaneamientoBasico = tipoContribucionSaneamientoBasico;
    }
    public String getValorPagoContribucionSaneamientoBasico() {
        return valorPagoContribucionSaneamientoBasico;
    }
    public void setValorPagoContribucionSaneamientoBasico(String valorPagoContribucionSaneamientoBasico) {
        this.valorPagoContribucionSaneamientoBasico = valorPagoContribucionSaneamientoBasico;
    }
    public Date getFechaHMSContribucionSaneamientoBasico() {
        return fechaHMSContribucionSaneamientoBasico;
    }
    public void setFechaHMSContribucionSaneamientoBasico(Date fechaHMSContribucionSaneamientoBasico) {
        this.fechaHMSContribucionSaneamientoBasico = fechaHMSContribucionSaneamientoBasico;
    }
    public String getNombreArchivoDocumentoAnexoFactContribSanBas() {
        return nombreArchivoDocumentoAnexoFactContribSanBas;
    }
    public void setNombreArchivoDocumentoAnexoFactContribSanBas(String nombreArchivoDocumentoAnexoFactContribSanBas) {
        this.nombreArchivoDocumentoAnexoFactContribSanBas = nombreArchivoDocumentoAnexoFactContribSanBas;
    }*/
}
