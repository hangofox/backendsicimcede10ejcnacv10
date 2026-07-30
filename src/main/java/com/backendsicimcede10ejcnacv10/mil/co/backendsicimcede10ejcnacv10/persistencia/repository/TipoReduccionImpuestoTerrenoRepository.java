//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoReduccionImpuestoTerreno;
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
public interface TipoReduccionImpuestoTerrenoRepository extends JpaRepository<TipoReduccionImpuestoTerreno,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_reducciones_impuestos_terrenos WHERE (:idTipoReduccionImpuestoTerreno IS NULL OR id_tipo_reduccion_impuesto_terreno = :idTipoReduccionImpuestoTerreno) AND (:keyword IS NULL OR UPPER(nombre_tipo_reduccion_impuesto_terreno) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoReduccionImpuestoTerreno") Long idTipoReduccionImpuestoTerreno, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_reducciones_impuestos_terrenos WHERE (:idTipoReduccionImpuestoTerreno IS NULL OR id_tipo_reduccion_impuesto_terreno = :idTipoReduccionImpuestoTerreno) AND (:keyword IS NULL OR UPPER(nombre_tipo_reduccion_impuesto_terreno) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoReduccionImpuestoTerreno' AND :orderMode = 'ASC' THEN id_tipo_reduccion_impuesto_terreno END ASC, CASE WHEN :orderBy = 'idTipoReduccionImpuestoTerreno' AND :orderMode = 'DESC' THEN id_tipo_reduccion_impuesto_terreno END DESC, CASE WHEN :orderBy = 'nombreTipoReduccionImpuestoTerreno' AND :orderMode = 'ASC' THEN nombre_tipo_reduccion_impuesto_terreno END ASC, CASE WHEN :orderBy = 'nombreTipoReduccionImpuestoTerreno' AND :orderMode = 'DESC' THEN nombre_tipo_reduccion_impuesto_terreno END DESC", nativeQuery = true)
    List<TipoReduccionImpuestoTerreno> findAllTiposReduccionesImpuestosTerrenos(@Param("idTipoReduccionImpuestoTerreno") Long idTipoReduccionImpuestoTerreno, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_reducciones_impuestos_terrenos WHERE (:idTipoReduccionImpuestoTerreno IS NULL OR id_tipo_reduccion_impuesto_terreno = :idTipoReduccionImpuestoTerreno) AND (:keyword IS NULL OR UPPER(nombre_tipo_reduccion_impuesto_terreno) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoReduccionImpuestoTerreno' AND :orderMode = 'ASC' THEN id_tipo_reduccion_impuesto_terreno END ASC, CASE WHEN :orderBy = 'idTipoReduccionImpuestoTerreno' AND :orderMode = 'DESC' THEN id_tipo_reduccion_impuesto_terreno END DESC, CASE WHEN :orderBy = 'nombreTipoReduccionImpuestoTerreno' AND :orderMode = 'ASC' THEN nombre_tipo_reduccion_impuesto_terreno END ASC, CASE WHEN :orderBy = 'nombreTipoReduccionImpuestoTerreno' AND :orderMode = 'DESC' THEN nombre_tipo_reduccion_impuesto_terreno END DESC", nativeQuery = true)
    Slice<TipoReduccionImpuestoTerreno> findAllTiposReduccionesImpuestosTerrrenosPag(Pageable pageable, @Param("idTipoReduccionImpuestoTerreno") Long idTipoReduccionImpuestoTerreno, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoReduccionImpuestoTerreno> findByIdTipoReduccionImpuestoTerreno(Long idTipoReduccionImpuestoTerreno);
    
    TipoReduccionImpuestoTerreno findByNombreTipoReduccionImpuestoTerreno(String nombreTipoReduccionImpuestoTerreno);
    
    @Query(value = "SELECT MAX(id_tipo_reduccion_impuesto_terreno) FROM tabla_tipos_reducciones_impuestos_terrenos", nativeQuery = true)
    Long findMaxIdTipoReduccionImpuestoTerreno();
}
