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
@Table(name = "TABLA_SEGUROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class Seguro {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_SEGURO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idSeguro;
    
    //@Column(name = "ID_ASEGURADORA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idAseguradora;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ASEGURADORA", columnDefinition = "NUMBER(20) NOT NULL")
    private Aseguradora aseguradora;
    
    //@Column(name = "ID_TIPO_SEGURO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoSeguro;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_SEGURO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoSeguro tipoSeguro;
    
    @Column(name = "FECHA_H_M_S_INICIO_SEGURO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSInicioSeguro;
    
    @Column(name = "FECHA_H_M_S_EXPIRACION_SEGURO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSExpiracionSeguro;
    
    @Column(name = "ESTADO_SEGURO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String estadoSeguro;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdSeguro() {
        return idSeguro;
    }
    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }
    public Aseguradora getAseguradora() {
        return aseguradora;
    }
    public void setAseguradora(Aseguradora aseguradora) {
        this.aseguradora = aseguradora;
    }
    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }
    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
    public Date getFechaHMSInicioSeguro() {
        return fechaHMSInicioSeguro;
    }
    public void setFechaHMSInicioSeguro(Date fechaHMSInicioSeguro) {
        this.fechaHMSInicioSeguro = fechaHMSInicioSeguro;
    }
    public Date getFechaHMSExpiracionSeguro() {
        return fechaHMSExpiracionSeguro;
    }
    public void setFechaHMSExpiracionSeguro(Date fechaHMSExpiracionSeguro) {
        this.fechaHMSExpiracionSeguro = fechaHMSExpiracionSeguro;
    }
    public String getEstadoSeguro() {
        return estadoSeguro;
    }
    public void setEstadoSeguro(String estadoSeguro) {
        this.estadoSeguro = estadoSeguro;
    }*/
}
