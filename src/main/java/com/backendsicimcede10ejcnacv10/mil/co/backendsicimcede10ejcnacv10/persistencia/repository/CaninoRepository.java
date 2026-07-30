//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Canino;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface CaninoRepository extends JpaRepository<Canino, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE COMPAÑIA UNIDAD MILITAR + NOMBRE TIPO DESPEJE MILITAR ARTEFACTO EXPLOSIVO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_caninos, tabla_companias_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (tabla_caninos.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) " +
          "AND (tabla_caninos.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) " +
          "AND (:idCanino IS NULL OR tabla_caninos.id_canino = :idCanino) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_caninos.denominacion_canino) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_caninos.nombre_canino) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) " +
          "AND (:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo)", nativeQuery = true)
    Long findTotalRegistros(@Param("idCanino") Long idCanino, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo);
    
    @Query(value = "SELECT tabla_caninos.* FROM tabla_caninos, tabla_companias_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (tabla_caninos.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) " +
          "AND (tabla_caninos.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) " +
          "AND (:idCanino IS NULL OR tabla_caninos.id_canino = :idCanino) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_caninos.denominacion_canino) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_caninos.nombre_canino) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) " +
          "AND (:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo) " +
          "ORDER BY CASE WHEN :orderBy = 'idCanino' AND :orderMode = 'ASC' THEN tabla_caninos.id_canino END ASC, " +
          "CASE WHEN :orderBy = 'idCanino' AND :orderMode = 'DESC' THEN tabla_caninos.id_canino END DESC, " +
          "CASE WHEN :orderBy = 'denominacionCanino' AND :orderMode = 'ASC' THEN tabla_caninos.denominacion_canino END ASC, " +
          "CASE WHEN :orderBy = 'denominacionCanino' AND :orderMode = 'DESC' THEN tabla_caninos.denominacion_canino END DESC, " +
          "CASE WHEN :orderBy = 'numeroChipCanino' AND :orderMode = 'ASC' THEN tabla_caninos.numero_chip_canino END ASC, " +
          "CASE WHEN :orderBy = 'numeroChipCanino' AND :orderMode = 'DESC' THEN tabla_caninos.numero_chip_canino END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioCanino' AND :orderMode = 'ASC' THEN tabla_caninos.numero_inventario_canino END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioCanino' AND :orderMode = 'DESC' THEN tabla_caninos.numero_inventario_canino END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoCanino' AND :orderMode = 'ASC' THEN tabla_caninos.numero_activo_fijo_canino END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoCanino' AND :orderMode = 'DESC' THEN tabla_caninos.numero_activo_fijo_canino END DESC, " +
          "CASE WHEN :orderBy = 'nombreCanino' AND :orderMode = 'ASC' THEN tabla_caninos.nombre_canino END ASC, " +
          "CASE WHEN :orderBy = 'nombreCanino' AND :orderMode = 'DESC' THEN tabla_caninos.nombre_canino END DESC, " +
          "CASE WHEN :orderBy = 'colorCanino' AND :orderMode = 'ASC' THEN tabla_caninos.color_canino END ASC, " +
          "CASE WHEN :orderBy = 'colorCanino' AND :orderMode = 'DESC' THEN tabla_caninos.color_canino END DESC, " +
          "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'ASC' THEN tabla_caninos.nombre_raza_canino END ASC, " +
          "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'DESC' THEN tabla_caninos.nombre_raza_canino END DESC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionCanino' AND :orderMode = 'ASC' THEN tabla_caninos.valor_adquisicion_canino END ASC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionCanino' AND :orderMode = 'DESC' THEN tabla_caninos.valor_adquisicion_canino END DESC, " +
          "CASE WHEN :orderBy = 'valorContableCanino' AND :orderMode = 'ASC' THEN tabla_caninos.valor_contable_canino END ASC, " +
          "CASE WHEN :orderBy = 'valorContableCanino' AND :orderMode = 'DESC' THEN tabla_caninos.valor_contable_canino END DESC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioCanino' AND :orderMode = 'ASC' THEN tabla_caninos.valor_costo_unitario_canino END ASC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioCanino' AND :orderMode = 'DESC' THEN tabla_caninos.valor_costo_unitario_canino END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_caninos.centro_costo_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_caninos.centro_costo_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaCanino' AND :orderMode = 'ASC' THEN tabla_caninos.fecha_h_m_s_alta_canino END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaCanino' AND :orderMode = 'DESC' THEN tabla_caninos.fecha_h_m_s_alta_canino END DESC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilCanino' AND :orderMode = 'ASC' THEN tabla_caninos.tiempo_anual_vida_util_canino END ASC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilCanino' AND :orderMode = 'DESC' THEN tabla_caninos.tiempo_anual_vida_util_canino END DESC, " +
          "CASE WHEN :orderBy = 'descripcionCanino' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_caninos.descripcion_canino, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'descripcionCanino' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_caninos.descripcion_canino, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoCanino' AND :orderMode = 'ASC' THEN tabla_caninos.fecha_h_m_s_ingreso_canino END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoCanino' AND :orderMode = 'DESC' THEN tabla_caninos.fecha_h_m_s_ingreso_canino END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionCanino' AND :orderMode = 'ASC' THEN tabla_caninos.fecha_h_m_s_modificacion_canino END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionCanino' AND :orderMode = 'DESC' THEN tabla_caninos.fecha_h_m_s_modificacion_canino END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoCanino' AND :orderMode = 'ASC' THEN tabla_caninos.estado_uso_canino END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoCanino' AND :orderMode = 'DESC' THEN tabla_caninos.estado_uso_canino END DESC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN tabla_caninos.id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN tabla_caninos.id_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    List<Canino> findAllCaninos(@Param("idCanino") Long idCanino, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_caninos.* FROM tabla_caninos, tabla_companias_unidades_militares, tabla_tipos_despejes_militares_artefactos_explosivos " +
          "WHERE (tabla_caninos.id_compania_unidad_militar = tabla_companias_unidades_militares.id_compania_unidad_militar) " +
          "AND (tabla_caninos.id_tipo_despeje_militar_artefacto_explosivo = tabla_tipos_despejes_militares_artefactos_explosivos.id_tipo_despeje_militar_artefacto_explosivo) " +
          "AND (:idCanino IS NULL OR tabla_caninos.id_canino = :idCanino) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_caninos.denominacion_canino) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_caninos.nombre_canino) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_companias_unidades_militares.nombre_compania_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:nombreCompaniaUnidadMilitar IS NULL OR tabla_companias_unidades_militares.nombre_compania_unidad_militar = :nombreCompaniaUnidadMilitar) " +
          "AND (:nombreTipoDespejeMilitarArtefactoExplosivo IS NULL OR tabla_tipos_despejes_militares_artefactos_explosivos.nombre_tipo_despeje_militar_artefacto_explosivo = :nombreTipoDespejeMilitarArtefactoExplosivo) " +
          "ORDER BY CASE WHEN :orderBy = 'idCanino' AND :orderMode = 'ASC' THEN tabla_caninos.id_canino END ASC, " +
          "CASE WHEN :orderBy = 'idCanino' AND :orderMode = 'DESC' THEN tabla_caninos.id_canino END DESC, " +
          "CASE WHEN :orderBy = 'denominacionCanino' AND :orderMode = 'ASC' THEN tabla_caninos.denominacion_canino END ASC, " +
          "CASE WHEN :orderBy = 'denominacionCanino' AND :orderMode = 'DESC' THEN tabla_caninos.denominacion_canino END DESC, " +
          "CASE WHEN :orderBy = 'numeroChipCanino' AND :orderMode = 'ASC' THEN tabla_caninos.numero_chip_canino END ASC, " +
          "CASE WHEN :orderBy = 'numeroChipCanino' AND :orderMode = 'DESC' THEN tabla_caninos.numero_chip_canino END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioCanino' AND :orderMode = 'ASC' THEN tabla_caninos.numero_inventario_canino END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioCanino' AND :orderMode = 'DESC' THEN tabla_caninos.numero_inventario_canino END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoCanino' AND :orderMode = 'ASC' THEN tabla_caninos.numero_activo_fijo_canino END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoCanino' AND :orderMode = 'DESC' THEN tabla_caninos.numero_activo_fijo_canino END DESC, " +
          "CASE WHEN :orderBy = 'nombreCanino' AND :orderMode = 'ASC' THEN tabla_caninos.nombre_canino END ASC, " +
          "CASE WHEN :orderBy = 'nombreCanino' AND :orderMode = 'DESC' THEN tabla_caninos.nombre_canino END DESC, " +
          "CASE WHEN :orderBy = 'colorCanino' AND :orderMode = 'ASC' THEN tabla_caninos.color_canino END ASC, " +
          "CASE WHEN :orderBy = 'colorCanino' AND :orderMode = 'DESC' THEN tabla_caninos.color_canino END DESC, " +
          "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'ASC' THEN tabla_caninos.nombre_raza_canino END ASC, " +
          "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'DESC' THEN tabla_caninos.nombre_raza_canino END DESC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionCanino' AND :orderMode = 'ASC' THEN tabla_caninos.valor_adquisicion_canino END ASC, " +
          "CASE WHEN :orderBy = 'valorAdquisicionCanino' AND :orderMode = 'DESC' THEN tabla_caninos.valor_adquisicion_canino END DESC, " +
          "CASE WHEN :orderBy = 'valorContableCanino' AND :orderMode = 'ASC' THEN tabla_caninos.valor_contable_canino END ASC, " +
          "CASE WHEN :orderBy = 'valorContableCanino' AND :orderMode = 'DESC' THEN tabla_caninos.valor_contable_canino END DESC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioCanino' AND :orderMode = 'ASC' THEN tabla_caninos.valor_costo_unitario_canino END ASC, " +
          "CASE WHEN :orderBy = 'valorCostoUnitarioCanino' AND :orderMode = 'DESC' THEN tabla_caninos.valor_costo_unitario_canino END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_caninos.centro_costo_compania_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoCompaniaUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_caninos.centro_costo_compania_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaCanino' AND :orderMode = 'ASC' THEN tabla_caninos.fecha_h_m_s_alta_canino END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaCanino' AND :orderMode = 'DESC' THEN tabla_caninos.fecha_h_m_s_alta_canino END DESC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilCanino' AND :orderMode = 'ASC' THEN tabla_caninos.tiempo_anual_vida_util_canino END ASC, " +
          "CASE WHEN :orderBy = 'tiempoAnualVidaUtilCanino' AND :orderMode = 'DESC' THEN tabla_caninos.tiempo_anual_vida_util_canino END DESC, " +
          "CASE WHEN :orderBy = 'descripcionCanino' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_caninos.descripcion_canino, 4000, 1) END ASC, " +
          "CASE WHEN :orderBy = 'descripcionCanino' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_caninos.descripcion_canino, 4000, 1) END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoCanino' AND :orderMode = 'ASC' THEN tabla_caninos.fecha_h_m_s_ingreso_canino END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoCanino' AND :orderMode = 'DESC' THEN tabla_caninos.fecha_h_m_s_ingreso_canino END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionCanino' AND :orderMode = 'ASC' THEN tabla_caninos.fecha_h_m_s_modificacion_canino END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionCanino' AND :orderMode = 'DESC' THEN tabla_caninos.fecha_h_m_s_modificacion_canino END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoCanino' AND :orderMode = 'ASC' THEN tabla_caninos.estado_uso_canino END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoCanino' AND :orderMode = 'DESC' THEN tabla_caninos.estado_uso_canino END DESC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'ASC' THEN tabla_caninos.id_tipo_despeje_militar_artefacto_explosivo END ASC, " +
          "CASE WHEN :orderBy = 'idTipoDespejeMilitarArtefactoExplosivo' AND :orderMode = 'DESC' THEN tabla_caninos.id_tipo_despeje_militar_artefacto_explosivo END DESC", nativeQuery = true)
    Slice<Canino> findAllCaninosPag(Pageable pageable, @Param("idCanino") Long idCanino, @Param("keyword") String keyword, @Param("nombreCompaniaUnidadMilitar") String nombreCompaniaUnidadMilitar, @Param("nombreTipoDespejeMilitarArtefactoExplosivo") String nombreTipoDespejeMilitarArtefactoExplosivo, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Canino> findByIdCanino(Long idCanino);
    
    //BUSQUEDA POR CAMPOS ÚNICOS COMBINADOS (NUMERO CHIP, NUMERO INVENTARIO, NUMERO ACTIVO FIJO):
    //NOTA: SE RETORNA UNA LISTA PORQUE AL MODIFICAR UN REGISTRO ESTE PUEDE COINCIDIR CONSIGO MISMO EN UN CAMPO Y CON OTRO REGISTRO DIFERENTE EN OTRO CAMPO, DEVOLVIENDO MÁS DE UNA FILA.
    @Query(value = "SELECT tabla_caninos.* FROM tabla_caninos " +
          "WHERE ((:numeroChipCanino IS NOT NULL AND tabla_caninos.numero_chip_canino = :numeroChipCanino) " +
          "OR (:numeroInventarioCanino IS NOT NULL AND tabla_caninos.numero_inventario_canino = :numeroInventarioCanino) " +
          "OR (:numeroActivoFijoCanino IS NOT NULL AND tabla_caninos.numero_activo_fijo_canino = :numeroActivoFijoCanino))", nativeQuery = true)
    List<Canino> findByNumeroChipCaninoOrNumeroInventarioCaninoOrNumeroActivoFijoCanino(@Param("numeroChipCanino") String numeroChipCanino, @Param("numeroInventarioCanino") String numeroInventarioCanino, @Param("numeroActivoFijoCanino") String numeroActivoFijoCanino);
    
    @Query(value = "SELECT MAX(id_canino) FROM tabla_caninos", nativeQuery = true)
    Long findMaxIdCanino();
}
