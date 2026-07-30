//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast;
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
public interface HistorialTipoPersonalApoyObrRedMitigGestRiesgDesastRepository extends JpaRepository<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID APOYO OBR RED MITIG GEST RIESG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast " +
            "WHERE (:idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast") Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast " +
            "WHERE (:idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.cantidad_personal_apoyo END ASC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.cantidad_personal_apoyo END DESC, " +
            "CASE WHEN :orderBy = 'nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.nombre_especialidad_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.nombre_especialidad_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    List<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> findAllHistorialesTiposPersonalApoyObrRedMitigGestRiesgDesast(@Param("idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast") Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.* FROM tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast " +
            "WHERE (:idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast = :idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.num_reg_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.cantidad_personal_apoyo END ASC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.cantidad_personal_apoyo END DESC, " +
            "CASE WHEN :orderBy = 'nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.nombre_especialidad_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
            "CASE WHEN :orderBy = 'nombreEspecialidadTipoPersonalApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast.nombre_especialidad_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    Slice<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> findAllHistorialesTiposPersonalApoyObrRedMitigGestRiesgDesastPag(Pageable pageable, @Param("idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast") Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast> findByIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(Long idHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialTipoPersonalApoyObrRedMitigGestRiesgDesast findByNumRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast(String numRegHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT MAX(id_historial_tipo_personal_apoy_obr_red_mitig_gest_riesg_desast) FROM tabla_historial_tipos_personal_apoy_obr_red_mitig_gest_riesg_desast", nativeQuery = true)
    Long findMaxIdHistorialTipoPersonalApoyObrRedMitigGestRiesgDesast();
}
