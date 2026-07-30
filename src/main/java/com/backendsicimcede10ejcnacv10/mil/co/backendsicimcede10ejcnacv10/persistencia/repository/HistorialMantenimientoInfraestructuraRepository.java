//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMantenimientoInfraestructura;
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
public interface HistorialMantenimientoInfraestructuraRepository extends JpaRepository<HistorialMantenimientoInfraestructura, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID HISTORIAL MANTENIMIENTO INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_mantenimientos_infraestructuras " +
            "WHERE (:idHistorialMantenimientoInfraestructura IS NULL OR tabla_historial_mantenimientos_infraestructuras.id_historial_mantenimiento_infraestructura = :idHistorialMantenimientoInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_mantenimientos_infraestructuras.num_reg_historial_mantenimiento_infraestructura) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialMantenimientoInfraestructura") Long idHistorialMantenimientoInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_mantenimientos_infraestructuras.* FROM tabla_historial_mantenimientos_infraestructuras " +
            "WHERE (:idHistorialMantenimientoInfraestructura IS NULL OR tabla_historial_mantenimientos_infraestructuras.id_historial_mantenimiento_infraestructura = :idHistorialMantenimientoInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_mantenimientos_infraestructuras.num_reg_historial_mantenimiento_infraestructura) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.id_historial_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.id_historial_mantenimiento_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.num_reg_historial_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.num_reg_historial_mantenimiento_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.asunto_mantenimiento_infraestructura, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.asunto_mantenimiento_infraestructura, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.descripcion_mantenimiento_infraestructura, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.descripcion_mantenimiento_infraestructura, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.fecha_h_m_s_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.fecha_h_m_s_mantenimiento_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.valor_costo_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.valor_costo_mantenimiento_infraestructura END DESC", nativeQuery = true)
    List<HistorialMantenimientoInfraestructura> findAllHistorialesMantenimientosInfraestructuras(@Param("idHistorialMantenimientoInfraestructura") Long idHistorialMantenimientoInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_mantenimientos_infraestructuras.* FROM tabla_historial_mantenimientos_infraestructuras " +
            "WHERE (:idHistorialMantenimientoInfraestructura IS NULL OR tabla_historial_mantenimientos_infraestructuras.id_historial_mantenimiento_infraestructura = :idHistorialMantenimientoInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_mantenimientos_infraestructuras.num_reg_historial_mantenimiento_infraestructura) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.id_historial_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.id_historial_mantenimiento_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.num_reg_historial_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.num_reg_historial_mantenimiento_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.asunto_mantenimiento_infraestructura, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.asunto_mantenimiento_infraestructura, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.descripcion_mantenimiento_infraestructura, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_infraestructuras.descripcion_mantenimiento_infraestructura, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.fecha_h_m_s_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.fecha_h_m_s_mantenimiento_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_infraestructuras.valor_costo_mantenimiento_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_infraestructuras.valor_costo_mantenimiento_infraestructura END DESC", nativeQuery = true)
    Slice<HistorialMantenimientoInfraestructura> findAllHistorialesMantenimientosInfraestructurasPag(Pageable pageable, @Param("idHistorialMantenimientoInfraestructura") Long idHistorialMantenimientoInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialMantenimientoInfraestructura> findByIdHistorialMantenimientoInfraestructura(Long idHistorialMantenimientoInfraestructura);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialMantenimientoInfraestructura findByNumRegHistorialMantenimientoInfraestructura(String numRegHistorialMantenimientoInfraestructura);
    
    @Query(value = "SELECT MAX(id_historial_mantenimiento_infraestructura) FROM tabla_historial_mantenimientos_infraestructuras", nativeQuery = true)
    Long findMaxIdHistorialMantenimientoInfraestructura();
}
