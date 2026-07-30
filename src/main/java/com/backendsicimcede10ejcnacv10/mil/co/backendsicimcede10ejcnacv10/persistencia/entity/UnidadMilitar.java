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
* @Since 01/08/2023.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_UNIDADES_MILITARES")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class UnidadMilitar {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_UNIDAD_MILITAR", columnDefinition="NUMBER(20) NOT NULL")
    private Long idUnidadMilitar;

    @Column(name = "CODIGO_UNIDAD_MILITAR", columnDefinition="VARCHAR2(150) NOT NULL")
    private String codigoUnidadMilitar;

    @Column(name = "NOMBRE_UNIDAD_MILITAR", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreUnidadMilitar;
    
    @Column(name = "SIGLA_O_ACRONIMO_UNIDAD_MILITAR", columnDefinition="VARCHAR2(250) NOT NULL")
    private String siglaoAcronimoUnidadMilitar;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_LOG_EXT_O_FMT_UNIDAD_MILITAR", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoLogExtoFmtUnidadMilitar;
    
    @Column(name = "NOMBRE_CARPETA_ALMACENAMIENTO_UNIDAD_MILITAR", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreCarpetaAlmacenamientoUnidadMilitar;

    @Column(name = "NIVEL_UNIDAD_MILITAR", columnDefinition="VARCHAR2(50) NOT NULL")
    private String nivelUnidadMilitar;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdUnidadMilitar() {
        return idUnidadMilitar;
    }
    public void setIdUnidadMilitar(Long idUnidadMilitar) {
        this.idUnidadMilitar = idUnidadMilitar;
    }
    public String getNombreUnidadMilitar() {
        return nombreUnidadMilitar;
    }
    public void setNombreUnidadMilitar(String nombreUnidadMilitar) {
        this.nombreUnidadMilitar = nombreUnidadMilitar;
    }
    public String getSiglaoAcronimoUnidadMilitar() {
        return siglaoAcronimoUnidadMilitar;
    }
    public void setSiglaoAcronimoUnidadMilitar(String siglaoAcronimoUnidadMilitar) {
        this.siglaoAcronimoUnidadMilitar = siglaoAcronimoUnidadMilitar;
    }
    public String getArchivoFotoLogExtoFmtUnidadMilitar() {
        return archivoFotoLogExtoFmtUnidadMilitar;
    }
    public void setArchivoFotoLogExtoFmtUnidadMilitar(String archivoFotoLogExtoFmtUnidadMilitar) {
        this.archivoFotoLogExtoFmtUnidadMilitar = archivoFotoLogExtoFmtUnidadMilitar;
    }
    public String getNombreCarpetaAlmacenamientoUnidadMilitar() {
        return nombreCarpetaAlmacenamientoUnidadMilitar;
    }
    public void setNombreCarpetaAlmacenamientoUnidadMilitar(String nombreCarpetaAlmacenamientoUnidadMilitar) {
        this.nombreCarpetaAlmacenamientoUnidadMilitar = nombreCarpetaAlmacenamientoUnidadMilitar;
    }*/
}
