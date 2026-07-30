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
@Table(name = "TABLA_HISTORIAL_TIPOS_PERSONAL_APOY_ATENC_PREV_EMERG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialTipoPersonalApoyAtencPrevEmergDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_TIPO_PERSONAL_APOY_ATENC_PREV_EMERG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialTipoPersonalApoyAtencPrevEmergDesast;
    
    @Column(name = "NUM_REG_HISTORIAL_TIPO_PERSONAL_APOY_ATENC_PREV_EMERG_DESAST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialTipoPersonalApoyAtencPrevEmergDesast;
    
    //@Column(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoAtencPrevEmergDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast;
    
    //@Column(name = "ID_TIPO_PERSONAL_APOYO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoPersonalApoyo;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_PERSONAL_APOYO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoPersonalApoyo tipoPersonalApoyo;
    
    @Column(name = "CANTIDAD_PERSONAL_APOYO", columnDefinition="NUMBER(20) NOT NULL")
    private Long cantidadPersonalApoyo;
    
    @Column(name = "DIAS_EMPLEADOS_TIPO_PERSONAL_APOY_ATENC_PREV_EMERG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialTipoPersonalApoyAtencPrevEmergDesast() {
        return idHistorialTipoPersonalApoyAtencPrevEmergDesast;
    }
    public void setIdHistorialTipoPersonalApoyAtencPrevEmergDesast(Long idHistorialTipoPersonalApoyAtencPrevEmergDesast) {
        this.idHistorialTipoPersonalApoyAtencPrevEmergDesast = idHistorialTipoPersonalApoyAtencPrevEmergDesast;
    }
    public String getNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast() {
        return numRegHistorialTipoPersonalApoyAtencPrevEmergDesast;
    }
    public void setNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast(String numRegHistorialTipoPersonalApoyAtencPrevEmergDesast) {
        this.numRegHistorialTipoPersonalApoyAtencPrevEmergDesast = numRegHistorialTipoPersonalApoyAtencPrevEmergDesast;
    }
    public ApoyoAtencPrevEmergDesast getApoyoAtencPrevEmergDesast() {
        return apoyoAtencPrevEmergDesast;
    }
    public void setApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast) {
        this.apoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesast;
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
    public Long getDiasEmpleadosTipoPersonalApoyAtencPrevEmergDesast() {
        return diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast;
    }
    public void setDiasEmpleadosTipoPersonalApoyAtencPrevEmergDesast(Long diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast) {
        this.diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast = diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast;
    }*/
}
