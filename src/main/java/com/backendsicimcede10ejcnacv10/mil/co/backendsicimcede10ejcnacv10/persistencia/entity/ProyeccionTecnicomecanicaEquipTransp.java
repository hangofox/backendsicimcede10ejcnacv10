//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROYECCIONES_TECNICOMECANICAS_EQUIP_TRANSP")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProyeccionTecnicomecanicaEquipTransp {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROYECCION_TECNICOMECANICA_EQUIP_TRANSP", columnDefinition="NUMBER(20) NOT NULL")
    private Long idProyeccionTecnicomecanicaEquipTransp;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "NOMBRE_Y_NUMERO_RUBRO_PROYECCION_TECNICOMECANICA_EQUIP_TRANSP", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp;
    
    @Column(name = "VALOR_SOLICITADO_PROYECCION_TECNICOMECANICA_EQUIP_TRANSP", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoProyeccionTecnicomecanicaEquipTransp;
    
    @Column(name = "FECHA_H_M_S_PROYECCION_TECNICOMECANICA_EQUIP_TRANSP", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSProyeccionTecnicomecanicaEquipTransp;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdProyeccionTecnicomecanicaEquipTransp() {
        return idProyeccionTecnicomecanicaEquipTransp;
    }
    public void setIdProyeccionTecnicomecanicaEquipTransp(Long idProyeccionTecnicomecanicaEquipTransp) {
        this.idProyeccionTecnicomecanicaEquipTransp = idProyeccionTecnicomecanicaEquipTransp;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public String getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp() {
        return nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp;
    }
    public void setNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp(String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp) {
        this.nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp = nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp;
    }
    public String getValorSolicitadoProyeccionTecnicomecanicaEquipTransp() {
        return valorSolicitadoProyeccionTecnicomecanicaEquipTransp;
    }
    public void setValorSolicitadoProyeccionTecnicomecanicaEquipTransp(String valorSolicitadoProyeccionTecnicomecanicaEquipTransp) {
        this.valorSolicitadoProyeccionTecnicomecanicaEquipTransp = valorSolicitadoProyeccionTecnicomecanicaEquipTransp;
    }
    public Date getFechaHMSProyeccionTecnicomecanicaEquipTransp() {
        return fechaHMSProyeccionTecnicomecanicaEquipTransp;
    }
    public void setFechaHMSProyeccionTecnicomecanicaEquipTransp(Date fechaHMSProyeccionTecnicomecanicaEquipTransp) {
        this.fechaHMSProyeccionTecnicomecanicaEquipTransp = fechaHMSProyeccionTecnicomecanicaEquipTransp;
    }*/
}
