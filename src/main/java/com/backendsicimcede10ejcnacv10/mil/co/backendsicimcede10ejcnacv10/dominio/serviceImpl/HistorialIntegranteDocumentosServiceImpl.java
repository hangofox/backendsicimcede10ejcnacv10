//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialIntegranteDocumentosDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialIntegranteDocumentosService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialIntegranteDocumentosDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialIntegranteDocumentos;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialIntegranteDocumentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialIntegranteDocumentosServiceImpl implements HistorialIntegranteDocumentosService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialIntegranteDocumentosDAO historialIntegranteDocumentosDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialIntegranteDocumentosRepository historialIntegranteDocumentosRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialIntegranteDocumentos, String keyword) {
        return historialIntegranteDocumentosRepository.findTotalRegistros(idHistorialIntegranteDocumentos, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialIntegranteDocumentosDTO> listarHistorialesIntegrantesDocumentos(Long idHistorialIntegranteDocumentos, String keyword, String orderBy, String orderMode) {
        List<HistorialIntegranteDocumentos> historialesIntegrantesDocumentos = historialIntegranteDocumentosRepository.findAllHistorialesIntegrantesDocumentos(idHistorialIntegranteDocumentos, keyword, orderBy, orderMode);
        List<HistorialIntegranteDocumentosDTO> historialIntegranteDocumentosDTOS = new ArrayList<>();
        for (HistorialIntegranteDocumentos historialIntegranteDocumentos : historialesIntegrantesDocumentos) {
            historialIntegranteDocumentosDTOS.add(historialIntegranteDocumentosDAO.historialIntegranteDocumentosDTO(historialIntegranteDocumentos));
        }
        
        return historialIntegranteDocumentosDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialIntegranteDocumentosDTO> listarHistorialesIntegrantesDocumentosPag(Pageable pageable, Long idHistorialIntegranteDocumentos, String keyword, String orderBy, String orderMode) {
        Slice<HistorialIntegranteDocumentos> historialesIntegrantesDocumentos = historialIntegranteDocumentosRepository.findAllHistorialesIntegrantesDocumentosPag(pageable, idHistorialIntegranteDocumentos, keyword, orderBy, orderMode);
        return historialesIntegrantesDocumentos.map(historialIntegranteDocumentos -> historialIntegranteDocumentosDAO.historialIntegranteDocumentosDTO(historialIntegranteDocumentos));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialIntegranteDocumentos(HistorialIntegranteDocumentosDTO historialIntegranteDocumentosDTO) {
        Long maxIdHistorialIntegranteDocumentos = null;
        HistorialIntegranteDocumentos historialIntegranteDocumentosNumeroDocumentoIdentificacion = historialIntegranteDocumentosRepository.findByNumeroDocumentoIdentificacionIntegranteDocumentos(historialIntegranteDocumentosDTO.getNumeroDocumentoIdentificacionIntegranteDocumentos());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
        
        if (!(historialIntegranteDocumentosNumeroDocumentoIdentificacion == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           banderaNumeroDocumentoIdentificacionRegistroEncontrado = 1;
        }
        
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 1) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
           respuestaDTO.setHistorialIntegranteDocumentosDTO(null);
        }
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO.
           maxIdHistorialIntegranteDocumentos = historialIntegranteDocumentosRepository.findMaxIdHistorialIntegranteDocumentos();
           if (maxIdHistorialIntegranteDocumentos == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdHistorialIntegranteDocumentos = Long.valueOf(0);
           }
           historialIntegranteDocumentosDTO.setIdHistorialIntegranteDocumentos(maxIdHistorialIntegranteDocumentos + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-INTEG-DOC" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-", LA SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR, LA CADENA "-" Y EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL INTEGRANTE:
           historialIntegranteDocumentosDTO.setNumRegHistorialIntegranteDocumentos("HIST-INTEG-DOC" + "-" + (maxIdHistorialIntegranteDocumentos + 1) + "-" + historialIntegranteDocumentosDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar() + "-" + historialIntegranteDocumentosDTO.getNumeroDocumentoIdentificacionIntegranteDocumentos());
           
           historialIntegranteDocumentosRepository.save(historialIntegranteDocumentosDAO.historialIntegranteDocumentos(historialIntegranteDocumentosDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialIntegranteDocumentosporId(Long idHistorialIntegranteDocumentos) {
        Optional<HistorialIntegranteDocumentos> historialIntegranteDocumentosId = historialIntegranteDocumentosRepository.findByIdHistorialIntegranteDocumentos(Long.valueOf(idHistorialIntegranteDocumentos));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialIntegranteDocumentosId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialIntegranteDocumentosDTO(historialIntegranteDocumentosDAO.historialIntegranteDocumentosDTO(historialIntegranteDocumentosId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialIntegranteDocumentosId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO.
    public RespuestaDTO consultarHistorialIntegranteDocumentosporNumReg(String numRegHistorialIntegranteDocumentos) {
        if (numRegHistorialIntegranteDocumentos == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteDocumentosDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialIntegranteDocumentos> historialIntegranteDocumentosNumReg = Optional.ofNullable(historialIntegranteDocumentosRepository.findByNumRegHistorialIntegranteDocumentos(numRegHistorialIntegranteDocumentos));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialIntegranteDocumentosNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialIntegranteDocumentosDTO(historialIntegranteDocumentosDAO.historialIntegranteDocumentosDTO(historialIntegranteDocumentosNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialIntegranteDocumentosNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialIntegranteDocumentos(HistorialIntegranteDocumentosDTO historialIntegranteDocumentosDTO) {
        Optional<HistorialIntegranteDocumentos> historialIntegranteDocumentosId = historialIntegranteDocumentosRepository.findByIdHistorialIntegranteDocumentos(historialIntegranteDocumentosDTO.getIdHistorialIntegranteDocumentos());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialIntegranteDocumentosId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (historialIntegranteDocumentosDTO.getNumeroDocumentoIdentificacionIntegranteDocumentos().equals(historialIntegranteDocumentosId.get().getNumeroDocumentoIdentificacionIntegranteDocumentos())==true) ) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES IGUAL AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              HistorialIntegranteDocumentos historialIntegranteDocumentos = historialIntegranteDocumentosDAO.historialIntegranteDocumentos(historialIntegranteDocumentosDTO);
              historialIntegranteDocumentosRepository.save(historialIntegranteDocumentos);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (historialIntegranteDocumentosDTO.getNumeroDocumentoIdentificacionIntegranteDocumentos().equals(historialIntegranteDocumentosId.get().getNumeroDocumentoIdentificacionIntegranteDocumentos())==false) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES DIFERENTE AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO EXISTE EN OTROS REGISTROS.
              HistorialIntegranteDocumentos historialIntegranteDocumentosNumeroDocumentoIdentificacion = historialIntegranteDocumentosRepository.findByNumeroDocumentoIdentificacionIntegranteDocumentos(historialIntegranteDocumentosDTO.getNumeroDocumentoIdentificacionIntegranteDocumentos());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
              
              if (!(historialIntegranteDocumentosNumeroDocumentoIdentificacion == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
                 banderaNumeroDocumentoIdentificacionRegistroEncontrado=1;
              }
              
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
                 respuestaDTO.setHistorialIntegranteDocumentosDTO(null);
              }
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 historialIntegranteDocumentosRepository.save(historialIntegranteDocumentosDAO.historialIntegranteDocumentos(historialIntegranteDocumentosDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (historialIntegranteDocumentosId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialIntegranteDocumentos(Long idHistorialIntegranteDocumentos) {
        Optional<HistorialIntegranteDocumentos> historialIntegranteDocumentosId = historialIntegranteDocumentosRepository.findById(idHistorialIntegranteDocumentos);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialIntegranteDocumentosId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialIntegranteDocumentosRepository.delete(historialIntegranteDocumentosId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialIntegranteDocumentosId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
}
