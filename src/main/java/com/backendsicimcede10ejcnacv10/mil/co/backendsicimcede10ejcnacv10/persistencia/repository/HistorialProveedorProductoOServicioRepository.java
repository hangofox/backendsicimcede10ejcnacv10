//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialProveedorProductoOServicio;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 02/06/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialProveedorProductoOServicioRepository extends JpaRepository<HistorialProveedorProductoOServicio, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_proveedores_productos_o_servicios " +
          "WHERE (:idHistorialProveedorProductoOServicio IS NULL OR tabla_historial_proveedores_productos_o_servicios.id_historial_proveedor_producto_o_servicio = :idHistorialProveedorProductoOServicio) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proveedores_productos_o_servicios.num_reg_historial_proveedor_producto_o_servicio) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialProveedorProductoOServicio") Long idHistorialProveedorProductoOServicio, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_proveedores_productos_o_servicios.* FROM tabla_historial_proveedores_productos_o_servicios " +
          "WHERE (:idHistorialProveedorProductoOServicio IS NULL OR tabla_historial_proveedores_productos_o_servicios.id_historial_proveedor_producto_o_servicio = :idHistorialProveedorProductoOServicio) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proveedores_productos_o_servicios.num_reg_historial_proveedor_producto_o_servicio) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.id_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.id_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.num_reg_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.num_reg_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.numero_documento_identificacion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.numero_documento_identificacion_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.lugar_expedicion_documento_identificacion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.lugar_expedicion_documento_identificacion_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'nombresProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.nombres_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'nombresProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.nombres_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.primer_apellido_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.primer_apellido_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.segundo_apellido_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.segundo_apellido_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'direccionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.direccion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'direccionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.direccion_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'telefonoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.telefono_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'telefonoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.telefono_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'movilProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.movil_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'movilProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.movil_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_personal_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_personal_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_institucional_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_institucional_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.pais_origen_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.pais_origen_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.departamento_o_estado_origen_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.departamento_o_estado_origen_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.ciudad_origen_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.ciudad_origen_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_ingreso_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_ingreso_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_modificacion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_modificacion_prov_prod_o_serv END DESC", nativeQuery = true)
    List<HistorialProveedorProductoOServicio> findAllHistorialesProveedoresProductosOServicios(@Param("idHistorialProveedorProductoOServicio") Long idHistorialProveedorProductoOServicio, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_proveedores_productos_o_servicios.* FROM tabla_historial_proveedores_productos_o_servicios " +
          "WHERE (:idHistorialProveedorProductoOServicio IS NULL OR tabla_historial_proveedores_productos_o_servicios.id_historial_proveedor_producto_o_servicio = :idHistorialProveedorProductoOServicio) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_proveedores_productos_o_servicios.num_reg_historial_proveedor_producto_o_servicio) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.id_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.id_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.num_reg_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.num_reg_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.numero_documento_identificacion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.numero_documento_identificacion_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.lugar_expedicion_documento_identificacion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.lugar_expedicion_documento_identificacion_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'nombresProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.nombres_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'nombresProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.nombres_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.primer_apellido_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.primer_apellido_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.segundo_apellido_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.segundo_apellido_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'direccionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.direccion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'direccionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.direccion_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'telefonoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.telefono_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'telefonoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.telefono_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'movilProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.movil_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'movilProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.movil_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_personal_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_personal_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_institucional_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.correo_electronico_institucional_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.pais_origen_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.pais_origen_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.departamento_o_estado_origen_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'departamentoOEstadoOrigenProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.departamento_o_estado_origen_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.ciudad_origen_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.ciudad_origen_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_ingreso_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_ingreso_prov_prod_o_serv END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionProvProdOServ' AND :orderMode = 'ASC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_modificacion_prov_prod_o_serv END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionProvProdOServ' AND :orderMode = 'DESC' THEN tabla_historial_proveedores_productos_o_servicios.fecha_h_m_s_modificacion_prov_prod_o_serv END DESC", nativeQuery = true)
    Slice<HistorialProveedorProductoOServicio> findAllHistorialesProveedoresProductosOServiciosPag(Pageable pageable, @Param("idHistorialProveedorProductoOServicio") Long idHistorialProveedorProductoOServicio, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialProveedorProductoOServicio> findByIdHistorialProveedorProductoOServicio(Long idHistorialProveedorProductoOServicio);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialProveedorProductoOServicio findByNumRegHistorialProveedorProductoOServicio(String numRegHistorialProveedorProductoOServicio);

    //BUSQUEDA POR NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR:
    HistorialProveedorProductoOServicio findByNumeroDocumentoIdentificacionProvProdOServAndSiglaOAcronimoUnidadMilitar(String numeroDocumentoIdentificacionProvProdOServ, String siglaOAcronimoUnidadMilitar);

    @Query(value = "SELECT MAX(id_historial_proveedor_producto_o_servicio) FROM tabla_historial_proveedores_productos_o_servicios", nativeQuery = true)
    Long findMaxIdHistorialProveedorProductoOServicio();
}
