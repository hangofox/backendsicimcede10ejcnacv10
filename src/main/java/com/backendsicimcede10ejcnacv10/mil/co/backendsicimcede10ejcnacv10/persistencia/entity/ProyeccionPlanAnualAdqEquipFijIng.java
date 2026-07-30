//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROYECCIONES_PLANES_ANUALES_ADQ_EQUIP_FIJ_ING")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProyeccionPlanAnualAdqEquipFijIng {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_EQUIP_FIJ_ING", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idProyeccionPlanAnualAdqEquipFijIng;
    
    //@Column(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_GENERAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionPlanAnualAdqGeneral;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_GENERAL", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral;
    
    @Column(name = "NOMBRE_PROYECCION_PLAN_ANUAL_ADQ_EQUIP_FIJ_ING", columnDefinition = "VARCHAR2(250) NOT NULL")
    private String nombreProyeccionPlanAnualAdqEquipFijIng;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdProyeccionPlanAnualAdqEquipFijIng() {
        return idProyeccionPlanAnualAdqEquipFijIng;
    }
    public void setIdProyeccionPlanAnualAdqEquipFijIng(Long idProyeccionPlanAnualAdqEquipFijIng) {
        this.idProyeccionPlanAnualAdqEquipFijIng = idProyeccionPlanAnualAdqEquipFijIng;
    }
    public ProyeccionPlanAnualAdqGeneral getProyeccionPlanAnualAdqGeneral() {
        return proyeccionPlanAnualAdqGeneral;
    }
    public void setProyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral) {
        this.proyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqGeneral;
    }
    public String getNombreProyeccionPlanAnualAdqEquipFijIng() {
        return nombreProyeccionPlanAnualAdqEquipFijIng;
    }
    public void setNombreProyeccionPlanAnualAdqEquipFijIng(String nombreProyeccionPlanAnualAdqEquipFijIng) {
        this.nombreProyeccionPlanAnualAdqEquipFijIng = nombreProyeccionPlanAnualAdqEquipFijIng;
    }*/
}
