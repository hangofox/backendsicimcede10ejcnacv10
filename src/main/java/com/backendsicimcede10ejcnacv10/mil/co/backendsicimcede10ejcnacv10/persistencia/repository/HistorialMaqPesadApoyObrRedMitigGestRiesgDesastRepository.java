//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMaqPesadApoyObrRedMitigGestRiesgDesast;
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
public interface HistorialMaqPesadApoyObrRedMitigGestRiesgDesastRepository extends JpaRepository<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID APOYO OBR RED MITIG GEST RIESG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast " +
            "WHERE (:idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast") Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast " +
            "WHERE (:idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    List<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> findAllHistorialesMaqPesadApoyObrRedMitigGestRiesgDesast(@Param("idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast") Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast " +
            "WHERE (:idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'totalHorasEmpleadasMaqPesadApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast.total_horas_empleadas_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    Slice<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> findAllHistorialesMaqPesadApoyObrRedMitigGestRiesgDesastPag(Pageable pageable, @Param("idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast") Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialMaqPesadApoyObrRedMitigGestRiesgDesast> findByIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(Long idHistorialMaqPesadApoyObrRedMitigGestRiesgDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialMaqPesadApoyObrRedMitigGestRiesgDesast findByNumRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast(String numRegHistorialMaqPesadApoyObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT MAX(id_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast) FROM tabla_historial_maq_pesad_apoy_obr_red_mitig_gest_riesg_desast", nativeQuery = true)
    Long findMaxIdHistorialMaqPesadApoyObrRedMitigGestRiesgDesast();
}
