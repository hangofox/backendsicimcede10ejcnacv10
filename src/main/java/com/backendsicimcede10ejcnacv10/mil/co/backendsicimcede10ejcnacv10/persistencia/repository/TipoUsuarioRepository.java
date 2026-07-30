//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_usuarios WHERE (:idTipoUsuario IS NULL OR id_tipo_usuario = :idTipoUsuario) AND (:keyword IS NULL OR UPPER(nombre_tipo_usuario) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoUsuario") Long idTipoUsuario, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_usuarios WHERE (:idTipoUsuario IS NULL OR id_tipo_usuario = :idTipoUsuario) AND (:keyword IS NULL OR UPPER(nombre_tipo_usuario) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoUsuario' AND :orderMode = 'ASC' THEN id_tipo_usuario END ASC, CASE WHEN :orderBy = 'idTipoUsuario' AND :orderMode = 'DESC' THEN id_tipo_usuario END DESC, CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'ASC' THEN nombre_tipo_usuario END ASC, CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'DESC' THEN nombre_tipo_usuario END DESC", nativeQuery = true)
    List<TipoUsuario> findAllTiposUsuarios(@Param("idTipoUsuario") Long idTipoUsuario, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_usuarios WHERE (:idTipoUsuario IS NULL OR id_tipo_usuario = :idTipoUsuario) AND (:keyword IS NULL OR UPPER(nombre_tipo_usuario) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoUsuario' AND :orderMode = 'ASC' THEN id_tipo_usuario END ASC, CASE WHEN :orderBy = 'idTipoUsuario' AND :orderMode = 'DESC' THEN id_tipo_usuario END DESC, CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'ASC' THEN nombre_tipo_usuario END ASC, CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'DESC' THEN nombre_tipo_usuario END DESC", nativeQuery = true)
    Slice<TipoUsuario> findAllTiposUsuariosPag(Pageable pageable, @Param("idTipoUsuario") Long idTipoUsuario, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoUsuario> findByIdTipoUsuario(Long idTipoUsuario);
    
    TipoUsuario findByNombreTipoUsuario(String nombreTipoUsuario);
    
    @Query(value = "SELECT MAX(id_tipo_usuario) FROM tabla_tipos_usuarios", nativeQuery = true)
    Long findMaxIdTipoUsuario();
}
