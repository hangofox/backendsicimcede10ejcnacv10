//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialOrdenApoyoMovimientoTropa;
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
public interface HistorialOrdenApoyoMovimientoTropaRepository extends JpaRepository<HistorialOrdenApoyoMovimientoTropa, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID APOYO ATENC PREV EMERG DESAST + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_ordenes_apoyos_movimientos_tropas " +
          "WHERE (:idHistorialOrdenApoyoMovimientoTropa IS NULL OR tabla_historial_ordenes_apoyos_movimientos_tropas.id_historial_orden_apoyo_movimiento_tropa = :idHistorialOrdenApoyoMovimientoTropa) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_ordenes_apoyos_movimientos_tropas.num_reg_historial_orden_apoyo_movimiento_tropa) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_ordenes_apoyos_movimientos_tropas.numero_oficio_hr_orden_apoyo_movimiento_tropa) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialOrdenApoyoMovimientoTropa") Long idHistorialOrdenApoyoMovimientoTropa, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_ordenes_apoyos_movimientos_tropas.* FROM tabla_historial_ordenes_apoyos_movimientos_tropas " +
          "WHERE (:idHistorialOrdenApoyoMovimientoTropa IS NULL OR tabla_historial_ordenes_apoyos_movimientos_tropas.id_historial_orden_apoyo_movimiento_tropa = :idHistorialOrdenApoyoMovimientoTropa) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_ordenes_apoyos_movimientos_tropas.num_reg_historial_orden_apoyo_movimiento_tropa) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_ordenes_apoyos_movimientos_tropas.numero_oficio_hr_orden_apoyo_movimiento_tropa) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.id_historial_orden_apoyo_movimiento_tropa END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.id_historial_orden_apoyo_movimiento_tropa END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.num_reg_historial_orden_apoyo_movimiento_tropa END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.num_reg_historial_orden_apoyo_movimiento_tropa END DESC, " +
          "CASE WHEN :orderBy = 'numeroOficioHrOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.numero_oficio_hr_orden_apoyo_movimiento_tropa END ASC, " +
          "CASE WHEN :orderBy = 'numeroOficioHrOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.numero_oficio_hr_orden_apoyo_movimiento_tropa END DESC, " +
          "CASE WHEN :orderBy = 'asuntoOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_ordenes_apoyos_movimientos_tropas.asunto_orden_apoyo_movimiento_tropa, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'asuntoOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_ordenes_apoyos_movimientos_tropas.asunto_orden_apoyo_movimiento_tropa, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialOrdenApoyoMovimientoTropa> findAllHistorialesOrdenesApoyosMovimientosTropas(@Param("idHistorialOrdenApoyoMovimientoTropa") Long idHistorialOrdenApoyoMovimientoTropa, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_ordenes_apoyos_movimientos_tropas.* FROM tabla_historial_ordenes_apoyos_movimientos_tropas " +
          "WHERE (:idHistorialOrdenApoyoMovimientoTropa IS NULL OR tabla_historial_ordenes_apoyos_movimientos_tropas.id_historial_orden_apoyo_movimiento_tropa = :idHistorialOrdenApoyoMovimientoTropa) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_ordenes_apoyos_movimientos_tropas.num_reg_historial_orden_apoyo_movimiento_tropa) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_ordenes_apoyos_movimientos_tropas.numero_oficio_hr_orden_apoyo_movimiento_tropa) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.id_historial_orden_apoyo_movimiento_tropa END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.id_historial_orden_apoyo_movimiento_tropa END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.num_reg_historial_orden_apoyo_movimiento_tropa END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.num_reg_historial_orden_apoyo_movimiento_tropa END DESC, " +
          "CASE WHEN :orderBy = 'numeroOficioHrOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.numero_oficio_hr_orden_apoyo_movimiento_tropa END ASC, " +
          "CASE WHEN :orderBy = 'numeroOficioHrOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN tabla_historial_ordenes_apoyos_movimientos_tropas.numero_oficio_hr_orden_apoyo_movimiento_tropa END DESC, " +
          "CASE WHEN :orderBy = 'asuntoOrdenApoyoMovimientoTropa' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_ordenes_apoyos_movimientos_tropas.asunto_orden_apoyo_movimiento_tropa, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'asuntoOrdenApoyoMovimientoTropa' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_ordenes_apoyos_movimientos_tropas.asunto_orden_apoyo_movimiento_tropa, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialOrdenApoyoMovimientoTropa> findAllHistorialesOrdenesApoyosMovimientosTropasPag(Pageable pageable, @Param("idHistorialOrdenApoyoMovimientoTropa") Long idHistorialOrdenApoyoMovimientoTropa, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialOrdenApoyoMovimientoTropa> findByIdHistorialOrdenApoyoMovimientoTropa(Long idHistorialOrdenApoyoMovimientoTropa);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialOrdenApoyoMovimientoTropa findByNumRegHistorialOrdenApoyoMovimientoTropa(String numRegHistorialOrdenApoyoMovimientoTropa);
    
    @Query(value = "SELECT MAX(id_historial_orden_apoyo_movimiento_tropa) FROM tabla_historial_ordenes_apoyos_movimientos_tropas", nativeQuery = true)
    Long findMaxIdHistorialOrdenApoyoMovimientoTropa();
}
