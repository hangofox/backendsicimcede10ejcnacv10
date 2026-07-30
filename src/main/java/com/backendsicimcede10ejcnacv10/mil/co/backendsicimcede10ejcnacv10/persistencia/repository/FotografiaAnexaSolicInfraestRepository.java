//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaSolicInfraest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface FotografiaAnexaSolicInfraestRepository extends JpaRepository<FotografiaAnexaSolicInfraest, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + ID SOLICITUD INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_fotografias_anexas_solic_infraest " +
          "WHERE (:idFotografiasAnexasSolicInfraest IS NULL OR tabla_fotografias_anexas_solic_infraest.id_fotografias_anexas_solic_infraest = :idFotografiasAnexasSolicInfraest) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idFotografiasAnexasSolicInfraest") Long idFotografiasAnexasSolicInfraest, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT tabla_fotografias_anexas_solic_infraest.* FROM tabla_fotografias_anexas_solic_infraest " +
          "WHERE (:idFotografiasAnexasSolicInfraest IS NULL OR tabla_fotografias_anexas_solic_infraest.id_fotografias_anexas_solic_infraest = :idFotografiasAnexasSolicInfraest) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idFotografiasAnexasSolicInfraest' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_solic_infraest.id_fotografias_anexas_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idFotografiasAnexasSolicInfraest' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_solic_infraest.id_fotografias_anexas_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura END DESC", nativeQuery = true)
    List<FotografiaAnexaSolicInfraest> findAllFotografiasAnexasSolicInfraest(@Param("idFotografiasAnexasSolicInfraest") Long idFotografiasAnexasSolicInfraest, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_fotografias_anexas_solic_infraest.* FROM tabla_fotografias_anexas_solic_infraest " +
          "WHERE (:idFotografiasAnexasSolicInfraest IS NULL OR tabla_fotografias_anexas_solic_infraest.id_fotografias_anexas_solic_infraest = :idFotografiasAnexasSolicInfraest) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idFotografiasAnexasSolicInfraest' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_solic_infraest.id_fotografias_anexas_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idFotografiasAnexasSolicInfraest' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_solic_infraest.id_fotografias_anexas_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura END DESC", nativeQuery = true)
    Slice<FotografiaAnexaSolicInfraest> findAllFotografiasAnexasSolicInfraestPag(Pageable pageable, @Param("idFotografiasAnexasSolicInfraest") Long idFotografiasAnexasSolicInfraest, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<FotografiaAnexaSolicInfraest> findByIdFotografiasAnexasSolicInfraest(Long idFotografiasAnexasSolicInfraest);
    
    //BUSQUEDA UNITARIA POR ID SOLICITUD INFRAESTRUCTURA (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO DE FOTOGRAFIA ANEXA PARA LA MISMA SOLICITUD):
    @Query(value = "SELECT tabla_fotografias_anexas_solic_infraest.* FROM tabla_fotografias_anexas_solic_infraest " +
          "WHERE tabla_fotografias_anexas_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura AND ROWNUM = 1", nativeQuery = true)
    FotografiaAnexaSolicInfraest findBySolicitudInfraestructuraId(@Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT MAX(id_fotografias_anexas_solic_infraest) FROM tabla_fotografias_anexas_solic_infraest", nativeQuery = true)
    Long findMaxIdFotografiasAnexasSolicInfraest();
}
