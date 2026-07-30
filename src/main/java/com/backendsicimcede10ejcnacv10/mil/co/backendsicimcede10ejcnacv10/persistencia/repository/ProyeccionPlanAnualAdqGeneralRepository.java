//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProyeccionPlanAnualAdqGeneralRepository extends JpaRepository<ProyeccionPlanAnualAdqGeneral,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_adq_generales " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqGeneral IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_general) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqGeneral || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_general) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqGeneral") String nombreProyeccionPlanAnualAdqGeneral, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_generales " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqGeneral IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_general) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqGeneral || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_general) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_adq_general END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualAdqGeneral> findAllProyeccionesPlanesAnualesAdqGenerales(@Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqGeneral") String nombreProyeccionPlanAnualAdqGeneral, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_generales " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqGeneral IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_general) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqGeneral || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_general) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_adq_general END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualAdqGeneral> findAllProyeccionesPlanesAnualesAdqGeneralesPag(Pageable pageable, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqGeneral") String nombreProyeccionPlanAnualAdqGeneral, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualAdqGeneral> findByIdProyeccionPlanAnualAdqGeneral(Long idProyeccionPlanAnualAdqGeneral);
    
    ProyeccionPlanAnualAdqGeneral findByNombreProyeccionPlanAnualAdqGeneral(String nombreProyeccionPlanAnualAdqGeneral);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_adq_general) FROM tabla_proyecciones_planes_anuales_adq_generales", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualAdqGeneral();
}
