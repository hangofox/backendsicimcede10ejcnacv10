//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.NivelMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.NivelMantenimientoEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.NivelMantenimientoEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.NivelMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.NivelMantenimientoEquipoIngenieroRepository;
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
public class NivelMantenimientoEquipoIngenieroServiceImpl implements NivelMantenimientoEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private NivelMantenimientoEquipoIngenieroDAO nivelMantenimientoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private NivelMantenimientoEquipoIngenieroRepository nivelMantenimientoEquipoIngenieroRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idNivelMantenimientoEquipoIngeniero, String keyword) {
        return nivelMantenimientoEquipoIngenieroRepository.findTotalRegistros(idNivelMantenimientoEquipoIngeniero, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<NivelMantenimientoEquipoIngenieroDTO> listarNivelesMantenimientosEquiposIngenieros(Long idNivelMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        List<NivelMantenimientoEquipoIngeniero> nivelesMantenimientosEquiposIngenieros = nivelMantenimientoEquipoIngenieroRepository.findAllNivelesMantenimientosEquiposIngenieros(idNivelMantenimientoEquipoIngeniero, keyword, orderBy, orderMode);
        List<NivelMantenimientoEquipoIngenieroDTO> nivelMantenimientoEquipoIngenieroDTOS = new ArrayList<>();
        
        for (NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero : nivelesMantenimientosEquiposIngenieros){
            nivelMantenimientoEquipoIngenieroDTOS.add(nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngeniero));
        }
        
        return nivelMantenimientoEquipoIngenieroDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<NivelMantenimientoEquipoIngenieroDTO> listarNivelesMantenimientosEquiposIngenierosOrdenadosporIdPag(Pageable pageable, Long idNivelMantenimientoEquipoIngeniero, String keyword, String orderBy, String orderMode) {
        Slice<NivelMantenimientoEquipoIngeniero> nivelesMantenimientosEquiposIngenieros = nivelMantenimientoEquipoIngenieroRepository.findAllNivelesMantenimientosEquiposIngenierosOrdenadosporIdPag(pageable, idNivelMantenimientoEquipoIngeniero, keyword, orderBy, orderMode);
        return nivelesMantenimientosEquiposIngenieros.map(nivelMantenimientoEquipoIngeniero -> nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearNivelMantenimientoEquipoIngeniero(NivelMantenimientoEquipoIngenieroDTO nivelMantenimientoEquipoIngenieroDTO) {
        Long maxIdNivelMantenimientoEquipoIngeniero=null;
        NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngenieroNombre = nivelMantenimientoEquipoIngenieroRepository.findByNombreNivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO.getNombreNivelMantenimientoEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(nivelMantenimientoEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdNivelMantenimientoEquipoIngeniero = nivelMantenimientoEquipoIngenieroRepository.findMaxIdNivelMantenimientoEquipoIngeniero();
           if (maxIdNivelMantenimientoEquipoIngeniero==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdNivelMantenimientoEquipoIngeniero=Long.valueOf(0);
           }
           nivelMantenimientoEquipoIngenieroDTO.setIdNivelMantenimientoEquipoIngeniero(maxIdNivelMantenimientoEquipoIngeniero+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           nivelMantenimientoEquipoIngenieroRepository.save(nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarNivelMantenimientoEquipoIngenieroporId(Long idNivelMantenimientoEquipoIngeniero) {
        Optional<NivelMantenimientoEquipoIngeniero> nivelMantenimientoEquipoIngenieroId = nivelMantenimientoEquipoIngenieroRepository.findByIdNivelMantenimientoEquipoIngeniero(Long.valueOf(idNivelMantenimientoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (nivelMantenimientoEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (nivelMantenimientoEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarNivelMantenimientoEquipoIngenieroporNombre(String nombreNivelMantenimientoEquipoIngeniero) {
        Optional<NivelMantenimientoEquipoIngeniero> nivelMantenimientoEquipoIngenieroNombre = Optional.ofNullable(nivelMantenimientoEquipoIngenieroRepository.findByNombreNivelMantenimientoEquipoIngeniero(String.valueOf(nombreNivelMantenimientoEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (nivelMantenimientoEquipoIngenieroNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (nivelMantenimientoEquipoIngenieroNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarNivelMantenimientoEquipoIngeniero(NivelMantenimientoEquipoIngenieroDTO nivelMantenimientoEquipoIngenieroDTO) {
        Optional<NivelMantenimientoEquipoIngeniero> nivelMantenimientoEquipoIngenieroId = nivelMantenimientoEquipoIngenieroRepository.findByIdNivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO.getIdNivelMantenimientoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (nivelMantenimientoEquipoIngenieroId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (nivelMantenimientoEquipoIngenieroDTO.getNombreNivelMantenimientoEquipoIngeniero().equals(nivelMantenimientoEquipoIngenieroId.get().getNombreNivelMantenimientoEquipoIngeniero())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero = nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO);
              nivelMantenimientoEquipoIngenieroRepository.save(nivelMantenimientoEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (nivelMantenimientoEquipoIngenieroDTO.getNombreNivelMantenimientoEquipoIngeniero().equals(nivelMantenimientoEquipoIngenieroId.get().getNombreNivelMantenimientoEquipoIngeniero())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngenieroNombre = nivelMantenimientoEquipoIngenieroRepository.findByNombreNivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO.getNombreNivelMantenimientoEquipoIngeniero().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(nivelMantenimientoEquipoIngenieroNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 NivelMantenimientoEquipoIngeniero nivelMantenimientoEquipoIngeniero = nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngeniero(nivelMantenimientoEquipoIngenieroDTO);
                 nivelMantenimientoEquipoIngenieroRepository.save(nivelMantenimientoEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (nivelMantenimientoEquipoIngenieroId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarNivelMantenimientoEquipoIngeniero(Long idNivelMantenimientoEquipoIngeniero) {
        Optional<NivelMantenimientoEquipoIngeniero> nivelMantenimientoEquipoIngenieroId  = nivelMantenimientoEquipoIngenieroRepository.findById(idNivelMantenimientoEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (nivelMantenimientoEquipoIngenieroId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngenieroDAO.nivelMantenimientoEquipoIngenieroDTO(nivelMantenimientoEquipoIngenieroId.get()));
           nivelMantenimientoEquipoIngenieroRepository.delete(nivelMantenimientoEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (nivelMantenimientoEquipoIngenieroId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setNivelMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
