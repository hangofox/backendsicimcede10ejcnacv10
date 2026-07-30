//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
//import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PRIVILEG_Y_RESTRICC_ACCESOS_USUARIOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class PrivilegyRestriccAccesoUsuario {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PRIVILEGIO_Y_RESTRICCION_ACCESO_USUARIO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idPrivilegioyRestriccionAccesoUsuario;
    
    @Column(name = "NUMERO_REGISTRO_PRIVILEGIO_Y_RESTRICCION_ACCESO_USUARIO", columnDefinition="VARCHAR(150) NOT NULL")
    private String numeroRegistroPrivilegioyRestriccionAccesoUsuario;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    @OneToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_USUARIO", columnDefinition = "NUMBER(20) NOT NULL")
    private Usuario usuario;
    
    @OneToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_FUNCIONALIDAD", columnDefinition = "NUMBER(20) NOT NULL")
    private Funcionalidad funcionalidad;
    
    @OneToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ROL", columnDefinition = "NUMBER(20) NOT NULL")
    private Rol rol;
    
    @Column(name = "URL_ACCESO_USUARIO", columnDefinition="VARCHAR(150) NULL")
    private String urlAccesoUsuario;
    
    @Column(name = "SI_O_NO_PRIVILEGIO_Y_RESTRICCION_ACCESO_USUARIO", columnDefinition="VARCHAR2(50) NOT NULL")
    private String sioNoPrivilegioyRestriccionAccesoUsuario;
    
    @Column(name = "FECHA_H_M_S_INGRESO_PRIVILEGIO_Y_RESTRICCION_ACCESO_USUARIO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdPrivilegioyRestriccionAccesoUsuario() {
        return idPrivilegioyRestriccionAccesoUsuario;
    }
    public void setIdPrivilegioyRestriccionAccesoUsuario(Long idPrivilegioyRestriccionAccesoUsuario) {
        this.idPrivilegioyRestriccionAccesoUsuario = idPrivilegioyRestriccionAccesoUsuario;
    }
    public String getNumeroRegistroPrivilegioyRestriccionAccesoUsuario() {
        return numeroRegistroPrivilegioyRestriccionAccesoUsuario;
    }
    public void setNumeroRegistroPrivilegioyRestriccionAccesoUsuario(String numeroRegistroPrivilegioyRestriccionAccesoUsuario) {
        this.numeroRegistroPrivilegioyRestriccionAccesoUsuario = numeroRegistroPrivilegioyRestriccionAccesoUsuario;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Funcionalidad getFuncionalidad() {
        return funcionalidad;
    }
    public void setFuncionalidad(Funcionalidad funcionalidad) {
        this.funcionalidad = funcionalidad;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getUrlAccesoUsuario() {
        return urlAccesoUsuario;
    }
    public void setUrlAccesoUsuario(String urlAccesoUsuario) {
        this.urlAccesoUsuario = urlAccesoUsuario;
    }
    public String getSioNoPrivilegioyRestriccionAccesoUsuario() {
        return sioNoPrivilegioyRestriccionAccesoUsuario;
    }
    public void setSioNoPrivilegioyRestriccionAccesoUsuario(String sioNoPrivilegioyRestriccionAccesoUsuario) {
        this.sioNoPrivilegioyRestriccionAccesoUsuario = sioNoPrivilegioyRestriccionAccesoUsuario;
    }
    public Date getFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario() {
        return fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario;
    }
    public void setFechaHMSIngresoPrivilegioyRestriccionAccesoUsuario(Date fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario) {
        this.fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario = fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario;
    }*/
}
