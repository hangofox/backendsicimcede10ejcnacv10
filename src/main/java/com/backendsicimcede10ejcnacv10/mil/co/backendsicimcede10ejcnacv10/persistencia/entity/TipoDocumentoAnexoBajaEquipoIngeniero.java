//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.io.Serializable;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_TIPOS_DOCUMENTOS_ANEXOS_BAJAS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class TipoDocumentoAnexoBajaEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_TIPO_DOCUMENTO_ANEXO_BAJA_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idTipoDocumentoAnexoBajaEquipoIngeniero;
    
    @Column(name = "NOMBRE_TIPO_DOCUMENTO_ANEXO_BAJA_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreTipoDocumentoAnexoBajaEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdTipoDocumentoAnexoBajaEquipoIngeniero() {
        return idTipoDocumentoAnexoBajaEquipoIngeniero;
    }
    public void setIdTipoDocumentoAnexoBajaEquipoIngeniero(Long idTipoDocumentoAnexoBajaEquipoIngeniero) {
        this.idTipoDocumentoAnexoBajaEquipoIngeniero = idTipoDocumentoAnexoBajaEquipoIngeniero;
    }
    public String getNombreTipoDocumentoAnexoBajaEquipoIngeniero() {
        return nombreTipoDocumentoAnexoBajaEquipoIngeniero;
    }
    public void setNombreTipoDocumentoAnexoBajaEquipoIngeniero(String nombreTipoDocumentoAnexoBajaEquipoIngeniero) {
        this.nombreTipoDocumentoAnexoBajaEquipoIngeniero = nombreTipoDocumentoAnexoBajaEquipoIngeniero;
    }*/
}
