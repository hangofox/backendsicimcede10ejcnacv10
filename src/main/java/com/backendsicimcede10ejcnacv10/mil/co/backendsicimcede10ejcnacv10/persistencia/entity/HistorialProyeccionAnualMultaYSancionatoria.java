//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_PROYECCIONES_ANUALES_MULTAS_Y_SANCIONATORIAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialProyeccionAnualMultaYSancionatoria {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_PROYECCION_ANUAL_MULTA_Y_SANCIONATORIA", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialProyeccionAnualMultaYSancionatoria;
    
    @Column(name = "NUM_REG_HISTORIAL_PROYECCION_ANUAL_MULTA_Y_SANCIONATORIA", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialProyeccionAnualMultaYSancionatoria;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "NUMERO_AUTO_AMBIENTAL_HIST_PROY_AN_MULT_Y_SANC", columnDefinition = "VARCHAR2(150) NULL")
    private String numeroAutoAmbientalHistProyAnMultYSanc;
    
    @Column(name = "DENOMINACION_AUTO_AMBIENTAL_HIST_PROY_AN_MULT_Y_SANC", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String denominacionAutoAmbientalHistProyAnMultYSanc;
    
    @Column(name = "OBSERVACIONES_AUTO_AMBIENTAL_HIST_PROY_AN_MULT_Y_SANC", columnDefinition = "CLOB NULL")
    //@Lob
    private String observacionesAutoAmbientalHistProyAnMultYSanc;
    
    @Column(name = "VALOR_PRESUPUESTAL_HIST_PROY_AN_MULT_Y_SANC", columnDefinition = "VARCHAR2(150) NULL")
    private String valorPresupuestalHistProyAnMultYSanc;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_HIST_PROY_AN_MULT_Y_SANC", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoDocumentoAnexoHistProyAnMultYSanc;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialProyeccionAnualMultaYSancionatoria() {
        return idHistorialProyeccionAnualMultaYSancionatoria;
    }
    public void setIdHistorialProyeccionAnualMultaYSancionatoria(Long idHistorialProyeccionAnualMultaYSancionatoria) {
        this.idHistorialProyeccionAnualMultaYSancionatoria = idHistorialProyeccionAnualMultaYSancionatoria;
    }
    public String getNumRegHistorialProyeccionAnualMultaYSancionatoria() {
        return numRegHistorialProyeccionAnualMultaYSancionatoria;
    }
    public void setNumRegHistorialProyeccionAnualMultaYSancionatoria(String numRegHistorialProyeccionAnualMultaYSancionatoria) {
        this.numRegHistorialProyeccionAnualMultaYSancionatoria = numRegHistorialProyeccionAnualMultaYSancionatoria;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getNumeroAutoAmbientalHistProyAnMultYSanc() {
        return numeroAutoAmbientalHistProyAnMultYSanc;
    }
    public void setNumeroAutoAmbientalHistProyAnMultYSanc(String numeroAutoAmbientalHistProyAnMultYSanc) {
        this.numeroAutoAmbientalHistProyAnMultYSanc = numeroAutoAmbientalHistProyAnMultYSanc;
    }
    public String getDenominacionAutoAmbientalHistProyAnMultYSanc() {
        return denominacionAutoAmbientalHistProyAnMultYSanc;
    }
    public void setDenominacionAutoAmbientalHistProyAnMultYSanc(String denominacionAutoAmbientalHistProyAnMultYSanc) {
        this.denominacionAutoAmbientalHistProyAnMultYSanc = denominacionAutoAmbientalHistProyAnMultYSanc;
    }
    public String getObservacionesAutoAmbientalHistProyAnMultYSanc() {
        return observacionesAutoAmbientalHistProyAnMultYSanc;
    }
    public void setObservacionesAutoAmbientalHistProyAnMultYSanc(String observacionesAutoAmbientalHistProyAnMultYSanc) {
        this.observacionesAutoAmbientalHistProyAnMultYSanc = observacionesAutoAmbientalHistProyAnMultYSanc;
    }
    public String getValorPresupuestalHistProyAnMultYSanc() {
        return valorPresupuestalHistProyAnMultYSanc;
    }
    public void setValorPresupuestalHistProyAnMultYSanc(String valorPresupuestalHistProyAnMultYSanc) {
        this.valorPresupuestalHistProyAnMultYSanc = valorPresupuestalHistProyAnMultYSanc;
    }
    public String getNombreArchivoDocumentoAnexoHistProyAnMultYSanc() {
        return nombreArchivoDocumentoAnexoHistProyAnMultYSanc;
    }
    public void setNombreArchivoDocumentoAnexoHistProyAnMultYSanc(String nombreArchivoDocumentoAnexoHistProyAnMultYSanc) {
        this.nombreArchivoDocumentoAnexoHistProyAnMultYSanc = nombreArchivoDocumentoAnexoHistProyAnMultYSanc;
    }*/
}
