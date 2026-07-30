//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionSeguroInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionSeguroInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionSeguroInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionSeguroInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionSeguroInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 14/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProyeccionSeguroInfraestructuraServiceImpl implements ProyeccionSeguroInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionSeguroInfraestructuraDAO proyeccionSeguroInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionSeguroInfraestructuraRepository proyeccionSeguroInfraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionSeguroInfraestructura, Long idInfraestructura, String valorSolicitadoProySegInfraest, String valorSolicitadoTodoRiesgoProySegInfraest, String valorSolicitadoRenegociacionProySegInfraest, String keyword) {
        return proyeccionSeguroInfraestructuraRepository.findTotalRegistros(idProyeccionSeguroInfraestructura, idInfraestructura, valorSolicitadoProySegInfraest, valorSolicitadoTodoRiesgoProySegInfraest, valorSolicitadoRenegociacionProySegInfraest, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionSeguroInfraestructuraDTO> listarProyeccionesSegurosInfraestructuras(Long idProyeccionSeguroInfraestructura, Long idInfraestructura, String valorSolicitadoProySegInfraest, String valorSolicitadoTodoRiesgoProySegInfraest, String valorSolicitadoRenegociacionProySegInfraest, String keyword, String orderBy, String orderMode) {
        List<ProyeccionSeguroInfraestructura> proyeccionesSegurosInfraestructuras = proyeccionSeguroInfraestructuraRepository.findAllProyeccionesSegurosInfraestructuras(idProyeccionSeguroInfraestructura, idInfraestructura, valorSolicitadoProySegInfraest, valorSolicitadoTodoRiesgoProySegInfraest, valorSolicitadoRenegociacionProySegInfraest, keyword, orderBy, orderMode);
        List<ProyeccionSeguroInfraestructuraDTO> proyeccionSeguroInfraestructuraDTOS = new ArrayList<>();
        for (ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura : proyeccionesSegurosInfraestructuras) {
            proyeccionSeguroInfraestructuraDTOS.add(proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructura));
        }
        
        return proyeccionSeguroInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionSeguroInfraestructuraDTO> listarProyeccionesSegurosInfraestructurasPag(Pageable pageable, Long idProyeccionSeguroInfraestructura, Long idInfraestructura, String valorSolicitadoProySegInfraest, String valorSolicitadoTodoRiesgoProySegInfraest, String valorSolicitadoRenegociacionProySegInfraest, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionSeguroInfraestructura> proyeccionesSegurosInfraestructuras = proyeccionSeguroInfraestructuraRepository.findAllProyeccionesSegurosInfraestructurasPag(pageable, idProyeccionSeguroInfraestructura, idInfraestructura, valorSolicitadoProySegInfraest, valorSolicitadoTodoRiesgoProySegInfraest, valorSolicitadoRenegociacionProySegInfraest, keyword, orderBy, orderMode);
        return proyeccionesSegurosInfraestructuras.map(proyeccionSeguroInfraestructura -> proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionSeguroInfraestructura(ProyeccionSeguroInfraestructuraDTO proyeccionSeguroInfraestructuraDTO) {
        Long maxIdProyeccionSeguroInfraestructura = null;
        ProyeccionSeguroInfraestructura proyeccionSeguroExistenteEnInfraestructura = proyeccionSeguroInfraestructuraRepository.findByInfraestructuraId(proyeccionSeguroInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(proyeccionSeguroExistenteEnInfraestructura == null)) {//SI YA EXISTE UN REGISTRO DE PROYECCION SEGURO PARA LA MISMA INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE PROYECCION SEGURO PARA LA MISMA INFRAESTRUCTURA SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_SEGURO_YA_EXISTE_EN_INFRAESTRUCTURA, false);
           respuestaDTO.setProyeccionSeguroInfraestructuraDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE PROYECCION SEGURO PARA LA MISMA INFRAESTRUCTURA SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionSeguroInfraestructura = proyeccionSeguroInfraestructuraRepository.findMaxIdProyeccionSeguroInfraestructura();
           if (maxIdProyeccionSeguroInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionSeguroInfraestructura = Long.valueOf(0);
           }
           proyeccionSeguroInfraestructuraDTO.setIdProyeccionSeguroInfraestructura(maxIdProyeccionSeguroInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionSeguroInfraestructuraRepository.save(proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructura(proyeccionSeguroInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionSeguroInfraestructuraporId(Long idProyeccionSeguroInfraestructura) {
        Optional<ProyeccionSeguroInfraestructura> proyeccionSeguroInfraestructuraId = proyeccionSeguroInfraestructuraRepository.findByIdProyeccionSeguroInfraestructura(Long.valueOf(idProyeccionSeguroInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionSeguroInfraestructura(ProyeccionSeguroInfraestructuraDTO proyeccionSeguroInfraestructuraDTO) {
        Optional<ProyeccionSeguroInfraestructura> proyeccionSeguroInfraestructuraId = proyeccionSeguroInfraestructuraRepository.findByIdProyeccionSeguroInfraestructura(proyeccionSeguroInfraestructuraDTO.getIdProyeccionSeguroInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (proyeccionSeguroInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionSeguroInfraestructuraId.get().getInfraestructura().getIdInfraestructura())==true) ) {//SI EL ID DE INFRAESTRUCTURA DIGITADO ES IGUAL AL ID DE INFRAESTRUCTURA ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ProyeccionSeguroInfraestructura proyeccionSeguroInfraestructura = proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructura(proyeccionSeguroInfraestructuraDTO);
              proyeccionSeguroInfraestructuraRepository.save(proyeccionSeguroInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (proyeccionSeguroInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionSeguroInfraestructuraId.get().getInfraestructura().getIdInfraestructura())==false) {//SI EL ID DE INFRAESTRUCTURA DIGITADO ES DIFERENTE AL ID DE INFRAESTRUCTURA ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE ID DE INFRAESTRUCTURA DIGITADO EXISTE EN OTROS REGISTROS.
              ProyeccionSeguroInfraestructura proyeccionSeguroExistenteEnInfraestructura = proyeccionSeguroInfraestructuraRepository.findByInfraestructuraId(proyeccionSeguroInfraestructuraDTO.getInfraestructuraDTO().getIdInfraestructura());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaRegistroEncontrado = 0;
              
              if (!(proyeccionSeguroExistenteEnInfraestructura == null)) {//SI ENCONTRO UN REGISTRO DE PROYECCION SEGURO PARA LA MISMA INFRAESTRUCTURA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE RESTRICCIÓN.
                 banderaRegistroEncontrado=1;
              }
              
              if (banderaRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE LA INFRAESTRUCTURA DIGITADA Y BUSCADA ES DIFERENTE DE NULO SIGNIFICA QUE YA EXISTE UN REGISTRO DE PROYECCION SEGURO PARA LA MISMA INFRAESTRUCTURA EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE RESTRICCIÓN.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_SEGURO_NO_MODIFICAR_EN_INFRAESTRUCTURA, false);
                 respuestaDTO.setProyeccionSeguroInfraestructuraDTO(null);
              }
              if (banderaRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE LA INFRAESTRUCTURA DIGITADA ES NULA EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionSeguroInfraestructuraRepository.save(proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructura(proyeccionSeguroInfraestructuraDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionSeguroInfraestructura(Long idProyeccionSeguroInfraestructura) {
        Optional<ProyeccionSeguroInfraestructura> proyeccionSeguroInfraestructuraId = proyeccionSeguroInfraestructuraRepository.findById(idProyeccionSeguroInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionSeguroInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructuraDAO.proyeccionSeguroInfraestructuraDTO(proyeccionSeguroInfraestructuraId.get()));
           proyeccionSeguroInfraestructuraRepository.delete(proyeccionSeguroInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionSeguroInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionSeguroInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
