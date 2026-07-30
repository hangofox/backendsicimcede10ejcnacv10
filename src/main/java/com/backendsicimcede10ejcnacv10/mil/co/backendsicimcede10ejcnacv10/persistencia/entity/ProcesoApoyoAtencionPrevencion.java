//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROCESOS_APOYOS_ATENCION_PREVENCION")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProcesoApoyoAtencionPrevencion {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROCESO_APOYO_ATENCION_PREVENCION", columnDefinition="NUMBER(20) NOT NULL")
    private Long idProcesoApoyoAtencionPrevencion;

    @Column(name = "NOMBRE_PROCESO_APOYO_ATENCION_PREVENCION", columnDefinition = "VARCHAR2(255) NOT NULL")
    private String nombreProcesoApoyoAtencionPrevencion;
    
    //@Column(name = "ID_TIPO_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoRequerimientoApoyoAtencionPrevencion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_REQUERIMIENTO_APOYO_ATENCION_PREVENCION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdProcesoApoyoAtencionPrevencion() {
        return idProcesoApoyoAtencionPrevencion;
    }
    public void setIdProcesoApoyoAtencionPrevencion(Long idProcesoApoyoAtencionPrevencion) {
        this.idProcesoApoyoAtencionPrevencion = idProcesoApoyoAtencionPrevencion;
    }
    public String getNombreProcesoApoyoAtencionPrevencion() {
        return nombreProcesoApoyoAtencionPrevencion;
    }
    public void setNombreProcesoApoyoAtencionPrevencion(String nombreProcesoApoyoAtencionPrevencion) {
        this.nombreProcesoApoyoAtencionPrevencion = nombreProcesoApoyoAtencionPrevencion;
    }
    public TipoRequerimientoApoyoAtencionPrevencion getTipoRequerimientoApoyoAtencionPrevencion() {
        return tipoRequerimientoApoyoAtencionPrevencion;
    }
    public void setTipoRequerimientoApoyoAtencionPrevencion(TipoRequerimientoApoyoAtencionPrevencion tipoRequerimientoApoyoAtencionPrevencion) {
        this.tipoRequerimientoApoyoAtencionPrevencion = tipoRequerimientoApoyoAtencionPrevencion;
    }*/
}
