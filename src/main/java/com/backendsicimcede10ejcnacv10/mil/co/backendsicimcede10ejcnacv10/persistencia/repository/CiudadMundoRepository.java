//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CiudadMundo;
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
public interface CiudadMundoRepository extends JpaRepository<CiudadMundo,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + ID PAIS MUNDO + ID DEPTO O ESTADO MUNDO + NOMBRE PAIS MUNDO + NOMBRE DEPTO O ESTADO MUNDO + KEYWORD + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_ciudades_mundo, tabla_paises_mundo, tabla_departamentos_o_estados_mundo " +
          "WHERE (:idCiudadMundo IS NULL OR tabla_ciudades_mundo.id_ciudad_mundo = :idCiudadMundo) AND " +
          "(tabla_ciudades_mundo.id_pais_mundo = tabla_paises_mundo.id_pais_mundo) AND " +
          "(tabla_ciudades_mundo.id_departamento_o_estado_mundo = tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo) AND " +
          "(:idPaisMundo IS NULL OR tabla_paises_mundo.id_pais_mundo = :idPaisMundo) AND " +
          "(:idDepartamentooEstadoMundo IS NULL OR tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo = :idDepartamentooEstadoMundo) AND " +
          "(:nombrePaisMundo IS NULL OR tabla_paises_mundo.nombre_pais_mundo = :nombrePaisMundo) AND " +
          "(:nombreDepartamentooEstadoMundo IS NULL OR tabla_departamentos_o_estados_mundo.nombre_departamento_o_estado_mundo = :nombreDepartamentooEstadoMundo) AND " +
          "(:keyword IS NULL OR tabla_ciudades_mundo.nombre_ciudad_mundo LIKE '%'||:keyword||'%' OR " +
          "tabla_paises_mundo.nombre_pais_mundo LIKE '%'||:keyword||'%' OR " +
          "tabla_departamentos_o_estados_mundo.nombre_departamento_o_estado_mundo LIKE '%'||:keyword||'%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idCiudadMundo") Long idCiudadMundo, @Param("idPaisMundo") Long idPaisMundo, @Param("idDepartamentooEstadoMundo") Long idDepartamentooEstadoMundo, @Param("nombrePaisMundo") String nombrePaisMundo, @Param("nombreDepartamentooEstadoMundo") String nombreDepartamentooEstadoMundo, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_ciudades_mundo, tabla_paises_mundo, tabla_departamentos_o_estados_mundo " +
          "WHERE (:idCiudadMundo IS NULL OR tabla_ciudades_mundo.id_ciudad_mundo = :idCiudadMundo) AND " +
          "(tabla_ciudades_mundo.id_pais_mundo = tabla_paises_mundo.id_pais_mundo) AND " +
          "(tabla_ciudades_mundo.id_departamento_o_estado_mundo = tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo) AND " +
          "(:idPaisMundo IS NULL OR tabla_paises_mundo.id_pais_mundo = :idPaisMundo) AND " +
          "(:idDepartamentooEstadoMundo IS NULL OR tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo = :idDepartamentooEstadoMundo) AND " +
          "(:nombrePaisMundo IS NULL OR tabla_paises_mundo.nombre_pais_mundo = :nombrePaisMundo) AND " +
          "(:nombreDepartamentooEstadoMundo IS NULL OR tabla_departamentos_o_estados_mundo.nombre_departamento_o_estado_mundo = :nombreDepartamentooEstadoMundo) AND " +
          "(:keyword IS NULL OR tabla_ciudades_mundo.nombre_ciudad_mundo LIKE '%'||:keyword||'%' OR " +
          "tabla_paises_mundo.nombre_pais_mundo LIKE '%'||:keyword||'%' OR " +
          "tabla_departamentos_o_estados_mundo.nombre_departamento_o_estado_mundo LIKE '%'||:keyword||'%') " +
          "ORDER BY CASE WHEN :orderBy = 'idCiudadMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.id_ciudad_mundo END ASC, " +
          "CASE WHEN :orderBy = 'idCiudadMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.id_ciudad_mundo END DESC, " +
          "CASE WHEN :orderBy = 'nombreCiudadMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.nombre_ciudad_mundo END ASC, " +
          "CASE WHEN :orderBy = 'nombreCiudadMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.nombre_ciudad_mundo END DESC, " +
          "CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.id_pais_mundo END ASC, " +
          "CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.id_pais_mundo END DESC, " +
          "CASE WHEN :orderBy = 'idDepartamentooEstadoMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.id_departamento_o_estado_mundo END ASC, " +
          "CASE WHEN :orderBy = 'idDepartamentooEstadoMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.id_departamento_o_estado_mundo END DESC", nativeQuery = true)
    List<CiudadMundo> findAllCiudadesMundo(@Param("idCiudadMundo") Long idCiudadMundo, @Param("idPaisMundo") Long idPaisMundo, @Param("idDepartamentooEstadoMundo") Long idDepartamentooEstadoMundo, @Param("nombrePaisMundo") String nombrePaisMundo, @Param("nombreDepartamentooEstadoMundo") String nombreDepartamentooEstadoMundo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_ciudades_mundo, tabla_paises_mundo, tabla_departamentos_o_estados_mundo " +
          "WHERE (:idCiudadMundo IS NULL OR tabla_ciudades_mundo.id_ciudad_mundo = :idCiudadMundo) AND " +
          "(tabla_ciudades_mundo.id_pais_mundo = tabla_paises_mundo.id_pais_mundo) AND " +
          "(tabla_ciudades_mundo.id_departamento_o_estado_mundo = tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo) AND " +
          "(:idPaisMundo IS NULL OR tabla_paises_mundo.id_pais_mundo = :idPaisMundo) AND " +
          "(:idDepartamentooEstadoMundo IS NULL OR tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo = :idDepartamentooEstadoMundo) AND " +
          "(:nombrePaisMundo IS NULL OR tabla_paises_mundo.nombre_pais_mundo = :nombrePaisMundo) AND " +
          "(:nombreDepartamentooEstadoMundo IS NULL OR tabla_departamentos_o_estados_mundo.nombre_departamento_o_estado_mundo = :nombreDepartamentooEstadoMundo) AND " +
          "(:keyword IS NULL OR tabla_ciudades_mundo.nombre_ciudad_mundo LIKE '%'||:keyword||'%' OR " +
          "tabla_paises_mundo.nombre_pais_mundo LIKE '%'||:keyword||'%' OR " +
          "tabla_departamentos_o_estados_mundo.nombre_departamento_o_estado_mundo LIKE '%'||:keyword||'%') " +
          "ORDER BY CASE WHEN :orderBy = 'idCiudadMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.id_ciudad_mundo END ASC, " +
          "CASE WHEN :orderBy = 'idCiudadMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.id_ciudad_mundo END DESC, " +
          "CASE WHEN :orderBy = 'nombreCiudadMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.nombre_ciudad_mundo END ASC, " +
          "CASE WHEN :orderBy = 'nombreCiudadMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.nombre_ciudad_mundo END DESC, " +
          "CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.id_pais_mundo END ASC, " +
          "CASE WHEN :orderBy = 'idPaisMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.id_pais_mundo END DESC, " +
          "CASE WHEN :orderBy = 'idDepartamentooEstadoMundo' AND :orderMode = 'ASC' THEN tabla_ciudades_mundo.id_departamento_o_estado_mundo END ASC, " +
          "CASE WHEN :orderBy = 'idDepartamentooEstadoMundo' AND :orderMode = 'DESC' THEN tabla_ciudades_mundo.id_departamento_o_estado_mundo END DESC", nativeQuery = true)
    Slice<CiudadMundo> findAllCiudadesMundoPag(Pageable pageable, @Param("idCiudadMundo") Long idCiudadMundo, @Param("idPaisMundo") Long idPaisMundo, @Param("idDepartamentooEstadoMundo") Long idDepartamentooEstadoMundo, @Param("nombrePaisMundo") String nombrePaisMundo, @Param("nombreDepartamentooEstadoMundo") String nombreDepartamentooEstadoMundo, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<CiudadMundo> findByIdCiudadMundo(Long idCiudadMundo);
    
    //CiudadMundo findByNombreCiudadMundo(String nombreCiudadMundo);
    
    @Query(value = "SELECT * FROM tabla_ciudades_mundo, tabla_paises_mundo, tabla_departamentos_o_estados_mundo " +
          "WHERE (tabla_ciudades_mundo.id_pais_mundo = tabla_paises_mundo.id_pais_mundo) AND " +
          "(tabla_ciudades_mundo.id_departamento_o_estado_mundo = tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo) AND " +
          "(tabla_paises_mundo.id_pais_mundo = :idPaisMundo) AND " +
          "(tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo = :idDepartamentooEstadoMundo) AND " +
          "(tabla_ciudades_mundo.id_ciudad_mundo = :idCiudadMundo)", nativeQuery = true)
    CiudadMundo findByIdPaisMundoAndIdDepartamentooEstadoMundoAndIdCiudadMundo(@Param("idPaisMundo") Long idPaisMundo, @Param("idDepartamentooEstadoMundo") Long idDepartamentooEstadoMundo, @Param("idCiudadMundo") Long idCiudadMundo);
    
    @Query(value = "SELECT * FROM tabla_ciudades_mundo, tabla_paises_mundo, tabla_departamentos_o_estados_mundo " +
          "WHERE (tabla_ciudades_mundo.id_pais_mundo = tabla_paises_mundo.id_pais_mundo) AND " +
          "(tabla_ciudades_mundo.id_departamento_o_estado_mundo = tabla_departamentos_o_estados_mundo.id_departamento_o_estado_mundo) AND " +
          "(tabla_paises_mundo.nombre_pais_mundo = :nombrePaisMundo) AND " +
          "(tabla_departamentos_o_estados_mundo.nombre_departamento_o_estado_mundo = :nombreDepartamentooEstadoMundo) AND " +
          "(tabla_ciudades_mundo.nombre_ciudad_mundo = :nombreCiudadMundo)", nativeQuery = true)
    CiudadMundo findByNombrePaisMundoAndNombreDepartamentooEstadoMundoAndNombreCiudadMundo(@Param("nombrePaisMundo") String nombrePaisMundo, @Param("nombreDepartamentooEstadoMundo") String nombreDepartamentooEstadoMundo, @Param("nombreCiudadMundo") String nombreCiudadMundo);
    
    @Query(value = "SELECT MAX(id_ciudad_mundo) FROM tabla_ciudades_mundo", nativeQuery = true)
    Long findMaxIdCiudadMundo();
}
