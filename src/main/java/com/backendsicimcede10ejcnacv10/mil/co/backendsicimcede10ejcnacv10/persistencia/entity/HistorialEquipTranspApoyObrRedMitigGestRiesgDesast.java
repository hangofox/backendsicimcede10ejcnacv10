//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_EQUIP_TRANSP_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialEquipTranspApoyObrRedMitigGestRiesgDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_EQUIP_TRANSP_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUM_REG_HISTORIAL_EQUIP_TRANSP_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoObrRedMitigGestRiesgDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_CLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idClasificacionEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_CLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private ClasificacionEquipoIngeniero clasificacionEquipoIngeniero;
    
    //@Column(name = "ID_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSubclasificacionEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero;
    
    //@Column(name = "ID_ELEMENTO_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idElementoSubclasificacionEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ELEMENTO_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "NUMERO_PLACA_EQUIPO_TRANSPORTE", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numeroPlacaEquipoTransporte;
    
    @Column(name = "TOTAL_HORAS_EMPLEADAS_EQUIP_TRANSP_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast() {
        return idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
    }
    public void setIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) {
        this.idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast = idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
    }
    public String getNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast() {
        return numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
    }
    public void setNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(String numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) {
        this.numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast = numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
    }
    public ApoyoObrRedMitigGestRiesgDesast getApoyoObrRedMitigGestRiesgDesast() {
        return apoyoObrRedMitigGestRiesgDesast;
    }
    public void setApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast) {
        this.apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesast;
    }
    public ClasificacionEquipoIngeniero getClasificacionEquipoIngeniero() {
        return clasificacionEquipoIngeniero;
    }
    public void setClasificacionEquipoIngeniero(ClasificacionEquipoIngeniero clasificacionEquipoIngeniero) {
        this.clasificacionEquipoIngeniero = clasificacionEquipoIngeniero;
    }
    public SubclasificacionEquipoIngeniero getSubclasificacionEquipoIngeniero() {
        return subclasificacionEquipoIngeniero;
    }
    public void setSubclasificacionEquipoIngeniero(SubclasificacionEquipoIngeniero subclasificacionEquipoIngeniero) {
        this.subclasificacionEquipoIngeniero = subclasificacionEquipoIngeniero;
    }
    public ElementoSubclasificacionEquipoIngeniero getElementoSubclasificacionEquipoIngeniero() {
        return elementoSubclasificacionEquipoIngeniero;
    }
    public void setElementoSubclasificacionEquipoIngeniero(ElementoSubclasificacionEquipoIngeniero elementoSubclasificacionEquipoIngeniero) {
        this.elementoSubclasificacionEquipoIngeniero = elementoSubclasificacionEquipoIngeniero;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public String getNumeroPlacaEquipoTransporte() {
        return numeroPlacaEquipoTransporte;
    }
    public void setNumeroPlacaEquipoTransporte(String numeroPlacaEquipoTransporte) {
        this.numeroPlacaEquipoTransporte = numeroPlacaEquipoTransporte;
    }
    public Long getTotalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast() {
        return totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast;
    }
    public void setTotalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast(Long totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast) {
        this.totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast = totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast;
    }*/
}
