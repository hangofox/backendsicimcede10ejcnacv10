//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialControlAvancObrRedMitigGestRiesgDesast;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialControlAvancObrRedMitigGestRiesgDesastRepository extends JpaRepository<HistorialControlAvancObrRedMitigGestRiesgDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID APOYO OBR RED MITIG GEST RIESG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast " +
          "WHERE (:idHistorialControlAvancObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.id_historial_control_avanc_obr_red_mitig_gest_riesg_desast = :idHistorialControlAvancObrRedMitigGestRiesgDesast) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.num_reg_historial_control_avanc_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.nombre_historial_control_avanc_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialControlAvancObrRedMitigGestRiesgDesast") Long idHistorialControlAvancObrRedMitigGestRiesgDesast, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast " +
          "WHERE (:idHistorialControlAvancObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.id_historial_control_avanc_obr_red_mitig_gest_riesg_desast = :idHistorialControlAvancObrRedMitigGestRiesgDesast) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.num_reg_historial_control_avanc_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.nombre_historial_control_avanc_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.id_historial_control_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.id_historial_control_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.num_reg_historial_control_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.num_reg_historial_control_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'nombreHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.nombre_historial_control_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'nombreHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.nombre_historial_control_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_prog_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_prog_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_ejec_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_ejec_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_falt_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_falt_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'observacionesHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.observaciones_historial_control_avanc_obr_red_mitig_gest_riesg_desast, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'observacionesHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.observaciones_historial_control_avanc_obr_red_mitig_gest_riesg_desast, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialControlAvancObrRedMitigGestRiesgDesast> findAllHistorialesControlesAvancsObrRedMitigGestRiesgDesast(@Param("idHistorialControlAvancObrRedMitigGestRiesgDesast") Long idHistorialControlAvancObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast " +
          "WHERE (:idHistorialControlAvancObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.id_historial_control_avanc_obr_red_mitig_gest_riesg_desast = :idHistorialControlAvancObrRedMitigGestRiesgDesast) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.num_reg_historial_control_avanc_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.nombre_historial_control_avanc_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.id_historial_control_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.id_historial_control_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.num_reg_historial_control_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.num_reg_historial_control_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'nombreHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.nombre_historial_control_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'nombreHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.nombre_historial_control_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_prog_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActProgAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_prog_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_ejec_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActEjecAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_ejec_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_falt_avanc_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeActFaltAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.numero_porcentaje_act_falt_avanc_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'observacionesHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.observaciones_historial_control_avanc_obr_red_mitig_gest_riesg_desast, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'observacionesHistorialControlAvancObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast.observaciones_historial_control_avanc_obr_red_mitig_gest_riesg_desast, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialControlAvancObrRedMitigGestRiesgDesast> findAllHistorialesControlesAvancsObrRedMitigGestRiesgDesastPag(Pageable pageable, @Param("idHistorialControlAvancObrRedMitigGestRiesgDesast") Long idHistorialControlAvancObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialControlAvancObrRedMitigGestRiesgDesast> findByIdHistorialControlAvancObrRedMitigGestRiesgDesast(Long idHistorialControlAvancObrRedMitigGestRiesgDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialControlAvancObrRedMitigGestRiesgDesast findByNumRegHistorialControlAvancObrRedMitigGestRiesgDesast(String numRegHistorialControlAvancObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT MAX(id_historial_control_avanc_obr_red_mitig_gest_riesg_desast) FROM tabla_historial_controles_avanc_obr_red_mitig_gest_riesg_desast", nativeQuery = true)
    Long findMaxIdHistorialControlAvancObrRedMitigGestRiesgDesast();
}
