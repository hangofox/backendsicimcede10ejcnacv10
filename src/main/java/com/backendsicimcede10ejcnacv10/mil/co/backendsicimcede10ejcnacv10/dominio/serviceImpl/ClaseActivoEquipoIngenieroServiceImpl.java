//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ClaseActivoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ClaseActivoEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ClaseActivoEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ClaseActivoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ClaseActivoEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ClaseActivoEquipoIngenieroServiceImpl implements ClaseActivoEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ClaseActivoEquipoIngenieroDAO claseActivoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ClaseActivoEquipoIngenieroRepository claseActivoEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idClaseActivoEquipoIngeniero, String keyword, String nombreClaseActivoEquipoIngeniero) {
        return claseActivoEquipoIngenieroRepository.findTotalRegistros(idClaseActivoEquipoIngeniero, keyword, nombreClaseActivoEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ClaseActivoEquipoIngenieroDTO> listarClasesActivosEquiposIngenieros(Long idClaseActivoEquipoIngeniero, String keyword, String nombreClaseActivoEquipoIngeniero, String orderBy, String orderMode) {
        List<ClaseActivoEquipoIngeniero> clasesActivosEquiposIngenieros = claseActivoEquipoIngenieroRepository.findAllClasesActivosEquiposIngenieros(idClaseActivoEquipoIngeniero, keyword, nombreClaseActivoEquipoIngeniero, orderBy, orderMode);
        List<ClaseActivoEquipoIngenieroDTO> claseActivoEquipoIngenierosDTOS = new ArrayList<>();
        for (ClaseActivoEquipoIngeniero claseActivoEquipoIngeniero : clasesActivosEquiposIngenieros) {
            claseActivoEquipoIngenierosDTOS.add(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngenieroDTO(claseActivoEquipoIngeniero));
        }
        
        return claseActivoEquipoIngenierosDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<ClaseActivoEquipoIngenieroDTO> listarClasesActivosEquiposIngenierosProPag(Pageable pageable, Long idClaseActivoEquipoIngeniero, String keyword, String nombreClaseActivoEquipoIngeniero, String orderBy, String orderMode) {
        Slice<ClaseActivoEquipoIngeniero> clasesActivosEquiposIngenieros = claseActivoEquipoIngenieroRepository.findAllClasesActivosEquiposIngenierosProPag(pageable, idClaseActivoEquipoIngeniero, keyword, nombreClaseActivoEquipoIngeniero, orderBy, orderMode);
        return clasesActivosEquiposIngenieros.map(claseActivoEquipoIngeniero -> claseActivoEquipoIngenieroDAO.claseActivoEquipoIngenieroDTO(claseActivoEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearClaseActivoEquipoIngeniero(ClaseActivoEquipoIngenieroDTO claseActivoEquipoIngenieroDTO) {
        Long maxIdClaseActivoEquipoIngeniero = null;
        ClaseActivoEquipoIngeniero claseActivoEquipoIngenieroNombre = claseActivoEquipoIngenieroRepository.findByNombreClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getNombreClaseActivoEquipoIngeniero().toUpperCase());
        ClaseActivoEquipoIngeniero claseActivoEquipoIngenieroNumero = claseActivoEquipoIngenieroRepository.findByNumeroClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getNumeroClaseActivoEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        long banderaNumeroRegistroEncontrado = 0;
        
        if (!(claseActivoEquipoIngenieroNombre == null)) {//SI ENCONTRO EL NOMBRE DE LA CLASE ACTIVO EQUIPO INGENIERO EN LA TABLA DE LA BASE DE DATOS ACTIVA BANDERA.
           banderaNombreRegistroEncontrado = 1;
        }
        if (!(claseActivoEquipoIngenieroNumero == null)) {//SI ENCONTRO EL NÚMERO DE LA CLASE ACTIVO EQUIPO INGENIERO EN LA TABLA DE LA BASE DE DATOS ACTIVA BANDERA.
           banderaNumeroRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
        }
        if (banderaNumeroRegistroEncontrado == 1) {//SI ENCONTRO EL NÚMERO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE REGISTRO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
        }
        if ( (banderaNombreRegistroEncontrado == 0)&&(banderaNumeroRegistroEncontrado == 0) ) {//SI NO ENCONTRO NI EL NOMBRE NI EL NÚMERO CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdClaseActivoEquipoIngeniero = claseActivoEquipoIngenieroRepository.findMaxIdClaseActivoEquipoIngeniero();
           if (maxIdClaseActivoEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdClaseActivoEquipoIngeniero = Long.valueOf(0);
           }
           claseActivoEquipoIngenieroDTO.setIdClaseActivoEquipoIngeniero(maxIdClaseActivoEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           claseActivoEquipoIngenieroRepository.save(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarClaseActivoEquipoIngenieroporId(Long idClaseActivoEquipoIngeniero) {
        Optional<ClaseActivoEquipoIngeniero> claseActivoEquipoIngenieroId = claseActivoEquipoIngenieroRepository.findByIdClaseActivoEquipoIngeniero(Long.valueOf(idClaseActivoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (claseActivoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (claseActivoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarClaseActivoEquipoIngenieroporNombreClaseActivoEquipoIngeniero(String nombreClaseActivoEquipoIngeniero) {
        Optional<ClaseActivoEquipoIngeniero> claseActivoEquipoIngenieroNombre = Optional.ofNullable(claseActivoEquipoIngenieroRepository.findByNombreClaseActivoEquipoIngeniero(nombreClaseActivoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (claseActivoEquipoIngenieroNombre.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NOMBRE PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (claseActivoEquipoIngenieroNombre.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NOMBRE PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NÚMERO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarClaseActivoEquipoIngenieroporNumeroClaseActivoEquipoIngeniero(String numeroClaseActivoEquipoIngeniero) {
        Optional<ClaseActivoEquipoIngeniero> claseActivoEquipoIngenieroNumero = Optional.ofNullable(claseActivoEquipoIngenieroRepository.findByNumeroClaseActivoEquipoIngeniero(numeroClaseActivoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (claseActivoEquipoIngenieroNumero.isPresent() == true) {//SI ENCONTRO EL NÚMERO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NÚMERO PROPORCIONADO.
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroNumero.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (claseActivoEquipoIngenieroNumero.isPresent() == false) {//SI NO ENCONTRO EL NÚMERO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NÚMERO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarClaseActivoEquipoIngeniero(ClaseActivoEquipoIngenieroDTO claseActivoEquipoIngenieroDTO) {
        Optional<ClaseActivoEquipoIngeniero> claseActivoEquipoIngenieroId = claseActivoEquipoIngenieroRepository.findByIdClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getIdClaseActivoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (claseActivoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL NOMBRE Y DEL NÚMERO.
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaNombreRegistroEncontrado = 0;
           long banderaNumeroRegistroEncontrado = 0;
           
           ClaseActivoEquipoIngeniero claseActivoEquipoIngenieroNombre = claseActivoEquipoIngenieroRepository.findByNombreClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getNombreClaseActivoEquipoIngeniero().toUpperCase());
           ClaseActivoEquipoIngeniero claseActivoEquipoIngenieroNumero = claseActivoEquipoIngenieroRepository.findByNumeroClaseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO.getNumeroClaseActivoEquipoIngeniero().toUpperCase());
           
           if (!(claseActivoEquipoIngenieroNombre == null) && !(claseActivoEquipoIngenieroNombre.getIdClaseActivoEquipoIngeniero().equals(claseActivoEquipoIngenieroDTO.getIdClaseActivoEquipoIngeniero()))) {//SI ENCONTRO EL NOMBRE EN UN REGISTRO DIFERENTE AL ACTUAL ACTIVA BANDERA.
              banderaNombreRegistroEncontrado = 1;
           }
           if (!(claseActivoEquipoIngenieroNumero == null) && !(claseActivoEquipoIngenieroNumero.getIdClaseActivoEquipoIngeniero().equals(claseActivoEquipoIngenieroDTO.getIdClaseActivoEquipoIngeniero()))) {//SI ENCONTRO EL NÚMERO EN UN REGISTRO DIFERENTE AL ACTUAL ACTIVA BANDERA.
              banderaNumeroRegistroEncontrado = 1;
           }
           
           if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO NOMBRE ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
              respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
           }
           if (banderaNumeroRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO NÚMERO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE NÚMERO DE REGISTRO REPETIDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
           }
           if ( (banderaNombreRegistroEncontrado == 0)&&(banderaNumeroRegistroEncontrado == 0) ) {//SI NO ENCONTRO CONFLICTOS DE NOMBRE NI DE NÚMERO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              claseActivoEquipoIngenieroRepository.save(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngeniero(claseActivoEquipoIngenieroDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (claseActivoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
        }

        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarClaseActivoEquipoIngeniero(Long idClaseActivoEquipoIngeniero) {
        Optional<ClaseActivoEquipoIngeniero> claseActivoEquipoIngenieroId = claseActivoEquipoIngenieroRepository.findById(idClaseActivoEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (claseActivoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroDAO.claseActivoEquipoIngenieroDTO(claseActivoEquipoIngenieroId.get()));
           claseActivoEquipoIngenieroRepository.delete(claseActivoEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (claseActivoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setClaseActivoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
