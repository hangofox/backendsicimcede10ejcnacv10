//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_unidades_medidas WHERE (:keyword IS NULL OR (UPPER(nombre_unidad_medida) LIKE UPPER('%'||:keyword||'%') OR UPPER(sigla_o_acronimo_unidad_medida) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_categoria_unidad_medida) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_unidades_medidas WHERE (:keyword IS NULL OR (UPPER(nombre_unidad_medida) LIKE UPPER('%'||:keyword||'%') OR UPPER(sigla_o_acronimo_unidad_medida) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_categoria_unidad_medida) LIKE UPPER('%'||:keyword||'%'))) ORDER BY CASE WHEN :orderBy = 'idUnidadMedida' AND :orderMode = 'ASC' THEN id_unidad_medida END ASC, CASE WHEN :orderBy = 'idUnidadMedida' AND :orderMode = 'DESC' THEN id_unidad_medida END DESC, CASE WHEN :orderBy = 'nombreUnidadMedida' AND :orderMode = 'ASC' THEN nombre_unidad_medida END ASC, CASE WHEN :orderBy = 'nombreUnidadMedida' AND :orderMode = 'DESC' THEN nombre_unidad_medida END DESC, CASE WHEN :orderBy = 'nombreCategoriaUnidadMedida' AND :orderMode = 'ASC' THEN nombre_categoria_unidad_medida END ASC, CASE WHEN :orderBy = 'nombreCategoriaUnidadMedida' AND :orderMode = 'DESC' THEN nombre_categoria_unidad_medida END DESC", nativeQuery = true)
    List<UnidadMedida> findAllUnidadesMedidas(@Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_unidades_medidas WHERE (:keyword IS NULL OR (UPPER(nombre_unidad_medida) LIKE UPPER('%'||:keyword||'%') OR UPPER(sigla_o_acronimo_unidad_medida) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_categoria_unidad_medida) LIKE UPPER('%'||:keyword||'%'))) ORDER BY CASE WHEN :orderBy = 'idUnidadMedida' AND :orderMode = 'ASC' THEN id_unidad_medida END ASC, CASE WHEN :orderBy = 'idUnidadMedida' AND :orderMode = 'DESC' THEN id_unidad_medida END DESC, CASE WHEN :orderBy = 'nombreUnidadMedida' AND :orderMode = 'ASC' THEN nombre_unidad_medida END ASC, CASE WHEN :orderBy = 'nombreUnidadMedida' AND :orderMode = 'DESC' THEN nombre_unidad_medida END DESC, CASE WHEN :orderBy = 'nombreCategoriaUnidadMedida' AND :orderMode = 'ASC' THEN nombre_categoria_unidad_medida END ASC, CASE WHEN :orderBy = 'nombreCategoriaUnidadMedida' AND :orderMode = 'DESC' THEN nombre_categoria_unidad_medida END DESC", nativeQuery = true)
    Slice<UnidadMedida> findAllUnidadesMedidasPag(Pageable pageable, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<UnidadMedida> findByIdUnidadMedida(Long idUnidadMedida);
    
    UnidadMedida findByNombreUnidadMedida(String nombreUnidadMedida);
    
    @Query(value = "SELECT MAX(id_unidad_medida) FROM tabla_unidades_medidas", nativeQuery = true)
    Long findMaxIdUnidadMedida();
}
