//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoTopografia;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface EquipoTopografiaRepository extends JpaRepository<EquipoTopografia,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_equipos_topografias, tabla_unidades_militares " +
          "WHERE (tabla_equipos_topografias.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND (:idEquipoTopografia IS NULL OR tabla_equipos_topografias.id_equipo_topografia = :idEquipoTopografia) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_equipos_topografias.denominacion_equipo_topografia) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idEquipoTopografia") Long idEquipoTopografia, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_equipos_topografias.* FROM tabla_equipos_topografias, tabla_unidades_militares " +
          "WHERE (tabla_equipos_topografias.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND (:idEquipoTopografia IS NULL OR tabla_equipos_topografias.id_equipo_topografia = :idEquipoTopografia) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_equipos_topografias.denominacion_equipo_topografia) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idEquipoTopografia' AND :orderMode = 'ASC' THEN tabla_equipos_topografias.id_equipo_topografia END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoTopografia' AND :orderMode = 'DESC' THEN tabla_equipos_topografias.id_equipo_topografia END DESC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoTopografia' AND :orderMode = 'ASC' THEN tabla_equipos_topografias.denominacion_equipo_topografia END ASC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoTopografia' AND :orderMode = 'DESC' THEN tabla_equipos_topografias.denominacion_equipo_topografia END DESC", nativeQuery = true)
    List<EquipoTopografia> findAllEquiposTopografias(@Param("idEquipoTopografia") Long idEquipoTopografia, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_equipos_topografias.* FROM tabla_equipos_topografias, tabla_unidades_militares " +
          "WHERE (tabla_equipos_topografias.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND (:idEquipoTopografia IS NULL OR tabla_equipos_topografias.id_equipo_topografia = :idEquipoTopografia) " +
          "AND (:keyword IS NULL OR (UPPER(tabla_equipos_topografias.denominacion_equipo_topografia) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) " +
          "AND (:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idEquipoTopografia' AND :orderMode = 'ASC' THEN tabla_equipos_topografias.id_equipo_topografia END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoTopografia' AND :orderMode = 'DESC' THEN tabla_equipos_topografias.id_equipo_topografia END DESC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoTopografia' AND :orderMode = 'ASC' THEN tabla_equipos_topografias.denominacion_equipo_topografia END ASC, " +
          "CASE WHEN :orderBy = 'denominacionEquipoTopografia' AND :orderMode = 'DESC' THEN tabla_equipos_topografias.denominacion_equipo_topografia END DESC", nativeQuery = true)
    Slice<EquipoTopografia> findAllEquiposTopografiasPag(Pageable pageable, @Param("idEquipoTopografia") Long idEquipoTopografia, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<EquipoTopografia> findByIdEquipoTopografia(Long idEquipoTopografia);
    
    @Query(value = "SELECT tabla_equipos_topografias.* FROM tabla_equipos_topografias, tabla_unidades_militares " +
          "WHERE (tabla_equipos_topografias.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) " +
          "AND UPPER(tabla_equipos_topografias.denominacion_equipo_topografia) = UPPER(:denominacionEquipoTopografia) " +
          "AND UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    EquipoTopografia findByDenominacionEquipoTopografiaAndSiglaoAcronimoUnidadMilitar(@Param("denominacionEquipoTopografia") String denominacionEquipoTopografia, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT MAX(tabla_equipos_topografias.id_equipo_topografia) FROM tabla_equipos_topografias", nativeQuery = true)
    Long findMaxIdEquipoTopografia();
}
