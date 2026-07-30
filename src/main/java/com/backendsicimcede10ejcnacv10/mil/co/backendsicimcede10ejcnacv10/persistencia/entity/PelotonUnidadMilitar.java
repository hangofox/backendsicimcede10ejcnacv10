//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
//import java.io.Serializable;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PELOTONES_UNIDADES_MILITARES")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class PelotonUnidadMilitar {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PELOTON_UNIDAD_MILITAR", columnDefinition="NUMBER(20) NOT NULL")
    private Long idPelotonUnidadMilitar;
    
    @Column(name = "NOMBRE_PELOTON_UNIDAD_MILITAR", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombrePelotonUnidadMilitar;
    
    //@Column(name = "ID_COMPANIA_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idCompaniaUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_COMPANIA_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private CompaniaUnidadMilitar companiaUnidadMilitar;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdPelotonUnidadMilitar() {
        return idPelotonUnidadMilitar;
    }
    public void setIdPelotonUnidadMilitar(Long idPelotonUnidadMilitar) {
        this.idPelotonUnidadMilitar = idPelotonUnidadMilitar;
    }
    public CompaniaUnidadMilitar getCompaniaUnidadMilitar() {
        return companiaUnidadMilitar;
    }
    public void setCompaniaUnidadMilitar(CompaniaUnidadMilitar companiaUnidadMilitar) {
        this.companiaUnidadMilitar = companiaUnidadMilitar;
    }
    public String getNombrePelotonUnidadMilitar() {
        return nombrePelotonUnidadMilitar;
    }
    public void setNombrePelotonUnidadMilitar(String nombrePelotonUnidadMilitar) {
        this.nombreOficina = nombrePelotonUnidadMilitar;
    }*/
}
