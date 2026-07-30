//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROYECCIONES_SEGUROS_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProyeccionSeguroInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROYECCION_SEGURO_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idProyeccionSeguroInfraestructura;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    @Column(name = "VALOR_SOLICITADO_PROY_SEG_INFRAEST", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoProySegInfraest;
    
    @Column(name = "VALOR_SOLICITADO_TODO_RIESGO_PROY_SEG_INFRAEST", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoTodoRiesgoProySegInfraest;
    
    @Column(name = "VALOR_SOLICITADO_RENEGOCIACION_PROY_SEG_INFRAEST", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoRenegociacionProySegInfraest;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdProyeccionSeguroInfraestructura() {
        return idProyeccionSeguroInfraestructura;
    }
    public void setIdProyeccionSeguroInfraestructura(Long idProyeccionSeguroInfraestructura) {
        this.idProyeccionSeguroInfraestructura = idProyeccionSeguroInfraestructura;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }
    public String getValorSolicitadoProySegInfraest() {
        return valorSolicitadoProySegInfraest;
    }
    public void setValorSolicitadoProySegInfraest(String valorSolicitadoProySegInfraest) {
        this.valorSolicitadoProySegInfraest = valorSolicitadoProySegInfraest;
    }
    public String getValorSolicitadoTodoRiesgoProySegInfraest() {
        return valorSolicitadoTodoRiesgoProySegInfraest;
    }
    public void setValorSolicitadoTodoRiesgoProySegInfraest(String valorSolicitadoTodoRiesgoProySegInfraest) {
        this.valorSolicitadoTodoRiesgoProySegInfraest = valorSolicitadoTodoRiesgoProySegInfraest;
    }
    public String getValorSolicitadoRenegociacionProySegInfraest() {
        return valorSolicitadoRenegociacionProySegInfraest;
    }
    public void setValorSolicitadoRenegociacionProySegInfraest(String valorSolicitadoRenegociacionProySegInfraest) {
        this.valorSolicitadoRenegociacionProySegInfraest = valorSolicitadoRenegociacionProySegInfraest;
    }*/
}
