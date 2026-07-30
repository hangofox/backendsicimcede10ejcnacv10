//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SeguroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.SeguroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.SeguroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Seguro;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class SeguroServiceImpl implements SeguroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private SeguroDAO seguroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SeguroRepository seguroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idSeguro, String keyword, String estadoSeguro) {
        return seguroRepository.findTotalRegistros(idSeguro, keyword, estadoSeguro);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<SeguroDTO> listarSeguros(Long idSeguro, String keyword, String estadoSeguro, String orderBy, String orderMode) {
        List<Seguro> seguros = seguroRepository.findAllSeguros(idSeguro, keyword, estadoSeguro, orderBy, orderMode);
        List<SeguroDTO> seguroDTOS = new ArrayList<>();
        for (Seguro seguro : seguros) {
            seguroDTOS.add(seguroDAO.seguroDTO(seguro));
        }
        
        return seguroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<SeguroDTO> listarSegurosPag(Pageable pageable, Long idSeguro, String keyword, String estadoSeguro, String orderBy, String orderMode) {
        Slice<Seguro> seguros = seguroRepository.findAllSegurosPag(pageable, idSeguro, keyword, estadoSeguro, orderBy, orderMode);
        return seguros.map(seguro -> seguroDAO.seguroDTO(seguro));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearSeguro(SeguroDTO seguroDTO) {
        Long maxIdSeguro = null;
        Seguro seguroUnico = seguroRepository.findByIdAseguradoraAndIdTipoSeguro(seguroDTO.getAseguradoraDTO().getIdAseguradora(), seguroDTO.getTipoSeguroDTO().getIdTipoSeguro());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(seguroUnico == null)) {//SI ENCONTRO LA ASEGURADORA Y TIPO SEGURO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO LA ASEGURADORA Y TIPO SEGURO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setSeguroDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO LA ASEGURADORA Y TIPO SEGURO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdSeguro = seguroRepository.findMaxIdSeguro();
           if (maxIdSeguro == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdSeguro = Long.valueOf(0);
           }
           seguroDTO.setIdSeguro(maxIdSeguro + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           seguroRepository.save(seguroDAO.seguro(seguroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSeguroportId(Long idSeguro) {
        Optional<Seguro> seguroId = seguroRepository.findByIdSeguro(Long.valueOf(idSeguro));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (seguroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setSeguroDTO(seguroDAO.seguroDTO(seguroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (seguroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSeguroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE ASEGURADORA Y NOMBRE TIPO DE SEGURO (CAMPOS ÚNICOS COMBINADOS):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarSeguroportNombreAseguradoraAndNombreTipoSeguro(String nombreAseguradora, String nombreTipoSeguro) {
        if (nombreAseguradora == null && nombreTipoSeguro == null) {//SI TODOS LOS PARAMETROS SON NULOS NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setSeguroDTO(null);
           return respuestaDTO;
        }
        Optional<Seguro> seguroUnico = Optional.ofNullable(seguroRepository.findByNombreAseguradoraAndNombreTipoSeguro(nombreAseguradora, nombreTipoSeguro));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (seguroUnico.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NOMBRE ASEGURADORA Y NOMBRE TIPO SEGURO PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setSeguroDTO(seguroDAO.seguroDTO(seguroUnico.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (seguroUnico.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NOMBRE ASEGURADORA Y NOMBRE TIPO SEGURO PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setSeguroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarSeguro(SeguroDTO seguroDTO) {
        Optional<Seguro> seguroId = seguroRepository.findByIdSeguro(seguroDTO.getIdSeguro());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (seguroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DE LOS CAMPOS ÚNICOS DEL REGISTRO CON EL ID PROPORCIONADO.
           Seguro seguroUnico = seguroRepository.findByIdAseguradoraAndIdTipoSeguro(seguroDTO.getAseguradoraDTO().getIdAseguradora(), seguroDTO.getTipoSeguroDTO().getIdTipoSeguro());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(seguroUnico == null) && !(seguroUnico.getIdSeguro().equals(seguroDTO.getIdSeguro()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON LA MISMA ASEGURADORA Y TIPO SEGURO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON LOS MISMOS CAMPOS ÚNICOS ASOCIADOS A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
              respuestaDTO.setSeguroDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON LOS MISMOS CAMPOS ÚNICOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              seguroRepository.save(seguroDAO.seguro(seguroDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (seguroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setSeguroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarSeguro(Long idSeguro) {
        Optional<Seguro> seguroId = seguroRepository.findById(idSeguro);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (seguroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setSeguroDTO(seguroDAO.seguroDTO(seguroId.get()));
           seguroRepository.delete(seguroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (seguroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSeguroDTO(null);
        }
        
        return respuestaDTO;
    }
}
