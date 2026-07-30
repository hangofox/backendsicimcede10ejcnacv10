//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ProyeccionPlanAnualPozoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ProyeccionPlanAnualPozoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ProyeccionPlanAnualPozoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ProyeccionPlanAnualPozo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ProyeccionPlanAnualPozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ProyeccionPlanAnualPozoServiceImpl implements ProyeccionPlanAnualPozoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ProyeccionPlanAnualPozoDAO proyeccionPlanAnualPozoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ProyeccionPlanAnualPozoRepository proyeccionPlanAnualPozoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idProyeccionPlanAnualPozo, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualPozo, Long idTipoMantenimientoPozo, String nombreYNumeroRubroProyeccionPlanAnualPozo, String valorSolicitadoProyeccionPlanAnualPozo, String nombreBienOServicioProyeccionPlanAnualPozo, Long idInfraestructura, String keyword) {
        return proyeccionPlanAnualPozoRepository.findTotalRegistros(idProyeccionPlanAnualPozo, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualPozo, idTipoMantenimientoPozo, nombreYNumeroRubroProyeccionPlanAnualPozo, valorSolicitadoProyeccionPlanAnualPozo, nombreBienOServicioProyeccionPlanAnualPozo, idInfraestructura, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ProyeccionPlanAnualPozoDTO> listarProyeccionesPlanesAnualesPozos(Long idProyeccionPlanAnualPozo, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualPozo, Long idTipoMantenimientoPozo, String nombreYNumeroRubroProyeccionPlanAnualPozo, String valorSolicitadoProyeccionPlanAnualPozo, String nombreBienOServicioProyeccionPlanAnualPozo, Long idInfraestructura, String keyword, String orderBy, String orderMode) {
        List<ProyeccionPlanAnualPozo> proyeccionesPlanesAnualesPozos = proyeccionPlanAnualPozoRepository.findAllProyeccionesPlanesAnualesPozos(idProyeccionPlanAnualPozo, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualPozo, idTipoMantenimientoPozo, nombreYNumeroRubroProyeccionPlanAnualPozo, valorSolicitadoProyeccionPlanAnualPozo, nombreBienOServicioProyeccionPlanAnualPozo, idInfraestructura, keyword, orderBy, orderMode);
        List<ProyeccionPlanAnualPozoDTO> proyeccionPlanAnualPozoDTOS = new ArrayList<>();
        for (ProyeccionPlanAnualPozo proyeccionPlanAnualPozo : proyeccionesPlanesAnualesPozos) {
            proyeccionPlanAnualPozoDTOS.add(proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozoDTO(proyeccionPlanAnualPozo));
        }
        
        return proyeccionPlanAnualPozoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ProyeccionPlanAnualPozoDTO> listarProyeccionesPlanesAnualesPozosPag(Pageable pageable, Long idProyeccionPlanAnualPozo, Long idProyeccionPlanAnualAdqGeneral, String nombreProyeccionPlanAnualPozo, Long idTipoMantenimientoPozo, String nombreYNumeroRubroProyeccionPlanAnualPozo, String valorSolicitadoProyeccionPlanAnualPozo, String nombreBienOServicioProyeccionPlanAnualPozo, Long idInfraestructura, String keyword, String orderBy, String orderMode) {
        Slice<ProyeccionPlanAnualPozo> proyeccionesPlanesAnualesPozos = proyeccionPlanAnualPozoRepository.findAllProyeccionesPlanesAnualesPozosPag(pageable, idProyeccionPlanAnualPozo, idProyeccionPlanAnualAdqGeneral, nombreProyeccionPlanAnualPozo, idTipoMantenimientoPozo, nombreYNumeroRubroProyeccionPlanAnualPozo, valorSolicitadoProyeccionPlanAnualPozo, nombreBienOServicioProyeccionPlanAnualPozo, idInfraestructura, keyword, orderBy, orderMode);
        return proyeccionesPlanesAnualesPozos.map(proyeccionPlanAnualPozo -> proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozoDTO(proyeccionPlanAnualPozo));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearProyeccionPlanAnualPozo(ProyeccionPlanAnualPozoDTO proyeccionPlanAnualPozoDTO) {
        Long maxIdProyeccionPlanAnualPozo = proyeccionPlanAnualPozoRepository.findMaxIdProyeccionPlanAnualPozo();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdProyeccionPlanAnualPozo == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdProyeccionPlanAnualPozo = Long.valueOf(0);
        }
        proyeccionPlanAnualPozoDTO.setIdProyeccionPlanAnualPozo(maxIdProyeccionPlanAnualPozo + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        ProyeccionPlanAnualPozo proyeccionPlanAnualPozoNombreIdProyeccionPlanAnualAdqGeneralIdTipoMantenimientoPozoEIdInfraestructura = proyeccionPlanAnualPozoRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdTipoMantenimientoPozoAndIdInfraestructura(proyeccionPlanAnualPozoDTO.getNombreProyeccionPlanAnualPozo().toUpperCase(), proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO().getIdTipoMantenimientoPozo(), proyeccionPlanAnualPozoDTO.getInfraestructuraDTO().getIdInfraestructura());
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(proyeccionPlanAnualPozoNombreIdProyeccionPlanAnualAdqGeneralIdTipoMantenimientoPozoEIdInfraestructura == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO ASOCIADO AL MISMO PLAN ANUAL ADQ GENERAL, TIPO MANTENIMIENTO POZO E INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN LA COMBINACION MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_POZO_YA_EXISTE_EN_PLAN_ANUAL_ADQ_GENERAL_TIPO_MANTENIMIENTO_POZO_E_INFRAESTRUCTURA, false);
           respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI EL NOMBRE NO ESTA REPETIDO EN LA COMBINACION SE VERIFICA EL NOMBRE Y NUMERO DE RUBRO.
           ProyeccionPlanAnualPozo proyeccionPlanAnualPozoNombreYNumeroRubro = proyeccionPlanAnualPozoRepository.findByNombreYNumeroRubroProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getNombreYNumeroRubroProyeccionPlanAnualPozo().toUpperCase());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaNombreYNumeroRubroRegistroEncontrado = 0;
           
           if (!(proyeccionPlanAnualPozoNombreYNumeroRubro == null)) {//SI ENCONTRO EL NOMBRE Y NUMERO DE RUBRO DEL REGISTRO MUESTRA UN MENSAJE DE NOMBRE Y NUMERO DE RUBRO REPETIDO.
              banderaNombreYNumeroRubroRegistroEncontrado = 1;
           }
           
           if (banderaNombreYNumeroRubroRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE Y NUMERO DE RUBRO YA EXISTE MUESTRA UN MENSAJE DE NOMBRE Y NUMERO DE RUBRO REPETIDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_POZO_NOMBRE_Y_NUMERO_RUBRO_YA_EXISTE, false);
              respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
           }
           if (banderaNombreYNumeroRubroRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE Y NUMERO DE RUBRO NO EXISTE SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
              proyeccionPlanAnualPozoRepository.save(proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
           }
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarProyeccionPlanAnualPozoporId(Long idProyeccionPlanAnualPozo) {
        Optional<ProyeccionPlanAnualPozo> proyeccionPlanAnualPozoId = proyeccionPlanAnualPozoRepository.findByIdProyeccionPlanAnualPozo(Long.valueOf(idProyeccionPlanAnualPozo));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualPozoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualPozoDTO(proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozoDTO(proyeccionPlanAnualPozoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (proyeccionPlanAnualPozoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarProyeccionPlanAnualPozo(ProyeccionPlanAnualPozoDTO proyeccionPlanAnualPozoDTO) {
        Optional<ProyeccionPlanAnualPozo> proyeccionPlanAnualPozoId = proyeccionPlanAnualPozoRepository.findByIdProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getIdProyeccionPlanAnualPozo());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (proyeccionPlanAnualPozoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE Y NUMERO DE RUBRO DEL REGISTRO.
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaNombreYNumeroRubroRegistroEncontrado = 0;
           
           if (proyeccionPlanAnualPozoDTO.getNombreYNumeroRubroProyeccionPlanAnualPozo().equals(proyeccionPlanAnualPozoId.get().getNombreYNumeroRubroProyeccionPlanAnualPozo()) == false) {//SI EL NOMBRE Y NUMERO DE RUBRO DIGITADO ES DIFERENTE AL ALMACENADO SE VERIFICA QUE NO EXISTA EN OTRO REGISTRO.
              ProyeccionPlanAnualPozo proyeccionPlanAnualPozoNombreYNumeroRubro = proyeccionPlanAnualPozoRepository.findByNombreYNumeroRubroProyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO.getNombreYNumeroRubroProyeccionPlanAnualPozo().toUpperCase());
              if (!(proyeccionPlanAnualPozoNombreYNumeroRubro == null)) {//SI ENCONTRO EL NOMBRE Y NUMERO DE RUBRO EN OTRO REGISTRO ACTIVA LA BANDERA.
                 banderaNombreYNumeroRubroRegistroEncontrado = 1;
              }
           }
           
           if (banderaNombreYNumeroRubroRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCUENTRA EL NOMBRE Y NUMERO DE RUBRO REPETIDO MUESTRA UN MENSAJE DE NOMBRE Y NUMERO DE RUBRO REPETIDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_POZO_NOMBRE_Y_NUMERO_RUBRO_NO_MODIFICAR, false);
              respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
           }
           if (banderaNombreYNumeroRubroRegistroEncontrado == 0) {//SI EL NOMBRE Y NUMERO DE RUBRO NO ESTA REPETIDO SE VERIFICA EL NOMBRE DEL REGISTRO.
              if ((proyeccionPlanAnualPozoDTO.getNombreProyeccionPlanAnualPozo().equals(proyeccionPlanAnualPozoId.get().getNombreProyeccionPlanAnualPozo()) == true)) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI LOS FK CAMBIARON.
                 if ((proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualPozoId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) &&
                     (proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO().getIdTipoMantenimientoPozo().equals(proyeccionPlanAnualPozoId.get().getTipoMantenimientoPozo().getIdTipoMantenimientoPozo()) == true) &&
                     (proyeccionPlanAnualPozoDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionPlanAnualPozoId.get().getInfraestructura().getIdInfraestructura()) == true)) {//SI EL PLAN ANUAL ADQ GENERAL, TIPO MANTENIMIENTO POZO E INFRAESTRUCTURA NO CAMBIARON SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualPozoRepository.save(proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
                 if (!((proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral().equals(proyeccionPlanAnualPozoId.get().getProyeccionPlanAnualAdqGeneral().getIdProyeccionPlanAnualAdqGeneral()) == true) && (proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO().getIdTipoMantenimientoPozo().equals(proyeccionPlanAnualPozoId.get().getTipoMantenimientoPozo().getIdTipoMantenimientoPozo()) == true) && (proyeccionPlanAnualPozoDTO.getInfraestructuraDTO().getIdInfraestructura().equals(proyeccionPlanAnualPozoId.get().getInfraestructura().getIdInfraestructura()) == true))) {//SI ALGUNO DE LOS FK CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN LA NUEVA COMBINACION DE FK.
                    ProyeccionPlanAnualPozo proyeccionPlanAnualPozoNombreIdProyeccionPlanAnualAdqGeneralIdTipoMantenimientoPozoEIdInfraestructura = proyeccionPlanAnualPozoRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdTipoMantenimientoPozoAndIdInfraestructura(proyeccionPlanAnualPozoDTO.getNombreProyeccionPlanAnualPozo().toUpperCase(), proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO().getIdTipoMantenimientoPozo(), proyeccionPlanAnualPozoDTO.getInfraestructuraDTO().getIdInfraestructura());
                    
                    //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                    long banderaNombreRegistroEncontrado = 0;
                    
                    if (!(proyeccionPlanAnualPozoNombreIdProyeccionPlanAnualAdqGeneralIdTipoMantenimientoPozoEIdInfraestructura == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO CON LA NUEVA COMBINACION DE FK MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                       banderaNombreRegistroEncontrado = 1;
                    }
                    
                    if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCUENTRA EL REGISTRO REPETIDO MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                       respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_POZO_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_TIPO_MANTENIMIENTO_POZO_E_INFRAESTRUCTURA, false);
                       respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
                    }
                    if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA NO ENCUENTRA REGISTRO REPETIDO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                       proyeccionPlanAnualPozoRepository.save(proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO));
                       respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                    }
                 }
              }
              if (proyeccionPlanAnualPozoDTO.getNombreProyeccionPlanAnualPozo().equals(proyeccionPlanAnualPozoId.get().getNombreProyeccionPlanAnualPozo()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS CON LA MISMA COMBINACION DE FK.
                 ProyeccionPlanAnualPozo proyeccionPlanAnualPozoNombreIdProyeccionPlanAnualAdqGeneralIdTipoMantenimientoPozoEIdInfraestructura = proyeccionPlanAnualPozoRepository.findByNombreAndIdProyeccionPlanAnualAdqGeneralAndIdTipoMantenimientoPozoAndIdInfraestructura(proyeccionPlanAnualPozoDTO.getNombreProyeccionPlanAnualPozo().toUpperCase(), proyeccionPlanAnualPozoDTO.getProyeccionPlanAnualAdqGeneralDTO().getIdProyeccionPlanAnualAdqGeneral(), proyeccionPlanAnualPozoDTO.getTipoMantenimientoPozoDTO().getIdTipoMantenimientoPozo(), proyeccionPlanAnualPozoDTO.getInfraestructuraDTO().getIdInfraestructura());
                 
                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;
                 
                 if (!(proyeccionPlanAnualPozoNombreIdProyeccionPlanAnualAdqGeneralIdTipoMantenimientoPozoEIdInfraestructura == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO CON LA MISMA COMBINACION DE FK MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
                    banderaNombreRegistroEncontrado = 1;
                 }
                 
                 if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCUENTRA EL REGISTRO REPETIDO MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_PROYECCION_PLAN_ANUAL_POZO_NO_MODIFICAR_EN_PLAN_ANUAL_ADQ_GENERAL_TIPO_MANTENIMIENTO_POZO_E_INFRAESTRUCTURA, false);
                    respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA NO ENCUENTRA REGISTRO REPETIDO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    proyeccionPlanAnualPozoRepository.save(proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozo(proyeccionPlanAnualPozoDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
        }
        if (proyeccionPlanAnualPozoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarProyeccionPlanAnualPozo(Long idProyeccionPlanAnualPozo) {
        Optional<ProyeccionPlanAnualPozo> proyeccionPlanAnualPozoId = proyeccionPlanAnualPozoRepository.findById(idProyeccionPlanAnualPozo);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (proyeccionPlanAnualPozoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setProyeccionPlanAnualPozoDTO(proyeccionPlanAnualPozoDAO.proyeccionPlanAnualPozoDTO(proyeccionPlanAnualPozoId.get()));
           proyeccionPlanAnualPozoRepository.delete(proyeccionPlanAnualPozoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (proyeccionPlanAnualPozoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setProyeccionPlanAnualPozoDTO(null);
        }
        
        return respuestaDTO;
    }
}
