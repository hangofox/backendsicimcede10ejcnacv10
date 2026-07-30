//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SociedadUnidadCentralizadora;
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
public interface SociedadUnidadCentralizadoraRepository extends JpaRepository<SociedadUnidadCentralizadora, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRÓNIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_sociedades_unidades_centralizadoras, tabla_unidades_militares " +
          "WHERE (:idSociedadUnidadCentralizadora IS NULL OR tabla_sociedades_unidades_centralizadoras.id_sociedad_unidad_centralizadora = :idSociedadUnidadCentralizadora) AND " +
          "(tabla_sociedades_unidades_centralizadoras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_sociedades_unidades_centralizadoras.codigo_sociedad_unidad_centralizadora) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    Long findTotalRegistros(@Param("idSociedadUnidadCentralizadora") Long idSociedadUnidadCentralizadora, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_sociedades_unidades_centralizadoras.* FROM tabla_sociedades_unidades_centralizadoras, tabla_unidades_militares " +
          "WHERE (:idSociedadUnidadCentralizadora IS NULL OR tabla_sociedades_unidades_centralizadoras.id_sociedad_unidad_centralizadora = :idSociedadUnidadCentralizadora) AND " +
          "(tabla_sociedades_unidades_centralizadoras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_sociedades_unidades_centralizadoras.codigo_sociedad_unidad_centralizadora) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_sociedades_unidades_centralizadoras.id_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_sociedades_unidades_centralizadoras.id_sociedad_unidad_centralizadora END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'codigoSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_sociedades_unidades_centralizadoras.codigo_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'codigoSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_sociedades_unidades_centralizadoras.codigo_sociedad_unidad_centralizadora END DESC", nativeQuery = true)
    List<SociedadUnidadCentralizadora> findAllSociedadesUnidadesCentralizadoras(@Param("idSociedadUnidadCentralizadora") Long idSociedadUnidadCentralizadora, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_sociedades_unidades_centralizadoras.* FROM tabla_sociedades_unidades_centralizadoras, tabla_unidades_militares " +
          "WHERE (:idSociedadUnidadCentralizadora IS NULL OR tabla_sociedades_unidades_centralizadoras.id_sociedad_unidad_centralizadora = :idSociedadUnidadCentralizadora) AND " +
          "(tabla_sociedades_unidades_centralizadoras.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_unidades_militares.nombre_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_sociedades_unidades_centralizadoras.codigo_sociedad_unidad_centralizadora) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) " +
          "ORDER BY CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_sociedades_unidades_centralizadoras.id_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'idSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_sociedades_unidades_centralizadoras.id_sociedad_unidad_centralizadora END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'codigoSociedadUnidadCentralizadora' AND :orderMode = 'ASC' THEN tabla_sociedades_unidades_centralizadoras.codigo_sociedad_unidad_centralizadora END ASC, " +
          "CASE WHEN :orderBy = 'codigoSociedadUnidadCentralizadora' AND :orderMode = 'DESC' THEN tabla_sociedades_unidades_centralizadoras.codigo_sociedad_unidad_centralizadora END DESC", nativeQuery = true)
    Slice<SociedadUnidadCentralizadora> findAllSociedadesUnidadesCentralizadorasPag(Pageable pageable, @Param("idSociedadUnidadCentralizadora") Long idSociedadUnidadCentralizadora, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<SociedadUnidadCentralizadora> findByIdSociedadUnidadCentralizadora(Long idSociedadUnidadCentralizadora);
    
    @Query(value = "SELECT * FROM tabla_sociedades_unidades_centralizadoras WHERE codigo_sociedad_unidad_centralizadora = :codigoSociedadUnidadCentralizadora", nativeQuery = true)
    Optional<SociedadUnidadCentralizadora> findByCodigoSociedadUnidadCentralizadora(@Param("codigoSociedadUnidadCentralizadora") String codigoSociedadUnidadCentralizadora);
    
    @Query(value = "SELECT * FROM tabla_sociedades_unidades_centralizadoras WHERE id_unidad_militar = :idUnidadMilitar", nativeQuery = true)
    Optional<SociedadUnidadCentralizadora> findByIdUnidadMilitar(@Param("idUnidadMilitar") Long idUnidadMilitar);
    
    @Query(value = "SELECT MAX(id_sociedad_unidad_centralizadora) FROM tabla_sociedades_unidades_centralizadoras", nativeQuery = true)
    Long findMaxIdSociedadUnidadCentralizadora();
}
