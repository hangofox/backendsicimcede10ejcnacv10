//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ParametrosSistemaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ParametrosSistemaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ParametrosSistemaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ParametrosSistema;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ParametrosSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 30/07/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class ParametrosSistemaServiceImpl implements ParametrosSistemaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ParametrosSistemaDAO parametrosSistemaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ParametrosSistemaRepository parametrosSistemaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idParametrosSistema) {
        return parametrosSistemaRepository.findTotalRegistros(idParametrosSistema);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ParametrosSistemaDTO> listarParametrosSistema(Long idParametrosSistema, String orderBy, String orderMode) {
        List<ParametrosSistema> parametrosSistemas = parametrosSistemaRepository.findAllParametrosSistema(idParametrosSistema, orderBy, orderMode);
        List<ParametrosSistemaDTO> parametrosSistemaDTOS = new ArrayList<>();
        for (ParametrosSistema parametrosSistema : parametrosSistemas) {
            parametrosSistemaDTOS.add(parametrosSistemaDAO.parametrosSistemaDTO(parametrosSistema));
        }
        
        return parametrosSistemaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ParametrosSistemaDTO> listarParametrosSistemaPag(Pageable pageable, Long idParametrosSistema, String orderBy, String orderMode) {
        Slice<ParametrosSistema> parametrosSistemas = parametrosSistemaRepository.findAllParametrosSistemaPag(pageable, idParametrosSistema, orderBy, orderMode);
        return parametrosSistemas.map(parametrosSistema -> parametrosSistemaDAO.parametrosSistemaDTO(parametrosSistema));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearParametrosSistema(ParametrosSistemaDTO parametrosSistemaDTO) {
        Long maxIdParametrosSistema = parametrosSistemaRepository.findMaxIdParametrosSistema();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdParametrosSistema == null) {
           maxIdParametrosSistema = Long.valueOf(0);
        }
        parametrosSistemaDTO.setIdParametrosSistema(maxIdParametrosSistema + 1);
        parametrosSistemaRepository.save(parametrosSistemaDAO.parametrosSistema(parametrosSistemaDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarParametrosSistemaporId(Long idParametrosSistema) {
        Optional<ParametrosSistema> parametrosSistemaId = parametrosSistemaRepository.findByIdParametrosSistema(Long.valueOf(idParametrosSistema));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (parametrosSistemaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setParametrosSistemaDTO(parametrosSistemaDAO.parametrosSistemaDTO(parametrosSistemaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (parametrosSistemaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setParametrosSistemaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarParametrosSistema(ParametrosSistemaDTO parametrosSistemaDTO) {
        Optional<ParametrosSistema> parametrosSistemaId = parametrosSistemaRepository.findByIdParametrosSistema(parametrosSistemaDTO.getIdParametrosSistema());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (parametrosSistemaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           parametrosSistemaRepository.save(parametrosSistemaDAO.parametrosSistema(parametrosSistemaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (parametrosSistemaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setParametrosSistemaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarParametrosSistema(Long idParametrosSistema) {
        Optional<ParametrosSistema> parametrosSistemaId = parametrosSistemaRepository.findById(idParametrosSistema);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (parametrosSistemaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           parametrosSistemaRepository.delete(parametrosSistemaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (parametrosSistemaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setParametrosSistemaDTO(null);
        }
        
        return respuestaDTO;
    }
}
