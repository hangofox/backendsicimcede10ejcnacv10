//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.InclusionSeguroInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.InclusionSeguroInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InclusionSeguroInfraestructuraRepository;
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
public class InclusionSeguroInfraestructuraServiceImpl implements InclusionSeguroInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private InclusionSeguroInfraestructuraDAO inclusionSeguroInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InclusionSeguroInfraestructuraRepository inclusionSeguroInfraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idInclusionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura) {
        return inclusionSeguroInfraestructuraRepository.findTotalRegistros(idInclusionSeguroInfraestructura, keyword, idProyeccionSeguroInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<InclusionSeguroInfraestructuraDTO> listarInclusionesSeguroInfraestructura(Long idInclusionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura, String orderBy, String orderMode) {
        List<InclusionSeguroInfraestructura> inclusionesSeguroInfraestructura = inclusionSeguroInfraestructuraRepository.findAllInclusionesSeguroInfraestructura(idInclusionSeguroInfraestructura, keyword, idProyeccionSeguroInfraestructura, orderBy, orderMode);
        List<InclusionSeguroInfraestructuraDTO> inclusionSeguroInfraestructuraDTOS = new ArrayList<>();
        for (InclusionSeguroInfraestructura inclusionSeguroInfraestructura : inclusionesSeguroInfraestructura) {
            inclusionSeguroInfraestructuraDTOS.add(inclusionSeguroInfraestructuraDAO.inclusionSeguroInfraestructuraDTO(inclusionSeguroInfraestructura));
        }
        
        return inclusionSeguroInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<InclusionSeguroInfraestructuraDTO> listarInclusionesSeguroInfraestructuraPag(Pageable pageable, Long idInclusionSeguroInfraestructura, String keyword, Long idProyeccionSeguroInfraestructura, String orderBy, String orderMode) {
        Slice<InclusionSeguroInfraestructura> inclusionesSeguroInfraestructura = inclusionSeguroInfraestructuraRepository.findAllInclusionesSeguroInfraestructuraPag(pageable, idInclusionSeguroInfraestructura, keyword, idProyeccionSeguroInfraestructura, orderBy, orderMode);
        return inclusionesSeguroInfraestructura.map(inclusionSeguroInfraestructura -> inclusionSeguroInfraestructuraDAO.inclusionSeguroInfraestructuraDTO(inclusionSeguroInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearInclusionSeguroInfraestructura(InclusionSeguroInfraestructuraDTO inclusionSeguroInfraestructuraDTO) {
        Long maxIdInclusionSeguroInfraestructura = inclusionSeguroInfraestructuraRepository.findMaxIdInclusionSeguroInfraestructura();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdInclusionSeguroInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdInclusionSeguroInfraestructura = Long.valueOf(0);
        }
        inclusionSeguroInfraestructuraDTO.setIdInclusionSeguroInfraestructura(maxIdInclusionSeguroInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        inclusionSeguroInfraestructuraRepository.save(inclusionSeguroInfraestructuraDAO.inclusionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarInclusionSeguroInfraestructuraporId(Long idInclusionSeguroInfraestructura) {
        Optional<InclusionSeguroInfraestructura> inclusionSeguroInfraestructuraId = inclusionSeguroInfraestructuraRepository.findByIdInclusionSeguroInfraestructura(Long.valueOf(idInclusionSeguroInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (inclusionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setInclusionSeguroInfraestructuraDTO(inclusionSeguroInfraestructuraDAO.inclusionSeguroInfraestructuraDTO(inclusionSeguroInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (inclusionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInclusionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarInclusionSeguroInfraestructura(InclusionSeguroInfraestructuraDTO inclusionSeguroInfraestructuraDTO) {
        Optional<InclusionSeguroInfraestructura> inclusionSeguroInfraestructuraId = inclusionSeguroInfraestructuraRepository.findByIdInclusionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO.getIdInclusionSeguroInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (inclusionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           inclusionSeguroInfraestructuraRepository.save(inclusionSeguroInfraestructuraDAO.inclusionSeguroInfraestructura(inclusionSeguroInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (inclusionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setInclusionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarInclusionSeguroInfraestructura(Long idInclusionSeguroInfraestructura) {
        Optional<InclusionSeguroInfraestructura> inclusionSeguroInfraestructuraId = inclusionSeguroInfraestructuraRepository.findById(idInclusionSeguroInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (inclusionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setInclusionSeguroInfraestructuraDTO(inclusionSeguroInfraestructuraDAO.inclusionSeguroInfraestructuraDTO(inclusionSeguroInfraestructuraId.get()));
           inclusionSeguroInfraestructuraRepository.delete(inclusionSeguroInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (inclusionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInclusionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
