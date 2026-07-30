//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoActividadExpEquipHerrYPerrDispArtefExpDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoActividadExpEquipHerrYPerrDispArtefExpService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoActividadExpEquipHerrYPerrDispArtefExpDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoActividadExpEquipHerrYPerrDispArtefExp;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoActividadExpEquipHerrYPerrDispArtefExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
public class TipoActividadExpEquipHerrYPerrDispArtefExpServiceImpl implements TipoActividadExpEquipHerrYPerrDispArtefExpService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoActividadExpEquipHerrYPerrDispArtefExpDAO tipoActividadExpEquipHerrYPerrDispArtefExpDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoActividadExpEquipHerrYPerrDispArtefExpRepository tipoActividadExpEquipHerrYPerrDispArtefExpRepository;
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS (CON FILTROS OPCIONALES POR KEYWORD/ID DE TIPO ACTIVIDAD):
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idTipoActividadExpEquipHerrYPerrDispArtefExp, String keyword) {
        return tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findTotalRegistros(idTipoActividadExpEquipHerrYPerrDispArtefExp, keyword);
    }
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    //LISTAR REGISTROS (CON FILTROS OPCIONALES POR KEYWORD/ID DE TIPO ACTIVIDAD):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoActividadExpEquipHerrYPerrDispArtefExpDTO> listarTiposActividadesExpEquipHerrYPerrDispArtefExp(Long idTipoActividadExpEquipHerrYPerrDispArtefExp, String keyword, String orderBy, String orderMode) {
        List<TipoActividadExpEquipHerrYPerrDispArtefExp> tiposActividadesExpEquipHerrYPerrDispArtefExp = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findAllTiposActividadesExpEquipHerrYPerrDispArtefExp(idTipoActividadExpEquipHerrYPerrDispArtefExp, keyword, orderBy, orderMode);
        List<TipoActividadExpEquipHerrYPerrDispArtefExpDTO> tipoActividadExpEquipHerrYPerrDispArtefExpDTOS = new ArrayList<>();
        
        for (TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExp : tiposActividadesExpEquipHerrYPerrDispArtefExp){
            tipoActividadExpEquipHerrYPerrDispArtefExpDTOS.add(tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExp));
        }
        
        return tipoActividadExpEquipHerrYPerrDispArtefExpDTOS;
    }
    
    //LISTAR REGISTROS CON PAGINACIÓN (CON FILTROS OPCIONALES POR KEYWORD/ID DE TIPO ACTIVIDAD):
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<TipoActividadExpEquipHerrYPerrDispArtefExpDTO> listarTiposActividadesExpEquipHerrYPerrDispArtefExpPag(Pageable pageable, Long idTipoActividadExpEquipHerrYPerrDispArtefExp, String keyword, String orderBy, String orderMode) {
        Slice<TipoActividadExpEquipHerrYPerrDispArtefExp> tiposActividadesExpEquipHerrYPerrDispArtefExp = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findAllTiposActividadesExpEquipHerrYPerrDispArtefExpPag(pageable, idTipoActividadExpEquipHerrYPerrDispArtefExp, keyword, orderBy, orderMode);
        return tiposActividadesExpEquipHerrYPerrDispArtefExp.map(tipoActividadExpEquipHerrYPerrDispArtefExp -> tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExp));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoActividadExpEquipHerrYPerrDispArtefExp(TipoActividadExpEquipHerrYPerrDispArtefExpDTO tipoActividadExpEquipHerrYPerrDispArtefExpDTO) {
        Long maxIdTipoActividadExpEquipHerrYPerrDispArtefExp=null;
        TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExpNombre = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findByNombreTipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO.getNombreTipoActividadExpEquipHerrYPerrDispArtefExp().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoActividadExpEquipHerrYPerrDispArtefExpNombre ==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoActividadExpEquipHerrYPerrDispArtefExp = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findMaxIdTipoActividadExpEquipHerrYPerrDispArtefExp();
           if (maxIdTipoActividadExpEquipHerrYPerrDispArtefExp==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoActividadExpEquipHerrYPerrDispArtefExp=Long.valueOf(0);
           }
           tipoActividadExpEquipHerrYPerrDispArtefExpDTO.setIdTipoActividadExpEquipHerrYPerrDispArtefExp(maxIdTipoActividadExpEquipHerrYPerrDispArtefExp+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoActividadExpEquipHerrYPerrDispArtefExpRepository.save(tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoActividadExpEquipHerrYPerrDispArtefExpporId(Long idTipoActividadExpEquipHerrYPerrDispArtefExp) {
        Optional<TipoActividadExpEquipHerrYPerrDispArtefExp> tipoActividadExpEquipHerrYPerrDispArtefExpId = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findByIdTipoActividadExpEquipHerrYPerrDispArtefExp(Long.valueOf(idTipoActividadExpEquipHerrYPerrDispArtefExp));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoActividadExpEquipHerrYPerrDispArtefExpId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExpId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoActividadExpEquipHerrYPerrDispArtefExpId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoActividadExpEquipHerrYPerrDispArtefExpporNombre(String nombreTipoActividadExpEquipHerrYPerrDispArtefExp) {
        Optional<TipoActividadExpEquipHerrYPerrDispArtefExp> tipoActividadExpEquipHerrYPerrDispArtefExpNombre = Optional.ofNullable(tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findByNombreTipoActividadExpEquipHerrYPerrDispArtefExp(String.valueOf(nombreTipoActividadExpEquipHerrYPerrDispArtefExp)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoActividadExpEquipHerrYPerrDispArtefExpNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExpNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoActividadExpEquipHerrYPerrDispArtefExpNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoActividadExpEquipHerrYPerrDispArtefExp(TipoActividadExpEquipHerrYPerrDispArtefExpDTO tipoActividadExpEquipHerrYPerrDispArtefExpDTO) {
        Optional<TipoActividadExpEquipHerrYPerrDispArtefExp> tipoActividadExpEquipHerrYPerrDispArtefExpId = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findByIdTipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO.getIdTipoActividadExpEquipHerrYPerrDispArtefExp());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoActividadExpEquipHerrYPerrDispArtefExpId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoActividadExpEquipHerrYPerrDispArtefExpDTO.getNombreTipoActividadExpEquipHerrYPerrDispArtefExp().equals(tipoActividadExpEquipHerrYPerrDispArtefExpId.get().getNombreTipoActividadExpEquipHerrYPerrDispArtefExp())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExp = tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO);
              tipoActividadExpEquipHerrYPerrDispArtefExpRepository.save(tipoActividadExpEquipHerrYPerrDispArtefExp);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoActividadExpEquipHerrYPerrDispArtefExpDTO.getNombreTipoActividadExpEquipHerrYPerrDispArtefExp().equals(tipoActividadExpEquipHerrYPerrDispArtefExpId.get().getNombreTipoActividadExpEquipHerrYPerrDispArtefExp())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExpNombre = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findByNombreTipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO.getNombreTipoActividadExpEquipHerrYPerrDispArtefExp().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoActividadExpEquipHerrYPerrDispArtefExpNombre ==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoActividadExpEquipHerrYPerrDispArtefExp tipoActividadExpEquipHerrYPerrDispArtefExp = tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExp(tipoActividadExpEquipHerrYPerrDispArtefExpDTO);
                 tipoActividadExpEquipHerrYPerrDispArtefExpRepository.save(tipoActividadExpEquipHerrYPerrDispArtefExp);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoActividadExpEquipHerrYPerrDispArtefExpId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoActividadExpEquipHerrYPerrDispArtefExp(Long idTipoActividadExpEquipHerrYPerrDispArtefExp) {
        Optional<TipoActividadExpEquipHerrYPerrDispArtefExp> tipoActividadExpEquipHerrYPerrDispArtefExpId  = tipoActividadExpEquipHerrYPerrDispArtefExpRepository.findById(idTipoActividadExpEquipHerrYPerrDispArtefExp);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoActividadExpEquipHerrYPerrDispArtefExpId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExpDAO.tipoActividadExpEquipHerrYPerrDispArtefExpDTO(tipoActividadExpEquipHerrYPerrDispArtefExpId.get()));
           tipoActividadExpEquipHerrYPerrDispArtefExpRepository.delete(tipoActividadExpEquipHerrYPerrDispArtefExpId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoActividadExpEquipHerrYPerrDispArtefExpId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoActividadExpEquipHerrYPerrDispArtefExpDTO(null);
        }
        
        return respuestaDTO;
    }
}
