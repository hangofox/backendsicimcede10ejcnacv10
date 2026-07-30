//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_PAGOS_ANUALES_IMPUESTOS_TERRENOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialPagoAnualImpuestoTerreno {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_PAGO_ANUAL_IMPUESTO_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialPagoAnualImpuestoTerreno;
    
    @Column(name = "NUM_REG_HISTORIAL_PAGO_ANUAL_IMPUESTO_TERRENO", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialPagoAnualImpuestoTerreno;
    
    //@Column(name = "ID_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTerreno;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    private Terreno terreno;
    
    @Column(name = "VALOR_TOTAL_HISTORIAL_PAGO_ANUAL_IMPUESTO_TERRENO", columnDefinition = "VARCHAR2(150) NULL")
    private String valorTotalHistorialPagoAnualImpuestoTerreno;
    
    @Column(name = "FECHA_H_M_S_HISTORIAL_PAGO_ANUAL_IMPUESTO_TERRENO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSHistorialPagoAnualImpuestoTerreno;
    
    //@Column(name = "ID_TIPO_ENTIDAD_INSTITUCIONAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoEntidadInstitucional;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_ENTIDAD_INSTITUCIONAL", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoEntidadInstitucional tipoEntidadInstitucional;
    
    @Column(name = "NOMBRE_ENTIDAD_INSTITUCIONAL_PAGO_ANUAL_IMPUESTO_TERRENO", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String nombreEntidadInstitucionalPagoAnualImpuestoTerreno;
    
    @Column(name = "NUMERO_FACTURA_HISTORIAL_PAGO_ANUAL_IMPUESTO_TERRENO", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String numeroFacturaHistorialPagoAnualImpuestoTerreno;
    
    @Column(name = "SI_O_NO_REDUCCION_HISTORIAL_PAGO_ANUAL_IMPUESTO_TERRENO", columnDefinition = "VARCHAR2(50) NOT NULL")
    private String siONoReduccionHistorialPagoAnualImpuestoTerreno;
    
    //@Column(name = "ID_TIPO_REDUCCION_IMPUESTO_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoReduccionImpuestoTerreno;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_REDUCCION_IMPUESTO_TERRENO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno;
    
    @Column(name = "NUMERO_PORCENTAJE_REDUCC_HIST_PAG_AN_IMP_TERR", columnDefinition = "VARCHAR2(150) NULL")
    private String numeroPorcentajeReduccHistPagAnImpTerr;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_FACT_HIST_PAG_AN_IMP_TERR", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoDocumentoAnexoFactHistPagAnImpTerr;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialPagoAnualImpuestoTerreno() {
        return idHistorialPagoAnualImpuestoTerreno;
    }
    public void setIdHistorialPagoAnualImpuestoTerreno(Long idHistorialPagoAnualImpuestoTerreno) {
        this.idHistorialPagoAnualImpuestoTerreno = idHistorialPagoAnualImpuestoTerreno;
    }
    public String getNumRegHistorialPagoAnualImpuestoTerreno() {
        return numRegHistorialPagoAnualImpuestoTerreno;
    }
    public void setNumRegHistorialPagoAnualImpuestoTerreno(String numRegHistorialPagoAnualImpuestoTerreno) {
        this.numRegHistorialPagoAnualImpuestoTerreno = numRegHistorialPagoAnualImpuestoTerreno;
    }
    public Terreno getTerreno() {
        return terreno;
    }
    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
    public String getValorTotalHistorialPagoAnualImpuestoTerreno() {
        return valorTotalHistorialPagoAnualImpuestoTerreno;
    }
    public void setValorTotalHistorialPagoAnualImpuestoTerreno(String valorTotalHistorialPagoAnualImpuestoTerreno) {
        this.valorTotalHistorialPagoAnualImpuestoTerreno = valorTotalHistorialPagoAnualImpuestoTerreno;
    }
    public Date getFechaHMSHistorialPagoAnualImpuestoTerreno() {
        return fechaHMSHistorialPagoAnualImpuestoTerreno;
    }
    public void setFechaHMSHistorialPagoAnualImpuestoTerreno(Date fechaHMSHistorialPagoAnualImpuestoTerreno) {
        this.fechaHMSHistorialPagoAnualImpuestoTerreno = fechaHMSHistorialPagoAnualImpuestoTerreno;
    }
    public TipoEntidadInstitucional getTipoEntidadInstitucional() {
        return tipoEntidadInstitucional;
    }
    public void setTipoEntidadInstitucional(TipoEntidadInstitucional tipoEntidadInstitucional) {
        this.tipoEntidadInstitucional = tipoEntidadInstitucional;
    }
    public String getNombreEntidadInstitucionalPagoAnualImpuestoTerreno() {
        return nombreEntidadInstitucionalPagoAnualImpuestoTerreno;
    }
    public void setNombreEntidadInstitucionalPagoAnualImpuestoTerreno(String nombreEntidadInstitucionalPagoAnualImpuestoTerreno) {
        this.nombreEntidadInstitucionalPagoAnualImpuestoTerreno = nombreEntidadInstitucionalPagoAnualImpuestoTerreno;
    }
    public String getNumeroFacturaHistorialPagoAnualImpuestoTerreno() {
        return numeroFacturaHistorialPagoAnualImpuestoTerreno;
    }
    public void setNumeroFacturaHistorialPagoAnualImpuestoTerreno(String numeroFacturaHistorialPagoAnualImpuestoTerreno) {
        this.numeroFacturaHistorialPagoAnualImpuestoTerreno = numeroFacturaHistorialPagoAnualImpuestoTerreno;
    }
    public String getSiONoReduccionHistorialPagoAnualImpuestoTerreno() {
        return siONoReduccionHistorialPagoAnualImpuestoTerreno;
    }
    public void setSiONoReduccionHistorialPagoAnualImpuestoTerreno(String siONoReduccionHistorialPagoAnualImpuestoTerreno) {
        this.siONoReduccionHistorialPagoAnualImpuestoTerreno = siONoReduccionHistorialPagoAnualImpuestoTerreno;
    }
    public TipoReduccionImpuestoTerreno getTipoReduccionImpuestoTerreno() {
        return tipoReduccionImpuestoTerreno;
    }
    public void setTipoReduccionImpuestoTerreno(TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno) {
        this.tipoReduccionImpuestoTerreno = tipoReduccionImpuestoTerreno;
    }
    public String getNumeroPorcentajeReduccHistPagAnImpTerr() {
        return numeroPorcentajeReduccHistPagAnImpTerr;
    }
    public void setNumeroPorcentajeReduccHistPagAnImpTerr(String numeroPorcentajeReduccHistPagAnImpTerr) {
        this.numeroPorcentajeReduccHistPagAnImpTerr = numeroPorcentajeReduccHistPagAnImpTerr;
    }
    public String getNombreArchivoDocumentoAnexoFactHistPagAnImpTerr() {
        return nombreArchivoDocumentoAnexoFactHistPagAnImpTerr;
    }
    public void setNombreArchivoDocumentoAnexoFactHistPagAnImpTerr(String nombreArchivoDocumentoAnexoFactHistPagAnImpTerr) {
        this.nombreArchivoDocumentoAnexoFactHistPagAnImpTerr = nombreArchivoDocumentoAnexoFactHistPagAnImpTerr;
    }*/
}
