//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoOficina;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface CentroCostoOficinaRepository extends JpaRepository<CentroCostoOficina,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + NOMBRE OFICINA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_centros_costos_oficinas, tabla_oficinas, tabla_unidades_militares " +
          "WHERE (tabla_centros_costos_oficinas.id_oficina = tabla_oficinas.id_oficina) AND " +
          "(tabla_oficinas.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idCentroCostoOficina IS NULL OR tabla_centros_costos_oficinas.id_centro_costo_oficina = :idCentroCostoOficina) AND " +
          "(:keyword IS NULL OR (tabla_oficinas.nombre_oficina LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_centros_costos_oficinas.centro_costo_oficina LIKE '%' || :keyword || '%')) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:nombreOficina IS NULL OR tabla_oficinas.nombre_oficina = :nombreOficina)", nativeQuery = true)
    Long findTotalRegistros(@Param("idCentroCostoOficina") Long idCentroCostoOficina, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreOficina") String nombreOficina);
    
    @Query(value = "SELECT tabla_centros_costos_oficinas.* FROM tabla_centros_costos_oficinas, tabla_oficinas, tabla_unidades_militares " +
          "WHERE (tabla_centros_costos_oficinas.id_oficina = tabla_oficinas.id_oficina) AND " +
          "(tabla_oficinas.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idCentroCostoOficina IS NULL OR tabla_centros_costos_oficinas.id_centro_costo_oficina = :idCentroCostoOficina) AND " +
          "(:keyword IS NULL OR (tabla_oficinas.nombre_oficina LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_centros_costos_oficinas.centro_costo_oficina LIKE '%' || :keyword || '%')) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:nombreOficina IS NULL OR tabla_oficinas.nombre_oficina = :nombreOficina) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idCentroCostoOficina' AND :orderMode = 'ASC' THEN tabla_centros_costos_oficinas.id_centro_costo_oficina END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoOficina' AND :orderMode = 'DESC' THEN tabla_centros_costos_oficinas.id_centro_costo_oficina END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoOficina' AND :orderMode = 'ASC' THEN tabla_centros_costos_oficinas.centro_costo_oficina END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoOficina' AND :orderMode = 'DESC' THEN tabla_centros_costos_oficinas.centro_costo_oficina END DESC", nativeQuery = true)
    List<CentroCostoOficina> findAllCentrosCostosOficinas(@Param("idCentroCostoOficina") Long idCentroCostoOficina, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreOficina") String nombreOficina, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_centros_costos_oficinas.* FROM tabla_centros_costos_oficinas, tabla_oficinas, tabla_unidades_militares " +
          "WHERE (tabla_centros_costos_oficinas.id_oficina = tabla_oficinas.id_oficina) AND " +
          "(tabla_oficinas.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:idCentroCostoOficina IS NULL OR tabla_centros_costos_oficinas.id_centro_costo_oficina = :idCentroCostoOficina) AND " +
          "(:keyword IS NULL OR (tabla_oficinas.nombre_oficina LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_centros_costos_oficinas.centro_costo_oficina LIKE '%' || :keyword || '%')) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:nombreOficina IS NULL OR tabla_oficinas.nombre_oficina = :nombreOficina) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idCentroCostoOficina' AND :orderMode = 'ASC' THEN tabla_centros_costos_oficinas.id_centro_costo_oficina END ASC, " +
          "CASE WHEN :orderBy = 'idCentroCostoOficina' AND :orderMode = 'DESC' THEN tabla_centros_costos_oficinas.id_centro_costo_oficina END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoOficina' AND :orderMode = 'ASC' THEN tabla_centros_costos_oficinas.centro_costo_oficina END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoOficina' AND :orderMode = 'DESC' THEN tabla_centros_costos_oficinas.centro_costo_oficina END DESC", nativeQuery = true)
    Slice<CentroCostoOficina> findAllCentrosCostosOficinasPag(Pageable pageable, @Param("idCentroCostoOficina") Long idCentroCostoOficina, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("nombreOficina") String nombreOficina, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CentroCostoOficina> findByIdCentroCostoOficina(Long idCentroCostoOficina);
    
    CentroCostoOficina findByCentroCostoOficina(String centroCostoOficina);
    
    @Query(value = "SELECT tabla_centros_costos_oficinas.* FROM tabla_centros_costos_oficinas, tabla_oficinas WHERE tabla_centros_costos_oficinas.id_oficina = tabla_oficinas.id_oficina AND UPPER(tabla_centros_costos_oficinas.centro_costo_oficina) = UPPER(:centroCostoOficina) AND UPPER(tabla_oficinas.nombre_oficina) = UPPER(:nombreOficina)", nativeQuery = true)
    CentroCostoOficina findByCentroCostoOficinaAndNombreOficina(@Param("centroCostoOficina") String centroCostoOficina, @Param("nombreOficina") String nombreOficina);
    
    @Query(value = "SELECT MAX(id_centro_costo_oficina) FROM tabla_centros_costos_oficinas", nativeQuery = true)
    Long findMaxIdCentroCostoOficina();
}
