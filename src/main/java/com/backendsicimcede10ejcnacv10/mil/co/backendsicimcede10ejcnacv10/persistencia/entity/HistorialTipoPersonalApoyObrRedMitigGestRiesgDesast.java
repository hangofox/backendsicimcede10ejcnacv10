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
@Table(name = "TABLA_HISTORIAL_TIPOS_PERSONAL_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_TIPO_PERSONAL_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUM_REG_HISTORIAL_TIPO_PERSONAL_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoObrRedMitigGestRiesgDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_TIPO_PERSONAL_APOYO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoPersonalApoyo;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_PERSONAL_APOYO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoPersonalApoyo tipoPersonalApoyo;
    
    @Column(name = "CANTIDAD_PERSONAL_APOYO", columnDefinition="NUMBER(20) NOT NULL")
    private Long cantidadPersonalApoyo;
    
    @Column(name = "NOMBRE_ESPECIALIDAD_TIPO_PERSONAL_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast() {
        return idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
    }
    public void setIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) {
        this.idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast = idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
    }
    public String getNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast() {
        return numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
    }
    public void setNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(String numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) {
        this.numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast = numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
    }
    public ApoyoObrRedMitigGestRiesgDesast getApoyoObrRedMitigGestRiesgDesast() {
        return apoyoObrRedMitigGestRiesgDesast;
    }
    public void setApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast) {
        this.apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesast;
    }
    public TipoPersonalApoyo getTipoPersonalApoyo() {
        return tipoPersonalApoyo;
    }
    public void setTipoPersonalApoyo(TipoPersonalApoyo tipoPersonalApoyo) {
        this.tipoPersonalApoyo = tipoPersonalApoyo;
    }
    public Long getCantidadPersonalApoyo() {
        return cantidadPersonalApoyo;
    }
    public void setCantidadPersonalApoyo(Long cantidadPersonalApoyo) {
        this.cantidadPersonalApoyo = cantidadPersonalApoyo;
    }
    public String getNombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast() {
        return nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast;
    }
    public void setNombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast(String nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast) {
        this.nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast = nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast;
    }*/
}
