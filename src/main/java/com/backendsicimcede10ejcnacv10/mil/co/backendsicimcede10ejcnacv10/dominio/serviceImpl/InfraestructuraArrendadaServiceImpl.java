//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InfraestructuraArrendadaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.InfraestructuraArrendadaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.InfraestructuraArrendadaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InfraestructuraArrendada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraArrendadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 08/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class InfraestructuraArrendadaServiceImpl implements InfraestructuraArrendadaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraArrendadaDAO infraestructuraArrendadaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraArrendadaRepository infraestructuraArrendadaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idInfraestructuraArrendada, String keyword) {
        return infraestructuraArrendadaRepository.findTotalRegistros(idInfraestructuraArrendada, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<InfraestructuraArrendadaDTO> listarInfraestructurasArrendadas(Long idInfraestructuraArrendada, String keyword, String orderBy, String orderMode) {
        List<InfraestructuraArrendada> infraestructurasArrendadas = infraestructuraArrendadaRepository.findAllInfraestructurasArrendadas(idInfraestructuraArrendada, keyword, orderBy, orderMode);
        List<InfraestructuraArrendadaDTO> infraestructuraArrendadaDTOS = new ArrayList<>();
        for (InfraestructuraArrendada infraestructuraArrendada : infraestructurasArrendadas) {
            infraestructuraArrendadaDTOS.add(infraestructuraArrendadaDAO.infraestructuraArrendadaDTO(infraestructuraArrendada));
        }
        
        return infraestructuraArrendadaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<InfraestructuraArrendadaDTO> listarInfraestructurasArrendadasPag(Pageable pageable, Long idInfraestructuraArrendada, String keyword, String orderBy, String orderMode) {
        Slice<InfraestructuraArrendada> infraestructurasArrendadas = infraestructuraArrendadaRepository.findAllInfraestructurasArrendadasPag(pageable, idInfraestructuraArrendada, keyword, orderBy, orderMode);
        return infraestructurasArrendadas.map(infraestructuraArrendada -> infraestructuraArrendadaDAO.infraestructuraArrendadaDTO(infraestructuraArrendada));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearInfraestructuraArrendada(InfraestructuraArrendadaDTO infraestructuraArrendadaDTO) {
        Long maxIdInfraestructuraArrendada = infraestructuraArrendadaRepository.findMaxIdInfraestructuraArrendada();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdInfraestructuraArrendada == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdInfraestructuraArrendada = Long.valueOf(0);
        }
        infraestructuraArrendadaDTO.setIdInfraestructuraArrendada(maxIdInfraestructuraArrendada + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        infraestructuraArrendadaRepository.save(infraestructuraArrendadaDAO.infraestructuraArrendada(infraestructuraArrendadaDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarInfraestructuraArrendadaporId(Long idInfraestructuraArrendada) {
        Optional<InfraestructuraArrendada> infraestructuraArrendadaId = infraestructuraArrendadaRepository.findByIdInfraestructuraArrendada(Long.valueOf(idInfraestructuraArrendada));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (infraestructuraArrendadaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setInfraestructuraArrendadaDTO(infraestructuraArrendadaDAO.infraestructuraArrendadaDTO(infraestructuraArrendadaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (infraestructuraArrendadaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInfraestructuraArrendadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarInfraestructuraArrendada(InfraestructuraArrendadaDTO infraestructuraArrendadaDTO) {
        Optional<InfraestructuraArrendada> infraestructuraArrendadaId = infraestructuraArrendadaRepository.findByIdInfraestructuraArrendada(infraestructuraArrendadaDTO.getIdInfraestructuraArrendada());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (infraestructuraArrendadaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           infraestructuraArrendadaRepository.save(infraestructuraArrendadaDAO.infraestructuraArrendada(infraestructuraArrendadaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (infraestructuraArrendadaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setInfraestructuraArrendadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarInfraestructuraArrendada(Long idInfraestructuraArrendada) {
        Optional<InfraestructuraArrendada> infraestructuraArrendadaId = infraestructuraArrendadaRepository.findById(idInfraestructuraArrendada);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (infraestructuraArrendadaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setInfraestructuraArrendadaDTO(infraestructuraArrendadaDAO.infraestructuraArrendadaDTO(infraestructuraArrendadaId.get()));
           infraestructuraArrendadaRepository.delete(infraestructuraArrendadaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (infraestructuraArrendadaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInfraestructuraArrendadaDTO(null);
        }
        
        return respuestaDTO;
    }
}
