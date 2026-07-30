//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSoatLineaBlanca;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProyeccionSoatLineaBlancaRepository extends JpaRepository<ProyeccionSoatLineaBlanca, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) FROM tabla_proyecciones_soats_lineas_blancas, tabla_equipos_ingenieros " +
          "WHERE (tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero = tabla_equipos_ingenieros.id_equipo_ingeniero) " +
          "AND (:idProyeccionSoatLineaBlanca IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca = :idProyeccionSoatLineaBlanca) " +
          "AND (:idEquipoIngeniero IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "AND (:valorSolicitadoProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(tabla_proyecciones_soats_lineas_blancas.valor_solicitado_proyeccion_soat_linea_blanca) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualAdqCdoIng || '%')) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_equipos_ingenieros.denominacion_equipo_ingeniero) LIKE UPPER('%' || :keyword || '%') " +
          "OR UPPER(tabla_equipos_ingenieros.numero_placa_equipo_ingeniero) LIKE UPPER('%' || :keyword || '%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionSoatLineaBlanca") Long idProyeccionSoatLineaBlanca, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("valorSolicitadoProyeccionPlanAnualAdqCdoIng") String valorSolicitadoProyeccionPlanAnualAdqCdoIng, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT tabla_proyecciones_soats_lineas_blancas.* FROM tabla_proyecciones_soats_lineas_blancas, tabla_equipos_ingenieros " +
          "WHERE (tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero = tabla_equipos_ingenieros.id_equipo_ingeniero) " +
          "AND (:idProyeccionSoatLineaBlanca IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca = :idProyeccionSoatLineaBlanca) " +
          "AND (:idEquipoIngeniero IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "AND (:valorSolicitadoProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(tabla_proyecciones_soats_lineas_blancas.valor_solicitado_proyeccion_soat_linea_blanca) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualAdqCdoIng || '%')) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_equipos_ingenieros.denominacion_equipo_ingeniero) LIKE UPPER('%' || :keyword || '%') " +
          "OR UPPER(tabla_equipos_ingenieros.numero_placa_equipo_ingeniero) LIKE UPPER('%' || :keyword || '%'))) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionSoatLineaBlanca' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionSoatLineaBlanca' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.valor_solicitado_proyeccion_soat_linea_blanca END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.valor_solicitado_proyeccion_soat_linea_blanca END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionSoatLineaBlanca' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.fecha_h_m_s_proyeccion_soat_linea_blanca END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionSoatLineaBlanca' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.fecha_h_m_s_proyeccion_soat_linea_blanca END DESC", nativeQuery = true)
    List<ProyeccionSoatLineaBlanca> findAllProyeccionesSoatsLineasBlancas(@Param("idProyeccionSoatLineaBlanca") Long idProyeccionSoatLineaBlanca, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("valorSolicitadoProyeccionPlanAnualAdqCdoIng") String valorSolicitadoProyeccionPlanAnualAdqCdoIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT tabla_proyecciones_soats_lineas_blancas.* FROM tabla_proyecciones_soats_lineas_blancas, tabla_equipos_ingenieros " +
          "WHERE (tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero = tabla_equipos_ingenieros.id_equipo_ingeniero) " +
          "AND (:idProyeccionSoatLineaBlanca IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca = :idProyeccionSoatLineaBlanca) " +
          "AND (:idEquipoIngeniero IS NULL OR tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero = :idEquipoIngeniero) " +
          "AND (:valorSolicitadoProyeccionPlanAnualAdqCdoIng IS NULL OR UPPER(tabla_proyecciones_soats_lineas_blancas.valor_solicitado_proyeccion_soat_linea_blanca) LIKE UPPER('%' || :valorSolicitadoProyeccionPlanAnualAdqCdoIng || '%')) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_equipos_ingenieros.denominacion_equipo_ingeniero) LIKE UPPER('%' || :keyword || '%') " +
          "OR UPPER(tabla_equipos_ingenieros.numero_placa_equipo_ingeniero) LIKE UPPER('%' || :keyword || '%'))) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionSoatLineaBlanca' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionSoatLineaBlanca' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.id_proyeccion_soat_linea_blanca END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.valor_solicitado_proyeccion_soat_linea_blanca END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionPlanAnualAdqCdoIng' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.valor_solicitado_proyeccion_soat_linea_blanca END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionSoatLineaBlanca' AND :orderMode = 'ASC' THEN tabla_proyecciones_soats_lineas_blancas.fecha_h_m_s_proyeccion_soat_linea_blanca END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionSoatLineaBlanca' AND :orderMode = 'DESC' THEN tabla_proyecciones_soats_lineas_blancas.fecha_h_m_s_proyeccion_soat_linea_blanca END DESC", nativeQuery = true)
    Slice<ProyeccionSoatLineaBlanca> findAllProyeccionesSoatsLineasBlancasPag(Pageable pageable, @Param("idProyeccionSoatLineaBlanca") Long idProyeccionSoatLineaBlanca, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("valorSolicitadoProyeccionPlanAnualAdqCdoIng") String valorSolicitadoProyeccionPlanAnualAdqCdoIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionSoatLineaBlanca> findByIdProyeccionSoatLineaBlanca(Long idProyeccionSoatLineaBlanca);
    
    @Query(value = "SELECT MAX(id_proyeccion_soat_linea_blanca) FROM tabla_proyecciones_soats_lineas_blancas", nativeQuery = true)
    Long findMaxIdProyeccionSoatLineaBlanca();
}
