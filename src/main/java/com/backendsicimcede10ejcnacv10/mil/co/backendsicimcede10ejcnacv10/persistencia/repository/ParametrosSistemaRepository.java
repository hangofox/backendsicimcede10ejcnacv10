//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ParametrosSistema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/07/2026.
* DECLARACIÓN DE LA CLASE INTERFACE DEL REPOSITORIO QUIEN ES EL QUE HACE EL ENLACE DIRECTO HACIA LA BASE DE DATOS.
*/
public interface ParametrosSistemaRepository extends JpaRepository<ParametrosSistema, Long> {
    
    //CONTADORES Y LISTADOS UNIFICADOS (ID PARAMETROS SISTEMA + ORDERBY + ORDERMODE):
    @Query(value = "SELECT COUNT(*) FROM tabla_parametros_sistema " +
            "WHERE (:idParametrosSistema IS NULL OR tabla_parametros_sistema.id_parametros_sistema = :idParametrosSistema)", nativeQuery = true)
    Long findTotalRegistros(@Param("idParametrosSistema") Long idParametrosSistema);
    
    @Query(value = "SELECT tabla_parametros_sistema.* FROM tabla_parametros_sistema " +
            "WHERE (:idParametrosSistema IS NULL OR tabla_parametros_sistema.id_parametros_sistema = :idParametrosSistema) " +
            "ORDER BY CASE WHEN :orderBy = 'idParametrosSistema' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.id_parametros_sistema END ASC, " +
            "CASE WHEN :orderBy = 'idParametrosSistema' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.id_parametros_sistema END DESC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosSesionInactivaSistema' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.tiempo_minutos_sesion_inactiva_sistema END ASC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosSesionInactivaSistema' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.tiempo_minutos_sesion_inactiva_sistema END DESC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosValidezCodigoActivacionContrasena' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.tiempo_minutos_validez_codigo_activacion_contrasena END ASC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosValidezCodigoActivacionContrasena' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.tiempo_minutos_validez_codigo_activacion_contrasena END DESC, " +
            "CASE WHEN :orderBy = 'authEnable' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.auth_enable END ASC, " +
            "CASE WHEN :orderBy = 'authEnable' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.auth_enable END DESC, " +
            "CASE WHEN :orderBy = 'startTTLSEnable' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.start_ttls_enable END ASC, " +
            "CASE WHEN :orderBy = 'startTTLSEnable' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.start_ttls_enable END DESC, " +
            "CASE WHEN :orderBy = 'smtpHost' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.smtp_host END ASC, " +
            "CASE WHEN :orderBy = 'smtpHost' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.smtp_host END DESC, " +
            "CASE WHEN :orderBy = 'smtpPort' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.smtp_port END ASC, " +
            "CASE WHEN :orderBy = 'smtpPort' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.smtp_port END DESC, " +
            "CASE WHEN :orderBy = 'smtpProtocols' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.smtp_protocols END ASC, " +
            "CASE WHEN :orderBy = 'smtpProtocols' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.smtp_protocols END DESC, " +
            "CASE WHEN :orderBy = 'usuarioRemitente' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.usuario_remitente END ASC, " +
            "CASE WHEN :orderBy = 'usuarioRemitente' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.usuario_remitente END DESC, " +
            "CASE WHEN :orderBy = 'correoElectronicoRemitente' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.correo_electronico_remitente END ASC, " +
            "CASE WHEN :orderBy = 'correoElectronicoRemitente' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.correo_electronico_remitente END DESC, " +
            "CASE WHEN :orderBy = 'asuntoDestinatarioRecuperacionContrasena' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.asunto_destinatario_recuperacion_contrasena END ASC, " +
            "CASE WHEN :orderBy = 'asuntoDestinatarioRecuperacionContrasena' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.asunto_destinatario_recuperacion_contrasena END DESC", nativeQuery = true)
    List<ParametrosSistema> findAllParametrosSistema(@Param("idParametrosSistema") Long idParametrosSistema, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    @Query(value = "SELECT tabla_parametros_sistema.* FROM tabla_parametros_sistema " +
            "WHERE (:idParametrosSistema IS NULL OR tabla_parametros_sistema.id_parametros_sistema = :idParametrosSistema) " +
            "ORDER BY CASE WHEN :orderBy = 'idParametrosSistema' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.id_parametros_sistema END ASC, " +
            "CASE WHEN :orderBy = 'idParametrosSistema' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.id_parametros_sistema END DESC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosSesionInactivaSistema' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.tiempo_minutos_sesion_inactiva_sistema END ASC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosSesionInactivaSistema' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.tiempo_minutos_sesion_inactiva_sistema END DESC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosValidezCodigoActivacionContrasena' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.tiempo_minutos_validez_codigo_activacion_contrasena END ASC, " +
            "CASE WHEN :orderBy = 'tiempoMinutosValidezCodigoActivacionContrasena' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.tiempo_minutos_validez_codigo_activacion_contrasena END DESC, " +
            "CASE WHEN :orderBy = 'authEnable' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.auth_enable END ASC, " +
            "CASE WHEN :orderBy = 'authEnable' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.auth_enable END DESC, " +
            "CASE WHEN :orderBy = 'startTTLSEnable' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.start_ttls_enable END ASC, " +
            "CASE WHEN :orderBy = 'startTTLSEnable' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.start_ttls_enable END DESC, " +
            "CASE WHEN :orderBy = 'smtpHost' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.smtp_host END ASC, " +
            "CASE WHEN :orderBy = 'smtpHost' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.smtp_host END DESC, " +
            "CASE WHEN :orderBy = 'smtpPort' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.smtp_port END ASC, " +
            "CASE WHEN :orderBy = 'smtpPort' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.smtp_port END DESC, " +
            "CASE WHEN :orderBy = 'smtpProtocols' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.smtp_protocols END ASC, " +
            "CASE WHEN :orderBy = 'smtpProtocols' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.smtp_protocols END DESC, " +
            "CASE WHEN :orderBy = 'usuarioRemitente' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.usuario_remitente END ASC, " +
            "CASE WHEN :orderBy = 'usuarioRemitente' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.usuario_remitente END DESC, " +
            "CASE WHEN :orderBy = 'correoElectronicoRemitente' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.correo_electronico_remitente END ASC, " +
            "CASE WHEN :orderBy = 'correoElectronicoRemitente' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.correo_electronico_remitente END DESC, " +
            "CASE WHEN :orderBy = 'asuntoDestinatarioRecuperacionContrasena' AND :orderMode = 'ASC' THEN tabla_parametros_sistema.asunto_destinatario_recuperacion_contrasena END ASC, " +
            "CASE WHEN :orderBy = 'asuntoDestinatarioRecuperacionContrasena' AND :orderMode = 'DESC' THEN tabla_parametros_sistema.asunto_destinatario_recuperacion_contrasena END DESC", nativeQuery = true)
    Slice<ParametrosSistema> findAllParametrosSistemaPag(Pageable pageable, @Param("idParametrosSistema") Long idParametrosSistema, @Param("orderBy") String orderBy, @Param("orderMode") String orderMode);
    
    Optional<ParametrosSistema> findByIdParametrosSistema(Long idParametrosSistema);
    
    @Query(value = "SELECT MAX(id_parametros_sistema) FROM tabla_parametros_sistema", nativeQuery = true)
    Long findMaxIdParametrosSistema();
}
