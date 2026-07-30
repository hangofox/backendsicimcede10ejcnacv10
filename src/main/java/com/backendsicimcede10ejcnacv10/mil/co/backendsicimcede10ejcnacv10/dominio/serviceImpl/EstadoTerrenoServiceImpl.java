//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EstadoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.EstadoTerrenoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.EstadoTerrenoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EstadoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EstadoTerrenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class EstadoTerrenoServiceImpl implements EstadoTerrenoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private EstadoTerrenoDAO estadoTerrenoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EstadoTerrenoRepository estadoTerrenoRepository;
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<EstadoTerrenoDTO> listarEstadosTerrenos() {
        List<EstadoTerreno> estadosTerrenos = estadoTerrenoRepository.findAll();
        List<EstadoTerrenoDTO> estadoTerrenoDTOS = new ArrayList<>();
        
        for (EstadoTerreno estadoTerreno : estadosTerrenos){
            estadoTerrenoDTOS.add(estadoTerrenoDAO.estadoTerrenoDTO(estadoTerreno));
        }
        
        return estadoTerrenoDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<EstadoTerrenoDTO> listarEstadosTerrenosOrdenadosporId(Long idEstadoTerreno, String orderBy, String orderMode) {
        List<EstadoTerreno> estadosTerrenos = estadoTerrenoRepository.findAllEstadosTerrenos(idEstadoTerreno, orderBy, orderMode);
        List<EstadoTerrenoDTO> estadoTerrenoDTOS = new ArrayList<>();
        
        for (EstadoTerreno estadoTerreno : estadosTerrenos){
            estadoTerrenoDTOS.add(estadoTerrenoDAO.estadoTerrenoDTO(estadoTerreno));
        }
        
        return estadoTerrenoDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<EstadoTerrenoDTO> listarEstadosTerrenosOrdenadosporIdPag(Pageable pageable, Long idEstadoTerreno, String orderBy, String orderMode) {
        Slice<EstadoTerreno> estadosTerrenos = estadoTerrenoRepository.findAllEstadosTerrenosPag(pageable, idEstadoTerreno, orderBy, orderMode);
        return estadosTerrenos.map(estadoTerreno -> estadoTerrenoDAO.estadoTerrenoDTO(estadoTerreno));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearEstadoTerreno(EstadoTerrenoDTO estadoTerrenoDTO) {
        Long maxIdEstadoTerreno=null;
        EstadoTerreno estadoTerrenoNombre = estadoTerrenoRepository.findByNombreEstadoTerreno(estadoTerrenoDTO.getNombreEstadoTerreno().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(estadoTerrenoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setEstadoTerrenoDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdEstadoTerreno = estadoTerrenoRepository.findMaxIdEstadoTerreno();
           if (maxIdEstadoTerreno==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdEstadoTerreno=Long.valueOf(0);
           }
           estadoTerrenoDTO.setIdEstadoTerreno(maxIdEstadoTerreno+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           estadoTerrenoRepository.save(estadoTerrenoDAO.estadoTerreno(estadoTerrenoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEstadoTerrenoporId(Long idEstadoTerreno) {
        Optional<EstadoTerreno> estadoTerrenoId = estadoTerrenoRepository.findByIdEstadoTerreno(Long.valueOf(idEstadoTerreno));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (estadoTerrenoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setEstadoTerrenoDTO(estadoTerrenoDAO.estadoTerrenoDTO(estadoTerrenoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (estadoTerrenoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEstadoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEstadoTerrenoporNombre(String nombreEstadoTerreno) {
        Optional<EstadoTerreno> estadoTerrenoNombre = Optional.ofNullable(estadoTerrenoRepository.findByNombreEstadoTerreno(String.valueOf(nombreEstadoTerreno)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (estadoTerrenoNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setEstadoTerrenoDTO(estadoTerrenoDAO.estadoTerrenoDTO(estadoTerrenoNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (estadoTerrenoNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setEstadoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarEstadoTerreno(EstadoTerrenoDTO estadoTerrenoDTO) {
        Optional<EstadoTerreno> estadoTerrenoId = estadoTerrenoRepository.findByIdEstadoTerreno(estadoTerrenoDTO.getIdEstadoTerreno());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (estadoTerrenoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (estadoTerrenoDTO.getNombreEstadoTerreno().equals(estadoTerrenoId.get().getNombreEstadoTerreno())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              EstadoTerreno estadoTerreno = estadoTerrenoDAO.estadoTerreno(estadoTerrenoDTO);
              estadoTerrenoRepository.save(estadoTerreno);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (estadoTerrenoDTO.getNombreEstadoTerreno().equals(estadoTerrenoId.get().getNombreEstadoTerreno())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              EstadoTerreno estadoTerrenoNombre = estadoTerrenoRepository.findByNombreEstadoTerreno(estadoTerrenoDTO.getNombreEstadoTerreno().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(estadoTerrenoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setEstadoTerrenoDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 EstadoTerreno estadoTerreno = estadoTerrenoDAO.estadoTerreno(estadoTerrenoDTO);
                 estadoTerrenoRepository.save(estadoTerreno);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (estadoTerrenoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setEstadoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarEstadoTerreno(Long idEstadoTerreno) {
        Optional<EstadoTerreno> estadoTerrenoId  = estadoTerrenoRepository.findById(idEstadoTerreno);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (estadoTerrenoId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setEstadoTerrenoDTO(estadoTerrenoDAO.estadoTerrenoDTO(estadoTerrenoId.get()));
           estadoTerrenoRepository.delete(estadoTerrenoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (estadoTerrenoId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEstadoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
}
