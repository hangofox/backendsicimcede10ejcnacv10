//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.ContribucionSaneamientoBasicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.ContribucionSaneamientoBasicoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.ContribucionSaneamientoBasicoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.ContribucionSaneamientoBasico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.ContribucionSaneamientoBasicoRepository;
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
public class ContribucionSaneamientoBasicoServiceImpl implements ContribucionSaneamientoBasicoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private ContribucionSaneamientoBasicoDAO contribucionSaneamientoBasicoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private ContribucionSaneamientoBasicoRepository contribucionSaneamientoBasicoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idContribucionSaneamientoBasico, String keyword, Long idInfraestructura) {
        return contribucionSaneamientoBasicoRepository.findTotalRegistros(idContribucionSaneamientoBasico, keyword, idInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<ContribucionSaneamientoBasicoDTO> listarContribucionesSaneamientosBasicos(Long idContribucionSaneamientoBasico, String keyword, Long idInfraestructura, String orderBy, String orderMode) {
        List<ContribucionSaneamientoBasico> contribucionesSaneamientosBasicos = contribucionSaneamientoBasicoRepository.findAllContribucionesSaneamientosBasicos(idContribucionSaneamientoBasico, keyword, idInfraestructura, orderBy, orderMode);
        List<ContribucionSaneamientoBasicoDTO> contribucionSaneamientoBasicoDTOS = new ArrayList<>();
        for (ContribucionSaneamientoBasico contribucionSaneamientoBasico : contribucionesSaneamientosBasicos) {
            contribucionSaneamientoBasicoDTOS.add(contribucionSaneamientoBasicoDAO.contribucionSaneamientoBasicoDTO(contribucionSaneamientoBasico));
        }
        
        return contribucionSaneamientoBasicoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<ContribucionSaneamientoBasicoDTO> listarContribucionesSaneamientosBasicosPag(Pageable pageable, Long idContribucionSaneamientoBasico, String keyword, Long idInfraestructura, String orderBy, String orderMode) {
        Slice<ContribucionSaneamientoBasico> contribucionesSaneamientosBasicos = contribucionSaneamientoBasicoRepository.findAllContribucionesSaneamientosBasicosPag(pageable, idContribucionSaneamientoBasico, keyword, idInfraestructura, orderBy, orderMode);
        return contribucionesSaneamientosBasicos.map(contribucionSaneamientoBasico -> contribucionSaneamientoBasicoDAO.contribucionSaneamientoBasicoDTO(contribucionSaneamientoBasico));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearContribucionSaneamientoBasico(ContribucionSaneamientoBasicoDTO contribucionSaneamientoBasicoDTO) {
        Long maxId = contribucionSaneamientoBasicoRepository.findMaxIdContribucionSaneamientoBasico();
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        if (maxId == null) {
           maxId = Long.valueOf(0);
        }
        contribucionSaneamientoBasicoDTO.setIdContribucionSaneamientoBasico(maxId + 1);
        contribucionSaneamientoBasicoRepository.save(contribucionSaneamientoBasicoDAO.contribucionSaneamientoBasico(contribucionSaneamientoBasicoDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarContribucionSaneamientoBasicoporId(Long idContribucionSaneamientoBasico) {
        Optional<ContribucionSaneamientoBasico> contribucionSaneamientoBasicoId = contribucionSaneamientoBasicoRepository.findByIdContribucionSaneamientoBasico(Long.valueOf(idContribucionSaneamientoBasico));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (contribucionSaneamientoBasicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setContribucionSaneamientoBasicoDTO(contribucionSaneamientoBasicoDAO.contribucionSaneamientoBasicoDTO(contribucionSaneamientoBasicoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (contribucionSaneamientoBasicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setContribucionSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarContribucionSaneamientoBasico(ContribucionSaneamientoBasicoDTO contribucionSaneamientoBasicoDTO) {
        Optional<ContribucionSaneamientoBasico> contribucionSaneamientoBasicoId = contribucionSaneamientoBasicoRepository.findByIdContribucionSaneamientoBasico(contribucionSaneamientoBasicoDTO.getIdContribucionSaneamientoBasico());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (contribucionSaneamientoBasicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           contribucionSaneamientoBasicoRepository.save(contribucionSaneamientoBasicoDAO.contribucionSaneamientoBasico(contribucionSaneamientoBasicoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (contribucionSaneamientoBasicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setContribucionSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarContribucionSaneamientoBasico(Long idContribucionSaneamientoBasico) {
        Optional<ContribucionSaneamientoBasico> contribucionSaneamientoBasicoId = contribucionSaneamientoBasicoRepository.findById(idContribucionSaneamientoBasico);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (contribucionSaneamientoBasicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           contribucionSaneamientoBasicoRepository.delete(contribucionSaneamientoBasicoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (contribucionSaneamientoBasicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setContribucionSaneamientoBasicoDTO(null);
        }
        
        return respuestaDTO;
    }
}
