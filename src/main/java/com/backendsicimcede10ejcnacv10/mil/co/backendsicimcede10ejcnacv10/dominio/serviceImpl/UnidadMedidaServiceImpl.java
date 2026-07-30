//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMedidaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.UnidadMedidaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.UnidadMedidaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMedida;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMedidaRepository;
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
public class UnidadMedidaServiceImpl implements UnidadMedidaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMedidaDAO unidadMedidaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMedidaRepository unidadMedidaRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(String keyword) {
        return unidadMedidaRepository.findTotalRegistros(keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<UnidadMedidaDTO> listarUnidadesMedidas(String keyword, String orderBy, String orderMode) {
        List<UnidadMedida> unidadesMedidas = unidadMedidaRepository.findAllUnidadesMedidas(keyword, orderBy, orderMode);
        List<UnidadMedidaDTO> unidadMedidaDTOS = new ArrayList<>();
        
        for (UnidadMedida unidadMedida : unidadesMedidas){
            unidadMedidaDTOS.add(unidadMedidaDAO.unidadMedidaDTO(unidadMedida));
        }
        
        return unidadMedidaDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<UnidadMedidaDTO> listarUnidadesMedidasPag(Pageable pageable, String keyword, String orderBy, String orderMode) {
        Slice<UnidadMedida> unidadesMedidas = unidadMedidaRepository.findAllUnidadesMedidasPag(pageable, keyword, orderBy, orderMode);
        return unidadesMedidas.map(unidadMedida -> unidadMedidaDAO.unidadMedidaDTO(unidadMedida));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearUnidadMedida(UnidadMedidaDTO unidadMedidaDTO) {
        Long maxIdUnidadMedida=null;
        UnidadMedida unidadMedidaNombre = unidadMedidaRepository.findByNombreUnidadMedida(unidadMedidaDTO.getNombreUnidadMedida().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(unidadMedidaNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setUnidadMedidaDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdUnidadMedida = unidadMedidaRepository.findMaxIdUnidadMedida();
           if (maxIdUnidadMedida==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdUnidadMedida=Long.valueOf(0);
           }
           unidadMedidaDTO.setIdUnidadMedida(maxIdUnidadMedida+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           unidadMedidaRepository.save(unidadMedidaDAO.unidadMedida(unidadMedidaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUnidadMedidaporId(Long idUnidadMedida) {
        Optional<UnidadMedida> unidadMedidaId = unidadMedidaRepository.findByIdUnidadMedida(Long.valueOf(idUnidadMedida));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (unidadMedidaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setUnidadMedidaDTO(unidadMedidaDAO.unidadMedidaDTO(unidadMedidaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (unidadMedidaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMedidaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUnidadMedidaporNombre(String nombreUnidadMedida) {
        Optional<UnidadMedida> unidadMedidaNombre = Optional.ofNullable(unidadMedidaRepository.findByNombreUnidadMedida(String.valueOf(nombreUnidadMedida)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (unidadMedidaNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setUnidadMedidaDTO(unidadMedidaDAO.unidadMedidaDTO(unidadMedidaNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (unidadMedidaNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMedidaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarUnidadMedida(UnidadMedidaDTO unidadMedidaDTO) {
        Optional<UnidadMedida> unidadMedidaId = unidadMedidaRepository.findByIdUnidadMedida(unidadMedidaDTO.getIdUnidadMedida());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (unidadMedidaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (unidadMedidaDTO.getNombreUnidadMedida().equals(unidadMedidaId.get().getNombreUnidadMedida())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              UnidadMedida unidadMedida = unidadMedidaDAO.unidadMedida(unidadMedidaDTO);
              unidadMedidaRepository.save(unidadMedida);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (unidadMedidaDTO.getNombreUnidadMedida().equals(unidadMedidaId.get().getNombreUnidadMedida())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              UnidadMedida unidadMedidaNombre = unidadMedidaRepository.findByNombreUnidadMedida(unidadMedidaDTO.getNombreUnidadMedida().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(unidadMedidaNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setUnidadMedidaDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 UnidadMedida unidadMedida = unidadMedidaDAO.unidadMedida(unidadMedidaDTO);
                 unidadMedidaRepository.save(unidadMedida);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (unidadMedidaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setUnidadMedidaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarUnidadMedida(Long idUnidadMedida) {
        Optional<UnidadMedida> unidadMedidaId  = unidadMedidaRepository.findById(idUnidadMedida);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (unidadMedidaId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setUnidadMedidaDTO(unidadMedidaDAO.unidadMedidaDTO(unidadMedidaId.get()));
           unidadMedidaRepository.delete(unidadMedidaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (unidadMedidaId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMedidaDTO(null);
        }
        
        return respuestaDTO;
    }
}
