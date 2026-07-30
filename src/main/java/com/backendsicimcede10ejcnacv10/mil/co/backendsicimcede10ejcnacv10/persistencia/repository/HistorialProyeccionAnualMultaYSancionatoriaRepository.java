//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualMultaYSancionatoria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 13/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialProyeccionAnualMultaYSancionatoriaRepository extends JpaRepository<HistorialProyeccionAnualMultaYSancionatoria, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_proyecciones_anuales_multas_y_sancionatorias " +
          "WHERE (:idHistorialProyeccionAnualMultaYSancionatoria IS NULL OR tabla_historial_proyecciones_anuales_multas_y_sancionatorias.id_historial_proyeccion_anual_multa_y_sancionatoria = :idHistorialProyeccionAnualMultaYSancionatoria) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.num_reg_historial_proyeccion_anual_multa_y_sancionatoria) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialProyeccionAnualMultaYSancionatoria") Long idHistorialProyeccionAnualMultaYSancionatoria, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_multas_y_sancionatorias.* FROM tabla_historial_proyecciones_anuales_multas_y_sancionatorias " +
          "WHERE (:idHistorialProyeccionAnualMultaYSancionatoria IS NULL OR tabla_historial_proyecciones_anuales_multas_y_sancionatorias.id_historial_proyeccion_anual_multa_y_sancionatoria = :idHistorialProyeccionAnualMultaYSancionatoria) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.num_reg_historial_proyeccion_anual_multa_y_sancionatoria) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.id_historial_proyeccion_anual_multa_y_sancionatoria END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.id_historial_proyeccion_anual_multa_y_sancionatoria END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.num_reg_historial_proyeccion_anual_multa_y_sancionatoria END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.num_reg_historial_proyeccion_anual_multa_y_sancionatoria END DESC, " +
          "CASE WHEN :orderBy = 'numeroAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.numero_auto_ambiental_hist_proy_an_mult_y_sanc END ASC, " +
          "CASE WHEN :orderBy = 'numeroAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.numero_auto_ambiental_hist_proy_an_mult_y_sanc END DESC, " +
          "CASE WHEN :orderBy = 'denominacionAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.denominacion_auto_ambiental_hist_proy_an_mult_y_sanc END ASC, " +
          "CASE WHEN :orderBy = 'denominacionAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.denominacion_auto_ambiental_hist_proy_an_mult_y_sanc END DESC, " +
          "CASE WHEN :orderBy = 'observacionesAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.observaciones_auto_ambiental_hist_proy_an_mult_y_sanc, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'observacionesAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.observaciones_auto_ambiental_hist_proy_an_mult_y_sanc, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.valor_presupuestal_hist_proy_an_mult_y_sanc END ASC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.valor_presupuestal_hist_proy_an_mult_y_sanc END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.nombre_archivo_documento_anexo_hist_proy_an_mult_y_sanc, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.nombre_archivo_documento_anexo_hist_proy_an_mult_y_sanc, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialProyeccionAnualMultaYSancionatoria> findAllHistorialesProyeccionesAnualesMultasYSancionatorias(@Param("idHistorialProyeccionAnualMultaYSancionatoria") Long idHistorialProyeccionAnualMultaYSancionatoria, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_multas_y_sancionatorias.* FROM tabla_historial_proyecciones_anuales_multas_y_sancionatorias " +
          "WHERE (:idHistorialProyeccionAnualMultaYSancionatoria IS NULL OR tabla_historial_proyecciones_anuales_multas_y_sancionatorias.id_historial_proyeccion_anual_multa_y_sancionatoria = :idHistorialProyeccionAnualMultaYSancionatoria) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.num_reg_historial_proyeccion_anual_multa_y_sancionatoria) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.id_historial_proyeccion_anual_multa_y_sancionatoria END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.id_historial_proyeccion_anual_multa_y_sancionatoria END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.num_reg_historial_proyeccion_anual_multa_y_sancionatoria END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualMultaYSancionatoria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.num_reg_historial_proyeccion_anual_multa_y_sancionatoria END DESC, " +
          "CASE WHEN :orderBy = 'numeroAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.numero_auto_ambiental_hist_proy_an_mult_y_sanc END ASC, " +
          "CASE WHEN :orderBy = 'numeroAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.numero_auto_ambiental_hist_proy_an_mult_y_sanc END DESC, " +
          "CASE WHEN :orderBy = 'denominacionAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.denominacion_auto_ambiental_hist_proy_an_mult_y_sanc END ASC, " +
          "CASE WHEN :orderBy = 'denominacionAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.denominacion_auto_ambiental_hist_proy_an_mult_y_sanc END DESC, " +
          "CASE WHEN :orderBy = 'observacionesAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.observaciones_auto_ambiental_hist_proy_an_mult_y_sanc, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'observacionesAutoAmbientalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.observaciones_auto_ambiental_hist_proy_an_mult_y_sanc, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.valor_presupuestal_hist_proy_an_mult_y_sanc END ASC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_multas_y_sancionatorias.valor_presupuestal_hist_proy_an_mult_y_sanc END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistProyAnMultYSanc' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.nombre_archivo_documento_anexo_hist_proy_an_mult_y_sanc, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistProyAnMultYSanc' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_multas_y_sancionatorias.nombre_archivo_documento_anexo_hist_proy_an_mult_y_sanc, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialProyeccionAnualMultaYSancionatoria> findAllHistorialesProyeccionesAnualesMultasYSancionatoriasPag(Pageable pageable, @Param("idHistorialProyeccionAnualMultaYSancionatoria") Long idHistorialProyeccionAnualMultaYSancionatoria, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialProyeccionAnualMultaYSancionatoria> findByIdHistorialProyeccionAnualMultaYSancionatoria(Long idHistorialProyeccionAnualMultaYSancionatoria);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialProyeccionAnualMultaYSancionatoria findByNumRegHistorialProyeccionAnualMultaYSancionatoria(String numRegHistorialProyeccionAnualMultaYSancionatoria);
    
    @Query(value = "SELECT MAX(id_historial_proyeccion_anual_multa_y_sancionatoria) FROM tabla_historial_proyecciones_anuales_multas_y_sancionatorias", nativeQuery = true)
    Long findMaxIdHistorialProyeccionAnualMultaYSancionatoria();
}
