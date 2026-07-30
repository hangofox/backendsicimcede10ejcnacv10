//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionTecnicomecanicaEquipTransp;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ProyeccionTecnicomecanicaEquipTranspRepository extends JpaRepository<ProyeccionTecnicomecanicaEquipTransp, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (FILTROS + ORDERBY + ORDERMODE):
    @Query(value = "" +
          "SELECT COUNT(*) FROM tabla_proyecciones_tecnicomecanicas_equip_transp " +
          "WHERE " +
          "(:idProyeccionTecnicomecanicaEquipTransp IS NULL OR id_proyeccion_tecnicomecanica_equip_transp = :idProyeccionTecnicomecanicaEquipTransp) AND " +
          "(:idEquipoIngeniero IS NULL OR id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp || '%')) AND " +
          "(:valorSolicitadoProyeccionTecnicomecanicaEquipTransp IS NULL OR UPPER(valor_solicitado_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :valorSolicitadoProyeccionTecnicomecanicaEquipTransp || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :keyword || '%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idProyeccionTecnicomecanicaEquipTransp") Long idProyeccionTecnicomecanicaEquipTransp, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp") String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, @Param("valorSolicitadoProyeccionTecnicomecanicaEquipTransp") String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, @Param("keyword") String keyword);
    
    @Query(value = "" +
          "SELECT tabla_proyecciones_tecnicomecanicas_equip_transp.* FROM tabla_proyecciones_tecnicomecanicas_equip_transp " +
          "WHERE " +
          "(:idProyeccionTecnicomecanicaEquipTransp IS NULL OR id_proyeccion_tecnicomecanica_equip_transp = :idProyeccionTecnicomecanicaEquipTransp) AND " +
          "(:idEquipoIngeniero IS NULL OR id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp || '%')) AND " +
          "(:valorSolicitadoProyeccionTecnicomecanicaEquipTransp IS NULL OR UPPER(valor_solicitado_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :valorSolicitadoProyeccionTecnicomecanicaEquipTransp || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_proyeccion_tecnicomecanica_equip_transp END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.valor_solicitado_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.valor_solicitado_proyeccion_tecnicomecanica_equip_transp END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.fecha_h_m_s_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.fecha_h_m_s_proyeccion_tecnicomecanica_equip_transp END DESC", nativeQuery = true)
    List<ProyeccionTecnicomecanicaEquipTransp> findAllProyeccionesTecnicomecanicasEquipsTransps(@Param("idProyeccionTecnicomecanicaEquipTransp") Long idProyeccionTecnicomecanicaEquipTransp, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp") String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, @Param("valorSolicitadoProyeccionTecnicomecanicaEquipTransp") String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "" +
          "SELECT tabla_proyecciones_tecnicomecanicas_equip_transp.* FROM tabla_proyecciones_tecnicomecanicas_equip_transp " +
          "WHERE " +
          "(:idProyeccionTecnicomecanicaEquipTransp IS NULL OR id_proyeccion_tecnicomecanica_equip_transp = :idProyeccionTecnicomecanicaEquipTransp) AND " +
          "(:idEquipoIngeniero IS NULL OR id_equipo_ingeniero = :idEquipoIngeniero) AND " +
          "(:nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp || '%')) AND " +
          "(:valorSolicitadoProyeccionTecnicomecanicaEquipTransp IS NULL OR UPPER(valor_solicitado_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :valorSolicitadoProyeccionTecnicomecanicaEquipTransp || '%')) AND " +
          "(:keyword IS NULL OR UPPER(nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp) LIKE UPPER('%' || :keyword || '%')) " +
          "ORDER BY " +
          "CASE WHEN :orderBy = 'idProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'idProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_proyeccion_tecnicomecanica_equip_transp END DESC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_equipo_ingeniero END ASC, " +
          "CASE WHEN :orderBy = 'idEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.id_equipo_ingeniero END DESC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp END DESC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.valor_solicitado_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'valorSolicitadoProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.valor_solicitado_proyeccion_tecnicomecanica_equip_transp END DESC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'ASC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.fecha_h_m_s_proyeccion_tecnicomecanica_equip_transp END ASC, " +
          "CASE WHEN :orderBy = 'fechaHMSProyeccionTecnicomecanicaEquipTransp' AND :orderMode = 'DESC' THEN tabla_proyecciones_tecnicomecanicas_equip_transp.fecha_h_m_s_proyeccion_tecnicomecanica_equip_transp END DESC", nativeQuery = true)
    Slice<ProyeccionTecnicomecanicaEquipTransp> findAllProyeccionesTecnicomecanicasEquipsTranspsPag(Pageable pageable, @Param("idProyeccionTecnicomecanicaEquipTransp") Long idProyeccionTecnicomecanicaEquipTransp, @Param("idEquipoIngeniero") Long idEquipoIngeniero, @Param("nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp") String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, @Param("valorSolicitadoProyeccionTecnicomecanicaEquipTransp") String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ProyeccionTecnicomecanicaEquipTransp> findByIdProyeccionTecnicomecanicaEquipTransp(Long idProyeccionTecnicomecanicaEquipTransp);
    
    //BUSQUEDA UNITARIA POR NOMBRE Y NUMERO RUBRO E ID EQUIPO INGENIERO (PARA VALIDACIÓN DE DUPLICADOS):
    @Query(value = "SELECT * FROM tabla_proyecciones_tecnicomecanicas_equip_transp " +
          "WHERE (UPPER(nombre_y_numero_rubro_proyeccion_tecnicomecanica_equip_transp) = :nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp) AND " +
          "(id_equipo_ingeniero = :idEquipoIngeniero) AND ROWNUM = 1", nativeQuery = true)
    ProyeccionTecnicomecanicaEquipTransp findByNombreYNumeroRubroAndIdEquipoIngeniero(@Param("nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp") String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, @Param("idEquipoIngeniero") Long idEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_proyeccion_tecnicomecanica_equip_transp) FROM tabla_proyecciones_tecnicomecanicas_equip_transp", nativeQuery = true)
    Long findMaxIdProyeccionTecnicomecanicaEquipTransp();
}
