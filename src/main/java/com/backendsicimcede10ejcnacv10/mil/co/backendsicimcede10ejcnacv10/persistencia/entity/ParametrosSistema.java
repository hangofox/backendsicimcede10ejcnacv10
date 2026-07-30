//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity;

//IMPORTACIÓN DE LIBRERIAS:
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.io.Serializable;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/07/2026.
* Declaración de la entidad.
*/
@Data//DECLARACIÓN DE LA DATA PARA LOS DATOS DE LA TABLA DE LA BASE DE DATOS PARA LA ENTIDAD.
@Entity//DECLARACIÓN DE LA ENTIDAD QUE ES LA MISMA TABLA DE LA BASE DE DATOS.
@Table(name = "TABLA_PARAMETROS_SISTEMA")//REFERENCIA A LA TABLA DE LA BASE DE DATOS.
public class ParametrosSistema {
    
    //CAMPOS DE LA TABLA DE LA BASE DE DATOS:
    @Id//DECLARACIÓN DEL ID PRINCIPAL DE LA TABLA DE BASE DE DATOS.
    
    //AQUI ES DONDE SE CREA EL ENLACE ENTRE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS Y LAS VARIABLES DECLARADAS
    //QUE RECIBIRAN O ENVIARAS LOS DATOS A LA BASE DE DATOS PARA LA ENTIDAD.
    //NOTA: EN LOS NAME SE PONEN EL NOMBRE DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS EXACTAMENTE IGUAL A COMO SE CREARÓN.
    @Column(name = "ID_PARAMETROS_SISTEMA", columnDefinition="NUMBER(20) NOT NULL")
    private Long idParametrosSistema;
    
    @Column(name = "TIEMPO_MINUTOS_SESION_INACTIVA_SISTEMA", columnDefinition="NUMBER(20) NOT NULL")
    private Long tiempoMinutosSesionInactivaSistema;
    
    @Column(name = "TIEMPO_MINUTOS_VALIDEZ_CODIGO_ACTIVACION_CONTRASENA", columnDefinition="NUMBER(20) NOT NULL")
    private Long tiempoMinutosValidezCodigoActivacionContrasena;
    
