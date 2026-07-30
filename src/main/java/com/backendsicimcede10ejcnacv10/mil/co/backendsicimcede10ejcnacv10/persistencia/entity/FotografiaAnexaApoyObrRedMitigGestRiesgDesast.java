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
@Table(name = "TABLA_FOTOGRAFIAS_ANEXAS_APOYOS_OBR_RED_MITIG_GEST_RIESG_DESAST")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class FotografiaAnexaApoyObrRedMitigGestRiesgDesast {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_FOTOGRAFIAS_ANEXAS_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition="NUMBER(20) NOT NULL")
    private Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast;
    
    //@Column(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idApoyoObrRedMitigGestRiesgDesast;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST", columnDefinition = "NUMBER(20) NOT NULL")
    private ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST1", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1;
    
    @Column(name = "NOMBRE_ARCHIVO_FOTO_EXTENSION_O_FORMATO_APOY_OBR_RED_MITIG_GEST_RIESG_DESAST2", columnDefinition="CLOB NULL")
    //@Lob
    private String nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast() {
        return idFotografiasAnexasApoyObrRedMitigGestRiesgDesast;
    }
    public void setIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast(Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast) {
        this.idFotografiasAnexasApoyObrRedMitigGestRiesgDesast = idFotografiasAnexasApoyObrRedMitigGestRiesgDesast;
    }
    public ApoyoObrRedMitigGestRiesgDesast getApoyoObrRedMitigGestRiesgDesast() {
        return apoyoObrRedMitigGestRiesgDesast;
    }
    public void setApoyoObrRedMitigGestRiesgDesast(ApoyoObrRedMitigGestRiesgDesast apoyoObrRedMitigGestRiesgDesast) {
        this.apoyoObrRedMitigGestRiesgDesast = apoyoObrRedMitigGestRiesgDesast;
    }
    public String getNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1() {
        return nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1;
    }
    public void setNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1(String nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1) {
        this.nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1 = nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast1;
    }
    public String getNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2() {
        return nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2;
    }
    public void setNombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2(String nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2) {
        this.nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2 = nombreArchivoFotoExtensionOFormatoApoyObrRedMitigGestRiesgDesast2;
    }*/
}
