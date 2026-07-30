//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqInfraest;
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
public interface ProyeccionPlanAnualAdqInfraestRepository extends JpaRepository<ProyeccionPlanAnualAdqInfraest, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_adq_infraest " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqInfraest IS NULL OR id_proyeccion_plan_anual_adq_infraest = :idProyeccionPlanAnualAdqInfraest) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualInfraest IS NULL OR UPPER(nombre_proyeccion_plan_anual_infraest) LIKE UPPER('%' || :nombreProyeccionPlanAnualInfraest || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_infraest) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualAdqInfraest") Long idProyeccionPlanAnualAdqInfraest, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualInfraest") String nombreProyeccionPlanAnualInfraest, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_infraest " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqInfraest IS NULL OR id_proyeccion_plan_anual_adq_infraest = :idProyeccionPlanAnualAdqInfraest) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualInfraest IS NULL OR UPPER(nombre_proyeccion_plan_anual_infraest) LIKE UPPER('%' || :nombreProyeccionPlanAnualInfraest || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_infraest) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqInfraest' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqInfraest' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualInfraest' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualInfraest' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualAdqInfraest> findAllProyeccionesPlanesAnualesAdqInfraest(@Param("idProyeccionPlanAnualAdqInfraest") Long idProyeccionPlanAnualAdqInfraest, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualInfraest") String nombreProyeccionPlanAnualInfraest, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_infraest " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqInfraest IS NULL OR id_proyeccion_plan_anual_adq_infraest = :idProyeccionPlanAnualAdqInfraest) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualInfraest IS NULL OR UPPER(nombre_proyeccion_plan_anual_infraest) LIKE UPPER('%' || :nombreProyeccionPlanAnualInfraest || '%')) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_infraest) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqInfraest' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqInfraest' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualInfraest' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualInfraest' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualAdqInfraest> findAllProyeccionesPlanesAnualesAdqInfraestPag(Pageable pageable, @Param("idProyeccionPlanAnualAdqInfraest") Long idProyeccionPlanAnualAdqInfraest, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualInfraest") String nombreProyeccionPlanAnualInfraest, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualAdqInfraest> findByIdProyeccionPlanAnualAdqInfraest(Long idProyeccionPlanAnualAdqInfraest);
    
    //BUSQUEDA UNITARIA POR NOMBRE, ID PLAN ANUAL ADQ GENERAL E ID INFRAESTRUCTURA (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_adq_infraest " +
          "WHERE (UPPER(nombre_proyeccion_plan_anual_infraest) = :nombreProyeccionPlanAnualInfraest) AND " +
          "(id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(id_infraestructura = :idInfraestructura) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualAdqInfraest findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdInfraestructura(@Param("nombreProyeccionPlanAnualInfraest") String nombreProyeccionPlanAnualInfraest, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("idInfraestructura") Long idInfraestructura);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_adq_infraest) FROM tabla_proyecciones_planes_anuales_adq_infraest", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualAdqInfraest();
}
