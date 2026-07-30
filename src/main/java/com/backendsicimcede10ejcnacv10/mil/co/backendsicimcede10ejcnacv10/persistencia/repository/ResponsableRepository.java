//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Responsable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ResponsableRepository extends JpaRepository<Responsable,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + SIGLA O ACRONIMO UNIDAD MILITAR + ESTADO + KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_responsables, tabla_unidades_militares, tabla_tipos_documentos_identificacion " +
          "WHERE " +
          "(:idResponsable IS NULL OR tabla_responsables.id_responsable = :idResponsable) AND " +
          "(tabla_responsables.id_unidad_militar=tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_responsables.id_tipo_documento_identificacion=tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:estadoResponsable IS NULL OR tabla_responsables.estado_responsable = :estadoResponsable) AND " +
          "(:keyword IS NULL OR (" +
          "tabla_unidades_militares.nombre_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "TO_CHAR(tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar) LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.usuario_red_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.numero_documento_identificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.lugar_expedicion_documento_identificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.grado_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.nombres_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.primer_apellido_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.segundo_apellido_responsable LIKE '%' || :keyword || '%' OR " +
          "TO_CHAR(tabla_responsables.nombre_archivo_foto_extension_o_formato_responsable) LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_nacimiento_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.sexo_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.direccion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.telefono_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.movil_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.correo_electronico_personal_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.correo_electronico_institucional_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.pais_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.departamento_o_estado_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.ciudad_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.numero_curso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.puesto_curso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.escalafon_antiguedad_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_incorporacion_ffmm_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_ingreso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_modificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.estado_responsable LIKE '%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idResponsable") Long idResponsable, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("estadoResponsable") String estadoResponsable, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM " +
          "tabla_responsables, " +
          "tabla_unidades_militares, " +
          "tabla_tipos_documentos_identificacion, " +
          "tabla_grados_siath " +
          "WHERE " +
          "(:idResponsable IS NULL OR tabla_responsables.id_responsable = :idResponsable) AND " +
          "(tabla_responsables.id_unidad_militar=tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_responsables.id_tipo_documento_identificacion=tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
          "(tabla_responsables.grado_responsable=tabla_grados_siath.nombre_grado_siath) AND " +
          "(tabla_grados_siath.fuerza_siath=3) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:estadoResponsable IS NULL OR tabla_responsables.estado_responsable = :estadoResponsable) AND " +
          "(:keyword IS NULL OR (" +
          "tabla_unidades_militares.nombre_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "TO_CHAR(tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar) LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.usuario_red_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.numero_documento_identificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.lugar_expedicion_documento_identificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.grado_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.nombres_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.primer_apellido_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.segundo_apellido_responsable LIKE '%' || :keyword || '%' OR " +
          "TO_CHAR(tabla_responsables.nombre_archivo_foto_extension_o_formato_responsable) LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_nacimiento_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.sexo_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.direccion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.telefono_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.movil_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.correo_electronico_personal_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.correo_electronico_institucional_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.pais_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.departamento_o_estado_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.ciudad_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.numero_curso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.puesto_curso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.escalafon_antiguedad_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_incorporacion_ffmm_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_ingreso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_modificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.estado_responsable LIKE '%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.id_responsable END ASC, " +
          "CASE WHEN :orderBy = 'idResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.id_responsable END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'ASC' THEN tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'DESC' THEN tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion END DESC, " +
          "CASE WHEN :orderBy = 'usuarioRedResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.usuario_red_responsable END ASC, " +
          "CASE WHEN :orderBy = 'usuarioRedResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.usuario_red_responsable END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.numero_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.numero_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.lugar_expedicion_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.lugar_expedicion_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.grado_responsable END ASC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.grado_responsable END DESC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.nombres_responsable END ASC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.nombres_responsable END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.primer_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.primer_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.segundo_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.segundo_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'armaResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.arma_responsable END ASC, " +
          "CASE WHEN :orderBy = 'armaResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.arma_responsable END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoFotoExtensionoFormatoResponsable' AND :orderMode = 'ASC' THEN TO_CHAR(tabla_responsables.nombre_archivo_foto_extension_o_formato_responsable) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoFotoExtensionoFormatoResponsable' AND :orderMode = 'DESC' THEN TO_CHAR(tabla_responsables.nombre_archivo_foto_extension_o_formato_responsable) END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSNacimientoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_nacimiento_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSNacimientoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_nacimiento_responsable END DESC, " +
          "CASE WHEN :orderBy = 'sexoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.sexo_responsable END ASC, " +
          "CASE WHEN :orderBy = 'sexoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.sexo_responsable END DESC, " +
          "CASE WHEN :orderBy = 'direccionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.direccion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'direccionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.direccion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'telefonoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.telefono_responsable END ASC, " +
          "CASE WHEN :orderBy = 'telefonoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.telefono_responsable END DESC, " +
          "CASE WHEN :orderBy = 'movilResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.movil_responsable END ASC, " +
          "CASE WHEN :orderBy = 'movilResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.movil_responsable END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.correo_electronico_personal_responsable END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.correo_electronico_personal_responsable END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.correo_electronico_institucional_responsable END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.correo_electronico_institucional_responsable END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.pais_origen_responsable END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.pais_origen_responsable END DESC, " +
          "CASE WHEN :orderBy = 'departamentooEstadoOrigenResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.departamento_o_estado_origen_responsable END ASC, " +
          "CASE WHEN :orderBy = 'departamentooEstadoOrigenResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.departamento_o_estado_origen_responsable END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.ciudad_origen_responsable END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.ciudad_origen_responsable END DESC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.numero_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.numero_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.puesto_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.puesto_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'ASC' THEN tabla_grados_siath.orden END ASC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.escalafon_antiguedad_responsable END ASC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'DESC' THEN tabla_grados_siath.orden END DESC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.escalafon_antiguedad_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIncorporacionFFMMResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_incorporacion_ffmm_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIncorporacionFFMMResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_incorporacion_ffmm_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_ingreso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_ingreso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_modificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_modificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'estadoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.estado_responsable END ASC, " +
          "CASE WHEN :orderBy = 'estadoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.estado_responsable END DESC", nativeQuery = true)
    List<Responsable> findAllResponsables(@Param("idResponsable") Long idResponsable, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("estadoResponsable") String estadoResponsable, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM " +
          "tabla_responsables, " +
          "tabla_unidades_militares, " +
          "tabla_tipos_documentos_identificacion, " +
          "tabla_grados_siath " +
          "WHERE " +
          "(:idResponsable IS NULL OR tabla_responsables.id_responsable = :idResponsable) AND " +
          "(tabla_responsables.id_unidad_militar=tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_responsables.id_tipo_documento_identificacion=tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
          "(tabla_responsables.grado_responsable=tabla_grados_siath.nombre_grado_siath) AND " +
          "(tabla_grados_siath.fuerza_siath=3) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:estadoResponsable IS NULL OR tabla_responsables.estado_responsable = :estadoResponsable) AND " +
          "(:keyword IS NULL OR (" +
          "tabla_unidades_militares.nombre_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "TO_CHAR(tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar) LIKE '%' || :keyword || '%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.usuario_red_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.numero_documento_identificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.lugar_expedicion_documento_identificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.grado_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.nombres_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.primer_apellido_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.segundo_apellido_responsable LIKE '%' || :keyword || '%' OR " +
          "TO_CHAR(tabla_responsables.nombre_archivo_foto_extension_o_formato_responsable) LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_nacimiento_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.sexo_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.direccion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.telefono_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.movil_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.correo_electronico_personal_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.correo_electronico_institucional_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.pais_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.departamento_o_estado_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.ciudad_origen_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.numero_curso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.puesto_curso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.escalafon_antiguedad_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_incorporacion_ffmm_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_ingreso_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.fecha_h_m_s_modificacion_responsable LIKE '%' || :keyword || '%' OR " +
          "tabla_responsables.estado_responsable LIKE '%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.id_responsable END ASC, " +
          "CASE WHEN :orderBy = 'idResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.id_responsable END DESC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaOAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'ASC' THEN tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoDocumentoIdentificacion' AND :orderMode = 'DESC' THEN tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion END DESC, " +
          "CASE WHEN :orderBy = 'usuarioRedResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.usuario_red_responsable END ASC, " +
          "CASE WHEN :orderBy = 'usuarioRedResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.usuario_red_responsable END DESC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.numero_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.numero_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.lugar_expedicion_documento_identificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.lugar_expedicion_documento_identificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.grado_responsable END ASC, " +
          "CASE WHEN :orderBy = 'gradoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.grado_responsable END DESC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.nombres_responsable END ASC, " +
          "CASE WHEN :orderBy = 'nombresResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.nombres_responsable END DESC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.primer_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'primerApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.primer_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.segundo_apellido_responsable END ASC, " +
          "CASE WHEN :orderBy = 'segundoApellidoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.segundo_apellido_responsable END DESC, " +
          "CASE WHEN :orderBy = 'armaResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.arma_responsable END ASC, " +
          "CASE WHEN :orderBy = 'armaResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.arma_responsable END DESC, " +
          "CASE WHEN :orderBy = 'nombreArchivoFotoExtensionoFormatoResponsable' AND :orderMode = 'ASC' THEN TO_CHAR(tabla_responsables.nombre_archivo_foto_extension_o_formato_responsable) END ASC, " +
          "CASE WHEN :orderBy = 'nombreArchivoFotoExtensionoFormatoResponsable' AND :orderMode = 'DESC' THEN TO_CHAR(tabla_responsables.nombre_archivo_foto_extension_o_formato_responsable) END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSNacimientoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_nacimiento_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSNacimientoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_nacimiento_responsable END DESC, " +
          "CASE WHEN :orderBy = 'sexoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.sexo_responsable END ASC, " +
          "CASE WHEN :orderBy = 'sexoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.sexo_responsable END DESC, " +
          "CASE WHEN :orderBy = 'direccionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.direccion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'direccionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.direccion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'telefonoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.telefono_responsable END ASC, " +
          "CASE WHEN :orderBy = 'telefonoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.telefono_responsable END DESC, " +
          "CASE WHEN :orderBy = 'movilResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.movil_responsable END ASC, " +
          "CASE WHEN :orderBy = 'movilResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.movil_responsable END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.correo_electronico_personal_responsable END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoPersonalResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.correo_electronico_personal_responsable END DESC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.correo_electronico_institucional_responsable END ASC, " +
          "CASE WHEN :orderBy = 'correoElectronicoInstitucionalResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.correo_electronico_institucional_responsable END DESC, " +
          "CASE WHEN :orderBy = 'paisOrigenResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.pais_origen_responsable END ASC, " +
          "CASE WHEN :orderBy = 'paisOrigenResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.pais_origen_responsable END DESC, " +
          "CASE WHEN :orderBy = 'departamentooEstadoOrigenResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.departamento_o_estado_origen_responsable END ASC, " +
          "CASE WHEN :orderBy = 'departamentooEstadoOrigenResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.departamento_o_estado_origen_responsable END DESC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.ciudad_origen_responsable END ASC, " +
          "CASE WHEN :orderBy = 'ciudadOrigenResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.ciudad_origen_responsable END DESC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.numero_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'numeroCursoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.numero_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.puesto_curso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'puestoCursoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.puesto_curso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'ASC' THEN tabla_grados_siath.orden END ASC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.escalafon_antiguedad_responsable END ASC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'DESC' THEN tabla_grados_siath.orden END DESC, " +
          "CASE WHEN :orderBy = 'escalafonAntiguedadResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.escalafon_antiguedad_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIncorporacionFFMMResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_incorporacion_ffmm_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIncorporacionFFMMResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_incorporacion_ffmm_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_ingreso_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_ingreso_responsable END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.fecha_h_m_s_modificacion_responsable END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSModificacionResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.fecha_h_m_s_modificacion_responsable END DESC, " +
          "CASE WHEN :orderBy = 'estadoResponsable' AND :orderMode = 'ASC' THEN tabla_responsables.estado_responsable END ASC, " +
          "CASE WHEN :orderBy = 'estadoResponsable' AND :orderMode = 'DESC' THEN tabla_responsables.estado_responsable END DESC", nativeQuery = true)
    Slice<Responsable> findAllResponsablesPag(Pageable pageable, @Param("idResponsable") Long idResponsable, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("estadoResponsable") String estadoResponsable, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Responsable> findByIdResponsable(Long idResponsable);
    
    Responsable findByNumeroDocumentoIdentificacionResponsable(String numeroDocumentoIdentificacionResponsable);
    
    @Query(value = "SELECT MAX(id_responsable) FROM tabla_responsables", nativeQuery = true)
    Long findMaxIdResponsable();
}
