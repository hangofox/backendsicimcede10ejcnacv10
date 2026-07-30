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
@Table(name = "TABLA_PERSONAL_MANTENIMIENTOS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class PersonalMantenimientoEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PERSONAL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idPersonalMantenimientoEquipoIngeniero;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @Column(name = "NUM_DOC_IDENTIF_PERSONAL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition = "VARCHAR(150) NOT NULL")
    private String numDocIdentifPersonalMantenimientoEquipoIngeniero;
    
    @Column(name = "GRADO_PERSONAL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NULL")
    private String gradoPersonalMantenimientoEquipoIngeniero;
    
    @Column(name = "NOMBRES_Y_APELLIDOS_PERSONAL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombresyApellidosPersonalMantenimientoEquipoIngeniero;
    
    @Column(name = "CARGO_PERSONAL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String cargoPersonalMantenimientoEquipoIngeniero;

    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdPersonalMantenimientoEquipoIngeniero() {
        return idPersonalMantenimientoEquipoIngeniero;
    }
    public void setIdPersonalMantenimientoEquipoIngeniero(Long idPersonalMantenimientoEquipoIngeniero) {
        this.idPersonalMantenimientoEquipoIngeniero = idPersonalMantenimientoEquipoIngeniero;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public String getNumDocIdentifPersonalMantenimientoEquipoIngeniero() {
        return numDocIdentifPersonalMantenimientoEquipoIngeniero;
    }
    public void setNumDocIdentifPersonalMantenimientoEquipoIngeniero(String numDocIdentifPersonalMantenimientoEquipoIngeniero) {
        this.numDocIdentifPersonalMantenimientoEquipoIngeniero = numDocIdentifPersonalMantenimientoEquipoIngeniero;
    }
    public String getGradoPersonalMantenimientoEquipoIngeniero() {
        return gradoPersonalMantenimientoEquipoIngeniero;
    }
    public void setGradoPersonalMantenimientoEquipoIngeniero(String gradoPersonalMantenimientoEquipoIngeniero) {
        this.gradoPersonalMantenimientoEquipoIngeniero = gradoPersonalMantenimientoEquipoIngeniero;
    }
    public String getNombresyApellidosPersonalMantenimientoEquipoIngeniero() {
        return nombresyApellidosPersonalMantenimientoEquipoIngeniero;
    }
    public void setNombresyApellidosPersonalMantenimientoEquipoIngeniero(String nombresyApellidosPersonalMantenimientoEquipoIngeniero) {
        this.nombresyApellidosPersonalMantenimientoEquipoIngeniero = nombresyApellidosPersonalMantenimientoEquipoIngeniero;
    }
    public String getCargoPersonalMantenimientoEquipoIngeniero() {
        return cargoPersonalMantenimientoEquipoIngeniero;
    }
    public void setCargoPersonalMantenimientoEquipoIngeniero(String cargoPersonalMantenimientoEquipoIngeniero) {
        this.cargoPersonalMantenimientoEquipoIngeniero = cargoPersonalMantenimientoEquipoIngeniero;
    }*/
}
