//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEntidadInstitucional;
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
public interface TipoEntidadInstitucionalRepository extends JpaRepository<TipoEntidadInstitucional,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_entidades_institucionales WHERE (:idTipoEntidadInstitucional IS NULL OR id_tipo_entidad_institucional = :idTipoEntidadInstitucional) AND (:keyword IS NULL OR UPPER(nombre_tipo_entidad_institucional) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoEntidadInstitucional") Long idTipoEntidadInstitucional, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_entidades_institucionales WHERE (:idTipoEntidadInstitucional IS NULL OR id_tipo_entidad_institucional = :idTipoEntidadInstitucional) AND (:keyword IS NULL OR UPPER(nombre_tipo_entidad_institucional) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN id_tipo_entidad_institucional END ASC, CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN id_tipo_entidad_institucional END DESC, CASE WHEN :orderBy = 'nombreTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN nombre_tipo_entidad_institucional END ASC, CASE WHEN :orderBy = 'nombreTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN nombre_tipo_entidad_institucional END DESC", nativeQuery = true)
    List<TipoEntidadInstitucional> findAllTiposEntidadesInstitucionales(@Param("idTipoEntidadInstitucional") Long idTipoEntidadInstitucional, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_tipos_entidades_institucionales WHERE (:idTipoEntidadInstitucional IS NULL OR id_tipo_entidad_institucional = :idTipoEntidadInstitucional) AND (:keyword IS NULL OR UPPER(nombre_tipo_entidad_institucional) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN id_tipo_entidad_institucional END ASC, CASE WHEN :orderBy = 'idTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN id_tipo_entidad_institucional END DESC, CASE WHEN :orderBy = 'nombreTipoEntidadInstitucional' AND :orderMode = 'ASC' THEN nombre_tipo_entidad_institucional END ASC, CASE WHEN :orderBy = 'nombreTipoEntidadInstitucional' AND :orderMode = 'DESC' THEN nombre_tipo_entidad_institucional END DESC", nativeQuery = true)
    Slice<TipoEntidadInstitucional> findAllTiposEntidadesInstitucionalesPag(Pageable pageable, @Param("idTipoEntidadInstitucional") Long idTipoEntidadInstitucional, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoEntidadInstitucional> findByIdTipoEntidadInstitucional(Long idTipoEntidadInstitucional);
    
    TipoEntidadInstitucional findByNombreTipoEntidadInstitucional(String nombreTipoEntidadInstitucional);
    
    @Query(value = "SELECT MAX(id_tipo_entidad_institucional) FROM tabla_tipos_entidades_institucionales", nativeQuery = true)
    Long findMaxIdTipoEntidadInstitucional();
}
