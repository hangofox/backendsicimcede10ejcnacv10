//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialDemeritoYDesgasteEquipoIngeniero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface HistorialDemeritoYDesgasteEquipoIngenieroRepository extends JpaRepository<HistorialDemeritoYDesgasteEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_demeritos_y_desgastes_equipos_ingenieros " +
          "WHERE (:idHistorialDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_historial_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero = :idHistorialDemeritoYDesgasteEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_demeritos_y_desgastes_equipos_ingenieros.num_reg_historial_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_demeritos_y_desgastes_equipos_ingenieros.nombre_proyecto_historial_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialDemeritoYDesgasteEquipoIngeniero") Long idHistorialDemeritoYDesgasteEquipoIngeniero, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_demeritos_y_desgastes_equipos_ingenieros.* FROM tabla_historial_demeritos_y_desgastes_equipos_ingenieros " +
          "WHERE (:idHistorialDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_historial_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero = :idHistorialDemeritoYDesgasteEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_demeritos_y_desgastes_equipos_ingenieros.num_reg_historial_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_demeritos_y_desgastes_equipos_ingenieros.nombre_proyecto_historial_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.num_reg_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.num_reg_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.nombre_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.nombre_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.valor_presupuestal_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.valor_presupuestal_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.horas_trabajadas_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.horas_trabajadas_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.kilometros_recorridos_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.kilometros_recorridos_historial_demerito_y_desgaste_equipo_ingeniero END DESC", nativeQuery = true)
    List<HistorialDemeritoYDesgasteEquipoIngeniero> findAllHistorialesDemeritosYDesgastesEquiposIngenieros(@Param("idHistorialDemeritoYDesgasteEquipoIngeniero") Long idHistorialDemeritoYDesgasteEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_demeritos_y_desgastes_equipos_ingenieros.* FROM tabla_historial_demeritos_y_desgastes_equipos_ingenieros " +
          "WHERE (:idHistorialDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_historial_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero = :idHistorialDemeritoYDesgasteEquipoIngeniero) AND " +
          "(:keyword IS NULL OR (UPPER(tabla_historial_demeritos_y_desgastes_equipos_ingenieros.num_reg_historial_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%') OR " +
          "UPPER(tabla_historial_demeritos_y_desgastes_equipos_ingenieros.nombre_proyecto_historial_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))) " +
          "ORDER BY CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'numRegHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.num_reg_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'numRegHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.num_reg_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.nombre_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.nombre_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.valor_presupuestal_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'valorPresupuestalProyectoHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.valor_presupuestal_proyecto_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.horas_trabajadas_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'horasTrabajadasHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.horas_trabajadas_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.kilometros_recorridos_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'kilometrosRecorridosHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_demeritos_y_desgastes_equipos_ingenieros.kilometros_recorridos_historial_demerito_y_desgaste_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<HistorialDemeritoYDesgasteEquipoIngeniero> findAllHistorialesDemeritosYDesgastesEquiposIngenierosPag(Pageable pageable, @Param("idHistorialDemeritoYDesgasteEquipoIngeniero") Long idHistorialDemeritoYDesgasteEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialDemeritoYDesgasteEquipoIngeniero> findByIdHistorialDemeritoYDesgasteEquipoIngeniero(Long idHistorialDemeritoYDesgasteEquipoIngeniero);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialDemeritoYDesgasteEquipoIngeniero findByNumRegHistorialDemeritoYDesgasteEquipoIngeniero(String numRegHistorialDemeritoYDesgasteEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_historial_demerito_y_desgaste_equipo_ingeniero) FROM tabla_historial_demeritos_y_desgastes_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdHistorialDemeritoYDesgasteEquipoIngeniero();
}
