//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaApoyObrRedMitigGestRiesgDesast;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface FotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository extends JpaRepository<FotografiaAnexaApoyObrRedMitigGestRiesgDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + ID APOYO OBR RED MITIG GEST RIESG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast " +
          "WHERE (:idFotografiasAnexasApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast = :idFotografiasAnexasApoyObrRedMitigGestRiesgDesast) AND " +
          "(:idApoyoObrRedMitigGestRiesgDesast IS NULL OR tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast = :idApoyoObrRedMitigGestRiesgDesast)", nativeQuery = true)
    Long findTotalRegistros(@Param("idFotografiasAnexasApoyObrRedMitigGestRiesgDesast") Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, @Param("idApoyoObrRedMitigGestRiesgDesast") Long idApoyoObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.* FROM tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast " +
          "WHERE (:idFotografiasAnexasApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast = :idFotografiasAnexasApoyObrRedMitigGestRiesgDesast) AND " +
          "(:idApoyoObrRedMitigGestRiesgDesast IS NULL OR tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast = :idApoyoObrRedMitigGestRiesgDesast) " +
          "ORDER BY CASE WHEN :orderBy = 'idFotografiasAnexasApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idFotografiasAnexasApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    List<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> findAllFotografiasAnexasApoyosObrRedMitigGestRiesgDesast(@Param("idFotografiasAnexasApoyObrRedMitigGestRiesgDesast") Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, @Param("idApoyoObrRedMitigGestRiesgDesast") Long idApoyoObrRedMitigGestRiesgDesast, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.* FROM tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast " +
          "WHERE (:idFotografiasAnexasApoyObrRedMitigGestRiesgDesast IS NULL OR tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast = :idFotografiasAnexasApoyObrRedMitigGestRiesgDesast) AND " +
          "(:idApoyoObrRedMitigGestRiesgDesast IS NULL OR tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast = :idApoyoObrRedMitigGestRiesgDesast) " +
          "ORDER BY CASE WHEN :orderBy = 'idFotografiasAnexasApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idFotografiasAnexasApoyObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoObrRedMitigGestRiesgDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast.id_apoyo_obr_red_mitig_gest_riesg_desast END DESC", nativeQuery = true)
    Slice<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> findAllFotografiasAnexasApoyosObrRedMitigGestRiesgDesastPag(Pageable pageable, @Param("idFotografiasAnexasApoyObrRedMitigGestRiesgDesast") Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, @Param("idApoyoObrRedMitigGestRiesgDesast") Long idApoyoObrRedMitigGestRiesgDesast, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> findByIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast(Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast);
    
    //BUSQUEDA UNITARIA POR ID APOYO OBR RED MITIG GEST RIESG DESAST (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO):
    @Query(value = "SELECT * FROM tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast " +
          "WHERE id_apoyo_obr_red_mitig_gest_riesg_desast = :idApoyoObrRedMitigGestRiesgDesast AND ROWNUM = 1", nativeQuery = true)
    FotografiaAnexaApoyObrRedMitigGestRiesgDesast findByApoyoObrRedMitigGestRiesgDesastId(@Param("idApoyoObrRedMitigGestRiesgDesast") Long idApoyoObrRedMitigGestRiesgDesast);
    
    @Query(value = "SELECT MAX(id_fotografias_anexas_apoy_obr_red_mitig_gest_riesg_desast) FROM tabla_fotografias_anexas_apoyos_obr_red_mitig_gest_riesg_desast", nativeQuery = true)
    Long findMaxIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast();
}
