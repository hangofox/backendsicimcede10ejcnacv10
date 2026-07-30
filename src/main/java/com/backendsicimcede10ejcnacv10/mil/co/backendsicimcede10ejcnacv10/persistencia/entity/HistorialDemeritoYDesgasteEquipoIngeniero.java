//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_DEMERITOS_Y_DESGASTES_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialDemeritoYDesgasteEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialDemeritoYDesgasteEquipoIngeniero;
    
    @Column(name = "NUM_REG_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialDemeritoYDesgasteEquipoIngeniero;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "NOMBRE_PROYECTO_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero;
    
    @Column(name = "VALOR_PRESUPUESTAL_PROYECTO_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero;
    
    @Column(name = "HORAS_TRABAJADAS_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero;
    
    @Column(name = "KILOMETROS_RECORRIDOS_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialDemeritoYDesgasteEquipoIngeniero() {
        return idHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public void setIdHistorialDemeritoYDesgasteEquipoIngeniero(Long idHistorialDemeritoYDesgasteEquipoIngeniero) {
        this.idHistorialDemeritoYDesgasteEquipoIngeniero = idHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public String getNumRegHistorialDemeritoYDesgasteEquipoIngeniero() {
        return numRegHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public void setNumRegHistorialDemeritoYDesgasteEquipoIngeniero(String numRegHistorialDemeritoYDesgasteEquipoIngeniero) {
        this.numRegHistorialDemeritoYDesgasteEquipoIngeniero = numRegHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public String getNombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero() {
        return nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public void setNombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero(String nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero) {
        this.nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero = nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public String getValorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero() {
        return valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public void setValorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero(String valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero) {
        this.valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero = valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public String getHorasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero() {
        return horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public void setHorasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero(String horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero) {
        this.horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero = horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public String getKilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero() {
        return kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero;
    }
    public void setKilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero(String kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero) {
        this.kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero = kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero;
    }*/
}
