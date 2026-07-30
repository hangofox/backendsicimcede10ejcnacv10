//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MunicionEspecial;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface MunicionEspecialRepository extends JpaRepository<MunicionEspecial, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE PELOTÓN UNIDAD MILITAR + NOMBRE TIPO DESPEJE MILITAR ARTEFACTO EXPLOSIVO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_municiones_especiales, tabla_pelotones_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (:idMunicionEspecial IS NULL OR tabla_municiones_especiales.id_municion_especial = :idMunicionEspecial) AND " +
          "(tabla_municiones_especiales.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(tabla_municiones_especiales.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_municiones_especiales.nombre_municion_especial) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_municiones_especiales.lote_municion_especial) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombrePelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo)", nativeQuery = true)
    Long findTotalRegistros(@Param("idMunicionEspecial") Long idMunicionEspecial, @Param("keyword") String keyword, @Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo);
    
    @Query(value = "SELECT tabla_municiones_especiales.* FROM tabla_municiones_especiales, tabla_pelotones_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (:idMunicionEspecial IS NULL OR tabla_municiones_especiales.id_municion_especial = :idMunicionEspecial) AND " +
          "(tabla_municiones_especiales.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(tabla_municiones_especiales.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_municiones_especiales.nombre_municion_especial) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_municiones_especiales.lote_municion_especial) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombrePelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo) " +
          "ORDER BY CASE WHEN :orderBy = 'idMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.id_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'idMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.id_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'nombreMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.nombre_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'nombreMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.nombre_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'cantidadMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.cantidad_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'cantidadMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.cantidad_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'loteMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.lote_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'loteMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.lote_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.valor_adquisicion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.valor_adquisicion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'valorContableMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.valor_contable_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'valorContableMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.valor_contable_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.fecha_h_m_s_alta_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.fecha_h_m_s_alta_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.id_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.id_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.centro_costo_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.centro_costo_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.fecha_h_m_s_ingreso_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.fecha_h_m_s_ingreso_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.fecha_h_m_s_modificacion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.fecha_h_m_s_modificacion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'estadoMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.estado_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'estadoMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.estado_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.id_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    List<MunicionEspecial> findAllMunicionesEspeciales(@Param("idMunicionEspecial") Long idMunicionEspecial, @Param("keyword") String keyword, @Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_municiones_especiales.* FROM tabla_municiones_especiales, tabla_pelotones_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (:idMunicionEspecial IS NULL OR tabla_municiones_especiales.id_municion_especial = :idMunicionEspecial) AND " +
          "(tabla_municiones_especiales.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(tabla_municiones_especiales.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_municiones_especiales.nombre_municion_especial) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_municiones_especiales.lote_municion_especial) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombrePelotonUnidadMilitar IS NULL OR tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo) " +
          "ORDER BY CASE WHEN :orderBy = 'idMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.id_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'idMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.id_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'nombreMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.nombre_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'nombreMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.nombre_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'cantidadMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.cantidad_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'cantidadMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.cantidad_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'loteMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.lote_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'loteMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.lote_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.valor_adquisicion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.valor_adquisicion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'valorContableMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.valor_contable_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'valorContableMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.valor_contable_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.fecha_h_m_s_alta_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.fecha_h_m_s_alta_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.id_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.id_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.centro_costo_peloton_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoPelotonUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.centro_costo_peloton_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.fecha_h_m_s_ingreso_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.fecha_h_m_s_ingreso_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.fecha_h_m_s_modificacion_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.fecha_h_m_s_modificacion_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'estadoMunicionEspecial' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.estado_municion_especial END ASC, " +
          "CASE WHEN :orderBy = 'estadoMunicionEspecial' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.estado_municion_especial END DESC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN tabla_municiones_especiales.id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN tabla_municiones_especiales.id_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    Slice<MunicionEspecial> findAllMunicionesEspecialesPag(Pageable pageable, @Param("idMunicionEspecial") Long idMunicionEspecial, @Param("keyword") String keyword, @Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<MunicionEspecial> findByIdMunicionEspecial(Long idMunicionEspecial);
    
    @Query(value = "SELECT tabla_municiones_especiales.* FROM tabla_municiones_especiales, tabla_pelotones_unidades_militares " +
          "WHERE (tabla_municiones_especiales.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) " +
          "AND (tabla_municiones_especiales.nombre_municion_especial = :nombreMunicionEspecial) " +
          "AND (tabla_municiones_especiales.lote_municion_especial = :loteMunicionEspecial)", nativeQuery = true)
    MunicionEspecial findByNombreMunicionEspecialAndLoteMunicionEspecial(@Param("nombreMunicionEspecial") String nombreMunicionEspecial, @Param("loteMunicionEspecial") String loteMunicionEspecial);
    
    @Query(value = "SELECT tabla_municiones_especiales.* FROM tabla_municiones_especiales, tabla_pelotones_unidades_militares " +
          "WHERE (tabla_municiones_especiales.id_peloton_unidad_militar = tabla_pelotones_unidades_militares.id_peloton_unidad_militar) AND " +
          "(tabla_pelotones_unidades_militares.nombre_peloton_unidad_militar = :nombrePelotonUnidadMilitar) AND " +
          "(tabla_municiones_especiales.nombre_municion_especial = :nombreMunicionEspecial)", nativeQuery = true)
    MunicionEspecial findByNombrePelotonUnidadMilitarAndNombreMunicionEspecial(@Param("nombrePelotonUnidadMilitar") String nombrePelotonUnidadMilitar, @Param("nombreMunicionEspecial") String nombreMunicionEspecial);
    
    @Query(value = "SELECT MAX(id_municion_especial) FROM tabla_municiones_especiales", nativeQuery = true)
    Long findMaxIdMunicionEspecial();
}
