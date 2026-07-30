//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CapituloInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CapituloInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CapituloInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CapituloInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CapituloInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class CapituloInfraestructuraServiceImpl implements CapituloInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CapituloInfraestructuraDAO capituloInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CapituloInfraestructuraRepository capituloInfraestructuraRepository;
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CapituloInfraestructuraDTO> listarCapitulosInfraestructuras() {
        List<CapituloInfraestructura> capitulosInfraestructuras = capituloInfraestructuraRepository.findAll();
        List<CapituloInfraestructuraDTO> capituloInfraestructuraDTOS = new ArrayList<>();
        
        for (CapituloInfraestructura capituloInfraestructura : capitulosInfraestructuras){
            capituloInfraestructuraDTOS.add(capituloInfraestructuraDAO.capituloInfraestructuraDTO(capituloInfraestructura));
        }
        
        return capituloInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CapituloInfraestructuraDTO> listarCapitulosInfraestructurasOrdenadosporId(String orderMode) {
        List<CapituloInfraestructura> capitulosInfraestructuras = capituloInfraestructuraRepository.findAllCapitulosInfraestructurasOrderedById(orderMode);
        List<CapituloInfraestructuraDTO> capituloInfraestructuraDTOS = new ArrayList<>();
        
        for (CapituloInfraestructura capituloInfraestructura : capitulosInfraestructuras){
            capituloInfraestructuraDTOS.add(capituloInfraestructuraDAO.capituloInfraestructuraDTO(capituloInfraestructura));
        }
        
        return capituloInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS ORDENADOS POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<CapituloInfraestructuraDTO> listarCapitulosInfraestructurasOrdenadosporIdPag(Pageable pageable, String orderMode) {
        Slice<CapituloInfraestructura> capitulosInfraestructuras = capituloInfraestructuraRepository.findAllCapitulosInfraestructurasOrderedByIdPag(pageable, orderMode);
        return capitulosInfraestructuras.map(capituloInfraestructura -> capituloInfraestructuraDAO.capituloInfraestructuraDTO(capituloInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCapituloInfraestructura(CapituloInfraestructuraDTO capituloInfraestructuraDTO) {
        Long maxIdCapituloInfraestructura=null;
        CapituloInfraestructura capituloInfraestructuraNombre = capituloInfraestructuraRepository.findByNombreCapituloInfraestructura(capituloInfraestructuraDTO.getNombreCapituloInfraestructura().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(capituloInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setCapituloInfraestructuraDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdCapituloInfraestructura = capituloInfraestructuraRepository.findMaxIdCapituloInfraestructura();
           if (maxIdCapituloInfraestructura==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdCapituloInfraestructura=Long.valueOf(0);
           }
           capituloInfraestructuraDTO.setIdCapituloInfraestructura(maxIdCapituloInfraestructura+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.

           capituloInfraestructuraRepository.save(capituloInfraestructuraDAO.capituloInfraestructura(capituloInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCapituloInfraestructuraporId(Long idCapituloInfraestructura) {
        Optional<CapituloInfraestructura> capituloInfraestructuraId = capituloInfraestructuraRepository.findByIdCapituloInfraestructura(Long.valueOf(idCapituloInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (capituloInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCapituloInfraestructuraDTO(capituloInfraestructuraDAO.capituloInfraestructuraDTO(capituloInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (capituloInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCapituloInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCapituloInfraestructuraporNombre(String nombreCapituloInfraestructura) {
        Optional<CapituloInfraestructura> capituloInfraestructuraNombre = Optional.ofNullable(capituloInfraestructuraRepository.findByNombreCapituloInfraestructura(String.valueOf(nombreCapituloInfraestructura)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (capituloInfraestructuraNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setCapituloInfraestructuraDTO(capituloInfraestructuraDAO.capituloInfraestructuraDTO(capituloInfraestructuraNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (capituloInfraestructuraNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setCapituloInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCapituloInfraestructura(CapituloInfraestructuraDTO capituloInfraestructuraDTO) {
        Optional<CapituloInfraestructura> capituloInfraestructuraId = capituloInfraestructuraRepository.findByIdCapituloInfraestructura(capituloInfraestructuraDTO.getIdCapituloInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (capituloInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (capituloInfraestructuraDTO.getNombreCapituloInfraestructura().equals(capituloInfraestructuraId.get().getNombreCapituloInfraestructura())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              CapituloInfraestructura capituloInfraestructura = capituloInfraestructuraDAO.capituloInfraestructura(capituloInfraestructuraDTO);
              capituloInfraestructuraRepository.save(capituloInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (capituloInfraestructuraDTO.getNombreCapituloInfraestructura().equals(capituloInfraestructuraId.get().getNombreCapituloInfraestructura())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              CapituloInfraestructura capituloInfraestructuraNombre = capituloInfraestructuraRepository.findByNombreCapituloInfraestructura(capituloInfraestructuraDTO.getNombreCapituloInfraestructura().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(capituloInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setCapituloInfraestructuraDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 CapituloInfraestructura capituloInfraestructura = capituloInfraestructuraDAO.capituloInfraestructura(capituloInfraestructuraDTO);
                 capituloInfraestructuraRepository.save(capituloInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (capituloInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCapituloInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCapituloInfraestructura(Long idCapituloInfraestructura) {
        Optional<CapituloInfraestructura> capituloInfraestructuraId = capituloInfraestructuraRepository.findById(idCapituloInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (capituloInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCapituloInfraestructuraDTO(capituloInfraestructuraDAO.capituloInfraestructuraDTO(capituloInfraestructuraId.get()));
           capituloInfraestructuraRepository.delete(capituloInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (capituloInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCapituloInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
