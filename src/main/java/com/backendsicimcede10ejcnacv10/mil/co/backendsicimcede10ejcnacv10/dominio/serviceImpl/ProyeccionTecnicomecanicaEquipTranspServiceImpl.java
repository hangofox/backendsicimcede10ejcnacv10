//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionTecnicomecanicaEquipTranspDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionTecnicomecanicaEquipTranspService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionTecnicomecanicaEquipTranspDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionTecnicomecanicaEquipTransp;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionTecnicomecanicaEquipTranspRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProyeccionTecnicomecanicaEquipTranspServiceImpl implements ProyeccionTecnicomecanicaEquipTranspService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionTecnicomecanicaEquipTranspDAO proyeccionTecnicomecanicaEquipTranspDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionTecnicomecanicaEquipTranspRepository proyeccionTecnicomecanicaEquipTranspRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionTecnicomecanicaEquipTransp, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, String keyword) {
        return proyeccionTecnicomecanicaEquipTranspRepository.findTotalRegistros(idProyeccionTecnicomecanicaEquipTransp, idEquipoIngeniero, nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, valorSolicitadoProyeccionTecnicomecanicaEquipTransp, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionTecnicomecanicaEquipTranspDTO> listarProyeccionesTecnicomecanicasEquipsTransps(Long idProyeccionTecnicomecanicaEquipTransp, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, String keyword, String orderBy, String orderMode) {
        List<ProyeccionTecnicomecanicaEquipTransp> proyeccionesTecnicomecanicasEquipsTransps = proyeccionTecnicomecanicaEquipTranspRepository.findAllProyeccionesTecnicomecanicasEquipsTransps(idProyeccionTecnicomecanicaEquipTransp, idEquipoIngeniero, nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, valorSolicitadoProyeccionTecnicomecanicaEquipTransp, keyword, orderBy, orderMode);
        List<ProyeccionTecnicomecanicaEquipTranspDTO> proyeccionTecnicomecanicaEquipTranspDTOS = new ArrayList<>();
        for (ProyeccionTecnicomecanicaEquipTransp proyeccionTecnicomecanicaEquipTransp : proyeccionesTecnicomecanicasEquipsTransps) {
            proyeccionTecnicomecanicaEquipTranspDTOS.add(proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTranspDTO(proyeccionTecnicomecanicaEquipTransp));
        }
        
        return proyeccionTecnicomecanicaEquipTranspDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionTecnicomecanicaEquipTranspDTO> listarProyeccionesTecnicomecanicasEquipsTranspsPag(Pageable pageable, Long idProyeccionTecnicomecanicaEquipTransp, Long idEquipoIngeniero, String nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, String valorSolicitadoProyeccionTecnicomecanicaEquipTransp, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionTecnicomecanicaEquipTransp> proyeccionesTecnicomecanicasEquipsTransps = proyeccionTecnicomecanicaEquipTranspRepository.findAllProyeccionesTecnicomecanicasEquipsTranspsPag(pageable, idProyeccionTecnicomecanicaEquipTransp, idEquipoIngeniero, nombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp, valorSolicitadoProyeccionTecnicomecanicaEquipTransp, keyword, orderBy, orderMode);
        return proyeccionesTecnicomecanicasEquipsTransps.map(proyeccionTecnicomecanicaEquipTransp -> proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTranspDTO(proyeccionTecnicomecanicaEquipTransp));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionTecnicomecanicaEquipTransp(ProyeccionTecnicomecanicaEquipTranspDTO proyeccionTecnicomecanicaEquipTranspDTO) {
        Long maxIdProyeccionTecnicomecanicaEquipTransp = null;
        ProyeccionTecnicomecanicaEquipTransp proyeccionTecnicomecanicaEquipTranspNombreEIdEquipoIngeniero = proyeccionTecnicomecanicaEquipTranspRepository.findByNombreYNumeroRubroAndIdEquipoIngeniero(proyeccionTecnicomecanicaEquipTranspDTO.getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp().toUpperCase(), proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionTecnicomecanicaEquipTranspNombreEIdEquipoIngeniero == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_TECNICOMECANICA_EQUIP_TRANSP_YA_EXISTE_EN_EQUIPO_INGENIERO, false);
           respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO EQUIPO DE INGENIERO CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdProyeccionTecnicomecanicaEquipTransp = proyeccionTecnicomecanicaEquipTranspRepository.findMaxIdProyeccionTecnicomecanicaEquipTransp();
           if (maxIdProyeccionTecnicomecanicaEquipTransp == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdProyeccionTecnicomecanicaEquipTransp = Long.valueOf(0);
           }
           proyeccionTecnicomecanicaEquipTranspDTO.setIdProyeccionTecnicomecanicaEquipTransp(maxIdProyeccionTecnicomecanicaEquipTransp + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           proyeccionTecnicomecanicaEquipTranspRepository.save(proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionTecnicomecanicaEquipTranspporId(Long idProyeccionTecnicomecanicaEquipTransp) {
        Optional<ProyeccionTecnicomecanicaEquipTransp> proyeccionTecnicomecanicaEquipTranspId = proyeccionTecnicomecanicaEquipTranspRepository.findByIdProyeccionTecnicomecanicaEquipTransp(Long.valueOf(idProyeccionTecnicomecanicaEquipTransp));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionTecnicomecanicaEquipTranspId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTranspDTO(proyeccionTecnicomecanicaEquipTranspId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionTecnicomecanicaEquipTranspId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionTecnicomecanicaEquipTransp(ProyeccionTecnicomecanicaEquipTranspDTO proyeccionTecnicomecanicaEquipTranspDTO) {
        Optional<ProyeccionTecnicomecanicaEquipTransp> proyeccionTecnicomecanicaEquipTranspId = proyeccionTecnicomecanicaEquipTranspRepository.findByIdProyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO.getIdProyeccionTecnicomecanicaEquipTransp());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionTecnicomecanicaEquipTranspId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (proyeccionTecnicomecanicaEquipTranspDTO.getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp().equals(proyeccionTecnicomecanicaEquipTranspId.get().getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI EL EQUIPO DE INGENIERO CAMBIO.
              if ( (proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero().equals(proyeccionTecnicomecanicaEquipTranspId.get().getEquipoIngeniero().getIdEquipoIngeniero())==true) ) {//SI EL EQUIPO DE INGENIERO NO CAMBIO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionTecnicomecanicaEquipTranspRepository.save(proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero().equals(proyeccionTecnicomecanicaEquipTranspId.get().getEquipoIngeniero().getIdEquipoIngeniero())==false) {//SI EL EQUIPO DE INGENIERO CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN EL NUEVO EQUIPO DE INGENIERO.
                 ProyeccionTecnicomecanicaEquipTransp proyeccionTecnicomecanicaEquipTranspNombreEIdEquipoIngeniero = proyeccionTecnicomecanicaEquipTranspRepository.findByNombreYNumeroRubroAndIdEquipoIngeniero(proyeccionTecnicomecanicaEquipTranspDTO.getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp().toUpperCase(), proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionTecnicomecanicaEquipTranspNombreEIdEquipoIngeniero == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO AL NUEVO EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN EL NUEVO EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_TECNICOMECANICA_EQUIP_TRANSP_NO_MODIFICAR_EN_EQUIPO_INGENIERO, false);
                    respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN EL NUEVO EQUIPO DE INGENIERO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionTecnicomecanicaEquipTranspRepository.save(proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (proyeccionTecnicomecanicaEquipTranspDTO.getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp().equals(proyeccionTecnicomecanicaEquipTranspId.get().getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADO A UN MISMO EQUIPO DE INGENIERO.
              ProyeccionTecnicomecanicaEquipTransp proyeccionTecnicomecanicaEquipTranspNombreEIdEquipoIngeniero = proyeccionTecnicomecanicaEquipTranspRepository.findByNombreYNumeroRubroAndIdEquipoIngeniero(proyeccionTecnicomecanicaEquipTranspDTO.getNombreYNumeroRubroProyeccionTecnicomecanicaEquipTransp().toUpperCase(), proyeccionTecnicomecanicaEquipTranspDTO.getEquipoIngenieroDTO().getIdEquipoIngeniero());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(proyeccionTecnicomecanicaEquipTranspNombreEIdEquipoIngeniero == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO EQUIPO DE INGENIERO MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO EQUIPO DE INGENIERO Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_TECNICOMECANICA_EQUIP_TRANSP_NO_MODIFICAR_EN_EQUIPO_INGENIERO, false);
                 respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO EQUIPO DE INGENIERO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 proyeccionTecnicomecanicaEquipTranspRepository.save(proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTransp(proyeccionTecnicomecanicaEquipTranspDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (proyeccionTecnicomecanicaEquipTranspId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionTecnicomecanicaEquipTransp(Long idProyeccionTecnicomecanicaEquipTransp) {
        Optional<ProyeccionTecnicomecanicaEquipTransp> proyeccionTecnicomecanicaEquipTranspId = proyeccionTecnicomecanicaEquipTranspRepository.findById(idProyeccionTecnicomecanicaEquipTransp);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionTecnicomecanicaEquipTranspId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(proyeccionTecnicomecanicaEquipTranspDAO.proyeccionTecnicomecanicaEquipTranspDTO(proyeccionTecnicomecanicaEquipTranspId.get()));
           proyeccionTecnicomecanicaEquipTranspRepository.delete(proyeccionTecnicomecanicaEquipTranspId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionTecnicomecanicaEquipTranspId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionTecnicomecanicaEquipTranspDTO(null);
        }
        
        return respuestaDTO;
    }
}
