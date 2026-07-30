//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PersonalMantenimientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.PersonalMantenimientoEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.PersonalMantenimientoEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PersonalMantenimientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.PersonalMantenimientoEquipoIngenieroRepository;
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
public class PersonalMantenimientoEquipoIngenieroServiceImpl implements PersonalMantenimientoEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private PersonalMantenimientoEquipoIngenieroDAO personalMantenimientoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private PersonalMantenimientoEquipoIngenieroRepository personalMantenimientoEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idPersonalMantenimientoEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar) {
        return personalMantenimientoEquipoIngenieroRepository.findTotalRegistros(idPersonalMantenimientoEquipoIngeniero, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<PersonalMantenimientoEquipoIngenieroDTO> listarPersonalMantenimientosEquiposIngenieros(Long idPersonalMantenimientoEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<PersonalMantenimientoEquipoIngeniero> personalMantenimientosEquiposIngenieros = personalMantenimientoEquipoIngenieroRepository.findAllPersonalMantenimientosEquiposIngenieros(idPersonalMantenimientoEquipoIngeniero, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<PersonalMantenimientoEquipoIngenieroDTO> personalMantenimientoEquipoIngeneroDTOS = new ArrayList<>();
        for (PersonalMantenimientoEquipoIngeniero personalMantenimientoEquipoIngeniero : personalMantenimientosEquiposIngenieros) {
            personalMantenimientoEquipoIngeneroDTOS.add(personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngeniero));
        }
        
        return personalMantenimientoEquipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<PersonalMantenimientoEquipoIngenieroDTO> listarPersonalMantenimientosEquiposIngenierosPag(Pageable pageable, Long idPersonalMantenimientoEquipoIngeniero, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<PersonalMantenimientoEquipoIngeniero> personalMantenimientosEquiposIngenieros = personalMantenimientoEquipoIngenieroRepository.findAllPersonalMantenimientosEquiposIngenierosPag(pageable, idPersonalMantenimientoEquipoIngeniero, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return personalMantenimientosEquiposIngenieros.map(personalMantenimientoEquipoIngeniero -> personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearPersonalMantenimientoEquipoIngeniero(PersonalMantenimientoEquipoIngenieroDTO personalMantenimientoEquipoIngenieroDTO) {
        Long maxIdPersonalMantenimientoEquipoIngeniero = null;
        PersonalMantenimientoEquipoIngeniero personalMantenimientoEquipoIngenieroNumDoc = personalMantenimientoEquipoIngenieroRepository.findByNumDocIdentifPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getNumDocIdentifPersonalMantenimientoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(personalMantenimientoEquipoIngenieroNumDoc == null)) {//SI ENCONTRO EL NUMERO DE DOCUMENTO DE IDENTIFICACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NUMERO DE DOCUMENTO PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE DOCUMENTO DE IDENTIFICACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NUMERO DE DOCUMENTO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE DOCUMENTO DE IDENTIFICACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdPersonalMantenimientoEquipoIngeniero = personalMantenimientoEquipoIngenieroRepository.findMaxIdPersonalMantenimientoEquipoIngeniero();
           if (maxIdPersonalMantenimientoEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdPersonalMantenimientoEquipoIngeniero = Long.valueOf(0);
           }
           personalMantenimientoEquipoIngenieroDTO.setIdPersonalMantenimientoEquipoIngeniero(maxIdPersonalMantenimientoEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           personalMantenimientoEquipoIngenieroRepository.save(personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarPersonalMantenimientoEquipoIngenieroporId(Long idPersonalMantenimientoEquipoIngeniero) {
        Optional<PersonalMantenimientoEquipoIngeniero> personalMantenimientoEquipoIngenieroId = personalMantenimientoEquipoIngenieroRepository.findByIdPersonalMantenimientoEquipoIngeniero(Long.valueOf(idPersonalMantenimientoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (personalMantenimientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (personalMantenimientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE DOCUMENTO DE IDENTIFICACION:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarPersonalMantenimientoEquipoIngenieroporNumDocIdentif(String numDocIdentifPersonalMantenimientoEquipoIngeniero) {
        Optional<PersonalMantenimientoEquipoIngeniero> personalMantenimientoEquipoIngenieroNumDoc = Optional.ofNullable(personalMantenimientoEquipoIngenieroRepository.findByNumDocIdentifPersonalMantenimientoEquipoIngeniero(String.valueOf(numDocIdentifPersonalMantenimientoEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (personalMantenimientoEquipoIngenieroNumDoc.isPresent() == true) {//SI ENCONTRO EL NUMERO DE DOCUMENTO DE IDENTIFICACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NUMERO DE DOCUMENTO PROPORCIONADO.
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngenieroNumDoc.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (personalMantenimientoEquipoIngenieroNumDoc.isPresent() == false) {//SI NO ENCONTRO EL NUMERO DE DOCUMENTO DE IDENTIFICACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NUMERO DE DOCUMENTO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarPersonalMantenimientoEquipoIngeniero(PersonalMantenimientoEquipoIngenieroDTO personalMantenimientoEquipoIngenieroDTO) {
        Optional<PersonalMantenimientoEquipoIngeniero> personalMantenimientoEquipoIngenieroId = personalMantenimientoEquipoIngenieroRepository.findByIdPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getIdPersonalMantenimientoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (personalMantenimientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NUMERO DE DOCUMENTO DE IDENTIFICACION DEL REGISTRO CON EL ID PROPORCIONADO.
           if (personalMantenimientoEquipoIngenieroDTO.getNumDocIdentifPersonalMantenimientoEquipoIngeniero().equals(personalMantenimientoEquipoIngenieroId.get().getNumDocIdentifPersonalMantenimientoEquipoIngeniero()) == true) {//SI EL NUMERO DE DOCUMENTO DIGITADO ES IGUAL AL ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              personalMantenimientoEquipoIngenieroRepository.save(personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (personalMantenimientoEquipoIngenieroDTO.getNumDocIdentifPersonalMantenimientoEquipoIngeniero().equals(personalMantenimientoEquipoIngenieroId.get().getNumDocIdentifPersonalMantenimientoEquipoIngeniero()) == false) {//SI EL NUMERO DE DOCUMENTO DIGITADO ES DIFERENTE AL ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NUMERO DE DOCUMENTO DIGITADO EXISTE EN OTROS REGISTROS.
              PersonalMantenimientoEquipoIngeniero personalMantenimientoEquipoIngenieroNumDoc = personalMantenimientoEquipoIngenieroRepository.findByNumDocIdentifPersonalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO.getNumDocIdentifPersonalMantenimientoEquipoIngeniero());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(personalMantenimientoEquipoIngenieroNumDoc == null)) {//SI ENCONTRO EL NUMERO DE DOCUMENTO DE IDENTIFICACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NUMERO DE DOCUMENTO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NUMERO DE DOCUMENTO DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NUMERO DE DOCUMENTO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NUMERO DE DOCUMENTO DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 personalMantenimientoEquipoIngenieroRepository.save(personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngeniero(personalMantenimientoEquipoIngenieroDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (personalMantenimientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarPersonalMantenimientoEquipoIngeniero(Long idPersonalMantenimientoEquipoIngeniero) {
        Optional<PersonalMantenimientoEquipoIngeniero> personalMantenimientoEquipoIngenieroId = personalMantenimientoEquipoIngenieroRepository.findById(idPersonalMantenimientoEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (personalMantenimientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngenieroDAO.personalMantenimientoEquipoIngenieroDTO(personalMantenimientoEquipoIngenieroId.get()));
           personalMantenimientoEquipoIngenieroRepository.delete(personalMantenimientoEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (personalMantenimientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setPersonalMantenimientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
