//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.GerenteProyectoSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.GerenteProyectoSolicInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.GerenteProyectoSolicInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.GerenteProyectoSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.GerenteProyectoSolicInfraestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class GerenteProyectoSolicInfraestServiceImpl implements GerenteProyectoSolicInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private GerenteProyectoSolicInfraestDAO gerenteProyectoSolicInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private GerenteProyectoSolicInfraestRepository gerenteProyectoSolicInfraestRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idGerenteProyectoSolicInfraest, String keyword, Long idSolicitudInfraestructura) {
        return gerenteProyectoSolicInfraestRepository.findTotalRegistros(idGerenteProyectoSolicInfraest, keyword, idSolicitudInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<GerenteProyectoSolicInfraestDTO> listarGerentesProyectosSolicInfraest(Long idGerenteProyectoSolicInfraest, String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        List<GerenteProyectoSolicInfraest> gerentesProyectosSolicInfraest = gerenteProyectoSolicInfraestRepository.findAllGerentesProyectosSolicInfraest(idGerenteProyectoSolicInfraest, keyword, idSolicitudInfraestructura, orderBy, orderMode);
        List<GerenteProyectoSolicInfraestDTO> gerenteProyectoSolicInfraestDTOS = new ArrayList<>();
        for (GerenteProyectoSolicInfraest gerenteProyectoSolicInfraest : gerentesProyectosSolicInfraest) {
            gerenteProyectoSolicInfraestDTOS.add(gerenteProyectoSolicInfraestDAO.gerenteProyectoSolicInfraestDTO(gerenteProyectoSolicInfraest));
        }
        
        return gerenteProyectoSolicInfraestDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<GerenteProyectoSolicInfraestDTO> listarGerentesProyectosSolicInfraestPag(Pageable pageable, Long idGerenteProyectoSolicInfraest, String keyword, Long idSolicitudInfraestructura, String orderBy, String orderMode) {
        Slice<GerenteProyectoSolicInfraest> gerentesProyectosSolicInfraest = gerenteProyectoSolicInfraestRepository.findAllGerentesProyectosSolicInfraestPag(pageable, idGerenteProyectoSolicInfraest, keyword, idSolicitudInfraestructura, orderBy, orderMode);
        return gerentesProyectosSolicInfraest.map(gerenteProyectoSolicInfraest -> gerenteProyectoSolicInfraestDAO.gerenteProyectoSolicInfraestDTO(gerenteProyectoSolicInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearGerenteProyectoSolicInfraest(GerenteProyectoSolicInfraestDTO gerenteProyectoSolicInfraestDTO) {
        Long maxIdGerenteProyectoSolicInfraest = null;
        GerenteProyectoSolicInfraest gerenteProyectoExistenteEnSolicitudInfraestructura = gerenteProyectoSolicInfraestRepository.findBySolicitudInfraestructuraId(gerenteProyectoSolicInfraestDTO.getSolicitudInfraestructuraDTO().getIdSolicitudInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(gerenteProyectoExistenteEnSolicitudInfraestructura == null)) {//SI YA EXISTE UN REGISTRO DE GERENTE DE PROYECTO PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE GERENTE DE PROYECTO PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_GERENTE_PROYECTO_YA_EXISTE_EN_SOLICITUD_INFRAESTRUCTURA, false);
           respuestaDTO.setGerenteProyectoSolicInfraestDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE GERENTE DE PROYECTO PARA LA MISMA SOLICITUD DE INFRAESTRUCTURA SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdGerenteProyectoSolicInfraest = gerenteProyectoSolicInfraestRepository.findMaxIdGerenteProyectoSolicInfraest();
           if (maxIdGerenteProyectoSolicInfraest == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdGerenteProyectoSolicInfraest = Long.valueOf(0);
           }
           gerenteProyectoSolicInfraestDTO.setIdGerenteProyectoSolicInfraest(maxIdGerenteProyectoSolicInfraest + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           gerenteProyectoSolicInfraestRepository.save(gerenteProyectoSolicInfraestDAO.gerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarGerenteProyectoSolicInfraestporId(Long idGerenteProyectoSolicInfraest) {
        Optional<GerenteProyectoSolicInfraest> gerenteProyectoSolicInfraestId = gerenteProyectoSolicInfraestRepository.findByIdGerenteProyectoSolicInfraest(Long.valueOf(idGerenteProyectoSolicInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (gerenteProyectoSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setGerenteProyectoSolicInfraestDTO(gerenteProyectoSolicInfraestDAO.gerenteProyectoSolicInfraestDTO(gerenteProyectoSolicInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (gerenteProyectoSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setGerenteProyectoSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarGerenteProyectoSolicInfraest(GerenteProyectoSolicInfraestDTO gerenteProyectoSolicInfraestDTO) {
        Optional<GerenteProyectoSolicInfraest> gerenteProyectoSolicInfraestId = gerenteProyectoSolicInfraestRepository.findByIdGerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO.getIdGerenteProyectoSolicInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (gerenteProyectoSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           gerenteProyectoSolicInfraestRepository.save(gerenteProyectoSolicInfraestDAO.gerenteProyectoSolicInfraest(gerenteProyectoSolicInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (gerenteProyectoSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setGerenteProyectoSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarGerenteProyectoSolicInfraest(Long idGerenteProyectoSolicInfraest) {
        Optional<GerenteProyectoSolicInfraest> gerenteProyectoSolicInfraestId = gerenteProyectoSolicInfraestRepository.findById(idGerenteProyectoSolicInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (gerenteProyectoSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setGerenteProyectoSolicInfraestDTO(gerenteProyectoSolicInfraestDAO.gerenteProyectoSolicInfraestDTO(gerenteProyectoSolicInfraestId.get()));
           gerenteProyectoSolicInfraestRepository.delete(gerenteProyectoSolicInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (gerenteProyectoSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setGerenteProyectoSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
