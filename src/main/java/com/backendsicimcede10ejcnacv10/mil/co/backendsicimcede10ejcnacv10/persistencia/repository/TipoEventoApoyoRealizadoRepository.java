//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEventoApoyoRealizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface TipoEventoApoyoRealizadoRepository extends JpaRepository<TipoEventoApoyoRealizado,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_eventos_apoyos_realizados WHERE (:idTipoEventoApoyoRealizado IS NULL OR id_tipo_evento_apoyo_realizado = :idTipoEventoApoyoRealizado) AND (:keyword IS NULL OR UPPER(nombre_tipo_evento_apoyo_realizado) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoEventoApoyoRealizado") Long idTipoEventoApoyoRealizado, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_eventos_apoyos_realizados WHERE (:idTipoEventoApoyoRealizado IS NULL OR id_tipo_evento_apoyo_realizado = :idTipoEventoApoyoRealizado) AND (:keyword IS NULL OR UPPER(nombre_tipo_evento_apoyo_realizado) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'ASC' THEN id_tipo_evento_apoyo_realizado END ASC, CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'DESC' THEN id_tipo_evento_apoyo_realizado END DESC, CASE WHEN :orderBy = 'nombreTipoEventoApoyoRealizado' AND :orderMode = 'ASC' THEN nombre_tipo_evento_apoyo_realizado END ASC, CASE WHEN :orderBy = 'nombreTipoEventoApoyoRealizado' AND :orderMode = 'DESC' THEN nombre_tipo_evento_apoyo_realizado END DESC", nativeQuery = true)
    List<TipoEventoApoyoRealizado> findAllTiposEventosApoyosRealizados(@Param("idTipoEventoApoyoRealizado") Long idTipoEventoApoyoRealizado, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_tipos_eventos_apoyos_realizados WHERE (:idTipoEventoApoyoRealizado IS NULL OR id_tipo_evento_apoyo_realizado = :idTipoEventoApoyoRealizado) AND (:keyword IS NULL OR UPPER(nombre_tipo_evento_apoyo_realizado) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'ASC' THEN id_tipo_evento_apoyo_realizado END ASC, CASE WHEN :orderBy = 'idTipoEventoApoyoRealizado' AND :orderMode = 'DESC' THEN id_tipo_evento_apoyo_realizado END DESC, CASE WHEN :orderBy = 'nombreTipoEventoApoyoRealizado' AND :orderMode = 'ASC' THEN nombre_tipo_evento_apoyo_realizado END ASC, CASE WHEN :orderBy = 'nombreTipoEventoApoyoRealizado' AND :orderMode = 'DESC' THEN nombre_tipo_evento_apoyo_realizado END DESC", nativeQuery = true)
    Slice<TipoEventoApoyoRealizado> findAllTiposEventosApoyosRealizadosPag(Pageable pageable, @Param("idTipoEventoApoyoRealizado") Long idTipoEventoApoyoRealizado, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoEventoApoyoRealizado> findByIdTipoEventoApoyoRealizado(Long idTipoEventoApoyoRealizado);
    
    TipoEventoApoyoRealizado findByNombreTipoEventoApoyoRealizado(String nombreTipoEventoApoyoRealizado);
    
    @Query(value = "SELECT MAX(id_tipo_evento_apoyo_realizado) FROM tabla_tipos_eventos_apoyos_realizados", nativeQuery = true)
    Long findMaxIdTipoEventoApoyoRealizado();
}
