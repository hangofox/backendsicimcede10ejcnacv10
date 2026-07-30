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
@Table(name = "TABLA_CONTRATOS_PROYECCIONES_SEGUROS_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ContratoProyeccionSeguroInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_CONTRATO_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idContratoProyeccionSeguroInfraestructura;
    
    //@Column(name = "ID_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionSeguroInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura;
    
    //@Column(name = "ID_TIPO_CONTRATO_SEGURO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoContratoSeguroInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_CONTRATO_SEGURO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura;
    
    //@Column(name = "ID_TIPO_RESPONSABILIDAD_CONTRACTUAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoResponsabilidadContractual;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_RESPONSABILIDAD_CONTRACTUAL", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoResponsabilidadContractual tipoResponsabilidadContractual;
    
    @Column(name = "NUMERO_CONTRATO_SEGURO_INFRAESTRUCTURA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String numeroContratoSeguroInfraestructura;
    
    @Column(name = "FECHA_H_M_S_CONTRATO_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSContratoProyeccionSeguroInfraestructura;
    
    @Column(name = "DESCRIPCION_CONTRATO_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition="CLOB NULL")
    private String descripcionContratoProyeccionSeguroInfraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdContratoProyeccionSeguroInfraestructura() {
        return idContratoProyeccionSeguroInfraestructura;
    }
    public void setIdContratoProyeccionSeguroInfraestructura(Long idContratoProyeccionSeguroInfraestructura) {
        this.idContratoProyeccionSeguroInfraestructura = idContratoProyeccionSeguroInfraestructura;
    }
    public ProyeccionSeguroInfraestructura getProyeccionSeguroInfraestructura() {
        return proyeccionSeguroInfraestructura;
    }
    public void setProyeccionSeguroInfraestructura(ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura) {
        this.proyeccionSeguroInfraestructura = proyeccionSeguroInfraestructura;
    }
    public TipoContratoSeguroInfraestructura getTipoContratoSeguroInfraestructura() {
        return tipoContratoSeguroInfraestructura;
    }
    public void setTipoContratoSeguroInfraestructura(TipoContratoSeguroInfraestructura tipoContratoSeguroInfraestructura) {
        this.tipoContratoSeguroInfraestructura = tipoContratoSeguroInfraestructura;
    }
    public TipoResponsabilidadContractual getTipoResponsabilidadContractual() {
        return tipoResponsabilidadContractual;
    }
    public void setTipoResponsabilidadContractual(TipoResponsabilidadContractual tipoResponsabilidadContractual) {
        this.tipoResponsabilidadContractual = tipoResponsabilidadContractual;
    }
    public String getNumeroContratoSeguroInfraestructura() {
        return numeroContratoSeguroInfraestructura;
    }
    public void setNumeroContratoSeguroInfraestructura(String numeroContratoSeguroInfraestructura) {
        this.numeroContratoSeguroInfraestructura = numeroContratoSeguroInfraestructura;
    }
    public Date getFechaHMSContratoProyeccionSeguroInfraestructura() {
        return fechaHMSContratoProyeccionSeguroInfraestructura;
    }
    public void setFechaHMSContratoProyeccionSeguroInfraestructura(Date fechaHMSContratoProyeccionSeguroInfraestructura) {
        this.fechaHMSContratoProyeccionSeguroInfraestructura = fechaHMSContratoProyeccionSeguroInfraestructura;
    }
    public String getDescripcionContratoProyeccionSeguroInfraestructura() {
        return descripcionContratoProyeccionSeguroInfraestructura;
    }
    public void setDescripcionContratoProyeccionSeguroInfraestructura(String descripcionContratoProyeccionSeguroInfraestructura) {
        this.descripcionContratoProyeccionSeguroInfraestructura = descripcionContratoProyeccionSeguroInfraestructura;
    }*/
}
