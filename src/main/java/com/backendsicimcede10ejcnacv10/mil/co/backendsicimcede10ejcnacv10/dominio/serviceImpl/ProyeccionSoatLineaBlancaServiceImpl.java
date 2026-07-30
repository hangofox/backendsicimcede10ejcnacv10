//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionSoatLineaBlancaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionSoatLineaBlancaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionSoatLineaBlancaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSoatLineaBlanca;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionSoatLineaBlancaRepository;
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
public class ProyeccionSoatLineaBlancaServiceImpl implements ProyeccionSoatLineaBlancaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionSoatLineaBlancaDAO proyeccionSoatLineaBlancaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionSoatLineaBlancaRepository proyeccionSoatLineaBlancaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionSoatLineaBlanca, Long idEquipoIngeniero, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, String keyword) {
        return proyeccionSoatLineaBlancaRepository.findTotalRegistros(idProyeccionSoatLineaBlanca, idEquipoIngeniero, valorSolicitadoProyeccionPlanAnualAdqCdoIng, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionSoatLineaBlancaDTO> listarProyeccionesSoatsLineasBlancas(Long idProyeccionSoatLineaBlanca, Long idEquipoIngeniero, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, String keyword, String orderBy, String orderMode) {
        List<ProyeccionSoatLineaBlanca> proyeccionesSoatsLineasBlancas = proyeccionSoatLineaBlancaRepository.findAllProyeccionesSoatsLineasBlancas(idProyeccionSoatLineaBlanca, idEquipoIngeniero, valorSolicitadoProyeccionPlanAnualAdqCdoIng, keyword, orderBy, orderMode);
        List<ProyeccionSoatLineaBlancaDTO> proyeccionSoatLineaBlancaDTOS = new ArrayList<>();
        for (ProyeccionSoatLineaBlanca proyeccionSoatLineaBlanca : proyeccionesSoatsLineasBlancas) {
            proyeccionSoatLineaBlancaDTOS.add(proyeccionSoatLineaBlancaDAO.proyeccionSoatLineaBlancaDTO(proyeccionSoatLineaBlanca));
        }
        
        return proyeccionSoatLineaBlancaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionSoatLineaBlancaDTO> listarProyeccionesSoatsLineasBlancasPag(Pageable pageable, Long idProyeccionSoatLineaBlanca, Long idEquipoIngeniero, String valorSolicitadoProyeccionPlanAnualAdqCdoIng, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionSoatLineaBlanca> proyeccionesSoatsLineasBlancas = proyeccionSoatLineaBlancaRepository.findAllProyeccionesSoatsLineasBlancasPag(pageable, idProyeccionSoatLineaBlanca, idEquipoIngeniero, valorSolicitadoProyeccionPlanAnualAdqCdoIng, keyword, orderBy, orderMode);
        return proyeccionesSoatsLineasBlancas.map(proyeccionSoatLineaBlanca -> proyeccionSoatLineaBlancaDAO.proyeccionSoatLineaBlancaDTO(proyeccionSoatLineaBlanca));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionSoatLineaBlanca(ProyeccionSoatLineaBlancaDTO proyeccionSoatLineaBlancaDTO) {
        Long maxIdProyeccionSoatLineaBlanca = proyeccionSoatLineaBlancaRepository.findMaxIdProyeccionSoatLineaBlanca();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdProyeccionSoatLineaBlanca == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdProyeccionSoatLineaBlanca = Long.valueOf(0);
        }
        proyeccionSoatLineaBlancaDTO.setIdProyeccionSoatLineaBlanca(maxIdProyeccionSoatLineaBlanca + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        proyeccionSoatLineaBlancaRepository.save(proyeccionSoatLineaBlancaDAO.proyeccionSoatLineaBlanca(proyeccionSoatLineaBlancaDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionSoatLineaBlancaporId(Long idProyeccionSoatLineaBlanca) {
        Optional<ProyeccionSoatLineaBlanca> proyeccionSoatLineaBlancaId = proyeccionSoatLineaBlancaRepository.findByIdProyeccionSoatLineaBlanca(Long.valueOf(idProyeccionSoatLineaBlanca));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionSoatLineaBlancaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionSoatLineaBlancaDTO(proyeccionSoatLineaBlancaDAO.proyeccionSoatLineaBlancaDTO(proyeccionSoatLineaBlancaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionSoatLineaBlancaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionSoatLineaBlancaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionSoatLineaBlanca(ProyeccionSoatLineaBlancaDTO proyeccionSoatLineaBlancaDTO) {
        Optional<ProyeccionSoatLineaBlanca> proyeccionSoatLineaBlancaId = proyeccionSoatLineaBlancaRepository.findByIdProyeccionSoatLineaBlanca(proyeccionSoatLineaBlancaDTO.getIdProyeccionSoatLineaBlanca());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionSoatLineaBlancaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           proyeccionSoatLineaBlancaRepository.save(proyeccionSoatLineaBlancaDAO.proyeccionSoatLineaBlanca(proyeccionSoatLineaBlancaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (proyeccionSoatLineaBlancaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionSoatLineaBlancaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionSoatLineaBlanca(Long idProyeccionSoatLineaBlanca) {
        Optional<ProyeccionSoatLineaBlanca> proyeccionSoatLineaBlancaId = proyeccionSoatLineaBlancaRepository.findById(idProyeccionSoatLineaBlanca);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionSoatLineaBlancaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionSoatLineaBlancaDTO(proyeccionSoatLineaBlancaDAO.proyeccionSoatLineaBlancaDTO(proyeccionSoatLineaBlancaId.get()));
           proyeccionSoatLineaBlancaRepository.delete(proyeccionSoatLineaBlancaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionSoatLineaBlancaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionSoatLineaBlancaDTO(null);
        }
        
        return respuestaDTO;
    }
}
