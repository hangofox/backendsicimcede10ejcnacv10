//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProyeccionAnualAseoLimpInfraest;
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
public interface HistorialProyeccionAnualAseoLimpInfraestRepository extends JpaRepository<HistorialProyeccionAnualAseoLimpInfraest, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_proyecciones_anuales_aseos_limp_infraest " +
          "WHERE (:idHistorialProyeccionAnualAseoLimpInfraest IS NULL OR tabla_historial_proyecciones_anuales_aseos_limp_infraest.id_historial_proyeccion_anual_aseo_limp_infraest = :idHistorialProyeccionAnualAseoLimpInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_aseos_limp_infraest.num_reg_historial_proyeccion_anual_aseo_limp_infraest) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialProyeccionAnualAseoLimpInfraest") Long idHistorialProyeccionAnualAseoLimpInfraest, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_aseos_limp_infraest.* FROM tabla_historial_proyecciones_anuales_aseos_limp_infraest " +
          "WHERE (:idHistorialProyeccionAnualAseoLimpInfraest IS NULL OR tabla_historial_proyecciones_anuales_aseos_limp_infraest.id_historial_proyeccion_anual_aseo_limp_infraest = :idHistorialProyeccionAnualAseoLimpInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_aseos_limp_infraest.num_reg_historial_proyeccion_anual_aseo_limp_infraest) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.id_historial_proyeccion_anual_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.id_historial_proyeccion_anual_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.num_reg_historial_proyeccion_anual_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.num_reg_historial_proyeccion_anual_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.valor_contrato_historial_proyeccion_anual_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.valor_contrato_historial_proyeccion_anual_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'numeroPersonalHumanoHistProyAnAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.numero_personal_humano_hist_proy_an_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'numeroPersonalHumanoHistProyAnAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.numero_personal_humano_hist_proy_an_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_contrat_hist_proy_an_aseo_limp_infraest, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_contrat_hist_proy_an_aseo_limp_infraest, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_cotiz_hist_proy_an_aseo_limp_infraest, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_cotiz_hist_proy_an_aseo_limp_infraest, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialProyeccionAnualAseoLimpInfraest> findAllHistorialesProyeccionesAnualesAseoLimpInfraest(@Param("idHistorialProyeccionAnualAseoLimpInfraest") Long idHistorialProyeccionAnualAseoLimpInfraest, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_proyecciones_anuales_aseos_limp_infraest.* FROM tabla_historial_proyecciones_anuales_aseos_limp_infraest " +
          "WHERE (:idHistorialProyeccionAnualAseoLimpInfraest IS NULL OR tabla_historial_proyecciones_anuales_aseos_limp_infraest.id_historial_proyeccion_anual_aseo_limp_infraest = :idHistorialProyeccionAnualAseoLimpInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proyecciones_anuales_aseos_limp_infraest.num_reg_historial_proyeccion_anual_aseo_limp_infraest) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.id_historial_proyeccion_anual_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.id_historial_proyeccion_anual_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.num_reg_historial_proyeccion_anual_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.num_reg_historial_proyeccion_anual_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.valor_contrato_historial_proyeccion_anual_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorContratoHistorialProyeccionAnualAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.valor_contrato_historial_proyeccion_anual_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'numeroPersonalHumanoHistProyAnAseoLimpInfraest' AND :orderMode = 'ASC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.numero_personal_humano_hist_proy_an_aseo_limp_infraest END ASC, " +
          "CASE WHEN :orderBy = 'numeroPersonalHumanoHistProyAnAseoLimpInfraest' AND :orderMode = 'DESC' THEN tabla_historial_proyecciones_anuales_aseos_limp_infraest.numero_personal_humano_hist_proy_an_aseo_limp_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_contrat_hist_proy_an_aseo_limp_infraest, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratHistProyAnAseoLimpInfraest' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_contrat_hist_proy_an_aseo_limp_infraest, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_cotiz_hist_proy_an_aseo_limp_infraest, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoCotizHistProyAnAseoLimpInfraest' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_proyecciones_anuales_aseos_limp_infraest.nombre_archivo_documento_anexo_cotiz_hist_proy_an_aseo_limp_infraest, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialProyeccionAnualAseoLimpInfraest> findAllHistorialesProyeccionesAnualesAseoLimpInfraestPag(Pageable pageable, @Param("idHistorialProyeccionAnualAseoLimpInfraest") Long idHistorialProyeccionAnualAseoLimpInfraest, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialProyeccionAnualAseoLimpInfraest> findByIdHistorialProyeccionAnualAseoLimpInfraest(Long idHistorialProyeccionAnualAseoLimpInfraest);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialProyeccionAnualAseoLimpInfraest findByNumRegHistorialProyeccionAnualAseoLimpInfraest(String numRegHistorialProyeccionAnualAseoLimpInfraest);
    
    @Query(value = "SELECT MAX(id_historial_proyeccion_anual_aseo_limp_infraest) FROM tabla_historial_proyecciones_anuales_aseos_limp_infraest", nativeQuery = true)
    Long findMaxIdHistorialProyeccionAnualAseoLimpInfraest();
}
