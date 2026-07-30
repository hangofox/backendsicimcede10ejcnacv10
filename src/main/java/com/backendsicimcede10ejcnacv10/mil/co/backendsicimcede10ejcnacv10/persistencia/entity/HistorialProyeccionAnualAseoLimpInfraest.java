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
@Table(name = "TABLA_HISTORIAL_PROYECCIONES_ANUALES_ASEOS_LIMP_INFRAEST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialProyeccionAnualAseoLimpInfraest {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_PROYECCION_ANUAL_ASEO_LIMP_INFRAEST", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialProyeccionAnualAseoLimpInfraest;
    
    @Column(name = "NUM_REG_HISTORIAL_PROYECCION_ANUAL_ASEO_LIMP_INFRAEST", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialProyeccionAnualAseoLimpInfraest;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    @Column(name = "VALOR_CONTRATO_HISTORIAL_PROYECCION_ANUAL_ASEO_LIMP_INFRAEST", columnDefinition = "VARCHAR2(150) NULL")
    private String valorContratoHistorialProyeccionAnualAseoLimpInfraest;
    
    @Column(name = "NUMERO_PERSONAL_HUMANO_HIST_PROY_AN_ASEO_LIMP_INFRAEST", columnDefinition = "VARCHAR2(150) NULL")
    private String numeroPersonalHumanoHistProyAnAseoLimpInfraest;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_CONTRAT_HIST_PROY_AN_ASEO_LIMP_INFRAEST", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_COTIZ_HIST_PROY_AN_ASEO_LIMP_INFRAEST", columnDefinition = "CLOB NULL")
    //@Lob
    private String nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialProyeccionAnualAseoLimpInfraest() {
        return idHistorialProyeccionAnualAseoLimpInfraest;
    }
    public void setIdHistorialProyeccionAnualAseoLimpInfraest(Long idHistorialProyeccionAnualAseoLimpInfraest) {
        this.idHistorialProyeccionAnualAseoLimpInfraest = idHistorialProyeccionAnualAseoLimpInfraest;
    }
    public String getNumRegHistorialProyeccionAnualAseoLimpInfraest() {
        return numRegHistorialProyeccionAnualAseoLimpInfraest;
    }
    public void setNumRegHistorialProyeccionAnualAseoLimpInfraest(String numRegHistorialProyeccionAnualAseoLimpInfraest) {
        this.numRegHistorialProyeccionAnualAseoLimpInfraest = numRegHistorialProyeccionAnualAseoLimpInfraest;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public String getValorContratoHistorialProyeccionAnualAseoLimpInfraest() {
        return valorContratoHistorialProyeccionAnualAseoLimpInfraest;
    }
    public void setValorContratoHistorialProyeccionAnualAseoLimpInfraest(String valorContratoHistorialProyeccionAnualAseoLimpInfraest) {
        this.valorContratoHistorialProyeccionAnualAseoLimpInfraest = valorContratoHistorialProyeccionAnualAseoLimpInfraest;
    }
    public String getNumeroPersonalHumanoHistProyAnAseoLimpInfraest() {
        return numeroPersonalHumanoHistProyAnAseoLimpInfraest;
    }
    public void setNumeroPersonalHumanoHistProyAnAseoLimpInfraest(String numeroPersonalHumanoHistProyAnAseoLimpInfraest) {
        this.numeroPersonalHumanoHistProyAnAseoLimpInfraest = numeroPersonalHumanoHistProyAnAseoLimpInfraest;
    }
    public String getNombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest() {
        return nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest;
    }
    public void setNombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest(String nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest) {
        this.nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest = nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest;
    }
    public String getNombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest() {
        return nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest;
    }
    public void setNombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest(String nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest) {
        this.nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest = nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest;
    }*/
}
