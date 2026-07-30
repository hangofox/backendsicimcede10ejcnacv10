//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_ASEGURADORAS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class Aseguradora {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_ASEGURADORA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idAseguradora;
    
    @Column(name = "NOMBRE_ASEGURADORA", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreAseguradora;
    
    //@Column(name = "ID_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoDocumentoIdentificacion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_DOCUMENTO_IDENTIFICACION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoDocumentoIdentificacion tipoDocumentoIdentificacion;
    
    @Column(name = "NUMERO_DOCUMENTO_IDENTIFICACION_ASEGURADORA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numeroDocumentoIdentificacionAseguradora;
    
    @Column(name = "PAIS_ORIGEN_ASEGURADORA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String paisOrigenAseguradora;
    
    @Column(name = "DEPARTAMENTO_O_ESTADO_ORIGEN_ASEGURADORA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String departamentoOEstadoOrigenAseguradora;
    
    @Column(name = "CIUDAD_ORIGEN_ASEGURADORA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String ciudadOrigenAseguradora;
    
    @Column(name = "DIRECCION_ASEGURADORA", columnDefinition="VARCHAR2(150) NOT NULL")
    private String direccionAseguradora;
    
    @Column(name = "ESTADO_ASEGURADORA", columnDefinition="VARCHAR2(50) NOT NULL")
    private String estadoAseguradora;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdAseguradora() {
        return idAseguradora;
    }
    public void setIdAseguradora(Long idAseguradora) {
        this.idAseguradora = idAseguradora;
    }
    public String getNombreAseguradora() {
        return nombreAseguradora;
    }
    public void setNombreAseguradora(String nombreAseguradora) {
        this.nombreAseguradora = nombreAseguradora;
    }
    public TipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
        return tipoDocumentoIdentificacion;
    }
    public void setTipoDocumentoIdentificacion(TipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }
    public String getNumeroDocumentoIdentificacionAseguradora() {
        return numeroDocumentoIdentificacionAseguradora;
    }
    public void setNumeroDocumentoIdentificacionAseguradora(String numeroDocumentoIdentificacionAseguradora) {
        this.numeroDocumentoIdentificacionAseguradora = numeroDocumentoIdentificacionAseguradora;
    }
    public String getPaisOrigenAseguradora() {
        return paisOrigenAseguradora;
    }
    public void setPaisOrigenAseguradora(String paisOrigenAseguradora) {
        this.paisOrigenAseguradora = paisOrigenAseguradora;
    }
    public String getDepartamentoOEstadoOrigenAseguradora() {
        return departamentoOEstadoOrigenAseguradora;
    }
    public void setDepartamentoOEstadoOrigenAseguradora(String departamentoOEstadoOrigenAseguradora) {
        this.departamentoOEstadoOrigenAseguradora = departamentoOEstadoOrigenAseguradora;
    }
    public String getCiudadOrigenAseguradora() {
        return ciudadOrigenAseguradora;
    }
    public void setCiudadOrigenAseguradora(String ciudadOrigenAseguradora) {
        this.ciudadOrigenAseguradora = ciudadOrigenAseguradora;
    }
    public String getDireccionAseguradora() {
        return direccionAseguradora;
    }
    public void setDireccionAseguradora(String direccionAseguradora) {
        this.direccionAseguradora = direccionAseguradora;
    }
    public String getEstadoAseguradora() {
        return estadoAseguradora;
    }
    public void setEstadoAseguradora(String estadoAseguradora) {
        this.estadoAseguradora = estadoAseguradora;
    }*/
}
