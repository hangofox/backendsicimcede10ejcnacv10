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
@Table(name = "TABLA_HISTORIAL_MAQ_PESAD_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialMaqPesadApoyObrRedMitigGestRiesgDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_MAQ_PESAD_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
    
    @Column(name = "NUM_REG_HISTORIAL_MAQ_PESAD_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoObrRedMitigGestRiesgDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_MAQUINARIA_PESADA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idMaquinariaPesada;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_MAQUINARIA_PESADA", columnDefinition = "NUMBER(20) NOT NULL")
    private MaquinariaPesada maquinariaPesada;
    
    @Column(name = "TOTAL_HORAS_EMPLEADAS_MAQ_PESAD_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast() {
        return idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
    }
    public void setIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) {
        this.idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast = idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
    }
    public String getNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast() {
        return numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
    }
    public void setNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(String numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) {
        this.numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast = numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
    }
    public ApoyoObrRedMitigGestRiesgDesast getApoyoObrRedMitigGestRiesgDesast() {
        return apoyoObrRedMitigGestRiesgDesast;
    }
    public void setApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast) {
        this.apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesast;
    }
    public MaquinariaPesada getMaquinariaPesada() {
        return maquinariaPesada;
    }
    public void setMaquinariaPesada(MaquinariaPesada maquinariaPesada) {
        this.maquinariaPesada = maquinariaPesada;
    }
    public Long getTotalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast() {
        return totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast;
    }
    public void setTotalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast(Long totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast) {
        this.totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast = totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast;
    }*/
}
