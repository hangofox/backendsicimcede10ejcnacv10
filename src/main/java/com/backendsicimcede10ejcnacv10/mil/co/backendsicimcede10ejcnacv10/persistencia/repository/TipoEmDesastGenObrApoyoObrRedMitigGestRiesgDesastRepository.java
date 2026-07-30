//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast;
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
public interface TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesastRepository extends JpaRepository<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast WHERE (:idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast IS NULL OR id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast = :idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast) AND (:keyword IS NULL OR UPPER(nombre_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast") Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast WHERE (:idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast IS NULL OR id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast = :idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast) AND (:keyword IS NULL OR UPPER(nombre_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END ASC, CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END DESC, CASE WHEN :orderBy = 'nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN nombre_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END ASC, CASE WHEN :orderBy = 'nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN nombre_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    List<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> findAllTiposEmDesastGenObrRedMitigGestRiesgDesast(@Param("idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast") Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_tipos_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast WHERE (:idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast IS NULL OR id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast = :idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast) AND (:keyword IS NULL OR UPPER(nombre_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END ASC, CASE WHEN :orderBy = 'idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END DESC, CASE WHEN :orderBy = 'nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN nombre_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END ASC, CASE WHEN :orderBy = 'nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN nombre_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    Slice<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> findAllTiposEmDesastGenObrRedMitigGestRiesgDesastPag(Pageable pageable, @Param("idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast") Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast> findByIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(Long idTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
    
    TipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast findByNombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast(String nombreTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT MAX(id_tipo_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast) FROM tabla_tipos_em_desast_gen_obr_apoyo_obr_red_mitig_gest_riesg_desast", nativeQuery = true)
    Long findMaxIdTipoEmDesastGenObrApoyoObrRedMitigGestRiesgDesast();
}
