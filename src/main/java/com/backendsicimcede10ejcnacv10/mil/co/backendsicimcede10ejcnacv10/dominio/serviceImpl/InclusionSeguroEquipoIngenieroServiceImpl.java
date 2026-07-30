//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.InclusionSeguroEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.InclusionSeguroEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InclusionSeguroEquipoIngenieroRepository;
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
public class InclusionSeguroEquipoIngenieroServiceImpl implements InclusionSeguroEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private InclusionSeguroEquipoIngenieroDAO inclusionSeguroEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InclusionSeguroEquipoIngenieroRepository inclusionSeguroEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idInclusionSeguroEquipoIngeniero, String keyword, Long idAseguramientoEquipoIngeniero) {
        return inclusionSeguroEquipoIngenieroRepository.findTotalRegistros(idInclusionSeguroEquipoIngeniero, keyword, idAseguramientoEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<InclusionSeguroEquipoIngenieroDTO> listarInclusionesSeguroEquipoIngeniero(Long idInclusionSeguroEquipoIngeniero, String keyword, Long idAseguramientoEquipoIngeniero, String orderBy, String orderMode) {
        List<InclusionSeguroEquipoIngeniero> inclusionesSeguroEquipoIngeniero = inclusionSeguroEquipoIngenieroRepository.findAllInclusionesSeguroEquipoIngeniero(idInclusionSeguroEquipoIngeniero, keyword, idAseguramientoEquipoIngeniero, orderBy, orderMode);
        List<InclusionSeguroEquipoIngenieroDTO> inclusionSeguroEquipoIngeneroDTOS = new ArrayList<>();
        for (InclusionSeguroEquipoIngeniero inclusionSeguroEquipoIngeniero : inclusionesSeguroEquipoIngeniero) {
            inclusionSeguroEquipoIngeneroDTOS.add(inclusionSeguroEquipoIngenieroDAO.inclusionSeguroEquipoIngenieroDTO(inclusionSeguroEquipoIngeniero));
        }
        
        return inclusionSeguroEquipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<InclusionSeguroEquipoIngenieroDTO> listarInclusionesSeguroEquipoIngeneroPag(Pageable pageable, Long idInclusionSeguroEquipoIngeniero, String keyword, Long idAseguramientoEquipoIngeniero, String orderBy, String orderMode) {
        Slice<InclusionSeguroEquipoIngeniero> inclusionesSeguroEquipoIngeniero = inclusionSeguroEquipoIngenieroRepository.findAllInclusionesSeguroEquipoIngeneroPag(pageable, idInclusionSeguroEquipoIngeniero, keyword, idAseguramientoEquipoIngeniero, orderBy, orderMode);
        return inclusionesSeguroEquipoIngeniero.map(inclusionSeguroEquipoIngeniero -> inclusionSeguroEquipoIngenieroDAO.inclusionSeguroEquipoIngenieroDTO(inclusionSeguroEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearInclusionSeguroEquipoIngeniero(InclusionSeguroEquipoIngenieroDTO inclusionSeguroEquipoIngenieroDTO) {
        Long maxIdInclusionSeguroEquipoIngeniero = inclusionSeguroEquipoIngenieroRepository.findMaxIdInclusionSeguroEquipoIngeniero();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdInclusionSeguroEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdInclusionSeguroEquipoIngeniero = Long.valueOf(0);
        }
        inclusionSeguroEquipoIngenieroDTO.setIdInclusionSeguroEquipoIngeniero(maxIdInclusionSeguroEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        inclusionSeguroEquipoIngenieroRepository.save(inclusionSeguroEquipoIngenieroDAO.inclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarInclusionSeguroEquipoIngenieroporId(Long idInclusionSeguroEquipoIngeniero) {
        Optional<InclusionSeguroEquipoIngeniero> inclusionSeguroEquipoIngenieroId = inclusionSeguroEquipoIngenieroRepository.findByIdInclusionSeguroEquipoIngeniero(Long.valueOf(idInclusionSeguroEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (inclusionSeguroEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setInclusionSeguroEquipoIngenieroDTO(inclusionSeguroEquipoIngenieroDAO.inclusionSeguroEquipoIngenieroDTO(inclusionSeguroEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (inclusionSeguroEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInclusionSeguroEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarInclusionSeguroEquipoIngeniero(InclusionSeguroEquipoIngenieroDTO inclusionSeguroEquipoIngenieroDTO) {
        Optional<InclusionSeguroEquipoIngeniero> inclusionSeguroEquipoIngenieroId = inclusionSeguroEquipoIngenieroRepository.findByIdInclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO.getIdInclusionSeguroEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (inclusionSeguroEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           inclusionSeguroEquipoIngenieroRepository.save(inclusionSeguroEquipoIngenieroDAO.inclusionSeguroEquipoIngeniero(inclusionSeguroEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (inclusionSeguroEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setInclusionSeguroEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarInclusionSeguroEquipoIngeniero(Long idInclusionSeguroEquipoIngeniero) {
        Optional<InclusionSeguroEquipoIngeniero> inclusionSeguroEquipoIngenieroId = inclusionSeguroEquipoIngenieroRepository.findById(idInclusionSeguroEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (inclusionSeguroEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setInclusionSeguroEquipoIngenieroDTO(inclusionSeguroEquipoIngenieroDAO.inclusionSeguroEquipoIngenieroDTO(inclusionSeguroEquipoIngenieroId.get()));
           inclusionSeguroEquipoIngenieroRepository.delete(inclusionSeguroEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (inclusionSeguroEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInclusionSeguroEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
