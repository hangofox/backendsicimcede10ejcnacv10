//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaApoyAtencPrevEmergDesast;
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
public interface FotografiaAnexaApoyAtencPrevEmergDesastRepository extends JpaRepository<FotografiaAnexaApoyAtencPrevEmergDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + ID APOYO ATENC PREV EMERG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast " +
          "WHERE (:idFotografiasAnexasApoyAtencPrevEmergDesast IS NULL OR tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_fotografias_anexas_apoy_atenc_prev_emerg_desast = :idFotografiasAnexasApoyAtencPrevEmergDesast) AND " +
          "(:idApoyoAtencPrevEmergDesast IS NULL OR tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast)", nativeQuery = true)
    Long findTotalRegistros(@Param("idFotografiasAnexasApoyAtencPrevEmergDesast") Long idFotografiasAnexasApoyAtencPrevEmergDesast, @Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast);
    
    @Query(value = "SELECT tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.* FROM tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast " +
          "WHERE (:idFotografiasAnexasApoyAtencPrevEmergDesast IS NULL OR tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_fotografias_anexas_apoy_atenc_prev_emerg_desast = :idFotografiasAnexasApoyAtencPrevEmergDesast) AND " +
          "(:idApoyoAtencPrevEmergDesast IS NULL OR tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) " +
          "ORDER BY CASE WHEN :orderBy = 'idFotografiasAnexasApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_fotografias_anexas_apoy_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idFotografiasAnexasApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_fotografias_anexas_apoy_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END DESC", nativeQuery = true)
    List<FotografiaAnexaApoyAtencPrevEmergDesast> findAllFotografiasAnexasApoyosAtencPrevEmergDesast(@Param("idFotografiasAnexasApoyAtencPrevEmergDesast") Long idFotografiasAnexasApoyAtencPrevEmergDesast, @Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.* FROM tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast " +
          "WHERE (:idFotografiasAnexasApoyAtencPrevEmergDesast IS NULL OR tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_fotografias_anexas_apoy_atenc_prev_emerg_desast = :idFotografiasAnexasApoyAtencPrevEmergDesast) AND " +
          "(:idApoyoAtencPrevEmergDesast IS NULL OR tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast) " +
          "ORDER BY CASE WHEN :orderBy = 'idFotografiasAnexasApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_fotografias_anexas_apoy_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idFotografiasAnexasApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_fotografias_anexas_apoy_atenc_prev_emerg_desast END DESC, " +
          "CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END ASC, " +
          "CASE WHEN :orderBy = 'idApoyoAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast.id_apoyo_atenc_prev_emerg_desast END DESC", nativeQuery = true)
    Slice<FotografiaAnexaApoyAtencPrevEmergDesast> findAllFotografiasAnexasApoyosAtencPrevEmergDesastPag(Pageable pageable, @Param("idFotografiasAnexasApoyAtencPrevEmergDesast") Long idFotografiasAnexasApoyAtencPrevEmergDesast, @Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<FotografiaAnexaApoyAtencPrevEmergDesast> findByIdFotografiasAnexasApoyAtencPrevEmergDesast(Long idFotografiasAnexasApoyAtencPrevEmergDesast);
    
    //BUSQUEDA UNITARIA POR ID APOYO ATENC PREV EMERG DESAST (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO):
    @Query(value = "SELECT * FROM tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast " +
          "WHERE id_apoyo_atenc_prev_emerg_desast = :idApoyoAtencPrevEmergDesast AND ROWNUM = 1", nativeQuery = true)
    FotografiaAnexaApoyAtencPrevEmergDesast findByApoyoAtencPrevEmergDesastId(@Param("idApoyoAtencPrevEmergDesast") Long idApoyoAtencPrevEmergDesast);
    
    @Query(value = "SELECT MAX(id_fotografias_anexas_apoy_atenc_prev_emerg_desast) FROM tabla_fotografias_anexas_apoyos_atenc_prev_emerg_desast", nativeQuery = true)
    Long findMaxIdFotografiasAnexasApoyAtencPrevEmergDesast();
}
