//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualAdqGeneralDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualAdqGeneralService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualAdqGeneralDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualAdqGeneral;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualAdqGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProyeccionPlanAnualAdqGeneralServiceImpl implements ProyeccionPlanAnualAdqGeneralService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualAdqGeneralDAO proyeccionPlanAnualAdqGeneralDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualAdqGeneralRepository proyeccionPlanAnualAdqGeneralRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqGeneral, String keyword) {
        return proyeccionPlanAnualAdqGeneralRepository.findTotalRegistros(idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqGeneral, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualAdqGeneralDTO> listarProyeccionesPlanesAnualesAdqGenerales(Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqGeneral, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualAdqGeneral> proyeccionesPlanesAnualesAdqGenerales = proyeccionPlanAnualAdqGeneralRepository.findAllProyeccionesPlanesAnualesAdqGenerales(idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqGeneral, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualAdqGeneralDTO> proyeccionPlanAnualAdqGeneralDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral : proyeccionesPlanesAnualesAdqGenerales) {
            proyeccionPlanAnualAdqGeneralDTOS.add(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneral));
        }
        
        return proyeccionPlanAnualAdqGeneralDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualAdqGeneralDTO> listarProyeccionesPlanesAnualesAdqGeneralesPag(Pageable pageable, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualAdqGeneral, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualAdqGeneral> proyeccionesPlanesAnualesAdqGenerales = proyeccionPlanAnualAdqGeneralRepository.findAllProyeccionesPlanesAnualesAdqGeneralesPag(pageable, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualAdqGeneral, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesAdqGenerales.map(proyeccionPlanAnualAdqGeneral -> proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneral));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneralDTO proyeccionPlanAnualAdqGeneralDTO) {
        Long maxIdProyeccionPlanAnualAdqGeneral=null;
        ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneralNombre = proyeccionPlanAnualAdqGeneralRepository.findByNombreProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO.getNombreProyeccionPlanAnualAdqGeneral().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(proyeccionPlanAnualAdqGeneralNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdProyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqGeneralRepository.findMaxIdProyeccionPlanAnualAdqGeneral();
           if (maxIdProyeccionPlanAnualAdqGeneral==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionPlanAnualAdqGeneral=Long.valueOf(0);
           }
           proyeccionPlanAnualAdqGeneralDTO.setIdProyeccionPlanAnualAdqGeneral(maxIdProyeccionPlanAnualAdqGeneral+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionPlanAnualAdqGeneralRepository.save(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualAdqGeneralporId(Long idProyeccionPlanAnualAdqGeneral) {
        Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralId = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(Long.valueOf(idProyeccionPlanAnualAdqGeneral));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqGeneralId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualAdqGeneralId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualAdqGeneralporNombre(String nombreProyeccionPlanAnualAdqGeneral) {
        Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralNombre = Optional.ofNullable(proyeccionPlanAnualAdqGeneralRepository.findByNombreProyeccionPlanAnualAdqGeneral(String.valueOf(nombreProyeccionPlanAnualAdqGeneral)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqGeneralNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualAdqGeneralNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualAdqGeneral(ProyeccionPlanAnualAdqGeneralDTO proyeccionPlanAnualAdqGeneralDTO) {
        Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralId = proyeccionPlanAnualAdqGeneralRepository.findByIdProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO.getIdProyeccionPlanAnualAdqGeneral());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualAdqGeneralId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (proyeccionPlanAnualAdqGeneralDTO.getNombreProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqGeneralId.get().getNombreProyeccionPlanAnualAdqGeneral())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO);
              proyeccionPlanAnualAdqGeneralRepository.save(proyeccionPlanAnualAdqGeneral);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (proyeccionPlanAnualAdqGeneralDTO.getNombreProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualAdqGeneralId.get().getNombreProyeccionPlanAnualAdqGeneral())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneralNombre = proyeccionPlanAnualAdqGeneralRepository.findByNombreProyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO.getNombreProyeccionPlanAnualAdqGeneral().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(proyeccionPlanAnualAdqGeneralNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 ProyeccionPlanAnualAdqGeneral proyeccionPlanAnualAdqGeneral = proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneral(proyeccionPlanAnualAdqGeneralDTO);
                 proyeccionPlanAnualAdqGeneralRepository.save(proyeccionPlanAnualAdqGeneral);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionPlanAnualAdqGeneralId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualAdqGeneral(Long idProyeccionPlanAnualAdqGeneral) {
        Optional<ProyeccionPlanAnualAdqGeneral> proyeccionPlanAnualAdqGeneralId  = proyeccionPlanAnualAdqGeneralRepository.findById(idProyeccionPlanAnualAdqGeneral);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualAdqGeneralId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralDAO.proyeccionPlanAnualAdqGeneralDTO(proyeccionPlanAnualAdqGeneralId.get()));
           proyeccionPlanAnualAdqGeneralRepository.delete(proyeccionPlanAnualAdqGeneralId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualAdqGeneralId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualAdqGeneralDTO(null);
        }
        
        return respuestaDTO;
    }
}
