//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoRequerimientoApoyoAtencionPrevencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface TipoRequerimientoApoyoAtencionPrevencionRepository extends JpaRepository<TipoRequerimientoApoyoAtencionPrevencion,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_requerimientos_apoyos_atencion_prevencion WHERE (:idTipoRequerimientoApoyoAtencionPrevencion IS NULL OR id_tipo_requerimiento_apoyo_atencion_prevencion = :idTipoRequerimientoApoyoAtencionPrevencion) AND (:keyword IS NULL OR UPPER(nombre_tipo_requerimiento_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoRequerimientoApoyoAtencionPrevencion") Long idTipoRequerimientoApoyoAtencionPrevencion, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_requerimientos_apoyos_atencion_prevencion WHERE (:idTipoRequerimientoApoyoAtencionPrevencion IS NULL OR id_tipo_requerimiento_apoyo_atencion_prevencion = :idTipoRequerimientoApoyoAtencionPrevencion) AND (:keyword IS NULL OR UPPER(nombre_tipo_requerimiento_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN id_tipo_requerimiento_apoyo_atencion_prevencion END ASC, CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN id_tipo_requerimiento_apoyo_atencion_prevencion END DESC, CASE WHEN :orderBy = 'nombreTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN nombre_tipo_requerimiento_apoyo_atencion_prevencion END ASC, CASE WHEN :orderBy = 'nombreTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN nombre_tipo_requerimiento_apoyo_atencion_prevencion END DESC", nativeQuery = true)
    List<TipoRequerimientoApoyoAtencionPrevencion> findAllTiposRequerimientosApoyosAtencionPrevencion(@Param("idTipoRequerimientoApoyoAtencionPrevencion") Long idTipoRequerimientoApoyoAtencionPrevencion, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_requerimientos_apoyos_atencion_prevencion WHERE (:idTipoRequerimientoApoyoAtencionPrevencion IS NULL OR id_tipo_requerimiento_apoyo_atencion_prevencion = :idTipoRequerimientoApoyoAtencionPrevencion) AND (:keyword IS NULL OR UPPER(nombre_tipo_requerimiento_apoyo_atencion_prevencion) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN id_tipo_requerimiento_apoyo_atencion_prevencion END ASC, CASE WHEN :orderBy = 'idTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN id_tipo_requerimiento_apoyo_atencion_prevencion END DESC, CASE WHEN :orderBy = 'nombreTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'ASC' THEN nombre_tipo_requerimiento_apoyo_atencion_prevencion END ASC, CASE WHEN :orderBy = 'nombreTipoRequerimientoApoyoAtencionPrevencion' AND :orderMode = 'DESC' THEN nombre_tipo_requerimiento_apoyo_atencion_prevencion END DESC", nativeQuery = true)
    Slice<TipoRequerimientoApoyoAtencionPrevencion> findAllTiposRequerimientosApoyosAtencionPrevencionPag(Pageable pageable, @Param("idTipoRequerimientoApoyoAtencionPrevencion") Long idTipoRequerimientoApoyoAtencionPrevencion, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoRequerimientoApoyoAtencionPrevencion> findByIdTipoRequerimientoApoyoAtencionPrevencion(Long idTipoRequerimientoApoyoAtencionPrevencion);
    
    TipoRequerimientoApoyoAtencionPrevencion findByNombreTipoRequerimientoApoyoAtencionPrevencion(String nombreTipoRequerimientoApoyoAtencionPrevencion);
    
    @Query(value = "SELECT MAX(id_tipo_requerimiento_apoyo_atencion_prevencion) FROM tabla_tipos_requerimientos_apoyos_atencion_prevencion", nativeQuery = true)
    Long findMaxIdTipoRequerimientoApoyoAtencionPrevencion();
}
