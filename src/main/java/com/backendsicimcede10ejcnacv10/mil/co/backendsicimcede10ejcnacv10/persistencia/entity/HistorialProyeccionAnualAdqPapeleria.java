//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 10/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_PROYECCIONES_ANUALES_ADQ_PAPELERIAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialProyeccionAnualAdqPapeleria {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_PROYECCION_ANUAL_ADQ_PAPELERIA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialProyeccionAnualAdqPapeleria;
    
    @Column(name = "NUM_REG_HISTORIAL_PROYECCION_ANUAL_ADQ_PAPELERIA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialProyeccionAnualAdqPapeleria;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "VALOR_CONTRATO_HISTORIAL_PROYECCION_ANUAL_ADQ_PAPELERIA", columnDefinition="VARCHAR2(150) NULL")
    private String valorContratoHistorialProyeccionAnualAdqPapeleria;
    
    @Column(name = "NUMERO_RUBRO_PRESUPUESTAL_HIST_PROY_AN_ADQ_PAP", columnDefinition="VARCHAR2(150) NULL")
    private String numeroRubroPresupuestalHistProyAnAdqPap;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_CONTRAT_HIST_PROY_AN_ADQ_PAP", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoContratHistProyAnAdqPap;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_COTIZ_HIST_PROY_AN_ADQ_PAP", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_PL_NEC_HIST_PROY_AN_ADQ_PAP", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdHistorialProyeccionAnualAdqPapeleria() {
        return idHistorialProyeccionAnualAdqPapeleria;
    }
    public void setIdHistorialProyeccionAnualAdqPapeleria(Long idHistorialProyeccionAnualAdqPapeleria) {
        this.idHistorialProyeccionAnualAdqPapeleria = idHistorialProyeccionAnualAdqPapeleria;
    }
    public String getNumRegHistorialProyeccionAnualAdqPapeleria() {
        return numRegHistorialProyeccionAnualAdqPapeleria;
    }
    public void setNumRegHistorialProyeccionAnualAdqPapeleria(String numRegHistorialProyeccionAnualAdqPapeleria) {
        this.numRegHistorialProyeccionAnualAdqPapeleria = numRegHistorialProyeccionAnualAdqPapeleria;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getValorContratoHistorialProyeccionAnualAdqPapeleria() {
        return valorContratoHistorialProyeccionAnualAdqPapeleria;
    }
    public void setValorContratoHistorialProyeccionAnualAdqPapeleria(String valorContratoHistorialProyeccionAnualAdqPapeleria) {
        this.valorContratoHistorialProyeccionAnualAdqPapeleria = valorContratoHistorialProyeccionAnualAdqPapeleria;
    }
    public String getNumeroRubroPresupuestalHistProyAnAdqPap() {
        return numeroRubroPresupuestalHistProyAnAdqPap;
    }
    public void setNumeroRubroPresupuestalHistProyAnAdqPap(String numeroRubroPresupuestalHistProyAnAdqPap) {
        this.numeroRubroPresupuestalHistProyAnAdqPap = numeroRubroPresupuestalHistProyAnAdqPap;
    }
    public String getNombreArchivoDocumentoAnexoContratHistProyAnAdqPap() {
        return nombreArchivoDocumentoAnexoContratHistProyAnAdqPap;
    }
    public void setNombreArchivoDocumentoAnexoContratHistProyAnAdqPap(String nombreArchivoDocumentoAnexoContratHistProyAnAdqPap) {
        this.nombreArchivoDocumentoAnexoContratHistProyAnAdqPap = nombreArchivoDocumentoAnexoContratHistProyAnAdqPap;
    }
    public String getNombreArchivoDocumentoAnexoCotizHistProyAnAdqPap() {
        return nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap;
    }
    public void setNombreArchivoDocumentoAnexoCotizHistProyAnAdqPap(String nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap) {
        this.nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap = nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap;
    }
    public String getNombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap() {
        return nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap;
    }
    public void setNombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap(String nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap) {
        this.nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap = nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap;
    }*/
}
