//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialDiagnosticoInicialSeleccMttoEquipIng;
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
public interface HistorialDiagnosticoInicialSeleccMttoEquipIngRepository extends JpaRepository<HistorialDiagnosticoInicialSeleccMttoEquipIng, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + [FILTER_FIELD] + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing " +
            "WHERE (:idHistorialDiagnosticoInicialSeleccMttoEquipIng IS NULL OR tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.id_historial_diagnostico_inicial_selecc_mtto_equip_ing = :idHistorialDiagnosticoInicialSeleccMttoEquipIng) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.num_reg_historial_diagnostico_inicial_selecc_mtto_equip_ing) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialDiagnosticoInicialSeleccMttoEquipIng") Long idHistorialDiagnosticoInicialSeleccMttoEquipIng, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.* FROM tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing " +
            "WHERE (:idHistorialDiagnosticoInicialSeleccMttoEquipIng IS NULL OR tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.id_historial_diagnostico_inicial_selecc_mtto_equip_ing = :idHistorialDiagnosticoInicialSeleccMttoEquipIng) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.num_reg_historial_diagnostico_inicial_selecc_mtto_equip_ing) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.id_historial_diagnostico_inicial_selecc_mtto_equip_ing END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.id_historial_diagnostico_inicial_selecc_mtto_equip_ing END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.num_reg_historial_diagnostico_inicial_selecc_mtto_equip_ing END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.num_reg_historial_diagnostico_inicial_selecc_mtto_equip_ing END DESC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.nombre_archivo_documento_anexo_hist_diag_inic_selecc_mtto_equip_ing, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.nombre_archivo_documento_anexo_hist_diag_inic_selecc_mtto_equip_ing, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.descripcion_objetivo_historial_diagnostico_inicial_selecc_mtto_equip_ing, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.descripcion_objetivo_historial_diagnostico_inicial_selecc_mtto_equip_ing, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialDiagnosticoInicialSeleccMttoEquipIng> findAllHistorialesDiagnosticosInicialesSeleccMttoEquipIng(@Param("idHistorialDiagnosticoInicialSeleccMttoEquipIng") Long idHistorialDiagnosticoInicialSeleccMttoEquipIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.* FROM tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing " +
            "WHERE (:idHistorialDiagnosticoInicialSeleccMttoEquipIng IS NULL OR tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.id_historial_diagnostico_inicial_selecc_mtto_equip_ing = :idHistorialDiagnosticoInicialSeleccMttoEquipIng) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.num_reg_historial_diagnostico_inicial_selecc_mtto_equip_ing) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.id_historial_diagnostico_inicial_selecc_mtto_equip_ing END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.id_historial_diagnostico_inicial_selecc_mtto_equip_ing END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.num_reg_historial_diagnostico_inicial_selecc_mtto_equip_ing END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.num_reg_historial_diagnostico_inicial_selecc_mtto_equip_ing END DESC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.nombre_archivo_documento_anexo_hist_diag_inic_selecc_mtto_equip_ing, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoHistDiagInicSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.nombre_archivo_documento_anexo_hist_diag_inic_selecc_mtto_equip_ing, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.descripcion_objetivo_historial_diagnostico_inicial_selecc_mtto_equip_ing, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionObjetivoHistorialDiagnosticoInicialSeleccMttoEquipIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing.descripcion_objetivo_historial_diagnostico_inicial_selecc_mtto_equip_ing, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialDiagnosticoInicialSeleccMttoEquipIng> findAllHistorialesDiagnosticosInicialesSeleccMttoEquipIngPag(Pageable pageable, @Param("idHistorialDiagnosticoInicialSeleccMttoEquipIng") Long idHistorialDiagnosticoInicialSeleccMttoEquipIng, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialDiagnosticoInicialSeleccMttoEquipIng> findByIdHistorialDiagnosticoInicialSeleccMttoEquipIng(Long idHistorialDiagnosticoInicialSeleccMttoEquipIng);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialDiagnosticoInicialSeleccMttoEquipIng findByNumRegHistorialDiagnosticoInicialSeleccMttoEquipIng(String numRegHistorialDiagnosticoInicialSeleccMttoEquipIng);
    
    @Query(value = "SELECT MAX(id_historial_diagnostico_inicial_selecc_mtto_equip_ing) FROM tabla_historial_diagnosticos_iniciales_selecc_mttos_equip_ing", nativeQuery = true)
    Long findMaxIdHistorialDiagnosticoInicialSeleccMttoEquipIng();
}
