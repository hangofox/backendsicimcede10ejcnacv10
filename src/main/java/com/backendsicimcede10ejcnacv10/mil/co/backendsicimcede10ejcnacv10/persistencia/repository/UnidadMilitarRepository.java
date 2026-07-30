//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface UnidadMilitarRepository extends JpaRepository<UnidadMilitar,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_unidades_militares WHERE (:idUnidadMilitar IS NULL OR id_unidad_militar = :idUnidadMilitar) AND (:keyword IS NULL OR (UPPER(nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_archivo_foto_log_ext_o_fmt_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_carpeta_almacenamiento_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(codigo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nivel_unidad_militar) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idUnidadMilitar") Long idUnidadMilitar, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_unidades_militares WHERE (:idUnidadMilitar IS NULL OR id_unidad_militar = :idUnidadMilitar) AND (:keyword IS NULL OR (UPPER(nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_archivo_foto_log_ext_o_fmt_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_carpeta_almacenamiento_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(codigo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nivel_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) ORDER BY CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN id_unidad_militar END ASC, CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN id_unidad_militar END DESC, CASE WHEN :orderBy = 'nombreUnidadMilitar' AND :orderMode = 'ASC' THEN nombre_unidad_militar END ASC, CASE WHEN :orderBy = 'nombreUnidadMilitar' AND :orderMode = 'DESC' THEN nombre_unidad_militar END DESC, CASE WHEN :orderBy = 'codigoUnidadMilitar' AND :orderMode = 'ASC' THEN codigo_unidad_militar END ASC, CASE WHEN :orderBy = 'codigoUnidadMilitar' AND :orderMode = 'DESC' THEN codigo_unidad_militar END DESC, CASE WHEN :orderBy = 'nivelUnidadMilitar' AND :orderMode = 'ASC' THEN nivel_unidad_militar END ASC, CASE WHEN :orderBy = 'nivelUnidadMilitar' AND :orderMode = 'DESC' THEN nivel_unidad_militar END DESC", nativeQuery = true)
    List<UnidadMilitar> findAllUnidadesMilitares(@Param("idUnidadMilitar") Long idUnidadMilitar, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_unidades_militares WHERE (:idUnidadMilitar IS NULL OR id_unidad_militar = :idUnidadMilitar) AND (:keyword IS NULL OR (UPPER(nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_archivo_foto_log_ext_o_fmt_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nombre_carpeta_almacenamiento_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(codigo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR UPPER(nivel_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) ORDER BY CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN id_unidad_militar END ASC, CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN id_unidad_militar END DESC, CASE WHEN :orderBy = 'nombreUnidadMilitar' AND :orderMode = 'ASC' THEN nombre_unidad_militar END ASC, CASE WHEN :orderBy = 'nombreUnidadMilitar' AND :orderMode = 'DESC' THEN nombre_unidad_militar END DESC, CASE WHEN :orderBy = 'codigoUnidadMilitar' AND :orderMode = 'ASC' THEN codigo_unidad_militar END ASC, CASE WHEN :orderBy = 'codigoUnidadMilitar' AND :orderMode = 'DESC' THEN codigo_unidad_militar END DESC, CASE WHEN :orderBy = 'nivelUnidadMilitar' AND :orderMode = 'ASC' THEN nivel_unidad_militar END ASC, CASE WHEN :orderBy = 'nivelUnidadMilitar' AND :orderMode = 'DESC' THEN nivel_unidad_militar END DESC", nativeQuery = true)
    Slice<UnidadMilitar> findAllUnidadesMilitaresPag(Pageable pageable, @Param("idUnidadMilitar") Long idUnidadMilitar, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<UnidadMilitar> findByIdUnidadMilitar(Long idUnidadMilitar);
    
    UnidadMilitar findByNombreUnidadMilitar(String nombreUnidadMilitar);

    UnidadMilitar findByCodigoUnidadMilitar(String codigoUnidadMilitar);
    
    UnidadMilitar findBySiglaoAcronimoUnidadMilitar(String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT MAX(id_unidad_militar) FROM tabla_unidades_militares", nativeQuery = true)
    Long findMaxIdUnidadMilitar();
}
