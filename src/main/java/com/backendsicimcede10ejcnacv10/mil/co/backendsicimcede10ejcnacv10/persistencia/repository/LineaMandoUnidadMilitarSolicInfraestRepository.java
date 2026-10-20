//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitarSolicInfraest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface LineaMandoUnidadMilitarSolicInfraestRepository extends JpaRepository<LineaMandoUnidadMilitarSolicInfraest,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_lineas_mandos_unidades_militares_solic_infraest, tabla_unidades_militares " +
          "WHERE (tabla_lineas_mandos_unidades_militares_solic_infraest.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idLineaMandoUnidadMilitarSolicInfraest IS NULL OR tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest = :idLineaMandoUnidadMilitarSolicInfraest) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idLineaMandoUnidadMilitarSolicInfraest") Long idLineaMandoUnidadMilitarSolicInfraest, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_lineas_mandos_unidades_militares_solic_infraest.* FROM tabla_lineas_mandos_unidades_militares_solic_infraest, tabla_unidades_militares " +
          "WHERE (tabla_lineas_mandos_unidades_militares_solic_infraest.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idLineaMandoUnidadMilitarSolicInfraest IS NULL OR tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest = :idLineaMandoUnidadMilitarSolicInfraest) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idLineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idLineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest END DESC", nativeQuery = true)
    List<LineaMandoUnidadMilitarSolicInfraest> findAllLineasMandosUnidadesMilitaresSolicInfraest(@Param("idLineaMandoUnidadMilitarSolicInfraest") Long idLineaMandoUnidadMilitarSolicInfraest, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_lineas_mandos_unidades_militares_solic_infraest.* FROM tabla_lineas_mandos_unidades_militares_solic_infraest, tabla_unidades_militares " +
          "WHERE (tabla_lineas_mandos_unidades_militares_solic_infraest.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idLineaMandoUnidadMilitarSolicInfraest IS NULL OR tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest = :idLineaMandoUnidadMilitarSolicInfraest) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idLineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idLineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest END DESC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest END ASC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitarSolicInfraest' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest END DESC", nativeQuery = true)
    Slice<LineaMandoUnidadMilitarSolicInfraest> findAllLineasMandosUnidadesMilitaresSolicInfraestPag(Pageable pageable, @Param("idLineaMandoUnidadMilitarSolicInfraest") Long idLineaMandoUnidadMilitarSolicInfraest, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<LineaMandoUnidadMilitarSolicInfraest> findByIdLineaMandoUnidadMilitarSolicInfraest(Long idLineaMandoUnidadMilitarSolicInfraest);
    
    @Query(value = "SELECT tabla_lineas_mandos_unidades_militares_solic_infraest.* FROM tabla_lineas_mandos_unidades_militares_solic_infraest, tabla_unidades_militares WHERE tabla_lineas_mandos_unidades_militares_solic_infraest.id_unidad_militar = tabla_unidades_militares.id_unidad_militar AND UPPER(tabla_lineas_mandos_unidades_militares_solic_infraest.linea_mando_unidad_militar_solic_infraest) = UPPER(:lineaMandoUnidadMilitarSolicInfraest) AND UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    LineaMandoUnidadMilitarSolicInfraest findByLineaMandoUnidadMilitarSolicInfraestAndSiglaoAcronimoUnidadMilitar(@Param("lineaMandoUnidadMilitarSolicInfraest") String lineaMandoUnidadMilitarSolicInfraest, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT * FROM tabla_lineas_mandos_unidades_militares_solic_infraest WHERE id_unidad_militar = :idUnidadMilitar", nativeQuery = true)
    Optional<LineaMandoUnidadMilitarSolicInfraest> findByIdUnidadMilitar(@Param("idUnidadMilitar") Long idUnidadMilitar);
    
    @Query(value = "SELECT MAX(tabla_lineas_mandos_unidades_militares_solic_infraest.id_linea_mando_unidad_militar_solic_infraest) FROM tabla_lineas_mandos_unidades_militares_solic_infraest", nativeQuery = true)
    Long findMaxIdLineaMandoUnidadMilitarSolicInfraest();
}
