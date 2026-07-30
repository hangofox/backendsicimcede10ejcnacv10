//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
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
public interface InfraestructuraRepository extends JpaRepository<Infraestructura,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_infraestructuras, tabla_unidades_militares " +
          "WHERE (tabla_infraestructuras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idInfraestructura IS NULL OR tabla_infraestructuras.id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_infraestructuras.denominacion_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_infraestructuras.numero_inventario_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_infraestructuras.* FROM tabla_infraestructuras, tabla_unidades_militares " +
          "WHERE (tabla_infraestructuras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idInfraestructura IS NULL OR tabla_infraestructuras.id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_infraestructuras.denominacion_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_infraestructuras.numero_inventario_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.denominacion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.denominacion_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_inventario_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_inventario_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_activo_fijo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_activo_fijo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitarInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.centro_costo_unidad_militar_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitarInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.centro_costo_unidad_militar_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_sociedad_unidad_centralizadora END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_tipo_estructura_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_tipo_estructura_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idFuncionalidadInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_funcionalidad_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidadInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_funcionalidad_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_seguro END ASC, " +
          "CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_seguro END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.pais_origen_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.pais_origen_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.departamento_o_estado_origen_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.departamento_o_estado_origen_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.ciudad_origen_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.ciudad_origen_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.direccion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.direccion_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAmortizacionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_amortizacion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAmortizacionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_amortizacion_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_alta_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_alta_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_largo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_largo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.nombre_unidad_medida_largo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.nombre_unidad_medida_largo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_anchura_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_anchura_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.nombre_unidad_medida_anchura_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.nombre_unidad_medida_anchura_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_profundidad_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_profundidad_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.nombre_unidad_medida_profundidad_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.nombre_unidad_medida_profundidad_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_pisos_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_pisos_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.estado_uso_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.estado_uso_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.latitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.latitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.longitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.longitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'normaSismoresistenteInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.norma_sismoresistente_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'normaSismoresistenteInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.norma_sismoresistente_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'propiedadHorizontalInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.propiedad_horizontal_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'propiedadHorizontalInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.propiedad_horizontal_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'denominacionPosteriorInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.denominacion_posterior_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'denominacionPosteriorInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.denominacion_posterior_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.estrato_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.estrato_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroCuentaInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_cuenta_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroCuentaInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_cuenta_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroSubcuentaInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_subcuenta_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroSubcuentaInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_subcuenta_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'valorContableInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.valor_contable_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'valorContableInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.valor_contable_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_ingreso_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_ingreso_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_modificacion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_modificacion_infraestructura END DESC", nativeQuery = true)
    List<Infraestructura> findAllInfraestructuras(@Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_infraestructuras.* FROM tabla_infraestructuras, tabla_unidades_militares " +
          "WHERE (tabla_infraestructuras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idInfraestructura IS NULL OR tabla_infraestructuras.id_infraestructura = :idInfraestructura) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_infraestructuras.denominacion_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_infraestructuras.numero_inventario_infraestructura) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.denominacion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.denominacion_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroInventarioInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_inventario_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroInventarioInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_inventario_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_activo_fijo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroActivoFijoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_activo_fijo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitarInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.centro_costo_unidad_militar_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoUnidadMilitarInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.centro_costo_unidad_militar_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_sociedad_unidad_centralizadora END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_tipo_estructura_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_tipo_estructura_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idFuncionalidadInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_funcionalidad_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidadInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_funcionalidad_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_seguro END ASC, " +
          "CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_seguro END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.pais_origen_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.pais_origen_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.departamento_o_estado_origen_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.departamento_o_estado_origen_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.ciudad_origen_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.ciudad_origen_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.direccion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.direccion_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAmortizacionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_amortizacion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAmortizacionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_amortizacion_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_alta_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSAltaInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_alta_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_largo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_largo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.nombre_unidad_medida_largo_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.nombre_unidad_medida_largo_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_anchura_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_anchura_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.nombre_unidad_medida_anchura_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.nombre_unidad_medida_anchura_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_profundidad_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_profundidad_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.nombre_unidad_medida_profundidad_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.nombre_unidad_medida_profundidad_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_pisos_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_pisos_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.estado_uso_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.estado_uso_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.latitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.latitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.longitud_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.longitud_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'normaSismoresistenteInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.norma_sismoresistente_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'normaSismoresistenteInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.norma_sismoresistente_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'propiedadHorizontalInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.propiedad_horizontal_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'propiedadHorizontalInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.propiedad_horizontal_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'denominacionPosteriorInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.denominacion_posterior_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'denominacionPosteriorInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.denominacion_posterior_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.estrato_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.estrato_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroCuentaInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_cuenta_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroCuentaInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_cuenta_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numeroSubcuentaInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.numero_subcuenta_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numeroSubcuentaInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.numero_subcuenta_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'valorContableInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.valor_contable_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'valorContableInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.valor_contable_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'ASC' THEN tabla_infraestructuras.id_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'DESC' THEN tabla_infraestructuras.id_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_ingreso_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_ingreso_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructura' AND :orderMode = 'ASC' THEN tabla_infraestructuras.fecha_h_m_s_modificacion_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructura' AND :orderMode = 'DESC' THEN tabla_infraestructuras.fecha_h_m_s_modificacion_infraestructura END DESC", nativeQuery = true)
    Slice<Infraestructura> findAllInfraestructurasPag(Pageable pageable, @Param("idInfraestructura") Long idInfraestructura, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Infraestructura> findByIdInfraestructura(Long idInfraestructura);
    
    //BUSQUEDA UNITARIA POR CAMPOS ÚNICOS COMBINADOS (NUMERO INVENTARIO, NUMERO ACTIVO FIJO):
    @Query(value = "SELECT tabla_infraestructuras.* FROM tabla_infraestructuras " +
          "WHERE ((:numeroInventarioInfraestructura IS NOT NULL AND tabla_infraestructuras.numero_inventario_infraestructura = :numeroInventarioInfraestructura) OR " +
          "(:numeroActivoFijoInfraestructura IS NOT NULL AND tabla_infraestructuras.numero_activo_fijo_infraestructura = :numeroActivoFijoInfraestructura))", nativeQuery = true)
    Infraestructura findByNumeroInventarioInfraestructuraOrNumeroActivoFijoInfraestructura(@Param("numeroInventarioInfraestructura") String numeroInventarioInfraestructura, @Param("numeroActivoFijoInfraestructura") String numeroActivoFijoInfraestructura);
    
    @Query(value = "SELECT MAX(id_infraestructura) FROM tabla_infraestructuras", nativeQuery = true)
    Long findMaxIdInfraestructura();
}
