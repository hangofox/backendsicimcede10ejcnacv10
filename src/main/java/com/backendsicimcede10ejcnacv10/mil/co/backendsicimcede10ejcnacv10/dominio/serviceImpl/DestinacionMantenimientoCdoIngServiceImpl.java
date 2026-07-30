//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.DestinacionMantenimientoCdoIngDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.DestinacionMantenimientoCdoIngService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.DestinacionMantenimientoCdoIngDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.DestinacionMantenimientoCdoIng;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.DestinacionMantenimientoCdoIngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/12/2025.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class DestinacionMantenimientoCdoIngServiceImpl implements DestinacionMantenimientoCdoIngService {
    
    @Autowired//INYECTAMOS EL DAO.
    private DestinacionMantenimientoCdoIngDAO destinacionMantenimientoCdoIngDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private DestinacionMantenimientoCdoIngRepository destinacionMantenimientoCdoIngRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idDestinacionMantenimientoCdoIng, String keyword) {
        return destinacionMantenimientoCdoIngRepository.findTotalRegistros(idDestinacionMantenimientoCdoIng, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<DestinacionMantenimientoCdoIngDTO> listarDestinacionesMantenimientosCdosIng(Long idDestinacionMantenimientoCdoIng, String keyword, String orderBy, String orderMode) {
        List<DestinacionMantenimientoCdoIng> destinacionesMantenimientosCdosIng = destinacionMantenimientoCdoIngRepository.findAllDestinacionesMantenimientosCdosIng(idDestinacionMantenimientoCdoIng, keyword, orderBy, orderMode);
        List<DestinacionMantenimientoCdoIngDTO> destinacionMantenimientoCdoIngDTOS = new ArrayList<>();
        
        for (DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIng : destinacionesMantenimientosCdosIng){
            destinacionMantenimientoCdoIngDTOS.add(destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIng));
        }
        
        return destinacionMantenimientoCdoIngDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<DestinacionMantenimientoCdoIngDTO> listarDestinacionesMantenimientosCdosIngOrdenadosporIdPag(Pageable pageable, Long idDestinacionMantenimientoCdoIng, String keyword, String orderBy, String orderMode) {
        Slice<DestinacionMantenimientoCdoIng> destinacionesMantenimientosCdosIng = destinacionMantenimientoCdoIngRepository.findAllDestinacionesMantenimientosCdosIngOrdenadosporIdPag(pageable, idDestinacionMantenimientoCdoIng, keyword, orderBy, orderMode);
        return destinacionesMantenimientosCdosIng.map(destinacionMantenimientoCdoIng -> destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIng));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearDestinacionMantenimientoCdoIng(DestinacionMantenimientoCdoIngDTO destinacionMantenimientoCdoIngDTO) {
        Long maxIdDestinacionMantenimientoCdoIng=null;
        DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIngNombre = destinacionMantenimientoCdoIngRepository.findByNombreDestinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO.getNombreDestinacionMantenimientoCdoIng().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(destinacionMantenimientoCdoIngNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdDestinacionMantenimientoCdoIng = destinacionMantenimientoCdoIngRepository.findMaxIdDestinacionMantenimientoCdoIng();
           if (maxIdDestinacionMantenimientoCdoIng==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdDestinacionMantenimientoCdoIng=Long.valueOf(0);
           }
           destinacionMantenimientoCdoIngDTO.setIdDestinacionMantenimientoCdoIng(maxIdDestinacionMantenimientoCdoIng+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           destinacionMantenimientoCdoIngRepository.save(destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDestinacionMantenimientoCdoIngporId(Long idDestinacionMantenimientoCdoIng) {
        Optional<DestinacionMantenimientoCdoIng> destinacionMantenimientoCdoIngId = destinacionMantenimientoCdoIngRepository.findByIdDestinacionMantenimientoCdoIng(Long.valueOf(idDestinacionMantenimientoCdoIng));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (destinacionMantenimientoCdoIngId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIngId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (destinacionMantenimientoCdoIngId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarDestinacionMantenimientoCdoIngporNombre(String nombreDestinacionMantenimientoCdoIng) {
        Optional<DestinacionMantenimientoCdoIng> destinacionMantenimientoCdoIngNombre = Optional.ofNullable(destinacionMantenimientoCdoIngRepository.findByNombreDestinacionMantenimientoCdoIng(String.valueOf(nombreDestinacionMantenimientoCdoIng)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (destinacionMantenimientoCdoIngNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIngNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (destinacionMantenimientoCdoIngNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarDestinacionMantenimientoCdoIng(DestinacionMantenimientoCdoIngDTO destinacionMantenimientoCdoIngDTO) {
        Optional<DestinacionMantenimientoCdoIng> destinacionMantenimientoCdoIngId = destinacionMantenimientoCdoIngRepository.findByIdDestinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO.getIdDestinacionMantenimientoCdoIng());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (destinacionMantenimientoCdoIngId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (destinacionMantenimientoCdoIngDTO.getNombreDestinacionMantenimientoCdoIng().equals(destinacionMantenimientoCdoIngId.get().getNombreDestinacionMantenimientoCdoIng())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIng = destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO);
              destinacionMantenimientoCdoIngRepository.save(destinacionMantenimientoCdoIng);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (destinacionMantenimientoCdoIngDTO.getNombreDestinacionMantenimientoCdoIng().equals(destinacionMantenimientoCdoIngId.get().getNombreDestinacionMantenimientoCdoIng())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIngNombre = destinacionMantenimientoCdoIngRepository.findByNombreDestinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO.getNombreDestinacionMantenimientoCdoIng().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(destinacionMantenimientoCdoIngNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setDestinacionMantenimientoCdoIngDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 DestinacionMantenimientoCdoIng destinacionMantenimientoCdoIng = destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIng(destinacionMantenimientoCdoIngDTO);
                 destinacionMantenimientoCdoIngRepository.save(destinacionMantenimientoCdoIng);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (destinacionMantenimientoCdoIngId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarDestinacionMantenimientoCdoIng(Long idDestinacionMantenimientoCdoIng) {
        Optional<DestinacionMantenimientoCdoIng> destinacionMantenimientoCdoIngId  = destinacionMantenimientoCdoIngRepository.findById(idDestinacionMantenimientoCdoIng);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (destinacionMantenimientoCdoIngId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIngDAO.destinacionMantenimientoCdoIngDTO(destinacionMantenimientoCdoIngId.get()));
           destinacionMantenimientoCdoIngRepository.delete(destinacionMantenimientoCdoIngId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (destinacionMantenimientoCdoIngId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setDestinacionMantenimientoCdoIngDTO(null);
        }
        
        return respuestaDTO;
    }
}
