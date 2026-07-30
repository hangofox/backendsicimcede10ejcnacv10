//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAdqPapeleria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 10/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialProyeccionAnualAdqPapeleriaRepository extends JpaRepository<HistorialProyeccionAnualAdqPapeleria, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + IDUNIDADMILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_proyecciones_anuales_adq_papelerias " +
          "WHERE (:idHistorialProyeccionAnualAdqPapeleria IS NULL OR tabla_historial_proyecciones_anuales_adq_papelerias.id_historial_proyeccion_anual_adq_papeleria = :idHistorialProyeccionAnualAdqPapeleria) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_adq_papelerias.num_reg_historial_proyeccion_anual_adq_papeleria) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialProyeccionAnualAdqPapeleria") Long idHistorialProyeccionAnualAdqPapeleria, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_adq_papelerias.* FROM tabla_historial_proyecciones_anuales_adq_papelerias " +
          "WHERE (:idHistorialProyeccionAnualAdqPapeleria IS NULL OR tabla_historial_proyecciones_anuales_adq_papelerias.id_historial_proyeccion_anual_adq_papeleria = :idHistorialProyeccionAnualAdqPapeleria) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_adq_papelerias.num_reg_historial_proyeccion_anual_adq_papeleria) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.id_historial_proyeccion_anual_adq_papeleria END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.id_historial_proyeccion_anual_adq_papeleria END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.num_reg_historial_proyeccion_anual_adq_papeleria END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.num_reg_historial_proyeccion_anual_adq_papeleria END DESC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.valor_contrato_historial_proyeccion_anual_adq_papeleria END ASC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.valor_contrato_historial_proyeccion_anual_adq_papeleria END DESC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyAnAdqPap' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.numero_rubro_presupuestal_hist_proy_an_adq_pap END ASC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyAnAdqPap' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.numero_rubro_presupuestal_hist_proy_an_adq_pap END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAdqPap' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_contrat_hist_proy_an_adq_pap, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAdqPap' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_contrat_hist_proy_an_adq_pap, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_cotiz_hist_proy_an_adq_pap, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_cotiz_hist_proy_an_adq_pap, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_pl_nec_hist_proy_an_adq_pap, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_pl_nec_hist_proy_an_adq_pap, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialProyeccionAnualAdqPapeleria> findAllHistorialesProyeccionesAnualesAdqPapelerias(@Param("idHistorialProyeccionAnualAdqPapeleria") Long idHistorialProyeccionAnualAdqPapeleria, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_adq_papelerias.* FROM tabla_historial_proyecciones_anuales_adq_papelerias " +
          "WHERE (:idHistorialProyeccionAnualAdqPapeleria IS NULL OR tabla_historial_proyecciones_anuales_adq_papelerias.id_historial_proyeccion_anual_adq_papeleria = :idHistorialProyeccionAnualAdqPapeleria) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_adq_papelerias.num_reg_historial_proyeccion_anual_adq_papeleria) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.id_historial_proyeccion_anual_adq_papeleria END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.id_historial_proyeccion_anual_adq_papeleria END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.num_reg_historial_proyeccion_anual_adq_papeleria END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.num_reg_historial_proyeccion_anual_adq_papeleria END DESC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.valor_contrato_historial_proyeccion_anual_adq_papeleria END ASC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAdqPapeleria' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.valor_contrato_historial_proyeccion_anual_adq_papeleria END DESC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyAnAdqPap' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.numero_rubro_presupuestal_hist_proy_an_adq_pap END ASC, " +
          "CASE WHEN :orderBy = 'numeroRubroPresupuestalHistProyAnAdqPap' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_papelerias.numero_rubro_presupuestal_hist_proy_an_adq_pap END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAdqPap' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_contrat_hist_proy_an_adq_pap, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAdqPap' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_contrat_hist_proy_an_adq_pap, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_cotiz_hist_proy_an_adq_pap, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAdqPap' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_cotiz_hist_proy_an_adq_pap, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_pl_nec_hist_proy_an_adq_pap, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoPlNecHistProyAnAdqPap' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_papelerias.nombre_archivo_documento_anexo_pl_nec_hist_proy_an_adq_pap, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialProyeccionAnualAdqPapeleria> findAllHistorialesProyeccionesAnualesAdqPapeleriasPag(Pageable pageable, @Param("idHistorialProyeccionAnualAdqPapeleria") Long idHistorialProyeccionAnualAdqPapeleria, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialProyeccionAnualAdqPapeleria> findByIdHistorialProyeccionAnualAdqPapeleria(Long idHistorialProyeccionAnualAdqPapeleria);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialProyeccionAnualAdqPapeleria findByNumRegHistorialProyeccionAnualAdqPapeleria(String numRegHistorialProyeccionAnualAdqPapeleria);
    
    @Query(value = "SELECT MAX(id_historial_proyeccion_anual_adq_papeleria) FROM tabla_historial_proyecciones_anuales_adq_papelerias", nativeQuery = true)
    Long findMaxIdHistorialProyeccionAnualAdqPapeleria();
}
