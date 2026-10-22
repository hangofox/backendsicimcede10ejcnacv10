//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitar;
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
public interface LineaMandoUnidadMilitarRepository extends JpaRepository<LineaMandoUnidadMilitar,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_lineas_mandos_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_lineas_mandos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idLineaMandoUnidadMilitar IS NULL OR tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar = :idLineaMandoUnidadMilitar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idLineaMandoUnidadMilitar") Long idLineaMandoUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_lineas_mandos_unidades_militares.* FROM tabla_lineas_mandos_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_lineas_mandos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idLineaMandoUnidadMilitar IS NULL OR tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar = :idLineaMandoUnidadMilitar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idLineaMandoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idLineaMandoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar END DESC", nativeQuery = true)
    List<LineaMandoUnidadMilitar> findAllLineasMandosUnidadesMilitares(@Param("idLineaMandoUnidadMilitar") Long idLineaMandoUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_lineas_mandos_unidades_militares.* FROM tabla_lineas_mandos_unidades_militares, tabla_unidades_militares " +
          "WHERE (tabla_lineas_mandos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idLineaMandoUnidadMilitar IS NULL OR tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar = :idLineaMandoUnidadMilitar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idLineaMandoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idLineaMandoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'lineaMandoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar END DESC", nativeQuery = true)
    Slice<LineaMandoUnidadMilitar> findAllLineasMandosUnidadesMilitaresPag(Pageable pageable, @Param("idLineaMandoUnidadMilitar") Long idLineaMandoUnidadMilitar, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<LineaMandoUnidadMilitar> findByIdLineaMandoUnidadMilitar(Long idLineaMandoUnidadMilitar);
    
    @Query(value = "SELECT tabla_lineas_mandos_unidades_militares.* FROM tabla_lineas_mandos_unidades_militares, tabla_unidades_militares WHERE tabla_lineas_mandos_unidades_militares.id_unidad_militar = tabla_unidades_militares.id_unidad_militar AND UPPER(tabla_lineas_mandos_unidades_militares.linea_mando_unidad_militar) = UPPER(:lineaMandoUnidadMilitar) AND UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    LineaMandoUnidadMilitar findByLineaMandoUnidadMilitarAndSiglaoAcronimoUnidadMilitar(@Param("lineaMandoUnidadMilitar") String lineaMandoUnidadMilitar, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT * FROM tabla_lineas_mandos_unidades_militares WHERE id_unidad_militar = :idUnidadMilitar", nativeQuery = true)
    Optional<LineaMandoUnidadMilitar> findByIdUnidadMilitar(@Param("idUnidadMilitar") Long idUnidadMilitar);
    
    @Query(value = "SELECT MAX(tabla_lineas_mandos_unidades_militares.id_linea_mando_unidad_militar) FROM tabla_lineas_mandos_unidades_militares", nativeQuery = true)
    Long findMaxIdLineaMandoUnidadMilitar();
    
    //LÍNEAS DE MANDO QUE CONTIENEN LA SIGLA O ACRÓNIMO COMO UN PASO (ENTRE "->", "[" O "]" DE LOS FINALES ALTERNATIVOS, EJ.
    //"BAICC->BRICC->CAOCC->[SECEJ->CEDE10][CEDE10][JEMGF->COING]"); SE USA AL CAMBIAR LA SIGLA DE UNA UNIDAD MILITAR. LOS
    //CORCHETES SE CAMBIAN POR "->" SOLO PARA BUSCAR. EL "_" DE ALGUNAS SIGLAS ES COMODÍN EN LIKE, POR ESO EL SERVICIO VUELVE A
    //COMPARAR CADA PASO EXACTO ANTES DE REEMPLAZARLO:
    @Query(value = "SELECT * FROM tabla_lineas_mandos_unidades_militares WHERE ('->'||REPLACE(REPLACE(REPLACE(linea_mando_unidad_militar,' ',''),'[','->'),']','->')||'->') LIKE '%->'||:siglaoAcronimoUnidadMilitar||'->%'", nativeQuery = true)
    List<LineaMandoUnidadMilitar> findByPasoSiglaoAcronimoUnidadMilitar(@Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
}
