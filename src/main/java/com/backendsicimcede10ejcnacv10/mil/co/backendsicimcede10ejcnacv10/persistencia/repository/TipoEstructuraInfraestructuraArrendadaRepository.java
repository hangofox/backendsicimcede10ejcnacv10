//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructuraArrendada;
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
public interface TipoEstructuraInfraestructuraArrendadaRepository extends JpaRepository<TipoEstructuraInfraestructuraArrendada,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_estructuras_infraestructuras_arrendadas WHERE (:idTipoEstructuraInfraestructuraArrendada IS NULL OR id_tipo_estructura_infraestructura_arrendada = :idTipoEstructuraInfraestructuraArrendada) AND (:keyword IS NULL OR UPPER(nombre_tipo_estructura_infraestructura_arrendada) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoEstructuraInfraestructuraArrendada") Long idTipoEstructuraInfraestructuraArrendada, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_estructuras_infraestructuras_arrendadas WHERE (:idTipoEstructuraInfraestructuraArrendada IS NULL OR id_tipo_estructura_infraestructura_arrendada = :idTipoEstructuraInfraestructuraArrendada) AND (:keyword IS NULL OR UPPER(nombre_tipo_estructura_infraestructura_arrendada) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN id_tipo_estructura_infraestructura_arrendada END ASC, CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN id_tipo_estructura_infraestructura_arrendada END DESC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN nombre_tipo_estructura_infraestructura_arrendada END ASC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN nombre_tipo_estructura_infraestructura_arrendada END DESC", nativeQuery = true)
    List<TipoEstructuraInfraestructuraArrendada> findAllTiposEstructurasInfraestructurasArrendadas(@Param("idTipoEstructuraInfraestructuraArrendada") Long idTipoEstructuraInfraestructuraArrendada, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_estructuras_infraestructuras_arrendadas WHERE (:idTipoEstructuraInfraestructuraArrendada IS NULL OR id_tipo_estructura_infraestructura_arrendada = :idTipoEstructuraInfraestructuraArrendada) AND (:keyword IS NULL OR UPPER(nombre_tipo_estructura_infraestructura_arrendada) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN id_tipo_estructura_infraestructura_arrendada END ASC, CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN id_tipo_estructura_infraestructura_arrendada END DESC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN nombre_tipo_estructura_infraestructura_arrendada END ASC, CASE WHEN :orderBy = 'nombreTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN nombre_tipo_estructura_infraestructura_arrendada END DESC", nativeQuery = true)
    Slice<TipoEstructuraInfraestructuraArrendada> findAllTiposEstructurasInfraestructurasArrendadasPag(Pageable pageable, @Param("idTipoEstructuraInfraestructuraArrendada") Long idTipoEstructuraInfraestructuraArrendada, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoEstructuraInfraestructuraArrendada> findByIdTipoEstructuraInfraestructuraArrendada(Long idTipoEstructuraInfraestructuraArrendada);
    
    TipoEstructuraInfraestructuraArrendada findByNombreTipoEstructuraInfraestructuraArrendada(String nombreTipoEstructuraInfraestructuraArrendada);
    
    @Query(value = "SELECT MAX(id_tipo_estructura_infraestructura_arrendada) FROM tabla_tipos_estructuras_infraestructuras_arrendadas", nativeQuery = true)
    Long findMaxIdTipoEstructuraInfraestructuraArrendada();
}
