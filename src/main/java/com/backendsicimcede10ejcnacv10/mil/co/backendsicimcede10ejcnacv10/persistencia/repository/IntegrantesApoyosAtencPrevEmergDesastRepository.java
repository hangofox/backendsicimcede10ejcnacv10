//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesApoyosAtencPrevEmergDesast;
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
public interface IntegrantesApoyosAtencPrevEmergDesastRepository extends JpaRepository<IntegrantesApoyosAtencPrevEmergDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_integrantes_apoyos_atenc_prev_emerg_desast t " +
          "WHERE (:idIntegrantesApoyosAtencPrevEmergDesast IS NULL OR t.id_integrantes_apoyos_atenc_prev_emerg_desast = :idIntegrantesApoyosAtencPrevEmergDesast) AND " +
          "(:idApoyoAtencPrevEmergDesast IS NULL OR t.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) AND " +
          "(:gradoJefeGestionRiesgoUnidadMilitar IS NULL OR t.grado_jefe_gestion_riesgo_unidad_militar = :gradoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:nombresJefeGestionRiesgoUnidadMilitar IS NULL OR t.nombres_jefe_gestion_riesgo_unidad_militar = :nombresJefeGestionRiesgoUnidadMilitar) AND " +
          "(:primerApellidoJefeGestionRiesgoUnidadMilitar IS NULL OR t.primer_apellido_jefe_gestion_riesgo_unidad_militar = :primerApellidoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:segundoApellidoJefeGestionRiesgoUnidadMilitar IS NULL OR t.segundo_apellido_jefe_gestion_riesgo_unidad_militar = :segundoApellidoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:cargoJefeGestionRiesgoUnidadMilitar IS NULL OR t.cargo_jefe_gestion_riesgo_unidad_militar = :cargoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:gradoJefeOperacionesUnidadMilitar IS NULL OR t.grado_jefe_operaciones_unidad_militar = :gradoJefeOperacionesUnidadMilitar) AND " +
          "(:nombresJefeOperacionesUnidadMilitar IS NULL OR t.nombres_jefe_operaciones_unidad_militar = :nombresJefeOperacionesUnidadMilitar) AND " +
          "(:primerApellidoJefeOperacionesUnidadMilitar IS NULL OR t.primer_apellido_jefe_operaciones_unidad_militar = :primerApellidoJefeOperacionesUnidadMilitar) AND " +
          "(:segundoApellidoJefeOperacionesUnidadMilitar IS NULL OR t.segundo_apellido_jefe_operaciones_unidad_militar = :segundoApellidoJefeOperacionesUnidadMilitar) AND " +
          "(:cargoJefeOperacionesUnidadMilitar IS NULL OR t.cargo_jefe_operaciones_unidad_militar = :cargoJefeOperacionesUnidadMilitar) AND " +
          "(:gradoCteUnidadMilitar IS NULL OR t.grado_cte_unidad_militar = :gradoCteUnidadMilitar) AND " +
          "(:nombresCteUnidadMilitar IS NULL OR t.nombres_cte_unidad_militar = :nombresCteUnidadMilitar) AND " +
          "(:primerApellidoCteUnidadMilitar IS NULL OR t.primer_apellido_cte_unidad_militar = :primerApellidoCteUnidadMilitar) AND " +
          "(:segundoApellidoCteUnidadMilitar IS NULL OR t.segundo_apellido_cte_unidad_militar = :segundoApellidoCteUnidadMilitar) AND " +
          "(:cargoCteUnidadMilitar IS NULL OR t.cargo_cte_unidad_militar = :cargoCteUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(t.nombres_jefe_gestion_riesgo_unidad_militar) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idIntegrantesApoyosAtencPrevEmergDesast") Long idIntegrantesApoyosAtencPrevEmergDesast, @Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("gradoJefeGestionRiesgoUnidadMilitar") String gradoJefeGestionRiesgoUnidadMilitar, @Param("nombresJefeGestionRiesgoUnidadMilitar") String nombresJefeGestionRiesgoUnidadMilitar, @Param("primerApellidoJefeGestionRiesgoUnidadMilitar") String primerApellidoJefeGestionRiesgoUnidadMilitar, @Param("segundoApellidoJefeGestionRiesgoUnidadMilitar") String segundoApellidoJefeGestionRiesgoUnidadMilitar, @Param("cargoJefeGestionRiesgoUnidadMilitar") String cargoJefeGestionRiesgoUnidadMilitar, @Param("gradoJefeOperacionesUnidadMilitar") String gradoJefeOperacionesUnidadMilitar, @Param("nombresJefeOperacionesUnidadMilitar") String nombresJefeOperacionesUnidadMilitar, @Param("primerApellidoJefeOperacionesUnidadMilitar") String primerApellidoJefeOperacionesUnidadMilitar, @Param("segundoApellidoJefeOperacionesUnidadMilitar") String segundoApellidoJefeOperacionesUnidadMilitar, @Param("cargoJefeOperacionesUnidadMilitar") String cargoJefeOperacionesUnidadMilitar, @Param("gradoCteUnidadMilitar") String gradoCteUnidadMilitar, @Param("nombresCteUnidadMilitar") String nombresCteUnidadMilitar, @Param("primerApellidoCteUnidadMilitar") String primerApellidoCteUnidadMilitar, @Param("segundoApellidoCteUnidadMilitar") String segundoApellidoCteUnidadMilitar, @Param("cargoCteUnidadMilitar") String cargoCteUnidadMilitar, @Param("keyword") String keyword);
    
    @Query(value = "SELECT t.* FROM tabla_integrantes_apoyos_atenc_prev_emerg_desast t " +
          "WHERE (:idIntegrantesApoyosAtencPrevEmergDesast IS NULL OR t.id_integrantes_apoyos_atenc_prev_emerg_desast = :idIntegrantesApoyosAtencPrevEmergDesast) AND " +
          "(:idApoyoAtencPrevEmergDesast IS NULL OR t.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) AND " +
          "(:gradoJefeGestionRiesgoUnidadMilitar IS NULL OR t.grado_jefe_gestion_riesgo_unidad_militar = :gradoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:nombresJefeGestionRiesgoUnidadMilitar IS NULL OR t.nombres_jefe_gestion_riesgo_unidad_militar = :nombresJefeGestionRiesgoUnidadMilitar) AND " +
          "(:primerApellidoJefeGestionRiesgoUnidadMilitar IS NULL OR t.primer_apellido_jefe_gestion_riesgo_unidad_militar = :primerApellidoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:segundoApellidoJefeGestionRiesgoUnidadMilitar IS NULL OR t.segundo_apellido_jefe_gestion_riesgo_unidad_militar = :segundoApellidoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:cargoJefeGestionRiesgoUnidadMilitar IS NULL OR t.cargo_jefe_gestion_riesgo_unidad_militar = :cargoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:gradoJefeOperacionesUnidadMilitar IS NULL OR t.grado_jefe_operaciones_unidad_militar = :gradoJefeOperacionesUnidadMilitar) AND " +
          "(:nombresJefeOperacionesUnidadMilitar IS NULL OR t.nombres_jefe_operaciones_unidad_militar = :nombresJefeOperacionesUnidadMilitar) AND " +
          "(:primerApellidoJefeOperacionesUnidadMilitar IS NULL OR t.primer_apellido_jefe_operaciones_unidad_militar = :primerApellidoJefeOperacionesUnidadMilitar) AND " +
          "(:segundoApellidoJefeOperacionesUnidadMilitar IS NULL OR t.segundo_apellido_jefe_operaciones_unidad_militar = :segundoApellidoJefeOperacionesUnidadMilitar) AND " +
          "(:cargoJefeOperacionesUnidadMilitar IS NULL OR t.cargo_jefe_operaciones_unidad_militar = :cargoJefeOperacionesUnidadMilitar) AND " +
          "(:gradoCteUnidadMilitar IS NULL OR t.grado_cte_unidad_militar = :gradoCteUnidadMilitar) AND " +
          "(:nombresCteUnidadMilitar IS NULL OR t.nombres_cte_unidad_militar = :nombresCteUnidadMilitar) AND " +
          "(:primerApellidoCteUnidadMilitar IS NULL OR t.primer_apellido_cte_unidad_militar = :primerApellidoCteUnidadMilitar) AND " +
          "(:segundoApellidoCteUnidadMilitar IS NULL OR t.segundo_apellido_cte_unidad_militar = :segundoApellidoCteUnidadMilitar) AND " +
          "(:cargoCteUnidadMilitar IS NULL OR t.cargo_cte_unidad_militar = :cargoCteUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(t.nombres_jefe_gestion_riesgo_unidad_militar) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idIntegrantesApoyosAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN t.id_integrantes_apoyos_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idIntegrantesApoyosAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN t.id_integrantes_apoyos_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'gradoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.grado_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'gradoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.grado_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombresJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.nombres_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombresJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.nombres_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.primer_apellido_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.primer_apellido_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.segundo_apellido_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.segundo_apellido_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'cargoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.cargo_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'cargoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.cargo_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'gradoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.grado_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'gradoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.grado_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombresJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.nombres_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombresJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.nombres_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.primer_apellido_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.primer_apellido_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.segundo_apellido_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.segundo_apellido_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'cargoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.cargo_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'cargoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.cargo_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'gradoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.grado_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'gradoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.grado_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombresCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.nombres_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombresCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.nombres_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.primer_apellido_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.primer_apellido_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.segundo_apellido_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.segundo_apellido_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'cargoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.cargo_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'cargoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.cargo_cte_unidad_militar END DESC", nativeQuery = true)
    List<IntegrantesApoyosAtencPrevEmergDesast> findAllIntegrantesApoyosAtencPrevEmergDesast(@Param("idIntegrantesApoyosAtencPrevEmergDesast") Long idIntegrantesApoyosAtencPrevEmergDesast, @Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("gradoJefeGestionRiesgoUnidadMilitar") String gradoJefeGestionRiesgoUnidadMilitar, @Param("nombresJefeGestionRiesgoUnidadMilitar") String nombresJefeGestionRiesgoUnidadMilitar, @Param("primerApellidoJefeGestionRiesgoUnidadMilitar") String primerApellidoJefeGestionRiesgoUnidadMilitar, @Param("segundoApellidoJefeGestionRiesgoUnidadMilitar") String segundoApellidoJefeGestionRiesgoUnidadMilitar, @Param("cargoJefeGestionRiesgoUnidadMilitar") String cargoJefeGestionRiesgoUnidadMilitar, @Param("gradoJefeOperacionesUnidadMilitar") String gradoJefeOperacionesUnidadMilitar, @Param("nombresJefeOperacionesUnidadMilitar") String nombresJefeOperacionesUnidadMilitar, @Param("primerApellidoJefeOperacionesUnidadMilitar") String primerApellidoJefeOperacionesUnidadMilitar, @Param("segundoApellidoJefeOperacionesUnidadMilitar") String segundoApellidoJefeOperacionesUnidadMilitar, @Param("cargoJefeOperacionesUnidadMilitar") String cargoJefeOperacionesUnidadMilitar, @Param("gradoCteUnidadMilitar") String gradoCteUnidadMilitar, @Param("nombresCteUnidadMilitar") String nombresCteUnidadMilitar, @Param("primerApellidoCteUnidadMilitar") String primerApellidoCteUnidadMilitar, @Param("segundoApellidoCteUnidadMilitar") String segundoApellidoCteUnidadMilitar, @Param("cargoCteUnidadMilitar") String cargoCteUnidadMilitar, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT t.* FROM tabla_integrantes_apoyos_atenc_prev_emerg_desast t " +
          "WHERE (:idIntegrantesApoyosAtencPrevEmergDesast IS NULL OR t.id_integrantes_apoyos_atenc_prev_emerg_desast = :idIntegrantesApoyosAtencPrevEmergDesast) AND " +
          "(:idApoyoAtencPrevEmergDesast IS NULL OR t.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) AND " +
          "(:gradoJefeGestionRiesgoUnidadMilitar IS NULL OR t.grado_jefe_gestion_riesgo_unidad_militar = :gradoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:nombresJefeGestionRiesgoUnidadMilitar IS NULL OR t.nombres_jefe_gestion_riesgo_unidad_militar = :nombresJefeGestionRiesgoUnidadMilitar) AND " +
          "(:primerApellidoJefeGestionRiesgoUnidadMilitar IS NULL OR t.primer_apellido_jefe_gestion_riesgo_unidad_militar = :primerApellidoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:segundoApellidoJefeGestionRiesgoUnidadMilitar IS NULL OR t.segundo_apellido_jefe_gestion_riesgo_unidad_militar = :segundoApellidoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:cargoJefeGestionRiesgoUnidadMilitar IS NULL OR t.cargo_jefe_gestion_riesgo_unidad_militar = :cargoJefeGestionRiesgoUnidadMilitar) AND " +
          "(:gradoJefeOperacionesUnidadMilitar IS NULL OR t.grado_jefe_operaciones_unidad_militar = :gradoJefeOperacionesUnidadMilitar) AND " +
          "(:nombresJefeOperacionesUnidadMilitar IS NULL OR t.nombres_jefe_operaciones_unidad_militar = :nombresJefeOperacionesUnidadMilitar) AND " +
          "(:primerApellidoJefeOperacionesUnidadMilitar IS NULL OR t.primer_apellido_jefe_operaciones_unidad_militar = :primerApellidoJefeOperacionesUnidadMilitar) AND " +
          "(:segundoApellidoJefeOperacionesUnidadMilitar IS NULL OR t.segundo_apellido_jefe_operaciones_unidad_militar = :segundoApellidoJefeOperacionesUnidadMilitar) AND " +
          "(:cargoJefeOperacionesUnidadMilitar IS NULL OR t.cargo_jefe_operaciones_unidad_militar = :cargoJefeOperacionesUnidadMilitar) AND " +
          "(:gradoCteUnidadMilitar IS NULL OR t.grado_cte_unidad_militar = :gradoCteUnidadMilitar) AND " +
          "(:nombresCteUnidadMilitar IS NULL OR t.nombres_cte_unidad_militar = :nombresCteUnidadMilitar) AND " +
          "(:primerApellidoCteUnidadMilitar IS NULL OR t.primer_apellido_cte_unidad_militar = :primerApellidoCteUnidadMilitar) AND " +
          "(:segundoApellidoCteUnidadMilitar IS NULL OR t.segundo_apellido_cte_unidad_militar = :segundoApellidoCteUnidadMilitar) AND " +
          "(:cargoCteUnidadMilitar IS NULL OR t.cargo_cte_unidad_militar = :cargoCteUnidadMilitar) AND " +
          "(:keyword IS NULL OR UPPER(t.nombres_jefe_gestion_riesgo_unidad_militar) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idIntegrantesApoyosAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN t.id_integrantes_apoyos_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idIntegrantesApoyosAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN t.id_integrantes_apoyos_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'gradoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.grado_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'gradoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.grado_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombresJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.nombres_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombresJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.nombres_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.primer_apellido_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.primer_apellido_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.segundo_apellido_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.segundo_apellido_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'cargoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'ASC' THEN t.cargo_jefe_gestion_riesgo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'cargoJefeGestionRiesgoUnidadMilitar' AND :orderMode = 'DESC' THEN t.cargo_jefe_gestion_riesgo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'gradoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.grado_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'gradoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.grado_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombresJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.nombres_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombresJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.nombres_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.primer_apellido_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.primer_apellido_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.segundo_apellido_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.segundo_apellido_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'cargoJefeOperacionesUnidadMilitar' AND :orderMode = 'ASC' THEN t.cargo_jefe_operaciones_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'cargoJefeOperacionesUnidadMilitar' AND :orderMode = 'DESC' THEN t.cargo_jefe_operaciones_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'gradoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.grado_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'gradoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.grado_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombresCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.nombres_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'nombresCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.nombres_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.primer_apellido_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.primer_apellido_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.segundo_apellido_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.segundo_apellido_cte_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'cargoCteUnidadMilitar' AND :orderMode = 'ASC' THEN t.cargo_cte_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'cargoCteUnidadMilitar' AND :orderMode = 'DESC' THEN t.cargo_cte_unidad_militar END DESC", nativeQuery = true)
    Slice<IntegrantesApoyosAtencPrevEmergDesast> findAllIntegrantesApoyosAtencPrevEmergDesastPag(Pageable pageable, @Param("idIntegrantesApoyosAtencPrevEmergDesast") Long idIntegrantesApoyosAtencPrevEmergDesast, @Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("gradoJefeGestionRiesgoUnidadMilitar") String gradoJefeGestionRiesgoUnidadMilitar, @Param("nombresJefeGestionRiesgoUnidadMilitar") String nombresJefeGestionRiesgoUnidadMilitar, @Param("primerApellidoJefeGestionRiesgoUnidadMilitar") String primerApellidoJefeGestionRiesgoUnidadMilitar, @Param("segundoApellidoJefeGestionRiesgoUnidadMilitar") String segundoApellidoJefeGestionRiesgoUnidadMilitar, @Param("cargoJefeGestionRiesgoUnidadMilitar") String cargoJefeGestionRiesgoUnidadMilitar, @Param("gradoJefeOperacionesUnidadMilitar") String gradoJefeOperacionesUnidadMilitar, @Param("nombresJefeOperacionesUnidadMilitar") String nombresJefeOperacionesUnidadMilitar, @Param("primerApellidoJefeOperacionesUnidadMilitar") String primerApellidoJefeOperacionesUnidadMilitar, @Param("segundoApellidoJefeOperacionesUnidadMilitar") String segundoApellidoJefeOperacionesUnidadMilitar, @Param("cargoJefeOperacionesUnidadMilitar") String cargoJefeOperacionesUnidadMilitar, @Param("gradoCteUnidadMilitar") String gradoCteUnidadMilitar, @Param("nombresCteUnidadMilitar") String nombresCteUnidadMilitar, @Param("primerApellidoCteUnidadMilitar") String primerApellidoCteUnidadMilitar, @Param("segundoApellidoCteUnidadMilitar") String segundoApellidoCteUnidadMilitar, @Param("cargoCteUnidadMilitar") String cargoCteUnidadMilitar, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<IntegrantesApoyosAtencPrevEmergDesast> findByIdIntegrantesApoyosAtencPrevEmergDesast(Long idIntegrantesApoyosAtencPrevEmergDesast);
    
    //BUSQUEDA UNITARIA POR ID APOYO ATENC PREV EMERG DESAST (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO DE INTEGRANTES PARA EL MISMO APOYO):
    @Query(value = "SELECT * FROM tabla_integrantes_apoyos_atenc_prev_emerg_desast " +
          "WHERE id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast AND ROWNUM = 1", nativeQuery = true)
    IntegrantesApoyosAtencPrevEmergDesast findByApoyoAtencPrevEmergDesastId(@Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast);
    
    @Query(value = "SELECT MAX(id_integrantes_apoyos_atenc_prev_emerg_desast) FROM tabla_integrantes_apoyos_atenc_prev_emerg_desast", nativeQuery = true)
    Long findMaxIdIntegrantesApoyosAtencPrevEmergDesast();
}
