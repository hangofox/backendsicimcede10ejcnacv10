//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InfraestructuraArrendada;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface InfraestructuraArrendadaRepository extends JpaRepository<InfraestructuraArrendada, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_infraestructuras_arrendadas " +
          "WHERE (:idInfraestructuraArrendada IS NULL OR tabla_infraestructuras_arrendadas.id_infraestructura_arrendada = :idInfraestructuraArrendada) " +
          "AND (:keyword IS NULL OR UPPER(tabla_infraestructuras_arrendadas.denominacion_infraestructura_arrendada) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idInfraestructuraArrendada") Long idInfraestructuraArrendada, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_infraestructuras_arrendadas.* FROM tabla_infraestructuras_arrendadas " +
          "WHERE (:idInfraestructuraArrendada IS NULL OR tabla_infraestructuras_arrendadas.id_infraestructura_arrendada = :idInfraestructuraArrendada) " +
          "AND (:keyword IS NULL OR UPPER(tabla_infraestructuras_arrendadas.denominacion_infraestructura_arrendada) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.denominacion_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.denominacion_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_tipo_estructura_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_tipo_estructura_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.pais_origen_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.pais_origen_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.departamento_o_estado_origen_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.departamento_o_estado_origen_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.ciudad_origen_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.ciudad_origen_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.direccion_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.direccion_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_largo_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_largo_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_largo_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_largo_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_anchura_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_anchura_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_anchura_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_anchura_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_profundidad_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_profundidad_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_profundidad_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_profundidad_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_pisos_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_pisos_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.estado_uso_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.estado_uso_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.latitud_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.latitud_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.longitud_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.longitud_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.estrato_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.estrato_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_ingreso_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_ingreso_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_modificacion_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_modificacion_infraestructura_arrendada END DESC", nativeQuery = true)
    List<InfraestructuraArrendada> findAllInfraestructurasArrendadas(@Param("idInfraestructuraArrendada") Long idInfraestructuraArrendada, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_infraestructuras_arrendadas.* FROM tabla_infraestructuras_arrendadas " +
          "WHERE (:idInfraestructuraArrendada IS NULL OR tabla_infraestructuras_arrendadas.id_infraestructura_arrendada = :idInfraestructuraArrendada) " +
          "AND (:keyword IS NULL OR UPPER(tabla_infraestructuras_arrendadas.denominacion_infraestructura_arrendada) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.denominacion_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'denominacionInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.denominacion_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.id_tipo_estructura_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'idTipoEstructuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.id_tipo_estructura_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.pais_origen_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.pais_origen_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.departamento_o_estado_origen_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.departamento_o_estado_origen_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.ciudad_origen_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.ciudad_origen_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.direccion_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'direccionInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.direccion_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_largo_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroLargoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_largo_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_largo_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaLargoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_largo_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_anchura_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroAnchuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_anchura_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_anchura_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaAnchuraInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_anchura_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_profundidad_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroProfundidadInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_profundidad_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_profundidad_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaProfundidadInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.nombre_unidad_medida_profundidad_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.numero_pisos_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'numeroPisosInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.numero_pisos_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.estado_uso_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'estadoUsoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.estado_uso_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.latitud_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'latitudInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.latitud_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.longitud_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'longitudInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.longitud_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.estrato_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'estratoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.estrato_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_ingreso_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_ingreso_infraestructura_arrendada END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructuraArrendada' AND :orderMode = 'ASC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_modificacion_infraestructura_arrendada END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionInfraestructuraArrendada' AND :orderMode = 'DESC' THEN tabla_infraestructuras_arrendadas.fecha_h_m_s_modificacion_infraestructura_arrendada END DESC", nativeQuery = true)
    Slice<InfraestructuraArrendada> findAllInfraestructurasArrendadasPag(Pageable pageable, @Param("idInfraestructuraArrendada") Long idInfraestructuraArrendada, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<InfraestructuraArrendada> findByIdInfraestructuraArrendada(Long idInfraestructuraArrendada);
    
    @Query(value = "SELECT MAX(id_infraestructura_arrendada) FROM tabla_infraestructuras_arrendadas", nativeQuery = true)
    Long findMaxIdInfraestructuraArrendada();
}
