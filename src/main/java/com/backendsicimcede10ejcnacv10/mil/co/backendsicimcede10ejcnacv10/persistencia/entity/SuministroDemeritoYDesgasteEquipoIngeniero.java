//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_SUMINISTROS_DEMERITOS_Y_DESGASTES_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class SuministroDemeritoYDesgasteEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_SUMINISTRO_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idSuministroDemeritoYDesgasteEquipoIngeniero;
    
    //@Column(name = "ID_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idHistorialDemeritoYDesgasteEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_HISTORIAL_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngeniero;
    
    @Column(name = "NOMBRE_SUMINISTRO_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(255) NOT NULL")
    private String nombreSuministroDemeritoYDesgasteEquipoIngeniero;
    
    @Column(name = "VALOR_SUMINISTRO_DEMERITO_Y_DESGASTE_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String valorSuministroDemeritoYDesgasteEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdSuministroDemeritoYDesgasteEquipoIngeniero() {
        return idSuministroDemeritoYDesgasteEquipoIngeniero;
    }
    public void setIdSuministroDemeritoYDesgasteEquipoIngeniero(Long idSuministroDemeritoYDesgasteEquipoIngeniero) {
        this.idSuministroDemeritoYDesgasteEquipoIngeniero = idSuministroDemeritoYDesgasteEquipoIngeniero;
    }
    public HistorialDemeritoYDesgasteEquipoIngeniero getHistorialDemeritoYDesgasteEquipoIngeniero() {
        return historialDemeritoYDesgasteEquipoIngeniero;
    }
    public void setHistorialDemeritoYDesgasteEquipoIngeniero(HistorialDemeritoYDesgasteEquipoIngeniero historialDemeritoYDesgasteEquipoIngeniero) {
        this.historialDemeritoYDesgasteEquipoIngeniero = historialDemeritoYDesgasteEquipoIngeniero;
    }
    public String getNombreSuministroDemeritoYDesgasteEquipoIngeniero() {
        return nombreSuministroDemeritoYDesgasteEquipoIngeniero;
    }
    public void setNombreSuministroDemeritoYDesgasteEquipoIngeniero(String nombreSuministroDemeritoYDesgasteEquipoIngeniero) {
        this.nombreSuministroDemeritoYDesgasteEquipoIngeniero = nombreSuministroDemeritoYDesgasteEquipoIngeniero;
    }
    public String getValorSuministroDemeritoYDesgasteEquipoIngeniero() {
        return valorSuministroDemeritoYDesgasteEquipoIngeniero;
    }
    public void setValorSuministroDemeritoYDesgasteEquipoIngeniero(String valorSuministroDemeritoYDesgasteEquipoIngeniero) {
        this.valorSuministroDemeritoYDesgasteEquipoIngeniero = valorSuministroDemeritoYDesgasteEquipoIngeniero;
    }*/
}
