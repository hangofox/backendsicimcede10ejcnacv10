//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ComodatoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ComodatoTerrenoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ComodatoTerrenoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ComodatoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ComodatoTerrenoRepository;
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
public class ComodatoTerrenoServiceImpl implements ComodatoTerrenoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ComodatoTerrenoDAO comodatoTerrenoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ComodatoTerrenoRepository comodatoTerrenoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idComodatoTerreno, String keyword, Long idTerreno) {
        return comodatoTerrenoRepository.findTotalRegistros(idComodatoTerreno, keyword, idTerreno);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ComodatoTerrenoDTO> listarComodatosTerrenos(Long idComodatoTerreno, String keyword, Long idTerreno, String orderBy, String orderMode) {
        List<ComodatoTerreno> comodatosTerrenos = comodatoTerrenoRepository.findAllComodatosTerrenos(idComodatoTerreno, keyword, idTerreno, orderBy, orderMode);
        List<ComodatoTerrenoDTO> comodatoTerrenoDTOS = new ArrayList<>();
        for (ComodatoTerreno comodatoTerreno : comodatosTerrenos) {
            comodatoTerrenoDTOS.add(comodatoTerrenoDAO.comodatoTerrenoDTO(comodatoTerreno));
        }
        
        return comodatoTerrenoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ComodatoTerrenoDTO> listarComodatosTerrenosPag(Pageable pageable, Long idComodatoTerreno, String keyword, Long idTerreno, String orderBy, String orderMode) {
        Slice<ComodatoTerreno> comodatosTerrenos = comodatoTerrenoRepository.findAllComodatosTerrenosPag(pageable, idComodatoTerreno, keyword, idTerreno, orderBy, orderMode);
        return comodatosTerrenos.map(comodatoTerreno -> comodatoTerrenoDAO.comodatoTerrenoDTO(comodatoTerreno));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearComodatoTerreno(ComodatoTerrenoDTO comodatoTerrenoDTO) {
        Long maxIdComodatoTerreno = comodatoTerrenoRepository.findMaxIdComodatoTerreno();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdComodatoTerreno == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdComodatoTerreno = Long.valueOf(0);
        }
        comodatoTerrenoDTO.setIdComodatoTerreno(maxIdComodatoTerreno + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        comodatoTerrenoRepository.save(comodatoTerrenoDAO.comodatoTerreno(comodatoTerrenoDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarComodatoTerrenoporId(Long idComodatoTerreno) {
        Optional<ComodatoTerreno> comodatoTerrenoId = comodatoTerrenoRepository.findByIdComodatoTerreno(Long.valueOf(idComodatoTerreno));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (comodatoTerrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setComodatoTerrenoDTO(comodatoTerrenoDAO.comodatoTerrenoDTO(comodatoTerrenoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (comodatoTerrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setComodatoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarComodatoTerreno(ComodatoTerrenoDTO comodatoTerrenoDTO) {
        Optional<ComodatoTerreno> comodatoTerrenoId = comodatoTerrenoRepository.findByIdComodatoTerreno(comodatoTerrenoDTO.getIdComodatoTerreno());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (comodatoTerrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           comodatoTerrenoRepository.save(comodatoTerrenoDAO.comodatoTerreno(comodatoTerrenoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (comodatoTerrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setComodatoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarComodatoTerreno(Long idComodatoTerreno) {
        Optional<ComodatoTerreno> comodatoTerrenoId = comodatoTerrenoRepository.findById(idComodatoTerreno);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (comodatoTerrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setComodatoTerrenoDTO(comodatoTerrenoDAO.comodatoTerrenoDTO(comodatoTerrenoId.get()));
           comodatoTerrenoRepository.delete(comodatoTerrenoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (comodatoTerrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setComodatoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
}
