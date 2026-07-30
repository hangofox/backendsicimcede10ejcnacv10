//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PrivilegyRestriccAccesoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface PrivilegyRestriccAccesoUsuarioRepository extends JpaRepository<PrivilegyRestriccAccesoUsuario,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + IDFUNCIONALIDAD + NOMBREFUNCIONALIDAD + IDROL + NOMBREROL + SIGLAOACRONIMOUM + IDUSUARIO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_privileg_y_restricc_accesos_usuarios, tabla_unidades_militares, tabla_usuarios, tabla_funcionalidades, tabla_roles " +
          "WHERE (:idPrivilegioyRestriccionAccesoUsuario IS NULL OR tabla_privileg_y_restricc_accesos_usuarios.id_privilegio_y_restriccion_acceso_usuario = :idPrivilegioyRestriccionAccesoUsuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_usuario = tabla_usuarios.id_usuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad = tabla_funcionalidades.id_funcionalidad) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_rol = tabla_roles.id_rol) AND " +
          "(:keyword IS NULL OR (tabla_unidades_militares.nombre_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.nombre_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.label_menu_principal_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_roles.nombre_rol LIKE '%'||:keyword||'%' OR " +
          "tabla_privileg_y_restricc_accesos_usuarios.url_acceso_usuario LIKE '%'||:keyword||'%' OR " +
          "tabla_privileg_y_restricc_accesos_usuarios.fecha_h_m_s_ingreso_privilegio_y_restriccion_acceso_usuario LIKE '%'||:keyword||'%')) AND " +
          "(:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) AND " +
          "(:nombreFuncionalidad IS NULL OR tabla_funcionalidades.nombre_funcionalidad = :nombreFuncionalidad) AND " +
          "(:idRol IS NULL OR tabla_roles.id_rol = :idRol) AND " +
          "(:nombreRol IS NULL OR tabla_roles.nombre_rol = :nombreRol) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:idUsuario IS NULL OR tabla_usuarios.id_usuario = :idUsuario)", nativeQuery = true)
    Long findTotalRegistros(@Param("idPrivilegioyRestriccionAccesoUsuario") Long idPrivilegioyRestriccionAccesoUsuario, @Param("keyword") String keyword, @Param("idFuncionalidad") Long idFuncionalidad, @Param("nombreFuncionalidad") String nombreFuncionalidad, @Param("idRol") Long idRol, @Param("nombreRol") String nombreRol, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("idUsuario") Long idUsuario);
    
    @Query(value = "SELECT tabla_privileg_y_restricc_accesos_usuarios.* FROM tabla_privileg_y_restricc_accesos_usuarios, tabla_unidades_militares, tabla_usuarios, tabla_funcionalidades, tabla_roles " +
          "WHERE (:idPrivilegioyRestriccionAccesoUsuario IS NULL OR tabla_privileg_y_restricc_accesos_usuarios.id_privilegio_y_restriccion_acceso_usuario = :idPrivilegioyRestriccionAccesoUsuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_usuario = tabla_usuarios.id_usuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad = tabla_funcionalidades.id_funcionalidad) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_rol = tabla_roles.id_rol) AND " +
          "(:keyword IS NULL OR (tabla_unidades_militares.nombre_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.nombre_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.label_menu_principal_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_roles.nombre_rol LIKE '%'||:keyword||'%' OR " +
          "tabla_privileg_y_restricc_accesos_usuarios.url_acceso_usuario LIKE '%'||:keyword||'%' OR " +
          "tabla_privileg_y_restricc_accesos_usuarios.fecha_h_m_s_ingreso_privilegio_y_restriccion_acceso_usuario LIKE '%'||:keyword||'%')) AND " +
          "(:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) AND " +
          "(:nombreFuncionalidad IS NULL OR tabla_funcionalidades.nombre_funcionalidad = :nombreFuncionalidad) AND " +
          "(:idRol IS NULL OR tabla_roles.id_rol = :idRol) AND " +
          "(:nombreRol IS NULL OR tabla_roles.nombre_rol = :nombreRol) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:idUsuario IS NULL OR tabla_usuarios.id_usuario = :idUsuario) " +
          "ORDER BY CASE WHEN :orderBy = 'idPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'idPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'numeroRegistroPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.numero_registro_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'numeroRegistroPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.numero_registro_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_usuario END ASC, " +
          "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_usuario END DESC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'idRol' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_rol END ASC, " +
          "CASE WHEN :orderBy = 'idRol' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_rol END DESC, " +
          "CASE WHEN :orderBy = 'urlAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.url_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'urlAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.url_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'sioNoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.si_o_no_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'sioNoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.si_o_no_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.fecha_h_m_s_ingreso_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.fecha_h_m_s_ingreso_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.nombre_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.nombre_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'ASC' THEN tabla_roles.nombre_rol END ASC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'DESC' THEN tabla_roles.nombre_rol END DESC", nativeQuery = true)
    List<PrivilegyRestriccAccesoUsuario> findAllPrivilegyRestriccAccesosUsuarios(@Param("idPrivilegioyRestriccionAccesoUsuario") Long idPrivilegioyRestriccionAccesoUsuario, @Param("keyword") String keyword, @Param("idFuncionalidad") Long idFuncionalidad, @Param("nombreFuncionalidad") String nombreFuncionalidad, @Param("idRol") Long idRol, @Param("nombreRol") String nombreRol, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("idUsuario") Long idUsuario, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_privileg_y_restricc_accesos_usuarios.* FROM tabla_privileg_y_restricc_accesos_usuarios, tabla_unidades_militares, tabla_usuarios, tabla_funcionalidades, tabla_roles " +
          "WHERE (:idPrivilegioyRestriccionAccesoUsuario IS NULL OR tabla_privileg_y_restricc_accesos_usuarios.id_privilegio_y_restriccion_acceso_usuario = :idPrivilegioyRestriccionAccesoUsuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_usuario = tabla_usuarios.id_usuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad = tabla_funcionalidades.id_funcionalidad) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_rol = tabla_roles.id_rol) AND " +
          "(:keyword IS NULL OR (tabla_unidades_militares.nombre_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.sigla_o_acronimo_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.nombre_archivo_foto_log_ext_o_fmt_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_unidades_militares.nombre_carpeta_almacenamiento_unidad_militar LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.nombre_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_funcionalidades.label_menu_principal_funcionalidad LIKE '%'||:keyword||'%' OR " +
          "tabla_roles.nombre_rol LIKE '%'||:keyword||'%' OR " +
          "tabla_privileg_y_restricc_accesos_usuarios.url_acceso_usuario LIKE '%'||:keyword||'%' OR " +
          "tabla_privileg_y_restricc_accesos_usuarios.fecha_h_m_s_ingreso_privilegio_y_restriccion_acceso_usuario LIKE '%'||:keyword||'%')) AND " +
          "(:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) AND " +
          "(:nombreFuncionalidad IS NULL OR tabla_funcionalidades.nombre_funcionalidad = :nombreFuncionalidad) AND " +
          "(:idRol IS NULL OR tabla_roles.id_rol = :idRol) AND " +
          "(:nombreRol IS NULL OR tabla_roles.nombre_rol = :nombreRol) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(:idUsuario IS NULL OR tabla_usuarios.id_usuario = :idUsuario) " +
          "ORDER BY CASE WHEN :orderBy = 'idPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'idPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'numeroRegistroPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.numero_registro_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'numeroRegistroPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.numero_registro_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_usuario END ASC, " +
          "CASE WHEN :orderBy = 'idUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_usuario END DESC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'idRol' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_rol END ASC, " +
          "CASE WHEN :orderBy = 'idRol' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.id_rol END DESC, " +
          "CASE WHEN :orderBy = 'urlAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.url_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'urlAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.url_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'sioNoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.si_o_no_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'sioNoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.si_o_no_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'ASC' THEN tabla_privileg_y_restricc_accesos_usuarios.fecha_h_m_s_ingreso_privilegio_y_restriccion_acceso_usuario END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSIngresoPrivilegioyRestriccionAccesoUsuario' AND :orderMode = 'DESC' THEN tabla_privileg_y_restricc_accesos_usuarios.fecha_h_m_s_ingreso_privilegio_y_restriccion_acceso_usuario END DESC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.nombre_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.nombre_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'ASC' THEN tabla_roles.nombre_rol END ASC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'DESC' THEN tabla_roles.nombre_rol END DESC", nativeQuery = true)
    Slice<PrivilegyRestriccAccesoUsuario> findAllPrivilegyRestriccAccesosUsuariosPag(Pageable pageable, @Param("idPrivilegioyRestriccionAccesoUsuario") Long idPrivilegioyRestriccionAccesoUsuario, @Param("keyword") String keyword, @Param("idFuncionalidad") Long idFuncionalidad, @Param("nombreFuncionalidad") String nombreFuncionalidad, @Param("idRol") Long idRol, @Param("nombreRol") String nombreRol, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("idUsuario") Long idUsuario, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<PrivilegyRestriccAccesoUsuario> findByIdPrivilegioyRestriccionAccesoUsuario(Long idPrivilegioyRestriccionAccesoUsuario);
    
    @Query(value = "" +
          "SELECT " +
          "* " +
          "FROM " +
          "tabla_privileg_y_restricc_accesos_usuarios, " +
          "tabla_unidades_militares, " +
          "tabla_usuarios, " +
          "tabla_funcionalidades, " +
          "tabla_roles " +
          "WHERE " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar=tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_usuario=tabla_usuarios.id_usuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad=tabla_funcionalidades.id_funcionalidad) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_rol=tabla_roles.id_rol) AND " +
          "(tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(tabla_usuarios.id_usuario = :idUsuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_rol=tabla_roles.id_rol) AND " +
          "(tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) AND " +
          "(tabla_roles.id_rol = :idRol)", nativeQuery = true)
    PrivilegyRestriccAccesoUsuario findBySAUnidadMilitarAndIdUsuarioAndIdFuncionalidadAndIdRol(@Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("idUsuario") Long idUsuario, @Param("idFuncionalidad") Long idFuncionalidad, @Param("idRol") Long idRol);
    
    @Query(value = "" +
          "SELECT " +
          "* " +
          "FROM " +
          "tabla_privileg_y_restricc_accesos_usuarios, " +
          "tabla_unidades_militares, " +
          "tabla_usuarios, " +
          "tabla_funcionalidades, " +
          "tabla_roles " +
          "WHERE " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar=tabla_unidades_militares.id_unidad_militar) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_usuario=tabla_usuarios.id_usuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_funcionalidad=tabla_funcionalidades.id_funcionalidad) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_rol=tabla_roles.id_rol) AND " +
          "(tabla_unidades_militares.sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar) AND " +
          "(tabla_usuarios.id_usuario = :idUsuario) AND " +
          "(tabla_privileg_y_restricc_accesos_usuarios.id_rol=tabla_roles.id_rol) AND " +
          "(tabla_funcionalidades.nombre_funcionalidad = :nombreFuncionalidad) AND " +
          "(tabla_roles.nombre_rol = :nombreRol)", nativeQuery = true)
    PrivilegyRestriccAccesoUsuario findBySAUnidadMilitarAndIdUsuarioAndNombreFuncionalidadAndNombreRol(@Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("idUsuario") Long idUsuario, @Param("nombreFuncionalidad") String nombreFuncionalidad, @Param("nombreRol") String nombreRol);
    
    @Query(value = "SELECT MAX(id_privilegio_y_restriccion_acceso_usuario) FROM tabla_privileg_y_restricc_accesos_usuarios", nativeQuery = true)
    Long findMaxIdPrivilegioyRestriccionAccesoUsuario();
    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tabla_privileg_y_restricc_accesos_usuarios WHERE tabla_privileg_y_restricc_accesos_usuarios.id_usuario = :idUsuario", nativeQuery = true)
    void deletePrivilegyRestriccAccesosUsuariosNivelGeneralByIdUsuario(@Param("idUsuario") Long idUsuario);
    
    @Transactional
    @Modifying
    @Query(value = "" +
    "DELETE FROM tabla_privileg_y_restricc_accesos_usuarios WHERE tabla_privileg_y_restricc_accesos_usuarios.id_usuario = :idUsuario AND " +
    "tabla_privileg_y_restricc_accesos_usuarios.id_unidad_militar = (SELECT id_unidad_militar FROM tabla_unidades_militares WHERE sigla_o_acronimo_unidad_militar = :siglaoAcronimoUnidadMilitar)", nativeQuery = true)
    void deletePrivilegyRestriccAccesosUsuariosUnidadMilitarByIdUsuarioAndSAUnidadMilitar(@Param("idUsuario") Long idUsuario, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
}
