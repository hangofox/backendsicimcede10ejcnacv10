//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialEquipTranspApoyObrRedMitigGestRiesgDesast;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialEquipTranspApoyObrRedMitigGestRiesgDesastRepository extends JpaRepository<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID APOYO OBR RED MITIG GEST RIESG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast, tabla_clasificaciones_equipos_ingenieros, tabla_subclasificaciones_equipos_ingenieros, tabla_elementos_subclasificaciones_equipos_ingenieros, tabla_equipos_ingenieros " +
            "WHERE (:idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_subclasificacion_equipo_ingeniero = tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_elemento_subclasificacion_equipo_ingeniero = tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_equipo_ingeniero = tabla_equipos_ingenieros.id_equipo_ingeniero) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:nombreClasificacionEquipoIngeniero IS NULL OR UPPER(tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero)) AND " +
            "(:nombreSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero)) AND " +
            "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) AND " +
            "(:idEquipoIngeniero IS NULL OR UPPER(tabla_equipos_ingenieros.id_equipo_ingeniero) = UPPER(:idEquipoIngeniero))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast") Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("idEquipoIngeniero") Long idEquipoIngeniero);
    
    @Query(value = "SELECT tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast, tabla_clasificaciones_equipos_ingenieros, tabla_subclasificaciones_equipos_ingenieros, tabla_elementos_subclasificaciones_equipos_ingenieros, tabla_equipos_ingenieros " +
            "WHERE (:idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_subclasificacion_equipo_ingeniero = tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_elemento_subclasificacion_equipo_ingeniero = tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_equipo_ingeniero = tabla_equipos_ingenieros.id_equipo_ingeniero) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:nombreClasificacionEquipoIngeniero IS NULL OR UPPER(tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero)) AND " +
            "(:nombreSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero)) AND " +
            "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) AND " +
            "(:idEquipoIngeniero IS NULL OR UPPER(tabla_equipos_ingenieros.id_equipo_ingeniero) = UPPER(:idEquipoIngeniero)) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numeroPlacaEquipoTransporte' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.numero_placa_equipo_transporte END ASC, " +
            "CASE WHEN :orderBy = 'numeroPlacaEquipoTransporte' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.numero_placa_equipo_transporte END DESC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    List<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> findAllHistorialesEquipsTranspsApoyObrRedMitigGestRiesgDesast(@Param("idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast") Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast, tabla_clasificaciones_equipos_ingenieros, tabla_subclasificaciones_equipos_ingenieros, tabla_elementos_subclasificaciones_equipos_ingenieros, tabla_equipos_ingenieros " +
            "WHERE (:idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_clasificacion_equipo_ingeniero = tabla_clasificaciones_equipos_ingenieros.id_clasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_subclasificacion_equipo_ingeniero = tabla_subclasificaciones_equipos_ingenieros.id_subclasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_elemento_subclasificacion_equipo_ingeniero = tabla_elementos_subclasificaciones_equipos_ingenieros.id_elemento_subclasificacion_equipo_ingeniero) AND " +
            "(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_equipo_ingeniero = tabla_equipos_ingenieros.id_equipo_ingeniero) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:nombreClasificacionEquipoIngeniero IS NULL OR UPPER(tabla_clasificaciones_equipos_ingenieros.nombre_clasificacion_equipo_ingeniero) = UPPER(:nombreClasificacionEquipoIngeniero)) AND " +
            "(:nombreSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_subclasificaciones_equipos_ingenieros.nombre_subclasificacion_equipo_ingeniero) = UPPER(:nombreSubclasificacionEquipoIngeniero)) AND " +
            "(:nombreElementoSubclasificacionEquipoIngeniero IS NULL OR UPPER(tabla_elementos_subclasificaciones_equipos_ingenieros.nombre_elemento_subclasificacion_equipo_ingeniero) = UPPER(:nombreElementoSubclasificacionEquipoIngeniero)) AND " +
            "(:idEquipoIngeniero IS NULL OR UPPER(tabla_equipos_ingenieros.id_equipo_ingeniero) = UPPER(:idEquipoIngeniero)) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numeroPlacaEquipoTransporte' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.numero_placa_equipo_transporte END ASC, " +
            "CASE WHEN :orderBy = 'numeroPlacaEquipoTransporte' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.numero_placa_equipo_transporte END DESC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasEquipTranspApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_equip_transp_apoy_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    Slice<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> findAllHistorialesEquipsTranspsApoyObrRedMitigGestRiesgDesastPag(Pageable pageable, @Param("idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast") Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("nombreClasificacionEquipoIngeniero") String nombreClasificacionEquipoIngeniero, @Param("nombreSubclasificacionEquipoIngeniero") String nombreSubclasificacionEquipoIngeniero, @Param("nombreElementoSubclasificacionEquipoIngeniero") String nombreElementoSubclasificacionEquipoIngeniero, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialEquipTranspApoyObrRedMitigGestRiesgDesast> findByIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(Long idHistorialEquipTranspApoyObrRedMitigGestRiesgDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialEquipTranspApoyObrRedMitigGestRiesgDesast findByNumRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast(String numRegHistorialEquipTranspApoyObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT MAX(id_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast) FROM tabla_historial_equip_transp_apoy_obr_red_mitig_gest_riesg_desast", nativeQuery = true)
    Long findMaxIdHistorialEquipTranspApoyObrRedMitigGestRiesgDesast();
}
