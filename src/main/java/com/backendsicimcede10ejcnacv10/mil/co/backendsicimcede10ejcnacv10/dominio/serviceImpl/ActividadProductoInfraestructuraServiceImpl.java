//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ActividadProductoInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ActividadProductoInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ActividadProductoInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ActividadProductoInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ActividadProductoInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ActividadProductoInfraestructuraServiceImpl implements ActividadProductoInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ActividadProductoInfraestructuraDAO actividadProductoInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ActividadProductoInfraestructuraRepository actividadProductoInfraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idActividadProductoInfraestructura, String keyword, String nombreCapituloInfraestructura) {
        return actividadProductoInfraestructuraRepository.findTotalRegistros(idActividadProductoInfraestructura, keyword, nombreCapituloInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ActividadProductoInfraestructuraDTO> listarActividadesProductosInfraestructuras(Long idActividadProductoInfraestructura, String keyword, String nombreCapituloInfraestructura, String orderBy, String orderMode) {
        List<ActividadProductoInfraestructura> actividadesProductosInfraestructuras = actividadProductoInfraestructuraRepository.findAllActividadesProductosInfraestructuras(idActividadProductoInfraestructura, keyword, nombreCapituloInfraestructura, orderBy, orderMode);
        List<ActividadProductoInfraestructuraDTO> actividadProductoInfraestructuraDTOS = new ArrayList<>();
        for (ActividadProductoInfraestructura actividadProductoInfraestructura : actividadesProductosInfraestructuras) {
            actividadProductoInfraestructuraDTOS.add(actividadProductoInfraestructuraDAO.actividadProductoInfraestructuraDTO(actividadProductoInfraestructura));
        }
        
        return actividadProductoInfraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<ActividadProductoInfraestructuraDTO> listarActividadesProductosInfraestructurasPag(Pageable pageable, Long idActividadProductoInfraestructura, String keyword, String nombreCapituloInfraestructura, String orderBy, String orderMode) {
        Slice<ActividadProductoInfraestructura> actividadesProductosInfraestructuras = actividadProductoInfraestructuraRepository.findAllActividadesProductosInfraestructurasPag(pageable, idActividadProductoInfraestructura, keyword, nombreCapituloInfraestructura, orderBy, orderMode);
        return actividadesProductosInfraestructuras.map(actividadProductoInfraestructura -> actividadProductoInfraestructuraDAO.actividadProductoInfraestructuraDTO(actividadProductoInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearActividadProductoInfraestructura(ActividadProductoInfraestructuraDTO actividadProductoInfraestructuraDTO) {
        Long maxIdActividadProductoInfraestructura = null;
        ActividadProductoInfraestructura actividadProductoInfraestructuraNombreYCapitulo = actividadProductoInfraestructuraRepository.findByNombreCapituloInfraestructuraAndNombreActividadProductoInfraestructura(actividadProductoInfraestructuraDTO.getCapituloInfraestructuraDTO().getNombreCapituloInfraestructura(), actividadProductoInfraestructuraDTO.getNombreActividadProductoInfraestructura().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(actividadProductoInfraestructuraNombreYCapitulo == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO CAPÍTULO DE INFRAESTRUCTURA MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO CAPÍTULO DE INFRAESTRUCTURA MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setActividadProductoInfraestructuraDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO CAPÍTULO DE INFRAESTRUCTURA CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdActividadProductoInfraestructura = actividadProductoInfraestructuraRepository.findMaxIdActividadProductoInfraestructura();
           if (maxIdActividadProductoInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdActividadProductoInfraestructura = Long.valueOf(0);
           }
           actividadProductoInfraestructuraDTO.setIdActividadProductoInfraestructura(maxIdActividadProductoInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           actividadProductoInfraestructuraRepository.save(actividadProductoInfraestructuraDAO.actividadProductoInfraestructura(actividadProductoInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarActividadProductoInfraestructuraporId(Long idActividadProductoInfraestructura) {
        Optional<ActividadProductoInfraestructura> actividadProductoInfraestructuraId = actividadProductoInfraestructuraRepository.findByIdActividadProductoInfraestructura(Long.valueOf(idActividadProductoInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (actividadProductoInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setActividadProductoInfraestructuraDTO(actividadProductoInfraestructuraDAO.actividadProductoInfraestructuraDTO(actividadProductoInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (actividadProductoInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setActividadProductoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y NOMBRE CAPÍTULO DE INFRAESTRUCTURA:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarActividadProductoInfraestructuraporNombreYNombreCapituloInfraestructura(String nombreActividadProductoInfraestructura, String nombreCapituloInfraestructura) {
        Optional<ActividadProductoInfraestructura> actividadProductoInfraestructuraNombre = Optional.ofNullable(actividadProductoInfraestructuraRepository.findByNombreCapituloInfraestructuraAndNombreActividadProductoInfraestructura(String.valueOf(nombreCapituloInfraestructura), String.valueOf(nombreActividadProductoInfraestructura)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (actividadProductoInfraestructuraNombre.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setActividadProductoInfraestructuraDTO(actividadProductoInfraestructuraDAO.actividadProductoInfraestructuraDTO(actividadProductoInfraestructuraNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (actividadProductoInfraestructuraNombre.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setActividadProductoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarActividadProductoInfraestructura(ActividadProductoInfraestructuraDTO actividadProductoInfraestructuraDTO) {
        Optional<ActividadProductoInfraestructura> actividadProductoInfraestructuraId = actividadProductoInfraestructuraRepository.findByIdActividadProductoInfraestructura(actividadProductoInfraestructuraDTO.getIdActividadProductoInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (actividadProductoInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (actividadProductoInfraestructuraDTO.getNombreActividadProductoInfraestructura().equals(actividadProductoInfraestructuraId.get().getNombreActividadProductoInfraestructura()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              actividadProductoInfraestructuraRepository.save(actividadProductoInfraestructuraDAO.actividadProductoInfraestructura(actividadProductoInfraestructuraDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (actividadProductoInfraestructuraDTO.getNombreActividadProductoInfraestructura().equals(actividadProductoInfraestructuraId.get().getNombreActividadProductoInfraestructura()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UN MISMO CAPÍTULO DE INFRAESTRUCTURA.
              ActividadProductoInfraestructura actividadProductoInfraestructuraNombreYCapitulo = actividadProductoInfraestructuraRepository.findByNombreCapituloInfraestructuraAndNombreActividadProductoInfraestructura(actividadProductoInfraestructuraDTO.getCapituloInfraestructuraDTO().getNombreCapituloInfraestructura(), actividadProductoInfraestructuraDTO.getNombreActividadProductoInfraestructura().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(actividadProductoInfraestructuraNombreYCapitulo == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO CAPÍTULO DE INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO CAPÍTULO DE INFRAESTRUCTURA Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setActividadProductoInfraestructuraDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO CAPÍTULO DE INFRAESTRUCTURA SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 actividadProductoInfraestructuraRepository.save(actividadProductoInfraestructuraDAO.actividadProductoInfraestructura(actividadProductoInfraestructuraDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (actividadProductoInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setActividadProductoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarActividadProductoInfraestructura(Long idActividadProductoInfraestructura) {
        Optional<ActividadProductoInfraestructura> actividadProductoInfraestructuraId = actividadProductoInfraestructuraRepository.findById(idActividadProductoInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (actividadProductoInfraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setActividadProductoInfraestructuraDTO(actividadProductoInfraestructuraDAO.actividadProductoInfraestructuraDTO(actividadProductoInfraestructuraId.get()));
           actividadProductoInfraestructuraRepository.delete(actividadProductoInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (actividadProductoInfraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setActividadProductoInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
