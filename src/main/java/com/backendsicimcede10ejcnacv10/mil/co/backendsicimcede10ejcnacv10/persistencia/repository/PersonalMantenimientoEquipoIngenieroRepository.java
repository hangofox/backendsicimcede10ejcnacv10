//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PersonalMantenimientoEquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface PersonalMantenimientoEquipoIngenieroRepository extends JpaRepository<PersonalMantenimientoEquipoIngeniero,Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID + KEYWORD + SIGLA O ACRONIMO UNIDAD MILITAR + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_personal_mantenimientos_equipos_ingenieros, tabla_unidades_militares " +
          "WHERE (:idPersonalMantenimientoEquipoIngeniero IS NULL OR tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero = :idPersonalMantenimientoEquipoIngeniero) AND " +
          "(tabla_personal_mantenimientos_equipos_ingenieros.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_personal_mantenimientos_equipos_ingenieros.num_doc_identif_personal_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_personal_mantenimientos_equipos_ingenieros.nombres_y_apellidos_personal_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar))", nativeQuery = true)
    Long findTotalRegistros(@Param("idPersonalMantenimientoEquipoIngeniero") Long idPersonalMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar);
    
    @Query(value = "SELECT tabla_personal_mantenimientos_equipos_ingenieros.* FROM tabla_personal_mantenimientos_equipos_ingenieros, tabla_unidades_militares " +
          "WHERE (:idPersonalMantenimientoEquipoIngeniero IS NULL OR tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero = :idPersonalMantenimientoEquipoIngeniero) AND " +
          "(tabla_personal_mantenimientos_equipos_ingenieros.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_personal_mantenimientos_equipos_ingenieros.num_doc_identif_personal_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_personal_mantenimientos_equipos_ingenieros.nombres_y_apellidos_personal_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') AND " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'numDocIdentifPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.num_doc_identif_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numDocIdentifPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.num_doc_identif_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'gradoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.grado_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'gradoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.grado_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombresyApellidosPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.nombres_y_apellidos_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombresyApellidosPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.nombres_y_apellidos_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'cargoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.cargo_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'cargoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.cargo_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC", nativeQuery = true)
    List<PersonalMantenimientoEquipoIngeniero> findAllPersonalMantenimientosEquiposIngenieros(@Param("idPersonalMantenimientoEquipoIngeniero") Long idPersonalMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_personal_mantenimientos_equipos_ingenieros.* FROM tabla_personal_mantenimientos_equipos_ingenieros, tabla_unidades_militares " +
          "WHERE (:idPersonalMantenimientoEquipoIngeniero IS NULL OR tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero = :idPersonalMantenimientoEquipoIngeniero) AND " +
          "(tabla_personal_mantenimientos_equipos_ingenieros.id_unidad_militar = tabla_unidades_militares.id_unidad_militar) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_personal_mantenimientos_equipos_ingenieros.num_doc_identif_personal_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_personal_mantenimientos_equipos_ingenieros.nombres_y_apellidos_personal_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) LIKE UPPER('%'||:keyword||'%'))) AND " +
          "(:siglaoAcronimoUnidadMilitar IS NULL OR UPPER(tabla_unidades_militares.sigla_o_acronimo_unidad_militar) = UPPER(:siglaoAcronimoUnidadMilitar)) " +
          "ORDER BY CASE WHEN :orderBy = 'idPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'idUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.id_unidad_militar END DESC, " +
          "CASE WHEN :orderBy = 'numDocIdentifPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.num_doc_identif_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numDocIdentifPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.num_doc_identif_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'gradoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.grado_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'gradoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.grado_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombresyApellidosPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.nombres_y_apellidos_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombresyApellidosPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.nombres_y_apellidos_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'cargoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_personal_mantenimientos_equipos_ingenieros.cargo_personal_mantenimiento_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'cargoPersonalMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_personal_mantenimientos_equipos_ingenieros.cargo_personal_mantenimiento_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'ASC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END ASC, " +
          "CASE WHEN :orderBy = 'siglaoAcronimoUnidadMilitar' AND :orderMode = 'DESC' THEN tabla_unidades_militares.sigla_o_acronimo_unidad_militar END DESC", nativeQuery = true)
    Slice<PersonalMantenimientoEquipoIngeniero> findAllPersonalMantenimientosEquiposIngenierosPag(Pageable pageable, @Param("idPersonalMantenimientoEquipoIngeniero") Long idPersonalMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("siglaoAcronimoUnidadMilitar") String siglaoAcronimoUnidadMilitar, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<PersonalMantenimientoEquipoIngeniero> findByIdPersonalMantenimientoEquipoIngeniero(Long idPersonalMantenimientoEquipoIngeniero);
    
    PersonalMantenimientoEquipoIngeniero findByNumDocIdentifPersonalMantenimientoEquipoIngeniero(String numDocIdentifPersonalMantenimientoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(tabla_personal_mantenimientos_equipos_ingenieros.id_personal_mantenimiento_equipo_ingeniero) FROM tabla_personal_mantenimientos_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdPersonalMantenimientoEquipoIngeniero();
}
