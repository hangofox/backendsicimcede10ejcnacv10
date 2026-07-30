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
@Table(name = "TABLA_TIPOS_DESPEJES_ARTEFACTOS_EXPLOSIVOS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class TipoDespejeArtefactoExplosivo {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_TIPO_DESPEJE_ARTEFACTO_EXPLOSIVO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idTipoDespejeArtefactoExplosivo;
    
    @Column(name = "NOMBRE_TIPO_DESPEJE_ARTEFACTO_EXPLOSIVO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String nombreTipoDespejeArtefactoExplosivo;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdTipoDespejeArtefactoExplosivo() {
        return idTipoDespejeArtefactoExplosivo;
    }
    public void setIdTipoDespejeArtefactoExplosivo(Long idTipoDespejeArtefactoExplosivo) {
        this.idTipoDespejeArtefactoExplosivo = idTipoDespejeArtefactoExplosivo;
    }
    public String getNombreTipoDespejeArtefactoExplosivo() {
        return nombreTipoDespejeArtefactoExplosivo;
    }
    public void setNombreTipoDespejeArtefactoExplosivo(String nombreTipoDespejeArtefactoExplosivo) {
        this.nombreTipoDespejeArtefactoExplosivo = nombreTipoDespejeArtefactoExplosivo;
    }*/
}
