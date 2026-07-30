//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FotografiaAnexaApoyAtencPrevEmergDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.FotografiaAnexaApoyAtencPrevEmergDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.FotografiaAnexaApoyAtencPrevEmergDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaApoyAtencPrevEmergDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.FotografiaAnexaApoyAtencPrevEmergDesastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 31/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class FotografiaAnexaApoyAtencPrevEmergDesastServiceImpl implements FotografiaAnexaApoyAtencPrevEmergDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private FotografiaAnexaApoyAtencPrevEmergDesastDAO fotografiaAnexaApoyAtencPrevEmergDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private FotografiaAnexaApoyAtencPrevEmergDesastRepository fotografiaAnexaApoyAtencPrevEmergDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idFotografiasAnexasApoyAtencPrevEmergDesast, Long idApoyoAtencPrevEmergDesast) {
        return fotografiaAnexaApoyAtencPrevEmergDesastRepository.findTotalRegistros(idFotografiasAnexasApoyAtencPrevEmergDesast, idApoyoAtencPrevEmergDesast);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<FotografiaAnexaApoyAtencPrevEmergDesastDTO> listarFotografiasAnexasApoyosAtencPrevEmergDesast(Long idFotografiasAnexasApoyAtencPrevEmergDesast, Long idApoyoAtencPrevEmergDesast, String orderBy, String orderMode) {
        List<FotografiaAnexaApoyAtencPrevEmergDesast> fotografiasAnexasApoyosAtencPrevEmergDesast = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findAllFotografiasAnexasApoyosAtencPrevEmergDesast(idFotografiasAnexasApoyAtencPrevEmergDesast, idApoyoAtencPrevEmergDesast, orderBy, orderMode);
        List<FotografiaAnexaApoyAtencPrevEmergDesastDTO> fotografiaAnexaApoyAtencPrevEmergDesastDTOS = new ArrayList<>();
        for (FotografiaAnexaApoyAtencPrevEmergDesast fotografiaAnexaApoyAtencPrevEmergDesast : fotografiasAnexasApoyosAtencPrevEmergDesast) {
            fotografiaAnexaApoyAtencPrevEmergDesastDTOS.add(fotografiaAnexaApoyAtencPrevEmergDesastDAO.fotografiaAnexaApoyAtencPrevEmergDesastDTO(fotografiaAnexaApoyAtencPrevEmergDesast));
        }
        
        return fotografiaAnexaApoyAtencPrevEmergDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<FotografiaAnexaApoyAtencPrevEmergDesastDTO> listarFotografiasAnexasApoyosAtencPrevEmergDesastPag(Pageable pageable, Long idFotografiasAnexasApoyAtencPrevEmergDesast, Long idApoyoAtencPrevEmergDesast, String orderBy, String orderMode) {
        Slice<FotografiaAnexaApoyAtencPrevEmergDesast> fotografiasAnexasApoyosAtencPrevEmergDesast = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findAllFotografiasAnexasApoyosAtencPrevEmergDesastPag(pageable, idFotografiasAnexasApoyAtencPrevEmergDesast, idApoyoAtencPrevEmergDesast, orderBy, orderMode);
        return fotografiasAnexasApoyosAtencPrevEmergDesast.map(fotografiaAnexaApoyAtencPrevEmergDesast -> fotografiaAnexaApoyAtencPrevEmergDesastDAO.fotografiaAnexaApoyAtencPrevEmergDesastDTO(fotografiaAnexaApoyAtencPrevEmergDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearFotografiaAnexaApoyAtencPrevEmergDesast(FotografiaAnexaApoyAtencPrevEmergDesastDTO fotografiaAnexaApoyAtencPrevEmergDesastDTO) {
        Long maxIdFotografiasAnexasApoyAtencPrevEmergDesast = null;
        FotografiaAnexaApoyAtencPrevEmergDesast fotografiaAnexaExistenteEnApoyoAtencPrevEmergDesast = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findByApoyoAtencPrevEmergDesastId(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(fotografiaAnexaExistenteEnApoyoAtencPrevEmergDesast == null)) {//SI YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO ATENC PREV EMERG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO ATENC PREV EMERG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_FOTOGRAFIA_ANEXA_YA_EXISTE_EN_APOYO_ATENC_PREV_EMERG_DESAST, false);
           respuestaDTO.setFotografiaAnexaApoyAtencPrevEmergDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO ATENC PREV EMERG DESAST SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdFotografiasAnexasApoyAtencPrevEmergDesast = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findMaxIdFotografiasAnexasApoyAtencPrevEmergDesast();
           if (maxIdFotografiasAnexasApoyAtencPrevEmergDesast == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdFotografiasAnexasApoyAtencPrevEmergDesast = Long.valueOf(0);
           }
           fotografiaAnexaApoyAtencPrevEmergDesastDTO.setIdFotografiasAnexasApoyAtencPrevEmergDesast(maxIdFotografiasAnexasApoyAtencPrevEmergDesast + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           fotografiaAnexaApoyAtencPrevEmergDesastRepository.save(fotografiaAnexaApoyAtencPrevEmergDesastDAO.fotografiaAnexaApoyAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarFotografiaAnexaApoyAtencPrevEmergDesastporId(Long idFotografiasAnexasApoyAtencPrevEmergDesast) {
        Optional<FotografiaAnexaApoyAtencPrevEmergDesast> fotografiaAnexaApoyAtencPrevEmergDesastId = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findByIdFotografiasAnexasApoyAtencPrevEmergDesast(Long.valueOf(idFotografiasAnexasApoyAtencPrevEmergDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (fotografiaAnexaApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setFotografiaAnexaApoyAtencPrevEmergDesastDTO(fotografiaAnexaApoyAtencPrevEmergDesastDAO.fotografiaAnexaApoyAtencPrevEmergDesastDTO(fotografiaAnexaApoyAtencPrevEmergDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (fotografiaAnexaApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFotografiaAnexaApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarFotografiaAnexaApoyAtencPrevEmergDesast(FotografiaAnexaApoyAtencPrevEmergDesastDTO fotografiaAnexaApoyAtencPrevEmergDesastDTO) {
        Optional<FotografiaAnexaApoyAtencPrevEmergDesast> fotografiaAnexaApoyAtencPrevEmergDesastId = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findByIdFotografiasAnexasApoyAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getIdFotografiasAnexasApoyAtencPrevEmergDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);

        if (fotografiaAnexaApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (fotografiaAnexaApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast().equals(fotografiaAnexaApoyAtencPrevEmergDesastId.get().getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast())==true) ) {//SI EL ID DE APOYO ATENC PREV EMERG DESAST DIGITADO ES IGUAL AL ID DE APOYO ATENC PREV EMERG DESAST ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              FotografiaAnexaApoyAtencPrevEmergDesast fotografiaAnexaApoyAtencPrevEmergDesast = fotografiaAnexaApoyAtencPrevEmergDesastDAO.fotografiaAnexaApoyAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesastDTO);
              fotografiaAnexaApoyAtencPrevEmergDesastRepository.save(fotografiaAnexaApoyAtencPrevEmergDesast);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (fotografiaAnexaApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast().equals(fotografiaAnexaApoyAtencPrevEmergDesastId.get().getApoyoAtencPrevEmergDesast().getIdApoyoAtencPrevEmergDesast())==false) {//SI EL ID DE APOYO ATENC PREV EMERG DESAST DIGITADO ES DIFERENTE AL ID DE APOYO ATENC PREV EMERG DESAST ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE ID DE APOYO ATENC PREV EMERG DESAST DIGITADO EXISTE EN OTROS REGISTROS.
              FotografiaAnexaApoyAtencPrevEmergDesast fotografiaAnexaExistenteEnApoyoAtencPrevEmergDesast = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findByApoyoAtencPrevEmergDesastId(fotografiaAnexaApoyAtencPrevEmergDesastDTO.getApoyoAtencPrevEmergDesastDTO().getIdApoyoAtencPrevEmergDesast());

              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaRegistroEncontrado = 0;

              if (!(fotografiaAnexaExistenteEnApoyoAtencPrevEmergDesast == null)) {//SI ENCONTRO UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO ATENC PREV EMERG DESAST EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE RESTRICCIÓN.
                 banderaRegistroEncontrado=1;
              }

              if (banderaRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL APOYO ATENC PREV EMERG DESAST DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO ATENC PREV EMERG DESAST EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE RESTRICCIÓN.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_FOTOGRAFIA_ANEXA_NO_MODIFICAR_EN_APOYO_ATENC_PREV_EMERG_DESAST, false);
                 respuestaDTO.setFotografiaAnexaApoyAtencPrevEmergDesastDTO(null);
              }
              if (banderaRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL APOYO ATENC PREV EMERG DESAST DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 fotografiaAnexaApoyAtencPrevEmergDesastRepository.save(fotografiaAnexaApoyAtencPrevEmergDesastDAO.fotografiaAnexaApoyAtencPrevEmergDesast(fotografiaAnexaApoyAtencPrevEmergDesastDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (fotografiaAnexaApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setFotografiaAnexaApoyAtencPrevEmergDesastDTO(null);
        }

        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarFotografiaAnexaApoyAtencPrevEmergDesast(Long idFotografiasAnexasApoyAtencPrevEmergDesast) {
        Optional<FotografiaAnexaApoyAtencPrevEmergDesast> fotografiaAnexaApoyAtencPrevEmergDesastId = fotografiaAnexaApoyAtencPrevEmergDesastRepository.findById(idFotografiasAnexasApoyAtencPrevEmergDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (fotografiaAnexaApoyAtencPrevEmergDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setFotografiaAnexaApoyAtencPrevEmergDesastDTO(fotografiaAnexaApoyAtencPrevEmergDesastDAO.fotografiaAnexaApoyAtencPrevEmergDesastDTO(fotografiaAnexaApoyAtencPrevEmergDesastId.get()));
           fotografiaAnexaApoyAtencPrevEmergDesastRepository.delete(fotografiaAnexaApoyAtencPrevEmergDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (fotografiaAnexaApoyAtencPrevEmergDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFotografiaAnexaApoyAtencPrevEmergDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
