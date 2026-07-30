//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.*;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_HISTORIAL_DIAGNOSTICOS_INICIALES_SELECC_MTTOS_EQUIP_ING")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialDiagnosticoInicialSeleccMttoEquipIng {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_DIAGNOSTICO_INICIAL_SELECC_MTTO_EQUIP_ING", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialDiagnosticoInicialSeleccMttoEquipIng;
    
    @Column(name = "NUM_REG_HISTORIAL_DIAGNOSTICO_INICIAL_SELECC_MTTO_EQUIP_ING", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialDiagnosticoInicialSeleccMttoEquipIng;
    
    //@Column(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitar;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitar;
    
    //@Column(name = "ID_UNIDAD_MILITAR_REALIZADORA_MANTENIMIENTO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idUnidadMilitarRealizadoraMantenimiento;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_UNIDAD_MILITAR_REALIZADORA_MANTENIMIENTO", columnDefinition = "NUMBER(20) NOT NULL")
    private UnidadMilitar unidadMilitarRealizadoraMantenimiento;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_HIST_DIAG_INIC_SELECC_MTTO_EQUIP_ING", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng;
    
    @Column(name = "DESCRIPCION_OBJETIVO_HISTORIAL_DIAGNOSTICO_INICIAL_SELECC_MTTO_EQUIP_ING", columnDefinition="CLOB NULL")
    private String descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng;
    
    //@Column(name = "ID_ESTADO_DIAGNOSTICO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEstadoDiagnosticoEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_ESTADO_DIAGNOSTICO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialDiagnosticoInicialSeleccMttoEquipIng() {
        return idHistorialDiagnosticoInicialSeleccMttoEquipIng;
    }
    public void setIdHistorialDiagnosticoInicialSeleccMttoEquipIng(Long idHistorialDiagnosticoInicialSeleccMttoEquipIng) {
        this.idHistorialDiagnosticoInicialSeleccMttoEquipIng = idHistorialDiagnosticoInicialSeleccMttoEquipIng;
    }
    public String getNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng() {
        return numRegHistorialDiagnosticoInicialSeleccMttoEquipIng;
    }
    public void setNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng(String numRegHistorialDiagnosticoInicialSeleccMttoEquipIng) {
        this.numRegHistorialDiagnosticoInicialSeleccMttoEquipIng = numRegHistorialDiagnosticoInicialSeleccMttoEquipIng;
    }
    public UnidadMilitar getUnidadMilitar() {
        return unidadMilitar;
    }
    public void setUnidadMilitar(UnidadMilitar unidadMilitar) {
        this.unidadMilitar = unidadMilitar;
    }
    public UnidadMilitar getUnidadMilitarRealizadoraMantenimiento() {
        return unidadMilitarRealizadoraMantenimiento;
    }
    public void setUnidadMilitarRealizadoraMantenimiento(UnidadMilitar unidadMilitarRealizadoraMantenimiento) {
        this.unidadMilitarRealizadoraMantenimiento = unidadMilitarRealizadoraMantenimiento;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public String getNombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng() {
        return nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng;
    }
    public void setNombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng(String nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng) {
        this.nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng = nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng;
    }
    public String getDescripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng() {
        return descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng;
    }
    public void setDescripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng(String descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng) {
        this.descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng = descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng;
    }
    public EstadoDiagnosticoEquipoIngeniero getEstadoDiagnosticoEquipoIngeniero() {
        return estadoDiagnosticoEquipoIngeniero;
    }
    public void setEstadoDiagnosticoEquipoIngeniero(EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero) {
        this.estadoDiagnosticoEquipoIngeniero = estadoDiagnosticoEquipoIngeniero;
    }*/
}
