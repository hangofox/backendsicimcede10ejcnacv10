//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.AseguramientoLineaBlanca;
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
public interface AseguramientoLineaBlancaRepository extends JpaRepository<AseguramientoLineaBlanca, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ID EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_aseguramientos_lineas_blancas " +
            "WHERE (:idAseguramientoLineaBlanca IS NULL OR tabla_aseguramientos_lineas_blancas.id_aseguramiento_linea_blanca = :idAseguramientoLineaBlanca) AND " +
            "(:keyword IS NULL OR UPPER(tabla_aseguramientos_lineas_blancas.numero_seguro_aseguramiento_linea_blanca) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idEquipoIngeniero IS NULL OR tabla_aseguramientos_lineas_blancas.id_equipo_ingeniero = :idEquipoIngeniero)", nativeQuery = true)
    Long findTotalRegistros(@Param("idAseguramientoLineaBlanca") Long idAseguramientoLineaBlanca, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero);
    
    @Query(value = "SELECT tabla_aseguramientos_lineas_blancas.* FROM tabla_aseguramientos_lineas_blancas " +
            "WHERE (:idAseguramientoLineaBlanca IS NULL OR tabla_aseguramientos_lineas_blancas.id_aseguramiento_linea_blanca = :idAseguramientoLineaBlanca) AND " +
            "(:keyword IS NULL OR UPPER(tabla_aseguramientos_lineas_blancas.numero_seguro_aseguramiento_linea_blanca) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idEquipoIngeniero IS NULL OR tabla_aseguramientos_lineas_blancas.id_equipo_ingeniero = :idEquipoIngeniero) " +
            "ORDER BY CASE WHEN :orderBy = 'idAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'idAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_iniciacion_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_iniciacion_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_finalizacion_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_finalizacion_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_aseguradora END ASC, " +
            "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_aseguradora END DESC, " +
            "CASE WHEN :orderBy = 'numeroSeguroAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.numero_seguro_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'numeroSeguroAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.numero_seguro_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_tipo_responsabilidad_contractual END ASC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_tipo_responsabilidad_contractual END DESC, " +
            "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.valor_solicitado_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.valor_solicitado_aseguramiento_linea_blanca END DESC", nativeQuery = true)
    List<AseguramientoLineaBlanca> findAllAseguramientosLineasBlancas(@Param("idAseguramientoLineaBlanca") Long idAseguramientoLineaBlanca, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_aseguramientos_lineas_blancas.* FROM tabla_aseguramientos_lineas_blancas " +
            "WHERE (:idAseguramientoLineaBlanca IS NULL OR tabla_aseguramientos_lineas_blancas.id_aseguramiento_linea_blanca = :idAseguramientoLineaBlanca) AND " +
            "(:keyword IS NULL OR UPPER(tabla_aseguramientos_lineas_blancas.numero_seguro_aseguramiento_linea_blanca) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idEquipoIngeniero IS NULL OR tabla_aseguramientos_lineas_blancas.id_equipo_ingeniero = :idEquipoIngeniero) " +
            "ORDER BY CASE WHEN :orderBy = 'idAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'idAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_iniciacion_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_iniciacion_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_finalizacion_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.fecha_h_m_s_finalizacion_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_aseguradora END ASC, " +
            "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_aseguradora END DESC, " +
            "CASE WHEN :orderBy = 'numeroSeguroAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.numero_seguro_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'numeroSeguroAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.numero_seguro_aseguramiento_linea_blanca END DESC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.id_tipo_responsabilidad_contractual END ASC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.id_tipo_responsabilidad_contractual END DESC, " +
            "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoLineaBlanca' AND :orderMode = 'ASC' THEN tabla_aseguramientos_lineas_blancas.valor_solicitado_aseguramiento_linea_blanca END ASC, " +
            "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoLineaBlanca' AND :orderMode = 'DESC' THEN tabla_aseguramientos_lineas_blancas.valor_solicitado_aseguramiento_linea_blanca END DESC", nativeQuery = true)
    Slice<AseguramientoLineaBlanca> findAllAseguramientosLineasBlancasPag(Pageable pageable, @Param("idAseguramientoLineaBlanca") Long idAseguramientoLineaBlanca, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<AseguramientoLineaBlanca> findByIdAseguramientoLineaBlanca(Long idAseguramientoLineaBlanca);
    
    //BUSQUEDA UNITARIA POR NUMERO DE SEGURO (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO CON EL MISMO NUMERO DE SEGURO):
    AseguramientoLineaBlanca findByNumeroSeguroAseguramientoLineaBlanca(String numeroSeguroAseguramientoLineaBlanca);
    
    @Query(value = "SELECT MAX(id_aseguramiento_linea_blanca) FROM tabla_aseguramientos_lineas_blancas", nativeQuery = true)
    Long findMaxIdAseguramientoLineaBlanca();
}
