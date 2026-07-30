//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "" +
    "SELECT COUNT(*) " +
    "FROM " +
    "tabla_usuarios, " +
    "tabla_tipos_documentos_identificacion, " +
    "tabla_tipos_usuarios " +
    "WHERE " +
    "(tabla_usuarios.id_tipo_documento_identificacion=tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
    "(tabla_usuarios.id_tipo_usuario=tabla_tipos_usuarios.id_tipo_usuario) AND " +
    "(:idUsuario IS NULL OR id_usuario = :idUsuario) AND " +
    "(:keyword IS NULL OR (UPPER(tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.numero_documento_identificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.lugar_expedicion_documento_identificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.grado_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.nombres_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.primer_apellido_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.segundo_apellido_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_nacimiento_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.sexo_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.direccion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.telefono_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.movil_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.correo_electronico_personal_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.correo_electronico_institucional_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.pais_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.departamento_o_estado_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.ciudad_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_tipos_usuarios.nombre_tipo_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_ingreso_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_modificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.estado_usuario) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idUsuario") Long idUsuario, @Param("keyword") String keyword);
    
    @Query(value = "" +
    "SELECT * " +
    "FROM " +
    "tabla_usuarios, " +
    "tabla_tipos_documentos_identificacion, " +
    "tabla_tipos_usuarios " +
    "WHERE " +
    "(tabla_usuarios.id_tipo_documento_identificacion=tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
    "(tabla_usuarios.id_tipo_usuario=tabla_tipos_usuarios.id_tipo_usuario) AND " +
    "(:idUsuario IS NULL OR id_usuario = :idUsuario) AND " +
    "(:keyword IS NULL OR (UPPER(tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.numero_documento_identificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.lugar_expedicion_documento_identificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.grado_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.nombres_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.primer_apellido_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.segundo_apellido_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_nacimiento_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.sexo_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.direccion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.telefono_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.movil_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.correo_electronico_personal_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.correo_electronico_institucional_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.pais_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.departamento_o_estado_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.ciudad_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_tipos_usuarios.nombre_tipo_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_ingreso_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_modificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.estado_usuario) LIKE UPPER('%'||:keyword||'%'))) " +
    "ORDER BY " +
    "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'ASC' THEN id_usuario END ASC, " +
    "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'DESC' THEN id_usuario END DESC, " +
    "CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'ASC' THEN nombre_tipo_usuario END ASC, " +
    "CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'DESC' THEN nombre_tipo_usuario END DESC, " +
    "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionUsuario' AND :orderMode = 'ASC' THEN numero_documento_identificacion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionUsuario' AND :orderMode = 'DESC' THEN numero_documento_identificacion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionUsuario' AND :orderMode = 'ASC' THEN lugar_expedicion_documento_identificacion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionUsuario' AND :orderMode = 'DESC' THEN lugar_expedicion_documento_identificacion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'gradoUsuario' AND :orderMode = 'ASC' THEN grado_usuario END ASC, " +
    "CASE WHEN :orderBy = 'gradoUsuario' AND :orderMode = 'DESC' THEN grado_usuario END DESC, " +
    "CASE WHEN :orderBy = 'nombresUsuario' AND :orderMode = 'ASC' THEN nombres_usuario END ASC, " +
    "CASE WHEN :orderBy = 'nombresUsuario' AND :orderMode = 'DESC' THEN nombres_usuario END DESC, " +
    "CASE WHEN :orderBy = 'primerApellidoUsuario' AND :orderMode = 'ASC' THEN primer_apellido_usuario END ASC, " +
    "CASE WHEN :orderBy = 'primerApellidoUsuario' AND :orderMode = 'DESC' THEN primer_apellido_usuario END DESC, " +
    "CASE WHEN :orderBy = 'segundoApellidoUsuario' AND :orderMode = 'ASC' THEN segundo_apellido_usuario END ASC, " +
    "CASE WHEN :orderBy = 'segundoApellidoUsuario' AND :orderMode = 'DESC' THEN segundo_apellido_usuario END DESC, " +
    "CASE WHEN :orderBy = 'fechaHMSNacimientoUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_nacimiento_usuario END ASC, " +
    "CASE WHEN :orderBy = 'fechaHMSNacimientoUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_nacimiento_usuario END DESC, " +
    "CASE WHEN :orderBy = 'sexoUsuario' AND :orderMode = 'ASC' THEN sexo_usuario END ASC, " +
    "CASE WHEN :orderBy = 'sexoUsuario' AND :orderMode = 'DESC' THEN sexo_usuario END DESC, " +
    "CASE WHEN :orderBy = 'direccionUsuario' AND :orderMode = 'ASC' THEN direccion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'direccionUsuario' AND :orderMode = 'DESC' THEN direccion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'telefonoUsuario' AND :orderMode = 'ASC' THEN telefono_usuario END ASC, " +
    "CASE WHEN :orderBy = 'telefonoUsuario' AND :orderMode = 'DESC' THEN telefono_usuario END DESC, " +
    "CASE WHEN :orderBy = 'movilUsuario' AND :orderMode = 'ASC' THEN movil_usuario END ASC, " +
    "CASE WHEN :orderBy = 'movilUsuario' AND :orderMode = 'DESC' THEN movil_usuario END DESC, " +
    "CASE WHEN :orderBy = 'correoElectronicoPersonalUsuario' AND :orderMode = 'ASC' THEN correo_electronico_personal_usuario END ASC, " +
    "CASE WHEN :orderBy = 'correoElectronicoPersonalUsuario' AND :orderMode = 'DESC' THEN correo_electronico_personal_usuario END DESC, " +
    "CASE WHEN :orderBy = 'correoElectronicoInstitucionalUsuario' AND :orderMode = 'ASC' THEN correo_electronico_institucional_usuario END ASC, " +
    "CASE WHEN :orderBy = 'correoElectronicoInstitucionalUsuario' AND :orderMode = 'DESC' THEN correo_electronico_institucional_usuario END DESC, " +
    "CASE WHEN :orderBy = 'paisOrigenUsuario' AND :orderMode = 'ASC' THEN pais_origen_usuario END ASC, " +
    "CASE WHEN :orderBy = 'paisOrigenUsuario' AND :orderMode = 'DESC' THEN pais_origen_usuario END DESC, " +
    "CASE WHEN :orderBy = 'departamentooEstadoOrigenUsuario' AND :orderMode = 'ASC' THEN departamento_o_estado_origen_usuario END ASC, " +
    "CASE WHEN :orderBy = 'departamentooEstadoOrigenUsuario' AND :orderMode = 'DESC' THEN departamento_o_estado_origen_usuario END DESC, " +
    "CASE WHEN :orderBy = 'ciudadOrigenUsuario' AND :orderMode = 'ASC' THEN ciudad_origen_usuario END ASC, " +
    "CASE WHEN :orderBy = 'ciudadOrigenUsuario' AND :orderMode = 'DESC' THEN ciudad_origen_usuario END DESC, " +
    "CASE WHEN :orderBy = 'fechaHMSIngresoUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_ingreso_usuario END ASC, " +
    "CASE WHEN :orderBy = 'fechaHMSIngresoUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_ingreso_usuario END DESC, " +
    "CASE WHEN :orderBy = 'fechaHMSModificacionUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_modificacion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'fechaHMSModificacionUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_modificacion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'estadoUsuario' AND :orderMode = 'ASC' THEN estado_usuario END ASC, " +
    "CASE WHEN :orderBy = 'estadoUsuario' AND :orderMode = 'DESC' THEN estado_usuario END DESC", nativeQuery = true)
    List<Usuario> findAllUsuarios(@Param("idUsuario") Long idUsuario, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
    "SELECT * " +
    "FROM " +
    "tabla_usuarios, " +
    "tabla_tipos_documentos_identificacion, " +
    "tabla_tipos_usuarios " +
    "WHERE " +
    "(tabla_usuarios.id_tipo_documento_identificacion=tabla_tipos_documentos_identificacion.id_tipo_documento_identificacion) AND " +
    "(tabla_usuarios.id_tipo_usuario=tabla_tipos_usuarios.id_tipo_usuario) AND " +
    "(:idUsuario IS NULL OR id_usuario = :idUsuario) AND " +
    "(:keyword IS NULL OR (UPPER(tabla_tipos_documentos_identificacion.nombre_tipo_documento_identificacion) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.numero_documento_identificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.lugar_expedicion_documento_identificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.grado_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.nombres_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.primer_apellido_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.segundo_apellido_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_nacimiento_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.sexo_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.direccion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.telefono_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.movil_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.correo_electronico_personal_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.correo_electronico_institucional_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.pais_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.departamento_o_estado_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.ciudad_origen_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_tipos_usuarios.nombre_tipo_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_ingreso_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.fecha_h_m_s_modificacion_usuario) LIKE UPPER('%'||:keyword||'%') OR " +
    "UPPER(tabla_usuarios.estado_usuario) LIKE UPPER('%'||:keyword||'%'))) " +
    "ORDER BY " +
    "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'ASC' THEN id_usuario END ASC, " +
    "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'DESC' THEN id_usuario END DESC, " +
    "CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'ASC' THEN nombre_tipo_usuario END ASC, " +
    "CASE WHEN :orderBy = 'nombreTipoUsuario' AND :orderMode = 'DESC' THEN nombre_tipo_usuario END DESC, " +
    "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionUsuario' AND :orderMode = 'ASC' THEN numero_documento_identificacion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'numeroDocumentoIdentificacionUsuario' AND :orderMode = 'DESC' THEN numero_documento_identificacion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionUsuario' AND :orderMode = 'ASC' THEN lugar_expedicion_documento_identificacion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'lugarExpedicionDocumentoIdentificacionUsuario' AND :orderMode = 'DESC' THEN lugar_expedicion_documento_identificacion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'gradoUsuario' AND :orderMode = 'ASC' THEN grado_usuario END ASC, " +
    "CASE WHEN :orderBy = 'gradoUsuario' AND :orderMode = 'DESC' THEN grado_usuario END DESC, " +
    "CASE WHEN :orderBy = 'nombresUsuario' AND :orderMode = 'ASC' THEN nombres_usuario END ASC, " +
    "CASE WHEN :orderBy = 'nombresUsuario' AND :orderMode = 'DESC' THEN nombres_usuario END DESC, " +
    "CASE WHEN :orderBy = 'primerApellidoUsuario' AND :orderMode = 'ASC' THEN primer_apellido_usuario END ASC, " +
    "CASE WHEN :orderBy = 'primerApellidoUsuario' AND :orderMode = 'DESC' THEN primer_apellido_usuario END DESC, " +
    "CASE WHEN :orderBy = 'segundoApellidoUsuario' AND :orderMode = 'ASC' THEN segundo_apellido_usuario END ASC, " +
    "CASE WHEN :orderBy = 'segundoApellidoUsuario' AND :orderMode = 'DESC' THEN segundo_apellido_usuario END DESC, " +
    "CASE WHEN :orderBy = 'fechaHMSNacimientoUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_nacimiento_usuario END ASC, " +
    "CASE WHEN :orderBy = 'fechaHMSNacimientoUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_nacimiento_usuario END DESC, " +
    "CASE WHEN :orderBy = 'sexoUsuario' AND :orderMode = 'ASC' THEN sexo_usuario END ASC, " +
    "CASE WHEN :orderBy = 'sexoUsuario' AND :orderMode = 'DESC' THEN sexo_usuario END DESC, " +
    "CASE WHEN :orderBy = 'direccionUsuario' AND :orderMode = 'ASC' THEN direccion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'direccionUsuario' AND :orderMode = 'DESC' THEN direccion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'telefonoUsuario' AND :orderMode = 'ASC' THEN telefono_usuario END ASC, " +
    "CASE WHEN :orderBy = 'telefonoUsuario' AND :orderMode = 'DESC' THEN telefono_usuario END DESC, " +
    "CASE WHEN :orderBy = 'movilUsuario' AND :orderMode = 'ASC' THEN movil_usuario END ASC, " +
    "CASE WHEN :orderBy = 'movilUsuario' AND :orderMode = 'DESC' THEN movil_usuario END DESC, " +
    "CASE WHEN :orderBy = 'correoElectronicoPersonalUsuario' AND :orderMode = 'ASC' THEN correo_electronico_personal_usuario END ASC, " +
    "CASE WHEN :orderBy = 'correoElectronicoPersonalUsuario' AND :orderMode = 'DESC' THEN correo_electronico_personal_usuario END DESC, " +
    "CASE WHEN :orderBy = 'correoElectronicoInstitucionalUsuario' AND :orderMode = 'ASC' THEN correo_electronico_institucional_usuario END ASC, " +
    "CASE WHEN :orderBy = 'correoElectronicoInstitucionalUsuario' AND :orderMode = 'DESC' THEN correo_electronico_institucional_usuario END DESC, " +
    "CASE WHEN :orderBy = 'paisOrigenUsuario' AND :orderMode = 'ASC' THEN pais_origen_usuario END ASC, " +
    "CASE WHEN :orderBy = 'paisOrigenUsuario' AND :orderMode = 'DESC' THEN pais_origen_usuario END DESC, " +
    "CASE WHEN :orderBy = 'departamentooEstadoOrigenUsuario' AND :orderMode = 'ASC' THEN departamento_o_estado_origen_usuario END ASC, " +
    "CASE WHEN :orderBy = 'departamentooEstadoOrigenUsuario' AND :orderMode = 'DESC' THEN departamento_o_estado_origen_usuario END DESC, " +
    "CASE WHEN :orderBy = 'ciudadOrigenUsuario' AND :orderMode = 'ASC' THEN ciudad_origen_usuario END ASC, " +
    "CASE WHEN :orderBy = 'ciudadOrigenUsuario' AND :orderMode = 'DESC' THEN ciudad_origen_usuario END DESC, " +
    "CASE WHEN :orderBy = 'fechaHMSIngresoUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_ingreso_usuario END ASC, " +
    "CASE WHEN :orderBy = 'fechaHMSIngresoUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_ingreso_usuario END DESC, " +
    "CASE WHEN :orderBy = 'fechaHMSModificacionUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_modificacion_usuario END ASC, " +
    "CASE WHEN :orderBy = 'fechaHMSModificacionUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_modificacion_usuario END DESC, " +
    "CASE WHEN :orderBy = 'estadoUsuario' AND :orderMode = 'ASC' THEN estado_usuario END ASC, " +
    "CASE WHEN :orderBy = 'estadoUsuario' AND :orderMode = 'DESC' THEN estado_usuario END DESC", nativeQuery = true)
    Slice<Usuario> findAllUsuariosPag(Pageable pageable, @Param("idUsuario") Long idUsuario, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Usuario> findByIdUsuario(Long idUsuario);
    
    Usuario findByNumeroDocumentoIdentificacionUsuario(String numeroDocumentoIdentificacionUsuario);
    
    Usuario findByNicknameUsuario(String nicknameUsuario);
    
    Usuario findByNicknameUsuarioAndPasswordUsuario(String nicknameUsuario, String passwordUsuario);
    
    @Query(value = "SELECT MAX(id_usuario) FROM tabla_usuarios", nativeQuery = true)
    Long findMaxIdUsuario();
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE tabla_usuarios SET password_usuario=:passwordUsuario WHERE (id_usuario=:idUsuario)", nativeQuery = true)
    void updatePasswordUsuario(@Param("idUsuario") Long idUsuario, @Param("passwordUsuario") String passwordUsuario);
}
