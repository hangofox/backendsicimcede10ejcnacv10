//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoTerreno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface EstadoTerrenoRepository extends JpaRepository<EstadoTerreno,Long> {
    
    @Query(value = "SELECT * FROM tabla_estados_terrenos " +
           "WHERE (:idEstadoTerreno IS NULL OR id_estado_terreno = :idEstadoTerreno) " +
           "ORDER BY CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'ASC' THEN id_estado_terreno END ASC, " +
           "CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'DESC' THEN id_estado_terreno END DESC, " +
           "CASE WHEN :orderBy = 'nombreEstadoTerreno' AND :orderMode = 'ASC' THEN nombre_estado_terreno END ASC, " +
           "CASE WHEN :orderBy = 'nombreEstadoTerreno' AND :orderMode = 'DESC' THEN nombre_estado_terreno END DESC", nativeQuery = true)
    List<EstadoTerreno> findAllEstadosTerrenos(@Param("idEstadoTerreno") Long idEstadoTerreno, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_estados_terrenos " +
           "WHERE (:idEstadoTerreno IS NULL OR id_estado_terreno = :idEstadoTerreno) " +
           "ORDER BY CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'ASC' THEN id_estado_terreno END ASC, " +
           "CASE WHEN :orderBy = 'idEstadoTerreno' AND :orderMode = 'DESC' THEN id_estado_terreno END DESC, " +
           "CASE WHEN :orderBy = 'nombreEstadoTerreno' AND :orderMode = 'ASC' THEN nombre_estado_terreno END ASC, " +
           "CASE WHEN :orderBy = 'nombreEstadoTerreno' AND :orderMode = 'DESC' THEN nombre_estado_terreno END DESC", nativeQuery = true)
    Slice<EstadoTerreno> findAllEstadosTerrenosPag(Pageable pageable, @Param("idEstadoTerreno") Long idEstadoTerreno, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<EstadoTerreno> findByIdEstadoTerreno(Long idEstadoTerreno);
    
    EstadoTerreno findByNombreEstadoTerreno(String nombreEstadoTerreno);
    
    @Query(value = "SELECT MAX(id_estado_terreno) FROM tabla_estados_terrenos", nativeQuery = true)
    Long findMaxIdEstadoTerreno();
}
