//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROYECCIONES_PLANES_ANUALES_ARRENDAMIENTOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProyeccionPlanAnualArrendamiento {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROYECCION_PLAN_ANUAL_ARRENDAMIENTO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idProyeccionPlanAnualArrendamiento;
    
    //@Column(name = "ID_INFRAESTRUCTURA_ARRENDADA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructuraArrendada;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA_ARRENDADA", columnDefinition = "NUMBER(20) NOT NULL")
    private InfraestructuraArrendada infraestructuraArrendada;
    
    @Column(name = "NOMBRE_PROYECCION_PLAN_ANUAL_ARRENDAMIENTO", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreProyeccionPlanAnualArrendamiento;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdProyeccionPlanAnualArrendamiento() {
        return idProyeccionPlanAnualArrendamiento;
    }
    public void setIdProyeccionPlanAnualArrendamiento(Long idProyeccionPlanAnualArrendamiento) {
        this.idProyeccionPlanAnualArrendamiento = idProyeccionPlanAnualArrendamiento;
    }
    public InfraestructuraArrendada getInfraestructuraArrendada() {
        return infraestructuraArrendada;
    }
    public void setInfraestructuraArrendada(InfraestructuraArrendada infraestructuraArrendada) {
        this.infraestructuraArrendada = infraestructuraArrendada;
    }
    public String getNombreProyeccionPlanAnualArrendamiento() {
        return nombreProyeccionPlanAnualArrendamiento;
    }
    public void setNombreProyeccionPlanAnualArrendamiento(String nombreProyeccionPlanAnualArrendamiento) {
        this.nombreProyeccionPlanAnualArrendamiento = nombreProyeccionPlanAnualArrendamiento;
    }*/
}
