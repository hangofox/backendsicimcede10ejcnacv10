//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ComodatoTerreno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ComodatoTerrenoRepository extends JpaRepository<ComodatoTerreno, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + IDTERRENO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_comodatos_terrenos " +
          "WHERE (:idComodatoTerreno IS NULL OR tabla_comodatos_terrenos.id_comodato_terreno = :idComodatoTerreno) AND " +
          "(:keyword IS NULL OR UPPER(tabla_comodatos_terrenos.estado_terreno) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idTerreno IS NULL OR tabla_comodatos_terrenos.id_terreno = :idTerreno)", nativeQuery = true)
    Long findTotalRegistros(@Param("idComodatoTerreno") Long idComodatoTerreno, @Param("keyword") String keyword, @Param("idTerreno") Long idTerreno);
    
    @Query(value = "SELECT tabla_comodatos_terrenos.* FROM tabla_comodatos_terrenos " +
          "WHERE (:idComodatoTerreno IS NULL OR tabla_comodatos_terrenos.id_comodato_terreno = :idComodatoTerreno) AND " +
          "(:keyword IS NULL OR UPPER(tabla_comodatos_terrenos.estado_terreno) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idTerreno IS NULL OR tabla_comodatos_terrenos.id_terreno = :idTerreno) " +
          "ORDER BY CASE WHEN :orderBy = 'idComodatoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.id_comodato_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idComodatoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.id_comodato_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.id_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.id_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionComodatoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.fecha_h_m_s_iniciacion_comodato_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionComodatoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.fecha_h_m_s_iniciacion_comodato_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionComodatoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.fecha_h_m_s_finalizacion_comodato_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionComodatoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.fecha_h_m_s_finalizacion_comodato_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.id_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.id_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'estadoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.estado_terreno END ASC, " +
          "CASE WHEN :orderBy = 'estadoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.estado_terreno END DESC", nativeQuery = true)
    List<ComodatoTerreno> findAllComodatosTerrenos(@Param("idComodatoTerreno") Long idComodatoTerreno, @Param("keyword") String keyword, @Param("idTerreno") Long idTerreno, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_comodatos_terrenos.* FROM tabla_comodatos_terrenos " +
          "WHERE (:idComodatoTerreno IS NULL OR tabla_comodatos_terrenos.id_comodato_terreno = :idComodatoTerreno) AND " +
          "(:keyword IS NULL OR UPPER(tabla_comodatos_terrenos.estado_terreno) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idTerreno IS NULL OR tabla_comodatos_terrenos.id_terreno = :idTerreno) " +
          "ORDER BY CASE WHEN :orderBy = 'idComodatoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.id_comodato_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idComodatoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.id_comodato_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.id_terreno END ASC, " +
          "CASE WHEN :orderBy = 'idTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.id_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionComodatoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.fecha_h_m_s_iniciacion_comodato_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIniciacionComodatoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.fecha_h_m_s_iniciacion_comodato_terreno END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionComodatoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.fecha_h_m_s_finalizacion_comodato_terreno END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSFinalizacionComodatoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.fecha_h_m_s_finalizacion_comodato_terreno END DESC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.id_historial_proveedor_producto_o_servicio END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialProveedorProductoOServicio' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.id_historial_proveedor_producto_o_servicio END DESC, " +
          "CASE WHEN :orderBy = 'estadoTerreno' AND :orderMode = 'ASC' THEN tabla_comodatos_terrenos.estado_terreno END ASC, " +
          "CASE WHEN :orderBy = 'estadoTerreno' AND :orderMode = 'DESC' THEN tabla_comodatos_terrenos.estado_terreno END DESC", nativeQuery = true)
    Slice<ComodatoTerreno> findAllComodatosTerrenosPag(Pageable pageable, @Param("idComodatoTerreno") Long idComodatoTerreno, @Param("keyword") String keyword, @Param("idTerreno") Long idTerreno, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ComodatoTerreno> findByIdComodatoTerreno(Long idComodatoTerreno);
    
    @Query(value = "SELECT MAX(id_comodato_terreno) FROM tabla_comodatos_terrenos", nativeQuery = true)
    Long findMaxIdComodatoTerreno();
}
