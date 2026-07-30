//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ContratoProyeccionSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ContratoProyeccionSeguroInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ContratoProyeccionSeguroInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ContratoProyeccionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ContratoProyeccionSeguroInfraestructuraRepository;
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
public class ContratoProyeccionSeguroInfraestructuraServiceImpl implements ContratoProyeccionSeguroInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ContratoProyeccionSeguroInfraestructuraDAO contratoProyeccionSeguroInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ContratoProyeccionSeguroInfraestructuraRepository contratoProyeccionSeguroInfraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idContratoProyeccionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura) {
        return contratoProyeccionSeguroInfraestructuraRepository.findTotalRegistros(idContratoProyeccionSeguroInfraestructura, keyword, idProyeccionSeguroInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ContratoProyeccionSeguroInfraestructuraDTO> listarContratosProyeccionesSegurosInfraestructuras(Long idContratoProyeccionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura, String orderBy, String orderMode) {
        List<ContratoProyeccionSeguroInfraestructura> contratosProyeccionesSegurosInfraestructuras = contratoProyeccionSeguroInfraestructuraRepository.findAllContratosProyeccionesSegurosInfraestructuras(idContratoProyeccionSeguroInfraestructura, keyword, idProyeccionSeguroInfraestructura, orderBy, orderMode);
        List<ContratoProyeccionSeguroInfraestructuraDTO> contratoProyeccionSeguroInfraestructuraDTOS = new ArrayList<>();
        for (ContratoProyeccionSeguroInfraestructura contratoProyeccionSeguroInfraestructura : contratosProyeccionesSegurosInfraestructuras) {
            contratoProyeccionSeguroInfraestructuraDTOS.add(contratoProyeccionSeguroInfraestructuraDAO.contratoProyeccionSeguroInfraestructuraDTO(contratoProyeccionSeguroInfraestructura));
        }
        
        return contratoProyeccionSeguroInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ContratoProyeccionSeguroInfraestructuraDTO> listarContratosProyeccionesSegurosInfraestructurasPag(Pageable pageable, Long idContratoProyeccionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura, String orderBy, String orderMode) {
        Slice<ContratoProyeccionSeguroInfraestructura> contratosProyeccionesSegurosInfraestructuras = contratoProyeccionSeguroInfraestructuraRepository.findAllContratosProyeccionesSegurosInfraestructurasPag(pageable, idContratoProyeccionSeguroInfraestructura, keyword, idProyeccionSeguroInfraestructura, orderBy, orderMode);
        return contratosProyeccionesSegurosInfraestructuras.map(contratoProyeccionSeguroInfraestructura -> contratoProyeccionSeguroInfraestructuraDAO.contratoProyeccionSeguroInfraestructuraDTO(contratoProyeccionSeguroInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearContratoProyeccionSeguroInfraestructura(ContratoProyeccionSeguroInfraestructuraDTO contratoProyeccionSeguroInfraestructuraDTO) {
        Long maxIdContratoProyeccionSeguroInfraestructura = null;
        ContratoProyeccionSeguroInfraestructura contratoNumeroContrato = contratoProyeccionSeguroInfraestructuraRepository.findByNumeroContratoSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getNumeroContratoSeguroInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroContratoRegistroEncontrado=0;
        
        if (!(contratoNumeroContrato==null)) {//SI ENCONTRO EL NÚMERO DE CONTRATO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE CONTRATO DE REGISTRO REPETIDO CON EL NÚMERO DE CONTRATO PROPORCIONADO.
           banderaNumeroContratoRegistroEncontrado=1;
        }
        
        if (banderaNumeroContratoRegistroEncontrado==1) {//SI ENCONTRO EL NÚMERO DE CONTRATO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE CONTRATO DE REGISTRO REPETIDO CON EL NÚMERO DE CONTRATO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CONTRATO_SEGURO_INFRAESTRUCTURA_YA_EXISTE, false);
           respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(null);
        }
        if ((banderaNumeroContratoRegistroEncontrado==0)) {//SI NO ENCONTRO EL NÚMERO DE CONTRATO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NÚMERO DE CONTRATO PROPORCIONADO.
           maxIdContratoProyeccionSeguroInfraestructura = contratoProyeccionSeguroInfraestructuraRepository.findMaxIdContratoProyeccionSeguroInfraestructura();
           if (maxIdContratoProyeccionSeguroInfraestructura==null) {
              maxIdContratoProyeccionSeguroInfraestructura=Long.valueOf(0);
           }
           contratoProyeccionSeguroInfraestructuraDTO.setIdContratoProyeccionSeguroInfraestructura(maxIdContratoProyeccionSeguroInfraestructura+1);
           contratoProyeccionSeguroInfraestructuraRepository.save(contratoProyeccionSeguroInfraestructuraDAO.contratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarContratoProyeccionSeguroInfraestructuraporId(Long idContratoProyeccionSeguroInfraestructura) {
        Optional<ContratoProyeccionSeguroInfraestructura> contratoProyeccionSeguroInfraestructuraId = contratoProyeccionSeguroInfraestructuraRepository.findByIdContratoProyeccionSeguroInfraestructura(Long.valueOf(idContratoProyeccionSeguroInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (contratoProyeccionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(contratoProyeccionSeguroInfraestructuraDAO.contratoProyeccionSeguroInfraestructuraDTO(contratoProyeccionSeguroInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (contratoProyeccionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NÚMERO DE CONTRATO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarContratoProyeccionSeguroInfraestructuraporNumeroContrato(String numeroContratoSeguroInfraestructura) {
        Optional<ContratoProyeccionSeguroInfraestructura> contratoNumeroContrato = Optional.ofNullable(contratoProyeccionSeguroInfraestructuraRepository.findByNumeroContratoSeguroInfraestructura(numeroContratoSeguroInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CONTRATO_SEGURO_INFRAESTRUCTURA_NO_ENCONTRADO, false);
        
        if (contratoNumeroContrato.isPresent()==true) {//SI ENCONTRO EL NÚMERO DE CONTRATO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NÚMERO DE CONTRATO PROPORCIONADO.
           respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(contratoProyeccionSeguroInfraestructuraDAO.contratoProyeccionSeguroInfraestructuraDTO(contratoNumeroContrato.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (contratoNumeroContrato.isPresent()==false) {//SI NO ENCONTRO EL NÚMERO DE CONTRATO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NÚMERO DE CONTRATO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CONTRATO_SEGURO_INFRAESTRUCTURA_NO_ENCONTRADO, false);
           respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarContratoProyeccionSeguroInfraestructura(ContratoProyeccionSeguroInfraestructuraDTO contratoProyeccionSeguroInfraestructuraDTO) {
        Optional<ContratoProyeccionSeguroInfraestructura> contratoProyeccionSeguroInfraestructuraId = contratoProyeccionSeguroInfraestructuraRepository.findByIdContratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getIdContratoProyeccionSeguroInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (contratoProyeccionSeguroInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NÚMERO DE CONTRATO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (contratoProyeccionSeguroInfraestructuraDTO.getNumeroContratoSeguroInfraestructura().equals(contratoProyeccionSeguroInfraestructuraId.get().getNumeroContratoSeguroInfraestructura())==true) ) {//SI EL NÚMERO DE CONTRATO DIGITADO ES IGUAL AL NÚMERO DE CONTRATO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ContratoProyeccionSeguroInfraestructura contratoProyeccionSeguroInfraestructura = contratoProyeccionSeguroInfraestructuraDAO.contratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO);
              contratoProyeccionSeguroInfraestructuraRepository.save(contratoProyeccionSeguroInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (contratoProyeccionSeguroInfraestructuraDTO.getNumeroContratoSeguroInfraestructura().equals(contratoProyeccionSeguroInfraestructuraId.get().getNumeroContratoSeguroInfraestructura())==false) {//SI EL NÚMERO DE CONTRATO DIGITADO ES DIFERENTE AL NÚMERO DE CONTRATO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NÚMERO DE CONTRATO DIGITADO EXISTE EN OTROS REGISTROS.
              ContratoProyeccionSeguroInfraestructura contratoNumeroContrato = contratoProyeccionSeguroInfraestructuraRepository.findByNumeroContratoSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO.getNumeroContratoSeguroInfraestructura());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroContratoRegistroEncontrado=0;
              
              if (!(contratoNumeroContrato==null)) {//SI ENCONTRO EL NÚMERO DE CONTRATO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE CONTRATO DE REGISTRO REPETIDO CON EL NÚMERO DE CONTRATO PROPORCIONADO.
                 banderaNumeroContratoRegistroEncontrado=1;
              }
              
              if (banderaNumeroContratoRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE CONTRATO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE CONTRATO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NÚMERO DE CONTRATO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CONTRATO_SEGURO_INFRAESTRUCTURA_YA_EXISTE, false);
                 respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(null);
              }
              if (banderaNumeroContratoRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE CONTRATO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 ContratoProyeccionSeguroInfraestructura contratoProyeccionSeguroInfraestructura = contratoProyeccionSeguroInfraestructuraDAO.contratoProyeccionSeguroInfraestructura(contratoProyeccionSeguroInfraestructuraDTO);
                 contratoProyeccionSeguroInfraestructuraRepository.save(contratoProyeccionSeguroInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (contratoProyeccionSeguroInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarContratoProyeccionSeguroInfraestructura(Long idContratoProyeccionSeguroInfraestructura) {
        Optional<ContratoProyeccionSeguroInfraestructura> contratoProyeccionSeguroInfraestructuraId = contratoProyeccionSeguroInfraestructuraRepository.findById(idContratoProyeccionSeguroInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (contratoProyeccionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           contratoProyeccionSeguroInfraestructuraRepository.delete(contratoProyeccionSeguroInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (contratoProyeccionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setContratoProyeccionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
