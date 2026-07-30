//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 10/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_PROYECCIONES_ANUALES_ADQ_SERV_PUBLIC")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialProyeccionAnualAdqServPublic {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_PROYECCION_ANUAL_ADQ_SERV_PUBLIC", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialProyeccionAnualAdqServPublic;
    
    @Column(name = "NUM_REG_HISTORIAL_PROYECCION_ANUAL_ADQ_SERV_PUBLIC", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialProyeccionAnualAdqServPublic;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    //@Column(name = "ID_TIPO_SERVICIO_PUBLICO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoServicioPublico;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_SERVICIO_PUBLICO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoServicioPublico tipoServicioPublico;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "VALOR_TOTAL_HISTORIAL_PAGO_ANUAL_ADQ_SERV_PUBLIC", columnDefinition="VARCHAR2(150) NULL")
    private String valorTotalHistorialPagoAnualAdqServPublic;
    
    @Column(name = "FECHA_H_M_S_HISTORIAL_PAGO_ANUAL_ADQ_SERV_PUBLIC", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSHistorialPagoAnualAdqServPublic;
    
    @Column(name = "TELEFONO_HISTORIAL_PAGO_ANUAL_ADQ_SERV_PUBLIC", columnDefinition="VARCHAR2(150) NULL")
    private String telefonoHistorialPagoAnualAdqServPublic;
    
    @Column(name = "MOVIL_HISTORIAL_PAGO_ANUAL_ADQ_SERV_PUBLIC", columnDefinition="VARCHAR2(150) NULL")
    private String movilHistorialPagoAnualAdqServPublic;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_FACT_HIST_PAG_AN_ADQ_SERV_PUBLIC", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdHistorialProyeccionAnualAdqServPublic() {
        return idHistorialProyeccionAnualAdqServPublic;
    }
    public void setIdHistorialProyeccionAnualAdqServPublic(Long idHistorialProyeccionAnualAdqServPublic) {
        this.idHistorialProyeccionAnualAdqServPublic = idHistorialProyeccionAnualAdqServPublic;
    }
    public String getNumRegHistorialProyeccionAnualAdqServPublic() {
        return numRegHistorialProyeccionAnualAdqServPublic;
    }
    public void setNumRegHistorialProyeccionAnualAdqServPublic(String numRegHistorialProyeccionAnualAdqServPublic) {
        this.numRegHistorialProyeccionAnualAdqServPublic = numRegHistorialProyeccionAnualAdqServPublic;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public TipoServicioPublico getTipoServicioPublico() {
        return tipoServicioPublico;
    }
    public void setTipoServicioPublico(TipoServicioPublico tipoServicioPublico) {
        this.tipoServicioPublico = tipoServicioPublico;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getValorTotalHistorialPagoAnualAdqServPublic() {
        return valorTotalHistorialPagoAnualAdqServPublic;
    }
    public void setValorTotalHistorialPagoAnualAdqServPublic(String valorTotalHistorialPagoAnualAdqServPublic) {
        this.valorTotalHistorialPagoAnualAdqServPublic = valorTotalHistorialPagoAnualAdqServPublic;
    }
    public Date getFechaHMSHistorialPagoAnualAdqServPublic() {
        return fechaHMSHistorialPagoAnualAdqServPublic;
    }
    public void setFechaHMSHistorialPagoAnualAdqServPublic(Date fechaHMSHistorialPagoAnualAdqServPublic) {
        this.fechaHMSHistorialPagoAnualAdqServPublic = fechaHMSHistorialPagoAnualAdqServPublic;
    }
    public String getTelefonoHistorialPagoAnualAdqServPublic() {
        return telefonoHistorialPagoAnualAdqServPublic;
    }
    public void setTelefonoHistorialPagoAnualAdqServPublic(String telefonoHistorialPagoAnualAdqServPublic) {
        this.telefonoHistorialPagoAnualAdqServPublic = telefonoHistorialPagoAnualAdqServPublic;
    }
    public String getMovilHistorialPagoAnualAdqServPublic() {
        return movilHistorialPagoAnualAdqServPublic;
    }
    public void setMovilHistorialPagoAnualAdqServPublic(String movilHistorialPagoAnualAdqServPublic) {
        this.movilHistorialPagoAnualAdqServPublic = movilHistorialPagoAnualAdqServPublic;
    }
    public String getNombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic() {
        return nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic;
    }
    public void setNombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic(String nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic) {
        this.nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic = nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic;
    }*/
}
