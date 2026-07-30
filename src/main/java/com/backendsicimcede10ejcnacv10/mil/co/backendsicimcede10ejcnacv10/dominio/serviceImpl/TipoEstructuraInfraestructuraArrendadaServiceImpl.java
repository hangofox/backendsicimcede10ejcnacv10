//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEstructuraInfraestructuraArrendadaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoEstructuraInfraestructuraArrendadaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoEstructuraInfraestructuraArrendadaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructuraArrendada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoEstructuraInfraestructuraArrendadaRepository;
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
public class TipoEstructuraInfraestructuraArrendadaServiceImpl implements TipoEstructuraInfraestructuraArrendadaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoEstructuraInfraestructuraArrendadaDAO tipoEstructuraInfraestructuraArrendadaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoEstructuraInfraestructuraArrendadaRepository tipoEstructuraInfraestructuraArrendadaRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoEstructuraInfraestructuraArrendada, String keyword) {
        return tipoEstructuraInfraestructuraArrendadaRepository.findTotalRegistros(idTipoEstructuraInfraestructuraArrendada, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoEstructuraInfraestructuraArrendadaDTO> listarTiposEstructurasInfraestructurasArrendadas(Long idTipoEstructuraInfraestructuraArrendada, String keyword, String orderBy, String orderMode) {
        List<TipoEstructuraInfraestructuraArrendada> tiposEstructurasInfraestructurasArrendadas = tipoEstructuraInfraestructuraArrendadaRepository.findAllTiposEstructurasInfraestructurasArrendadas(idTipoEstructuraInfraestructuraArrendada, keyword, orderBy, orderMode);
        List<TipoEstructuraInfraestructuraArrendadaDTO> tipoEstructuraInfraestructuraArrendadaDTOS = new ArrayList<>();
        
        for (TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada : tiposEstructurasInfraestructurasArrendadas){
            tipoEstructuraInfraestructuraArrendadaDTOS.add(tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendada));
        }
        
        return tipoEstructuraInfraestructuraArrendadaDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoEstructuraInfraestructuraArrendadaDTO> listarTiposEstructurasInfraestructurasArrendadasPag(Pageable pageable, Long idTipoEstructuraInfraestructuraArrendada, String keyword, String orderBy, String orderMode) {
        Slice<TipoEstructuraInfraestructuraArrendada> tiposEstructurasInfraestructurasArrendadas = tipoEstructuraInfraestructuraArrendadaRepository.findAllTiposEstructurasInfraestructurasArrendadasPag(pageable, idTipoEstructuraInfraestructuraArrendada, keyword, orderBy, orderMode);
        return tiposEstructurasInfraestructurasArrendadas.map(tipoEstructuraInfraestructuraArrendada -> tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendada));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoEstructuraInfraestructuraArrendada(TipoEstructuraInfraestructuraArrendadaDTO tipoEstructuraInfraestructuraArrendadaDTO) {
        Long maxIdTipoEstructuraInfraestructuraArrendada=null;
        TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendadaNombre = tipoEstructuraInfraestructuraArrendadaRepository.findByNombreTipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO.getNombreTipoEstructuraInfraestructuraArrendada().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoEstructuraInfraestructuraArrendadaNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoEstructuraInfraestructuraArrendada = tipoEstructuraInfraestructuraArrendadaRepository.findMaxIdTipoEstructuraInfraestructuraArrendada();
           if (maxIdTipoEstructuraInfraestructuraArrendada==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoEstructuraInfraestructuraArrendada=Long.valueOf(0);
           }
           tipoEstructuraInfraestructuraArrendadaDTO.setIdTipoEstructuraInfraestructuraArrendada(maxIdTipoEstructuraInfraestructuraArrendada+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoEstructuraInfraestructuraArrendadaRepository.save(tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEstructuraInfraestructuraArrendadaporId(Long idTipoEstructuraInfraestructuraArrendada) {
        Optional<TipoEstructuraInfraestructuraArrendada> tipoEstructuraInfraestructuraArrendadaId = tipoEstructuraInfraestructuraArrendadaRepository.findByIdTipoEstructuraInfraestructuraArrendada(Long.valueOf(idTipoEstructuraInfraestructuraArrendada));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEstructuraInfraestructuraArrendadaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendadaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEstructuraInfraestructuraArrendadaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoEstructuraInfraestructuraArrendadaporNombre(String nombreTipoEstructuraInfraestructuraArrendada) {
        Optional<TipoEstructuraInfraestructuraArrendada> tipoEstructuraInfraestructuraArrendadaNombre = Optional.ofNullable(tipoEstructuraInfraestructuraArrendadaRepository.findByNombreTipoEstructuraInfraestructuraArrendada(String.valueOf(nombreTipoEstructuraInfraestructuraArrendada)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoEstructuraInfraestructuraArrendadaNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendadaNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoEstructuraInfraestructuraArrendadaNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoEstructuraInfraestructuraArrendada(TipoEstructuraInfraestructuraArrendadaDTO tipoEstructuraInfraestructuraArrendadaDTO) {
        Optional<TipoEstructuraInfraestructuraArrendada> tipoEstructuraInfraestructuraArrendadaId = tipoEstructuraInfraestructuraArrendadaRepository.findByIdTipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO.getIdTipoEstructuraInfraestructuraArrendada());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoEstructuraInfraestructuraArrendadaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoEstructuraInfraestructuraArrendadaDTO.getNombreTipoEstructuraInfraestructuraArrendada().equals(tipoEstructuraInfraestructuraArrendadaId.get().getNombreTipoEstructuraInfraestructuraArrendada())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada = tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO);
              tipoEstructuraInfraestructuraArrendadaRepository.save(tipoEstructuraInfraestructuraArrendada);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoEstructuraInfraestructuraArrendadaDTO.getNombreTipoEstructuraInfraestructuraArrendada().equals(tipoEstructuraInfraestructuraArrendadaId.get().getNombreTipoEstructuraInfraestructuraArrendada())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendadaNombre = tipoEstructuraInfraestructuraArrendadaRepository.findByNombreTipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO.getNombreTipoEstructuraInfraestructuraArrendada().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoEstructuraInfraestructuraArrendadaNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada = tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO);
                 tipoEstructuraInfraestructuraArrendadaRepository.save(tipoEstructuraInfraestructuraArrendada);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoEstructuraInfraestructuraArrendadaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoEstructuraInfraestructuraArrendada(Long idTipoEstructuraInfraestructuraArrendada) {
        Optional<TipoEstructuraInfraestructuraArrendada> tipoEstructuraInfraestructuraArrendadaId  = tipoEstructuraInfraestructuraArrendadaRepository.findById(idTipoEstructuraInfraestructuraArrendada);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoEstructuraInfraestructuraArrendadaId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendadaDAO.tipoEstructuraInfraestructuraArrendadaDTO(tipoEstructuraInfraestructuraArrendadaId.get()));
           tipoEstructuraInfraestructuraArrendadaRepository.delete(tipoEstructuraInfraestructuraArrendadaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoEstructuraInfraestructuraArrendadaId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoEstructuraInfraestructuraArrendadaDTO(null);
        }
        
        return respuestaDTO;
    }
}