    @Column(name = "RUTA_DESTINO_CARPETA_PRINCIPAL_SERVIDOR_APLICACIONES", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoCarpetaPrincipalServidorAplicaciones;
    
    @Column(name = "RUTA_DESTINO_CARPETA_CARGUE_TEMPORAL_ARCHIVOS", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoCarpetaCargueTemporalArchivos;
    
    @Column(name = "RUTA_DESTINO_ARCHIVOS_USUARIOS", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoArchivosUsuarios;
    
    @Column(name = "RUTA_DESTINO_ARCHIVOS_UNIDADES_MILITARES", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoArchivosUnidadesMilitares;
    
    @Column(name = "RUTA_DESTINO_ARCHIVOS_INTEGRANTES_DOCUMENTOS", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoArchivosIntegrantesDocumentos;
    
    @Column(name = "RUTA_DESTINO_ARCHIVOS_CONCEPTOS_TECNICOS", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoArchivosConceptosTecnicos;
    
    @Column(name = "RUTA_DESTINO_ARCHIVOS_ACTAS_REINTEGROS", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoArchivosActasReintegros;
    
    @Column(name = "RUTA_DESTINO_ARCHIVOS_RESOLUCIONES_BAJAS", columnDefinition="CLOB NOT NULL")
    private String rutaDestinoArchivosResolucionesBajas;
    
    @Column(name = "AUTH_ENABLE", columnDefinition="VARCHAR2(150) NULL")
    private String authEnable;
    
    @Column(name = "START_TTLS_ENABLE", columnDefinition="VARCHAR2(150) NULL")
    private String startTTLSEnable;
    
    @Column(name = "SMTP_HOST", columnDefinition="VARCHAR2(150) NULL")
    private String smtpHost;
    
    @Column(name = "SMTP_PORT", columnDefinition="NUMBER(20) NULL")
    private Long smtpPort;
    
    @Column(name = "SMTP_PROTOCOLS", columnDefinition="VARCHAR2(150) NULL")
    private String smtpProtocols;
    
    @Column(name = "USUARIO_REMITENTE", columnDefinition="VARCHAR2(150) NULL")
    private String usuarioRemitente;
    
    @Column(name = "PASSWORD_REMITENTE", columnDefinition="VARCHAR2(150) NULL")
    private String passwordRemitente;
    
    @Column(name = "CORREO_ELECTRONICO_REMITENTE", columnDefinition="VARCHAR2(150) NULL")
    private String correoElectronicoRemitente;
    
    @Column(name = "ASUNTO_DESTINATARIO_RECUPERACION_CONTRASENA", columnDefinition="VARCHAR2(150) NULL")
    private String asuntoDestinatarioRecuperacionContrasena;
    
    @Column(name = "CUERPO_MENSAJE_HTML_RECUPERACION_CONTRASENA", columnDefinition="CLOB NULL")
    private String cuerpoMensajeHtmlRecuperacionContrasena;
    
    /*//DECLARACIÓN DE LOS MÉTODOS SETTERS Y GETTERS DE LAS VARIABLES DECLARADAS DE LOS CAMPOS DE LA TABLA DE LA BASE DE DATOS DE LA ENTIDAD:
    public Long getIdParametrosSistema() {
        return idParametrosSistema;
    }
    public void setIdParametrosSistema(Long idParametrosSistema) {
        this.idParametrosSistema = idParametrosSistema;
    }
    public Long getTiempoMinutosSesionInactivaSistema() {
        return tiempoMinutosSesionInactivaSistema;
    }
    public void setTiempoMinutosSesionInactivaSistema(Long tiempoMinutosSesionInactivaSistema) {
        this.tiempoMinutosSesionInactivaSistema = tiempoMinutosSesionInactivaSistema;
    }
    public Long getTiempoMinutosValidezCodigoActivacionContrasena() {
        return tiempoMinutosValidezCodigoActivacionContrasena;
    }
    public void setTiempoMinutosValidezCodigoActivacionContrasena(Long tiempoMinutosValidezCodigoActivacionContrasena) {
        this.tiempoMinutosValidezCodigoActivacionContrasena = tiempoMinutosValidezCodigoActivacionContrasena;
    }
    public String getRutaDestinoCarpetaPrincipalServidorAplicaciones() {
        return rutaDestinoCarpetaPrincipalServidorAplicaciones;
    }
    public void setRutaDestinoCarpetaPrincipalServidorAplicaciones(String rutaDestinoCarpetaPrincipalServidorAplicaciones) {
        this.rutaDestinoCarpetaPrincipalServidorAplicaciones = rutaDestinoCarpetaPrincipalServidorAplicaciones;
    }
    public String getRutaDestinoCarpetaCargueTemporalArchivos() {
        return rutaDestinoCarpetaCargueTemporalArchivos;
    }
    public void setRutaDestinoCarpetaCargueTemporalArchivos(String rutaDestinoCarpetaCargueTemporalArchivos) {
        this.rutaDestinoCarpetaCargueTemporalArchivos = rutaDestinoCarpetaCargueTemporalArchivos;
    }
    public String getRutaDestinoArchivosUsuarios() {
        return rutaDestinoArchivosUsuarios;
    }
    public void setRutaDestinoArchivosUsuarios(String rutaDestinoArchivosUsuarios) {
        this.rutaDestinoArchivosUsuarios = rutaDestinoArchivosUsuarios;
    }
    public String getRutaDestinoArchivosUnidadesMilitares() {
        return rutaDestinoArchivosUnidadesMilitares;
    }
    public void setRutaDestinoArchivosUnidadesMilitares(String rutaDestinoArchivosUnidadesMilitares) {
        this.rutaDestinoArchivosUnidadesMilitares = rutaDestinoArchivosUnidadesMilitares;
    }
    public String getRutaDestinoArchivosIntegrantesDocumentos() {
        return rutaDestinoArchivosIntegrantesDocumentos;
    }
    public void setRutaDestinoArchivosIntegrantesDocumentos(String rutaDestinoArchivosIntegrantesDocumentos) {
        this.rutaDestinoArchivosIntegrantesDocumentos = rutaDestinoArchivosIntegrantesDocumentos;
    }
    public String getRutaDestinoArchivosConceptosTecnicos() {
        return rutaDestinoArchivosConceptosTecnicos;
    }
    public void setRutaDestinoArchivosConceptosTecnicos(String rutaDestinoArchivosConceptosTecnicos) {
        this.rutaDestinoArchivosConceptosTecnicos = rutaDestinoArchivosConceptosTecnicos;
    }
    public String getRutaDestinoArchivosActasReintegros() {
        return rutaDestinoArchivosActasReintegros;
    }
    public void setRutaDestinoArchivosActasReintegros(String rutaDestinoArchivosActasReintegros) {
        this.rutaDestinoArchivosActasReintegros = rutaDestinoArchivosActasReintegros;
    }
    public String getRutaDestinoArchivosResolucionesBajas() {
        return rutaDestinoArchivosResolucionesBajas;
    }
    public void setRutaDestinoArchivosResolucionesBajas(String rutaDestinoArchivosResolucionesBajas) {
        this.rutaDestinoArchivosResolucionesBajas = rutaDestinoArchivosResolucionesBajas;
    }
    public String getAuthEnable() {
        return authEnable;
    }
    public void setAuthEnable(String authEnable) {
        this.authEnable = authEnable;
    }
    public String getStartTTLSEnable() {
        return startTTLSEnable;
    }
    public void setStartTTLSEnable(String startTTLSEnable) {
        this.startTTLSEnable = startTTLSEnable;
    }
    public String getSmtpHost() {
        return smtpHost;
    }
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }
    public Long getSmtpPort() {
        return smtpPort;
    }
    public void setSmtpPort(Long smtpPort) {
        this.smtpPort = smtpPort;
    }
    public String getSmtpProtocols() {
        return smtpProtocols;
    }
    public void setSmtpProtocols(String smtpProtocols) {
        this.smtpProtocols = smtpProtocols;
    }
    public String getUsuarioRemitente() {
        return usuarioRemitente;
    }
    public void setUsuarioRemitente(String usuarioRemitente) {
        this.usuarioRemitente = usuarioRemitente;
    }
    public String getPasswordRemitente() {
        return passwordRemitente;
    }
    public void setPasswordRemitente(String passwordRemitente) {
        this.passwordRemitente = passwordRemitente;
    }
    public String getCorreoElectronicoRemitente() {
        return correoElectronicoRemitente;
    }
    public void setCorreoElectronicoRemitente(String correoElectronicoRemitente) {
        this.correoElectronicoRemitente = correoElectronicoRemitente;
    }
    public String getAsuntoDestinatarioRecuperacionContrasena() {
        return asuntoDestinatarioRecuperacionContrasena;
    }
    public void setAsuntoDestinatarioRecuperacionContrasena(String asuntoDestinatarioRecuperacionContrasena) {
        this.asuntoDestinatarioRecuperacionContrasena = asuntoDestinatarioRecuperacionContrasena;
    }
    public String getCuerpoMensajeHtmlRecuperacionContrasena() {
        return cuerpoMensajeHtmlRecuperacionContrasena;
    }
    public void setCuerpoMensajeHtmlRecuperacionContrasena(String cuerpoMensajeHtmlRecuperacionContrasena) {
        this.cuerpoMensajeHtmlRecuperacionContrasena = cuerpoMensajeHtmlRecuperacionContrasena;
    }*/
}
