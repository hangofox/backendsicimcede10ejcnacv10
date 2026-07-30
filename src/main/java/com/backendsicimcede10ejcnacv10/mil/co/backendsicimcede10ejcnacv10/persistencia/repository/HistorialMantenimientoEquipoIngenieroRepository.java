//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialMantenimientoEquipoIngeniero;
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
public interface HistorialMantenimientoEquipoIngenieroRepository extends JpaRepository<HistorialMantenimientoEquipoIngeniero, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (KEYWORD + ID HISTORIAL MANTENIMIENTO EQUIPO INGENIERO + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_historial_mantenimientos_equipos_ingenieros " +
            "WHERE (:idHistorialMantenimientoEquipoIngeniero IS NULL OR tabla_historial_mantenimientos_equipos_ingenieros.id_historial_mantenimiento_equipo_ingeniero = :idHistorialMantenimientoEquipoIngeniero) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_mantenimientos_equipos_ingenieros.num_reg_historial_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idHistorialMantenimientoEquipoIngeniero") Long idHistorialMantenimientoEquipoIngeniero, @Param("keyword") String keyword);
    
    @Query(value = "SELECT tabla_historial_mantenimientos_equipos_ingenieros.* FROM tabla_historial_mantenimientos_equipos_ingenieros " +
            "WHERE (:idHistorialMantenimientoEquipoIngeniero IS NULL OR tabla_historial_mantenimientos_equipos_ingenieros.id_historial_mantenimiento_equipo_ingeniero = :idHistorialMantenimientoEquipoIngeniero) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_mantenimientos_equipos_ingenieros.num_reg_historial_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.id_historial_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.id_historial_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.num_reg_historial_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.num_reg_historial_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.asunto_mantenimiento_equipo_ingeniero, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.asunto_mantenimiento_equipo_ingeniero, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.descripcion_mantenimiento_equipo_ingeniero, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.descripcion_mantenimiento_equipo_ingeniero, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.fecha_h_m_s_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.fecha_h_m_s_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.valor_costo_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.valor_costo_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.nombre_documento_anexo_contrato_mtto_equip_ing END ASC, " +
            "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.nombre_documento_anexo_contrato_mtto_equip_ing END DESC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.nombre_archivo_documento_anexo_contrato_mtto_equip_ing, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.nombre_archivo_documento_anexo_contrato_mtto_equip_ing, 4000, 1) END DESC", nativeQuery = true)
    List<HistorialMantenimientoEquipoIngeniero> findAllHistorialesMantenimientosEquiposIngenieros(@Param("idHistorialMantenimientoEquipoIngeniero") Long idHistorialMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_historial_mantenimientos_equipos_ingenieros.* FROM tabla_historial_mantenimientos_equipos_ingenieros " +
            "WHERE (:idHistorialMantenimientoEquipoIngeniero IS NULL OR tabla_historial_mantenimientos_equipos_ingenieros.id_historial_mantenimiento_equipo_ingeniero = :idHistorialMantenimientoEquipoIngeniero) AND " +
            "(:keyword IS NULL OR UPPER(tabla_historial_mantenimientos_equipos_ingenieros.num_reg_historial_mantenimiento_equipo_ingeniero) LIKE UPPER('%'||:keyword||'%')) " +
            "ORDER BY CASE WHEN :orderBy = 'idHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.id_historial_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'idHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.id_historial_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.num_reg_historial_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'numRegHistorialMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.num_reg_historial_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.asunto_mantenimiento_equipo_ingeniero, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'asuntoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.asunto_mantenimiento_equipo_ingeniero, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.descripcion_mantenimiento_equipo_ingeniero, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'descripcionMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.descripcion_mantenimiento_equipo_ingeniero, 4000, 1) END DESC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.fecha_h_m_s_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'fechaHMSMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.fecha_h_m_s_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoEquipoIngeniero' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.valor_costo_mantenimiento_equipo_ingeniero END ASC, " +
            "CASE WHEN :orderBy = 'valorCostoMantenimientoEquipoIngeniero' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.valor_costo_mantenimiento_equipo_ingeniero END DESC, " +
            "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'ASC' THEN tabla_historial_mantenimientos_equipos_ingenieros.nombre_documento_anexo_contrato_mtto_equip_ing END ASC, " +
            "CASE WHEN :orderBy = 'nombreDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'DESC' THEN tabla_historial_mantenimientos_equipos_ingenieros.nombre_documento_anexo_contrato_mtto_equip_ing END DESC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'ASC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.nombre_archivo_documento_anexo_contrato_mtto_equip_ing, 4000, 1) END ASC, " +
            "CASE WHEN :orderBy = 'nombreArchivoDocumentoAnexoContratoMttoEquipIng' AND :orderMode = 'DESC' THEN DBMS_LOB.SUBSTR(tabla_historial_mantenimientos_equipos_ingenieros.nombre_archivo_documento_anexo_contrato_mtto_equip_ing, 4000, 1) END DESC", nativeQuery = true)
    Slice<HistorialMantenimientoEquipoIngeniero> findAllHistorialesMantenimientosEquiposIngenierosPag(Pageable pageable, @Param("idHistorialMantenimientoEquipoIngeniero") Long idHistorialMantenimientoEquipoIngeniero, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<HistorialMantenimientoEquipoIngeniero> findByIdHistorialMantenimientoEquipoIngeniero(Long idHistorialMantenimientoEquipoIngeniero);
    
    //BUSQUEDA UNITARIA POR CAMPO ÚNICO (NUM REG):
    HistorialMantenimientoEquipoIngeniero findByNumRegHistorialMantenimientoEquipoIngeniero(String numRegHistorialMantenimientoEquipoIngeniero);
    
    @Query(value = "SELECT MAX(id_historial_mantenimiento_equipo_ingeniero) FROM tabla_historial_mantenimientos_equipos_ingenieros", nativeQuery = true)
    Long findMaxIdHistorialMantenimientoEquipoIngeniero();
}
