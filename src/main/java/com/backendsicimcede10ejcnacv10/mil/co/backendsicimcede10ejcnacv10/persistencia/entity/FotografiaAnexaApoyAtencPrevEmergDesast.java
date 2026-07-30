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
@Table(name = "TABLA_FOTOGRAFIAS_ANEXAS_APOYOS_ATENC_PREV_EMERG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class FotografiaAnexaApoyAtencPrevEmergDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_FOTOGRAFIAS_ANEXAS_APOY_ATENC_PREV_EMERG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idFotografiasAnexasApoyAtencPrevEmergDesast;
    
    //@Column(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoAtencPrevEmergDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_ATENC_PREV_EMERG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_APOY_ATENC_PREV_EMERG_DESAST1", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_APOY_ATENC_PREV_EMERG_DESAST2", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_APOY_ATENC_PREV_EMERG_DESAST3", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_APOY_ATENC_PREV_EMERG_DESAST4", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdFotografiasAnexasApoyAtencPrevEmergDesast() {
        return idFotografiasAnexasApoyAtencPrevEmergDesast;
    }
    public void setIdFotografiasAnexasApoyAtencPrevEmergDesast(Long idFotografiasAnexasApoyAtencPrevEmergDesast) {
        this.idFotografiasAnexasApoyAtencPrevEmergDesast = idFotografiasAnexasApoyAtencPrevEmergDesast;
    }
    public ApoyoAtencPrevEmergDesast getApoyoAtencPrevEmergDesast() {
        return apoyoAtencPrevEmergDesast;
    }
    public void setApoyoAtencPrevEmergDesast(ApoyoAtencPrevEmergDesast apoyoAtencPrevEmergDesast) {
        this.apoyoAtencPrevEmergDesast = apoyoAtencPrevEmergDesast;
    }
    public String getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1() {
        return nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1;
    }
    public void setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1(String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1) {
        this.nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1 = nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast1;
    }
    public String getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2() {
        return nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2;
    }
    public void setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2(String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2) {
        this.nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2 = nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast2;
    }
    public String getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3() {
        return nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3;
    }
    public void setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3(String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3) {
        this.nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3 = nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast3;
    }
    public String getNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4() {
        return nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4;
    }
    public void setNombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4(String nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4) {
        this.nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4 = nombreArchivoFotoExtensionOFormatoApoyAtencPrevEmergDesast4;
    }*/
}
