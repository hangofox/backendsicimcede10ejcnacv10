//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoActividadExpEquipHerrYPerrDispArtefExp;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface TipoActividadExpEquipHerrYPerrDispArtefExpRepository extends JpaRepository<TipoActividadExpEquipHerrYPerrDispArtefExp,Long> {
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT COUNT(*) " +
          "FROM tabla_tipos_actividades_exp_equip_herr_y_perr_disp_artef_exp " +
          "WHERE " +
          "(:idTipoActividadExpEquipHerrYPerrDispArtefExp IS NULL OR id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp = :idTipoActividadExpEquipHerrYPerrDispArtefExp) AND " +
          "(:keyword IS NULL OR nombre_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp LIKE '%' || :keyword || '%')", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoActividadExpEquipHerrYPerrDispArtefExp") Long idTipoActividadExpEquipHerrYPerrDispArtefExp, @Param("keyword") String keyword);
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_actividades_exp_equip_herr_y_perr_disp_artef_exp " +
          "WHERE " +
          "(:idTipoActividadExpEquipHerrYPerrDispArtefExp IS NULL OR id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp = :idTipoActividadExpEquipHerrYPerrDispArtefExp) AND " +
          "(:keyword IS NULL OR nombre_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'ASC' THEN id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END ASC, " +
          "CASE WHEN :orderBy = 'idTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'DESC' THEN id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'ASC' THEN nombre_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'DESC' THEN nombre_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END DESC", nativeQuery = true)
    List<TipoActividadExpEquipHerrYPerrDispArtefExp> findAllTiposActividadesExpEquipHerrYPerrDispArtefExp(@Param("idTipoActividadExpEquipHerrYPerrDispArtefExp") Long idTipoActividadExpEquipHerrYPerrDispArtefExp, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT * " +
          "FROM tabla_tipos_actividades_exp_equip_herr_y_perr_disp_artef_exp " +
          "WHERE " +
          "(:idTipoActividadExpEquipHerrYPerrDispArtefExp IS NULL OR id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp = :idTipoActividadExpEquipHerrYPerrDispArtefExp) AND " +
          "(:keyword IS NULL OR nombre_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp LIKE '%' || :keyword || '%') " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'ASC' THEN id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END ASC, " +
          "CASE WHEN :orderBy = 'idTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'DESC' THEN id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END DESC, " +
          "CASE WHEN :orderBy = 'nombreTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'ASC' THEN nombre_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END ASC, " +
          "CASE WHEN :orderBy = 'nombreTipoActividadExpEquipHerrYPerrDispArtefExp' AND :orderMode = 'DESC' THEN nombre_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp END DESC", nativeQuery = true)
    Slice<TipoActividadExpEquipHerrYPerrDispArtefExp> findAllTiposActividadesExpEquipHerrYPerrDispArtefExpPag(Pageable pageable, @Param("idTipoActividadExpEquipHerrYPerrDispArtefExp") Long idTipoActividadExpEquipHerrYPerrDispArtefExp, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoActividadExpEquipHerrYPerrDispArtefExp> findByIdTipoActividadExpEquipHerrYPerrDispArtefExp(Long idTipoActividadExpEquipHerrYPerrDispArtefExp);
    
    TipoActividadExpEquipHerrYPerrDispArtefExp findByNombreTipoActividadExpEquipHerrYPerrDispArtefExp(String nombreTipoActividadExpEquipHerrYPerrDispArtefExp);
    
    @Query(value = "SELECT MAX(id_tipo_actividad_exp_equip_herr_y_perr_disp_artef_exp) FROM tabla_tipos_actividades_exp_equip_herr_y_perr_disp_artef_exp", nativeQuery = true)
    Long findMaxIdTipoActividadExpEquipHerrYPerrDispArtefExp();
}
