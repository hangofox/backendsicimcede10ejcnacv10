//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.FotografiaAnexaApoyObrRedMitigGestRiesgDesastService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.FotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FotografiaAnexaApoyObrRedMitigGestRiesgDesast;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.FotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository;
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
public class FotografiaAnexaApoyObrRedMitigGestRiesgDesastServiceImpl implements FotografiaAnexaApoyObrRedMitigGestRiesgDesastService {
    
    @Autowired//INYECTAMOS EL DAO.
    private FotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private FotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast) {
        return fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findTotalRegistros(idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, idApoyoObrRedMitigGestRiesgDesast);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO> listarFotografiasAnexasApoyosObrRedMitigGestRiesgDesast(Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String orderBy, String orderMode) {
        List<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> fotografiasAnexasApoyosObrRedMitigGestRiesgDesast = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findAllFotografiasAnexasApoyosObrRedMitigGestRiesgDesast(idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, idApoyoObrRedMitigGestRiesgDesast, orderBy, orderMode);
        List<FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO> fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTOS = new ArrayList<>();
        for (FotografiaAnexaApoyObrRedMitigGestRiesgDesast fotografiaAnexaApoyObrRedMitigGestRiesgDesast : fotografiasAnexasApoyosObrRedMitigGestRiesgDesast) {
            fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTOS.add(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO.fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(fotografiaAnexaApoyObrRedMitigGestRiesgDesast));
        }
        
        return fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO> listarFotografiasAnexasApoyosObrRedMitigGestRiesgDesastPag(Pageable pageable, Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, Long idApoyoObrRedMitigGestRiesgDesast, String orderBy, String orderMode) {
        Slice<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> fotografiasAnexasApoyosObrRedMitigGestRiesgDesast = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findAllFotografiasAnexasApoyosObrRedMitigGestRiesgDesastPag(pageable, idFotografiasAnexasApoyObrRedMitigGestRiesgDesast, idApoyoObrRedMitigGestRiesgDesast, orderBy, orderMode);
        return fotografiasAnexasApoyosObrRedMitigGestRiesgDesast.map(fotografiaAnexaApoyObrRedMitigGestRiesgDesast -> fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO.fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(fotografiaAnexaApoyObrRedMitigGestRiesgDesast));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearFotografiaAnexaApoyObrRedMitigGestRiesgDesast(FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO) {
        Long maxIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast = null;
        FotografiaAnexaApoyObrRedMitigGestRiesgDesast fotografiaAnexaExistenteEnApoyoObrRedMitigGestRiesgDesast = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findByApoyoObrRedMitigGestRiesgDesastId(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(fotografiaAnexaExistenteEnApoyoObrRedMitigGestRiesgDesast == null)) {//SI YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST SE MUESTRA UN MENSAJE DE RESTRICCIÓN.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_FOTOGRAFIA_ANEXA_YA_EXISTE_EN_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST, false);
           respuestaDTO.setFotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST SE CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findMaxIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast();
           if (maxIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast = Long.valueOf(0);
           }
           fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.setIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast(maxIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.save(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO.fotografiaAnexaApoyObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarFotografiaAnexaApoyObrRedMitigGestRiesgDesastporId(Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast) {
        Optional<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> fotografiaAnexaApoyObrRedMitigGestRiesgDesastId = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findByIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast(Long.valueOf(idFotografiasAnexasApoyObrRedMitigGestRiesgDesast));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setFotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO.fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarFotografiaAnexaApoyObrRedMitigGestRiesgDesast(FotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO) {
        Optional<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> fotografiaAnexaApoyObrRedMitigGestRiesgDesastId = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findByIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getIdFotografiasAnexasApoyObrRedMitigGestRiesgDesast());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);

        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL CAMPO ÚNICO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast().equals(fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.get().getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast())==true) ) {//SI EL ID DE APOYO OBR RED MITIG GEST RIESG DESAST DIGITADO ES IGUAL AL ID DE APOYO OBR RED MITIG GEST RIESG DESAST ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              FotografiaAnexaApoyObrRedMitigGestRiesgDesast fotografiaAnexaApoyObrRedMitigGestRiesgDesast = fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO.fotografiaAnexaApoyObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO);
              fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.save(fotografiaAnexaApoyObrRedMitigGestRiesgDesast);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast().equals(fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.get().getApoyoObrRedMitigGestRiesgDesast().getIdApoyoObrRedMitigGestRiesgDesast())==false) {//SI EL ID DE APOYO OBR RED MITIG GEST RIESG DESAST DIGITADO ES DIFERENTE AL ID DE APOYO OBR RED MITIG GEST RIESG DESAST ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE ID DE APOYO OBR RED MITIG GEST RIESG DESAST DIGITADO EXISTE EN OTROS REGISTROS.
              FotografiaAnexaApoyObrRedMitigGestRiesgDesast fotografiaAnexaExistenteEnApoyoObrRedMitigGestRiesgDesast = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findByApoyoObrRedMitigGestRiesgDesastId(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO.getApoyoObrRedMitigGestRiesgDesastDTO().getIdApoyoObrRedMitigGestRiesgDesast());

              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaRegistroEncontrado = 0;

              if (!(fotografiaAnexaExistenteEnApoyoObrRedMitigGestRiesgDesast == null)) {//SI ENCONTRO UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE RESTRICCIÓN.
                 banderaRegistroEncontrado=1;
              }

              if (banderaRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL APOYO OBR RED MITIG GEST RIESG DESAST DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE YA EXISTE UN REGISTRO DE FOTOGRAFIA ANEXA PARA EL MISMO APOYO OBR RED MITIG GEST RIESG DESAST EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE RESTRICCIÓN.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_FOTOGRAFIA_ANEXA_NO_MODIFICAR_EN_APOYO_OBR_RED_MITIG_GEST_RIESG_DESAST, false);
                 respuestaDTO.setFotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(null);
              }
              if (banderaRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL APOYO OBR RED MITIG GEST RIESG DESAST DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.save(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO.fotografiaAnexaApoyObrRedMitigGestRiesgDesast(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setFotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(null);
        }

        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarFotografiaAnexaApoyObrRedMitigGestRiesgDesast(Long idFotografiasAnexasApoyObrRedMitigGestRiesgDesast) {
        Optional<FotografiaAnexaApoyObrRedMitigGestRiesgDesast> fotografiaAnexaApoyObrRedMitigGestRiesgDesastId = fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.findById(idFotografiasAnexasApoyObrRedMitigGestRiesgDesast);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setFotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(fotografiaAnexaApoyObrRedMitigGestRiesgDesastDAO.fotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.get()));
           fotografiaAnexaApoyObrRedMitigGestRiesgDesastRepository.delete(fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (fotografiaAnexaApoyObrRedMitigGestRiesgDesastId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFotografiaAnexaApoyObrRedMitigGestRiesgDesastDTO(null);
        }
        
        return respuestaDTO;
    }
}
