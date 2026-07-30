//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoReduccionImpuestoTerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoReduccionImpuestoTerrenoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoReduccionImpuestoTerrenoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoReduccionImpuestoTerreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoReduccionImpuestoTerrenoRepository;
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
public class TipoReduccionImpuestoTerrenoServiceImpl implements TipoReduccionImpuestoTerrenoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoReduccionImpuestoTerrenoDAO tipoReduccionImpuestoTerrenoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoReduccionImpuestoTerrenoRepository tipoReduccionImpuestoTerrenoRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idTipoReduccionImpuestoTerreno, String keyword) {
        return tipoReduccionImpuestoTerrenoRepository.findTotalRegistros(idTipoReduccionImpuestoTerreno, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoReduccionImpuestoTerrenoDTO> listarTiposReduccionesImpuestosTerrenos(Long idTipoReduccionImpuestoTerreno, String keyword, String orderBy, String orderMode) {
        List<TipoReduccionImpuestoTerreno> tiposReduccionesImpuestosTerrenos = tipoReduccionImpuestoTerrenoRepository.findAllTiposReduccionesImpuestosTerrenos(idTipoReduccionImpuestoTerreno, keyword, orderBy, orderMode);
        List<TipoReduccionImpuestoTerrenoDTO> tipoReduccionImpuestoTerrenoDTOS = new ArrayList<>();
        
        for (TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno : tiposReduccionesImpuestosTerrenos){
            tipoReduccionImpuestoTerrenoDTOS.add(tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerreno));
        }
        
        return tipoReduccionImpuestoTerrenoDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoReduccionImpuestoTerrenoDTO> listarTiposReduccionesImpuestosTerrrenosPag(Pageable pageable, Long idTipoReduccionImpuestoTerreno, String keyword, String orderBy, String orderMode) {
        Slice<TipoReduccionImpuestoTerreno> tiposReduccionesImpuestosTerrenos = tipoReduccionImpuestoTerrenoRepository.findAllTiposReduccionesImpuestosTerrrenosPag(pageable, idTipoReduccionImpuestoTerreno, keyword, orderBy, orderMode);
        return tiposReduccionesImpuestosTerrenos.map(tipoReduccionImpuestoTerreno -> tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerreno));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoReduccionImpuestoTerreno(TipoReduccionImpuestoTerrenoDTO tipoReduccionImpuestoTerrenoDTO) {
        Long maxIdTipoReduccionImpuestoTerreno=null;
        TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerrenoNombre = tipoReduccionImpuestoTerrenoRepository.findByNombreTipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO.getNombreTipoReduccionImpuestoTerreno().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoReduccionImpuestoTerrenoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoReduccionImpuestoTerreno = tipoReduccionImpuestoTerrenoRepository.findMaxIdTipoReduccionImpuestoTerreno();
           if (maxIdTipoReduccionImpuestoTerreno==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoReduccionImpuestoTerreno=Long.valueOf(0);
           }
           tipoReduccionImpuestoTerrenoDTO.setIdTipoReduccionImpuestoTerreno(maxIdTipoReduccionImpuestoTerreno+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoReduccionImpuestoTerrenoRepository.save(tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoReduccionImpuestoTerrenoporId(Long idTipoReduccionImpuestoTerreno) {
        Optional<TipoReduccionImpuestoTerreno> tipoReduccionImpuestoTerrenoId = tipoReduccionImpuestoTerrenoRepository.findByIdTipoReduccionImpuestoTerreno(Long.valueOf(idTipoReduccionImpuestoTerreno));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoReduccionImpuestoTerrenoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerrenoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoReduccionImpuestoTerrenoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoReduccionImpuestoTerrenoporNombre(String nombreTipoReduccionImpuestoTerreno) {
        Optional<TipoReduccionImpuestoTerreno> tipoReduccionImpuestoTerrenoNombre = Optional.ofNullable(tipoReduccionImpuestoTerrenoRepository.findByNombreTipoReduccionImpuestoTerreno(String.valueOf(nombreTipoReduccionImpuestoTerreno)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoReduccionImpuestoTerrenoNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerrenoNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoReduccionImpuestoTerrenoNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoReduccionImpuestoTerreno(TipoReduccionImpuestoTerrenoDTO tipoReduccionImpuestoTerrenoDTO) {
        Optional<TipoReduccionImpuestoTerreno> tipoReduccionImpuestoTerrenoId = tipoReduccionImpuestoTerrenoRepository.findByIdTipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO.getIdTipoReduccionImpuestoTerreno());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoReduccionImpuestoTerrenoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoReduccionImpuestoTerrenoDTO.getNombreTipoReduccionImpuestoTerreno().equals(tipoReduccionImpuestoTerrenoId.get().getNombreTipoReduccionImpuestoTerreno())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno = tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO);
              tipoReduccionImpuestoTerrenoRepository.save(tipoReduccionImpuestoTerreno);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoReduccionImpuestoTerrenoDTO.getNombreTipoReduccionImpuestoTerreno().equals(tipoReduccionImpuestoTerrenoId.get().getNombreTipoReduccionImpuestoTerreno())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerrenoNombre = tipoReduccionImpuestoTerrenoRepository.findByNombreTipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO.getNombreTipoReduccionImpuestoTerreno().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoReduccionImpuestoTerrenoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoReduccionImpuestoTerreno tipoReduccionImpuestoTerreno = tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerreno(tipoReduccionImpuestoTerrenoDTO);
                 tipoReduccionImpuestoTerrenoRepository.save(tipoReduccionImpuestoTerreno);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoReduccionImpuestoTerrenoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoReduccionImpuestoTerreno(Long idTipoReduccionImpuestoTerreno) {
        Optional<TipoReduccionImpuestoTerreno> tipoReduccionImpuestoTerrenoId  = tipoReduccionImpuestoTerrenoRepository.findById(idTipoReduccionImpuestoTerreno);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoReduccionImpuestoTerrenoId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerrenoDAO.tipoReduccionImpuestoTerrenoDTO(tipoReduccionImpuestoTerrenoId.get()));
           tipoReduccionImpuestoTerrenoRepository.delete(tipoReduccionImpuestoTerrenoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoReduccionImpuestoTerrenoId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoReduccionImpuestoTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
}
