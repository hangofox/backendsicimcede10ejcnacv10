//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoResponsabilidadContractualDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoResponsabilidadContractualService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoResponsabilidadContractualDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoResponsabilidadContractual;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoResponsabilidadContractualRepository;
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
public class TipoResponsabilidadContractualServiceImpl implements TipoResponsabilidadContractualService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoResponsabilidadContractualDAO tipoResponsabilidadContractualDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoResponsabilidadContractualRepository tipoResponsabilidadContractualRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoResponsabilidadContractual, String keyword) {
        return tipoResponsabilidadContractualRepository.findTotalRegistros(idTipoResponsabilidadContractual, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoResponsabilidadContractualDTO> listarTiposResponsabilidadesContractuales(Long idTipoResponsabilidadContractual, String keyword, String orderBy, String orderMode) {
        List<TipoResponsabilidadContractual> tiposResponsabilidadesContractuales = tipoResponsabilidadContractualRepository.findAllTiposResponsabilidadesContractuales(idTipoResponsabilidadContractual, keyword, orderBy, orderMode);
        List<TipoResponsabilidadContractualDTO> tipoResponsabilidadContractualDTOS = new ArrayList<>();
        
        for (TipoResponsabilidadContractual tipoResponsabilidadContractual : tiposResponsabilidadesContractuales){
            tipoResponsabilidadContractualDTOS.add(tipoResponsabilidadContractualDAO.tipoResponsabilidadContractualDTO(tipoResponsabilidadContractual));
        }
        
        return tipoResponsabilidadContractualDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoResponsabilidadContractualDTO> listarTiposResponsabilidadesContractualesPag(Pageable pageable, Long idTipoResponsabilidadContractual, String keyword, String orderBy, String orderMode) {
        Slice<TipoResponsabilidadContractual> tiposResponsabilidadesContractuales = tipoResponsabilidadContractualRepository.findAllTiposResponsabilidadesContractualesPag(pageable, idTipoResponsabilidadContractual, keyword, orderBy, orderMode);
        return tiposResponsabilidadesContractuales.map(tipoResponsabilidadContractual -> tipoResponsabilidadContractualDAO.tipoResponsabilidadContractualDTO(tipoResponsabilidadContractual));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoResponsabilidadContractual(TipoResponsabilidadContractualDTO tipoResponsabilidadContractualDTO) {
        Long maxIdTipoResponsabilidadContractual=null;
        TipoResponsabilidadContractual tipoResponsabilidadContractualNombre = tipoResponsabilidadContractualRepository.findByNombreTipoResponsabilidadContractual(tipoResponsabilidadContractualDTO.getNombreTipoResponsabilidadContractual().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoResponsabilidadContractualNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoResponsabilidadContractualDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoResponsabilidadContractual = tipoResponsabilidadContractualRepository.findMaxIdTipoResponsabilidadContractual();
           if (maxIdTipoResponsabilidadContractual==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoResponsabilidadContractual=Long.valueOf(0);
           }
           tipoResponsabilidadContractualDTO.setIdTipoResponsabilidadContractual(maxIdTipoResponsabilidadContractual+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoResponsabilidadContractualRepository.save(tipoResponsabilidadContractualDAO.tipoResponsabilidadContractual(tipoResponsabilidadContractualDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoResponsabilidadContractualporId(Long idTipoResponsabilidadContractual) {
        Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualId = tipoResponsabilidadContractualRepository.findByIdTipoResponsabilidadContractual(Long.valueOf(idTipoResponsabilidadContractual));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoResponsabilidadContractualId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoResponsabilidadContractualDTO(tipoResponsabilidadContractualDAO.tipoResponsabilidadContractualDTO(tipoResponsabilidadContractualId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoResponsabilidadContractualId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoResponsabilidadContractualDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoResponsabilidadContractualporNombre(String nombreTipoResponsabilidadContractual) {
        Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualNombre = Optional.ofNullable(tipoResponsabilidadContractualRepository.findByNombreTipoResponsabilidadContractual(String.valueOf(nombreTipoResponsabilidadContractual)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoResponsabilidadContractualNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoResponsabilidadContractualDTO(tipoResponsabilidadContractualDAO.tipoResponsabilidadContractualDTO(tipoResponsabilidadContractualNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoResponsabilidadContractualNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoResponsabilidadContractualDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoResponsabilidadContractual(TipoResponsabilidadContractualDTO tipoResponsabilidadContractualDTO) {
        Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualId = tipoResponsabilidadContractualRepository.findByIdTipoResponsabilidadContractual(tipoResponsabilidadContractualDTO.getIdTipoResponsabilidadContractual());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoResponsabilidadContractualId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoResponsabilidadContractualDTO.getNombreTipoResponsabilidadContractual().equals(tipoResponsabilidadContractualId.get().getNombreTipoResponsabilidadContractual())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoResponsabilidadContractual tipoResponsabilidadContractual = tipoResponsabilidadContractualDAO.tipoResponsabilidadContractual(tipoResponsabilidadContractualDTO);
              tipoResponsabilidadContractualRepository.save(tipoResponsabilidadContractual);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoResponsabilidadContractualDTO.getNombreTipoResponsabilidadContractual().equals(tipoResponsabilidadContractualId.get().getNombreTipoResponsabilidadContractual())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoResponsabilidadContractual tipoResponsabilidadContractualNombre = tipoResponsabilidadContractualRepository.findByNombreTipoResponsabilidadContractual(tipoResponsabilidadContractualDTO.getNombreTipoResponsabilidadContractual().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoResponsabilidadContractualNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoResponsabilidadContractualDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoResponsabilidadContractual tipoResponsabilidadContractual = tipoResponsabilidadContractualDAO.tipoResponsabilidadContractual(tipoResponsabilidadContractualDTO);
                 tipoResponsabilidadContractualRepository.save(tipoResponsabilidadContractual);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoResponsabilidadContractualId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoResponsabilidadContractualDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoResponsabilidadContractual(Long idTipoResponsabilidadContractual) {
        Optional<TipoResponsabilidadContractual> tipoResponsabilidadContractualId  = tipoResponsabilidadContractualRepository.findById(idTipoResponsabilidadContractual);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoResponsabilidadContractualId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoResponsabilidadContractualDTO(tipoResponsabilidadContractualDAO.tipoResponsabilidadContractualDTO(tipoResponsabilidadContractualId.get()));
           tipoResponsabilidadContractualRepository.delete(tipoResponsabilidadContractualId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoResponsabilidadContractualId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoResponsabilidadContractualDTO(null);
        }
        
        return respuestaDTO;
    }
}
