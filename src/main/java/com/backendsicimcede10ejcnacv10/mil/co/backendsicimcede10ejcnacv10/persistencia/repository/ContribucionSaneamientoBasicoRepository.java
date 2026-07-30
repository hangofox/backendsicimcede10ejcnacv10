//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ContribucionSaneamientoBasico;
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
public interface ContribucionSaneamientoBasicoRepository extends JpaRepository<ContribucionSaneamientoBasico, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID CONTRIBUCION + KEYWORD + ID INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_contribuciones_saneamientos_basicos " +
            "WHERE (:idContribucionSaneamientoBasico IS NULL OR tabla_contribuciones_saneamientos_basicos.id_contribucion_saneamiento_basico = :idContribucionSaneamientoBasico) AND " +
            "(:keyword IS NULL OR UPPER(tabla_contribuciones_saneamientos_basicos.valor_pago_contribucion_saneamiento_basico) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idInfraestructura IS NULL OR tabla_contribuciones_saneamientos_basicos.id_infraestructura = :idInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idContribucionSaneamientoBasico") Long idContribucionSaneamientoBasico, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura);
    
    @Query(value = "SELECT tabla_contribuciones_saneamientos_basicos.* FROM tabla_contribuciones_saneamientos_basicos " +
            "WHERE (:idContribucionSaneamientoBasico IS NULL OR tabla_contribuciones_saneamientos_basicos.id_contribucion_saneamiento_basico = :idContribucionSaneamientoBasico) AND " +
            "(:keyword IS NULL OR UPPER(tabla_contribuciones_saneamientos_basicos.valor_pago_contribucion_saneamiento_basico) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idInfraestructura IS NULL OR tabla_contribuciones_saneamientos_basicos.id_infraestructura = :idInfraestructura) " +
            "ORDER BY CASE WHEN :orderBy = 'idContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'idContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_contribucion_saneamiento_basico END DESC, " +
            "CASE WHEN :orderBy = 'valorPagoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.valor_pago_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'valorPagoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.valor_pago_contribucion_saneamiento_basico END DESC, " +
            "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_historial_proveedor_producto_o_servicio END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_historial_proveedor_producto_o_servicio END DESC, " +
            "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_tipo_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_tipo_contribucion_saneamiento_basico END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.fecha_h_m_s_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.fecha_h_m_s_contribucion_saneamiento_basico END DESC", nativeQuery = true)
    List<ContribucionSaneamientoBasico> findAllContribucionesSaneamientosBasicos(@Param("idContribucionSaneamientoBasico") Long idContribucionSaneamientoBasico, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_contribuciones_saneamientos_basicos.* FROM tabla_contribuciones_saneamientos_basicos " +
            "WHERE (:idContribucionSaneamientoBasico IS NULL OR tabla_contribuciones_saneamientos_basicos.id_contribucion_saneamiento_basico = :idContribucionSaneamientoBasico) AND " +
            "(:keyword IS NULL OR UPPER(tabla_contribuciones_saneamientos_basicos.valor_pago_contribucion_saneamiento_basico) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idInfraestructura IS NULL OR tabla_contribuciones_saneamientos_basicos.id_infraestructura = :idInfraestructura) " +
            "ORDER BY CASE WHEN :orderBy = 'idContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'idContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_contribucion_saneamiento_basico END DESC, " +
            "CASE WHEN :orderBy = 'valorPagoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.valor_pago_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'valorPagoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.valor_pago_contribucion_saneamiento_basico END DESC, " +
            "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_historial_proveedor_producto_o_servicio END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_historial_proveedor_producto_o_servicio END DESC, " +
            "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.id_tipo_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'idTipoContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.id_tipo_contribucion_saneamiento_basico END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSContribucionSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_contribuciones_saneamientos_basicos.fecha_h_m_s_contribucion_saneamiento_basico END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSContribucionSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_contribuciones_saneamientos_basicos.fecha_h_m_s_contribucion_saneamiento_basico END DESC", nativeQuery = true)
    Slice<ContribucionSaneamientoBasico> findAllContribucionesSaneamientosBasicosPag(Pageable pageable, @Param("idContribucionSaneamientoBasico") Long idContribucionSaneamientoBasico, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ContribucionSaneamientoBasico> findByIdContribucionSaneamientoBasico(Long idContribucionSaneamientoBasico);
    
    @Query(value = "SELECT MAX(id_contribucion_saneamiento_basico) FROM tabla_contribuciones_saneamientos_basicos", nativeQuery = true)
    Long findMaxIdContribucionSaneamientoBasico();
}
