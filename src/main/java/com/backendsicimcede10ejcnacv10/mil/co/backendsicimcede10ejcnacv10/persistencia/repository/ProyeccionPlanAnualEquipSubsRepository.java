//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualEquipSubs;
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
public interface ProyeccionPlanAnualEquipSubsRepository extends JpaRepository<ProyeccionPlanAnualEquipSubs, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_planes_anuales_equip_subs " +
          "WHERE " +
          "(:idProyeccionPlanAnualEquipSubs IS NULL OR id_proyeccion_plan_anual_equip_subs = :idProyeccionPlanAnualEquipSubs) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:idEquipoIngeniero IS NULL OR id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:nombreYNumeroRubroProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:valorSolicitadoProyeccionPlanAnualEquipSubs IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:nombreBienOServicioProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_bien_o_servicio_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreBienOServicioProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionPlanAnualEquipSubs") Long idProyeccionPlanAnualEquipSubs, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualEquipSubs") String nombreProyeccionPlanAnualEquipSubs, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("nombreYNumeroRubroProyeccionPlanAnualEquipSubs") String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, @Param("valorSolicitadoProyeccionPlanAnualEquipSubs") String valorSolicitadoProyeccionPlanAnualEquipSubs, @Param("nombreBienOServicioProyeccionPlanAnualEquipSubs") String nombreBienOServicioProyeccionPlanAnualEquipSubs, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_equip_subs " +
          "WHERE " +
          "(:idProyeccionPlanAnualEquipSubs IS NULL OR id_proyeccion_plan_anual_equip_subs = :idProyeccionPlanAnualEquipSubs) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:idEquipoIngeniero IS NULL OR id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:nombreYNumeroRubroProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:valorSolicitadoProyeccionPlanAnualEquipSubs IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:nombreBienOServicioProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_bien_o_servicio_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreBienOServicioProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN valor_solicitado_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN valor_solicitado_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_equip_subs END DESC", nativeQuery = true)
    List<ProyeccionPlanAnualEquipSubs> findAllProyeccionesPlanesAnualesEquipSubs(@Param("idProyeccionPlanAnualEquipSubs") Long idProyeccionPlanAnualEquipSubs, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualEquipSubs") String nombreProyeccionPlanAnualEquipSubs, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("nombreYNumeroRubroProyeccionPlanAnualEquipSubs") String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, @Param("valorSolicitadoProyeccionPlanAnualEquipSubs") String valorSolicitadoProyeccionPlanAnualEquipSubs, @Param("nombreBienOServicioProyeccionPlanAnualEquipSubs") String nombreBienOServicioProyeccionPlanAnualEquipSubs, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_planes_anuales_equip_subs " +
          "WHERE " +
          "(:idProyeccionPlanAnualEquipSubs IS NULL OR id_proyeccion_plan_anual_equip_subs = :idProyeccionPlanAnualEquipSubs) AND " +
          "(:idProyeccionPlanAnualAdqGeneral IS NULL OR id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(:nombreProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:idEquipoIngeniero IS NULL OR id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:nombreYNumeroRubroProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:valorSolicitadoProyeccionPlanAnualEquipSubs IS NULL OR UPPER(valor_solicitado_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:nombreBienOServicioProyeccionPlanAnualEquipSubs IS NULL OR UPPER(nombre_bien_o_servicio_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :nombreBienOServicioProyeccionPlanAnualEquipSubs || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_proyeccion_plan_anual_equip_subs) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'ASC' THEN id_proyeccion_plan_anual_adq_general END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionPlanAnualAdqGeneral' AND :orderMode = 'DESC' THEN id_proyeccion_plan_anual_adq_general END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN nombre_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN nombre_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN nombre_y_numero_rubro_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN valor_solicitado_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN valor_solicitado_proyeccion_plan_anual_equip_subs END DESC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualEquipSubs' AND :orderMode = 'ASC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_equip_subs END ASC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioProyeccionPlanAnualEquipSubs' AND :orderMode = 'DESC' THEN nombre_bien_o_servicio_proyeccion_plan_anual_equip_subs END DESC", nativeQuery = true)
    Slice<ProyeccionPlanAnualEquipSubs> findAllProyeccionesPlanesAnualesEquipSubsPag(Pageable pageable, @Param("idProyeccionPlanAnualEquipSubs") Long idProyeccionPlanAnualEquipSubs, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("nombreProyeccionPlanAnualEquipSubs") String nombreProyeccionPlanAnualEquipSubs, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("nombreYNumeroRubroProyeccionPlanAnualEquipSubs") String nombreYNumeroRubroProyeccionPlanAnualEquipSubs, @Param("valorSolicitadoProyeccionPlanAnualEquipSubs") String valorSolicitadoProyeccionPlanAnualEquipSubs, @Param("nombreBienOServicioProyeccionPlanAnualEquipSubs") String nombreBienOServicioProyeccionPlanAnualEquipSubs, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionPlanAnualEquipSubs> findByIdProyeccionPlanAnualEquipSubs(Long idProyeccionPlanAnualEquipSubs);
    
    //BUSQUEDA UNITARIA POR NOMBRE, ID PLAN ANUAL ADQ GENERAL E ID EQUIPO INGENIERO (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_planes_anuales_equip_subs " +
          "WHERE (UPPER(nombre_proyeccion_plan_anual_equip_subs) = :nombreProyeccionPlanAnualEquipSubs) AND " +
          "(id_proyeccion_plan_anual_adq_general = :idProyeccionPlanAnualAdqGeneral) AND " +
          "(id_equipo_ingeniero = :idEquipoIngeniero) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionPlanAnualEquipSubs findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdEquipoIngeniero(@Param("nombreProyeccionPlanAnualEquipSubs") String nombreProyeccionPlanAnualEquipSubs, @Param("idProyeccionPlanAnualAdqGeneral") Long idProyeccionPlanAnualAdqGeneral, @Param("idEquipoIngeniero") Long idEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_proyeccion_plan_anual_equip_subs) FROM tabla_proyecciones_planes_anuales_equip_subs", nativeQuery = true)
    Long findMaxIdProyeccionPlanAnualEquipSubs();
}
