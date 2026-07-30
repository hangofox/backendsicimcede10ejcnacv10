//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EstadoDiagnosticoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.EstadoDiagnosticoEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.EstadoDiagnosticoEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoDiagnosticoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EstadoDiagnosticoEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class EstadoDiagnosticoEquipoIngenieroServiceImpl implements EstadoDiagnosticoEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private EstadoDiagnosticoEquipoIngenieroDAO estadoDiagnosticoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EstadoDiagnosticoEquipoIngenieroRepository estadoDiagnosticoEquipoIngenieroRepository;
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<EstadoDiagnosticoEquipoIngenieroDTO> listarEstadosDiagnosticosEquiposIngenieros() {
        List<EstadoDiagnosticoEquipoIngeniero> estadosDiagnosticosEquiposIngenieros = estadoDiagnosticoEquipoIngenieroRepository.findAll();
        List<EstadoDiagnosticoEquipoIngenieroDTO> estadoDiagnosticoEquipoIngenieroDTOS = new ArrayList<>();
        
        for (EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero : estadosDiagnosticosEquiposIngenieros){
            estadoDiagnosticoEquipoIngenieroDTOS.add(estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngeniero));
        }
        
        return estadoDiagnosticoEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS POR ID DE FORMA ASCENDENTE O DESCENDENTE:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<EstadoDiagnosticoEquipoIngenieroDTO> listarEstadosDiagnosticosEquiposIngenieros(Long idEstadoDiagnosticoEquipoIngeniero, String orderBy, String orderMode) {
        List<EstadoDiagnosticoEquipoIngeniero> estadosDiagnosticosEquiposIngenieros = estadoDiagnosticoEquipoIngenieroRepository.findAllEstadosDiagnosticosEquiposIngenieros(idEstadoDiagnosticoEquipoIngeniero, orderBy, orderMode);
        List<EstadoDiagnosticoEquipoIngenieroDTO> estadoDiagnosticoEquipoIngenieroDTOS = new ArrayList<>();
        
        for (EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero : estadosDiagnosticosEquiposIngenieros){
            estadoDiagnosticoEquipoIngenieroDTOS.add(estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngeniero));
        }
        
        return estadoDiagnosticoEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<EstadoDiagnosticoEquipoIngenieroDTO> listarEstadosDiagnosticosEquiposIngenierosPag(Pageable pageable, Long idEstadoDiagnosticoEquipoIngeniero, String orderBy, String orderMode) {
        Slice<EstadoDiagnosticoEquipoIngeniero> estadosDiagnosticosEquiposIngenieros = estadoDiagnosticoEquipoIngenieroRepository.findAllEstadosDiagnosticosEquiposIngenierosPag(pageable, idEstadoDiagnosticoEquipoIngeniero, orderBy, orderMode);
        return estadosDiagnosticosEquiposIngenieros.map(estadoDiagnosticoEquipoIngeniero -> estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearEstadoDiagnosticoEquipoIngeniero(EstadoDiagnosticoEquipoIngenieroDTO estadoDiagnosticoEquipoIngenieroDTO) {
        Long maxIdEstadoDiagnosticoEquipoIngeniero=null;
        EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngenieroNombre = estadoDiagnosticoEquipoIngenieroRepository.findByNombreEstadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO.getNombreEstadoDiagnosticoEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(estadoDiagnosticoEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdEstadoDiagnosticoEquipoIngeniero = estadoDiagnosticoEquipoIngenieroRepository.findMaxIdEstadoDiagnosticoEquipoIngeniero();
           if (maxIdEstadoDiagnosticoEquipoIngeniero==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdEstadoDiagnosticoEquipoIngeniero=Long.valueOf(0);
           }
           estadoDiagnosticoEquipoIngenieroDTO.setIdEstadoDiagnosticoEquipoIngeniero(maxIdEstadoDiagnosticoEquipoIngeniero+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           estadoDiagnosticoEquipoIngenieroRepository.save(estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEstadoDiagnosticoEquipoIngenieroporId(Long idEstadoDiagnosticoEquipoIngeniero) {
        Optional<EstadoDiagnosticoEquipoIngeniero> estadoDiagnosticoEquipoIngenieroId = estadoDiagnosticoEquipoIngenieroRepository.findByIdEstadoDiagnosticoEquipoIngeniero(Long.valueOf(idEstadoDiagnosticoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (estadoDiagnosticoEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (estadoDiagnosticoEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEstadoDiagnosticoEquipoIngenieroporNombre(String nombreEstadoDiagnosticoEquipoIngeniero) {
        Optional<EstadoDiagnosticoEquipoIngeniero> estadoDiagnosticoEquipoIngenieroNombre = Optional.ofNullable(estadoDiagnosticoEquipoIngenieroRepository.findByNombreEstadoDiagnosticoEquipoIngeniero(String.valueOf(nombreEstadoDiagnosticoEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (estadoDiagnosticoEquipoIngenieroNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (estadoDiagnosticoEquipoIngenieroNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarEstadoDiagnosticoEquipoIngeniero(EstadoDiagnosticoEquipoIngenieroDTO estadoDiagnosticoEquipoIngenieroDTO) {
        Optional<EstadoDiagnosticoEquipoIngeniero> estadoDiagnosticoEquipoIngenieroId = estadoDiagnosticoEquipoIngenieroRepository.findByIdEstadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO.getIdEstadoDiagnosticoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (estadoDiagnosticoEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (estadoDiagnosticoEquipoIngenieroDTO.getNombreEstadoDiagnosticoEquipoIngeniero().equals(estadoDiagnosticoEquipoIngenieroId.get().getNombreEstadoDiagnosticoEquipoIngeniero())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero = estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO);
              estadoDiagnosticoEquipoIngenieroRepository.save(estadoDiagnosticoEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (estadoDiagnosticoEquipoIngenieroDTO.getNombreEstadoDiagnosticoEquipoIngeniero().equals(estadoDiagnosticoEquipoIngenieroId.get().getNombreEstadoDiagnosticoEquipoIngeniero())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngenieroNombre = estadoDiagnosticoEquipoIngenieroRepository.findByNombreEstadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO.getNombreEstadoDiagnosticoEquipoIngeniero().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(estadoDiagnosticoEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 EstadoDiagnosticoEquipoIngeniero estadoDiagnosticoEquipoIngeniero = estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngeniero(estadoDiagnosticoEquipoIngenieroDTO);
                 estadoDiagnosticoEquipoIngenieroRepository.save(estadoDiagnosticoEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (estadoDiagnosticoEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarEstadoDiagnosticoEquipoIngeniero(Long idEstadoDiagnosticoEquipoIngeniero) {
        Optional<EstadoDiagnosticoEquipoIngeniero> estadoDiagnosticoEquipoIngenieroId  = estadoDiagnosticoEquipoIngenieroRepository.findById(idEstadoDiagnosticoEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (estadoDiagnosticoEquipoIngenieroId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngenieroDAO.estadoDiagnosticoEquipoIngenieroDTO(estadoDiagnosticoEquipoIngenieroId.get()));
           estadoDiagnosticoEquipoIngenieroRepository.delete(estadoDiagnosticoEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (estadoDiagnosticoEquipoIngenieroId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEstadoDiagnosticoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
