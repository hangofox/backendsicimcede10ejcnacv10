//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ResponsableDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ResponsableService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ResponsableDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Responsable;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ResponsableServiceImpl implements ResponsableService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ResponsableDAO responsableDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ResponsableRepository responsableRepository;
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR SIGLA/ESTADO/KEYWORD/ID DE RESPONSABLE):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idResponsable, String siglaoAcronimoUnidadMilitar, String estadoResponsable, String keyword) {
        return responsableRepository.findTotalRegistros(idResponsable, siglaoAcronimoUnidadMilitar, estadoResponsable, keyword);
    }
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR SIGLA/ESTADO/KEYWORD/ID DE RESPONSABLE):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ResponsableDTO> listarResponsables(Long idResponsable, String siglaoAcronimoUnidadMilitar, String estadoResponsable, String keyword, String orderBy, String orderMode) {
        List<Responsable> responsables = responsableRepository.findAllResponsables(idResponsable, siglaoAcronimoUnidadMilitar, estadoResponsable, keyword, orderBy, orderMode);
        List<ResponsableDTO> responsableDTOS = new ArrayList<>();
        
        for (Responsable responsable : responsables) {
            responsableDTOS.add(responsableDAO.responsableDTO(responsable));
        }
        
        return responsableDTOS;
    }
    
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR SIGLA/ESTADO/KEYWORD/ID DE RESPONSABLE):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ResponsableDTO> listarResponsablesPag(Pageable pageable, Long idResponsable, String siglaoAcronimoUnidadMilitar, String estadoResponsable, String keyword, String orderBy, String orderMode) {
        Slice<Responsable> responsables = responsableRepository.findAllResponsablesPag(pageable, idResponsable, siglaoAcronimoUnidadMilitar, estadoResponsable, keyword, orderBy, orderMode);
        return responsables.map(responsable -> responsableDAO.responsableDTO(responsable));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearResponsable(ResponsableDTO responsableDTO) {
        Long maxIdResponsable = null;
        Responsable responsableNumeroDocumentoIdentificacion = responsableRepository.findByNumeroDocumentoIdentificacionResponsable(responsableDTO.getNumeroDocumentoIdentificacionResponsable());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroDocumentoIdentificacionRegistroEncontrado=0;
        
        if (!(responsableNumeroDocumentoIdentificacion==null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           banderaNumeroDocumentoIdentificacionRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
           respuestaDTO.setResponsableDTO(null);
        }
        if ((banderaNumeroDocumentoIdentificacionRegistroEncontrado==0)) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           maxIdResponsable = responsableRepository.findMaxIdResponsable();
           if (maxIdResponsable==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdResponsable=Long.valueOf(0);
           }
           responsableDTO.setIdResponsable(maxIdResponsable+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           responsableRepository.save(responsableDAO.responsable(responsableDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarResponsableporId(Long idResponsable) {
        Optional<Responsable> responsableId = responsableRepository.findByIdResponsable(Long.valueOf(idResponsable));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        if (responsableId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setResponsableDTO(responsableDAO.responsableDTO(responsableId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (responsableId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setResponsableDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarResponsableporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionResponsable) {
        Optional<Responsable> responsableNumeroDocumentoIdentificacion = Optional.ofNullable(responsableRepository.findByNumeroDocumentoIdentificacionResponsable(numeroDocumentoIdentificacionResponsable));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
        
        if (responsableNumeroDocumentoIdentificacion.isPresent()==true) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO.setResponsableDTO(responsableDAO.responsableDTO(responsableNumeroDocumentoIdentificacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (responsableNumeroDocumentoIdentificacion.isPresent()==false) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_NO_ENCONTRADO, false);
           respuestaDTO.setResponsableDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarResponsable(ResponsableDTO responsableDTO) {
        Optional<Responsable> responsableId = responsableRepository.findByIdResponsable(responsableDTO.getIdResponsable());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (responsableId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (responsableDTO.getNumeroDocumentoIdentificacionResponsable().equals(responsableId.get().getNumeroDocumentoIdentificacionResponsable())==true) ) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES IGUAL AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              Responsable responsable = responsableDAO.responsable(responsableDTO);
              responsableRepository.save(responsable);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (responsableDTO.getNumeroDocumentoIdentificacionResponsable().equals(responsableId.get().getNumeroDocumentoIdentificacionResponsable())==false) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NICKNAME DIGITADO ES DIFERENTE AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NICKNAME ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN O NICKNAME DIGITADO EXISTE EN OTROS REGISTROS.
              Responsable responsableNumeroDocumentoIdentificacion = responsableRepository.findByNumeroDocumentoIdentificacionResponsable(responsableDTO.getNumeroDocumentoIdentificacionResponsable());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroDocumentoIdentificacionRegistroEncontrado=0;
              
              if (!(responsableNumeroDocumentoIdentificacion==null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
                 banderaNumeroDocumentoIdentificacionRegistroEncontrado=1;
              }
              
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
                 respuestaDTO.setResponsableDTO(null);
              }
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 Responsable responsable = responsableDAO.responsable(responsableDTO);
                 responsableRepository.save(responsable);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (responsableId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setResponsableDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarResponsable(Long idResponsable) {
        Optional<Responsable> responsableId = responsableRepository.findById(idResponsable);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (responsableId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setResponsableDTO(responsableDAO.responsableDTO(responsableId.get()));
            responsableRepository.delete(responsableId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (responsableId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setResponsableDTO(null);
        }
        
        return respuestaDTO;
    }
}
