//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_GERENTES_PROYECTOS_SOLIC_INFRAEST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class GerenteProyectoSolicInfraest {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_GERENTE_PROYECTO_SOLIC_INFRAEST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idGerenteProyectoSolicInfraest;
    
    //@Column(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idSolicitudInfraestructura;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_SOLICITUD_INFRAESTRUCTURA", columnDefinition = "NUMBER(20) NOT NULL")
    private SolicitudInfraestructura solicitudInfraestructura;
    
    @Column(name = "GRADO_GERENTE_PROYECTO_SOLIC_INFRAEST", columnDefinition="VARCHAR2(255) NULL")
    private String gradoGerenteProyectoSolicInfraest;
    
    @Column(name = "NOMBRES_GERENTE_PROYECTO_SOLIC_INFRAEST", columnDefinition="VARCHAR2(255) NULL")
    private String nombresGerenteProyectoSolicInfraest;
    
    @Column(name = "PRIMER_APELLIDO_GERENTE_PROYECTO_SOLIC_INFRAEST", columnDefinition="VARCHAR2(255) NULL")
    private String primerApellidoGerenteProyectoSolicInfraest;
    
    @Column(name = "SEGUNDO_APELLIDO_GERENTE_PROYECTO_SOLIC_INFRAEST", columnDefinition="VARCHAR2(255) NULL")
    private String segundoApellidoGerenteProyectoSolicInfraest;
    
    @Column(name = "MOVIL_GERENTE_PROYECTO_SOLIC_INFRAEST", columnDefinition="VARCHAR2(150) NOT NULL")
    private String movilGerenteProyectoSolicInfraest;
    
    @Column(name = "CARGO_ACTUAL_GERENTE_PROYECTO_SOLIC_INFRAEST", columnDefinition="VARCHAR2(255) NULL")
    private String cargoActualGerenteProyectoSolicInfraest;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdGerenteProyectoSolicInfraest() {
        return idGerenteProyectoSolicInfraest;
    }
    public void setIdGerenteProyectoSolicInfraest(Long idGerenteProyectoSolicInfraest) {
        this.idGerenteProyectoSolicInfraest = idGerenteProyectoSolicInfraest;
    }
    public SolicitudInfraestructura getSolicitudInfraestructura() {
        return solicitudInfraestructura;
    }
    public void setSolicitudInfraestructura(SolicitudInfraestructura solicitudInfraestructura) {
        this.solicitudInfraestructura = solicitudInfraestructura;
    }
    public String getGradoGerenteProyectoSolicInfraest() {
        return gradoGerenteProyectoSolicInfraest;
    }
    public void setGradoGerenteProyectoSolicInfraest(String gradoGerenteProyectoSolicInfraest) {
        this.gradoGerenteProyectoSolicInfraest = gradoGerenteProyectoSolicInfraest;
    }
    public String getNombresGerenteProyectoSolicInfraest() {
        return nombresGerenteProyectoSolicInfraest;
    }
    public void setNombresGerenteProyectoSolicInfraest(String nombresGerenteProyectoSolicInfraest) {
        this.nombresGerenteProyectoSolicInfraest = nombresGerenteProyectoSolicInfraest;
    }
    public String getPrimerApellidoGerenteProyectoSolicInfraest() {
        return primerApellidoGerenteProyectoSolicInfraest;
    }
    public void setPrimerApellidoGerenteProyectoSolicInfraest(String primerApellidoGerenteProyectoSolicInfraest) {
        this.primerApellidoGerenteProyectoSolicInfraest = primerApellidoGerenteProyectoSolicInfraest;
    }
    public String getSegundoApellidoGerenteProyectoSolicInfraest() {
        return segundoApellidoGerenteProyectoSolicInfraest;
    }
    public void setSegundoApellidoGerenteProyectoSolicInfraest(String segundoApellidoGerenteProyectoSolicInfraest) {
        this.segundoApellidoGerenteProyectoSolicInfraest = segundoApellidoGerenteProyectoSolicInfraest;
    }
    public String getMovilGerenteProyectoSolicInfraest() {
        return movilGerenteProyectoSolicInfraest;
    }
    public void setMovilGerenteProyectoSolicInfraest(String movilGerenteProyectoSolicInfraest) {
        this.movilGerenteProyectoSolicInfraest = movilGerenteProyectoSolicInfraest;
    }
    public String getCargoActualGerenteProyectoSolicInfraest() {
        return cargoActualGerenteProyectoSolicInfraest;
    }
    public void setCargoActualGerenteProyectoSolicInfraest(String cargoActualGerenteProyectoSolicInfraest) {
        this.cargoActualGerenteProyectoSolicInfraest = cargoActualGerenteProyectoSolicInfraest;
    }*/
}
