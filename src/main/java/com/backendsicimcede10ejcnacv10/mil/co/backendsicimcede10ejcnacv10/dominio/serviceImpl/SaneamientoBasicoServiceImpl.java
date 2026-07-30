//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SaneamientoBasicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.SaneamientoBasicoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.SaneamientoBasicoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SaneamientoBasico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SaneamientoBasicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class SaneamientoBasicoServiceImpl implements SaneamientoBasicoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private SaneamientoBasicoDAO saneamientoBasicoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SaneamientoBasicoRepository saneamientoBasicoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idSaneamientoBasico, String keyword, Long idInfraestructura) {
        return saneamientoBasicoRepository.findTotalRegistros(idSaneamientoBasico, keyword, idInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<SaneamientoBasicoDTO> listarSaneamientosBasicos(Long idSaneamientoBasico, String keyword, Long idInfraestructura, String orderBy, String orderMode) {
        List<SaneamientoBasico> saneamientosBasicos = saneamientoBasicoRepository.findAllSaneamientosBasicos(idSaneamientoBasico, keyword, idInfraestructura, orderBy, orderMode);
        List<SaneamientoBasicoDTO> saneamientoBasicoDTOS = new ArrayList<>();
        for (SaneamientoBasico saneamientoBasico : saneamientosBasicos) {
            saneamientoBasicoDTOS.add(saneamientoBasicoDAO.saneamientoBasicoDTO(saneamientoBasico));
        }
        
        return saneamientoBasicoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<SaneamientoBasicoDTO> listarSaneamientosBasicosPag(Pageable pageable, Long idSaneamientoBasico, String keyword, Long idInfraestructura, String orderBy, String orderMode) {
        Slice<SaneamientoBasico> saneamientosBasicos = saneamientoBasicoRepository.findAllSaneamientosBasicosPag(pageable, idSaneamientoBasico, keyword, idInfraestructura, orderBy, orderMode);
        return saneamientosBasicos.map(saneamientoBasico -> saneamientoBasicoDAO.saneamientoBasicoDTO(saneamientoBasico));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearSaneamientoBasico(SaneamientoBasicoDTO saneamientoBasicoDTO) {
        Long maxIdSaneamientoBasico = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        maxIdSaneamientoBasico = saneamientoBasicoRepository.findMaxIdSaneamientoBasico();
        if (maxIdSaneamientoBasico == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdSaneamientoBasico = Long.valueOf(0);
        }
        saneamientoBasicoDTO.setIdSaneamientoBasico(maxIdSaneamientoBasico + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        saneamientoBasicoRepository.save(saneamientoBasicoDAO.saneamientoBasico(saneamientoBasicoDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSaneamientoBasicoporId(Long idSaneamientoBasico) {
        Optional<SaneamientoBasico> saneamientoBasicoId = saneamientoBasicoRepository.findByIdSaneamientoBasico(Long.valueOf(idSaneamientoBasico));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (saneamientoBasicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setSaneamientoBasicoDTO(saneamientoBasicoDAO.saneamientoBasicoDTO(saneamientoBasicoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (saneamientoBasicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarSaneamientoBasico(SaneamientoBasicoDTO saneamientoBasicoDTO) {
        Optional<SaneamientoBasico> saneamientoBasicoId = saneamientoBasicoRepository.findByIdSaneamientoBasico(saneamientoBasicoDTO.getIdSaneamientoBasico());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (saneamientoBasicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           saneamientoBasicoRepository.save(saneamientoBasicoDAO.saneamientoBasico(saneamientoBasicoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (saneamientoBasicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarSaneamientoBasico(Long idSaneamientoBasico) {
        Optional<SaneamientoBasico> saneamientoBasicoId = saneamientoBasicoRepository.findById(idSaneamientoBasico);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (saneamientoBasicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setSaneamientoBasicoDTO(saneamientoBasicoDAO.saneamientoBasicoDTO(saneamientoBasicoId.get()));
           saneamientoBasicoRepository.delete(saneamientoBasicoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (saneamientoBasicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
}
