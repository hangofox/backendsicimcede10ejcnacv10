//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.EquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.EquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class EquipoIngenieroServiceImpl implements EquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoIngenieroDAO equipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoIngenieroRepository equipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, String estado) {
        return equipoIngenieroRepository.findTotalRegistros(idEquipoIngeniero, keyword, siglaoAcronimoUnidadMilitar, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, estado);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<EquipoIngenieroDTO> listarEquiposIngenieros(Long idEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, String estado, String orderBy, String orderMode) {
        List<EquipoIngeniero> equiposIngenieros = equipoIngenieroRepository.findAllEquiposIngenieros(idEquipoIngeniero, keyword, siglaoAcronimoUnidadMilitar, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, estado, orderBy, orderMode);
        List<EquipoIngenieroDTO> equipoIngeneroDTOS = new ArrayList<>();
        for (EquipoIngeniero equipoIngeniero : equiposIngenieros) {
            equipoIngeneroDTOS.add(equipoIngenieroDAO.equipoIngenieroDTO(equipoIngeniero));
        }
        
        return equipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<EquipoIngenieroDTO> listarEquiposIngenierosPag(Pageable pageable, Long idEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String nombreClasificacionEquipoIngeniero, String nombreSubclasificacionEquipoIngeniero, String nombreElementoSubclasificacionEquipoIngeniero, String estado, String orderBy, String orderMode) {
        Slice<EquipoIngeniero> equiposIngenieros = equipoIngenieroRepository.findAllEquiposIngenierosPag(pageable, idEquipoIngeniero, keyword, siglaoAcronimoUnidadMilitar, nombreClasificacionEquipoIngeniero, nombreSubclasificacionEquipoIngeniero, nombreElementoSubclasificacionEquipoIngeniero, estado, orderBy, orderMode);
        return equiposIngenieros.map(equipoIngeniero -> equipoIngenieroDAO.equipoIngenieroDTO(equipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearEquipoIngeniero(EquipoIngenieroDTO equipoIngenieroDTO) {
        Long maxIdEquipoIngeniero = null;
        EquipoIngeniero equipoIngenieroUnico = equipoIngenieroRepository.findByNumeroInventarioEquipoIngenieroOrNumeroActivoFijoEquipoIngeniero(equipoIngenieroDTO.getNumeroInventarioEquipoIngeniero(), equipoIngenieroDTO.getNumeroActivoFijoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(equipoIngenieroUnico == null)) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
           respuestaDTO.setEquipoIngenieroDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdEquipoIngeniero = equipoIngenieroRepository.findMaxIdEquipoIngeniero();
           if (maxIdEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdEquipoIngeniero = Long.valueOf(0);
           }
           equipoIngenieroDTO.setIdEquipoIngeniero(maxIdEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           equipoIngenieroRepository.save(equipoIngenieroDAO.equipoIngeniero(equipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEquipoIngenieroporId(Long idEquipoIngeniero) {
        Optional<EquipoIngeniero> equipoIngenieroId = equipoIngenieroRepository.findByIdEquipoIngeniero(Long.valueOf(idEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (equipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (equipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO INVENTARIO Y NUMERO ACTIVO FIJO (CAMPOS ÚNICOS COMBINADOS):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEquipoIngenieroporNumeroInventarioNumeroActivoFijo(String numeroInventarioEquipoIngeniero, String numeroActivoFijoEquipoIngeniero) {
        if (numeroInventarioEquipoIngeniero == null && numeroActivoFijoEquipoIngeniero == null) {//SI TODOS LOS PARAMETROS SON NULOS NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setEquipoIngenieroDTO(null);
           return respuestaDTO;
        }
        Optional<EquipoIngeniero> equipoIngenieroNumero = Optional.ofNullable(equipoIngenieroRepository.findByNumeroInventarioEquipoIngenieroOrNumeroActivoFijoEquipoIngeniero(numeroInventarioEquipoIngeniero, numeroActivoFijoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
        
        if (equipoIngenieroNumero.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipoIngenieroNumero.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (equipoIngenieroNumero.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarEquipoIngeniero(EquipoIngenieroDTO equipoIngenieroDTO) {
        Optional<EquipoIngeniero> equipoIngenieroId = equipoIngenieroRepository.findByIdEquipoIngeniero(equipoIngenieroDTO.getIdEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (equipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DE LOS CAMPOS ÚNICOS DEL REGISTRO CON EL ID PROPORCIONADO.
           EquipoIngeniero equipoIngenieroUnico = equipoIngenieroRepository.findByNumeroInventarioEquipoIngenieroOrNumeroActivoFijoEquipoIngeniero(equipoIngenieroDTO.getNumeroInventarioEquipoIngeniero(), equipoIngenieroDTO.getNumeroActivoFijoEquipoIngeniero());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(equipoIngenieroUnico == null) && !(equipoIngenieroUnico.getIdEquipoIngeniero().equals(equipoIngenieroDTO.getIdEquipoIngeniero()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO INVENTARIO O NUMERO ACTIVO FIJO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON LOS MISMOS CAMPOS ÚNICOS ASOCIADOS A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
              respuestaDTO.setEquipoIngenieroDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON LOS MISMOS CAMPOS ÚNICOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              equipoIngenieroRepository.save(equipoIngenieroDAO.equipoIngeniero(equipoIngenieroDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (equipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarEquipoIngeniero(Long idEquipoIngeniero) {
        Optional<EquipoIngeniero> equipoIngenieroId = equipoIngenieroRepository.findById(idEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (equipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setEquipoIngenieroDTO(equipoIngenieroDAO.equipoIngenieroDTO(equipoIngenieroId.get()));
           equipoIngenieroRepository.delete(equipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (equipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
