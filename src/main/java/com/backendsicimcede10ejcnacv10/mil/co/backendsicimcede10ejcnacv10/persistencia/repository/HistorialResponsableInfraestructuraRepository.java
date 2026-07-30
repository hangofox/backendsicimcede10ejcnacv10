//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialResponsableInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialResponsableInfraestructuraRepository extends JpaRepository<HistorialResponsableInfraestructura, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID INFRAESTRUCTURA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_responsables_infraestructuras " +
          "WHERE (:idHistorialResponsableInfraestructura IS NULL OR tabla_historial_responsables_infraestructuras.id_historial_responsable_infraestructura = :idHistorialResponsableInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_responsables_infraestructuras.num_reg_historial_responsable_infraestructura) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialResponsableInfraestructura") Long idHistorialResponsableInfraestructura, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_responsables_infraestructuras.* FROM tabla_historial_responsables_infraestructuras " +
          "WHERE (:idHistorialResponsableInfraestructura IS NULL OR tabla_historial_responsables_infraestructuras.id_historial_responsable_infraestructura = :idHistorialResponsableInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_responsables_infraestructuras.num_reg_historial_responsable_infraestructura) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialResponsableInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.id_historial_responsable_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialResponsableInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.id_historial_responsable_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialResponsableInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.num_reg_historial_responsable_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialResponsableInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.num_reg_historial_responsable_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.nombre_tipo_documento_identificacion END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.nombre_tipo_documento_identificacion END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.numero_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.numero_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.lugar_expedicion_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.lugar_expedicion_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.grado_responsable END ASC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.grado_responsable END DESC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.nombres_responsable END ASC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.nombres_responsable END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.primer_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.primer_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.segundo_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.segundo_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'siONoActualResponsablePredeterminado' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.si_o_no_actual_responsable_predeterminado END ASC, " +
          "CASE WHEN :orderBy = 'siONoActualResponsablePredeterminado' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.si_o_no_actual_responsable_predeterminado END DESC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.numero_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.numero_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.puesto_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.puesto_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.escalafon_antiguedad_responsable END ASC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.escalafon_antiguedad_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_ingreso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_ingreso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_modificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_modificacion_responsable END DESC", nativeQuery = true)
    List<HistorialResponsableInfraestructura> findAllHistorialesResponsablesInfraestructuras(@Param("idHistorialResponsableInfraestructura") Long idHistorialResponsableInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_responsables_infraestructuras.* FROM tabla_historial_responsables_infraestructuras " +
          "WHERE (:idHistorialResponsableInfraestructura IS NULL OR tabla_historial_responsables_infraestructuras.id_historial_responsable_infraestructura = :idHistorialResponsableInfraestructura) AND " +
          "(:keyword IS NULL OR UPPER(tabla_historial_responsables_infraestructuras.num_reg_historial_responsable_infraestructura) LIKE UPPER('%'||:keyword||'%')) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialResponsableInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.id_historial_responsable_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialResponsableInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.id_historial_responsable_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialResponsableInfraestructura' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.num_reg_historial_responsable_infraestructura END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialResponsableInfraestructura' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.num_reg_historial_responsable_infraestructura END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.nombre_tipo_documento_identificacion END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.nombre_tipo_documento_identificacion END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.numero_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.numero_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.lugar_expedicion_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.lugar_expedicion_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.grado_responsable END ASC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.grado_responsable END DESC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.nombres_responsable END ASC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.nombres_responsable END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.primer_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.primer_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.segundo_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.segundo_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'siONoActualResponsablePredeterminado' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.si_o_no_actual_responsable_predeterminado END ASC, " +
          "CASE WHEN :orderBy = 'siONoActualResponsablePredeterminado' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.si_o_no_actual_responsable_predeterminado END DESC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.numero_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.numero_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.puesto_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.puesto_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.escalafon_antiguedad_responsable END ASC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.escalafon_antiguedad_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_ingreso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_ingreso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'ASC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_modificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'DESC' THEN tabla_historial_responsables_infraestructuras.fecha_h_m_s_modificacion_responsable END DESC", nativeQuery = true)
    Slice<HistorialResponsableInfraestructura> findAllHistorialesResponsablesInfraestructurasPag(Pageable pageable, @Param("idHistorialResponsableInfraestructura") Long idHistorialResponsableInfraestructura, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialResponsableInfraestructura> findByIdHistorialResponsableInfraestructura(Long idHistorialResponsableInfraestructura);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialResponsableInfraestructura findByNumRegHistorialResponsableInfraestructura(String numRegHistorialResponsableInfraestructura);

    //BUSQUEDA POR NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR:
    HistorialResponsableInfraestructura findByNumeroDocumentoIdentificacionResponsableAndSiglaOAcronimoUnidadMilitar(String numeroDocumentoIdentificacionResponsable, String siglaOAcronimoUnidadMilitar);

    @Query(value = "SELECT MAX(id_historial_responsable_infraestructura) FROM tabla_historial_responsables_infraestructuras", nativeQuery = true)
    Long findMaxIdHistorialResponsableInfraestructura();
}
