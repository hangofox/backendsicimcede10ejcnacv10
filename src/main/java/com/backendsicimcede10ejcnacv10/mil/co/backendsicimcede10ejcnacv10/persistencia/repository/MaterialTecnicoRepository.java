//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaterialTecnico;
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
public interface MaterialTecnicoRepository extends JpaRepository<MaterialTecnico,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + NOMBRE TIPO DESPEJE MILITAR ARTEFACTO EXPLOSIVO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_materiales_tecnicos, tabla_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (:idMaterialTecnico IS NULL OR tabla_materiales_tecnicos.id_material_tecnico = :idMaterialTecnico) AND " +
          "(tabla_materiales_tecnicos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_materiales_tecnicos.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_materiales_tecnicos.nombre_material_tecnico) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) AND " +
          "(:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo)", nativeQuery = true)
    Long findTotalRegistros(@Param("idMaterialTecnico") Long idMaterialTecnico, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo);
    
    @Query(value = "SELECT tabla_materiales_tecnicos.* FROM tabla_materiales_tecnicos, tabla_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (:idMaterialTecnico IS NULL OR tabla_materiales_tecnicos.id_material_tecnico = :idMaterialTecnico) AND " +
          "(tabla_materiales_tecnicos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_materiales_tecnicos.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_materiales_tecnicos.nombre_material_tecnico) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) AND " +
          "(:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo) " +
          "ORDER BY CASE WHEN :orderBy = 'idMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.id_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'idMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.id_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'nombreMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.nombre_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'nombreMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.nombre_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'serialMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.serial_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'serialMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.serial_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.numero_inventario_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.numero_inventario_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.numero_activo_fijo_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.numero_activo_fijo_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.valor_adquisicion_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.valor_adquisicion_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'valorContableMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.valor_contable_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'valorContableMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.valor_contable_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.valor_costo_unitario_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.valor_costo_unitario_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'codigoContableMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.codigo_contable_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'codigoContableMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.codigo_contable_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.centro_costo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.centro_costo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.fecha_h_m_s_alta_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.fecha_h_m_s_alta_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.tiempo_anual_vida_util_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.tiempo_anual_vida_util_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.fecha_h_m_s_ingreso_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.fecha_h_m_s_ingreso_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.fecha_h_m_s_modificacion_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.fecha_h_m_s_modificacion_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.estado_uso_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.estado_uso_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.id_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    List<MaterialTecnico> findAllMaterialesTecnicos(@Param("idMaterialTecnico") Long idMaterialTecnico, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT tabla_materiales_tecnicos.* FROM tabla_materiales_tecnicos, tabla_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (:idMaterialTecnico IS NULL OR tabla_materiales_tecnicos.id_material_tecnico = :idMaterialTecnico) AND " +
          "(tabla_materiales_tecnicos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_materiales_tecnicos.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_materiales_tecnicos.nombre_material_tecnico) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) AND " +
          "(:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo) " +
          "ORDER BY CASE WHEN :orderBy = 'idMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.id_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'idMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.id_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'nombreMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.nombre_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'nombreMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.nombre_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'serialMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.serial_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'serialMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.serial_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.numero_inventario_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.numero_inventario_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.numero_activo_fijo_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.numero_activo_fijo_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.valor_adquisicion_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.valor_adquisicion_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'valorContableMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.valor_contable_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'valorContableMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.valor_contable_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.valor_costo_unitario_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.valor_costo_unitario_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'codigoContableMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.codigo_contable_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'codigoContableMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.codigo_contable_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.centro_costo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.centro_costo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.fecha_h_m_s_alta_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.fecha_h_m_s_alta_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.tiempo_anual_vida_util_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.tiempo_anual_vida_util_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.fecha_h_m_s_ingreso_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.fecha_h_m_s_ingreso_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.fecha_h_m_s_modificacion_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.fecha_h_m_s_modificacion_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoMaterialTecnico' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.estado_uso_material_tecnico END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoMaterialTecnico' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.estado_uso_material_tecnico END DESC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN tabla_materiales_tecnicos.id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN tabla_materiales_tecnicos.id_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    Slice<MaterialTecnico> findAllMaterialesTecnicosPag(Pageable pageable, @Param("idMaterialTecnico") Long idMaterialTecnico, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<MaterialTecnico> findByIdMaterialTecnico(Long idMaterialTecnico);
    
    //BUSQUEDA UNITARIA POR CAMPOS ÚNICOS COMBINADOS (NUMERO INVENTARIO, NUMERO ACTIVO FIJO):
    @Query(value = "SELECT tabla_materiales_tecnicos.* FROM tabla_materiales_tecnicos " +
          "WHERE ((:numeroInventarioMaterialTecnico IS NOT NULL AND tabla_materiales_tecnicos.numero_inventario_material_tecnico = :numeroInventarioMaterialTecnico) OR " +
          "(:numeroActivoFijoMaterialTecnico IS NOT NULL AND tabla_materiales_tecnicos.numero_activo_fijo_material_tecnico = :numeroActivoFijoMaterialTecnico))", nativeQuery = true)
    MaterialTecnico findByNumeroInventarioMaterialTecnicoOrNumeroActivoFijoMaterialTecnico(@Param("numeroInventarioMaterialTecnico") String numeroInventarioMaterialTecnico, @Param("numeroActivoFijoMaterialTecnico") String numeroActivoFijoMaterialTecnico);
    
    //BUSQUEDA UNITARIA POR NOMBRE DEL MATERIAL TECNICO Y SIGLA O ACRONIMO DE LA UNIDAD MILITAR (VALIDA QUE EL NOMBRE NO SE REPITA DENTRO DE LA MISMA UNIDAD MILITAR):
    @Query(value = "SELECT tabla_materiales_tecnicos.* FROM tabla_materiales_tecnicos, tabla_unidades_militares " +
          "WHERE (tabla_materiales_tecnicos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_materiales_tecnicos.nombre_material_tecnico = :nombreMaterialTecnico) AND " +
          "(tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    MaterialTecnico findByNombreMaterialTecnicoAndSAUnidadMilitar(@Param("nombreMaterialTecnico") String nombreMaterialTecnico, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT MAX(tabla_materiales_tecnicos.id_material_tecnico) FROM tabla_materiales_tecnicos", nativeQuery = true)
    Long findMaxIdMaterialTecnico();
}
