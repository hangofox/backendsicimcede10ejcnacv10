//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoServicioPublico;
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
public interface TipoServicioPublicoRepository extends JpaRepository<TipoServicioPublico,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_servicios_publicos WHERE (:idTipoServicioPublico IS NULL OR id_tipo_servicio_publico = :idTipoServicioPublico) AND (:keyword IS NULL OR UPPER(nombre_tipo_servicio_publico) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoServicioPublico") Long idTipoServicioPublico, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_servicios_publicos WHERE (:idTipoServicioPublico IS NULL OR id_tipo_servicio_publico = :idTipoServicioPublico) AND (:keyword IS NULL OR UPPER(nombre_tipo_servicio_publico) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoServicioPublico' AND :orderMode = 'ASC' THEN id_tipo_servicio_publico END ASC, CASE WHEN :orderBy = 'idTipoServicioPublico' AND :orderMode = 'DESC' THEN id_tipo_servicio_publico END DESC, CASE WHEN :orderBy = 'nombreTipoServicioPublico' AND :orderMode = 'ASC' THEN nombre_tipo_servicio_publico END ASC, CASE WHEN :orderBy = 'nombreTipoServicioPublico' AND :orderMode = 'DESC' THEN nombre_tipo_servicio_publico END DESC", nativeQuery = true)
    List<TipoServicioPublico> findAllTiposServiciosPublicos(@Param("idTipoServicioPublico") Long idTipoServicioPublico, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_servicios_publicos WHERE (:idTipoServicioPublico IS NULL OR id_tipo_servicio_publico = :idTipoServicioPublico) AND (:keyword IS NULL OR UPPER(nombre_tipo_servicio_publico) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoServicioPublico' AND :orderMode = 'ASC' THEN id_tipo_servicio_publico END ASC, CASE WHEN :orderBy = 'idTipoServicioPublico' AND :orderMode = 'DESC' THEN id_tipo_servicio_publico END DESC, CASE WHEN :orderBy = 'nombreTipoServicioPublico' AND :orderMode = 'ASC' THEN nombre_tipo_servicio_publico END ASC, CASE WHEN :orderBy = 'nombreTipoServicioPublico' AND :orderMode = 'DESC' THEN nombre_tipo_servicio_publico END DESC", nativeQuery = true)
    Slice<TipoServicioPublico> findAllTiposServiciosPublicosPag(Pageable pageable, @Param("idTipoServicioPublico") Long idTipoServicioPublico, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoServicioPublico> findByIdTipoServicioPublico(Long idTipoServicioPublico);
    
    TipoServicioPublico findByNombreTipoServicioPublico(String nombreTipoServicioPublico);
    
    @Query(value = "SELECT MAX(id_tipo_servicio_publico) FROM tabla_tipos_servicios_publicos", nativeQuery = true)
    Long findMaxIdTipoServicioPublico();
}
