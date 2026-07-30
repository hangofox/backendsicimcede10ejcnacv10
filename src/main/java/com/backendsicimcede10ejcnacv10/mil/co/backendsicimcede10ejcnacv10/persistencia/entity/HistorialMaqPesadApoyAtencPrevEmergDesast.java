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
@Table(name = "TABLA_HISTORIAL_MAQ_PESAD_APOY_ATENC_PREV_EMERG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialMaqPesadApoyAtencPrevEmergDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_MAQ_PESAD_APOY_ATENC_PREV_EMERG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialMaqPesadApoyAtencPrevEmergDesast;
    
    @Column(name = "NUM_REG_HISTORIAL_MAQ_PESAD_APOY_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialMaqPesadApoyAtencPrevEmergDesast;
    
    //@Column(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoAtencPrevEmergDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast;
    
    //@Column(name = "ID_MAQUINARIA_PESADA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idMaquinariaPesada;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_MAQUINARIA_PESADA", columnDefinition = "NUMBER(20) NOT NULL")
    private MaquinariaPesada maquinariaPesada;
    
    @Column(name = "DIAS_EMPLEADOS_MAQ_PESAD_APOY_ATENC_PREV_EMERG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long diasEmpleadosMaqPesadApoyAtencPrevEmergDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialMaqPesadApoyAtencPrevEmergDesast() {
        return idHistorialMaqPesadApoyAtencPrevEmergDesast;
    }
    public void setIdHistorialMaqPesadApoyAtencPrevEmergDesast(Long idHistorialMaqPesadApoyAtencPrevEmergDesast) {
        this.idHistorialMaqPesadApoyAtencPrevEmergDesast = idHistorialMaqPesadApoyAtencPrevEmergDesast;
    }
    public String getNumRegHistorialMaqPesadApoyAtencPrevEmergDesast() {
        return numRegHistorialMaqPesadApoyAtencPrevEmergDesast;
    }
    public void setNumRegHistorialMaqPesadApoyAtencPrevEmergDesast(String numRegHistorialMaqPesadApoyAtencPrevEmergDesast) {
        this.numRegHistorialMaqPesadApoyAtencPrevEmergDesast = numRegHistorialMaqPesadApoyAtencPrevEmergDesast;
    }
    public ApoyoAtencPrevEmergDesast getApoyoAtencPrevEmergDesast() {
        return apoyoAtencPrevEmergDesast;
    }
    public void setApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast) {
        this.apoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesast;
    }
    public MaquinariaPesada getMaquinariaPesada() {
        return maquinariaPesada;
    }
    public void setMaquinariaPesada(MaquinariaPesada maquinariaPesada) {
        this.maquinariaPesada = maquinariaPesada;
    }
    public Long getDiasEmpleadosMaqPesadApoyAtencPrevEmergDesast() {
        return diasEmpleadosMaqPesadApoyAtencPrevEmergDesast;
    }
    public void setDiasEmpleadosMaqPesadApoyAtencPrevEmergDesast(Long diasEmpleadosMaqPesadApoyAtencPrevEmergDesast) {
        this.diasEmpleadosMaqPesadApoyAtencPrevEmergDesast = diasEmpleadosMaqPesadApoyAtencPrevEmergDesast;
    }*/
}
