//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoPersonalApoyo;
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
public interface TipoPersonalApoyoRepository extends JpaRepository<TipoPersonalApoyo,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_personal_apoyos WHERE (:idTipoPersonalApoyo IS NULL OR id_tipo_personal_apoyo = :idTipoPersonalApoyo) AND (:keyword IS NULL OR UPPER(nombre_tipo_personal_apoyo) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoPersonalApoyo") Long idTipoPersonalApoyo, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_personal_apoyos WHERE (:idTipoPersonalApoyo IS NULL OR id_tipo_personal_apoyo = :idTipoPersonalApoyo) AND (:keyword IS NULL OR UPPER(nombre_tipo_personal_apoyo) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoPersonalApoyo' AND :orderMode = 'ASC' THEN id_tipo_personal_apoyo END ASC, CASE WHEN :orderBy = 'idTipoPersonalApoyo' AND :orderMode = 'DESC' THEN id_tipo_personal_apoyo END DESC, CASE WHEN :orderBy = 'nombreTipoPersonalApoyo' AND :orderMode = 'ASC' THEN nombre_tipo_personal_apoyo END ASC, CASE WHEN :orderBy = 'nombreTipoPersonalApoyo' AND :orderMode = 'DESC' THEN nombre_tipo_personal_apoyo END DESC", nativeQuery = true)
    List<TipoPersonalApoyo> findAllTiposPersonalApoyos(@Param("idTipoPersonalApoyo") Long idTipoPersonalApoyo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_personal_apoyos WHERE (:idTipoPersonalApoyo IS NULL OR id_tipo_personal_apoyo = :idTipoPersonalApoyo) AND (:keyword IS NULL OR UPPER(nombre_tipo_personal_apoyo) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoPersonalApoyo' AND :orderMode = 'ASC' THEN id_tipo_personal_apoyo END ASC, CASE WHEN :orderBy = 'idTipoPersonalApoyo' AND :orderMode = 'DESC' THEN id_tipo_personal_apoyo END DESC, CASE WHEN :orderBy = 'nombreTipoPersonalApoyo' AND :orderMode = 'ASC' THEN nombre_tipo_personal_apoyo END ASC, CASE WHEN :orderBy = 'nombreTipoPersonalApoyo' AND :orderMode = 'DESC' THEN nombre_tipo_personal_apoyo END DESC", nativeQuery = true)
    Slice<TipoPersonalApoyo> findAllTiposPersonalApoyosPag(Pageable pageable, @Param("idTipoPersonalApoyo") Long idTipoPersonalApoyo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoPersonalApoyo> findByIdTipoPersonalApoyo(Long idTipoPersonalApoyo);
    
    TipoPersonalApoyo findByNombreTipoPersonalApoyo(String nombreTipoPersonalApoyo);
    
    @Query(value = "SELECT MAX(id_tipo_personal_apoyo) FROM tabla_tipos_personal_apoyos", nativeQuery = true)
    Long findMaxIdTipoPersonalApoyo();
}
