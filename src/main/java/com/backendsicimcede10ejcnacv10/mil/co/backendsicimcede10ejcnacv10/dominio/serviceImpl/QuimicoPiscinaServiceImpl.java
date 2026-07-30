//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.QuimicoPiscinaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.QuimicoPiscinaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.QuimicoPiscinaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.QuimicoPiscina;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.QuimicoPiscinaRepository;
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
public class QuimicoPiscinaServiceImpl implements QuimicoPiscinaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private QuimicoPiscinaDAO quimicoPiscinaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private QuimicoPiscinaRepository quimicoPiscinaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idQuimicoPiscina, String keyword) {
        return quimicoPiscinaRepository.findTotalRegistros(idQuimicoPiscina, keyword);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<QuimicoPiscinaDTO> listarQuimicosPiscinas(Long idQuimicoPiscina, String keyword, String orderBy, String orderMode) {
        List<QuimicoPiscina> quimicosPiscinas = quimicoPiscinaRepository.findAllQuimicosPiscinas(idQuimicoPiscina, keyword, orderBy, orderMode);
        List<QuimicoPiscinaDTO> quimicoPiscinaDTOS = new ArrayList<>();
        for (QuimicoPiscina quimicoPiscina : quimicosPiscinas) {
            quimicoPiscinaDTOS.add(quimicoPiscinaDAO.quimicoPiscinaDTO(quimicoPiscina));
        }
        
        return quimicoPiscinaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<QuimicoPiscinaDTO> listarQuimicosPiscinasPag(Pageable pageable, Long idQuimicoPiscina, String keyword, String orderBy, String orderMode) {
        Slice<QuimicoPiscina> quimicosPiscinas = quimicoPiscinaRepository.findAllQuimicosPiscinasPag(pageable, idQuimicoPiscina, keyword, orderBy, orderMode);
        return quimicosPiscinas.map(quimicoPiscina -> quimicoPiscinaDAO.quimicoPiscinaDTO(quimicoPiscina));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearQuimicoPiscina(QuimicoPiscinaDTO quimicoPiscinaDTO) {
        Long maxId = null;
        QuimicoPiscina quimicoPiscinaUnico = quimicoPiscinaRepository.findByNombreQuimicoPiscina(quimicoPiscinaDTO.getNombreQuimicoPiscina());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(quimicoPiscinaUnico == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setQuimicoPiscinaDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO.
           maxId = quimicoPiscinaRepository.findMaxIdQuimicoPiscina();
           if (maxId == null) {
              maxId = Long.valueOf(0);
           }
           quimicoPiscinaDTO.setIdQuimicoPiscina(maxId + 1);
           quimicoPiscinaRepository.save(quimicoPiscinaDAO.quimicoPiscina(quimicoPiscinaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarQuimicoPiscinaporId(Long idQuimicoPiscina) {
        Optional<QuimicoPiscina> quimicoPiscinaId = quimicoPiscinaRepository.findByIdQuimicoPiscina(Long.valueOf(idQuimicoPiscina));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (quimicoPiscinaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setQuimicoPiscinaDTO(quimicoPiscinaDAO.quimicoPiscinaDTO(quimicoPiscinaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (quimicoPiscinaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setQuimicoPiscinaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NOMBRE.
    public RespuestaDTO consultarQuimicoPiscinaporNombre(String nombreQuimicoPiscina) {
        QuimicoPiscina quimicoPiscinaNombre = quimicoPiscinaRepository.findByNombreQuimicoPiscina(nombreQuimicoPiscina);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (!(quimicoPiscinaNombre == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO...
           respuestaDTO.setQuimicoPiscinaDTO(quimicoPiscinaDAO.quimicoPiscinaDTO(quimicoPiscinaNombre));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (quimicoPiscinaNombre == null) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setQuimicoPiscinaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarQuimicoPiscina(QuimicoPiscinaDTO quimicoPiscinaDTO) {
        Optional<QuimicoPiscina> quimicoPiscinaId = quimicoPiscinaRepository.findByIdQuimicoPiscina(quimicoPiscinaDTO.getIdQuimicoPiscina());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (quimicoPiscinaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           quimicoPiscinaRepository.save(quimicoPiscinaDAO.quimicoPiscina(quimicoPiscinaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (quimicoPiscinaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setQuimicoPiscinaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarQuimicoPiscina(Long idQuimicoPiscina) {
        Optional<QuimicoPiscina> quimicoPiscinaId = quimicoPiscinaRepository.findById(idQuimicoPiscina);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (quimicoPiscinaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           quimicoPiscinaRepository.delete(quimicoPiscinaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (quimicoPiscinaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setQuimicoPiscinaDTO(null);
        }
        
        return respuestaDTO;
    }
}
