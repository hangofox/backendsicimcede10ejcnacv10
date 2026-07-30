//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.GradoSiathDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.GradoSiathService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.GradoSiathDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.GradoSiath;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.GradoSiathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class GradoSiathServiceImpl implements GradoSiathService {
    
    @Autowired//INYECTAMOS EL DAO.
    private GradoSiathDAO gradoSiathDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private GradoSiathRepository gradoSiathRepository;
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<GradoSiathDTO> listarGradosSiath() {
        List<GradoSiath> gradosSiath = gradoSiathRepository.findAll();
        List<GradoSiathDTO> gradoSiathDTOS = new ArrayList<>();
        
        for (GradoSiath gradoSiath : gradosSiath){
            gradoSiathDTOS.add(gradoSiathDAO.gradoSiathDTO(gradoSiath));
        }
        
        return gradoSiathDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<GradoSiathDTO> listarGradosSiath(Long idGradoSiath, String orderBy, String orderMode) {
        List<GradoSiath> gradosSiath = gradoSiathRepository.findAllGradosSiath(idGradoSiath, orderBy, orderMode);
        List<GradoSiathDTO> gradoSiathDTOS = new ArrayList<>();
        
        for (GradoSiath gradoSiath : gradosSiath){
            gradoSiathDTOS.add(gradoSiathDAO.gradoSiathDTO(gradoSiath));
        }
        
        return gradoSiathDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS ORDENADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<GradoSiathDTO> listarGradosSiathPag(Pageable pageable, Long idGradoSiath, String orderBy, String orderMode) {
        Slice<GradoSiath> gradosSiath = gradoSiathRepository.findAllGradosSiathPag(pageable, idGradoSiath, orderBy, orderMode);
        return gradosSiath.map(gradoSiath -> gradoSiathDAO.gradoSiathDTO(gradoSiath));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearGradoSiath(GradoSiathDTO gradoSiathDTO) {
        Long maxIdGradoSiath=null;
        GradoSiath gradoSiathNombre = gradoSiathRepository.findByNombreGradoSiathAndFuerzaSiath(gradoSiathDTO.getNombreGradoSiath().toUpperCase(), Long.valueOf(gradoSiathDTO.getFuerzaSiath()));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(gradoSiathNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE Y FUERZA SIATH PROPORCIONADOS.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE Y FUERZA SIATH PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setGradoSiathDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdGradoSiath = gradoSiathRepository.findMaxIdGradoSiath();
           if (maxIdGradoSiath==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdGradoSiath=Long.valueOf(0);
           }
           gradoSiathDTO.setIdGradoSiath(maxIdGradoSiath+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           gradoSiathRepository.save(gradoSiathDAO.gradoSiath(gradoSiathDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarGradoSiathporId(Long idGradoSiath) {
        Optional<GradoSiath> gradoSiathId = gradoSiathRepository.findByIdGradoSiath(Long.valueOf(idGradoSiath));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (gradoSiathId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setGradoSiathDTO(gradoSiathDAO.gradoSiathDTO(gradoSiathId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (gradoSiathId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setGradoSiathDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y FUERZA SIATH:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarGradoSiathporNombreyFuerzaSiath(String nombreGradoSiath, Long fuerzaSiath) {
        Optional<GradoSiath> gradoSiathNombre = Optional.ofNullable(gradoSiathRepository.findByNombreGradoSiathAndFuerzaSiath(String.valueOf(nombreGradoSiath), fuerzaSiath));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (gradoSiathNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE Y FUERZA SIATH PROPORCIONADOS.
           respuestaDTO.setGradoSiathDTO(gradoSiathDAO.gradoSiathDTO(gradoSiathNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (gradoSiathNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE Y FUERZA SIATH PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setGradoSiathDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarGradoSiath(GradoSiathDTO gradoSiathDTO) {
        Optional<GradoSiath> gradoSiathId = gradoSiathRepository.findByIdGradoSiath(gradoSiathDTO.getIdGradoSiath());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (gradoSiathId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (gradoSiathDTO.getNombreGradoSiath().equals(gradoSiathId.get().getNombreGradoSiath())==true) ) {//SI EL NOMBRE Y FUERZA SIATH DIGITADOS SON IGUALES AL NOMBRE Y FUERZA SIATH ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              GradoSiath gradoSiath = gradoSiathDAO.gradoSiath(gradoSiathDTO);
              gradoSiathRepository.save(gradoSiath);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (gradoSiathDTO.getNombreGradoSiath().equals(gradoSiathId.get().getNombreGradoSiath())==false) {//SI EL NOMBRE Y FUERZA SIATH DIGITADOS SON DIFERENTES A LOS NOMBRES Y FUERZA SIATH ALMACENADOS EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE Y FUERZA SIATH DIGITADOS EXISTEN EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              GradoSiath gradoSiathNombre = gradoSiathRepository.findByNombreGradoSiathAndFuerzaSiath(gradoSiathDTO.getNombreGradoSiath().toUpperCase(), Long.valueOf(gradoSiathDTO.getFuerzaSiath()));
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(gradoSiathNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE Y FUERZA SIATH PROPORCIONADOS.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setGradoSiathDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 GradoSiath gradoSiath = gradoSiathDAO.gradoSiath(gradoSiathDTO);
                 gradoSiathRepository.save(gradoSiath);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (gradoSiathId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setGradoSiathDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarGradoSiath(Long idGradoSiath) {
        Optional<GradoSiath> gradoSiathId = gradoSiathRepository.findById(idGradoSiath);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (gradoSiathId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setGradoSiathDTO(gradoSiathDAO.gradoSiathDTO(gradoSiathId.get()));
           gradoSiathRepository.delete(gradoSiathId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (gradoSiathId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setGradoSiathDTO(null);
        }
        
        return respuestaDTO;
    }
}
