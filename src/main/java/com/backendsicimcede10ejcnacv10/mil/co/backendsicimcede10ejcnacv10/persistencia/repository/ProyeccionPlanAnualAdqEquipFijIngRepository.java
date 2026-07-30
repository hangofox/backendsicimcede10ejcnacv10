//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqEquipFijIng;
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
public interface ProyeccionPlanAnualAdqEquipFijIngRepository extends JpaRepository<ProyeccionPlanAnualAdqEquipFijIng, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_adq_equip_fij_ing " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqEquipFijIng IS NULL OR id_proyeccion_plan_anual_adq_equip_fij_ing = :idProyeccionPlanAnualAdqEquipFijIng) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqEquipFijIng IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_equip_fij_ing) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqEquipFijIng || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_equip_fij_ing) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualAdqEquipFijIng") Long idProyeccionPlanAnualAdqEquipFijIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqEquipFijIng") String nombreProyeccionPlanAnualAdqEquipFijIng, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_equip_fij_ing " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqEquipFijIng IS NULL OR id_proyeccion_plan_anual_adq_equip_fij_ing = :idProyeccionPlanAnualAdqEquipFijIng) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqEquipFijIng IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_equip_fij_ing) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqEquipFijIng || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_equip_fij_ing) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_equip_fij_ing END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_equip_fij_ing END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_adq_equip_fij_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_adq_equip_fij_ing END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualAdqEquipFijIng> findAllProyeccionesPlanesAnualesAdqEquipFijIng(@Param("idProyeccionPlanAnualAdqEquipFijIng") Long idProyeccionPlanAnualAdqEquipFijIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqEquipFijIng") String nombreProyeccionPlanAnualAdqEquipFijIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_adq_equip_fij_ing " +
          "WHERE " +
          "(:idProyeccionPlanAnualAdqEquipFijIng IS NULL OR id_proyeccion_plan_anual_adq_equip_fij_ing = :idProyeccionPlanAnualAdqEquipFijIng) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualAdqEquipFijIng IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_equip_fij_ing) LIKE UPPER('%' || :nombreProyeccionPlanAnualAdqEquipFijIng || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_adq_equip_fij_ing) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_equip_fij_ing END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_equip_fij_ing END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_adq_equip_fij_ing END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualAdqEquipFijIng' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_adq_equip_fij_ing END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualAdqEquipFijIng> findAllProyeccionesPlanesAnualesAdqEquipFijIngPag(Pageable pageable, @Param("idProyeccionPlanAnualAdqEquipFijIng") Long idProyeccionPlanAnualAdqEquipFijIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualAdqEquipFijIng") String nombreProyeccionPlanAnualAdqEquipFijIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualAdqEquipFijIng> findByIdProyeccionPlanAnualAdqEquipFijIng(Long idProyeccionPlanAnualAdqEquipFijIng);
    
    //BUSQUEDA UNITARIA POR NOMBRE E ID PLAN ANUAL ADQ GENERAL (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_adq_equip_fij_ing " +
          "WHERE (UPPER(nombre_proyeccion_plan_anual_adq_equip_fij_ing) = :nombreProyeccionPlanAnualAdqEquipFijIng) AND " +
          "(id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualAdqEquipFijIng findByNombreAndIdProyeccionPlanAnualAdqGeneral(@Param("nombreProyeccionPlanAnualAdqEquipFijIng") String nombreProyeccionPlanAnualAdqEquipFijIng, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_adq_equip_fij_ing) FROM tabla_proyecciones_planes_anuales_adq_equip_fij_ing", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualAdqEquipFijIng();
}
