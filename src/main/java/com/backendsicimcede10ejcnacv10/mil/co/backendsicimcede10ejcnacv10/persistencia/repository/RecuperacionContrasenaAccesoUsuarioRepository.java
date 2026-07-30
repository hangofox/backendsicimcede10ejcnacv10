//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RecuperacionContrasenaAccesoUsuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
import java.util.Date;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface RecuperacionContrasenaAccesoUsuarioRepository extends JpaRepository<RecuperacionContrasenaAccesoUsuario,Long> {

    @Query(value = "SELECT * FROM tabla_recuperaciones_contrasenas_accesos_usuarios ORDER BY CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN id_recuperacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN id_recuperacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN codigo_activacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN estado_uso_codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN estado_uso_codigo_activacion_contrasena_acceso_usuario END DESC", nativeQuery = true)
    List<RecuperacionContrasenaAccesoUsuario> findAllRecuperacionesContrasenasAccesosUsuariosOrderedById(@Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT * FROM tabla_recuperaciones_contrasenas_accesos_usuarios ORDER BY CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN id_recuperacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN id_recuperacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN codigo_activacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN estado_uso_codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN estado_uso_codigo_activacion_contrasena_acceso_usuario END DESC", nativeQuery = true)
    Slice<RecuperacionContrasenaAccesoUsuario> findAllRecuperacionesContrasenasAccesosUsuariosOrderedByIdPag(Pageable pageable, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT " +
          "tabla_recuperaciones_contrasenas_accesos_usuarios.* " +
          "FROM " +
          "tabla_recuperaciones_contrasenas_accesos_usuarios, " +
          "tabla_usuarios " +
          "WHERE " +
          "(tabla_recuperaciones_contrasenas_accesos_usuarios.id_usuario=tabla_usuarios.id_usuario) AND " +
          "(tabla_usuarios.id_usuario = :idUsuario) " +
          "ORDER BY CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.id_recuperacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.id_recuperacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.codigo_activacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.estado_uso_codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.estado_uso_codigo_activacion_contrasena_acceso_usuario END DESC", nativeQuery = true)
    List<RecuperacionContrasenaAccesoUsuario> searchRecuperacionesContrasenasAccesosUsuariosByIdUsuarioOrderedById(@Param("idUsuario") Long idUsuario, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "" +
          "SELECT " +
          "tabla_recuperaciones_contrasenas_accesos_usuarios.* " +
          "FROM " +
          "tabla_recuperaciones_contrasenas_accesos_usuarios, " +
          "tabla_usuarios " +
          "WHERE " +
          "(tabla_recuperaciones_contrasenas_accesos_usuarios.id_usuario=tabla_usuarios.id_usuario) AND " +
          "(tabla_usuarios.id_usuario = :idUsuario) " +
          "ORDER BY CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.id_recuperacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'idRecuperacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.id_recuperacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'codigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.codigo_activacion_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'fechaHMSExpCodActivContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario END DESC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.estado_uso_codigo_activacion_contrasena_acceso_usuario END ASC, CASE WHEN :orderBy = 'estadoUsoCodigoActivacionContrasenaAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_recuperaciones_contrasenas_accesos_usuarios.estado_uso_codigo_activacion_contrasena_acceso_usuario END DESC", nativeQuery = true)
    Slice<RecuperacionContrasenaAccesoUsuario> searchRecuperacionesContrasenasAccesosUsuariosByIdUsuarioOrderedByIdPag(Pageable pageable, @Param("idUsuario") Long idUsuario, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    Optional<RecuperacionContrasenaAccesoUsuario> findByIdRecuperacionContrasenaAccesoUsuario(Long idRecuperacionContrasenaAccesoUsuario);

    RecuperacionContrasenaAccesoUsuario findByCodigoActivacionContrasenaAccesoUsuario(String codigoActivacionContrasenaAccesoUsuario);

    @Query(value = "SELECT MAX(id_recuperacion_contrasena_acceso_usuario) FROM tabla_recuperaciones_contrasenas_accesos_usuarios", nativeQuery = true)
    Long findMaxIdRecuperacionContrasenaAccesoUsuario();

    @Transactional
    @Modifying
    @Query(value = "UPDATE tabla_recuperaciones_contrasenas_accesos_usuarios SET estado_uso_codigo_activacion_contrasena_acceso_usuario='EXPIRADO' WHERE (fecha_h_m_s_exp_cod_activ_contrasena_acceso_usuario < :fechaHMSExpCodActivContrasenaAccesoUsuario) AND (estado_uso_codigo_activacion_contrasena_acceso_usuario='PENDIENTE DE USO')", nativeQuery = true)
    void updateEstadoUsoCodActivContrasenaAccesoUsuarioRecuperacionesContrasenasAccesosUsuarios(@Param("fechaHMSExpCodActivContrasenaAccesoUsuario") Date fechaHMSExpCodActivContrasenaAccesoUsuario);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tabla_recuperaciones_contrasenas_accesos_usuarios WHERE tabla_recuperaciones_contrasenas_accesos_usuarios.id_usuario = :idUsuario", nativeQuery = true)
    void deleteRecuperacionesContrasenasAccesosUsuariosByIdUsuario(@Param("idUsuario") Long idUsuario);
}
