//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 19/06/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_ELEMENTOS_SUBCLASIFICACIONES_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ElementoSubclasificacionEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_ELEMENTO_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idElementoSubclasificacionEquipoIngeniero;
    
    @Column(name = "NOMBRE_ELEMENTO_SUBCLASIFICACION_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreElementoSubclasificacionEquipoIngeniero;
    
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
    
    //@Column(name = "ID_LINEA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idLineaEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_LINEA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private LineaEquipoIngeniero lineaEquipoIngeniero;
    
    //@Column(name = "ID_CUENTA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idCuentaEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_CUENTA_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private CuentaEquipoIngeniero cuentaEquipoIngeniero;
    
    //@Column(name = "ID_CLASE_ACTIVO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idClaseActivoEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_CLASE_ACTIVO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private ClaseActivoEquipoIngeniero claseActivoEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdElementoSubclasificacionEquipoIngeniero() {
        return idElementoSubclasificacionEquipoIngeniero;
    }
    public void setIdElementoSubclasificacionEquipoIngeniero(Long idElementoSubclasificacionEquipoIngeniero) {
        this.idElementoSubclasificacionEquipoIngeniero = idElementoSubclasificacionEquipoIngeniero;
    }
    public String getNombreElementoSubclasificacionEquipoIngeniero() {
        return nombreElementoSubclasificacionEquipoIngeniero;
    }
    public void setNombreElementoSubclasificacionEquipoIngeniero(String nombreElementoSubclasificacionEquipoIngeniero) {
        this.nombreElementoSubclasificacionEquipoIngeniero = nombreElementoSubclasificacionEquipoIngeniero;
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
    public LineaEquipoIngeniero getLineaEquipoIngeniero() {
        return lineaEquipoIngeniero;
    }
    public void setLineaEquipoIngeniero(LineaEquipoIngeniero lineaEquipoIngeniero) {
        this.lineaEquipoIngeniero = lineaEquipoIngeniero;
    }
    public CuentaEquipoIngeniero getCuentaEquipoIngeniero() {
        return cuentaEquipoIngeniero;
    }
    public void setCuentaEquipoIngeniero(CuentaEquipoIngeniero cuentaEquipoIngeniero) {
        this.cuentaEquipoIngeniero = cuentaEquipoIngeniero;
    }
    public ClaseActivoEquipoIngeniero getClaseActivoEquipoIngeniero() {
        return claseActivoEquipoIngeniero;
    }
    public void setClaseActivoEquipoIngeniero(ClaseActivoEquipoIngeniero claseActivoEquipoIngeniero) {
        this.claseActivoEquipoIngeniero = claseActivoEquipoIngeniero;
    }*/
}
