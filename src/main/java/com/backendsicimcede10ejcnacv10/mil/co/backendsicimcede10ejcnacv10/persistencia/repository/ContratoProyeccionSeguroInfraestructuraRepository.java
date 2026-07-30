// @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ. / @Since 15/04/2026.
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ContratoProyeccionSeguroInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ContratoProyeccionSeguroInfraestructuraRepository extends JpaRepository<ContratoProyeccionSeguroInfraestructura, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID CONTRATO + KEYWORD + ID PROYECCION SEGURO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_contratos_proyecciones_seguros_infraestructuras " +
            "WHERE (:idContratoProyeccionSeguroInfraestructura IS NULL OR tabla_contratos_proyecciones_seguros_infraestructuras.id_contrato_proyeccion_seguro_infraestructura = :idContratoProyeccionSeguroInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(tabla_contratos_proyecciones_seguros_infraestructuras.numero_contrato_seguro_infraestructura) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idProyeccionSeguroInfraestructura IS NULL OR tabla_contratos_proyecciones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura)", nativeQuery = true)
    Long findTotalRegistros(@Param("idContratoProyeccionSeguroInfraestructura") Long idContratoProyeccionSeguroInfraestructura, @Param("keyword") String keyword, @Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura);
    
    @Query(value = "SELECT tabla_contratos_proyecciones_seguros_infraestructuras.* FROM tabla_contratos_proyecciones_seguros_infraestructuras " +
            "WHERE (:idContratoProyeccionSeguroInfraestructura IS NULL OR tabla_contratos_proyecciones_seguros_infraestructuras.id_contrato_proyeccion_seguro_infraestructura = :idContratoProyeccionSeguroInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(tabla_contratos_proyecciones_seguros_infraestructuras.numero_contrato_seguro_infraestructura) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idProyeccionSeguroInfraestructura IS NULL OR tabla_contratos_proyecciones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura) " +
            "ORDER BY CASE WHEN :orderBy = 'idContratoProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_contrato_proyeccion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idContratoProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_contrato_proyeccion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'numeroContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.numero_contrato_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'numeroContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.numero_contrato_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_contrato_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_contrato_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_responsabilidad_contractual END ASC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_responsabilidad_contractual END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSContratoProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.fecha_h_m_s_contrato_proyeccion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSContratoProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.fecha_h_m_s_contrato_proyeccion_seguro_infraestructura END DESC", nativeQuery = true)
    List<ContratoProyeccionSeguroInfraestructura> findAllContratosProyeccionesSegurosInfraestructuras(@Param("idContratoProyeccionSeguroInfraestructura") Long idContratoProyeccionSeguroInfraestructura, @Param("keyword") String keyword, @Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_contratos_proyecciones_seguros_infraestructuras.* FROM tabla_contratos_proyecciones_seguros_infraestructuras " +
            "WHERE (:idContratoProyeccionSeguroInfraestructura IS NULL OR tabla_contratos_proyecciones_seguros_infraestructuras.id_contrato_proyeccion_seguro_infraestructura = :idContratoProyeccionSeguroInfraestructura) AND " +
            "(:keyword IS NULL OR UPPER(tabla_contratos_proyecciones_seguros_infraestructuras.numero_contrato_seguro_infraestructura) LIKE UPPER('%'||:keyword||'%')) AND " +
            "(:idProyeccionSeguroInfraestructura IS NULL OR tabla_contratos_proyecciones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura = :idProyeccionSeguroInfraestructura) " +
            "ORDER BY CASE WHEN :orderBy = 'idContratoProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_contrato_proyeccion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idContratoProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_contrato_proyeccion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'numeroContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.numero_contrato_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'numeroContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.numero_contrato_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_proyeccion_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_contrato_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'idTipoContratoSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_contrato_seguro_infraestructura END DESC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_responsabilidad_contractual END ASC, " +
            "CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.id_tipo_responsabilidad_contractual END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSContratoProyeccionSeguroInfraestructura' AND :orderMode = 'ASC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.fecha_h_m_s_contrato_proyeccion_seguro_infraestructura END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSContratoProyeccionSeguroInfraestructura' AND :orderMode = 'DESC' THEN tabla_contratos_proyecciones_seguros_infraestructuras.fecha_h_m_s_contrato_proyeccion_seguro_infraestructura END DESC", nativeQuery = true)
    Slice<ContratoProyeccionSeguroInfraestructura> findAllContratosProyeccionesSegurosInfraestructurasPag(Pageable pageable, @Param("idContratoProyeccionSeguroInfraestructura") Long idContratoProyeccionSeguroInfraestructura, @Param("keyword") String keyword, @Param("idProyeccionSeguroInfraestructura") Long idProyeccionSeguroInfraestructura, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ContratoProyeccionSeguroInfraestructura> findByIdContratoProyeccionSeguroInfraestructura(Long idContratoProyeccionSeguroInfraestructura);
    
    //BUSQUEDA UNITARIA POR NUMERO DE CONTRATO (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO CON EL MISMO NUMERO DE CONTRATO):
    @Query(value = "SELECT * FROM tabla_contratos_proyecciones_seguros_infraestructuras " +
          "WHERE numero_contrato_seguro_infraestructura = :numeroContratoSeguroInfraestructura AND ROWNUM = 1", nativeQuery = true)
    ContratoProyeccionSeguroInfraestructura findByNumeroContratoSeguroInfraestructura(@Param("numeroContratoSeguroInfraestructura") String numeroContratoSeguroInfraestructura);
    
    @Query(value = "SELECT MAX(id_contrato_proyeccion_seguro_infraestructura) FROM tabla_contratos_proyecciones_seguros_infraestructuras", nativeQuery = true)
    Long findMaxIdContratoProyeccionSeguroInfraestructura();
}
