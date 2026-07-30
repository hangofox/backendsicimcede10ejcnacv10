//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RazaCanino;
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
public interface RazaCaninoRepository extends JpaRepository<RazaCanino,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "SELECT * FROM tabla_razas_caninos " +
           "WHERE (:idRazaCanino IS NULL OR id_raza_canino = :idRazaCanino) " +
           "AND (:keyword IS NULL OR UPPER(nombre_raza_canino) LIKE UPPER('%'||:keyword||'%')) " +
           "ORDER BY CASE WHEN :orderBy = 'idRazaCanino' AND :orderMode = 'ASC' THEN id_raza_canino END ASC, " +
           "CASE WHEN :orderBy = 'idRazaCanino' AND :orderMode = 'DESC' THEN id_raza_canino END DESC, " +
           "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'ASC' THEN nombre_raza_canino END ASC, " +
           "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'DESC' THEN nombre_raza_canino END DESC", nativeQuery = true)
    List<RazaCanino> findAllRazasCaninos(@Param("idRazaCanino") Long idRazaCanino, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_razas_caninos " +
           "WHERE (:idRazaCanino IS NULL OR id_raza_canino = :idRazaCanino) " +
           "AND (:keyword IS NULL OR UPPER(nombre_raza_canino) LIKE UPPER('%'||:keyword||'%')) " +
           "ORDER BY CASE WHEN :orderBy = 'idRazaCanino' AND :orderMode = 'ASC' THEN id_raza_canino END ASC, " +
           "CASE WHEN :orderBy = 'idRazaCanino' AND :orderMode = 'DESC' THEN id_raza_canino END DESC, " +
           "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'ASC' THEN nombre_raza_canino END ASC, " +
           "CASE WHEN :orderBy = 'nombreRazaCanino' AND :orderMode = 'DESC' THEN nombre_raza_canino END DESC", nativeQuery = true)
    Slice<RazaCanino> findAllRazasCaninosPag(Pageable pageable, @Param("idRazaCanino") Long idRazaCanino, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<RazaCanino> findByIdRazaCanino(Long idRazaCanino);
    
    RazaCanino findByNombreRazaCanino(String nombreRazaCanino);
    
    @Query(value = "SELECT MAX(id_raza_canino) FROM tabla_razas_caninos", nativeQuery = true)
    Long findMaxIdRazaCanino();
}
