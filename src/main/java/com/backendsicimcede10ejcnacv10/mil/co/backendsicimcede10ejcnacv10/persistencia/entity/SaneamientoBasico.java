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
@Table(name = "TABLA_SANEAMIENTOS_BASICOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class SaneamientoBasico {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_SANEAMIENTO_BASICO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idSaneamientoBasico;
    
    @Column(name = "NOMBRE_CAUDAL_SANEAMIENTO_BASICO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreCaudalSaneamientoBasico;
    
    @Column(name = "NOMBRE_UNIDAD_MEDIDA_SANEAMIENTO_BASICO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreUnidadMedidaSaneamientoBasico;
    
    //@Column(name = "ID_OFICINA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idOficina;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_OFICINA", columnDefinition = "NUMBER(20) NOT NULL")
    private Oficina oficina;
    
    @Column(name = "CENTRO_COSTO_OFICINA_SANEAMIENTO_BASICO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String centroCostoOficinaSaneamientoBasico;
    
    //@Column(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private Infraestructura infraestructura;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdSaneamientoBasico() {
        return idSaneamientoBasico;
    }
    public void setIdSaneamientoBasico(Long idSaneamientoBasico) {
        this.idSaneamientoBasico = idSaneamientoBasico;
    }
    public String getNombreCaudalSaneamientoBasico() {
        return nombreCaudalSaneamientoBasico;
    }
    public void setNombreCaudalSaneamientoBasico(String nombreCaudalSaneamientoBasico) {
        this.nombreCaudalSaneamientoBasico = nombreCaudalSaneamientoBasico;
    }
    public String getNombreUnidadMedidaSaneamientoBasico() {
        return nombreUnidadMedidaSaneamientoBasico;
    }
    public void setNombreUnidadMedidaSaneamientoBasico(String nombreUnidadMedidaSaneamientoBasico) {
        this.nombreUnidadMedidaSaneamientoBasico = nombreUnidadMedidaSaneamientoBasico;
    }
    public Oficina getOficina() {
        return oficina;
    }
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public String getCentroCostoOficinaSaneamientoBasico() {
        return centroCostoOficinaSaneamientoBasico;
    }
    public void setCentroCostoOficinaSaneamientoBasico(String centroCostoOficinaSaneamientoBasico) {
        this.centroCostoOficinaSaneamientoBasico = centroCostoOficinaSaneamientoBasico;
    }
    public Infraestructura getInfraestructura() {
        return infraestructura;
    }
    public void setInfraestructura(Infraestructura infraestructura) {
        this.infraestructura = infraestructura;
    }*/
}
