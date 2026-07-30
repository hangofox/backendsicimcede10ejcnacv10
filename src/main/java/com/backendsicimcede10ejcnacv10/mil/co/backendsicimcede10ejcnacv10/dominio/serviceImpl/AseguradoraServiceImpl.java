//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.AseguradoraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.AseguradoraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.AseguradoraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Aseguradora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.AseguradoraRepository;
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
public class AseguradoraServiceImpl implements AseguradoraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private AseguradoraDAO aseguradoraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private AseguradoraRepository aseguradoraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idAseguradora, String keyword, String nombreTipoDocumentoIdentificacion, String nombreAseguradora) {
        return aseguradoraRepository.findTotalRegistros(idAseguradora, keyword, nombreTipoDocumentoIdentificacion, nombreAseguradora);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<AseguradoraDTO> listarAseguradoras(Long idAseguradora, String keyword, String nombreTipoDocumentoIdentificacion, String nombreAseguradora, String orderBy, String orderMode) {
        List<Aseguradora> aseguradoras = aseguradoraRepository.findAllAseguradoras(idAseguradora, keyword, nombreTipoDocumentoIdentificacion, nombreAseguradora, orderBy, orderMode);
        List<AseguradoraDTO> aseguradoraDTOS = new ArrayList<>();
        for (Aseguradora aseguradora : aseguradoras) {
            aseguradoraDTOS.add(aseguradoraDAO.aseguradoraDTO(aseguradora));
        }
        
        return aseguradoraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<AseguradoraDTO> listarAseguradorasPag(Pageable pageable, Long idAseguradora, String keyword, String nombreTipoDocumentoIdentificacion, String nombreAseguradora, String orderBy, String orderMode) {
        Slice<Aseguradora> aseguradoras = aseguradoraRepository.findAllAseguradorasPag(pageable, idAseguradora, keyword, nombreTipoDocumentoIdentificacion, nombreAseguradora, orderBy, orderMode);
        return aseguradoras.map(aseguradora -> aseguradoraDAO.aseguradoraDTO(aseguradora));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearAseguradora(AseguradoraDTO aseguradoraDTO) {
        Long maxIdAseguradora = null;
        Aseguradora aseguradoraNumeroDocumentoIdentificacion = aseguradoraRepository.findByNumeroDocumentoIdentificacionAseguradora(aseguradoraDTO.getNumeroDocumentoIdentificacionAseguradora());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
        
        if (!(aseguradoraNumeroDocumentoIdentificacion == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           banderaNumeroDocumentoIdentificacionRegistroEncontrado = 1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 1) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
           respuestaDTO.setAseguradoraDTO(null);
        }
        if ((banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0)) {//SI NO ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
           maxIdAseguradora = aseguradoraRepository.findMaxIdAseguradora();
           if (maxIdAseguradora == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdAseguradora = Long.valueOf(0);
           }
           aseguradoraDTO.setIdAseguradora(maxIdAseguradora + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           aseguradoraRepository.save(aseguradoraDAO.aseguradora(aseguradoraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarAseguradoraporId(Long idAseguradora) {
        Optional<Aseguradora> aseguradoraId = aseguradoraRepository.findByIdAseguradora(Long.valueOf(idAseguradora));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (aseguradoraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setAseguradoraDTO(aseguradoraDAO.aseguradoraDTO(aseguradoraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (aseguradoraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setAseguradoraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y NOMBRE DEL TIPO DE DOCUMENTO DE IDENTIFICACION:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarAseguradoraporNumeroDocumentoIdentificacion(String numeroDocumentoIdentificacionAseguradora) {
        Optional<Aseguradora> aseguradoraNombreyNombreTipoDocumentoIdentificacion = Optional.ofNullable(aseguradoraRepository.findByNumeroDocumentoIdentificacionAseguradora(numeroDocumentoIdentificacionAseguradora));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (aseguradoraNombreyNombreTipoDocumentoIdentificacion.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE Y NOMBRE PROPORCIONADO.
           respuestaDTO.setAseguradoraDTO(aseguradoraDAO.aseguradoraDTO(aseguradoraNombreyNombreTipoDocumentoIdentificacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (aseguradoraNombreyNombreTipoDocumentoIdentificacion.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE Y NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setAseguradoraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarAseguradora(AseguradoraDTO aseguradoraDTO) {
        Optional<Aseguradora> aseguradoraId = aseguradoraRepository.findByIdAseguradora(aseguradoraDTO.getIdAseguradora());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (aseguradoraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO CON EL ID PROPORCIONADO.
           if ((aseguradoraDTO.getNumeroDocumentoIdentificacionAseguradora().equals(aseguradoraId.get().getNumeroDocumentoIdentificacionAseguradora()) == true)) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES IGUAL AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              Aseguradora aseguradora = aseguradoraDAO.aseguradora(aseguradoraDTO);
              aseguradoraRepository.save(aseguradora);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (aseguradoraDTO.getNumeroDocumentoIdentificacionAseguradora().equals(aseguradoraId.get().getNumeroDocumentoIdentificacionAseguradora()) == false) {//SI EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO ES DIFERENTE AL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO EXISTE EN OTROS REGISTROS.
              Aseguradora aseguradoraNumeroDocumentoIdentificacion = aseguradoraRepository.findByNumeroDocumentoIdentificacionAseguradora(aseguradoraDTO.getNumeroDocumentoIdentificacionAseguradora());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNumeroDocumentoIdentificacionRegistroEncontrado = 0;
              
              if (!(aseguradoraNumeroDocumentoIdentificacion == null)) {//SI ENCONTRO EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DE REGISTRO REPETIDO CON EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN PROPORCIONADO.
                 banderaNumeroDocumentoIdentificacionRegistroEncontrado = 1;
              }
              
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_DOCUMENTO_IDENTIFICACION_YA_EXISTE, false);
                 respuestaDTO.setAseguradoraDTO(null);
              }
              if (banderaNumeroDocumentoIdentificacionRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NÚMERO DE DOCUMENTO DE IDENTIFICACIÓN DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 Aseguradora aseguradora = aseguradoraDAO.aseguradora(aseguradoraDTO);
                 aseguradoraRepository.save(aseguradora);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (aseguradoraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setAseguradoraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarAseguradora(Long idAseguradora) {
        Optional<Aseguradora> aseguradoraId = aseguradoraRepository.findById(idAseguradora);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (aseguradoraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setAseguradoraDTO(aseguradoraDAO.aseguradoraDTO(aseguradoraId.get()));
           aseguradoraRepository.delete(aseguradoraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (aseguradoraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setAseguradoraDTO(null);
        }
        
        return respuestaDTO;
    }
}
