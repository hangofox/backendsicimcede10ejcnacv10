//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoSeguro;
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
public interface TipoSeguroRepository extends JpaRepository<TipoSeguro,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_seguros WHERE (:idTipoSeguro IS NULL OR id_tipo_seguro = :idTipoSeguro) AND (:keyword IS NULL OR UPPER(nombre_tipo_seguro) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoSeguro") Long idTipoSeguro, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_seguros WHERE (:idTipoSeguro IS NULL OR id_tipo_seguro = :idTipoSeguro) AND (:keyword IS NULL OR UPPER(nombre_tipo_seguro) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'ASC' THEN id_tipo_seguro END ASC, CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'DESC' THEN id_tipo_seguro END DESC, CASE WHEN :orderBy = 'nombreTipoSeguro' AND :orderMode = 'ASC' THEN nombre_tipo_seguro END ASC, CASE WHEN :orderBy = 'nombreTipoSeguro' AND :orderMode = 'DESC' THEN nombre_tipo_seguro END DESC", nativeQuery = true)
    List<TipoSeguro> findAllTiposSeguros(@Param("idTipoSeguro") Long idTipoSeguro, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_seguros WHERE (:idTipoSeguro IS NULL OR id_tipo_seguro = :idTipoSeguro) AND (:keyword IS NULL OR UPPER(nombre_tipo_seguro) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'ASC' THEN id_tipo_seguro END ASC, CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'DESC' THEN id_tipo_seguro END DESC, CASE WHEN :orderBy = 'nombreTipoSeguro' AND :orderMode = 'ASC' THEN nombre_tipo_seguro END ASC, CASE WHEN :orderBy = 'nombreTipoSeguro' AND :orderMode = 'DESC' THEN nombre_tipo_seguro END DESC", nativeQuery = true)
    Slice<TipoSeguro> findAllTiposSegurosPag(Pageable pageable, @Param("idTipoSeguro") Long idTipoSeguro, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoSeguro> findByIdTipoSeguro(Long idTipoSeguro);
    
    TipoSeguro findByNombreTipoSeguro(String nombreTipoSeguro);
    
    @Query(value = "SELECT MAX(id_tipo_seguro) FROM tabla_tipos_seguros", nativeQuery = true)
    Long findMaxIdTipoSeguro();
}
