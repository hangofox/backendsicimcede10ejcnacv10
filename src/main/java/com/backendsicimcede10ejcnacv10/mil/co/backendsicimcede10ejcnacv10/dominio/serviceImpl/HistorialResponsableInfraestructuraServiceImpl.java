//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialResponsableInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialResponsableInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialResponsableInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialResponsableInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialResponsableInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialResponsableInfraestructuraServiceImpl implements HistorialResponsableInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialResponsableInfraestructuraDAO historialResponsableInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialResponsableInfraestructuraRepository historialResponsableInfraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialResponsableInfraestructura, String keyword) {
        return historialResponsableInfraestructuraRepository.findTotalRegistros(idHistorialResponsableInfraestructura, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialResponsableInfraestructuraDTO> listarHistorialesResponsablesInfraestructuras(Long idHistorialResponsableInfraestructura, String keyword, String orderBy, String orderMode) {
        List<HistorialResponsableInfraestructura> historialesResponsablesInfraestructuras = historialResponsableInfraestructuraRepository.findAllHistorialesResponsablesInfraestructuras(idHistorialResponsableInfraestructura, keyword, orderBy, orderMode);
        List<HistorialResponsableInfraestructuraDTO> historialResponsableInfraestructuraDTOS = new ArrayList<>();
        for (HistorialResponsableInfraestructura historialResponsableInfraestructura : historialesResponsablesInfraestructuras) {
            historialResponsableInfraestructuraDTOS.add(historialResponsableInfraestructuraDAO.historialResponsableInfraestructuraDTO(historialResponsableInfraestructura));
        }
        
        return historialResponsableInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialResponsableInfraestructuraDTO> listarHistorialesResponsablesInfraestructurasPag(Pageable pageable, Long idHistorialResponsableInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<HistorialResponsableInfraestructura> historialesResponsablesInfraestructuras = historialResponsableInfraestructuraRepository.findAllHistorialesResponsablesInfraestructurasPag(pageable, idHistorialResponsableInfraestructura, keyword, orderBy, orderMode);
        return historialesResponsablesInfraestructuras.map(historialResponsableInfraestructura -> historialResponsableInfraestructuraDAO.historialResponsableInfraestructuraDTO(historialResponsableInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialResponsableInfraestructura(HistorialResponsableInfraestructuraDTO historialResponsableInfraestructuraDTO) {
        Long maxIdHistorialResponsableInfraestructura = null;
        HistorialResponsableInfraestructura historialResponsableInfraestructuraNumeroDocumentoIdentificacion = historialResponsableInfraestructuraRepository.findByNumeroDocumentoIdentificacionResponsableAndSiglaOAcronimoUnidadMilitar(historialResponsableInfraestructuraDTO.getNumeroDocumentoIdentificacionResponsable(), historialResponsableInfraestructuraDTO.getSiglaOAcronimoUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroDocumentoIdentificacionRegistroEncontrado=0;
        
        if (!(historialResponsableInfraestructuraNumeroDocumentoIdentificacion==null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO Y ASOCIADO CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
           banderaNumeroDocumentoIdentificacionRegistroEncontrado=1;
        }
        
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO Y ASOCIADO CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_O_NIC_EN_UNIDAD_MILITAR_YA_EXISTE, false);
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(null);
        }
        if ((banderaNumeroDocumentoIdentificacionRegistroEncontrado==0)) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
           maxIdHistorialResponsableInfraestructura = historialResponsableInfraestructuraRepository.findMaxIdHistorialResponsableInfraestructura();
           if (maxIdHistorialResponsableInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialResponsableInfraestructura = Long.valueOf(0);
           }
           historialResponsableInfraestructuraDTO.setIdHistorialResponsableInfraestructura(maxIdHistorialResponsableInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-RESP-INF" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-", LA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR, LA CADENA "-" Y EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL RESPONSABLE:
           historialResponsableInfraestructuraDTO.setNumRegHistorialResponsableInfraestructura("HIST-RESP-INF" + "-" + (maxIdHistorialResponsableInfraestructura + 1) + "-" + historialResponsableInfraestructuraDTO.getSiglaOAcronimoUnidadMilitar() + "-" + historialResponsableInfraestructuraDTO.getNumeroDocumentoIdentificacionResponsable());
           
           historialResponsableInfraestructuraRepository.save(historialResponsableInfraestructuraDAO.historialResponsableInfraestructura(historialResponsableInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialResponsableInfraestructuraporId(Long idHistorialResponsableInfraestructura) {
        Optional<HistorialResponsableInfraestructura> historialResponsableInfraestructuraId = historialResponsableInfraestructuraRepository.findByIdHistorialResponsableInfraestructura(Long.valueOf(idHistorialResponsableInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialResponsableInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(historialResponsableInfraestructuraDAO.historialResponsableInfraestructuraDTO(historialResponsableInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialResponsableInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialResponsableInfraestructuraporNumReg(String numRegHistorialResponsableInfraestructura) {
        if (numRegHistorialResponsableInfraestructura == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialResponsableInfraestructura> historialResponsableInfraestructuraNumReg = Optional.ofNullable(historialResponsableInfraestructuraRepository.findByNumRegHistorialResponsableInfraestructura(numRegHistorialResponsableInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialResponsableInfraestructuraNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(historialResponsableInfraestructuraDAO.historialResponsableInfraestructuraDTO(historialResponsableInfraestructuraNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialResponsableInfraestructuraNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialResponsableInfraestructura(HistorialResponsableInfraestructuraDTO historialResponsableInfraestructuraDTO) {
        Optional<HistorialResponsableInfraestructura> historialResponsableInfraestructuraId = historialResponsableInfraestructuraRepository.findByIdHistorialResponsableInfraestructura(historialResponsableInfraestructuraDTO.getIdHistorialResponsableInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialResponsableInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (historialResponsableInfraestructuraDTO.getNumeroDocumentoIdentificacionResponsable().equals(historialResponsableInfraestructuraId.get().getNumeroDocumentoIdentificacionResponsable())==true) ) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO ES IGUAL AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              HistorialResponsableInfraestructura historialResponsableInfraestructura = historialResponsableInfraestructuraDAO.historialResponsableInfraestructura(historialResponsableInfraestructuraDTO);
              historialResponsableInfraestructuraRepository.save(historialResponsableInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (historialResponsableInfraestructuraDTO.getNumeroDocumentoIdentificacionResponsable().equals(historialResponsableInfraestructuraId.get().getNumeroDocumentoIdentificacionResponsable())==false) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO ES DIFERENTE AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO EXISTE EN OTROS REGISTROS.
              HistorialResponsableInfraestructura historialResponsableInfraestructuraNumeroDocumentoIdentificacionySAUnidadMilitar = historialResponsableInfraestructuraRepository.findByNumeroDocumentoIdentificacionResponsableAndSiglaOAcronimoUnidadMilitar(historialResponsableInfraestructuraDTO.getNumeroDocumentoIdentificacionResponsable(), historialResponsableInfraestructuraDTO.getSiglaOAcronimoUnidadMilitar());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
              
              if (!(historialResponsableInfraestructuraNumeroDocumentoIdentificacionySAUnidadMilitar == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC PROPORCIONADO.
                 banderaNumeroDocumentoIdentificacionRegistroEncontrado = 1;
              }
              
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR ALMACENADOS EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL Y MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_O_NIC_EN_UNIDAD_MILITAR_YA_EXISTE, false);
                 respuestaDTO.setHistorialResponsableInfraestructuraDTO(null);
              }
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NIC DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA CON LA MISMA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 historialResponsableInfraestructuraRepository.save(historialResponsableInfraestructuraDAO.historialResponsableInfraestructura(historialResponsableInfraestructuraDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (historialResponsableInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialResponsableInfraestructura(Long idHistorialResponsableInfraestructura) {
        Optional<HistorialResponsableInfraestructura> historialResponsableInfraestructuraId = historialResponsableInfraestructuraRepository.findById(idHistorialResponsableInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialResponsableInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(historialResponsableInfraestructuraDAO.historialResponsableInfraestructuraDTO(historialResponsableInfraestructuraId.get()));
           historialResponsableInfraestructuraRepository.delete(historialResponsableInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialResponsableInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialResponsableInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
