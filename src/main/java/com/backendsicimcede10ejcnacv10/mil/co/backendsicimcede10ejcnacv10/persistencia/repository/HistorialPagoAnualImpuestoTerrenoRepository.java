//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialPagoAnualImpuestoTerreno;
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
public interface HistorialPagoAnualImpuestoTerrenoRepository extends JpaRepository<HistorialPagoAnualImpuestoTerreno, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID TERRENO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_pagos_anuales_impuestos_terrenos " +
          "WHERE (:idHistorialPagoAnualImpuestoTerreno IS NULL OR tabla_historial_pagos_anuales_impuestos_terrenos.id_historial_pago_anual_impuesto_terreno = :idHistorialPagoAnualImpuestoTerreno) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.num_reg_historial_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.nombre_entidad_institucional_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.numero_factura_historial_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialPagoAnualImpuestoTerreno") Long idHistorialPagoAnualImpuestoTerreno, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_pagos_anuales_impuestos_terrenos.* FROM tabla_historial_pagos_anuales_impuestos_terrenos " +
          "WHERE (:idHistorialPagoAnualImpuestoTerreno IS NULL OR tabla_historial_pagos_anuales_impuestos_terrenos.id_historial_pago_anual_impuesto_terreno = :idHistorialPagoAnualImpuestoTerreno) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.num_reg_historial_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.nombre_entidad_institucional_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.numero_factura_historial_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.id_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.id_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.num_reg_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.num_reg_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.valor_total_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.valor_total_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.fecha_h_m_s_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.fecha_h_m_s_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.nombre_entidad_institucional_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.nombre_entidad_institucional_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroFacturaHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_factura_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroFacturaHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_factura_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'siONoReduccionHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.si_o_no_reduccion_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'siONoReduccionHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.si_o_no_reduccion_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeReduccHistPagAnImpTerr' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_porcentaje_reducc_hist_pag_an_imp_terr END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeReduccHistPagAnImpTerr' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_porcentaje_reducc_hist_pag_an_imp_terr END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnImpTerr' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_pagos_anuales_impuestos_terrenos.nombre_archivo_documento_anexo_fact_hist_pag_an_imp_terr, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnImpTerr' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_pagos_anuales_impuestos_terrenos.nombre_archivo_documento_anexo_fact_hist_pag_an_imp_terr, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialPagoAnualImpuestoTerreno> findAllHistorialesPagosAnualesImpuestosTerrenos(@Param("idHistorialPagoAnualImpuestoTerreno") Long idHistorialPagoAnualImpuestoTerreno, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_pagos_anuales_impuestos_terrenos.* FROM tabla_historial_pagos_anuales_impuestos_terrenos " +
          "WHERE (:idHistorialPagoAnualImpuestoTerreno IS NULL OR tabla_historial_pagos_anuales_impuestos_terrenos.id_historial_pago_anual_impuesto_terreno = :idHistorialPagoAnualImpuestoTerreno) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.num_reg_historial_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.nombre_entidad_institucional_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_pagos_anuales_impuestos_terrenos.numero_factura_historial_pago_anual_impuesto_terreno) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.id_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.id_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.num_reg_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.num_reg_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.valor_total_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'valorTotalHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.valor_total_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.fecha_h_m_s_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.fecha_h_m_s_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.nombre_entidad_institucional_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'nombreEntidadInstitucionalPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.nombre_entidad_institucional_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroFacturaHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_factura_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroFacturaHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_factura_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'siONoReduccionHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.si_o_no_reduccion_historial_pago_anual_impuesto_terreno END ASC, " +
          "CASE WHEN :orderBy = 'siONoReduccionHistorialPagoAnualImpuestoTerreno' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.si_o_no_reduccion_historial_pago_anual_impuesto_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeReduccHistPagAnImpTerr' AND :orderMode = 'ASC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_porcentaje_reducc_hist_pag_an_imp_terr END ASC, " +
          "CASE WHEN :orderBy = 'numeroPorcentajeReduccHistPagAnImpTerr' AND :orderMode = 'DESC' THEN tabla_historial_pagos_anuales_impuestos_terrenos.numero_porcentaje_reducc_hist_pag_an_imp_terr END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnImpTerr' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_pagos_anuales_impuestos_terrenos.nombre_archivo_documento_anexo_fact_hist_pag_an_imp_terr, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoFactHistPagAnImpTerr' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_pagos_anuales_impuestos_terrenos.nombre_archivo_documento_anexo_fact_hist_pag_an_imp_terr, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialPagoAnualImpuestoTerreno> findAllHistorialesPagosAnualesImpuestosTerminosPag(Pageable pageable, @Param("idHistorialPagoAnualImpuestoTerreno") Long idHistorialPagoAnualImpuestoTerreno, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialPagoAnualImpuestoTerreno> findByIdHistorialPagoAnualImpuestoTerreno(Long idHistorialPagoAnualImpuestoTerreno);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialPagoAnualImpuestoTerreno findByNumRegHistorialPagoAnualImpuestoTerreno(String numRegHistorialPagoAnualImpuestoTerreno);
    
    @Query(value = "SELECT MAX(id_historial_pago_anual_impuesto_terreno) FROM tabla_historial_pagos_anuales_impuestos_terrenos", nativeQuery = true)
    Long findMaxIdHistorialPagoAnualImpuestoTerreno();
}
