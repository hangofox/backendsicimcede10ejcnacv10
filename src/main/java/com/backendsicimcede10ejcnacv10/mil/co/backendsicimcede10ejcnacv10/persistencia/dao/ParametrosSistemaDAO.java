//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ParametrosSistemaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ParametrosSistema;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/07/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class ParametrosSistemaDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/07/2026.
    * @param parametrosSistemaDTO
    * Recibe un DTO para crear un objeto parametrosSistema.
    * @return parametrosSistema
    */
    public ParametrosSistema parametrosSistema(ParametrosSistemaDTO parametrosSistemaDTO){
        ParametrosSistema parametrosSistema = new ParametrosSistema();
        parametrosSistema.setIdParametrosSistema(parametrosSistemaDTO.getIdParametrosSistema());
        parametrosSistema.setTiempoMinutosSesionInactivaSistema(parametrosSistemaDTO.getTiempoMinutosSesionInactivaSistema());
        parametrosSistema.setTiempoMinutosValidezCodigoActivacionContrasena(parametrosSistemaDTO.getTiempoMinutosValidezCodigoActivacionContrasena());
        parametrosSistema.setRutaDestinoCarpetaPrincipalServidorAplicaciones(parametrosSistemaDTO.getRutaDestinoCarpetaPrincipalServidorAplicaciones());
        parametrosSistema.setRutaDestinoCarpetaCargueTemporalArchivos(parametrosSistemaDTO.getRutaDestinoCarpetaCargueTemporalArchivos());
        parametrosSistema.setRutaDestinoArchivosUsuarios(parametrosSistemaDTO.getRutaDestinoArchivosUsuarios());
        parametrosSistema.setRutaDestinoArchivosUnidadesMilitares(parametrosSistemaDTO.getRutaDestinoArchivosUnidadesMilitares());
        parametrosSistema.setRutaDestinoArchivosIntegrantesDocumentos(parametrosSistemaDTO.getRutaDestinoArchivosIntegrantesDocumentos());
        parametrosSistema.setRutaDestinoArchivosConceptosTecnicos(parametrosSistemaDTO.getRutaDestinoArchivosConceptosTecnicos());
        parametrosSistema.setRutaDestinoArchivosActasReintegros(parametrosSistemaDTO.getRutaDestinoArchivosActasReintegros());
        parametrosSistema.setRutaDestinoArchivosResolucionesBajas(parametrosSistemaDTO.getRutaDestinoArchivosResolucionesBajas());
        parametrosSistema.setAuthEnable(parametrosSistemaDTO.getAuthEnable());
        parametrosSistema.setStartTTLSEnable(parametrosSistemaDTO.getStartTTLSEnable());
        parametrosSistema.setSmtpHost(parametrosSistemaDTO.getSmtpHost());
        parametrosSistema.setSmtpPort(parametrosSistemaDTO.getSmtpPort());
        parametrosSistema.setSmtpProtocols(parametrosSistemaDTO.getSmtpProtocols());
        parametrosSistema.setUsuarioRemitente(parametrosSistemaDTO.getUsuarioRemitente());
        parametrosSistema.setPasswordRemitente(parametrosSistemaDTO.getPasswordRemitente());
        parametrosSistema.setCorreoElectronicoRemitente(parametrosSistemaDTO.getCorreoElectronicoRemitente());
        parametrosSistema.setAsuntoDestinatarioRecuperacionContrasena(parametrosSistemaDTO.getAsuntoDestinatarioRecuperacionContrasena());
        parametrosSistema.setCuerpoMensajeHtmlRecuperacionContrasena(parametrosSistemaDTO.getCuerpoMensajeHtmlRecuperacionContrasena());
        
        return parametrosSistema;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 30/07/2026.
    * @param parametrosSistema
    * Recibe un objeto parametrosSistema para crear un DTO.
    * @return parametrosSistemaDTO
    */
    public ParametrosSistemaDTO parametrosSistemaDTO(ParametrosSistema parametrosSistema){
        ParametrosSistemaDTO parametrosSistemaDTO = new ParametrosSistemaDTO();
        parametrosSistemaDTO.setIdParametrosSistema(parametrosSistema.getIdParametrosSistema());
        parametrosSistemaDTO.setTiempoMinutosSesionInactivaSistema(parametrosSistema.getTiempoMinutosSesionInactivaSistema());
        parametrosSistemaDTO.setTiempoMinutosValidezCodigoActivacionContrasena(parametrosSistema.getTiempoMinutosValidezCodigoActivacionContrasena());
        parametrosSistemaDTO.setRutaDestinoCarpetaPrincipalServidorAplicaciones(parametrosSistema.getRutaDestinoCarpetaPrincipalServidorAplicaciones());
        parametrosSistemaDTO.setRutaDestinoCarpetaCargueTemporalArchivos(parametrosSistema.getRutaDestinoCarpetaCargueTemporalArchivos());
        parametrosSistemaDTO.setRutaDestinoArchivosUsuarios(parametrosSistema.getRutaDestinoArchivosUsuarios());
        parametrosSistemaDTO.setRutaDestinoArchivosUnidadesMilitares(parametrosSistema.getRutaDestinoArchivosUnidadesMilitares());
        parametrosSistemaDTO.setRutaDestinoArchivosIntegrantesDocumentos(parametrosSistema.getRutaDestinoArchivosIntegrantesDocumentos());
        parametrosSistemaDTO.setRutaDestinoArchivosConceptosTecnicos(parametrosSistema.getRutaDestinoArchivosConceptosTecnicos());
        parametrosSistemaDTO.setRutaDestinoArchivosActasReintegros(parametrosSistema.getRutaDestinoArchivosActasReintegros());
        parametrosSistemaDTO.setRutaDestinoArchivosResolucionesBajas(parametrosSistema.getRutaDestinoArchivosResolucionesBajas());
        parametrosSistemaDTO.setAuthEnable(parametrosSistema.getAuthEnable());
        parametrosSistemaDTO.setStartTTLSEnable(parametrosSistema.getStartTTLSEnable());
        parametrosSistemaDTO.setSmtpHost(parametrosSistema.getSmtpHost());
        parametrosSistemaDTO.setSmtpPort(parametrosSistema.getSmtpPort());
        parametrosSistemaDTO.setSmtpProtocols(parametrosSistema.getSmtpProtocols());
        parametrosSistemaDTO.setUsuarioRemitente(parametrosSistema.getUsuarioRemitente());
        parametrosSistemaDTO.setPasswordRemitente(parametrosSistema.getPasswordRemitente());
        parametrosSistemaDTO.setCorreoElectronicoRemitente(parametrosSistema.getCorreoElectronicoRemitente());
        parametrosSistemaDTO.setAsuntoDestinatarioRecuperacionContrasena(parametrosSistema.getAsuntoDestinatarioRecuperacionContrasena());
        parametrosSistemaDTO.setCuerpoMensajeHtmlRecuperacionContrasena(parametrosSistema.getCuerpoMensajeHtmlRecuperacionContrasena());
        
        return parametrosSistemaDTO;
    }
}
