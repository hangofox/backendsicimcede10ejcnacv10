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
@Table(name = "TABLA_UNIDADES_MILITARES_REALIZADORAS_MANTENIMIENTOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class UnidadMilitarRealizadoraMantenimiento {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_UNIDAD_MILITAR_REALIZADORA_MANTENIMIENTO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idUnidadMilitarRealizadoraMantenimiento;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "CODIGO_UNIDAD_MILITAR_REALIZADORA_MANTENIMIENTO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String codigoUnidadMilitarRealizadoraMantenimiento;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getUnidadMilitarRealizadoraMantenimiento() {
        return idUnidadMilitarRealizadoraMantenimiento;
    }
    public void setIdUnidadMilitarRealizadoraMantenimiento(Long idUnidadMilitarRealizadoraMantenimiento) {
        this.idUnidadMilitarRealizadoraMantenimiento = idUnidadMilitarRealizadoraMantenimiento;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getCodigoUnidadMilitarRealizadoraMantenimiento() {
        return codigoUnidadMilitarRealizadoraMantenimiento;
    }
    public void setCodigoUnidadMilitarRealizadoraMantenimiento(String codigoUnidadMilitarRealizadoraMantenimiento) {
        this.codigoUnidadMilitarRealizadoraMantenimiento = codigoUnidadMilitarRealizadoraMantenimiento;
    }*/
}
