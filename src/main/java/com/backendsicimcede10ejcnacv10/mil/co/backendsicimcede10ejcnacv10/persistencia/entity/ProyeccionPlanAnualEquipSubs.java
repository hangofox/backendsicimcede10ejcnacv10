//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PROYECCIONES_PLANES_ANUALES_EQUIP_SUBS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ProyeccionPlanAnualEquipSubs {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PROYECCION_PLAN_ANUAL_EQUIP_SUBS", columnDefinition="NUMBER(20) NOT NULL")
    private Long idProyeccionPlanAnualEquipSubs;
    
    //@Column(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_GENERAL", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idProyeccionPlanAnualAdqGeneral;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_PROYECCION_PLAN_ANUAL_ADQ_GENERAL", columnDefinition = "NUMBER(20) NOT NULL")
    private ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral;
    
    @Column(name = "NOMBRE_PROYECCION_PLAN_ANUAL_EQUIP_SUBS", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreProyeccionPlanAnualEquipSubs;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "NOMBRE_Y_NUMERO_RUBRO_PROYECCION_PLAN_ANUAL_EQUIP_SUBS", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreYNumeroRubroProyeccionPlanAnualEquipSubs;
    
    @Column(name = "VALOR_SOLICITADO_PROYECCION_PLAN_ANUAL_EQUIP_SUBS", columnDefinition="VARCHAR2(150) NULL")
    private String valorSolicitadoProyeccionPlanAnualEquipSubs;
    
    @Column(name = "NOMBRE_BIEN_O_SERVICIO_PROYECCION_PLAN_ANUAL_EQUIP_SUBS", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreBienOServicioProyeccionPlanAnualEquipSubs;
    
    @Lob
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_PROY_PL_AN_NEC_EQUIP_SUBS", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoProyPlAnNecEquipSubs;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
        public Long getIdProyeccionPlanAnualEquipSubs() {
        return idProyeccionPlanAnualEquipSubs;
    }
    public void setIdProyeccionPlanAnualEquipSubs(Long idProyeccionPlanAnualEquipSubs) {
        this.idProyeccionPlanAnualEquipSubs = idProyeccionPlanAnualEquipSubs;
    }
    public ProyeccionPlanAnualAdqGeneral getProyeccionPlanAnualAdqGeneral() {
        return proyeccionPlanAnualAdqGeneral;
    }
    public void setProyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral) {
        this.proyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqGeneral;
    }
    public String getNombreProyeccionPlanAnualEquipSubs() {
        return nombreProyeccionPlanAnualEquipSubs;
    }
    public void setNombreProyeccionPlanAnualEquipSubs(String nombreProyeccionPlanAnualEquipSubs) {
        this.nombreProyeccionPlanAnualEquipSubs = nombreProyeccionPlanAnualEquipSubs;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public String getNombreYNumeroRubroProyeccionPlanAnualEquipSubs() {
        return nombreYNumeroRubroProyeccionPlanAnualEquipSubs;
    }
    public void setNombreYNumeroRubroProyeccionPlanAnualEquipSubs(String nombreYNumeroRubroProyeccionPlanAnualEquipSubs) {
        this.nombreYNumeroRubroProyeccionPlanAnualEquipSubs = nombreYNumeroRubroProyeccionPlanAnualEquipSubs;
    }
    public String getValorSolicitadoProyeccionPlanAnualEquipSubs() {
        return valorSolicitadoProyeccionPlanAnualEquipSubs;
    }
    public void setValorSolicitadoProyeccionPlanAnualEquipSubs(String valorSolicitadoProyeccionPlanAnualEquipSubs) {
        this.valorSolicitadoProyeccionPlanAnualEquipSubs = valorSolicitadoProyeccionPlanAnualEquipSubs;
    }
    public String getNombreBienOServicioProyeccionPlanAnualEquipSubs() {
        return nombreBienOServicioProyeccionPlanAnualEquipSubs;
    }
    public void setNombreBienOServicioProyeccionPlanAnualEquipSubs(String nombreBienOServicioProyeccionPlanAnualEquipSubs) {
        this.nombreBienOServicioProyeccionPlanAnualEquipSubs = nombreBienOServicioProyeccionPlanAnualEquipSubs;
    }
    public String getNombreArchivoDocumentoAnexoProyPlAnNecEquipSubs() {
        return nombreArchivoDocumentoAnexoProyPlAnNecEquipSubs;
    }
    public void setNombreArchivoDocumentoAnexoProyPlAnNecEquipSubs(String nombreArchivoDocumentoAnexoProyPlAnNecEquipSubs) {
        this.nombreArchivoDocumentoAnexoProyPlAnNecEquipSubs = nombreArchivoDocumentoAnexoProyPlAnNecEquipSubs;
    }*/
}
