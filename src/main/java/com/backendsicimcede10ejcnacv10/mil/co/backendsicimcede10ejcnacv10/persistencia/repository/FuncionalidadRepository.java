//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Funcionalidad;
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
public interface FuncionalidadRepository extends JpaRepository<Funcionalidad,Long> {

    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_funcionalidades " +
          "WHERE (:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_funcionalidades.nombre_funcionalidad) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_funcionalidades.label_menu_principal_funcionalidad) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idFuncionalidad") Long idFuncionalidad, @Param("keyword") String keyword);

    @Query(value = "SELECT tabla_funcionalidades.* FROM tabla_funcionalidades " +
          "WHERE (:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_funcionalidades.nombre_funcionalidad) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_funcionalidades.label_menu_principal_funcionalidad) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.id_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.id_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.nombre_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.nombre_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'nombreIconoMenuPrincipalFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'nombreIconoMenuPrincipalFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'labelMenuPrincipalFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.label_menu_principal_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'labelMenuPrincipalFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.label_menu_principal_funcionalidad END DESC", nativeQuery = true)
    List<Funcionalidad> findAllFuncionalidades(@Param("idFuncionalidad") Long idFuncionalidad, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    @Query(value = "SELECT tabla_funcionalidades.* FROM tabla_funcionalidades " +
          "WHERE (:idFuncionalidad IS NULL OR tabla_funcionalidades.id_funcionalidad = :idFuncionalidad) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_funcionalidades.nombre_funcionalidad) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad) LIKE UPPER('%'||:keyword||'%') " +
          "OR UPPER(tabla_funcionalidades.label_menu_principal_funcionalidad) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.id_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'idFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.id_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.nombre_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'nombreFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.nombre_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'nombreIconoMenuPrincipalFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'nombreIconoMenuPrincipalFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.nombre_icono_menu_principal_funcionalidad END DESC, " +
          "CASE WHEN :orderBy = 'labelMenuPrincipalFuncionalidad' AND :orderMode = 'ASC' THEN tabla_funcionalidades.label_menu_principal_funcionalidad END ASC, " +
          "CASE WHEN :orderBy = 'labelMenuPrincipalFuncionalidad' AND :orderMode = 'DESC' THEN tabla_funcionalidades.label_menu_principal_funcionalidad END DESC", nativeQuery = true)
    Slice<Funcionalidad> findAllFuncionalidadesPag(Pageable pageable, @Param("idFuncionalidad") Long idFuncionalidad, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);

    Optional<Funcionalidad> findByIdFuncionalidad(Long idFuncionalidad);

    Funcionalidad findByNombreFuncionalidad(String nombreFuncionalidad);

    @Query(value = "SELECT MAX(id_funcionalidad) FROM tabla_funcionalidades", nativeQuery = true)
    Long findMaxIdFuncionalidad();
}
