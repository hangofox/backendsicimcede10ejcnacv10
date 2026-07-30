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
@Table(name = "TABLA_HISTORIAL_ORDENES_APOYOS_MOVIMIENTOS_TROPAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialOrdenApoyoMovimientoTropa {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_ORDEN_APOYO_MOVIMIENTO_TROPA", columnDefinition = "NUMBER(20) NOT NULL")
    private Long idHistorialOrdenApoyoMovimientoTropa;
    
    @Column(name = "NUM_REG_HISTORIAL_ORDEN_APOYO_MOVIMIENTO_TROPA", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String numRegHistorialOrdenApoyoMovimientoTropa;
    
    //@Column(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoAtencPrevEmergDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast;
    
    @Column(name = "NUMERO_OFICIO_HR_ORDEN_APOYO_MOVIMIENTO_TROPA", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String numeroOficioHrOrdenApoyoMovimientoTropa;
    
    @Column(name = "ASUNTO_ORDEN_APOYO_MOVIMIENTO_TROPA", columnDefinition = "CLOB NOT NULL")
    //@Lob
    private String asuntoOrdenApoyoMovimientoTropa;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialOrdenApoyoMovimientoTropa() {
        return idHistorialOrdenApoyoMovimientoTropa;
    }
    public void setIdHistorialOrdenApoyoMovimientoTropa(Long idHistorialOrdenApoyoMovimientoTropa) {
        this.idHistorialOrdenApoyoMovimientoTropa = idHistorialOrdenApoyoMovimientoTropa;
    }
    public String getNumRegHistorialOrdenApoyoMovimientoTropa() {
        return numRegHistorialOrdenApoyoMovimientoTropa;
    }
    public void setNumRegHistorialOrdenApoyoMovimientoTropa(String numRegHistorialOrdenApoyoMovimientoTropa) {
        this.numRegHistorialOrdenApoyoMovimientoTropa = numRegHistorialOrdenApoyoMovimientoTropa;
    }
    public ApoyoAtencPrevEmergDesast getApoyoAtencPrevEmergDesast() {
        return apoyoAtencPrevEmergDesast;
    }
    public void setApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast) {
        this.apoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesast;
    }
    public String getNumeroOficioHrOrdenApoyoMovimientoTropa() {
        return numeroOficioHrOrdenApoyoMovimientoTropa;
    }
    public void setNumeroOficioHrOrdenApoyoMovimientoTropa(String numeroOficioHrOrdenApoyoMovimientoTropa) {
        this.numeroOficioHrOrdenApoyoMovimientoTropa = numeroOficioHrOrdenApoyoMovimientoTropa;
    }
    public String getAsuntoOrdenApoyoMovimientoTropa() {
        return asuntoOrdenApoyoMovimientoTropa;
    }
    public void setAsuntoOrdenApoyoMovimientoTropa(String asuntoOrdenApoyoMovimientoTropa) {
        this.asuntoOrdenApoyoMovimientoTropa = asuntoOrdenApoyoMovimientoTropa;
    }*/
}
