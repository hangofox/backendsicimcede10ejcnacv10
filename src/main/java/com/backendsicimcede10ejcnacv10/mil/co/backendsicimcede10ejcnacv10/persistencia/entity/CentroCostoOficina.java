//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 18/12/2025.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_CENTROS_COSTOS_OFICINAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class CentroCostoOficina {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_CENTRO_COSTO_OFICINA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idCentroCostoOficina;
    
    //@Column(name = "ID_OFICINA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idOficina;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_OFICINA", columnDefinition = "NUMBER(20) NOT NULL")
    private Oficina oficina;
    
    @Column(name = "CENTRO_COSTO_OFICINA", columnDefinition = "VARCHAR2(150) NOT NULL")
    private String centroCostoOficina;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdCentroCostoOficina() {
        return idCentroCostoOficina;
    }
    public void setIdCentroCostoOficina(Long idCentroCostoOficina) {
        this.idCentroCostoOficina = idCentroCostoOficina;
    }
    public Oficina getOficina() {
        return oficina;
    }
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public String getCentroCostoOficina() {
        return centroCostoOficina;
    }
    public void setCentroCostoOficina(String centroCostoOficina) {
        this.centroCostoOficina = centroCostoOficina;
    }*/
}
