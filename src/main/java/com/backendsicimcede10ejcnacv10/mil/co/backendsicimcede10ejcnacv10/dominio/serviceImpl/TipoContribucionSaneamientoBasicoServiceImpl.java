//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoContribucionSaneamientoBasicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoContribucionSaneamientoBasicoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoContribucionSaneamientoBasicoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoContribucionSaneamientoBasico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoContribucionSaneamientoBasicoRepository;
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
public class TipoContribucionSaneamientoBasicoServiceImpl implements TipoContribucionSaneamientoBasicoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoContribucionSaneamientoBasicoDAO tipoContribucionSaneamientoBasicoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoContribucionSaneamientoBasicoRepository tipoContribucionSaneamientoBasicoRepository;
    
    //CONTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR REGISTROS.
    public Long contarTotalRegistros(Long idTipoContribucionSaneamientoBasico, String keyword) {
        return tipoContribucionSaneamientoBasicoRepository.findTotalRegistros(idTipoContribucionSaneamientoBasico, keyword);
    }
    
    //LISTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoContribucionSaneamientoBasicoDTO> listarTiposContribucionesSaneamientosBasicos(Long idTipoContribucionSaneamientoBasico, String keyword, String orderBy, String orderMode) {
        List<TipoContribucionSaneamientoBasico> tiposContribucionesSaneamientosBasicos = tipoContribucionSaneamientoBasicoRepository.findAllTiposContribucionesSaneamientosBasicos(idTipoContribucionSaneamientoBasico, keyword, orderBy, orderMode);
        List<TipoContribucionSaneamientoBasicoDTO> tipoContribucionSaneamientoBasicoDTOS = new ArrayList<>();
        
        for (TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico : tiposContribucionesSaneamientosBasicos){
            tipoContribucionSaneamientoBasicoDTOS.add(tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasico));
        }
        
        return tipoContribucionSaneamientoBasicoDTOS;
    }
    
    //LISTAR REGISTROS FILTRADOS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoContribucionSaneamientoBasicoDTO> listarTiposContribucionesSaneamientosBasicosPag(Pageable pageable, Long idTipoContribucionSaneamientoBasico, String keyword, String orderBy, String orderMode) {
        Slice<TipoContribucionSaneamientoBasico> tiposContribucionesSaneamientosBasicos = tipoContribucionSaneamientoBasicoRepository.findAllTiposContribucionesSaneamientosBasicosPag(pageable, idTipoContribucionSaneamientoBasico, keyword, orderBy, orderMode);
        return tiposContribucionesSaneamientosBasicos.map(tipoContribucionSaneamientoBasico -> tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasico));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoContribucionSaneamientoBasico(TipoContribucionSaneamientoBasicoDTO tipoContribucionSaneamientoBasicoDTO) {
        Long maxIdTipoContribucionSaneamientoBasico=null;
        TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasicoNombre = tipoContribucionSaneamientoBasicoRepository.findByNombreTipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO.getNombreTipoContribucionSaneamientoBasico().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoContribucionSaneamientoBasicoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoContribucionSaneamientoBasico = tipoContribucionSaneamientoBasicoRepository.findMaxIdTipoContribucionSaneamientoBasico();
           if (maxIdTipoContribucionSaneamientoBasico==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoContribucionSaneamientoBasico=Long.valueOf(0);
           }
           tipoContribucionSaneamientoBasicoDTO.setIdTipoContribucionSaneamientoBasico(maxIdTipoContribucionSaneamientoBasico+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoContribucionSaneamientoBasicoRepository.save(tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoContribucionSaneamientoBasicoporId(Long idTipoContribucionSaneamientoBasico) {
        Optional<TipoContribucionSaneamientoBasico> tipoContribucionSaneamientoBasicoId = tipoContribucionSaneamientoBasicoRepository.findByIdTipoContribucionSaneamientoBasico(Long.valueOf(idTipoContribucionSaneamientoBasico));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoContribucionSaneamientoBasicoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasicoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoContribucionSaneamientoBasicoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoContribucionSaneamientoBasicoporNombre(String nombreTipoContribucionSaneamientoBasico) {
        Optional<TipoContribucionSaneamientoBasico> tipoContribucionSaneamientoBasicoNombre = Optional.ofNullable(tipoContribucionSaneamientoBasicoRepository.findByNombreTipoContribucionSaneamientoBasico(String.valueOf(nombreTipoContribucionSaneamientoBasico)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoContribucionSaneamientoBasicoNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasicoNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoContribucionSaneamientoBasicoNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoContribucionSaneamientoBasico(TipoContribucionSaneamientoBasicoDTO tipoContribucionSaneamientoBasicoDTO) {
        Optional<TipoContribucionSaneamientoBasico> tipoContribucionSaneamientoBasicoId = tipoContribucionSaneamientoBasicoRepository.findByIdTipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO.getIdTipoContribucionSaneamientoBasico());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoContribucionSaneamientoBasicoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoContribucionSaneamientoBasicoDTO.getNombreTipoContribucionSaneamientoBasico().equals(tipoContribucionSaneamientoBasicoId.get().getNombreTipoContribucionSaneamientoBasico())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico = tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO);
              tipoContribucionSaneamientoBasicoRepository.save(tipoContribucionSaneamientoBasico);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoContribucionSaneamientoBasicoDTO.getNombreTipoContribucionSaneamientoBasico().equals(tipoContribucionSaneamientoBasicoId.get().getNombreTipoContribucionSaneamientoBasico())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasicoNombre = tipoContribucionSaneamientoBasicoRepository.findByNombreTipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO.getNombreTipoContribucionSaneamientoBasico().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoContribucionSaneamientoBasicoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoContribucionSaneamientoBasico tipoContribucionSaneamientoBasico = tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasico(tipoContribucionSaneamientoBasicoDTO);
                 tipoContribucionSaneamientoBasicoRepository.save(tipoContribucionSaneamientoBasico);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoContribucionSaneamientoBasicoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoContribucionSaneamientoBasico(Long idTipoContribucionSaneamientoBasico) {
        Optional<TipoContribucionSaneamientoBasico> tipoContribucionSaneamientoBasicoId  = tipoContribucionSaneamientoBasicoRepository.findById(idTipoContribucionSaneamientoBasico);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoContribucionSaneamientoBasicoId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasicoDAO.tipoContribucionSaneamientoBasicoDTO(tipoContribucionSaneamientoBasicoId.get()));
           tipoContribucionSaneamientoBasicoRepository.delete(tipoContribucionSaneamientoBasicoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoContribucionSaneamientoBasicoId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoContribucionSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
}
