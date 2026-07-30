//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialIntegranteDocumentos;
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
public interface HistorialIntegranteDocumentosRepository extends JpaRepository<HistorialIntegranteDocumentos, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_integrantes_documentos " +
            "WHERE (:idHistorialIntegranteDocumentos IS NULL OR tabla_historial_integrantes_documentos.id_historial_integrante_documentos = :idHistorialIntegranteDocumentos) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_integrantes_documentos.num_reg_historial_integrante_documentos) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialIntegranteDocumentos") Long idHistorialIntegranteDocumentos, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_integrantes_documentos.* FROM tabla_historial_integrantes_documentos " +
            "WHERE (:idHistorialIntegranteDocumentos IS NULL OR tabla_historial_integrantes_documentos.id_historial_integrante_documentos = :idHistorialIntegranteDocumentos) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_integrantes_documentos.num_reg_historial_integrante_documentos) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.id_historial_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.id_historial_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.num_reg_historial_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.num_reg_historial_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'gradoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.grado_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'gradoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.grado_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'nombresYApellidosIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.nombres_y_apellidos_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'nombresYApellidosIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.nombres_y_apellidos_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'cargoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.cargo_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'cargoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.cargo_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.numero_documento_identificacion_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.numero_documento_identificacion_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'siONoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.si_o_no_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'siONoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.si_o_no_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'siONoActualIntegranteDocumentosPredeterminado' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.si_o_no_actual_integrante_documentos_predeterminado END ASC, " +
            "CASE WHEN :orderBy = 'siONoActualIntegranteDocumentosPredeterminado' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.si_o_no_actual_integrante_documentos_predeterminado END DESC, " +
            "CASE WHEN :orderBy = 'numeroCursoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.numero_curso_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'numeroCursoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.numero_curso_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'puestoCursoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.puesto_curso_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'puestoCursoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.puesto_curso_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'escalafonAntiguedadIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.escalafon_antiguedad_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'escalafonAntiguedadIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.escalafon_antiguedad_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIngresoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_ingreso_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIngresoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_ingreso_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSModificacionIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_modificacion_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSModificacionIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_modificacion_integrante_documentos END DESC", nativeQuery = true)
    List<HistorialIntegranteDocumentos> findAllHistorialesIntegrantesDocumentos(@Param("idHistorialIntegranteDocumentos") Long idHistorialIntegranteDocumentos, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_integrantes_documentos.* FROM tabla_historial_integrantes_documentos " +
            "WHERE (:idHistorialIntegranteDocumentos IS NULL OR tabla_historial_integrantes_documentos.id_historial_integrante_documentos = :idHistorialIntegranteDocumentos) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_integrantes_documentos.num_reg_historial_integrante_documentos) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.id_historial_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.id_historial_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.num_reg_historial_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.num_reg_historial_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'gradoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.grado_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'gradoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.grado_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'nombresYApellidosIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.nombres_y_apellidos_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'nombresYApellidosIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.nombres_y_apellidos_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'cargoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.cargo_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'cargoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.cargo_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.numero_documento_identificacion_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.numero_documento_identificacion_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'siONoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.si_o_no_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'siONoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.si_o_no_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'siONoActualIntegranteDocumentosPredeterminado' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.si_o_no_actual_integrante_documentos_predeterminado END ASC, " +
            "CASE WHEN :orderBy = 'siONoActualIntegranteDocumentosPredeterminado' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.si_o_no_actual_integrante_documentos_predeterminado END DESC, " +
            "CASE WHEN :orderBy = 'numeroCursoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.numero_curso_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'numeroCursoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.numero_curso_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'puestoCursoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.puesto_curso_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'puestoCursoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.puesto_curso_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'escalafonAntiguedadIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.escalafon_antiguedad_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'escalafonAntiguedadIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.escalafon_antiguedad_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSIngresoIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_ingreso_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSIngresoIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_ingreso_integrante_documentos END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSModificacionIntegranteDocumentos' AND :orderMode = 'ASC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_modificacion_integrante_documentos END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSModificacionIntegranteDocumentos' AND :orderMode = 'DESC' THEN tabla_historial_integrantes_documentos.fecha_h_m_s_modificacion_integrante_documentos END DESC", nativeQuery = true)
    Slice<HistorialIntegranteDocumentos> findAllHistorialesIntegrantesDocumentosPag(Pageable pageable, @Param("idHistorialIntegranteDocumentos") Long idHistorialIntegranteDocumentos, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialIntegranteDocumentos> findByIdHistorialIntegranteDocumentos(Long idHistorialIntegranteDocumentos);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialIntegranteDocumentos findByNumRegHistorialIntegranteDocumentos(String numRegHistorialIntegranteDocumentos);
    
    //BUSQUEDA UNITARIA POR NUMERO DE DOCUMENTO DE IDENTIFICACION (PARA VALIDAR QUE NO EXISTA YA UN REGISTRO CON EL MISMO NUMERO DE DOCUMENTO DE IDENTIFICACION):
    @Query(value = "SELECT tabla_historial_integrantes_documentos.* FROM tabla_historial_integrantes_documentos " +
          "WHERE tabla_historial_integrantes_documentos.numero_documento_identificacion_integrante_documentos = :numeroDocumentoIdentificacionIntegranteDocumentos AND ROWNUM = 1", nativeQuery = true)
    HistorialIntegranteDocumentos findByNumeroDocumentoIdentificacionIntegranteDocumentos(@Param("numeroDocumentoIdentificacionIntegranteDocumentos") String numeroDocumentoIdentificacionIntegranteDocumentos);
    
    @Query(value = "SELECT MAX(id_historial_integrante_documentos) FROM tabla_historial_integrantes_documentos", nativeQuery = true)
    Long findMaxIdHistorialIntegranteDocumentos();
}
