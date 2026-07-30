//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualPozo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProyeccionPlanAnualPozoRepository extends JpaRepository<ProyeccionPlanAnualPozo, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_pozos " +
          "WHERE " +
          "(:idProyeccionPlanAnualPozo IS NULL OR id_proyeccion_plan_anual_pozo = :idProyeccionPlanAnualPozo) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreProyeccionPlanAnualPozo || '%')) AND " +
          "(:idTipoMantenimientoPozo IS NULL OR id_tipo_mantenimiento_pozo = :idTipoMantenimientoPozo) AND " +
          "(:nombreYNumeroRubroProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionPlanAnualPozo || '%')) AND " +
          "(:valorSolicitadoProyeccionPlanAnualPozo IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualPozo || '%')) AND " +
          "(:nombreBienOServicioProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_bien_o_servicio_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreBienOServicioProyeccionPlanAnualPozo || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualPozo") Long idProyeccionPlanAnualPozo, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualPozo") String nombreProyeccionPlanAnualPozo, @Param("idTipoMantenimientoPozo") Long idTipoMantenimientoPozo, @Param("nombreYNumeroRubroProyeccionPlanAnualPozo") String nombreYNumeroRubroProyeccionPlanAnualPozo, @Param("valorSolicitadoProyeccionPlanAnualPozo") String valorSolicitadoProyeccionPlanAnualPozo, @Param("nombreBienOServicioProyeccionPlanAnualPozo") String nombreBienOServicioProyeccionPlanAnualPozo, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_pozos " +
          "WHERE " +
          "(:idProyeccionPlanAnualPozo IS NULL OR id_proyeccion_plan_anual_pozo = :idProyeccionPlanAnualPozo) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreProyeccionPlanAnualPozo || '%')) AND " +
          "(:idTipoMantenimientoPozo IS NULL OR id_tipo_mantenimiento_pozo = :idTipoMantenimientoPozo) AND " +
          "(:nombreYNumeroRubroProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionPlanAnualPozo || '%')) AND " +
          "(:valorSolicitadoProyeccionPlanAnualPozo IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualPozo || '%')) AND " +
          "(:nombreBienOServicioProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_bien_o_servicio_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreBienOServicioProyeccionPlanAnualPozo || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_pozo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_pozo END DESC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN valor_solicitado_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN valor_solicitado_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualPozo> findAllProyeccionesPlanesAnualesPozos(@Param("idProyeccionPlanAnualPozo") Long idProyeccionPlanAnualPozo, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualPozo") String nombreProyeccionPlanAnualPozo, @Param("idTipoMantenimientoPozo") Long idTipoMantenimientoPozo, @Param("nombreYNumeroRubroProyeccionPlanAnualPozo") String nombreYNumeroRubroProyeccionPlanAnualPozo, @Param("valorSolicitadoProyeccionPlanAnualPozo") String valorSolicitadoProyeccionPlanAnualPozo, @Param("nombreBienOServicioProyeccionPlanAnualPozo") String nombreBienOServicioProyeccionPlanAnualPozo, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_pozos " +
          "WHERE " +
          "(:idProyeccionPlanAnualPozo IS NULL OR id_proyeccion_plan_anual_pozo = :idProyeccionPlanAnualPozo) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreProyeccionPlanAnualPozo || '%')) AND " +
          "(:idTipoMantenimientoPozo IS NULL OR id_tipo_mantenimiento_pozo = :idTipoMantenimientoPozo) AND " +
          "(:nombreYNumeroRubroProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionPlanAnualPozo || '%')) AND " +
          "(:valorSolicitadoProyeccionPlanAnualPozo IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualPozo || '%')) AND " +
          "(:nombreBienOServicioProyeccionPlanAnualPozo IS NULL OR UPPER(nombre_bien_o_servicio_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :nombreBienOServicioProyeccionPlanAnualPozo || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_pozo) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'ASC' THEN id_tipo_mantenimiento_pozo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoMantenimientoPozo' AND :orderMode = 'DESC' THEN id_tipo_mantenimiento_pozo END DESC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN valor_solicitado_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN valor_solicitado_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualPozo' AND :orderMode = 'ASC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_pozo END ASC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualPozo' AND :orderMode = 'DESC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_pozo END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualPozo> findAllProyeccionesPlanesAnualesPozosPag(Pageable pageable, @Param("idProyeccionPlanAnualPozo") Long idProyeccionPlanAnualPozo, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualPozo") String nombreProyeccionPlanAnualPozo, @Param("idTipoMantenimientoPozo") Long idTipoMantenimientoPozo, @Param("nombreYNumeroRubroProyeccionPlanAnualPozo") String nombreYNumeroRubroProyeccionPlanAnualPozo, @Param("valorSolicitadoProyeccionPlanAnualPozo") String valorSolicitadoProyeccionPlanAnualPozo, @Param("nombreBienOServicioProyeccionPlanAnualPozo") String nombreBienOServicioProyeccionPlanAnualPozo, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualPozo> findByIdProyeccionPlanAnualPozo(Long idProyeccionPlanAnualPozo);
    
    //BUSQUEDA UNITARIA POR NOMBRE Y NUMERO DE RUBRO (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_pozos " +
          "WHERE (UPPER(nombre_y_numero_rubro_proyeccion_plan_anual_pozo) = :nombreYNumeroRubroProyeccionPlanAnualPozo) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualPozo findByNombreYNumeroRubroProyeccionPlanAnualPozo(@Param("nombreYNumeroRubroProyeccionPlanAnualPozo") String nombreYNumeroRubroProyeccionPlanAnualPozo);
    
    //BUSQUEDA UNITARIA POR NOMBRE, ID PLAN ANUAL ADQ GENERAL, ID TIPO MANTENIMIENTO POZO E ID INFRAESTRUCTURA (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_pozos " +
          "WHERE (UPPER(nombre_proyeccion_plan_anual_pozo) = :nombreProyeccionPlanAnualPozo) AND " +
          "(id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(id_tipo_mantenimiento_pozo = :idTipoMantenimientoPozo) AND " +
          "(id_infraestructura = :idInfraestructura) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualPozo findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdTipoMantenimientoPozoAndIdInfraestructura(@Param("nombreProyeccionPlanAnualPozo") String nombreProyeccionPlanAnualPozo, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("idTipoMantenimientoPozo") Long idTipoMantenimientoPozo, @Param("idInfraestructura") Long idInfraestructura);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_pozo) FROM tabla_proyecciones_planes_anuales_pozos", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualPozo();
}
