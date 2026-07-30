//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Seguro;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface SeguroRepository extends JpaRepository<Seguro,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ESTADO SEGURO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_seguros, tabla_aseguradoras, tabla_tipos_seguros " +
          "WHERE (:idSeguro IS NULL OR tabla_seguros.id_seguro = :idSeguro) AND " +
          "(tabla_seguros.id_aseguradora = tabla_aseguradoras.id_aseguradora) AND " +
          "(tabla_seguros.id_tipo_seguro = tabla_tipos_seguros.id_tipo_seguro) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_seguros.estado_seguro) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_aseguradoras.nombre_aseguradora) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_tipos_seguros.nombre_tipo_seguro) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:estadoSeguro IS NULL OR UPPER(tabla_seguros.estado_seguro) = UPPER(:estadoSeguro))", nativeQuery = true)
    Long findTotalRegistros(@Param("idSeguro") Long idSeguro, @Param("keyword") String keyword, @Param("estadoSeguro") String estadoSeguro);
    
    @Query(value = "SELECT tabla_seguros.* FROM tabla_seguros, tabla_aseguradoras, tabla_tipos_seguros " +
          "WHERE (:idSeguro IS NULL OR tabla_seguros.id_seguro = :idSeguro) AND " +
          "(tabla_seguros.id_aseguradora = tabla_aseguradoras.id_aseguradora) AND " +
          "(tabla_seguros.id_tipo_seguro = tabla_tipos_seguros.id_tipo_seguro) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_seguros.estado_seguro) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_aseguradoras.nombre_aseguradora) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_tipos_seguros.nombre_tipo_seguro) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:estadoSeguro IS NULL OR UPPER(tabla_seguros.estado_seguro) = UPPER(:estadoSeguro)) " +
          "ORDER BY CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.id_seguro END ASC, " +
          "CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.id_seguro END DESC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_seguros.id_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_seguros.id_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.id_tipo_seguro END ASC, " +
          "CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.id_tipo_seguro END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSInicioSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.fecha_h_m_s_inicio_seguro END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSInicioSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.fecha_h_m_s_inicio_seguro END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSExpiracionSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.fecha_h_m_s_expiracion_seguro END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSExpiracionSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.fecha_h_m_s_expiracion_seguro END DESC, " +
          "CASE WHEN :orderBy = 'estadoSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.estado_seguro END ASC, " +
          "CASE WHEN :orderBy = 'estadoSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.estado_seguro END DESC", nativeQuery = true)
    List<Seguro> findAllSeguros(@Param("idSeguro") Long idSeguro, @Param("keyword") String keyword, @Param("estadoSeguro") String estadoSeguro, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_seguros.* FROM tabla_seguros, tabla_aseguradoras, tabla_tipos_seguros " +
          "WHERE (:idSeguro IS NULL OR tabla_seguros.id_seguro = :idSeguro) AND " +
          "(tabla_seguros.id_aseguradora = tabla_aseguradoras.id_aseguradora) AND " +
          "(tabla_seguros.id_tipo_seguro = tabla_tipos_seguros.id_tipo_seguro) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_seguros.estado_seguro) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_aseguradoras.nombre_aseguradora) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_tipos_seguros.nombre_tipo_seguro) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:estadoSeguro IS NULL OR UPPER(tabla_seguros.estado_seguro) = UPPER(:estadoSeguro)) " +
          "ORDER BY CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.id_seguro END ASC, " +
          "CASE WHEN :orderBy = 'idSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.id_seguro END DESC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'ASC' THEN tabla_seguros.id_aseguradora END ASC, " +
          "CASE WHEN :orderBy = 'idAseguradora' AND :orderMode = 'DESC' THEN tabla_seguros.id_aseguradora END DESC, " +
          "CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.id_tipo_seguro END ASC, " +
          "CASE WHEN :orderBy = 'idTipoSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.id_tipo_seguro END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSInicioSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.fecha_h_m_s_inicio_seguro END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSInicioSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.fecha_h_m_s_inicio_seguro END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSExpiracionSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.fecha_h_m_s_expiracion_seguro END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSExpiracionSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.fecha_h_m_s_expiracion_seguro END DESC, " +
          "CASE WHEN :orderBy = 'estadoSeguro' AND :orderMode = 'ASC' THEN tabla_seguros.estado_seguro END ASC, " +
          "CASE WHEN :orderBy = 'estadoSeguro' AND :orderMode = 'DESC' THEN tabla_seguros.estado_seguro END DESC", nativeQuery = true)
    Slice<Seguro> findAllSegurosPag(Pageable pageable, @Param("idSeguro") Long idSeguro, @Param("keyword") String keyword, @Param("estadoSeguro") String estadoSeguro, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Seguro> findByIdSeguro(Long idSeguro);
    
    //BUSQUEDA UNITARIA POR CAMPOS ÚNICOS COMBINADOS (ID ASEGURADORA, ID TIPO SEGURO):
    @Query(value = "SELECT tabla_seguros.* FROM tabla_seguros " +
          "WHERE tabla_seguros.id_aseguradora = :idAseguradora AND " +
          "tabla_seguros.id_tipo_seguro = :idTipoSeguro", nativeQuery = true)
    Seguro findByIdAseguradoraAndIdTipoSeguro(@Param("idAseguradora") Long idAseguradora, @Param("idTipoSeguro") Long idTipoSeguro);
    
    //BUSQUEDA UNITARIA POR CAMPOS ÚNICOS COMBINADOS (NOMBRE ASEGURADORA, NOMBRE TIPO SEGURO):
    @Query(value = "SELECT tabla_seguros.* FROM tabla_seguros, tabla_aseguradoras, tabla_tipos_seguros " +
          "WHERE tabla_seguros.id_aseguradora = tabla_aseguradoras.id_aseguradora AND " +
          "tabla_seguros.id_tipo_seguro = tabla_tipos_seguros.id_tipo_seguro AND " +
          "UPPER(tabla_aseguradoras.nombre_aseguradora) = UPPER(:nombreAseguradora) AND " +
          "UPPER(tabla_tipos_seguros.nombre_tipo_seguro) = UPPER(:nombreTipoSeguro)", nativeQuery = true)
    Seguro findByNombreAseguradoraAndNombreTipoSeguro(@Param("nombreAseguradora") String nombreAseguradora, @Param("nombreTipoSeguro") String nombreTipoSeguro);
    
    @Query(value = "SELECT MAX(id_seguro) FROM tabla_seguros", nativeQuery = true)
    Long findMaxIdSeguro();
}
