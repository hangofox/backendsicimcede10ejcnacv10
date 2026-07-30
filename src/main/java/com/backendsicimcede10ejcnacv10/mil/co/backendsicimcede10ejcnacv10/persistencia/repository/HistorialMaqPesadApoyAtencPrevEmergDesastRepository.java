//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMaqPesadApoyAtencPrevEmergDesast;
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
public interface HistorialMaqPesadApoyAtencPrevEmergDesastRepository extends JpaRepository<HistorialMaqPesadApoyAtencPrevEmergDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID APOYO ATENC PREV EMERG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast " +
            "WHERE (:idHistorialMaqPesadApoyAtencPrevEmergDesast IS NULL OR tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.id_historial_maq_pesad_apoy_atenc_prev_emerg_desast = :idHistorialMaqPesadApoyAtencPrevEmergDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.num_reg_historial_maq_pesad_apoy_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialMaqPesadApoyAtencPrevEmergDesast") Long idHistorialMaqPesadApoyAtencPrevEmergDesast, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.* FROM tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast " +
            "WHERE (:idHistorialMaqPesadApoyAtencPrevEmergDesast IS NULL OR tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.id_historial_maq_pesad_apoy_atenc_prev_emerg_desast = :idHistorialMaqPesadApoyAtencPrevEmergDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.num_reg_historial_maq_pesad_apoy_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.id_historial_maq_pesad_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.id_historial_maq_pesad_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.num_reg_historial_maq_pesad_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.num_reg_historial_maq_pesad_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.dias_empleados_maq_pesad_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.dias_empleados_maq_pesad_apoy_atenc_prev_emerg_desast END DESC", nativeQuery = true)
    List<HistorialMaqPesadApoyAtencPrevEmergDesast> findAllHistorialesMaqPesadApoyAtencPrevEmergDesast(@Param("idHistorialMaqPesadApoyAtencPrevEmergDesast") Long idHistorialMaqPesadApoyAtencPrevEmergDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.* FROM tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast " +
            "WHERE (:idHistorialMaqPesadApoyAtencPrevEmergDesast IS NULL OR tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.id_historial_maq_pesad_apoy_atenc_prev_emerg_desast = :idHistorialMaqPesadApoyAtencPrevEmergDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.num_reg_historial_maq_pesad_apoy_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.id_historial_maq_pesad_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.id_historial_maq_pesad_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.num_reg_historial_maq_pesad_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.num_reg_historial_maq_pesad_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.dias_empleados_maq_pesad_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosMaqPesadApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast.dias_empleados_maq_pesad_apoy_atenc_prev_emerg_desast END DESC", nativeQuery = true)
    Slice<HistorialMaqPesadApoyAtencPrevEmergDesast> findAllHistorialesMaqPesadApoyAtencPrevEmergDesastPag(Pageable pageable, @Param("idHistorialMaqPesadApoyAtencPrevEmergDesast") Long idHistorialMaqPesadApoyAtencPrevEmergDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialMaqPesadApoyAtencPrevEmergDesast> findByIdHistorialMaqPesadApoyAtencPrevEmergDesast(Long idHistorialMaqPesadApoyAtencPrevEmergDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialMaqPesadApoyAtencPrevEmergDesast findByNumRegHistorialMaqPesadApoyAtencPrevEmergDesast(String numRegHistorialMaqPesadApoyAtencPrevEmergDesast);
    
    @Query(value = "SELECT MAX(id_historial_maq_pesad_apoy_atenc_prev_emerg_desast) FROM tabla_historial_maq_pesad_apoy_atenc_prev_emerg_desast", nativeQuery = true)
    Long findMaxIdHistorialMaqPesadApoyAtencPrevEmergDesast();
}
