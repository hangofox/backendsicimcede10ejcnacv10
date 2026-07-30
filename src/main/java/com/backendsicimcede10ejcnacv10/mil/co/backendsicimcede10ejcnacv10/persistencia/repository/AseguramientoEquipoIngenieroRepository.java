//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.AseguramientoEquipoIngeniero;
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
public interface AseguramientoEquipoIngenieroRepository extends JpaRepository<AseguramientoEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ID EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_aseguramientos_equipos_ingenieros " +
          "WHERE (:idAseguramientoEquipoIngeniero IS NULL OR tabla_aseguramientos_equipos_ingenieros.id_aseguramiento_equipo_ingeniero = :idAseguramientoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_aseguramientos_equipos_ingenieros.numero_seguro_aseguramiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_aseguramientos_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero)", nativeQuery = true)
    Long findTotalRegistros(@Param("idAseguramientoEquipoIngeniero") Long idAseguramientoEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero);
    
    @Query(value = "SELECT tabla_aseguramientos_equipos_ingenieros.* FROM tabla_aseguramientos_equipos_ingenieros " +
          "WHERE (:idAseguramientoEquipoIngeniero IS NULL OR tabla_aseguramientos_equipos_ingenieros.id_aseguramiento_equipo_ingeniero = :idAseguramientoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_aseguramientos_equipos_ingenieros.numero_seguro_aseguramiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_aseguramientos_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_iniciacion_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_iniciacion_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_finalizacion_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_finalizacion_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'numeroSeguroAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.numero_seguro_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numeroSeguroAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.numero_seguro_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.valor_solicitado_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.valor_solicitado_aseguramiento_equipo_ingeniero END DESC", nativeQuery = true)
    List<AseguramientoEquipoIngeniero> findAllAseguramientosEquiposIngenieros(@Param("idAseguramientoEquipoIngeniero") Long idAseguramientoEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_aseguramientos_equipos_ingenieros.* FROM tabla_aseguramientos_equipos_ingenieros " +
          "WHERE (:idAseguramientoEquipoIngeniero IS NULL OR tabla_aseguramientos_equipos_ingenieros.id_aseguramiento_equipo_ingeniero = :idAseguramientoEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_aseguramientos_equipos_ingenieros.numero_seguro_aseguramiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idEquipoIngeniero IS NULL OR tabla_aseguramientos_equipos_ingenieros.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_iniciacion_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_iniciacion_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_finalizacion_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.fecha_h_m_s_finalizacion_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.id_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'numeroSeguroAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.numero_seguro_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numeroSeguroAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.numero_seguro_aseguramiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_aseguramientos_equipos_ingenieros.valor_solicitado_aseguramiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoAseguramientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_aseguramientos_equipos_ingenieros.valor_solicitado_aseguramiento_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<AseguramientoEquipoIngeniero> findAllAseguramientosEquiposIngenierosPag(Pageable pageable, @Param("idAseguramientoEquipoIngeniero") Long idAseguramientoEquipoIngeniero, @Param("keyword") String keyword, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<AseguramientoEquipoIngeniero> findByIdAseguramientoEquipoIngeniero(Long idAseguramientoEquipoIngeniero);
    
    //BUSQUEDA UNITARIA POR NUMERO DE SEGURO (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO CON EL MISMO NUMERO DE SEGURO):
    AseguramientoEquipoIngeniero findByNumeroSeguroAseguramientoEquipoIngeniero(String numeroSeguroAseguramientoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_aseguramiento_equipo_ingeniero) FROM tabla_aseguramientos_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdAseguramientoEquipoIngeniero();
}
