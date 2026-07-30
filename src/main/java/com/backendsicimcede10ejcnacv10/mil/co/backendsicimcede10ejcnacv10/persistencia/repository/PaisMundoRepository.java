//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PaisMundo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface PaisMundoRepository extends JpaRepository<PaisMundo,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_paises_mundo", nativeQuery = true)
    Long findTotalRegistros();
    
    @Query(value = "SELECT * FROM tabla_paises_mundo " +
           "ORDER BY CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'ASC' THEN id_pais_mundo END ASC, " +
           "CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'DESC' THEN id_pais_mundo END DESC, " +
           "CASE WHEN :orderBy = 'nombrePaisMundo' AND :orderMode = 'ASC' THEN nombre_pais_mundo END ASC, " +
           "CASE WHEN :orderBy = 'nombrePaisMundo' AND :orderMode = 'DESC' THEN nombre_pais_mundo END DESC", nativeQuery = true)
    List<PaisMundo> findAllPaisesMundo(@Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_paises_mundo " +
           "ORDER BY CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'ASC' THEN id_pais_mundo END ASC, " +
           "CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'DESC' THEN id_pais_mundo END DESC, " +
           "CASE WHEN :orderBy = 'nombrePaisMundo' AND :orderMode = 'ASC' THEN nombre_pais_mundo END ASC, " +
           "CASE WHEN :orderBy = 'nombrePaisMundo' AND :orderMode = 'DESC' THEN nombre_pais_mundo END DESC", nativeQuery = true)
    Slice<PaisMundo> findAllPaisesMundoPag(Pageable pageable, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<PaisMundo> findByIdPaisMundo(Long idPaisMundo);
    
    PaisMundo findByNombrePaisMundo(String nombrePaisMundo);
    
    @Query(value = "SELECT MAX(id_pais_mundo) FROM tabla_paises_mundo", nativeQuery = true)
    Long findMaxIdPaisMundo();
}
