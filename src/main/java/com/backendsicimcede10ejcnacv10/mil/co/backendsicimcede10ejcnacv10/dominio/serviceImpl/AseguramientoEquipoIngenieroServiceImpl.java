//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.AseguramientoEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.AseguramientoEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.AseguramientoEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.AseguramientoEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.AseguramientoEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class AseguramientoEquipoIngenieroServiceImpl implements AseguramientoEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private AseguramientoEquipoIngenieroDAO aseguramientoEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private AseguramientoEquipoIngenieroRepository aseguramientoEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idAseguramientoEquipoIngeniero, String keyword, Long idEquipoIngeniero) {
        return aseguramientoEquipoIngenieroRepository.findTotalRegistros(idAseguramientoEquipoIngeniero, keyword, idEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<AseguramientoEquipoIngenieroDTO> listarAseguramientosEquiposIngenieros(Long idAseguramientoEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode) {
        List<AseguramientoEquipoIngeniero> aseguramientosEquiposIngenieros = aseguramientoEquipoIngenieroRepository.findAllAseguramientosEquiposIngenieros(idAseguramientoEquipoIngeniero, keyword, idEquipoIngeniero, orderBy, orderMode);
        List<AseguramientoEquipoIngenieroDTO> aseguramientoEquipoIngeneroDTOS = new ArrayList<>();
        for (AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero : aseguramientosEquiposIngenieros) {
            aseguramientoEquipoIngeneroDTOS.add(aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngeniero));
        }
        
        return aseguramientoEquipoIngeneroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<AseguramientoEquipoIngenieroDTO> listarAseguramientosEquiposIngenierosPag(Pageable pageable, Long idAseguramientoEquipoIngeniero, String keyword, Long idEquipoIngeniero, String orderBy, String orderMode) {
        Slice<AseguramientoEquipoIngeniero> aseguramientosEquiposIngenieros = aseguramientoEquipoIngenieroRepository.findAllAseguramientosEquiposIngenierosPag(pageable, idAseguramientoEquipoIngeniero, keyword, idEquipoIngeniero, orderBy, orderMode);
        return aseguramientosEquiposIngenieros.map(aseguramientoEquipoIngeniero -> aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearAseguramientoEquipoIngeniero(AseguramientoEquipoIngenieroDTO aseguramientoEquipoIngenieroDTO) {
        Long maxIdAseguramientoEquipoIngeniero = null;
        AseguramientoEquipoIngeniero aseguramientoEquipoIngenieroNumeroSeguro = aseguramientoEquipoIngenieroRepository.findByNumeroSeguroAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getNumeroSeguroAseguramientoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroSeguroRegistroEncontrado = 0;
        
        if (!(aseguramientoEquipoIngenieroNumeroSeguro == null)) {//SI ENCONTRO EL NUMERO DE SEGURO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NUMERO DE SEGURO DE REGISTRO REPETIDO CON EL NUMERO DE SEGURO PROPORCIONADO.
           banderaNumeroSeguroRegistroEncontrado = 1;
        }
        
        if (banderaNumeroSeguroRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO DE SEGURO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NUMERO DE SEGURO DE REGISTRO REPETIDO CON EL NUMERO DE SEGURO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           respuestaDTO.setAseguramientoEquipoIngenieroDTO(null);
        }
        if (banderaNumeroSeguroRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO DE SEGURO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NUMERO DE SEGURO PROPORCIONADO.
           maxIdAseguramientoEquipoIngeniero = aseguramientoEquipoIngenieroRepository.findMaxIdAseguramientoEquipoIngeniero();
           if (maxIdAseguramientoEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdAseguramientoEquipoIngeniero = Long.valueOf(0);
           }
           aseguramientoEquipoIngenieroDTO.setIdAseguramientoEquipoIngeniero(maxIdAseguramientoEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           //OBTENCIÓN AUTOMÁTICA DEL NUMERO DE SEGURO DE REGISTRO DEL ASEGURAMIENTO COMBINANDO LA CADENA "POL-EI" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-", LA CADENA "ASEG", LA CADENA "-" Y LA FECHA Y HORA ACTUAL DEL SISTEMA EN FORMATO DE HORA MILITAR SIN INTERMEDIOS DE GUIONES Y PUNTOS.
           //NOTA: SE USA LA FECHA Y HORA ACTUAL DEL SISTEMA (Y NO LA FECHA DE INICIACIÓN DEL ASEGURAMIENTO) PORQUE ESTA ENTIDAD NO CUENTA CON UN CAMPO DE FECHA DE INGRESO AL SISTEMA, Y LA FECHA DE INICIACIÓN ES EDITABLE EN UNA MODIFICACIÓN, POR LO QUE NO DEBE INTERFERIR CON EL NUMERO DE SEGURO YA GENERADO:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSActualsinIntermedios = objetoFechaHMS.format(new Date());
           aseguramientoEquipoIngenieroDTO.setNumeroSeguroAseguramientoEquipoIngeniero("POL-EI" + "-" + (maxIdAseguramientoEquipoIngeniero + 1) + "-" + "ASEG" + "-" + fechaHMSActualsinIntermedios);
           
           aseguramientoEquipoIngenieroRepository.save(aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarAseguramientoEquipoIngenieroporId(Long idAseguramientoEquipoIngeniero) {
        Optional<AseguramientoEquipoIngeniero> aseguramientoEquipoIngenieroId = aseguramientoEquipoIngenieroRepository.findByIdAseguramientoEquipoIngeniero(Long.valueOf(idAseguramientoEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (aseguramientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setAseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (aseguramientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setAseguramientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarAseguramientoEquipoIngeniero(AseguramientoEquipoIngenieroDTO aseguramientoEquipoIngenieroDTO) {
        Optional<AseguramientoEquipoIngeniero> aseguramientoEquipoIngenieroId = aseguramientoEquipoIngenieroRepository.findByIdAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getIdAseguramientoEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (aseguramientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NUMERO DE SEGURO DEL REGISTRO CON EL ID PROPORCIONADO.
           if (aseguramientoEquipoIngenieroDTO.getNumeroSeguroAseguramientoEquipoIngeniero().equals(aseguramientoEquipoIngenieroId.get().getNumeroSeguroAseguramientoEquipoIngeniero()) == true) {//SI EL NUMERO DE SEGURO DIGITADO ES IGUAL AL NUMERO DE SEGURO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero = aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO);
              aseguramientoEquipoIngenieroRepository.save(aseguramientoEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (aseguramientoEquipoIngenieroDTO.getNumeroSeguroAseguramientoEquipoIngeniero().equals(aseguramientoEquipoIngenieroId.get().getNumeroSeguroAseguramientoEquipoIngeniero()) == false) {//SI EL NUMERO DE SEGURO DIGITADO ES DIFERENTE AL NUMERO DE SEGURO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NUMERO DE SEGURO DIGITADO EXISTE EN OTROS REGISTROS.
              AseguramientoEquipoIngeniero aseguramientoEquipoIngenieroNumeroSeguro = aseguramientoEquipoIngenieroRepository.findByNumeroSeguroAseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO.getNumeroSeguroAseguramientoEquipoIngeniero());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroSeguroRegistroEncontrado = 0;
              
              if (!(aseguramientoEquipoIngenieroNumeroSeguro == null)) {//SI ENCONTRO EL NUMERO DE SEGURO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NUMERO DE SEGURO DE REGISTRO REPETIDO CON EL NUMERO DE SEGURO PROPORCIONADO.
                 banderaNumeroSeguroRegistroEncontrado = 1;
              }
              
              if (banderaNumeroSeguroRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NUMERO DE SEGURO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NUMERO DE SEGURO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NUMERO DE SEGURO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
                 respuestaDTO.setAseguramientoEquipoIngenieroDTO(null);
              }
              if (banderaNumeroSeguroRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NUMERO DE SEGURO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 AseguramientoEquipoIngeniero aseguramientoEquipoIngeniero = aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngeniero(aseguramientoEquipoIngenieroDTO);
                 aseguramientoEquipoIngenieroRepository.save(aseguramientoEquipoIngeniero);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (aseguramientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setAseguramientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarAseguramientoEquipoIngeniero(Long idAseguramientoEquipoIngeniero) {
        Optional<AseguramientoEquipoIngeniero> aseguramientoEquipoIngenieroId = aseguramientoEquipoIngenieroRepository.findById(idAseguramientoEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (aseguramientoEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setAseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngenieroDAO.aseguramientoEquipoIngenieroDTO(aseguramientoEquipoIngenieroId.get()));
           aseguramientoEquipoIngenieroRepository.delete(aseguramientoEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (aseguramientoEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setAseguramientoEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
