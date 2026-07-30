//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SuministroDemeritoYDesgasteEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.SuministroDemeritoYDesgasteEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.SuministroDemeritoYDesgasteEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SuministroDemeritoYDesgasteEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SuministroDemeritoYDesgasteEquipoIngenieroRepository;
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
public class SuministroDemeritoYDesgasteEquipoIngenieroServiceImpl implements SuministroDemeritoYDesgasteEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private SuministroDemeritoYDesgasteEquipoIngenieroDAO suministroDemeritoYDesgasteEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SuministroDemeritoYDesgasteEquipoIngenieroRepository suministroDemeritoYDesgasteEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idSuministroDemeritoYDesgasteEquipoIngeniero, String keyword, Long idHistorialDemeritoYDesgasteEquipoIngeniero) {
        return suministroDemeritoYDesgasteEquipoIngenieroRepository.findTotalRegistros(idSuministroDemeritoYDesgasteEquipoIngeniero, keyword, idHistorialDemeritoYDesgasteEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<SuministroDemeritoYDesgasteEquipoIngenieroDTO> listarSuministrosDemeritosYDesgastesEquiposIngenieros(Long idSuministroDemeritoYDesgasteEquipoIngeniero, String keyword, Long idHistorialDemeritoYDesgasteEquipoIngeniero, String orderBy, String orderMode) {
        List<SuministroDemeritoYDesgasteEquipoIngeniero> suministrosDemeritosYDesgastesEquiposIngenieros = suministroDemeritoYDesgasteEquipoIngenieroRepository.findAllSuministrosDemeritosYDesgastesEquiposIngenieros(idSuministroDemeritoYDesgasteEquipoIngeniero, keyword, idHistorialDemeritoYDesgasteEquipoIngeniero, orderBy, orderMode);
        List<SuministroDemeritoYDesgasteEquipoIngenieroDTO> suministroDemeritoYDesgasteEquipoIngeneroDTOS = new ArrayList<>();
        for (SuministroDemeritoYDesgasteEquipoIngeniero suministroDemeritoYDesgasteEquipoIngeniero : suministrosDemeritosYDesgastesEquiposIngenieros) {
            suministroDemeritoYDesgasteEquipoIngeneroDTOS.add(suministroDemeritoYDesgasteEquipoIngenieroDAO.suministroDemeritoYDesgasteEquipoIngenieroDTO(suministroDemeritoYDesgasteEquipoIngeniero));
        }
        
        return suministroDemeritoYDesgasteEquipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<SuministroDemeritoYDesgasteEquipoIngenieroDTO> listarSuministrosDemeritosYDesgastesEquiposIngenierosPag(Pageable pageable, Long idSuministroDemeritoYDesgasteEquipoIngeniero, String keyword, Long idHistorialDemeritoYDesgasteEquipoIngeniero, String orderBy, String orderMode) {
        Slice<SuministroDemeritoYDesgasteEquipoIngeniero> suministrosDemeritosYDesgastesEquiposIngenieros = suministroDemeritoYDesgasteEquipoIngenieroRepository.findAllSuministrosDemeritosYDesgastesEquiposIngenierosPag(pageable, idSuministroDemeritoYDesgasteEquipoIngeniero, keyword, idHistorialDemeritoYDesgasteEquipoIngeniero, orderBy, orderMode);
        return suministrosDemeritosYDesgastesEquiposIngenieros.map(suministroDemeritoYDesgasteEquipoIngeniero -> suministroDemeritoYDesgasteEquipoIngenieroDAO.suministroDemeritoYDesgasteEquipoIngenieroDTO(suministroDemeritoYDesgasteEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearSuministroDemeritoYDesgasteEquipoIngeniero(SuministroDemeritoYDesgasteEquipoIngenieroDTO suministroDemeritoYDesgasteEquipoIngenieroDTO) {
        Long maxIdSuministroDemeritoYDesgasteEquipoIngeniero = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        maxIdSuministroDemeritoYDesgasteEquipoIngeniero = suministroDemeritoYDesgasteEquipoIngenieroRepository.findMaxIdSuministroDemeritoYDesgasteEquipoIngeniero();
        if (maxIdSuministroDemeritoYDesgasteEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdSuministroDemeritoYDesgasteEquipoIngeniero = Long.valueOf(0);
        }
        suministroDemeritoYDesgasteEquipoIngenieroDTO.setIdSuministroDemeritoYDesgasteEquipoIngeniero(maxIdSuministroDemeritoYDesgasteEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        suministroDemeritoYDesgasteEquipoIngenieroRepository.save(suministroDemeritoYDesgasteEquipoIngenieroDAO.suministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngenieroDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSuministroDemeritoYDesgasteEquipoIngenieroporId(Long idSuministroDemeritoYDesgasteEquipoIngeniero) {
        Optional<SuministroDemeritoYDesgasteEquipoIngeniero> suministroDemeritoYDesgasteEquipoIngenieroId = suministroDemeritoYDesgasteEquipoIngenieroRepository.findByIdSuministroDemeritoYDesgasteEquipoIngeniero(Long.valueOf(idSuministroDemeritoYDesgasteEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (suministroDemeritoYDesgasteEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setSuministroDemeritoYDesgasteEquipoIngenieroDTO(suministroDemeritoYDesgasteEquipoIngenieroDAO.suministroDemeritoYDesgasteEquipoIngenieroDTO(suministroDemeritoYDesgasteEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (suministroDemeritoYDesgasteEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSuministroDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarSuministroDemeritoYDesgasteEquipoIngeniero(SuministroDemeritoYDesgasteEquipoIngenieroDTO suministroDemeritoYDesgasteEquipoIngenieroDTO) {
        Optional<SuministroDemeritoYDesgasteEquipoIngeniero> suministroDemeritoYDesgasteEquipoIngenieroId = suministroDemeritoYDesgasteEquipoIngenieroRepository.findByIdSuministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngenieroDTO.getIdSuministroDemeritoYDesgasteEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (suministroDemeritoYDesgasteEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           suministroDemeritoYDesgasteEquipoIngenieroRepository.save(suministroDemeritoYDesgasteEquipoIngenieroDAO.suministroDemeritoYDesgasteEquipoIngeniero(suministroDemeritoYDesgasteEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (suministroDemeritoYDesgasteEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setSuministroDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarSuministroDemeritoYDesgasteEquipoIngeniero(Long idSuministroDemeritoYDesgasteEquipoIngeniero) {
        Optional<SuministroDemeritoYDesgasteEquipoIngeniero> suministroDemeritoYDesgasteEquipoIngenieroId = suministroDemeritoYDesgasteEquipoIngenieroRepository.findById(idSuministroDemeritoYDesgasteEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (suministroDemeritoYDesgasteEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setSuministroDemeritoYDesgasteEquipoIngenieroDTO(suministroDemeritoYDesgasteEquipoIngenieroDAO.suministroDemeritoYDesgasteEquipoIngenieroDTO(suministroDemeritoYDesgasteEquipoIngenieroId.get()));
           suministroDemeritoYDesgasteEquipoIngenieroRepository.delete(suministroDemeritoYDesgasteEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (suministroDemeritoYDesgasteEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSuministroDemeritoYDesgasteEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
