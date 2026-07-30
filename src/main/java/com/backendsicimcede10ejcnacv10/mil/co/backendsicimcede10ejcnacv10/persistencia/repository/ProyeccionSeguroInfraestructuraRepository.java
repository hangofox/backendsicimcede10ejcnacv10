//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSeguroInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProyeccionSeguroInfraestructuraRepository extends JpaRepository<ProyeccionSeguroInfraestructura, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_proyecciones_seguros_infraestructuras " +
          "WHERE " +
          "(:idProyeccionSeguroInfraestructura IS NULL OR id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:valorSolicitadoProySegInfraest IS NULL OR UPPER(valor_solicitado_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoProySegInfraest || '%')) AND " +
          "(:valorSolicitadoTodoRiesgoProySegInfraest IS NULL OR UPPER(valor_solicitado_todo_riesgo_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoTodoRiesgoProySegInfraest || '%')) AND " +
          "(:valorSolicitadoRenegociacionProySegInfraest IS NULL OR UPPER(valor_solicitado_renegociacion_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoRenegociacionProySegInfraest || '%')) AND " +
          "(:keyword IS NULL OR UPPER(valor_solicitado_proy_seg_infraest) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura, @Param("idInfraestructura") Long idInfraestructura, @Param("valorSolicitadoProySegInfraest") String valorSolicitadoProySegInfraest, @Param("valorSolicitadoTodoRiesgoProySegInfraest") String valorSolicitadoTodoRiesgoProySegInfraest, @Param("valorSolicitadoRenegociacionProySegInfraest") String valorSolicitadoRenegociacionProySegInfraest, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_seguros_infraestructuras " +
          "WHERE " +
          "(:idProyeccionSeguroInfraestructura IS NULL OR id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:valorSolicitadoProySegInfraest IS NULL OR UPPER(valor_solicitado_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoProySegInfraest || '%')) AND " +
          "(:valorSolicitadoTodoRiesgoProySegInfraest IS NULL OR UPPER(valor_solicitado_todo_riesgo_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoTodoRiesgoProySegInfraest || '%')) AND " +
          "(:valorSolicitadoRenegociacionProySegInfraest IS NULL OR UPPER(valor_solicitado_renegociacion_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoRenegociacionProySegInfraest || '%')) AND " +
          "(:keyword IS NULL OR UPPER(valor_solicitado_proy_seg_infraest) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN id_proyeccion_seguro_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN id_proyeccion_seguro_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProySegInfraest' AND :orderMode = 'ASC' THEN valor_solicitado_proy_seg_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProySegInfraest' AND :orderMode = 'DESC' THEN valor_solicitado_proy_seg_infraest END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoTodoRiesgoProySegInfraest' AND :orderMode = 'ASC' THEN valor_solicitado_todo_riesgo_proy_seg_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoTodoRiesgoProySegInfraest' AND :orderMode = 'DESC' THEN valor_solicitado_todo_riesgo_proy_seg_infraest END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoRenegociacionProySegInfraest' AND :orderMode = 'ASC' THEN valor_solicitado_renegociacion_proy_seg_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoRenegociacionProySegInfraest' AND :orderMode = 'DESC' THEN valor_solicitado_renegociacion_proy_seg_infraest END DESC", nativeQuery = true)
    List<ProyeccionSeguroInfraestructura> findAllProyeccionesSegurosInfraestructuras(@Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura, @Param("idInfraestructura") Long idInfraestructura, @Param("valorSolicitadoProySegInfraest") String valorSolicitadoProySegInfraest, @Param("valorSolicitadoTodoRiesgoProySegInfraest") String valorSolicitadoTodoRiesgoProySegInfraest, @Param("valorSolicitadoRenegociacionProySegInfraest") String valorSolicitadoRenegociacionProySegInfraest, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_proyecciones_seguros_infraestructuras " +
          "WHERE " +
          "(:idProyeccionSeguroInfraestructura IS NULL OR id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura) AND " +
          "(:idInfraestructura IS NULL OR id_infraestructura = :idInfraestructura) AND " +
          "(:valorSolicitadoProySegInfraest IS NULL OR UPPER(valor_solicitado_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoProySegInfraest || '%')) AND " +
          "(:valorSolicitadoTodoRiesgoProySegInfraest IS NULL OR UPPER(valor_solicitado_todo_riesgo_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoTodoRiesgoProySegInfraest || '%')) AND " +
          "(:valorSolicitadoRenegociacionProySegInfraest IS NULL OR UPPER(valor_solicitado_renegociacion_proy_seg_infraest) LIKE UPPER('%' || :valorSolicitadoRenegociacionProySegInfraest || '%')) AND " +
          "(:keyword IS NULL OR UPPER(valor_solicitado_proy_seg_infraest) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN id_proyeccion_seguro_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN id_proyeccion_seguro_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN id_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProySegInfraest' AND :orderMode = 'ASC' THEN valor_solicitado_proy_seg_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProySegInfraest' AND :orderMode = 'DESC' THEN valor_solicitado_proy_seg_infraest END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoTodoRiesgoProySegInfraest' AND :orderMode = 'ASC' THEN valor_solicitado_todo_riesgo_proy_seg_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoTodoRiesgoProySegInfraest' AND :orderMode = 'DESC' THEN valor_solicitado_todo_riesgo_proy_seg_infraest END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoRenegociacionProySegInfraest' AND :orderMode = 'ASC' THEN valor_solicitado_renegociacion_proy_seg_infraest END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoRenegociacionProySegInfraest' AND :orderMode = 'DESC' THEN valor_solicitado_renegociacion_proy_seg_infraest END DESC", nativeQuery = true)
    Slice<ProyeccionSeguroInfraestructura> findAllProyeccionesSegurosInfraestructurasPag(Pageable pageable, @Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura, @Param("idInfraestructura") Long idInfraestructura, @Param("valorSolicitadoProySegInfraest") String valorSolicitadoProySegInfraest, @Param("valorSolicitadoTodoRiesgoProySegInfraest") String valorSolicitadoTodoRiesgoProySegInfraest, @Param("valorSolicitadoRenegociacionProySegInfraest") String valorSolicitadoRenegociacionProySegInfraest, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionSeguroInfraestructura> findByIdProyeccionSeguroInfraestructura(Long idProyeccionSeguroInfraestructura);
    
    //BUSQUEDA UNITARIA POR ID INFRAESTRUCTURA (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO DE PROYECCION SEGURO PARA LA MISMA INFRAESTRUCTURA):
    @Query(value = "SELECT * FROM tabla_proyecciones_seguros_infraestructuras " +
          "WHERE id_infraestructura = :idInfraestructura AND ROWNUM = 1", nativeQuery = true)
    ProyeccionSeguroInfraestructura findByInfraestructuraId(@Param("idInfraestructura") Long idInfraestructura);
    
    @Query(value = "SELECT MAX(id_proyeccion_seguro_infraestructura) FROM tabla_proyecciones_seguros_infraestructuras", nativeQuery = true)
    Long findMaxIdProyeccionSeguroInfraestructura();
}
