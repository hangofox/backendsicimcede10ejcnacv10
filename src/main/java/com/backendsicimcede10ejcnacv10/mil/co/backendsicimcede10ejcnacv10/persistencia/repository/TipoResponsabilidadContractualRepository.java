//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoResponsabilidadContractual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface TipoResponsabilidadContractualRepository extends JpaRepository<TipoResponsabilidadContractual,Long> {
    
    @Query(value = "SELECT COUNT(*) FROM tabla_tipos_responsabilidades_contractuales WHERE (:idTipoResponsabilidadContractual IS NULL OR id_tipo_responsabilidad_contractual = :idTipoResponsabilidadContractual) AND (:keyword IS NULL OR UPPER(nombre_tipo_responsabilidad_contractual) LIKE UPPER('%'||:keyword||'%'))", nativeQuery = true)
    Long findTotalRegistros(@Param("idTipoResponsabilidadContractual") Long idTipoResponsabilidadContractual, @Param("keyword") String keyword);
    
    @Query(value = "SELECT * FROM tabla_tipos_responsabilidades_contractuales WHERE (:idTipoResponsabilidadContractual IS NULL OR id_tipo_responsabilidad_contractual = :idTipoResponsabilidadContractual) AND (:keyword IS NULL OR UPPER(nombre_tipo_responsabilidad_contractual) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN id_tipo_responsabilidad_contractual END ASC, CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN id_tipo_responsabilidad_contractual END DESC, CASE WHEN :orderBy = 'nombreTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN nombre_tipo_responsabilidad_contractual END ASC, CASE WHEN :orderBy = 'nombreTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN nombre_tipo_responsabilidad_contractual END DESC", nativeQuery = true)
    List<TipoResponsabilidadContractual> findAllTiposResponsabilidadesContractuales(@Param("idTipoResponsabilidadContractual") Long idTipoResponsabilidadContractual, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_tipos_responsabilidades_contractuales WHERE (:idTipoResponsabilidadContractual IS NULL OR id_tipo_responsabilidad_contractual = :idTipoResponsabilidadContractual) AND (:keyword IS NULL OR UPPER(nombre_tipo_responsabilidad_contractual) LIKE UPPER('%'||:keyword||'%')) ORDER BY CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN id_tipo_responsabilidad_contractual END ASC, CASE WHEN :orderBy = 'idTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN id_tipo_responsabilidad_contractual END DESC, CASE WHEN :orderBy = 'nombreTipoResponsabilidadContractual' AND :orderMode = 'ASC' THEN nombre_tipo_responsabilidad_contractual END ASC, CASE WHEN :orderBy = 'nombreTipoResponsabilidadContractual' AND :orderMode = 'DESC' THEN nombre_tipo_responsabilidad_contractual END DESC", nativeQuery = true)
    Slice<TipoResponsabilidadContractual> findAllTiposResponsabilidadesContractualesPag(Pageable pageable, @Param("idTipoResponsabilidadContractual") Long idTipoResponsabilidadContractual, @Param("keyword") String keyword, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<TipoResponsabilidadContractual> findByIdTipoResponsabilidadContractual(Long idTipoResponsabilidadContractual);
    
    TipoResponsabilidadContractual findByNombreTipoResponsabilidadContractual(String nombreTipoResponsabilidadContractual);
    
    @Query(value = "SELECT MAX(id_tipo_responsabilidad_contractual) FROM tabla_tipos_responsabilidades_contractuales", nativeQuery = true)
    Long findMaxIdTipoResponsabilidadContractual();
}
