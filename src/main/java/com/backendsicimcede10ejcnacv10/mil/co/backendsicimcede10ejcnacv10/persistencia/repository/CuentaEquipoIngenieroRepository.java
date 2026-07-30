//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CuentaEquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface CuentaEquipoIngenieroRepository extends JpaRepository<CuentaEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + NOMBRE CUENTA EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_cuentas_equipos_ingenieros " +
          "WHERE (:idCuentaEquipoIngeniero IS NULL OR tabla_cuentas_equipos_ingenieros.id_cuenta_equipo_ingeniero = :idCuentaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_cuentas_equipos_ingenieros.numero_cuenta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreCuentaEquipoIngeniero IS NULL OR UPPER(tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero) = UPPER(:nombreCuentaEquipoIngeniero))", nativeQuery = true)
    Long findTotalRegistros(@Param("idCuentaEquipoIngeniero") Long idCuentaEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreCuentaEquipoIngeniero") String nombreCuentaEquipoIngeniero);
    
    @Query(value = "SELECT * FROM tabla_cuentas_equipos_ingenieros " +
          "WHERE (:idCuentaEquipoIngeniero IS NULL OR tabla_cuentas_equipos_ingenieros.id_cuenta_equipo_ingeniero = :idCuentaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_cuentas_equipos_ingenieros.numero_cuenta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreCuentaEquipoIngeniero IS NULL OR UPPER(tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero) = UPPER(:nombreCuentaEquipoIngeniero)) " +
          "ORDER BY CASE WHEN :orderBy = 'idCuentaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_cuentas_equipos_ingenieros.id_cuenta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idCuentaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_cuentas_equipos_ingenieros.id_cuenta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreCuentaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreCuentaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'numeroCuentaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_cuentas_equipos_ingenieros.numero_cuenta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numeroCuentaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_cuentas_equipos_ingenieros.numero_cuenta_equipo_ingeniero END DESC", nativeQuery = true)
    List<CuentaEquipoIngeniero> findAllCuentasEquiposIngenieros(@Param("idCuentaEquipoIngeniero") Long idCuentaEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreCuentaEquipoIngeniero") String nombreCuentaEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_cuentas_equipos_ingenieros " +
          "WHERE (:idCuentaEquipoIngeniero IS NULL OR tabla_cuentas_equipos_ingenieros.id_cuenta_equipo_ingeniero = :idCuentaEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_cuentas_equipos_ingenieros.numero_cuenta_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:nombreCuentaEquipoIngeniero IS NULL OR UPPER(tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero) = UPPER(:nombreCuentaEquipoIngeniero)) " +
          "ORDER BY CASE WHEN :orderBy = 'idCuentaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_cuentas_equipos_ingenieros.id_cuenta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idCuentaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_cuentas_equipos_ingenieros.id_cuenta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreCuentaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreCuentaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_cuentas_equipos_ingenieros.nombre_cuenta_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'numeroCuentaEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_cuentas_equipos_ingenieros.numero_cuenta_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numeroCuentaEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_cuentas_equipos_ingenieros.numero_cuenta_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<CuentaEquipoIngeniero> findAllCuentasEquiposIngenierosOrdenadosporIdPag(Pageable pageable, @Param("idCuentaEquipoIngeniero") Long idCuentaEquipoIngeniero, @Param("keyword") String keyword, @Param("nombreCuentaEquipoIngeniero") String nombreCuentaEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CuentaEquipoIngeniero> findByIdCuentaEquipoIngeniero(Long idCuentaEquipoIngeniero);
    
    @Query(value = "SELECT * FROM tabla_cuentas_equipos_ingenieros " +
          "WHERE UPPER(nombre_cuenta_equipo_ingeniero) = UPPER(:nombreCuentaEquipoIngeniero)", nativeQuery = true)
    CuentaEquipoIngeniero findByNombreCuentaEquipoIngeniero(@Param("nombreCuentaEquipoIngeniero") String nombreCuentaEquipoIngeniero);

    @Query(value = "SELECT * FROM tabla_cuentas_equipos_ingenieros " +
          "WHERE UPPER(numero_cuenta_equipo_ingeniero) = UPPER(:numeroCuentaEquipoIngeniero)", nativeQuery = true)
    CuentaEquipoIngeniero findByNumeroCuentaEquipoIngeniero(@Param("numeroCuentaEquipoIngeniero") String numeroCuentaEquipoIngeniero);

    @Query(value = "SELECT MAX(id_cuenta_equipo_ingeniero) FROM tabla_cuentas_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdCuentaEquipoIngeniero();
}
