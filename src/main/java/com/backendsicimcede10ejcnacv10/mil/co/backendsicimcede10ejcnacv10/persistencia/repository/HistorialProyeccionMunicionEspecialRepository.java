//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionMunicionEspecial;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialProyeccionMunicionEspecialRepository extends JpaRepository<HistorialProyeccionMunicionEspecial, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID MUNICION ESPECIAL + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_proyecciones_municiones_especiales " +
          "WHERE (:idHistorialProyeccionMunicionEspecial IS NULL OR tabla_historial_proyecciones_municiones_especiales.id_historial_proyeccion_municion_especial = :idHistorialProyeccionMunicionEspecial) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_municiones_especiales.num_reg_historial_proyeccion_municion_especial) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialProyeccionMunicionEspecial") Long idHistorialProyeccionMunicionEspecial, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_proyecciones_municiones_especiales.* FROM tabla_historial_proyecciones_municiones_especiales " +
          "WHERE (:idHistorialProyeccionMunicionEspecial IS NULL OR tabla_historial_proyecciones_municiones_especiales.id_historial_proyeccion_municion_especial = :idHistorialProyeccionMunicionEspecial) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_municiones_especiales.num_reg_historial_proyeccion_municion_especial) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.id_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.id_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.num_reg_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.num_reg_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.valor_total_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.valor_total_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyMunEsp' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.numero_rubro_presupuestal_hist_proy_mun_esp END ASC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyMunEsp' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.numero_rubro_presupuestal_hist_proy_mun_esp END DESC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.nombre_bien_o_servicio_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.nombre_bien_o_servicio_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'cantidadSolicitadaHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.cantidad_solicitada_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'cantidadSolicitadaHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.cantidad_solicitada_historial_proyeccion_municion_especial END DESC", nativeQuery = true)
    List<HistorialProyeccionMunicionEspecial> findAllHistorialesProyeccionesMunicionesEspeciales(@Param("idHistorialProyeccionMunicionEspecial") Long idHistorialProyeccionMunicionEspecial, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_proyecciones_municiones_especiales.* FROM tabla_historial_proyecciones_municiones_especiales " +
          "WHERE (:idHistorialProyeccionMunicionEspecial IS NULL OR tabla_historial_proyecciones_municiones_especiales.id_historial_proyeccion_municion_especial = :idHistorialProyeccionMunicionEspecial) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_municiones_especiales.num_reg_historial_proyeccion_municion_especial) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.id_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.id_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.num_reg_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.num_reg_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.valor_total_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.valor_total_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyMunEsp' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.numero_rubro_presupuestal_hist_proy_mun_esp END ASC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyMunEsp' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.numero_rubro_presupuestal_hist_proy_mun_esp END DESC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.nombre_bien_o_servicio_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'nombreBienOServicioHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.nombre_bien_o_servicio_historial_proyeccion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'cantidadSolicitadaHistorialProyeccionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_municiones_especiales.cantidad_solicitada_historial_proyeccion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'cantidadSolicitadaHistorialProyeccionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_municiones_especiales.cantidad_solicitada_historial_proyeccion_municion_especial END DESC", nativeQuery = true)
    Slice<HistorialProyeccionMunicionEspecial> findAllHistorialesProyeccionesMunicionesEspecialesPag(Pageable pageable, @Param("idHistorialProyeccionMunicionEspecial") Long idHistorialProyeccionMunicionEspecial, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialProyeccionMunicionEspecial> findByIdHistorialProyeccionMunicionEspecial(Long idHistorialProyeccionMunicionEspecial);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialProyeccionMunicionEspecial findByNumRegHistorialProyeccionMunicionEspecial(String numRegHistorialProyeccionMunicionEspecial);
    
    @Query(value = "SELECT MAX(id_historial_proyeccion_municion_especial) FROM tabla_historial_proyecciones_municiones_especiales", nativeQuery = true)
    Long findMaxIdHistorialProyeccionMunicionEspecial();
}
