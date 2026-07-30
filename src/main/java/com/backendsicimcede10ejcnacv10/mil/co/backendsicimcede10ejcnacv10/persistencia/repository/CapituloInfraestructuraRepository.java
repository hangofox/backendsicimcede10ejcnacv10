//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CapituloInfraestructura;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface CapituloInfraestructuraRepository extends JpaRepository<CapituloInfraestructura,Long> {
    
    @Query(value = "SELECT * FROM tabla_capitulos_infraestructuras ORDER BY CASE WHEN :orderMode = 'ASC' THEN id_capitulo_infraestructura END ASC, CASE WHEN :orderMode = 'DESC' THEN id_capitulo_infraestructura END DESC", nativeQuery = true)
    List<CapituloInfraestructura> findAllCapitulosInfraestructurasOrderedById(@Param("orderMode") String orderMode);
    
    @Query(value = "SELECT * FROM tabla_capitulos_infraestructuras ORDER BY CASE WHEN :orderMode = 'ASC' THEN id_capitulo_infraestructura END ASC, CASE WHEN :orderMode = 'DESC' THEN id_capitulo_infraestructura END DESC", nativeQuery = true)
    Slice<CapituloInfraestructura> findAllCapitulosInfraestructurasOrderedByIdPag(Pageable pageable, @Param("orderMode") String orderMode);
    
    Optional<CapituloInfraestructura> findByIdCapituloInfraestructura(Long idCapituloInfraestructura);
    
    CapituloInfraestructura findByNombreCapituloInfraestructura(String nombreCapituloInfraestructura);
    
    @Query(value = "SELECT MAX(id_capitulo_infraestructura) FROM tabla_capitulos_infraestructuras", nativeQuery = true)
    Long findMaxIdCapituloInfraestructura();
}
