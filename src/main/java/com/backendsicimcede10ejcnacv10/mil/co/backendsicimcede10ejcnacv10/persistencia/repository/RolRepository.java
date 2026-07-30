//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Rol;
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
public interface RolRepository extends JpaRepository<Rol,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID ROL + KEYWORD + ID FUNCIONALIDAD + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_roles, tabla_funcionalidades " +
          "WHERE (tabla_roles.id_funcionalidad = tabla_funcionalidades.id_funcionalidad) AND " +
          "(:idRol IS NULL OR tabla_roles.id_rol = :idRol) AND " +
          "(:keyword IS NULL OR UPPER(tabla_roles.nombre_rol) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_funcionalidades.nombre_funcionalidad) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad)", nativeQuery = true)
    Long findTotalRegistros(@Param("idRol") Long idRol, @Param("keyword") String keyword, @Param("idFuncionalidad") Long idFuncionalidad);
    
    @Query(value = "SELECT tabla_roles.* FROM tabla_roles, tabla_funcionalidades " +
          "WHERE (tabla_roles.id_funcionalidad = tabla_funcionalidades.id_funcionalidad) AND " +
          "(:idRol IS NULL OR tabla_roles.id_rol = :idRol) AND " +
          "(:keyword IS NULL OR UPPER(tabla_roles.nombre_rol) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_funcionalidades.nombre_funcionalidad) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) " +
          "ORDER BY CASE WHEN :orderBy = 'idRol' AND :orderMode = 'ASC' THEN tabla_roles.id_rol END ASC, " +
          "CASE WHEN :orderBy = 'idRol' AND :orderMode = 'DESC' THEN tabla_roles.id_rol END DESC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'ASC' THEN tabla_roles.nombre_rol END ASC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'DESC' THEN tabla_roles.nombre_rol END DESC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'ASC' THEN tabla_roles.id_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'DESC' THEN tabla_roles.id_funcionalidad END DESC", nativeQuery = true)
    List<Rol> findAllRoles(@Param("idRol") Long idRol, @Param("keyword") String keyword, @Param("idFuncionalidad") Long idFuncionalidad, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_roles.* FROM tabla_roles, tabla_funcionalidades " +
          "WHERE (tabla_roles.id_funcionalidad = tabla_funcionalidades.id_funcionalidad) AND " +
          "(:idRol IS NULL OR tabla_roles.id_rol = :idRol) AND " +
          "(:keyword IS NULL OR UPPER(tabla_roles.nombre_rol) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_funcionalidades.nombre_funcionalidad) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) " +
          "ORDER BY CASE WHEN :orderBy = 'idRol' AND :orderMode = 'ASC' THEN tabla_roles.id_rol END ASC, " +
          "CASE WHEN :orderBy = 'idRol' AND :orderMode = 'DESC' THEN tabla_roles.id_rol END DESC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'ASC' THEN tabla_roles.nombre_rol END ASC, " +
          "CASE WHEN :orderBy = 'nombreRol' AND :orderMode = 'DESC' THEN tabla_roles.nombre_rol END DESC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'ASC' THEN tabla_roles.id_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'DESC' THEN tabla_roles.id_funcionalidad END DESC", nativeQuery = true)
    Slice<Rol> findAllRolesPag(Pageable pageable, @Param("idRol") Long idRol, @Param("keyword") String keyword, @Param("idFuncionalidad") Long idFuncionalidad, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<Rol> findByIdRol(Long idRol);
    
    //Rol findByNombreRol(String nombreRol);
    
    @Query(value = "" +
          "SELECT " +
          "* " +
          "FROM " +
          "tabla_roles, " +
          "tabla_funcionalidades " +
          "WHERE " +
          "(tabla_roles.id_funcionalidad=tabla_funcionalidades.id_funcionalidad) AND " +
          "(tabla_roles.id_rol = :idRol) AND " +
          "(tabla_funcionalidades.id_funcionalidad = :idFuncionalidad)", nativeQuery = true)
    Rol findByIdRolAndIdFuncionalidad(@Param("idRol") Long idRol, @Param("idFuncionalidad") Long idFuncionalidad);
    
    @Query(value = "" +
          "SELECT " +
          "* " +
          "FROM " +
          "tabla_roles, " +
          "tabla_funcionalidades " +
          "WHERE " +
          "(tabla_roles.id_funcionalidad=tabla_funcionalidades.id_funcionalidad) AND " +
          "(tabla_roles.nombre_rol = :nombreRol) AND " +
          "(tabla_funcionalidades.nombre_funcionalidad = :nombreFuncionalidad)", nativeQuery = true)
    Rol findByNombreRolAndNombreFuncionalidad(@Param("nombreRol") String nombreRol, @Param("nombreFuncionalidad") String nombreFuncionalidad);
    
    @Query(value = "SELECT MAX(id_rol) FROM tabla_roles", nativeQuery = true)
    Long findMaxIdRol();
}
