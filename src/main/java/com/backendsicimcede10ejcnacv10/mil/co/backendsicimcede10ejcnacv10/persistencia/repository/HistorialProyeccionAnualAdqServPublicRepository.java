//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAdqServPublic;
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
public interface HistorialProyeccionAnualAdqServPublicRepository extends JpaRepository<HistorialProyeccionAnualAdqServPublic, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + IDINFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_proyecciones_anuales_adq_serv_public " +
          "WHERE (:idHistorialProyeccionAnualAdqServPublic IS NULL OR tabla_historial_proyecciones_anuales_adq_serv_public.id_historial_proyeccion_anual_adq_serv_public = :idHistorialProyeccionAnualAdqServPublic) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_adq_serv_public.num_reg_historial_proyeccion_anual_adq_serv_public) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialProyeccionAnualAdqServPublic") Long idHistorialProyeccionAnualAdqServPublic, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_adq_serv_public.* FROM tabla_historial_proyecciones_anuales_adq_serv_public " +
          "WHERE (:idHistorialProyeccionAnualAdqServPublic IS NULL OR tabla_historial_proyecciones_anuales_adq_serv_public.id_historial_proyeccion_anual_adq_serv_public = :idHistorialProyeccionAnualAdqServPublic) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_adq_serv_public.num_reg_historial_proyeccion_anual_adq_serv_public) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.id_historial_proyeccion_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.id_historial_proyeccion_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.num_reg_historial_proyeccion_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.num_reg_historial_proyeccion_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.valor_total_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.valor_total_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.fecha_h_m_s_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.fecha_h_m_s_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'telefonoHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.telefono_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'telefonoHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.telefono_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'movilHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.movil_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'movilHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.movil_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_serv_public.nombre_archivo_documento_anexo_fact_hist_pag_an_adq_serv_public, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_serv_public.nombre_archivo_documento_anexo_fact_hist_pag_an_adq_serv_public, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialProyeccionAnualAdqServPublic> findAllHistorialesProyeccionesAnualesAdqServPublic(@Param("idHistorialProyeccionAnualAdqServPublic") Long idHistorialProyeccionAnualAdqServPublic, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_adq_serv_public.* FROM tabla_historial_proyecciones_anuales_adq_serv_public " +
          "WHERE (:idHistorialProyeccionAnualAdqServPublic IS NULL OR tabla_historial_proyecciones_anuales_adq_serv_public.id_historial_proyeccion_anual_adq_serv_public = :idHistorialProyeccionAnualAdqServPublic) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_adq_serv_public.num_reg_historial_proyeccion_anual_adq_serv_public) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.id_historial_proyeccion_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.id_historial_proyeccion_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.num_reg_historial_proyeccion_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.num_reg_historial_proyeccion_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.valor_total_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.valor_total_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.fecha_h_m_s_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.fecha_h_m_s_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'telefonoHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.telefono_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'telefonoHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.telefono_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'movilHistorialPagoAnualAdqServPublic' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.movil_historial_pago_anual_adq_serv_public END ASC, " +
          "CASE WHEN :orderBy = 'movilHistorialPagoAnualAdqServPublic' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_adq_serv_public.movil_historial_pago_anual_adq_serv_public END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_serv_public.nombre_archivo_documento_anexo_fact_hist_pag_an_adq_serv_public, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnAdqServPublic' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_adq_serv_public.nombre_archivo_documento_anexo_fact_hist_pag_an_adq_serv_public, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialProyeccionAnualAdqServPublic> findAllHistorialesProyeccionesAnualesAdqServPublicPag(Pageable pageable, @Param("idHistorialProyeccionAnualAdqServPublic") Long idHistorialProyeccionAnualAdqServPublic, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialProyeccionAnualAdqServPublic> findByIdHistorialProyeccionAnualAdqServPublic(Long idHistorialProyeccionAnualAdqServPublic);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialProyeccionAnualAdqServPublic findByNumRegHistorialProyeccionAnualAdqServPublic(String numRegHistorialProyeccionAnualAdqServPublic);
    
    @Query(value = "SELECT MAX(id_historial_proyeccion_anual_adq_serv_public) FROM tabla_historial_proyecciones_anuales_adq_serv_public", nativeQuery = true)
    Long findMaxIdHistorialProyeccionAnualAdqServPublic();
}
