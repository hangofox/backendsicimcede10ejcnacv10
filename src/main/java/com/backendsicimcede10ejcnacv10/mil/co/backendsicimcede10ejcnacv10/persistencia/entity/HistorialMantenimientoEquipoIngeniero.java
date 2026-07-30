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
@Table(name = "TABLA_HISTORIAL_MANTENIMIENTOS_EQUIPOS_INGENIEROS")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class HistorialMantenimientoEquipoIngeniero {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_HISTORIAL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="NUMBER(20) NOT NULL")
    private Long idHistorialMantenimientoEquipoIngeniero;
    
    @Column(name = "NUM_REG_HISTORIAL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NOT NULL")
    private String numRegHistorialMantenimientoEquipoIngeniero;
    
    //@Column(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private EquipoIngeniero equipoIngeniero;
    
    //@Column(name = "ID_NIVEL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idNivelMantenimientoEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_NIVEL_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero;
    
    //@Column(name = "ID_TIPO_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoMantenimientoEquipoIngeniero;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero;
    
    @Column(name = "ASUNTO_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="CLOB NOT NULL")
    private String asuntoMantenimientoEquipoIngeniero;
    
    @Column(name = "DESCRIPCION_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="CLOB NOT NULL")
    private String descripcionMantenimientoEquipoIngeniero;
    
    @Column(name = "FECHA_H_M_S_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition = "TIMESTAMP NOT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHMSMantenimientoEquipoIngeniero;
    
    //@Column(name = "ID_TIPO_FUENTE_FINANCIACION", columnDefinition = "NUMBER(20) NOT NULL")
    //private Long idTipoFuenteFinanciacion;
    //@JsonIgnore//OMITE DATO O CAMPO.
    @ManyToOne(fetch = FetchType.LAZY)//MAPEA RELACIÓN DE FORMA PEREZOSA.
    @JoinColumn(name = "ID_TIPO_FUENTE_FINANCIACION", columnDefinition = "NUMBER(20) NOT NULL")
    private TipoFuenteFinanciacion tipoFuenteFinanciacion;
    
    @Column(name = "VALOR_COSTO_MANTENIMIENTO_EQUIPO_INGENIERO", columnDefinition="VARCHAR2(150) NULL")
    private String valorCostoMantenimientoEquipoIngeniero;
    
    @Column(name = "NOMBRE_DOCUMENTO_ANEXO_CONTRATO_MTTO_EQUIP_ING", columnDefinition="VARCHAR2(250) NOT NULL")
    private String nombreDocumentoAnexoContratoMttoEquipIng;
    
    @Column(name = "NOMBRE_ARCHIVO_DOCUMENTO_ANEXO_CONTRATO_MTTO_EQUIP_ING", columnDefinition="CLOB NULL")
    private String nombreArchivoDocumentoAnexoContratoMttoEquipIng;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdHistorialMantenimientoEquipoIngeniero() {
        return idHistorialMantenimientoEquipoIngeniero;
    }
    public void setIdHistorialMantenimientoEquipoIngeniero(Long idHistorialMantenimientoEquipoIngeniero) {
        this.idHistorialMantenimientoEquipoIngeniero = idHistorialMantenimientoEquipoIngeniero;
    }
    public String getNumRegHistorialMantenimientoEquipoIngeniero() {
        return numRegHistorialMantenimientoEquipoIngeniero;
    }
    public void setNumRegHistorialMantenimientoEquipoIngeniero(String numRegHistorialMantenimientoEquipoIngeniero) {
        this.numRegHistorialMantenimientoEquipoIngeniero = numRegHistorialMantenimientoEquipoIngeniero;
    }
    public EquipoIngeniero getEquipoIngeniero() {
        return equipoIngeniero;
    }
    public void setEquipoIngeniero(EquipoIngeniero equipoIngeniero) {
        this.equipoIngeniero = equipoIngeniero;
    }
    public NivelMantenimientoEquipoIngeniero getNivelMantenimientoEquipoIngeniero() {
        return nivelMantenimientoEquipoIngeniero;
    }
    public void setNivelMantenimientoEquipoIngeniero(NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero) {
        this.nivelMantenimientoEquipoIngeniero = nivelMantenimientoEquipoIngeniero;
    }
    public TipoMantenimientoEquipoIngeniero getTipoMantenimientoEquipoIngeniero() {
        return tipoMantenimientoEquipoIngeniero;
    }
    public void setTipoMantenimientoEquipoIngeniero(TipoMantenimientoEquipoIngeniero tipoMantenimientoEquipoIngeniero) {
        this.tipoMantenimientoEquipoIngeniero = tipoMantenimientoEquipoIngeniero;
    }
    public String getAsuntoMantenimientoEquipoIngeniero() {
        return asuntoMantenimientoEquipoIngeniero;
    }
    public void setAsuntoMantenimientoEquipoIngeniero(String asuntoMantenimientoEquipoIngeniero) {
        this.asuntoMantenimientoEquipoIngeniero = asuntoMantenimientoEquipoIngeniero;
    }
    public String getDescripcionMantenimientoEquipoIngeniero() {
        return descripcionMantenimientoEquipoIngeniero;
    }
    public void setDescripcionMantenimientoEquipoIngeniero(String descripcionMantenimientoEquipoIngeniero) {
        this.descripcionMantenimientoEquipoIngeniero = descripcionMantenimientoEquipoIngeniero;
    }
    public Date getFechaHMSMantenimientoEquipoIngeniero() {
        return fechaHMSMantenimientoEquipoIngeniero;
    }
    public void setFechaHMSMantenimientoEquipoIngeniero(Date fechaHMSMantenimientoEquipoIngeniero) {
        this.fechaHMSMantenimientoEquipoIngeniero = fechaHMSMantenimientoEquipoIngeniero;
    }
    public TipoFuenteFinanciacion getTipoFuenteFinanciacion() {
        return tipoFuenteFinanciacion;
    }
    public void setTipoFuenteFinanciacion(TipoFuenteFinanciacion tipoFuenteFinanciacion) {
        this.tipoFuenteFinanciacion = tipoFuenteFinanciacion;
    }
    public String getValorCostoMantenimientoEquipoIngeniero() {
        return valorCostoMantenimientoEquipoIngeniero;
    }
    public void setValorCostoMantenimientoEquipoIngeniero(String valorCostoMantenimientoEquipoIngeniero) {
        this.valorCostoMantenimientoEquipoIngeniero = valorCostoMantenimientoEquipoIngeniero;
    }
    public String getNombreDocumentoAnexoContratoMttoEquipIng() {
        return nombreDocumentoAnexoContratoMttoEquipIng;
    }
    public void setNombreDocumentoAnexoContratoMttoEquipIng(String nombreDocumentoAnexoContratoMttoEquipIng) {
        this.nombreDocumentoAnexoContratoMttoEquipIng = nombreDocumentoAnexoContratoMttoEquipIng;
    }
    public String getNombreArchivoDocumentoAnexoContratoMttoEquipIng() {
        return nombreArchivoDocumentoAnexoContratoMttoEquipIng;
    }
    public void setNombreArchivoDocumentoAnexoContratoMttoEquipIng(String nombreArchivoDocumentoAnexoContratoMttoEquipIng) {
        this.nombreArchivoDocumentoAnexoContratoMttoEquipIng = nombreArchivoDocumentoAnexoContratoMttoEquipIng;
    }*/
}
