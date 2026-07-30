//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SaneamientoBasico;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface SaneamientoBasicoRepository extends JpaRepository<SaneamientoBasico, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID SANEAMIENTO + KEYWORD + ID INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_saneamientos_basicos " +
          "WHERE (:idSaneamientoBasico IS NULL OR tabla_saneamientos_basicos.id_saneamiento_basico = :idSaneamientoBasico) AND " +
          "(:keyword IS NULL OR UPPER(tabla_saneamientos_basicos.nombre_caudal_saneamiento_basico) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idInfraestructura IS NULL OR tabla_saneamientos_basicos.id_infraestructura = :idInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idSaneamientoBasico") Long idSaneamientoBasico, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura);
    
    @Query(value = "SELECT tabla_saneamientos_basicos.* FROM tabla_saneamientos_basicos " +
          "WHERE (:idSaneamientoBasico IS NULL OR tabla_saneamientos_basicos.id_saneamiento_basico = :idSaneamientoBasico) AND " +
          "(:keyword IS NULL OR UPPER(tabla_saneamientos_basicos.nombre_caudal_saneamiento_basico) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idInfraestructura IS NULL OR tabla_saneamientos_basicos.id_infraestructura = :idInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.id_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'idSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.id_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'nombreCaudalSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.nombre_caudal_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'nombreCaudalSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.nombre_caudal_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.nombre_unidad_medida_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.nombre_unidad_medida_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.id_oficina END ASC, " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.id_oficina END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.centro_costo_oficina_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.centro_costo_oficina_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.id_infraestructura END DESC", nativeQuery = true)
    List<SaneamientoBasico> findAllSaneamientosBasicos(@Param("idSaneamientoBasico") Long idSaneamientoBasico, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_saneamientos_basicos.* FROM tabla_saneamientos_basicos " +
          "WHERE (:idSaneamientoBasico IS NULL OR tabla_saneamientos_basicos.id_saneamiento_basico = :idSaneamientoBasico) AND " +
          "(:keyword IS NULL OR UPPER(tabla_saneamientos_basicos.nombre_caudal_saneamiento_basico) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idInfraestructura IS NULL OR tabla_saneamientos_basicos.id_infraestructura = :idInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.id_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'idSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.id_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'nombreCaudalSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.nombre_caudal_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'nombreCaudalSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.nombre_caudal_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.nombre_unidad_medida_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'nombreUnidadMedidaSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.nombre_unidad_medida_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.id_oficina END ASC, " +
          "CASE WHEN :orderBy = 'idOficina' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.id_oficina END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaSaneamientoBasico' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.centro_costo_oficina_saneamiento_basico END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaSaneamientoBasico' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.centro_costo_oficina_saneamiento_basico END DESC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'ASC' THEN tabla_saneamientos_basicos.id_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idInfraestructura' AND :orderMode = 'DESC' THEN tabla_saneamientos_basicos.id_infraestructura END DESC", nativeQuery = true)
    Slice<SaneamientoBasico> findAllSaneamientosBasicosPag(Pageable pageable, @Param("idSaneamientoBasico") Long idSaneamientoBasico, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<SaneamientoBasico> findByIdSaneamientoBasico(Long idSaneamientoBasico);
    
    @Query(value = "SELECT MAX(id_saneamiento_basico) FROM tabla_saneamientos_basicos", nativeQuery = true)
    Long findMaxIdSaneamientoBasico();
}
