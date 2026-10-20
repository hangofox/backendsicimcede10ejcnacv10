//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialIntegranteSolicitudInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialIntegranteSolicitudInfraestructuraRepository extends JpaRepository<HistorialIntegranteSolicitudInfraestructura, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + ID SOLICITUD DE INFRAESTRUCTURA + KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_integrantes_solicitudes_infraestructuras " +
          "WHERE (:siglaoAcronimoUnidadMilitar IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_unidad_militar IN (SELECT tabla_unidades_militares.id_unidad_militar FROM tabla_unidades_militares WHERE UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))) AND " +
          "(:idHistorialIntegranteSolicitudInfraestructura IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_historial_integrante_solicitud_infraestructura = :idHistorialIntegranteSolicitudInfraestructura) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.num_reg_historial_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.nombres_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.primer_apellido_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.segundo_apellido_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialIntegranteSolicitudInfraestructura") Long idHistorialIntegranteSolicitudInfraestructura, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_historial_integrantes_solicitudes_infraestructuras.* FROM tabla_historial_integrantes_solicitudes_infraestructuras " +
          "WHERE (:siglaoAcronimoUnidadMilitar IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_unidad_militar IN (SELECT tabla_unidades_militares.id_unidad_militar FROM tabla_unidades_militares WHERE UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))) AND " +
          "(:idHistorialIntegranteSolicitudInfraestructura IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_historial_integrante_solicitud_infraestructura = :idHistorialIntegranteSolicitudInfraestructura) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.num_reg_historial_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.nombres_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.primer_apellido_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.segundo_apellido_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.id_historial_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.id_historial_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.num_reg_historial_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.num_reg_historial_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'gradoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.grado_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'gradoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.grado_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombresIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.nombres_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombresIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.nombres_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.primer_apellido_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.primer_apellido_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.segundo_apellido_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.segundo_apellido_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'cargoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'cargoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura END DESC", nativeQuery = true)
    List<HistorialIntegranteSolicitudInfraestructura> findAllHistorialesIntegrantesSolicitudesInfraestructuras(@Param("idHistorialIntegranteSolicitudInfraestructura") Long idHistorialIntegranteSolicitudInfraestructura, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_integrantes_solicitudes_infraestructuras.* FROM tabla_historial_integrantes_solicitudes_infraestructuras " +
          "WHERE (:siglaoAcronimoUnidadMilitar IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_unidad_militar IN (SELECT tabla_unidades_militares.id_unidad_militar FROM tabla_unidades_militares WHERE UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))) AND " +
          "(:idHistorialIntegranteSolicitudInfraestructura IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_historial_integrante_solicitud_infraestructura = :idHistorialIntegranteSolicitudInfraestructura) AND " +
          "(:idSolicitudInfraestructura IS NULL OR tabla_historial_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.num_reg_historial_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.nombres_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.primer_apellido_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.segundo_apellido_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.id_historial_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.id_historial_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.num_reg_historial_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.num_reg_historial_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'gradoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.grado_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'gradoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.grado_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombresIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.nombres_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombresIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.nombres_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.primer_apellido_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.primer_apellido_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.segundo_apellido_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.segundo_apellido_integrante_solicitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'cargoIntegranteSolicitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'cargoIntegranteSolicitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura END DESC", nativeQuery = true)
    Slice<HistorialIntegranteSolicitudInfraestructura> findAllHistorialesIntegrantesSolicitudesInfraestructurasPag(Pageable pageable, @Param("idHistorialIntegranteSolicitudInfraestructura") Long idHistorialIntegranteSolicitudInfraestructura, @Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialIntegranteSolicitudInfraestructura> findByIdHistorialIntegranteSolicitudInfraestructura(Long idHistorialIntegranteSolicitudInfraestructura);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialIntegranteSolicitudInfraestructura findByNumRegHistorialIntegranteSolicitudInfraestructura(String numRegHistorialIntegranteSolicitudInfraestructura);
    
    //BUSQUEDA DEL MISMO CARGO DE UNA MISMA UNIDAD MILITAR EN UNA MISMA SOLICITUD DE INFRAESTRUCTURA (NO SE PERMITE REGISTRAR DOS VECES EL MISMO CARGO DE LA MISMA UNIDAD MILITAR EN LA MISMA SOLICITUD; LA MISMA DENOMINACIÓN DE CARGO SÍ PUEDE REPETIRSE EN OTRA UNIDAD DE LA LÍNEA DE MANDO):
    @Query(value = "SELECT tabla_historial_integrantes_solicitudes_infraestructuras.* FROM tabla_historial_integrantes_solicitudes_infraestructuras " +
          "WHERE tabla_historial_integrantes_solicitudes_infraestructuras.id_solicitud_infraestructura = :idSolicitudInfraestructura AND " +
          "tabla_historial_integrantes_solicitudes_infraestructuras.id_unidad_militar = :idUnidadMilitar AND " +
          "UPPER(tabla_historial_integrantes_solicitudes_infraestructuras.cargo_integrante_solicitud_infraestructura) = UPPER(:cargoIntegranteSolicitudInfraestructura) AND ROWNUM = 1", nativeQuery = true)
    HistorialIntegranteSolicitudInfraestructura findBySolicitudInfraestructuraAndUnidadMilitarAndCargo(@Param("idSolicitudInfraestructura") Long idSolicitudInfraestructura, @Param("idUnidadMilitar") Long idUnidadMilitar, @Param("cargoIntegranteSolicitudInfraestructura") String cargoIntegranteSolicitudInfraestructura);
    
    @Query(value = "SELECT MAX(id_historial_integrante_solicitud_infraestructura) FROM tabla_historial_integrantes_solicitudes_infraestructuras", nativeQuery = true)
    Long findMaxIdHistorialIntegranteSolicitudInfraestructura();
}
