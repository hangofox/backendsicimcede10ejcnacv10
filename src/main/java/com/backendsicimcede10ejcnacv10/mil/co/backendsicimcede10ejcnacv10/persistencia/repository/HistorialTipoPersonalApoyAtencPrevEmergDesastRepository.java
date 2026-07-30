//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialTipoPersonalApoyAtencPrevEmergDesast;
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
public interface HistorialTipoPersonalApoyAtencPrevEmergDesastRepository extends JpaRepository<HistorialTipoPersonalApoyAtencPrevEmergDesast, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID APOYO ATENC PREV EMERG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast " +
            "WHERE (:idHistorialTipoPersonalApoyAtencPrevEmergDesast IS NULL OR tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.id_historial_tipo_personal_apoy_atenc_prev_emerg_desast = :idHistorialTipoPersonalApoyAtencPrevEmergDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.num_reg_historial_tipo_personal_apoy_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialTipoPersonalApoyAtencPrevEmergDesast") Long idHistorialTipoPersonalApoyAtencPrevEmergDesast, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.* FROM tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast " +
            "WHERE (:idHistorialTipoPersonalApoyAtencPrevEmergDesast IS NULL OR tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.id_historial_tipo_personal_apoy_atenc_prev_emerg_desast = :idHistorialTipoPersonalApoyAtencPrevEmergDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.num_reg_historial_tipo_personal_apoy_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.id_historial_tipo_personal_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.id_historial_tipo_personal_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.num_reg_historial_tipo_personal_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.num_reg_historial_tipo_personal_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.cantidad_personal_apoyo END ASC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.cantidad_personal_apoyo END DESC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.dias_empleados_tipo_personal_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.dias_empleados_tipo_personal_apoy_atenc_prev_emerg_desast END DESC", nativeQuery = true)
    List<HistorialTipoPersonalApoyAtencPrevEmergDesast> findAllHistorialesTiposPersonalApoyAtencPrevEmergDesast(@Param("idHistorialTipoPersonalApoyAtencPrevEmergDesast") Long idHistorialTipoPersonalApoyAtencPrevEmergDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.* FROM tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast " +
            "WHERE (:idHistorialTipoPersonalApoyAtencPrevEmergDesast IS NULL OR tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.id_historial_tipo_personal_apoy_atenc_prev_emerg_desast = :idHistorialTipoPersonalApoyAtencPrevEmergDesast) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.num_reg_historial_tipo_personal_apoy_atenc_prev_emerg_desast) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.id_historial_tipo_personal_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.id_historial_tipo_personal_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.num_reg_historial_tipo_personal_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.num_reg_historial_tipo_personal_apoy_atenc_prev_emerg_desast END DESC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.cantidad_personal_apoyo END ASC, " +
            "CASE WHEN :orderBy = 'cantidadPersonalApoyo' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.cantidad_personal_apoyo END DESC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'ASC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.dias_empleados_tipo_personal_apoy_atenc_prev_emerg_desast END ASC, " +
            "CASE WHEN :orderBy = 'diasEmpleadosTipoPersonalApoyAtencPrevEmergDesast' AND :orderMode = 'DESC' THEN tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast.dias_empleados_tipo_personal_apoy_atenc_prev_emerg_desast END DESC", nativeQuery = true)
    Slice<HistorialTipoPersonalApoyAtencPrevEmergDesast> findAllHistorialesTiposPersonalApoyAtencPrevEmergDesastPag(Pageable pageable, @Param("idHistorialTipoPersonalApoyAtencPrevEmergDesast") Long idHistorialTipoPersonalApoyAtencPrevEmergDesast, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialTipoPersonalApoyAtencPrevEmergDesast> findByIdHistorialTipoPersonalApoyAtencPrevEmergDesast(Long idHistorialTipoPersonalApoyAtencPrevEmergDesast);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialTipoPersonalApoyAtencPrevEmergDesast findByNumRegHistorialTipoPersonalApoyAtencPrevEmergDesast(String numRegHistorialTipoPersonalApoyAtencPrevEmergDesast);
    
    @Query(value = "SELECT MAX(id_historial_tipo_personal_apoy_atenc_prev_emerg_desast) FROM tabla_historial_tipos_personal_apoy_atenc_prev_emerg_desast", nativeQuery = true)
    Long findMaxIdHistorialTipoPersonalApoyAtencPrevEmergDesast();
}
