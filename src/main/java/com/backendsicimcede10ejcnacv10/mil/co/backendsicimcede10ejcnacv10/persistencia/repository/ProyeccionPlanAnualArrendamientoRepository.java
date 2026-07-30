//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualArrendamiento;
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
public interface ProyeccionPlanAnualArrendamientoRepository extends JpaRepository<ProyeccionPlanAnualArrendamiento, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento) AND " +
          "(:idInfraestructuraArrendada IS NULL OR id_infraestructura_arrendada = :idInfraestructuraArrendada) AND " +
          "(:nombreProyeccionPlanAnualArrendamiento IS NULL OR UPPER(nombre_proyeccion_plan_anual_arrendamiento) LIKE UPPER('%' || :nombreProyeccionPlanAnualArrendamiento || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_arrendamiento) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento, @Param("idInfraestructuraArrendada") Long idInfraestructuraArrendada, @Param("nombreProyeccionPlanAnualArrendamiento") String nombreProyeccionPlanAnualArrendamiento, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento) AND " +
          "(:idInfraestructuraArrendada IS NULL OR id_infraestructura_arrendada = :idInfraestructuraArrendada) AND " +
          "(:nombreProyeccionPlanAnualArrendamiento IS NULL OR UPPER(nombre_proyeccion_plan_anual_arrendamiento) LIKE UPPER('%' || :nombreProyeccionPlanAnualArrendamiento || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_arrendamiento) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualArrendamiento' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_arrendamiento END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualArrendamiento' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_arrendamiento END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'ASC' THEN id_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'DESC' THEN id_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualArrendamiento' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_arrendamiento END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualArrendamiento' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_arrendamiento END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualArrendamiento> findAllProyeccionesPlanesAnualesArrendamientos(@Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento, @Param("idInfraestructuraArrendada") Long idInfraestructuraArrendada, @Param("nombreProyeccionPlanAnualArrendamiento") String nombreProyeccionPlanAnualArrendamiento, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE " +
          "(:idProyeccionPlanAnualArrendamiento IS NULL OR id_proyeccion_plan_anual_arrendamiento = :idProyeccionPlanAnualArrendamiento) AND " +
          "(:idInfraestructuraArrendada IS NULL OR id_infraestructura_arrendada = :idInfraestructuraArrendada) AND " +
          "(:nombreProyeccionPlanAnualArrendamiento IS NULL OR UPPER(nombre_proyeccion_plan_anual_arrendamiento) LIKE UPPER('%' || :nombreProyeccionPlanAnualArrendamiento || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_arrendamiento) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualArrendamiento' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_arrendamiento END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualArrendamiento' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_arrendamiento END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'ASC' THEN id_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'DESC' THEN id_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualArrendamiento' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_arrendamiento END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualArrendamiento' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_arrendamiento END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualArrendamiento> findAllProyeccionesPlanesAnualesArrendamientosPag(Pageable pageable, @Param("idProyeccionPlanAnualArrendamiento") Long idProyeccionPlanAnualArrendamiento, @Param("idInfraestructuraArrendada") Long idInfraestructuraArrendada, @Param("nombreProyeccionPlanAnualArrendamiento") String nombreProyeccionPlanAnualArrendamiento, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualArrendamiento> findByIdProyeccionPlanAnualArrendamiento(Long idProyeccionPlanAnualArrendamiento);
    
    //BUSQUEDA UNITARIA POR NOMBRE DEL PLAN ANUAL ARRENDAMIENTO E ID DE LA INFRAESTRUCTURA ARRENDADA (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_arrendamientos " +
          "WHERE (UPPER(nombre_proyeccion_plan_anual_arrendamiento) = :nombreProyeccionPlanAnualArrendamiento) AND " +
          "(id_infraestructura_arrendada = :idInfraestructuraArrendada) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualArrendamiento findByNombreProyeccionPlanAnualArrendamientoAndIdInfraestructuraArrendada(@Param("nombreProyeccionPlanAnualArrendamiento") String nombreProyeccionPlanAnualArrendamiento, @Param("idInfraestructuraArrendada") Long idInfraestructuraArrendada);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_arrendamiento) FROM tabla_proyecciones_planes_anuales_arrendamientos", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualArrendamiento();
}
