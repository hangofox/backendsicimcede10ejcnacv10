//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SuministroDemeritoYDesgasteEquipoIngeniero;
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
public interface SuministroDemeritoYDesgasteEquipoIngenieroRepository extends JpaRepository<SuministroDemeritoYDesgasteEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID SUMINISTRO + KEYWORD + ID HISTORIAL DEMERITO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_suministros_demeritos_y_desgastes_equipos_ingenieros " +
          "WHERE (:idSuministroDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_suministro_demerito_y_desgaste_equipo_ingeniero = :idSuministroDemeritoYDesgasteEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.nombre_suministro_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idHistorialDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero = :idHistorialDemeritoYDesgasteEquipoIngeniero)", nativeQuery = true)
    Long findTotalRegistros(@Param("idSuministroDemeritoYDesgasteEquipoIngeniero") Long idSuministroDemeritoYDesgasteEquipoIngeniero, @Param("keyword") String keyword, @Param("idHistorialDemeritoYDesgasteEquipoIngeniero") Long idHistorialDemeritoYDesgasteEquipoIngeniero);
    
    @Query(value = "SELECT tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.* FROM tabla_suministros_demeritos_y_desgastes_equipos_ingenieros " +
          "WHERE (:idSuministroDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_suministro_demerito_y_desgaste_equipo_ingeniero = :idSuministroDemeritoYDesgasteEquipoIngeniero) " +
          "AND (:keyword IS NULL OR UPPER(tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.nombre_suministro_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) " +
          "AND (:idHistorialDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero = :idHistorialDemeritoYDesgasteEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_suministro_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_suministro_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.nombre_suministro_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.nombre_suministro_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.valor_suministro_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'valorSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.valor_suministro_demerito_y_desgaste_equipo_ingeniero END DESC", nativeQuery = true)
    List<SuministroDemeritoYDesgasteEquipoIngeniero> findAllSuministrosDemeritosYDesgastesEquiposIngenieros(@Param("idSuministroDemeritoYDesgasteEquipoIngeniero") Long idSuministroDemeritoYDesgasteEquipoIngeniero, @Param("keyword") String keyword, @Param("idHistorialDemeritoYDesgasteEquipoIngeniero") Long idHistorialDemeritoYDesgasteEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.* FROM tabla_suministros_demeritos_y_desgastes_equipos_ingenieros " +
          "WHERE (:idSuministroDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_suministro_demerito_y_desgaste_equipo_ingeniero = :idSuministroDemeritoYDesgasteEquipoIngeniero) AND " +
          "(:keyword IS NULL OR UPPER(tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.nombre_suministro_demerito_y_desgaste_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) AND " +
          "(:idHistorialDemeritoYDesgasteEquipoIngeniero IS NULL OR tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero = :idHistorialDemeritoYDesgasteEquipoIngeniero) " +
          "ORDER BY CASE WHEN :orderBy = 'idSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_suministro_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_suministro_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.nombre_suministro_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'nombreSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.nombre_suministro_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idHistorialDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.id_historial_demerito_y_desgaste_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'valorSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.valor_suministro_demerito_y_desgaste_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'valorSuministroDemeritoYDesgasteEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_suministros_demeritos_y_desgastes_equipos_ingenieros.valor_suministro_demerito_y_desgaste_equipo_ingeniero END DESC", nativeQuery = true)
    Slice<SuministroDemeritoYDesgasteEquipoIngeniero> findAllSuministrosDemeritosYDesgastesEquiposIngenierosPag(Pageable pageable, @Param("idSuministroDemeritoYDesgasteEquipoIngeniero") Long idSuministroDemeritoYDesgasteEquipoIngeniero, @Param("keyword") String keyword, @Param("idHistorialDemeritoYDesgasteEquipoIngeniero") Long idHistorialDemeritoYDesgasteEquipoIngeniero, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<SuministroDemeritoYDesgasteEquipoIngeniero> findByIdSuministroDemeritoYDesgasteEquipoIngeniero(Long idSuministroDemeritoYDesgasteEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_suministro_demerito_y_desgaste_equipo_ingeniero) FROM tabla_suministros_demeritos_y_desgastes_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdSuministroDemeritoYDesgasteEquipoIngeniero();
}
