//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Terreno;
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
public interface TerrenoRepository extends JpaRepository<Terreno,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_terrenos, tabla_unidades_militares " +
          "WHERE (:idTerreno IS NULL OR tabla_terrenos.id_terreno = :idTerreno) AND " +
          "(tabla_terrenos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_terrenos.denominacion_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_terrenos.numero_inventario_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTerreno") Long idTerreno, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_terrenos.* FROM tabla_terrenos, tabla_unidades_militares " +
          "WHERE (:idTerreno IS NULL OR tabla_terrenos.id_terreno = :idTerreno) AND " +
          "(tabla_terrenos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_terrenos.denominacion_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_terrenos.numero_inventario_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.id_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.id_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_terrenos.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_terrenos.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_terrenos.id_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_terrenos.id_sociedad_unidad_centralizadora END DESC, " +
          "CASE WHEN :orderBy = 'denominacionTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.denominacion_terreno END ASC, " +
          "CASE WHEN :orderBy = 'denominacionTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.denominacion_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_inventario_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_inventario_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_activo_fijo_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_activo_fijo_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroCatastralTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_catastral_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroCatastralTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_catastral_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroEscrituraTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_escritura_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroEscrituraTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_escritura_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroNotariaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_notaria_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroNotariaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_notaria_terreno END DESC, " +
          "CASE WHEN :orderBy = 'lugarUbicacionNotariaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.lugar_ubicacion_notaria_terreno END ASC, " +
          "CASE WHEN :orderBy = 'lugarUbicacionNotariaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.lugar_ubicacion_notaria_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSMatriculaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_matricula_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSMatriculaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_matricula_terreno END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.pais_origen_terreno END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.pais_origen_terreno END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.departamento_o_estado_origen_terreno END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.departamento_o_estado_origen_terreno END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.ciudad_origen_terreno END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.ciudad_origen_terreno END DESC, " +
          "CASE WHEN :orderBy = 'direccionTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.direccion_terreno END ASC, " +
          "CASE WHEN :orderBy = 'direccionTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.direccion_terreno END DESC, " +
          "CASE WHEN :orderBy = 'latitudTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.latitud_terreno END ASC, " +
          "CASE WHEN :orderBy = 'latitudTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.latitud_terreno END DESC, " +
          "CASE WHEN :orderBy = 'longitudTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.longitud_terreno END ASC, " +
          "CASE WHEN :orderBy = 'longitudTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.longitud_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroAreaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_area_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroAreaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_area_terreno END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.nombre_unidad_medida_terreno END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.nombre_unidad_medida_terreno END DESC, " +
          "CASE WHEN :orderBy = 'siONoExoneradoImpuestoPredialTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.si_o_no_exonerado_impuesto_predial_terreno END ASC, " +
          "CASE WHEN :orderBy = 'siONoExoneradoImpuestoPredialTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.si_o_no_exonerado_impuesto_predial_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroAnosExoneracionImpuestoPredialTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_anos_exoneracion_impuesto_predial_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroAnosExoneracionImpuestoPredialTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_anos_exoneracion_impuesto_predial_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_alta_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_alta_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_ingreso_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_ingreso_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_modificacion_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_modificacion_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.id_estado_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.id_estado_terreno END DESC", nativeQuery = true)
    List<Terreno> findAllTerrenos(@Param("idTerreno") Long idTerreno, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_terrenos.* FROM tabla_terrenos, tabla_unidades_militares " +
          "WHERE (:idTerreno IS NULL OR tabla_terrenos.id_terreno = :idTerreno) AND " +
          "(tabla_terrenos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_terrenos.denominacion_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_terrenos.numero_inventario_terreno) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.id_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.id_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_terrenos.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_terrenos.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_terrenos.id_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_terrenos.id_sociedad_unidad_centralizadora END DESC, " +
          "CASE WHEN :orderBy = 'denominacionTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.denominacion_terreno END ASC, " +
          "CASE WHEN :orderBy = 'denominacionTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.denominacion_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_inventario_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_inventario_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_activo_fijo_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_activo_fijo_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroCatastralTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_catastral_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroCatastralTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_catastral_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroEscrituraTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_escritura_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroEscrituraTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_escritura_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroNotariaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_notaria_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroNotariaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_notaria_terreno END DESC, " +
          "CASE WHEN :orderBy = 'lugarUbicacionNotariaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.lugar_ubicacion_notaria_terreno END ASC, " +
          "CASE WHEN :orderBy = 'lugarUbicacionNotariaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.lugar_ubicacion_notaria_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSMatriculaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_matricula_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSMatriculaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_matricula_terreno END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.pais_origen_terreno END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.pais_origen_terreno END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.departamento_o_estado_origen_terreno END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.departamento_o_estado_origen_terreno END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.ciudad_origen_terreno END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.ciudad_origen_terreno END DESC, " +
          "CASE WHEN :orderBy = 'direccionTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.direccion_terreno END ASC, " +
          "CASE WHEN :orderBy = 'direccionTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.direccion_terreno END DESC, " +
          "CASE WHEN :orderBy = 'latitudTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.latitud_terreno END ASC, " +
          "CASE WHEN :orderBy = 'latitudTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.latitud_terreno END DESC, " +
          "CASE WHEN :orderBy = 'longitudTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.longitud_terreno END ASC, " +
          "CASE WHEN :orderBy = 'longitudTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.longitud_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroAreaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_area_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroAreaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_area_terreno END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.nombre_unidad_medida_terreno END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.nombre_unidad_medida_terreno END DESC, " +
          "CASE WHEN :orderBy = 'siONoExoneradoImpuestoPredialTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.si_o_no_exonerado_impuesto_predial_terreno END ASC, " +
          "CASE WHEN :orderBy = 'siONoExoneradoImpuestoPredialTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.si_o_no_exonerado_impuesto_predial_terreno END DESC, " +
          "CASE WHEN :orderBy = 'numeroAnosExoneracionImpuestoPredialTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.numero_anos_exoneracion_impuesto_predial_terreno END ASC, " +
          "CASE WHEN :orderBy = 'numeroAnosExoneracionImpuestoPredialTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.numero_anos_exoneracion_impuesto_predial_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_alta_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_alta_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_ingreso_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_ingreso_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.fecha_h_m_s_modificacion_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.fecha_h_m_s_modificacion_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'ASC' THEN tabla_terrenos.id_estado_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'DESC' THEN tabla_terrenos.id_estado_terreno END DESC", nativeQuery = true)
    Slice<Terreno> findAllTerrenosPag(Pageable pageable, @Param("idTerreno") Long idTerreno, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Terreno> findByIdTerreno(Long idTerreno);
    
    //BUSQUEDA UNITARIA POR CAMPOS ÚNICOS COMBINADOS (NUMERO INVENTARIO, NUMERO ACTIVO FIJO):
    @Query(value = "SELECT tabla_terrenos.* FROM tabla_terrenos " +
          "WHERE ((:numeroInventarioTerreno IS NOT NULL AND tabla_terrenos.numero_inventario_terreno = :numeroInventarioTerreno) OR " +
          "(:numeroActivoFijoTerreno IS NOT NULL AND tabla_terrenos.numero_activo_fijo_terreno = :numeroActivoFijoTerreno))", nativeQuery = true)
    Terreno findByNumeroInventarioTerrenoOrNumeroActivoFijoTerreno(@Param("numeroInventarioTerreno") String numeroInventarioTerreno, @Param("numeroActivoFijoTerreno") String numeroActivoFijoTerreno);
    
    @Query(value = "SELECT MAX(id_terreno) FROM tabla_terrenos", nativeQuery = true)
    Long findMaxIdTerreno();
}
