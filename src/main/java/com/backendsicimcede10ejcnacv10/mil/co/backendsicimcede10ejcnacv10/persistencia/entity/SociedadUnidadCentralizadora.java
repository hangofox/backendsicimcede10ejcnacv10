//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
//import java.io.Serializable;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_SOCIEDADES_UNIDADES_CENTRALIZADORAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class SociedadUnidadCentralizadora {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idSociedadUnidadCentralizadora;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;

    @Column(name = "CODIGO_SOCIEDAD_UNIDAD_CENTRALIZADORA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String codigoSociedadUnidadCentralizadora;

    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getSociedadUnidadCentralizadora() {
        return idSociedadUnidadCentralizadora;
    }
    public void setIdSociedadUnidadCentralizadora(Long idSociedadUnidadCentralizadora) {
        this.idSociedadUnidadCentralizadora = idSociedadUnidadCentralizadora;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getCodigoSociedadUnidadCentralizadora() {
        return codigoSociedadUnidadCentralizadora;
    }
    public void setCodigoSociedadUnidadCentralizadora(String codigoSociedadUnidadCentralizadora) {
        this.codigoSociedadUnidadCentralizadora = codigoSociedadUnidadCentralizadora;
    }*/
}
