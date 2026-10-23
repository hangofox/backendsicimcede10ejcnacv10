//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.EstadosSolicitudesInfraestructurasConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialIntegranteSolicitudInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialIntegranteSolicitudInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialIntegranteSolicitudInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialIntegranteSolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SolicitudInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialIntegranteSolicitudInfraestructuraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.LineaMandoUnidadMilitarRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SolicitudInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialIntegranteSolicitudInfraestructuraServiceImpl implements HistorialIntegranteSolicitudInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialIntegranteSolicitudInfraestructuraDAO historialIntegranteSolicitudInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialIntegranteSolicitudInfraestructuraRepository historialIntegranteSolicitudInfraestructuraRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SolicitudInfraestructuraRepository solicitudInfraestructuraRepository;

    @Autowired//INYECTAMOS EL REPOSITORIO.
    private LineaMandoUnidadMilitarRepository lineaMandoUnidadMilitarRepository;

    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialIntegranteSolicitudInfraestructura, Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar) {
        return historialIntegranteSolicitudInfraestructuraRepository.findTotalRegistros(idHistorialIntegranteSolicitudInfraestructura, idSolicitudInfraestructura, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialIntegranteSolicitudInfraestructuraDTO> listarHistorialesIntegrantesSolicitudesInfraestructuras(Long idHistorialIntegranteSolicitudInfraestructura, Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<HistorialIntegranteSolicitudInfraestructura> historialesIntegrantesSolicitudesInfraestructuras = historialIntegranteSolicitudInfraestructuraRepository.findAllHistorialesIntegrantesSolicitudesInfraestructuras(idHistorialIntegranteSolicitudInfraestructura, idSolicitudInfraestructura, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<HistorialIntegranteSolicitudInfraestructuraDTO> historialIntegranteSolicitudInfraestructuraDTOS = new ArrayList<>();
        for (HistorialIntegranteSolicitudInfraestructura historialIntegranteSolicitudInfraestructura : historialesIntegrantesSolicitudesInfraestructuras) {
            historialIntegranteSolicitudInfraestructuraDTOS.add(historialIntegranteSolicitudInfraestructuraDAO.historialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructura));
        }
        
        return historialIntegranteSolicitudInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialIntegranteSolicitudInfraestructuraDTO> listarHistorialesIntegrantesSolicitudesInfraestructurasPag(Pageable pageable, Long idHistorialIntegranteSolicitudInfraestructura, Long idSolicitudInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<HistorialIntegranteSolicitudInfraestructura> historialesIntegrantesSolicitudesInfraestructuras = historialIntegranteSolicitudInfraestructuraRepository.findAllHistorialesIntegrantesSolicitudesInfraestructurasPag(pageable, idHistorialIntegranteSolicitudInfraestructura, idSolicitudInfraestructura, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return historialesIntegrantesSolicitudesInfraestructuras.map(historialIntegranteSolicitudInfraestructura -> historialIntegranteSolicitudInfraestructuraDAO.historialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialIntegranteSolicitudInfraestructura(HistorialIntegranteSolicitudInfraestructuraDTO historialIntegranteSolicitudInfraestructuraDTO) {
        Long maxIdHistorialIntegranteSolicitudInfraestructura = null;
        Long idSolicitudInfraestructura = historialIntegranteSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura();
        HistorialIntegranteSolicitudInfraestructura historialIntegranteSolicitudInfraestructuraCargo = historialIntegranteSolicitudInfraestructuraRepository.findBySolicitudInfraestructuraAndUnidadMilitarAndCargo(idSolicitudInfraestructura, historialIntegranteSolicitudInfraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar(), historialIntegranteSolicitudInfraestructuraDTO.getCargoIntegranteSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaCargoRegistroEncontrado=0;
        
        if (!(historialIntegranteSolicitudInfraestructuraCargo==null)) {//SI ENCONTRO EL MISMO CARGO DE LA MISMA UNIDAD MILITAR ASOCIADO A LA MISMA SOLICITUD DE INFRAESTRUCTURA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CARGO DE REGISTRO REPETIDO.
           banderaCargoRegistroEncontrado=1;
        }
        
        if (banderaCargoRegistroEncontrado==1) {//SI ENCONTRO EL MISMO CARGO DE LA MISMA UNIDAD MILITAR ASOCIADO A LA MISMA SOLICITUD DE INFRAESTRUCTURA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CARGO DE REGISTRO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CARGO_YA_EXISTE_EN_SOLICITUD_INFRAESTRUCTURA, false);
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(null);
        }
        if ((banderaCargoRegistroEncontrado==0)) {//SI NO ENCONTRO EL MISMO CARGO EN LA MISMA SOLICITUD DE INFRAESTRUCTURA EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialIntegranteSolicitudInfraestructura = historialIntegranteSolicitudInfraestructuraRepository.findMaxIdHistorialIntegranteSolicitudInfraestructura();
           if (maxIdHistorialIntegranteSolicitudInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialIntegranteSolicitudInfraestructura = Long.valueOf(0);
           }
           
           historialIntegranteSolicitudInfraestructuraDTO.setIdHistorialIntegranteSolicitudInfraestructura(maxIdHistorialIntegranteSolicitudInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //SE CONSULTA LA SOLICITUD DE INFRAESTRUCTURA PARA OBTENER SU CÓDIGO DE RADICADO:
           SolicitudInfraestructura solicitudInfraestructura = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(idSolicitudInfraestructura).get();
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-INTEG-SOLIC-INF" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y EL CÓDIGO DE RADICADO DE LA SOLICITUD DE INFRAESTRUCTURA:
           historialIntegranteSolicitudInfraestructuraDTO.setNumRegHistorialIntegranteSolicitudInfraestructura("HIST-INTEG-SOLIC-INF" + "-" + (maxIdHistorialIntegranteSolicitudInfraestructura + 1) + "-" + solicitudInfraestructura.getCodigoRadicadoSolicitudInfraestructura());
           
           historialIntegranteSolicitudInfraestructuraRepository.save(historialIntegranteSolicitudInfraestructuraDAO.historialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO));
           actualizarEstadoSolicitudInfraestructura(idSolicitudInfraestructura);//EL NUEVO INTEGRANTE PUEDE HACER AVANZAR EL ESTADO DE LA SOLICITUD.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialIntegranteSolicitudInfraestructuraporId(Long idHistorialIntegranteSolicitudInfraestructura) {
        Optional<HistorialIntegranteSolicitudInfraestructura> historialIntegranteSolicitudInfraestructuraId = historialIntegranteSolicitudInfraestructuraRepository.findByIdHistorialIntegranteSolicitudInfraestructura(Long.valueOf(idHistorialIntegranteSolicitudInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialIntegranteSolicitudInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructuraDAO.historialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialIntegranteSolicitudInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialIntegranteSolicitudInfraestructuraporNumReg(String numRegHistorialIntegranteSolicitudInfraestructura) {
        if (numRegHistorialIntegranteSolicitudInfraestructura == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialIntegranteSolicitudInfraestructura> historialIntegranteSolicitudInfraestructuraNumReg = Optional.ofNullable(historialIntegranteSolicitudInfraestructuraRepository.findByNumRegHistorialIntegranteSolicitudInfraestructura(numRegHistorialIntegranteSolicitudInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialIntegranteSolicitudInfraestructuraNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructuraDAO.historialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructuraNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialIntegranteSolicitudInfraestructuraNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialIntegranteSolicitudInfraestructura(HistorialIntegranteSolicitudInfraestructuraDTO historialIntegranteSolicitudInfraestructuraDTO) {
        Optional<HistorialIntegranteSolicitudInfraestructura> historialIntegranteSolicitudInfraestructuraId = historialIntegranteSolicitudInfraestructuraRepository.findByIdHistorialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getIdHistorialIntegranteSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialIntegranteSolicitudInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA QUE EL CARGO NO ESTE REPETIDO EN OTRO REGISTRO DE LA MISMA SOLICITUD DE INFRAESTRUCTURA.
           HistorialIntegranteSolicitudInfraestructura historialIntegranteSolicitudInfraestructuraCargo = historialIntegranteSolicitudInfraestructuraRepository.findBySolicitudInfraestructuraAndUnidadMilitarAndCargo(historialIntegranteSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura(), historialIntegranteSolicitudInfraestructuraDTO.getUnidadMilitarDTO().getIdUnidadMilitar(), historialIntegranteSolicitudInfraestructuraDTO.getCargoIntegranteSolicitudInfraestructura());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaCargoRegistroEncontrado = 0;
           
           //NOTA: SE IGNORA EL PROPIO REGISTRO QUE SE ESTÁ MODIFICANDO, ASÍ SE PUEDE GUARDAR SIN CAMBIAR EL CARGO.
           if ( (!(historialIntegranteSolicitudInfraestructuraCargo == null))&&(!(historialIntegranteSolicitudInfraestructuraCargo.getIdHistorialIntegranteSolicitudInfraestructura().equals(historialIntegranteSolicitudInfraestructuraId.get().getIdHistorialIntegranteSolicitudInfraestructura()))) ) {//SI ENCONTRO EL MISMO CARGO DE LA MISMA UNIDAD MILITAR EN OTRO REGISTRO DE LA MISMA SOLICITUD DE INFRAESTRUCTURA MUESTRA UN MENSAJE DE CARGO DE REGISTRO REPETIDO.
              banderaCargoRegistroEncontrado = 1;
           }
           
           if (banderaCargoRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL CARGO YA ESTÁ ALMACENADO EN OTRO REGISTRO DE LA MISMA SOLICITUD DE INFRAESTRUCTURA MUESTRA UN MENSAJE DE CARGO DEL REGISTRO REPETIDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CARGO_YA_EXISTE_EN_SOLICITUD_INFRAESTRUCTURA, false);
              respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(null);
           }
           if (banderaCargoRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL CARGO NO EXISTE EN OTRO REGISTRO DE LA MISMA SOLICITUD DE INFRAESTRUCTURA SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              //SE CONSERVA EL NÚMERO DE REGISTRO ALMACENADO (CAMPO ÚNICO GENERADO AUTOMÁTICAMENTE AL CREAR EL REGISTRO):
              historialIntegranteSolicitudInfraestructuraDTO.setNumRegHistorialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraId.get().getNumRegHistorialIntegranteSolicitudInfraestructura());
              Long idSolicitudInfraestructuraAnterior = historialIntegranteSolicitudInfraestructuraId.get().getSolicitudInfraestructura() == null ? null : historialIntegranteSolicitudInfraestructuraId.get().getSolicitudInfraestructura().getIdSolicitudInfraestructura();
              historialIntegranteSolicitudInfraestructuraRepository.save(historialIntegranteSolicitudInfraestructuraDAO.historialIntegranteSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO));
              //AL CAMBIAR LA UNIDAD MILITAR DEL INTEGRANTE PUEDE CAMBIAR EL ESTADO DE LA SOLICITUD (Y DE LA ANTERIOR, SI SE MOVIÓ DE SOLICITUD):
              actualizarEstadoSolicitudInfraestructura(historialIntegranteSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
              if (idSolicitudInfraestructuraAnterior != null && !idSolicitudInfraestructuraAnterior.equals(historialIntegranteSolicitudInfraestructuraDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura())) {
                 actualizarEstadoSolicitudInfraestructura(idSolicitudInfraestructuraAnterior);
              }
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (historialIntegranteSolicitudInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialIntegranteSolicitudInfraestructura(Long idHistorialIntegranteSolicitudInfraestructura) {
        Optional<HistorialIntegranteSolicitudInfraestructura> historialIntegranteSolicitudInfraestructuraId = historialIntegranteSolicitudInfraestructuraRepository.findById(idHistorialIntegranteSolicitudInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialIntegranteSolicitudInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructuraDAO.historialIntegranteSolicitudInfraestructuraDTO(historialIntegranteSolicitudInfraestructuraId.get()));
           Long idSolicitudInfraestructura = historialIntegranteSolicitudInfraestructuraId.get().getSolicitudInfraestructura() == null ? null : historialIntegranteSolicitudInfraestructuraId.get().getSolicitudInfraestructura().getIdSolicitudInfraestructura();
           historialIntegranteSolicitudInfraestructuraRepository.delete(historialIntegranteSolicitudInfraestructuraId.get());
           actualizarEstadoSolicitudInfraestructura(idSolicitudInfraestructura);//SIN ESE INTEGRANTE EL ESTADO DE LA SOLICITUD PUEDE RETROCEDER.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialIntegranteSolicitudInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteSolicitudInfraestructuraDTO(null);
        }

        return respuestaDTO;
    }

    //RECALCULA AUTOMÁTICAMENTE EL ESTADO DE LA SOLICITUD DE INFRAESTRUCTURA SEGÚN EL PASO MÁS AVANZADO DE LA LÍNEA DE MANDO DE SU UNIDAD
    //MILITAR QUE YA TIENE INTEGRANTES REGISTRADOS EN EL HISTORIAL: 1.º PASO (O NINGUNO) = CREACION, 2.º = VERIFICACION, 3.º = VALIDACION
    //Y 4.º EN ADELANTE = ASIGNACION (NUNCA PASA SOLO A APROBACION). SI LA SOLICITUD YA ESTÁ EN "APROBACION" O "RECHAZADO", QUE SON
    //ESTADOS QUE SE ASIGNAN MANUALMENTE, NO SE MODIFICA:
    private void actualizarEstadoSolicitudInfraestructura(Long idSolicitudInfraestructura) {
        if (idSolicitudInfraestructura == null) {
           return;
        }
        Optional<SolicitudInfraestructura> solicitudInfraestructuraId = solicitudInfraestructuraRepository.findByIdSolicitudInfraestructura(idSolicitudInfraestructura);
        if (solicitudInfraestructuraId.isPresent() == false) {
           return;
        }
        SolicitudInfraestructura solicitudInfraestructura = solicitudInfraestructuraId.get();
        String estadoActual = solicitudInfraestructura.getEstadoSolicitudInfraestructura();
        if (EstadosSolicitudesInfraestructurasConstantes.ESTADO_APROBACION.equals(estadoActual) || EstadosSolicitudesInfraestructurasConstantes.ESTADO_RECHAZADO.equals(estadoActual)) {
           return;
        }

        //SIGLAS O ACRÓNIMOS (EN MAYÚSCULA) DE LAS UNIDADES MILITARES QUE YA TIENEN INTEGRANTES REGISTRADOS EN EL HISTORIAL DE LA SOLICITUD:
        Set<String> siglasoAcronimosConIntegrantes = new HashSet<>();
        for (HistorialIntegranteSolicitudInfraestructura historialIntegranteSolicitudInfraestructura : historialIntegranteSolicitudInfraestructuraRepository.findAllHistorialesIntegrantesSolicitudesInfraestructuras(null, idSolicitudInfraestructura, null, null, null, null)) {
            if (historialIntegranteSolicitudInfraestructura.getUnidadMilitar() != null && historialIntegranteSolicitudInfraestructura.getUnidadMilitar().getSiglaoAcronimoUnidadMilitar() != null) {
               siglasoAcronimosConIntegrantes.add(historialIntegranteSolicitudInfraestructura.getUnidadMilitar().getSiglaoAcronimoUnidadMilitar().trim().toUpperCase());
            }
        }

        //SI LA UNIDAD MILITAR DE LA SOLICITUD NO TIENE LÍNEA DE MANDO REGISTRADA, SU ÚNICO PASO ES ELLA MISMA:
        String lineaMando = solicitudInfraestructura.getUnidadMilitar() == null ? "" : solicitudInfraestructura.getUnidadMilitar().getSiglaoAcronimoUnidadMilitar();
        if (solicitudInfraestructura.getUnidadMilitar() != null) {
           Optional<LineaMandoUnidadMilitar> lineaMandoUnidadMilitar = lineaMandoUnidadMilitarRepository.findByIdUnidadMilitar(solicitudInfraestructura.getUnidadMilitar().getIdUnidadMilitar());
           if (lineaMandoUnidadMilitar.isPresent() == true) {
              lineaMando = lineaMandoUnidadMilitar.get().getLineaMandoUnidadMilitar();
           }
        }

        int pasoMasAvanzado = obtenerPasoMasAvanzadoConIntegrantes(lineaMando, siglasoAcronimosConIntegrantes);
        String estadoNuevo = EstadosSolicitudesInfraestructurasConstantes.ESTADO_ASIGNACION;
        if (pasoMasAvanzado <= 0) {//NINGÚN PASO O SOLO EL 1.º (LA UNIDAD MILITAR QUE CREÓ LA SOLICITUD).
           estadoNuevo = EstadosSolicitudesInfraestructurasConstantes.ESTADO_CREACION;
        } else if (pasoMasAvanzado == 1) {//2.º PASO.
           estadoNuevo = EstadosSolicitudesInfraestructurasConstantes.ESTADO_VERIFICACION;
        } else if (pasoMasAvanzado == 2) {//3.º PASO.
           estadoNuevo = EstadosSolicitudesInfraestructurasConstantes.ESTADO_VALIDACION;
        }
        if (estadoNuevo.equals(estadoActual) == false) {
           solicitudInfraestructura.setEstadoSolicitudInfraestructura(estadoNuevo);
           solicitudInfraestructuraRepository.save(solicitudInfraestructura);
        }
    }

    //POSICIÓN (DESDE 0) DEL PASO MÁS AVANZADO DE LA LÍNEA DE MANDO CUYA UNIDAD MILITAR TIENE INTEGRANTES; -1 SI NINGUNO. LOS PASOS DE
    //CADA FINAL ALTERNATIVO ENTRE CORCHETES SE NUMERAN A CONTINUACIÓN DEL TRAMO COMÚN, EJ. EN "BAICC->BRICC->CAOCC->SECEJ->[JEMPP->CEDE10][CEDE10]"
    //SECEJ ES LA POSICIÓN 3 Y JEMPP Y EL CEDE10 DEL 2.º FINAL SON LA POSICIÓN 4:
    private int obtenerPasoMasAvanzadoConIntegrantes(String lineaMando, Set<String> siglasoAcronimosConIntegrantes) {
        String lineaMandoCompacta = String.valueOf(lineaMando == null ? "" : lineaMando).trim().replaceAll("\\s*(->|\\[|\\])\\s*", "$1").toUpperCase();
        int inicioFinalesAlternativos = lineaMandoCompacta.indexOf('[');
        String tramoComun = inicioFinalesAlternativos < 0 ? lineaMandoCompacta : lineaMandoCompacta.substring(0, inicioFinalesAlternativos);
        if (tramoComun.endsWith("->")) {
           tramoComun = tramoComun.substring(0, tramoComun.length() - 2);
        }
        String[] pasosTramoComun = tramoComun.isEmpty() ? new String[0] : tramoComun.split("->");
        int pasoMasAvanzado = -1;
        for (int posicion = 0; posicion < pasosTramoComun.length; posicion++) {
            if (siglasoAcronimosConIntegrantes.contains(pasosTramoComun[posicion].trim())) {
               pasoMasAvanzado = Math.max(pasoMasAvanzado, posicion);
            }
        }
        if (inicioFinalesAlternativos >= 0) {
           Matcher finalAlternativo = Pattern.compile("\\[([^\\[\\]]*)\\]").matcher(lineaMandoCompacta.substring(inicioFinalesAlternativos));
           while (finalAlternativo.find()) {
               String[] pasosFinal = finalAlternativo.group(1).split("->");
               for (int posicion = 0; posicion < pasosFinal.length; posicion++) {
                   if (siglasoAcronimosConIntegrantes.contains(pasosFinal[posicion].trim())) {
                      pasoMasAvanzado = Math.max(pasoMasAvanzado, pasosTramoComun.length + posicion);
                   }
               }
           }
        }
        return pasoMasAvanzado;
    }
}
