//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDespejeArtefactoExplosivoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoDespejeArtefactoExplosivoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoDespejeArtefactoExplosivoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeArtefactoExplosivo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDespejeArtefactoExplosivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class TipoDespejeArtefactoExplosivoServiceImpl implements TipoDespejeArtefactoExplosivoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDespejeArtefactoExplosivoDAO tipoDespejeArtefactoExplosivoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDespejeArtefactoExplosivoRepository tipoDespejeArtefactoExplosivoRepository;
    
    //CONTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR REGISTROS.
    public Long contarTotalRegistros(Long idTipoDespejeArtefactoExplosivo, String keyword) {
        return tipoDespejeArtefactoExplosivoRepository.findTotalRegistros(idTipoDespejeArtefactoExplosivo, keyword);
    }
    
    //LISTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoDespejeArtefactoExplosivoDTO> listarTiposDespejesArtefactosExplosivos(Long idTipoDespejeArtefactoExplosivo, String keyword, String orderBy, String orderMode) {
        List<TipoDespejeArtefactoExplosivo> tiposDespejesArtefactosExplosivos = tipoDespejeArtefactoExplosivoRepository.findAllTiposDespejesArtefactosExplosivos(idTipoDespejeArtefactoExplosivo, keyword, orderBy, orderMode);
        List<TipoDespejeArtefactoExplosivoDTO> tipoDespejeArtefactoExplosivoDTOS = new ArrayList<>();
        
        for (TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivo : tiposDespejesArtefactosExplosivos){
            tipoDespejeArtefactoExplosivoDTOS.add(tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivo));
        }
        
        return tipoDespejeArtefactoExplosivoDTOS;
    }
    
    //LISTAR REGISTROS FILTRADOS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoDespejeArtefactoExplosivoDTO> listarTiposDespejesArtefactosExplosivosPag(Pageable pageable, Long idTipoDespejeArtefactoExplosivo, String keyword, String orderBy, String orderMode) {
        Slice<TipoDespejeArtefactoExplosivo> tiposDespejesArtefactosExplosivos = tipoDespejeArtefactoExplosivoRepository.findAllTiposDespejesArtefactosExplosivosPag(pageable, idTipoDespejeArtefactoExplosivo, keyword, orderBy, orderMode);
        return tiposDespejesArtefactosExplosivos.map(tipoDespejeArtefactoExplosivo -> tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivo));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoDespejeArtefactoExplosivo(TipoDespejeArtefactoExplosivoDTO tipoDespejeArtefactoExplosivoDTO) {
        Long maxIdTipoDespejeArtefactoExplosivo=null;
        TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivoNombre = tipoDespejeArtefactoExplosivoRepository.findByNombreTipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO.getNombreTipoDespejeArtefactoExplosivo().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoDespejeArtefactoExplosivoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoDespejeArtefactoExplosivo = tipoDespejeArtefactoExplosivoRepository.findMaxIdTipoDespejeArtefactoExplosivo();
           if (maxIdTipoDespejeArtefactoExplosivo==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoDespejeArtefactoExplosivo=Long.valueOf(0);
           }
           tipoDespejeArtefactoExplosivoDTO.setIdTipoDespejeArtefactoExplosivo(maxIdTipoDespejeArtefactoExplosivo+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoDespejeArtefactoExplosivoRepository.save(tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDespejeArtefactoExplosivoporId(Long idTipoDespejeArtefactoExplosivo) {
        Optional<TipoDespejeArtefactoExplosivo> tipoDespejeArtefactoExplosivoId = tipoDespejeArtefactoExplosivoRepository.findByIdTipoDespejeArtefactoExplosivo(Long.valueOf(idTipoDespejeArtefactoExplosivo));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDespejeArtefactoExplosivoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDespejeArtefactoExplosivoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDespejeArtefactoExplosivoporNombre(String nombreTipoDespejeArtefactoExplosivo) {
        Optional<TipoDespejeArtefactoExplosivo> tipoDespejeArtefactoExplosivoNombre = Optional.ofNullable(tipoDespejeArtefactoExplosivoRepository.findByNombreTipoDespejeArtefactoExplosivo(String.valueOf(nombreTipoDespejeArtefactoExplosivo)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoDespejeArtefactoExplosivoNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivoNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDespejeArtefactoExplosivoNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoDespejeArtefactoExplosivo(TipoDespejeArtefactoExplosivoDTO tipoDespejeArtefactoExplosivoDTO) {
        Optional<TipoDespejeArtefactoExplosivo> tipoDespejeArtefactoExplosivoId = tipoDespejeArtefactoExplosivoRepository.findByIdTipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO.getIdTipoDespejeArtefactoExplosivo());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoDespejeArtefactoExplosivoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoDespejeArtefactoExplosivoDTO.getNombreTipoDespejeArtefactoExplosivo().equals(tipoDespejeArtefactoExplosivoId.get().getNombreTipoDespejeArtefactoExplosivo())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivo = tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO);
              tipoDespejeArtefactoExplosivoRepository.save(tipoDespejeArtefactoExplosivo);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoDespejeArtefactoExplosivoDTO.getNombreTipoDespejeArtefactoExplosivo().equals(tipoDespejeArtefactoExplosivoId.get().getNombreTipoDespejeArtefactoExplosivo())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivoNombre = tipoDespejeArtefactoExplosivoRepository.findByNombreTipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO.getNombreTipoDespejeArtefactoExplosivo().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoDespejeArtefactoExplosivoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoDespejeArtefactoExplosivo tipoDespejeArtefactoExplosivo = tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivo(tipoDespejeArtefactoExplosivoDTO);
                 tipoDespejeArtefactoExplosivoRepository.save(tipoDespejeArtefactoExplosivo);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoDespejeArtefactoExplosivoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoDespejeArtefactoExplosivo(Long idTipoDespejeArtefactoExplosivo) {
        Optional<TipoDespejeArtefactoExplosivo> tipoDespejeArtefactoExplosivoId  = tipoDespejeArtefactoExplosivoRepository.findById(idTipoDespejeArtefactoExplosivo);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDespejeArtefactoExplosivoId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivoDAO.tipoDespejeArtefactoExplosivoDTO(tipoDespejeArtefactoExplosivoId.get()));
           tipoDespejeArtefactoExplosivoRepository.delete(tipoDespejeArtefactoExplosivoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoDespejeArtefactoExplosivoId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDespejeArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
}
