//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RegionDaneColombia;
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
public interface RegionDaneColombiaRepository extends JpaRepository<RegionDaneColombia,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_regiones_dane_colombia", nativeQuery = true)
    Long findTotalRegistros();
    
    @Query(value = "" +
          "SELECT " +
          "COUNT(*) " +
          "FROM " +
          "tabla_regiones_dane_colombia " +
          "WHERE " +
          "(nombre_pais_dane_colombia LIKE '%' || :keyword || '%' OR " +
          "nombre_departamento_dane_colombia LIKE '%' || :keyword || '%' OR " +
          "nombre_ciudad_municipio_dane_colombia LIKE '%' || :keyword || '%' OR " +
          "codigo_dane_colombia LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistrosByKeyword(@Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_regiones_dane_colombia " +
           "WHERE (:keyword IS NULL OR " +
           "nombre_pais_dane_colombia LIKE '%' || :keyword || '%' OR " +
           "nombre_departamento_dane_colombia LIKE '%' || :keyword || '%' OR " +
           "nombre_ciudad_municipio_dane_colombia LIKE '%' || :keyword || '%' OR " +
           "codigo_dane_colombia LIKE '%' || :keyword || '%') " +
           "ORDER BY CASE WHEN :orderBy = 'idRegionDaneColombia' AND :orderMode = 'ASC' THEN id_region_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'idRegionDaneColombia' AND :orderMode = 'DESC' THEN id_region_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'nombrePaisDaneColombia' AND :orderMode = 'ASC' THEN nombre_pais_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'nombrePaisDaneColombia' AND :orderMode = 'DESC' THEN nombre_pais_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'nombreDepartamentoDaneColombia' AND :orderMode = 'ASC' THEN nombre_departamento_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'nombreDepartamentoDaneColombia' AND :orderMode = 'DESC' THEN nombre_departamento_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'nombreCiudadMunicipioDaneColombia' AND :orderMode = 'ASC' THEN nombre_ciudad_municipio_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'nombreCiudadMunicipioDaneColombia' AND :orderMode = 'DESC' THEN nombre_ciudad_municipio_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'codigoDaneColombia' AND :orderMode = 'ASC' THEN codigo_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'codigoDaneColombia' AND :orderMode = 'DESC' THEN codigo_dane_colombia END DESC", nativeQuery = true)
    List<RegionDaneColombia> findAllRegionesDaneColombia(@Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_regiones_dane_colombia " +
           "WHERE (:keyword IS NULL OR " +
           "nombre_pais_dane_colombia LIKE '%' || :keyword || '%' OR " +
           "nombre_departamento_dane_colombia LIKE '%' || :keyword || '%' OR " +
           "nombre_ciudad_municipio_dane_colombia LIKE '%' || :keyword || '%' OR " +
           "codigo_dane_colombia LIKE '%' || :keyword || '%') " +
           "ORDER BY CASE WHEN :orderBy = 'idRegionDaneColombia' AND :orderMode = 'ASC' THEN id_region_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'idRegionDaneColombia' AND :orderMode = 'DESC' THEN id_region_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'nombrePaisDaneColombia' AND :orderMode = 'ASC' THEN nombre_pais_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'nombrePaisDaneColombia' AND :orderMode = 'DESC' THEN nombre_pais_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'nombreDepartamentoDaneColombia' AND :orderMode = 'ASC' THEN nombre_departamento_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'nombreDepartamentoDaneColombia' AND :orderMode = 'DESC' THEN nombre_departamento_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'nombreCiudadMunicipioDaneColombia' AND :orderMode = 'ASC' THEN nombre_ciudad_municipio_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'nombreCiudadMunicipioDaneColombia' AND :orderMode = 'DESC' THEN nombre_ciudad_municipio_dane_colombia END DESC, " +
           "CASE WHEN :orderBy = 'codigoDaneColombia' AND :orderMode = 'ASC' THEN codigo_dane_colombia END ASC, " +
           "CASE WHEN :orderBy = 'codigoDaneColombia' AND :orderMode = 'DESC' THEN codigo_dane_colombia END DESC", nativeQuery = true)
    Slice<RegionDaneColombia> findAllRegionesDaneColombiaPag(Pageable pageable, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<RegionDaneColombia> findByIdRegionDaneColombia(Long idRegionDaneColombia);
    
    RegionDaneColombia findByNombreCiudadMunicipioDaneColombia(String nombreCiudadMunicipioDaneColombia);
    
    RegionDaneColombia findByCodigoDaneColombia(String codigoDaneColombia);
    
    @Query(value = "SELECT MAX(id_region_dane_colombia) FROM tabla_regiones_dane_colombia", nativeQuery = true)
    Long findMaxIdRegionDaneColombia();
}
