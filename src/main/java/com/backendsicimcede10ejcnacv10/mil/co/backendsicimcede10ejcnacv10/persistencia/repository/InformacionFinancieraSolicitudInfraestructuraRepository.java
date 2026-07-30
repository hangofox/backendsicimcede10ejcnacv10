//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InformacionFinancieraSolicitudInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 27/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface InformacionFinancieraSolicitudInfraestructuraRepository extends JpaRepository<InformacionFinancieraSolicitudInfraestructura,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID SOLICITUD INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_informacion_financiera_solicitudes_infraestructuras, tabla_solicitudes_infraestructuras " +
          "WHERE (tabla_informacion_financiera_solicitudes_infraestructuras.id_solicitud_infraestructura = tabla_solicitudes_infraestructuras.id_solicitud_infraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_informacion_financiera_solicitudes_infraestructuras.numero_area_intervencion_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_informacion_financiera_solicitudes_infraestructuras.nombre_unidad_medida_area_intervencion_infraestructura) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_informacion_financiera_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT tabla_informacion_financiera_solicitudes_infraestructuras.* FROM tabla_informacion_financiera_solicitudes_infraestructuras, tabla_solicitudes_infraestructuras " +
          "WHERE (tabla_informacion_financiera_solicitudes_infraestructuras.id_solicitud_infraestructura = tabla_solicitudes_infraestructuras.id_solicitud_infraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_informacion_financiera_solicitudes_infraestructuras.numero_area_intervencion_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_informacion_financiera_solicitudes_infraestructuras.nombre_unidad_medida_area_intervencion_infraestructura) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_informacion_financiera_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idInformacionFinancieraSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_informacion_financiera_solicitudes_infraestructuras.id_informacion_financiera_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInformacionFinancieraSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_informacion_financiera_solicitudes_infraestructuras.id_informacion_financiera_solicitud_infraestructura END DESC", nativeQuery = true)
    List<InformacionFinancieraSolicitudInfraestructura> findAllInformacionesFinancierasSolicitudesInfraestructuras(@Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_informacion_financiera_solicitudes_infraestructuras.* FROM tabla_informacion_financiera_solicitudes_infraestructuras, tabla_solicitudes_infraestructuras " +
          "WHERE (tabla_informacion_financiera_solicitudes_infraestructuras.id_solicitud_infraestructura = tabla_solicitudes_infraestructuras.id_solicitud_infraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_solicitudes_infraestructuras.codigo_radicado_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_informacion_financiera_solicitudes_infraestructuras.numero_area_intervencion_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_informacion_financiera_solicitudes_infraestructuras.nombre_unidad_medida_area_intervencion_infraestructura) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_informacion_financiera_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idInformacionFinancieraSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_informacion_financiera_solicitudes_infraestructuras.id_informacion_financiera_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInformacionFinancieraSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_informacion_financiera_solicitudes_infraestructuras.id_informacion_financiera_solicitud_infraestructura END DESC", nativeQuery = true)
    Slice<InformacionFinancieraSolicitudInfraestructura> findAllInformacionesFinancierasSolicitudesInfraestructurasPag(Pageable pageable, @Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<InformacionFinancieraSolicitudInfraestructura> findByIdInformacionFinancieraSolicitudInfraestructura(Long idInformacionFinancieraSolicitudInfraestructura);
    
    @Query(value = "SELECT MAX(id_informacion_financiera_solicitud_infraestructura) FROM tabla_informacion_financiera_solicitudes_infraestructuras", nativeQuery = true)
    Long findMaxIdInformacionFinancieraSolicitudInfraestructura();
}
