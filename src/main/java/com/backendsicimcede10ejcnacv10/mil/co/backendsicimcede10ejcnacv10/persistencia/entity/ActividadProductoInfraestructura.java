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
@Table(name = "TABLA_ACTIVIDADES_PRODUCTOS_INFRAESTRUCTURAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ActividadProductoInfraestructura {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_ACTIVIDAD_PRODUCTO_INFRAESTRUCTURA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idActividadProductoInfraestructura;
    
    @Column(name = "NOMBRE_ACTIVIDAD_PRODUCTO_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(250) NOT NULL")
    private String nombreActividadProductoInfraestructura;
    
    //@Column(name = "ID_CAPITULO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idCapituloInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_CAPITULO_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private CapituloInfraestructura capituloInfraestructura;
    
    @Column(name = "SIGLA_O_ACRONIMO_UNIDAD_MEDIDA_ACTIVIDAD_PRODUCTO_INFRAESTRUCTURA", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String siglaOAcronimoUnidadMedidaActividadProductoInfraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdActividadProductoInfraestructura() {
        return idActividadProductoInfraestructura;
    }
    public void setIdActividadProductoInfraestructura(Long idActividadProductoInfraestructura) {
        this.idActividadProductoInfraestructura = idActividadProductoInfraestructura;
    }
    public String getNombreActividadProductoInfraestructura() {
        return nombreActividadProductoInfraestructura;
    }
    public void setNombreActividadProductoInfraestructura(String nombreActividadProductoInfraestructura) {
        this.nombreActividadProductoInfraestructura = nombreActividadProductoInfraestructura;
    }
    public CapituloInfraestructura getCapituloInfraestructura() {
        return capituloInfraestructura;
    }
    public void setCapituloInfraestructura(CapituloInfraestructura capituloInfraestructura) {
        this.capituloInfraestructura = capituloInfraestructura;
    }
    public String getSiglaOAcronimoUnidadMedidaActividadProductoInfraestructura() {
        return siglaOAcronimoUnidadMedidaActividadProductoInfraestructura;
    }
    public void setSiglaOAcronimoUnidadMedidaActividadProductoInfraestructura(String siglaOAcronimoUnidadMedidaActividadProductoInfraestructura) {
        this.siglaOAcronimoUnidadMedidaActividadProductoInfraestructura = siglaOAcronimoUnidadMedidaActividadProductoInfraestructura;
    }*/
}
