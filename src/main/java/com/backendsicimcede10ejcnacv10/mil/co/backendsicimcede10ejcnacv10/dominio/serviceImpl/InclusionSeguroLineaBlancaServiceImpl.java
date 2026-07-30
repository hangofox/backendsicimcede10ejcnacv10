//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InclusionSeguroLineaBlancaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.InclusionSeguroLineaBlancaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.InclusionSeguroLineaBlancaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.InclusionSeguroLineaBlanca;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InclusionSeguroLineaBlancaRepository;
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
public class InclusionSeguroLineaBlancaServiceImpl implements InclusionSeguroLineaBlancaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private InclusionSeguroLineaBlancaDAO inclusionSeguroLineaBlancaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InclusionSeguroLineaBlancaRepository inclusionSeguroLineaBlancaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idInclusionSeguroLineaBlanca, String keyword, Long idAseguramientoLineaBlanca) {
        return inclusionSeguroLineaBlancaRepository.findTotalRegistros(idInclusionSeguroLineaBlanca, keyword, idAseguramientoLineaBlanca);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<InclusionSeguroLineaBlancaDTO> listarInclusionesSeguroLineaBlanca(Long idInclusionSeguroLineaBlanca, String keyword, Long idAseguramientoLineaBlanca, String orderBy, String orderMode) {
        List<InclusionSeguroLineaBlanca> inclusionesSeguroLineaBlanca = inclusionSeguroLineaBlancaRepository.findAllInclusionesSeguroLineaBlanca(idInclusionSeguroLineaBlanca, keyword, idAseguramientoLineaBlanca, orderBy, orderMode);
        List<InclusionSeguroLineaBlancaDTO> inclusionSeguroLineaBlancaDTOS = new ArrayList<>();
        for (InclusionSeguroLineaBlanca inclusionSeguroLineaBlanca : inclusionesSeguroLineaBlanca) {
            inclusionSeguroLineaBlancaDTOS.add(inclusionSeguroLineaBlancaDAO.inclusionSeguroLineaBlancaDTO(inclusionSeguroLineaBlanca));
        }
        
        return inclusionSeguroLineaBlancaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<InclusionSeguroLineaBlancaDTO> listarInclusionesSeguroLineaBlancaPag(Pageable pageable, Long idInclusionSeguroLineaBlanca, String keyword, Long idAseguramientoLineaBlanca, String orderBy, String orderMode) {
        Slice<InclusionSeguroLineaBlanca> inclusionesSeguroLineaBlanca = inclusionSeguroLineaBlancaRepository.findAllInclusionesSeguroLineaBlancaPag(pageable, idInclusionSeguroLineaBlanca, keyword, idAseguramientoLineaBlanca, orderBy, orderMode);
        return inclusionesSeguroLineaBlanca.map(inclusionSeguroLineaBlanca -> inclusionSeguroLineaBlancaDAO.inclusionSeguroLineaBlancaDTO(inclusionSeguroLineaBlanca));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearInclusionSeguroLineaBlanca(InclusionSeguroLineaBlancaDTO inclusionSeguroLineaBlancaDTO) {
        Long maxIdInclusionSeguroLineaBlanca = inclusionSeguroLineaBlancaRepository.findMaxIdInclusionSeguroLineaBlanca();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        if (maxIdInclusionSeguroLineaBlanca == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
           maxIdInclusionSeguroLineaBlanca = Long.valueOf(0);
        }
        inclusionSeguroLineaBlancaDTO.setIdInclusionSeguroLineaBlanca(maxIdInclusionSeguroLineaBlanca + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        
        inclusionSeguroLineaBlancaRepository.save(inclusionSeguroLineaBlancaDAO.inclusionSeguroLineaBlanca(inclusionSeguroLineaBlancaDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarInclusionSeguroLineaBlancaporId(Long idInclusionSeguroLineaBlanca) {
        Optional<InclusionSeguroLineaBlanca> inclusionSeguroLineaBlancaId = inclusionSeguroLineaBlancaRepository.findByIdInclusionSeguroLineaBlanca(Long.valueOf(idInclusionSeguroLineaBlanca));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (inclusionSeguroLineaBlancaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setInclusionSeguroLineaBlancaDTO(inclusionSeguroLineaBlancaDAO.inclusionSeguroLineaBlancaDTO(inclusionSeguroLineaBlancaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (inclusionSeguroLineaBlancaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInclusionSeguroLineaBlancaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarInclusionSeguroLineaBlanca(InclusionSeguroLineaBlancaDTO inclusionSeguroLineaBlancaDTO) {
        Optional<InclusionSeguroLineaBlanca> inclusionSeguroLineaBlancaId = inclusionSeguroLineaBlancaRepository.findByIdInclusionSeguroLineaBlanca(inclusionSeguroLineaBlancaDTO.getIdInclusionSeguroLineaBlanca());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (inclusionSeguroLineaBlancaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           inclusionSeguroLineaBlancaRepository.save(inclusionSeguroLineaBlancaDAO.inclusionSeguroLineaBlanca(inclusionSeguroLineaBlancaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (inclusionSeguroLineaBlancaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setInclusionSeguroLineaBlancaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarInclusionSeguroLineaBlanca(Long idInclusionSeguroLineaBlanca) {
        Optional<InclusionSeguroLineaBlanca> inclusionSeguroLineaBlancaId = inclusionSeguroLineaBlancaRepository.findById(idInclusionSeguroLineaBlanca);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (inclusionSeguroLineaBlancaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setInclusionSeguroLineaBlancaDTO(inclusionSeguroLineaBlancaDAO.inclusionSeguroLineaBlancaDTO(inclusionSeguroLineaBlancaId.get()));
           inclusionSeguroLineaBlancaRepository.delete(inclusionSeguroLineaBlancaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (inclusionSeguroLineaBlancaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInclusionSeguroLineaBlancaDTO(null);
        }
        
        return respuestaDTO;
    }
}
