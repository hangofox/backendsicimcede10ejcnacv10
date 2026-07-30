//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitarRealizadoraMantenimiento;
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
public interface UnidadMilitarRealizadoraMantenimientoRepository extends JpaRepository<UnidadMilitarRealizadoraMantenimiento,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_unidades_militares_realizadoras_mantenimientos, tabla_unidades_militares " +
          "WHERE (tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND (:idUnidadMilitarRealizadoraMantenimiento IS NULL OR tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento = :idUnidadMilitarRealizadoraMantenimiento) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares_realizadoras_mantenimientos.codigo_unidad_militar_realizadora_mantenimiento) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    Long findTotalRegistros(@Param("idUnidadMilitarRealizadoraMantenimiento") Long idUnidadMilitarRealizadoraMantenimiento, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_unidades_militares_realizadoras_mantenimientos.* FROM tabla_unidades_militares_realizadoras_mantenimientos, tabla_unidades_militares " +
          "WHERE (tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND (:idUnidadMilitarRealizadoraMantenimiento IS NULL OR tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento = :idUnidadMilitarRealizadoraMantenimiento) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares_realizadoras_mantenimientos.codigo_unidad_militar_realizadora_mantenimiento) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'ASC' THEN tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'DESC' THEN tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento END DESC, " +
          "CASE WHEN :orderBy = 'codigoUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'ASC' THEN tabla_unidades_militares_realizadoras_mantenimientos.codigo_unidad_militar_realizadora_mantenimiento END ASC, " +
          "CASE WHEN :orderBy = 'codigoUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'DESC' THEN tabla_unidades_militares_realizadoras_mantenimientos.codigo_unidad_militar_realizadora_mantenimiento END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC", nativeQuery = true)
    List<UnidadMilitarRealizadoraMantenimiento> findAllUnidadesMilitaresRealizadorasMantenimientos(@Param("idUnidadMilitarRealizadoraMantenimiento") Long idUnidadMilitarRealizadoraMantenimiento, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_unidades_militares_realizadoras_mantenimientos.* FROM tabla_unidades_militares_realizadoras_mantenimientos, tabla_unidades_militares " +
          "WHERE (tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND (:idUnidadMilitarRealizadoraMantenimiento IS NULL OR tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento = :idUnidadMilitarRealizadoraMantenimiento) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares_realizadoras_mantenimientos.codigo_unidad_militar_realizadora_mantenimiento) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'ASC' THEN tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'DESC' THEN tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento END DESC, " +
          "CASE WHEN :orderBy = 'codigoUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'ASC' THEN tabla_unidades_militares_realizadoras_mantenimientos.codigo_unidad_militar_realizadora_mantenimiento END ASC, " +
          "CASE WHEN :orderBy = 'codigoUnidadMilitarRealizadoraMantenimiento' AND :orderMode = 'DESC' THEN tabla_unidades_militares_realizadoras_mantenimientos.codigo_unidad_militar_realizadora_mantenimiento END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC", nativeQuery = true)
    Slice<UnidadMilitarRealizadoraMantenimiento> findAllUnidadesMilitaresRealizadorasMantenimientosPag(Pageable pageable, @Param("idUnidadMilitarRealizadoraMantenimiento") Long idUnidadMilitarRealizadoraMantenimiento, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<UnidadMilitarRealizadoraMantenimiento> findByIdUnidadMilitarRealizadoraMantenimiento(Long idUnidadMilitarRealizadoraMantenimiento);
    
    @Query(value = "SELECT * FROM tabla_unidades_militares_realizadoras_mantenimientos WHERE codigo_unidad_militar_realizadora_mantenimiento = :codigoUnidadMilitarRealizadoraMantenimiento", nativeQuery = true)
    Optional<UnidadMilitarRealizadoraMantenimiento> findByCodigoUnidadMilitarRealizadoraMantenimiento(@Param("codigoUnidadMilitarRealizadoraMantenimiento") String codigoUnidadMilitarRealizadoraMantenimiento);
    
    @Query(value = "SELECT * FROM tabla_unidades_militares_realizadoras_mantenimientos WHERE id_unidad_militar = :idUnidadMilitar", nativeQuery = true)
    Optional<UnidadMilitarRealizadoraMantenimiento> findByIdUnidadMilitar(@Param("idUnidadMilitar") Long idUnidadMilitar);
    
    @Query(value = "SELECT MAX(tabla_unidades_militares_realizadoras_mantenimientos.id_unidad_militar_realizadora_mantenimiento) FROM tabla_unidades_militares_realizadoras_mantenimientos", nativeQuery = true)
    Long findMaxIdUnidadMilitarRealizadoraMantenimiento();
}
