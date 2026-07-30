//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.GerenteProyectoSolicInfraest;
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
public interface GerenteProyectoSolicInfraestRepository extends JpaRepository<GerenteProyectoSolicInfraest, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ID SOLICITUD INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_gerentes_proyectos_solic_infraest " +
          "WHERE (:idGerenteProyectoSolicInfraest IS NULL OR tabla_gerentes_proyectos_solic_infraest.id_gerente_proyecto_solic_infraest = :idGerenteProyectoSolicInfraest) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_gerentes_proyectos_solic_infraest.nombres_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_gerentes_proyectos_solic_infraest.primer_apellido_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_gerentes_proyectos_solic_infraest.segundo_apellido_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_gerentes_proyectos_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idGerenteProyectoSolicInfraest") Long idGerenteProyectoSolicInfraest, @Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT tabla_gerentes_proyectos_solic_infraest.* FROM tabla_gerentes_proyectos_solic_infraest " +
          "WHERE (:idGerenteProyectoSolicInfraest IS NULL OR tabla_gerentes_proyectos_solic_infraest.id_gerente_proyecto_solic_infraest = :idGerenteProyectoSolicInfraest) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_gerentes_proyectos_solic_infraest.nombres_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_gerentes_proyectos_solic_infraest.primer_apellido_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_gerentes_proyectos_solic_infraest.segundo_apellido_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_gerentes_proyectos_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.id_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.id_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.id_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.id_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'gradoGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.grado_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'gradoGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.grado_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombresGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.nombres_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombresGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.nombres_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.primer_apellido_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.primer_apellido_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.segundo_apellido_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.segundo_apellido_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'movilGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.movil_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'movilGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.movil_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'cargoActualGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.cargo_actual_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'cargoActualGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.cargo_actual_gerente_proyecto_solic_infraest END DESC", nativeQuery = true)
    List<GerenteProyectoSolicInfraest> findAllGerentesProyectosSolicInfraest(@Param("idGerenteProyectoSolicInfraest") Long idGerenteProyectoSolicInfraest, @Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_gerentes_proyectos_solic_infraest.* FROM tabla_gerentes_proyectos_solic_infraest " +
          "WHERE (:idGerenteProyectoSolicInfraest IS NULL OR tabla_gerentes_proyectos_solic_infraest.id_gerente_proyecto_solic_infraest = :idGerenteProyectoSolicInfraest) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_gerentes_proyectos_solic_infraest.nombres_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_gerentes_proyectos_solic_infraest.primer_apellido_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_gerentes_proyectos_solic_infraest.segundo_apellido_gerente_proyecto_solic_infraest) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_gerentes_proyectos_solic_infraest.id_solicitud_infraestructura = :idSolicitudInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.id_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.id_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.id_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.id_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'gradoGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.grado_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'gradoGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.grado_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombresGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.nombres_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombresGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.nombres_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.primer_apellido_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.primer_apellido_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.segundo_apellido_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.segundo_apellido_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'movilGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.movil_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'movilGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.movil_gerente_proyecto_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'cargoActualGerenteProyectoSolicInfraest' AND :orderMode = 'ASC' THEN tabla_gerentes_proyectos_solic_infraest.cargo_actual_gerente_proyecto_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'cargoActualGerenteProyectoSolicInfraest' AND :orderMode = 'DESC' THEN tabla_gerentes_proyectos_solic_infraest.cargo_actual_gerente_proyecto_solic_infraest END DESC", nativeQuery = true)
    Slice<GerenteProyectoSolicInfraest> findAllGerentesProyectosSolicInfraestPag(Pageable pageable, @Param("idGerenteProyectoSolicInfraest") Long idGerenteProyectoSolicInfraest, @Param("keyword") String keyword, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<GerenteProyectoSolicInfraest> findByIdGerenteProyectoSolicInfraest(Long idGerenteProyectoSolicInfraest);
    
    //BUSQUEDA UNITARIA POR ID SOLICITUD INFRAESTRUCTURA (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO DE GERENTE DE PROYECTO PARA LA MISMA SOLICITUD):
    @Query(value = "SELECT * FROM tabla_gerentes_proyectos_solic_infraest " +
          "WHERE id_solicitud_infraestructura = :idSolicitudInfraestructura AND ROWNUM = 1", nativeQuery = true)
    GerenteProyectoSolicInfraest findBySolicitudInfraestructuraId(@Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura);
    
    @Query(value = "SELECT MAX(id_gerente_proyecto_solic_infraest) FROM tabla_gerentes_proyectos_solic_infraest", nativeQuery = true)
    Long findMaxIdGerenteProyectoSolicInfraest();
}
