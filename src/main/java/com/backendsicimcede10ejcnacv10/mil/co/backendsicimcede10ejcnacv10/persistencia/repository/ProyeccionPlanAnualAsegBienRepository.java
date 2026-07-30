//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAsegBien;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProyeccionPlanAnualAsegBienRepository extends JpaRepository<ProyeccionPlanAnualAsegBien, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_aseg_bienes " +
          "WHERE " +
          "(:idProyeccionPlanAnualAsegBien IS NULL OR id_proyeccion_plan_anual_aseg_bien = :idProyeccionPlanAnualAsegBien) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAsegBien IS NULL OR UPPER(nombre_proyeccion_plan_anual_aseg_bien) LIKE UPPER('%' || :nombreProyeccionPlanAnualAsegBien || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_aseg_bien) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualAsegBien") Long idProyeccionPlanAnualAsegBien, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAsegBien") String nombreProyeccionPlanAnualAsegBien, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_aseg_bienes " +
          "WHERE " +
          "(:idProyeccionPlanAnualAsegBien IS NULL OR id_proyeccion_plan_anual_aseg_bien = :idProyeccionPlanAnualAsegBien) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAsegBien IS NULL OR UPPER(nombre_proyeccion_plan_anual_aseg_bien) LIKE UPPER('%' || :nombreProyeccionPlanAnualAsegBien || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_aseg_bien) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAsegBien' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_aseg_bien END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAsegBien' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_aseg_bien END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAsegBien' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_aseg_bien END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAsegBien' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_aseg_bien END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualAsegBien> findAllProyeccionesPlanesAnualesAsegBienes(@Param("idProyeccionPlanAnualAsegBien") Long idProyeccionPlanAnualAsegBien, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAsegBien") String nombreProyeccionPlanAnualAsegBien, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_aseg_bienes " +
          "WHERE " +
          "(:idProyeccionPlanAnualAsegBien IS NULL OR id_proyeccion_plan_anual_aseg_bien = :idProyeccionPlanAnualAsegBien) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAsegBien IS NULL OR UPPER(nombre_proyeccion_plan_anual_aseg_bien) LIKE UPPER('%' || :nombreProyeccionPlanAnualAsegBien || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_aseg_bien) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAsegBien' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_aseg_bien END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAsegBien' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_aseg_bien END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAsegBien' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_aseg_bien END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAsegBien' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_aseg_bien END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualAsegBien> findAllProyeccionesPlanesAnualesAsegBienesPag(Pageable pageable, @Param("idProyeccionPlanAnualAsegBien") Long idProyeccionPlanAnualAsegBien, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAsegBien") String nombreProyeccionPlanAnualAsegBien, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualAsegBien> findByIdProyeccionPlanAnualAsegBien(Long idProyeccionPlanAnualAsegBien);
    
    //BUSQUEDA UNITARIA POR NOMBRE E ID PLAN ANUAL ADQ GENERAL (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_aseg_bienes " +
          "WHERE (UPPER(nombre_proyeccion_plan_anual_aseg_bien) = :nombreProyeccionPlanAnualAsegBien) AND " +
          "(id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualAsegBien findByNombreAndIdProyeccionPlanAnualAdqGeneral(@Param("nombreProyeccionPlanAnualAsegBien") String nombreProyeccionPlanAnualAsegBien, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_aseg_bien) FROM tabla_proyecciones_planes_anuales_aseg_bienes", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualAsegBien();
}
