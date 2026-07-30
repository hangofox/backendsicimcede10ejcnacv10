//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaquinariaPesada;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface MaquinariaPesadaRepository extends JpaRepository<MaquinariaPesada,Long> {
    
    @Query(value = "SELECT * FROM tabla_maquinarias_pesadas " +
          "WHERE (:idMaquinariaPesada IS NULL OR id_maquinaria_pesada = :idMaquinariaPesada) " +
          "ORDER BY CASE WHEN :orderBy = 'idMaquinariaPesada' AND :orderMode = 'ASC' THEN id_maquinaria_pesada END ASC, " +
          "CASE WHEN :orderBy = 'idMaquinariaPesada' AND :orderMode = 'DESC' THEN id_maquinaria_pesada END DESC, " +
          "CASE WHEN :orderBy = 'nombreMaquinariaPesada' AND :orderMode = 'ASC' THEN nombre_maquinaria_pesada END ASC, " +
          "CASE WHEN :orderBy = 'nombreMaquinariaPesada' AND :orderMode = 'DESC' THEN nombre_maquinaria_pesada END DESC, " +
          "CASE WHEN :orderBy = 'empadronamientoMaquinariaPesada' AND :orderMode = 'ASC' THEN empadronamiento_maquinaria_pesada END ASC, " +
          "CASE WHEN :orderBy = 'empadronamientoMaquinariaPesada' AND :orderMode = 'DESC' THEN empadronamiento_maquinaria_pesada END DESC", nativeQuery = true)
    List<MaquinariaPesada> findAllMaquinariasPesadas(@Param("idMaquinariaPesada") Long idMaquinariaPesada, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_maquinarias_pesadas " +
          "WHERE (:idMaquinariaPesada IS NULL OR id_maquinaria_pesada = :idMaquinariaPesada) " +
          "ORDER BY CASE WHEN :orderBy = 'idMaquinariaPesada' AND :orderMode = 'ASC' THEN id_maquinaria_pesada END ASC, " +
          "CASE WHEN :orderBy = 'idMaquinariaPesada' AND :orderMode = 'DESC' THEN id_maquinaria_pesada END DESC, " +
          "CASE WHEN :orderBy = 'nombreMaquinariaPesada' AND :orderMode = 'ASC' THEN nombre_maquinaria_pesada END ASC, " +
          "CASE WHEN :orderBy = 'nombreMaquinariaPesada' AND :orderMode = 'DESC' THEN nombre_maquinaria_pesada END DESC, " +
          "CASE WHEN :orderBy = 'empadronamientoMaquinariaPesada' AND :orderMode = 'ASC' THEN empadronamiento_maquinaria_pesada END ASC, " +
          "CASE WHEN :orderBy = 'empadronamientoMaquinariaPesada' AND :orderMode = 'DESC' THEN empadronamiento_maquinaria_pesada END DESC", nativeQuery = true)
    Slice<MaquinariaPesada> findAllMaquinariasPesadasPag(Pageable pageable, @Param("idMaquinariaPesada") Long idMaquinariaPesada, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<MaquinariaPesada> findByIdMaquinariaPesada(Long idMaquinariaPesada);
    
    MaquinariaPesada findByNombreMaquinariaPesada(String nombreMaquinariaPesada);
    
    @Query(value = "SELECT MAX(id_maquinaria_pesada) FROM tabla_maquinarias_pesadas", nativeQuery = true)
    Long findMaxIdMaquinariaPesada();
}
