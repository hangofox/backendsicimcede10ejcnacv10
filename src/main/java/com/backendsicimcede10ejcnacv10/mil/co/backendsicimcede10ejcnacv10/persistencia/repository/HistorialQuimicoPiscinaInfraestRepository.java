//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialQuimicoPiscinaInfraest;
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
public interface HistorialQuimicoPiscinaInfraestRepository extends JpaRepository<HistorialQuimicoPiscinaInfraest, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID HISTORIAL QUIMICO PISCINA INFRAEST + ID INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_quimicos_piscinas_infraest " +
          "WHERE (:idHistorialQuimicoPiscinaInfraest IS NULL OR tabla_historial_quimicos_piscinas_infraest.id_historial_quimico_piscina_infraest = :idHistorialQuimicoPiscinaInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_quimicos_piscinas_infraest.num_reg_historial_quimico_piscina_infraest) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idInfraestructura IS NULL OR tabla_historial_quimicos_piscinas_infraest.id_infraestructura = :idInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialQuimicoPiscinaInfraest") Long idHistorialQuimicoPiscinaInfraest, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura);
    
    @Query(value = "SELECT tabla_historial_quimicos_piscinas_infraest.* FROM tabla_historial_quimicos_piscinas_infraest " +
          "WHERE (:idHistorialQuimicoPiscinaInfraest IS NULL OR tabla_historial_quimicos_piscinas_infraest.id_historial_quimico_piscina_infraest = :idHistorialQuimicoPiscinaInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_quimicos_piscinas_infraest.num_reg_historial_quimico_piscina_infraest) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idInfraestructura IS NULL OR tabla_historial_quimicos_piscinas_infraest.id_infraestructura = :idInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.id_historial_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.id_historial_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.num_reg_historial_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.num_reg_historial_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreHistorialQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.nombre_historial_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreHistorialQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.nombre_historial_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.centro_costo_oficina_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.centro_costo_oficina_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_ingreso_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_ingreso_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_modificacion_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_modificacion_quimico_piscina_infraest END DESC", nativeQuery = true)
    List<HistorialQuimicoPiscinaInfraest> findAllHistorialesQuimicosPiscinasInfraest(@Param("idHistorialQuimicoPiscinaInfraest") Long idHistorialQuimicoPiscinaInfraest, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_quimicos_piscinas_infraest.* FROM tabla_historial_quimicos_piscinas_infraest " +
          "WHERE (:idHistorialQuimicoPiscinaInfraest IS NULL OR tabla_historial_quimicos_piscinas_infraest.id_historial_quimico_piscina_infraest = :idHistorialQuimicoPiscinaInfraest) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_quimicos_piscinas_infraest.num_reg_historial_quimico_piscina_infraest) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idInfraestructura IS NULL OR tabla_historial_quimicos_piscinas_infraest.id_infraestructura = :idInfraestructura) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.id_historial_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.id_historial_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.num_reg_historial_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.num_reg_historial_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'nombreHistorialQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.nombre_historial_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'nombreHistorialQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.nombre_historial_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.centro_costo_oficina_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'centroCostoOficinaQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.centro_costo_oficina_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_ingreso_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_ingreso_quimico_piscina_infraest END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionQuimicoPiscinaInfraest' AND :orderMode = 'ASC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_modificacion_quimico_piscina_infraest END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionQuimicoPiscinaInfraest' AND :orderMode = 'DESC' THEN tabla_historial_quimicos_piscinas_infraest.fecha_h_m_s_modificacion_quimico_piscina_infraest END DESC", nativeQuery = true)
    Slice<HistorialQuimicoPiscinaInfraest> findAllHistorialesQuimicosPiscinasInfraestPag(Pageable pageable, @Param("idHistorialQuimicoPiscinaInfraest") Long idHistorialQuimicoPiscinaInfraest, @Param("keyword") String keyword, @Param("idInfraestructura") Long idInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialQuimicoPiscinaInfraest> findByIdHistorialQuimicoPiscinaInfraest(Long idHistorialQuimicoPiscinaInfraest);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialQuimicoPiscinaInfraest findByNumRegHistorialQuimicoPiscinaInfraest(String numRegHistorialQuimicoPiscinaInfraest);
    
    List<HistorialQuimicoPiscinaInfraest> findByNombreHistorialQuimicoPiscinaInfraest(String nombreHistorialQuimicoPiscinaInfraest);
    
    //BUSQUEDA UNITARIA POR NOMBRE DEL HISTORIAL Y DENOMINACIÓN DE LA INFRAESTRUCTURA (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT tabla_historial_quimicos_piscinas_infraest.* FROM tabla_historial_quimicos_piscinas_infraest, tabla_infraestructuras " +
          "WHERE (tabla_historial_quimicos_piscinas_infraest.id_infraestructura = tabla_infraestructuras.id_infraestructura) AND " +
          "(tabla_historial_quimicos_piscinas_infraest.nombre_historial_quimico_piscina_infraest = :nombreHistorialQuimicoPiscinaInfraest) AND " +
          "(tabla_infraestructuras.denominacion_infraestructura = :denominacionInfraestructura)", nativeQuery = true)
    HistorialQuimicoPiscinaInfraest findByNombreHistorialQuimicoPiscinaInfraestAndDenominacionInfraestructura(@Param("nombreHistorialQuimicoPiscinaInfraest") String nombreHistorialQuimicoPiscinaInfraest, @Param("denominacionInfraestructura") String denominacionInfraestructura);
    
    @Query(value = "SELECT MAX(id_historial_quimico_piscina_infraest) FROM tabla_historial_quimicos_piscinas_infraest", nativeQuery = true)
    Long findMaxIdHistorialQuimicoPiscinaInfraest();
}
