//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROYECCIONES_SOATS_LINEAS_BLANCAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProyeccionSoatLineaBlanca {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROYECCION_SOAT_LINEA_BLANCA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idProyeccionSoatLineaBlanca;
    
    //@Column(name = "ID_EQUIPO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "VALOR_SOLICITADO_PROYECCION_SOAT_LINEA_BLANCA", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoProyeccionSoatLineaBlanca;
    
    @Column(name = "FECHA_H_M_S_PROYECCION_SOAT_LINEA_BLANCA", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSProyeccionSoatLineaBlanca;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdProyeccionSoatLineaBlanca() {
        return idProyeccionSoatLineaBlanca;
    }
    public void setIdProyeccionSoatLineaBlanca(Long idProyeccionSoatLineaBlanca) {
        this.idProyeccionSoatLineaBlanca = idProyeccionSoatLineaBlanca;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public String getValorSolicitadoProyeccionSoatLineaBlanca() {
        return valorSolicitadoProyeccionSoatLineaBlanca;
    }
    public void setValorSolicitadoProyeccionSoatLineaBlanca(String valorSolicitadoProyeccionSoatLineaBlanca) {
        this.valorSolicitadoProyeccionSoatLineaBlanca = valorSolicitadoProyeccionSoatLineaBlanca;
    }
    public Date getFechaHMSProyeccionSoatLineaBlanca() {
        return fechaHMSProyeccionSoatLineaBlanca;
    }
    public void setFechaHMSProyeccionSoatLineaBlanca(Date fechaHMSProyeccionSoatLineaBlanca) {
        this.fechaHMSProyeccionSoatLineaBlanca = fechaHMSProyeccionSoatLineaBlanca;
    }*/
}
