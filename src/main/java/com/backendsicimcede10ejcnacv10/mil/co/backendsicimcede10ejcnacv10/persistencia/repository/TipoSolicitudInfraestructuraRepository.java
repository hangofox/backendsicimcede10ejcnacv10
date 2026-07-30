//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoSolicitudInfraestructura;
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
public interface TipoSolicitudInfraestructuraRepository extends JpaRepository<TipoSolicitudInfraestructura,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_solicitudes_infraestructuras WHERE (:idTipoSolicitudInfraestructura IS NULL OR id_tipo_solicitud_infraestructura = :idTipoSolicitudInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoSolicitudInfraestructura") Long idTipoSolicitudInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_solicitudes_infraestructuras WHERE (:idTipoSolicitudInfraestructura IS NULL OR id_tipo_solicitud_infraestructura = :idTipoSolicitudInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_solicitud_infraestructura END ASC, CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_solicitud_infraestructura END DESC, CASE WHEN :orderBy = 'nombreTipoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_solicitud_infraestructura END ASC, CASE WHEN :orderBy = 'nombreTipoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_solicitud_infraestructura END DESC", nativeQuery = true)
    List<TipoSolicitudInfraestructura> findAllTiposSolicitudesInfraestructuras(@Param("idTipoSolicitudInfraestructura") Long idTipoSolicitudInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_solicitudes_infraestructuras WHERE (:idTipoSolicitudInfraestructura IS NULL OR id_tipo_solicitud_infraestructura = :idTipoSolicitudInfraestructura) AND (:keyword IS NULL OR UPPER(nombre_tipo_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN id_tipo_solicitud_infraestructura END ASC, CASE WHEN :orderBy = 'idTipoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN id_tipo_solicitud_infraestructura END DESC, CASE WHEN :orderBy = 'nombreTipoSolicitudInfraestructura' AND :orderMode = 'ASC' THEN nombre_tipo_solicitud_infraestructura END ASC, CASE WHEN :orderBy = 'nombreTipoSolicitudInfraestructura' AND :orderMode = 'DESC' THEN nombre_tipo_solicitud_infraestructura END DESC", nativeQuery = true)
    Slice<TipoSolicitudInfraestructura> findAllTiposSolicitudesInfraestructurasPag(Pageable pageable, @Param("idTipoSolicitudInfraestructura") Long idTipoSolicitudInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoSolicitudInfraestructura> findByIdTipoSolicitudInfraestructura(Long idTipoSolicitudInfraestructura);
    
    TipoSolicitudInfraestructura findByNombreTipoSolicitudInfraestructura(String nombreTipoSolicitudInfraestructura);
    
    @Query(value = "SELECT MAX(id_tipo_solicitud_infraestructura) FROM tabla_tipos_solicitudes_infraestructuras", nativeQuery = true)
    Long findMaxIdTipoSolicitudInfraestructura();
}
