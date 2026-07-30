//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.IntegrantesSolicitudesInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface IntegrantesSolicitudesInfraestructuraRepository extends JpaRepository<IntegrantesSolicitudesInfraestructura, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID INTEGRANTES SOLICITUDES INFRAESTRUCTURA + ID SOLICITUD INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_integrantes_solicitudes_infraestructuras " +
          "WHERE (:idIntegrantesSolicitudesInfraestructura IS NULL OR tabla_integrantes_solicitudes_infraestructuras.id_integrantes_solicitudes_infraestructura = :idIntegrantesSolicitudesInfraestructura) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idIntegrantesSolicitudesInfraestructura") Long idIntegrantesSolicitudesInfraestructura, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT tabla_integrantes_solicitudes_infraestructuras.* FROM tabla_integrantes_solicitudes_infraestructuras " +
          "WHERE (:idIntegrantesSolicitudesInfraestructura IS NULL OR tabla_integrantes_solicitudes_infraestructuras.id_integrantes_solicitudes_infraestructura = :idIntegrantesSolicitudesInfraestructura) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idIntegrantesSolicitudesInfraestructura' AND :orderMode = 'ASC' THEN tabla_integrantes_solicitudes_infraestructuras.id_integrantes_solicitudes_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idIntegrantesSolicitudesInfraestructura' AND :orderMode = 'DESC' THEN tabla_integrantes_solicitudes_infraestructuras.id_integrantes_solicitudes_infraestructura END DESC", nativeQuery = true)
    List<IntegrantesSolicitudesInfraestructura> findAllIntegrantesSolicitudesInfraestructuras(@Param("idIntegrantesSolicitudesInfraestructura") Long idIntegrantesSolicitudesInfraestructura, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_integrantes_solicitudes_infraestructuras.* FROM tabla_integrantes_solicitudes_infraestructuras " +
          "WHERE (:idIntegrantesSolicitudesInfraestructura IS NULL OR tabla_integrantes_solicitudes_infraestructuras.id_integrantes_solicitudes_infraestructura = :idIntegrantesSolicitudesInfraestructura) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idIntegrantesSolicitudesInfraestructura' AND :orderMode = 'ASC' THEN tabla_integrantes_solicitudes_infraestructuras.id_integrantes_solicitudes_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idIntegrantesSolicitudesInfraestructura' AND :orderMode = 'DESC' THEN tabla_integrantes_solicitudes_infraestructuras.id_integrantes_solicitudes_infraestructura END DESC", nativeQuery = true)
    Slice<IntegrantesSolicitudesInfraestructura> findAllIntegrantesSolicitudesInfraestructurasPag(Pageable pageable, @Param("idIntegrantesSolicitudesInfraestructura") Long idIntegrantesSolicitudesInfraestructura, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<IntegrantesSolicitudesInfraestructura> findByIdIntegrantesSolicitudesInfraestructura(Long idIntegrantesSolicitudesInfraestructura);
    
    //BUSQUEDA UNITARIA POR ID SOLICITUD INFRAESTRUCTURA (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO DE INTEGRANTES PARA LA MISMA SOLICITUD):
    @Query(value = "SELECT tabla_integrantes_solicitudes_infraestructuras.* FROM tabla_integrantes_solicitudes_infraestructuras " +
          "WHERE tabla_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura AND ROWNUM = 1", nativeQuery = true)
    IntegrantesSolicitudesInfraestructura findBySolicitudInfraestructuraId(@Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT MAX(id_integrantes_solicitudes_infraestructura) FROM tabla_integrantes_solicitudes_infraestructuras", nativeQuery = true)
    Long findMaxIdIntegrantesSolicitudesInfraestructura();
}
