//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqCdoIng;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProyeccionPlanAnualAdqCdoIngRepository extends JpaRepository<ProyeccionPlanAnualAdqCdoIng, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_adq_cdos_ing " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqCdoIng IS NULL OR id_proyeccion_plan_anual_adq_cdo_ing = :idProyeccionPlanAnualAdqCdoIng) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqCdoIng || '%')) AND " +
          "(:idDestinacionMantenimientoCdoIng IS NULL OR id_destinacion_mantenimiento_cdo_ing = :idDestinacionMantenimientoCdoIng) AND " +
          "(:valorSolicitadoProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualAdqCdoIng || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualAdqCdoIng") Long idProyeccionPlanAnualAdqCdoIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqCdoIng") String nombreProyeccionPlanAnualAdqCdoIng, @Param("idDestinacionMantenimientoCdoIng") Long idDestinacionMantenimientoCdoIng, @Param("valorSolicitadoProyeccionPlanAnualAdqCdoIng") String valorSolicitadoProyeccionPlanAnualAdqCdoIng, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_cdos_ing " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqCdoIng IS NULL OR id_proyeccion_plan_anual_adq_cdo_ing = :idProyeccionPlanAnualAdqCdoIng) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqCdoIng || '%')) AND " +
          "(:idDestinacionMantenimientoCdoIng IS NULL OR id_destinacion_mantenimiento_cdo_ing = :idDestinacionMantenimientoCdoIng) AND " +
          "(:valorSolicitadoProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualAdqCdoIng || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'ASC' THEN id_destinacion_mantenimiento_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'DESC' THEN id_destinacion_mantenimiento_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN valor_solicitado_proyeccion_plan_anual_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN valor_solicitado_proyeccion_plan_anual_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualAdqCdoIng> findAllProyeccionesPlanesAnualesAdqCdosIng(@Param("idProyeccionPlanAnualAdqCdoIng") Long idProyeccionPlanAnualAdqCdoIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqCdoIng") String nombreProyeccionPlanAnualAdqCdoIng, @Param("idDestinacionMantenimientoCdoIng") Long idDestinacionMantenimientoCdoIng, @Param("valorSolicitadoProyeccionPlanAnualAdqCdoIng") String valorSolicitadoProyeccionPlanAnualAdqCdoIng, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_cdos_ing " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqCdoIng IS NULL OR id_proyeccion_plan_anual_adq_cdo_ing = :idProyeccionPlanAnualAdqCdoIng) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqCdoIng || '%')) AND " +
          "(:idDestinacionMantenimientoCdoIng IS NULL OR id_destinacion_mantenimiento_cdo_ing = :idDestinacionMantenimientoCdoIng) AND " +
          "(:valorSolicitadoProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualAdqCdoIng || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_cdo_ing) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'ASC' THEN id_destinacion_mantenimiento_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'idDestinacionMantenimientoCdoIng' AND :orderMode = 'DESC' THEN id_destinacion_mantenimiento_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN valor_solicitado_proyeccion_plan_anual_adq_cdo_ing END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN valor_solicitado_proyeccion_plan_anual_adq_cdo_ing END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualAdqCdoIng> findAllProyeccionesPlanesAnualesAdqCdosIngPag(Pageable pageable, @Param("idProyeccionPlanAnualAdqCdoIng") Long idProyeccionPlanAnualAdqCdoIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqCdoIng") String nombreProyeccionPlanAnualAdqCdoIng, @Param("idDestinacionMantenimientoCdoIng") Long idDestinacionMantenimientoCdoIng, @Param("valorSolicitadoProyeccionPlanAnualAdqCdoIng") String valorSolicitadoProyeccionPlanAnualAdqCdoIng, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualAdqCdoIng> findByIdProyeccionPlanAnualAdqCdoIng(Long idProyeccionPlanAnualAdqCdoIng);
    
    //BUSQUEDA UNITARIA POR NOMBRE, ID PLAN ANUAL ADQ GENERAL, ID DESTINACION MANTENIMIENTO CDO ING E ID INFRAESTRUCTURA (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_adq_cdos_ing " +
          "WHERE (UPPER(nombre_proyeccion_plan_anual_adq_cdo_ing) = :nombreProyeccionPlanAnualAdqCdoIng) AND " +
          "(id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(id_destinacion_mantenimiento_cdo_ing = :idDestinacionMantenimientoCdoIng) AND " +
          "(id_infraestructura = :idInfraestructura) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualAdqCdoIng findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdDestinacionMantenimientoCdoIngAndIdInfraestructura(@Param("nombreProyeccionPlanAnualAdqCdoIng") String nombreProyeccionPlanAnualAdqCdoIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("idDestinacionMantenimientoCdoIng") Long idDestinacionMantenimientoCdoIng, @Param("idInfraestructura") Long idInfraestructura);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_adq_cdo_ing) FROM tabla_proyecciones_planes_anuales_adq_cdos_ing", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualAdqCdoIng();
}
