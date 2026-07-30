//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CargoIntegranteDocumentosDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CargoIntegranteDocumentosService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CargoIntegranteDocumentosDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CargoIntegranteDocumentos;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CargoIntegranteDocumentosRepository;
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
public class CargoIntegranteDocumentosServiceImpl implements CargoIntegranteDocumentosService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CargoIntegranteDocumentosDAO cargoIntegranteDocumentosDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CargoIntegranteDocumentosRepository cargoIntegranteDocumentosRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCargoIntegranteDocumentos, String keyword) {
        return cargoIntegranteDocumentosRepository.findTotalRegistros(idCargoIntegranteDocumentos, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CargoIntegranteDocumentosDTO> listarCargosIntegrantesDocumentos(Long idCargoIntegranteDocumentos, String keyword, String orderBy, String orderMode) {
        List<CargoIntegranteDocumentos> cargosIntegrantesDocumentos = cargoIntegranteDocumentosRepository.findAllCargosIntegrantesDocumentos(idCargoIntegranteDocumentos, keyword, orderBy, orderMode);
        List<CargoIntegranteDocumentosDTO> cargoIntegranteDocumentosDTOS = new ArrayList<>();
        
        for (CargoIntegranteDocumentos cargoIntegranteDocumentos : cargosIntegrantesDocumentos){
            cargoIntegranteDocumentosDTOS.add(cargoIntegranteDocumentosDAO.cargoIntegranteDocumentosDTO(cargoIntegranteDocumentos));
        }
        
        return cargoIntegranteDocumentosDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<CargoIntegranteDocumentosDTO> listarCargosIntegrantesDocumentosPag(Pageable pageable, Long idCargoIntegranteDocumentos, String keyword, String orderBy, String orderMode) {
        Slice<CargoIntegranteDocumentos> cargosIntegrantesDocumentos = cargoIntegranteDocumentosRepository.findAllCargosIntegrantesDocumentosPag(pageable, idCargoIntegranteDocumentos, keyword, orderBy, orderMode);
        return cargosIntegrantesDocumentos.map(cargoIntegranteDocumentos -> cargoIntegranteDocumentosDAO.cargoIntegranteDocumentosDTO(cargoIntegranteDocumentos));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCargoIntegranteDocumentos(CargoIntegranteDocumentosDTO cargoIntegranteDocumentosDTO) {
        Long maxIdCargoIntegranteDocumentos=null;
        CargoIntegranteDocumentos cargoIntegranteDocumentosNombre = cargoIntegranteDocumentosRepository.findByNombreCargoIntegranteDocumentos(cargoIntegranteDocumentosDTO.getNombreCargoIntegranteDocumentos().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(cargoIntegranteDocumentosNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setCargoIntegranteDocumentosDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdCargoIntegranteDocumentos = cargoIntegranteDocumentosRepository.findMaxIdCargoIntegranteDocumentos();
           if (maxIdCargoIntegranteDocumentos==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdCargoIntegranteDocumentos=Long.valueOf(0);
           }
           cargoIntegranteDocumentosDTO.setIdCargoIntegranteDocumentos(maxIdCargoIntegranteDocumentos+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           cargoIntegranteDocumentosRepository.save(cargoIntegranteDocumentosDAO.cargoIntegranteDocumentos(cargoIntegranteDocumentosDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCargoIntegranteDocumentosporId(Long idCargoIntegranteDocumentos) {
        Optional<CargoIntegranteDocumentos> cargoIntegranteDocumentosId = cargoIntegranteDocumentosRepository.findByIdCargoIntegranteDocumentos(Long.valueOf(idCargoIntegranteDocumentos));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (cargoIntegranteDocumentosId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCargoIntegranteDocumentosDTO(cargoIntegranteDocumentosDAO.cargoIntegranteDocumentosDTO(cargoIntegranteDocumentosId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (cargoIntegranteDocumentosId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCargoIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCargoIntegranteDocumentosporNombre(String nombreCargoIntegranteDocumentos) {
        Optional<CargoIntegranteDocumentos> cargoIntegranteDocumentosNombre = Optional.ofNullable(cargoIntegranteDocumentosRepository.findByNombreCargoIntegranteDocumentos(String.valueOf(nombreCargoIntegranteDocumentos)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (cargoIntegranteDocumentosNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setCargoIntegranteDocumentosDTO(cargoIntegranteDocumentosDAO.cargoIntegranteDocumentosDTO(cargoIntegranteDocumentosNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (cargoIntegranteDocumentosNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setCargoIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCargoIntegranteDocumentos(CargoIntegranteDocumentosDTO cargoIntegranteDocumentosDTO) {
        Optional<CargoIntegranteDocumentos> cargoIntegranteDocumentosId = cargoIntegranteDocumentosRepository.findByIdCargoIntegranteDocumentos(cargoIntegranteDocumentosDTO.getIdCargoIntegranteDocumentos());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (cargoIntegranteDocumentosId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (cargoIntegranteDocumentosDTO.getNombreCargoIntegranteDocumentos().equals(cargoIntegranteDocumentosId.get().getNombreCargoIntegranteDocumentos())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              CargoIntegranteDocumentos cargoIntegranteDocumentos = cargoIntegranteDocumentosDAO.cargoIntegranteDocumentos(cargoIntegranteDocumentosDTO);
              cargoIntegranteDocumentosRepository.save(cargoIntegranteDocumentos);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (cargoIntegranteDocumentosDTO.getNombreCargoIntegranteDocumentos().equals(cargoIntegranteDocumentosId.get().getNombreCargoIntegranteDocumentos())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              CargoIntegranteDocumentos cargoIntegranteDocumentosNombre = cargoIntegranteDocumentosRepository.findByNombreCargoIntegranteDocumentos(cargoIntegranteDocumentosDTO.getNombreCargoIntegranteDocumentos().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(cargoIntegranteDocumentosNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setCargoIntegranteDocumentosDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 CargoIntegranteDocumentos cargoIntegranteDocumentos = cargoIntegranteDocumentosDAO.cargoIntegranteDocumentos(cargoIntegranteDocumentosDTO);
                 cargoIntegranteDocumentosRepository.save(cargoIntegranteDocumentos);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (cargoIntegranteDocumentosId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCargoIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCargoIntegranteDocumentos(Long idCargoIntegranteDocumentos) {
        Optional<CargoIntegranteDocumentos> cargoIntegranteDocumentosId  = cargoIntegranteDocumentosRepository.findById(idCargoIntegranteDocumentos);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (cargoIntegranteDocumentosId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCargoIntegranteDocumentosDTO(cargoIntegranteDocumentosDAO.cargoIntegranteDocumentosDTO(cargoIntegranteDocumentosId.get()));
           cargoIntegranteDocumentosRepository.delete(cargoIntegranteDocumentosId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (cargoIntegranteDocumentosId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCargoIntegranteDocumentosDTO(null);
        }
        
        return respuestaDTO;
    }
}
