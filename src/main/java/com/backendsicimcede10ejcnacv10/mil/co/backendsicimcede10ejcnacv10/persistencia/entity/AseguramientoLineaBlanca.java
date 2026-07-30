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
@Table(name = "TABLA_ASEGURAMIENTOS_LINEAS_BLANCAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class AseguramientoLineaBlanca {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_ASEGURAMIENTO_LINEA_BLANCA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idAseguramientoLineaBlanca;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_INICIACION_ASEGURAMIENTO_LINEA_BLANCA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIniciacionAseguramientoLineaBlanca;
    
    @Column(name = "FECHA_H_M_S_FINALIZACION_ASEGURAMIENTO_LINEA_BLANCA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSFinalizacionAseguramientoLineaBlanca;
    
    //@Column(name = "ID_ASEGURADORA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idAseguradora;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ASEGURADORA", columnDefinition = "NUMBER(20) NOT NULL")
    private Aseguradora aseguradora;
    
    @Column(name = "NUMERO_SEGURO_ASEGURAMIENTO_LINEA_BLANCA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String numeroSeguroAseguramientoLineaBlanca;
    
    //@Column(name = "ID_TIPO_RESPONSABILIDAD_CONTRACTUAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoResponsabilidadContractual;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_RESPONSABILIDAD_CONTRACTUAL", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoResponsabilidadContractual tipoResponsabilidadContractual;
    
    @Column(name = "VALOR_SOLICITADO_ASEGURAMIENTO_LINEA_BLANCA", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoAseguramientoLineaBlanca;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdAseguramientoLineaBlanca() {
        return idAseguramientoLineaBlanca;
    }
    public void setIdAseguramientoLineaBlanca(Long idAseguramientoLineaBlanca) {
        this.idAseguramientoLineaBlanca = idAseguramientoLineaBlanca;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public Date getFechaHMSIniciacionAseguramientoLineaBlanca() {
        return fechaHMSIniciacionAseguramientoLineaBlanca;
    }
    public void setFechaHMSIniciacionAseguramientoLineaBlanca(Date fechaHMSIniciacionAseguramientoLineaBlanca) {
        this.fechaHMSIniciacionAseguramientoLineaBlanca = fechaHMSIniciacionAseguramientoLineaBlanca;
    }
    public Date getFechaHMSFinalizacionAseguramientoLineaBlanca() {
        return fechaHMSFinalizacionAseguramientoLineaBlanca;
    }
    public void setFechaHMSFinalizacionAseguramientoLineaBlanca(Date fechaHMSFinalizacionAseguramientoLineaBlanca) {
        this.fechaHMSFinalizacionAseguramientoLineaBlanca = fechaHMSFinalizacionAseguramientoLineaBlanca;
    }
    public Aseguradora getAseguradora() {
        return aseguradora;
    }
    public void setAseguradora(Aseguradora aseguradora) {
        this.aseguradora = aseguradora;
    }
    public String getNumeroSeguroAseguramientoLineaBlanca() {
        return numeroSeguroAseguramientoLineaBlanca;
    }
    public void setNumeroSeguroAseguramientoLineaBlanca(String numeroSeguroAseguramientoLineaBlanca) {
        this.numeroSeguroAseguramientoLineaBlanca = numeroSeguroAseguramientoLineaBlanca;
    }
    public TipoResponsabilidadContractual getTipoResponsabilidadContractual() {
        return tipoResponsabilidadContractual;
    }
    public void setTipoResponsabilidadContractual(TipoResponsabilidadContractual tipoResponsabilidadContractual) {
        this.tipoResponsabilidadContractual = tipoResponsabilidadContractual;
    }
    public String getValorSolicitadoAseguramientoLineaBlanca() {
        return valorSolicitadoAseguramientoLineaBlanca;
    }
    public void setValorSolicitadoAseguramientoLineaBlanca(String valorSolicitadoAseguramientoLineaBlanca) {
        this.valorSolicitadoAseguramientoLineaBlanca = valorSolicitadoAseguramientoLineaBlanca;
    }*/
}
