//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.GradoSiath;
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
public interface GradoSiathRepository extends JpaRepository<GradoSiath,Long> {
    
    @Query(value = "SELECT * FROM tabla_grados_siath " +
           "WHERE (:idGradoSiath IS NULL OR id_grado_siath = :idGradoSiath) " +
           "ORDER BY CASE WHEN :orderBy = 'idGradoSiath' AND :orderMode = 'ASC' THEN id_grado_siath END ASC, " +
           "CASE WHEN :orderBy = 'idGradoSiath' AND :orderMode = 'DESC' THEN id_grado_siath END DESC, " +
           "CASE WHEN :orderBy = 'nombreGradoSiath' AND :orderMode = 'ASC' THEN nombre_grado_siath END ASC, " +
           "CASE WHEN :orderBy = 'nombreGradoSiath' AND :orderMode = 'DESC' THEN nombre_grado_siath END DESC, " +
           "CASE WHEN :orderBy = 'descripcionGradoSiath' AND :orderMode = 'ASC' THEN descripcion_grado_siath END ASC, " +
           "CASE WHEN :orderBy = 'descripcionGradoSiath' AND :orderMode = 'DESC' THEN descripcion_grado_siath END DESC, " +
           "CASE WHEN :orderBy = 'idSiath' AND :orderMode = 'ASC' THEN id_siath END ASC, " +
           "CASE WHEN :orderBy = 'idSiath' AND :orderMode = 'DESC' THEN id_siath END DESC, " +
           "CASE WHEN :orderBy = 'fuerzaSiath' AND :orderMode = 'ASC' THEN fuerza_siath END ASC, " +
           "CASE WHEN :orderBy = 'fuerzaSiath' AND :orderMode = 'DESC' THEN fuerza_siath END DESC, " +
           "CASE WHEN :orderBy = 'categoria' AND :orderMode = 'ASC' THEN categoria END ASC, " +
           "CASE WHEN :orderBy = 'categoria' AND :orderMode = 'DESC' THEN categoria END DESC, " +
           "CASE WHEN :orderBy = 'idCategoriaSiath' AND :orderMode = 'ASC' THEN id_categoria_siath END ASC, " +
           "CASE WHEN :orderBy = 'idCategoriaSiath' AND :orderMode = 'DESC' THEN id_categoria_siath END DESC, " +
           "CASE WHEN :orderBy = 'orden' AND :orderMode = 'ASC' THEN orden END ASC, " +
           "CASE WHEN :orderBy = 'orden' AND :orderMode = 'DESC' THEN orden END DESC, " +
           "CASE WHEN :orderBy = 'periodicidadConceptos' AND :orderMode = 'ASC' THEN periodicidad_conceptos END ASC, " +
           "CASE WHEN :orderBy = 'periodicidadConceptos' AND :orderMode = 'DESC' THEN periodicidad_conceptos END DESC", nativeQuery = true)
    List<GradoSiath> findAllGradosSiath(@Param("idGradoSiath") Long idGradoSiath, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_grados_siath " +
           "WHERE (:idGradoSiath IS NULL OR id_grado_siath = :idGradoSiath) " +
           "ORDER BY CASE WHEN :orderBy = 'idGradoSiath' AND :orderMode = 'ASC' THEN id_grado_siath END ASC, " +
           "CASE WHEN :orderBy = 'idGradoSiath' AND :orderMode = 'DESC' THEN id_grado_siath END DESC, " +
           "CASE WHEN :orderBy = 'nombreGradoSiath' AND :orderMode = 'ASC' THEN nombre_grado_siath END ASC, " +
           "CASE WHEN :orderBy = 'nombreGradoSiath' AND :orderMode = 'DESC' THEN nombre_grado_siath END DESC, " +
           "CASE WHEN :orderBy = 'descripcionGradoSiath' AND :orderMode = 'ASC' THEN descripcion_grado_siath END ASC, " +
           "CASE WHEN :orderBy = 'descripcionGradoSiath' AND :orderMode = 'DESC' THEN descripcion_grado_siath END DESC, " +
           "CASE WHEN :orderBy = 'idSiath' AND :orderMode = 'ASC' THEN id_siath END ASC, " +
           "CASE WHEN :orderBy = 'idSiath' AND :orderMode = 'DESC' THEN id_siath END DESC, " +
           "CASE WHEN :orderBy = 'fuerzaSiath' AND :orderMode = 'ASC' THEN fuerza_siath END ASC, " +
           "CASE WHEN :orderBy = 'fuerzaSiath' AND :orderMode = 'DESC' THEN fuerza_siath END DESC, " +
           "CASE WHEN :orderBy = 'categoria' AND :orderMode = 'ASC' THEN categoria END ASC, " +
           "CASE WHEN :orderBy = 'categoria' AND :orderMode = 'DESC' THEN categoria END DESC, " +
           "CASE WHEN :orderBy = 'idCategoriaSiath' AND :orderMode = 'ASC' THEN id_categoria_siath END ASC, " +
           "CASE WHEN :orderBy = 'idCategoriaSiath' AND :orderMode = 'DESC' THEN id_categoria_siath END DESC, " +
           "CASE WHEN :orderBy = 'orden' AND :orderMode = 'ASC' THEN orden END ASC, " +
           "CASE WHEN :orderBy = 'orden' AND :orderMode = 'DESC' THEN orden END DESC, " +
           "CASE WHEN :orderBy = 'periodicidadConceptos' AND :orderMode = 'ASC' THEN periodicidad_conceptos END ASC, " +
           "CASE WHEN :orderBy = 'periodicidadConceptos' AND :orderMode = 'DESC' THEN periodicidad_conceptos END DESC", nativeQuery = true)
    Slice<GradoSiath> findAllGradosSiathPag(Pageable pageable, @Param("idGradoSiath") Long idGradoSiath, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<GradoSiath> findByIdGradoSiath(Long idGradoSiath);
    
    //GradoSiath findByNombreGradoSiath(String nombreGradoSiath);
    
    @Query(value = "" +
          "SELECT " +
          "* " +
          "FROM " +
          "tabla_grados_siath " +
          "WHERE " +
          "(tabla_grados_siath.nombre_grado_siath = :nombreGradoSiath AND " +
          "tabla_grados_siath.fuerza_siath = :fuerzaSiath)", nativeQuery = true)
    GradoSiath findByNombreGradoSiathAndFuerzaSiath(@Param("nombreGradoSiath") String nombreGradoSiath, @Param("fuerzaSiath") Long fuerzaSiath);
    
    @Query(value = "SELECT MAX(id_grado_siath) FROM tabla_grados_siath", nativeQuery = true)
    Long findMaxIdGradoSiath();
}
