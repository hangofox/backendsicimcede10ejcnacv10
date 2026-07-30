//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.QuimicoPiscina;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface QuimicoPiscinaRepository extends JpaRepository<QuimicoPiscina, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID QUIMICO PISCINA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_quimicos_piscinas " +
            "WHERE (:idQuimicoPiscina IS NULL OR id_quimico_piscina = :idQuimicoPiscina) AND " +
            "(:keyword IS NULL OR UPPER(nombre_quimico_piscina) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idQuimicoPiscina") Long idQuimicoPiscina, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_quimicos_piscinas " +
            "WHERE (:idQuimicoPiscina IS NULL OR id_quimico_piscina = :idQuimicoPiscina) AND " +
            "(:keyword IS NULL OR UPPER(nombre_quimico_piscina) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idQuimicoPiscina' AND :orderMode = 'ASC' THEN id_quimico_piscina END ASC, " +
            "CASE WHEN :orderBy = 'idQuimicoPiscina' AND :orderMode = 'DESC' THEN id_quimico_piscina END DESC, " +
            "CASE WHEN :orderBy = 'nombreQuimicoPiscina' AND :orderMode = 'ASC' THEN nombre_quimico_piscina END ASC, " +
            "CASE WHEN :orderBy = 'nombreQuimicoPiscina' AND :orderMode = 'DESC' THEN nombre_quimico_piscina END DESC", nativeQuery = true)
    List<QuimicoPiscina> findAllQuimicosPiscinas(@Param("idQuimicoPiscina") Long idQuimicoPiscina, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_quimicos_piscinas " +
            "WHERE (:idQuimicoPiscina IS NULL OR id_quimico_piscina = :idQuimicoPiscina) AND " +
            "(:keyword IS NULL OR UPPER(nombre_quimico_piscina) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idQuimicoPiscina' AND :orderMode = 'ASC' THEN id_quimico_piscina END ASC, " +
            "CASE WHEN :orderBy = 'idQuimicoPiscina' AND :orderMode = 'DESC' THEN id_quimico_piscina END DESC, " +
            "CASE WHEN :orderBy = 'nombreQuimicoPiscina' AND :orderMode = 'ASC' THEN nombre_quimico_piscina END ASC, " +
            "CASE WHEN :orderBy = 'nombreQuimicoPiscina' AND :orderMode = 'DESC' THEN nombre_quimico_piscina END DESC", nativeQuery = true)
    Slice<QuimicoPiscina> findAllQuimicosPiscinasPag(Pageable pageable, @Param("idQuimicoPiscina") Long idQuimicoPiscina, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<QuimicoPiscina> findByIdQuimicoPiscina(Long idQuimicoPiscina);
    
    QuimicoPiscina findByNombreQuimicoPiscina(String nombreQuimicoPiscina);
    
    @Query(value = "SELECT MAX(id_quimico_piscina) FROM tabla_quimicos_piscinas", nativeQuery = true)
    Long findMaxIdQuimicoPiscina();
}
